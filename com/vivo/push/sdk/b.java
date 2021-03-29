package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f39521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39522b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f39523c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f39524d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f39524d = aVar;
        this.f39521a = method;
        this.f39522b = obj;
        this.f39523c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f39521a.invoke(this.f39522b, this.f39523c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
