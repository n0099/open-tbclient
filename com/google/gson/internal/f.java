package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes5.dex */
public class f {
    public static DateFormat Rq(int i) {
        return new SimpleDateFormat(Rr(i), Locale.US);
    }

    public static DateFormat eg(int i, int i2) {
        return new SimpleDateFormat(Rs(i) + " " + Rt(i2), Locale.US);
    }

    private static String Rr(int i) {
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

    private static String Rs(int i) {
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

    private static String Rt(int i) {
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
