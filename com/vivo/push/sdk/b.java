package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f40465a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f40466b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f40467c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f40468d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f40468d = aVar;
        this.f40465a = method;
        this.f40466b = obj;
        this.f40467c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f40465a.invoke(this.f40466b, this.f40467c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
