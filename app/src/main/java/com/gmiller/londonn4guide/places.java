package com.gmiller.londonn4guide;

/**
 * Created by dell on 08/03/2017.
 */

public class places {
    private String mName;

    private String mKnownFor;

    private double mDistance;

    private String mUrl;

    /**
     * Constructs a new {@link places} object.
     *
     * @param name is the name of the place
     * @param knownFor is the speciality of the place
     * @param distance is the distance from Finsbury park station
     * @param url is the website address of the place
     */

    public places(String name, String knownFor, double distance, String url) {
        mName = name;
        mKnownFor = knownFor;
        mDistance = distance;
        mUrl = url;
    }

    public String getName;

    public String getKnownFor;

    public double getDistance;

    public String getUrl;
}
