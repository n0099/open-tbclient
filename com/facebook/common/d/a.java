package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> hYE = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean yA(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String yB(String str) {
        String yC = yC(str);
        if (yC == null) {
            return null;
        }
        String lowerCase = yC.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return hYE.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String yC(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
