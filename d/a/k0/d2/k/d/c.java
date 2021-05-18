package d.a.k0.d2.k.d;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.k0.f0.a;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static final int f52845g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: a  reason: collision with root package name */
    public boolean f52846a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52847b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.k0.d2.k.d.a f52848c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.k0.f0.b f52849d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f52850e = new a();

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f52851f = new b();

    /* loaded from: classes4.dex */
    public class a implements a.b {

        /* renamed from: d.a.k0.d2.k.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1239a implements Runnable {
            public RunnableC1239a() {
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

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            if (!c.this.f52848c.l() || c.this.e() || c.this.f()) {
                return;
            }
            c.this.g(true);
            c.this.h(true);
            c.this.f52848c.k().t(new RunnableC1239a());
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            if (!c.this.f52848c.l() || c.this.e() || !c.this.f52848c.k().h() || Math.abs(i3) <= c.f52845g) {
                return;
            }
            c.this.f52848c.i(new b());
            c.this.g(true);
            c.this.h(false);
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f52849d.c(motionEvent);
            return false;
        }
    }

    public c(d.a.k0.d2.k.d.a aVar) {
        this.f52848c = aVar;
        d.a.k0.f0.b bVar = new d.a.k0.f0.b(aVar.f52830f.getPageContext().getPageActivity());
        this.f52849d = bVar;
        bVar.d(this.f52850e);
    }

    public void d() {
        d k = this.f52848c.k();
        if (k.m()) {
            k.e().setOnTouchListener(this.f52851f);
        }
    }

    public boolean e() {
        return this.f52846a;
    }

    public boolean f() {
        return this.f52847b;
    }

    public void g(boolean z) {
        this.f52846a = z;
    }

    public void h(boolean z) {
        this.f52847b = z;
    }
}
