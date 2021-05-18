package d.a.a0.p;

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
import d.a.a0.i;
import d.a.a0.n.d;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class c {
    public static final boolean P = d.f38476d;
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
    public Context f38495a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f38496b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38497c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38498d;

    /* renamed from: e  reason: collision with root package name */
    public View f38499e;

    /* renamed from: f  reason: collision with root package name */
    public View f38500f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38501g;
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
    public int f38502h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f38503i = 1;
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
            if (view == null || c.this.f38500f == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.f38500f.getLayoutParams();
            c cVar = c.this;
            cVar.p(cVar.j(view, layoutParams, cVar.N, c.this.O));
            c.this.F(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onDismiss();
    }

    /* renamed from: d.a.a0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0489c extends FrameLayout {
        public C0489c(Context context) {
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
        public int[] onCreateDrawableState(int i2) {
            if (c.this.G) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.Q);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i2);
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
        public void sendAccessibilityEvent(int i2) {
            if (c.this.f38499e != null) {
                c.this.f38499e.sendAccessibilityEvent(i2);
            } else {
                super.sendAccessibilityEvent(i2);
            }
        }
    }

    public c(View view, int i2, int i3, boolean z) {
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a();
        if (view != null) {
            Context context = view.getContext();
            this.f38495a = context;
            this.f38496b = (WindowManager) context.getSystemService("window");
        }
        z(view);
        D(i2);
        B(i3);
        A(z);
    }

    public void A(boolean z) {
        this.f38501g = z;
    }

    public void B(int i2) {
        this.x = i2;
    }

    public void C(boolean z) {
        this.k = z;
    }

    public void D(int i2) {
        this.u = i2;
    }

    public void E(View view, int i2, int i3, int i4) {
        f(view.getWindowToken(), i2, i3, i4);
    }

    public void F(int i2, int i3, int i4, int i5, boolean z) {
        if (i4 != -1) {
            this.v = i4;
            D(i4);
        }
        if (i5 != -1) {
            this.y = i5;
            B(i5);
        }
        if (!u() || this.f38499e == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f38500f.getLayoutParams();
        int i6 = this.t;
        if (i6 >= 0) {
            i6 = this.v;
        }
        boolean z2 = true;
        if (i4 != -1 && layoutParams.width != i6) {
            this.v = i6;
            layoutParams.width = i6;
            z = true;
        }
        int i7 = this.w;
        if (i7 >= 0) {
            i7 = this.y;
        }
        if (i5 != -1 && layoutParams.height != i7) {
            this.y = i7;
            layoutParams.height = i7;
            z = true;
        }
        if (layoutParams.x != i2) {
            layoutParams.x = i2;
            z = true;
        }
        if (layoutParams.y != i3) {
            layoutParams.y = i3;
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
            this.f38496b.updateViewLayout(this.f38500f, layoutParams);
        }
    }

    public final int a() {
        int i2 = this.K;
        if (i2 == -1) {
            if (this.f38498d) {
                return this.G ? i.PopupWindow_DropDownUp : i.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i2;
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
        int i2 = this.u;
        this.v = i2;
        layoutParams.width = i2;
        int i3 = this.x;
        this.y = i3;
        layoutParams.height = i3;
        Drawable drawable = this.D;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = w(layoutParams.flags);
        layoutParams.type = this.H;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.f38503i;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    public void f(IBinder iBinder, int i2, int i3, int i4) {
        if (iBinder == null || u() || this.f38499e == null) {
            return;
        }
        b();
        this.f38497c = true;
        this.f38498d = false;
        WindowManager.LayoutParams d2 = d(iBinder);
        d2.windowAnimations = a();
        m(d2);
        if (i2 == 0) {
            i2 = 51;
        }
        d2.gravity = i2;
        d2.x = i3;
        d2.y = i4;
        int i5 = this.w;
        if (i5 < 0) {
            this.y = i5;
            d2.height = i5;
        }
        int i6 = this.t;
        if (i6 < 0) {
            this.v = i6;
            d2.width = i6;
        }
        g(d2);
    }

    public final void g(WindowManager.LayoutParams layoutParams) {
        Context context = this.f38495a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f38496b.addView(this.f38500f, layoutParams);
    }

    public void h(b bVar) {
        this.I = bVar;
    }

    public final boolean j(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
        int height = view.getHeight();
        view.getLocationInWindow(this.B);
        int[] iArr = this.B;
        layoutParams.x = iArr[0] + i2;
        layoutParams.y = iArr[1] + height + i3;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.C);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (this.C[1] + height + i3 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
            if (this.p) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i2, this.A + scrollY + view.getHeight() + i3), true);
            }
            view.getLocationInWindow(this.B);
            int[] iArr2 = this.B;
            layoutParams.x = iArr2[0] + i2;
            layoutParams.y = iArr2[1] + view.getHeight() + i3;
            view.getLocationOnScreen(this.C);
            r2 = ((rect.bottom - this.C[1]) - view.getHeight()) - i3 < (this.C[1] - i3) - rect.top;
            if (r2) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.B[1]) + i3;
            } else {
                layoutParams.y = this.B[1] + view.getHeight() + i3;
            }
        }
        if (this.o) {
            int i4 = rect.right - rect.left;
            int i5 = layoutParams.x;
            int i6 = layoutParams.width + i5;
            if (i6 > i4) {
                layoutParams.x = i5 - (i6 - i4);
            }
            int i7 = layoutParams.x;
            int i8 = rect.left;
            if (i7 < i8) {
                layoutParams.x = i8;
                layoutParams.width = Math.min(layoutParams.width, i4);
            }
            if (r2) {
                int i9 = (this.C[1] + i3) - this.A;
                if (i9 < 0) {
                    layoutParams.y += i9;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= Label.FORWARD_REFERENCE_TYPE_SHORT;
        return r2;
    }

    public final void m(WindowManager.LayoutParams layoutParams) {
        View view = this.f38499e;
        if (view != null && this.f38495a != null && this.f38496b != null) {
            if (this.D != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                int i2 = -2;
                i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                C0489c c0489c = new C0489c(this.f38495a);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                c0489c.setBackgroundDrawable(this.D);
                c0489c.addView(this.f38499e, layoutParams3);
                this.f38500f = c0489c;
            } else {
                this.f38500f = view;
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
                    this.f38500f.refreshDrawableState();
                } else if (z) {
                    this.f38500f.setBackgroundDrawable(drawable);
                } else {
                    this.f38500f.setBackgroundDrawable(this.F);
                }
            }
        }
    }

    public void q() {
        b bVar;
        if (!u() || this.f38500f == null) {
            return;
        }
        this.f38497c = false;
        b();
        try {
            try {
                this.f38496b.removeView(this.f38500f);
                View view = this.f38500f;
                View view2 = this.f38499e;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.f38500f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (IllegalArgumentException e2) {
                if (!P) {
                    View view3 = this.f38500f;
                    View view4 = this.f38499e;
                    if (view3 != view4 && (view3 instanceof ViewGroup)) {
                        ((ViewGroup) view3).removeView(view4);
                    }
                    this.f38500f = null;
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
            View view5 = this.f38500f;
            View view6 = this.f38499e;
            if (view5 != view6 && (view5 instanceof ViewGroup)) {
                ((ViewGroup) view5).removeView(view6);
            }
            this.f38500f = null;
            b bVar2 = this.I;
            if (bVar2 != null) {
                bVar2.onDismiss();
            }
            throw th;
        }
    }

    public boolean u() {
        return this.f38497c;
    }

    public boolean v() {
        Context context;
        return (this.m >= 0 || (context = this.f38495a) == null) ? this.m == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r2.f38502h == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        r3 = r3 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r2.f38502h == 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int w(int i2) {
        int i3 = i2 & (-8815129);
        if (this.J) {
            i3 |= 32768;
        }
        if (!this.f38501g) {
            i3 |= 8;
        }
        if (!this.j) {
            i3 |= 16;
        }
        if (this.k) {
            i3 |= 262144;
        }
        if (!this.l) {
            i3 |= 512;
        }
        if (v()) {
            i3 |= 8388608;
        }
        if (this.n) {
            i3 |= 256;
        }
        if (this.q) {
            i3 |= 65536;
        }
        return this.r ? i3 | 32 : i3;
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
        this.f38499e = view;
        if (this.f38495a == null && view != null) {
            this.f38495a = view.getContext();
        }
        if (this.f38496b != null || this.f38499e == null || (context = this.f38495a) == null) {
            return;
        }
        this.f38496b = (WindowManager) context.getSystemService("window");
    }
}
