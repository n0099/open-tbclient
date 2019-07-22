package com.facebook.common.d;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import com.sina.weibo.sdk.utils.FileUtils;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {
    public static final Map<String, String> jZp = ImmutableMap.of("mkv", "video/x-matroska");

    public static boolean HG(@Nullable String str) {
        return str != null && str.startsWith(FileUtils.VIDEO_FILE_START);
    }

    @Nullable
    public static String HH(String str) {
        String HI = HI(str);
        if (HI == null) {
            return null;
        }
        String lowerCase = HI.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return jZp.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    private static String HI(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }
}
