package d.a.j0.w.v.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.a.j0.w.v.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f50802a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f50803b;

    /* renamed from: c  reason: collision with root package name */
    public final int f50804c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f50805d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.w.v.a f50806e;

    public c(View view) {
        this.f50803b = view;
        this.f50804c = d.a.j0.w.v.d.c.a(view.getContext());
        this.f50805d = d.c((Activity) view.getContext());
    }

    public final d.a.j0.w.v.a a(View view) {
        d.a.j0.w.v.a aVar = this.f50806e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.a.j0.w.v.a) {
            d.a.j0.w.v.a aVar2 = (d.a.j0.w.v.a) view;
            this.f50806e = aVar2;
            return aVar2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                d.a.j0.w.v.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f50806e = a2;
                    return a2;
                }
                i2++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i2, int i3) {
        if (this.f50805d && Build.VERSION.SDK_INT >= 16 && this.f50803b.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.f50803b.getWindowVisibleDisplayFrame(rect);
            i3 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i2 + " height: " + i3);
        if (i3 < 0) {
            return;
        }
        int i4 = this.f50802a;
        if (i4 < 0) {
            this.f50802a = i3;
            return;
        }
        int i5 = i4 - i3;
        if (i5 == 0) {
            Log.d("KPSRootLayoutHandler", "" + i5 + " == 0 break;");
        } else if (Math.abs(i5) == this.f50804c) {
            Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i5)));
        } else {
            this.f50802a = i3;
            d.a.j0.w.v.a a2 = a(this.f50803b);
            if (a2 == null) {
                Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
            } else if (Math.abs(i5) < d.a.j0.w.v.d.b.f(this.f50803b.getContext())) {
                Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
            } else if (i5 > 0) {
                a2.handleHide();
            } else if (a2.b() && a2.isVisible()) {
                a2.handleShow();
            }
        }
    }
}
