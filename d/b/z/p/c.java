package d.b.z.p;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.alibaba.fastjson.asm.Label;
import d.b.z.i;
import d.b.z.n.d;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class c {
    public static final boolean P = d.f65748d;
    public static final int[] Q = {16842922};
    public int A;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public boolean G;
    public int H;
    public b I;
    public boolean J;
    public int K;
    public WeakReference<View> L;
    public ViewTreeObserver.OnScrollChangedListener M;
    public int N;
    public int O;

    /* renamed from: a  reason: collision with root package name */
    public Context f65767a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f65768b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65769c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65770d;

    /* renamed from: e  reason: collision with root package name */
    public View f65771e;

    /* renamed from: f  reason: collision with root package name */
    public View f65772f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65773g;
    public boolean n;
    public boolean o;
    public boolean r;
    public View.OnTouchListener s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: h  reason: collision with root package name */
    public int f65774h = 0;
    public int i = 1;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;
    public boolean p = true;
    public boolean q = false;
    public int[] B = new int[2];
    public int[] C = new int[2];

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.L != null ? (View) c.this.L.get() : null;
            if (view == null || c.this.f65772f == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.f65772f.getLayoutParams();
            c cVar = c.this;
            cVar.p(cVar.j(view, layoutParams, cVar.N, c.this.O));
            c.this.F(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onDismiss();
    }

    /* renamed from: d.b.z.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1811c extends FrameLayout {
        public C1811c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    c.this.q();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (c.this.s == null || !c.this.s.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i) {
            if (c.this.G) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.Q);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                c.this.q();
                return true;
            } else if (motionEvent.getAction() == 4) {
                c.this.q();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (c.this.f65771e != null) {
                c.this.f65771e.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a();
        if (view != null) {
            Context context = view.getContext();
            this.f65767a = context;
            this.f65768b = (WindowManager) context.getSystemService("window");
        }
        z(view);
        D(i);
        B(i2);
        A(z);
    }

    public void A(boolean z) {
        this.f65773g = z;
    }

    public void B(int i) {
        this.x = i;
    }

    public void C(boolean z) {
        this.k = z;
    }

    public void D(int i) {
        this.u = i;
    }

    public void E(View view, int i, int i2, int i3) {
        f(view.getWindowToken(), i, i2, i3);
    }

    public void F(int i, int i2, int i3, int i4, boolean z) {
        if (i3 != -1) {
            this.v = i3;
            D(i3);
        }
        if (i4 != -1) {
            this.y = i4;
            B(i4);
        }
        if (!u() || this.f65771e == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f65772f.getLayoutParams();
        int i5 = this.t;
        if (i5 >= 0) {
            i5 = this.v;
        }
        boolean z2 = true;
        if (i3 != -1 && layoutParams.width != i5) {
            this.v = i5;
            layoutParams.width = i5;
            z = true;
        }
        int i6 = this.w;
        if (i6 >= 0) {
            i6 = this.y;
        }
        if (i4 != -1 && layoutParams.height != i6) {
            this.y = i6;
            layoutParams.height = i6;
            z = true;
        }
        if (layoutParams.x != i) {
            layoutParams.x = i;
            z = true;
        }
        if (layoutParams.y != i2) {
            layoutParams.y = i2;
            z = true;
        }
        int a2 = a();
        if (a2 != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = a2;
            z = true;
        }
        int w = w(layoutParams.flags);
        if (w != layoutParams.flags) {
            layoutParams.flags = w;
        } else {
            z2 = z;
        }
        if (z2) {
            this.f65768b.updateViewLayout(this.f65772f, layoutParams);
        }
    }

    public final int a() {
        int i = this.K;
        if (i == -1) {
            if (this.f65770d) {
                return this.G ? i.PopupWindow_DropDownUp : i.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    public final void b() {
        WeakReference<View> weakReference = this.L;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.M);
        }
        this.L = null;
    }

    public final WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.u;
        this.v = i;
        layoutParams.width = i;
        int i2 = this.x;
        this.y = i2;
        layoutParams.height = i2;
        Drawable drawable = this.D;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = w(layoutParams.flags);
        layoutParams.type = this.H;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.i;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    public void f(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder == null || u() || this.f65771e == null) {
            return;
        }
        b();
        this.f65769c = true;
        this.f65770d = false;
        WindowManager.LayoutParams d2 = d(iBinder);
        d2.windowAnimations = a();
        m(d2);
        if (i == 0) {
            i = 51;
        }
        d2.gravity = i;
        d2.x = i2;
        d2.y = i3;
        int i4 = this.w;
        if (i4 < 0) {
            this.y = i4;
            d2.height = i4;
        }
        int i5 = this.t;
        if (i5 < 0) {
            this.v = i5;
            d2.width = i5;
        }
        g(d2);
    }

    public final void g(WindowManager.LayoutParams layoutParams) {
        Context context = this.f65767a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f65768b.addView(this.f65772f, layoutParams);
    }

    public void h(b bVar) {
        this.I = bVar;
    }

    public final boolean j(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.B);
        int[] iArr = this.B;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.C);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (this.C[1] + height + i2 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
            if (this.p) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i, this.A + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.B);
            int[] iArr2 = this.B;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.C);
            r2 = ((rect.bottom - this.C[1]) - view.getHeight()) - i2 < (this.C[1] - i2) - rect.top;
            if (r2) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.B[1]) + i2;
            } else {
                layoutParams.y = this.B[1] + view.getHeight() + i2;
            }
        }
        if (this.o) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x;
            int i5 = layoutParams.width + i4;
            if (i5 > i3) {
                layoutParams.x = i4 - (i5 - i3);
            }
            int i6 = layoutParams.x;
            int i7 = rect.left;
            if (i6 < i7) {
                layoutParams.x = i7;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r2) {
                int i8 = (this.C[1] + i2) - this.A;
                if (i8 < 0) {
                    layoutParams.y += i8;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= Label.FORWARD_REFERENCE_TYPE_SHORT;
        return r2;
    }

    public final void m(WindowManager.LayoutParams layoutParams) {
        View view = this.f65771e;
        if (view != null && this.f65767a != null && this.f65768b != null) {
            if (this.D != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                int i = -2;
                i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                C1811c c1811c = new C1811c(this.f65767a);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c1811c.setBackgroundDrawable(this.D);
                c1811c.addView(this.f65771e, layoutParams3);
                this.f65772f = c1811c;
            } else {
                this.f65772f = view;
            }
            this.z = layoutParams.width;
            this.A = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    public final void p(boolean z) {
        if (z != this.G) {
            this.G = z;
            if (this.D != null) {
                Drawable drawable = this.E;
                if (drawable == null) {
                    this.f65772f.refreshDrawableState();
                } else if (z) {
                    this.f65772f.setBackgroundDrawable(drawable);
                } else {
                    this.f65772f.setBackgroundDrawable(this.F);
                }
            }
        }
    }

    public void q() {
        b bVar;
        if (!u() || this.f65772f == null) {
            return;
        }
        this.f65769c = false;
        b();
        try {
            try {
                this.f65768b.removeView(this.f65772f);
                View view = this.f65772f;
                View view2 = this.f65771e;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.f65772f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (IllegalArgumentException e2) {
                if (!P) {
                    View view3 = this.f65772f;
                    View view4 = this.f65771e;
                    if (view3 != view4 && (view3 instanceof ViewGroup)) {
                        ((ViewGroup) view3).removeView(view4);
                    }
                    this.f65772f = null;
                    bVar = this.I;
                    if (bVar == null) {
                        return;
                    }
                } else {
                    throw e2;
                }
            }
            bVar.onDismiss();
        } catch (Throwable th) {
            View view5 = this.f65772f;
            View view6 = this.f65771e;
            if (view5 != view6 && (view5 instanceof ViewGroup)) {
                ((ViewGroup) view5).removeView(view6);
            }
            this.f65772f = null;
            b bVar2 = this.I;
            if (bVar2 != null) {
                bVar2.onDismiss();
            }
            throw th;
        }
    }

    public boolean u() {
        return this.f65769c;
    }

    public boolean v() {
        Context context;
        return (this.m >= 0 || (context = this.f65767a) == null) ? this.m == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r2.f65774h == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        r3 = r3 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r2.f65774h == 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int w(int i) {
        int i2 = i & (-8815129);
        if (this.J) {
            i2 |= 32768;
        }
        if (!this.f65773g) {
            i2 |= 8;
        }
        if (!this.j) {
            i2 |= 16;
        }
        if (this.k) {
            i2 |= 262144;
        }
        if (!this.l) {
            i2 |= 512;
        }
        if (v()) {
            i2 |= 8388608;
        }
        if (this.n) {
            i2 |= 256;
        }
        if (this.q) {
            i2 |= 65536;
        }
        return this.r ? i2 | 32 : i2;
    }

    public void x(Drawable drawable) {
        this.D = drawable;
    }

    public void y(boolean z) {
        this.l = z;
    }

    public void z(View view) {
        Context context;
        if (u()) {
            return;
        }
        this.f65771e = view;
        if (this.f65767a == null && view != null) {
            this.f65767a = view.getContext();
        }
        if (this.f65768b != null || this.f65771e == null || (context = this.f65767a) == null) {
            return;
        }
        this.f65768b = (WindowManager) context.getSystemService("window");
    }
}
