package com.fun.openid.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
/* loaded from: classes3.dex */
public class n implements h {
    @Override // com.fun.openid.sdk.h
    public void a(Context context, h.a aVar) {
        String str = null;
        r.io(context).getClass();
        if (!r.b) {
            if (b.isLogEnabled()) {
                Log.e("FunOpenIDSdk", "当前设备不支持获取OAID");
            }
            ((g.a) aVar).a(false, null);
            return;
        }
        r io2 = r.io(context);
        io2.getClass();
        if (r.b) {
            String str2 = r.h;
            if (str2 != null) {
                str = str2;
            } else {
                io2.a(0, null);
                if (r.pRj == null) {
                    Context context2 = r.f5250a;
                    r.pRj = new t(r.pRk, 0, null);
                    context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, r.pRj);
                }
                str = r.h;
            }
        }
        ((g.a) aVar).a(true, str);
    }
}
