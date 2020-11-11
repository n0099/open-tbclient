package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1042a {

        /* renamed from: a  reason: collision with root package name */
        public String f4564a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C1042a c1042a) {
        if (context == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (d.a(c1042a.action)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = d.a(c1042a.f4564a) ? null : c1042a.f4564a + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c1042a.action);
            if (c1042a.bundle != null) {
                intent.putExtras(c1042a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 620823552);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c1042a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c1042a.b);
            intent.putExtra("_mmessage_checksum", b.a(c1042a.content, 620823552, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
