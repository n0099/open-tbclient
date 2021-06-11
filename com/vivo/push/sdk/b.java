package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f40362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f40363b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f40364c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f40365d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f40365d = aVar;
        this.f40362a = method;
        this.f40363b = obj;
        this.f40364c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f40362a.invoke(this.f40363b, this.f40364c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
