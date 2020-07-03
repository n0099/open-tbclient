package com.kascend.chushou.d;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public final class i {
    @Nullable
    public static Uri Rj(@Nullable String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    @Nullable
    public static String a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static boolean ae(@Nullable Uri uri) {
        return "file".equals(a(uri));
    }

    public static boolean af(@Nullable Uri uri) {
        return "content".equals(a(uri));
    }

    @Nullable
    public static String a(@NonNull Context context, Uri uri) {
        Uri uri2 = null;
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return null;
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{split2[1]});
                }
                return null;
            }
        } else if (af(uri)) {
            return a(context, uri, null, null);
        } else {
            if (ae(uri)) {
                return uri.getPath();
            }
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [311=5, 312=4] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        int columnIndexOrThrow;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst() && (columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data")) != -1) {
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
        return null;
    }
}
