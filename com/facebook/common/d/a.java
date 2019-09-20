package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> kcS = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean Ih(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Ii(String str) {
        String Ij = Ij(str);
        if (Ij == null) {
            return null;
        }
        String lowerCase = Ij.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return kcS.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Ij(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
