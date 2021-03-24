package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f39520a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f39522c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f39523d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f39523d = aVar;
        this.f39520a = method;
        this.f39521b = obj;
        this.f39522c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f39520a.invoke(this.f39521b, this.f39522c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
