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
    public i f52541b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.g0.a f52545f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52540a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f52542c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f52543d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52544e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f52546g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f52541b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            d.this.f52544e = false;
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            d.this.f52544e = true;
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f52541b = new i(tbPageContext, bdTypeListView);
        d.a.n0.g0.a aVar = new d.a.n0.g0.a();
        this.f52545f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f52541b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f52541b.q(!z);
        e.a().removeCallbacks(this.f52546g);
        if (z) {
            this.f52541b.x();
        } else {
            e.a().postDelayed(this.f52546g, 200L);
        }
    }

    public void e(int i2, int i3) {
        this.f52542c = i2;
        this.f52543d = (i2 + i3) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.a.n0.g0.a aVar = this.f52545f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f52541b;
        if (iVar == null || !this.f52540a) {
            return;
        }
        iVar.m(this.f52542c, this.f52543d, this.f52544e, 1);
    }

    public void h(boolean z) {
        this.f52540a = z;
    }

    public void i() {
        this.f52541b.w();
        this.f52540a = false;
    }
}
