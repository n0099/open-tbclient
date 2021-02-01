package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a {
    public static final Map<String, String> pyX = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Zj(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Zk(String str) {
        String Zl = Zl(str);
        if (Zl == null) {
            return null;
        }
        String lowerCase = Zl.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return pyX.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Zl(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
