package d.m.a.h;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public float f67406a;

    /* renamed from: b  reason: collision with root package name */
    public float f67407b;

    /* renamed from: c  reason: collision with root package name */
    public float f67408c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f67409d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67410e;

    public final boolean a() {
        return this.f67410e;
    }

    public final float b() {
        return this.f67408c;
    }

    public final float c() {
        return this.f67409d;
    }

    public final float d() {
        return this.f67406a;
    }

    public final float e() {
        return this.f67407b;
    }

    public final void f(float f2, float f3, float f4, float f5, ImageView.ScaleType scaleType) {
        if (f2 == 0.0f || f3 == 0.0f || f4 == 0.0f || f5 == 0.0f) {
            return;
        }
        g();
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f3 - f5) / 2.0f;
        float f8 = f4 / f5;
        float f9 = f2 / f3;
        float f10 = f3 / f5;
        float f11 = f2 / f4;
        switch (d.$EnumSwitchMapping$0[scaleType.ordinal()]) {
            case 1:
                this.f67406a = f6;
                this.f67407b = f7;
                return;
            case 2:
                if (f8 > f9) {
                    this.f67410e = false;
                    this.f67408c = f10;
                    this.f67409d = f10;
                    this.f67406a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
                this.f67410e = true;
                this.f67408c = f11;
                this.f67409d = f11;
                this.f67407b = (f3 - (f5 * f11)) / 2.0f;
                return;
            case 3:
                if (f4 < f2 && f5 < f3) {
                    this.f67406a = f6;
                    this.f67407b = f7;
                    return;
                } else if (f8 > f9) {
                    this.f67410e = true;
                    this.f67408c = f11;
                    this.f67409d = f11;
                    this.f67407b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                } else {
                    this.f67410e = false;
                    this.f67408c = f10;
                    this.f67409d = f10;
                    this.f67406a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
            case 4:
                if (f8 > f9) {
                    this.f67410e = true;
                    this.f67408c = f11;
                    this.f67409d = f11;
                    this.f67407b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                }
                this.f67410e = false;
                this.f67408c = f10;
                this.f67409d = f10;
                this.f67406a = (f2 - (f4 * f10)) / 2.0f;
                return;
            case 5:
                if (f8 > f9) {
                    this.f67410e = true;
                    this.f67408c = f11;
                    this.f67409d = f11;
                    return;
                }
                this.f67410e = false;
                this.f67408c = f10;
                this.f67409d = f10;
                return;
            case 6:
                if (f8 > f9) {
                    this.f67410e = true;
                    this.f67408c = f11;
                    this.f67409d = f11;
                    this.f67407b = f3 - (f5 * f11);
                    return;
                }
                this.f67410e = false;
                this.f67408c = f10;
                this.f67409d = f10;
                this.f67406a = f2 - (f4 * f10);
                return;
            case 7:
                Math.max(f11, f10);
                this.f67410e = f11 > f10;
                this.f67408c = f11;
                this.f67409d = f10;
                return;
            default:
                this.f67410e = true;
                this.f67408c = f11;
                this.f67409d = f11;
                return;
        }
    }

    public final void g() {
        this.f67406a = 0.0f;
        this.f67407b = 0.0f;
        this.f67408c = 1.0f;
        this.f67409d = 1.0f;
        this.f67410e = false;
    }
}
