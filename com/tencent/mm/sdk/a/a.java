package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0511a {
        public int flags = -1;

        /* renamed from: h  reason: collision with root package name */
        public String f39155h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0511a c0511a) {
        if (context == null || c0511a == null) {
            com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid argument");
            return false;
        } else if (c.a(c0511a.f39155h)) {
            com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid targetPkgName, targetPkgName = " + c0511a.f39155h);
            return false;
        } else {
            if (c.a(c0511a.i)) {
                c0511a.i = c0511a.f39155h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
            }
            com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send, targetPkgName = " + c0511a.f39155h + ", targetClassName = " + c0511a.i);
            Intent intent = new Intent();
            intent.setClassName(c0511a.f39155h, c0511a.i);
            Bundle bundle = c0511a.k;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0511a.j);
            intent.putExtra("_mmessage_checksum", b.a(c0511a.j, 570490883, packageName));
            int i = c0511a.flags;
            if (i == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(i);
            }
            try {
                context.startActivity(intent);
                com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send mm message, intent=" + intent);
                return true;
            } catch (Exception e2) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, ex = %s", e2.getMessage());
                return false;
            }
        }
    }
}
