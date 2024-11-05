package com.bruk.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @brief Definition is a class to hold definition of a single word.
 */
public class Definition implements Parcelable {
    public String englishWord;
    public String englishDefinition;
    public String amharicWord;

    public Definition(String englishWord, String englishDefinition, String amharicWord) {
        this.englishWord = englishWord;
        this.englishDefinition = englishDefinition;
        this.amharicWord = amharicWord;
    }

    public Definition() {
    }

    protected Definition(Parcel in) {
        englishWord = in.readString();
        englishDefinition = in.readString();
        amharicWord = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(englishWord);
        dest.writeString(englishDefinition);
        dest.writeString(amharicWord);
    }

    @Override
    public int describeContents()/ {
        return 0;
    }

    public static final Creator<Definition> CREATOR = new Creator<Definition>() {
        @Override
        public Definition createFromParcel(Parcel in) {
            return new Definition(in);
        }

        @Override
        public Definition[] newArray(int size) {
            return new Definition[size];
        }
    };
}
