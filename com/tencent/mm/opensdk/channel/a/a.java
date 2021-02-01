package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1261a {

        /* renamed from: a  reason: collision with root package name */
        public String f13354a;
        public String action;

        /* renamed from: b  reason: collision with root package name */
        public long f13355b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C1261a c1261a) {
        if (context == null) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (d.a(c1261a.action)) {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = d.a(c1261a.f13354a) ? null : c1261a.f13354a + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c1261a.action);
            if (c1261a.bundle != null) {
                intent.putExtras(c1261a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 620823552);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c1261a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c1261a.f13355b);
            intent.putExtra("_mmessage_checksum", b.a(c1261a.content, 620823552, packageName));
            context.sendBroadcast(intent, str);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
