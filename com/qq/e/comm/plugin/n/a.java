package com.qq.e.comm.plugin.n;

import android.content.Context;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.q;
/* loaded from: classes15.dex */
public class a {
    public static g a(Context context, com.qq.e.comm.plugin.s.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        if (context == null || aVar == null) {
            ai.a("BottomCardFactory", "params error, create BottomCard fail.");
            return null;
        } else if (q.a(aVar)) {
            ai.a("BottomCardFactory", "dpa ad, create DpaCardView.");
            return new c(context, aVar, cVar);
        } else {
            ai.a("BottomCardFactory", "normal ad, create BottomCardView.");
            return new b(context, aVar);
        }
    }
}
