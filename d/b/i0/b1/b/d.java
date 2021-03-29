package d.b.i0.b1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.e.m.e;
import d.b.i0.f0.a;
import d.b.i0.i2.i;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f52083b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f0.a f52087f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52082a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f52084c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f52085d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52086e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f52088g = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f52083b.o();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            d.this.f52086e = false;
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            d.this.f52086e = true;
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f52083b = new i(tbPageContext, bdTypeListView);
        d.b.i0.f0.a aVar = new d.b.i0.f0.a();
        this.f52087f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f52083b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f52083b.q(!z);
        e.a().removeCallbacks(this.f52088g);
        if (z) {
            this.f52083b.x();
        } else {
            e.a().postDelayed(this.f52088g, 200L);
        }
    }

    public void e(int i, int i2) {
        this.f52084c = i;
        this.f52085d = (i + i2) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.b.i0.f0.a aVar = this.f52087f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f52083b;
        if (iVar == null || !this.f52082a) {
            return;
        }
        iVar.m(this.f52084c, this.f52085d, this.f52086e, 1);
    }

    public void h(boolean z) {
        this.f52082a = z;
    }

    public void i() {
        this.f52083b.w();
        this.f52082a = false;
    }
}
