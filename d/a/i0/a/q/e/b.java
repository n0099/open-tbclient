package d.a.i0.a.q.e;

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
    public WebViewContainer f43971a;

    /* renamed from: b  reason: collision with root package name */
    public Context f43972b;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f43975e;

    /* renamed from: f  reason: collision with root package name */
    public float f43976f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.i1.g.a f43977g;

    /* renamed from: h  reason: collision with root package name */
    public int f43978h;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43973c = true;

    /* renamed from: d  reason: collision with root package name */
    public double f43974d = 0.25d;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43979i = true;
    public WebViewContainer.b j = new a();
    public WebViewContainer.c k = new C0790b();

    /* loaded from: classes2.dex */
    public class a implements WebViewContainer.b {
        public a() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            b.this.j(false);
        }
    }

    /* renamed from: d.a.i0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0790b implements WebViewContainer.c {
        public C0790b() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            if (b.this.f43971a == null) {
                return;
            }
            b.this.j((((double) b.this.f43971a.getTopMargin()) * 1.0d) / (((double) b.this.f43978h) * 1.0d) >= (z ? 1.0d - b.this.f43974d : b.this.f43974d));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements WebViewContainer.a {
        public c() {
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            if (!z || b.this.f43971a.getTopMargin() > b.this.f43978h) {
                if (z || b.this.f43971a.getTopMargin() < b.this.f43971a.getMinTopMargin()) {
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
        public float f43983e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f43984f;

        /* renamed from: g  reason: collision with root package name */
        public int f43985g;

        /* renamed from: h  reason: collision with root package name */
        public int f43986h;

        /* renamed from: i  reason: collision with root package name */
        public float f43987i;
        public int j;
        public final /* synthetic */ boolean k;

        public d(boolean z) {
            this.k = z;
            this.f43984f = b.this.f43978h - b.this.f43971a.getTopMargin();
            int topMargin = b.this.f43971a.getTopMargin() - b.this.f43971a.getMinTopMargin();
            this.f43985g = topMargin;
            topMargin = this.k ? this.f43984f : topMargin;
            this.f43986h = topMargin;
            this.f43987i = topMargin * b.this.f43976f;
            this.j = b.this.f43971a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f43971a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((b.this.f43973c ? this.f43986h : this.f43987i) * (floatValue - this.f43983e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            b.this.f43971a.scrollBy(0, i2);
            b.this.f43971a.setTopMargin(this.j);
            this.f43983e = floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f43988e;

        public e(boolean z) {
            this.f43988e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f43971a == null) {
                return;
            }
            b.this.i(this.f43988e);
        }
    }

    public b(Context context) {
        this.f43972b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f43975e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer = this.f43971a;
        if (webViewContainer == null || this.f43977g == null) {
            return;
        }
        if (z) {
            if (this.f43973c) {
                webViewContainer.scrollBy(0, -(this.f43978h - webViewContainer.getTopMargin()));
                this.f43971a.setTopMargin(this.f43978h);
            }
            if (!this.f43977g.n() && !this.f43977g.m()) {
                this.f43977g.r();
            }
            this.f43979i = true;
            return;
        }
        if (this.f43973c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f43971a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f43971a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f43977g.n()) {
            this.f43977g.p();
        }
        this.f43979i = false;
    }

    public final void j(boolean z) {
        if (this.f43978h <= 0 || this.f43971a == null || this.f43977g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        WebViewContainer webViewContainer = new WebViewContainer(this.f43972b);
        this.f43971a = webViewContainer;
        webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f43971a.setClipChildren(false);
        this.f43971a.setLayerType(2, null);
        this.f43971a.setTopLimit(this.f43978h);
        this.f43971a.setTopMargin(this.f43978h);
        this.f43971a.setAutoScroll2TopListener(this.j);
        this.f43971a.setOnUpListener(this.k);
        this.f43971a.setMinFlingVelocity(1000);
        this.f43971a.setUpYVelocityRatio(3.5f);
        this.f43971a.setInterceptFlingListener(new c());
        return this.f43971a;
    }

    public boolean l() {
        return this.f43979i;
    }

    public final boolean m() {
        ValueAnimator valueAnimator = this.f43975e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final void n(boolean z) {
        if (this.f43971a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f43975e = ofFloat;
        ofFloat.setDuration(100L);
        this.f43975e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f43971a.getYVelocity() >= 0.0f) {
            this.f43976f = this.f43971a.getYVelocity() / 4000.0f;
        } else {
            this.f43976f = (-this.f43971a.getYVelocity()) / 4000.0f;
        }
        this.f43976f = Math.min(this.f43976f, 1.0f);
        this.f43975e.addUpdateListener(new d(z));
        this.f43975e.addListener(new e(z));
        this.f43975e.start();
    }

    public void o(int i2) {
        this.f43978h = i2;
    }

    public void p(d.a.i0.a.i1.g.a aVar) {
        this.f43977g = aVar;
    }
}
