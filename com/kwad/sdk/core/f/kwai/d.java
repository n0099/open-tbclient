package com.kwad.sdk.core.f.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes8.dex */
public final class d {
    public Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public static String d(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
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
            str = d(query);
            new StringBuilder("getOAID oaid:").append(str);
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
        } catch (Exception unused) {
            return str;
        }
    }
}
