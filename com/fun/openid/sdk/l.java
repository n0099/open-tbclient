package com.fun.openid.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
/* loaded from: classes6.dex */
public class l implements f {
    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        p.a(context).getClass();
        String str = null;
        if (!p.f30731b) {
            if (FunOpenIDSdk.isLogEnabled()) {
                Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
            }
            ((e.a) aVar).a(false, null);
            return;
        }
        p a2 = p.a(context);
        a2.getClass();
        if (p.f30731b) {
            String str2 = p.f30737h;
            if (str2 != null) {
                str = str2;
            } else {
                a2.a(0, null);
                if (p.f30732c == null) {
                    Context context2 = p.f30730a;
                    p.f30732c = new q(p.f30738i, 0, null);
                    context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, p.f30732c);
                }
                str = p.f30737h;
            }
        }
        ((e.a) aVar).a(true, str);
    }
}
