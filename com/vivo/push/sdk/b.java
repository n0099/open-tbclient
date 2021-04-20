package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f39810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f39812c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f39813d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f39813d = aVar;
        this.f39810a = method;
        this.f39811b = obj;
        this.f39812c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f39810a.invoke(this.f39811b, this.f39812c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
