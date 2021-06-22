package d.a.o0.d1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.m.e;
import d.a.o0.g0.a;
import d.a.o0.k2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f56355b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.g0.a f56359f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56354a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f56356c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56357d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56358e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56360g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f56355b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            d.this.f56358e = false;
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            d.this.f56358e = true;
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56355b = new i(tbPageContext, bdTypeListView);
        d.a.o0.g0.a aVar = new d.a.o0.g0.a();
        this.f56359f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f56355b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f56355b.q(!z);
        e.a().removeCallbacks(this.f56360g);
        if (z) {
            this.f56355b.x();
        } else {
            e.a().postDelayed(this.f56360g, 200L);
        }
    }

    public void e(int i2, int i3) {
        this.f56356c = i2;
        this.f56357d = (i2 + i3) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.a.o0.g0.a aVar = this.f56359f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f56355b;
        if (iVar == null || !this.f56354a) {
            return;
        }
        iVar.m(this.f56356c, this.f56357d, this.f56358e, 1);
    }

    public void h(boolean z) {
        this.f56354a = z;
    }

    public void i() {
        this.f56355b.w();
        this.f56354a = false;
    }
}
