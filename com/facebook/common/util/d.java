package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class d {
    private static final Uri ptU = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    @Nullable
    public static URL M(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean N(@Nullable Uri uri) {
        String W = W(uri);
        return "https".equals(W) || HttpHost.DEFAULT_SCHEME_NAME.equals(W);
    }

    public static boolean O(@Nullable Uri uri) {
        return "file".equals(W(uri));
    }

    public static boolean P(@Nullable Uri uri) {
        return "content".equals(W(uri));
    }

    public static boolean Q(Uri uri) {
        return P(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(ptU.getPath());
    }

    public static boolean R(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean S(@Nullable Uri uri) {
        return "asset".equals(W(uri));
    }

    public static boolean T(@Nullable Uri uri) {
        return "res".equals(W(uri));
    }

    public static boolean U(@Nullable Uri uri) {
        return "android.resource".equals(W(uri));
    }

    public static boolean V(@Nullable Uri uri) {
        return "data".equals(W(uri));
    }

    @Nullable
    public static String W(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        String string;
        Cursor cursor = null;
        if (P(uri)) {
            try {
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                            string = query.getString(columnIndex);
                            if (query == null) {
                                query.close();
                                return string;
                            }
                            return string;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                string = null;
                if (query == null) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (O(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri Qi(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
