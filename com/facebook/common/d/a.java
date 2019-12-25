package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a {
    public static final Map<String, String> lEl = ImmutableMap.of("mkv", MimeType.Video.MKV, "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Ot(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Ou(String str) {
        String Ov = Ov(str);
        if (Ov == null) {
            return null;
        }
        String lowerCase = Ov.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return lEl.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Ov(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
