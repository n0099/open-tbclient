package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a {
    public static final Map<String, String> oMR = ImmutableMap.of("mkv", MimeType.Video.MKV, "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean XK(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String XL(String str) {
        String XM = XM(str);
        if (XM == null) {
            return null;
        }
        String lowerCase = XM.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return oMR.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String XM(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
