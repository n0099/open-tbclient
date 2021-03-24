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
/* loaded from: classes6.dex */
public class b extends ViewGroup {
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public float I;
    public float J;
    public float K;
    public float L;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public EdgeEffectCompat T;
    public EdgeEffectCompat U;
    public boolean V;
    public boolean W;
    public boolean aa;
    public int ab;
    public long ac;
    public List<ViewPager.OnPageChangeListener> ad;
    public ViewPager.OnPageChangeListener ae;
    public e af;
    public f ag;
    public ViewPager.PageTransformer ah;
    public Method ai;
    public int aj;
    public ArrayList<View> ak;
    public final Runnable am;
    public int an;

    /* renamed from: b  reason: collision with root package name */
    public int f31894b;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<C0360b> f31895e;

    /* renamed from: f  reason: collision with root package name */
    public int f31896f;

    /* renamed from: g  reason: collision with root package name */
    public final C0360b f31897g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f31898h;
    public PagerAdapter i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Parcelable n;
    public ClassLoader o;
    public Scroller p;
    public g q;
    public List<DataSetObserver> r;
    public int s;
    public Drawable t;
    public int u;
    public int v;
    public float w;
    public float x;
    public int y;
    public int z;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f31891a = {16842931};

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<C0360b> f31892c = new Comparator<C0360b>() { // from class: com.kwad.sdk.contentalliance.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0360b c0360b, C0360b c0360b2) {
            return c0360b.f31901b - c0360b2.f31901b;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final Interpolator f31893d = new Interpolator() { // from class: com.kwad.sdk.contentalliance.b.b.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    public static final i al = new i();

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0360b {

        /* renamed from: a  reason: collision with root package name */
        public Object f31900a;

        /* renamed from: b  reason: collision with root package name */
        public int f31901b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31902c;

        /* renamed from: d  reason: collision with root package name */
        public float f31903d;

        /* renamed from: e  reason: collision with root package name */
        public float f31904e;
    }

    /* loaded from: classes6.dex */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f31905a;

        /* renamed from: b  reason: collision with root package name */
        public int f31906b;

        /* renamed from: c  reason: collision with root package name */
        public float f31907c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31908d;

        /* renamed from: e  reason: collision with root package name */
        public int f31909e;

        /* renamed from: f  reason: collision with root package name */
        public int f31910f;

        public c() {
            super(-1, -1);
            this.f31907c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f31907c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f31891a);
            this.f31906b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AccessibilityDelegateCompat {
        public d() {
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
            b bVar;
            int i2;
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !b.this.d(-1)) {
                    return false;
                }
                bVar = b.this;
                i2 = bVar.j - 1;
            } else if (!b.this.d(1)) {
                return false;
            } else {
                bVar = b.this;
                i2 = bVar.j + 1;
            }
            bVar.setCurrentItem(i2);
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes6.dex */
    public class g extends DataSetObserver {
        public g() {
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

    /* loaded from: classes6.dex */
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
        public int f31913a;

        /* renamed from: b  reason: collision with root package name */
        public Parcelable f31914b;

        /* renamed from: c  reason: collision with root package name */
        public ClassLoader f31915c;

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? h.class.getClassLoader() : classLoader;
            this.f31913a = parcel.readInt();
            this.f31914b = parcel.readParcelable(classLoader);
            this.f31915c = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f31913a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f31913a);
            parcel.writeParcelable(this.f31914b, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements Comparator<View> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            boolean z = cVar.f31905a;
            return z != cVar2.f31905a ? z ? 1 : -1 : cVar.f31909e - cVar2.f31909e;
        }
    }

    public b(Context context) {
        super(context);
        this.f31895e = new ArrayList<>();
        this.f31897g = new C0360b();
        this.f31898h = new Rect();
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
        this.f31895e = new ArrayList<>();
        this.f31897g = new C0360b();
        this.f31898h = new Rect();
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
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void a() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f31905a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.f31895e.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)) * (((i2 - getPaddingTop()) - getPaddingBottom()) + i4));
            scrollTo(getScrollX(), scrollY);
            if (this.p.isFinished()) {
                return;
            }
            this.p.startScroll(0, scrollY, 0, (int) (c(this.j).f31904e * i2), this.p.getDuration() - this.p.timePassed());
            return;
        }
        C0360b c2 = c(this.j);
        int min = (int) ((c2 != null ? Math.min(c2.f31904e, this.x) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            a(false);
            scrollTo(getScrollX(), min);
        }
    }

    private void a(int i2, boolean z, int i3, boolean z2, boolean z3) {
        C0360b c2 = c(i2);
        int clientHeight = c2 != null ? (int) (getClientHeight() * Math.max(this.w, Math.min(c2.f31904e, this.x))) : 0;
        if (z) {
            a(0, clientHeight, i3, z3);
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
        scrollTo(0, clientHeight);
        h(clientHeight);
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
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void a(C0360b c0360b, int i2, C0360b c0360b2) {
        int i3;
        int i4;
        C0360b c0360b3;
        C0360b c0360b4;
        int count = this.i.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
        if (c0360b2 != null) {
            int i5 = c0360b2.f31901b;
            int i6 = c0360b.f31901b;
            if (i5 < i6) {
                float f3 = c0360b2.f31904e + c0360b2.f31903d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= c0360b.f31901b && i8 < this.f31895e.size()) {
                    while (true) {
                        c0360b4 = this.f31895e.get(i8);
                        if (i7 <= c0360b4.f31901b || i8 >= this.f31895e.size() - 1) {
                            break;
                        }
                        i8++;
                    }
                    while (i7 < c0360b4.f31901b) {
                        f3 += this.i.getPageWidth(i7) + f2;
                        i7++;
                    }
                    c0360b4.f31904e = f3;
                    f3 += c0360b4.f31903d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.f31895e.size() - 1;
                float f4 = c0360b2.f31904e;
                while (true) {
                    i5--;
                    if (i5 < c0360b.f31901b || size < 0) {
                        break;
                    }
                    while (true) {
                        c0360b3 = this.f31895e.get(size);
                        if (i5 >= c0360b3.f31901b || size <= 0) {
                            break;
                        }
                        size--;
                    }
                    while (i5 > c0360b3.f31901b) {
                        f4 -= this.i.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= c0360b3.f31903d + f2;
                    c0360b3.f31904e = f4;
                }
            }
        }
        int size2 = this.f31895e.size();
        float f5 = c0360b.f31904e;
        int i9 = c0360b.f31901b;
        int i10 = i9 - 1;
        this.w = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = count - 1;
        this.x = c0360b.f31901b == i11 ? (c0360b.f31904e + c0360b.f31903d) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            C0360b c0360b5 = this.f31895e.get(i12);
            while (true) {
                i4 = c0360b5.f31901b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.i.getPageWidth(i10) + f2;
                i10--;
            }
            f5 -= c0360b5.f31903d + f2;
            c0360b5.f31904e = f5;
            if (i4 == 0) {
                this.w = f5;
            }
            i12--;
            i10--;
        }
        float f6 = c0360b.f31904e + c0360b.f31903d + f2;
        int i13 = c0360b.f31901b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            C0360b c0360b6 = this.f31895e.get(i14);
            while (true) {
                i3 = c0360b6.f31901b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.i.getPageWidth(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.x = (c0360b6.f31903d + f6) - 1.0f;
            }
            c0360b6.f31904e = f6;
            f6 += c0360b6.f31903d + f2;
            i14++;
            i13++;
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
        for (int i2 = 0; i2 < this.f31895e.size(); i2++) {
            C0360b c0360b = this.f31895e.get(i2);
            if (c0360b.f31902c) {
                c0360b.f31902c = false;
                z2 = true;
            }
        }
        if (z2) {
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
            ArrayList<View> arrayList = this.ak;
            if (arrayList == null) {
                this.ak = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ak.add(getChildAt(i2));
            }
            Collections.sort(this.ak, al);
        }
    }

    private void b(int i2, float f2, int i3) {
        List<ViewPager.OnPageChangeListener> list = this.ad;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i4);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i2, f2, i3);
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

    private C0360b d() {
        int i2;
        int clientHeight = getClientHeight();
        float f2 = 0.0f;
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f3 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
        C0360b c0360b = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (i4 < this.f31895e.size()) {
            C0360b c0360b2 = this.f31895e.get(i4);
            if (!z && c0360b2.f31901b != (i2 = i3 + 1)) {
                c0360b2 = this.f31897g;
                c0360b2.f31904e = f2 + f4 + f3;
                c0360b2.f31901b = i2;
                c0360b2.f31903d = this.i.getPageWidth(i2);
                i4--;
            }
            f2 = c0360b2.f31904e;
            float f5 = c0360b2.f31903d + f2 + f3;
            if (!z && scrollY < f2) {
                return c0360b;
            }
            if (scrollY < f5 || i4 == this.f31895e.size() - 1) {
                return c0360b2;
            }
            i3 = c0360b2.f31901b;
            f4 = c0360b2.f31903d;
            i4++;
            c0360b = c0360b2;
            z = false;
        }
        return c0360b;
    }

    private void e() {
        this.E = false;
        this.F = false;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    private void f(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.ad;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageSelected(i2);
        }
    }

    private void g(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.ad;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrollStateChanged(i2);
        }
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private boolean h(int i2) {
        if (this.f31895e.size() == 0) {
            this.aa = false;
            a(0, 0.0f, 0);
            if (this.aa) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0360b d2 = d();
        int clientHeight = getClientHeight();
        int i3 = this.s;
        int i4 = clientHeight + i3;
        float f2 = clientHeight;
        int i5 = d2.f31901b;
        float f3 = ((i2 / f2) - d2.f31904e) / (d2.f31903d + (i3 / f2));
        this.aa = false;
        a(i5, f3, (int) (i4 * f3));
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

    public float a(float f2) {
        double d2;
        Double.isNaN(f2 - 0.5f);
        return (float) Math.sin((float) (d2 * 0.4712389167638204d));
    }

    public int a(int i2) {
        return i2;
    }

    public int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
            i2 = (int) (i2 + f2 + (i2 >= this.j ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f31895e.size() > 0) {
            ArrayList<C0360b> arrayList = this.f31895e;
            return Math.max(this.f31895e.get(0).f31901b, Math.min(i2, arrayList.get(arrayList.size() - 1).f31901b));
        }
        return i2;
    }

    public C0360b a(int i2, int i3) {
        C0360b c0360b = new C0360b();
        c0360b.f31901b = i2;
        c0360b.f31900a = this.i.instantiateItem((ViewGroup) this, i2);
        c0360b.f31903d = this.i.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.f31895e.size()) {
            this.f31895e.add(c0360b);
        } else {
            this.f31895e.add(i3, c0360b);
        }
        return c0360b;
    }

    public C0360b a(View view) {
        for (int i2 = 0; i2 < this.f31895e.size(); i2++) {
            C0360b c0360b = this.f31895e.get(i2);
            if (this.i.isViewFromObject(view, c0360b.f31900a)) {
                return c0360b;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, float f2, int i3) {
        int max;
        int i4;
        int top;
        if (this.ab > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f31905a) {
                    int i6 = cVar.f31906b & 112;
                    if (i6 != 16) {
                        if (i6 == 48) {
                            i4 = childAt.getHeight() + paddingTop;
                        } else if (i6 != 80) {
                            i4 = paddingTop;
                        } else {
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i4;
                    } else {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i7 = max;
                    i4 = paddingTop;
                    paddingTop = i7;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i4;
                }
            }
        }
        b(i2, f2, i3);
        if (this.ah != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((c) childAt2.getLayoutParams()).f31905a) {
                    this.ah.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.aa = true;
    }

    public void a(int i2, int i3, int i4, boolean z) {
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
        float f2 = clientHeight;
        float f3 = i7;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = ((int) (((Math.abs(i6) / ((f2 * this.i.getPageWidth(this.j)) + this.s)) + 1.0f) * 100.0f)) * 2;
        }
        this.p.startScroll(scrollX, scrollY, i5, i6, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void a(int i2, boolean z) {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2 + " smoothScroll=" + z);
        this.C = false;
        a(i2, z, false);
    }

    public void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    public void a(int i2, boolean z, boolean z2, int i3) {
        a(i2, z, z2, i3, false);
    }

    public void a(int i2, boolean z, boolean z2, int i3, boolean z3) {
        int i4;
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.j != i2 || this.f31895e.size() == 0) {
            if (i2 < 0) {
                i4 = 0;
            } else {
                if (i2 >= this.i.getCount()) {
                    i2 = this.i.getCount() - 1;
                }
                i4 = i2;
            }
            int i5 = this.D;
            int i6 = this.j;
            if (i4 > i6 + i5 || i4 < i6 - i5) {
                for (int i7 = 0; i7 < this.f31895e.size(); i7++) {
                    this.f31895e.get(i7).f31902c = true;
                }
            }
            boolean z4 = this.j != i4;
            if (!this.V) {
                b(i4);
                a(i4, z, i3, z4, z3);
                return;
            }
            this.k = i4;
            this.j = i4;
            if (z4) {
                f(i4);
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
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                i2 = 17;
            } else if (keyCode == 22) {
                i2 = 66;
            } else if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    i2 = 2;
                } else if (keyEvent.hasModifiers(1)) {
                    return e(1);
                }
            }
            return e(i2);
        }
        return false;
    }

    public boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.isEnabled() && childAt.getVisibility() == 0 && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && (i6 = i3 + scrollX) >= childAt.getLeft() && i6 < childAt.getRight() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        C0360b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f31901b == this.j) {
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
        C0360b a2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f31901b == this.j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        boolean z = cVar.f31905a | (view instanceof a);
        cVar.f31905a = z;
        if (!this.A) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, i2, layoutParams);
        } else if (cVar != null && z) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            cVar.f31908d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public C0360b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (r11 == r12) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d1, code lost:
        if (r1 >= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
        if (r1 >= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ed, code lost:
        if (r1 >= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ef, code lost:
        r11 = r17.f31895e.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f8, code lost:
        r11 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i2) {
        int i3;
        C0360b c0360b;
        String hexString;
        C0360b c0360b2;
        C0360b a2;
        C0360b c0360b3;
        int i4 = this.j;
        if (i4 != i2) {
            i3 = i4 < i2 ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            c0360b = c(this.j);
            int i5 = this.j;
            if (i5 != i2) {
                this.k = i5;
            }
            this.j = i2;
        } else {
            i3 = 2;
            c0360b = null;
        }
        if (this.i == null) {
            b();
        } else if (this.C) {
            b();
        } else if (getWindowToken() != null) {
            this.i.startUpdate((ViewGroup) this);
            int i6 = this.D;
            int max = Math.max(0, this.j - i6);
            int count = this.i.getCount();
            int min = Math.min(count - 1, this.j + i6);
            if (count != this.f31894b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException unused) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f31894b + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.i.getClass());
            }
            int i7 = 0;
            while (true) {
                if (i7 >= this.f31895e.size()) {
                    break;
                }
                c0360b2 = this.f31895e.get(i7);
                int i8 = c0360b2.f31901b;
                int i9 = this.j;
                if (i8 < i9) {
                    i7++;
                }
            }
            if (c0360b2 == null && count > 0) {
                c0360b2 = a(this.j, i7);
            }
            if (c0360b2 != null && i6 > 0) {
                int i10 = i7 - 1;
                C0360b c0360b4 = i10 >= 0 ? this.f31895e.get(i10) : null;
                int clientHeight = getClientHeight();
                float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - c0360b2.f31903d) + (getPaddingLeft() / clientHeight);
                float f2 = 0.0f;
                for (int i11 = this.j - 1; i11 >= 0; i11--) {
                    if (f2 < paddingLeft || i11 >= max) {
                        if (c0360b4 == null || i11 != c0360b4.f31901b) {
                            f2 += a(i11, i10 + 1).f31903d;
                            i7++;
                        } else {
                            f2 += c0360b4.f31903d;
                            i10--;
                        }
                    } else if (c0360b4 == null) {
                        break;
                    } else {
                        if (i11 == c0360b4.f31901b && !c0360b4.f31902c) {
                            this.f31895e.remove(i10);
                            this.i.destroyItem((ViewGroup) this, i11, c0360b4.f31900a);
                            i10--;
                            i7--;
                        }
                    }
                    c0360b4 = c0360b3;
                }
                float f3 = c0360b2.f31903d;
                int i12 = i7 + 1;
                if (f3 < 2.0f) {
                    C0360b c0360b5 = i12 < this.f31895e.size() ? this.f31895e.get(i12) : null;
                    float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                    int i13 = this.j;
                    while (true) {
                        i13++;
                        if (i13 >= count) {
                            break;
                        } else if (f3 < paddingRight || i13 <= min) {
                            if (c0360b5 == null || i13 != c0360b5.f31901b) {
                                C0360b a3 = a(i13, i12);
                                i12++;
                                f3 += a3.f31903d;
                                c0360b5 = i12 < this.f31895e.size() ? this.f31895e.get(i12) : null;
                            } else {
                                f3 += c0360b5.f31903d;
                                i12++;
                                if (i12 < this.f31895e.size()) {
                                }
                            }
                        } else if (c0360b5 == null) {
                            break;
                        } else if (i13 == c0360b5.f31901b && !c0360b5.f31902c) {
                            this.f31895e.remove(i12);
                            this.i.destroyItem((ViewGroup) this, i13, c0360b5.f31900a);
                            if (i12 < this.f31895e.size()) {
                            }
                        }
                    }
                }
                a(c0360b2, i7, c0360b);
            }
            this.i.setPrimaryItem((ViewGroup) this, this.j, c0360b2 != null ? c0360b2.f31900a : null);
            this.i.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                c cVar = (c) childAt.getLayoutParams();
                cVar.f31910f = i14;
                if (!cVar.f31905a && cVar.f31907c == 0.0f && (a2 = a(childAt)) != null) {
                    cVar.f31907c = a2.f31903d;
                    cVar.f31909e = a2.f31901b;
                }
            }
            b();
            if (hasFocus()) {
                View findFocus = findFocus();
                C0360b b2 = findFocus != null ? b(findFocus) : null;
                if (b2 == null || b2.f31901b != this.j) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        C0360b a4 = a(childAt2);
                        if (a4 != null && a4.f31901b == this.j && childAt2.requestFocus(i3)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list = this.r;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }

    public void b(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.ad;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.J - f2;
        this.J = f2;
        float scrollY = getScrollY() + f3;
        float clientHeight = getClientHeight();
        float f4 = this.w * clientHeight;
        float f5 = this.x * clientHeight;
        boolean z3 = true;
        if (this.f31895e.size() > 0) {
            C0360b c0360b = this.f31895e.get(0);
            ArrayList<C0360b> arrayList = this.f31895e;
            C0360b c0360b2 = arrayList.get(arrayList.size() - 1);
            if (c0360b.f31901b != 0) {
                f4 = c0360b.f31904e * clientHeight;
                z2 = false;
            } else {
                z2 = true;
            }
            if (c0360b2.f31901b != this.i.getCount() - 1) {
                f5 = c0360b2.f31904e * clientHeight;
                z3 = z2;
                z = false;
                if (scrollY >= f4) {
                    r5 = z3 ? this.T.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
                    scrollY = f4;
                } else if (scrollY > f5) {
                    r5 = z ? this.U.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
                    scrollY = f5;
                }
                int i2 = (int) scrollY;
                this.I += scrollY - i2;
                int a2 = a(i2);
                scrollTo(getScrollX(), a2);
                h(a(a2));
                return r5;
            }
            z3 = z2;
        }
        z = true;
        if (scrollY >= f4) {
        }
        int i22 = (int) scrollY;
        this.I += scrollY - i22;
        int a22 = a(i22);
        scrollTo(getScrollX(), a22);
        h(a(a22));
        return r5;
    }

    public C0360b c(int i2) {
        for (int i3 = 0; i3 < this.f31895e.size(); i3++) {
            C0360b c0360b = this.f31895e.get(i3);
            if (c0360b.f31901b == i2) {
                return c0360b;
            }
        }
        return null;
    }

    public void c() {
        f fVar = this.ag;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
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
        return i2 < 0 ? scrollY > ((int) (((float) clientHeight) * this.w)) : i2 > 0 && scrollY < ((int) (((float) clientHeight) * this.x));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0360b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f31901b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.i) != null && pagerAdapter.getCount() > 1)) {
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
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.t;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(int i2) {
        boolean z;
        View findNextFocus;
        boolean r;
        View findFocus = findFocus();
        boolean z2 = false;
        if (findFocus != this) {
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
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    com.kwad.sdk.core.d.a.a("VerticalViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus != null || findNextFocus == findFocus) {
                if (i2 != 33 || i2 == 1) {
                    z2 = q();
                } else if (i2 == 130 || i2 == 2) {
                    z2 = r();
                }
            } else if (i2 == 33) {
                int i3 = a(this.f31898h, findNextFocus).top;
                int i4 = a(this.f31898h, findFocus).top;
                if (findFocus != null && i3 >= i4) {
                    r = q();
                    z2 = r;
                }
                r = findNextFocus.requestFocus();
                z2 = r;
            } else if (i2 == 130) {
                int i5 = a(this.f31898h, findNextFocus).bottom;
                int i6 = a(this.f31898h, findFocus).bottom;
                if (findFocus != null && i5 <= i6) {
                    r = r();
                    z2 = r;
                }
                r = findNextFocus.requestFocus();
                z2 = r;
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        if (findNextFocus != null) {
        }
        if (i2 != 33) {
        }
        z2 = q();
        if (z2) {
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.aj == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ak.get(i3).getLayoutParams()).f31910f;
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

    public void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.p = new Scroller(context, f31893d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f31896f = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.O = (int) (400.0f * f2);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffectCompat(context);
        this.U = new EdgeEffectCompat(context);
        this.Q = (int) (25.0f * f2);
        this.R = (int) (2.0f * f2);
        this.G = (int) (f2 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public void m() {
        int count = this.i.getCount();
        this.f31894b = count;
        boolean z = this.f31895e.size() < (this.D * 2) + 1 && this.f31895e.size() < count;
        int i2 = this.j;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.f31895e.size()) {
            C0360b c0360b = this.f31895e.get(i3);
            int itemPosition = this.i.getItemPosition(c0360b);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f31895e.remove(i3);
                    i3--;
                    if (!z2) {
                        this.i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.i.destroyItem((ViewGroup) this, c0360b.f31901b, c0360b.f31900a);
                    int i4 = this.j;
                    if (i4 == c0360b.f31901b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = c0360b.f31901b;
                    if (i5 != itemPosition) {
                        if (i5 == this.j) {
                            i2 = itemPosition;
                        }
                        c0360b.f31901b = itemPosition;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f31895e, f31892c);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                if (!cVar.f31905a) {
                    cVar.f31907c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public void n() {
        b(this.j);
    }

    public void o() {
        List<DataSetObserver> list = this.r;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.r.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "onDetachedFromWindow");
        removeCallbacks(this.am);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.s <= 0 || this.t == null || this.f31895e.size() <= 0 || this.i == null) {
            return;
        }
        int scrollY = getScrollY();
        float height2 = getHeight();
        float f4 = this.s / height2;
        int i2 = 0;
        C0360b c0360b = this.f31895e.get(0);
        float f5 = c0360b.f31904e;
        int size = this.f31895e.size();
        int i3 = c0360b.f31901b;
        int i4 = this.f31895e.get(size - 1).f31901b;
        while (i3 < i4) {
            while (i3 > c0360b.f31901b && i2 < size) {
                i2++;
                c0360b = this.f31895e.get(i2);
            }
            if (i3 == c0360b.f31901b) {
                float f6 = c0360b.f31904e;
                float f7 = c0360b.f31903d;
                f2 = (f6 + f7) * height2;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.i.getPageWidth(i3);
                f2 = (f5 + pageWidth) * height2;
                f5 += pageWidth + f4;
            }
            int i5 = this.s;
            if (i5 + f2 > scrollY) {
                f3 = f4;
                this.t.setBounds(this.u, (int) f2, this.v, (int) (i5 + f2 + 0.5f));
                this.t.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollY + height) {
                return;
            }
            i3++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.E = false;
            this.F = false;
            this.M = -1;
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.N = null;
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
        if (action == 0) {
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = MotionEventCompat.getPointerId(motionEvent, 0);
            this.F = false;
            this.p.computeScrollOffset();
            if (this.an != 2 || Math.abs(this.p.getFinalY() - this.p.getCurrY()) <= this.R) {
                a(false);
                this.E = false;
            } else {
                this.p.abortAnimation();
                this.C = false;
                n();
                this.E = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
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
                if (f2 != 0.0f && z && a3) {
                    this.I = a2;
                    this.J = b2;
                    this.F = true;
                    return false;
                }
                if (abs > this.f31896f && abs > abs2) {
                    this.E = true;
                    c(true);
                    setScrollState(1);
                    this.J = f2 > 0.0f ? this.L + this.f31896f : this.L - this.f31896f;
                    this.I = a2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > this.f31896f) {
                    this.F = true;
                }
                if (this.E && b(b2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.E;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        C0360b a2;
        int max;
        int i6;
        int max2;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f31905a) {
                    int i12 = cVar.f31906b;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 != 1) {
                        if (i13 == 3) {
                            i6 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i13 != 5) {
                            i6 = paddingLeft;
                        } else {
                            max = (i8 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i14 == 16) {
                            if (i14 == 48) {
                                i7 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i14 != 80) {
                                i7 = paddingTop;
                            } else {
                                max2 = (i9 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i15 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i15, childAt.getMeasuredWidth() + paddingLeft, i15 + childAt.getMeasuredHeight());
                            i10++;
                            paddingTop = i7;
                            paddingLeft = i6;
                        } else {
                            max2 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i16 = max2;
                        i7 = paddingTop;
                        paddingTop = i16;
                        int i152 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i152, childAt.getMeasuredWidth() + paddingLeft, i152 + childAt.getMeasuredHeight());
                        i10++;
                        paddingTop = i7;
                        paddingLeft = i6;
                    } else {
                        max = Math.max((i8 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i17 = max;
                    i6 = paddingLeft;
                    paddingLeft = i17;
                    if (i14 == 16) {
                    }
                    int i162 = max2;
                    i7 = paddingTop;
                    paddingTop = i162;
                    int i1522 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i1522, childAt.getMeasuredWidth() + paddingLeft, i1522 + childAt.getMeasuredHeight());
                    i10++;
                    paddingTop = i7;
                    paddingLeft = i6;
                }
            }
        }
        int i18 = (i9 - paddingTop) - paddingBottom;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f31905a && (a2 = a(childAt2)) != null) {
                    float f2 = i18;
                    int i20 = ((int) (a2.f31904e * f2)) + paddingTop;
                    if (cVar2.f31908d) {
                        cVar2.f31908d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i8 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f31907c), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i20, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i20);
                }
            }
        }
        this.u = paddingLeft;
        this.v = i8 - paddingRight;
        this.ab = i10;
        if (this.V) {
            a(this.j, false, 0, false, false);
        }
        this.V = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredHeight = getMeasuredHeight();
        this.H = Math.min(measuredHeight / 10, this.G);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            boolean z = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f31905a) {
                int i9 = cVar2.f31906b;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i12 = 1073741824;
                } else if (z) {
                    i4 = 1073741824;
                    i5 = ((ViewGroup.LayoutParams) cVar2).width;
                    if (i5 == -2) {
                        if (i5 == -1) {
                            i5 = measuredWidth;
                        }
                        i12 = 1073741824;
                    } else {
                        i5 = measuredWidth;
                    }
                    i6 = ((ViewGroup.LayoutParams) cVar2).height;
                    if (i6 != -2) {
                        i6 = paddingTop;
                        i8 = i4;
                    } else if (i6 == -1) {
                        i6 = paddingTop;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                    if (!z2) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (z) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i4 = Integer.MIN_VALUE;
                i5 = ((ViewGroup.LayoutParams) cVar2).width;
                if (i5 == -2) {
                }
                i6 = ((ViewGroup.LayoutParams) cVar2).height;
                if (i6 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                if (!z2) {
                }
            }
            i7++;
        }
        this.y = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.z = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.A = true;
        n();
        this.A = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f31905a)) {
                childAt2.measure(this.y, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * cVar.f31907c), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        C0360b a2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f31901b == this.j && childAt.requestFocus(i2, rect)) {
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
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(hVar.f31914b, hVar.f31915c);
            a(hVar.f31913a, false, true);
            return;
        }
        this.l = hVar.f31913a;
        this.n = hVar.f31914b;
        this.o = hVar.f31915c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            int i6 = this.s;
            a(i3, i5, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        int pointerId;
        if (this.S) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.i) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                if (this.E) {
                    VelocityTracker velocityTracker = this.N;
                    velocityTracker.computeCurrentVelocity(1000, this.P);
                    int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.M);
                    this.C = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    C0360b d2 = d();
                    if (d2 != null) {
                        a(a(d2.f31901b, ((scrollY / clientHeight) - d2.f31904e) / d2.f31903d, yVelocity, (int) (b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M)) - this.L)), true, true, yVelocity, true);
                        this.M = -1;
                        e();
                        z = this.T.onRelease() | this.U.onRelease();
                    }
                }
                this.ac = System.currentTimeMillis();
            } else if (action == 2) {
                if (!this.E) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.M);
                    float b2 = b(motionEvent, findPointerIndex);
                    float abs = Math.abs(b2 - this.J);
                    float a2 = a(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(a2 - this.I);
                    if (abs > this.f31896f && abs > abs2) {
                        this.E = true;
                        c(true);
                        float f2 = this.L;
                        this.J = b2 - f2 > 0.0f ? f2 + this.f31896f : f2 - this.f31896f;
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
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.J = b(motionEvent, actionIndex);
                    pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.J = b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M));
                }
            } else if (this.E) {
                a(this.j, true, 0, false, false);
                this.M = -1;
                e();
                z = this.T.onRelease() | this.U.onRelease();
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return true;
        }
        this.p.abortAnimation();
        this.C = false;
        n();
        float x = motionEvent.getX();
        this.K = x;
        this.I = x;
        float y = motionEvent.getY();
        this.L = y;
        this.J = y;
        pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.M = pointerId;
        if (z) {
        }
        return true;
    }

    public void p() {
        List<DataSetObserver> list = this.r;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.r.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onInvalidated();
                }
            }
        }
    }

    public boolean q() {
        int i2 = this.j;
        if (i2 > 0) {
            a(i2 - 1, true);
            return true;
        }
        return false;
    }

    public boolean r() {
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter == null || this.j >= pagerAdapter.getCount() - 1) {
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
        PagerAdapter pagerAdapter2 = this.i;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.q);
            this.i.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f31895e.size(); i2++) {
                C0360b c0360b = this.f31895e.get(i2);
                this.i.destroyItem((ViewGroup) this, c0360b.f31901b, c0360b.f31900a);
            }
            this.i.finishUpdate((ViewGroup) this);
            this.f31895e.clear();
            a();
            int i3 = this.j;
            if (i3 != 0) {
                this.k = i3;
            } else {
                this.k = -1;
            }
            this.j = 0;
            scrollTo(0, 0);
        }
        int i4 = this.m;
        if (i4 > 0) {
            this.k = -1;
            this.j = i4;
            this.m = -1;
        }
        PagerAdapter pagerAdapter3 = this.i;
        this.i = pagerAdapter;
        this.f31894b = 0;
        if (pagerAdapter != null) {
            if (this.q == null) {
                this.q = new g();
            }
            this.i.registerDataSetObserver(this.q);
            this.C = false;
            boolean z = this.V;
            this.V = true;
            this.f31894b = this.i.getCount();
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
        e eVar = this.af;
        if (eVar == null || pagerAdapter3 == pagerAdapter) {
            return;
        }
        eVar.a(pagerAdapter3, pagerAdapter);
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
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

    public void setCurrentItem(int i2) {
        com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2);
        this.C = false;
        a(i2, this.V ^ true, false);
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

    public void setOnAdapterChangeListener(e eVar) {
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
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.t;
    }
}
