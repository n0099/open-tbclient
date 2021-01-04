package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.plugin.util.az;
/* loaded from: classes3.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context, c cVar) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(cVar.h());
        String t = cVar.t();
        if (az.b(t) && com.qq.e.comm.plugin.w.a.c.a(context, cVar.h(), t)) {
            launchIntentForPackage = com.qq.e.comm.plugin.w.a.c.a(context, cVar.h(), Uri.parse(com.qq.e.comm.plugin.w.a.c.a(t, cVar.l(), cVar.k())));
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
        }
        return launchIntentForPackage;
    }

    public static void a(c cVar) {
        if (cVar != null && az.b(cVar.t())) {
            com.qq.e.comm.plugin.w.a.b(cVar.k());
        }
    }
}
