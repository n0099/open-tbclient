package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import javax.annotation.Nullable;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class d {
    private static final String kbb = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();

    public static boolean v(@Nullable Uri uri) {
        String D = D(uri);
        return "https".equals(D) || HttpHost.DEFAULT_SCHEME_NAME.equals(D);
    }

    public static boolean w(@Nullable Uri uri) {
        return BdStatsConstant.OpSubType.FILE.equals(D(uri));
    }

    public static boolean x(@Nullable Uri uri) {
        return "content".equals(D(uri));
    }

    public static boolean y(Uri uri) {
        return x(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(kbb);
    }

    public static boolean z(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean A(@Nullable Uri uri) {
        return "asset".equals(D(uri));
    }

    public static boolean B(@Nullable Uri uri) {
        return "res".equals(D(uri));
    }

    public static boolean C(@Nullable Uri uri) {
        return "data".equals(D(uri));
    }

    @Nullable
    public static String D(@Nullable Uri uri) {
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
    public static String b(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        String string;
        Cursor cursor = null;
        if (x(uri)) {
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
        } else if (w(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri BZ(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
}
