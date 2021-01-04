package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static boolean a(Context context, Intent intent, a aVar) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            if (aVar != null) {
                aVar.a();
            }
            return true;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a(th);
                return false;
            }
            return false;
        }
    }
}
