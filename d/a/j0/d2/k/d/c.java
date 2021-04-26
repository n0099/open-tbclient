package d.a.j0.d2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.f0.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f52146g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f52147a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52148b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.j0.d2.k.d.a f52149c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.j0.f0.b f52150d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f52151e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f52152f = new b();

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: d.a.j0.d2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1167a implements Runnable {
            public RunnableC1167a() {
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

        @Override // d.a.j0.f0.a.b
        public void a(int i2, int i3) {
            if (!c.this.f52149c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f52149c.k().t(new RunnableC1167a());
        }

        @Override // d.a.j0.f0.a.b
        public void b(int i2, int i3) {
            if (!c.this.f52149c.l() || c.this.e() || !c.this.f52149c.k().h() || Math.abs(i3) <= c.f52146g) {
                return;
            }
            c.this.f52149c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.a.j0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.j0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f52150d.c(motionEvent);
            return false;
        }
    }

    public c(d.a.j0.d2.k.d.a aVar) {
        this.f52149c = aVar;
        d.a.j0.f0.b bVar = new d.a.j0.f0.b(aVar.f52131f.getPageContext().getPageActivity());
        this.f52150d = bVar;
        bVar.d(this.f52151e);
    }

    public void d() {
        d k = this.f52149c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f52152f);
        }
    }

    public boolean e() {
        return this.f52147a;
    }

    public boolean f() {
        return this.f52148b;
    }

    public void g(boolean z) {
        this.f52147a = z;
    }

    public void h(boolean z) {
        this.f52148b = z;
    }
}
