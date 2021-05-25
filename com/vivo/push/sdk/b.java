package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f36683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f36684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f36685c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f36686d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f36686d = aVar;
        this.f36683a = method;
        this.f36684b = obj;
        this.f36685c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f36683a.invoke(this.f36684b, this.f36685c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
