package com.example.android.miwok;

/**
 * Created by Johnny on 12/2/2017.
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    /**
     * Testing static variable. A NON final variable is to be used whenever a class is created throughout the entire program regardless of which class calls it. For instance, in this program, every
     * time the Word constructor is used. Ex. ONE run through of the 5 word lists will return a total of 38 words. A FINAL variable will NEVER BE MODIFIED and remain the same for every instance
     * a constructor is ran. From what I can tell, you want to return a boolean with hasImage() instead of making the WordAdapter do the logic check because, I assume, it is more efficient.
     */
//    private static int wordCount;

    private static final int NO_IMAGE_PROVIDED = 0;

    /** Method to create a Word object that contains an image icon
     *
     * @param defaultTrans the word of the default language the user is using (ie. English word for English users)
     * @param miwokTrans the Miwok translation of the word
     * @param audioResourceId the drawable resource ID for the corresponding word
     */

    public Word(String defaultTrans, String miwokTrans, int audioResourceId) {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miwokTrans;
        mAudioResourceId = audioResourceId;
//        wordCount++;
    }

    /**
     * alternate way to construct a word obj with an icon
     * @param defaultTrans same as above
     * @param miwokTrans same as above
     * @param imageResourceId image resource id for the icon
     * @param audioResourceId same as above
     */

    public Word(String defaultTrans, String miwokTrans, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miwokTrans;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
//        wordCount++;
    }

    /**
     * Return default translation fot the word
     */

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Return Miwok translation fot the word
     */

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Return default drawable resource ID for the word
     */

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

//    public static int getWordCount() {
//        return wordCount;
//    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
