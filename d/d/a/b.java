package d.d.a;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static long f66853b = 922337203685477580L;

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f66854c = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f66855d = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    /* renamed from: a  reason: collision with root package name */
    public int f66856a;

    public int a() {
        return this.f66856a;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0089 A[EDGE_INSN: B:113:0x0089->B:42:0x0089 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float b(String str, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        float f2;
        char charAt;
        int i8;
        boolean z3;
        boolean z4;
        char charAt2;
        this.f66856a = i;
        if (i >= i2) {
            return Float.NaN;
        }
        char charAt3 = str.charAt(i);
        if (charAt3 == '+') {
            z = false;
        } else if (charAt3 != '-') {
            z = false;
            int i9 = this.f66856a;
            long j = 0;
            i3 = 0;
            i4 = 0;
            int i10 = 0;
            z2 = false;
            int i11 = 0;
            while (true) {
                i5 = this.f66856a;
                if (i5 >= i2) {
                    break;
                }
                char charAt4 = str.charAt(i5);
                if (charAt4 == '0') {
                    if (i3 == 0) {
                        i10++;
                    } else {
                        i4++;
                    }
                } else if (charAt4 >= '1' && charAt4 <= '9') {
                    int i12 = i3 + i4;
                    while (i4 > 0) {
                        if (j > f66853b) {
                            return Float.NaN;
                        }
                        j *= 10;
                        i4--;
                    }
                    if (j > f66853b) {
                        return Float.NaN;
                    }
                    j = (j * 10) + (charAt4 - '0');
                    i3 = i12 + 1;
                    if (j < 0) {
                        return Float.NaN;
                    }
                } else if (charAt4 != '.' || z2) {
                    break;
                } else {
                    i11 = this.f66856a - i9;
                    z2 = true;
                }
                this.f66856a++;
            }
            if (z2 || this.f66856a != i11 + 1) {
                if (i3 == 0) {
                    if (i10 == 0) {
                        return Float.NaN;
                    }
                    i3 = 1;
                }
                if (z2) {
                    i4 = (i11 - i10) - i3;
                }
                i6 = this.f66856a;
                if (i6 < i2 && ((charAt = str.charAt(i6)) == 'E' || charAt == 'e')) {
                    i8 = this.f66856a + 1;
                    this.f66856a = i8;
                    if (i8 != i2) {
                        return Float.NaN;
                    }
                    char charAt5 = str.charAt(i8);
                    if (charAt5 == '+') {
                        z3 = false;
                    } else if (charAt5 != '-') {
                        switch (charAt5) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                z3 = false;
                                z4 = false;
                                break;
                            default:
                                this.f66856a--;
                                z3 = false;
                                z4 = true;
                                break;
                        }
                        if (!z4) {
                            int i13 = this.f66856a;
                            int i14 = 0;
                            while (true) {
                                int i15 = this.f66856a;
                                if (i15 < i2 && (charAt2 = str.charAt(i15)) >= '0' && charAt2 <= '9') {
                                    if (i14 > f66853b) {
                                        return Float.NaN;
                                    }
                                    i14 = (i14 * 10) + (charAt2 - '0');
                                    this.f66856a++;
                                }
                            }
                            if (this.f66856a == i13) {
                                return Float.NaN;
                            }
                            i4 = z3 ? i4 - i14 : i4 + i14;
                        }
                    } else {
                        z3 = true;
                    }
                    this.f66856a++;
                    z4 = false;
                    if (!z4) {
                    }
                }
                i7 = i3 + i4;
                if (i7 <= 39 || i7 < -44) {
                    return Float.NaN;
                }
                long j2 = j;
                float f3 = (float) j2;
                if (j2 != 0) {
                    if (i4 > 0) {
                        f2 = f66854c[i4];
                    } else if (i4 < 0) {
                        if (i4 < -38) {
                            f3 = (float) (f3 * 1.0E-20d);
                            i4 += 20;
                        }
                        f2 = f66855d[-i4];
                    }
                    f3 *= f2;
                }
                return z ? -f3 : f3;
            }
            return Float.NaN;
        } else {
            z = true;
        }
        this.f66856a++;
        int i92 = this.f66856a;
        long j3 = 0;
        i3 = 0;
        i4 = 0;
        int i102 = 0;
        z2 = false;
        int i112 = 0;
        while (true) {
            i5 = this.f66856a;
            if (i5 >= i2) {
            }
            this.f66856a++;
        }
        if (z2) {
        }
        if (i3 == 0) {
        }
        if (z2) {
        }
        i6 = this.f66856a;
        if (i6 < i2) {
            i8 = this.f66856a + 1;
            this.f66856a = i8;
            if (i8 != i2) {
            }
        }
        i7 = i3 + i4;
        if (i7 <= 39) {
        }
        return Float.NaN;
    }
}
