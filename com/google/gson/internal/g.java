package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
public class g {
    public static DateFormat Kp(int i) {
        return new SimpleDateFormat(Kq(i), Locale.US);
    }

    public static DateFormat dJ(int i, int i2) {
        return new SimpleDateFormat(Kr(i) + " " + Ks(i2), Locale.US);
    }

    private static String Kq(int i) {
        switch (i) {
            case 0:
                return "EEEE, MMMM d, y";
            case 1:
                return "MMMM d, y";
            case 2:
                return "MMM d, y";
            case 3:
                return "M/d/yy";
            default:
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
    }

    private static String Kr(int i) {
        switch (i) {
            case 0:
                return "EEEE, MMMM d, yyyy";
            case 1:
                return "MMMM d, yyyy";
            case 2:
                return "MMM d, yyyy";
            case 3:
                return "M/d/yy";
            default:
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
    }

    private static String Ks(int i) {
        switch (i) {
            case 0:
            case 1:
                return "h:mm:ss a z";
            case 2:
                return "h:mm:ss a";
            case 3:
                return "h:mm a";
            default:
                throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
    }
}
