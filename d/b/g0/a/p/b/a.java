package d.b.g0.a.p.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import d.b.g0.a.e0.k.d.a;
import d.b.g0.a.e0.u.b;
/* loaded from: classes2.dex */
public class a implements d.b.g0.a.p.c.l {

    /* renamed from: d.b.g0.a.p.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0752a implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f45433a;

        public C0752a(a aVar, a.c cVar) {
            this.f45433a = cVar;
        }

        @Override // d.b.g0.a.e0.u.b.c
        public void a() {
            a.c cVar = this.f45433a;
            if (cVar != null) {
                cVar.a();
            }
            d.b.g0.a.e0.u.b.h(AppRuntime.getAppContext()).f(this);
        }
    }

    @Override // d.b.g0.a.p.c.l
    public void a(boolean z) {
        if (z) {
            d.b.g0.a.e0.u.b.h(AppRuntime.getAppContext()).k(ProcessUtils.isMainProcess());
        } else {
            d.b.g0.a.e0.u.b.h(AppRuntime.getAppContext()).i();
        }
    }

    @Override // d.b.g0.a.p.c.l
    public int b() {
        return 10150;
    }

    @Override // d.b.g0.a.p.c.l
    public VideoPlayerFactory c() {
        return null;
    }

    @Override // d.b.g0.a.p.c.l
    public boolean d() {
        return false;
    }

    @Override // d.b.g0.a.p.c.l
    public int e() {
        return 5000;
    }

    @Override // d.b.g0.a.p.c.l
    public boolean f() {
        return true;
    }

    @Override // d.b.g0.a.p.c.l
    public void g(int i) {
    }

    @Override // d.b.g0.a.p.c.l
    public void h(a.c cVar) {
        d.b.g0.a.e0.u.b.h(AppRuntime.getAppContext()).e(new C0752a(this, cVar));
    }
}
