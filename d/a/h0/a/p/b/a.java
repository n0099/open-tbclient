package d.a.h0.a.p.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import d.a.h0.a.e0.k.d.a;
import d.a.h0.a.e0.u.b;
/* loaded from: classes2.dex */
public class a implements d.a.h0.a.p.c.l {

    /* renamed from: d.a.h0.a.p.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0723a implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f43501a;

        public C0723a(a aVar, a.c cVar) {
            this.f43501a = cVar;
        }

        @Override // d.a.h0.a.e0.u.b.c
        public void a() {
            a.c cVar = this.f43501a;
            if (cVar != null) {
                cVar.a();
            }
            d.a.h0.a.e0.u.b.h(AppRuntime.getAppContext()).f(this);
        }
    }

    @Override // d.a.h0.a.p.c.l
    public int a() {
        return 10150;
    }

    @Override // d.a.h0.a.p.c.l
    public VideoPlayerFactory b() {
        return null;
    }

    @Override // d.a.h0.a.p.c.l
    public int c() {
        return 5000;
    }

    @Override // d.a.h0.a.p.c.l
    public void d(boolean z) {
        if (z) {
            d.a.h0.a.e0.u.b.h(AppRuntime.getAppContext()).k(ProcessUtils.isMainProcess());
        } else {
            d.a.h0.a.e0.u.b.h(AppRuntime.getAppContext()).i();
        }
    }

    @Override // d.a.h0.a.p.c.l
    public boolean e() {
        return false;
    }

    @Override // d.a.h0.a.p.c.l
    public boolean f() {
        return true;
    }

    @Override // d.a.h0.a.p.c.l
    public void g(int i2) {
    }

    @Override // d.a.h0.a.p.c.l
    public void h(a.c cVar) {
        d.a.h0.a.e0.u.b.h(AppRuntime.getAppContext()).e(new C0723a(this, cVar));
    }
}
