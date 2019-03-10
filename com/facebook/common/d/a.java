package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import com.sina.weibo.sdk.utils.FileUtils;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> jAe = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean FB(@Nullable String str) {
        return str != null && str.startsWith(FileUtils.VIDEO_FILE_START);
    }

    @Nullable
    public static String FC(String str) {
        String FD = FD(str);
        if (FD == null) {
            return null;
        }
        String lowerCase = FD.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return jAe.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String FD(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
