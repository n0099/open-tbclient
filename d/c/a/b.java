package d.c.a;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static long f65260b = 922337203685477580L;

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f65261c = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f65262d = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    /* renamed from: a  reason: collision with root package name */
    public int f65263a;

    public int a() {
        return this.f65263a;
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
    public float b(String str, int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        float f2;
        char charAt;
        int i9;
        boolean z3;
        boolean z4;
        char charAt2;
        this.f65263a = i2;
        if (i2 >= i3) {
            return Float.NaN;
        }
        char charAt3 = str.charAt(i2);
        if (charAt3 == '+') {
            z = false;
        } else if (charAt3 != '-') {
            z = false;
            int i10 = this.f65263a;
            long j = 0;
            i4 = 0;
            i5 = 0;
            int i11 = 0;
            z2 = false;
            int i12 = 0;
            while (true) {
                i6 = this.f65263a;
                if (i6 >= i3) {
                    break;
                }
                char charAt4 = str.charAt(i6);
                if (charAt4 == '0') {
                    if (i4 == 0) {
                        i11++;
                    } else {
                        i5++;
                    }
                } else if (charAt4 >= '1' && charAt4 <= '9') {
                    int i13 = i4 + i5;
                    while (i5 > 0) {
                        if (j > f65260b) {
                            return Float.NaN;
                        }
                        j *= 10;
                        i5--;
                    }
                    if (j > f65260b) {
                        return Float.NaN;
                    }
                    j = (j * 10) + (charAt4 - '0');
                    i4 = i13 + 1;
                    if (j < 0) {
                        return Float.NaN;
                    }
                } else if (charAt4 != '.' || z2) {
                    break;
                } else {
                    i12 = this.f65263a - i10;
                    z2 = true;
                }
                this.f65263a++;
            }
            if (z2 || this.f65263a != i12 + 1) {
                if (i4 == 0) {
                    if (i11 == 0) {
                        return Float.NaN;
                    }
                    i4 = 1;
                }
                if (z2) {
                    i5 = (i12 - i11) - i4;
                }
                i7 = this.f65263a;
                if (i7 < i3 && ((charAt = str.charAt(i7)) == 'E' || charAt == 'e')) {
                    i9 = this.f65263a + 1;
                    this.f65263a = i9;
                    if (i9 != i3) {
                        return Float.NaN;
                    }
                    char charAt5 = str.charAt(i9);
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
                                this.f65263a--;
                                z3 = false;
                                z4 = true;
                                break;
                        }
                        if (!z4) {
                            int i14 = this.f65263a;
                            int i15 = 0;
                            while (true) {
                                int i16 = this.f65263a;
                                if (i16 < i3 && (charAt2 = str.charAt(i16)) >= '0' && charAt2 <= '9') {
                                    if (i15 > f65260b) {
                                        return Float.NaN;
                                    }
                                    i15 = (i15 * 10) + (charAt2 - '0');
                                    this.f65263a++;
                                }
                            }
                            if (this.f65263a == i14) {
                                return Float.NaN;
                            }
                            i5 = z3 ? i5 - i15 : i5 + i15;
                        }
                    } else {
                        z3 = true;
                    }
                    this.f65263a++;
                    z4 = false;
                    if (!z4) {
                    }
                }
                i8 = i4 + i5;
                if (i8 <= 39 || i8 < -44) {
                    return Float.NaN;
                }
                long j2 = j;
                float f3 = (float) j2;
                if (j2 != 0) {
                    if (i5 > 0) {
                        f2 = f65261c[i5];
                    } else if (i5 < 0) {
                        if (i5 < -38) {
                            f3 = (float) (f3 * 1.0E-20d);
                            i5 += 20;
                        }
                        f2 = f65262d[-i5];
                    }
                    f3 *= f2;
                }
                return z ? -f3 : f3;
            }
            return Float.NaN;
        } else {
            z = true;
        }
        this.f65263a++;
        int i102 = this.f65263a;
        long j3 = 0;
        i4 = 0;
        i5 = 0;
        int i112 = 0;
        z2 = false;
        int i122 = 0;
        while (true) {
            i6 = this.f65263a;
            if (i6 >= i3) {
            }
            this.f65263a++;
        }
        if (z2) {
        }
        if (i4 == 0) {
        }
        if (z2) {
        }
        i7 = this.f65263a;
        if (i7 < i3) {
            i9 = this.f65263a + 1;
            this.f65263a = i9;
            if (i9 != i3) {
            }
        }
        i8 = i4 + i5;
        if (i8 <= 39) {
        }
        return Float.NaN;
    }
}
