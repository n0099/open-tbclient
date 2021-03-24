package d.b.i0.p3.l;
/* loaded from: classes5.dex */
public class k {
    public final void A(int i, int[] iArr, double[] dArr) {
        int i2 = 0;
        iArr[0] = i;
        iArr[1] = 1;
        if (i > 2) {
            int i3 = i >> 1;
            double d2 = i3;
            Double.isNaN(d2);
            double d3 = 0.7853981633974483d / d2;
            Double.isNaN(d2);
            double cos = Math.cos(d2 * d3);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i3 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d3);
                dArr[3] = 0.5d / Math.cos(6.0d * d3);
            }
            for (int i4 = 4; i4 < i3; i4 += 4) {
                double d4 = i4;
                Double.isNaN(d4);
                double d5 = d3 * d4;
                dArr[i4] = Math.cos(d5);
                dArr[i4 + 1] = Math.sin(d5);
                Double.isNaN(d4);
                double d6 = 3.0d * d3 * d4;
                dArr[i4 + 2] = Math.cos(d6);
                dArr[i4 + 3] = Math.sin(d6);
            }
            while (i3 > 2) {
                int i5 = i2 + i3;
                i3 >>= 1;
                dArr[i5] = 1.0d;
                dArr[i5 + 1] = cos;
                if (i3 >= 4) {
                    double d7 = dArr[i2 + 4];
                    double d8 = dArr[i2 + 6];
                    dArr[i5 + 2] = 0.5d / d7;
                    dArr[i5 + 3] = 0.5d / d8;
                }
                for (int i6 = 4; i6 < i3; i6 += 4) {
                    int i7 = (i6 * 2) + i2;
                    double d9 = dArr[i7];
                    double d10 = dArr[i7 + 1];
                    double d11 = dArr[i7 + 2];
                    double d12 = dArr[i7 + 3];
                    int i8 = i5 + i6;
                    dArr[i8] = d9;
                    dArr[i8 + 1] = d10;
                    dArr[i8 + 2] = d11;
                    dArr[i8 + 3] = d12;
                }
                i2 = i5;
            }
        }
    }

    public void B(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3 = iArr[0];
        if (i > (i3 << 2)) {
            i3 = i >> 2;
            A(i3, iArr, dArr2);
        }
        int i4 = i3;
        int i5 = iArr[1];
        if (i > (i5 << 2)) {
            i5 = i >> 2;
            z(i5, iArr, dArr2, i4);
        }
        int i6 = i5;
        if (i2 >= 0) {
            if (i > 4) {
                r(i, dArr, iArr, 2, i4, dArr2);
                D(i, dArr, i6, dArr2, i4);
            } else if (i == 4) {
                r(i, dArr, iArr, 2, i4, dArr2);
            }
            double d2 = dArr[0] - dArr[1];
            dArr[0] = dArr[0] + dArr[1];
            dArr[1] = d2;
            return;
        }
        dArr[1] = (dArr[0] - dArr[1]) * 0.5d;
        dArr[0] = dArr[0] - dArr[1];
        if (i > 4) {
            C(i, dArr, i6, dArr2, i4);
            i(i, dArr, iArr, 2, i4, dArr2);
        } else if (i == 4) {
            i(i, dArr, iArr, 2, i4, dArr2);
        }
    }

    public final void C(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d2 = 0.5d - dArr2[(i3 + i2) - i6];
            double d3 = dArr2[i3 + i6];
            double d4 = dArr[i7] - dArr[i8];
            int i9 = i7 + 1;
            int i10 = i8 + 1;
            double d5 = dArr[i9] + dArr[i10];
            double d6 = (d2 * d4) + (d3 * d5);
            double d7 = (d2 * d5) - (d3 * d4);
            dArr[i7] = dArr[i7] - d6;
            dArr[i9] = dArr[i9] - d7;
            dArr[i8] = dArr[i8] + d6;
            dArr[i10] = dArr[i10] - d7;
        }
    }

    public final void D(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d2 = 0.5d - dArr2[(i3 + i2) - i6];
            double d3 = dArr2[i3 + i6];
            double d4 = dArr[i7] - dArr[i8];
            int i9 = i7 + 1;
            int i10 = i8 + 1;
            double d5 = dArr[i9] + dArr[i10];
            double d6 = (d2 * d4) - (d3 * d5);
            double d7 = (d2 * d5) + (d3 * d4);
            dArr[i7] = dArr[i7] - d6;
            dArr[i9] = dArr[i9] - d7;
            dArr[i8] = dArr[i8] + d6;
            dArr[i10] = dArr[i10] - d7;
        }
    }

    public final void a(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        iArr[i2 + 0] = 0;
        int i4 = i;
        int i5 = 1;
        while (true) {
            i3 = i5 << 3;
            if (i3 >= i4) {
                break;
            }
            i4 >>= 1;
            for (int i6 = 0; i6 < i5; i6++) {
                iArr[i2 + i5 + i6] = iArr[i2 + i6] + i4;
            }
            i5 <<= 1;
        }
        int i7 = i5 * 2;
        if (i3 != i4) {
            for (int i8 = 1; i8 < i5; i8++) {
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = (i9 * 2) + iArr[i2 + i8];
                    int i11 = (i8 * 2) + iArr[i2 + i9];
                    double d2 = dArr[i10];
                    int i12 = i10 + 1;
                    double d3 = dArr[i12];
                    double d4 = dArr[i11];
                    int i13 = i11 + 1;
                    double d5 = dArr[i13];
                    dArr[i10] = d4;
                    dArr[i12] = d5;
                    dArr[i11] = d2;
                    dArr[i13] = d3;
                    int i14 = i10 + i7;
                    int i15 = i11 + i7;
                    double d6 = dArr[i14];
                    int i16 = i14 + 1;
                    double d7 = dArr[i16];
                    double d8 = dArr[i15];
                    int i17 = i15 + 1;
                    double d9 = dArr[i17];
                    dArr[i14] = d8;
                    dArr[i16] = d9;
                    dArr[i15] = d6;
                    dArr[i17] = d7;
                }
            }
            return;
        }
        for (int i18 = 0; i18 < i5; i18++) {
            for (int i19 = 0; i19 < i18; i19++) {
                int i20 = (i19 * 2) + iArr[i2 + i18];
                int i21 = (i18 * 2) + iArr[i2 + i19];
                double d10 = dArr[i20];
                int i22 = i20 + 1;
                double d11 = dArr[i22];
                double d12 = dArr[i21];
                int i23 = i21 + 1;
                double d13 = dArr[i23];
                dArr[i20] = d12;
                dArr[i22] = d13;
                dArr[i21] = d10;
                dArr[i23] = d11;
                int i24 = i20 + i7;
                int i25 = i7 * 2;
                int i26 = i21 + i25;
                double d14 = dArr[i24];
                int i27 = i24 + 1;
                double d15 = dArr[i27];
                double d16 = dArr[i26];
                int i28 = i26 + 1;
                double d17 = dArr[i28];
                dArr[i24] = d16;
                dArr[i27] = d17;
                dArr[i26] = d14;
                dArr[i28] = d15;
                int i29 = i24 + i7;
                int i30 = i26 - i7;
                double d18 = dArr[i29];
                int i31 = i29 + 1;
                double d19 = dArr[i31];
                double d20 = dArr[i30];
                int i32 = i30 + 1;
                double d21 = dArr[i32];
                dArr[i29] = d20;
                dArr[i31] = d21;
                dArr[i30] = d18;
                dArr[i32] = d19;
                int i33 = i29 + i7;
                int i34 = i30 + i25;
                double d22 = dArr[i33];
                int i35 = i33 + 1;
                double d23 = dArr[i35];
                double d24 = dArr[i34];
                int i36 = i34 + 1;
                double d25 = dArr[i36];
                dArr[i33] = d24;
                dArr[i35] = d25;
                dArr[i34] = d22;
                dArr[i36] = d23;
            }
            int i37 = (i18 * 2) + i7 + iArr[i2 + i18];
            int i38 = i37 + i7;
            double d26 = dArr[i37];
            int i39 = i37 + 1;
            double d27 = dArr[i39];
            double d28 = dArr[i38];
            int i40 = i38 + 1;
            double d29 = dArr[i40];
            dArr[i37] = d28;
            dArr[i39] = d29;
            dArr[i38] = d26;
            dArr[i40] = d27;
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

    public final void f(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        iArr[i2 + 0] = 0;
        int i4 = i;
        int i5 = 1;
        while (true) {
            i3 = i5 << 3;
            if (i3 >= i4) {
                break;
            }
            i4 >>= 1;
            for (int i6 = 0; i6 < i5; i6++) {
                iArr[i2 + i5 + i6] = iArr[i2 + i6] + i4;
            }
            i5 <<= 1;
        }
        int i7 = i5 * 2;
        if (i3 != i4) {
            int i8 = i5;
            dArr[1] = -dArr[1];
            int i9 = i7 + 1;
            dArr[i9] = -dArr[i9];
            for (int i10 = 1; i10 < i8; i10++) {
                for (int i11 = 0; i11 < i10; i11++) {
                    int i12 = (i11 * 2) + iArr[i2 + i10];
                    int i13 = (i10 * 2) + iArr[i2 + i11];
                    double d2 = dArr[i12];
                    int i14 = i12 + 1;
                    int i15 = i13 + 1;
                    dArr[i12] = dArr[i13];
                    dArr[i14] = -dArr[i15];
                    dArr[i13] = d2;
                    dArr[i15] = -dArr[i14];
                    int i16 = i12 + i7;
                    int i17 = i13 + i7;
                    double d3 = dArr[i16];
                    int i18 = i16 + 1;
                    int i19 = i17 + 1;
                    dArr[i16] = dArr[i17];
                    dArr[i18] = -dArr[i19];
                    dArr[i17] = d3;
                    dArr[i19] = -dArr[i18];
                }
                int i20 = (i10 * 2) + iArr[i2 + i10];
                int i21 = i20 + 1;
                dArr[i21] = -dArr[i21];
                int i22 = i20 + i7 + 1;
                dArr[i22] = -dArr[i22];
            }
            return;
        }
        int i23 = 0;
        while (i23 < i5) {
            int i24 = 0;
            while (i24 < i23) {
                int i25 = (i24 * 2) + iArr[i2 + i23];
                int i26 = (i23 * 2) + iArr[i2 + i24];
                double d4 = dArr[i25];
                int i27 = i25 + 1;
                int i28 = i26 + 1;
                dArr[i25] = dArr[i26];
                dArr[i27] = -dArr[i28];
                dArr[i26] = d4;
                dArr[i28] = -dArr[i27];
                int i29 = i25 + i7;
                int i30 = i7 * 2;
                int i31 = i26 + i30;
                double d5 = dArr[i29];
                int i32 = i29 + 1;
                int i33 = i31 + 1;
                int i34 = i23;
                int i35 = i5;
                dArr[i29] = dArr[i31];
                dArr[i32] = -dArr[i33];
                dArr[i31] = d5;
                dArr[i33] = -dArr[i32];
                int i36 = i29 + i7;
                int i37 = i31 - i7;
                double d6 = dArr[i36];
                int i38 = i36 + 1;
                int i39 = i37 + 1;
                dArr[i36] = dArr[i37];
                dArr[i38] = -dArr[i39];
                dArr[i37] = d6;
                dArr[i39] = -dArr[i38];
                int i40 = i36 + i7;
                int i41 = i37 + i30;
                double d7 = dArr[i40];
                int i42 = i40 + 1;
                int i43 = i41 + 1;
                dArr[i40] = dArr[i41];
                dArr[i42] = -dArr[i43];
                dArr[i41] = d7;
                dArr[i43] = -dArr[i42];
                i24++;
                i5 = i35;
                i23 = i34;
            }
            int i44 = i23;
            int i45 = i5;
            int i46 = (i44 * 2) + iArr[i2 + i44];
            int i47 = i46 + 1;
            dArr[i47] = -dArr[i47];
            int i48 = i46 + i7;
            int i49 = i48 + i7;
            double d8 = dArr[i48];
            int i50 = i48 + 1;
            int i51 = i49 + 1;
            dArr[i48] = dArr[i49];
            dArr[i50] = -dArr[i51];
            dArr[i49] = d8;
            dArr[i51] = -dArr[i50];
            int i52 = i49 + i7 + 1;
            dArr[i52] = -dArr[i52];
            i23 = i44 + 1;
            i5 = i45;
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

    public final void h(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        int i7 = 0;
        double d2 = dArr[0] + dArr[i5];
        int i8 = i5 + 1;
        double d3 = (-dArr[1]) - dArr[i8];
        double d4 = dArr[0] - dArr[i5];
        double d5 = (-dArr[1]) + dArr[i8];
        double d6 = dArr[i4] + dArr[i6];
        int i9 = i4 + 1;
        int i10 = i6 + 1;
        double d7 = dArr[i9] + dArr[i10];
        double d8 = dArr[i4] - dArr[i6];
        double d9 = dArr[i9] - dArr[i10];
        dArr[0] = d2 + d6;
        dArr[1] = d3 - d7;
        dArr[i4] = d2 - d6;
        dArr[i9] = d3 + d7;
        dArr[i5] = d4 + d9;
        dArr[i8] = d5 + d8;
        dArr[i6] = d4 - d9;
        dArr[i10] = d5 - d8;
        double d10 = dArr2[i2 + 1];
        double d11 = dArr2[i2 + 2];
        double d12 = dArr2[i2 + 3];
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 1.0d;
        int i11 = 2;
        double d16 = 0.0d;
        while (true) {
            int i12 = i3 - 2;
            if (i11 < i12) {
                int i13 = i7 + 4;
                int i14 = i2 + i13;
                double d17 = (d14 + dArr2[i14]) * d11;
                int i15 = i14 + 1;
                double d18 = (d13 + dArr2[i15]) * d11;
                int i16 = i14 + 2;
                double d19 = (d15 + dArr2[i16]) * d12;
                int i17 = i14 + 3;
                double d20 = (d16 - dArr2[i17]) * d12;
                double d21 = dArr2[i14];
                double d22 = dArr2[i15];
                double d23 = dArr2[i16];
                double d24 = -dArr2[i17];
                int i18 = i11 + i4;
                int i19 = i18 + i4;
                int i20 = i19 + i4;
                double d25 = dArr[i11] + dArr[i19];
                int i21 = i11 + 1;
                double d26 = d12;
                int i22 = i19 + 1;
                double d27 = (-dArr[i21]) - dArr[i22];
                double d28 = dArr[i11] - dArr[i19];
                double d29 = d11;
                double d30 = (-dArr[i21]) + dArr[i22];
                int i23 = i11 + 2;
                int i24 = i19 + 2;
                double d31 = dArr[i23] + dArr[i24];
                int i25 = i11 + 3;
                int i26 = i3;
                int i27 = i4;
                int i28 = i19 + 3;
                double d32 = (-dArr[i25]) - dArr[i28];
                double d33 = dArr[i23] - dArr[i24];
                double d34 = (-dArr[i25]) + dArr[i28];
                double d35 = dArr[i18] + dArr[i20];
                int i29 = i18 + 1;
                int i30 = i20 + 1;
                double d36 = dArr[i29] + dArr[i30];
                double d37 = dArr[i18] - dArr[i20];
                double d38 = dArr[i29] - dArr[i30];
                int i31 = i18 + 2;
                int i32 = i20 + 2;
                double d39 = dArr[i31] + dArr[i32];
                int i33 = i18 + 3;
                int i34 = i20 + 3;
                double d40 = dArr[i33] + dArr[i34];
                double d41 = dArr[i31] - dArr[i32];
                double d42 = dArr[i33] - dArr[i34];
                dArr[i11] = d25 + d35;
                dArr[i21] = d27 - d36;
                dArr[i23] = d31 + d39;
                dArr[i25] = d32 - d40;
                dArr[i18] = d25 - d35;
                dArr[i29] = d27 + d36;
                dArr[i31] = d31 - d39;
                dArr[i33] = d32 + d40;
                double d43 = d28 + d38;
                double d44 = d30 + d37;
                dArr[i19] = (d17 * d43) - (d18 * d44);
                dArr[i22] = (d44 * d17) + (d43 * d18);
                double d45 = d33 + d42;
                double d46 = d34 + d41;
                dArr[i24] = (d21 * d45) - (d22 * d46);
                dArr[i28] = (d46 * d21) + (d45 * d22);
                double d47 = d28 - d38;
                double d48 = d30 - d37;
                dArr[i20] = (d19 * d47) + (d20 * d48);
                dArr[i30] = (d48 * d19) - (d47 * d20);
                double d49 = d33 - d42;
                double d50 = d34 - d41;
                dArr[i32] = (d23 * d49) + (d24 * d50);
                dArr[i34] = (d50 * d23) - (d24 * d49);
                int i35 = i27 - i11;
                int i36 = i35 + i27;
                int i37 = i36 + i27;
                int i38 = i37 + i27;
                double d51 = dArr[i35] + dArr[i37];
                int i39 = i35 + 1;
                int i40 = i37 + 1;
                double d52 = (-dArr[i39]) - dArr[i40];
                double d53 = dArr[i35] - dArr[i37];
                double d54 = (-dArr[i39]) + dArr[i40];
                int i41 = i35 - 2;
                int i42 = i37 - 2;
                double d55 = dArr[i41] + dArr[i42];
                int i43 = i35 - 1;
                int i44 = i37 - 1;
                double d56 = (-dArr[i43]) - dArr[i44];
                double d57 = dArr[i41] - dArr[i42];
                int i45 = i11;
                double d58 = (-dArr[i43]) + dArr[i44];
                double d59 = dArr[i36] + dArr[i38];
                int i46 = i36 + 1;
                int i47 = i38 + 1;
                double d60 = dArr[i46] + dArr[i47];
                double d61 = dArr[i36] - dArr[i38];
                double d62 = dArr[i46] - dArr[i47];
                int i48 = i36 - 2;
                int i49 = i38 - 2;
                double d63 = dArr[i48] + dArr[i49];
                int i50 = i36 - 1;
                int i51 = i38 - 1;
                double d64 = dArr[i50] + dArr[i51];
                double d65 = dArr[i48] - dArr[i49];
                double d66 = dArr[i50] - dArr[i51];
                dArr[i35] = d51 + d59;
                dArr[i39] = d52 - d60;
                dArr[i41] = d55 + d63;
                dArr[i43] = d56 - d64;
                dArr[i36] = d51 - d59;
                dArr[i46] = d52 + d60;
                dArr[i48] = d55 - d63;
                dArr[i50] = d56 + d64;
                double d67 = d53 + d62;
                double d68 = d54 + d61;
                dArr[i37] = (d18 * d67) - (d17 * d68);
                dArr[i40] = (d68 * d18) + (d67 * d17);
                double d69 = d57 + d66;
                double d70 = d58 + d65;
                dArr[i42] = (d22 * d69) - (d21 * d70);
                dArr[i44] = (d70 * d22) + (d69 * d21);
                double d71 = d53 - d62;
                double d72 = d54 - d61;
                dArr[i38] = (d20 * d71) + (d19 * d72);
                dArr[i47] = (d20 * d72) - (d19 * d71);
                double d73 = d57 - d66;
                double d74 = d58 - d65;
                dArr[i49] = (d24 * d73) + (d23 * d74);
                dArr[i51] = (d24 * d74) - (d73 * d23);
                i11 = i45 + 4;
                i7 = i13;
                d15 = d23;
                d14 = d21;
                d13 = d22;
                d12 = d26;
                d11 = d29;
                i3 = i26;
                i4 = i27;
                d16 = d24;
            } else {
                int i52 = i3;
                int i53 = i4;
                double d75 = d11;
                double d76 = d12;
                double d77 = d75 * (d14 + d10);
                double d78 = d75 * (d13 + d10);
                double d79 = d76 * (d15 - d10);
                double d80 = d76 * (d16 - d10);
                int i54 = i52 + i53;
                int i55 = i54 + i53;
                int i56 = i55 + i53;
                int i57 = i55 - 2;
                double d81 = dArr[i12] + dArr[i57];
                int i58 = i52 - 1;
                int i59 = i55 - 1;
                double d82 = (-dArr[i58]) - dArr[i59];
                double d83 = dArr[i12] - dArr[i57];
                double d84 = (-dArr[i58]) + dArr[i59];
                int i60 = i54 - 2;
                int i61 = i56 - 2;
                double d85 = dArr[i60] + dArr[i61];
                int i62 = i54 - 1;
                int i63 = i56 - 1;
                double d86 = dArr[i62] + dArr[i63];
                double d87 = dArr[i60] - dArr[i61];
                double d88 = dArr[i62] - dArr[i63];
                dArr[i12] = d81 + d85;
                dArr[i58] = d82 - d86;
                dArr[i60] = d81 - d85;
                dArr[i62] = d82 + d86;
                double d89 = d83 + d88;
                double d90 = d84 + d87;
                dArr[i57] = (d77 * d89) - (d78 * d90);
                dArr[i59] = (d90 * d77) + (d89 * d78);
                double d91 = d83 - d88;
                double d92 = d84 - d87;
                dArr[i61] = (d79 * d91) + (d80 * d92);
                dArr[i63] = (d92 * d79) - (d80 * d91);
                double d93 = dArr[i52] + dArr[i55];
                int i64 = i52 + 1;
                int i65 = i55 + 1;
                double d94 = (-dArr[i64]) - dArr[i65];
                double d95 = dArr[i52] - dArr[i55];
                double d96 = (-dArr[i64]) + dArr[i65];
                double d97 = dArr[i54] + dArr[i56];
                int i66 = i54 + 1;
                int i67 = i56 + 1;
                double d98 = dArr[i66] + dArr[i67];
                double d99 = dArr[i54] - dArr[i56];
                double d100 = dArr[i66] - dArr[i67];
                dArr[i52] = d93 + d97;
                dArr[i64] = d94 - d98;
                dArr[i54] = d93 - d97;
                dArr[i66] = d94 + d98;
                double d101 = d95 + d100;
                double d102 = d96 + d99;
                dArr[i55] = (d101 - d102) * d10;
                dArr[i65] = d10 * (d102 + d101);
                double d103 = d95 - d100;
                double d104 = d96 - d99;
                double d105 = -d10;
                dArr[i56] = (d103 + d104) * d105;
                dArr[i67] = d105 * (d104 - d103);
                int i68 = i52 + 2;
                int i69 = i55 + 2;
                double d106 = dArr[i68] + dArr[i69];
                int i70 = i52 + 3;
                int i71 = i55 + 3;
                double d107 = (-dArr[i70]) - dArr[i71];
                double d108 = dArr[i68] - dArr[i69];
                double d109 = (-dArr[i70]) + dArr[i71];
                int i72 = i54 + 2;
                int i73 = i56 + 2;
                double d110 = dArr[i72] + dArr[i73];
                int i74 = i54 + 3;
                int i75 = i56 + 3;
                double d111 = dArr[i74] + dArr[i75];
                double d112 = dArr[i72] - dArr[i73];
                double d113 = dArr[i74] - dArr[i75];
                dArr[i68] = d106 + d110;
                dArr[i70] = d107 - d111;
                dArr[i72] = d106 - d110;
                dArr[i74] = d107 + d111;
                double d114 = d108 + d113;
                double d115 = d109 + d112;
                dArr[i69] = (d78 * d114) - (d77 * d115);
                dArr[i71] = (d78 * d115) + (d77 * d114);
                double d116 = d108 - d113;
                double d117 = d109 - d112;
                dArr[i73] = (d80 * d116) + (d79 * d117);
                dArr[i75] = (d80 * d117) - (d79 * d116);
                return;
            }
        }
    }

    public final void i(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            h(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                w(i4, dArr, 0, i3, dArr2);
                x(i4, dArr, i4, i3, dArr2);
                w(i4, dArr, i4 * 2, i3, dArr2);
                w(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                j(i, dArr, 0, i3, dArr2);
            } else {
                s(i, dArr, 0, i3, dArr2);
            }
            f(i, iArr, i2, dArr);
        } else if (i > 8) {
            if (i == 32) {
                o(dArr, 0, dArr2, i3 - 8);
                e(dArr);
                return;
            }
            m(dArr, 0, dArr2, 0);
            c(dArr);
        } else if (i == 8) {
            g(dArr);
        } else if (i == 4) {
            y(dArr);
        }
    }

    public final void j(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        while (i4 > 128) {
            for (int i5 = i4; i5 < i; i5 <<= 2) {
                for (int i6 = i5 - i4; i6 < i; i6 += i5 * 4) {
                    int i7 = i3 - (i4 >> 1);
                    int i8 = i4;
                    u(i8, dArr, i2 + i6, dArr2, i7);
                    v(i8, dArr, i2 + i5 + i6, dArr2, i3 - i4);
                    u(i8, dArr, i2 + (i5 * 2) + i6, dArr2, i7);
                }
            }
            u(i4, dArr, (i2 + i) - i4, dArr2, i3 - (i4 >> 1));
            i4 >>= 2;
        }
        for (int i9 = i4; i9 < i; i9 <<= 2) {
            for (int i10 = i9 - i4; i10 < i; i10 += i9 * 4) {
                int i11 = i2 + i10;
                int i12 = i3 - (i4 >> 1);
                u(i4, dArr, i11, dArr2, i12);
                s(i4, dArr, i11, i3, dArr2);
                int i13 = i2 + i9 + i10;
                v(i4, dArr, i13, dArr2, i3 - i4);
                t(i4, dArr, i13, i3, dArr2);
                int i14 = i2 + (i9 * 2) + i10;
                u(i4, dArr, i14, dArr2, i12);
                s(i4, dArr, i14, i3, dArr2);
            }
        }
        int i15 = (i2 + i) - i4;
        u(i4, dArr, i15, dArr2, i3 - (i4 >> 1));
        s(i4, dArr, i15, i3, dArr2);
    }

    public final void k(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 1;
        int i5 = i >> 2;
        while (i5 > 128) {
            for (int i6 = i5; i6 < i4; i6 <<= 2) {
                for (int i7 = i6 - i5; i7 < i4; i7 += i6 * 2) {
                    int i8 = i3 - (i5 >> 1);
                    int i9 = i5;
                    u(i9, dArr, i2 + i7, dArr2, i8);
                    u(i9, dArr, i2 + i4 + i7, dArr2, i8);
                }
                for (int i10 = (i6 * 2) - i5; i10 < i4; i10 += i6 * 4) {
                    int i11 = i3 - i5;
                    int i12 = i5;
                    v(i12, dArr, i2 + i10, dArr2, i11);
                    v(i12, dArr, i2 + i4 + i10, dArr2, i11);
                }
            }
            i5 >>= 2;
        }
        for (int i13 = i5; i13 < i4; i13 <<= 2) {
            for (int i14 = i13 - i5; i14 < i4; i14 += i13 * 2) {
                int i15 = i2 + i14;
                int i16 = i3 - (i5 >> 1);
                int i17 = i5;
                u(i17, dArr, i15, dArr2, i16);
                int i18 = i5;
                s(i18, dArr, i15, i3, dArr2);
                int i19 = i2 + i4 + i14;
                u(i17, dArr, i19, dArr2, i16);
                s(i18, dArr, i19, i3, dArr2);
            }
            for (int i20 = (i13 * 2) - i5; i20 < i4; i20 += i13 * 4) {
                int i21 = i2 + i20;
                int i22 = i3 - i5;
                int i23 = i5;
                v(i23, dArr, i21, dArr2, i22);
                int i24 = i5;
                t(i24, dArr, i21, i3, dArr2);
                int i25 = i2 + i4 + i20;
                v(i23, dArr, i25, dArr2, i22);
                t(i24, dArr, i25, i3, dArr2);
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

    public final void m(double[] dArr, int i, double[] dArr2, int i2) {
        double d2 = dArr2[i2 + 1];
        int i3 = i + 0;
        int i4 = i + 8;
        double d3 = dArr[i3] + dArr[i4];
        int i5 = i + 1;
        int i6 = i + 9;
        double d4 = dArr[i5] + dArr[i6];
        double d5 = dArr[i3] - dArr[i4];
        double d6 = dArr[i5] - dArr[i6];
        int i7 = i + 4;
        int i8 = i + 12;
        double d7 = dArr[i7] + dArr[i8];
        int i9 = i + 5;
        int i10 = i + 13;
        double d8 = dArr[i9] + dArr[i10];
        double d9 = dArr[i7] - dArr[i8];
        double d10 = dArr[i9] - dArr[i10];
        double d11 = d3 + d7;
        double d12 = d4 + d8;
        double d13 = d3 - d7;
        double d14 = d4 - d8;
        double d15 = d5 - d10;
        double d16 = d6 + d9;
        double d17 = d5 + d10;
        double d18 = d6 - d9;
        int i11 = i + 2;
        int i12 = i + 10;
        double d19 = dArr[i11] + dArr[i12];
        int i13 = i + 3;
        int i14 = i + 11;
        double d20 = dArr[i13] + dArr[i14];
        double d21 = dArr[i11] - dArr[i12];
        double d22 = dArr[i13] - dArr[i14];
        int i15 = i + 6;
        int i16 = i + 14;
        double d23 = dArr[i15] + dArr[i16];
        int i17 = i + 7;
        int i18 = i + 15;
        double d24 = dArr[i17] + dArr[i18];
        double d25 = dArr[i15] - dArr[i16];
        double d26 = dArr[i17] - dArr[i18];
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
        dArr[i4] = d15 + d35;
        dArr[i6] = d16 + d36;
        dArr[i12] = d15 - d35;
        dArr[i14] = d16 - d36;
        dArr[i8] = d17 - d38;
        dArr[i10] = d18 + d37;
        dArr[i16] = d17 + d38;
        dArr[i18] = d18 - d37;
        dArr[i3] = d11 + d27;
        dArr[i5] = d12 + d28;
        dArr[i11] = d11 - d27;
        dArr[i13] = d12 - d28;
        dArr[i7] = d13 - d30;
        dArr[i9] = d14 + d29;
        dArr[i15] = d13 + d30;
        dArr[i17] = d14 - d29;
    }

    public final void n(double[] dArr, int i, double[] dArr2, int i2) {
        double d2 = dArr2[i2 + 1];
        double d3 = dArr2[i2 + 4];
        double d4 = dArr2[i2 + 5];
        int i3 = i + 0;
        int i4 = i + 9;
        double d5 = dArr[i3] - dArr[i4];
        int i5 = i + 1;
        int i6 = i + 8;
        double d6 = dArr[i5] + dArr[i6];
        double d7 = dArr[i3] + dArr[i4];
        double d8 = dArr[i5] - dArr[i6];
        int i7 = i + 4;
        int i8 = i + 13;
        double d9 = dArr[i7] - dArr[i8];
        int i9 = i + 5;
        int i10 = i + 12;
        double d10 = dArr[i9] + dArr[i10];
        double d11 = (d9 - d10) * d2;
        double d12 = (d10 + d9) * d2;
        double d13 = dArr[i7] + dArr[i8];
        double d14 = dArr[i9] - dArr[i10];
        double d15 = (d13 - d14) * d2;
        double d16 = d2 * (d14 + d13);
        int i11 = i + 2;
        int i12 = i + 11;
        double d17 = dArr[i11] - dArr[i12];
        int i13 = i + 3;
        int i14 = i + 10;
        double d18 = dArr[i13] + dArr[i14];
        double d19 = (d3 * d17) - (d4 * d18);
        double d20 = (d18 * d3) + (d17 * d4);
        double d21 = dArr[i11] + dArr[i12];
        double d22 = dArr[i13] - dArr[i14];
        double d23 = (d4 * d21) - (d3 * d22);
        double d24 = (d22 * d4) + (d21 * d3);
        int i15 = i + 6;
        int i16 = i + 15;
        double d25 = dArr[i15] - dArr[i16];
        int i17 = i + 7;
        int i18 = i + 14;
        double d26 = dArr[i17] + dArr[i18];
        double d27 = (d4 * d25) - (d3 * d26);
        double d28 = (d26 * d4) + (d25 * d3);
        double d29 = dArr[i15] + dArr[i16];
        double d30 = dArr[i17] - dArr[i18];
        double d31 = (d3 * d29) - (d4 * d30);
        double d32 = (d3 * d30) + (d4 * d29);
        double d33 = d5 + d11;
        double d34 = d6 + d12;
        double d35 = d19 + d27;
        double d36 = d20 + d28;
        dArr[i3] = d33 + d35;
        dArr[i5] = d34 + d36;
        dArr[i11] = d33 - d35;
        dArr[i13] = d34 - d36;
        double d37 = d5 - d11;
        double d38 = d6 - d12;
        double d39 = d19 - d27;
        double d40 = d20 - d28;
        dArr[i7] = d37 - d40;
        dArr[i9] = d38 + d39;
        dArr[i15] = d37 + d40;
        dArr[i17] = d38 - d39;
        double d41 = d7 - d16;
        double d42 = d8 + d15;
        double d43 = d23 - d31;
        double d44 = d24 - d32;
        dArr[i6] = d41 + d43;
        dArr[i4] = d42 + d44;
        dArr[i14] = d41 - d43;
        dArr[i12] = d42 - d44;
        double d45 = d7 + d16;
        double d46 = d8 - d15;
        double d47 = d23 + d31;
        double d48 = d24 + d32;
        dArr[i10] = d45 - d48;
        dArr[i8] = d46 + d47;
        dArr[i18] = d45 + d48;
        dArr[i16] = d46 - d47;
    }

    public final void o(double[] dArr, int i, double[] dArr2, int i2) {
        double d2 = dArr2[i2 + 1];
        int i3 = i2 + 2;
        double d3 = dArr2[i3] * d2;
        double d4 = dArr2[i3] + d3;
        int i4 = i + 0;
        int i5 = i + 16;
        double d5 = dArr[i4] + dArr[i5];
        int i6 = i + 1;
        int i7 = i + 17;
        double d6 = dArr[i6] + dArr[i7];
        double d7 = dArr[i4] - dArr[i5];
        double d8 = dArr[i6] - dArr[i7];
        int i8 = i + 8;
        int i9 = i + 24;
        double d9 = dArr[i8] + dArr[i9];
        int i10 = i + 9;
        int i11 = i + 25;
        double d10 = dArr[i10] + dArr[i11];
        double d11 = dArr[i8] - dArr[i9];
        double d12 = dArr[i10] - dArr[i11];
        double d13 = d5 + d9;
        double d14 = d6 + d10;
        double d15 = d5 - d9;
        double d16 = d6 - d10;
        double d17 = d7 - d12;
        double d18 = d8 + d11;
        double d19 = d7 + d12;
        double d20 = d8 - d11;
        int i12 = i + 2;
        int i13 = i + 18;
        double d21 = dArr[i12] + dArr[i13];
        int i14 = i + 3;
        int i15 = i + 19;
        double d22 = dArr[i14] + dArr[i15];
        double d23 = dArr[i12] - dArr[i13];
        double d24 = dArr[i14] - dArr[i15];
        int i16 = i + 10;
        int i17 = i + 26;
        double d25 = dArr[i16] + dArr[i17];
        int i18 = i + 11;
        int i19 = i + 27;
        double d26 = dArr[i18] + dArr[i19];
        double d27 = dArr[i16] - dArr[i17];
        double d28 = dArr[i18] - dArr[i19];
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
        int i20 = i + 4;
        int i21 = i + 20;
        double d41 = dArr[i20] + dArr[i21];
        int i22 = i + 5;
        int i23 = i + 21;
        double d42 = dArr[i22] + dArr[i23];
        double d43 = dArr[i20] - dArr[i21];
        double d44 = dArr[i22] - dArr[i23];
        int i24 = i + 12;
        int i25 = i + 28;
        double d45 = dArr[i24] + dArr[i25];
        int i26 = i + 13;
        int i27 = i + 29;
        double d46 = dArr[i26] + dArr[i27];
        double d47 = dArr[i24] - dArr[i25];
        double d48 = dArr[i26] - dArr[i27];
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
        int i28 = i + 6;
        int i29 = i + 22;
        double d61 = dArr[i28] + dArr[i29];
        int i30 = i + 7;
        int i31 = i + 23;
        double d62 = dArr[i30] + dArr[i31];
        double d63 = dArr[i28] - dArr[i29];
        double d64 = dArr[i30] - dArr[i31];
        int i32 = i + 14;
        int i33 = i + 30;
        double d65 = dArr[i32] + dArr[i33];
        int i34 = i + 15;
        int i35 = i + 31;
        double d66 = dArr[i34] + dArr[i35];
        double d67 = dArr[i32] - dArr[i33];
        double d68 = dArr[i34] - dArr[i35];
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
        dArr[i9] = d81 + d85;
        dArr[i11] = d82 + d86;
        dArr[i17] = d81 - d85;
        dArr[i19] = d82 - d86;
        dArr[i25] = d83 - d88;
        dArr[i27] = d84 + d87;
        dArr[i33] = d83 + d88;
        dArr[i35] = d84 - d87;
        double d89 = d17 + d55;
        double d90 = d18 + d56;
        double d91 = d17 - d55;
        double d92 = d18 - d56;
        double d93 = d35 + d75;
        double d94 = d36 + d76;
        double d95 = d35 - d75;
        double d96 = d36 - d76;
        dArr[i5] = d89 + d93;
        dArr[i7] = d90 + d94;
        dArr[i13] = d89 - d93;
        dArr[i15] = d90 - d94;
        dArr[i21] = d91 - d96;
        dArr[i23] = d92 + d95;
        dArr[i29] = d91 + d96;
        dArr[i31] = d92 - d95;
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
        dArr[i8] = d105 + d99;
        dArr[i10] = d106 + d100;
        dArr[i16] = d105 - d99;
        dArr[i18] = d106 - d100;
        dArr[i24] = d107 - d104;
        dArr[i26] = d108 + d103;
        dArr[i32] = d107 + d104;
        dArr[i34] = d108 - d103;
        double d109 = d13 + d49;
        double d110 = d14 + d50;
        double d111 = d13 - d49;
        double d112 = d14 - d50;
        double d113 = d29 + d69;
        double d114 = d30 + d70;
        double d115 = d29 - d69;
        double d116 = d30 - d70;
        dArr[i4] = d109 + d113;
        dArr[i6] = d110 + d114;
        dArr[i12] = d109 - d113;
        dArr[i14] = d110 - d114;
        dArr[i20] = d111 - d116;
        dArr[i22] = d112 + d115;
        dArr[i28] = d111 + d116;
        dArr[i30] = d112 - d115;
    }

    public final void p(double[] dArr, int i, double[] dArr2, int i2) {
        double d2 = dArr2[i2 + 1];
        double d3 = dArr2[i2 + 4];
        double d4 = dArr2[i2 + 5];
        double d5 = dArr2[i2 + 6];
        double d6 = dArr2[i2 + 7];
        double d7 = dArr2[i2 + 8];
        double d8 = dArr2[i2 + 9];
        int i3 = i + 0;
        int i4 = i + 17;
        double d9 = dArr[i3] - dArr[i4];
        int i5 = i + 1;
        int i6 = i + 16;
        double d10 = dArr[i5] + dArr[i6];
        int i7 = i + 8;
        int i8 = i + 25;
        double d11 = dArr[i7] - dArr[i8];
        int i9 = i + 9;
        int i10 = i + 24;
        double d12 = dArr[i9] + dArr[i10];
        double d13 = (d11 - d12) * d2;
        double d14 = (d12 + d11) * d2;
        double d15 = d9 + d13;
        double d16 = d10 + d14;
        double d17 = d9 - d13;
        double d18 = d10 - d14;
        double d19 = dArr[i3] + dArr[i4];
        double d20 = dArr[i5] - dArr[i6];
        double d21 = dArr[i7] + dArr[i8];
        double d22 = dArr[i9] - dArr[i10];
        double d23 = (d21 - d22) * d2;
        double d24 = (d22 + d21) * d2;
        double d25 = d19 - d24;
        double d26 = d20 + d23;
        double d27 = d19 + d24;
        double d28 = d20 - d23;
        int i11 = i + 2;
        int i12 = i + 19;
        double d29 = dArr[i11] - dArr[i12];
        int i13 = i + 3;
        int i14 = i + 18;
        double d30 = dArr[i13] + dArr[i14];
        double d31 = (d3 * d29) - (d4 * d30);
        double d32 = (d30 * d3) + (d29 * d4);
        int i15 = i + 10;
        int i16 = i + 27;
        double d33 = dArr[i15] - dArr[i16];
        int i17 = i + 11;
        int i18 = i + 26;
        double d34 = dArr[i17] + dArr[i18];
        double d35 = (d6 * d33) - (d5 * d34);
        double d36 = (d34 * d6) + (d33 * d5);
        double d37 = d31 + d35;
        double d38 = d32 + d36;
        double d39 = d31 - d35;
        double d40 = d32 - d36;
        double d41 = dArr[i11] + dArr[i12];
        double d42 = dArr[i13] - dArr[i14];
        double d43 = (d5 * d41) - (d6 * d42);
        double d44 = (d42 * d5) + (d41 * d6);
        double d45 = dArr[i15] + dArr[i16];
        double d46 = dArr[i17] - dArr[i18];
        double d47 = (d3 * d45) + (d4 * d46);
        double d48 = (d46 * d3) - (d45 * d4);
        double d49 = d43 - d47;
        double d50 = d44 - d48;
        double d51 = d43 + d47;
        double d52 = d44 + d48;
        int i19 = i + 4;
        int i20 = i + 21;
        double d53 = dArr[i19] - dArr[i20];
        int i21 = i + 5;
        int i22 = i + 20;
        double d54 = dArr[i21] + dArr[i22];
        double d55 = (d7 * d53) - (d8 * d54);
        double d56 = (d54 * d7) + (d53 * d8);
        int i23 = i + 12;
        int i24 = i + 29;
        double d57 = dArr[i23] - dArr[i24];
        int i25 = i + 13;
        int i26 = i + 28;
        double d58 = dArr[i25] + dArr[i26];
        double d59 = (d8 * d57) - (d7 * d58);
        double d60 = (d58 * d8) + (d57 * d7);
        double d61 = d55 + d59;
        double d62 = d56 + d60;
        double d63 = d55 - d59;
        double d64 = d56 - d60;
        double d65 = dArr[i19] + dArr[i20];
        double d66 = dArr[i21] - dArr[i22];
        double d67 = (d8 * d65) - (d7 * d66);
        double d68 = (d66 * d8) + (d65 * d7);
        double d69 = dArr[i23] + dArr[i24];
        double d70 = dArr[i25] - dArr[i26];
        double d71 = (d7 * d69) - (d8 * d70);
        double d72 = (d7 * d70) + (d8 * d69);
        double d73 = d67 - d71;
        double d74 = d68 - d72;
        double d75 = d67 + d71;
        double d76 = d68 + d72;
        int i27 = i + 6;
        int i28 = i + 23;
        double d77 = dArr[i27] - dArr[i28];
        int i29 = i + 7;
        int i30 = i + 22;
        double d78 = dArr[i29] + dArr[i30];
        double d79 = (d5 * d77) - (d6 * d78);
        double d80 = (d78 * d5) + (d77 * d6);
        int i31 = i + 14;
        int i32 = i + 31;
        double d81 = dArr[i31] - dArr[i32];
        int i33 = i + 15;
        int i34 = i + 30;
        double d82 = dArr[i33] + dArr[i34];
        double d83 = (d4 * d81) - (d3 * d82);
        double d84 = (d82 * d4) + (d81 * d3);
        double d85 = d79 + d83;
        double d86 = d80 + d84;
        double d87 = d79 - d83;
        double d88 = d80 - d84;
        double d89 = dArr[i27] + dArr[i28];
        double d90 = dArr[i29] - dArr[i30];
        double d91 = (d4 * d89) + (d3 * d90);
        double d92 = (d4 * d90) - (d3 * d89);
        double d93 = dArr[i31] + dArr[i32];
        double d94 = dArr[i33] - dArr[i34];
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
        dArr[i3] = d101 + d103;
        dArr[i5] = d102 + d104;
        dArr[i11] = d101 - d103;
        dArr[i13] = d102 - d104;
        double d105 = d15 - d61;
        double d106 = d16 - d62;
        double d107 = d37 - d85;
        double d108 = d38 - d86;
        dArr[i19] = d105 - d108;
        dArr[i21] = d106 + d107;
        dArr[i27] = d105 + d108;
        dArr[i29] = d106 - d107;
        double d109 = d17 - d64;
        double d110 = d18 + d63;
        double d111 = d39 - d88;
        double d112 = d40 + d87;
        double d113 = (d111 - d112) * d2;
        double d114 = (d112 + d111) * d2;
        dArr[i7] = d109 + d113;
        dArr[i9] = d110 + d114;
        dArr[i15] = d109 - d113;
        dArr[i17] = d110 - d114;
        double d115 = d17 + d64;
        double d116 = d18 - d63;
        double d117 = d39 + d88;
        double d118 = d40 - d87;
        double d119 = (d117 - d118) * d2;
        double d120 = (d118 + d117) * d2;
        dArr[i23] = d115 - d120;
        dArr[i25] = d116 + d119;
        dArr[i31] = d115 + d120;
        dArr[i33] = d116 - d119;
        double d121 = d25 + d73;
        double d122 = d26 + d74;
        double d123 = d49 - d97;
        double d124 = d50 - d98;
        dArr[i6] = d121 + d123;
        dArr[i4] = d122 + d124;
        dArr[i14] = d121 - d123;
        dArr[i12] = d122 - d124;
        double d125 = d25 - d73;
        double d126 = d26 - d74;
        double d127 = d49 + d97;
        double d128 = d50 + d98;
        dArr[i22] = d125 - d128;
        dArr[i20] = d126 + d127;
        dArr[i30] = d125 + d128;
        dArr[i28] = d126 - d127;
        double d129 = d27 - d76;
        double d130 = d28 + d75;
        double d131 = d51 + d100;
        double d132 = d52 - d99;
        double d133 = (d131 - d132) * d2;
        double d134 = (d132 + d131) * d2;
        dArr[i10] = d129 + d133;
        dArr[i8] = d130 + d134;
        dArr[i18] = d129 - d133;
        dArr[i16] = d130 - d134;
        double d135 = d27 + d76;
        double d136 = d28 - d75;
        double d137 = d51 - d100;
        double d138 = d52 + d99;
        double d139 = (d137 - d138) * d2;
        double d140 = d2 * (d138 + d137);
        dArr[i26] = d135 - d140;
        dArr[i24] = d136 + d139;
        dArr[i34] = d135 + d140;
        dArr[i32] = d136 - d139;
    }

    public final void q(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        int i7 = 0;
        double d2 = dArr[0] + dArr[i5];
        int i8 = i5 + 1;
        double d3 = dArr[1] + dArr[i8];
        double d4 = dArr[0] - dArr[i5];
        double d5 = dArr[1] - dArr[i8];
        double d6 = dArr[i4] + dArr[i6];
        int i9 = i4 + 1;
        int i10 = i6 + 1;
        double d7 = dArr[i9] + dArr[i10];
        double d8 = dArr[i4] - dArr[i6];
        double d9 = dArr[i9] - dArr[i10];
        dArr[0] = d2 + d6;
        dArr[1] = d3 + d7;
        dArr[i4] = d2 - d6;
        dArr[i9] = d3 - d7;
        dArr[i5] = d4 - d9;
        dArr[i8] = d5 + d8;
        dArr[i6] = d4 + d9;
        dArr[i10] = d5 - d8;
        double d10 = dArr2[i2 + 1];
        double d11 = dArr2[i2 + 2];
        double d12 = dArr2[i2 + 3];
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 1.0d;
        int i11 = 2;
        double d16 = 0.0d;
        while (true) {
            int i12 = i3 - 2;
            if (i11 < i12) {
                int i13 = i7 + 4;
                int i14 = i2 + i13;
                double d17 = (d14 + dArr2[i14]) * d11;
                int i15 = i14 + 1;
                double d18 = (d13 + dArr2[i15]) * d11;
                int i16 = i14 + 2;
                double d19 = (d15 + dArr2[i16]) * d12;
                int i17 = i14 + 3;
                double d20 = (d16 - dArr2[i17]) * d12;
                double d21 = dArr2[i14];
                double d22 = dArr2[i15];
                double d23 = dArr2[i16];
                double d24 = -dArr2[i17];
                int i18 = i11 + i4;
                int i19 = i18 + i4;
                int i20 = i19 + i4;
                double d25 = dArr[i11] + dArr[i19];
                int i21 = i11 + 1;
                int i22 = i19 + 1;
                double d26 = dArr[i21] + dArr[i22];
                double d27 = dArr[i11] - dArr[i19];
                double d28 = dArr[i21] - dArr[i22];
                int i23 = i11 + 2;
                int i24 = i19 + 2;
                double d29 = dArr[i23] + dArr[i24];
                int i25 = i11 + 3;
                int i26 = i19 + 3;
                double d30 = dArr[i25] + dArr[i26];
                double d31 = dArr[i23] - dArr[i24];
                double d32 = dArr[i25] - dArr[i26];
                double d33 = dArr[i18] + dArr[i20];
                int i27 = i18 + 1;
                int i28 = i20 + 1;
                double d34 = dArr[i27] + dArr[i28];
                double d35 = dArr[i18] - dArr[i20];
                double d36 = dArr[i27] - dArr[i28];
                int i29 = i18 + 2;
                int i30 = i20 + 2;
                double d37 = dArr[i29] + dArr[i30];
                int i31 = i18 + 3;
                int i32 = i20 + 3;
                double d38 = dArr[i31] + dArr[i32];
                double d39 = dArr[i29] - dArr[i30];
                double d40 = dArr[i31] - dArr[i32];
                dArr[i11] = d25 + d33;
                dArr[i21] = d26 + d34;
                dArr[i23] = d29 + d37;
                dArr[i25] = d30 + d38;
                dArr[i18] = d25 - d33;
                dArr[i27] = d26 - d34;
                dArr[i29] = d29 - d37;
                dArr[i31] = d30 - d38;
                double d41 = d27 - d36;
                double d42 = d28 + d35;
                dArr[i19] = (d17 * d41) - (d18 * d42);
                dArr[i22] = (d42 * d17) + (d41 * d18);
                double d43 = d31 - d40;
                double d44 = d32 + d39;
                dArr[i24] = (d21 * d43) - (d22 * d44);
                dArr[i26] = (d44 * d21) + (d43 * d22);
                double d45 = d27 + d36;
                double d46 = d28 - d35;
                dArr[i20] = (d19 * d45) + (d20 * d46);
                dArr[i28] = (d46 * d19) - (d45 * d20);
                double d47 = d31 + d40;
                double d48 = d32 - d39;
                dArr[i30] = (d23 * d47) + (d24 * d48);
                dArr[i32] = (d48 * d23) - (d47 * d24);
                int i33 = i4 - i11;
                int i34 = i33 + i4;
                int i35 = i34 + i4;
                int i36 = i35 + i4;
                double d49 = dArr[i33] + dArr[i35];
                int i37 = i33 + 1;
                int i38 = i35 + 1;
                double d50 = dArr[i37] + dArr[i38];
                double d51 = dArr[i33] - dArr[i35];
                double d52 = dArr[i37] - dArr[i38];
                int i39 = i33 - 2;
                int i40 = i35 - 2;
                double d53 = dArr[i39] + dArr[i40];
                int i41 = i33 - 1;
                int i42 = i35 - 1;
                double d54 = dArr[i41] + dArr[i42];
                double d55 = dArr[i39] - dArr[i40];
                double d56 = dArr[i41] - dArr[i42];
                double d57 = dArr[i34] + dArr[i36];
                int i43 = i34 + 1;
                int i44 = i36 + 1;
                double d58 = dArr[i43] + dArr[i44];
                double d59 = dArr[i34] - dArr[i36];
                double d60 = dArr[i43] - dArr[i44];
                int i45 = i34 - 2;
                int i46 = i36 - 2;
                double d61 = dArr[i45] + dArr[i46];
                int i47 = i34 - 1;
                int i48 = i36 - 1;
                double d62 = dArr[i47] + dArr[i48];
                double d63 = dArr[i45] - dArr[i46];
                double d64 = dArr[i47] - dArr[i48];
                dArr[i33] = d49 + d57;
                dArr[i37] = d50 + d58;
                dArr[i39] = d53 + d61;
                dArr[i41] = d54 + d62;
                dArr[i34] = d49 - d57;
                dArr[i43] = d50 - d58;
                dArr[i45] = d53 - d61;
                dArr[i47] = d54 - d62;
                double d65 = d51 - d60;
                double d66 = d52 + d59;
                dArr[i35] = (d18 * d65) - (d17 * d66);
                dArr[i38] = (d18 * d66) + (d17 * d65);
                double d67 = d55 - d64;
                double d68 = d56 + d63;
                dArr[i40] = (d22 * d67) - (d21 * d68);
                dArr[i42] = (d68 * d22) + (d67 * d21);
                double d69 = d51 + d60;
                double d70 = d52 - d59;
                dArr[i36] = (d20 * d69) + (d19 * d70);
                dArr[i44] = (d20 * d70) - (d19 * d69);
                double d71 = d55 + d64;
                double d72 = d56 - d63;
                dArr[i46] = (d24 * d71) + (d23 * d72);
                dArr[i48] = (d72 * d24) - (d71 * d23);
                i11 += 4;
                d16 = d24;
                d15 = d23;
                d14 = d21;
                d13 = d22;
                i7 = i13;
            } else {
                double d73 = (d14 + d10) * d11;
                double d74 = d11 * (d13 + d10);
                double d75 = (d15 - d10) * d12;
                double d76 = d12 * (d16 - d10);
                int i49 = i3 + i4;
                int i50 = i49 + i4;
                int i51 = i4 + i50;
                int i52 = i50 - 2;
                double d77 = dArr[i12] + dArr[i52];
                int i53 = i3 - 1;
                int i54 = i50 - 1;
                double d78 = dArr[i53] + dArr[i54];
                double d79 = dArr[i12] - dArr[i52];
                double d80 = dArr[i53] - dArr[i54];
                int i55 = i49 - 2;
                int i56 = i51 - 2;
                double d81 = dArr[i55] + dArr[i56];
                int i57 = i49 - 1;
                int i58 = i51 - 1;
                double d82 = dArr[i57] + dArr[i58];
                double d83 = dArr[i55] - dArr[i56];
                double d84 = dArr[i57] - dArr[i58];
                dArr[i12] = d77 + d81;
                dArr[i53] = d78 + d82;
                dArr[i55] = d77 - d81;
                dArr[i57] = d78 - d82;
                double d85 = d79 - d84;
                double d86 = d80 + d83;
                dArr[i52] = (d73 * d85) - (d74 * d86);
                dArr[i54] = (d86 * d73) + (d85 * d74);
                double d87 = d79 + d84;
                double d88 = d80 - d83;
                dArr[i56] = (d75 * d87) + (d76 * d88);
                dArr[i58] = (d88 * d75) - (d87 * d76);
                double d89 = dArr[i3] + dArr[i50];
                int i59 = i3 + 1;
                int i60 = i50 + 1;
                double d90 = dArr[i59] + dArr[i60];
                double d91 = dArr[i3] - dArr[i50];
                double d92 = dArr[i59] - dArr[i60];
                double d93 = dArr[i49] + dArr[i51];
                int i61 = i49 + 1;
                int i62 = i51 + 1;
                double d94 = dArr[i61] + dArr[i62];
                double d95 = dArr[i49] - dArr[i51];
                double d96 = dArr[i61] - dArr[i62];
                dArr[i3] = d89 + d93;
                dArr[i59] = d90 + d94;
                dArr[i49] = d89 - d93;
                dArr[i61] = d90 - d94;
                double d97 = d91 - d96;
                double d98 = d92 + d95;
                dArr[i50] = (d97 - d98) * d10;
                dArr[i60] = d10 * (d98 + d97);
                double d99 = d91 + d96;
                double d100 = d92 - d95;
                double d101 = -d10;
                dArr[i51] = (d99 + d100) * d101;
                dArr[i62] = d101 * (d100 - d99);
                int i63 = i3 + 2;
                int i64 = i50 + 2;
                double d102 = dArr[i63] + dArr[i64];
                int i65 = i3 + 3;
                int i66 = i50 + 3;
                double d103 = dArr[i65] + dArr[i66];
                double d104 = dArr[i63] - dArr[i64];
                double d105 = dArr[i65] - dArr[i66];
                int i67 = i49 + 2;
                int i68 = i51 + 2;
                double d106 = dArr[i67] + dArr[i68];
                int i69 = i49 + 3;
                int i70 = i51 + 3;
                double d107 = dArr[i69] + dArr[i70];
                double d108 = dArr[i67] - dArr[i68];
                double d109 = dArr[i69] - dArr[i70];
                dArr[i63] = d102 + d106;
                dArr[i65] = d103 + d107;
                dArr[i67] = d102 - d106;
                dArr[i69] = d103 - d107;
                double d110 = d104 - d109;
                double d111 = d105 + d108;
                dArr[i64] = (d74 * d110) - (d73 * d111);
                dArr[i66] = (d74 * d111) + (d73 * d110);
                double d112 = d104 + d109;
                double d113 = d105 - d108;
                dArr[i68] = (d76 * d112) + (d75 * d113);
                dArr[i70] = (d76 * d113) - (d75 * d112);
                return;
            }
        }
    }

    public final void r(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            q(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                w(i4, dArr, 0, i3, dArr2);
                x(i4, dArr, i4, i3, dArr2);
                w(i4, dArr, i4 * 2, i3, dArr2);
                w(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                j(i, dArr, 0, i3, dArr2);
            } else {
                s(i, dArr, 0, i3, dArr2);
            }
            a(i, iArr, i2, dArr);
        } else if (i > 8) {
            if (i == 32) {
                o(dArr, 0, dArr2, i3 - 8);
                d(dArr);
                return;
            }
            m(dArr, 0, dArr2, 0);
            b(dArr);
        } else if (i == 8) {
            l(dArr);
        } else if (i == 4) {
            y(dArr);
        }
    }

    public final void s(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i == 128) {
            int i4 = i3 - 8;
            o(dArr, i2, dArr2, i4);
            p(dArr, i2 + 32, dArr2, i3 - 32);
            o(dArr, i2 + 64, dArr2, i4);
            o(dArr, i2 + 96, dArr2, i4);
            return;
        }
        int i5 = i3 - 16;
        m(dArr, i2, dArr2, i5);
        n(dArr, i2 + 16, dArr2, i5);
        m(dArr, i2 + 32, dArr2, i5);
        m(dArr, i2 + 48, dArr2, i5);
    }

    public final void t(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i == 128) {
            int i4 = i3 - 8;
            o(dArr, i2, dArr2, i4);
            int i5 = i3 - 32;
            p(dArr, i2 + 32, dArr2, i5);
            o(dArr, i2 + 64, dArr2, i4);
            p(dArr, i2 + 96, dArr2, i5);
            return;
        }
        int i6 = i3 - 16;
        m(dArr, i2, dArr2, i6);
        n(dArr, i2 + 16, dArr2, i6);
        m(dArr, i2 + 32, dArr2, i6);
        n(dArr, i2 + 48, dArr2, i6);
    }

    public final void u(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + 0;
        int i9 = i2 + i6;
        double d2 = dArr[i8] + dArr[i9];
        int i10 = i2 + 1;
        int i11 = i9 + 1;
        double d3 = dArr[i10] + dArr[i11];
        double d4 = dArr[i8] - dArr[i9];
        double d5 = dArr[i10] - dArr[i11];
        int i12 = i2 + i5;
        int i13 = i2 + i7;
        double d6 = dArr[i12] + dArr[i13];
        int i14 = i12 + 1;
        int i15 = i13 + 1;
        double d7 = dArr[i14] + dArr[i15];
        double d8 = dArr[i12] - dArr[i13];
        double d9 = dArr[i14] - dArr[i15];
        dArr[i8] = d2 + d6;
        dArr[i10] = d3 + d7;
        dArr[i12] = d2 - d6;
        dArr[i14] = d3 - d7;
        dArr[i9] = d4 - d9;
        dArr[i11] = d5 + d8;
        dArr[i13] = d4 + d9;
        dArr[i15] = d5 - d8;
        double d10 = dArr2[i3 + 1];
        int i16 = 0;
        for (int i17 = 2; i17 < i4; i17 += 2) {
            i16 += 4;
            int i18 = i3 + i16;
            double d11 = dArr2[i18];
            double d12 = dArr2[i18 + 1];
            double d13 = dArr2[i18 + 2];
            double d14 = -dArr2[i18 + 3];
            int i19 = i17 + i5;
            int i20 = i19 + i5;
            int i21 = i20 + i5;
            int i22 = i2 + i17;
            int i23 = i2 + i20;
            double d15 = dArr[i22] + dArr[i23];
            int i24 = i22 + 1;
            int i25 = i23 + 1;
            double d16 = dArr[i24] + dArr[i25];
            double d17 = dArr[i22] - dArr[i23];
            double d18 = dArr[i24] - dArr[i25];
            int i26 = i2 + i19;
            int i27 = i2 + i21;
            double d19 = dArr[i26] + dArr[i27];
            int i28 = i26 + 1;
            int i29 = i27 + 1;
            double d20 = dArr[i28] + dArr[i29];
            double d21 = dArr[i26] - dArr[i27];
            double d22 = dArr[i28] - dArr[i29];
            dArr[i22] = d15 + d19;
            dArr[i24] = d16 + d20;
            dArr[i26] = d15 - d19;
            dArr[i28] = d16 - d20;
            double d23 = d17 - d22;
            double d24 = d18 + d21;
            dArr[i23] = (d11 * d23) - (d12 * d24);
            dArr[i25] = (d24 * d11) + (d23 * d12);
            double d25 = d17 + d22;
            double d26 = d18 - d21;
            dArr[i27] = (d13 * d25) + (d14 * d26);
            dArr[i29] = (d26 * d13) - (d25 * d14);
            int i30 = i5 - i17;
            int i31 = i30 + i5;
            int i32 = i31 + i5;
            int i33 = i32 + i5;
            int i34 = i2 + i30;
            int i35 = i2 + i32;
            double d27 = dArr[i34] + dArr[i35];
            int i36 = i34 + 1;
            int i37 = i35 + 1;
            double d28 = dArr[i36] + dArr[i37];
            double d29 = dArr[i34] - dArr[i35];
            double d30 = dArr[i36] - dArr[i37];
            int i38 = i2 + i31;
            int i39 = i2 + i33;
            double d31 = dArr[i38] + dArr[i39];
            int i40 = i38 + 1;
            int i41 = i39 + 1;
            double d32 = dArr[i40] + dArr[i41];
            double d33 = dArr[i38] - dArr[i39];
            double d34 = dArr[i40] - dArr[i41];
            dArr[i34] = d27 + d31;
            dArr[i36] = d28 + d32;
            dArr[i38] = d27 - d31;
            dArr[i40] = d28 - d32;
            double d35 = d29 - d34;
            double d36 = d30 + d33;
            dArr[i35] = (d12 * d35) - (d11 * d36);
            dArr[i37] = (d12 * d36) + (d11 * d35);
            double d37 = d29 + d34;
            double d38 = d30 - d33;
            dArr[i39] = (d14 * d37) + (d13 * d38);
            dArr[i41] = (d14 * d38) - (d13 * d37);
        }
        int i42 = i4 + i5;
        int i43 = i42 + i5;
        int i44 = i5 + i43;
        int i45 = i2 + i4;
        int i46 = i2 + i43;
        double d39 = dArr[i45] + dArr[i46];
        int i47 = i45 + 1;
        int i48 = i46 + 1;
        double d40 = dArr[i47] + dArr[i48];
        double d41 = dArr[i45] - dArr[i46];
        double d42 = dArr[i47] - dArr[i48];
        int i49 = i2 + i42;
        int i50 = i2 + i44;
        double d43 = dArr[i49] + dArr[i50];
        int i51 = i49 + 1;
        int i52 = i50 + 1;
        double d44 = dArr[i51] + dArr[i52];
        double d45 = dArr[i49] - dArr[i50];
        double d46 = dArr[i51] - dArr[i52];
        dArr[i45] = d39 + d43;
        dArr[i47] = d40 + d44;
        dArr[i49] = d39 - d43;
        dArr[i51] = d40 - d44;
        double d47 = d41 - d46;
        double d48 = d42 + d45;
        dArr[i46] = (d47 - d48) * d10;
        dArr[i48] = (d48 + d47) * d10;
        double d49 = d41 + d46;
        double d50 = d42 - d45;
        double d51 = -d10;
        dArr[i50] = (d49 + d50) * d51;
        dArr[i52] = d51 * (d50 - d49);
    }

    public final void v(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        double d2 = dArr2[i3 + 1];
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + 0;
        int i9 = i2 + i6;
        int i10 = i9 + 1;
        double d3 = dArr[i8] - dArr[i10];
        int i11 = i2 + 1;
        double d4 = dArr[i11] + dArr[i9];
        double d5 = dArr[i8] + dArr[i10];
        double d6 = dArr[i11] - dArr[i9];
        int i12 = i2 + i5;
        int i13 = i2 + i7;
        int i14 = i13 + 1;
        double d7 = dArr[i12] - dArr[i14];
        int i15 = i12 + 1;
        double d8 = dArr[i15] + dArr[i13];
        double d9 = dArr[i12] + dArr[i14];
        double d10 = dArr[i15] - dArr[i13];
        double d11 = (d7 - d8) * d2;
        double d12 = (d8 + d7) * d2;
        dArr[i8] = d3 + d11;
        dArr[i11] = d4 + d12;
        dArr[i12] = d3 - d11;
        dArr[i15] = d4 - d12;
        double d13 = (d9 - d10) * d2;
        double d14 = d2 * (d10 + d9);
        dArr[i9] = d5 - d14;
        dArr[i10] = d6 + d13;
        dArr[i13] = d5 + d14;
        dArr[i14] = d6 - d13;
        int i16 = i5 * 2;
        int i17 = 0;
        int i18 = 2;
        while (i18 < i4) {
            int i19 = i17 + 4;
            int i20 = i3 + i19;
            double d15 = dArr2[i20];
            double d16 = dArr2[i20 + 1];
            double d17 = dArr2[i20 + 2];
            double d18 = -dArr2[i20 + 3];
            int i21 = i16 - 4;
            int i22 = i3 + i21;
            double d19 = dArr2[i22];
            double d20 = dArr2[i22 + 1];
            double d21 = dArr2[i22 + 2];
            double d22 = -dArr2[i22 + 3];
            int i23 = i18 + i5;
            int i24 = i23 + i5;
            int i25 = i24 + i5;
            int i26 = i2 + i18;
            int i27 = i2 + i24;
            int i28 = i27 + 1;
            double d23 = dArr[i26] - dArr[i28];
            int i29 = i26 + 1;
            double d24 = dArr[i29] + dArr[i27];
            double d25 = dArr[i26] + dArr[i28];
            double d26 = dArr[i29] - dArr[i27];
            int i30 = i2 + i23;
            int i31 = i2 + i25;
            int i32 = i31 + 1;
            double d27 = dArr[i30] - dArr[i32];
            int i33 = i30 + 1;
            double d28 = dArr[i33] + dArr[i31];
            double d29 = dArr[i30] + dArr[i32];
            double d30 = dArr[i33] - dArr[i31];
            double d31 = (d15 * d23) - (d16 * d24);
            double d32 = (d24 * d15) + (d23 * d16);
            double d33 = (d20 * d27) - (d19 * d28);
            double d34 = (d28 * d20) + (d27 * d19);
            dArr[i26] = d31 + d33;
            dArr[i29] = d32 + d34;
            dArr[i30] = d31 - d33;
            dArr[i33] = d32 - d34;
            double d35 = (d17 * d25) + (d18 * d26);
            double d36 = (d26 * d17) - (d25 * d18);
            double d37 = (d22 * d29) + (d21 * d30);
            double d38 = (d30 * d22) - (d29 * d21);
            dArr[i27] = d35 + d37;
            dArr[i28] = d36 + d38;
            dArr[i31] = d35 - d37;
            dArr[i32] = d36 - d38;
            int i34 = i5 - i18;
            int i35 = i34 + i5;
            int i36 = i35 + i5;
            int i37 = i36 + i5;
            int i38 = i2 + i34;
            int i39 = i2 + i36;
            int i40 = i39 + 1;
            double d39 = dArr[i38] - dArr[i40];
            int i41 = i38 + 1;
            double d40 = dArr[i41] + dArr[i39];
            double d41 = dArr[i38] + dArr[i40];
            double d42 = dArr[i41] - dArr[i39];
            int i42 = i2 + i35;
            int i43 = i2 + i37;
            int i44 = i43 + 1;
            double d43 = dArr[i42] - dArr[i44];
            int i45 = i42 + 1;
            double d44 = dArr[i45] + dArr[i43];
            double d45 = dArr[i42] + dArr[i44];
            double d46 = dArr[i45] - dArr[i43];
            double d47 = (d19 * d39) - (d20 * d40);
            double d48 = (d19 * d40) + (d20 * d39);
            double d49 = (d16 * d43) - (d15 * d44);
            double d50 = (d16 * d44) + (d15 * d43);
            dArr[i38] = d47 + d49;
            dArr[i41] = d48 + d50;
            dArr[i42] = d47 - d49;
            dArr[i45] = d48 - d50;
            double d51 = (d21 * d41) + (d22 * d42);
            double d52 = (d21 * d42) - (d22 * d41);
            double d53 = (d18 * d45) + (d17 * d46);
            double d54 = (d18 * d46) - (d17 * d45);
            dArr[i39] = d51 + d53;
            dArr[i40] = d52 + d54;
            dArr[i43] = d51 - d53;
            dArr[i44] = d52 - d54;
            i18 += 2;
            i17 = i19;
            i16 = i21;
        }
        int i46 = i3 + i5;
        double d55 = dArr2[i46];
        double d56 = dArr2[i46 + 1];
        int i47 = i4 + i5;
        int i48 = i47 + i5;
        int i49 = i5 + i48;
        int i50 = i2 + i4;
        int i51 = i2 + i48;
        int i52 = i51 + 1;
        double d57 = dArr[i50] - dArr[i52];
        int i53 = i50 + 1;
        double d58 = dArr[i53] + dArr[i51];
        double d59 = dArr[i50] + dArr[i52];
        double d60 = dArr[i53] - dArr[i51];
        int i54 = i2 + i47;
        int i55 = i2 + i49;
        int i56 = i55 + 1;
        double d61 = dArr[i54] - dArr[i56];
        int i57 = i54 + 1;
        double d62 = dArr[i57] + dArr[i55];
        double d63 = dArr[i54] + dArr[i56];
        double d64 = dArr[i57] - dArr[i55];
        double d65 = (d55 * d57) - (d56 * d58);
        double d66 = (d58 * d55) + (d57 * d56);
        double d67 = (d56 * d61) - (d55 * d62);
        double d68 = (d62 * d56) + (d61 * d55);
        dArr[i50] = d65 + d67;
        dArr[i53] = d66 + d68;
        dArr[i54] = d65 - d67;
        dArr[i57] = d66 - d68;
        double d69 = (d56 * d59) - (d55 * d60);
        double d70 = (d60 * d56) + (d59 * d55);
        double d71 = (d55 * d63) - (d56 * d64);
        double d72 = (d55 * d64) + (d56 * d63);
        dArr[i51] = d69 - d71;
        dArr[i52] = d70 - d72;
        dArr[i55] = d69 + d71;
        dArr[i56] = d70 + d72;
    }

    public final void w(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        int i5 = i4 * 2;
        u(i, dArr, i2, dArr2, i3 - i5);
        if (i > 512) {
            w(i4, dArr, i2, i3, dArr2);
            x(i4, dArr, i2 + i4, i3, dArr2);
            w(i4, dArr, i2 + i5, i3, dArr2);
            w(i4, dArr, i2 + (i4 * 3), i3, dArr2);
            return;
        }
        j(i, dArr, i2, i3, dArr2);
    }

    public final void x(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        v(i, dArr, i2, dArr2, i3 - i);
        if (i > 512) {
            w(i4, dArr, i2, i3, dArr2);
            x(i4, dArr, i2 + i4, i3, dArr2);
            w(i4, dArr, i2 + (i4 * 2), i3, dArr2);
            x(i4, dArr, i2 + (i4 * 3), i3, dArr2);
            return;
        }
        k(i, dArr, i2, i3, dArr2);
    }

    public final void y(double[] dArr) {
        double d2 = dArr[1] - dArr[3];
        dArr[0] = dArr[0] + dArr[2];
        dArr[1] = dArr[1] + dArr[3];
        dArr[2] = dArr[0] - dArr[2];
        dArr[3] = d2;
    }

    public final void z(int i, int[] iArr, double[] dArr, int i2) {
        iArr[1] = i;
        if (i > 1) {
            int i3 = i >> 1;
            double d2 = i3;
            Double.isNaN(d2);
            double d3 = 0.7853981633974483d / d2;
            int i4 = i2 + 0;
            Double.isNaN(d2);
            dArr[i4] = Math.cos(d2 * d3);
            dArr[i2 + i3] = dArr[i4] * 0.5d;
            for (int i5 = 1; i5 < i3; i5++) {
                double d4 = i5;
                Double.isNaN(d4);
                double d5 = d4 * d3;
                dArr[i2 + i5] = Math.cos(d5) * 0.5d;
                dArr[(i2 + i) - i5] = Math.sin(d5) * 0.5d;
            }
        }
    }
}
