package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {
    public static final Map<String, String> ptg = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Zq(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Zr(String str) {
        String Zs = Zs(str);
        if (Zs == null) {
            return null;
        }
        String lowerCase = Zs.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return ptg.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Zs(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
