package d.a.i0.a.w1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import d.a.i0.a.k;
import d.a.i0.a.w1.j.e;
import d.a.i0.a.w1.j.g;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45433e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public int f45434a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f45435b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.w1.k.a f45436c;

    /* renamed from: d  reason: collision with root package name */
    public Context f45437d;

    public c(View view) {
        this.f45435b = view;
        this.f45437d = view.getContext();
    }

    public final d.a.i0.a.w1.k.a a(View view) {
        d.a.i0.a.w1.k.a aVar = this.f45436c;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.a.i0.a.w1.k.a) {
            d.a.i0.a.w1.k.a aVar2 = (d.a.i0.a.w1.k.a) view;
            this.f45436c = aVar2;
            return aVar2;
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                d.a.i0.a.w1.k.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f45436c = a2;
                    return a2;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public void b(int i2, int i3) {
        Context context = this.f45437d;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (g.f(activity) && this.f45435b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f45435b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
                if (f45433e) {
                    Log.d("SPSwitchRootLayout", "TranslucentStatus && FitsSystemWindows = true, height: " + i3);
                }
            }
            if (g.e(activity) && this.f45435b.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.f45435b.getWindowVisibleDisplayFrame(rect2);
                i3 = rect2.bottom - rect2.top;
                if (f45433e) {
                    Log.d("SPSwitchRootLayout", "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3);
                }
            }
        }
        if (f45433e) {
            Log.d("SPSwitchRootLayout", "onMeasure, width: " + i2 + " height: " + i3);
        }
        if (i3 < 0) {
            return;
        }
        int i4 = this.f45434a;
        if (i4 < 0) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "onMeasure, oldHeight < 0, oldHeight: " + this.f45434a);
            }
            this.f45434a = i3;
            return;
        }
        int i5 = i4 - i3;
        if (i5 == 0) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "offset == 0, break;");
                return;
            }
            return;
        }
        this.f45434a = i3;
        d.a.i0.a.w1.k.a a2 = a(this.f45435b);
        if (a2 == null) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "cannot find the valid panel layout, give up!");
                return;
            }
            return;
        }
        int visibility = ((LinearLayout) a2).getVisibility();
        if (f45433e) {
            Log.d("SPSwitchRootLayout", "panel visibility: " + visibility);
        }
        if (Math.abs(i5) < e.g(this.f45435b.getContext())) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "layout change min, not caused by softinput/panel switch!");
            }
        } else if (Math.abs(i5) > e.e(this.f45435b.getContext())) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "layout change max , but not caused by softinput/panel switch!");
            }
        } else if (i5 > 0) {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "offset > 0, offset : " + i5 + ", panel->handleHide...");
            }
            a2.handleHide();
        } else {
            if (f45433e) {
                Log.d("SPSwitchRootLayout", "offset < 0, offset : " + i5 + ", panel->handleShow...");
            }
            a2.handleShow();
        }
    }
}
