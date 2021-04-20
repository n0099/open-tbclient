package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.utils.w;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f33906a;

    public h(Context context) {
        this.f33906a = context;
    }

    public String a() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.f33906a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    str = cursor.getString(cursor.getColumnIndex("value"));
                    com.kwad.sdk.core.d.a.b("VivoDeviceIDHelper", "getOAID oaid:" + str);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b("VivoDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.a.b(e2);
            }
            return str;
        } finally {
            w.a(cursor);
        }
    }
}
