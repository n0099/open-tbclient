package d.a.l0.a.w1.i;

import android.view.View;
import d.a.l0.a.k;
import d.a.l0.a.w1.j.g;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.w1.k.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49279h = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public final View f49280e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49281f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49282g = false;

    public b(View view) {
        this.f49280e = view;
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            this.f49281f = false;
        }
        if (i2 == this.f49280e.getVisibility()) {
            return true;
        }
        return b() && i2 == 0;
    }

    public boolean b() {
        return this.f49282g;
    }

    public int[] c(int i2, int i3) {
        if (this.f49281f) {
            this.f49280e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public void d(int i2) {
        g.g(this.f49280e, i2);
    }

    public void e(boolean z) {
        this.f49282g = z;
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleHide() {
        this.f49281f = true;
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleShow() {
        if (f49279h) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }
}
