package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> ifR = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean zd(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String ze(String str) {
        String zf = zf(str);
        if (zf == null) {
            return null;
        }
        String lowerCase = zf.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return ifR.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String zf(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
