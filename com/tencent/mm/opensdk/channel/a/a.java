package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0932a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0932a c0932a) {
        if (context == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (d.a(c0932a.action)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = d.a(c0932a.a) ? null : c0932a.a + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c0932a.action);
            if (c0932a.bundle != null) {
                intent.putExtras(c0932a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 620823552);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0932a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0932a.b);
            intent.putExtra("_mmessage_checksum", b.a(c0932a.content, 620823552, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
