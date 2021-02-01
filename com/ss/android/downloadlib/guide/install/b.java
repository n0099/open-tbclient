package com.ss.android.downloadlib.guide.install;

import android.graphics.PointF;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private int f12997a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f12998b = new PointF();
    private final PointF c = new PointF();

    public b(float f, float f2, float f3, float f4) {
        this.f12998b.x = f;
        this.f12998b.y = f2;
        this.c.x = f3;
        this.c.y = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f == 0.0f) {
            this.f12997a = 0;
        }
        int i = this.f12997a;
        float f2 = f;
        while (true) {
            if (i >= 128) {
                break;
            }
            float f3 = i * 0.0078125f;
            if (a(f3, this.f12998b.x, this.c.x) < f) {
                i++;
                f2 = f3;
            } else {
                this.f12997a = i;
                f2 = f3;
                break;
            }
        }
        double a2 = a(f2, this.f12998b.y, this.c.y);
        if (f == 1.0f) {
            this.f12997a = 0;
        }
        return (float) a2;
    }

    public static double a(double d, double d2, double d3) {
        double d4 = 1.0d - d;
        double d5 = d * d;
        return (d4 * 3.0d * d5 * d3) + (d4 * d4 * 3.0d * d * d2) + (d5 * d);
    }
}
