package d.a.h0.a.j1.o;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class c implements d.a.h0.a.j1.o.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42989e = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public b f42990b;

    /* renamed from: c  reason: collision with root package name */
    public long f42991c;

    /* renamed from: d  reason: collision with root package name */
    public long f42992d;

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
            this.f42990b = new b();
        }
    }

    @Override // d.a.h0.a.j1.o.a
    public void a(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        bVar.f(j - this.f42991c);
    }

    @Override // d.a.h0.a.j1.l.e
    public void b(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        this.f42991c = j;
        bVar.e();
    }

    @Override // d.a.h0.a.j1.l.e
    public void c(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        this.f42992d = j;
        bVar.l(this.f42991c, j);
        this.f42990b.a();
    }

    @Override // d.a.h0.a.j1.o.a
    public void d(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        bVar.h(j - this.f42991c);
    }

    @Override // d.a.h0.a.j1.o.a
    public void e(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        bVar.i(j - this.f42991c);
    }

    @Override // d.a.h0.a.j1.o.a
    public void f(long j) {
        b bVar;
        if (!k() || (bVar = this.f42990b) == null) {
            return;
        }
        bVar.g(j - this.f42991c);
    }

    @Override // d.a.h0.a.j1.o.a
    public void g(View view) {
        if (!f42989e || view == null) {
            return;
        }
        view.setOnLongClickListener(new a());
    }

    public final boolean k() {
        if (f42989e) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }

    public final void l() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        b bVar = this.f42990b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void m() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.f42990b == null) {
            this.f42990b = new b();
        }
        this.f42990b.k();
    }
}
