package d.a.m0.w.v.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.a.m0.w.v.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f54552a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f54553b;

    /* renamed from: c  reason: collision with root package name */
    public final int f54554c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f54555d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.w.v.a f54556e;

    public c(View view) {
        this.f54553b = view;
        this.f54554c = d.a.m0.w.v.d.c.a(view.getContext());
        this.f54555d = d.c((Activity) view.getContext());
    }

    public final d.a.m0.w.v.a a(View view) {
        d.a.m0.w.v.a aVar = this.f54556e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.a.m0.w.v.a) {
            d.a.m0.w.v.a aVar2 = (d.a.m0.w.v.a) view;
            this.f54556e = aVar2;
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
                d.a.m0.w.v.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f54556e = a2;
                    return a2;
                }
                i2++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i2, int i3) {
        if (this.f54555d && Build.VERSION.SDK_INT >= 16 && this.f54553b.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.f54553b.getWindowVisibleDisplayFrame(rect);
            i3 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i2 + " height: " + i3);
        if (i3 < 0) {
            return;
        }
        int i4 = this.f54552a;
        if (i4 < 0) {
            this.f54552a = i3;
            return;
        }
        int i5 = i4 - i3;
        if (i5 == 0) {
            Log.d("KPSRootLayoutHandler", "" + i5 + " == 0 break;");
        } else if (Math.abs(i5) == this.f54554c) {
            Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i5)));
        } else {
            this.f54552a = i3;
            d.a.m0.w.v.a a2 = a(this.f54553b);
            if (a2 == null) {
                Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
            } else if (Math.abs(i5) < d.a.m0.w.v.d.b.f(this.f54553b.getContext())) {
                Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
            } else if (i5 > 0) {
                a2.handleHide();
            } else if (a2.b() && a2.isVisible()) {
                a2.handleShow();
            }
        }
    }
}
