package d.a.o0.e2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.o0.g0.a;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f56865g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f56866a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56867b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.o0.e2.k.d.a f56868c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.o0.g0.b f56869d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f56870e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f56871f = new b();

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: d.a.o0.e2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1317a implements Runnable {
            public RunnableC1317a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g(false);
            }
        }

        /* loaded from: classes5.dex */
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

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            if (!c.this.f56868c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f56868c.k().t(new RunnableC1317a());
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            if (!c.this.f56868c.l() || c.this.e() || !c.this.f56868c.k().h() || Math.abs(i3) <= c.f56865g) {
                return;
            }
            c.this.f56868c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56869d.c(motionEvent);
            return false;
        }
    }

    public c(d.a.o0.e2.k.d.a aVar) {
        this.f56868c = aVar;
        d.a.o0.g0.b bVar = new d.a.o0.g0.b(aVar.f56850f.getPageContext().getPageActivity());
        this.f56869d = bVar;
        bVar.d(this.f56870e);
    }

    public void d() {
        d k = this.f56868c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f56871f);
        }
    }

    public boolean e() {
        return this.f56866a;
    }

    public boolean f() {
        return this.f56867b;
    }

    public void g(boolean z) {
        this.f56866a = z;
    }

    public void h(boolean z) {
        this.f56867b = z;
    }
}
