package com.kwad.sdk.contentalliance.refreshview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public View G;
    public boolean H;
    public boolean I;
    public boolean J;
    public RefreshStyle K;
    public View L;
    public ValueAnimator M;
    public com.kwad.sdk.contentalliance.refreshview.b N;
    public b O;
    public final Animation.AnimationListener P;
    public d Q;
    public c R;
    public List<c> S;
    public Interpolator T;
    public Interpolator U;
    public boolean V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f33555a;
    public final Animation aa;
    public final Animation ab;
    public boolean ac;

    /* renamed from: b  reason: collision with root package name */
    public float f33556b;

    /* renamed from: c  reason: collision with root package name */
    public float f33557c;

    /* renamed from: d  reason: collision with root package name */
    public View f33558d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.refreshview.d f33559e;

    /* renamed from: f  reason: collision with root package name */
    public final Animation.AnimationListener f33560f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33561g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f33562h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f33563i;
    public final NestedScrollingChildHelper j;
    public final NestedScrollingParentHelper k;
    public float l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$6  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33569a;

        static {
            int[] iArr = new int[RefreshStyle.values().length];
            f33569a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33569a[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    /* loaded from: classes6.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void a(float f2, float f3, boolean z);

        void b();

        void c();
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(float f2, boolean z);
    }

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33561g = "RefreshLayout";
        this.f33562h = new int[2];
        this.f33563i = new int[2];
        this.t = -1;
        this.u = -1;
        this.v = 300;
        this.w = 500;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = RefreshStyle.NORMAL;
        this.M = null;
        this.P = new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (RefreshLayout.this.r && RefreshLayout.this.O != null) {
                    RefreshLayout.this.O.a();
                }
                RefreshLayout.this.n = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                RefreshLayout.this.n = true;
                RefreshLayout.this.f33559e.b();
            }
        };
        this.f33560f = new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RefreshLayout.this.a();
                if (RefreshLayout.this.R != null) {
                    RefreshLayout.this.R.c();
                }
                if (RefreshLayout.this.S != null) {
                    for (int i2 = 0; i2 < RefreshLayout.this.S.size(); i2++) {
                        ((c) RefreshLayout.this.S.get(i2)).c();
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                RefreshLayout.this.n = true;
            }
        };
        this.T = new DecelerateInterpolator(2.0f);
        this.U = new DecelerateInterpolator(2.0f);
        this.W = true;
        this.aa = new Animation() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                float f3;
                RefreshLayout refreshLayout;
                View view;
                if (RefreshLayout.this.L == null) {
                    return;
                }
                if (AnonymousClass6.f33569a[RefreshLayout.this.K.ordinal()] != 1) {
                    refreshLayout = RefreshLayout.this;
                    f3 = refreshLayout.f33557c;
                    view = refreshLayout.L;
                } else {
                    RefreshLayout refreshLayout2 = RefreshLayout.this;
                    f3 = refreshLayout2.f33557c + refreshLayout2.D;
                    refreshLayout = RefreshLayout.this;
                    view = refreshLayout.f33558d;
                }
                refreshLayout.a(f3, view.getTop(), f2);
            }
        };
        this.ab = new Animation() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                RefreshLayout refreshLayout;
                float f3;
                View view;
                if (RefreshLayout.this.L == null) {
                    return;
                }
                if (AnonymousClass6.f33569a[RefreshLayout.this.K.ordinal()] != 1) {
                    refreshLayout = RefreshLayout.this;
                    f3 = 0.0f;
                    view = refreshLayout.L;
                } else {
                    refreshLayout = RefreshLayout.this;
                    f3 = refreshLayout.D;
                    view = RefreshLayout.this.f33558d;
                }
                refreshLayout.a(f3, view.getTop(), f2);
            }
        };
        this.ac = true;
        this.y = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = getResources().getDisplayMetrics().density;
        this.f33555a = (int) (f2 * 70.0f);
        this.f33557c = f2 * 70.0f;
        this.f33556b = 0.0f;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "constructor: " + this.f33556b);
        this.D = 0.0f;
        this.E = 1.0f;
        this.k = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        a(attributeSet);
        g();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    private float a(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c();
        this.C = 0.0f;
        this.F = 0.0f;
        this.f33559e.a();
        this.f33558d.setVisibility(8);
        this.o = false;
        this.n = false;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "reset");
    }

    private void a(float f2) {
        float f3 = f2 - this.z;
        if (this.o && (f3 > this.y || this.f33556b > 0.0f)) {
            this.q = true;
            this.B = this.z + this.y;
        } else if (this.q) {
        } else {
            int i2 = this.y;
            if (f3 > i2) {
                this.B = this.z + i2;
                this.q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        int i2 = this.x;
        setTargetOrRefreshViewOffsetY((int) (((int) (i2 + ((f2 - i2) * f4))) - f3));
    }

    private void a(float f2, boolean z) {
        float f3;
        this.C = f2;
        d dVar = this.Q;
        int i2 = 0;
        if (dVar == null || !dVar.a(f2, false)) {
            if (this.o) {
                f3 = this.f33557c;
                if (f2 <= f3) {
                    f3 = f2;
                }
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
            } else {
                f3 = AnonymousClass6.f33569a[this.K.ordinal()] != 1 ? this.N.a(f2, this.f33557c) : this.D + this.N.a(f2, this.f33557c);
            }
            float f4 = this.f33557c;
            if (!this.o) {
                if (f3 > f4 && !this.p) {
                    this.p = true;
                    this.f33559e.d();
                    c cVar = this.R;
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (this.S != null) {
                        while (i2 < this.S.size()) {
                            this.S.get(i2).a();
                            i2++;
                        }
                    }
                } else if (f3 <= f4 && this.p) {
                    this.p = false;
                    this.f33559e.e();
                    c cVar2 = this.R;
                    if (cVar2 != null) {
                        cVar2.b();
                    }
                    if (this.S != null) {
                        while (i2 < this.S.size()) {
                            this.S.get(i2).b();
                            i2++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.a.b("RefreshLayout", f2 + " -- " + f4 + " -- " + f3 + " -- " + this.f33556b + " -- " + this.f33557c);
            a((int) (f3 - this.f33556b), z);
        }
    }

    private void a(int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33558d.getLayoutParams();
        this.f33558d.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, boolean z) {
        View view;
        if (this.L == null) {
            return;
        }
        int i3 = AnonymousClass6.f33569a[this.K.ordinal()];
        if (i3 == 1) {
            this.f33558d.offsetTopAndBottom(i2);
            view = this.f33558d;
        } else if (i3 != 2) {
            this.L.offsetTopAndBottom(i2);
            View view2 = this.G;
            if (view2 != null) {
                view2.offsetTopAndBottom(i2);
            } else {
                float f2 = (i2 / this.E) + this.F;
                int i4 = (int) f2;
                this.F = f2 - i4;
                this.f33558d.offsetTopAndBottom(i4);
            }
            this.f33556b = this.L.getTop();
            com.kwad.sdk.core.d.a.b("RefreshLayout", "refresh style" + this.f33556b);
            com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f33556b);
            if (AnonymousClass6.f33569a[this.K.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.d dVar = this.f33559e;
                float f3 = this.f33556b;
                dVar.a(f3, f3 / this.f33557c);
                c cVar = this.R;
                if (cVar != null) {
                    float f4 = this.f33556b;
                    cVar.a(f4, f4 / this.f33557c, z);
                }
                if (this.S != null) {
                    for (int i5 = 0; i5 < this.S.size(); i5++) {
                        float f5 = this.f33556b;
                        this.S.get(i5).a(f5, f5 / this.f33557c, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.d dVar2 = this.f33559e;
                float f6 = this.f33556b;
                dVar2.a(f6, (f6 - this.D) / this.f33557c);
                c cVar2 = this.R;
                if (cVar2 != null) {
                    float f7 = this.f33556b;
                    cVar2.a(f7, (f7 - this.D) / this.f33557c, z);
                }
                if (this.S != null) {
                    for (int i6 = 0; i6 < this.S.size(); i6++) {
                        float f8 = this.f33556b;
                        this.S.get(i6).a(f8, (f8 - this.D) / this.f33557c, z);
                    }
                }
            }
            if (this.W && this.f33558d.getVisibility() != 0) {
                this.f33558d.setVisibility(0);
            }
            invalidate();
        } else {
            this.L.offsetTopAndBottom(i2);
            View view3 = this.G;
            if (view3 != null) {
                view3.offsetTopAndBottom(i2);
            }
            view = this.L;
        }
        this.f33556b = view.getTop();
        com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f33556b);
        if (AnonymousClass6.f33569a[this.K.ordinal()] == 1) {
        }
        if (this.W) {
            this.f33558d.setVisibility(0);
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
        this.u = pointerId;
        this.B = a(motionEvent, pointerId) - this.C;
        com.kwad.sdk.core.d.a.b("RefreshLayout", " onDown " + this.B);
    }

    private void a(boolean z, boolean z2) {
        if (this.o != z) {
            this.r = z2;
            this.o = z;
            if (z) {
                b((int) this.f33556b, this.P);
                return;
            }
            this.f33559e.c();
            postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.a((int) refreshLayout.f33556b, refreshLayout.f33560f);
                }
            }, this.f33559e.f());
        }
    }

    private boolean a(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14 && (view instanceof AbsListView)) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() > 0) {
                return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
            }
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    private int b(float f2) {
        com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- refreshing " + f2);
        if (AnonymousClass6.f33569a[this.K.ordinal()] == 1) {
            f2 -= this.D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.f33557c) / this.f33557c)) * this.w);
    }

    private int b(int i2) {
        return AnonymousClass6.f33569a[this.K.ordinal()] != 1 ? i2 + ((int) this.f33556b) : i2;
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (b(i2) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i2;
        this.aa.reset();
        this.aa.setDuration(b(f2));
        this.aa.setInterpolator(this.U);
        if (animationListener != null) {
            this.aa.setAnimationListener(animationListener);
        }
        startAnimation(this.aa);
    }

    private void b(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.u) {
            this.u = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
        this.B = a(motionEvent, this.u) - this.C;
        com.kwad.sdk.core.d.a.b("RefreshLayout", " onUp " + this.B);
    }

    private int c(float f2) {
        com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- start " + f2);
        if (f2 < this.D) {
            return 0;
        }
        if (AnonymousClass6.f33569a[this.K.ordinal()] == 1) {
            f2 -= this.D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.f33557c)) * this.v);
    }

    private void c() {
        setTargetOrRefreshViewOffsetY((int) ((AnonymousClass6.f33569a[this.K.ordinal()] != 1 ? 0.0f : this.D) - this.f33556b));
    }

    private void g() {
        this.N = b();
    }

    private int getTargetOrRefreshViewTop() {
        return (AnonymousClass6.f33569a[this.K.ordinal()] != 1 ? this.L : this.f33558d).getTop();
    }

    private void h() {
        this.L.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private void i() {
        this.A = 0.0f;
        this.q = false;
        this.s = false;
        this.u = -1;
    }

    private void j() {
        if (this.o || this.n) {
            return;
        }
        d dVar = this.Q;
        if (dVar == null || !dVar.a(this.C, true)) {
            if (d()) {
                a(true, true);
                return;
            }
            this.o = false;
            a((int) this.f33556b, this.f33560f);
        }
    }

    private void k() {
        View view = this.G;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private void l() {
        if (m()) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.f33558d) && !childAt.equals(this.G)) {
                this.L = childAt;
                return;
            }
        }
    }

    private boolean m() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (this.L == getChildAt(i2)) {
                return true;
            }
        }
        return false;
    }

    public int a(int i2) {
        int i3 = AnonymousClass6.f33569a[this.K.ordinal()];
        return (i3 == 1 || i3 != 2) ? i2 + ((int) this.f33556b) : i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void a(int i2, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (c(i2) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i2;
        this.ab.reset();
        this.ab.setDuration(c(f2));
        this.ab.setInterpolator(this.T);
        if (animationListener != null) {
            this.ab.setAnimationListener(animationListener);
        }
        startAnimation(this.ab);
    }

    public void a(AttributeSet attributeSet) {
        View b2 = b(attributeSet);
        this.f33558d = b2;
        b2.setVisibility(8);
        View view = this.f33558d;
        if (!(view instanceof com.kwad.sdk.contentalliance.refreshview.d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.f33559e = (com.kwad.sdk.contentalliance.refreshview.d) view;
        a c2 = c(attributeSet);
        if (c2 == null) {
            int i2 = this.f33555a;
            c2 = new a(i2, i2);
        }
        addView(this.f33558d, c2);
    }

    public abstract View b(AttributeSet attributeSet);

    public abstract com.kwad.sdk.contentalliance.refreshview.b b();

    public a c(AttributeSet attributeSet) {
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: d */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public boolean d() {
        return !this.V && ((float) getTargetOrRefreshViewOffset()) > this.f33557c;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.j.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.j.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.j.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (this.ac && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
            onStopNestedScroll(this);
        }
        com.kwad.sdk.core.d.a.b("RefreshLayout", "dispatch " + this.s + " isRefreshing" + this.o);
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean e() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: f */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (AnonymousClass6.f33569a[this.K.ordinal()] != 1) {
            int i4 = this.t;
            return i4 < 0 ? i3 : i3 == 0 ? i4 : i3 <= i4 ? i3 - 1 : i3;
        }
        int i5 = this.t;
        return i5 < 0 ? i3 : i3 == i2 - 1 ? i5 : i3 >= i5 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.k.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.f33557c;
    }

    @Nullable
    public View getStateView() {
        return this.G;
    }

    public int getTargetOrRefreshViewOffset() {
        if (AnonymousClass6.f33569a[this.K.ordinal()] != 1) {
            View view = this.L;
            if (view == null) {
                return 0;
            }
            return view.getTop();
        }
        return (int) (this.f33558d.getTop() - this.D);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        a();
        this.O = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        l();
        View view = this.L;
        if (view == null) {
            return false;
        }
        if (!(view instanceof com.kwad.sdk.contentalliance.refreshview.c) || ((com.kwad.sdk.contentalliance.refreshview.c) view).a()) {
            if (AnonymousClass6.f33569a[this.K.ordinal()] != 1) {
                if (!isEnabled() || (a(this.L) && !this.s)) {
                    return false;
                }
            } else if (!isEnabled() || a(this.L) || this.o || this.m) {
                return false;
            }
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.u;
                        if (i2 == -1) {
                            return false;
                        }
                        float a2 = a(motionEvent, i2);
                        if (a2 == -1.0f) {
                            return false;
                        }
                        a(a2);
                        ValueAnimator valueAnimator = this.M;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            this.M.cancel();
                            this.f33559e.c();
                            a((int) this.f33556b, this.f33560f);
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            b(motionEvent);
                        }
                    }
                }
                this.q = false;
                this.u = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.u = pointerId;
                this.q = false;
                float a3 = a(motionEvent, pointerId);
                if (a3 == -1.0f) {
                    return false;
                }
                if (this.aa.hasEnded() && this.ab.hasEnded()) {
                    this.n = false;
                }
                this.z = a3;
                this.A = this.f33556b;
                this.s = false;
            }
            return this.q;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        if (getChildCount() == 0) {
            return;
        }
        l();
        if (this.L == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.L.getVisibility() != 8 || ((view = this.G) != null && view.getVisibility() != 8)) {
            int b2 = b(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
            if (this.L.getVisibility() != 8) {
                this.L.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
            View view2 = this.G;
            if (view2 != null && view2.getVisibility() != 8) {
                this.G.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33558d.getLayoutParams();
        int a2 = (a((int) this.D) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.f33558d.layout((measuredWidth - this.f33558d.getMeasuredWidth()) / 2, a2, (measuredWidth + this.f33558d.getMeasuredWidth()) / 2, this.f33558d.getMeasuredHeight() + a2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        l();
        if (this.L == null) {
            return;
        }
        h();
        k();
        a(i2, i3);
        if (!this.J && !this.I) {
            int i4 = AnonymousClass6.f33569a[this.K.ordinal()];
            if (i4 == 1) {
                float f2 = -this.f33558d.getMeasuredHeight();
                this.D = f2;
                this.f33556b = f2;
            } else if (i4 != 2) {
                this.f33556b = 0.0f;
                this.D = -this.f33558d.getMeasuredHeight();
            } else {
                this.D = 0.0f;
                this.f33556b = 0.0f;
            }
        }
        if (!this.J && !this.H && this.f33557c < this.f33558d.getMeasuredHeight()) {
            this.f33557c = this.f33558d.getMeasuredHeight();
        }
        this.J = true;
        this.t = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == this.f33558d) {
                this.t = i5;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.l;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.l = 0.0f;
                } else {
                    this.l = f2 - f3;
                    iArr[1] = i3;
                }
                com.kwad.sdk.core.d.a.b("RefreshLayout", "pre scroll");
                a(this.l, false);
            }
        }
        int[] iArr2 = this.f33562h;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6;
        dispatchNestedScroll(i2, i3, i4, i5, this.f33563i);
        if (i5 + this.f33563i[1] < 0) {
            this.l += Math.abs(i6);
            com.kwad.sdk.core.d.a.b("RefreshLayout", "nested scroll");
            a(this.l, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.k.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.l = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return AnonymousClass6.f33569a[this.K.ordinal()] != 1 ? isEnabled() && a(this.L) && (i2 & 2) != 0 : isEnabled() && a(this.L) && !this.o && (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.k.onStopNestedScroll(view);
        this.m = false;
        if (this.l > 0.0f) {
            j();
            this.l = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        StringBuilder sb;
        float f3;
        l();
        if (this.L == null) {
            return false;
        }
        if (AnonymousClass6.f33569a[this.K.ordinal()] != 1) {
            if (!isEnabled() || (a(this.L) && !this.s)) {
                return false;
            }
        } else if (!isEnabled() || a(this.L) || this.m) {
            return false;
        }
        if (this.K == RefreshStyle.FLOAT && (a(this.L) || this.m)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = this.u;
                    if (i2 == -1) {
                        return false;
                    }
                    float a2 = a(motionEvent, i2);
                    if (a2 == -1.0f) {
                        return false;
                    }
                    if (this.n) {
                        f2 = getTargetOrRefreshViewTop();
                        this.B = a2;
                        this.A = f2;
                        sb = new StringBuilder();
                        sb.append("animatetostart overscrolly ");
                        sb.append(f2);
                        sb.append(" -- ");
                        f3 = this.B;
                    } else {
                        f2 = (a2 - this.B) + this.A;
                        sb = new StringBuilder();
                        sb.append("overscrolly ");
                        sb.append(f2);
                        sb.append(" --");
                        sb.append(this.B);
                        sb.append(" -- ");
                        f3 = this.A;
                    }
                    sb.append(f3);
                    com.kwad.sdk.core.d.a.b("RefreshLayout", sb.toString());
                    if (this.o) {
                        if (f2 > 0.0f) {
                            if (f2 > 0.0f && f2 < this.f33557c && this.s) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(3);
                                this.s = false;
                            }
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner refreshing -- " + this.A + " -- " + (a2 - this.B));
                            a(f2, true);
                        } else if (!this.s) {
                            motionEvent = MotionEvent.obtain(motionEvent);
                            motionEvent.setAction(0);
                            this.s = true;
                        }
                        this.L.dispatchTouchEvent(motionEvent);
                        com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner refreshing -- " + this.A + " -- " + (a2 - this.B));
                        a(f2, true);
                    } else if (!this.q) {
                        com.kwad.sdk.core.d.a.b("RefreshLayout", "is not Being Dragged, init drag status");
                        a(a2);
                    } else if (f2 <= 0.0f) {
                        com.kwad.sdk.core.d.a.b("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                        return false;
                    } else {
                        a(f2, true);
                        com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner not refreshing -- " + this.A + " -- " + (a2 - this.B));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        a(motionEvent);
                    } else if (action == 6) {
                        b(motionEvent);
                    }
                }
            }
            int i3 = this.u;
            if (i3 == -1 || a(motionEvent, i3) == -1.0f) {
                i();
                return false;
            } else if (!this.o && !this.n) {
                i();
                j();
                return false;
            } else {
                if (this.s) {
                    this.L.dispatchTouchEvent(motionEvent);
                }
                i();
                return false;
            }
        }
        this.u = MotionEventCompat.getPointerId(motionEvent, 0);
        this.q = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.L instanceof AbsListView)) {
            View view = this.L;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimateToRefreshDuration(int i2) {
        this.w = i2;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.U = interpolator;
    }

    public void setAnimateToStartDuration(int i2) {
        this.v = i2;
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        this.T = interpolator;
    }

    public void setDragDistanceConverter(@NonNull com.kwad.sdk.contentalliance.refreshview.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("the dragDistanceConverter can't be null");
        }
        this.N = bVar;
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        this.ac = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.j.setNestedScrollingEnabled(z);
    }

    public void setOnRefreshListener(b bVar) {
        this.O = bVar;
    }

    public void setOnRefreshStatusListener(c cVar) {
        this.R = cVar;
    }

    public void setOnScrollInterceptor(d dVar) {
        this.Q = dVar;
    }

    public void setOnlySupportPull(boolean z) {
        this.V = z;
    }

    public void setRefreshInitialOffset(float f2) {
        this.D = f2;
        this.I = true;
        requestLayout();
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        this.K = refreshStyle;
    }

    public void setRefreshTargetOffset(float f2) {
        this.f33557c = f2;
        this.H = true;
        requestLayout();
    }

    public void setRefreshing(boolean z) {
        if (this.o == z) {
            return;
        }
        if (!z) {
            a(z, false);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded()) {
            getAnimation().setAnimationListener(null);
            clearAnimation();
            a();
        }
        this.o = z;
        this.r = false;
        b((int) this.f33556b, this.P);
    }

    public void setShowRefreshView(boolean z) {
        setOnlySupportPull(!z);
        this.W = z;
    }

    public void setTargetOrRefreshViewOffsetY(int i2) {
        a(i2, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.j.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }
}
