package com.example.carmaintainf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCarActivity extends AppCompatActivity {
    EditText marqueEditText, modeleEditText, kilometrageEditText, anneeEditText;
    Button updatebutton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carinformation);

        // Initialisation de la base de données Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("cars");

        // Récupération des références des éléments de l'interface utilisateur
        marqueEditText = findViewById(R.id.marquecar);
        modeleEditText = findViewById(R.id.modele);
        kilometrageEditText = findViewById(R.id.kilometrage);
        anneeEditText = findViewById(R.id.annee);
        updatebutton = findViewById(R.id.buttonupdatecarinfo);

        // Gestionnaire de clic sur le bouton de mise à jour
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCarToFirebase();
            }
        });
    }

    private void addCarToFirebase() {
        // Récupération des valeurs des champs de saisie
        String marque = marqueEditText.getText().toString().trim();
        String modele = modeleEditText.getText().toString().trim();
        String kilometrage = kilometrageEditText.getText().toString().trim();
        String annee = anneeEditText.getText().toString().trim();

        // Vérification si tous les champs sont remplis
        if (!marque.isEmpty() && !modele.isEmpty() && !kilometrage.isEmpty() && !annee.isEmpty()) {
            // Création d'un objet CarInfo avec les données saisies
            CarInfo carInfo = new CarInfo(marque, modele, kilometrage, annee);

            // Génération d'une clé unique pour la voiture
            String carId = databaseReference.push().getKey();

            // Enregistrement de la voiture dans Firebase avec la clé générée
            databaseReference.child(carId).setValue(carInfo);

            // Affichage d'un message de succès
            Toast.makeText(this, "Voiture ajoutée avec succès!", Toast.LENGTH_SHORT).show();
        } else {
            // Affichage d'un message d'erreur si tous les champs ne sont pas remplis
            Toast.makeText(this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
        }
    }
}
