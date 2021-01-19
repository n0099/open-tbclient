package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a {
    public static final Map<String, String> poM = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Yi(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Yj(String str) {
        String Yk = Yk(str);
        if (Yk == null) {
            return null;
        }
        String lowerCase = Yk.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return poM.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Yk(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
