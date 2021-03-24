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
    public int f32955a;
    public final Animation aa;
    public final Animation ab;
    public boolean ac;

    /* renamed from: b  reason: collision with root package name */
    public float f32956b;

    /* renamed from: c  reason: collision with root package name */
    public float f32957c;

    /* renamed from: d  reason: collision with root package name */
    public View f32958d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.refreshview.d f32959e;

    /* renamed from: f  reason: collision with root package name */
    public final Animation.AnimationListener f32960f;

    /* renamed from: g  reason: collision with root package name */
    public final String f32961g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f32962h;
    public final int[] i;
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
        public static final /* synthetic */ int[] f32968a;

        static {
            int[] iArr = new int[RefreshStyle.values().length];
            f32968a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32968a[RefreshStyle.PINNED.ordinal()] = 2;
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
        this.f32961g = "RefreshLayout";
        this.f32962h = new int[2];
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
                RefreshLayout.this.f32959e.b();
            }
        };
        this.f32960f = new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RefreshLayout.this.a();
                if (RefreshLayout.this.R != null) {
                    RefreshLayout.this.R.c();
                }
                if (RefreshLayout.this.S != null) {
                    for (int i = 0; i < RefreshLayout.this.S.size(); i++) {
                        ((c) RefreshLayout.this.S.get(i)).c();
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
                if (AnonymousClass6.f32968a[RefreshLayout.this.K.ordinal()] != 1) {
                    refreshLayout = RefreshLayout.this;
                    f3 = refreshLayout.f32957c;
                    view = refreshLayout.L;
                } else {
                    RefreshLayout refreshLayout2 = RefreshLayout.this;
                    f3 = refreshLayout2.f32957c + refreshLayout2.D;
                    refreshLayout = RefreshLayout.this;
                    view = refreshLayout.f32958d;
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
                if (AnonymousClass6.f32968a[RefreshLayout.this.K.ordinal()] != 1) {
                    refreshLayout = RefreshLayout.this;
                    f3 = 0.0f;
                    view = refreshLayout.L;
                } else {
                    refreshLayout = RefreshLayout.this;
                    f3 = refreshLayout.D;
                    view = RefreshLayout.this.f32958d;
                }
                refreshLayout.a(f3, view.getTop(), f2);
            }
        };
        this.ac = true;
        this.y = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = getResources().getDisplayMetrics().density;
        this.f32955a = (int) (f2 * 70.0f);
        this.f32957c = f2 * 70.0f;
        this.f32956b = 0.0f;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "constructor: " + this.f32956b);
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
        this.f32959e.a();
        this.f32958d.setVisibility(8);
        this.o = false;
        this.n = false;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "reset");
    }

    private void a(float f2) {
        float f3 = f2 - this.z;
        if (this.o && (f3 > this.y || this.f32956b > 0.0f)) {
            this.q = true;
            this.B = this.z + this.y;
        } else if (this.q) {
        } else {
            int i = this.y;
            if (f3 > i) {
                this.B = this.z + i;
                this.q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        int i = this.x;
        setTargetOrRefreshViewOffsetY((int) (((int) (i + ((f2 - i) * f4))) - f3));
    }

    private void a(float f2, boolean z) {
        float f3;
        this.C = f2;
        d dVar = this.Q;
        int i = 0;
        if (dVar == null || !dVar.a(f2, false)) {
            if (this.o) {
                f3 = this.f32957c;
                if (f2 <= f3) {
                    f3 = f2;
                }
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
            } else {
                f3 = AnonymousClass6.f32968a[this.K.ordinal()] != 1 ? this.N.a(f2, this.f32957c) : this.D + this.N.a(f2, this.f32957c);
            }
            float f4 = this.f32957c;
            if (!this.o) {
                if (f3 > f4 && !this.p) {
                    this.p = true;
                    this.f32959e.d();
                    c cVar = this.R;
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (this.S != null) {
                        while (i < this.S.size()) {
                            this.S.get(i).a();
                            i++;
                        }
                    }
                } else if (f3 <= f4 && this.p) {
                    this.p = false;
                    this.f32959e.e();
                    c cVar2 = this.R;
                    if (cVar2 != null) {
                        cVar2.b();
                    }
                    if (this.S != null) {
                        while (i < this.S.size()) {
                            this.S.get(i).b();
                            i++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.a.b("RefreshLayout", f2 + " -- " + f4 + " -- " + f3 + " -- " + this.f32956b + " -- " + this.f32957c);
            a((int) (f3 - this.f32956b), z);
        }
    }

    private void a(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32958d.getLayoutParams();
        this.f32958d.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, boolean z) {
        View view;
        if (this.L == null) {
            return;
        }
        int i2 = AnonymousClass6.f32968a[this.K.ordinal()];
        if (i2 == 1) {
            this.f32958d.offsetTopAndBottom(i);
            view = this.f32958d;
        } else if (i2 != 2) {
            this.L.offsetTopAndBottom(i);
            View view2 = this.G;
            if (view2 != null) {
                view2.offsetTopAndBottom(i);
            } else {
                float f2 = (i / this.E) + this.F;
                int i3 = (int) f2;
                this.F = f2 - i3;
                this.f32958d.offsetTopAndBottom(i3);
            }
            this.f32956b = this.L.getTop();
            com.kwad.sdk.core.d.a.b("RefreshLayout", "refresh style" + this.f32956b);
            com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f32956b);
            if (AnonymousClass6.f32968a[this.K.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.d dVar = this.f32959e;
                float f3 = this.f32956b;
                dVar.a(f3, f3 / this.f32957c);
                c cVar = this.R;
                if (cVar != null) {
                    float f4 = this.f32956b;
                    cVar.a(f4, f4 / this.f32957c, z);
                }
                if (this.S != null) {
                    for (int i4 = 0; i4 < this.S.size(); i4++) {
                        float f5 = this.f32956b;
                        this.S.get(i4).a(f5, f5 / this.f32957c, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.d dVar2 = this.f32959e;
                float f6 = this.f32956b;
                dVar2.a(f6, (f6 - this.D) / this.f32957c);
                c cVar2 = this.R;
                if (cVar2 != null) {
                    float f7 = this.f32956b;
                    cVar2.a(f7, (f7 - this.D) / this.f32957c, z);
                }
                if (this.S != null) {
                    for (int i5 = 0; i5 < this.S.size(); i5++) {
                        float f8 = this.f32956b;
                        this.S.get(i5).a(f8, (f8 - this.D) / this.f32957c, z);
                    }
                }
            }
            if (this.W && this.f32958d.getVisibility() != 0) {
                this.f32958d.setVisibility(0);
            }
            invalidate();
        } else {
            this.L.offsetTopAndBottom(i);
            View view3 = this.G;
            if (view3 != null) {
                view3.offsetTopAndBottom(i);
            }
            view = this.L;
        }
        this.f32956b = view.getTop();
        com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f32956b);
        if (AnonymousClass6.f32968a[this.K.ordinal()] == 1) {
        }
        if (this.W) {
            this.f32958d.setVisibility(0);
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
                b((int) this.f32956b, this.P);
                return;
            }
            this.f32959e.c();
            postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.a((int) refreshLayout.f32956b, refreshLayout.f32960f);
                }
            }, this.f32959e.f());
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
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    private int b(float f2) {
        com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- refreshing " + f2);
        if (AnonymousClass6.f32968a[this.K.ordinal()] == 1) {
            f2 -= this.D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.f32957c) / this.f32957c)) * this.w);
    }

    private int b(int i) {
        return AnonymousClass6.f32968a[this.K.ordinal()] != 1 ? i + ((int) this.f32956b) : i;
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (b(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i;
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
        if (AnonymousClass6.f32968a[this.K.ordinal()] == 1) {
            f2 -= this.D;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.f32957c)) * this.v);
    }

    private void c() {
        setTargetOrRefreshViewOffsetY((int) ((AnonymousClass6.f32968a[this.K.ordinal()] != 1 ? 0.0f : this.D) - this.f32956b));
    }

    private void g() {
        this.N = b();
    }

    private int getTargetOrRefreshViewTop() {
        return (AnonymousClass6.f32968a[this.K.ordinal()] != 1 ? this.L : this.f32958d).getTop();
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
            a((int) this.f32956b, this.f32960f);
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
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!childAt.equals(this.f32958d) && !childAt.equals(this.G)) {
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

    public int a(int i) {
        int i2 = AnonymousClass6.f32968a[this.K.ordinal()];
        return (i2 == 1 || i2 != 2) ? i + ((int) this.f32956b) : i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void a(int i, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (c(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.x = i;
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
        this.f32958d = b2;
        b2.setVisibility(8);
        View view = this.f32958d;
        if (!(view instanceof com.kwad.sdk.contentalliance.refreshview.d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.f32959e = (com.kwad.sdk.contentalliance.refreshview.d) view;
        a c2 = c(attributeSet);
        if (c2 == null) {
            int i = this.f32955a;
            c2 = new a(i, i);
        }
        addView(this.f32958d, c2);
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
        return !this.V && ((float) getTargetOrRefreshViewOffset()) > this.f32957c;
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
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.j.dispatchNestedScroll(i, i2, i3, i4, iArr);
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
    public int getChildDrawingOrder(int i, int i2) {
        if (AnonymousClass6.f32968a[this.K.ordinal()] != 1) {
            int i3 = this.t;
            return i3 < 0 ? i2 : i2 == 0 ? i3 : i2 <= i3 ? i2 - 1 : i2;
        }
        int i4 = this.t;
        return i4 < 0 ? i2 : i2 == i - 1 ? i4 : i2 >= i4 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.k.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.f32957c;
    }

    @Nullable
    public View getStateView() {
        return this.G;
    }

    public int getTargetOrRefreshViewOffset() {
        if (AnonymousClass6.f32968a[this.K.ordinal()] != 1) {
            View view = this.L;
            if (view == null) {
                return 0;
            }
            return view.getTop();
        }
        return (int) (this.f32958d.getTop() - this.D);
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
            if (AnonymousClass6.f32968a[this.K.ordinal()] != 1) {
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
                        int i = this.u;
                        if (i == -1) {
                            return false;
                        }
                        float a2 = a(motionEvent, i);
                        if (a2 == -1.0f) {
                            return false;
                        }
                        a(a2);
                        ValueAnimator valueAnimator = this.M;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            this.M.cancel();
                            this.f32959e.c();
                            a((int) this.f32956b, this.f32960f);
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
                this.A = this.f32956b;
                this.s = false;
            }
            return this.q;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32958d.getLayoutParams();
        int a2 = (a((int) this.D) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.f32958d.layout((measuredWidth - this.f32958d.getMeasuredWidth()) / 2, a2, (measuredWidth + this.f32958d.getMeasuredWidth()) / 2, this.f32958d.getMeasuredHeight() + a2);
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
            int i3 = AnonymousClass6.f32968a[this.K.ordinal()];
            if (i3 == 1) {
                float f2 = -this.f32958d.getMeasuredHeight();
                this.D = f2;
                this.f32956b = f2;
            } else if (i3 != 2) {
                this.f32956b = 0.0f;
                this.D = -this.f32958d.getMeasuredHeight();
            } else {
                this.D = 0.0f;
                this.f32956b = 0.0f;
            }
        }
        if (!this.J && !this.H && this.f32957c < this.f32958d.getMeasuredHeight()) {
            this.f32957c = this.f32958d.getMeasuredHeight();
        }
        this.J = true;
        this.t = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.f32958d) {
                this.t = i4;
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
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f2 = this.l;
            if (f2 > 0.0f) {
                float f3 = i2;
                if (f3 > f2) {
                    iArr[1] = i2 - ((int) f2);
                    this.l = 0.0f;
                } else {
                    this.l = f2 - f3;
                    iArr[1] = i2;
                }
                com.kwad.sdk.core.d.a.b("RefreshLayout", "pre scroll");
                a(this.l, false);
            }
        }
        int[] iArr2 = this.f32962h;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5;
        dispatchNestedScroll(i, i2, i3, i4, this.i);
        if (i4 + this.i[1] < 0) {
            this.l += Math.abs(i5);
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
        return AnonymousClass6.f32968a[this.K.ordinal()] != 1 ? isEnabled() && a(this.L) && (i & 2) != 0 : isEnabled() && a(this.L) && !this.o && (i & 2) != 0;
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
        if (AnonymousClass6.f32968a[this.K.ordinal()] != 1) {
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
                    int i = this.u;
                    if (i == -1) {
                        return false;
                    }
                    float a2 = a(motionEvent, i);
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
                            if (f2 > 0.0f && f2 < this.f32957c && this.s) {
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
            int i2 = this.u;
            if (i2 == -1 || a(motionEvent, i2) == -1.0f) {
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

    public void setRefreshInitialOffset(float f2) {
        this.D = f2;
        this.I = true;
        requestLayout();
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        this.K = refreshStyle;
    }

    public void setRefreshTargetOffset(float f2) {
        this.f32957c = f2;
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
        b((int) this.f32956b, this.P);
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
