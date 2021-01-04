package com.kwai.player.vr;

import com.a.a.a.a;
/* loaded from: classes5.dex */
public class MDQuaternion {
    private final float[] q;

    public MDQuaternion() {
        this.q = new float[4];
        idt();
    }

    public MDQuaternion(float f, float f2, float f3, float f4) {
        this.q = new float[4];
        this.q[0] = f;
        this.q[1] = f2;
        this.q[2] = f3;
        this.q[3] = f4;
    }

    public static float calcAngle(float[] fArr, float[] fArr2) {
        return (float) Math.acos(Math.min(dot(normal(fArr), normal(fArr2)), 1.0f));
    }

    public static float[] calcAxis(float[] fArr, float[] fArr2) {
        return normal(cross(normal(fArr), normal(fArr2)));
    }

    private static float[] cross(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[1] * fArr2[2]) - (fArr2[1] * fArr[2]), (fArr[2] * fArr2[0]) - (fArr2[2] * fArr[0]), (fArr[0] * fArr2[1]) - (fArr2[0] * fArr[1])};
    }

    private static float dot(float[] fArr, float[] fArr2) {
        return (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    private static float[] normal(float[] fArr) {
        float sqrt = (float) Math.sqrt(dot(fArr, fArr));
        return new float[]{fArr[0] / sqrt, fArr[1] / sqrt, fArr[2] / sqrt};
    }

    private void set(float f, float f2, float f3, float f4) {
        this.q[0] = f;
        this.q[1] = f2;
        this.q[2] = f3;
        this.q[3] = f4;
    }

    private void set(float f, float[] fArr) {
        this.q[0] = (float) Math.cos(f / 2.0f);
        float sin = (float) Math.sin(f / 2.0f);
        this.q[1] = fArr[0] * sin;
        this.q[2] = fArr[1] * sin;
        this.q[3] = sin * fArr[2];
    }

    private void set(float[] fArr, float[] fArr2) {
        float[] normal = normal(fArr);
        float[] normal2 = normal(fArr2);
        set((float) Math.acos(dot(normal, normal2)), normal(cross(normal, normal2)));
    }

    private void setFromAxes(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (z) {
            float len = 1.0f / MDVector3D.len(f, f2, f3);
            float len2 = 1.0f / MDVector3D.len(f4, f5, f6);
            float len3 = 1.0f / MDVector3D.len(f7, f8, f9);
            f *= len;
            f2 *= len;
            f3 *= len;
            f4 *= len2;
            f5 *= len2;
            f6 *= len2;
            f7 *= len3;
            f8 *= len3;
            f9 *= len3;
        }
        float f14 = f + f5 + f9;
        if (f14 >= 0.0f) {
            float sqrt = (float) Math.sqrt(f14 + 1.0f);
            f13 = 0.5f * sqrt;
            float f15 = 0.5f / sqrt;
            f11 = (f8 - f6) * f15;
            f12 = (f3 - f7) * f15;
            f10 = f15 * (f4 - f2);
        } else if (f > f5 && f > f9) {
            float sqrt2 = (float) Math.sqrt(((1.0d + f) - f5) - f9);
            f11 = sqrt2 * 0.5f;
            float f16 = 0.5f / sqrt2;
            f12 = (f4 + f2) * f16;
            f10 = (f3 + f7) * f16;
            f13 = f16 * (f8 - f6);
        } else if (f5 > f9) {
            float sqrt3 = (float) Math.sqrt(((1.0d + f5) - f) - f9);
            f12 = 0.5f * sqrt3;
            float f17 = 0.5f / sqrt3;
            f11 = (f4 + f2) * f17;
            f10 = (f8 + f6) * f17;
            f13 = f17 * (f3 - f7);
        } else {
            float sqrt4 = (float) Math.sqrt(((1.0d + f9) - f) - f5);
            f10 = 0.5f * sqrt4;
            float f18 = 0.5f / sqrt4;
            f11 = (f3 + f7) * f18;
            f12 = (f8 + f6) * f18;
            f13 = f18 * (f4 - f2);
        }
        set(f13, f11, f12, f10);
    }

    public void clone(MDQuaternion mDQuaternion) {
        System.arraycopy(mDQuaternion.q, 0, this.q, 0, this.q.length);
    }

    public MDQuaternion conjugate() {
        return new MDQuaternion(this.q[0], -this.q[1], -this.q[2], -this.q[3]);
    }

    public MDQuaternion divides(MDQuaternion mDQuaternion) {
        return inverse().times(mDQuaternion);
    }

    public void fromMatrix(float[] fArr) {
        setFromAxes(false, fArr[0], fArr[1], fArr[2], fArr[4], fArr[5], fArr[6], fArr[8], fArr[9], fArr[10]);
    }

    public int getGimbalPole() {
        float f = (this.q[0] * this.q[3]) + (this.q[1] * this.q[2]);
        if (f > 0.499f) {
            return 1;
        }
        return f < -0.499f ? -1 : 0;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getPitchRad() {
        float f = this.q[0];
        float f2 = this.q[1];
        float f3 = this.q[2];
        float f4 = this.q[3];
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? (float) Math.asin(a.a(((f * f2) - (f4 * f3)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getRollRad() {
        float f = this.q[0];
        float f2 = this.q[1];
        float f3 = this.q[2];
        float f4 = this.q[3];
        int gimbalPole = getGimbalPole();
        if (gimbalPole == 0) {
            return a.a(((f * f4) + (f3 * f2)) * 2.0f, 1.0f - (((f2 * f2) + (f4 * f4)) * 2.0f));
        }
        return a.a(f3, f) * gimbalPole * 2.0f;
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public float getYawRad() {
        float f = this.q[0];
        float f2 = this.q[1];
        float f3 = this.q[2];
        float f4 = this.q[3];
        if (getGimbalPole() == 0) {
            return a.a(((f * f3) + (f4 * f2)) * 2.0f, 1.0f - (((f2 * f2) + (f3 * f3)) * 2.0f));
        }
        return 0.0f;
    }

    public void idt() {
        set(1.0f, 0.0f, 0.0f, 0.0f);
    }

    public MDQuaternion inverse() {
        float f = (this.q[0] * this.q[0]) + (this.q[1] * this.q[1]) + (this.q[2] * this.q[2]) + (this.q[3] * this.q[3]);
        return new MDQuaternion(this.q[0] / f, (-this.q[1]) / f, (-this.q[2]) / f, (-this.q[3]) / f);
    }

    public void nor() {
        float f = this.q[0];
        float f2 = this.q[1];
        float f3 = this.q[2];
        float f4 = this.q[3];
        float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4) + (f * f);
        if (f5 != 0.0f && !a.b(f5, 1.0f)) {
            float sqrt = (float) Math.sqrt(f5);
            f /= sqrt;
            f2 /= sqrt;
            f3 /= sqrt;
            f4 /= sqrt;
        }
        set(f, f2, f3, f4);
    }

    public MDQuaternion plus(MDQuaternion mDQuaternion) {
        return new MDQuaternion(this.q[0] + mDQuaternion.q[0], this.q[1] + mDQuaternion.q[1], this.q[2] + mDQuaternion.q[2], this.q[3] + mDQuaternion.q[3]);
    }

    public float[] rotateVec(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = (this.q[1] * f) + (this.q[2] * f2) + (this.q[3] * f3);
        return new float[]{(((this.q[0] * ((this.q[0] * f) - ((this.q[2] * f3) - (this.q[3] * f2)))) + (this.q[1] * f4)) * 2.0f) - f, (((this.q[0] * ((this.q[0] * f2) - ((this.q[3] * f) - (this.q[1] * f3)))) + (this.q[2] * f4)) * 2.0f) - f2, (((((this.q[0] * f3) - ((f2 * this.q[1]) - (f * this.q[2]))) * this.q[0]) + (this.q[3] * f4)) * 2.0f) - f3};
    }

    public void setEulerAngles(float f, float f2, float f3) {
        setEulerAnglesRad(f * 0.017453292f, f2 * 0.017453292f, 0.017453292f * f3);
    }

    public void setEulerAnglesRad(float f, float f2, float f3) {
        float f4 = f3 * 0.5f;
        float sin = (float) Math.sin(f4);
        float cos = (float) Math.cos(f4);
        float f5 = f * 0.5f;
        float sin2 = (float) Math.sin(f5);
        float cos2 = (float) Math.cos(f5);
        float f6 = f2 * 0.5f;
        float sin3 = (float) Math.sin(f6);
        float cos3 = (float) Math.cos(f6);
        float f7 = cos3 * sin2;
        float f8 = sin3 * cos2;
        float f9 = cos2 * cos3;
        float f10 = sin2 * sin3;
        this.q[1] = (f7 * cos) + (f8 * sin);
        this.q[2] = (f8 * cos) - (f7 * sin);
        this.q[3] = (f9 * sin) - (f10 * cos);
        this.q[0] = (cos * f9) + (sin * f10);
    }

    public void setFromAxis(float f, float f2, float f3, float f4) {
        setFromAxisRad(f, f2, f3, 0.017453292f * f4);
    }

    public void setFromAxisRad(float f, float f2, float f3, float f4) {
        float len = MDVector3D.len(f, f2, f3);
        if (len == 0.0f) {
            idt();
            return;
        }
        float f5 = 1.0f / len;
        float f6 = f4 < 0.0f ? 6.2831855f - ((-f4) % 6.2831855f) : f4 % 6.2831855f;
        float sin = (float) Math.sin(f6 / 2.0f);
        set((float) Math.cos(f6 / 2.0f), f5 * f * sin, f5 * f2 * sin, f5 * f3 * sin);
        nor();
    }

    public MDQuaternion times(MDQuaternion mDQuaternion) {
        return new MDQuaternion((((this.q[0] * mDQuaternion.q[0]) - (this.q[1] * mDQuaternion.q[1])) - (this.q[2] * mDQuaternion.q[2])) - (this.q[3] * mDQuaternion.q[3]), (((this.q[0] * mDQuaternion.q[1]) + (this.q[1] * mDQuaternion.q[0])) + (this.q[2] * mDQuaternion.q[3])) - (this.q[3] * mDQuaternion.q[2]), ((this.q[0] * mDQuaternion.q[2]) - (this.q[1] * mDQuaternion.q[3])) + (this.q[2] * mDQuaternion.q[0]) + (this.q[3] * mDQuaternion.q[1]), (((this.q[0] * mDQuaternion.q[3]) + (this.q[1] * mDQuaternion.q[2])) - (this.q[2] * mDQuaternion.q[1])) + (this.q[3] * mDQuaternion.q[0]));
    }

    public void toMatrix(float[] fArr) {
        float f = this.q[1] * this.q[1];
        float f2 = this.q[1] * this.q[2];
        float f3 = this.q[1] * this.q[3];
        float f4 = this.q[1] * this.q[0];
        float f5 = this.q[2] * this.q[2];
        float f6 = this.q[2] * this.q[3];
        float f7 = this.q[2] * this.q[0];
        float f8 = this.q[3] * this.q[3];
        float f9 = this.q[3] * this.q[0];
        fArr[0] = 1.0f - (2.0f * (f5 + f8));
        fArr[1] = 2.0f * (f2 - f9);
        fArr[2] = 2.0f * (f3 + f7);
        fArr[4] = (f2 + f9) * 2.0f;
        fArr[5] = 1.0f - ((f8 + f) * 2.0f);
        fArr[6] = 2.0f * (f6 - f4);
        fArr[8] = (f3 - f7) * 2.0f;
        fArr[9] = 2.0f * (f4 + f6);
        fArr[10] = 1.0f - ((f + f5) * 2.0f);
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
