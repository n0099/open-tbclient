package d.b.i0.d2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.f0.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f53937g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f53938a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53939b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.d2.k.d.a f53940c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.f0.b f53941d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f53942e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f53943f = new b();

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: d.b.i0.d2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1205a implements Runnable {
            public RunnableC1205a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g(false);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g(false);
            }
        }

        public a() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            if (!c.this.f53940c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f53940c.k().t(new RunnableC1205a());
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (!c.this.f53940c.l() || c.this.e() || !c.this.f53940c.k().h() || Math.abs(i2) <= c.f53937g) {
                return;
            }
            c.this.f53940c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f53941d.c(motionEvent);
            return false;
        }
    }

    public c(d.b.i0.d2.k.d.a aVar) {
        this.f53940c = aVar;
        d.b.i0.f0.b bVar = new d.b.i0.f0.b(aVar.f53923f.getPageContext().getPageActivity());
        this.f53941d = bVar;
        bVar.d(this.f53942e);
    }

    public void d() {
        d k = this.f53940c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f53943f);
        }
    }

    public boolean e() {
        return this.f53938a;
    }

    public boolean f() {
        return this.f53939b;
    }

    public void g(boolean z) {
        this.f53938a = z;
    }

    public void h(boolean z) {
        this.f53939b = z;
    }
}
