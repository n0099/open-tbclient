package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class d {
    private static final int[] oBg = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] oBh = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] oBi = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] oBj = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

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
        jVar.oBF = a.a(aVar, 1) == 1;
        jVar.oBE = 0;
        jVar.oBG = false;
        jVar.oBH = false;
        if (!jVar.oBF || a.a(aVar, 1) == 0) {
            int a = a.a(aVar, 2) + 4;
            if (a == 7) {
                jVar.oBH = true;
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
                        jVar.oBE = (a3 << (i * 8)) | jVar.oBE;
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
                    jVar.oBE = (a4 << (i2 * 4)) | jVar.oBE;
                }
            }
            jVar.oBE++;
            if (!jVar.oBF) {
                jVar.oBG = a.a(aVar, 1) == 1;
            }
        }
    }

    private static int a(int[] iArr, int i, a aVar) {
        int i2 = (int) (aVar.oAZ >>> aVar.bitOffset);
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
        return i.oBq[a] + a.a(aVar, i.oBr[a]);
    }

    private static int a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(oBh[i] + i2) & 3] + oBi[i] : (i - 16) + 1;
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
            int i12 = ((int) (aVar.oAZ >>> aVar.bitOffset)) & 31;
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
        l.d(iArr2, i7, i - i7);
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
                int i9 = oBg[i8];
                a.b(aVar);
                int i10 = ((int) (aVar.oAZ >>> aVar.bitOffset)) & 15;
                aVar.bitOffset += oBj[i10] >> 16;
                int i11 = oBj[i10] & 65535;
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
            l.y(bArr, 0, i);
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
        a aVar = jVar.oBA;
        int[] iArr = jVar.oBN;
        int i3 = i * 2;
        a.b(aVar);
        int a = a(jVar.oBC, i * 1080, aVar);
        jVar.oBL[i] = b(jVar.oBD, i * 1080, aVar);
        if (a == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (a == 0) {
            i2 = iArr[i3];
        } else {
            i2 = a - 2;
        }
        if (i2 >= jVar.oBM[i]) {
            i2 -= jVar.oBM[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    private static void a(j jVar) {
        a(jVar, 0);
        int i = jVar.oBN[1];
        jVar.oBW = i << 6;
        jVar.oBR = jVar.oBV[jVar.oBW] & 255;
        jVar.oBS = jVar.oBI.oBp[jVar.oBR];
        byte b = jVar.oBU[i];
        jVar.oBY = c.oBf[b];
        jVar.oBZ = c.oBf[b + 1];
    }

    private static void b(j jVar) {
        a(jVar, 1);
        jVar.oCa = jVar.oBJ.oBp[jVar.oBN[3]];
    }

    private static void c(j jVar) {
        a(jVar, 2);
        jVar.oBX = jVar.oBN[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r8.oCj >= 16384) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(j jVar) {
        int i;
        int i2;
        int i3 = 16384;
        int i4 = jVar.oCj;
        if (i4 > jVar.oCl) {
            while ((i4 >> 1) > ((int) jVar.oCl) + jVar.oCm.length) {
                i4 >>= 1;
            }
            if (!jVar.oBF) {
                if (i4 < 16384) {
                }
            }
        }
        i3 = i4;
        if (i3 > jVar.oCk) {
            byte[] bArr = new byte[i3 + 37];
            if (jVar.oBB != null) {
                System.arraycopy(jVar.oBB, 0, bArr, 0, jVar.oCk);
            } else if (jVar.oCm.length != 0) {
                int length = jVar.oCm.length;
                if (length > jVar.oCi) {
                    i2 = length - jVar.oCi;
                    i = jVar.oCi;
                } else {
                    i = length;
                    i2 = 0;
                }
                System.arraycopy(jVar.oCm, i2, bArr, 0, i);
                jVar.pos = i;
                jVar.oCn = i;
            }
            jVar.oBB = bArr;
            jVar.oCk = i3;
        }
    }

    private static void e(j jVar) {
        a aVar = jVar.oBA;
        if (jVar.oBF) {
            jVar.oBz = 10;
            jVar.oCr = jVar.pos;
            jVar.oga = 0;
            jVar.oBy = 12;
            return;
        }
        jVar.oBI.oBo = null;
        jVar.oBI.oBp = null;
        jVar.oBJ.oBo = null;
        jVar.oBJ.oBp = null;
        jVar.oBK.oBo = null;
        jVar.oBK.oBp = null;
        a.a(aVar);
        a(aVar, jVar);
        if (jVar.oBE != 0 || jVar.oBH) {
            if (jVar.oBG || jVar.oBH) {
                a.f(aVar);
                jVar.oBy = jVar.oBH ? 4 : 5;
            } else {
                jVar.oBy = 2;
            }
            if (!jVar.oBH) {
                jVar.oCl += jVar.oBE;
                if (jVar.oCk < jVar.oCj) {
                    d(jVar);
                }
            }
        }
    }

    private static void f(j jVar) {
        a aVar = jVar.oBA;
        for (int i = 0; i < 3; i++) {
            jVar.oBM[i] = h(aVar) + 1;
            jVar.oBL[i] = 268435456;
            if (jVar.oBM[i] > 1) {
                a(jVar.oBM[i] + 2, jVar.oBC, i * 1080, aVar);
                a(26, jVar.oBD, i * 1080, aVar);
                jVar.oBL[i] = b(jVar.oBD, i * 1080, aVar);
            }
        }
        a.a(aVar);
        jVar.oCf = a.a(aVar, 2);
        jVar.oCd = (a.a(aVar, 4) << jVar.oCf) + 16;
        jVar.oCe = (1 << jVar.oCf) - 1;
        int i2 = (48 << jVar.oCf) + jVar.oCd;
        jVar.oBU = new byte[jVar.oBM[0]];
        int i3 = 0;
        while (i3 < jVar.oBM[0]) {
            int min = Math.min(i3 + 96, jVar.oBM[0]);
            while (i3 < min) {
                jVar.oBU[i3] = (byte) (a.a(aVar, 2) << 1);
                i3++;
            }
            a.a(aVar);
        }
        jVar.oBV = new byte[jVar.oBM[0] << 6];
        int a = a(jVar.oBM[0] << 6, jVar.oBV, aVar);
        jVar.oBQ = true;
        int i4 = 0;
        while (true) {
            if (i4 < (jVar.oBM[0] << 6)) {
                if (jVar.oBV[i4] == (i4 >> 6)) {
                    i4++;
                } else {
                    jVar.oBQ = false;
                    break;
                }
            } else {
                break;
            }
        }
        jVar.oCc = new byte[jVar.oBM[2] << 2];
        int a2 = a(jVar.oBM[2] << 2, jVar.oCc, aVar);
        g.a(jVar.oBI, 256, a);
        g.a(jVar.oBJ, 704, jVar.oBM[1]);
        g.a(jVar.oBK, i2, a2);
        g.a(jVar.oBI, aVar);
        g.a(jVar.oBJ, aVar);
        g.a(jVar.oBK, aVar);
        jVar.oBW = 0;
        jVar.oBX = 0;
        jVar.oBY = c.oBf[jVar.oBU[0]];
        jVar.oBZ = c.oBf[jVar.oBU[0] + 1];
        jVar.oBR = 0;
        jVar.oBS = jVar.oBI.oBp[0];
        jVar.oCa = jVar.oBJ.oBp[0];
        int[] iArr = jVar.oBN;
        int[] iArr2 = jVar.oBN;
        jVar.oBN[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = jVar.oBN;
        int[] iArr4 = jVar.oBN;
        jVar.oBN[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void g(j jVar) {
        a aVar = jVar.oBA;
        byte[] bArr = jVar.oBB;
        if (jVar.oBE <= 0) {
            a.d(aVar);
            jVar.oBy = 1;
            return;
        }
        int min = Math.min(jVar.oCk - jVar.pos, jVar.oBE);
        a.a(aVar, bArr, jVar.pos, min);
        jVar.oBE -= min;
        jVar.pos += min;
        if (jVar.pos == jVar.oCk) {
            jVar.oBz = 5;
            jVar.oCr = jVar.oCk;
            jVar.oga = 0;
            jVar.oBy = 12;
            return;
        }
        a.d(aVar);
        jVar.oBy = 1;
    }

    private static boolean h(j jVar) {
        if (jVar.oCn != 0) {
            jVar.oga += jVar.oCn;
            jVar.oCn = 0;
        }
        int min = Math.min(jVar.oCp - jVar.oCq, jVar.oCr - jVar.oga);
        if (min != 0) {
            System.arraycopy(jVar.oBB, jVar.oga, jVar.output, jVar.oCo + jVar.oCq, min);
            jVar.oCq += min;
            jVar.oga = min + jVar.oga;
        }
        return jVar.oCq < jVar.oCp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.oCm = bArr;
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
            int r0 = r11.oBy
            if (r0 != 0) goto Ld
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress until initialized"
            r0.<init>(r1)
            throw r0
        Ld:
            int r0 = r11.oBy
            r1 = 11
            if (r0 != r1) goto L1c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress after close"
            r0.<init>(r1)
            throw r0
        L1c:
            org.brotli.dec.a r7 = r11.oBA
            int r0 = r11.oCk
            int r1 = r0 + (-1)
            byte[] r0 = r11.oBB
            r6 = r1
        L25:
            int r1 = r11.oBy
            r2 = 10
            if (r1 == r2) goto L3d1
            int r1 = r11.oBy
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
            int r2 = r11.oBy
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L4c:
            int r0 = r11.oBE
            if (r0 >= 0) goto L59
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L59:
            e(r11)
            int r0 = r11.oCk
            int r1 = r0 + (-1)
            byte[] r0 = r11.oBB
            r6 = r1
            goto L25
        L64:
            f(r11)
            r1 = 3
            r11.oBy = r1
        L6a:
            int r1 = r11.oBE
            if (r1 > 0) goto L72
            r1 = 1
            r11.oBy = r1
            goto L25
        L72:
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.oBL
            r2 = 1
            r1 = r1[r2]
            if (r1 != 0) goto L7f
            b(r11)
        L7f:
            int[] r1 = r11.oBL
            r2 = 1
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.oBJ
            int[] r1 = r1.oBo
            int r2 = r11.oCa
            int r2 = a(r1, r2, r7)
            int r1 = r2 >>> 6
            r3 = 0
            r11.oCb = r3
            r3 = 2
            if (r1 < r3) goto La2
            int r1 = r1 + (-2)
            r3 = -1
            r11.oCb = r3
        La2:
            int[] r3 = org.brotli.dec.i.oBw
            r3 = r3[r1]
            int r4 = r2 >>> 3
            r4 = r4 & 7
            int r3 = r3 + r4
            int[] r4 = org.brotli.dec.i.oBx
            r1 = r4[r1]
            r2 = r2 & 7
            int r1 = r1 + r2
            int[] r2 = org.brotli.dec.i.oBs
            r2 = r2[r3]
            int[] r4 = org.brotli.dec.i.oBt
            r3 = r4[r3]
            int r3 = org.brotli.dec.a.a(r7, r3)
            int r2 = r2 + r3
            r11.oBT = r2
            int[] r2 = org.brotli.dec.i.oBu
            r2 = r2[r1]
            int[] r3 = org.brotli.dec.i.oBv
            r1 = r3[r1]
            int r1 = org.brotli.dec.a.a(r7, r1)
            int r1 = r1 + r2
            r11.oCg = r1
            r1 = 0
            r11.j = r1
            r1 = 6
            r11.oBy = r1
        Ld6:
            boolean r1 = r11.oBQ
            if (r1 == 0) goto L139
        Lda:
            int r1 = r11.j
            int r2 = r11.oBT
            if (r1 >= r2) goto L124
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.oBL
            r2 = 0
            r1 = r1[r2]
            if (r1 != 0) goto Led
            a(r11)
        Led:
            int[] r1 = r11.oBL
            r2 = 0
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            int r1 = r11.pos
            org.brotli.dec.g r2 = r11.oBI
            int[] r2 = r2.oBo
            int r3 = r11.oBS
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
            r11.oBz = r1
            int r1 = r11.oCk
            r11.oCr = r1
            r1 = 0
            r11.oga = r1
            r1 = 12
            r11.oBy = r1
        L124:
            int r1 = r11.oBy
            r2 = 6
            if (r1 != r2) goto L25
            int r1 = r11.oBE
            int r2 = r11.oBT
            int r1 = r1 - r2
            r11.oBE = r1
            int r1 = r11.oBE
            if (r1 > 0) goto L1b7
            r1 = 3
            r11.oBy = r1
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
            int r4 = r11.oBT
            if (r3 >= r4) goto L124
            org.brotli.dec.a.a(r7)
            int[] r3 = r11.oBL
            r4 = 0
            r3 = r3[r4]
            if (r3 != 0) goto L15e
            a(r11)
        L15e:
            byte[] r3 = r11.oBV
            int r4 = r11.oBW
            int[] r5 = org.brotli.dec.c.oBe
            int r8 = r11.oBY
            int r8 = r8 + r2
            r5 = r5[r8]
            int[] r8 = org.brotli.dec.c.oBe
            int r9 = r11.oBZ
            int r1 = r1 + r9
            r1 = r8[r1]
            r1 = r1 | r5
            int r1 = r1 + r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int[] r3 = r11.oBL
            r4 = 0
            r5 = r3[r4]
            int r5 = r5 + (-1)
            r3[r4] = r5
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r3 = r11.oBI
            int[] r3 = r3.oBo
            org.brotli.dec.g r4 = r11.oBI
            int[] r4 = r4.oBp
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
            r11.oBz = r1
            int r1 = r11.oCk
            r11.oCr = r1
            r1 = 0
            r11.oga = r1
            r1 = 12
            r11.oBy = r1
            goto L124
        L1b3:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L14b
        L1b7:
            int r1 = r11.oCb
            if (r1 >= 0) goto L229
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.oBL
            r2 = 2
            r1 = r1[r2]
            if (r1 != 0) goto L1c8
            c(r11)
        L1c8:
            int[] r1 = r11.oBL
            r2 = 2
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.oBK
            int[] r2 = r1.oBo
            org.brotli.dec.g r1 = r11.oBK
            int[] r3 = r1.oBp
            byte[] r4 = r11.oCc
            int r5 = r11.oBX
            int r1 = r11.oCg
            r8 = 4
            if (r1 <= r8) goto L242
            r1 = 3
        L1e6:
            int r1 = r1 + r5
            r1 = r4[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r3[r1]
            int r1 = a(r2, r1, r7)
            r11.oCb = r1
            int r1 = r11.oCb
            int r2 = r11.oCd
            if (r1 < r2) goto L229
            int r1 = r11.oCb
            int r2 = r11.oCd
            int r1 = r1 - r2
            r11.oCb = r1
            int r1 = r11.oCb
            int r2 = r11.oCe
            r1 = r1 & r2
            int r2 = r11.oCb
            int r3 = r11.oCf
            int r2 = r2 >>> r3
            r11.oCb = r2
            int r2 = r11.oCb
            int r2 = r2 >>> 1
            int r2 = r2 + 1
            int r3 = r11.oCb
            r3 = r3 & 1
            int r3 = r3 + 2
            int r3 = r3 << r2
            int r3 = r3 + (-4)
            int r4 = r11.oCd
            int r1 = r1 + r4
            int r2 = org.brotli.dec.a.a(r7, r2)
            int r2 = r2 + r3
            int r3 = r11.oCf
            int r2 = r2 << r3
            int r1 = r1 + r2
            r11.oCb = r1
        L229:
            int r1 = r11.oCb
            int[] r2 = r11.oBO
            int r3 = r11.oBP
            int r1 = a(r1, r2, r3)
            r11.distance = r1
            int r1 = r11.distance
            if (r1 >= 0) goto L247
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Negative distance"
            r0.<init>(r1)
            throw r0
        L242:
            int r1 = r11.oCg
            int r1 = r1 + (-2)
            goto L1e6
        L247:
            int r1 = r11.ggY
            int r2 = r11.oCi
            if (r1 == r2) goto L267
            int r1 = r11.pos
            int r2 = r11.oCi
            if (r1 >= r2) goto L267
            int r1 = r11.pos
            r11.ggY = r1
        L257:
            int r1 = r11.pos
            r11.oCh = r1
            int r1 = r11.distance
            int r2 = r11.ggY
            if (r1 <= r2) goto L26c
            r1 = 9
            r11.oBy = r1
            goto L25
        L267:
            int r1 = r11.oCi
            r11.ggY = r1
            goto L257
        L26c:
            int r1 = r11.oCb
            if (r1 <= 0) goto L280
            int[] r1 = r11.oBO
            int r2 = r11.oBP
            r2 = r2 & 3
            int r3 = r11.distance
            r1[r2] = r3
            int r1 = r11.oBP
            int r1 = r1 + 1
            r11.oBP = r1
        L280:
            int r1 = r11.oCg
            int r2 = r11.oBE
            if (r1 <= r2) goto L28f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L28f:
            r1 = 0
            r11.j = r1
            r1 = 7
            r11.oBy = r1
        L295:
            int r1 = r11.pos
            int r2 = r11.distance
            int r1 = r1 - r2
            r3 = r1 & r6
            int r2 = r11.pos
            int r1 = r11.oCg
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
            int r1 = r11.oBE
            int r1 = r1 - r8
            r11.oBE = r1
            int r1 = r11.pos
            int r1 = r1 + r8
            r11.pos = r1
        L2cc:
            int r1 = r11.oBy
            r2 = 7
            if (r1 != r2) goto L25
            r1 = 3
            r11.oBy = r1
            goto L25
        L2d6:
            int r1 = r11.j
            int r2 = r11.oCg
            if (r1 >= r2) goto L2cc
            int r1 = r11.pos
            int r2 = r11.pos
            int r3 = r11.distance
            int r2 = r2 - r3
            r2 = r2 & r6
            r2 = r0[r2]
            r0[r1] = r2
            int r1 = r11.oBE
            int r1 = r1 + (-1)
            r11.oBE = r1
            int r1 = r11.j
            int r1 = r1 + 1
            r11.j = r1
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            if (r1 != r6) goto L2d6
            r1 = 7
            r11.oBz = r1
            int r1 = r11.oCk
            r11.oCr = r1
            r1 = 0
            r11.oga = r1
            r1 = 12
            r11.oBy = r1
            goto L2cc
        L30b:
            int r1 = r11.oCg
            r2 = 4
            if (r1 < r2) goto L37a
            int r1 = r11.oCg
            r2 = 24
            if (r1 > r2) goto L37a
            int[] r1 = org.brotli.dec.e.oBk
            int r2 = r11.oCg
            r1 = r1[r2]
            int r2 = r11.distance
            int r3 = r11.ggY
            int r2 = r2 - r3
            int r2 = r2 + (-1)
            int[] r3 = org.brotli.dec.e.oBl
            int r4 = r11.oCg
            r3 = r3[r4]
            r4 = 1
            int r4 = r4 << r3
            int r4 = r4 + (-1)
            r4 = r4 & r2
            int r5 = r2 >>> r3
            int r2 = r11.oCg
            int r2 = r2 * r4
            int r3 = r1 + r2
            org.brotli.dec.k[] r1 = org.brotli.dec.k.oCu
            int r1 = r1.length
            if (r5 >= r1) goto L371
            int r1 = r11.oCh
            byte[] r2 = org.brotli.dec.e.getData()
            int r4 = r11.oCg
            org.brotli.dec.k[] r8 = org.brotli.dec.k.oCu
            r5 = r8[r5]
            int r1 = org.brotli.dec.k.a(r0, r1, r2, r3, r4, r5)
            int r2 = r11.oCh
            int r2 = r2 + r1
            r11.oCh = r2
            int r2 = r11.pos
            int r2 = r2 + r1
            r11.pos = r2
            int r2 = r11.oBE
            int r1 = r2 - r1
            r11.oBE = r1
            int r1 = r11.oCh
            int r2 = r11.oCk
            if (r1 < r2) goto L383
            r1 = 8
            r11.oBz = r1
            int r1 = r11.oCk
            r11.oCr = r1
            r1 = 0
            r11.oga = r1
            r1 = 12
            r11.oBy = r1
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
            r11.oBy = r1
            goto L25
        L388:
            int r1 = r11.oCk
            r2 = 0
            int r3 = r11.oCh
            int r4 = r11.oCk
            int r3 = r3 - r4
            java.lang.System.arraycopy(r0, r1, r0, r2, r3)
            r1 = 3
            r11.oBy = r1
            goto L25
        L398:
            int r1 = r11.oBE
            if (r1 <= 0) goto L3ab
            org.brotli.dec.a.a(r7)
            r1 = 8
            org.brotli.dec.a.a(r7, r1)
            int r1 = r11.oBE
            int r1 = r1 + (-1)
            r11.oBE = r1
            goto L398
        L3ab:
            r1 = 1
            r11.oBy = r1
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
            int r2 = r11.oCi
            if (r1 < r2) goto L3c6
            int r1 = r11.oCi
            r11.ggY = r1
        L3c6:
            int r1 = r11.pos
            r1 = r1 & r6
            r11.pos = r1
            int r1 = r11.oBz
            r11.oBy = r1
            goto L25
        L3d1:
            int r0 = r11.oBy
            r1 = 10
            if (r0 != r1) goto L3bb
            int r0 = r11.oBE
            if (r0 >= 0) goto L3e4
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L3e4:
            org.brotli.dec.a.f(r7)
            org.brotli.dec.a r0 = r11.oBA
            r1 = 1
            org.brotli.dec.a.a(r0, r1)
            goto L3bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }
}
