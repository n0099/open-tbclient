package d.b.h0.w.v.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.b.h0.w.v.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f51556a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f51557b;

    /* renamed from: c  reason: collision with root package name */
    public final int f51558c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f51559d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.w.v.a f51560e;

    public c(View view) {
        this.f51557b = view;
        this.f51558c = d.b.h0.w.v.d.c.a(view.getContext());
        this.f51559d = d.c((Activity) view.getContext());
    }

    public final d.b.h0.w.v.a a(View view) {
        d.b.h0.w.v.a aVar = this.f51560e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.b.h0.w.v.a) {
            d.b.h0.w.v.a aVar2 = (d.b.h0.w.v.a) view;
            this.f51560e = aVar2;
            return aVar2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return null;
                }
                d.b.h0.w.v.a a2 = a(viewGroup.getChildAt(i));
                if (a2 != null) {
                    this.f51560e = a2;
                    return a2;
                }
                i++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i, int i2) {
        if (this.f51559d && Build.VERSION.SDK_INT >= 16 && this.f51557b.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.f51557b.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 < 0) {
            return;
        }
        int i3 = this.f51556a;
        if (i3 < 0) {
            this.f51556a = i2;
            return;
        }
        int i4 = i3 - i2;
        if (i4 == 0) {
            Log.d("KPSRootLayoutHandler", "" + i4 + " == 0 break;");
        } else if (Math.abs(i4) == this.f51558c) {
            Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i4)));
        } else {
            this.f51556a = i2;
            d.b.h0.w.v.a a2 = a(this.f51557b);
            if (a2 == null) {
                Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
            } else if (Math.abs(i4) < d.b.h0.w.v.d.b.f(this.f51557b.getContext())) {
                Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
            } else if (i4 > 0) {
                a2.handleHide();
            } else if (a2.b() && a2.isVisible()) {
                a2.handleShow();
            }
        }
    }
}
