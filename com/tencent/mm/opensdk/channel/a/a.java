package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0877a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0877a c0877a) {
        if (context == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (d.a(c0877a.action)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = d.a(c0877a.a) ? null : c0877a.a + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c0877a.action);
            if (c0877a.bundle != null) {
                intent.putExtras(c0877a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 620823552);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0877a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0877a.b);
            intent.putExtra("_mmessage_checksum", b.a(c0877a.content, 620823552, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
