package com.vivo.push.sdk;

import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Method f13974a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f13975b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Method method, Object obj, Object[] objArr) {
        this.d = aVar;
        this.f13974a = method;
        this.f13975b = obj;
        this.c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f13974a.invoke(this.f13975b, this.c);
        } catch (Exception e) {
            p.b("CommandWorker", "reflect e: ", e);
        }
    }
}
