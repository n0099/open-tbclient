package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0851a {
        public String j;
        public Bundle k;
        public String l;
        public String m;
    }

    public static boolean a(Context context, C0851a c0851a) {
        if (context == null || c0851a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (c.a(c0851a.m)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = c.a(c0851a.l) ? null : c0851a.l + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c0851a.m);
            if (c0851a.k != null) {
                intent.putExtras(c0851a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0851a.j);
            intent.putExtra("_mmessage_checksum", b.a(c0851a.j, 570490883, packageName));
            context.sendBroadcast(intent, str);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
