package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0378a {
        public int flags = -1;
        public String h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0378a c0378a) {
        if (context == null || c0378a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (c.a(c0378a.h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c0378a.h);
            return false;
        } else {
            if (c.a(c0378a.i)) {
                c0378a.i = c0378a.h + ".wxapi.WXEntryActivity";
            }
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c0378a.h + ", targetClassName = " + c0378a.i);
            Intent intent = new Intent();
            intent.setClassName(c0378a.h, c0378a.i);
            if (c0378a.k != null) {
                intent.putExtras(c0378a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c0378a.j);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0378a.j, 570490883, packageName));
            if (c0378a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c0378a.flags);
            }
            try {
                context.startActivity(intent);
                com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
