package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C1260a {
        public String j;
        public Bundle k;
        public String l;
        public String m;
    }

    public static boolean a(Context context, C1260a c1260a) {
        if (context == null || c1260a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (c.a(c1260a.m)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = c.a(c1260a.l) ? null : c1260a.l + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c1260a.m);
            if (c1260a.k != null) {
                intent.putExtras(c1260a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c1260a.j);
            intent.putExtra("_mmessage_checksum", b.a(c1260a.j, 570490883, packageName));
            context.sendBroadcast(intent, str);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
