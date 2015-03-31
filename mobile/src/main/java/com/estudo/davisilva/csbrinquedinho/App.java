package com.estudo.davisilva.csbrinquedinho;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "MAsSWayKKa3hItoFstMqvz7IzwxH7VSkKRGaMh6b", "ltSBTsi7ciZVcukMMjxb2vt4i4ee3lF2CpKczEgM");
    }
}
