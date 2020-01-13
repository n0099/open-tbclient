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
/* loaded from: classes12.dex */
public class d {
    private static final Uri lIp = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    @Nullable
    public static URL A(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean B(@Nullable Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || HttpHost.DEFAULT_SCHEME_NAME.equals(schemeOrNull);
    }

    public static boolean isLocalFileUri(@Nullable Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(@Nullable Uri uri) {
        return "content".equals(getSchemeOrNull(uri));
    }

    public static boolean C(Uri uri) {
        return isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(lIp.getPath());
    }

    public static boolean D(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean E(@Nullable Uri uri) {
        return "asset".equals(getSchemeOrNull(uri));
    }

    public static boolean F(@Nullable Uri uri) {
        return "res".equals(getSchemeOrNull(uri));
    }

    public static boolean G(@Nullable Uri uri) {
        return "android.resource".equals(getSchemeOrNull(uri));
    }

    public static boolean H(@Nullable Uri uri) {
        return "data".equals(getSchemeOrNull(uri));
    }

    @Nullable
    public static String getSchemeOrNull(@Nullable Uri uri) {
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
        if (isLocalContentUri(uri)) {
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
        } else if (isLocalFileUri(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri Hq(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
