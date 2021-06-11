package d.a.l0.a.w1.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import d.a.l0.a.k;
import d.a.l0.a.w1.j.e;
import d.a.l0.a.w1.j.g;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49283e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public int f49284a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f49285b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.w1.k.a f49286c;

    /* renamed from: d  reason: collision with root package name */
    public Context f49287d;

    public c(View view) {
        this.f49285b = view;
        this.f49287d = view.getContext();
    }

    public final d.a.l0.a.w1.k.a a(View view) {
        d.a.l0.a.w1.k.a aVar = this.f49286c;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.a.l0.a.w1.k.a) {
            d.a.l0.a.w1.k.a aVar2 = (d.a.l0.a.w1.k.a) view;
            this.f49286c = aVar2;
            return aVar2;
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                d.a.l0.a.w1.k.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f49286c = a2;
                    return a2;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public void b(int i2, int i3) {
        Context context = this.f49287d;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (g.f(activity) && this.f49285b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f49285b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
                if (f49283e) {
                    Log.d("SPSwitchRootLayout", "TranslucentStatus && FitsSystemWindows = true, height: " + i3);
                }
            }
            if (g.e(activity) && this.f49285b.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.f49285b.getWindowVisibleDisplayFrame(rect2);
                i3 = rect2.bottom - rect2.top;
                if (f49283e) {
                    Log.d("SPSwitchRootLayout", "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3);
                }
            }
        }
        if (f49283e) {
            Log.d("SPSwitchRootLayout", "onMeasure, width: " + i2 + " height: " + i3);
        }
        if (i3 < 0) {
            return;
        }
        int i4 = this.f49284a;
        if (i4 < 0) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "onMeasure, oldHeight < 0, oldHeight: " + this.f49284a);
            }
            this.f49284a = i3;
            return;
        }
        int i5 = i4 - i3;
        if (i5 == 0) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "offset == 0, break;");
                return;
            }
            return;
        }
        this.f49284a = i3;
        d.a.l0.a.w1.k.a a2 = a(this.f49285b);
        if (a2 == null) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "cannot find the valid panel layout, give up!");
                return;
            }
            return;
        }
        int visibility = ((LinearLayout) a2).getVisibility();
        if (f49283e) {
            Log.d("SPSwitchRootLayout", "panel visibility: " + visibility);
        }
        if (Math.abs(i5) < e.g(this.f49285b.getContext())) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "layout change min, not caused by softinput/panel switch!");
            }
        } else if (Math.abs(i5) > e.e(this.f49285b.getContext())) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "layout change max , but not caused by softinput/panel switch!");
            }
        } else if (i5 > 0) {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "offset > 0, offset : " + i5 + ", panel->handleHide...");
            }
            a2.handleHide();
        } else {
            if (f49283e) {
                Log.d("SPSwitchRootLayout", "offset < 0, offset : " + i5 + ", panel->handleShow...");
            }
            a2.handleShow();
        }
    }
}
