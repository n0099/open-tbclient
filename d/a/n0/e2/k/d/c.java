package d.a.n0.e2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.g0.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f53051g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f53052a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53053b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.e2.k.d.a f53054c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.g0.b f53055d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f53056e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f53057f = new b();

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: d.a.n0.e2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1257a implements Runnable {
            public RunnableC1257a() {
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

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            if (!c.this.f53054c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f53054c.k().t(new RunnableC1257a());
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            if (!c.this.f53054c.l() || c.this.e() || !c.this.f53054c.k().h() || Math.abs(i3) <= c.f53051g) {
                return;
            }
            c.this.f53054c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f53055d.c(motionEvent);
            return false;
        }
    }

    public c(d.a.n0.e2.k.d.a aVar) {
        this.f53054c = aVar;
        d.a.n0.g0.b bVar = new d.a.n0.g0.b(aVar.f53036f.getPageContext().getPageActivity());
        this.f53055d = bVar;
        bVar.d(this.f53056e);
    }

    public void d() {
        d k = this.f53054c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f53057f);
        }
    }

    public boolean e() {
        return this.f53052a;
    }

    public boolean f() {
        return this.f53053b;
    }

    public void g(boolean z) {
        this.f53052a = z;
    }

    public void h(boolean z) {
        this.f53053b = z;
    }
}
