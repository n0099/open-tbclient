package d.b.i0.w.v.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.b.i0.w.v.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f52311a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final View f52312b;

    /* renamed from: c  reason: collision with root package name */
    public final int f52313c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f52314d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.w.v.a f52315e;

    public c(View view) {
        this.f52312b = view;
        this.f52313c = d.b.i0.w.v.d.c.a(view.getContext());
        this.f52314d = d.c((Activity) view.getContext());
    }

    public final d.b.i0.w.v.a a(View view) {
        d.b.i0.w.v.a aVar = this.f52315e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.b.i0.w.v.a) {
            d.b.i0.w.v.a aVar2 = (d.b.i0.w.v.a) view;
            this.f52315e = aVar2;
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
                d.b.i0.w.v.a a2 = a(viewGroup.getChildAt(i));
                if (a2 != null) {
                    this.f52315e = a2;
                    return a2;
                }
                i++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i, int i2) {
        if (this.f52314d && Build.VERSION.SDK_INT >= 16 && this.f52312b.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.f52312b.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 < 0) {
            return;
        }
        int i3 = this.f52311a;
        if (i3 < 0) {
            this.f52311a = i2;
            return;
        }
        int i4 = i3 - i2;
        if (i4 == 0) {
            Log.d("KPSRootLayoutHandler", "" + i4 + " == 0 break;");
        } else if (Math.abs(i4) == this.f52313c) {
            Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i4)));
        } else {
            this.f52311a = i2;
            d.b.i0.w.v.a a2 = a(this.f52312b);
            if (a2 == null) {
                Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
            } else if (Math.abs(i4) < d.b.i0.w.v.d.b.f(this.f52312b.getContext())) {
                Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
            } else if (i4 > 0) {
                a2.handleHide();
            } else if (a2.b() && a2.isVisible()) {
                a2.handleShow();
            }
        }
    }
}
