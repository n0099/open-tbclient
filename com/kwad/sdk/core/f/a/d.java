package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes10.dex */
public final class d {
    public Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public static String f(Cursor cursor) {
        String str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex > 0) {
                str = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public final String getOAID() {
        String str = "";
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            str = f(query);
            new StringBuilder("getOAID oaid:").append(str);
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
        } catch (Exception unused) {
            return str;
        }
    }
}
