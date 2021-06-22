package d.l.a.h;

import android.widget.ImageView;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public float f70353a;

    /* renamed from: b  reason: collision with root package name */
    public float f70354b;

    /* renamed from: c  reason: collision with root package name */
    public float f70355c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f70356d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70357e;

    public final boolean a() {
        return this.f70357e;
    }

    public final float b() {
        return this.f70355c;
    }

    public final float c() {
        return this.f70356d;
    }

    public final float d() {
        return this.f70353a;
    }

    public final float e() {
        return this.f70354b;
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
                this.f70353a = f6;
                this.f70354b = f7;
                return;
            case 2:
                if (f8 > f9) {
                    this.f70357e = false;
                    this.f70355c = f10;
                    this.f70356d = f10;
                    this.f70353a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
                this.f70357e = true;
                this.f70355c = f11;
                this.f70356d = f11;
                this.f70354b = (f3 - (f5 * f11)) / 2.0f;
                return;
            case 3:
                if (f4 < f2 && f5 < f3) {
                    this.f70353a = f6;
                    this.f70354b = f7;
                    return;
                } else if (f8 > f9) {
                    this.f70357e = true;
                    this.f70355c = f11;
                    this.f70356d = f11;
                    this.f70354b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                } else {
                    this.f70357e = false;
                    this.f70355c = f10;
                    this.f70356d = f10;
                    this.f70353a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
            case 4:
                if (f8 > f9) {
                    this.f70357e = true;
                    this.f70355c = f11;
                    this.f70356d = f11;
                    this.f70354b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                }
                this.f70357e = false;
                this.f70355c = f10;
                this.f70356d = f10;
                this.f70353a = (f2 - (f4 * f10)) / 2.0f;
                return;
            case 5:
                if (f8 > f9) {
                    this.f70357e = true;
                    this.f70355c = f11;
                    this.f70356d = f11;
                    return;
                }
                this.f70357e = false;
                this.f70355c = f10;
                this.f70356d = f10;
                return;
            case 6:
                if (f8 > f9) {
                    this.f70357e = true;
                    this.f70355c = f11;
                    this.f70356d = f11;
                    this.f70354b = f3 - (f5 * f11);
                    return;
                }
                this.f70357e = false;
                this.f70355c = f10;
                this.f70356d = f10;
                this.f70353a = f2 - (f4 * f10);
                return;
            case 7:
                Math.max(f11, f10);
                this.f70357e = f11 > f10;
                this.f70355c = f11;
                this.f70356d = f10;
                return;
            default:
                this.f70357e = true;
                this.f70355c = f11;
                this.f70356d = f11;
                return;
        }
    }

    public final void g() {
        this.f70353a = 0.0f;
        this.f70354b = 0.0f;
        this.f70355c = 1.0f;
        this.f70356d = 1.0f;
        this.f70357e = false;
    }
}
