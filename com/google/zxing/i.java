package com.google.zxing;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final float f2875a;
    private final float b;

    public i(float f, float f2) {
        this.f2875a = f;
        this.b = f2;
    }

    public final float a() {
        return this.f2875a;
    }

    public final float b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.f2875a == iVar.f2875a && this.b == iVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2875a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f2875a);
        sb.append(',');
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }

    public static void a(i[] iVarArr) {
        i iVar;
        i iVar2;
        i iVar3;
        float a2 = a(iVarArr[0], iVarArr[1]);
        float a3 = a(iVarArr[1], iVarArr[2]);
        float a4 = a(iVarArr[0], iVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            iVar = iVarArr[0];
            iVar2 = iVarArr[1];
            iVar3 = iVarArr[2];
        } else if (a4 >= a3 && a4 >= a2) {
            iVar = iVarArr[1];
            iVar2 = iVarArr[0];
            iVar3 = iVarArr[2];
        } else {
            iVar = iVarArr[2];
            iVar2 = iVarArr[0];
            iVar3 = iVarArr[1];
        }
        if (a(iVar2, iVar, iVar3) >= 0.0f) {
            i iVar4 = iVar3;
            iVar3 = iVar2;
            iVar2 = iVar4;
        }
        iVarArr[0] = iVar3;
        iVarArr[1] = iVar;
        iVarArr[2] = iVar2;
    }

    public static float a(i iVar, i iVar2) {
        return com.google.zxing.common.a.a.a(iVar.f2875a, iVar.b, iVar2.f2875a, iVar2.b);
    }

    private static float a(i iVar, i iVar2, i iVar3) {
        float f = iVar2.f2875a;
        float f2 = iVar2.b;
        return ((iVar3.f2875a - f) * (iVar.b - f2)) - ((iVar.f2875a - f) * (iVar3.b - f2));
    }
}
