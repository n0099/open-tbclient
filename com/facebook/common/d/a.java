package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a {
    public static final Map<String, String> mQT = ImmutableMap.of("mkv", MimeType.Video.MKV, "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Ro(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Rp(String str) {
        String Rq = Rq(str);
        if (Rq == null) {
            return null;
        }
        String lowerCase = Rq.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return mQT.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Rq(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
