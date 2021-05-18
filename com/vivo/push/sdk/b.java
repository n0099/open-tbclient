package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f36754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f36755b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f36756c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f36757d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.f36757d = aVar;
        this.f36754a = method;
        this.f36755b = obj;
        this.f36756c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f36754a.invoke(this.f36755b, this.f36756c);
        } catch (Exception e2) {
            p.b("CommandWorker", "reflect e: ", e2);
        }
    }
}
