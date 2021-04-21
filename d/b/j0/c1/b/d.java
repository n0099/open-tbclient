package d.b.j0.c1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.e.m.e;
import d.b.j0.f0.a;
import d.b.j0.j2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f53905b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.f0.a f53909f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53904a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f53906c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f53907d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53908e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f53910g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f53905b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.j0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void b(int i, int i2) {
            d.this.f53908e = false;
        }

        @Override // d.b.j0.f0.a.b
        public void c(int i, int i2) {
            d.this.f53908e = true;
        }

        @Override // d.b.j0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f53905b = new i(tbPageContext, bdTypeListView);
        d.b.j0.f0.a aVar = new d.b.j0.f0.a();
        this.f53909f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f53905b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f53905b.q(!z);
        e.a().removeCallbacks(this.f53910g);
        if (z) {
            this.f53905b.x();
        } else {
            e.a().postDelayed(this.f53910g, 200L);
        }
    }

    public void e(int i, int i2) {
        this.f53906c = i;
        this.f53907d = (i + i2) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.b.j0.f0.a aVar = this.f53909f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f53905b;
        if (iVar == null || !this.f53904a) {
            return;
        }
        iVar.m(this.f53906c, this.f53907d, this.f53908e, 1);
    }

    public void h(boolean z) {
        this.f53904a = z;
    }

    public void i() {
        this.f53905b.w();
        this.f53904a = false;
    }
}
