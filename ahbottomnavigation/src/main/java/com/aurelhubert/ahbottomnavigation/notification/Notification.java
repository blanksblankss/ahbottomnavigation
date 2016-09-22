package com.aurelhubert.ahbottomnavigation.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author repitch
 */
public class Notification implements Parcelable {

    @Nullable
    private String text; // can be null, so notification will not be shown

    @ColorInt
    private int textColor; // if 0 then use default value

    @ColorInt
    private int backgroundColor; // if 0 then use default value

    private Notification() {
        // empty
    }

    private Notification(Parcel in) {
        text = in.readString();
        textColor = in.readInt();
        backgroundColor = in.readInt();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(text);
    }

    public String getText() {
        return text;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public static Notification justText(String text) {
        return newBuilder().setText(text).build();
    }

    public static Builder newBuilder() {
        return new Notification().new Builder();
    }

    public static List<Notification> generateEmptyList(int size) {
        List<Notification> notificationList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            notificationList.add(Notification.newBuilder().build());
        }
        return notificationList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeInt(textColor);
        dest.writeInt(backgroundColor);
    }

    public class Builder {
        private Builder() {
            // empty
        }

        public Builder setText(String text) {
            Notification.this.text = text;
            return this;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            Notification.this.textColor = textColor;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            Notification.this.backgroundColor = backgroundColor;
            return this;
        }

        public Notification build() {
            return Notification.this;
        }
    }

    public static final Creator<Notification> CREATOR = new Creator<Notification>() {
        @Override
        public Notification createFromParcel(Parcel in) {
            return new Notification(in);
        }

        @Override
        public Notification[] newArray(int size) {
            return new Notification[size];
        }
    };

}
