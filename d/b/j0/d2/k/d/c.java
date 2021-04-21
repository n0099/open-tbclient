package d.b.j0.d2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.j0.f0.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f54358g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f54359a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54360b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.j0.d2.k.d.a f54361c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.j0.f0.b f54362d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f54363e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f54364f = new b();

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: d.b.j0.d2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1228a implements Runnable {
            public RunnableC1228a() {
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

        @Override // d.b.j0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void b(int i, int i2) {
            if (!c.this.f54361c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f54361c.k().t(new RunnableC1228a());
        }

        @Override // d.b.j0.f0.a.b
        public void c(int i, int i2) {
            if (!c.this.f54361c.l() || c.this.e() || !c.this.f54361c.k().h() || Math.abs(i2) <= c.f54358g) {
                return;
            }
            c.this.f54361c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.b.j0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f54362d.c(motionEvent);
            return false;
        }
    }

    public c(d.b.j0.d2.k.d.a aVar) {
        this.f54361c = aVar;
        d.b.j0.f0.b bVar = new d.b.j0.f0.b(aVar.f54344f.getPageContext().getPageActivity());
        this.f54362d = bVar;
        bVar.d(this.f54363e);
    }

    public void d() {
        d k = this.f54361c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f54364f);
        }
    }

    public boolean e() {
        return this.f54359a;
    }

    public boolean f() {
        return this.f54360b;
    }

    public void g(boolean z) {
        this.f54359a = z;
    }

    public void h(boolean z) {
        this.f54360b = z;
    }
}
