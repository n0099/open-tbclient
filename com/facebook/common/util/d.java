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
    private static final String jSY = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();

    public static boolean y(@Nullable Uri uri) {
        String G = G(uri);
        return "https".equals(G) || HttpHost.DEFAULT_SCHEME_NAME.equals(G);
    }

    public static boolean z(@Nullable Uri uri) {
        return "file".equals(G(uri));
    }

    public static boolean A(@Nullable Uri uri) {
        return "content".equals(G(uri));
    }

    public static boolean B(Uri uri) {
        return A(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(jSY);
    }

    public static boolean C(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean D(@Nullable Uri uri) {
        return "asset".equals(G(uri));
    }

    public static boolean E(@Nullable Uri uri) {
        return "res".equals(G(uri));
    }

    public static boolean F(@Nullable Uri uri) {
        return "data".equals(G(uri));
    }

    @Nullable
    public static String G(@Nullable Uri uri) {
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
        if (A(uri)) {
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
        } else if (z(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri CR(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
