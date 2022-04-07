package com.kwad.sdk.core.f.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public class h {
    public Context a;

    public h(Context context) {
        this.a = context;
    }

    public String a() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    str = cursor.getString(cursor.getColumnIndex("value"));
                    com.kwad.sdk.core.d.a.c("VivoDeviceIDHelper", "getOAID oaid:" + str);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.c("VivoDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.a.b(e);
            }
            return str;
        } finally {
            ae.a(cursor);
        }
    }
}
