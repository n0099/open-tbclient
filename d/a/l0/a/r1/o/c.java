package d.a.l0.a.r1.o;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.r1.o.a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48223d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public b f48224a;

    /* renamed from: b  reason: collision with root package name */
    public long f48225b;

    /* renamed from: c  reason: collision with root package name */
    public long f48226c;

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
            this.f48224a = new b();
        }
    }

    @Override // d.a.l0.a.r1.o.a
    public void a(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        bVar.f(j - this.f48225b);
    }

    @Override // d.a.l0.a.r1.k.e
    public void b(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        this.f48225b = j;
        bVar.e();
    }

    @Override // d.a.l0.a.r1.k.e
    public void c(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        this.f48226c = j;
        bVar.l(this.f48225b, j);
        this.f48224a.a();
    }

    @Override // d.a.l0.a.r1.o.a
    public void e(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        bVar.h(j - this.f48225b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void f(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        bVar.i(j - this.f48225b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void g(long j) {
        b bVar;
        if (!l() || (bVar = this.f48224a) == null) {
            return;
        }
        bVar.g(j - this.f48225b);
    }

    @Override // d.a.l0.a.r1.o.a
    public void h(View view) {
        if (!f48223d || view == null) {
            return;
        }
        view.setOnLongClickListener(new a());
    }

    public final boolean l() {
        if (f48223d) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }

    public final void m() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        b bVar = this.f48224a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void n() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.f48224a == null) {
            this.f48224a = new b();
        }
        this.f48224a.k();
    }
}
