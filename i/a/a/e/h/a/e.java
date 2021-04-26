package i.a.a.e.h.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Activity f68096a;

    /* renamed from: b  reason: collision with root package name */
    public Window f68097b;

    /* renamed from: c  reason: collision with root package name */
    public View f68098c;

    /* renamed from: d  reason: collision with root package name */
    public View f68099d;

    /* renamed from: e  reason: collision with root package name */
    public View f68100e;

    /* renamed from: f  reason: collision with root package name */
    public b f68101f;

    /* renamed from: g  reason: collision with root package name */
    public int f68102g;

    /* renamed from: h  reason: collision with root package name */
    public int f68103h;

    /* renamed from: i  reason: collision with root package name */
    public int f68104i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p = new a();

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            int i3;
            int i4;
            int height;
            int i5;
            if (e.this.o) {
                Rect rect = new Rect();
                e.this.f68098c.getWindowVisibleDisplayFrame(rect);
                if (e.this.f68101f.B) {
                    int height2 = (e.this.f68099d.getHeight() - rect.bottom) - e.this.n;
                    if (e.this.f68101f.D != null) {
                        e.this.f68101f.D.a(height2 > e.this.n, height2);
                    }
                } else if (e.this.f68100e != null) {
                    if (e.this.f68101f.w) {
                        height = e.this.f68099d.getHeight() + e.this.l + e.this.m;
                        i5 = rect.bottom;
                    } else if (e.this.f68101f.r) {
                        height = e.this.f68099d.getHeight() + e.this.l;
                        i5 = rect.bottom;
                    } else {
                        height = e.this.f68099d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = e.this.f68101f.f68080i ? i6 - e.this.n : i6;
                    if (e.this.f68101f.f68080i && i6 == e.this.n) {
                        i6 -= e.this.n;
                    }
                    if (i7 != e.this.k) {
                        e.this.f68099d.setPadding(e.this.f68102g, e.this.f68103h, e.this.f68104i, i6 + e.this.j);
                        e.this.k = i7;
                        if (e.this.f68101f.D != null) {
                            e.this.f68101f.D.a(i7 > e.this.n, i7);
                        }
                    }
                } else {
                    int height3 = e.this.f68099d.getHeight() - rect.bottom;
                    if (e.this.f68101f.z && e.this.f68101f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = e.this.n;
                        } else if (!e.this.f68101f.f68080i) {
                            i4 = height3;
                            if (e.this.f68101f.f68080i && height3 == e.this.n) {
                                height3 -= e.this.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = e.this.n;
                        }
                        i4 = height3 - i3;
                        if (e.this.f68101f.f68080i) {
                            height3 -= e.this.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != e.this.k) {
                        if (e.this.f68101f.w) {
                            e.this.f68099d.setPadding(0, e.this.l + e.this.m, 0, i2);
                        } else if (e.this.f68101f.r) {
                            e.this.f68099d.setPadding(0, e.this.l, 0, i2);
                        } else {
                            e.this.f68099d.setPadding(0, 0, 0, i2);
                        }
                        e.this.k = height3;
                        if (e.this.f68101f.D != null) {
                            e.this.f68101f.D.a(height3 > e.this.n, height3);
                        }
                    }
                }
            }
        }
    }

    public e(Activity activity, Window window) {
        this.f68096a = activity;
        this.f68097b = window;
        View decorView = window.getDecorView();
        this.f68098c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f68100e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f68099d = frameLayout;
        this.f68102g = frameLayout.getPaddingLeft();
        this.f68103h = this.f68099d.getPaddingTop();
        this.f68104i = this.f68099d.getPaddingRight();
        this.j = this.f68099d.getPaddingBottom();
        i.a.a.e.h.a.a aVar = new i.a.a.e.h.a.a(this.f68096a);
        this.l = aVar.i();
        this.n = aVar.d();
        this.m = aVar.a();
        this.o = aVar.l();
    }

    public static e q(Activity activity, Window window) {
        return new e(activity, window);
    }

    public void o(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f68097b.setSoftInputMode(i2);
            this.f68098c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
        }
        this.f68096a = null;
    }

    public void p(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f68097b.setSoftInputMode(i2);
            this.f68098c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
        }
    }

    public void r(b bVar) {
        this.f68101f = bVar;
    }
}
