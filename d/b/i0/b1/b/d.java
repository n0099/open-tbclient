package d.b.i0.b1.b;

import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.e.m.e;
import d.b.i0.f0.a;
import d.b.i0.i2.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public i f52082b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f0.a f52086f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52081a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f52083c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f52084d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52085e = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f52087g = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f52082b.o();
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
            d.this.f52085e = false;
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            d.this.f52085e = true;
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f52082b = new i(tbPageContext, bdTypeListView);
        d.b.i0.f0.a aVar = new d.b.i0.f0.a();
        this.f52086f = aVar;
        aVar.d(new b());
    }

    public void c() {
        i iVar = this.f52082b;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void d(boolean z) {
        this.f52082b.q(!z);
        e.a().removeCallbacks(this.f52087g);
        if (z) {
            this.f52082b.x();
        } else {
            e.a().postDelayed(this.f52087g, 200L);
        }
    }

    public void e(int i, int i2) {
        this.f52083c = i;
        this.f52084d = (i + i2) - 1;
    }

    public void f(MotionEvent motionEvent) {
        d.b.i0.f0.a aVar = this.f52086f;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void g() {
        i iVar = this.f52082b;
        if (iVar == null || !this.f52081a) {
            return;
        }
        iVar.m(this.f52083c, this.f52084d, this.f52085e, 1);
    }

    public void h(boolean z) {
        this.f52081a = z;
    }

    public void i() {
        this.f52082b.w();
        this.f52081a = false;
    }
}
