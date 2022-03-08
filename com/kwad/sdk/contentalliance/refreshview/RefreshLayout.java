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
/* loaded from: classes7.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public float f54152b;

    /* renamed from: c  reason: collision with root package name */
    public View f54153c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.refreshview.b f54154d;

    /* renamed from: e  reason: collision with root package name */
    public final Animation.AnimationListener f54155e;

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollingChildHelper f54156f;

    /* renamed from: g  reason: collision with root package name */
    public final NestedScrollingParentHelper f54157g;

    /* renamed from: h  reason: collision with root package name */
    public float f54158h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54159i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f54160j;
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
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void a(float f2, float f3, boolean z);

        void b();
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(float f2, boolean z);
    }

    private float a(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void a(float f2) {
        float f3 = f2 - this.v;
        if (this.k && (f3 > this.u || this.a > 0.0f)) {
            this.m = true;
            this.x = this.v + this.u;
        } else if (this.m) {
        } else {
            int i2 = this.u;
            if (f3 > i2) {
                this.x = this.v + i2;
                this.m = true;
            }
        }
    }

    private void a(float f2, boolean z) {
        float f3;
        this.y = f2;
        c cVar = this.L;
        int i2 = 0;
        if (cVar == null || !cVar.a(f2, false)) {
            if (this.k) {
                f3 = this.f54152b;
                if (f2 <= f3) {
                    f3 = f2;
                }
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
            } else {
                f3 = AnonymousClass2.a[this.G.ordinal()] != 1 ? this.I.a(f2, this.f54152b) : this.z + this.I.a(f2, this.f54152b);
            }
            float f4 = this.f54152b;
            if (!this.k) {
                if (f3 > f4 && !this.l) {
                    this.l = true;
                    this.f54154d.c();
                    b bVar = this.M;
                    if (bVar != null) {
                        bVar.a();
                    }
                    if (this.N != null) {
                        while (i2 < this.N.size()) {
                            this.N.get(i2).a();
                            i2++;
                        }
                    }
                } else if (f3 <= f4 && this.l) {
                    this.l = false;
                    this.f54154d.d();
                    b bVar2 = this.M;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    if (this.N != null) {
                        while (i2 < this.N.size()) {
                            this.N.get(i2).b();
                            i2++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.a.c("RefreshLayout", f2 + " -- " + f4 + " -- " + f3 + " -- " + this.a + " -- " + this.f54152b);
            a((int) (f3 - this.a), z);
        }
    }

    private void a(int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f54153c.getLayoutParams();
        this.f54153c.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, boolean z) {
        View view;
        if (this.H == null) {
            return;
        }
        int i3 = AnonymousClass2.a[this.G.ordinal()];
        if (i3 == 1) {
            this.f54153c.offsetTopAndBottom(i2);
            view = this.f54153c;
        } else if (i3 != 2) {
            this.H.offsetTopAndBottom(i2);
            View view2 = this.C;
            if (view2 != null) {
                view2.offsetTopAndBottom(i2);
            } else {
                float f2 = (i2 / this.A) + this.B;
                int i4 = (int) f2;
                this.B = f2 - i4;
                this.f54153c.offsetTopAndBottom(i4);
            }
            this.a = this.H.getTop();
            com.kwad.sdk.core.d.a.c("RefreshLayout", "refresh style" + this.a);
            com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.a);
            if (AnonymousClass2.a[this.G.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.b bVar = this.f54154d;
                float f3 = this.a;
                bVar.a(f3, f3 / this.f54152b);
                b bVar2 = this.M;
                if (bVar2 != null) {
                    float f4 = this.a;
                    bVar2.a(f4, f4 / this.f54152b, z);
                }
                if (this.N != null) {
                    for (int i5 = 0; i5 < this.N.size(); i5++) {
                        float f5 = this.a;
                        this.N.get(i5).a(f5, f5 / this.f54152b, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.b bVar3 = this.f54154d;
                float f6 = this.a;
                bVar3.a(f6, (f6 - this.z) / this.f54152b);
                b bVar4 = this.M;
                if (bVar4 != null) {
                    float f7 = this.a;
                    bVar4.a(f7, (f7 - this.z) / this.f54152b, z);
                }
                if (this.N != null) {
                    for (int i6 = 0; i6 < this.N.size(); i6++) {
                        float f8 = this.a;
                        this.N.get(i6).a(f8, (f8 - this.z) / this.f54152b, z);
                    }
                }
            }
            if (this.R && this.f54153c.getVisibility() != 0) {
                this.f54153c.setVisibility(0);
            }
            invalidate();
        } else {
            this.H.offsetTopAndBottom(i2);
            View view3 = this.C;
            if (view3 != null) {
                view3.offsetTopAndBottom(i2);
            }
            view = this.H;
        }
        this.a = view.getTop();
        com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.a);
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
        }
        if (this.R) {
            this.f54153c.setVisibility(0);
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
            this.f54154d.b();
            postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.a((int) refreshLayout.a, refreshLayout.f54155e);
                }
            }, this.f54154d.e());
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
        com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- refreshing " + f2);
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
            f2 -= this.z;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.f54152b) / this.f54152b)) * this.s);
    }

    private int b(int i2) {
        return AnonymousClass2.a[this.G.ordinal()] != 1 ? i2 + ((int) this.a) : i2;
    }

    private void b() {
        c();
        this.y = 0.0f;
        this.B = 0.0f;
        this.f54154d.a();
        this.f54153c.setVisibility(8);
        this.k = false;
        this.f54160j = false;
        com.kwad.sdk.core.d.a.c("RefreshLayout", "reset");
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (b(i2) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.t = i2;
        this.S.reset();
        this.S.setDuration(b(f2));
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

    private int c(float f2) {
        com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- start " + f2);
        if (f2 < this.z) {
            return 0;
        }
        if (AnonymousClass2.a[this.G.ordinal()] == 1) {
            f2 -= this.z;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.f54152b)) * this.r);
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
        if (this.k || this.f54160j) {
            return;
        }
        c cVar = this.L;
        if (cVar == null || !cVar.a(this.y, true)) {
            if (a()) {
                a(true, true);
                return;
            }
            this.k = false;
            a((int) this.a, this.f54155e);
        }
    }

    private void g() {
        View view = this.C;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private int getTargetOrRefreshViewTop() {
        return (AnonymousClass2.a[this.G.ordinal()] != 1 ? this.H : this.f54153c).getTop();
    }

    private void h() {
        if (i()) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.f54153c) && !childAt.equals(this.C)) {
                this.H = childAt;
                return;
            }
        }
    }

    private boolean i() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (this.H == getChildAt(i2)) {
                return true;
            }
        }
        return false;
    }

    public int a(int i2) {
        int i3 = AnonymousClass2.a[this.G.ordinal()];
        return (i3 == 1 || i3 != 2) ? i2 + ((int) this.a) : i2;
    }

    public void a(int i2, Animation.AnimationListener animationListener) {
        float f2;
        clearAnimation();
        if (c(i2) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.t = i2;
        this.T.reset();
        this.T.setDuration(c(f2));
        this.T.setInterpolator(this.O);
        if (animationListener != null) {
            this.T.setAnimationListener(animationListener);
        }
        startAnimation(this.T);
    }

    public boolean a() {
        return !this.Q && ((float) getTargetOrRefreshViewOffset()) > this.f54152b;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f54156f.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f54156f.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f54156f.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f54156f.dispatchNestedScroll(i2, i3, i4, i5, iArr);
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
        return this.f54157g.getNestedScrollAxes();
    }

    public float getRefreshTargetOffset() {
        return this.f54152b;
    }

    @Nullable
    public View getStateView() {
        return this.C;
    }

    public int getTargetOrRefreshViewOffset() {
        if (AnonymousClass2.a[this.G.ordinal()] != 1) {
            View view = this.H;
            if (view == null) {
                return 0;
            }
            return view.getTop();
        }
        return (int) (this.f54153c.getTop() - this.z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f54156f.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f54156f.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b();
        this.J = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        if (getChildCount() == 0) {
            return;
        }
        h();
        if (this.H == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.H.getVisibility() != 8 || ((view = this.C) != null && view.getVisibility() != 8)) {
            int b2 = b(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
            if (this.H.getVisibility() != 8) {
                this.H.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
            View view2 = this.C;
            if (view2 != null && view2.getVisibility() != 8) {
                this.C.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f54153c.getLayoutParams();
        int a2 = (a((int) this.z) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.f54153c.layout((measuredWidth - this.f54153c.getMeasuredWidth()) / 2, a2, (measuredWidth + this.f54153c.getMeasuredWidth()) / 2, this.f54153c.getMeasuredHeight() + a2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        h();
        if (this.H == null) {
            return;
        }
        d();
        g();
        a(i2, i3);
        if (!this.F && !this.E) {
            int i4 = AnonymousClass2.a[this.G.ordinal()];
            if (i4 == 1) {
                float f2 = -this.f54153c.getMeasuredHeight();
                this.z = f2;
                this.a = f2;
            } else if (i4 != 2) {
                this.a = 0.0f;
                this.z = -this.f54153c.getMeasuredHeight();
            } else {
                this.z = 0.0f;
                this.a = 0.0f;
            }
        }
        if (!this.F && !this.D && this.f54152b < this.f54153c.getMeasuredHeight()) {
            this.f54152b = this.f54153c.getMeasuredHeight();
        }
        this.F = true;
        this.p = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == this.f54153c) {
                this.p = i5;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f54157g.onStopNestedScroll(view);
        this.f54159i = false;
        if (this.f54158h > 0.0f) {
            f();
            this.f54158h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        StringBuilder sb;
        float f3;
        h();
        if (this.H == null) {
            return false;
        }
        if (AnonymousClass2.a[this.G.ordinal()] != 1) {
            if (!isEnabled() || (a(this.H) && !this.o)) {
                return false;
            }
        } else if (!isEnabled() || a(this.H) || this.f54159i) {
            return false;
        }
        if (this.G == RefreshStyle.FLOAT && (a(this.H) || this.f54159i)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = this.q;
                    if (i2 == -1) {
                        return false;
                    }
                    float a2 = a(motionEvent, i2);
                    if (a2 == -1.0f) {
                        return false;
                    }
                    if (this.f54160j) {
                        f2 = getTargetOrRefreshViewTop();
                        this.x = a2;
                        this.w = f2;
                        sb = new StringBuilder();
                        sb.append("animatetostart overscrolly ");
                        sb.append(f2);
                        sb.append(" -- ");
                        f3 = this.x;
                    } else {
                        f2 = (a2 - this.x) + this.w;
                        sb = new StringBuilder();
                        sb.append("overscrolly ");
                        sb.append(f2);
                        sb.append(" --");
                        sb.append(this.x);
                        sb.append(" -- ");
                        f3 = this.w;
                    }
                    sb.append(f3);
                    com.kwad.sdk.core.d.a.c("RefreshLayout", sb.toString());
                    if (this.k) {
                        if (f2 > 0.0f) {
                            if (f2 > 0.0f && f2 < this.f54152b && this.o) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(3);
                                this.o = false;
                            }
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                            a(f2, true);
                        } else if (!this.o) {
                            motionEvent = MotionEvent.obtain(motionEvent);
                            motionEvent.setAction(0);
                            this.o = true;
                        }
                        this.H.dispatchTouchEvent(motionEvent);
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                        a(f2, true);
                    } else if (!this.m) {
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "is not Being Dragged, init drag status");
                        a(a2);
                    } else if (f2 <= 0.0f) {
                        com.kwad.sdk.core.d.a.c("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                        return false;
                    } else {
                        a(f2, true);
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
            int i3 = this.q;
            if (i3 == -1 || a(motionEvent, i3) == -1.0f) {
                e();
                return false;
            } else if (!this.k && !this.f54160j) {
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

    public void setAnimateToRefreshDuration(int i2) {
        this.s = i2;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.P = interpolator;
    }

    public void setAnimateToStartDuration(int i2) {
        this.r = i2;
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
        this.f54156f.setNestedScrollingEnabled(z);
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

    public void setRefreshInitialOffset(float f2) {
        this.z = f2;
        this.E = true;
        requestLayout();
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        this.G = refreshStyle;
    }

    public void setRefreshTargetOffset(float f2) {
        this.f54152b = f2;
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

    public void setTargetOrRefreshViewOffsetY(int i2) {
        a(i2, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.f54156f.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f54156f.stopNestedScroll();
    }
}
