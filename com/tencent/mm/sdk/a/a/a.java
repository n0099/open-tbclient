package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0513a {
        public String j;
        public Bundle k;
        public String l;
        public String m;
    }

    public static boolean a(Context context, C0513a c0513a) {
        String str;
        if (context == null || c0513a == null) {
            str = "send fail, invalid argument";
        } else if (!c.a(c0513a.m)) {
            String str2 = null;
            if (!c.a(c0513a.l)) {
                str2 = c0513a.l + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c0513a.m);
            Bundle bundle = c0513a.k;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0513a.j);
            intent.putExtra("_mmessage_checksum", b.a(c0513a.j, 570490883, packageName));
            context.sendBroadcast(intent, str2);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        } else {
            str = "send fail, action is null";
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
