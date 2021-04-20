package d.b.i0.c1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.e.m.e;
import d.b.i0.f0.a;
import d.b.i0.j2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f53484b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f0.a f53488f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53483a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f53485c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f53486d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53487e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f53489g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f53484b.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            d.this.f53487e = false;
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            d.this.f53487e = true;
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f53484b = new i(tbPageContext, bdTypeListView);
        d.b.i0.f0.a aVar = new d.b.i0.f0.a();
        this.f53488f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f53484b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f53484b.q(!z);
        e.a().removeCallbacks(this.f53489g);
        if (z) {
            this.f53484b.x();
        } else {
            e.a().postDelayed(this.f53489g, 200L);
        }
    }

    public void e(int i, int i2) {
        this.f53485c = i;
        this.f53486d = (i + i2) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.b.i0.f0.a aVar = this.f53488f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f53484b;
        if (iVar == null || !this.f53483a) {
            return;
        }
        iVar.m(this.f53485c, this.f53486d, this.f53487e, 1);
    }

    public void h(boolean z) {
        this.f53483a = z;
    }

    public void i() {
        this.f53484b.w();
        this.f53483a = false;
    }
}
