package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {
    public static final Map<String, String> mlE = ImmutableMap.of("mkv", MimeType.Video.MKV, "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean PP(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String PQ(String str) {
        String PR = PR(str);
        if (PR == null) {
            return null;
        }
        String lowerCase = PR.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return mlE.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String PR(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
