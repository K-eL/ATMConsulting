package com.thorschmidt.curso.atmconsulting.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thorschmidt.curso.atmconsulting.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_about, container, false);

        Element versao = new Element();
        versao.setTitle("Version 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription("Our mission is to support organizations that " +
                        "wish to reach success through management excellence and " +
                        "search for quality.")
                // Contact
                .addGroup("Contact us")
                .addEmail("administration@atmconsulting.com", "Send an e-mail")
                .addWebsite("www.google.com","Access our website")
                // Social Media
                .addGroup("Social Media")
                .addFacebook("facebook","Facebook")
                .addInstagram("google","Instagram")
                .addTwitter("google","Twitter")
                .addYoutube("google","Youtube")
                .addPlayStore("com.facebook.com","Download App")
                // Version
                .addItem(versao)
                // Create
                .create();


    }
}
