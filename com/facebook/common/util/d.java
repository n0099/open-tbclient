package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import javax.annotation.Nullable;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class d {
    private static final String igJ = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();

    public static boolean k(@Nullable Uri uri) {
        String s = s(uri);
        return "https".equals(s) || HttpHost.DEFAULT_SCHEME_NAME.equals(s);
    }

    public static boolean l(@Nullable Uri uri) {
        return "file".equals(s(uri));
    }

    public static boolean m(@Nullable Uri uri) {
        return "content".equals(s(uri));
    }

    public static boolean n(Uri uri) {
        return m(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(igJ);
    }

    public static boolean o(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean p(@Nullable Uri uri) {
        return "asset".equals(s(uri));
    }

    public static boolean q(@Nullable Uri uri) {
        return "res".equals(s(uri));
    }

    public static boolean r(@Nullable Uri uri) {
        return "data".equals(s(uri));
    }

    @Nullable
    public static String s(@Nullable Uri uri) {
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
        if (m(uri)) {
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
        } else if (l(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri xV(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
