package com.kwad.sdk.contentalliance.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends ViewGroup {
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private int M;
    private VelocityTracker N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private EdgeEffectCompat T;
    private EdgeEffectCompat U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private int ab;
    private long ac;
    private List<ViewPager.OnPageChangeListener> ad;
    private ViewPager.OnPageChangeListener ae;
    private e af;
    private f ag;
    private ViewPager.PageTransformer ah;
    private Method ai;
    private int aj;
    private ArrayList<View> ak;
    private final Runnable am;
    private int an;

    /* renamed from: b  reason: collision with root package name */
    private int f8270b;
    private final ArrayList<C1074b> e;
    protected int f;
    private final C1074b g;
    private final Rect h;
    private PagerAdapter i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Parcelable n;
    private ClassLoader o;
    private Scroller p;
    private g q;
    private List<DataSetObserver> r;
    private int s;
    private Drawable t;
    private int u;
    private int v;
    private float w;
    private float x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f8269a = {16842931};
    private static final Comparator<C1074b> c = new Comparator<C1074b>() { // from class: com.kwad.sdk.contentalliance.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C1074b c1074b, C1074b c1074b2) {
            return c1074b.f8273b - c1074b2.f8273b;
        }
    };
    private static final Interpolator d = new Interpolator() { // from class: com.kwad.sdk.contentalliance.b.b.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final i al = new i();

    /* loaded from: classes3.dex */
    interface a {
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1074b {

        /* renamed from: a  reason: collision with root package name */
        public Object f8272a;

        /* renamed from: b  reason: collision with root package name */
        public int f8273b;
        boolean c;
        float d;
        float e;
    }

    /* loaded from: classes3.dex */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8274a;

        /* renamed from: b  reason: collision with root package name */
        public int f8275b;
        float c;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f8269a);
            this.f8275b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends AccessibilityDelegateCompat {
        d() {
        }

        private boolean a() {
            return b.this.i != null && b.this.i.getCount() > 1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(a());
            if (accessibilityEvent.getEventType() != 4096 || b.this.i == null) {
                return;
            }
            obtain.setItemCount(b.this.i.getCount());
            obtain.setFromIndex(b.this.j);
            obtain.setToIndex(b.this.j);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(a());
            if (b.this.d(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (b.this.d(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (b.this.d(1)) {
                        b.this.setCurrentItem(b.this.j + 1);
                        return true;
                    }
                    return false;
                case 8192:
                    if (b.this.d(-1)) {
                        b.this.setCurrentItem(b.this.j - 1);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    interface e {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes3.dex */
    private class g extends DataSetObserver {
        private g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b.this.m();
            b.this.o();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            b.this.m();
            b.this.p();
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<h>() { // from class: com.kwad.sdk.contentalliance.b.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public h[] newArray(int i) {
                return new h[i];
            }
        });

        /* renamed from: a  reason: collision with root package name */
        int f8278a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f8279b;
        ClassLoader c;

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f8278a = parcel.readInt();
            this.f8279b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f8278a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8278a);
            parcel.writeParcelable(this.f8279b, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class i implements Comparator<View> {
        i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            return cVar.f8274a != cVar2.f8274a ? cVar.f8274a ? 1 : -1 : cVar.e - cVar2.e;
        }
    }

    public b(Context context) {
        super(context);
        this.e = new ArrayList<>();
        this.g = new C1074b();
        this.h = new Rect();
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.D = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.am = new Runnable() { // from class: com.kwad.sdk.contentalliance.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.setScrollState(0);
                b.this.n();
                b.this.c();
            }
        };
        this.an = 0;
        l();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
        this.g = new C1074b();
        this.h = new Rect();
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.D = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.am = new Runnable() { // from class: com.kwad.sdk.contentalliance.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.setScrollState(0);
                b.this.n();
                b.this.c();
            }
        };
        this.an = 0;
        l();
    }

    private float a(MotionEvent motionEvent, int i2) {
        return (i2 == -1 || motionEvent.getPointerCount() <= i2) ? motionEvent.getX() : MotionEventCompat.getX(motionEvent, i2);
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void a() {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return;
            }
            if (!((c) getChildAt(i3).getLayoutParams()).f8274a) {
                removeViewAt(i3);
                i3--;
            }
            i2 = i3 + 1;
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.e.isEmpty()) {
            int paddingTop = (int) ((((i2 - getPaddingTop()) - getPaddingBottom()) + i4) * (getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)));
            scrollTo(getScrollX(), paddingTop);
            if (this.p.isFinished()) {
                return;
            }
            this.p.startScroll(0, paddingTop, 0, (int) (c(this.j).e * i2), this.p.getDuration() - this.p.timePassed());
            return;
        }
        C1074b c2 = c(this.j);
        int min = (int) ((c2 != null ? Math.min(c2.e, this.x) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            a(false);
            scrollTo(getScrollX(), min);
        }
    }

    private void a(int i2, boolean z, int i3, boolean z2, boolean z3) {
        int i4;
        C1074b c2 = c(i2);
        if (c2 != null) {
            i4 = (int) (Math.max(this.w, Math.min(c2.e, this.x)) * getClientHeight());
        } else {
            i4 = 0;
        }
        if (z) {
            a(0, i4, i3, z3);
            if (z2) {
                f(i2);
                return;
            }
            return;
        }
        if (z2) {
            f(i2);
        }
        a(false);
        scrollTo(0, i4);
        h(i4);
        if (!z2 || this.an == 2) {
            return;
        }
        c();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.M) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.J = b(motionEvent, i2);
            this.M = MotionEventCompat.getPointerId(motionEvent, i2);
            if (this.N != null) {
                this.N.clear();
            }
        }
    }

    private void a(C1074b c1074b, int i2, C1074b c1074b2) {
        C1074b c1074b3;
        C1074b c1074b4;
        int count = this.i.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
        if (c1074b2 != null) {
            int i3 = c1074b2.f8273b;
            if (i3 < c1074b.f8273b) {
                float f3 = c1074b2.e + c1074b2.d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= c1074b.f8273b && i5 < this.e.size()) {
                    C1074b c1074b5 = this.e.get(i5);
                    while (true) {
                        c1074b4 = c1074b5;
                        if (i4 <= c1074b4.f8273b || i5 >= this.e.size() - 1) {
                            break;
                        }
                        i5++;
                        c1074b5 = this.e.get(i5);
                    }
                    while (i4 < c1074b4.f8273b) {
                        f3 += this.i.getPageWidth(i4) + f2;
                        i4++;
                    }
                    c1074b4.e = f3;
                    f3 += c1074b4.d + f2;
                    i4++;
                }
            } else if (i3 > c1074b.f8273b) {
                int size = this.e.size() - 1;
                float f4 = c1074b2.e;
                int i6 = i3 - 1;
                while (i6 >= c1074b.f8273b && size >= 0) {
                    C1074b c1074b6 = this.e.get(size);
                    while (true) {
                        c1074b3 = c1074b6;
                        if (i6 >= c1074b3.f8273b || size <= 0) {
                            break;
                        }
                        size--;
                        c1074b6 = this.e.get(size);
                    }
                    while (i6 > c1074b3.f8273b) {
                        f4 -= this.i.getPageWidth(i6) + f2;
                        i6--;
                    }
                    f4 -= c1074b3.d + f2;
                    c1074b3.e = f4;
                    i6--;
                }
            }
        }
        int size2 = this.e.size();
        float f5 = c1074b.e;
        int i7 = c1074b.f8273b - 1;
        this.w = c1074b.f8273b == 0 ? c1074b.e : -3.4028235E38f;
        this.x = c1074b.f8273b == count + (-1) ? (c1074b.e + c1074b.d) - 1.0f : Float.MAX_VALUE;
        for (int i8 = i2 - 1; i8 >= 0; i8--) {
            C1074b c1074b7 = this.e.get(i8);
            float f6 = f5;
            while (i7 > c1074b7.f8273b) {
                f6 -= this.i.getPageWidth(i7) + f2;
                i7--;
            }
            f5 = f6 - (c1074b7.d + f2);
            c1074b7.e = f5;
            if (c1074b7.f8273b == 0) {
                this.w = f5;
            }
            i7--;
        }
        float f7 = c1074b.e + c1074b.d + f2;
        int i9 = c1074b.f8273b + 1;
        for (int i10 = i2 + 1; i10 < size2; i10++) {
            C1074b c1074b8 = this.e.get(i10);
            float f8 = f7;
            while (i9 < c1074b8.f8273b) {
                f8 += this.i.getPageWidth(i9) + f2;
                i9++;
            }
            if (c1074b8.f8273b == count - 1) {
                this.x = (c1074b8.d + f8) - 1.0f;
            }
            c1074b8.e = f8;
            f7 = f8 + c1074b8.d + f2;
            i9++;
        }
        this.W = false;
    }

    private void a(boolean z) {
        boolean z2 = this.an == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.p.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.p.getCurrX();
            int currY = this.p.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.C = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            C1074b c1074b = this.e.get(i2);
            if (c1074b.c) {
                c1074b.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.am);
            } else {
                this.am.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.H) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.H)) && f3 < 0.0f);
    }

    private float b(MotionEvent motionEvent, int i2) {
        return (i2 == -1 || motionEvent.getPointerCount() <= i2) ? motionEvent.getY() : MotionEventCompat.getY(motionEvent, i2);
    }

    private void b() {
        if (this.aj != 0) {
            if (this.ak == null) {
                this.ak = new ArrayList<>();
            } else {
                this.ak.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ak.add(getChildAt(i2));
            }
            Collections.sort(this.ak, al);
        }
    }

    private void b(int i2, float f2, int i3) {
        if (this.ad != null) {
            int size = this.ad.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i4);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
            }
        }
        if (this.ae != null) {
            this.ae.onPageScrolled(i2, f2, i3);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewCompat.setLayerType(getChildAt(i2), z ? 2 : 0, null);
        }
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private C1074b d() {
        C1074b c1074b;
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f2 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
        int i2 = -1;
        boolean z = true;
        int i3 = 0;
        C1074b c1074b2 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.e.size()) {
            C1074b c1074b3 = this.e.get(i3);
            if (z || c1074b3.f8273b == i2 + 1) {
                c1074b = c1074b3;
            } else {
                C1074b c1074b4 = this.g;
                c1074b4.e = f4 + f3 + f2;
                c1074b4.f8273b = i2 + 1;
                c1074b4.d = this.i.getPageWidth(c1074b4.f8273b);
                i3--;
                c1074b = c1074b4;
            }
            f4 = c1074b.e;
            float f5 = c1074b.d + f4 + f2;
            if (!z && scrollY < f4) {
                return c1074b2;
            }
            if (scrollY < f5 || i3 == this.e.size() - 1) {
                return c1074b;
            }
            i2 = c1074b.f8273b;
            f3 = c1074b.d;
            i3++;
            c1074b2 = c1074b;
            z = false;
        }
        return c1074b2;
    }

    private void e() {
        this.E = false;
        this.F = false;
        if (this.N != null) {
            this.N.recycle();
            this.N = null;
        }
    }

    private void f(int i2) {
        if (this.ad != null) {
            int size = this.ad.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
        if (this.ae != null) {
            this.ae.onPageSelected(i2);
        }
    }

    private void g(int i2) {
        if (this.ad != null) {
            int size = this.ad.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
        if (this.ae != null) {
            this.ae.onPageScrollStateChanged(i2);
        }
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private boolean h(int i2) {
        if (this.e.size() == 0) {
            this.aa = false;
            a(0, 0.0f, 0);
            if (this.aa) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C1074b d2 = d();
        int clientHeight = getClientHeight();
        int i3 = this.s + clientHeight;
        float f2 = this.s / clientHeight;
        int i4 = d2.f8273b;
        float f3 = ((i2 / clientHeight) - d2.e) / (d2.d + f2);
        this.aa = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.aa) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (this.an == i2) {
            return;
        }
        this.an = i2;
        if (this.ah != null) {
            b(i2 != 0);
        }
        g(i2);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.B != z) {
            this.B = z;
        }
    }

    float a(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
            i2 = (int) ((i2 >= this.j ? 0.4f : 0.6f) + i2 + f2);
        } else if (i3 <= 0) {
            i2++;
        }
        return this.e.size() > 0 ? Math.max(this.e.get(0).f8273b, Math.min(i2, this.e.get(this.e.size() - 1).f8273b)) : i2;
    }

    C1074b a(int i2, int i3) {
        C1074b c1074b = new C1074b();
        c1074b.f8273b = i2;
        c1074b.f8272a = this.i.instantiateItem((ViewGroup) this, i2);
        c1074b.d = this.i.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.e.size()) {
            this.e.add(c1074b);
        } else {
            this.e.add(i3, c1074b);
        }
        return c1074b;
    }

    C1074b a(View view) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.e.size()) {
                return null;
            }
            C1074b c1074b = this.e.get(i3);
            if (this.i.isViewFromObject(view, c1074b.f8272a)) {
                return c1074b;
            }
            i2 = i3 + 1;
        }
    }

    protected void a(int i2, float f2, int i3) {
        int measuredHeight;
        int i4;
        if (this.ab > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f8274a) {
                    switch (cVar.f8275b & 112) {
                        case 16:
                            measuredHeight = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i4 = paddingTop;
                            break;
                        case 48:
                            i4 = paddingTop + childAt.getHeight();
                            measuredHeight = paddingTop;
                            break;
                        case 80:
                            measuredHeight = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i4 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i4 = paddingTop;
                            break;
                    }
                    int top = (measuredHeight + scrollY) - childAt.getTop();
                    if (top != 0) {
                        childAt.offsetTopAndBottom(top);
                    }
                } else {
                    i4 = paddingTop;
                }
                i5++;
                paddingTop = i4;
            }
        }
        b(i2, f2, i3);
        if (this.ah != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((c) childAt2.getLayoutParams()).f8274a) {
                    this.ah.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.aa = true;
    }

    void a(int i2, int i3, int i4, boolean z) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            n();
            if (z) {
                c();
            }
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i7 = clientHeight / 2;
        float a2 = (i7 * a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / clientHeight))) + i7;
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a2 / abs2)) * 4;
        } else {
            abs = ((int) (((Math.abs(i6) / ((clientHeight * this.i.getPageWidth(this.j)) + this.s)) + 1.0f) * 100.0f)) * 2;
        }
        this.p.startScroll(scrollX, scrollY, i5, i6, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void a(int i2, boolean z) {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2 + " smoothScroll=" + z);
        this.C = false;
        a(i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    void a(int i2, boolean z, boolean z2, int i3) {
        a(i2, z, z2, i3, false);
    }

    void a(int i2, boolean z, boolean z2, int i3, boolean z3) {
        if (this.i == null || this.i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.j != i2 || this.e.size() == 0) {
            int count = i2 < 0 ? 0 : i2 >= this.i.getCount() ? this.i.getCount() - 1 : i2;
            int i4 = this.D;
            if (count > this.j + i4 || count < this.j - i4) {
                for (int i5 = 0; i5 < this.e.size(); i5++) {
                    this.e.get(i5).c = true;
                }
            }
            boolean z4 = this.j != count;
            if (!this.V) {
                b(count);
                a(count, z, i3, z4, z3);
                return;
            }
            this.k = count;
            this.j = count;
            if (z4) {
                f(count);
            }
            requestLayout();
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void a(DataSetObserver dataSetObserver) {
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(dataSetObserver);
    }

    public void a(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(onPageChangeListener);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    return e(17);
                case 22:
                    return e(66);
                case 61:
                    if (Build.VERSION.SDK_INT >= 11) {
                        if (keyEvent.hasNoModifiers()) {
                            return e(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return e(1);
                        }
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    protected boolean a(View view, boolean z, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.isEnabled() && childAt.getVisibility() == 0 && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && a(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        C1074b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f8273b == this.j) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C1074b a2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f8273b == this.j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        c cVar = (c) generateLayoutParams;
        cVar.f8274a |= view instanceof a;
        if (!this.A) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, i2, generateLayoutParams);
        } else if (cVar != null && cVar.f8274a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            cVar.d = true;
            addViewInLayout(view, i2, generateLayoutParams);
        }
    }

    C1074b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dd, code lost:
        if (r0.f8273b == r14.j) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void b(int i2) {
        String hexString;
        int i3;
        C1074b c1074b;
        C1074b a2;
        int i4;
        C1074b c1074b2 = null;
        int i5 = 2;
        if (this.j != i2) {
            i5 = this.j < i2 ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            c1074b2 = c(this.j);
            if (this.j != i2) {
                this.k = this.j;
            }
            this.j = i2;
        }
        int i6 = i5;
        if (this.i == null) {
            b();
        } else if (this.C) {
            b();
        } else if (getWindowToken() != null) {
            this.i.startUpdate((ViewGroup) this);
            int i7 = this.D;
            int max = Math.max(0, this.j - i7);
            int count = this.i.getCount();
            int min = Math.min(count - 1, this.j + i7);
            if (count != this.f8270b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e2) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f8270b + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.i.getClass());
            }
            int i8 = 0;
            while (true) {
                i3 = i8;
                if (i3 >= this.e.size()) {
                    break;
                }
                c1074b = this.e.get(i3);
                if (c1074b.f8273b < this.j) {
                    i8 = i3 + 1;
                }
            }
            c1074b = null;
            C1074b a3 = (c1074b != null || count <= 0) ? c1074b : a(this.j, i3);
            if (a3 != null && i7 > 0) {
                float f2 = 0.0f;
                int i9 = i3 - 1;
                C1074b c1074b3 = i9 >= 0 ? this.e.get(i9) : null;
                int clientHeight = getClientHeight();
                float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - a3.d) + (getPaddingLeft() / clientHeight);
                int i10 = this.j - 1;
                int i11 = i3;
                while (i10 >= 0) {
                    if (f2 < paddingLeft || i10 >= max) {
                        if (c1074b3 == null || i10 != c1074b3.f8273b) {
                            f2 += a(i10, i9 + 1).d;
                            i11++;
                            c1074b3 = i9 >= 0 ? this.e.get(i9) : null;
                            i4 = i9;
                        } else {
                            f2 += c1074b3.d;
                            i4 = i9 - 1;
                            c1074b3 = i4 >= 0 ? this.e.get(i4) : null;
                        }
                    } else if (c1074b3 == null) {
                        break;
                    } else if (i10 != c1074b3.f8273b || c1074b3.c) {
                        i4 = i9;
                    } else {
                        this.e.remove(i9);
                        this.i.destroyItem((ViewGroup) this, i10, c1074b3.f8272a);
                        i4 = i9 - 1;
                        int i12 = i11 - 1;
                        c1074b3 = i4 >= 0 ? this.e.get(i4) : null;
                        i11 = i12;
                    }
                    i10--;
                    i9 = i4;
                }
                float f3 = a3.d;
                int i13 = i11 + 1;
                if (f3 < 2.0f) {
                    C1074b c1074b4 = i13 < this.e.size() ? this.e.get(i13) : null;
                    float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                    C1074b c1074b5 = c1074b4;
                    for (int i14 = this.j + 1; i14 < count; i14++) {
                        if (f3 < paddingRight || i14 <= min) {
                            if (c1074b5 == null || i14 != c1074b5.f8273b) {
                                C1074b a4 = a(i14, i13);
                                i13++;
                                f3 += a4.d;
                                c1074b5 = i13 < this.e.size() ? this.e.get(i13) : null;
                            } else {
                                f3 += c1074b5.d;
                                i13++;
                                c1074b5 = i13 < this.e.size() ? this.e.get(i13) : null;
                            }
                        } else if (c1074b5 == null) {
                            break;
                        } else if (i14 == c1074b5.f8273b && !c1074b5.c) {
                            this.e.remove(i13);
                            this.i.destroyItem((ViewGroup) this, i14, c1074b5.f8272a);
                            c1074b5 = i13 < this.e.size() ? this.e.get(i13) : null;
                        }
                    }
                }
                a(a3, i11, c1074b2);
            }
            this.i.setPrimaryItem((ViewGroup) this, this.j, a3 != null ? a3.f8272a : null);
            this.i.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = getChildAt(i15);
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = i15;
                if (!cVar.f8274a && cVar.c == 0.0f && (a2 = a(childAt)) != null) {
                    cVar.c = a2.d;
                    cVar.e = a2.f8273b;
                }
            }
            b();
            if (hasFocus()) {
                View findFocus = findFocus();
                C1074b b2 = findFocus != null ? b(findFocus) : null;
                if (b2 == null || b2.f8273b != this.j) {
                    for (int i16 = 0; i16 < getChildCount(); i16++) {
                        View childAt2 = getChildAt(i16);
                        C1074b a5 = a(childAt2);
                        if (a5 != null && a5.f8273b == this.j && childAt2.requestFocus(i6)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void b(DataSetObserver dataSetObserver) {
        if (this.r != null) {
            this.r.remove(dataSetObserver);
        }
    }

    public void b(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ad != null) {
            this.ad.remove(onPageChangeListener);
        }
    }

    protected boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3;
        float f4;
        this.J = f2;
        float scrollY = getScrollY() + (this.J - f2);
        int clientHeight = getClientHeight();
        float f5 = clientHeight * this.w;
        float f6 = clientHeight * this.x;
        if (this.e.size() > 0) {
            C1074b c1074b = this.e.get(0);
            C1074b c1074b2 = this.e.get(this.e.size() - 1);
            if (c1074b.f8273b != 0) {
                f5 = clientHeight * c1074b.e;
                z2 = false;
            } else {
                z2 = true;
            }
            if (c1074b2.f8273b != this.i.getCount() - 1) {
                f6 = c1074b2.e * clientHeight;
                z = false;
                f3 = f5;
            } else {
                z = true;
                f3 = f5;
            }
        } else {
            z = true;
            z2 = true;
            f3 = f5;
        }
        if (scrollY < f3) {
            r2 = z2 ? this.T.onPull(Math.abs(f3 - scrollY) / clientHeight) : false;
            f4 = f3;
        } else if (scrollY > f6) {
            r2 = z ? this.U.onPull(Math.abs(scrollY - f6) / clientHeight) : false;
            f4 = f6;
        } else {
            f4 = scrollY;
        }
        this.I += f4 - ((int) f4);
        int a2 = a((int) f4);
        scrollTo(getScrollX(), a2);
        h(a(a2));
        return r2;
    }

    C1074b c(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.e.size()) {
                return null;
            }
            C1074b c1074b = this.e.get(i4);
            if (c1074b.f8273b == i2) {
                return c1074b;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.ag != null) {
            this.ag.a();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.isFinished() || !this.p.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.p.getCurrX();
        int currY = this.p.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!h(currY)) {
                this.p.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public boolean d(int i2) {
        if (this.i == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i2 < 0) {
            return scrollY > ((int) (((float) clientHeight) * this.w));
        } else if (i2 > 0) {
            return scrollY < ((int) (((float) clientHeight) * this.x));
        } else {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C1074b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f8273b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.i != null && this.i.getCount() > 1)) {
            if (!this.T.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.w * height);
                this.T.setSize(width, height);
                z = false | this.T.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.U.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.x + 1.0f)) * height2);
                this.U.setSize(width2, height2);
                z |= this.U.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.T.finish();
            this.U.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.t;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean e(int i2) {
        View view;
        boolean z;
        boolean q;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    com.kwad.sdk.core.d.a.a("VerticalViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus == null || findNextFocus == view) {
            if (i2 == 33 || i2 == 1) {
                q = q();
            } else {
                if (i2 == 130 || i2 == 2) {
                    q = r();
                }
                q = false;
            }
        } else if (i2 == 33) {
            q = (view == null || a(this.h, findNextFocus).top < a(this.h, view).top) ? findNextFocus.requestFocus() : q();
        } else {
            if (i2 == 130) {
                q = (view == null || a(this.h, findNextFocus).bottom > a(this.h, view).bottom) ? findNextFocus.requestFocus() : r();
            }
            q = false;
        }
        if (q) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return q;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.aj == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ak.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.D;
    }

    public int getPageMargin() {
        return this.s;
    }

    public int getPreItem() {
        return this.k;
    }

    void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.p = new Scroller(context, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.O = (int) (400.0f * f2);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffectCompat(context);
        this.U = new EdgeEffectCompat(context);
        this.Q = (int) (25.0f * f2);
        this.R = (int) (2.0f * f2);
        this.G = (int) (16.0f * f2);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    void m() {
        int count = this.i.getCount();
        this.f8270b = count;
        boolean z = this.e.size() < (this.D * 2) + 1 && this.e.size() < count;
        int i2 = this.j;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = z;
        while (i3 < this.e.size()) {
            C1074b c1074b = this.e.get(i3);
            int itemPosition = this.i.getItemPosition(c1074b);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.e.remove(i3);
                    i3--;
                    if (!z2) {
                        this.i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.i.destroyItem((ViewGroup) this, c1074b.f8273b, c1074b.f8272a);
                    if (this.j == c1074b.f8273b) {
                        i2 = Math.max(0, Math.min(this.j, count - 1));
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                } else if (c1074b.f8273b != itemPosition) {
                    if (c1074b.f8273b == this.j) {
                        i2 = itemPosition;
                    }
                    c1074b.f8273b = itemPosition;
                    z3 = true;
                }
            }
            i3++;
        }
        if (z2) {
            this.i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.e, c);
        if (z3) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f8274a) {
                    cVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    void n() {
        b(this.j);
    }

    public void o() {
        if (this.r != null) {
            int size = this.r.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.r.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "onDetachedFromWindow");
        removeCallbacks(this.am);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.s <= 0 || this.t == null || this.e.size() <= 0 || this.i == null) {
            return;
        }
        int scrollY = getScrollY();
        int height = getHeight();
        float f3 = this.s / height;
        C1074b c1074b = this.e.get(0);
        float f4 = c1074b.e;
        int size = this.e.size();
        int i2 = c1074b.f8273b;
        int i3 = this.e.get(size - 1).f8273b;
        int i4 = 0;
        for (int i5 = i2; i5 < i3; i5++) {
            while (i5 > c1074b.f8273b && i4 < size) {
                i4++;
                c1074b = this.e.get(i4);
            }
            if (i5 == c1074b.f8273b) {
                f2 = (c1074b.e + c1074b.d) * height;
                f4 = c1074b.e + c1074b.d + f3;
            } else {
                float pageWidth = this.i.getPageWidth(i5);
                f2 = (f4 + pageWidth) * height;
                f4 += pageWidth + f3;
            }
            if (this.s + f2 > scrollY) {
                this.t.setBounds(this.u, (int) f2, this.v, (int) (this.s + f2 + 0.5f));
                this.t.draw(canvas);
            }
            if (f2 > scrollY + height) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.E = false;
            this.F = false;
            this.M = -1;
            if (this.N != null) {
                this.N.recycle();
                this.N = null;
                return false;
            }
            return false;
        }
        if (action != 0) {
            if (this.E) {
                return true;
            }
            if (this.F) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.K = x;
                this.I = x;
                float y = motionEvent.getY();
                this.L = y;
                this.J = y;
                this.M = MotionEventCompat.getPointerId(motionEvent, 0);
                this.F = false;
                this.p.computeScrollOffset();
                if (this.an == 2 && Math.abs(this.p.getFinalY() - this.p.getCurrY()) > this.R) {
                    this.p.abortAnimation();
                    this.C = false;
                    n();
                    this.E = true;
                    c(true);
                    setScrollState(1);
                    break;
                } else {
                    a(false);
                    this.E = false;
                    break;
                }
            case 2:
                int i2 = this.M;
                if (i2 != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                    float b2 = b(motionEvent, findPointerIndex);
                    float f2 = b2 - this.J;
                    float abs = Math.abs(f2);
                    float a2 = a(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(a2 - this.K);
                    boolean z = !a(this.J, f2);
                    boolean a3 = a((View) this, false, (int) f2, (int) a2, (int) b2);
                    if (f2 == 0.0f || !z || !a3) {
                        if (abs > this.f && abs > abs2) {
                            this.E = true;
                            c(true);
                            setScrollState(1);
                            this.J = f2 > 0.0f ? this.L + this.f : this.L - this.f;
                            this.I = a2;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > this.f) {
                            this.F = true;
                        }
                        if (this.E && b(b2)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                            break;
                        }
                    } else {
                        this.I = a2;
                        this.J = b2;
                        this.F = true;
                        return false;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        C1074b a2;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        int measuredHeight;
        int i9;
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f8274a) {
                    int i14 = cVar.f8275b & 7;
                    int i15 = cVar.f8275b & 112;
                    switch (i14) {
                        case 1:
                            measuredWidth = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 3:
                            i8 = paddingLeft + childAt.getMeasuredWidth();
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            break;
                        case 5:
                            measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            i7 = paddingRight + childAt.getMeasuredWidth();
                            i8 = paddingLeft;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i9 = paddingTop;
                            break;
                        case 48:
                            i9 = paddingTop + childAt.getMeasuredHeight();
                            measuredHeight = paddingTop;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i9 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i9 = paddingTop;
                            break;
                    }
                    int i16 = measuredHeight + scrollY;
                    childAt.layout(measuredWidth, i16, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i16);
                    i6 = i12 + 1;
                    paddingTop = i9;
                    i13++;
                    i12 = i6;
                    paddingRight = i7;
                    paddingLeft = i8;
                }
            }
            i6 = i12;
            i7 = paddingRight;
            i8 = paddingLeft;
            i13++;
            i12 = i6;
            paddingRight = i7;
            paddingLeft = i8;
        }
        int i17 = (i11 - paddingTop) - paddingBottom;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f8274a && (a2 = a(childAt2)) != null) {
                    int i19 = ((int) (a2.e * i17)) + paddingTop;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i10 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (cVar2.c * i17), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i19, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i19);
                }
            }
        }
        this.u = paddingLeft;
        this.v = i10 - paddingRight;
        this.ab = i12;
        if (this.V) {
            a(this.j, false, 0, false, false);
        }
        this.V = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredHeight = getMeasuredHeight();
        this.H = Math.min(measuredHeight / 10, this.G);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f8274a) {
                int i8 = cVar2.f8275b & 7;
                int i9 = cVar2.f8275b & 112;
                int i10 = Integer.MIN_VALUE;
                int i11 = Integer.MIN_VALUE;
                boolean z = i9 == 48 || i9 == 80;
                boolean z2 = i8 == 3 || i8 == 5;
                if (z) {
                    i10 = 1073741824;
                } else if (z2) {
                    i11 = 1073741824;
                }
                if (cVar2.width != -2) {
                    i5 = 1073741824;
                    i4 = cVar2.width != -1 ? cVar2.width : measuredWidth;
                } else {
                    i4 = measuredWidth;
                    i5 = i10;
                }
                if (cVar2.height != -2) {
                    i11 = 1073741824;
                    if (cVar2.height != -1) {
                        i6 = cVar2.height;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i5), View.MeasureSpec.makeMeasureSpec(i6, i11));
                        if (!z) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i6 = paddingTop;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i5), View.MeasureSpec.makeMeasureSpec(i6, i11));
                if (!z) {
                }
            }
        }
        this.y = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.z = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.A = true;
        n();
        this.A = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f8274a)) {
                childAt2.measure(this.y, View.MeasureSpec.makeMeasureSpec((int) (cVar.c * paddingTop), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        C1074b a2;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            childCount = -1;
            i4 = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f8273b == this.j && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        if (this.i != null) {
            this.i.restoreState(hVar.f8279b, hVar.c);
            a(hVar.f8278a, false, true);
            return;
        }
        this.l = hVar.f8278a;
        this.n = hVar.f8279b;
        this.o = hVar.c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            a(i3, i5, this.s, this.s);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.S) {
            return true;
        }
        if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            if (this.i == null || this.i.getCount() == 0) {
                return false;
            }
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.p.abortAnimation();
                    this.C = false;
                    n();
                    float x = motionEvent.getX();
                    this.K = x;
                    this.I = x;
                    float y = motionEvent.getY();
                    this.L = y;
                    this.J = y;
                    this.M = MotionEventCompat.getPointerId(motionEvent, 0);
                    break;
                case 1:
                    if (this.E) {
                        VelocityTracker velocityTracker = this.N;
                        velocityTracker.computeCurrentVelocity(1000, this.P);
                        int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.M);
                        this.C = true;
                        int clientHeight = getClientHeight();
                        int scrollY = getScrollY();
                        C1074b d2 = d();
                        if (d2 != null) {
                            a(a(d2.f8273b, ((scrollY / clientHeight) - d2.e) / d2.d, yVelocity, (int) (b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M)) - this.L)), true, true, yVelocity, true);
                            this.M = -1;
                            e();
                            z = this.T.onRelease() | this.U.onRelease();
                        }
                    }
                    this.ac = System.currentTimeMillis();
                    break;
                case 2:
                    if (!this.E) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.M);
                        float b2 = b(motionEvent, findPointerIndex);
                        float abs = Math.abs(b2 - this.J);
                        float a2 = a(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(a2 - this.I);
                        if (abs > this.f && abs > abs2) {
                            this.E = true;
                            c(true);
                            this.J = b2 - this.L > 0.0f ? this.L + this.f : this.L - this.f;
                            this.I = a2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.E) {
                        z = false | b(b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M)));
                        break;
                    }
                    break;
                case 3:
                    if (this.E) {
                        a(this.j, true, 0, false, false);
                        this.M = -1;
                        e();
                        z = this.T.onRelease() | this.U.onRelease();
                        break;
                    }
                    break;
                case 5:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.J = b(motionEvent, actionIndex);
                    this.M = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                case 6:
                    a(motionEvent);
                    this.J = b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M));
                    break;
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
            return true;
        }
        return false;
    }

    public void p() {
        if (this.r != null) {
            int size = this.r.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.r.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onInvalidated();
                }
            }
        }
    }

    boolean q() {
        if (this.j > 0) {
            a(this.j - 1, true);
            return true;
        }
        return false;
    }

    boolean r() {
        if (this.i == null || this.j >= this.i.getCount() - 1) {
            return false;
        }
        a(this.j + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.A) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.i != null) {
            this.i.unregisterDataSetObserver(this.q);
            this.i.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                C1074b c1074b = this.e.get(i2);
                this.i.destroyItem((ViewGroup) this, c1074b.f8273b, c1074b.f8272a);
            }
            this.i.finishUpdate((ViewGroup) this);
            this.e.clear();
            a();
            if (this.j != 0) {
                this.k = this.j;
            } else {
                this.k = -1;
            }
            this.j = 0;
            scrollTo(0, 0);
        }
        if (this.m > 0) {
            this.k = -1;
            this.j = this.m;
            this.m = -1;
        }
        PagerAdapter pagerAdapter2 = this.i;
        this.i = pagerAdapter;
        this.f8270b = 0;
        if (this.i != null) {
            if (this.q == null) {
                this.q = new g();
            }
            this.i.registerDataSetObserver(this.q);
            this.C = false;
            boolean z = this.V;
            this.V = true;
            this.f8270b = this.i.getCount();
            if (this.l >= 0) {
                this.i.restoreState(this.n, this.o);
                a(this.l, false, true);
                this.l = -1;
                this.n = null;
                this.o = null;
            } else if (z) {
                requestLayout();
            } else {
                n();
            }
        }
        if (this.af == null || pagerAdapter2 == pagerAdapter) {
            return;
        }
        this.af.a(pagerAdapter2, pagerAdapter);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.ai == null) {
                try {
                    this.ai = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    com.kwad.sdk.core.d.a.a("VerticalViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.ai.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a("VerticalViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCurrentItem(int i2) {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2);
        this.C = false;
        a(i2, !this.V, false);
    }

    public void setInitStartPosition(int i2) {
        this.m = i2;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            com.kwad.sdk.core.d.a.a("VerticalViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.D) {
            this.D = i2;
            n();
        }
    }

    void setOnAdapterChangeListener(e eVar) {
        this.af = eVar;
    }

    public void setOnPageScrollEndListener(f fVar) {
        this.ag = fVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.s;
        this.s = i2;
        int height = getHeight();
        a(height, height, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.t = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.t;
    }
}
