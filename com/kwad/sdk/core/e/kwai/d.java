package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes5.dex */
public final class d {
    public Context a;

    public d(Context context) {
        this.a = context;
    }

    public static String a(Cursor cursor) {
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

    public final String a() {
        String str = "";
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            str = a(query);
            new StringBuilder("getOAID oaid:").append(str);
            com.kwad.sdk.crash.utils.b.a(query);
        } catch (Exception unused) {
            return str;
        }
    }
}
