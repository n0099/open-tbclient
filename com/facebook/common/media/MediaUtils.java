package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import com.sina.weibo.sdk.utils.FileUtils;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary", "flv", "flv-application/octet-stream");

    @Nullable
    public static String extractExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    @Nullable
    public static String extractMime(String str) {
        String extractExtension = extractExtension(str);
        if (extractExtension == null) {
            return null;
        }
        String lowerCase = extractExtension.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase) : mimeTypeFromExtension;
    }

    public static boolean isNonNativeSupportedMimeType(String str) {
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(str);
    }

    public static boolean isPhoto(@Nullable String str) {
        return str != null && str.startsWith(FileUtils.IMAGE_FILE_START);
    }

    public static boolean isThreeD(@Nullable String str) {
        return str != null && str.equals("model/gltf-binary");
    }

    public static boolean isVideo(@Nullable String str) {
        return str != null && str.startsWith(FileUtils.VIDEO_FILE_START);
    }
}
