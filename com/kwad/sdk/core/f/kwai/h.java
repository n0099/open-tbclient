package com.kwad.sdk.core.f.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes8.dex */
public final class h {
    public Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                new StringBuilder("getOAID oaid:").append(str);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return str;
    }
}
