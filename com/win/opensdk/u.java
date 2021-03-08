package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.Date;
/* loaded from: classes14.dex */
public class u {
    public static u qkA;

    public static u eJa() {
        if (qkA == null) {
            synchronized (u.class) {
                if (qkA == null) {
                    qkA = new u();
                }
            }
        }
        return qkA;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (((r4 / 60) / 60) >= r2.f8147a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str) {
        boolean z = false;
        if (context != null) {
            context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                bp.e(context, str);
            }
            bt.a(new s(this, context));
            cu iU = cu.iU(context);
            long iP = bp.iP(iU.f8147a);
            if (iP > 0) {
                try {
                    long time = (new Date().getTime() - iP) / 1000;
                    if (time < 0) {
                        iU.b();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    z = true;
                }
                if (z) {
                    iU.b = System.currentTimeMillis();
                    bt.a(new cr(iU));
                }
                v.f(context);
                bc.a(context);
                return;
            }
            z = true;
            if (z) {
            }
            v.f(context);
            bc.a(context);
            return;
        }
        throw new RuntimeException("Error:Context is not allowed to be null");
    }
}
