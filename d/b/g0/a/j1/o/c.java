package d.b.g0.a.j1.o;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class c implements d.b.g0.a.j1.o.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44942e = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public b f44943b;

    /* renamed from: c  reason: collision with root package name */
    public long f44944c;

    /* renamed from: d  reason: collision with root package name */
    public long f44945d;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (c.this.k()) {
                c.this.l();
                return true;
            }
            c.this.m();
            return true;
        }
    }

    public c() {
        if (k()) {
            this.f44943b = new b();
        }
    }

    @Override // d.b.g0.a.j1.o.a
    public void a(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        bVar.f(j - this.f44944c);
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        this.f44944c = j;
        bVar.e();
    }

    @Override // d.b.g0.a.j1.o.a
    public void c(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        bVar.i(j - this.f44944c);
    }

    @Override // d.b.g0.a.j1.o.a
    public void d(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        bVar.g(j - this.f44944c);
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        this.f44945d = j;
        bVar.l(this.f44944c, j);
        this.f44943b.a();
    }

    @Override // d.b.g0.a.j1.o.a
    public void f(View view) {
        if (!f44942e || view == null) {
            return;
        }
        view.setOnLongClickListener(new a());
    }

    @Override // d.b.g0.a.j1.o.a
    public void g(long j) {
        b bVar;
        if (!k() || (bVar = this.f44943b) == null) {
            return;
        }
        bVar.h(j - this.f44944c);
    }

    public final boolean k() {
        if (f44942e) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }

    public final void l() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        b bVar = this.f44943b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void m() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.f44943b == null) {
            this.f44943b = new b();
        }
        this.f44943b.k();
    }
}
