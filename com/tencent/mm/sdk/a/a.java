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
    public static class C0336a {
        public int flags = -1;
        public String h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0336a c0336a) {
        if (context == null || c0336a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (c.a(c0336a.h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c0336a.h);
            return false;
        } else {
            if (c.a(c0336a.i)) {
                c0336a.i = c0336a.h + ".wxapi.WXEntryActivity";
            }
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c0336a.h + ", targetClassName = " + c0336a.i);
            Intent intent = new Intent();
            intent.setClassName(c0336a.h, c0336a.i);
            if (c0336a.k != null) {
                intent.putExtras(c0336a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c0336a.j);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0336a.j, 570490883, packageName));
            if (c0336a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c0336a.flags);
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
