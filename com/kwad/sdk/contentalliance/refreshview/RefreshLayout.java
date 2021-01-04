package com.kwad.sdk.contentalliance.refreshview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
/* loaded from: classes5.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private View G;
    private boolean H;
    private boolean I;
    private boolean J;
    private RefreshStyle K;
    private View L;
    private ValueAnimator M;
    private com.kwad.sdk.contentalliance.refreshview.b N;
    private b O;
    private final Animation.AnimationListener P;
    private d Q;
    private c R;
    private List<c> S;
    private Interpolator T;
    private Interpolator U;
    private boolean V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    protected int f9120a;
    private final Animation aa;
    private final Animation ab;
    private boolean ac;

    /* renamed from: b  reason: collision with root package name */
    protected float f9121b;
    protected float c;
    protected View d;
    protected com.kwad.sdk.contentalliance.refreshview.d e;
    protected final Animation.AnimationListener f;
    private final String g;
    private final int[] h;
    private final int[] i;
    private final NestedScrollingChildHelper j;
    private final NestedScrollingParentHelper k;
    private float l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private float z;

    /* loaded from: classes5.dex */
    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    /* loaded from: classes5.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void a(float f, float f2, boolean z);

        void b();

        void c();
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(float f, boolean z);
    }

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = "RefreshLayout";
        this.h = new int[2];
        this.i = new int[2];
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
                RefreshLayout.this.e.b();
            }
        };
        this.f = new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RefreshLayout.this.a();
                if (RefreshLayout.this.R != null) {
                    RefreshLayout.this.R.c();
                }
                if (RefreshLayout.this.S == null) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= RefreshLayout.this.S.size()) {
                        return;
                    }
                    ((c) RefreshLayout.this.S.get(i2)).c();
                    i = i2 + 1;
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
            protected void applyTransformation(float f, Transformation transformation) {
                if (RefreshLayout.this.L == null) {
                    return;
                }
                switch (AnonymousClass6.f9127a[RefreshLayout.this.K.ordinal()]) {
                    case 1:
                        RefreshLayout.this.a(RefreshLayout.this.c + RefreshLayout.this.D, RefreshLayout.this.d.getTop(), f);
                        return;
                    default:
                        RefreshLayout.this.a(RefreshLayout.this.c, RefreshLayout.this.L.getTop(), f);
                        return;
                }
            }
        };
        this.ab = new Animation() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.4
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                if (RefreshLayout.this.L == null) {
                    return;
                }
                switch (AnonymousClass6.f9127a[RefreshLayout.this.K.ordinal()]) {
                    case 1:
                        RefreshLayout.this.a(RefreshLayout.this.D, RefreshLayout.this.d.getTop(), f);
                        return;
                    default:
                        RefreshLayout.this.a(0.0f, RefreshLayout.this.L.getTop(), f);
                        return;
                }
            }
        };
        this.ac = true;
        this.y = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f9120a = (int) (displayMetrics.density * 70.0f);
        this.c = displayMetrics.density * 70.0f;
        this.f9121b = 0.0f;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "constructor: " + this.f9121b);
        this.D = 0.0f;
        this.E = 1.0f;
        this.k = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        a(attributeSet);
        g();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    private float a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
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
        this.e.a();
        this.d.setVisibility(8);
        this.o = false;
        this.n = false;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "reset");
    }

    private void a(float f) {
        float f2 = f - this.z;
        if (this.o && (f2 > this.y || this.f9121b > 0.0f)) {
            this.q = true;
            this.B = this.z + this.y;
        } else if (this.q || f2 <= this.y) {
        } else {
            this.B = this.z + this.y;
            this.q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2, float f3) {
        setTargetOrRefreshViewOffsetY((int) (((int) (this.x + ((f - this.x) * f3))) - f2));
    }

    private void a(float f, boolean z) {
        float f2;
        float f3;
        int i = 0;
        this.C = f;
        if (this.Q == null || !this.Q.a(f, false)) {
            if (!this.o) {
                switch (this.K) {
                    case FLOAT:
                        f3 = this.D + this.N.a(f, this.c);
                        f2 = this.c;
                        break;
                    default:
                        f3 = this.N.a(f, this.c);
                        f2 = this.c;
                        break;
                }
            } else {
                float f4 = f > this.c ? this.c : f;
                float f5 = f4 >= 0.0f ? f4 : 0.0f;
                f2 = this.c;
                f3 = f5;
            }
            if (!this.o) {
                if (f3 > f2 && !this.p) {
                    this.p = true;
                    this.e.d();
                    if (this.R != null) {
                        this.R.a();
                    }
                    if (this.S != null) {
                        while (i < this.S.size()) {
                            this.S.get(i).a();
                            i++;
                        }
                    }
                } else if (f3 <= f2 && this.p) {
                    this.p = false;
                    this.e.e();
                    if (this.R != null) {
                        this.R.b();
                    }
                    if (this.S != null) {
                        while (i < this.S.size()) {
                            this.S.get(i).b();
                            i++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.a.b("RefreshLayout", f + " -- " + f2 + " -- " + f3 + " -- " + this.f9121b + " -- " + this.c);
            a((int) (f3 - this.f9121b), z);
        }
    }

    private void a(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        this.d.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    private void a(int i, boolean z) {
        if (this.L == null) {
            return;
        }
        switch (this.K) {
            case FLOAT:
                this.d.offsetTopAndBottom(i);
                this.f9121b = this.d.getTop();
                break;
            case PINNED:
                this.L.offsetTopAndBottom(i);
                if (this.G != null) {
                    this.G.offsetTopAndBottom(i);
                }
                this.f9121b = this.L.getTop();
                break;
            default:
                this.L.offsetTopAndBottom(i);
                if (this.G != null) {
                    this.G.offsetTopAndBottom(i);
                } else {
                    float f = (i / this.E) + this.F;
                    this.F = f - ((int) f);
                    this.d.offsetTopAndBottom((int) f);
                }
                this.f9121b = this.L.getTop();
                com.kwad.sdk.core.d.a.b("RefreshLayout", "refresh style" + this.f9121b);
                break;
        }
        com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f9121b);
        switch (this.K) {
            case FLOAT:
                this.e.a(this.f9121b, (this.f9121b - this.D) / this.c);
                if (this.R != null) {
                    this.R.a(this.f9121b, (this.f9121b - this.D) / this.c, z);
                }
                if (this.S != null) {
                    for (int i2 = 0; i2 < this.S.size(); i2++) {
                        this.S.get(i2).a(this.f9121b, (this.f9121b - this.D) / this.c, z);
                    }
                    break;
                }
                break;
            default:
                this.e.a(this.f9121b, this.f9121b / this.c);
                if (this.R != null) {
                    this.R.a(this.f9121b, this.f9121b / this.c, z);
                }
                if (this.S != null) {
                    for (int i3 = 0; i3 < this.S.size(); i3++) {
                        this.S.get(i3).a(this.f9121b, this.f9121b / this.c, z);
                    }
                    break;
                }
                break;
        }
        if (this.W && this.d.getVisibility() != 0) {
            this.d.setVisibility(0);
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        this.u = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
        this.B = a(motionEvent, this.u) - this.C;
        com.kwad.sdk.core.d.a.b("RefreshLayout", " onDown " + this.B);
    }

    private void a(boolean z, boolean z2) {
        if (this.o != z) {
            this.r = z2;
            this.o = z;
            if (z) {
                b((int) this.f9121b, this.P);
                return;
            }
            this.e.c();
            postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    RefreshLayout.this.a((int) RefreshLayout.this.f9121b, RefreshLayout.this.f);
                }
            }, this.e.f());
        }
    }

    private boolean a(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14 && (view instanceof AbsListView)) {
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(((ViewGroup) view).getChildAt(i))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    private int b(float f) {
        com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- refreshing " + f);
        switch (this.K) {
            case FLOAT:
                return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs((f - this.D) - this.c) / this.c)) * this.w);
            default:
                return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.c) / this.c)) * this.w);
        }
    }

    private int b(int i) {
        switch (this.K) {
            case FLOAT:
                return i;
            case PINNED:
                return i + ((int) this.f9121b);
            default:
                return i + ((int) this.f9121b);
        }
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        if (b(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i;
        this.aa.reset();
        this.aa.setDuration(b(i));
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

    private int c(float f) {
        com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- start " + f);
        if (f < this.D) {
            return 0;
        }
        switch (this.K) {
            case FLOAT:
                return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.D) / this.c)) * this.v);
            default:
                return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f) / this.c)) * this.v);
        }
    }

    private void c() {
        switch (this.K) {
            case FLOAT:
                setTargetOrRefreshViewOffsetY((int) (this.D - this.f9121b));
                return;
            default:
                setTargetOrRefreshViewOffsetY((int) (0.0f - this.f9121b));
                return;
        }
    }

    private void g() {
        this.N = b();
    }

    private int getTargetOrRefreshViewTop() {
        switch (this.K) {
            case FLOAT:
                return this.d.getTop();
            default:
                return this.L.getTop();
        }
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
        if (this.Q == null || !this.Q.a(this.C, true)) {
            if (d()) {
                a(true, true);
                return;
            }
            this.o = false;
            a((int) this.f9121b, this.f);
        }
    }

    private void k() {
        if (this.G != null) {
            this.G.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private void l() {
        if (m()) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!childAt.equals(this.d) && !childAt.equals(this.G)) {
                this.L = childAt;
                return;
            }
        }
    }

    private boolean m() {
        for (int i = 0; i < getChildCount(); i++) {
            if (this.L == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    protected int a(int i) {
        switch (this.K) {
            case FLOAT:
                return i + ((int) this.f9121b);
            case PINNED:
                return i;
            default:
                return i + ((int) this.f9121b);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        if (c(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i;
        this.ab.reset();
        this.ab.setDuration(c(i));
        this.ab.setInterpolator(this.T);
        if (animationListener != null) {
            this.ab.setAnimationListener(animationListener);
        }
        startAnimation(this.ab);
    }

    protected void a(AttributeSet attributeSet) {
        this.d = b(attributeSet);
        this.d.setVisibility(8);
        if (!(this.d instanceof com.kwad.sdk.contentalliance.refreshview.d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.e = (com.kwad.sdk.contentalliance.refreshview.d) this.d;
        a c2 = c(attributeSet);
        if (c2 == null) {
            c2 = new a(this.f9120a, this.f9120a);
        }
        addView(this.d, c2);
    }

    protected abstract View b(AttributeSet attributeSet);

    protected abstract com.kwad.sdk.contentalliance.refreshview.b b();

    protected a c(AttributeSet attributeSet) {
        return null;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: d */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected boolean d() {
        return !this.V && ((float) getTargetOrRefreshViewOffset()) > this.c;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.j.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.j.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.j.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ac) {
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 1:
                case 3:
                    onStopNestedScroll(this);
                    break;
            }
        }
        com.kwad.sdk.core.d.a.b("RefreshLayout", "dispatch " + this.s + " isRefreshing" + this.o);
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean e() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: f */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        switch (this.K) {
            case FLOAT:
                return this.t >= 0 ? i2 == i + (-1) ? this.t : i2 >= this.t ? i2 + 1 : i2 : i2;
            default:
                return this.t < 0 ? i2 : i2 == 0 ? this.t : i2 <= this.t ? i2 - 1 : i2;
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.k.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.c;
    }

    @Nullable
    public View getStateView() {
        return this.G;
    }

    public int getTargetOrRefreshViewOffset() {
        switch (this.K) {
            case FLOAT:
                return (int) (this.d.getTop() - this.D);
            default:
                if (this.L == null) {
                    return 0;
                }
                return this.L.getTop();
        }
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
    protected void onDetachedFromWindow() {
        a();
        this.O = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        l();
        if (this.L == null) {
            return false;
        }
        if (!(this.L instanceof com.kwad.sdk.contentalliance.refreshview.c) || ((com.kwad.sdk.contentalliance.refreshview.c) this.L).a()) {
            switch (this.K) {
                case FLOAT:
                    if (!isEnabled() || a(this.L) || this.o || this.m) {
                        return false;
                    }
                    break;
                default:
                    if (!isEnabled() || (a(this.L) && !this.s)) {
                        return false;
                    }
                    break;
            }
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    this.u = motionEvent.getPointerId(0);
                    this.q = false;
                    float a2 = a(motionEvent, this.u);
                    if (a2 != -1.0f) {
                        if (this.aa.hasEnded() && this.ab.hasEnded()) {
                            this.n = false;
                        }
                        this.z = a2;
                        this.A = this.f9121b;
                        this.s = false;
                        break;
                    } else {
                        return false;
                    }
                case 1:
                case 3:
                    this.q = false;
                    this.u = -1;
                    break;
                case 2:
                    if (this.u != -1) {
                        float a3 = a(motionEvent, this.u);
                        if (a3 != -1.0f) {
                            a(a3);
                            if (this.M != null && this.M.isRunning()) {
                                this.M.cancel();
                                this.e.c();
                                a((int) this.f9121b, this.f);
                                break;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case 6:
                    b(motionEvent);
                    break;
            }
            return this.q;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            return;
        }
        l();
        if (this.L != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.L.getVisibility() != 8 || (this.G != null && this.G.getVisibility() != 8)) {
                int b2 = b(getPaddingTop());
                int paddingLeft = getPaddingLeft();
                int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
                int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
                if (this.L.getVisibility() != 8) {
                    this.L.layout(paddingLeft, b2, paddingLeft2, paddingTop);
                }
                if (this.G != null && this.G.getVisibility() != 8) {
                    this.G.layout(paddingLeft, b2, paddingLeft2, paddingTop);
                }
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            int a2 = (a((int) this.D) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
            this.d.layout((measuredWidth - this.d.getMeasuredWidth()) / 2, a2, (measuredWidth + this.d.getMeasuredWidth()) / 2, this.d.getMeasuredHeight() + a2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        l();
        if (this.L == null) {
            return;
        }
        h();
        k();
        a(i, i2);
        if (!this.J && !this.I) {
            switch (this.K) {
                case FLOAT:
                    float f = -this.d.getMeasuredHeight();
                    this.D = f;
                    this.f9121b = f;
                    break;
                case PINNED:
                    this.D = 0.0f;
                    this.f9121b = 0.0f;
                    break;
                default:
                    this.f9121b = 0.0f;
                    this.D = -this.d.getMeasuredHeight();
                    break;
            }
        }
        if (!this.J && !this.H && this.c < this.d.getMeasuredHeight()) {
            this.c = this.d.getMeasuredHeight();
        }
        this.J = true;
        this.t = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.d) {
                this.t = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.l > 0.0f) {
            if (i2 > this.l) {
                iArr[1] = i2 - ((int) this.l);
                this.l = 0.0f;
            } else {
                this.l -= i2;
                iArr[1] = i2;
            }
            com.kwad.sdk.core.d.a.b("RefreshLayout", "pre scroll");
            a(this.l, false);
        }
        int[] iArr2 = this.h;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.i);
        int i5 = this.i[1] + i4;
        if (i5 < 0) {
            this.l = Math.abs(i5) + this.l;
            com.kwad.sdk.core.d.a.b("RefreshLayout", "nested scroll");
            a(this.l, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.k.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.l = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        switch (this.K) {
            case FLOAT:
                return isEnabled() && a(this.L) && !this.o && (i & 2) != 0;
            default:
                return isEnabled() && a(this.L) && (i & 2) != 0;
        }
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
        float f;
        l();
        if (this.L == null) {
            return false;
        }
        switch (this.K) {
            case FLOAT:
                if (!isEnabled() || a(this.L) || this.m) {
                    return false;
                }
                break;
            default:
                if (!isEnabled() || (a(this.L) && !this.s)) {
                    return false;
                }
                break;
        }
        if (this.K == RefreshStyle.FLOAT && (a(this.L) || this.m)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.u = MotionEventCompat.getPointerId(motionEvent, 0);
                this.q = false;
                break;
            case 1:
            case 3:
                if (this.u == -1 || a(motionEvent, this.u) == -1.0f) {
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
            case 2:
                if (this.u != -1) {
                    float a2 = a(motionEvent, this.u);
                    if (a2 != -1.0f) {
                        if (this.n) {
                            f = getTargetOrRefreshViewTop();
                            this.B = a2;
                            this.A = f;
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "animatetostart overscrolly " + f + " -- " + this.B);
                        } else {
                            f = (a2 - this.B) + this.A;
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "overscrolly " + f + " --" + this.B + " -- " + this.A);
                        }
                        if (!this.o) {
                            if (!this.q) {
                                com.kwad.sdk.core.d.a.b("RefreshLayout", "is not Being Dragged, init drag status");
                                a(a2);
                                break;
                            } else if (f <= 0.0f) {
                                com.kwad.sdk.core.d.a.b("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                                return false;
                            } else {
                                a(f, true);
                                com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner not refreshing -- " + this.A + " -- " + (a2 - this.B));
                                break;
                            }
                        } else {
                            if (f <= 0.0f) {
                                if (this.s) {
                                    this.L.dispatchTouchEvent(motionEvent);
                                } else {
                                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                                    obtain.setAction(0);
                                    this.s = true;
                                    this.L.dispatchTouchEvent(obtain);
                                }
                            } else if (f > 0.0f && f < this.c && this.s) {
                                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                                obtain2.setAction(3);
                                this.s = false;
                                this.L.dispatchTouchEvent(obtain2);
                            }
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner refreshing -- " + this.A + " -- " + (a2 - this.B));
                            a(f, true);
                            break;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 5:
                a(motionEvent);
                break;
            case 6:
                b(motionEvent);
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.L instanceof AbsListView)) {
            if (this.L == null || ViewCompat.isNestedScrollingEnabled(this.L)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimateToRefreshDuration(int i) {
        this.w = i;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.U = interpolator;
    }

    public void setAnimateToStartDuration(int i) {
        this.v = i;
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

    public void setRefreshInitialOffset(float f) {
        this.D = f;
        this.I = true;
        requestLayout();
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        this.K = refreshStyle;
    }

    public void setRefreshTargetOffset(float f) {
        this.c = f;
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
        b((int) this.f9121b, this.P);
    }

    public void setShowRefreshView(boolean z) {
        setOnlySupportPull(!z);
        this.W = z;
    }

    public void setTargetOrRefreshViewOffsetY(int i) {
        a(i, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.j.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }
}
