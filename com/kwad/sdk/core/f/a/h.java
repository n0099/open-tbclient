package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.utils.w;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private Context f9145a;

    public h(Context context) {
        this.f9145a = context;
    }

    public String a() {
        Cursor cursor;
        String str;
        try {
            try {
                cursor = this.f9145a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            } catch (Throwable th) {
                th = th;
                w.a((Cursor) null);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
            str = "";
        } catch (Throwable th2) {
            th = th2;
            w.a((Cursor) null);
            throw th;
        }
        if (cursor != null) {
            try {
            } catch (Exception e2) {
                e = e2;
                str = "";
            }
            if (cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                try {
                    com.kwad.sdk.core.d.a.b("VivoDeviceIDHelper", "getOAID oaid:" + str);
                    w.a(cursor);
                } catch (Exception e3) {
                    e = e3;
                    com.kwad.sdk.core.d.a.b("VivoDeviceIDHelper", "getOAID fail");
                    com.kwad.sdk.core.d.a.b(e);
                    w.a(cursor);
                    return str;
                }
                return str;
            }
        }
        str = "";
        w.a(cursor);
        return str;
    }
}
