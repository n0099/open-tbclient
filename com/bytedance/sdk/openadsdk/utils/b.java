package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes6.dex */
public class b {

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static boolean a(Context context, Intent intent, a aVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                context.startActivity(intent);
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.a(th);
                }
            }
        }
        return false;
    }
}
