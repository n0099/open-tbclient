package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a {
    public static final Map<String, String> lRM = ImmutableMap.of("mkv", MimeType.Video.MKV, "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    public static boolean Ob(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String Oc(String str) {
        String Od = Od(str);
        if (Od == null) {
            return null;
        }
        String lowerCase = Od.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return lRM.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String Od(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
