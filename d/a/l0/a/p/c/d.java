package d.a.l0.a.p.c;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import d.a.l0.a.h0.f.d.a;
import d.a.l0.a.h0.s.b;
/* loaded from: classes2.dex */
public class d implements d.a.l0.a.p.d.t {

    /* loaded from: classes2.dex */
    public class a implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f43954a;

        public a(d dVar, a.c cVar) {
            this.f43954a = cVar;
        }

        @Override // d.a.l0.a.h0.s.b.c
        public void a() {
            a.c cVar = this.f43954a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    @Override // d.a.l0.a.p.d.t
    public int a() {
        return 10150;
    }

    @Override // d.a.l0.a.p.d.t
    public VideoPlayerFactory b() {
        return null;
    }

    @Override // d.a.l0.a.p.d.t
    public int c() {
        return 5000;
    }

    @Override // d.a.l0.a.p.d.t
    public void d(boolean z) {
        if (z) {
            d.a.l0.a.h0.s.b.g(AppRuntime.getAppContext()).j(ProcessUtils.isMainProcess());
        } else {
            d.a.l0.a.h0.s.b.g(AppRuntime.getAppContext()).h();
        }
    }

    @Override // d.a.l0.a.p.d.t
    public boolean e() {
        return false;
    }

    @Override // d.a.l0.a.p.d.t
    public boolean f() {
        return true;
    }

    @Override // d.a.l0.a.p.d.t
    public void g(int i2) {
    }

    @Override // d.a.l0.a.p.d.t
    public void h(a.c cVar) {
        d.a.l0.a.h0.s.b.g(AppRuntime.getAppContext()).e(new a(this, cVar));
    }
}
