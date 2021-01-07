package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {
    public static final Map<String, String> ptn = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Zp(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Zq(String str) {
        String Zr = Zr(str);
        if (Zr == null) {
            return null;
        }
        String lowerCase = Zr.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return ptn.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Zr(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
