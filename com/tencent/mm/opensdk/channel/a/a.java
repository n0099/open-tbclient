package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0775a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0775a c0775a) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else if (!d.b(c0775a.action)) {
            String str2 = null;
            if (!d.b(c0775a.a)) {
                str2 = c0775a.a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c0775a.action);
            Bundle bundle = c0775a.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c0775a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0775a.b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0775a.content, Build.SDK_INT, packageName));
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
