package d.a.k0.c1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.m.e;
import d.a.k0.f0.a;
import d.a.k0.j2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f52361b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.f0.a f52365f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52360a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f52362c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f52363d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52364e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f52366g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f52361b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            d.this.f52364e = false;
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            d.this.f52364e = true;
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f52361b = new i(tbPageContext, bdTypeListView);
        d.a.k0.f0.a aVar = new d.a.k0.f0.a();
        this.f52365f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f52361b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f52361b.q(!z);
        e.a().removeCallbacks(this.f52366g);
        if (z) {
            this.f52361b.x();
        } else {
            e.a().postDelayed(this.f52366g, 200L);
        }
    }

    public void e(int i2, int i3) {
        this.f52362c = i2;
        this.f52363d = (i2 + i3) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.a.k0.f0.a aVar = this.f52365f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f52361b;
        if (iVar == null || !this.f52360a) {
            return;
        }
        iVar.m(this.f52362c, this.f52363d, this.f52364e, 1);
    }

    public void h(boolean z) {
        this.f52360a = z;
    }

    public void i() {
        this.f52361b.w();
        this.f52360a = false;
    }
}
