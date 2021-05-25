package d.a.l0.a.r1.o;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.r1.o.a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44549d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public b f44550a;

    /* renamed from: b  reason: collision with root package name */
    public long f44551b;

    /* renamed from: c  reason: collision with root package name */
    public long f44552c;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (c.this.l()) {
                c.this.m();
                return true;
            }
            c.this.n();
            return true;
        }
    }

    public c() {
        if (l()) {
            this.f44550a = new b();
        }
    }

    @Override // d.a.l0.a.r1.o.a
    public void a(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        bVar.f(j - this.f44551b);
    }

    @Override // d.a.l0.a.r1.k.e
    public void b(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        this.f44551b = j;
        bVar.e();
    }

    @Override // d.a.l0.a.r1.k.e
    public void c(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        this.f44552c = j;
        bVar.l(this.f44551b, j);
        this.f44550a.a();
    }

    @Override // d.a.l0.a.r1.o.a
    public void e(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        bVar.h(j - this.f44551b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void f(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        bVar.i(j - this.f44551b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void g(long j) {
        b bVar;
        if (!l() || (bVar = this.f44550a) == null) {
            return;
        }
        bVar.g(j - this.f44551b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void h(View view) {
        if (!f44549d || view == null) {
            return;
        }
        view.setOnLongClickListener(new a());
    }

    public final boolean l() {
        if (f44549d) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }

    public final void m() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        b bVar = this.f44550a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void n() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.f44550a == null) {
            this.f44550a = new b();
        }
        this.f44550a.k();
    }
}
