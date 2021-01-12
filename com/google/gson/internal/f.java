package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes4.dex */
public class f {
    public static DateFormat PZ(int i) {
        return new SimpleDateFormat(Qa(i), Locale.US);
    }

    public static DateFormat ei(int i, int i2) {
        return new SimpleDateFormat(Qb(i) + " " + Qc(i2), Locale.US);
    }

    private static String Qa(int i) {
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

    private static String Qb(int i) {
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

    private static String Qc(int i) {
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
