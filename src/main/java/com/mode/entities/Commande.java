package com.mode.entities;

import java.util.Date;

public class Commande {

	private int id_commande;
	private int id_client;
	private String produit;
	private int nombre;
	private int prix;
	private Date date;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id_commande, int id_client, String produit, int nombre, int prix, Date date) {
		super();
		this.id_commande = id_commande;
		this.id_client = id_client;
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", id_client=" + id_client + ", produit=" + produit
				+ ", nombre=" + nombre + ", prix=" + prix + ", date=" + date + "]";
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
