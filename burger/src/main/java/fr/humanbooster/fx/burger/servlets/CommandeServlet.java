package fr.humanbooster.fx.burger.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.burger.business.Accompagnement;
import fr.humanbooster.fx.burger.business.Boisson;
import fr.humanbooster.fx.burger.business.Burger;
import fr.humanbooster.fx.burger.business.Commande;
import fr.humanbooster.fx.burger.business.Sauce;
import fr.humanbooster.fx.burger.services.impl.AccService;
import fr.humanbooster.fx.burger.services.impl.BoissonService;
import fr.humanbooster.fx.burger.services.impl.BurgerService;
import fr.humanbooster.fx.burger.services.impl.SauceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/commande"}, loadOnStartup = 1)
public class CommandeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Commande> commandes = new ArrayList<>();
	
	  @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	Commande commande = new Commande();
	    	float prix = 0.0f;
	    	System.out.println("sur place? "+req.getParameter("lieu"));
	    	if(req.getParameter("lieu") != null) {
	    		boolean surPlace = Boolean.parseBoolean(req.getParameter("lieu"));
	    		commande.setSurPlace(surPlace);
	    	}
	    	
			Long burgerID = Long.parseLong(req.getParameter("burger"));
			Burger burger = new BurgerService().getItem(burgerID);
			commande.setBurger(burger);
			prix +=burger.getPrix();
			
			Long accID = Long.parseLong(req.getParameter("accompagnement"));
			Accompagnement acc = new AccService().getItem(accID);
			commande.setAccompagnement(acc);
			prix +=acc.getPrix();
			
			Long boissonID = Long.parseLong(req.getParameter("boisson"));
			Boisson boisson = new BoissonService().getItem(boissonID);
			commande.setBoisson(boisson);
			prix +=boisson.getPrix();
			
			List<Sauce> sauces = new ArrayList<>();
			
			
			String[] tabSauces = req.getParameterValues("sauce_id");
			if(tabSauces != null) {
				 sauces = getSauces(tabSauces);
			}
			
			commande.setSauces(sauces);
			
			if(req.getParameter("remarques") != null) {
				String remarques = req.getParameter("remarques");
				commande.setRemarques(remarques);
			}
			
			if(req.getParameter("card") != null) {
				String card = req.getParameter("card");
				commande.setNoCarte(card);
			}
			
			String expiration = "";
			if(req.getParameter("mois") != null) {
				expiration += req.getParameter("mois");
			}
			
			if(req.getParameter("annee") != null) {
				expiration += "/"+req.getParameter("annee");
			}
			commande.setExpiration(expiration);
			
			if(req.getParameter("code") != null) {
				String code = req.getParameter("code");
				commande.setCodeCVV(code);
			}
			prix = (float)Math.round(prix * 100f) / 100f;
			commande.setPrix(prix);
			commandes.add(commande);
			
			System.out.println("commande : "+ commande);
			
			
			req.setAttribute("commande", commande);
			
			req.getRequestDispatcher("WEB-INF/merciCommande.jsp").forward(req, resp);
	    }

		public List<Sauce> getSauces(String[] tabSauces) {
			SauceService saucesServ = new SauceService();
			List<Sauce> sauces = new ArrayList<>();
			for(Sauce sauce : saucesServ.getList()) {
		            for(String sauce2 :tabSauces) {
		            	if(sauce.getId().equals(Long.parseLong(sauce2))) {
			            	sauces.add(sauce);
			            }
		            }
		        }
			return sauces;
		}

}
