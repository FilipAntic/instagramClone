package com.example.pc.instagram.database.mongodb;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.pc.instagram.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabaseHelper {


    // Write a message to the database
    FirebaseDatabase database = com.google.firebase.database.FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseDatabaseHelper() {

//        String id = myRef.push().getKey();
//
//        User u = new User();
//        u.setName("AAAA");
//        myRef.child(id).setValue(u);
//        id = myRef.push().getKey();
//        u = new User();
//        u.setName("BBBB");
//        myRef.child(id).setValue(u);
//        // Create a new user with a first and last name
//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "Ada");
//        user.put("last", "Lovelace");
//        user.put("born", 1815);

// Add a new document with a generated ID

//        db.collection("users").whereEqualTo("first", "Ada").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    Log.w("AA", "It Exists");
//                } else {
//                    Map<String, Object> user = new HashMap<>();
//                    user.put("first", "Ada");
//                    user.put("last", "Lovelace");
//                    user.put("born", 1815);
//
//                    db.collection("users").add(user)
//                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                @Override
//                                public void onSuccess(DocumentReference documentReference) {
//                                    Log.d("AA", "DocumentSnapshot added with ID: " + documentReference.getId());
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.w("AA", "Error adding document", e);
//                        }
//                    });
//                }
//            }
//        });
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d("AA", "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("AA", "Error adding document", e);
//                    }
//                });

//        CollectionReference cities = db.collection("users");
//// Create a query against the collection.
//        Query query = cities.whereEqualTo("first", "Ada");
//// retrieve  query results asynchronously using query.get()
//        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (DocumentSnapshot document : task.getResult()) {
//                        Log.d("A", document.getId() + " => " + document.getData());
//                    }
//                } else {
//                    Log.w("A", "Error getting documents.", task.getException());
//                }
//            }
//        });
        Map<String, Object> user = new HashMap<>();
        ArrayList<String>a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");

        user.put("first", a);
        add("posts", user);
    }

    public void add(final String collection, Object obj) {
        final Object finalObject = obj;
        if (collection.equals("users")) {
            db.collection(collection).whereEqualTo("first", "Ada").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        Log.w(collection, "It Exists");
                    } else {
                        db.collection("users").add((User) finalObject)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d("AA", "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("AA", "Error adding document", e);
                            }
                        });
                    }
                }
            });
        } else {
            db.collection(collection).add(finalObject)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("Added in " + collection, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(collection, "Error adding document", e);
                        }
                    });
        }


    }

    public void update(String collection, String id, Object obj) {
        db.collection(collection).document(id).set(obj, SetOptions.merge());
    }

    public void delete(String collection, String id) {
        db.collection(collection).document(id).delete();
    }


}
