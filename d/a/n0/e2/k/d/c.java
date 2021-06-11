package d.a.n0.e2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.g0.a;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f56740g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f56741a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56742b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.e2.k.d.a f56743c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.g0.b f56744d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f56745e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f56746f = new b();

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: d.a.n0.e2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1313a implements Runnable {
            public RunnableC1313a() {
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

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            if (!c.this.f56743c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f56743c.k().t(new RunnableC1313a());
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            if (!c.this.f56743c.l() || c.this.e() || !c.this.f56743c.k().h() || Math.abs(i3) <= c.f56740g) {
                return;
            }
            c.this.f56743c.i(new b());
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

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56744d.c(motionEvent);
            return false;
        }
    }

    public c(d.a.n0.e2.k.d.a aVar) {
        this.f56743c = aVar;
        d.a.n0.g0.b bVar = new d.a.n0.g0.b(aVar.f56725f.getPageContext().getPageActivity());
        this.f56744d = bVar;
        bVar.d(this.f56745e);
    }

    public void d() {
        d k = this.f56743c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f56746f);
        }
    }

    public boolean e() {
        return this.f56741a;
    }

    public boolean f() {
        return this.f56742b;
    }

    public void g(boolean z) {
        this.f56741a = z;
    }

    public void h(boolean z) {
        this.f56742b = z;
    }
}
