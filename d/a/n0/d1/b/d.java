package d.a.n0.d1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.m.e;
import d.a.n0.g0.a;
import d.a.n0.k2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f56230b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.g0.a f56234f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56229a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f56231c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56232d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56233e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56235g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f56230b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            d.this.f56233e = false;
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            d.this.f56233e = true;
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56230b = new i(tbPageContext, bdTypeListView);
        d.a.n0.g0.a aVar = new d.a.n0.g0.a();
        this.f56234f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f56230b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f56230b.q(!z);
        e.a().removeCallbacks(this.f56235g);
        if (z) {
            this.f56230b.x();
        } else {
            e.a().postDelayed(this.f56235g, 200L);
        }
    }

    public void e(int i2, int i3) {
        this.f56231c = i2;
        this.f56232d = (i2 + i3) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.a.n0.g0.a aVar = this.f56234f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f56230b;
        if (iVar == null || !this.f56229a) {
            return;
        }
        iVar.m(this.f56231c, this.f56232d, this.f56233e, 1);
    }

    public void h(boolean z) {
        this.f56229a = z;
    }

    public void i() {
        this.f56230b.w();
        this.f56229a = false;
    }
}
