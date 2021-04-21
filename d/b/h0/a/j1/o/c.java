package d.b.h0.a.j1.o;

import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class c implements d.b.h0.a.j1.o.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45664e = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public b f45665b;

    /* renamed from: c  reason: collision with root package name */
    public long f45666c;

    /* renamed from: d  reason: collision with root package name */
    public long f45667d;

    /* loaded from: classes2.dex */
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
            this.f45665b = new b();
        }
    }

    @Override // d.b.h0.a.j1.o.a
    public void a(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        bVar.f(j - this.f45666c);
    }

    @Override // d.b.h0.a.j1.l.e
    public void b(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        this.f45666c = j;
        bVar.e();
    }

    @Override // d.b.h0.a.j1.o.a
    public void c(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        bVar.i(j - this.f45666c);
    }

    @Override // d.b.h0.a.j1.o.a
    public void d(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        bVar.g(j - this.f45666c);
    }

    @Override // d.b.h0.a.j1.l.e
    public void e(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        this.f45667d = j;
        bVar.l(this.f45666c, j);
        this.f45665b.a();
    }

    @Override // d.b.h0.a.j1.o.a
    public void f(View view) {
        if (!f45664e || view == null) {
            return;
        }
        view.setOnLongClickListener(new a());
    }

    @Override // d.b.h0.a.j1.o.a
    public void g(long j) {
        b bVar;
        if (!k() || (bVar = this.f45665b) == null) {
            return;
        }
        bVar.h(j - this.f45666c);
    }

    public final boolean k() {
        if (f45664e) {
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return false;
    }

    public final void l() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
        b bVar = this.f45665b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void m() {
        AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
        if (this.f45665b == null) {
            this.f45665b = new b();
        }
        this.f45665b.k();
    }
}
