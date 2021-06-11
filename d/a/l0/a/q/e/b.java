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
    public WebViewContainer f47821a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47822b;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f47825e;

    /* renamed from: f  reason: collision with root package name */
    public float f47826f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.i1.g.a f47827g;

    /* renamed from: h  reason: collision with root package name */
    public int f47828h;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47823c = true;

    /* renamed from: d  reason: collision with root package name */
    public double f47824d = 0.25d;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47829i = true;
    public WebViewContainer.b j = new a();
    public WebViewContainer.c k = new C0857b();

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
    public class C0857b implements WebViewContainer.c {
        public C0857b() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            if (b.this.f47821a == null) {
                return;
            }
            b.this.j((((double) b.this.f47821a.getTopMargin()) * 1.0d) / (((double) b.this.f47828h) * 1.0d) >= (z ? 1.0d - b.this.f47824d : b.this.f47824d));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements WebViewContainer.a {
        public c() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            if (!z || b.this.f47821a.getTopMargin() > b.this.f47828h) {
                if (z || b.this.f47821a.getTopMargin() < b.this.f47821a.getMinTopMargin()) {
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
        public float f47833e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f47834f;

        /* renamed from: g  reason: collision with root package name */
        public int f47835g;

        /* renamed from: h  reason: collision with root package name */
        public int f47836h;

        /* renamed from: i  reason: collision with root package name */
        public float f47837i;
        public int j;
        public final /* synthetic */ boolean k;

        public d(boolean z) {
            this.k = z;
            this.f47834f = b.this.f47828h - b.this.f47821a.getTopMargin();
            int topMargin = b.this.f47821a.getTopMargin() - b.this.f47821a.getMinTopMargin();
            this.f47835g = topMargin;
            topMargin = this.k ? this.f47834f : topMargin;
            this.f47836h = topMargin;
            this.f47837i = topMargin * b.this.f47826f;
            this.j = b.this.f47821a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f47821a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((b.this.f47823c ? this.f47836h : this.f47837i) * (floatValue - this.f47833e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            b.this.f47821a.scrollBy(0, i2);
            b.this.f47821a.setTopMargin(this.j);
            this.f47833e = floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47838e;

        public e(boolean z) {
            this.f47838e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f47821a == null) {
                return;
            }
            b.this.i(this.f47838e);
        }
    }

    public b(Context context) {
        this.f47822b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f47825e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer = this.f47821a;
        if (webViewContainer == null || this.f47827g == null) {
            return;
        }
        if (z) {
            if (this.f47823c) {
                webViewContainer.scrollBy(0, -(this.f47828h - webViewContainer.getTopMargin()));
                this.f47821a.setTopMargin(this.f47828h);
            }
            if (!this.f47827g.n() && !this.f47827g.m()) {
                this.f47827g.r();
            }
            this.f47829i = true;
            return;
        }
        if (this.f47823c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f47821a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f47821a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f47827g.n()) {
            this.f47827g.p();
        }
        this.f47829i = false;
    }

    public final void j(boolean z) {
        if (this.f47828h <= 0 || this.f47821a == null || this.f47827g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        WebViewContainer webViewContainer = new WebViewContainer(this.f47822b);
        this.f47821a = webViewContainer;
        webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f47821a.setClipChildren(false);
        this.f47821a.setLayerType(2, null);
        this.f47821a.setTopLimit(this.f47828h);
        this.f47821a.setTopMargin(this.f47828h);
        this.f47821a.setAutoScroll2TopListener(this.j);
        this.f47821a.setOnUpListener(this.k);
        this.f47821a.setMinFlingVelocity(1000);
        this.f47821a.setUpYVelocityRatio(3.5f);
        this.f47821a.setInterceptFlingListener(new c());
        return this.f47821a;
    }

    public boolean l() {
        return this.f47829i;
    }

    public final boolean m() {
        ValueAnimator valueAnimator = this.f47825e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final void n(boolean z) {
        if (this.f47821a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47825e = ofFloat;
        ofFloat.setDuration(100L);
        this.f47825e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f47821a.getYVelocity() >= 0.0f) {
            this.f47826f = this.f47821a.getYVelocity() / 4000.0f;
        } else {
            this.f47826f = (-this.f47821a.getYVelocity()) / 4000.0f;
        }
        this.f47826f = Math.min(this.f47826f, 1.0f);
        this.f47825e.addUpdateListener(new d(z));
        this.f47825e.addListener(new e(z));
        this.f47825e.start();
    }

    public void o(int i2) {
        this.f47828h = i2;
    }

    public void p(d.a.l0.a.i1.g.a aVar) {
        this.f47827g = aVar;
    }
}
