package com.gmiller.londonn4guide;

/**
 * Created by dell on 08/03/2017.
 */

public class place {
    // Name of place
    private String mName;

    // What the place is famous for
    private String mKnownFor;

    // Number to show distance of the place from Finsbury Park
    private double mDistance;

    // Url for the website of the place
    private String mUrl;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constructs a new {@link place} object.
     *
     * @param name is the name of the place
     * @param knownFor is the speciality of the place
     * @param distance is the distance from Finsbury park station
     * @param url is the website address of the place
     */

    public place(String name, String knownFor, double distance, String url) {
        mName = name;
        mKnownFor = knownFor;
        mDistance = distance;
        mUrl = url;
    }
    /**
     * Constructs a new {@link place} object.
     *
     * @param name is the name of the place
     * @param knownFor is the speciality of the place
     * @param distance is the distance from Finsbury park station
     * @param url is the website address of the place
     */

    public place(String name, String knownFor, double distance, String url, int imageResourceId) {
        mName = name;
        mKnownFor = knownFor;
        mDistance = distance;
        mUrl = url;
        mImageResourceId = imageResourceId;
    }

    public String getName() { return mName; }

    public String getKnownFor() {return mKnownFor; }

    public double getDistance() {return mDistance; }

    public String getUrl() {return mUrl; }

    public int getmImageResourceId() {return mImageResourceId; }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
