package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class MimeTypeMapWrapper {
    public static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();
    public static final Map<String, String> sMimeTypeToExtensionMap = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    public static final Map<String, String> sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");

    public static String getExtensionFromMimeType(String str) {
        String str2 = sMimeTypeToExtensionMap.get(str);
        if (str2 != null) {
            return str2;
        }
        return sMimeTypeMap.getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        String str2 = sExtensionToMimeTypeMap.get(str);
        if (str2 != null) {
            return str2;
        }
        return sMimeTypeMap.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(String str) {
        if (!sExtensionToMimeTypeMap.containsKey(str) && !sMimeTypeMap.hasExtension(str)) {
            return false;
        }
        return true;
    }

    public static boolean hasMimeType(String str) {
        if (!sMimeTypeToExtensionMap.containsKey(str) && !sMimeTypeMap.hasMimeType(str)) {
            return false;
        }
        return true;
    }
}
