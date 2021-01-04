package com.qq.e.comm.plugin.gdtnativead.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.qq.e.comm.plugin.aa.b.c;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.aa.b.e;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.aa.b.g;
import com.qq.e.comm.plugin.ac.h;
import com.qq.e.comm.plugin.util.ak;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c extends FrameLayout implements com.qq.e.comm.plugin.aa.b.b, c.a {
    private View A;
    private View.OnClickListener B;
    private View.OnClickListener C;
    private View.OnClickListener D;
    private View.OnClickListener E;
    private f.a F;
    private final Handler G;

    /* renamed from: a  reason: collision with root package name */
    private e f12303a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.aa.b.c f12304b;
    private boolean c;
    private boolean d;
    private int e;
    private a f;
    private FrameLayout g;
    private FrameLayout h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private h m;
    private Context n;
    private ImageView o;
    private String p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* loaded from: classes3.dex */
    public interface a extends d.a {
        void b(boolean z);

        void j_();
    }

    /* loaded from: classes3.dex */
    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<c> f12312a;

        public b(c cVar) {
            this.f12312a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.f12312a.get();
            if (cVar != null) {
                switch (message.what) {
                    case 10001:
                        if (cVar.f12303a != null && cVar.f12303a.c()) {
                            cVar.d();
                            return;
                        }
                        Message obtainMessage = obtainMessage(10001);
                        removeMessages(10001);
                        sendMessageDelayed(obtainMessage, IMConnection.RETRY_DELAY_TIMES);
                        return;
                    case 10002:
                        cVar.t();
                        if (cVar.f12303a == null || !cVar.f12303a.c()) {
                            return;
                        }
                        sendMessageDelayed(obtainMessage(10002), 500L);
                        return;
                    case 10003:
                        cVar.setEnabled(false);
                        return;
                    case 10004:
                        cVar.s();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public c(Context context, int i, String str) {
        this(context, i, str, true, true);
    }

    public c(Context context, int i, String str, boolean z, boolean z2) {
        super(context);
        this.z = true;
        this.B = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f != null) {
                    c.this.f.j_();
                }
            }
        };
        this.C = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f != null) {
                    c.this.f.i_();
                }
            }
        };
        this.D = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.q();
            }
        };
        this.E = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f != null && c.this.f12303a != null) {
                    c.this.f.b(c.this.f12303a.c());
                }
                if (c.this.d) {
                    return;
                }
                c.this.r();
                c.this.a(3000, false);
            }
        };
        this.F = new f.a() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.5
            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void a() {
                if (c.this.f != null) {
                    c.this.f.b_();
                }
                c.this.j.setVisibility(0);
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void a(int i2, Exception exc) {
                c.this.G.sendEmptyMessage(10003);
                if (c.this.f != null) {
                    c.this.f.a(i2, exc);
                }
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void b() {
                c.this.G.sendEmptyMessage(10002);
                if (c.this.o != null) {
                    c.this.o.setVisibility(4);
                }
                if (c.this.f != null) {
                    c.this.f.c_();
                }
                c.this.s();
                c.this.e();
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void c() {
                c.this.G.removeMessages(10002);
                if (c.this.m != null) {
                    c.this.m.a(100);
                }
                if (c.this.f != null) {
                    c.this.f.f_();
                }
                if (c.this.o != null && c.this.x) {
                    c.this.o.setVisibility(0);
                }
                c.this.d(true);
                c.this.j.setVisibility(4);
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void d() {
                c.this.G.removeMessages(10002);
                if (c.this.m != null) {
                    c.this.m.a(100);
                }
                if (c.this.o != null && c.this.x) {
                    c.this.o.setVisibility(0);
                }
                if (c.this.f != null) {
                    c.this.f.g_();
                }
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void e() {
                c.this.G.removeMessages(10002);
                if (c.this.f != null) {
                    c.this.f.h_();
                }
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void f() {
                c.this.G.sendEmptyMessage(10002);
                c.this.s();
                if (c.this.f != null) {
                    c.this.f.g();
                }
            }
        };
        this.G = new b(this);
        this.p = str;
        this.e = i;
        this.w = z;
        this.x = z2;
        this.n = context.getApplicationContext();
        m();
        n();
    }

    private void m() {
        this.q = ak.a(this.n, 12);
        this.r = ak.a(this.n, 12);
        this.s = ak.a(this.n, 24) + (this.q * 2);
        this.t = ak.a(this.n, 30) + (this.r * 2);
        this.u = ak.a(this.n, 46);
        this.v = ak.a(this.n, 56);
    }

    private void n() {
        this.f12304b = new com.qq.e.comm.plugin.aa.b.c(getContext());
        this.f12304b.setBackgroundColor(0);
        addView(this.f12304b, 0);
        this.f12304b.a(this);
        this.g = new FrameLayout(getContext());
        this.f12304b.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        o();
        p();
    }

    private void o() {
        if (this.m == null) {
            this.m = new h(getContext());
            this.m.b(100);
        }
        this.m.setVisibility(this.w ? 0 : 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ak.a(this.n, 3));
        layoutParams.gravity = 80;
        this.g.addView(this.m, layoutParams);
    }

    private void p() {
        if (this.h == null) {
            this.h = new FrameLayout(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Integer.MIN_VALUE, 1073741824, 0});
            gradientDrawable.setShape(0);
            this.h.setBackgroundDrawable(gradientDrawable);
            this.h.setPadding(0, 0, 0, this.q);
        }
        this.g.addView(this.h, new FrameLayout.LayoutParams(-1, -2));
        this.h.setVisibility(4);
        if (this.k == null) {
            this.k = new ImageView(getContext());
            this.k.setImageBitmap(g.i(this.n));
            this.k.setOnClickListener(this.C);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.s, this.s);
        layoutParams.gravity = 53;
        this.k.setPadding(this.q / 2, this.q, this.q, this.q);
        this.k.setLayoutParams(layoutParams);
        this.h.addView(this.k);
        if (this.j == null) {
            this.j = new ImageView(getContext());
            this.j.setImageBitmap(g.g(this.n));
            this.j.setOnClickListener(this.D);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.s, this.s);
        layoutParams2.gravity = 53;
        layoutParams2.rightMargin = this.s;
        this.j.setPadding(this.q, this.q, this.q / 2, this.q);
        this.j.setLayoutParams(layoutParams2);
        this.h.addView(this.j);
        if (this.o == null && this.p != null) {
            this.o = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            this.g.addView(this.o, layoutParams3);
            com.qq.e.comm.plugin.p.a.a().a(this.p, this.o);
        }
        if (this.o != null) {
            this.o.setVisibility(this.x ? 0 : 4);
        }
        if (this.i == null) {
            this.i = new ImageView(getContext());
            this.i.setImageBitmap(g.e(this.n));
            this.i.setOnClickListener(this.B);
        }
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.s, this.s);
        layoutParams4.gravity = 51;
        this.i.setPadding(this.q, this.q, this.q, this.q);
        this.i.setLayoutParams(layoutParams4);
        this.g.addView(this.i);
        if (this.l == null) {
            this.l = new ImageView(getContext());
            this.l.setImageBitmap(g.j(this.n));
            this.l.setOnClickListener(this.E);
        }
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.u, this.u);
        layoutParams5.gravity = 17;
        this.l.setVisibility(4);
        this.g.addView(this.l, layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f12303a != null) {
            if (this.f12303a.d()) {
                this.f12303a.i();
            } else {
                this.f12303a.h();
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f12303a != null) {
            if (this.f12303a.c()) {
                this.f12303a.a();
            } else {
                this.f12303a.b();
            }
        }
        this.G.sendEmptyMessageDelayed(10004, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.l == null || this.f12303a == null) {
            return;
        }
        if (this.f12303a.c()) {
            this.l.setImageBitmap(g.k(this.n));
        } else {
            this.l.setImageBitmap(g.j(this.n));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        if (this.f12303a == null) {
            return 0;
        }
        int f = this.f12303a.f();
        int e = this.f12303a.e();
        if (this.m == null || e <= 0) {
            return f;
        }
        this.m.a((f * 100) / e);
        return f;
    }

    private void u() {
        if (this.i == null || this.j == null || this.l == null || this.k == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = this.s;
        layoutParams.height = this.s;
        this.i.setPadding(this.q, this.q, this.q, this.q);
        this.i.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.rightMargin = this.s;
        this.j.setPadding(this.q, this.q, this.q / 2, this.q);
        layoutParams2.width = this.s;
        layoutParams2.height = this.s;
        this.j.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams3.width = this.s;
        layoutParams3.height = this.s;
        this.k.setPadding(this.q / 2, this.q, this.q, this.q);
        this.k.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams4.width = this.u;
        layoutParams4.height = this.u;
        this.l.setLayoutParams(layoutParams4);
    }

    private void v() {
        if (this.i == null || this.j == null || this.l == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = this.t;
        layoutParams.height = this.t;
        this.i.setPadding(this.r, this.r, this.r, this.r);
        this.i.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.width = this.t;
        layoutParams2.height = this.t;
        layoutParams2.rightMargin = 0;
        this.j.setPadding(this.r, this.r, this.r, this.r);
        this.j.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams3.width = this.v;
        layoutParams3.height = this.v;
        this.l.setLayoutParams(layoutParams3);
    }

    public void a() {
        this.d = false;
        this.y = true;
    }

    public void a(int i) {
        this.e = i;
        if (this.e == 4) {
            v();
        } else if (this.e == 3) {
            u();
        }
    }

    public void a(int i, int i2) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 17;
        this.o.post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.o.setLayoutParams(layoutParams);
            }
        });
    }

    public void a(int i, boolean z) {
        a(i, z, 100L);
    }

    public void a(int i, boolean z, long j) {
        if (!this.c && this.l != null && this.h != null) {
            this.c = true;
            if (this.z) {
                this.l.setVisibility(0);
            }
            if (!z && !this.d) {
                this.h.setVisibility(0);
            }
        }
        this.G.sendEmptyMessageDelayed(10004, j);
        e();
        Message obtainMessage = this.G.obtainMessage(10001);
        if (i != 0) {
            this.G.removeMessages(10001);
            this.G.sendMessageDelayed(obtainMessage, i);
        }
    }

    public void a(long j) {
        a(3000, this.y, j);
    }

    public void a(d.a aVar) {
        if (aVar instanceof a) {
            this.f = (a) aVar;
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void a(e eVar) {
        this.f12303a = eVar;
        this.f12303a.a(this.F);
        s();
    }

    public void a(boolean z) {
        this.w = z;
        if (this.m != null) {
            this.m.setVisibility(z ? 0 : 4);
        }
    }

    public void a(boolean z, boolean z2) {
        this.x = z;
        if (this.o == null || !z2) {
            return;
        }
        if (!z || this.f12303a == null) {
            this.o.setVisibility(4);
            return;
        }
        f.d g = this.f12303a.g();
        if (g == f.d.END || g == f.d.STOP) {
            this.o.setVisibility(0);
        }
    }

    public void b() {
        if (this.i == null || this.h == null) {
            return;
        }
        this.i.setVisibility(4);
        this.h.setVisibility(4);
    }

    public void b(boolean z) {
        this.z = z;
        if (this.l != null) {
            if (z && isShown()) {
                c();
            } else {
                this.l.setVisibility(4);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void c() {
        if (this.f12303a == null || this.f12303a.g() == f.d.ERROR || this.f12303a.g() == f.d.UNINITIALIZED) {
            return;
        }
        a(3000, this.y);
    }

    public void c(boolean z) {
        this.d = z;
        if (this.i == null || this.h == null) {
            return;
        }
        if (z) {
            this.i.setVisibility(4);
            this.h.setVisibility(4);
            return;
        }
        this.i.setVisibility(0);
        this.h.setVisibility(0);
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void d() {
        if (!this.c || this.l == null || this.h == null) {
            return;
        }
        this.l.setVisibility(4);
        this.h.setVisibility(4);
        this.c = false;
    }

    public void d(boolean z) {
        if (this.f12303a == null || this.f12303a.g() == f.d.ERROR || this.f12303a.g() == f.d.UNINITIALIZED) {
            return;
        }
        a(3000, z);
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void e() {
        if (this.j == null || this.f12303a == null) {
            return;
        }
        if (this.f12303a.d()) {
            this.j.setImageBitmap(g.h(this.n));
        } else {
            this.j.setImageBitmap(g.g(this.n));
        }
    }

    public void e(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        if (z) {
            if (this.A == null) {
                this.A = new View(this.n);
                this.A.setAlpha(0.6f);
                this.A.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, 889192448, -1627389952, ViewCompat.MEASURED_STATE_MASK}));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ak.a(this.n, 250));
                layoutParams2.gravity = 80;
                this.g.addView(this.A, layoutParams2);
            } else {
                this.A.setVisibility(0);
            }
            layoutParams.setMargins(0, 0, 0, ak.a(this.n, 30));
        }
        layoutParams.height = ak.a(this.n, 2);
        this.m.setLayoutParams(layoutParams);
        this.m.bringToFront();
    }

    public void f() {
        if (this.k == null) {
            return;
        }
        if (this.e == 4) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public void g() {
        if (this.i == null) {
            return;
        }
        if (this.e == 4) {
            this.i.setImageBitmap(g.f(this.n));
        } else {
            this.i.setImageBitmap(g.e(this.n));
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.c.a
    public void h() {
        if (this.c) {
            c();
        }
    }

    public void i() {
        if (this.G != null) {
            this.G.removeMessages(10002);
            this.G.removeMessages(10001);
        }
    }

    @Override // android.view.View, com.qq.e.comm.plugin.aa.b.b
    public boolean isShown() {
        return this.c;
    }

    public boolean j() {
        if (this.f12303a != null) {
            return this.f12303a.d();
        }
        return true;
    }

    public void k() {
        if (this.f12303a != null) {
            if (this.f12303a.d()) {
                this.f12303a.i();
            } else {
                this.f12303a.h();
            }
        }
    }

    public void l() {
        if (this.A != null) {
            this.A.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.height = ak.a(this.n, 3);
        this.m.setLayoutParams(layoutParams);
    }
}
