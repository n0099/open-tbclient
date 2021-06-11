package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.asm.Label;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0512a {
        public int flags = -1;

        /* renamed from: h  reason: collision with root package name */
        public String f39989h;

        /* renamed from: i  reason: collision with root package name */
        public String f39990i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0512a c0512a) {
        if (context == null || c0512a == null) {
            com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid argument");
            return false;
        } else if (c.a(c0512a.f39989h)) {
            com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid targetPkgName, targetPkgName = " + c0512a.f39989h);
            return false;
        } else {
            if (c.a(c0512a.f39990i)) {
                c0512a.f39990i = c0512a.f39989h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
            }
            com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send, targetPkgName = " + c0512a.f39989h + ", targetClassName = " + c0512a.f39990i);
            Intent intent = new Intent();
            intent.setClassName(c0512a.f39989h, c0512a.f39990i);
            Bundle bundle = c0512a.k;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 570490883);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0512a.j);
            intent.putExtra("_mmessage_checksum", b.a(c0512a.j, 570490883, packageName));
            int i2 = c0512a.flags;
            if (i2 == -1) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT).addFlags(134217728);
            } else {
                intent.setFlags(i2);
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
