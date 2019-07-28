package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0473a {
        public int flags = -1;
        public String h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0473a c0473a) {
        if (context == null || c0473a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (c.a(c0473a.h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c0473a.h);
            return false;
        } else {
            if (c.a(c0473a.i)) {
                c0473a.i = c0473a.h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
            }
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c0473a.h + ", targetClassName = " + c0473a.i);
            Intent intent = new Intent();
            intent.setClassName(c0473a.h, c0473a.i);
            if (c0473a.k != null) {
                intent.putExtras(c0473a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0473a.j);
            intent.putExtra("_mmessage_checksum", b.a(c0473a.j, 570490883, packageName));
            if (c0473a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c0473a.flags);
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
