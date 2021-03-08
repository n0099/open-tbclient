package com.fun.openid.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes3.dex */
public final class q extends Handler {
    public q(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Uri parse;
        if (message.what != 11) {
            Log.e("VMS_IDLG_SDK_Client", "message type valid");
            return;
        }
        int i = message.getData().getInt("type");
        String string = message.getData().getString("appid");
        p pVar = r.pRl;
        pVar.getClass();
        if (i == 0) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + string);
        } else if (i != 2) {
            parse = i != 4 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + string);
        }
        Cursor query = pVar.f5249a.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        } else {
            Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
        }
        r.g = r2;
        Context context = r.f5250a;
        synchronized (r.d) {
            r.d.notify();
        }
    }
}
