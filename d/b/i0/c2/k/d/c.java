package d.b.i0.c2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f52542g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f52543a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52544b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.c2.k.d.a f52545c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.f0.b f52546d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f52547e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f52548f = new b();

    /* loaded from: classes4.dex */
    public class a implements a.b {

        /* renamed from: d.b.i0.c2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1148a implements Runnable {
            public RunnableC1148a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g(false);
            }
        }

        /* loaded from: classes4.dex */
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
            if (!c.this.f52545c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f52545c.k().t(new RunnableC1148a());
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            if (!c.this.f52545c.l() || c.this.e() || !c.this.f52545c.k().h() || Math.abs(i2) <= c.f52542g) {
                return;
            }
            c.this.f52545c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f52546d.c(motionEvent);
            return false;
        }
    }

    public c(d.b.i0.c2.k.d.a aVar) {
        this.f52545c = aVar;
        d.b.i0.f0.b bVar = new d.b.i0.f0.b(aVar.f52528f.getPageContext().getPageActivity());
        this.f52546d = bVar;
        bVar.d(this.f52547e);
    }

    public void d() {
        d k = this.f52545c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f52548f);
        }
    }

    public boolean e() {
        return this.f52543a;
    }

    public boolean f() {
        return this.f52544b;
    }

    public void g(boolean z) {
        this.f52543a = z;
    }

    public void h(boolean z) {
        this.f52544b = z;
    }
}
