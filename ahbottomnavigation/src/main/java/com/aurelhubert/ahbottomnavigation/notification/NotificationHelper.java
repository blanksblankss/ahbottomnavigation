package com.aurelhubert.ahbottomnavigation.notification;

import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;

/**
 * @author repitch
 */
public final class NotificationHelper {

    private NotificationHelper() {
        // empty
    }

    public static int getTextColor(@Nullable Notification notification, @ColorInt int defaultTextColor) {
        if (notification == null) {
            return defaultTextColor;
        }
        int textColor = notification.getTextColor();
        return textColor == 0 ? defaultTextColor : textColor;
    }

    public static int getBackgroundColor(@Nullable Notification notification, @ColorInt int defaultBackgroundColor) {
        if (notification == null) {
            return defaultBackgroundColor;
        }
        int backgroundColor = notification.getBackgroundColor();
        return backgroundColor == 0 ? defaultBackgroundColor : backgroundColor;
    }

}
