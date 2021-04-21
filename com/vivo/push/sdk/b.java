package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f39905a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f39907c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f39908d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f39908d = aVar;
        this.f39905a = method;
        this.f39906b = obj;
        this.f39907c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f39905a.invoke(this.f39906b, this.f39907c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
