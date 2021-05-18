package d.a.k0.q3.l;
/* loaded from: classes5.dex */
public class k {
    public final void A(int i2, int[] iArr, double[] dArr) {
        int i3 = 0;
        iArr[0] = i2;
        iArr[1] = 1;
        if (i2 > 2) {
            int i4 = i2 >> 1;
            double d2 = i4;
            double d3 = 0.7853981633974483d / d2;
            double cos = Math.cos(d2 * d3);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i4 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d3);
                dArr[3] = 0.5d / Math.cos(6.0d * d3);
            }
            for (int i5 = 4; i5 < i4; i5 += 4) {
                double d4 = i5;
                double d5 = d3 * d4;
                dArr[i5] = Math.cos(d5);
                dArr[i5 + 1] = Math.sin(d5);
                double d6 = 3.0d * d3 * d4;
                dArr[i5 + 2] = Math.cos(d6);
                dArr[i5 + 3] = Math.sin(d6);
            }
            while (i4 > 2) {
                int i6 = i3 + i4;
                i4 >>= 1;
                dArr[i6] = 1.0d;
                dArr[i6 + 1] = cos;
                if (i4 >= 4) {
                    double d7 = dArr[i3 + 4];
                    double d8 = dArr[i3 + 6];
                    dArr[i6 + 2] = 0.5d / d7;
                    dArr[i6 + 3] = 0.5d / d8;
                }
                for (int i7 = 4; i7 < i4; i7 += 4) {
                    int i8 = (i7 * 2) + i3;
                    double d9 = dArr[i8];
                    double d10 = dArr[i8 + 1];
                    double d11 = dArr[i8 + 2];
                    double d12 = dArr[i8 + 3];
                    int i9 = i6 + i7;
                    dArr[i9] = d9;
                    dArr[i9 + 1] = d10;
                    dArr[i9 + 2] = d11;
                    dArr[i9 + 3] = d12;
                }
                i3 = i6;
            }
        }
    }

    public void B(int i2, int i3, double[] dArr, int[] iArr, double[] dArr2) {
        int i4 = iArr[0];
        if (i2 > (i4 << 2)) {
            i4 = i2 >> 2;
            A(i4, iArr, dArr2);
        }
        int i5 = i4;
        int i6 = iArr[1];
        if (i2 > (i6 << 2)) {
            i6 = i2 >> 2;
            z(i6, iArr, dArr2, i5);
        }
        int i7 = i6;
        if (i3 >= 0) {
            if (i2 > 4) {
                r(i2, dArr, iArr, 2, i5, dArr2);
                D(i2, dArr, i7, dArr2, i5);
            } else if (i2 == 4) {
                r(i2, dArr, iArr, 2, i5, dArr2);
            }
            double d2 = dArr[0] - dArr[1];
            dArr[0] = dArr[0] + dArr[1];
            dArr[1] = d2;
            return;
        }
        dArr[1] = (dArr[0] - dArr[1]) * 0.5d;
        dArr[0] = dArr[0] - dArr[1];
        if (i2 > 4) {
            C(i2, dArr, i7, dArr2, i5);
            i(i2, dArr, iArr, 2, i5, dArr2);
        } else if (i2 == 4) {
            i(i2, dArr, iArr, 2, i5, dArr2);
        }
    }

    public final void C(int i2, double[] dArr, int i3, double[] dArr2, int i4) {
        int i5 = i2 >> 1;
        int i6 = (i3 * 2) / i5;
        int i7 = 0;
        for (int i8 = 2; i8 < i5; i8 += 2) {
            int i9 = i2 - i8;
            i7 += i6;
            double d2 = 0.5d - dArr2[(i4 + i3) - i7];
            double d3 = dArr2[i4 + i7];
            double d4 = dArr[i8] - dArr[i9];
            int i10 = i8 + 1;
            int i11 = i9 + 1;
            double d5 = dArr[i10] + dArr[i11];
            double d6 = (d2 * d4) + (d3 * d5);
            double d7 = (d2 * d5) - (d3 * d4);
            dArr[i8] = dArr[i8] - d6;
            dArr[i10] = dArr[i10] - d7;
            dArr[i9] = dArr[i9] + d6;
            dArr[i11] = dArr[i11] - d7;
        }
    }

    public final void D(int i2, double[] dArr, int i3, double[] dArr2, int i4) {
        int i5 = i2 >> 1;
        int i6 = (i3 * 2) / i5;
        int i7 = 0;
        for (int i8 = 2; i8 < i5; i8 += 2) {
            int i9 = i2 - i8;
            i7 += i6;
            double d2 = 0.5d - dArr2[(i4 + i3) - i7];
            double d3 = dArr2[i4 + i7];
            double d4 = dArr[i8] - dArr[i9];
            int i10 = i8 + 1;
            int i11 = i9 + 1;
            double d5 = dArr[i10] + dArr[i11];
            double d6 = (d2 * d4) - (d3 * d5);
            double d7 = (d2 * d5) + (d3 * d4);
            dArr[i8] = dArr[i8] - d6;
            dArr[i10] = dArr[i10] - d7;
            dArr[i9] = dArr[i9] + d6;
            dArr[i11] = dArr[i11] - d7;
        }
    }

    public final void a(int i2, int[] iArr, int i3, double[] dArr) {
        int i4;
        iArr[i3 + 0] = 0;
        int i5 = i2;
        int i6 = 1;
        while (true) {
            i4 = i6 << 3;
            if (i4 >= i5) {
                break;
            }
            i5 >>= 1;
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i3 + i6 + i7] = iArr[i3 + i7] + i5;
            }
            i6 <<= 1;
        }
        int i8 = i6 * 2;
        if (i4 != i5) {
            for (int i9 = 1; i9 < i6; i9++) {
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = (i10 * 2) + iArr[i3 + i9];
                    int i12 = (i9 * 2) + iArr[i3 + i10];
                    double d2 = dArr[i11];
                    int i13 = i11 + 1;
                    double d3 = dArr[i13];
                    double d4 = dArr[i12];
                    int i14 = i12 + 1;
                    double d5 = dArr[i14];
                    dArr[i11] = d4;
                    dArr[i13] = d5;
                    dArr[i12] = d2;
                    dArr[i14] = d3;
                    int i15 = i11 + i8;
                    int i16 = i12 + i8;
                    double d6 = dArr[i15];
                    int i17 = i15 + 1;
                    double d7 = dArr[i17];
                    double d8 = dArr[i16];
                    int i18 = i16 + 1;
                    double d9 = dArr[i18];
                    dArr[i15] = d8;
                    dArr[i17] = d9;
                    dArr[i16] = d6;
                    dArr[i18] = d7;
                }
            }
            return;
        }
        for (int i19 = 0; i19 < i6; i19++) {
            for (int i20 = 0; i20 < i19; i20++) {
                int i21 = (i20 * 2) + iArr[i3 + i19];
                int i22 = (i19 * 2) + iArr[i3 + i20];
                double d10 = dArr[i21];
                int i23 = i21 + 1;
                double d11 = dArr[i23];
                double d12 = dArr[i22];
                int i24 = i22 + 1;
                double d13 = dArr[i24];
                dArr[i21] = d12;
                dArr[i23] = d13;
                dArr[i22] = d10;
                dArr[i24] = d11;
                int i25 = i21 + i8;
                int i26 = i8 * 2;
                int i27 = i22 + i26;
                double d14 = dArr[i25];
                int i28 = i25 + 1;
                double d15 = dArr[i28];
                double d16 = dArr[i27];
                int i29 = i27 + 1;
                double d17 = dArr[i29];
                dArr[i25] = d16;
                dArr[i28] = d17;
                dArr[i27] = d14;
                dArr[i29] = d15;
                int i30 = i25 + i8;
                int i31 = i27 - i8;
                double d18 = dArr[i30];
                int i32 = i30 + 1;
                double d19 = dArr[i32];
                double d20 = dArr[i31];
                int i33 = i31 + 1;
                double d21 = dArr[i33];
                dArr[i30] = d20;
                dArr[i32] = d21;
                dArr[i31] = d18;
                dArr[i33] = d19;
                int i34 = i30 + i8;
                int i35 = i31 + i26;
                double d22 = dArr[i34];
                int i36 = i34 + 1;
                double d23 = dArr[i36];
                double d24 = dArr[i35];
                int i37 = i35 + 1;
                double d25 = dArr[i37];
                dArr[i34] = d24;
                dArr[i36] = d25;
                dArr[i35] = d22;
                dArr[i37] = d23;
            }
            int i38 = (i19 * 2) + i8 + iArr[i3 + i19];
            int i39 = i38 + i8;
            double d26 = dArr[i38];
            int i40 = i38 + 1;
            double d27 = dArr[i40];
            double d28 = dArr[i39];
            int i41 = i39 + 1;
            double d29 = dArr[i41];
            dArr[i38] = d28;
            dArr[i40] = d29;
            dArr[i39] = d26;
            dArr[i41] = d27;
        }
    }

    public final void b(double[] dArr) {
        double d2 = dArr[2];
        double d3 = dArr[3];
        double d4 = dArr[6];
        double d5 = dArr[7];
        double d6 = dArr[8];
        double d7 = dArr[9];
        double d8 = dArr[12];
        double d9 = dArr[13];
        dArr[2] = d6;
        dArr[3] = d7;
        dArr[6] = d8;
        dArr[7] = d9;
        dArr[8] = d2;
        dArr[9] = d3;
        dArr[12] = d4;
        dArr[13] = d5;
    }

    public final void c(double[] dArr) {
        double d2 = dArr[2];
        double d3 = dArr[3];
        double d4 = dArr[4];
        double d5 = dArr[5];
        double d6 = dArr[6];
        double d7 = dArr[7];
        double d8 = dArr[8];
        double d9 = dArr[9];
        double d10 = dArr[10];
        double d11 = dArr[11];
        double d12 = dArr[12];
        double d13 = dArr[13];
        double d14 = dArr[14];
        double d15 = dArr[15];
        dArr[2] = d14;
        dArr[3] = d15;
        dArr[4] = d6;
        dArr[5] = d7;
        dArr[6] = d10;
        dArr[7] = d11;
        dArr[8] = d2;
        dArr[9] = d3;
        dArr[10] = d12;
        dArr[11] = d13;
        dArr[12] = d4;
        dArr[13] = d5;
        dArr[14] = d8;
        dArr[15] = d9;
    }

    public final void d(double[] dArr) {
        double d2 = dArr[2];
        double d3 = dArr[3];
        double d4 = dArr[4];
        double d5 = dArr[5];
        double d6 = dArr[6];
        double d7 = dArr[7];
        double d8 = dArr[8];
        double d9 = dArr[9];
        double d10 = dArr[10];
        double d11 = dArr[11];
        double d12 = dArr[14];
        double d13 = dArr[15];
        double d14 = dArr[16];
        double d15 = dArr[17];
        double d16 = dArr[20];
        double d17 = dArr[21];
        double d18 = dArr[22];
        double d19 = dArr[23];
        double d20 = dArr[24];
        double d21 = dArr[25];
        double d22 = dArr[26];
        double d23 = dArr[27];
        double d24 = dArr[28];
        double d25 = dArr[29];
        dArr[2] = d14;
        dArr[3] = d15;
        dArr[4] = d8;
        dArr[5] = d9;
        dArr[6] = d20;
        dArr[7] = d21;
        dArr[8] = d4;
        dArr[9] = d5;
        dArr[10] = d16;
        dArr[11] = d17;
        dArr[14] = d24;
        dArr[15] = d25;
        dArr[16] = d2;
        dArr[17] = d3;
        dArr[20] = d10;
        dArr[21] = d11;
        dArr[22] = d22;
        dArr[23] = d23;
        dArr[24] = d6;
        dArr[25] = d7;
        dArr[26] = d18;
        dArr[27] = d19;
        dArr[28] = d12;
        dArr[29] = d13;
    }

    public final void e(double[] dArr) {
        double d2 = dArr[2];
        double d3 = dArr[3];
        double d4 = dArr[4];
        double d5 = dArr[5];
        double d6 = dArr[6];
        double d7 = dArr[7];
        double d8 = dArr[8];
        double d9 = dArr[9];
        double d10 = dArr[10];
        double d11 = dArr[11];
        double d12 = dArr[12];
        double d13 = dArr[13];
        double d14 = dArr[14];
        double d15 = dArr[15];
        double d16 = dArr[16];
        double d17 = dArr[17];
        double d18 = dArr[18];
        double d19 = dArr[19];
        double d20 = dArr[20];
        double d21 = dArr[21];
        double d22 = dArr[22];
        double d23 = dArr[23];
        double d24 = dArr[24];
        double d25 = dArr[25];
        double d26 = dArr[26];
        double d27 = dArr[27];
        double d28 = dArr[28];
        double d29 = dArr[29];
        double d30 = dArr[30];
        double d31 = dArr[31];
        dArr[2] = d30;
        dArr[3] = d31;
        dArr[4] = d14;
        dArr[5] = d15;
        dArr[6] = d22;
        dArr[7] = d23;
        dArr[8] = d6;
        dArr[9] = d7;
        dArr[10] = d26;
        dArr[11] = d27;
        dArr[12] = d10;
        dArr[13] = d11;
        dArr[14] = d18;
        dArr[15] = d19;
        dArr[16] = d2;
        dArr[17] = d3;
        dArr[18] = d28;
        dArr[19] = d29;
        dArr[20] = d12;
        dArr[21] = d13;
        dArr[22] = d20;
        dArr[23] = d21;
        dArr[24] = d4;
        dArr[25] = d5;
        dArr[26] = d24;
        dArr[27] = d25;
        dArr[28] = d8;
        dArr[29] = d9;
        dArr[30] = d16;
        dArr[31] = d17;
    }

    public final void f(int i2, int[] iArr, int i3, double[] dArr) {
        int i4;
        iArr[i3 + 0] = 0;
        int i5 = i2;
        int i6 = 1;
        while (true) {
            i4 = i6 << 3;
            if (i4 >= i5) {
                break;
            }
            i5 >>= 1;
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i3 + i6 + i7] = iArr[i3 + i7] + i5;
            }
            i6 <<= 1;
        }
        int i8 = i6 * 2;
        if (i4 != i5) {
            int i9 = i6;
            dArr[1] = -dArr[1];
            int i10 = i8 + 1;
            dArr[i10] = -dArr[i10];
            for (int i11 = 1; i11 < i9; i11++) {
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = (i12 * 2) + iArr[i3 + i11];
                    int i14 = (i11 * 2) + iArr[i3 + i12];
                    double d2 = dArr[i13];
                    int i15 = i13 + 1;
                    int i16 = i14 + 1;
                    dArr[i13] = dArr[i14];
                    dArr[i15] = -dArr[i16];
                    dArr[i14] = d2;
                    dArr[i16] = -dArr[i15];
                    int i17 = i13 + i8;
                    int i18 = i14 + i8;
                    double d3 = dArr[i17];
                    int i19 = i17 + 1;
                    int i20 = i18 + 1;
                    dArr[i17] = dArr[i18];
                    dArr[i19] = -dArr[i20];
                    dArr[i18] = d3;
                    dArr[i20] = -dArr[i19];
                }
                int i21 = (i11 * 2) + iArr[i3 + i11];
                int i22 = i21 + 1;
                dArr[i22] = -dArr[i22];
                int i23 = i21 + i8 + 1;
                dArr[i23] = -dArr[i23];
            }
            return;
        }
        int i24 = 0;
        while (i24 < i6) {
            int i25 = 0;
            while (i25 < i24) {
                int i26 = (i25 * 2) + iArr[i3 + i24];
                int i27 = (i24 * 2) + iArr[i3 + i25];
                double d4 = dArr[i26];
                int i28 = i26 + 1;
                int i29 = i27 + 1;
                dArr[i26] = dArr[i27];
                dArr[i28] = -dArr[i29];
                dArr[i27] = d4;
                dArr[i29] = -dArr[i28];
                int i30 = i26 + i8;
                int i31 = i8 * 2;
                int i32 = i27 + i31;
                double d5 = dArr[i30];
                int i33 = i30 + 1;
                int i34 = i32 + 1;
                int i35 = i24;
                int i36 = i6;
                dArr[i30] = dArr[i32];
                dArr[i33] = -dArr[i34];
                dArr[i32] = d5;
                dArr[i34] = -dArr[i33];
                int i37 = i30 + i8;
                int i38 = i32 - i8;
                double d6 = dArr[i37];
                int i39 = i37 + 1;
                int i40 = i38 + 1;
                dArr[i37] = dArr[i38];
                dArr[i39] = -dArr[i40];
                dArr[i38] = d6;
                dArr[i40] = -dArr[i39];
                int i41 = i37 + i8;
                int i42 = i38 + i31;
                double d7 = dArr[i41];
                int i43 = i41 + 1;
                int i44 = i42 + 1;
                dArr[i41] = dArr[i42];
                dArr[i43] = -dArr[i44];
                dArr[i42] = d7;
                dArr[i44] = -dArr[i43];
                i25++;
                i6 = i36;
                i24 = i35;
            }
            int i45 = i24;
            int i46 = i6;
            int i47 = (i45 * 2) + iArr[i3 + i45];
            int i48 = i47 + 1;
            dArr[i48] = -dArr[i48];
            int i49 = i47 + i8;
            int i50 = i49 + i8;
            double d8 = dArr[i49];
            int i51 = i49 + 1;
            int i52 = i50 + 1;
            dArr[i49] = dArr[i50];
            dArr[i51] = -dArr[i52];
            dArr[i50] = d8;
            dArr[i52] = -dArr[i51];
            int i53 = i50 + i8 + 1;
            dArr[i53] = -dArr[i53];
            i24 = i45 + 1;
            i6 = i46;
        }
    }

    public final void g(double[] dArr) {
        double d2 = dArr[0] + dArr[4];
        double d3 = dArr[1] + dArr[5];
        double d4 = dArr[0] - dArr[4];
        double d5 = dArr[1] - dArr[5];
        double d6 = dArr[2] + dArr[6];
        double d7 = dArr[3] + dArr[7];
        double d8 = dArr[2] - dArr[6];
        double d9 = dArr[3] - dArr[7];
        dArr[0] = d2 + d6;
        dArr[1] = d3 + d7;
        dArr[4] = d2 - d6;
        dArr[5] = d3 - d7;
        dArr[2] = d4 + d9;
        dArr[3] = d5 - d8;
        dArr[6] = d4 - d9;
        dArr[7] = d5 + d8;
    }

    public final void h(int i2, double[] dArr, double[] dArr2, int i3) {
        int i4 = i2 >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = 0;
        double d2 = dArr[0] + dArr[i6];
        int i9 = i6 + 1;
        double d3 = (-dArr[1]) - dArr[i9];
        double d4 = dArr[0] - dArr[i6];
        double d5 = (-dArr[1]) + dArr[i9];
        double d6 = dArr[i5] + dArr[i7];
        int i10 = i5 + 1;
        int i11 = i7 + 1;
        double d7 = dArr[i10] + dArr[i11];
        double d8 = dArr[i5] - dArr[i7];
        double d9 = dArr[i10] - dArr[i11];
        dArr[0] = d2 + d6;
        dArr[1] = d3 - d7;
        dArr[i5] = d2 - d6;
        dArr[i10] = d3 + d7;
        dArr[i6] = d4 + d9;
        dArr[i9] = d5 + d8;
        dArr[i7] = d4 - d9;
        dArr[i11] = d5 - d8;
        double d10 = dArr2[i3 + 1];
        double d11 = dArr2[i3 + 2];
        double d12 = dArr2[i3 + 3];
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 1.0d;
        int i12 = 2;
        double d16 = 0.0d;
        while (true) {
            int i13 = i4 - 2;
            if (i12 < i13) {
                int i14 = i8 + 4;
                int i15 = i3 + i14;
                double d17 = (d14 + dArr2[i15]) * d11;
                int i16 = i15 + 1;
                double d18 = (d13 + dArr2[i16]) * d11;
                int i17 = i15 + 2;
                double d19 = (d15 + dArr2[i17]) * d12;
                int i18 = i15 + 3;
                double d20 = (d16 - dArr2[i18]) * d12;
                double d21 = dArr2[i15];
                double d22 = dArr2[i16];
                double d23 = dArr2[i17];
                double d24 = -dArr2[i18];
                int i19 = i12 + i5;
                int i20 = i19 + i5;
                int i21 = i20 + i5;
                double d25 = dArr[i12] + dArr[i20];
                int i22 = i12 + 1;
                double d26 = d12;
                int i23 = i20 + 1;
                double d27 = (-dArr[i22]) - dArr[i23];
                double d28 = dArr[i12] - dArr[i20];
                double d29 = d11;
                double d30 = (-dArr[i22]) + dArr[i23];
                int i24 = i12 + 2;
                int i25 = i20 + 2;
                double d31 = dArr[i24] + dArr[i25];
                int i26 = i12 + 3;
                int i27 = i4;
                int i28 = i5;
                int i29 = i20 + 3;
                double d32 = (-dArr[i26]) - dArr[i29];
                double d33 = dArr[i24] - dArr[i25];
                double d34 = (-dArr[i26]) + dArr[i29];
                double d35 = dArr[i19] + dArr[i21];
                int i30 = i19 + 1;
                int i31 = i21 + 1;
                double d36 = dArr[i30] + dArr[i31];
                double d37 = dArr[i19] - dArr[i21];
                double d38 = dArr[i30] - dArr[i31];
                int i32 = i19 + 2;
                int i33 = i21 + 2;
                double d39 = dArr[i32] + dArr[i33];
                int i34 = i19 + 3;
                int i35 = i21 + 3;
                double d40 = dArr[i34] + dArr[i35];
                double d41 = dArr[i32] - dArr[i33];
                double d42 = dArr[i34] - dArr[i35];
                dArr[i12] = d25 + d35;
                dArr[i22] = d27 - d36;
                dArr[i24] = d31 + d39;
                dArr[i26] = d32 - d40;
                dArr[i19] = d25 - d35;
                dArr[i30] = d27 + d36;
                dArr[i32] = d31 - d39;
                dArr[i34] = d32 + d40;
                double d43 = d28 + d38;
                double d44 = d30 + d37;
                dArr[i20] = (d17 * d43) - (d18 * d44);
                dArr[i23] = (d44 * d17) + (d43 * d18);
                double d45 = d33 + d42;
                double d46 = d34 + d41;
                dArr[i25] = (d21 * d45) - (d22 * d46);
                dArr[i29] = (d46 * d21) + (d45 * d22);
                double d47 = d28 - d38;
                double d48 = d30 - d37;
                dArr[i21] = (d19 * d47) + (d20 * d48);
                dArr[i31] = (d48 * d19) - (d47 * d20);
                double d49 = d33 - d42;
                double d50 = d34 - d41;
                dArr[i33] = (d23 * d49) + (d24 * d50);
                dArr[i35] = (d50 * d23) - (d24 * d49);
                int i36 = i28 - i12;
                int i37 = i36 + i28;
                int i38 = i37 + i28;
                int i39 = i38 + i28;
                double d51 = dArr[i36] + dArr[i38];
                int i40 = i36 + 1;
                int i41 = i38 + 1;
                double d52 = (-dArr[i40]) - dArr[i41];
                double d53 = dArr[i36] - dArr[i38];
                double d54 = (-dArr[i40]) + dArr[i41];
                int i42 = i36 - 2;
                int i43 = i38 - 2;
                double d55 = dArr[i42] + dArr[i43];
                int i44 = i36 - 1;
                int i45 = i38 - 1;
                double d56 = (-dArr[i44]) - dArr[i45];
                double d57 = dArr[i42] - dArr[i43];
                int i46 = i12;
                double d58 = (-dArr[i44]) + dArr[i45];
                double d59 = dArr[i37] + dArr[i39];
                int i47 = i37 + 1;
                int i48 = i39 + 1;
                double d60 = dArr[i47] + dArr[i48];
                double d61 = dArr[i37] - dArr[i39];
                double d62 = dArr[i47] - dArr[i48];
                int i49 = i37 - 2;
                int i50 = i39 - 2;
                double d63 = dArr[i49] + dArr[i50];
                int i51 = i37 - 1;
                int i52 = i39 - 1;
                double d64 = dArr[i51] + dArr[i52];
                double d65 = dArr[i49] - dArr[i50];
                double d66 = dArr[i51] - dArr[i52];
                dArr[i36] = d51 + d59;
                dArr[i40] = d52 - d60;
                dArr[i42] = d55 + d63;
                dArr[i44] = d56 - d64;
                dArr[i37] = d51 - d59;
                dArr[i47] = d52 + d60;
                dArr[i49] = d55 - d63;
                dArr[i51] = d56 + d64;
                double d67 = d53 + d62;
                double d68 = d54 + d61;
                dArr[i38] = (d18 * d67) - (d17 * d68);
                dArr[i41] = (d68 * d18) + (d67 * d17);
                double d69 = d57 + d66;
                double d70 = d58 + d65;
                dArr[i43] = (d22 * d69) - (d21 * d70);
                dArr[i45] = (d70 * d22) + (d69 * d21);
                double d71 = d53 - d62;
                double d72 = d54 - d61;
                dArr[i39] = (d20 * d71) + (d19 * d72);
                dArr[i48] = (d20 * d72) - (d19 * d71);
                double d73 = d57 - d66;
                double d74 = d58 - d65;
                dArr[i50] = (d24 * d73) + (d23 * d74);
                dArr[i52] = (d24 * d74) - (d73 * d23);
                i12 = i46 + 4;
                i8 = i14;
                d15 = d23;
                d14 = d21;
                d13 = d22;
                d12 = d26;
                d11 = d29;
                i4 = i27;
                i5 = i28;
                d16 = d24;
            } else {
                int i53 = i4;
                int i54 = i5;
                double d75 = d11;
                double d76 = d12;
                double d77 = d75 * (d14 + d10);
                double d78 = d75 * (d13 + d10);
                double d79 = d76 * (d15 - d10);
                double d80 = d76 * (d16 - d10);
                int i55 = i53 + i54;
                int i56 = i55 + i54;
                int i57 = i56 + i54;
                int i58 = i56 - 2;
                double d81 = dArr[i13] + dArr[i58];
                int i59 = i53 - 1;
                int i60 = i56 - 1;
                double d82 = (-dArr[i59]) - dArr[i60];
                double d83 = dArr[i13] - dArr[i58];
                double d84 = (-dArr[i59]) + dArr[i60];
                int i61 = i55 - 2;
                int i62 = i57 - 2;
                double d85 = dArr[i61] + dArr[i62];
                int i63 = i55 - 1;
                int i64 = i57 - 1;
                double d86 = dArr[i63] + dArr[i64];
                double d87 = dArr[i61] - dArr[i62];
                double d88 = dArr[i63] - dArr[i64];
                dArr[i13] = d81 + d85;
                dArr[i59] = d82 - d86;
                dArr[i61] = d81 - d85;
                dArr[i63] = d82 + d86;
                double d89 = d83 + d88;
                double d90 = d84 + d87;
                dArr[i58] = (d77 * d89) - (d78 * d90);
                dArr[i60] = (d90 * d77) + (d89 * d78);
                double d91 = d83 - d88;
                double d92 = d84 - d87;
                dArr[i62] = (d79 * d91) + (d80 * d92);
                dArr[i64] = (d92 * d79) - (d80 * d91);
                double d93 = dArr[i53] + dArr[i56];
                int i65 = i53 + 1;
                int i66 = i56 + 1;
                double d94 = (-dArr[i65]) - dArr[i66];
                double d95 = dArr[i53] - dArr[i56];
                double d96 = (-dArr[i65]) + dArr[i66];
                double d97 = dArr[i55] + dArr[i57];
                int i67 = i55 + 1;
                int i68 = i57 + 1;
                double d98 = dArr[i67] + dArr[i68];
                double d99 = dArr[i55] - dArr[i57];
                double d100 = dArr[i67] - dArr[i68];
                dArr[i53] = d93 + d97;
                dArr[i65] = d94 - d98;
                dArr[i55] = d93 - d97;
                dArr[i67] = d94 + d98;
                double d101 = d95 + d100;
                double d102 = d96 + d99;
                dArr[i56] = (d101 - d102) * d10;
                dArr[i66] = d10 * (d102 + d101);
                double d103 = d95 - d100;
                double d104 = d96 - d99;
                double d105 = -d10;
                dArr[i57] = (d103 + d104) * d105;
                dArr[i68] = d105 * (d104 - d103);
                int i69 = i53 + 2;
                int i70 = i56 + 2;
                double d106 = dArr[i69] + dArr[i70];
                int i71 = i53 + 3;
                int i72 = i56 + 3;
                double d107 = (-dArr[i71]) - dArr[i72];
                double d108 = dArr[i69] - dArr[i70];
                double d109 = (-dArr[i71]) + dArr[i72];
                int i73 = i55 + 2;
                int i74 = i57 + 2;
                double d110 = dArr[i73] + dArr[i74];
                int i75 = i55 + 3;
                int i76 = i57 + 3;
                double d111 = dArr[i75] + dArr[i76];
                double d112 = dArr[i73] - dArr[i74];
                double d113 = dArr[i75] - dArr[i76];
                dArr[i69] = d106 + d110;
                dArr[i71] = d107 - d111;
                dArr[i73] = d106 - d110;
                dArr[i75] = d107 + d111;
                double d114 = d108 + d113;
                double d115 = d109 + d112;
                dArr[i70] = (d78 * d114) - (d77 * d115);
                dArr[i72] = (d78 * d115) + (d77 * d114);
                double d116 = d108 - d113;
                double d117 = d109 - d112;
                dArr[i74] = (d80 * d116) + (d79 * d117);
                dArr[i76] = (d80 * d117) - (d79 * d116);
                return;
            }
        }
    }

    public final void i(int i2, double[] dArr, int[] iArr, int i3, int i4, double[] dArr2) {
        if (i2 > 32) {
            int i5 = i2 >> 2;
            h(i2, dArr, dArr2, i4 - i5);
            if (i2 > 512) {
                w(i5, dArr, 0, i4, dArr2);
                x(i5, dArr, i5, i4, dArr2);
                w(i5, dArr, i5 * 2, i4, dArr2);
                w(i5, dArr, i5 * 3, i4, dArr2);
            } else if (i5 > 32) {
                j(i2, dArr, 0, i4, dArr2);
            } else {
                s(i2, dArr, 0, i4, dArr2);
            }
            f(i2, iArr, i3, dArr);
        } else if (i2 > 8) {
            if (i2 == 32) {
                o(dArr, 0, dArr2, i4 - 8);
                e(dArr);
                return;
            }
            m(dArr, 0, dArr2, 0);
            c(dArr);
        } else if (i2 == 8) {
            g(dArr);
        } else if (i2 == 4) {
            y(dArr);
        }
    }

    public final void j(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        int i5 = i2 >> 2;
        while (i5 > 128) {
            for (int i6 = i5; i6 < i2; i6 <<= 2) {
                for (int i7 = i6 - i5; i7 < i2; i7 += i6 * 4) {
                    int i8 = i4 - (i5 >> 1);
                    int i9 = i5;
                    u(i9, dArr, i3 + i7, dArr2, i8);
                    v(i9, dArr, i3 + i6 + i7, dArr2, i4 - i5);
                    u(i9, dArr, i3 + (i6 * 2) + i7, dArr2, i8);
                }
            }
            u(i5, dArr, (i3 + i2) - i5, dArr2, i4 - (i5 >> 1));
            i5 >>= 2;
        }
        for (int i10 = i5; i10 < i2; i10 <<= 2) {
            for (int i11 = i10 - i5; i11 < i2; i11 += i10 * 4) {
                int i12 = i3 + i11;
                int i13 = i4 - (i5 >> 1);
                u(i5, dArr, i12, dArr2, i13);
                s(i5, dArr, i12, i4, dArr2);
                int i14 = i3 + i10 + i11;
                v(i5, dArr, i14, dArr2, i4 - i5);
                t(i5, dArr, i14, i4, dArr2);
                int i15 = i3 + (i10 * 2) + i11;
                u(i5, dArr, i15, dArr2, i13);
                s(i5, dArr, i15, i4, dArr2);
            }
        }
        int i16 = (i3 + i2) - i5;
        u(i5, dArr, i16, dArr2, i4 - (i5 >> 1));
        s(i5, dArr, i16, i4, dArr2);
    }

    public final void k(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        int i5 = i2 >> 1;
        int i6 = i2 >> 2;
        while (i6 > 128) {
            for (int i7 = i6; i7 < i5; i7 <<= 2) {
                for (int i8 = i7 - i6; i8 < i5; i8 += i7 * 2) {
                    int i9 = i4 - (i6 >> 1);
                    int i10 = i6;
                    u(i10, dArr, i3 + i8, dArr2, i9);
                    u(i10, dArr, i3 + i5 + i8, dArr2, i9);
                }
                for (int i11 = (i7 * 2) - i6; i11 < i5; i11 += i7 * 4) {
                    int i12 = i4 - i6;
                    int i13 = i6;
                    v(i13, dArr, i3 + i11, dArr2, i12);
                    v(i13, dArr, i3 + i5 + i11, dArr2, i12);
                }
            }
            i6 >>= 2;
        }
        for (int i14 = i6; i14 < i5; i14 <<= 2) {
            for (int i15 = i14 - i6; i15 < i5; i15 += i14 * 2) {
                int i16 = i3 + i15;
                int i17 = i4 - (i6 >> 1);
                int i18 = i6;
                u(i18, dArr, i16, dArr2, i17);
                int i19 = i6;
                s(i19, dArr, i16, i4, dArr2);
                int i20 = i3 + i5 + i15;
                u(i18, dArr, i20, dArr2, i17);
                s(i19, dArr, i20, i4, dArr2);
            }
            for (int i21 = (i14 * 2) - i6; i21 < i5; i21 += i14 * 4) {
                int i22 = i3 + i21;
                int i23 = i4 - i6;
                int i24 = i6;
                v(i24, dArr, i22, dArr2, i23);
                int i25 = i6;
                t(i25, dArr, i22, i4, dArr2);
                int i26 = i3 + i5 + i21;
                v(i24, dArr, i26, dArr2, i23);
                t(i25, dArr, i26, i4, dArr2);
            }
        }
    }

    public final void l(double[] dArr) {
        double d2 = dArr[0] + dArr[4];
        double d3 = dArr[1] + dArr[5];
        double d4 = dArr[0] - dArr[4];
        double d5 = dArr[1] - dArr[5];
        double d6 = dArr[2] + dArr[6];
        double d7 = dArr[3] + dArr[7];
        double d8 = dArr[2] - dArr[6];
        double d9 = dArr[3] - dArr[7];
        dArr[0] = d2 + d6;
        dArr[1] = d3 + d7;
        dArr[4] = d2 - d6;
        dArr[5] = d3 - d7;
        dArr[2] = d4 - d9;
        dArr[3] = d5 + d8;
        dArr[6] = d4 + d9;
        dArr[7] = d5 - d8;
    }

    public final void m(double[] dArr, int i2, double[] dArr2, int i3) {
        double d2 = dArr2[i3 + 1];
        int i4 = i2 + 0;
        int i5 = i2 + 8;
        double d3 = dArr[i4] + dArr[i5];
        int i6 = i2 + 1;
        int i7 = i2 + 9;
        double d4 = dArr[i6] + dArr[i7];
        double d5 = dArr[i4] - dArr[i5];
        double d6 = dArr[i6] - dArr[i7];
        int i8 = i2 + 4;
        int i9 = i2 + 12;
        double d7 = dArr[i8] + dArr[i9];
        int i10 = i2 + 5;
        int i11 = i2 + 13;
        double d8 = dArr[i10] + dArr[i11];
        double d9 = dArr[i8] - dArr[i9];
        double d10 = dArr[i10] - dArr[i11];
        double d11 = d3 + d7;
        double d12 = d4 + d8;
        double d13 = d3 - d7;
        double d14 = d4 - d8;
        double d15 = d5 - d10;
        double d16 = d6 + d9;
        double d17 = d5 + d10;
        double d18 = d6 - d9;
        int i12 = i2 + 2;
        int i13 = i2 + 10;
        double d19 = dArr[i12] + dArr[i13];
        int i14 = i2 + 3;
        int i15 = i2 + 11;
        double d20 = dArr[i14] + dArr[i15];
        double d21 = dArr[i12] - dArr[i13];
        double d22 = dArr[i14] - dArr[i15];
        int i16 = i2 + 6;
        int i17 = i2 + 14;
        double d23 = dArr[i16] + dArr[i17];
        int i18 = i2 + 7;
        int i19 = i2 + 15;
        double d24 = dArr[i18] + dArr[i19];
        double d25 = dArr[i16] - dArr[i17];
        double d26 = dArr[i18] - dArr[i19];
        double d27 = d19 + d23;
        double d28 = d20 + d24;
        double d29 = d19 - d23;
        double d30 = d20 - d24;
        double d31 = d21 - d26;
        double d32 = d22 + d25;
        double d33 = d21 + d26;
        double d34 = d22 - d25;
        double d35 = (d31 - d32) * d2;
        double d36 = (d31 + d32) * d2;
        double d37 = (d33 - d34) * d2;
        double d38 = d2 * (d33 + d34);
        dArr[i5] = d15 + d35;
        dArr[i7] = d16 + d36;
        dArr[i13] = d15 - d35;
        dArr[i15] = d16 - d36;
        dArr[i9] = d17 - d38;
        dArr[i11] = d18 + d37;
        dArr[i17] = d17 + d38;
        dArr[i19] = d18 - d37;
        dArr[i4] = d11 + d27;
        dArr[i6] = d12 + d28;
        dArr[i12] = d11 - d27;
        dArr[i14] = d12 - d28;
        dArr[i8] = d13 - d30;
        dArr[i10] = d14 + d29;
        dArr[i16] = d13 + d30;
        dArr[i18] = d14 - d29;
    }

    public final void n(double[] dArr, int i2, double[] dArr2, int i3) {
        double d2 = dArr2[i3 + 1];
        double d3 = dArr2[i3 + 4];
        double d4 = dArr2[i3 + 5];
        int i4 = i2 + 0;
        int i5 = i2 + 9;
        double d5 = dArr[i4] - dArr[i5];
        int i6 = i2 + 1;
        int i7 = i2 + 8;
        double d6 = dArr[i6] + dArr[i7];
        double d7 = dArr[i4] + dArr[i5];
        double d8 = dArr[i6] - dArr[i7];
        int i8 = i2 + 4;
        int i9 = i2 + 13;
        double d9 = dArr[i8] - dArr[i9];
        int i10 = i2 + 5;
        int i11 = i2 + 12;
        double d10 = dArr[i10] + dArr[i11];
        double d11 = (d9 - d10) * d2;
        double d12 = (d10 + d9) * d2;
        double d13 = dArr[i8] + dArr[i9];
        double d14 = dArr[i10] - dArr[i11];
        double d15 = (d13 - d14) * d2;
        double d16 = d2 * (d14 + d13);
        int i12 = i2 + 2;
        int i13 = i2 + 11;
        double d17 = dArr[i12] - dArr[i13];
        int i14 = i2 + 3;
        int i15 = i2 + 10;
        double d18 = dArr[i14] + dArr[i15];
        double d19 = (d3 * d17) - (d4 * d18);
        double d20 = (d18 * d3) + (d17 * d4);
        double d21 = dArr[i12] + dArr[i13];
        double d22 = dArr[i14] - dArr[i15];
        double d23 = (d4 * d21) - (d3 * d22);
        double d24 = (d22 * d4) + (d21 * d3);
        int i16 = i2 + 6;
        int i17 = i2 + 15;
        double d25 = dArr[i16] - dArr[i17];
        int i18 = i2 + 7;
        int i19 = i2 + 14;
        double d26 = dArr[i18] + dArr[i19];
        double d27 = (d4 * d25) - (d3 * d26);
        double d28 = (d26 * d4) + (d25 * d3);
        double d29 = dArr[i16] + dArr[i17];
        double d30 = dArr[i18] - dArr[i19];
        double d31 = (d3 * d29) - (d4 * d30);
        double d32 = (d3 * d30) + (d4 * d29);
        double d33 = d5 + d11;
        double d34 = d6 + d12;
        double d35 = d19 + d27;
        double d36 = d20 + d28;
        dArr[i4] = d33 + d35;
        dArr[i6] = d34 + d36;
        dArr[i12] = d33 - d35;
        dArr[i14] = d34 - d36;
        double d37 = d5 - d11;
        double d38 = d6 - d12;
        double d39 = d19 - d27;
        double d40 = d20 - d28;
        dArr[i8] = d37 - d40;
        dArr[i10] = d38 + d39;
        dArr[i16] = d37 + d40;
        dArr[i18] = d38 - d39;
        double d41 = d7 - d16;
        double d42 = d8 + d15;
        double d43 = d23 - d31;
        double d44 = d24 - d32;
        dArr[i7] = d41 + d43;
        dArr[i5] = d42 + d44;
        dArr[i15] = d41 - d43;
        dArr[i13] = d42 - d44;
        double d45 = d7 + d16;
        double d46 = d8 - d15;
        double d47 = d23 + d31;
        double d48 = d24 + d32;
        dArr[i11] = d45 - d48;
        dArr[i9] = d46 + d47;
        dArr[i19] = d45 + d48;
        dArr[i17] = d46 - d47;
    }

    public final void o(double[] dArr, int i2, double[] dArr2, int i3) {
        double d2 = dArr2[i3 + 1];
        int i4 = i3 + 2;
        double d3 = dArr2[i4] * d2;
        double d4 = dArr2[i4] + d3;
        int i5 = i2 + 0;
        int i6 = i2 + 16;
        double d5 = dArr[i5] + dArr[i6];
        int i7 = i2 + 1;
        int i8 = i2 + 17;
        double d6 = dArr[i7] + dArr[i8];
        double d7 = dArr[i5] - dArr[i6];
        double d8 = dArr[i7] - dArr[i8];
        int i9 = i2 + 8;
        int i10 = i2 + 24;
        double d9 = dArr[i9] + dArr[i10];
        int i11 = i2 + 9;
        int i12 = i2 + 25;
        double d10 = dArr[i11] + dArr[i12];
        double d11 = dArr[i9] - dArr[i10];
        double d12 = dArr[i11] - dArr[i12];
        double d13 = d5 + d9;
        double d14 = d6 + d10;
        double d15 = d5 - d9;
        double d16 = d6 - d10;
        double d17 = d7 - d12;
        double d18 = d8 + d11;
        double d19 = d7 + d12;
        double d20 = d8 - d11;
        int i13 = i2 + 2;
        int i14 = i2 + 18;
        double d21 = dArr[i13] + dArr[i14];
        int i15 = i2 + 3;
        int i16 = i2 + 19;
        double d22 = dArr[i15] + dArr[i16];
        double d23 = dArr[i13] - dArr[i14];
        double d24 = dArr[i15] - dArr[i16];
        int i17 = i2 + 10;
        int i18 = i2 + 26;
        double d25 = dArr[i17] + dArr[i18];
        int i19 = i2 + 11;
        int i20 = i2 + 27;
        double d26 = dArr[i19] + dArr[i20];
        double d27 = dArr[i17] - dArr[i18];
        double d28 = dArr[i19] - dArr[i20];
        double d29 = d21 + d25;
        double d30 = d22 + d26;
        double d31 = d21 - d25;
        double d32 = d22 - d26;
        double d33 = d23 - d28;
        double d34 = d24 + d27;
        double d35 = (d4 * d33) - (d3 * d34);
        double d36 = (d34 * d4) + (d33 * d3);
        double d37 = d23 + d28;
        double d38 = d24 - d27;
        double d39 = (d3 * d37) - (d4 * d38);
        double d40 = (d38 * d3) + (d37 * d4);
        int i21 = i2 + 4;
        int i22 = i2 + 20;
        double d41 = dArr[i21] + dArr[i22];
        int i23 = i2 + 5;
        int i24 = i2 + 21;
        double d42 = dArr[i23] + dArr[i24];
        double d43 = dArr[i21] - dArr[i22];
        double d44 = dArr[i23] - dArr[i24];
        int i25 = i2 + 12;
        int i26 = i2 + 28;
        double d45 = dArr[i25] + dArr[i26];
        int i27 = i2 + 13;
        int i28 = i2 + 29;
        double d46 = dArr[i27] + dArr[i28];
        double d47 = dArr[i25] - dArr[i26];
        double d48 = dArr[i27] - dArr[i28];
        double d49 = d41 + d45;
        double d50 = d42 + d46;
        double d51 = d41 - d45;
        double d52 = d42 - d46;
        double d53 = d43 - d48;
        double d54 = d44 + d47;
        double d55 = (d53 - d54) * d2;
        double d56 = (d54 + d53) * d2;
        double d57 = d43 + d48;
        double d58 = d44 - d47;
        double d59 = (d57 + d58) * d2;
        double d60 = (d58 - d57) * d2;
        int i29 = i2 + 6;
        int i30 = i2 + 22;
        double d61 = dArr[i29] + dArr[i30];
        int i31 = i2 + 7;
        int i32 = i2 + 23;
        double d62 = dArr[i31] + dArr[i32];
        double d63 = dArr[i29] - dArr[i30];
        double d64 = dArr[i31] - dArr[i32];
        int i33 = i2 + 14;
        int i34 = i2 + 30;
        double d65 = dArr[i33] + dArr[i34];
        int i35 = i2 + 15;
        int i36 = i2 + 31;
        double d66 = dArr[i35] + dArr[i36];
        double d67 = dArr[i33] - dArr[i34];
        double d68 = dArr[i35] - dArr[i36];
        double d69 = d61 + d65;
        double d70 = d62 + d66;
        double d71 = d61 - d65;
        double d72 = d62 - d66;
        double d73 = d63 - d68;
        double d74 = d64 + d67;
        double d75 = (d3 * d73) - (d4 * d74);
        double d76 = (d74 * d3) + (d73 * d4);
        double d77 = d63 + d68;
        double d78 = d64 - d67;
        double d79 = (d4 * d77) - (d3 * d78);
        double d80 = (d4 * d78) + (d3 * d77);
        double d81 = d19 - d59;
        double d82 = d20 - d60;
        double d83 = d19 + d59;
        double d84 = d20 + d60;
        double d85 = d39 - d79;
        double d86 = d40 - d80;
        double d87 = d39 + d79;
        double d88 = d40 + d80;
        dArr[i10] = d81 + d85;
        dArr[i12] = d82 + d86;
        dArr[i18] = d81 - d85;
        dArr[i20] = d82 - d86;
        dArr[i26] = d83 - d88;
        dArr[i28] = d84 + d87;
        dArr[i34] = d83 + d88;
        dArr[i36] = d84 - d87;
        double d89 = d17 + d55;
        double d90 = d18 + d56;
        double d91 = d17 - d55;
        double d92 = d18 - d56;
        double d93 = d35 + d75;
        double d94 = d36 + d76;
        double d95 = d35 - d75;
        double d96 = d36 - d76;
        dArr[i6] = d89 + d93;
        dArr[i8] = d90 + d94;
        dArr[i14] = d89 - d93;
        dArr[i16] = d90 - d94;
        dArr[i22] = d91 - d96;
        dArr[i24] = d92 + d95;
        dArr[i30] = d91 + d96;
        dArr[i32] = d92 - d95;
        double d97 = d31 - d72;
        double d98 = d32 + d71;
        double d99 = (d97 - d98) * d2;
        double d100 = (d98 + d97) * d2;
        double d101 = d31 + d72;
        double d102 = d32 - d71;
        double d103 = (d101 - d102) * d2;
        double d104 = d2 * (d102 + d101);
        double d105 = d15 - d52;
        double d106 = d16 + d51;
        double d107 = d15 + d52;
        double d108 = d16 - d51;
        dArr[i9] = d105 + d99;
        dArr[i11] = d106 + d100;
        dArr[i17] = d105 - d99;
        dArr[i19] = d106 - d100;
        dArr[i25] = d107 - d104;
        dArr[i27] = d108 + d103;
        dArr[i33] = d107 + d104;
        dArr[i35] = d108 - d103;
        double d109 = d13 + d49;
        double d110 = d14 + d50;
        double d111 = d13 - d49;
        double d112 = d14 - d50;
        double d113 = d29 + d69;
        double d114 = d30 + d70;
        double d115 = d29 - d69;
        double d116 = d30 - d70;
        dArr[i5] = d109 + d113;
        dArr[i7] = d110 + d114;
        dArr[i13] = d109 - d113;
        dArr[i15] = d110 - d114;
        dArr[i21] = d111 - d116;
        dArr[i23] = d112 + d115;
        dArr[i29] = d111 + d116;
        dArr[i31] = d112 - d115;
    }

    public final void p(double[] dArr, int i2, double[] dArr2, int i3) {
        double d2 = dArr2[i3 + 1];
        double d3 = dArr2[i3 + 4];
        double d4 = dArr2[i3 + 5];
        double d5 = dArr2[i3 + 6];
        double d6 = dArr2[i3 + 7];
        double d7 = dArr2[i3 + 8];
        double d8 = dArr2[i3 + 9];
        int i4 = i2 + 0;
        int i5 = i2 + 17;
        double d9 = dArr[i4] - dArr[i5];
        int i6 = i2 + 1;
        int i7 = i2 + 16;
        double d10 = dArr[i6] + dArr[i7];
        int i8 = i2 + 8;
        int i9 = i2 + 25;
        double d11 = dArr[i8] - dArr[i9];
        int i10 = i2 + 9;
        int i11 = i2 + 24;
        double d12 = dArr[i10] + dArr[i11];
        double d13 = (d11 - d12) * d2;
        double d14 = (d12 + d11) * d2;
        double d15 = d9 + d13;
        double d16 = d10 + d14;
        double d17 = d9 - d13;
        double d18 = d10 - d14;
        double d19 = dArr[i4] + dArr[i5];
        double d20 = dArr[i6] - dArr[i7];
        double d21 = dArr[i8] + dArr[i9];
        double d22 = dArr[i10] - dArr[i11];
        double d23 = (d21 - d22) * d2;
        double d24 = (d22 + d21) * d2;
        double d25 = d19 - d24;
        double d26 = d20 + d23;
        double d27 = d19 + d24;
        double d28 = d20 - d23;
        int i12 = i2 + 2;
        int i13 = i2 + 19;
        double d29 = dArr[i12] - dArr[i13];
        int i14 = i2 + 3;
        int i15 = i2 + 18;
        double d30 = dArr[i14] + dArr[i15];
        double d31 = (d3 * d29) - (d4 * d30);
        double d32 = (d30 * d3) + (d29 * d4);
        int i16 = i2 + 10;
        int i17 = i2 + 27;
        double d33 = dArr[i16] - dArr[i17];
        int i18 = i2 + 11;
        int i19 = i2 + 26;
        double d34 = dArr[i18] + dArr[i19];
        double d35 = (d6 * d33) - (d5 * d34);
        double d36 = (d34 * d6) + (d33 * d5);
        double d37 = d31 + d35;
        double d38 = d32 + d36;
        double d39 = d31 - d35;
        double d40 = d32 - d36;
        double d41 = dArr[i12] + dArr[i13];
        double d42 = dArr[i14] - dArr[i15];
        double d43 = (d5 * d41) - (d6 * d42);
        double d44 = (d42 * d5) + (d41 * d6);
        double d45 = dArr[i16] + dArr[i17];
        double d46 = dArr[i18] - dArr[i19];
        double d47 = (d3 * d45) + (d4 * d46);
        double d48 = (d46 * d3) - (d45 * d4);
        double d49 = d43 - d47;
        double d50 = d44 - d48;
        double d51 = d43 + d47;
        double d52 = d44 + d48;
        int i20 = i2 + 4;
        int i21 = i2 + 21;
        double d53 = dArr[i20] - dArr[i21];
        int i22 = i2 + 5;
        int i23 = i2 + 20;
        double d54 = dArr[i22] + dArr[i23];
        double d55 = (d7 * d53) - (d8 * d54);
        double d56 = (d54 * d7) + (d53 * d8);
        int i24 = i2 + 12;
        int i25 = i2 + 29;
        double d57 = dArr[i24] - dArr[i25];
        int i26 = i2 + 13;
        int i27 = i2 + 28;
        double d58 = dArr[i26] + dArr[i27];
        double d59 = (d8 * d57) - (d7 * d58);
        double d60 = (d58 * d8) + (d57 * d7);
        double d61 = d55 + d59;
        double d62 = d56 + d60;
        double d63 = d55 - d59;
        double d64 = d56 - d60;
        double d65 = dArr[i20] + dArr[i21];
        double d66 = dArr[i22] - dArr[i23];
        double d67 = (d8 * d65) - (d7 * d66);
        double d68 = (d66 * d8) + (d65 * d7);
        double d69 = dArr[i24] + dArr[i25];
        double d70 = dArr[i26] - dArr[i27];
        double d71 = (d7 * d69) - (d8 * d70);
        double d72 = (d7 * d70) + (d8 * d69);
        double d73 = d67 - d71;
        double d74 = d68 - d72;
        double d75 = d67 + d71;
        double d76 = d68 + d72;
        int i28 = i2 + 6;
        int i29 = i2 + 23;
        double d77 = dArr[i28] - dArr[i29];
        int i30 = i2 + 7;
        int i31 = i2 + 22;
        double d78 = dArr[i30] + dArr[i31];
        double d79 = (d5 * d77) - (d6 * d78);
        double d80 = (d78 * d5) + (d77 * d6);
        int i32 = i2 + 14;
        int i33 = i2 + 31;
        double d81 = dArr[i32] - dArr[i33];
        int i34 = i2 + 15;
        int i35 = i2 + 30;
        double d82 = dArr[i34] + dArr[i35];
        double d83 = (d4 * d81) - (d3 * d82);
        double d84 = (d82 * d4) + (d81 * d3);
        double d85 = d79 + d83;
        double d86 = d80 + d84;
        double d87 = d79 - d83;
        double d88 = d80 - d84;
        double d89 = dArr[i28] + dArr[i29];
        double d90 = dArr[i30] - dArr[i31];
        double d91 = (d4 * d89) + (d3 * d90);
        double d92 = (d4 * d90) - (d3 * d89);
        double d93 = dArr[i32] + dArr[i33];
        double d94 = dArr[i34] - dArr[i35];
        double d95 = (d6 * d93) - (d5 * d94);
        double d96 = (d6 * d94) + (d5 * d93);
        double d97 = d91 + d95;
        double d98 = d92 + d96;
        double d99 = d91 - d95;
        double d100 = d92 - d96;
        double d101 = d15 + d61;
        double d102 = d16 + d62;
        double d103 = d37 + d85;
        double d104 = d38 + d86;
        dArr[i4] = d101 + d103;
        dArr[i6] = d102 + d104;
        dArr[i12] = d101 - d103;
        dArr[i14] = d102 - d104;
        double d105 = d15 - d61;
        double d106 = d16 - d62;
        double d107 = d37 - d85;
        double d108 = d38 - d86;
        dArr[i20] = d105 - d108;
        dArr[i22] = d106 + d107;
        dArr[i28] = d105 + d108;
        dArr[i30] = d106 - d107;
        double d109 = d17 - d64;
        double d110 = d18 + d63;
        double d111 = d39 - d88;
        double d112 = d40 + d87;
        double d113 = (d111 - d112) * d2;
        double d114 = (d112 + d111) * d2;
        dArr[i8] = d109 + d113;
        dArr[i10] = d110 + d114;
        dArr[i16] = d109 - d113;
        dArr[i18] = d110 - d114;
        double d115 = d17 + d64;
        double d116 = d18 - d63;
        double d117 = d39 + d88;
        double d118 = d40 - d87;
        double d119 = (d117 - d118) * d2;
        double d120 = (d118 + d117) * d2;
        dArr[i24] = d115 - d120;
        dArr[i26] = d116 + d119;
        dArr[i32] = d115 + d120;
        dArr[i34] = d116 - d119;
        double d121 = d25 + d73;
        double d122 = d26 + d74;
        double d123 = d49 - d97;
        double d124 = d50 - d98;
        dArr[i7] = d121 + d123;
        dArr[i5] = d122 + d124;
        dArr[i15] = d121 - d123;
        dArr[i13] = d122 - d124;
        double d125 = d25 - d73;
        double d126 = d26 - d74;
        double d127 = d49 + d97;
        double d128 = d50 + d98;
        dArr[i23] = d125 - d128;
        dArr[i21] = d126 + d127;
        dArr[i31] = d125 + d128;
        dArr[i29] = d126 - d127;
        double d129 = d27 - d76;
        double d130 = d28 + d75;
        double d131 = d51 + d100;
        double d132 = d52 - d99;
        double d133 = (d131 - d132) * d2;
        double d134 = (d132 + d131) * d2;
        dArr[i11] = d129 + d133;
        dArr[i9] = d130 + d134;
        dArr[i19] = d129 - d133;
        dArr[i17] = d130 - d134;
        double d135 = d27 + d76;
        double d136 = d28 - d75;
        double d137 = d51 - d100;
        double d138 = d52 + d99;
        double d139 = (d137 - d138) * d2;
        double d140 = d2 * (d138 + d137);
        dArr[i27] = d135 - d140;
        dArr[i25] = d136 + d139;
        dArr[i35] = d135 + d140;
        dArr[i33] = d136 - d139;
    }

    public final void q(int i2, double[] dArr, double[] dArr2, int i3) {
        int i4 = i2 >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = 0;
        double d2 = dArr[0] + dArr[i6];
        int i9 = i6 + 1;
        double d3 = dArr[1] + dArr[i9];
        double d4 = dArr[0] - dArr[i6];
        double d5 = dArr[1] - dArr[i9];
        double d6 = dArr[i5] + dArr[i7];
        int i10 = i5 + 1;
        int i11 = i7 + 1;
        double d7 = dArr[i10] + dArr[i11];
        double d8 = dArr[i5] - dArr[i7];
        double d9 = dArr[i10] - dArr[i11];
        dArr[0] = d2 + d6;
        dArr[1] = d3 + d7;
        dArr[i5] = d2 - d6;
        dArr[i10] = d3 - d7;
        dArr[i6] = d4 - d9;
        dArr[i9] = d5 + d8;
        dArr[i7] = d4 + d9;
        dArr[i11] = d5 - d8;
        double d10 = dArr2[i3 + 1];
        double d11 = dArr2[i3 + 2];
        double d12 = dArr2[i3 + 3];
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 1.0d;
        int i12 = 2;
        double d16 = 0.0d;
        while (true) {
            int i13 = i4 - 2;
            if (i12 < i13) {
                int i14 = i8 + 4;
                int i15 = i3 + i14;
                double d17 = (d14 + dArr2[i15]) * d11;
                int i16 = i15 + 1;
                double d18 = (d13 + dArr2[i16]) * d11;
                int i17 = i15 + 2;
                double d19 = (d15 + dArr2[i17]) * d12;
                int i18 = i15 + 3;
                double d20 = (d16 - dArr2[i18]) * d12;
                double d21 = dArr2[i15];
                double d22 = dArr2[i16];
                double d23 = dArr2[i17];
                double d24 = -dArr2[i18];
                int i19 = i12 + i5;
                int i20 = i19 + i5;
                int i21 = i20 + i5;
                double d25 = dArr[i12] + dArr[i20];
                int i22 = i12 + 1;
                int i23 = i20 + 1;
                double d26 = dArr[i22] + dArr[i23];
                double d27 = dArr[i12] - dArr[i20];
                double d28 = dArr[i22] - dArr[i23];
                int i24 = i12 + 2;
                int i25 = i20 + 2;
                double d29 = dArr[i24] + dArr[i25];
                int i26 = i12 + 3;
                int i27 = i20 + 3;
                double d30 = dArr[i26] + dArr[i27];
                double d31 = dArr[i24] - dArr[i25];
                double d32 = dArr[i26] - dArr[i27];
                double d33 = dArr[i19] + dArr[i21];
                int i28 = i19 + 1;
                int i29 = i21 + 1;
                double d34 = dArr[i28] + dArr[i29];
                double d35 = dArr[i19] - dArr[i21];
                double d36 = dArr[i28] - dArr[i29];
                int i30 = i19 + 2;
                int i31 = i21 + 2;
                double d37 = dArr[i30] + dArr[i31];
                int i32 = i19 + 3;
                int i33 = i21 + 3;
                double d38 = dArr[i32] + dArr[i33];
                double d39 = dArr[i30] - dArr[i31];
                double d40 = dArr[i32] - dArr[i33];
                dArr[i12] = d25 + d33;
                dArr[i22] = d26 + d34;
                dArr[i24] = d29 + d37;
                dArr[i26] = d30 + d38;
                dArr[i19] = d25 - d33;
                dArr[i28] = d26 - d34;
                dArr[i30] = d29 - d37;
                dArr[i32] = d30 - d38;
                double d41 = d27 - d36;
                double d42 = d28 + d35;
                dArr[i20] = (d17 * d41) - (d18 * d42);
                dArr[i23] = (d42 * d17) + (d41 * d18);
                double d43 = d31 - d40;
                double d44 = d32 + d39;
                dArr[i25] = (d21 * d43) - (d22 * d44);
                dArr[i27] = (d44 * d21) + (d43 * d22);
                double d45 = d27 + d36;
                double d46 = d28 - d35;
                dArr[i21] = (d19 * d45) + (d20 * d46);
                dArr[i29] = (d46 * d19) - (d45 * d20);
                double d47 = d31 + d40;
                double d48 = d32 - d39;
                dArr[i31] = (d23 * d47) + (d24 * d48);
                dArr[i33] = (d48 * d23) - (d47 * d24);
                int i34 = i5 - i12;
                int i35 = i34 + i5;
                int i36 = i35 + i5;
                int i37 = i36 + i5;
                double d49 = dArr[i34] + dArr[i36];
                int i38 = i34 + 1;
                int i39 = i36 + 1;
                double d50 = dArr[i38] + dArr[i39];
                double d51 = dArr[i34] - dArr[i36];
                double d52 = dArr[i38] - dArr[i39];
                int i40 = i34 - 2;
                int i41 = i36 - 2;
                double d53 = dArr[i40] + dArr[i41];
                int i42 = i34 - 1;
                int i43 = i36 - 1;
                double d54 = dArr[i42] + dArr[i43];
                double d55 = dArr[i40] - dArr[i41];
                double d56 = dArr[i42] - dArr[i43];
                double d57 = dArr[i35] + dArr[i37];
                int i44 = i35 + 1;
                int i45 = i37 + 1;
                double d58 = dArr[i44] + dArr[i45];
                double d59 = dArr[i35] - dArr[i37];
                double d60 = dArr[i44] - dArr[i45];
                int i46 = i35 - 2;
                int i47 = i37 - 2;
                double d61 = dArr[i46] + dArr[i47];
                int i48 = i35 - 1;
                int i49 = i37 - 1;
                double d62 = dArr[i48] + dArr[i49];
                double d63 = dArr[i46] - dArr[i47];
                double d64 = dArr[i48] - dArr[i49];
                dArr[i34] = d49 + d57;
                dArr[i38] = d50 + d58;
                dArr[i40] = d53 + d61;
                dArr[i42] = d54 + d62;
                dArr[i35] = d49 - d57;
                dArr[i44] = d50 - d58;
                dArr[i46] = d53 - d61;
                dArr[i48] = d54 - d62;
                double d65 = d51 - d60;
                double d66 = d52 + d59;
                dArr[i36] = (d18 * d65) - (d17 * d66);
                dArr[i39] = (d18 * d66) + (d17 * d65);
                double d67 = d55 - d64;
                double d68 = d56 + d63;
                dArr[i41] = (d22 * d67) - (d21 * d68);
                dArr[i43] = (d68 * d22) + (d67 * d21);
                double d69 = d51 + d60;
                double d70 = d52 - d59;
                dArr[i37] = (d20 * d69) + (d19 * d70);
                dArr[i45] = (d20 * d70) - (d19 * d69);
                double d71 = d55 + d64;
                double d72 = d56 - d63;
                dArr[i47] = (d24 * d71) + (d23 * d72);
                dArr[i49] = (d72 * d24) - (d71 * d23);
                i12 += 4;
                d16 = d24;
                d15 = d23;
                d14 = d21;
                d13 = d22;
                i8 = i14;
            } else {
                double d73 = (d14 + d10) * d11;
                double d74 = d11 * (d13 + d10);
                double d75 = (d15 - d10) * d12;
                double d76 = d12 * (d16 - d10);
                int i50 = i4 + i5;
                int i51 = i50 + i5;
                int i52 = i5 + i51;
                int i53 = i51 - 2;
                double d77 = dArr[i13] + dArr[i53];
                int i54 = i4 - 1;
                int i55 = i51 - 1;
                double d78 = dArr[i54] + dArr[i55];
                double d79 = dArr[i13] - dArr[i53];
                double d80 = dArr[i54] - dArr[i55];
                int i56 = i50 - 2;
                int i57 = i52 - 2;
                double d81 = dArr[i56] + dArr[i57];
                int i58 = i50 - 1;
                int i59 = i52 - 1;
                double d82 = dArr[i58] + dArr[i59];
                double d83 = dArr[i56] - dArr[i57];
                double d84 = dArr[i58] - dArr[i59];
                dArr[i13] = d77 + d81;
                dArr[i54] = d78 + d82;
                dArr[i56] = d77 - d81;
                dArr[i58] = d78 - d82;
                double d85 = d79 - d84;
                double d86 = d80 + d83;
                dArr[i53] = (d73 * d85) - (d74 * d86);
                dArr[i55] = (d86 * d73) + (d85 * d74);
                double d87 = d79 + d84;
                double d88 = d80 - d83;
                dArr[i57] = (d75 * d87) + (d76 * d88);
                dArr[i59] = (d88 * d75) - (d87 * d76);
                double d89 = dArr[i4] + dArr[i51];
                int i60 = i4 + 1;
                int i61 = i51 + 1;
                double d90 = dArr[i60] + dArr[i61];
                double d91 = dArr[i4] - dArr[i51];
                double d92 = dArr[i60] - dArr[i61];
                double d93 = dArr[i50] + dArr[i52];
                int i62 = i50 + 1;
                int i63 = i52 + 1;
                double d94 = dArr[i62] + dArr[i63];
                double d95 = dArr[i50] - dArr[i52];
                double d96 = dArr[i62] - dArr[i63];
                dArr[i4] = d89 + d93;
                dArr[i60] = d90 + d94;
                dArr[i50] = d89 - d93;
                dArr[i62] = d90 - d94;
                double d97 = d91 - d96;
                double d98 = d92 + d95;
                dArr[i51] = (d97 - d98) * d10;
                dArr[i61] = d10 * (d98 + d97);
                double d99 = d91 + d96;
                double d100 = d92 - d95;
                double d101 = -d10;
                dArr[i52] = (d99 + d100) * d101;
                dArr[i63] = d101 * (d100 - d99);
                int i64 = i4 + 2;
                int i65 = i51 + 2;
                double d102 = dArr[i64] + dArr[i65];
                int i66 = i4 + 3;
                int i67 = i51 + 3;
                double d103 = dArr[i66] + dArr[i67];
                double d104 = dArr[i64] - dArr[i65];
                double d105 = dArr[i66] - dArr[i67];
                int i68 = i50 + 2;
                int i69 = i52 + 2;
                double d106 = dArr[i68] + dArr[i69];
                int i70 = i50 + 3;
                int i71 = i52 + 3;
                double d107 = dArr[i70] + dArr[i71];
                double d108 = dArr[i68] - dArr[i69];
                double d109 = dArr[i70] - dArr[i71];
                dArr[i64] = d102 + d106;
                dArr[i66] = d103 + d107;
                dArr[i68] = d102 - d106;
                dArr[i70] = d103 - d107;
                double d110 = d104 - d109;
                double d111 = d105 + d108;
                dArr[i65] = (d74 * d110) - (d73 * d111);
                dArr[i67] = (d74 * d111) + (d73 * d110);
                double d112 = d104 + d109;
                double d113 = d105 - d108;
                dArr[i69] = (d76 * d112) + (d75 * d113);
                dArr[i71] = (d76 * d113) - (d75 * d112);
                return;
            }
        }
    }

    public final void r(int i2, double[] dArr, int[] iArr, int i3, int i4, double[] dArr2) {
        if (i2 > 32) {
            int i5 = i2 >> 2;
            q(i2, dArr, dArr2, i4 - i5);
            if (i2 > 512) {
                w(i5, dArr, 0, i4, dArr2);
                x(i5, dArr, i5, i4, dArr2);
                w(i5, dArr, i5 * 2, i4, dArr2);
                w(i5, dArr, i5 * 3, i4, dArr2);
            } else if (i5 > 32) {
                j(i2, dArr, 0, i4, dArr2);
            } else {
                s(i2, dArr, 0, i4, dArr2);
            }
            a(i2, iArr, i3, dArr);
        } else if (i2 > 8) {
            if (i2 == 32) {
                o(dArr, 0, dArr2, i4 - 8);
                d(dArr);
                return;
            }
            m(dArr, 0, dArr2, 0);
            b(dArr);
        } else if (i2 == 8) {
            l(dArr);
        } else if (i2 == 4) {
            y(dArr);
        }
    }

    public final void s(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        if (i2 == 128) {
            int i5 = i4 - 8;
            o(dArr, i3, dArr2, i5);
            p(dArr, i3 + 32, dArr2, i4 - 32);
            o(dArr, i3 + 64, dArr2, i5);
            o(dArr, i3 + 96, dArr2, i5);
            return;
        }
        int i6 = i4 - 16;
        m(dArr, i3, dArr2, i6);
        n(dArr, i3 + 16, dArr2, i6);
        m(dArr, i3 + 32, dArr2, i6);
        m(dArr, i3 + 48, dArr2, i6);
    }

    public final void t(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        if (i2 == 128) {
            int i5 = i4 - 8;
            o(dArr, i3, dArr2, i5);
            int i6 = i4 - 32;
            p(dArr, i3 + 32, dArr2, i6);
            o(dArr, i3 + 64, dArr2, i5);
            p(dArr, i3 + 96, dArr2, i6);
            return;
        }
        int i7 = i4 - 16;
        m(dArr, i3, dArr2, i7);
        n(dArr, i3 + 16, dArr2, i7);
        m(dArr, i3 + 32, dArr2, i7);
        n(dArr, i3 + 48, dArr2, i7);
    }

    public final void u(int i2, double[] dArr, int i3, double[] dArr2, int i4) {
        int i5 = i2 >> 3;
        int i6 = i5 * 2;
        int i7 = i6 + i6;
        int i8 = i7 + i6;
        int i9 = i3 + 0;
        int i10 = i3 + i7;
        double d2 = dArr[i9] + dArr[i10];
        int i11 = i3 + 1;
        int i12 = i10 + 1;
        double d3 = dArr[i11] + dArr[i12];
        double d4 = dArr[i9] - dArr[i10];
        double d5 = dArr[i11] - dArr[i12];
        int i13 = i3 + i6;
        int i14 = i3 + i8;
        double d6 = dArr[i13] + dArr[i14];
        int i15 = i13 + 1;
        int i16 = i14 + 1;
        double d7 = dArr[i15] + dArr[i16];
        double d8 = dArr[i13] - dArr[i14];
        double d9 = dArr[i15] - dArr[i16];
        dArr[i9] = d2 + d6;
        dArr[i11] = d3 + d7;
        dArr[i13] = d2 - d6;
        dArr[i15] = d3 - d7;
        dArr[i10] = d4 - d9;
        dArr[i12] = d5 + d8;
        dArr[i14] = d4 + d9;
        dArr[i16] = d5 - d8;
        double d10 = dArr2[i4 + 1];
        int i17 = 0;
        for (int i18 = 2; i18 < i5; i18 += 2) {
            i17 += 4;
            int i19 = i4 + i17;
            double d11 = dArr2[i19];
            double d12 = dArr2[i19 + 1];
            double d13 = dArr2[i19 + 2];
            double d14 = -dArr2[i19 + 3];
            int i20 = i18 + i6;
            int i21 = i20 + i6;
            int i22 = i21 + i6;
            int i23 = i3 + i18;
            int i24 = i3 + i21;
            double d15 = dArr[i23] + dArr[i24];
            int i25 = i23 + 1;
            int i26 = i24 + 1;
            double d16 = dArr[i25] + dArr[i26];
            double d17 = dArr[i23] - dArr[i24];
            double d18 = dArr[i25] - dArr[i26];
            int i27 = i3 + i20;
            int i28 = i3 + i22;
            double d19 = dArr[i27] + dArr[i28];
            int i29 = i27 + 1;
            int i30 = i28 + 1;
            double d20 = dArr[i29] + dArr[i30];
            double d21 = dArr[i27] - dArr[i28];
            double d22 = dArr[i29] - dArr[i30];
            dArr[i23] = d15 + d19;
            dArr[i25] = d16 + d20;
            dArr[i27] = d15 - d19;
            dArr[i29] = d16 - d20;
            double d23 = d17 - d22;
            double d24 = d18 + d21;
            dArr[i24] = (d11 * d23) - (d12 * d24);
            dArr[i26] = (d24 * d11) + (d23 * d12);
            double d25 = d17 + d22;
            double d26 = d18 - d21;
            dArr[i28] = (d13 * d25) + (d14 * d26);
            dArr[i30] = (d26 * d13) - (d25 * d14);
            int i31 = i6 - i18;
            int i32 = i31 + i6;
            int i33 = i32 + i6;
            int i34 = i33 + i6;
            int i35 = i3 + i31;
            int i36 = i3 + i33;
            double d27 = dArr[i35] + dArr[i36];
            int i37 = i35 + 1;
            int i38 = i36 + 1;
            double d28 = dArr[i37] + dArr[i38];
            double d29 = dArr[i35] - dArr[i36];
            double d30 = dArr[i37] - dArr[i38];
            int i39 = i3 + i32;
            int i40 = i3 + i34;
            double d31 = dArr[i39] + dArr[i40];
            int i41 = i39 + 1;
            int i42 = i40 + 1;
            double d32 = dArr[i41] + dArr[i42];
            double d33 = dArr[i39] - dArr[i40];
            double d34 = dArr[i41] - dArr[i42];
            dArr[i35] = d27 + d31;
            dArr[i37] = d28 + d32;
            dArr[i39] = d27 - d31;
            dArr[i41] = d28 - d32;
            double d35 = d29 - d34;
            double d36 = d30 + d33;
            dArr[i36] = (d12 * d35) - (d11 * d36);
            dArr[i38] = (d12 * d36) + (d11 * d35);
            double d37 = d29 + d34;
            double d38 = d30 - d33;
            dArr[i40] = (d14 * d37) + (d13 * d38);
            dArr[i42] = (d14 * d38) - (d13 * d37);
        }
        int i43 = i5 + i6;
        int i44 = i43 + i6;
        int i45 = i6 + i44;
        int i46 = i3 + i5;
        int i47 = i3 + i44;
        double d39 = dArr[i46] + dArr[i47];
        int i48 = i46 + 1;
        int i49 = i47 + 1;
        double d40 = dArr[i48] + dArr[i49];
        double d41 = dArr[i46] - dArr[i47];
        double d42 = dArr[i48] - dArr[i49];
        int i50 = i3 + i43;
        int i51 = i3 + i45;
        double d43 = dArr[i50] + dArr[i51];
        int i52 = i50 + 1;
        int i53 = i51 + 1;
        double d44 = dArr[i52] + dArr[i53];
        double d45 = dArr[i50] - dArr[i51];
        double d46 = dArr[i52] - dArr[i53];
        dArr[i46] = d39 + d43;
        dArr[i48] = d40 + d44;
        dArr[i50] = d39 - d43;
        dArr[i52] = d40 - d44;
        double d47 = d41 - d46;
        double d48 = d42 + d45;
        dArr[i47] = (d47 - d48) * d10;
        dArr[i49] = (d48 + d47) * d10;
        double d49 = d41 + d46;
        double d50 = d42 - d45;
        double d51 = -d10;
        dArr[i51] = (d49 + d50) * d51;
        dArr[i53] = d51 * (d50 - d49);
    }

    public final void v(int i2, double[] dArr, int i3, double[] dArr2, int i4) {
        int i5 = i2 >> 3;
        int i6 = i5 * 2;
        double d2 = dArr2[i4 + 1];
        int i7 = i6 + i6;
        int i8 = i7 + i6;
        int i9 = i3 + 0;
        int i10 = i3 + i7;
        int i11 = i10 + 1;
        double d3 = dArr[i9] - dArr[i11];
        int i12 = i3 + 1;
        double d4 = dArr[i12] + dArr[i10];
        double d5 = dArr[i9] + dArr[i11];
        double d6 = dArr[i12] - dArr[i10];
        int i13 = i3 + i6;
        int i14 = i3 + i8;
        int i15 = i14 + 1;
        double d7 = dArr[i13] - dArr[i15];
        int i16 = i13 + 1;
        double d8 = dArr[i16] + dArr[i14];
        double d9 = dArr[i13] + dArr[i15];
        double d10 = dArr[i16] - dArr[i14];
        double d11 = (d7 - d8) * d2;
        double d12 = (d8 + d7) * d2;
        dArr[i9] = d3 + d11;
        dArr[i12] = d4 + d12;
        dArr[i13] = d3 - d11;
        dArr[i16] = d4 - d12;
        double d13 = (d9 - d10) * d2;
        double d14 = d2 * (d10 + d9);
        dArr[i10] = d5 - d14;
        dArr[i11] = d6 + d13;
        dArr[i14] = d5 + d14;
        dArr[i15] = d6 - d13;
        int i17 = i6 * 2;
        int i18 = 0;
        int i19 = 2;
        while (i19 < i5) {
            int i20 = i18 + 4;
            int i21 = i4 + i20;
            double d15 = dArr2[i21];
            double d16 = dArr2[i21 + 1];
            double d17 = dArr2[i21 + 2];
            double d18 = -dArr2[i21 + 3];
            int i22 = i17 - 4;
            int i23 = i4 + i22;
            double d19 = dArr2[i23];
            double d20 = dArr2[i23 + 1];
            double d21 = dArr2[i23 + 2];
            double d22 = -dArr2[i23 + 3];
            int i24 = i19 + i6;
            int i25 = i24 + i6;
            int i26 = i25 + i6;
            int i27 = i3 + i19;
            int i28 = i3 + i25;
            int i29 = i28 + 1;
            double d23 = dArr[i27] - dArr[i29];
            int i30 = i27 + 1;
            double d24 = dArr[i30] + dArr[i28];
            double d25 = dArr[i27] + dArr[i29];
            double d26 = dArr[i30] - dArr[i28];
            int i31 = i3 + i24;
            int i32 = i3 + i26;
            int i33 = i32 + 1;
            double d27 = dArr[i31] - dArr[i33];
            int i34 = i31 + 1;
            double d28 = dArr[i34] + dArr[i32];
            double d29 = dArr[i31] + dArr[i33];
            double d30 = dArr[i34] - dArr[i32];
            double d31 = (d15 * d23) - (d16 * d24);
            double d32 = (d24 * d15) + (d23 * d16);
            double d33 = (d20 * d27) - (d19 * d28);
            double d34 = (d28 * d20) + (d27 * d19);
            dArr[i27] = d31 + d33;
            dArr[i30] = d32 + d34;
            dArr[i31] = d31 - d33;
            dArr[i34] = d32 - d34;
            double d35 = (d17 * d25) + (d18 * d26);
            double d36 = (d26 * d17) - (d25 * d18);
            double d37 = (d22 * d29) + (d21 * d30);
            double d38 = (d30 * d22) - (d29 * d21);
            dArr[i28] = d35 + d37;
            dArr[i29] = d36 + d38;
            dArr[i32] = d35 - d37;
            dArr[i33] = d36 - d38;
            int i35 = i6 - i19;
            int i36 = i35 + i6;
            int i37 = i36 + i6;
            int i38 = i37 + i6;
            int i39 = i3 + i35;
            int i40 = i3 + i37;
            int i41 = i40 + 1;
            double d39 = dArr[i39] - dArr[i41];
            int i42 = i39 + 1;
            double d40 = dArr[i42] + dArr[i40];
            double d41 = dArr[i39] + dArr[i41];
            double d42 = dArr[i42] - dArr[i40];
            int i43 = i3 + i36;
            int i44 = i3 + i38;
            int i45 = i44 + 1;
            double d43 = dArr[i43] - dArr[i45];
            int i46 = i43 + 1;
            double d44 = dArr[i46] + dArr[i44];
            double d45 = dArr[i43] + dArr[i45];
            double d46 = dArr[i46] - dArr[i44];
            double d47 = (d19 * d39) - (d20 * d40);
            double d48 = (d19 * d40) + (d20 * d39);
            double d49 = (d16 * d43) - (d15 * d44);
            double d50 = (d16 * d44) + (d15 * d43);
            dArr[i39] = d47 + d49;
            dArr[i42] = d48 + d50;
            dArr[i43] = d47 - d49;
            dArr[i46] = d48 - d50;
            double d51 = (d21 * d41) + (d22 * d42);
            double d52 = (d21 * d42) - (d22 * d41);
            double d53 = (d18 * d45) + (d17 * d46);
            double d54 = (d18 * d46) - (d17 * d45);
            dArr[i40] = d51 + d53;
            dArr[i41] = d52 + d54;
            dArr[i44] = d51 - d53;
            dArr[i45] = d52 - d54;
            i19 += 2;
            i18 = i20;
            i17 = i22;
        }
        int i47 = i4 + i6;
        double d55 = dArr2[i47];
        double d56 = dArr2[i47 + 1];
        int i48 = i5 + i6;
        int i49 = i48 + i6;
        int i50 = i6 + i49;
        int i51 = i3 + i5;
        int i52 = i3 + i49;
        int i53 = i52 + 1;
        double d57 = dArr[i51] - dArr[i53];
        int i54 = i51 + 1;
        double d58 = dArr[i54] + dArr[i52];
        double d59 = dArr[i51] + dArr[i53];
        double d60 = dArr[i54] - dArr[i52];
        int i55 = i3 + i48;
        int i56 = i3 + i50;
        int i57 = i56 + 1;
        double d61 = dArr[i55] - dArr[i57];
        int i58 = i55 + 1;
        double d62 = dArr[i58] + dArr[i56];
        double d63 = dArr[i55] + dArr[i57];
        double d64 = dArr[i58] - dArr[i56];
        double d65 = (d55 * d57) - (d56 * d58);
        double d66 = (d58 * d55) + (d57 * d56);
        double d67 = (d56 * d61) - (d55 * d62);
        double d68 = (d62 * d56) + (d61 * d55);
        dArr[i51] = d65 + d67;
        dArr[i54] = d66 + d68;
        dArr[i55] = d65 - d67;
        dArr[i58] = d66 - d68;
        double d69 = (d56 * d59) - (d55 * d60);
        double d70 = (d60 * d56) + (d59 * d55);
        double d71 = (d55 * d63) - (d56 * d64);
        double d72 = (d55 * d64) + (d56 * d63);
        dArr[i52] = d69 - d71;
        dArr[i53] = d70 - d72;
        dArr[i56] = d69 + d71;
        dArr[i57] = d70 + d72;
    }

    public final void w(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        int i5 = i2 >> 2;
        int i6 = i5 * 2;
        u(i2, dArr, i3, dArr2, i4 - i6);
        if (i2 > 512) {
            w(i5, dArr, i3, i4, dArr2);
            x(i5, dArr, i3 + i5, i4, dArr2);
            w(i5, dArr, i3 + i6, i4, dArr2);
            w(i5, dArr, i3 + (i5 * 3), i4, dArr2);
            return;
        }
        j(i2, dArr, i3, i4, dArr2);
    }

    public final void x(int i2, double[] dArr, int i3, int i4, double[] dArr2) {
        int i5 = i2 >> 2;
        v(i2, dArr, i3, dArr2, i4 - i2);
        if (i2 > 512) {
            w(i5, dArr, i3, i4, dArr2);
            x(i5, dArr, i3 + i5, i4, dArr2);
            w(i5, dArr, i3 + (i5 * 2), i4, dArr2);
            x(i5, dArr, i3 + (i5 * 3), i4, dArr2);
            return;
        }
        k(i2, dArr, i3, i4, dArr2);
    }

    public final void y(double[] dArr) {
        double d2 = dArr[1] - dArr[3];
        dArr[0] = dArr[0] + dArr[2];
        dArr[1] = dArr[1] + dArr[3];
        dArr[2] = dArr[0] - dArr[2];
        dArr[3] = d2;
    }

    public final void z(int i2, int[] iArr, double[] dArr, int i3) {
        iArr[1] = i2;
        if (i2 > 1) {
            int i4 = i2 >> 1;
            double d2 = i4;
            double d3 = 0.7853981633974483d / d2;
            int i5 = i3 + 0;
            dArr[i5] = Math.cos(d2 * d3);
            dArr[i3 + i4] = dArr[i5] * 0.5d;
            for (int i6 = 1; i6 < i4; i6++) {
                double d4 = i6 * d3;
                dArr[i3 + i6] = Math.cos(d4) * 0.5d;
                dArr[(i3 + i2) - i6] = Math.sin(d4) * 0.5d;
            }
        }
    }
}
