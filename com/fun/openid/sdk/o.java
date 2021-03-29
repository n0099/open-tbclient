package com.fun.openid.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes6.dex */
public final class o extends Handler {
    public o(Looper looper) {
        super(looper);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        String str;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str2;
        if (message.what != 11) {
            Log.e("VMS_IDLG_SDK_Client", "message type valid");
            return;
        }
        int i = message.getData().getInt("type");
        String string = message.getData().getString("appid");
        n nVar = p.j;
        nVar.getClass();
        if (i != 0) {
            if (i == 1) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i == 2) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            } else if (i != 4) {
                parse = null;
                query = nVar.f30853a.getContentResolver().query(parse, null, null, null, null);
                if (query == null) {
                    r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                } else {
                    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
                }
                p.f30860g = r2;
                Context context = p.f30854a;
                synchronized (p.f30857d) {
                    p.f30857d.notify();
                }
                return;
            } else {
                str = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
            }
            sb.append(str2);
            sb.append(string);
            str = sb.toString();
        } else {
            str = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        parse = Uri.parse(str);
        query = nVar.f30853a.getContentResolver().query(parse, null, null, null, null);
        if (query == null) {
        }
        p.f30860g = r2;
        Context context2 = p.f30854a;
        synchronized (p.f30857d) {
        }
    }
}
