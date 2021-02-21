package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1265a {
        public int flags = -1;
        public String h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C1265a c1265a) {
        if (context == null || c1265a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (c.a(c1265a.h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c1265a.h);
            return false;
        } else {
            if (c.a(c1265a.i)) {
                c1265a.i = c1265a.h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
            }
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c1265a.h + ", targetClassName = " + c1265a.i);
            Intent intent = new Intent();
            intent.setClassName(c1265a.h, c1265a.i);
            if (c1265a.k != null) {
                intent.putExtras(c1265a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c1265a.j);
            intent.putExtra("_mmessage_checksum", b.a(c1265a.j, 570490883, packageName));
            if (c1265a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c1265a.flags);
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
