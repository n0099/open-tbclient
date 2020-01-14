package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class d {
    private static final int[] nJL = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] nJM = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] nJN = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] nJO = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    private static int h(a aVar) {
        if (a.a(aVar, 1) != 0) {
            int a = a.a(aVar, 3);
            if (a == 0) {
                return 1;
            }
            return (1 << a) + a.a(aVar, a);
        }
        return 0;
    }

    private static void a(a aVar, j jVar) {
        jVar.nKk = a.a(aVar, 1) == 1;
        jVar.nKj = 0;
        jVar.nKl = false;
        jVar.nKm = false;
        if (!jVar.nKk || a.a(aVar, 1) == 0) {
            int a = a.a(aVar, 2) + 4;
            if (a == 7) {
                jVar.nKm = true;
                if (a.a(aVar, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int a2 = a.a(aVar, 2);
                if (a2 != 0) {
                    for (int i = 0; i < a2; i++) {
                        int a3 = a.a(aVar, 8);
                        if (a3 == 0 && i + 1 == a2 && a2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        jVar.nKj = (a3 << (i * 8)) | jVar.nKj;
                    }
                } else {
                    return;
                }
            } else {
                for (int i2 = 0; i2 < a; i2++) {
                    int a4 = a.a(aVar, 4);
                    if (a4 == 0 && i2 + 1 == a && a > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.nKj = (a4 << (i2 * 4)) | jVar.nKj;
                }
            }
            jVar.nKj++;
            if (!jVar.nKk) {
                jVar.nKl = a.a(aVar, 1) == 1;
            }
        }
    }

    private static int a(int[] iArr, int i, a aVar) {
        int i2 = (int) (aVar.nJE >>> aVar.bitOffset);
        int i3 = i + (i2 & 255);
        int i4 = iArr[i3] >> 16;
        int i5 = iArr[i3] & 65535;
        if (i4 <= 8) {
            aVar.bitOffset += i4;
            return i5;
        }
        int i6 = i5 + i3 + ((i2 & ((1 << i4) - 1)) >>> 8);
        aVar.bitOffset += (iArr[i6] >> 16) + 8;
        return iArr[i6] & 65535;
    }

    private static int b(int[] iArr, int i, a aVar) {
        a.b(aVar);
        int a = a(iArr, i, aVar);
        return i.nJV[a] + a.a(aVar, i.nJW[a]);
    }

    private static int a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(nJM[i] + i2) & 3] + nJN[i] : (i - 16) + 1;
    }

    private static void d(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static void H(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                d(iArr, i4);
            }
        }
    }

    private static void a(int[] iArr, int i, int[] iArr2, a aVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 32768;
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        while (i7 < i && i11 > 0) {
            a.a(aVar);
            a.b(aVar);
            int i12 = ((int) (aVar.nJE >>> aVar.bitOffset)) & 31;
            aVar.bitOffset += iArr3[i12] >> 16;
            int i13 = 65535 & iArr3[i12];
            if (i13 < 16) {
                int i14 = i7 + 1;
                iArr2[i7] = i13;
                if (i13 == 0) {
                    i3 = i11;
                    i5 = i14;
                    i4 = 0;
                    i6 = i8;
                } else {
                    i3 = i11 - (32768 >> i13);
                    i4 = 0;
                    i6 = i13;
                    i5 = i14;
                }
            } else {
                int i15 = i13 - 14;
                int i16 = i13 == 16 ? i8 : 0;
                if (i10 != i16) {
                    i2 = 0;
                } else {
                    i16 = i10;
                    i2 = i9;
                }
                int a = a.a(aVar, i15) + 3 + (i2 > 0 ? (i2 - 2) << i15 : i2);
                int i17 = a - i2;
                if (i7 + i17 > i) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i18 = 0;
                int i19 = i7;
                while (i18 < i17) {
                    iArr2[i19] = i16;
                    i18++;
                    i19++;
                }
                if (i16 != 0) {
                    i3 = i11 - (i17 << (15 - i16));
                    i4 = a;
                    i5 = i19;
                    i10 = i16;
                    i6 = i8;
                } else {
                    i3 = i11;
                    i4 = a;
                    i5 = i19;
                    i10 = i16;
                    i6 = i8;
                }
            }
            i8 = i6;
            i7 = i5;
            int i20 = i3;
            i9 = i4;
            i11 = i20;
        }
        if (i11 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        l.e(iArr2, i7, i - i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int[] iArr, int i2, a aVar) {
        int a;
        boolean z = true;
        a.a(aVar);
        int[] iArr2 = new int[i];
        if (a.a(aVar, 2) == 1) {
            int[] iArr3 = new int[4];
            int a2 = a.a(aVar, 2) + 1;
            int i3 = 0;
            for (int i4 = i - 1; i4 != 0; i4 >>= 1) {
                i3++;
            }
            for (int i5 = 0; i5 < a2; i5++) {
                iArr3[i5] = a.a(aVar, i3) % i;
                iArr2[iArr3[i5]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            switch (a2) {
                case 1:
                    break;
                case 2:
                    r0 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                    z = r0;
                    break;
                case 3:
                    if (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[1] == iArr3[2]) {
                        z = false;
                        break;
                    }
                    break;
                default:
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (a.a(aVar, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                        z = z2;
                        break;
                    } else {
                        iArr2[iArr3[0]] = 2;
                        z = z2;
                        break;
                    }
                    break;
            }
        } else {
            int[] iArr4 = new int[18];
            int i6 = 32;
            int i7 = 0;
            for (int i8 = a; i8 < 18 && i6 > 0; i8++) {
                int i9 = nJL[i8];
                a.b(aVar);
                int i10 = ((int) (aVar.nJE >>> aVar.bitOffset)) & 15;
                aVar.bitOffset += nJO[i10] >> 16;
                int i11 = nJO[i10] & 65535;
                iArr4[i9] = i11;
                if (i11 != 0) {
                    i6 -= 32 >> i11;
                    i7++;
                }
            }
            r0 = (i7 == 1 || i6 == 0) ? true : true;
            a(iArr4, i, iArr2, aVar);
            z = r0;
        }
        if (!z) {
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        f.a(iArr, i2, 8, iArr2, i);
    }

    private static int a(int i, byte[] bArr, a aVar) {
        int i2;
        a.a(aVar);
        int h = h(aVar) + 1;
        if (h == 1) {
            l.G(bArr, 0, i);
            return h;
        }
        int a = a.a(aVar, 1) == 1 ? a.a(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        a(h + a, iArr, 0, aVar);
        int i3 = 0;
        while (i3 < i) {
            a.a(aVar);
            a.b(aVar);
            int a2 = a(iArr, 0, aVar);
            if (a2 == 0) {
                bArr[i3] = 0;
                i2 = i3 + 1;
            } else if (a2 <= a) {
                int a3 = a.a(aVar, a2) + (1 << a2);
                i2 = i3;
                int i4 = a3;
                while (i4 != 0) {
                    if (i2 >= i) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i2] = 0;
                    i4--;
                    i2++;
                }
                continue;
            } else {
                bArr[i3] = (byte) (a2 - a);
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        if (a.a(aVar, 1) == 1) {
            H(bArr, i);
        }
        return h;
    }

    private static void a(j jVar, int i) {
        int i2;
        a aVar = jVar.nKf;
        int[] iArr = jVar.nKs;
        int i3 = i * 2;
        a.b(aVar);
        int a = a(jVar.nKh, i * 1080, aVar);
        jVar.nKq[i] = b(jVar.nKi, i * 1080, aVar);
        if (a == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (a == 0) {
            i2 = iArr[i3];
        } else {
            i2 = a - 2;
        }
        if (i2 >= jVar.nKr[i]) {
            i2 -= jVar.nKr[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    private static void a(j jVar) {
        a(jVar, 0);
        int i = jVar.nKs[1];
        jVar.nKB = i << 6;
        jVar.nKw = jVar.nKA[jVar.nKB] & 255;
        jVar.nKx = jVar.nKn.nJU[jVar.nKw];
        byte b = jVar.nKz[i];
        jVar.nKD = c.nJK[b];
        jVar.nKE = c.nJK[b + 1];
    }

    private static void b(j jVar) {
        a(jVar, 1);
        jVar.nKF = jVar.nKo.nJU[jVar.nKs[3]];
    }

    private static void c(j jVar) {
        a(jVar, 2);
        jVar.nKC = jVar.nKs[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r8.nKO >= 16384) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(j jVar) {
        int i;
        int i2;
        int i3 = 16384;
        int i4 = jVar.nKO;
        if (i4 > jVar.nKQ) {
            while ((i4 >> 1) > ((int) jVar.nKQ) + jVar.nKR.length) {
                i4 >>= 1;
            }
            if (!jVar.nKk) {
                if (i4 < 16384) {
                }
            }
        }
        i3 = i4;
        if (i3 > jVar.nKP) {
            byte[] bArr = new byte[i3 + 37];
            if (jVar.nKg != null) {
                System.arraycopy(jVar.nKg, 0, bArr, 0, jVar.nKP);
            } else if (jVar.nKR.length != 0) {
                int length = jVar.nKR.length;
                if (length > jVar.nKN) {
                    i2 = length - jVar.nKN;
                    i = jVar.nKN;
                } else {
                    i = length;
                    i2 = 0;
                }
                System.arraycopy(jVar.nKR, i2, bArr, 0, i);
                jVar.pos = i;
                jVar.nKS = i;
            }
            jVar.nKg = bArr;
            jVar.nKP = i3;
        }
    }

    private static void e(j jVar) {
        a aVar = jVar.nKf;
        if (jVar.nKk) {
            jVar.nKe = 10;
            jVar.nKW = jVar.pos;
            jVar.nmI = 0;
            jVar.nKd = 12;
            return;
        }
        jVar.nKn.nJT = null;
        jVar.nKn.nJU = null;
        jVar.nKo.nJT = null;
        jVar.nKo.nJU = null;
        jVar.nKp.nJT = null;
        jVar.nKp.nJU = null;
        a.a(aVar);
        a(aVar, jVar);
        if (jVar.nKj != 0 || jVar.nKm) {
            if (jVar.nKl || jVar.nKm) {
                a.f(aVar);
                jVar.nKd = jVar.nKm ? 4 : 5;
            } else {
                jVar.nKd = 2;
            }
            if (!jVar.nKm) {
                jVar.nKQ += jVar.nKj;
                if (jVar.nKP < jVar.nKO) {
                    d(jVar);
                }
            }
        }
    }

    private static void f(j jVar) {
        a aVar = jVar.nKf;
        for (int i = 0; i < 3; i++) {
            jVar.nKr[i] = h(aVar) + 1;
            jVar.nKq[i] = 268435456;
            if (jVar.nKr[i] > 1) {
                a(jVar.nKr[i] + 2, jVar.nKh, i * 1080, aVar);
                a(26, jVar.nKi, i * 1080, aVar);
                jVar.nKq[i] = b(jVar.nKi, i * 1080, aVar);
            }
        }
        a.a(aVar);
        jVar.nKK = a.a(aVar, 2);
        jVar.nKI = (a.a(aVar, 4) << jVar.nKK) + 16;
        jVar.nKJ = (1 << jVar.nKK) - 1;
        int i2 = (48 << jVar.nKK) + jVar.nKI;
        jVar.nKz = new byte[jVar.nKr[0]];
        int i3 = 0;
        while (i3 < jVar.nKr[0]) {
            int min = Math.min(i3 + 96, jVar.nKr[0]);
            while (i3 < min) {
                jVar.nKz[i3] = (byte) (a.a(aVar, 2) << 1);
                i3++;
            }
            a.a(aVar);
        }
        jVar.nKA = new byte[jVar.nKr[0] << 6];
        int a = a(jVar.nKr[0] << 6, jVar.nKA, aVar);
        jVar.nKv = true;
        int i4 = 0;
        while (true) {
            if (i4 < (jVar.nKr[0] << 6)) {
                if (jVar.nKA[i4] == (i4 >> 6)) {
                    i4++;
                } else {
                    jVar.nKv = false;
                    break;
                }
            } else {
                break;
            }
        }
        jVar.nKH = new byte[jVar.nKr[2] << 2];
        int a2 = a(jVar.nKr[2] << 2, jVar.nKH, aVar);
        g.a(jVar.nKn, 256, a);
        g.a(jVar.nKo, 704, jVar.nKr[1]);
        g.a(jVar.nKp, i2, a2);
        g.a(jVar.nKn, aVar);
        g.a(jVar.nKo, aVar);
        g.a(jVar.nKp, aVar);
        jVar.nKB = 0;
        jVar.nKC = 0;
        jVar.nKD = c.nJK[jVar.nKz[0]];
        jVar.nKE = c.nJK[jVar.nKz[0] + 1];
        jVar.nKw = 0;
        jVar.nKx = jVar.nKn.nJU[0];
        jVar.nKF = jVar.nKo.nJU[0];
        int[] iArr = jVar.nKs;
        int[] iArr2 = jVar.nKs;
        jVar.nKs[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = jVar.nKs;
        int[] iArr4 = jVar.nKs;
        jVar.nKs[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void g(j jVar) {
        a aVar = jVar.nKf;
        byte[] bArr = jVar.nKg;
        if (jVar.nKj <= 0) {
            a.d(aVar);
            jVar.nKd = 1;
            return;
        }
        int min = Math.min(jVar.nKP - jVar.pos, jVar.nKj);
        a.a(aVar, bArr, jVar.pos, min);
        jVar.nKj -= min;
        jVar.pos += min;
        if (jVar.pos == jVar.nKP) {
            jVar.nKe = 5;
            jVar.nKW = jVar.nKP;
            jVar.nmI = 0;
            jVar.nKd = 12;
            return;
        }
        a.d(aVar);
        jVar.nKd = 1;
    }

    private static boolean h(j jVar) {
        if (jVar.nKS != 0) {
            jVar.nmI += jVar.nKS;
            jVar.nKS = 0;
        }
        int min = Math.min(jVar.nKU - jVar.nKV, jVar.nKW - jVar.nmI);
        if (min != 0) {
            System.arraycopy(jVar.nKg, jVar.nmI, jVar.output, jVar.nKT + jVar.nKV, min);
            jVar.nKV += min;
            jVar.nmI = min + jVar.nmI;
        }
        return jVar.nKV < jVar.nKU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.nKR = bArr;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0025 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0025 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da A[LOOP:1: B:35:0x00da->B:41:0x0114, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(org.brotli.dec.j r11) {
        /*
            int r0 = r11.nKd
            if (r0 != 0) goto Ld
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress until initialized"
            r0.<init>(r1)
            throw r0
        Ld:
            int r0 = r11.nKd
            r1 = 11
            if (r0 != r1) goto L1c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress after close"
            r0.<init>(r1)
            throw r0
        L1c:
            org.brotli.dec.a r7 = r11.nKf
            int r0 = r11.nKP
            int r1 = r0 + (-1)
            byte[] r0 = r11.nKg
            r6 = r1
        L25:
            int r1 = r11.nKd
            r2 = 10
            if (r1 == r2) goto L3d1
            int r1 = r11.nKd
            switch(r1) {
                case 1: goto L4c;
                case 2: goto L64;
                case 3: goto L6a;
                case 4: goto L398;
                case 5: goto L3b0;
                case 6: goto Ld6;
                case 7: goto L295;
                case 8: goto L388;
                case 9: goto L30b;
                case 10: goto L30;
                case 11: goto L30;
                case 12: goto L3b5;
                default: goto L30;
            }
        L30:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected state "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r11.nKd
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L4c:
            int r0 = r11.nKj
            if (r0 >= 0) goto L59
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L59:
            e(r11)
            int r0 = r11.nKP
            int r1 = r0 + (-1)
            byte[] r0 = r11.nKg
            r6 = r1
            goto L25
        L64:
            f(r11)
            r1 = 3
            r11.nKd = r1
        L6a:
            int r1 = r11.nKj
            if (r1 > 0) goto L72
            r1 = 1
            r11.nKd = r1
            goto L25
        L72:
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nKq
            r2 = 1
            r1 = r1[r2]
            if (r1 != 0) goto L7f
            b(r11)
        L7f:
            int[] r1 = r11.nKq
            r2 = 1
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.nKo
            int[] r1 = r1.nJT
            int r2 = r11.nKF
            int r2 = a(r1, r2, r7)
            int r1 = r2 >>> 6
            r3 = 0
            r11.nKG = r3
            r3 = 2
            if (r1 < r3) goto La2
            int r1 = r1 + (-2)
            r3 = -1
            r11.nKG = r3
        La2:
            int[] r3 = org.brotli.dec.i.nKb
            r3 = r3[r1]
            int r4 = r2 >>> 3
            r4 = r4 & 7
            int r3 = r3 + r4
            int[] r4 = org.brotli.dec.i.nKc
            r1 = r4[r1]
            r2 = r2 & 7
            int r1 = r1 + r2
            int[] r2 = org.brotli.dec.i.nJX
            r2 = r2[r3]
            int[] r4 = org.brotli.dec.i.nJY
            r3 = r4[r3]
            int r3 = org.brotli.dec.a.a(r7, r3)
            int r2 = r2 + r3
            r11.nKy = r2
            int[] r2 = org.brotli.dec.i.nJZ
            r2 = r2[r1]
            int[] r3 = org.brotli.dec.i.nKa
            r1 = r3[r1]
            int r1 = org.brotli.dec.a.a(r7, r1)
            int r1 = r1 + r2
            r11.nKL = r1
            r1 = 0
            r11.j = r1
            r1 = 6
            r11.nKd = r1
        Ld6:
            boolean r1 = r11.nKv
            if (r1 == 0) goto L139
        Lda:
            int r1 = r11.j
            int r2 = r11.nKy
            if (r1 >= r2) goto L124
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nKq
            r2 = 0
            r1 = r1[r2]
            if (r1 != 0) goto Led
            a(r11)
        Led:
            int[] r1 = r11.nKq
            r2 = 0
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            int r1 = r11.pos
            org.brotli.dec.g r2 = r11.nKn
            int[] r2 = r2.nJT
            int r3 = r11.nKx
            int r2 = a(r2, r3, r7)
            byte r2 = (byte) r2
            r0[r1] = r2
            int r1 = r11.j
            int r1 = r1 + 1
            r11.j = r1
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            if (r1 != r6) goto Lda
            r1 = 6
            r11.nKe = r1
            int r1 = r11.nKP
            r11.nKW = r1
            r1 = 0
            r11.nmI = r1
            r1 = 12
            r11.nKd = r1
        L124:
            int r1 = r11.nKd
            r2 = 6
            if (r1 != r2) goto L25
            int r1 = r11.nKj
            int r2 = r11.nKy
            int r1 = r1 - r2
            r11.nKj = r1
            int r1 = r11.nKj
            if (r1 > 0) goto L1b7
            r1 = 3
            r11.nKd = r1
            goto L25
        L139:
            int r1 = r11.pos
            int r1 = r1 + (-1)
            r1 = r1 & r6
            r1 = r0[r1]
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r11.pos
            int r1 = r1 + (-2)
            r1 = r1 & r6
            r1 = r0[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
        L14b:
            int r3 = r11.j
            int r4 = r11.nKy
            if (r3 >= r4) goto L124
            org.brotli.dec.a.a(r7)
            int[] r3 = r11.nKq
            r4 = 0
            r3 = r3[r4]
            if (r3 != 0) goto L15e
            a(r11)
        L15e:
            byte[] r3 = r11.nKA
            int r4 = r11.nKB
            int[] r5 = org.brotli.dec.c.nJJ
            int r8 = r11.nKD
            int r8 = r8 + r2
            r5 = r5[r8]
            int[] r8 = org.brotli.dec.c.nJJ
            int r9 = r11.nKE
            int r1 = r1 + r9
            r1 = r8[r1]
            r1 = r1 | r5
            int r1 = r1 + r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int[] r3 = r11.nKq
            r4 = 0
            r5 = r3[r4]
            int r5 = r5 + (-1)
            r3[r4] = r5
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r3 = r11.nKn
            int[] r3 = r3.nJT
            org.brotli.dec.g r4 = r11.nKn
            int[] r4 = r4.nJU
            r1 = r4[r1]
            int r1 = a(r3, r1, r7)
            int r3 = r11.pos
            byte r4 = (byte) r1
            r0[r3] = r4
            int r3 = r11.j
            int r3 = r3 + 1
            r11.j = r3
            int r3 = r11.pos
            int r4 = r3 + 1
            r11.pos = r4
            if (r3 != r6) goto L1b3
            r1 = 6
            r11.nKe = r1
            int r1 = r11.nKP
            r11.nKW = r1
            r1 = 0
            r11.nmI = r1
            r1 = 12
            r11.nKd = r1
            goto L124
        L1b3:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L14b
        L1b7:
            int r1 = r11.nKG
            if (r1 >= 0) goto L229
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nKq
            r2 = 2
            r1 = r1[r2]
            if (r1 != 0) goto L1c8
            c(r11)
        L1c8:
            int[] r1 = r11.nKq
            r2 = 2
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.nKp
            int[] r2 = r1.nJT
            org.brotli.dec.g r1 = r11.nKp
            int[] r3 = r1.nJU
            byte[] r4 = r11.nKH
            int r5 = r11.nKC
            int r1 = r11.nKL
            r8 = 4
            if (r1 <= r8) goto L242
            r1 = 3
        L1e6:
            int r1 = r1 + r5
            r1 = r4[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r3[r1]
            int r1 = a(r2, r1, r7)
            r11.nKG = r1
            int r1 = r11.nKG
            int r2 = r11.nKI
            if (r1 < r2) goto L229
            int r1 = r11.nKG
            int r2 = r11.nKI
            int r1 = r1 - r2
            r11.nKG = r1
            int r1 = r11.nKG
            int r2 = r11.nKJ
            r1 = r1 & r2
            int r2 = r11.nKG
            int r3 = r11.nKK
            int r2 = r2 >>> r3
            r11.nKG = r2
            int r2 = r11.nKG
            int r2 = r2 >>> 1
            int r2 = r2 + 1
            int r3 = r11.nKG
            r3 = r3 & 1
            int r3 = r3 + 2
            int r3 = r3 << r2
            int r3 = r3 + (-4)
            int r4 = r11.nKI
            int r1 = r1 + r4
            int r2 = org.brotli.dec.a.a(r7, r2)
            int r2 = r2 + r3
            int r3 = r11.nKK
            int r2 = r2 << r3
            int r1 = r1 + r2
            r11.nKG = r1
        L229:
            int r1 = r11.nKG
            int[] r2 = r11.nKt
            int r3 = r11.nKu
            int r1 = a(r1, r2, r3)
            r11.distance = r1
            int r1 = r11.distance
            if (r1 >= 0) goto L247
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Negative distance"
            r0.<init>(r1)
            throw r0
        L242:
            int r1 = r11.nKL
            int r1 = r1 + (-2)
            goto L1e6
        L247:
            int r1 = r11.eHm
            int r2 = r11.nKN
            if (r1 == r2) goto L267
            int r1 = r11.pos
            int r2 = r11.nKN
            if (r1 >= r2) goto L267
            int r1 = r11.pos
            r11.eHm = r1
        L257:
            int r1 = r11.pos
            r11.nKM = r1
            int r1 = r11.distance
            int r2 = r11.eHm
            if (r1 <= r2) goto L26c
            r1 = 9
            r11.nKd = r1
            goto L25
        L267:
            int r1 = r11.nKN
            r11.eHm = r1
            goto L257
        L26c:
            int r1 = r11.nKG
            if (r1 <= 0) goto L280
            int[] r1 = r11.nKt
            int r2 = r11.nKu
            r2 = r2 & 3
            int r3 = r11.distance
            r1[r2] = r3
            int r1 = r11.nKu
            int r1 = r1 + 1
            r11.nKu = r1
        L280:
            int r1 = r11.nKL
            int r2 = r11.nKj
            if (r1 <= r2) goto L28f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L28f:
            r1 = 0
            r11.j = r1
            r1 = 7
            r11.nKd = r1
        L295:
            int r1 = r11.pos
            int r2 = r11.distance
            int r1 = r1 - r2
            r3 = r1 & r6
            int r2 = r11.pos
            int r1 = r11.nKL
            int r4 = r11.j
            int r8 = r1 - r4
            int r1 = r3 + r8
            if (r1 >= r6) goto L2d6
            int r1 = r2 + r8
            if (r1 >= r6) goto L2d6
            r1 = 0
            r4 = r3
        L2ae:
            if (r1 >= r8) goto L2bd
            int r3 = r2 + 1
            int r5 = r4 + 1
            r4 = r0[r4]
            r0[r2] = r4
            int r1 = r1 + 1
            r2 = r3
            r4 = r5
            goto L2ae
        L2bd:
            int r1 = r11.j
            int r1 = r1 + r8
            r11.j = r1
            int r1 = r11.nKj
            int r1 = r1 - r8
            r11.nKj = r1
            int r1 = r11.pos
            int r1 = r1 + r8
            r11.pos = r1
        L2cc:
            int r1 = r11.nKd
            r2 = 7
            if (r1 != r2) goto L25
            r1 = 3
            r11.nKd = r1
            goto L25
        L2d6:
            int r1 = r11.j
            int r2 = r11.nKL
            if (r1 >= r2) goto L2cc
            int r1 = r11.pos
            int r2 = r11.pos
            int r3 = r11.distance
            int r2 = r2 - r3
            r2 = r2 & r6
            r2 = r0[r2]
            r0[r1] = r2
            int r1 = r11.nKj
            int r1 = r1 + (-1)
            r11.nKj = r1
            int r1 = r11.j
            int r1 = r1 + 1
            r11.j = r1
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            if (r1 != r6) goto L2d6
            r1 = 7
            r11.nKe = r1
            int r1 = r11.nKP
            r11.nKW = r1
            r1 = 0
            r11.nmI = r1
            r1 = 12
            r11.nKd = r1
            goto L2cc
        L30b:
            int r1 = r11.nKL
            r2 = 4
            if (r1 < r2) goto L37a
            int r1 = r11.nKL
            r2 = 24
            if (r1 > r2) goto L37a
            int[] r1 = org.brotli.dec.e.nJP
            int r2 = r11.nKL
            r1 = r1[r2]
            int r2 = r11.distance
            int r3 = r11.eHm
            int r2 = r2 - r3
            int r2 = r2 + (-1)
            int[] r3 = org.brotli.dec.e.nJQ
            int r4 = r11.nKL
            r3 = r3[r4]
            r4 = 1
            int r4 = r4 << r3
            int r4 = r4 + (-1)
            r4 = r4 & r2
            int r5 = r2 >>> r3
            int r2 = r11.nKL
            int r2 = r2 * r4
            int r3 = r1 + r2
            org.brotli.dec.k[] r1 = org.brotli.dec.k.nKY
            int r1 = r1.length
            if (r5 >= r1) goto L371
            int r1 = r11.nKM
            byte[] r2 = org.brotli.dec.e.getData()
            int r4 = r11.nKL
            org.brotli.dec.k[] r8 = org.brotli.dec.k.nKY
            r5 = r8[r5]
            int r1 = org.brotli.dec.k.a(r0, r1, r2, r3, r4, r5)
            int r2 = r11.nKM
            int r2 = r2 + r1
            r11.nKM = r2
            int r2 = r11.pos
            int r2 = r2 + r1
            r11.pos = r2
            int r2 = r11.nKj
            int r1 = r2 - r1
            r11.nKj = r1
            int r1 = r11.nKM
            int r2 = r11.nKP
            if (r1 < r2) goto L383
            r1 = 8
            r11.nKe = r1
            int r1 = r11.nKP
            r11.nKW = r1
            r1 = 0
            r11.nmI = r1
            r1 = 12
            r11.nKd = r1
            goto L25
        L371:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L37a:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L383:
            r1 = 3
            r11.nKd = r1
            goto L25
        L388:
            int r1 = r11.nKP
            r2 = 0
            int r3 = r11.nKM
            int r4 = r11.nKP
            int r3 = r3 - r4
            java.lang.System.arraycopy(r0, r1, r0, r2, r3)
            r1 = 3
            r11.nKd = r1
            goto L25
        L398:
            int r1 = r11.nKj
            if (r1 <= 0) goto L3ab
            org.brotli.dec.a.a(r7)
            r1 = 8
            org.brotli.dec.a.a(r7, r1)
            int r1 = r11.nKj
            int r1 = r1 + (-1)
            r11.nKj = r1
            goto L398
        L3ab:
            r1 = 1
            r11.nKd = r1
            goto L25
        L3b0:
            g(r11)
            goto L25
        L3b5:
            boolean r1 = h(r11)
            if (r1 != 0) goto L3bc
        L3bb:
            return
        L3bc:
            int r1 = r11.pos
            int r2 = r11.nKN
            if (r1 < r2) goto L3c6
            int r1 = r11.nKN
            r11.eHm = r1
        L3c6:
            int r1 = r11.pos
            r1 = r1 & r6
            r11.pos = r1
            int r1 = r11.nKe
            r11.nKd = r1
            goto L25
        L3d1:
            int r0 = r11.nKd
            r1 = 10
            if (r0 != r1) goto L3bb
            int r0 = r11.nKj
            if (r0 >= 0) goto L3e4
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L3e4:
            org.brotli.dec.a.f(r7)
            org.brotli.dec.a r0 = r11.nKf
            r1 = 1
            org.brotli.dec.a.a(r0, r1)
            goto L3bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }
}
