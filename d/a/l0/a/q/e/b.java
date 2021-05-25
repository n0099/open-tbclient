package d.a.l0.a.q.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public WebViewContainer f44147a;

    /* renamed from: b  reason: collision with root package name */
    public Context f44148b;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f44151e;

    /* renamed from: f  reason: collision with root package name */
    public float f44152f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.g.a f44153g;

    /* renamed from: h  reason: collision with root package name */
    public int f44154h;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44149c = true;

    /* renamed from: d  reason: collision with root package name */
    public double f44150d = 0.25d;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44155i = true;
    public WebViewContainer.b j = new a();
    public WebViewContainer.c k = new C0801b();

    /* loaded from: classes2.dex */
    public class a implements WebViewContainer.b {
        public a() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            b.this.j(false);
        }
    }

    /* renamed from: d.a.l0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0801b implements WebViewContainer.c {
        public C0801b() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            if (b.this.f44147a == null) {
                return;
            }
            b.this.j((((double) b.this.f44147a.getTopMargin()) * 1.0d) / (((double) b.this.f44154h) * 1.0d) >= (z ? 1.0d - b.this.f44150d : b.this.f44150d));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements WebViewContainer.a {
        public c() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            if (!z || b.this.f44147a.getTopMargin() > b.this.f44154h) {
                if (z || b.this.f44147a.getTopMargin() < b.this.f44147a.getMinTopMargin()) {
                    return false;
                }
                b.this.j(true);
                return true;
            }
            b.this.j(false);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public float f44159e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f44160f;

        /* renamed from: g  reason: collision with root package name */
        public int f44161g;

        /* renamed from: h  reason: collision with root package name */
        public int f44162h;

        /* renamed from: i  reason: collision with root package name */
        public float f44163i;
        public int j;
        public final /* synthetic */ boolean k;

        public d(boolean z) {
            this.k = z;
            this.f44160f = b.this.f44154h - b.this.f44147a.getTopMargin();
            int topMargin = b.this.f44147a.getTopMargin() - b.this.f44147a.getMinTopMargin();
            this.f44161g = topMargin;
            topMargin = this.k ? this.f44160f : topMargin;
            this.f44162h = topMargin;
            this.f44163i = topMargin * b.this.f44152f;
            this.j = b.this.f44147a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f44147a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((b.this.f44149c ? this.f44162h : this.f44163i) * (floatValue - this.f44159e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            b.this.f44147a.scrollBy(0, i2);
            b.this.f44147a.setTopMargin(this.j);
            this.f44159e = floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44164e;

        public e(boolean z) {
            this.f44164e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f44147a == null) {
                return;
            }
            b.this.i(this.f44164e);
        }
    }

    public b(Context context) {
        this.f44148b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f44151e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer = this.f44147a;
        if (webViewContainer == null || this.f44153g == null) {
            return;
        }
        if (z) {
            if (this.f44149c) {
                webViewContainer.scrollBy(0, -(this.f44154h - webViewContainer.getTopMargin()));
                this.f44147a.setTopMargin(this.f44154h);
            }
            if (!this.f44153g.n() && !this.f44153g.m()) {
                this.f44153g.r();
            }
            this.f44155i = true;
            return;
        }
        if (this.f44149c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f44147a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f44147a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f44153g.n()) {
            this.f44153g.p();
        }
        this.f44155i = false;
    }

    public final void j(boolean z) {
        if (this.f44154h <= 0 || this.f44147a == null || this.f44153g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        WebViewContainer webViewContainer = new WebViewContainer(this.f44148b);
        this.f44147a = webViewContainer;
        webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f44147a.setClipChildren(false);
        this.f44147a.setLayerType(2, null);
        this.f44147a.setTopLimit(this.f44154h);
        this.f44147a.setTopMargin(this.f44154h);
        this.f44147a.setAutoScroll2TopListener(this.j);
        this.f44147a.setOnUpListener(this.k);
        this.f44147a.setMinFlingVelocity(1000);
        this.f44147a.setUpYVelocityRatio(3.5f);
        this.f44147a.setInterceptFlingListener(new c());
        return this.f44147a;
    }

    public boolean l() {
        return this.f44155i;
    }

    public final boolean m() {
        ValueAnimator valueAnimator = this.f44151e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final void n(boolean z) {
        if (this.f44147a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f44151e = ofFloat;
        ofFloat.setDuration(100L);
        this.f44151e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f44147a.getYVelocity() >= 0.0f) {
            this.f44152f = this.f44147a.getYVelocity() / 4000.0f;
        } else {
            this.f44152f = (-this.f44147a.getYVelocity()) / 4000.0f;
        }
        this.f44152f = Math.min(this.f44152f, 1.0f);
        this.f44151e.addUpdateListener(new d(z));
        this.f44151e.addListener(new e(z));
        this.f44151e.start();
    }

    public void o(int i2) {
        this.f44154h = i2;
    }

    public void p(d.a.l0.a.i1.g.a aVar) {
        this.f44153g = aVar;
    }
}
