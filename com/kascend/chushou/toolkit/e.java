package com.kascend.chushou.toolkit;

import kotlin.h;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
@h
/* loaded from: classes5.dex */
public final class e implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        q.j(chain, "chain");
        Request request = chain.request();
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dJv().S(tv.chushou.basis.d.a.b.b.class);
        Response proceed = chain.proceed(request.newBuilder().header("User-Agent", (bVar == null || (r0 = bVar.getUserAgent()) == null) ? "Android ChushouTV SDK/5.5.6/Tieba/1.0.2" : "Android ChushouTV SDK/5.5.6/Tieba/1.0.2").build());
        q.i(proceed, "chain.proceed(builder.build())");
        return proceed;
    }
}
