package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes5.dex */
public final class h {
    public Context a;

    public h(Context context) {
        this.a = context;
    }

    public final String a() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                new StringBuilder("getOAID oaid:").append(str);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.a(cursor);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.a(cursor);
        return str;
    }
}
