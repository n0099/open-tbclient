package d.a.m0.a.w1.i;

import android.view.View;
import d.a.m0.a.k;
import d.a.m0.a.w1.j.g;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.w1.k.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49387h = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public final View f49388e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49389f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49390g = false;

    public b(View view) {
        this.f49388e = view;
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            this.f49389f = false;
        }
        if (i2 == this.f49388e.getVisibility()) {
            return true;
        }
        return b() && i2 == 0;
    }

    public boolean b() {
        return this.f49390g;
    }

    public int[] c(int i2, int i3) {
        if (this.f49389f) {
            this.f49388e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public void d(int i2) {
        g.g(this.f49388e, i2);
    }

    public void e(boolean z) {
        this.f49390g = z;
    }

    @Override // d.a.m0.a.w1.k.a
    public void handleHide() {
        this.f49389f = true;
    }

    @Override // d.a.m0.a.w1.k.a
    public void handleShow() {
        if (f49387h) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }
}
