package com.kwad.sdk.contentalliance.refreshview;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
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
    public float A;
    public float B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public RefreshStyle G;
    public View H;
    public com.kwad.sdk.contentalliance.refreshview.a I;
    public a J;
    public final Animation.AnimationListener K;
    public c L;
    public b M;
    public List<b> N;
    public Interpolator O;
    public Interpolator P;
    public boolean Q;
    public boolean R;
    public final Animation S;
    public final Animation T;
    public boolean U;
    public float a;
    public float b;
    public View c;
    public com.kwad.sdk.contentalliance.refreshview.b d;
    public final Animation.AnimationListener e;
    public final NestedScrollingChildHelper f;
    public final NestedScrollingParentHelper g;
    public float h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshStyle.values().length];
            a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(float f, float f2, boolean z);

        void b();
    }

    /* loaded from: classes5.dex */
    public interface c {
        boolean a(float f, boolean z);
    }

    private float a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void a(float f) {
        float f2 = f - this.v;
        if (this.k && (f2 > this.u || this.a > 0.0f)) {
            this.m = true;
            this.x = this.v + this.u;
        } else if (this.m) {
        } else {
            int i = this.u;
            if (f2 > i) {
                this.x = this.v + i;
                this.m = true;
            }
        }
    }

    private void a(float f, boolean z) {
        float f2;
        this.y = f;
        c cVar = this.L;
        int i = 0;
        if (cVar == null || !cVar.a(f, false)) {
            if (this.k) {
                f2 = this.b;
                if (f <= f2) {
                    f2 = f;
                }
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
            } else {
                f2 = AnonymousClass2.a[this.G.ordinal()] != 1 ? this.I.a(f, this.b) : this.z + this.I.a(f, this.b);
            }
            float f3 = this.b;
            if (!this.k) {
                if (f2 > f3 && !this.l) {
                    this.l = true;
                    this.d.c();
                    b bVar = this.M;
                    if (bVar != null) {
                        bVar.a();
                    }
                    if (this.N != null) {
                        while (i < this.N.size()) {
                            this.N.get(i).a();
                            i++;
                        }
                    }
                } else if (f2 <= f3 && this.l) {
                    this.l = false;
                    this.d.d();
                    b bVar2 = this.M;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    if (this.N != null) {
                        while (i < this.N.size()) {
                            this.N.get(i).b();
                            i++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.a.c("RefreshLayout", f + " -- " + f3 + " -- " + f2 + " -- " + this.a + " -- " + this.b);
            a((int) (f2 - this.a), z);
        }
    }

    private void a(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        this.c.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, boolean z) {
        View view2;
        if (this.H == null) {
            return;
        }
        int i2 = AnonymousClass2.a[this.G.ordinal()];
        if (i2 == 1) {
            this.c.offsetTopAndBottom(i);
            view2 = this.c;
        } else if (i2 != 2) {
            this.H.offsetTopAndBottom(i);
            View view3 = this.C;
            if (view3 != null) {
                view3.offsetTopAndBottom(i);
            } else {
                float f = (i / this.A) + this.B;
                int i3 = (int) f;
                this.B = f - i3;
                this.c.offsetTopAndBottom(i3);
            }
            this.a = this.H.getTop();
            com.kwad.sdk.core.d.a.c("RefreshLayout", "refresh style" + this.a);
            com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.a);
            if (AnonymousClass2.a[this.G.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.b bVar = this.d;
                float f2 = this.a;
                bVar.a(f2, f2 / this.b);
                b bVar2 = this.M;
                if (bVar2 != null) {
                    float f3 = this.a;
                    bVar2.a(f3, f3 / this.b, z);
                }
                if (this.N != null) {
                    for (int i4 = 0; i4 < this.N.size(); i4++) {
                        float f4 = this.a;
                        this.N.get(i4).a(f4, f4 / this.b, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.b bVar3 = this.d;
                float f5 = this.a;
                bVar3.a(f5, (f5 - this.z) / this.b);
                b bVar4 = this.M;
                if (bVar4 != null) {
                    float f6 = this.a;
                    bVar4.a(f6, (f6 - this.z) / this.b, z);
                }
                if (this.N != null) {
                    for (int i5 = 0; i5 < this.N.size(); i5++) {
                        float f7 = this.a;
                        this.N.get(i5).a(f7, (f7 - this.z) / this.b, z);
                    }
                }
            }
            if (this.R && this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            invalidate();
        } else {
            this.H.offsetTopAndBottom(i);
            View view4 = this.C;
            if (view4 != null) {
                view4.offsetTopAndBottom(i);
            }
            view2 = this.H;
        }
        this.a = view2.getTop();
        com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.a);
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
        }
        if (this.R) {
            this.c.setVisibility(0);
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
        this.q = pointerId;
        this.x = a(motionEvent, pointerId) - this.y;
        com.kwad.sdk.core.d.a.c("RefreshLayout", " onDown " + this.x);
    }

    private void a(boolean z, boolean z2) {
        if (this.k != z) {
            this.n = z2;
            this.k = z;
            if (z) {
                b((int) this.a, this.K);
                return;
            }
            this.d.b();
            postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.a((int) refreshLayout.a, refreshLayout.e);
                }
            }, this.d.e());
        }
    }

    private boolean a(View view2) {
        if (view2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14 && (view2 instanceof AbsListView)) {
            AbsListView absListView = (AbsListView) view2;
            if (absListView.getChildCount() > 0) {
                return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
            }
            return false;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view2, -1);
    }

    private int b(float f) {
        com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- refreshing " + f);
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
            f -= this.z;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.b) / this.b)) * this.s);
    }

    private int b(int i) {
        return AnonymousClass2.a[this.G.ordinal()] != 1 ? i + ((int) this.a) : i;
    }

    private void b() {
        c();
        this.y = 0.0f;
        this.B = 0.0f;
        this.d.a();
        this.c.setVisibility(8);
        this.k = false;
        this.j = false;
        com.kwad.sdk.core.d.a.c("RefreshLayout", "reset");
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        float f;
        clearAnimation();
        if (b(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.t = i;
        this.S.reset();
        this.S.setDuration(b(f));
        this.S.setInterpolator(this.P);
        if (animationListener != null) {
            this.S.setAnimationListener(animationListener);
        }
        startAnimation(this.S);
    }

    private void b(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.q) {
            this.q = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
        this.x = a(motionEvent, this.q) - this.y;
        com.kwad.sdk.core.d.a.c("RefreshLayout", " onUp " + this.x);
    }

    private int c(float f) {
        com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- start " + f);
        if (f < this.z) {
            return 0;
        }
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
            f -= this.z;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f) / this.b)) * this.r);
    }

    private void c() {
        setTargetOrRefreshViewOffsetY((int) ((AnonymousClass2.a[this.G.ordinal()] != 1 ? 0.0f : this.z) - this.a));
    }

    private void d() {
        this.H.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private void e() {
        this.w = 0.0f;
        this.m = false;
        this.o = false;
        this.q = -1;
    }

    private void f() {
        if (this.k || this.j) {
            return;
        }
        c cVar = this.L;
        if (cVar == null || !cVar.a(this.y, true)) {
            if (a()) {
                a(true, true);
                return;
            }
            this.k = false;
            a((int) this.a, this.e);
        }
    }

    private void g() {
        View view2 = this.C;
        if (view2 != null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private int getTargetOrRefreshViewTop() {
        return (AnonymousClass2.a[this.G.ordinal()] != 1 ? this.H : this.c).getTop();
    }

    private void h() {
        if (i()) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!childAt.equals(this.c) && !childAt.equals(this.C)) {
                this.H = childAt;
                return;
            }
        }
    }

    private boolean i() {
        for (int i = 0; i < getChildCount(); i++) {
            if (this.H == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    public int a(int i) {
        int i2 = AnonymousClass2.a[this.G.ordinal()];
        return (i2 == 1 || i2 != 2) ? i + ((int) this.a) : i;
    }

    public void a(int i, Animation.AnimationListener animationListener) {
        float f;
        clearAnimation();
        if (c(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.t = i;
        this.T.reset();
        this.T.setDuration(c(f));
        this.T.setInterpolator(this.O);
        if (animationListener != null) {
            this.T.setAnimationListener(animationListener);
        }
        startAnimation(this.T);
    }

    public boolean a() {
        return !this.Q && ((float) getTargetOrRefreshViewOffset()) > this.b;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (this.U && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
            onStopNestedScroll(this);
        }
        com.kwad.sdk.core.d.a.c("RefreshLayout", "dispatch " + this.o + " isRefreshing" + this.k);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.g.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.b;
    }

    @Nullable
    public View getStateView() {
        return this.C;
    }

    public int getTargetOrRefreshViewOffset() {
        if (AnonymousClass2.a[this.G.ordinal()] != 1) {
            View view2 = this.H;
            if (view2 == null) {
                return 0;
            }
            return view2.getTop();
        }
        return (int) (this.c.getTop() - this.z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b();
        this.J = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view2;
        if (getChildCount() == 0) {
            return;
        }
        h();
        if (this.H == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.H.getVisibility() != 8 || ((view2 = this.C) != null && view2.getVisibility() != 8)) {
            int b2 = b(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
            if (this.H.getVisibility() != 8) {
                this.H.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
            View view3 = this.C;
            if (view3 != null && view3.getVisibility() != 8) {
                this.C.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        int a2 = (a((int) this.z) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.c.layout((measuredWidth - this.c.getMeasuredWidth()) / 2, a2, (measuredWidth + this.c.getMeasuredWidth()) / 2, this.c.getMeasuredHeight() + a2);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        h();
        if (this.H == null) {
            return;
        }
        d();
        g();
        a(i, i2);
        if (!this.F && !this.E) {
            int i3 = AnonymousClass2.a[this.G.ordinal()];
            if (i3 == 1) {
                float f = -this.c.getMeasuredHeight();
                this.z = f;
                this.a = f;
            } else if (i3 != 2) {
                this.a = 0.0f;
                this.z = -this.c.getMeasuredHeight();
            } else {
                this.z = 0.0f;
                this.a = 0.0f;
            }
        }
        if (!this.F && !this.D && this.b < this.c.getMeasuredHeight()) {
            this.b = this.c.getMeasuredHeight();
        }
        this.F = true;
        this.p = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.c) {
                this.p = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        this.g.onStopNestedScroll(view2);
        this.i = false;
        if (this.h > 0.0f) {
            f();
            this.h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        StringBuilder sb;
        float f2;
        h();
        if (this.H == null) {
            return false;
        }
        if (AnonymousClass2.a[this.G.ordinal()] != 1) {
            if (!isEnabled() || (a(this.H) && !this.o)) {
                return false;
            }
        } else if (!isEnabled() || a(this.H) || this.i) {
            return false;
        }
        if (this.G == RefreshStyle.FLOAT && (a(this.H) || this.i)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.q;
                    if (i == -1) {
                        return false;
                    }
                    float a2 = a(motionEvent, i);
                    if (a2 == -1.0f) {
                        return false;
                    }
                    if (this.j) {
                        f = getTargetOrRefreshViewTop();
                        this.x = a2;
                        this.w = f;
                        sb = new StringBuilder();
                        sb.append("animatetostart overscrolly ");
                        sb.append(f);
                        sb.append(" -- ");
                        f2 = this.x;
                    } else {
                        f = (a2 - this.x) + this.w;
                        sb = new StringBuilder();
                        sb.append("overscrolly ");
                        sb.append(f);
                        sb.append(" --");
                        sb.append(this.x);
                        sb.append(" -- ");
                        f2 = this.w;
                    }
                    sb.append(f2);
                    com.kwad.sdk.core.d.a.c("RefreshLayout", sb.toString());
                    if (this.k) {
                        if (f > 0.0f) {
                            if (f > 0.0f && f < this.b && this.o) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(3);
                                this.o = false;
                            }
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                            a(f, true);
                        } else if (!this.o) {
                            motionEvent = MotionEvent.obtain(motionEvent);
                            motionEvent.setAction(0);
                            this.o = true;
                        }
                        this.H.dispatchTouchEvent(motionEvent);
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                        a(f, true);
                    } else if (!this.m) {
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "is not Being Dragged, init drag status");
                        a(a2);
                    } else if (f <= 0.0f) {
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                        return false;
                    } else {
                        a(f, true);
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner not refreshing -- " + this.w + " -- " + (a2 - this.x));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        a(motionEvent);
                    } else if (action == 6) {
                        b(motionEvent);
                    }
                }
            }
            int i2 = this.q;
            if (i2 == -1 || a(motionEvent, i2) == -1.0f) {
                e();
                return false;
            } else if (!this.k && !this.j) {
                e();
                f();
                return false;
            } else {
                if (this.o) {
                    this.H.dispatchTouchEvent(motionEvent);
                }
                e();
                return false;
            }
        }
        this.q = MotionEventCompat.getPointerId(motionEvent, 0);
        this.m = false;
        return true;
    }

    public void setAnimateToRefreshDuration(int i) {
        this.s = i;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.P = interpolator;
    }

    public void setAnimateToStartDuration(int i) {
        this.r = i;
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        this.O = interpolator;
    }

    public void setDragDistanceConverter(@NonNull com.kwad.sdk.contentalliance.refreshview.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("the dragDistanceConverter can't be null");
        }
        this.I = aVar;
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        this.U = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f.setNestedScrollingEnabled(z);
    }

    public void setOnRefreshListener(a aVar) {
        this.J = aVar;
    }

    public void setOnRefreshStatusListener(b bVar) {
        this.M = bVar;
    }

    public void setOnScrollInterceptor(c cVar) {
        this.L = cVar;
    }

    public void setOnlySupportPull(boolean z) {
        this.Q = z;
    }

    public void setRefreshInitialOffset(float f) {
        this.z = f;
        this.E = true;
        requestLayout();
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        this.G = refreshStyle;
    }

    public void setRefreshTargetOffset(float f) {
        this.b = f;
        this.D = true;
        requestLayout();
    }

    public void setRefreshing(boolean z) {
        if (this.k == z) {
            return;
        }
        if (!z) {
            a(z, false);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded()) {
            getAnimation().setAnimationListener(null);
            clearAnimation();
            b();
        }
        this.k = z;
        this.n = false;
        b((int) this.a, this.K);
    }

    public void setShowRefreshView(boolean z) {
        setOnlySupportPull(!z);
        this.R = z;
    }

    public void setTargetOrRefreshViewOffsetY(int i) {
        a(i, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f.stopNestedScroll();
    }
}
