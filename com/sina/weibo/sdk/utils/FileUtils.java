package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
/* loaded from: classes2.dex */
public class FileUtils {
    public static final String IMAGE_FILE_START = "image/";
    public static final String VIDEO_FILE_START = "video/";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [35=5, 36=4] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getPath(Context context, Uri uri) {
        Cursor cursor;
        if (uri == null || context == null) {
            return null;
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(columnIndexOrThrow);
                                if (cursor != null) {
                                    cursor.close();
                                    return string;
                                }
                                return string;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getMIMEType(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return "*/*";
        }
        String substring = name.substring(lastIndexOf, name.length());
        if (TextUtils.isEmpty(substring) && substring.length() < 2) {
            return "*/*";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1, substring.length()).toLowerCase());
    }

    public static boolean isImageFile(Context context, Uri uri) {
        return getMIMEType(new File(getPath(context, uri))).startsWith(IMAGE_FILE_START);
    }

    public static boolean isVideoFile(Context context, Uri uri) {
        return getMIMEType(new File(getPath(context, uri))).startsWith(VIDEO_FILE_START);
    }
}
