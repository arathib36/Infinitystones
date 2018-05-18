package com.infinitystones.infinitystones;

public class Stones {
    public String mStones[]={
            "Wow!You have got the Power Stone!" ,
            "Hurray!You have got the Space stone!",
            "Wow!You have got the Time Stone!",
            "Great!You have got the Reality stone!",
            "Wow!You have got the Soul stone!",
            "Amazing!You have got the Mind stone!"

    };

    public String mItems[]={"Power","Space","Time","Reality","Soul","Mind"};

    public String mcolor[]={"#800080","#00FFFF","#008000","#FF0000","#ffa500","#FFFF00"};


    public String getStones(int a) {
        String Stone=mStones[a];
        return Stone;

    }

    public String getitems(int a) {
        String Items=mItems[a];
        return Items;

    }

    public String getcolor(int a) {
        String color=mcolor[a];
        return color;

    }

}
