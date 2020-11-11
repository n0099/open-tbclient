package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Method f4695a;
    final /* synthetic */ Object b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.d = aVar;
        this.f4695a = method;
        this.b = obj;
        this.c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f4695a.invoke(this.b, this.c);
        } catch (Exception e) {
            p.b("CommandWorker", "reflect e: ", e);
        }
    }
}
