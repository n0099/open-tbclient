package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.utils.w;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f33607a;

    public d(Context context) {
        this.f33607a = context;
    }

    private String a(Cursor cursor) {
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

    public String a() {
        String str = "";
        try {
            Cursor query = this.f33607a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            str = a(query);
            com.kwad.sdk.core.d.a.b("MeizuDeviceIDHelper", "getOAID oaid:" + str);
            w.a(query);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b("MeizuDeviceIDHelper", "getOAID service not found;");
            com.kwad.sdk.core.d.a.a(e2);
        }
        return str;
    }
}
