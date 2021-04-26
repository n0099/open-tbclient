package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f37509a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f37510b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f37511c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f37512d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f37512d = aVar;
        this.f37509a = method;
        this.f37510b = obj;
        this.f37511c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f37509a.invoke(this.f37510b, this.f37511c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
