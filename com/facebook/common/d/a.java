package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> kak = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean Gy(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Gz(String str) {
        String GA = GA(str);
        if (GA == null) {
            return null;
        }
        String lowerCase = GA.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return kak.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String GA(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
