package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a {
        public String j;
        public Bundle k;
        public String l;
        public String m;
    }

    public static boolean a(Context context, C0081a c0081a) {
        if (context == null || c0081a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (c.a(c0081a.m)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = c.a(c0081a.l) ? null : c0081a.l + ".permission.MM_MESSAGE";
            Intent intent = new Intent(c0081a.m);
            if (c0081a.k != null) {
                intent.putExtras(c0081a.k);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570425345);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c0081a.j);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0081a.j, 570425345, packageName));
            context.sendBroadcast(intent, str);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
