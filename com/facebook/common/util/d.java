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
/* loaded from: classes4.dex */
public class d {
    private static final Uri pCh = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    @Nullable
    public static URL J(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean K(@Nullable Uri uri) {
        String T = T(uri);
        return "https".equals(T) || HttpHost.DEFAULT_SCHEME_NAME.equals(T);
    }

    public static boolean L(@Nullable Uri uri) {
        return "file".equals(T(uri));
    }

    public static boolean M(@Nullable Uri uri) {
        return "content".equals(T(uri));
    }

    public static boolean N(Uri uri) {
        return M(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(pCh.getPath());
    }

    public static boolean O(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean P(@Nullable Uri uri) {
        return "asset".equals(T(uri));
    }

    public static boolean Q(@Nullable Uri uri) {
        return "res".equals(T(uri));
    }

    public static boolean R(@Nullable Uri uri) {
        return "android.resource".equals(T(uri));
    }

    public static boolean S(@Nullable Uri uri) {
        return "data".equals(T(uri));
    }

    @Nullable
    public static String T(@Nullable Uri uri) {
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
        if (M(uri)) {
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
        } else if (L(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri Pb(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
