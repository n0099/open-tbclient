package d.a.j0.c1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.m.e;
import d.a.j0.f0.a;
import d.a.j0.j2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f51662b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.f0.a f51666f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51661a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f51663c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51664d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51665e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f51667g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f51662b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.j0.f0.a.b
        public void a(int i2, int i3) {
            d.this.f51665e = false;
        }

        @Override // d.a.j0.f0.a.b
        public void b(int i2, int i3) {
            d.this.f51665e = true;
        }

        @Override // d.a.j0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.j0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f51662b = new i(tbPageContext, bdTypeListView);
        d.a.j0.f0.a aVar = new d.a.j0.f0.a();
        this.f51666f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f51662b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f51662b.q(!z);
        e.a().removeCallbacks(this.f51667g);
        if (z) {
            this.f51662b.x();
        } else {
            e.a().postDelayed(this.f51667g, 200L);
        }
    }

    public void e(int i2, int i3) {
        this.f51663c = i2;
        this.f51664d = (i2 + i3) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.a.j0.f0.a aVar = this.f51666f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f51662b;
        if (iVar == null || !this.f51661a) {
            return;
        }
        iVar.m(this.f51663c, this.f51664d, this.f51665e, 1);
    }

    public void h(boolean z) {
        this.f51661a = z;
    }

    public void i() {
        this.f51662b.w();
        this.f51661a = false;
    }
}
