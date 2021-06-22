package d.a.m0.a.q.e;

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
    public WebViewContainer f47929a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47930b;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f47933e;

    /* renamed from: f  reason: collision with root package name */
    public float f47934f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.i1.g.a f47935g;

    /* renamed from: h  reason: collision with root package name */
    public int f47936h;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47931c = true;

    /* renamed from: d  reason: collision with root package name */
    public double f47932d = 0.25d;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47937i = true;
    public WebViewContainer.b j = new a();
    public WebViewContainer.c k = new C0860b();

    /* loaded from: classes2.dex */
    public class a implements WebViewContainer.b {
        public a() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            b.this.j(false);
        }
    }

    /* renamed from: d.a.m0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0860b implements WebViewContainer.c {
        public C0860b() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            if (b.this.f47929a == null) {
                return;
            }
            b.this.j((((double) b.this.f47929a.getTopMargin()) * 1.0d) / (((double) b.this.f47936h) * 1.0d) >= (z ? 1.0d - b.this.f47932d : b.this.f47932d));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements WebViewContainer.a {
        public c() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            if (!z || b.this.f47929a.getTopMargin() > b.this.f47936h) {
                if (z || b.this.f47929a.getTopMargin() < b.this.f47929a.getMinTopMargin()) {
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
        public float f47941e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f47942f;

        /* renamed from: g  reason: collision with root package name */
        public int f47943g;

        /* renamed from: h  reason: collision with root package name */
        public int f47944h;

        /* renamed from: i  reason: collision with root package name */
        public float f47945i;
        public int j;
        public final /* synthetic */ boolean k;

        public d(boolean z) {
            this.k = z;
            this.f47942f = b.this.f47936h - b.this.f47929a.getTopMargin();
            int topMargin = b.this.f47929a.getTopMargin() - b.this.f47929a.getMinTopMargin();
            this.f47943g = topMargin;
            topMargin = this.k ? this.f47942f : topMargin;
            this.f47944h = topMargin;
            this.f47945i = topMargin * b.this.f47934f;
            this.j = b.this.f47929a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f47929a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((b.this.f47931c ? this.f47944h : this.f47945i) * (floatValue - this.f47941e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            b.this.f47929a.scrollBy(0, i2);
            b.this.f47929a.setTopMargin(this.j);
            this.f47941e = floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47946e;

        public e(boolean z) {
            this.f47946e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f47929a == null) {
                return;
            }
            b.this.i(this.f47946e);
        }
    }

    public b(Context context) {
        this.f47930b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f47933e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer = this.f47929a;
        if (webViewContainer == null || this.f47935g == null) {
            return;
        }
        if (z) {
            if (this.f47931c) {
                webViewContainer.scrollBy(0, -(this.f47936h - webViewContainer.getTopMargin()));
                this.f47929a.setTopMargin(this.f47936h);
            }
            if (!this.f47935g.n() && !this.f47935g.m()) {
                this.f47935g.r();
            }
            this.f47937i = true;
            return;
        }
        if (this.f47931c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f47929a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f47929a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f47935g.n()) {
            this.f47935g.p();
        }
        this.f47937i = false;
    }

    public final void j(boolean z) {
        if (this.f47936h <= 0 || this.f47929a == null || this.f47935g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        WebViewContainer webViewContainer = new WebViewContainer(this.f47930b);
        this.f47929a = webViewContainer;
        webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f47929a.setClipChildren(false);
        this.f47929a.setLayerType(2, null);
        this.f47929a.setTopLimit(this.f47936h);
        this.f47929a.setTopMargin(this.f47936h);
        this.f47929a.setAutoScroll2TopListener(this.j);
        this.f47929a.setOnUpListener(this.k);
        this.f47929a.setMinFlingVelocity(1000);
        this.f47929a.setUpYVelocityRatio(3.5f);
        this.f47929a.setInterceptFlingListener(new c());
        return this.f47929a;
    }

    public boolean l() {
        return this.f47937i;
    }

    public final boolean m() {
        ValueAnimator valueAnimator = this.f47933e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final void n(boolean z) {
        if (this.f47929a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47933e = ofFloat;
        ofFloat.setDuration(100L);
        this.f47933e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f47929a.getYVelocity() >= 0.0f) {
            this.f47934f = this.f47929a.getYVelocity() / 4000.0f;
        } else {
            this.f47934f = (-this.f47929a.getYVelocity()) / 4000.0f;
        }
        this.f47934f = Math.min(this.f47934f, 1.0f);
        this.f47933e.addUpdateListener(new d(z));
        this.f47933e.addListener(new e(z));
        this.f47933e.start();
    }

    public void o(int i2) {
        this.f47936h = i2;
    }

    public void p(d.a.m0.a.i1.g.a aVar) {
        this.f47935g = aVar;
    }
}
