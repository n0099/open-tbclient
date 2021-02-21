package org.brotli.dec;

import androidx.core.internal.view.SupportMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class d {
    private static final int[] qvH = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] qvI = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] qvJ = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] qvK = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    private static int h(a aVar) {
        if (a.a(aVar, 1) != 0) {
            int a2 = a.a(aVar, 3);
            if (a2 == 0) {
                return 1;
            }
            return (1 << a2) + a.a(aVar, a2);
        }
        return 0;
    }

    private static void a(a aVar, j jVar) {
        jVar.qwg = a.a(aVar, 1) == 1;
        jVar.qwf = 0;
        jVar.qwh = false;
        jVar.qwi = false;
        if (!jVar.qwg || a.a(aVar, 1) == 0) {
            int a2 = a.a(aVar, 2) + 4;
            if (a2 == 7) {
                jVar.qwi = true;
                if (a.a(aVar, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int a3 = a.a(aVar, 2);
                if (a3 != 0) {
                    for (int i = 0; i < a3; i++) {
                        int a4 = a.a(aVar, 8);
                        if (a4 == 0 && i + 1 == a3 && a3 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        jVar.qwf = (a4 << (i * 8)) | jVar.qwf;
                    }
                } else {
                    return;
                }
            } else {
                for (int i2 = 0; i2 < a2; i2++) {
                    int a5 = a.a(aVar, 4);
                    if (a5 == 0 && i2 + 1 == a2 && a2 > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.qwf = (a5 << (i2 * 4)) | jVar.qwf;
                }
            }
            jVar.qwf++;
            if (!jVar.qwg) {
                jVar.qwh = a.a(aVar, 1) == 1;
            }
        }
    }

    private static int a(int[] iArr, int i, a aVar) {
        int i2 = (int) (aVar.qvz >>> aVar.bitOffset);
        int i3 = i + (i2 & 255);
        int i4 = iArr[i3] >> 16;
        int i5 = iArr[i3] & SupportMenu.USER_MASK;
        if (i4 <= 8) {
            aVar.bitOffset += i4;
            return i5;
        }
        int i6 = i5 + i3 + ((i2 & ((1 << i4) - 1)) >>> 8);
        aVar.bitOffset += (iArr[i6] >> 16) + 8;
        return iArr[i6] & SupportMenu.USER_MASK;
    }

    private static int b(int[] iArr, int i, a aVar) {
        a.b(aVar);
        int a2 = a(iArr, i, aVar);
        return i.qvR[a2] + a.a(aVar, i.qvS[a2]);
    }

    private static int a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(qvI[i] + i2) & 3] + qvJ[i] : (i - 16) + 1;
    }

    private static void d(int[] iArr, int i) {
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
                d(iArr, i4);
            }
        }
    }

    private static void a(int[] iArr, int i, int[] iArr2, a aVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 8;
        int i8 = 0;
        int i9 = 0;
        int i10 = 32768;
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        while (i6 < i && i10 > 0) {
            a.a(aVar);
            a.b(aVar);
            int i11 = ((int) (aVar.qvz >>> aVar.bitOffset)) & 31;
            aVar.bitOffset += iArr3[i11] >> 16;
            int i12 = iArr3[i11] & SupportMenu.USER_MASK;
            if (i12 < 16) {
                i8 = 0;
                i3 = i6 + 1;
                iArr2[i6] = i12;
                if (i12 != 0) {
                    i4 = i10 - (32768 >> i12);
                    i5 = i9;
                }
                i4 = i10;
                i5 = i9;
                i12 = i7;
            } else {
                int i13 = i12 - 14;
                int i14 = i12 == 16 ? i7 : 0;
                if (i9 != i14) {
                    i2 = 0;
                    i9 = i14;
                } else {
                    i2 = i8;
                }
                i8 = a.a(aVar, i13) + 3 + (i2 > 0 ? (i2 - 2) << i13 : i2);
                int i15 = i8 - i2;
                if (i6 + i15 > i) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i16 = 0;
                i3 = i6;
                while (i16 < i15) {
                    iArr2[i3] = i9;
                    i16++;
                    i3++;
                }
                if (i9 != 0) {
                    i4 = i10 - (i15 << (15 - i9));
                    i5 = i9;
                    i12 = i7;
                }
                i4 = i10;
                i5 = i9;
                i12 = i7;
            }
            i10 = i4;
            i9 = i5;
            i7 = i12;
            i6 = i3;
        }
        if (i10 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        l.f(iArr2, i6, i - i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int[] iArr, int i2, a aVar) {
        boolean z = true;
        a.a(aVar);
        int[] iArr2 = new int[i];
        int a2 = a.a(aVar, 2);
        if (a2 == 1) {
            int[] iArr3 = new int[4];
            int a3 = a.a(aVar, 2) + 1;
            int i3 = 0;
            int i4 = i - 1;
            while (i4 != 0) {
                i4 >>= 1;
                i3++;
            }
            for (int i5 = 0; i5 < a3; i5++) {
                iArr3[i5] = a.a(aVar, i3) % i;
                iArr2[iArr3[i5]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            switch (a3) {
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
            while (a2 < 18 && i6 > 0) {
                int i8 = qvH[a2];
                a.b(aVar);
                int i9 = ((int) (aVar.qvz >>> aVar.bitOffset)) & 15;
                aVar.bitOffset += qvK[i9] >> 16;
                int i10 = qvK[i9] & SupportMenu.USER_MASK;
                iArr4[i8] = i10;
                if (i10 != 0) {
                    i6 -= 32 >> i10;
                    i7++;
                }
                a2++;
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
        a.a(aVar);
        int h = h(aVar) + 1;
        if (h == 1) {
            l.z(bArr, 0, i);
            return h;
        }
        int a2 = a.a(aVar, 1) == 1 ? a.a(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        a(h + a2, iArr, 0, aVar);
        int i2 = 0;
        while (i2 < i) {
            a.a(aVar);
            a.b(aVar);
            int a3 = a(iArr, 0, aVar);
            if (a3 == 0) {
                bArr[i2] = 0;
                i2++;
            } else if (a3 <= a2) {
                for (int a4 = a.a(aVar, a3) + (1 << a3); a4 != 0; a4--) {
                    if (i2 >= i) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i2] = 0;
                    i2++;
                }
                continue;
            } else {
                bArr[i2] = (byte) (a3 - a2);
                i2++;
            }
        }
        if (a.a(aVar, 1) == 1) {
            x(bArr, i);
        }
        return h;
    }

    private static void a(j jVar, int i) {
        int i2;
        a aVar = jVar.qwb;
        int[] iArr = jVar.qwo;
        int i3 = i * 2;
        a.b(aVar);
        int a2 = a(jVar.qwd, i * 1080, aVar);
        jVar.qwm[i] = b(jVar.qwe, i * 1080, aVar);
        if (a2 == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (a2 == 0) {
            i2 = iArr[i3];
        } else {
            i2 = a2 - 2;
        }
        if (i2 >= jVar.qwn[i]) {
            i2 -= jVar.qwn[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    private static void a(j jVar) {
        a(jVar, 0);
        int i = jVar.qwo[1];
        jVar.qwx = i << 6;
        jVar.qws = jVar.qww[jVar.qwx] & 255;
        jVar.qwt = jVar.qwj.qvQ[jVar.qws];
        byte b2 = jVar.qwv[i];
        jVar.qwz = c.qvG[b2];
        jVar.qwA = c.qvG[b2 + 1];
    }

    private static void b(j jVar) {
        a(jVar, 1);
        jVar.qwB = jVar.qwk.qvQ[jVar.qwo[3]];
    }

    private static void c(j jVar) {
        a(jVar, 2);
        jVar.qwy = jVar.qwo[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r8.qwK >= 16384) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(j jVar) {
        int i;
        int i2 = 16384;
        int i3 = jVar.qwK;
        if (i3 > jVar.qwM) {
            while ((i3 >> 1) > ((int) jVar.qwM) + jVar.qwN.length) {
                i3 >>= 1;
            }
            if (!jVar.qwg) {
                if (i3 < 16384) {
                }
            }
        }
        i2 = i3;
        if (i2 > jVar.qwL) {
            byte[] bArr = new byte[i2 + 37];
            if (jVar.qwc != null) {
                System.arraycopy(jVar.qwc, 0, bArr, 0, jVar.qwL);
            } else if (jVar.qwN.length != 0) {
                int length = jVar.qwN.length;
                if (length > jVar.qwJ) {
                    i = length - jVar.qwJ;
                    length = jVar.qwJ;
                } else {
                    i = 0;
                }
                System.arraycopy(jVar.qwN, i, bArr, 0, length);
                jVar.pos = length;
                jVar.qwO = length;
            }
            jVar.qwc = bArr;
            jVar.qwL = i2;
        }
    }

    private static void e(j jVar) {
        a aVar = jVar.qwb;
        if (jVar.qwg) {
            jVar.qwa = 10;
            jVar.qwT = jVar.pos;
            jVar.qwS = 0;
            jVar.qvZ = 12;
            return;
        }
        jVar.qwj.qvP = null;
        jVar.qwj.qvQ = null;
        jVar.qwk.qvP = null;
        jVar.qwk.qvQ = null;
        jVar.qwl.qvP = null;
        jVar.qwl.qvQ = null;
        a.a(aVar);
        a(aVar, jVar);
        if (jVar.qwf != 0 || jVar.qwi) {
            if (jVar.qwh || jVar.qwi) {
                a.f(aVar);
                jVar.qvZ = jVar.qwi ? 4 : 5;
            } else {
                jVar.qvZ = 2;
            }
            if (!jVar.qwi) {
                jVar.qwM += jVar.qwf;
                if (jVar.qwL < jVar.qwK) {
                    d(jVar);
                }
            }
        }
    }

    private static void f(j jVar) {
        a aVar = jVar.qwb;
        for (int i = 0; i < 3; i++) {
            jVar.qwn[i] = h(aVar) + 1;
            jVar.qwm[i] = 268435456;
            if (jVar.qwn[i] > 1) {
                a(jVar.qwn[i] + 2, jVar.qwd, i * 1080, aVar);
                a(26, jVar.qwe, i * 1080, aVar);
                jVar.qwm[i] = b(jVar.qwe, i * 1080, aVar);
            }
        }
        a.a(aVar);
        jVar.qwG = a.a(aVar, 2);
        jVar.qwE = (a.a(aVar, 4) << jVar.qwG) + 16;
        jVar.qwF = (1 << jVar.qwG) - 1;
        int i2 = (48 << jVar.qwG) + jVar.qwE;
        jVar.qwv = new byte[jVar.qwn[0]];
        int i3 = 0;
        while (i3 < jVar.qwn[0]) {
            int min = Math.min(i3 + 96, jVar.qwn[0]);
            while (i3 < min) {
                jVar.qwv[i3] = (byte) (a.a(aVar, 2) << 1);
                i3++;
            }
            a.a(aVar);
        }
        jVar.qww = new byte[jVar.qwn[0] << 6];
        int a2 = a(jVar.qwn[0] << 6, jVar.qww, aVar);
        jVar.qwr = true;
        int i4 = 0;
        while (true) {
            if (i4 < (jVar.qwn[0] << 6)) {
                if (jVar.qww[i4] == (i4 >> 6)) {
                    i4++;
                } else {
                    jVar.qwr = false;
                    break;
                }
            } else {
                break;
            }
        }
        jVar.qwD = new byte[jVar.qwn[2] << 2];
        int a3 = a(jVar.qwn[2] << 2, jVar.qwD, aVar);
        g.a(jVar.qwj, 256, a2);
        g.a(jVar.qwk, 704, jVar.qwn[1]);
        g.a(jVar.qwl, i2, a3);
        g.a(jVar.qwj, aVar);
        g.a(jVar.qwk, aVar);
        g.a(jVar.qwl, aVar);
        jVar.qwx = 0;
        jVar.qwy = 0;
        jVar.qwz = c.qvG[jVar.qwv[0]];
        jVar.qwA = c.qvG[jVar.qwv[0] + 1];
        jVar.qws = 0;
        jVar.qwt = jVar.qwj.qvQ[0];
        jVar.qwB = jVar.qwk.qvQ[0];
        int[] iArr = jVar.qwo;
        int[] iArr2 = jVar.qwo;
        jVar.qwo[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = jVar.qwo;
        int[] iArr4 = jVar.qwo;
        jVar.qwo[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void g(j jVar) {
        a aVar = jVar.qwb;
        byte[] bArr = jVar.qwc;
        if (jVar.qwf <= 0) {
            a.d(aVar);
            jVar.qvZ = 1;
            return;
        }
        int min = Math.min(jVar.qwL - jVar.pos, jVar.qwf);
        a.a(aVar, bArr, jVar.pos, min);
        jVar.qwf -= min;
        jVar.pos += min;
        if (jVar.pos == jVar.qwL) {
            jVar.qwa = 5;
            jVar.qwT = jVar.qwL;
            jVar.qwS = 0;
            jVar.qvZ = 12;
            return;
        }
        a.d(aVar);
        jVar.qvZ = 1;
    }

    private static boolean h(j jVar) {
        if (jVar.qwO != 0) {
            jVar.qwS += jVar.qwO;
            jVar.qwO = 0;
        }
        int min = Math.min(jVar.qwQ - jVar.qwR, jVar.qwT - jVar.qwS);
        if (min != 0) {
            System.arraycopy(jVar.qwc, jVar.qwS, jVar.output, jVar.qwP + jVar.qwR, min);
            jVar.qwR += min;
            jVar.qwS = min + jVar.qwS;
        }
        return jVar.qwR < jVar.qwQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.qwN = bArr;
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
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x002b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x002b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9 A[LOOP:1: B:35:0x00d9->B:41:0x0111, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(org.brotli.dec.j r15) {
        /*
            r14 = 12
            r13 = 6
            r7 = 3
            r12 = 1
            r8 = 0
            int r0 = r15.qvZ
            if (r0 != 0) goto L13
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress until initialized"
            r0.<init>(r1)
            throw r0
        L13:
            int r0 = r15.qvZ
            r1 = 11
            if (r0 != r1) goto L22
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress after close"
            r0.<init>(r1)
            throw r0
        L22:
            org.brotli.dec.a r9 = r15.qwb
            int r0 = r15.qwL
            int r1 = r0 + (-1)
            byte[] r0 = r15.qwc
            r6 = r1
        L2b:
            int r1 = r15.qvZ
            r2 = 10
            if (r1 == r2) goto L3b5
            int r1 = r15.qvZ
            switch(r1) {
                case 1: goto L52;
                case 2: goto L6a;
                case 3: goto L6f;
                case 4: goto L37d;
                case 5: goto L394;
                case 6: goto Ld5;
                case 7: goto L284;
                case 8: goto L36f;
                case 9: goto L2f6;
                case 10: goto L36;
                case 11: goto L36;
                case 12: goto L399;
                default: goto L36;
            }
        L36:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected state "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r15.qvZ
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L52:
            int r0 = r15.qwf
            if (r0 >= 0) goto L5f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L5f:
            e(r15)
            int r0 = r15.qwL
            int r1 = r0 + (-1)
            byte[] r0 = r15.qwc
            r6 = r1
            goto L2b
        L6a:
            f(r15)
            r15.qvZ = r7
        L6f:
            int r1 = r15.qwf
            if (r1 > 0) goto L76
            r15.qvZ = r12
            goto L2b
        L76:
            org.brotli.dec.a.a(r9)
            int[] r1 = r15.qwm
            r1 = r1[r12]
            if (r1 != 0) goto L82
            b(r15)
        L82:
            int[] r1 = r15.qwm
            r2 = r1[r12]
            int r2 = r2 + (-1)
            r1[r12] = r2
            org.brotli.dec.a.b(r9)
            org.brotli.dec.g r1 = r15.qwk
            int[] r1 = r1.qvP
            int r2 = r15.qwB
            int r2 = a(r1, r2, r9)
            int r1 = r2 >>> 6
            r15.qwC = r8
            r3 = 2
            if (r1 < r3) goto La3
            int r1 = r1 + (-2)
            r3 = -1
            r15.qwC = r3
        La3:
            int[] r3 = org.brotli.dec.i.qvX
            r3 = r3[r1]
            int r4 = r2 >>> 3
            r4 = r4 & 7
            int r3 = r3 + r4
            int[] r4 = org.brotli.dec.i.qvY
            r1 = r4[r1]
            r2 = r2 & 7
            int r1 = r1 + r2
            int[] r2 = org.brotli.dec.i.qvT
            r2 = r2[r3]
            int[] r4 = org.brotli.dec.i.qvU
            r3 = r4[r3]
            int r3 = org.brotli.dec.a.a(r9, r3)
            int r2 = r2 + r3
            r15.qwu = r2
            int[] r2 = org.brotli.dec.i.qvV
            r2 = r2[r1]
            int[] r3 = org.brotli.dec.i.qvW
            r1 = r3[r1]
            int r1 = org.brotli.dec.a.a(r9, r1)
            int r1 = r1 + r2
            r15.qwH = r1
            r15.j = r8
            r15.qvZ = r13
        Ld5:
            boolean r1 = r15.qwr
            if (r1 == 0) goto L130
        Ld9:
            int r1 = r15.j
            int r2 = r15.qwu
            if (r1 >= r2) goto L11d
            org.brotli.dec.a.a(r9)
            int[] r1 = r15.qwm
            r1 = r1[r8]
            if (r1 != 0) goto Leb
            a(r15)
        Leb:
            int[] r1 = r15.qwm
            r2 = r1[r8]
            int r2 = r2 + (-1)
            r1[r8] = r2
            org.brotli.dec.a.b(r9)
            int r1 = r15.pos
            org.brotli.dec.g r2 = r15.qwj
            int[] r2 = r2.qvP
            int r3 = r15.qwt
            int r2 = a(r2, r3, r9)
            byte r2 = (byte) r2
            r0[r1] = r2
            int r1 = r15.j
            int r1 = r1 + 1
            r15.j = r1
            int r1 = r15.pos
            int r2 = r1 + 1
            r15.pos = r2
            if (r1 != r6) goto Ld9
            r15.qwa = r13
            int r1 = r15.qwL
            r15.qwT = r1
            r15.qwS = r8
            r15.qvZ = r14
        L11d:
            int r1 = r15.qvZ
            if (r1 != r13) goto L2b
            int r1 = r15.qwf
            int r2 = r15.qwu
            int r1 = r1 - r2
            r15.qwf = r1
            int r1 = r15.qwf
            if (r1 > 0) goto L1a7
            r15.qvZ = r7
            goto L2b
        L130:
            int r1 = r15.pos
            int r1 = r1 + (-1)
            r1 = r1 & r6
            r1 = r0[r1]
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r15.pos
            int r1 = r1 + (-2)
            r1 = r1 & r6
            r1 = r0[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
        L142:
            int r3 = r15.j
            int r4 = r15.qwu
            if (r3 >= r4) goto L11d
            org.brotli.dec.a.a(r9)
            int[] r3 = r15.qwm
            r3 = r3[r8]
            if (r3 != 0) goto L154
            a(r15)
        L154:
            byte[] r3 = r15.qww
            int r4 = r15.qwx
            int[] r5 = org.brotli.dec.c.qvF
            int r10 = r15.qwz
            int r10 = r10 + r2
            r5 = r5[r10]
            int[] r10 = org.brotli.dec.c.qvF
            int r11 = r15.qwA
            int r1 = r1 + r11
            r1 = r10[r1]
            r1 = r1 | r5
            int r1 = r1 + r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int[] r3 = r15.qwm
            r4 = r3[r8]
            int r4 = r4 + (-1)
            r3[r8] = r4
            org.brotli.dec.a.b(r9)
            org.brotli.dec.g r3 = r15.qwj
            int[] r3 = r3.qvP
            org.brotli.dec.g r4 = r15.qwj
            int[] r4 = r4.qvQ
            r1 = r4[r1]
            int r3 = a(r3, r1, r9)
            int r1 = r15.pos
            byte r4 = (byte) r3
            r0[r1] = r4
            int r1 = r15.j
            int r1 = r1 + 1
            r15.j = r1
            int r1 = r15.pos
            int r4 = r1 + 1
            r15.pos = r4
            if (r1 != r6) goto L1a4
            r15.qwa = r13
            int r1 = r15.qwL
            r15.qwT = r1
            r15.qwS = r8
            r15.qvZ = r14
            goto L11d
        L1a4:
            r1 = r2
            r2 = r3
            goto L142
        L1a7:
            int r1 = r15.qwC
            if (r1 >= 0) goto L219
            org.brotli.dec.a.a(r9)
            int[] r1 = r15.qwm
            r2 = 2
            r1 = r1[r2]
            if (r1 != 0) goto L1b8
            c(r15)
        L1b8:
            int[] r1 = r15.qwm
            r2 = 2
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r9)
            org.brotli.dec.g r1 = r15.qwl
            int[] r2 = r1.qvP
            org.brotli.dec.g r1 = r15.qwl
            int[] r3 = r1.qvQ
            byte[] r4 = r15.qwD
            int r5 = r15.qwy
            int r1 = r15.qwH
            r10 = 4
            if (r1 <= r10) goto L232
            r1 = r7
        L1d6:
            int r1 = r1 + r5
            r1 = r4[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r3[r1]
            int r1 = a(r2, r1, r9)
            r15.qwC = r1
            int r1 = r15.qwC
            int r2 = r15.qwE
            if (r1 < r2) goto L219
            int r1 = r15.qwC
            int r2 = r15.qwE
            int r1 = r1 - r2
            r15.qwC = r1
            int r1 = r15.qwC
            int r2 = r15.qwF
            r1 = r1 & r2
            int r2 = r15.qwC
            int r3 = r15.qwG
            int r2 = r2 >>> r3
            r15.qwC = r2
            int r2 = r15.qwC
            int r2 = r2 >>> 1
            int r2 = r2 + 1
            int r3 = r15.qwC
            r3 = r3 & 1
            int r3 = r3 + 2
            int r3 = r3 << r2
            int r3 = r3 + (-4)
            int r4 = r15.qwE
            int r1 = r1 + r4
            int r2 = org.brotli.dec.a.a(r9, r2)
            int r2 = r2 + r3
            int r3 = r15.qwG
            int r2 = r2 << r3
            int r1 = r1 + r2
            r15.qwC = r1
        L219:
            int r1 = r15.qwC
            int[] r2 = r15.qwp
            int r3 = r15.qwq
            int r1 = a(r1, r2, r3)
            r15.distance = r1
            int r1 = r15.distance
            if (r1 >= 0) goto L237
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Negative distance"
            r0.<init>(r1)
            throw r0
        L232:
            int r1 = r15.qwH
            int r1 = r1 + (-2)
            goto L1d6
        L237:
            int r1 = r15.hkK
            int r2 = r15.qwJ
            if (r1 == r2) goto L257
            int r1 = r15.pos
            int r2 = r15.qwJ
            if (r1 >= r2) goto L257
            int r1 = r15.pos
            r15.hkK = r1
        L247:
            int r1 = r15.pos
            r15.qwI = r1
            int r1 = r15.distance
            int r2 = r15.hkK
            if (r1 <= r2) goto L25c
            r1 = 9
            r15.qvZ = r1
            goto L2b
        L257:
            int r1 = r15.qwJ
            r15.hkK = r1
            goto L247
        L25c:
            int r1 = r15.qwC
            if (r1 <= 0) goto L270
            int[] r1 = r15.qwp
            int r2 = r15.qwq
            r2 = r2 & 3
            int r3 = r15.distance
            r1[r2] = r3
            int r1 = r15.qwq
            int r1 = r1 + 1
            r15.qwq = r1
        L270:
            int r1 = r15.qwH
            int r2 = r15.qwf
            if (r1 <= r2) goto L27f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L27f:
            r15.j = r8
            r1 = 7
            r15.qvZ = r1
        L284:
            int r1 = r15.pos
            int r2 = r15.distance
            int r1 = r1 - r2
            r3 = r1 & r6
            int r2 = r15.pos
            int r1 = r15.qwH
            int r4 = r15.j
            int r10 = r1 - r4
            int r1 = r3 + r10
            if (r1 >= r6) goto L2c4
            int r1 = r2 + r10
            if (r1 >= r6) goto L2c4
            r1 = r8
            r4 = r3
        L29d:
            if (r1 >= r10) goto L2ac
            int r3 = r2 + 1
            int r5 = r4 + 1
            r4 = r0[r4]
            r0[r2] = r4
            int r1 = r1 + 1
            r2 = r3
            r4 = r5
            goto L29d
        L2ac:
            int r1 = r15.j
            int r1 = r1 + r10
            r15.j = r1
            int r1 = r15.qwf
            int r1 = r1 - r10
            r15.qwf = r1
            int r1 = r15.pos
            int r1 = r1 + r10
            r15.pos = r1
        L2bb:
            int r1 = r15.qvZ
            r2 = 7
            if (r1 != r2) goto L2b
            r15.qvZ = r7
            goto L2b
        L2c4:
            int r1 = r15.j
            int r2 = r15.qwH
            if (r1 >= r2) goto L2bb
            int r1 = r15.pos
            int r2 = r15.pos
            int r3 = r15.distance
            int r2 = r2 - r3
            r2 = r2 & r6
            r2 = r0[r2]
            r0[r1] = r2
            int r1 = r15.qwf
            int r1 = r1 + (-1)
            r15.qwf = r1
            int r1 = r15.j
            int r1 = r1 + 1
            r15.j = r1
            int r1 = r15.pos
            int r2 = r1 + 1
            r15.pos = r2
            if (r1 != r6) goto L2c4
            r1 = 7
            r15.qwa = r1
            int r1 = r15.qwL
            r15.qwT = r1
            r15.qwS = r8
            r15.qvZ = r14
            goto L2bb
        L2f6:
            int r1 = r15.qwH
            r2 = 4
            if (r1 < r2) goto L362
            int r1 = r15.qwH
            r2 = 24
            if (r1 > r2) goto L362
            int[] r1 = org.brotli.dec.e.qvL
            int r2 = r15.qwH
            r1 = r1[r2]
            int r2 = r15.distance
            int r3 = r15.hkK
            int r2 = r2 - r3
            int r2 = r2 + (-1)
            int[] r3 = org.brotli.dec.e.qvM
            int r4 = r15.qwH
            r3 = r3[r4]
            int r4 = r12 << r3
            int r4 = r4 + (-1)
            r4 = r4 & r2
            int r5 = r2 >>> r3
            int r2 = r15.qwH
            int r2 = r2 * r4
            int r3 = r1 + r2
            org.brotli.dec.k[] r1 = org.brotli.dec.k.qwV
            int r1 = r1.length
            if (r5 >= r1) goto L359
            int r1 = r15.qwI
            byte[] r2 = org.brotli.dec.e.getData()
            int r4 = r15.qwH
            org.brotli.dec.k[] r10 = org.brotli.dec.k.qwV
            r5 = r10[r5]
            int r1 = org.brotli.dec.k.a(r0, r1, r2, r3, r4, r5)
            int r2 = r15.qwI
            int r2 = r2 + r1
            r15.qwI = r2
            int r2 = r15.pos
            int r2 = r2 + r1
            r15.pos = r2
            int r2 = r15.qwf
            int r1 = r2 - r1
            r15.qwf = r1
            int r1 = r15.qwI
            int r2 = r15.qwL
            if (r1 < r2) goto L36b
            r1 = 8
            r15.qwa = r1
            int r1 = r15.qwL
            r15.qwT = r1
            r15.qwS = r8
            r15.qvZ = r14
            goto L2b
        L359:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L362:
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L36b:
            r15.qvZ = r7
            goto L2b
        L36f:
            int r1 = r15.qwL
            int r2 = r15.qwI
            int r3 = r15.qwL
            int r2 = r2 - r3
            java.lang.System.arraycopy(r0, r1, r0, r8, r2)
            r15.qvZ = r7
            goto L2b
        L37d:
            int r1 = r15.qwf
            if (r1 <= 0) goto L390
            org.brotli.dec.a.a(r9)
            r1 = 8
            org.brotli.dec.a.a(r9, r1)
            int r1 = r15.qwf
            int r1 = r1 + (-1)
            r15.qwf = r1
            goto L37d
        L390:
            r15.qvZ = r12
            goto L2b
        L394:
            g(r15)
            goto L2b
        L399:
            boolean r1 = h(r15)
            if (r1 != 0) goto L3a0
        L39f:
            return
        L3a0:
            int r1 = r15.pos
            int r2 = r15.qwJ
            if (r1 < r2) goto L3aa
            int r1 = r15.qwJ
            r15.hkK = r1
        L3aa:
            int r1 = r15.pos
            r1 = r1 & r6
            r15.pos = r1
            int r1 = r15.qwa
            r15.qvZ = r1
            goto L2b
        L3b5:
            int r0 = r15.qvZ
            r1 = 10
            if (r0 != r1) goto L39f
            int r0 = r15.qwf
            if (r0 >= 0) goto L3c8
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L3c8:
            org.brotli.dec.a.f(r9)
            org.brotli.dec.a r0 = r15.qwb
            org.brotli.dec.a.a(r0, r12)
            goto L39f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }
}
