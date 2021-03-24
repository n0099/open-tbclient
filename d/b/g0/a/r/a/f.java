package d.b.g0.a.r.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.g0.a.m.a f45693a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.g0.a.m.c f45694b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f45695c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f45696d;

    static {
        f fVar = new f();
        f45696d = fVar;
        Intrinsics.checkExpressionValueIsNotNull(fVar.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
    }

    public final void a() {
        d.f45691a.a();
        h.f45698a.b();
        f(false);
    }

    public final boolean b() {
        return f45695c;
    }

    public final d.b.g0.a.m.a c() {
        return f45693a;
    }

    public final d.b.g0.a.m.c d() {
        return f45694b;
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
        f45695c = z;
    }
}
