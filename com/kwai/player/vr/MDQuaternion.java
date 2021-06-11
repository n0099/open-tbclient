package com.kwai.player.vr;

import com.badlogic.gdx.math.a;
/* loaded from: classes7.dex */
public class MDQuaternion {
    public final float[] q;

    public MDQuaternion() {
        this.q = new float[4];
        idt();
    }

    public MDQuaternion(float f2, float f3, float f4, float f5) {
        this.q = r0;
        float[] fArr = {f2, f3, f4, f5};
    }

    public static float calcAngle(float[] fArr, float[] fArr2) {
        return (float) Math.acos(Math.min(dot(normal(fArr), normal(fArr2)), 1.0f));
    }

    public static float[] calcAxis(float[] fArr, float[] fArr2) {
        return normal(cross(normal(fArr), normal(fArr2)));
    }

    public static float[] cross(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[1] * fArr2[2]) - (fArr2[1] * fArr[2]), (fArr[2] * fArr2[0]) - (fArr2[2] * fArr[0]), (fArr[0] * fArr2[1]) - (fArr2[0] * fArr[1])};
    }

    public static float dot(float[] fArr, float[] fArr2) {
        return (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public static float[] normal(float[] fArr) {
        float sqrt = (float) Math.sqrt(dot(fArr, fArr));
        return new float[]{fArr[0] / sqrt, fArr[1] / sqrt, fArr[2] / sqrt};
    }

    private void set(float f2, float f3, float f4, float f5) {
        float[] fArr = this.q;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
    }

    private void set(float f2, float[] fArr) {
        double d2 = f2 / 2.0f;
        this.q[0] = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float[] fArr2 = this.q;
        fArr2[1] = fArr[0] * sin;
        fArr2[2] = fArr[1] * sin;
        fArr2[3] = fArr[2] * sin;
    }

    private void set(float[] fArr, float[] fArr2) {
        float[] normal = normal(fArr);
        float[] normal2 = normal(fArr2);
        set((float) Math.acos(dot(normal, normal2)), normal(cross(normal, normal2)));
    }

    private void setFromAxes(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        if (z) {
            float len = 1.0f / MDVector3D.len(f2, f3, f4);
            float len2 = 1.0f / MDVector3D.len(f5, f6, f7);
            float len3 = 1.0f / MDVector3D.len(f8, f9, f10);
            f2 *= len;
            f3 *= len;
            f4 *= len;
            f5 *= len2;
            f6 *= len2;
            f7 *= len2;
            f8 *= len3;
            f9 *= len3;
            f10 *= len3;
        }
        float f16 = f2 + f6 + f10;
        if (f16 >= 0.0f) {
            float sqrt = (float) Math.sqrt(f16 + 1.0f);
            f15 = sqrt * 0.5f;
            float f17 = 0.5f / sqrt;
            f13 = (f9 - f7) * f17;
            f11 = (f4 - f8) * f17;
            f14 = (f5 - f3) * f17;
        } else {
            if (f2 > f6 && f2 > f10) {
                float sqrt2 = (float) Math.sqrt(((f2 + 1.0d) - f6) - f10);
                float f18 = sqrt2 * 0.5f;
                float f19 = 0.5f / sqrt2;
                float f20 = (f5 + f3) * f19;
                f14 = (f4 + f8) * f19;
                f12 = (f9 - f7) * f19;
                f11 = f20;
                f13 = f18;
            } else if (f6 > f10) {
                float sqrt3 = (float) Math.sqrt(((f6 + 1.0d) - f2) - f10);
                float f21 = sqrt3 * 0.5f;
                float f22 = 0.5f / sqrt3;
                float f23 = (f5 + f3) * f22;
                f14 = (f9 + f7) * f22;
                f12 = (f4 - f8) * f22;
                f13 = f23;
                f11 = f21;
            } else {
                float sqrt4 = (float) Math.sqrt(((f10 + 1.0d) - f2) - f6);
                float f24 = sqrt4 * 0.5f;
                float f25 = 0.5f / sqrt4;
                float f26 = (f4 + f8) * f25;
                f11 = (f9 + f7) * f25;
                f12 = (f5 - f3) * f25;
                f13 = f26;
                f14 = f24;
            }
            f15 = f12;
        }
        set(f15, f13, f11, f14);
    }

    public void clone(MDQuaternion mDQuaternion) {
        float[] fArr = mDQuaternion.q;
        float[] fArr2 = this.q;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }

    public MDQuaternion conjugate() {
        float[] fArr = this.q;
        return new MDQuaternion(fArr[0], -fArr[1], -fArr[2], -fArr[3]);
    }

    public MDQuaternion divides(MDQuaternion mDQuaternion) {
        return inverse().times(mDQuaternion);
    }

    public void fromMatrix(float[] fArr) {
        setFromAxes(false, fArr[0], fArr[1], fArr[2], fArr[4], fArr[5], fArr[6], fArr[8], fArr[9], fArr[10]);
    }

    public int getGimbalPole() {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float f3 = (fArr[2] * fArr[1]) + (fArr[3] * f2);
        if (f3 > 0.499f) {
            return 1;
        }
        return f3 < -0.499f ? -1 : 0;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getPitchRad() {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? (float) Math.asin(a.b(((f2 * f3) - (f5 * f4)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getRollRad() {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? a.a(((f2 * f5) + (f4 * f3)) * 2.0f, 1.0f - (((f3 * f3) + (f5 * f5)) * 2.0f)) : gimbalPole * 2.0f * a.a(f4, f2);
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public float getYawRad() {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        if (getGimbalPole() == 0) {
            return a.a(((f2 * f4) + (f5 * f3)) * 2.0f, 1.0f - (((f4 * f4) + (f3 * f3)) * 2.0f));
        }
        return 0.0f;
    }

    public void idt() {
        set(1.0f, 0.0f, 0.0f, 0.0f);
    }

    public MDQuaternion inverse() {
        float[] fArr = this.q;
        float f2 = (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]) + (fArr[3] * fArr[3]);
        return new MDQuaternion(fArr[0] / f2, (-fArr[1]) / f2, (-fArr[2]) / f2, (-fArr[3]) / f2);
    }

    public void nor() {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        float f6 = (f3 * f3) + (f4 * f4) + (f5 * f5) + (f2 * f2);
        if (f6 != 0.0f && !a.c(f6, 1.0f)) {
            float sqrt = (float) Math.sqrt(f6);
            f2 /= sqrt;
            f3 /= sqrt;
            f4 /= sqrt;
            f5 /= sqrt;
        }
        set(f2, f3, f4, f5);
    }

    public MDQuaternion plus(MDQuaternion mDQuaternion) {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float[] fArr2 = mDQuaternion.q;
        return new MDQuaternion(f2 + fArr2[0], fArr[1] + fArr2[1], fArr[2] + fArr2[2], fArr[3] + fArr2[3]);
    }

    public float[] rotateVec(float[] fArr) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float[] fArr2 = this.q;
        float f5 = (fArr2[1] * f2) + (fArr2[2] * f3) + (fArr2[3] * f4);
        return new float[]{(((fArr2[0] * ((fArr2[0] * f2) - ((fArr2[2] * f4) - (fArr2[3] * f3)))) + (fArr2[1] * f5)) * 2.0f) - f2, (((fArr2[0] * ((fArr2[0] * f3) - ((fArr2[3] * f2) - (fArr2[1] * f4)))) + (fArr2[2] * f5)) * 2.0f) - f3, (((fArr2[0] * ((fArr2[0] * f4) - ((fArr2[1] * f3) - (fArr2[2] * f2)))) + (f5 * fArr2[3])) * 2.0f) - f4};
    }

    public void setEulerAngles(float f2, float f3, float f4) {
        setEulerAnglesRad(f2 * 0.017453292f, f3 * 0.017453292f, f4 * 0.017453292f);
    }

    public void setEulerAnglesRad(float f2, float f3, float f4) {
        double d2 = f4 * 0.5f;
        float sin = (float) Math.sin(d2);
        float cos = (float) Math.cos(d2);
        double d3 = f2 * 0.5f;
        float sin2 = (float) Math.sin(d3);
        float cos2 = (float) Math.cos(d3);
        double d4 = f3 * 0.5f;
        float sin3 = (float) Math.sin(d4);
        float cos3 = (float) Math.cos(d4);
        float f5 = cos3 * sin2;
        float f6 = sin3 * cos2;
        float f7 = cos3 * cos2;
        float f8 = sin3 * sin2;
        float[] fArr = this.q;
        fArr[1] = (f5 * cos) + (f6 * sin);
        fArr[2] = (f6 * cos) - (f5 * sin);
        fArr[3] = (f7 * sin) - (f8 * cos);
        fArr[0] = (f7 * cos) + (f8 * sin);
    }

    public void setFromAxis(float f2, float f3, float f4, float f5) {
        setFromAxisRad(f2, f3, f4, f5 * 0.017453292f);
    }

    public void setFromAxisRad(float f2, float f3, float f4, float f5) {
        float len = MDVector3D.len(f2, f3, f4);
        if (len == 0.0f) {
            idt();
            return;
        }
        float f6 = 1.0f / len;
        double d2 = (f5 < 0.0f ? 6.2831855f - ((-f5) % 6.2831855f) : f5 % 6.2831855f) / 2.0f;
        float sin = (float) Math.sin(d2);
        set((float) Math.cos(d2), f2 * f6 * sin, f3 * f6 * sin, f6 * f4 * sin);
        nor();
    }

    public MDQuaternion times(MDQuaternion mDQuaternion) {
        float[] fArr = this.q;
        float f2 = fArr[0];
        float[] fArr2 = mDQuaternion.q;
        return new MDQuaternion((((f2 * fArr2[0]) - (fArr[1] * fArr2[1])) - (fArr[2] * fArr2[2])) - (fArr[3] * fArr2[3]), (((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[0])) + (fArr[2] * fArr2[3])) - (fArr[3] * fArr2[2]), ((fArr[0] * fArr2[2]) - (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[0]) + (fArr[3] * fArr2[1]), (((fArr[0] * fArr2[3]) + (fArr[1] * fArr2[2])) - (fArr[2] * fArr2[1])) + (fArr[3] * fArr2[0]));
    }

    public void toMatrix(float[] fArr) {
        float[] fArr2 = this.q;
        float f2 = fArr2[1] * fArr2[1];
        float f3 = fArr2[1] * fArr2[2];
        float f4 = fArr2[1] * fArr2[3];
        float f5 = fArr2[1] * fArr2[0];
        float f6 = fArr2[2] * fArr2[2];
        float f7 = fArr2[2] * fArr2[3];
        float f8 = fArr2[2] * fArr2[0];
        float f9 = fArr2[3] * fArr2[3];
        float f10 = fArr2[3] * fArr2[0];
        fArr[0] = 1.0f - ((f6 + f9) * 2.0f);
        fArr[1] = (f3 - f10) * 2.0f;
        fArr[2] = (f4 + f8) * 2.0f;
        fArr[4] = (f3 + f10) * 2.0f;
        fArr[5] = 1.0f - ((f9 + f2) * 2.0f);
        fArr[6] = (f7 - f5) * 2.0f;
        fArr[8] = (f4 - f8) * 2.0f;
        fArr[9] = (f7 + f5) * 2.0f;
        fArr[10] = 1.0f - ((f2 + f6) * 2.0f);
        fArr[14] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[11] = 0.0f;
        fArr[7] = 0.0f;
        fArr[3] = 0.0f;
        fArr[15] = 1.0f;
    }

    public String toString() {
        return String.format("MDQuaternion w=%f x=%f, y=%f, z=%f", Float.valueOf(this.q[0]), Float.valueOf(this.q[1]), Float.valueOf(this.q[2]), Float.valueOf(this.q[3]));
    }
}
