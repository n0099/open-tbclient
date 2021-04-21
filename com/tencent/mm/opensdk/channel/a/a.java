package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0527a {

        /* renamed from: a  reason: collision with root package name */
        public String f39524a;
        public String action;

        /* renamed from: b  reason: collision with root package name */
        public long f39525b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0527a c0527a) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else if (!d.b(c0527a.action)) {
            String str2 = null;
            if (!d.b(c0527a.f39524a)) {
                str2 = c0527a.f39524a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c0527a.action);
            Bundle bundle = c0527a.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", Build.SDK_INT);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c0527a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0527a.f39525b);
            intent.putExtra("_mmessage_checksum", b.a(c0527a.content, Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        } else {
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
