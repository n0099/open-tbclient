package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class d {
    private static final int[] nYd = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] nYe = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] nYf = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] nYg = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

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
        jVar.nYC = a.a(aVar, 1) == 1;
        jVar.nYB = 0;
        jVar.nYD = false;
        jVar.nYE = false;
        if (!jVar.nYC || a.a(aVar, 1) == 0) {
            int a = a.a(aVar, 2) + 4;
            if (a == 7) {
                jVar.nYE = true;
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
                        jVar.nYB = (a3 << (i * 8)) | jVar.nYB;
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
                    jVar.nYB = (a4 << (i2 * 4)) | jVar.nYB;
                }
            }
            jVar.nYB++;
            if (!jVar.nYC) {
                jVar.nYD = a.a(aVar, 1) == 1;
            }
        }
    }

    private static int a(int[] iArr, int i, a aVar) {
        int i2 = (int) (aVar.nXW >>> aVar.bitOffset);
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
        return i.nYn[a] + a.a(aVar, i.nYo[a]);
    }

    private static int a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(nYe[i] + i2) & 3] + nYf[i] : (i - 16) + 1;
    }

    private static void b(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static void x(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                b(iArr, i4);
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
            int i12 = ((int) (aVar.nXW >>> aVar.bitOffset)) & 31;
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
                int i9 = nYd[i8];
                a.b(aVar);
                int i10 = ((int) (aVar.nXW >>> aVar.bitOffset)) & 15;
                aVar.bitOffset += nYg[i10] >> 16;
                int i11 = nYg[i10] & 65535;
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
            l.w(bArr, 0, i);
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
            x(bArr, i);
        }
        return h;
    }

    private static void a(j jVar, int i) {
        int i2;
        a aVar = jVar.nYx;
        int[] iArr = jVar.nYK;
        int i3 = i * 2;
        a.b(aVar);
        int a = a(jVar.nYz, i * 1080, aVar);
        jVar.nYI[i] = b(jVar.nYA, i * 1080, aVar);
        if (a == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (a == 0) {
            i2 = iArr[i3];
        } else {
            i2 = a - 2;
        }
        if (i2 >= jVar.nYJ[i]) {
            i2 -= jVar.nYJ[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    private static void a(j jVar) {
        a(jVar, 0);
        int i = jVar.nYK[1];
        jVar.nYT = i << 6;
        jVar.nYO = jVar.nYS[jVar.nYT] & 255;
        jVar.nYP = jVar.nYF.nYm[jVar.nYO];
        byte b = jVar.nYR[i];
        jVar.nYV = c.nYc[b];
        jVar.nYW = c.nYc[b + 1];
    }

    private static void b(j jVar) {
        a(jVar, 1);
        jVar.nYX = jVar.nYG.nYm[jVar.nYK[3]];
    }

    private static void c(j jVar) {
        a(jVar, 2);
        jVar.nYU = jVar.nYK[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r8.nZg >= 16384) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(j jVar) {
        int i;
        int i2;
        int i3 = 16384;
        int i4 = jVar.nZg;
        if (i4 > jVar.nZi) {
            while ((i4 >> 1) > ((int) jVar.nZi) + jVar.nZj.length) {
                i4 >>= 1;
            }
            if (!jVar.nYC) {
                if (i4 < 16384) {
                }
            }
        }
        i3 = i4;
        if (i3 > jVar.nZh) {
            byte[] bArr = new byte[i3 + 37];
            if (jVar.nYy != null) {
                System.arraycopy(jVar.nYy, 0, bArr, 0, jVar.nZh);
            } else if (jVar.nZj.length != 0) {
                int length = jVar.nZj.length;
                if (length > jVar.nZf) {
                    i2 = length - jVar.nZf;
                    i = jVar.nZf;
                } else {
                    i = length;
                    i2 = 0;
                }
                System.arraycopy(jVar.nZj, i2, bArr, 0, i);
                jVar.pos = i;
                jVar.nZk = i;
            }
            jVar.nYy = bArr;
            jVar.nZh = i3;
        }
    }

    private static void e(j jVar) {
        a aVar = jVar.nYx;
        if (jVar.nYC) {
            jVar.nYw = 10;
            jVar.nZo = jVar.pos;
            jVar.nDb = 0;
            jVar.nYv = 12;
            return;
        }
        jVar.nYF.nYl = null;
        jVar.nYF.nYm = null;
        jVar.nYG.nYl = null;
        jVar.nYG.nYm = null;
        jVar.nYH.nYl = null;
        jVar.nYH.nYm = null;
        a.a(aVar);
        a(aVar, jVar);
        if (jVar.nYB != 0 || jVar.nYE) {
            if (jVar.nYD || jVar.nYE) {
                a.f(aVar);
                jVar.nYv = jVar.nYE ? 4 : 5;
            } else {
                jVar.nYv = 2;
            }
            if (!jVar.nYE) {
                jVar.nZi += jVar.nYB;
                if (jVar.nZh < jVar.nZg) {
                    d(jVar);
                }
            }
        }
    }

    private static void f(j jVar) {
        a aVar = jVar.nYx;
        for (int i = 0; i < 3; i++) {
            jVar.nYJ[i] = h(aVar) + 1;
            jVar.nYI[i] = 268435456;
            if (jVar.nYJ[i] > 1) {
                a(jVar.nYJ[i] + 2, jVar.nYz, i * 1080, aVar);
                a(26, jVar.nYA, i * 1080, aVar);
                jVar.nYI[i] = b(jVar.nYA, i * 1080, aVar);
            }
        }
        a.a(aVar);
        jVar.nZc = a.a(aVar, 2);
        jVar.nZa = (a.a(aVar, 4) << jVar.nZc) + 16;
        jVar.nZb = (1 << jVar.nZc) - 1;
        int i2 = (48 << jVar.nZc) + jVar.nZa;
        jVar.nYR = new byte[jVar.nYJ[0]];
        int i3 = 0;
        while (i3 < jVar.nYJ[0]) {
            int min = Math.min(i3 + 96, jVar.nYJ[0]);
            while (i3 < min) {
                jVar.nYR[i3] = (byte) (a.a(aVar, 2) << 1);
                i3++;
            }
            a.a(aVar);
        }
        jVar.nYS = new byte[jVar.nYJ[0] << 6];
        int a = a(jVar.nYJ[0] << 6, jVar.nYS, aVar);
        jVar.nYN = true;
        int i4 = 0;
        while (true) {
            if (i4 < (jVar.nYJ[0] << 6)) {
                if (jVar.nYS[i4] == (i4 >> 6)) {
                    i4++;
                } else {
                    jVar.nYN = false;
                    break;
                }
            } else {
                break;
            }
        }
        jVar.nYZ = new byte[jVar.nYJ[2] << 2];
        int a2 = a(jVar.nYJ[2] << 2, jVar.nYZ, aVar);
        g.a(jVar.nYF, 256, a);
        g.a(jVar.nYG, 704, jVar.nYJ[1]);
        g.a(jVar.nYH, i2, a2);
        g.a(jVar.nYF, aVar);
        g.a(jVar.nYG, aVar);
        g.a(jVar.nYH, aVar);
        jVar.nYT = 0;
        jVar.nYU = 0;
        jVar.nYV = c.nYc[jVar.nYR[0]];
        jVar.nYW = c.nYc[jVar.nYR[0] + 1];
        jVar.nYO = 0;
        jVar.nYP = jVar.nYF.nYm[0];
        jVar.nYX = jVar.nYG.nYm[0];
        int[] iArr = jVar.nYK;
        int[] iArr2 = jVar.nYK;
        jVar.nYK[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = jVar.nYK;
        int[] iArr4 = jVar.nYK;
        jVar.nYK[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void g(j jVar) {
        a aVar = jVar.nYx;
        byte[] bArr = jVar.nYy;
        if (jVar.nYB <= 0) {
            a.d(aVar);
            jVar.nYv = 1;
            return;
        }
        int min = Math.min(jVar.nZh - jVar.pos, jVar.nYB);
        a.a(aVar, bArr, jVar.pos, min);
        jVar.nYB -= min;
        jVar.pos += min;
        if (jVar.pos == jVar.nZh) {
            jVar.nYw = 5;
            jVar.nZo = jVar.nZh;
            jVar.nDb = 0;
            jVar.nYv = 12;
            return;
        }
        a.d(aVar);
        jVar.nYv = 1;
    }

    private static boolean h(j jVar) {
        if (jVar.nZk != 0) {
            jVar.nDb += jVar.nZk;
            jVar.nZk = 0;
        }
        int min = Math.min(jVar.nZm - jVar.nZn, jVar.nZo - jVar.nDb);
        if (min != 0) {
            System.arraycopy(jVar.nYy, jVar.nDb, jVar.output, jVar.nZl + jVar.nZn, min);
            jVar.nZn += min;
            jVar.nDb = min + jVar.nDb;
        }
        return jVar.nZn < jVar.nZm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.nZj = bArr;
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
            int r0 = r11.nYv
            if (r0 != 0) goto Ld
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress until initialized"
            r0.<init>(r1)
            throw r0
        Ld:
            int r0 = r11.nYv
            r1 = 11
            if (r0 != r1) goto L1c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress after close"
            r0.<init>(r1)
            throw r0
        L1c:
            org.brotli.dec.a r7 = r11.nYx
            int r0 = r11.nZh
            int r1 = r0 + (-1)
            byte[] r0 = r11.nYy
            r6 = r1
        L25:
            int r1 = r11.nYv
            r2 = 10
            if (r1 == r2) goto L3d1
            int r1 = r11.nYv
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
            int r2 = r11.nYv
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L4c:
            int r0 = r11.nYB
            if (r0 >= 0) goto L59
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L59:
            e(r11)
            int r0 = r11.nZh
            int r1 = r0 + (-1)
            byte[] r0 = r11.nYy
            r6 = r1
            goto L25
        L64:
            f(r11)
            r1 = 3
            r11.nYv = r1
        L6a:
            int r1 = r11.nYB
            if (r1 > 0) goto L72
            r1 = 1
            r11.nYv = r1
            goto L25
        L72:
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nYI
            r2 = 1
            r1 = r1[r2]
            if (r1 != 0) goto L7f
            b(r11)
        L7f:
            int[] r1 = r11.nYI
            r2 = 1
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.nYG
            int[] r1 = r1.nYl
            int r2 = r11.nYX
            int r2 = a(r1, r2, r7)
            int r1 = r2 >>> 6
            r3 = 0
            r11.nYY = r3
            r3 = 2
            if (r1 < r3) goto La2
            int r1 = r1 + (-2)
            r3 = -1
            r11.nYY = r3
        La2:
            int[] r3 = org.brotli.dec.i.nYt
            r3 = r3[r1]
            int r4 = r2 >>> 3
            r4 = r4 & 7
            int r3 = r3 + r4
            int[] r4 = org.brotli.dec.i.nYu
            r1 = r4[r1]
            r2 = r2 & 7
            int r1 = r1 + r2
            int[] r2 = org.brotli.dec.i.nYp
            r2 = r2[r3]
            int[] r4 = org.brotli.dec.i.nYq
            r3 = r4[r3]
            int r3 = org.brotli.dec.a.a(r7, r3)
            int r2 = r2 + r3
            r11.nYQ = r2
            int[] r2 = org.brotli.dec.i.nYr
            r2 = r2[r1]
            int[] r3 = org.brotli.dec.i.nYs
            r1 = r3[r1]
            int r1 = org.brotli.dec.a.a(r7, r1)
            int r1 = r1 + r2
            r11.nZd = r1
            r1 = 0
            r11.j = r1
            r1 = 6
            r11.nYv = r1
        Ld6:
            boolean r1 = r11.nYN
            if (r1 == 0) goto L139
        Lda:
            int r1 = r11.j
            int r2 = r11.nYQ
            if (r1 >= r2) goto L124
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nYI
            r2 = 0
            r1 = r1[r2]
            if (r1 != 0) goto Led
            a(r11)
        Led:
            int[] r1 = r11.nYI
            r2 = 0
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            int r1 = r11.pos
            org.brotli.dec.g r2 = r11.nYF
            int[] r2 = r2.nYl
            int r3 = r11.nYP
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
            r11.nYw = r1
            int r1 = r11.nZh
            r11.nZo = r1
            r1 = 0
            r11.nDb = r1
            r1 = 12
            r11.nYv = r1
        L124:
            int r1 = r11.nYv
            r2 = 6
            if (r1 != r2) goto L25
            int r1 = r11.nYB
            int r2 = r11.nYQ
            int r1 = r1 - r2
            r11.nYB = r1
            int r1 = r11.nYB
            if (r1 > 0) goto L1b7
            r1 = 3
            r11.nYv = r1
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
            int r4 = r11.nYQ
            if (r3 >= r4) goto L124
            org.brotli.dec.a.a(r7)
            int[] r3 = r11.nYI
            r4 = 0
            r3 = r3[r4]
            if (r3 != 0) goto L15e
            a(r11)
        L15e:
            byte[] r3 = r11.nYS
            int r4 = r11.nYT
            int[] r5 = org.brotli.dec.c.nYb
            int r8 = r11.nYV
            int r8 = r8 + r2
            r5 = r5[r8]
            int[] r8 = org.brotli.dec.c.nYb
            int r9 = r11.nYW
            int r1 = r1 + r9
            r1 = r8[r1]
            r1 = r1 | r5
            int r1 = r1 + r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int[] r3 = r11.nYI
            r4 = 0
            r5 = r3[r4]
            int r5 = r5 + (-1)
            r3[r4] = r5
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r3 = r11.nYF
            int[] r3 = r3.nYl
            org.brotli.dec.g r4 = r11.nYF
            int[] r4 = r4.nYm
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
            r11.nYw = r1
            int r1 = r11.nZh
            r11.nZo = r1
            r1 = 0
            r11.nDb = r1
            r1 = 12
            r11.nYv = r1
            goto L124
        L1b3:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L14b
        L1b7:
            int r1 = r11.nYY
            if (r1 >= 0) goto L229
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.nYI
            r2 = 2
            r1 = r1[r2]
            if (r1 != 0) goto L1c8
            c(r11)
        L1c8:
            int[] r1 = r11.nYI
            r2 = 2
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.nYH
            int[] r2 = r1.nYl
            org.brotli.dec.g r1 = r11.nYH
            int[] r3 = r1.nYm
            byte[] r4 = r11.nYZ
            int r5 = r11.nYU
            int r1 = r11.nZd
            r8 = 4
            if (r1 <= r8) goto L242
            r1 = 3
        L1e6:
            int r1 = r1 + r5
            r1 = r4[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r3[r1]
            int r1 = a(r2, r1, r7)
            r11.nYY = r1
            int r1 = r11.nYY
            int r2 = r11.nZa
            if (r1 < r2) goto L229
            int r1 = r11.nYY
            int r2 = r11.nZa
            int r1 = r1 - r2
            r11.nYY = r1
            int r1 = r11.nYY
            int r2 = r11.nZb
            r1 = r1 & r2
            int r2 = r11.nYY
            int r3 = r11.nZc
            int r2 = r2 >>> r3
            r11.nYY = r2
            int r2 = r11.nYY
            int r2 = r2 >>> 1
            int r2 = r2 + 1
            int r3 = r11.nYY
            r3 = r3 & 1
            int r3 = r3 + 2
            int r3 = r3 << r2
            int r3 = r3 + (-4)
            int r4 = r11.nZa
            int r1 = r1 + r4
            int r2 = org.brotli.dec.a.a(r7, r2)
            int r2 = r2 + r3
            int r3 = r11.nZc
            int r2 = r2 << r3
            int r1 = r1 + r2
            r11.nYY = r1
        L229:
            int r1 = r11.nYY
            int[] r2 = r11.nYL
            int r3 = r11.nYM
            int r1 = a(r1, r2, r3)
            r11.distance = r1
            int r1 = r11.distance
            if (r1 >= 0) goto L247
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Negative distance"
            r0.<init>(r1)
            throw r0
        L242:
            int r1 = r11.nZd
            int r1 = r1 + (-2)
            goto L1e6
        L247:
            int r1 = r11.fPC
            int r2 = r11.nZf
            if (r1 == r2) goto L267
            int r1 = r11.pos
            int r2 = r11.nZf
            if (r1 >= r2) goto L267
            int r1 = r11.pos
            r11.fPC = r1
        L257:
            int r1 = r11.pos
            r11.nZe = r1
            int r1 = r11.distance
            int r2 = r11.fPC
            if (r1 <= r2) goto L26c
            r1 = 9
            r11.nYv = r1
            goto L25
        L267:
            int r1 = r11.nZf
            r11.fPC = r1
            goto L257
        L26c:
            int r1 = r11.nYY
            if (r1 <= 0) goto L280
            int[] r1 = r11.nYL
            int r2 = r11.nYM
            r2 = r2 & 3
            int r3 = r11.distance
            r1[r2] = r3
            int r1 = r11.nYM
            int r1 = r1 + 1
            r11.nYM = r1
        L280:
            int r1 = r11.nZd
            int r2 = r11.nYB
            if (r1 <= r2) goto L28f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L28f:
            r1 = 0
            r11.j = r1
            r1 = 7
            r11.nYv = r1
        L295:
            int r1 = r11.pos
            int r2 = r11.distance
            int r1 = r1 - r2
            r3 = r1 & r6
            int r2 = r11.pos
            int r1 = r11.nZd
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
            int r1 = r11.nYB
            int r1 = r1 - r8
            r11.nYB = r1
            int r1 = r11.pos
            int r1 = r1 + r8
            r11.pos = r1
        L2cc:
            int r1 = r11.nYv
            r2 = 7
            if (r1 != r2) goto L25
            r1 = 3
            r11.nYv = r1
            goto L25
        L2d6:
            int r1 = r11.j
            int r2 = r11.nZd
            if (r1 >= r2) goto L2cc
            int r1 = r11.pos
            int r2 = r11.pos
            int r3 = r11.distance
            int r2 = r2 - r3
            r2 = r2 & r6
            r2 = r0[r2]
            r0[r1] = r2
            int r1 = r11.nYB
            int r1 = r1 + (-1)
            r11.nYB = r1
            int r1 = r11.j
            int r1 = r1 + 1
            r11.j = r1
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            if (r1 != r6) goto L2d6
            r1 = 7
            r11.nYw = r1
            int r1 = r11.nZh
            r11.nZo = r1
            r1 = 0
            r11.nDb = r1
            r1 = 12
            r11.nYv = r1
            goto L2cc
        L30b:
            int r1 = r11.nZd
            r2 = 4
            if (r1 < r2) goto L37a
            int r1 = r11.nZd
            r2 = 24
            if (r1 > r2) goto L37a
            int[] r1 = org.brotli.dec.e.nYh
            int r2 = r11.nZd
            r1 = r1[r2]
            int r2 = r11.distance
            int r3 = r11.fPC
            int r2 = r2 - r3
            int r2 = r2 + (-1)
            int[] r3 = org.brotli.dec.e.nYi
            int r4 = r11.nZd
            r3 = r3[r4]
            r4 = 1
            int r4 = r4 << r3
            int r4 = r4 + (-1)
            r4 = r4 & r2
            int r5 = r2 >>> r3
            int r2 = r11.nZd
            int r2 = r2 * r4
            int r3 = r1 + r2
            org.brotli.dec.k[] r1 = org.brotli.dec.k.nZr
            int r1 = r1.length
            if (r5 >= r1) goto L371
            int r1 = r11.nZe
            byte[] r2 = org.brotli.dec.e.getData()
            int r4 = r11.nZd
            org.brotli.dec.k[] r8 = org.brotli.dec.k.nZr
            r5 = r8[r5]
            int r1 = org.brotli.dec.k.a(r0, r1, r2, r3, r4, r5)
            int r2 = r11.nZe
            int r2 = r2 + r1
            r11.nZe = r2
            int r2 = r11.pos
            int r2 = r2 + r1
            r11.pos = r2
            int r2 = r11.nYB
            int r1 = r2 - r1
            r11.nYB = r1
            int r1 = r11.nZe
            int r2 = r11.nZh
            if (r1 < r2) goto L383
            r1 = 8
            r11.nYw = r1
            int r1 = r11.nZh
            r11.nZo = r1
            r1 = 0
            r11.nDb = r1
            r1 = 12
            r11.nYv = r1
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
            r11.nYv = r1
            goto L25
        L388:
            int r1 = r11.nZh
            r2 = 0
            int r3 = r11.nZe
            int r4 = r11.nZh
            int r3 = r3 - r4
            java.lang.System.arraycopy(r0, r1, r0, r2, r3)
            r1 = 3
            r11.nYv = r1
            goto L25
        L398:
            int r1 = r11.nYB
            if (r1 <= 0) goto L3ab
            org.brotli.dec.a.a(r7)
            r1 = 8
            org.brotli.dec.a.a(r7, r1)
            int r1 = r11.nYB
            int r1 = r1 + (-1)
            r11.nYB = r1
            goto L398
        L3ab:
            r1 = 1
            r11.nYv = r1
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
            int r2 = r11.nZf
            if (r1 < r2) goto L3c6
            int r1 = r11.nZf
            r11.fPC = r1
        L3c6:
            int r1 = r11.pos
            r1 = r1 & r6
            r11.pos = r1
            int r1 = r11.nYw
            r11.nYv = r1
            goto L25
        L3d1:
            int r0 = r11.nYv
            r1 = 10
            if (r0 != r1) goto L3bb
            int r0 = r11.nYB
            if (r0 >= 0) goto L3e4
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L3e4:
            org.brotli.dec.a.f(r7)
            org.brotli.dec.a r0 = r11.nYx
            r1 = 1
            org.brotli.dec.a.a(r0, r1)
            goto L3bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }
}
