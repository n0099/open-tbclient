package d.a.l0.a.w1.i;

import android.view.View;
import d.a.l0.a.k;
import d.a.l0.a.w1.j.g;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.w1.k.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45605h = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public final View f45606e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45607f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45608g = false;

    public b(View view) {
        this.f45606e = view;
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            this.f45607f = false;
        }
        if (i2 == this.f45606e.getVisibility()) {
            return true;
        }
        return b() && i2 == 0;
    }

    public boolean b() {
        return this.f45608g;
    }

    public int[] c(int i2, int i3) {
        if (this.f45607f) {
            this.f45606e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public void d(int i2) {
        g.g(this.f45606e, i2);
    }

    public void e(boolean z) {
        this.f45608g = z;
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleHide() {
        this.f45607f = true;
    }

    @Override // d.a.l0.a.w1.k.a
    public void handleShow() {
        if (f45605h) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }
}
