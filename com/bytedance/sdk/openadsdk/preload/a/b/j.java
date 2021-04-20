package com.bytedance.sdk.openadsdk.preload.a.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes5.dex */
public class j {
    public static DateFormat a(int i, int i2) {
        return new SimpleDateFormat(a(i) + " " + b(i2), Locale.US);
    }

    public static String b(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i != 2) {
            if (i == 3) {
                return "h:mm a";
            }
            throw new IllegalArgumentException("Unknown DateFormat style: " + i);
        }
        return "h:mm:ss a";
    }

    public static String a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }
}
