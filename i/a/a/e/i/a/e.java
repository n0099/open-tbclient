package i.a.a.e.i.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Activity f72075a;

    /* renamed from: b  reason: collision with root package name */
    public Window f72076b;

    /* renamed from: c  reason: collision with root package name */
    public View f72077c;

    /* renamed from: d  reason: collision with root package name */
    public View f72078d;

    /* renamed from: e  reason: collision with root package name */
    public View f72079e;

    /* renamed from: f  reason: collision with root package name */
    public b f72080f;

    /* renamed from: g  reason: collision with root package name */
    public int f72081g;

    /* renamed from: h  reason: collision with root package name */
    public int f72082h;

    /* renamed from: i  reason: collision with root package name */
    public int f72083i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p = new a();

    /* loaded from: classes8.dex */
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
                e.this.f72077c.getWindowVisibleDisplayFrame(rect);
                if (e.this.f72080f.B) {
                    int height2 = (e.this.f72078d.getHeight() - rect.bottom) - e.this.n;
                    if (e.this.f72080f.D != null) {
                        e.this.f72080f.D.a(height2 > e.this.n, height2);
                    }
                } else if (e.this.f72079e != null) {
                    if (e.this.f72080f.w) {
                        height = e.this.f72078d.getHeight() + e.this.l + e.this.m;
                        i5 = rect.bottom;
                    } else if (e.this.f72080f.r) {
                        height = e.this.f72078d.getHeight() + e.this.l;
                        i5 = rect.bottom;
                    } else {
                        height = e.this.f72078d.getHeight();
                        i5 = rect.bottom;
                    }
                    int i6 = height - i5;
                    int i7 = e.this.f72080f.f72059i ? i6 - e.this.n : i6;
                    if (e.this.f72080f.f72059i && i6 == e.this.n) {
                        i6 -= e.this.n;
                    }
                    if (i7 != e.this.k) {
                        e.this.f72078d.setPadding(e.this.f72081g, e.this.f72082h, e.this.f72083i, i6 + e.this.j);
                        e.this.k = i7;
                        if (e.this.f72080f.D != null) {
                            e.this.f72080f.D.a(i7 > e.this.n, i7);
                        }
                    }
                } else {
                    int height3 = e.this.f72078d.getHeight() - rect.bottom;
                    if (e.this.f72080f.z && e.this.f72080f.A) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            i3 = e.this.n;
                        } else if (!e.this.f72080f.f72059i) {
                            i4 = height3;
                            if (e.this.f72080f.f72059i && height3 == e.this.n) {
                                height3 -= e.this.n;
                            }
                            int i8 = height3;
                            height3 = i4;
                            i2 = i8;
                        } else {
                            i3 = e.this.n;
                        }
                        i4 = height3 - i3;
                        if (e.this.f72080f.f72059i) {
                            height3 -= e.this.n;
                        }
                        int i82 = height3;
                        height3 = i4;
                        i2 = i82;
                    } else {
                        i2 = height3;
                    }
                    if (height3 != e.this.k) {
                        if (e.this.f72080f.w) {
                            e.this.f72078d.setPadding(0, e.this.l + e.this.m, 0, i2);
                        } else if (e.this.f72080f.r) {
                            e.this.f72078d.setPadding(0, e.this.l, 0, i2);
                        } else {
                            e.this.f72078d.setPadding(0, 0, 0, i2);
                        }
                        e.this.k = height3;
                        if (e.this.f72080f.D != null) {
                            e.this.f72080f.D.a(height3 > e.this.n, height3);
                        }
                    }
                }
            }
        }
    }

    public e(Activity activity, Window window) {
        this.f72075a = activity;
        this.f72076b = window;
        View decorView = window.getDecorView();
        this.f72077c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f72079e = childAt;
        frameLayout = childAt != null ? childAt : frameLayout;
        this.f72078d = frameLayout;
        this.f72081g = frameLayout.getPaddingLeft();
        this.f72082h = this.f72078d.getPaddingTop();
        this.f72083i = this.f72078d.getPaddingRight();
        this.j = this.f72078d.getPaddingBottom();
        i.a.a.e.i.a.a aVar = new i.a.a.e.i.a.a(this.f72075a);
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
            this.f72076b.setSoftInputMode(i2);
            this.f72077c.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
        }
        this.f72075a = null;
    }

    public void p(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f72076b.setSoftInputMode(i2);
            this.f72077c.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
        }
    }

    public void r(b bVar) {
        this.f72080f = bVar;
    }
}
