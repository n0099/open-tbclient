package d.b.h0.a.r.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.h0.a.m.a f46415a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.h0.a.m.c f46416b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f46417c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f46418d;

    static {
        f fVar = new f();
        f46418d = fVar;
        Intrinsics.checkExpressionValueIsNotNull(fVar.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
    }

    public final void a() {
        d.f46413a.a();
        h.f46420a.b();
        f(false);
    }

    public final boolean b() {
        return f46417c;
    }

    public final d.b.h0.a.m.a c() {
        return f46415a;
    }

    public final d.b.h0.a.m.c d() {
        return f46416b;
    }

    public final boolean e() {
        if (g.a() == null) {
            g();
        }
        Boolean a2 = g.a();
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        return a2.booleanValue();
    }

    public final void f(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
    }

    public final void g() {
        boolean z;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            z = false;
        } catch (ClassNotFoundException unused) {
            z = true;
        }
        g.b(Boolean.valueOf(z));
    }

    public final void h(boolean z) {
        f46417c = z;
    }
}
