package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class d {
    private static final int[] qcr = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] qcs = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] qct = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] qcu = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

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
        jVar.qcQ = a.a(aVar, 1) == 1;
        jVar.qcP = 0;
        jVar.qcR = false;
        jVar.qcS = false;
        if (!jVar.qcQ || a.a(aVar, 1) == 0) {
            int a2 = a.a(aVar, 2) + 4;
            if (a2 == 7) {
                jVar.qcS = true;
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
                        jVar.qcP = (a4 << (i * 8)) | jVar.qcP;
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
                    jVar.qcP = (a5 << (i2 * 4)) | jVar.qcP;
                }
            }
            jVar.qcP++;
            if (!jVar.qcQ) {
                jVar.qcR = a.a(aVar, 1) == 1;
            }
        }
    }

    private static int a(int[] iArr, int i, a aVar) {
        int i2 = (int) (aVar.qck >>> aVar.bitOffset);
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
        int a2 = a(iArr, i, aVar);
        return i.qcB[a2] + a.a(aVar, i.qcC[a2]);
    }

    private static int a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(qcs[i] + i2) & 3] + qct[i] : (i - 16) + 1;
    }

    private static void c(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static void y(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                c(iArr, i4);
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
            int i12 = ((int) (aVar.qck >>> aVar.bitOffset)) & 31;
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
                int a2 = a.a(aVar, i15) + 3 + (i2 > 0 ? (i2 - 2) << i15 : i2);
                int i17 = a2 - i2;
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
                    i4 = a2;
                    i5 = i19;
                    i10 = i16;
                    i6 = i8;
                } else {
                    i3 = i11;
                    i4 = a2;
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
        int a2;
        boolean z = true;
        a.a(aVar);
        int[] iArr2 = new int[i];
        if (a.a(aVar, 2) == 1) {
            int[] iArr3 = new int[4];
            int a3 = a.a(aVar, 2) + 1;
            int i3 = 0;
            for (int i4 = i - 1; i4 != 0; i4 >>= 1) {
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
            for (int i8 = a2; i8 < 18 && i6 > 0; i8++) {
                int i9 = qcr[i8];
                a.b(aVar);
                int i10 = ((int) (aVar.qck >>> aVar.bitOffset)) & 15;
                aVar.bitOffset += qcu[i10] >> 16;
                int i11 = qcu[i10] & 65535;
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
            l.A(bArr, 0, i);
            return h;
        }
        int a2 = a.a(aVar, 1) == 1 ? a.a(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        a(h + a2, iArr, 0, aVar);
        int i3 = 0;
        while (i3 < i) {
            a.a(aVar);
            a.b(aVar);
            int a3 = a(iArr, 0, aVar);
            if (a3 == 0) {
                bArr[i3] = 0;
                i2 = i3 + 1;
            } else if (a3 <= a2) {
                int a4 = a.a(aVar, a3) + (1 << a3);
                i2 = i3;
                int i4 = a4;
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
                bArr[i3] = (byte) (a3 - a2);
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        if (a.a(aVar, 1) == 1) {
            y(bArr, i);
        }
        return h;
    }

    private static void a(j jVar, int i) {
        int i2;
        a aVar = jVar.qcL;
        int[] iArr = jVar.qcY;
        int i3 = i * 2;
        a.b(aVar);
        int a2 = a(jVar.qcN, i * 1080, aVar);
        jVar.qcW[i] = b(jVar.qcO, i * 1080, aVar);
        if (a2 == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (a2 == 0) {
            i2 = iArr[i3];
        } else {
            i2 = a2 - 2;
        }
        if (i2 >= jVar.qcX[i]) {
            i2 -= jVar.qcX[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    private static void a(j jVar) {
        a(jVar, 0);
        int i = jVar.qcY[1];
        jVar.qdh = i << 6;
        jVar.qdc = jVar.qdg[jVar.qdh] & 255;
        jVar.qdd = jVar.qcT.qcA[jVar.qdc];
        byte b = jVar.qdf[i];
        jVar.qdj = c.qcq[b];
        jVar.qdk = c.qcq[b + 1];
    }

    private static void b(j jVar) {
        a(jVar, 1);
        jVar.qdl = jVar.qcU.qcA[jVar.qcY[3]];
    }

    private static void c(j jVar) {
        a(jVar, 2);
        jVar.qdi = jVar.qcY[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r8.qdu >= 16384) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(j jVar) {
        int i;
        int i2;
        int i3 = 16384;
        int i4 = jVar.qdu;
        if (i4 > jVar.qdw) {
            while ((i4 >> 1) > ((int) jVar.qdw) + jVar.qdx.length) {
                i4 >>= 1;
            }
            if (!jVar.qcQ) {
                if (i4 < 16384) {
                }
            }
        }
        i3 = i4;
        if (i3 > jVar.qdv) {
            byte[] bArr = new byte[i3 + 37];
            if (jVar.qcM != null) {
                System.arraycopy(jVar.qcM, 0, bArr, 0, jVar.qdv);
            } else if (jVar.qdx.length != 0) {
                int length = jVar.qdx.length;
                if (length > jVar.qdt) {
                    i2 = length - jVar.qdt;
                    i = jVar.qdt;
                } else {
                    i = length;
                    i2 = 0;
                }
                System.arraycopy(jVar.qdx, i2, bArr, 0, i);
                jVar.pos = i;
                jVar.qdy = i;
            }
            jVar.qcM = bArr;
            jVar.qdv = i3;
        }
    }

    private static void e(j jVar) {
        a aVar = jVar.qcL;
        if (jVar.qcQ) {
            jVar.qcK = 10;
            jVar.qdC = jVar.pos;
            jVar.pHt = 0;
            jVar.qcJ = 12;
            return;
        }
        jVar.qcT.qcz = null;
        jVar.qcT.qcA = null;
        jVar.qcU.qcz = null;
        jVar.qcU.qcA = null;
        jVar.qcV.qcz = null;
        jVar.qcV.qcA = null;
        a.a(aVar);
        a(aVar, jVar);
        if (jVar.qcP != 0 || jVar.qcS) {
            if (jVar.qcR || jVar.qcS) {
                a.f(aVar);
                jVar.qcJ = jVar.qcS ? 4 : 5;
            } else {
                jVar.qcJ = 2;
            }
            if (!jVar.qcS) {
                jVar.qdw += jVar.qcP;
                if (jVar.qdv < jVar.qdu) {
                    d(jVar);
                }
            }
        }
    }

    private static void f(j jVar) {
        a aVar = jVar.qcL;
        for (int i = 0; i < 3; i++) {
            jVar.qcX[i] = h(aVar) + 1;
            jVar.qcW[i] = 268435456;
            if (jVar.qcX[i] > 1) {
                a(jVar.qcX[i] + 2, jVar.qcN, i * 1080, aVar);
                a(26, jVar.qcO, i * 1080, aVar);
                jVar.qcW[i] = b(jVar.qcO, i * 1080, aVar);
            }
        }
        a.a(aVar);
        jVar.qdq = a.a(aVar, 2);
        jVar.qdo = (a.a(aVar, 4) << jVar.qdq) + 16;
        jVar.qdp = (1 << jVar.qdq) - 1;
        int i2 = (48 << jVar.qdq) + jVar.qdo;
        jVar.qdf = new byte[jVar.qcX[0]];
        int i3 = 0;
        while (i3 < jVar.qcX[0]) {
            int min = Math.min(i3 + 96, jVar.qcX[0]);
            while (i3 < min) {
                jVar.qdf[i3] = (byte) (a.a(aVar, 2) << 1);
                i3++;
            }
            a.a(aVar);
        }
        jVar.qdg = new byte[jVar.qcX[0] << 6];
        int a2 = a(jVar.qcX[0] << 6, jVar.qdg, aVar);
        jVar.qdb = true;
        int i4 = 0;
        while (true) {
            if (i4 < (jVar.qcX[0] << 6)) {
                if (jVar.qdg[i4] == (i4 >> 6)) {
                    i4++;
                } else {
                    jVar.qdb = false;
                    break;
                }
            } else {
                break;
            }
        }
        jVar.qdn = new byte[jVar.qcX[2] << 2];
        int a3 = a(jVar.qcX[2] << 2, jVar.qdn, aVar);
        g.a(jVar.qcT, 256, a2);
        g.a(jVar.qcU, 704, jVar.qcX[1]);
        g.a(jVar.qcV, i2, a3);
        g.a(jVar.qcT, aVar);
        g.a(jVar.qcU, aVar);
        g.a(jVar.qcV, aVar);
        jVar.qdh = 0;
        jVar.qdi = 0;
        jVar.qdj = c.qcq[jVar.qdf[0]];
        jVar.qdk = c.qcq[jVar.qdf[0] + 1];
        jVar.qdc = 0;
        jVar.qdd = jVar.qcT.qcA[0];
        jVar.qdl = jVar.qcU.qcA[0];
        int[] iArr = jVar.qcY;
        int[] iArr2 = jVar.qcY;
        jVar.qcY[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = jVar.qcY;
        int[] iArr4 = jVar.qcY;
        jVar.qcY[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void g(j jVar) {
        a aVar = jVar.qcL;
        byte[] bArr = jVar.qcM;
        if (jVar.qcP <= 0) {
            a.d(aVar);
            jVar.qcJ = 1;
            return;
        }
        int min = Math.min(jVar.qdv - jVar.pos, jVar.qcP);
        a.a(aVar, bArr, jVar.pos, min);
        jVar.qcP -= min;
        jVar.pos += min;
        if (jVar.pos == jVar.qdv) {
            jVar.qcK = 5;
            jVar.qdC = jVar.qdv;
            jVar.pHt = 0;
            jVar.qcJ = 12;
            return;
        }
        a.d(aVar);
        jVar.qcJ = 1;
    }

    private static boolean h(j jVar) {
        if (jVar.qdy != 0) {
            jVar.pHt += jVar.qdy;
            jVar.qdy = 0;
        }
        int min = Math.min(jVar.qdA - jVar.qdB, jVar.qdC - jVar.pHt);
        if (min != 0) {
            System.arraycopy(jVar.qcM, jVar.pHt, jVar.output, jVar.qdz + jVar.qdB, min);
            jVar.qdB += min;
            jVar.pHt = min + jVar.pHt;
        }
        return jVar.qdB < jVar.qdA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.qdx = bArr;
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
            int r0 = r11.qcJ
            if (r0 != 0) goto Ld
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress until initialized"
            r0.<init>(r1)
            throw r0
        Ld:
            int r0 = r11.qcJ
            r1 = 11
            if (r0 != r1) goto L1c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't decompress after close"
            r0.<init>(r1)
            throw r0
        L1c:
            org.brotli.dec.a r7 = r11.qcL
            int r0 = r11.qdv
            int r1 = r0 + (-1)
            byte[] r0 = r11.qcM
            r6 = r1
        L25:
            int r1 = r11.qcJ
            r2 = 10
            if (r1 == r2) goto L3d1
            int r1 = r11.qcJ
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
            int r2 = r11.qcJ
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L4c:
            int r0 = r11.qcP
            if (r0 >= 0) goto L59
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L59:
            e(r11)
            int r0 = r11.qdv
            int r1 = r0 + (-1)
            byte[] r0 = r11.qcM
            r6 = r1
            goto L25
        L64:
            f(r11)
            r1 = 3
            r11.qcJ = r1
        L6a:
            int r1 = r11.qcP
            if (r1 > 0) goto L72
            r1 = 1
            r11.qcJ = r1
            goto L25
        L72:
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.qcW
            r2 = 1
            r1 = r1[r2]
            if (r1 != 0) goto L7f
            b(r11)
        L7f:
            int[] r1 = r11.qcW
            r2 = 1
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.qcU
            int[] r1 = r1.qcz
            int r2 = r11.qdl
            int r2 = a(r1, r2, r7)
            int r1 = r2 >>> 6
            r3 = 0
            r11.qdm = r3
            r3 = 2
            if (r1 < r3) goto La2
            int r1 = r1 + (-2)
            r3 = -1
            r11.qdm = r3
        La2:
            int[] r3 = org.brotli.dec.i.qcH
            r3 = r3[r1]
            int r4 = r2 >>> 3
            r4 = r4 & 7
            int r3 = r3 + r4
            int[] r4 = org.brotli.dec.i.qcI
            r1 = r4[r1]
            r2 = r2 & 7
            int r1 = r1 + r2
            int[] r2 = org.brotli.dec.i.qcD
            r2 = r2[r3]
            int[] r4 = org.brotli.dec.i.qcE
            r3 = r4[r3]
            int r3 = org.brotli.dec.a.a(r7, r3)
            int r2 = r2 + r3
            r11.qde = r2
            int[] r2 = org.brotli.dec.i.qcF
            r2 = r2[r1]
            int[] r3 = org.brotli.dec.i.qcG
            r1 = r3[r1]
            int r1 = org.brotli.dec.a.a(r7, r1)
            int r1 = r1 + r2
            r11.qdr = r1
            r1 = 0
            r11.j = r1
            r1 = 6
            r11.qcJ = r1
        Ld6:
            boolean r1 = r11.qdb
            if (r1 == 0) goto L139
        Lda:
            int r1 = r11.j
            int r2 = r11.qde
            if (r1 >= r2) goto L124
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.qcW
            r2 = 0
            r1 = r1[r2]
            if (r1 != 0) goto Led
            a(r11)
        Led:
            int[] r1 = r11.qcW
            r2 = 0
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            int r1 = r11.pos
            org.brotli.dec.g r2 = r11.qcT
            int[] r2 = r2.qcz
            int r3 = r11.qdd
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
            r11.qcK = r1
            int r1 = r11.qdv
            r11.qdC = r1
            r1 = 0
            r11.pHt = r1
            r1 = 12
            r11.qcJ = r1
        L124:
            int r1 = r11.qcJ
            r2 = 6
            if (r1 != r2) goto L25
            int r1 = r11.qcP
            int r2 = r11.qde
            int r1 = r1 - r2
            r11.qcP = r1
            int r1 = r11.qcP
            if (r1 > 0) goto L1b7
            r1 = 3
            r11.qcJ = r1
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
            int r4 = r11.qde
            if (r3 >= r4) goto L124
            org.brotli.dec.a.a(r7)
            int[] r3 = r11.qcW
            r4 = 0
            r3 = r3[r4]
            if (r3 != 0) goto L15e
            a(r11)
        L15e:
            byte[] r3 = r11.qdg
            int r4 = r11.qdh
            int[] r5 = org.brotli.dec.c.qcp
            int r8 = r11.qdj
            int r8 = r8 + r2
            r5 = r5[r8]
            int[] r8 = org.brotli.dec.c.qcp
            int r9 = r11.qdk
            int r1 = r1 + r9
            r1 = r8[r1]
            r1 = r1 | r5
            int r1 = r1 + r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int[] r3 = r11.qcW
            r4 = 0
            r5 = r3[r4]
            int r5 = r5 + (-1)
            r3[r4] = r5
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r3 = r11.qcT
            int[] r3 = r3.qcz
            org.brotli.dec.g r4 = r11.qcT
            int[] r4 = r4.qcA
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
            r11.qcK = r1
            int r1 = r11.qdv
            r11.qdC = r1
            r1 = 0
            r11.pHt = r1
            r1 = 12
            r11.qcJ = r1
            goto L124
        L1b3:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L14b
        L1b7:
            int r1 = r11.qdm
            if (r1 >= 0) goto L229
            org.brotli.dec.a.a(r7)
            int[] r1 = r11.qcW
            r2 = 2
            r1 = r1[r2]
            if (r1 != 0) goto L1c8
            c(r11)
        L1c8:
            int[] r1 = r11.qcW
            r2 = 2
            r3 = r1[r2]
            int r3 = r3 + (-1)
            r1[r2] = r3
            org.brotli.dec.a.b(r7)
            org.brotli.dec.g r1 = r11.qcV
            int[] r2 = r1.qcz
            org.brotli.dec.g r1 = r11.qcV
            int[] r3 = r1.qcA
            byte[] r4 = r11.qdn
            int r5 = r11.qdi
            int r1 = r11.qdr
            r8 = 4
            if (r1 <= r8) goto L242
            r1 = 3
        L1e6:
            int r1 = r1 + r5
            r1 = r4[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r3[r1]
            int r1 = a(r2, r1, r7)
            r11.qdm = r1
            int r1 = r11.qdm
            int r2 = r11.qdo
            if (r1 < r2) goto L229
            int r1 = r11.qdm
            int r2 = r11.qdo
            int r1 = r1 - r2
            r11.qdm = r1
            int r1 = r11.qdm
            int r2 = r11.qdp
            r1 = r1 & r2
            int r2 = r11.qdm
            int r3 = r11.qdq
            int r2 = r2 >>> r3
            r11.qdm = r2
            int r2 = r11.qdm
            int r2 = r2 >>> 1
            int r2 = r2 + 1
            int r3 = r11.qdm
            r3 = r3 & 1
            int r3 = r3 + 2
            int r3 = r3 << r2
            int r3 = r3 + (-4)
            int r4 = r11.qdo
            int r1 = r1 + r4
            int r2 = org.brotli.dec.a.a(r7, r2)
            int r2 = r2 + r3
            int r3 = r11.qdq
            int r2 = r2 << r3
            int r1 = r1 + r2
            r11.qdm = r1
        L229:
            int r1 = r11.qdm
            int[] r2 = r11.qcZ
            int r3 = r11.qda
            int r1 = a(r1, r2, r3)
            r11.distance = r1
            int r1 = r11.distance
            if (r1 >= 0) goto L247
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Negative distance"
            r0.<init>(r1)
            throw r0
        L242:
            int r1 = r11.qdr
            int r1 = r1 + (-2)
            goto L1e6
        L247:
            int r1 = r11.gPJ
            int r2 = r11.qdt
            if (r1 == r2) goto L267
            int r1 = r11.pos
            int r2 = r11.qdt
            if (r1 >= r2) goto L267
            int r1 = r11.pos
            r11.gPJ = r1
        L257:
            int r1 = r11.pos
            r11.qds = r1
            int r1 = r11.distance
            int r2 = r11.gPJ
            if (r1 <= r2) goto L26c
            r1 = 9
            r11.qcJ = r1
            goto L25
        L267:
            int r1 = r11.qdt
            r11.gPJ = r1
            goto L257
        L26c:
            int r1 = r11.qdm
            if (r1 <= 0) goto L280
            int[] r1 = r11.qcZ
            int r2 = r11.qda
            r2 = r2 & 3
            int r3 = r11.distance
            r1[r2] = r3
            int r1 = r11.qda
            int r1 = r1 + 1
            r11.qda = r1
        L280:
            int r1 = r11.qdr
            int r2 = r11.qcP
            if (r1 <= r2) goto L28f
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid backward reference"
            r0.<init>(r1)
            throw r0
        L28f:
            r1 = 0
            r11.j = r1
            r1 = 7
            r11.qcJ = r1
        L295:
            int r1 = r11.pos
            int r2 = r11.distance
            int r1 = r1 - r2
            r3 = r1 & r6
            int r2 = r11.pos
            int r1 = r11.qdr
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
            int r1 = r11.qcP
            int r1 = r1 - r8
            r11.qcP = r1
            int r1 = r11.pos
            int r1 = r1 + r8
            r11.pos = r1
        L2cc:
            int r1 = r11.qcJ
            r2 = 7
            if (r1 != r2) goto L25
            r1 = 3
            r11.qcJ = r1
            goto L25
        L2d6:
            int r1 = r11.j
            int r2 = r11.qdr
            if (r1 >= r2) goto L2cc
            int r1 = r11.pos
            int r2 = r11.pos
            int r3 = r11.distance
            int r2 = r2 - r3
            r2 = r2 & r6
            r2 = r0[r2]
            r0[r1] = r2
            int r1 = r11.qcP
            int r1 = r1 + (-1)
            r11.qcP = r1
            int r1 = r11.j
            int r1 = r1 + 1
            r11.j = r1
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            if (r1 != r6) goto L2d6
            r1 = 7
            r11.qcK = r1
            int r1 = r11.qdv
            r11.qdC = r1
            r1 = 0
            r11.pHt = r1
            r1 = 12
            r11.qcJ = r1
            goto L2cc
        L30b:
            int r1 = r11.qdr
            r2 = 4
            if (r1 < r2) goto L37a
            int r1 = r11.qdr
            r2 = 24
            if (r1 > r2) goto L37a
            int[] r1 = org.brotli.dec.e.qcv
            int r2 = r11.qdr
            r1 = r1[r2]
            int r2 = r11.distance
            int r3 = r11.gPJ
            int r2 = r2 - r3
            int r2 = r2 + (-1)
            int[] r3 = org.brotli.dec.e.qcw
            int r4 = r11.qdr
            r3 = r3[r4]
            r4 = 1
            int r4 = r4 << r3
            int r4 = r4 + (-1)
            r4 = r4 & r2
            int r5 = r2 >>> r3
            int r2 = r11.qdr
            int r2 = r2 * r4
            int r3 = r1 + r2
            org.brotli.dec.k[] r1 = org.brotli.dec.k.qdF
            int r1 = r1.length
            if (r5 >= r1) goto L371
            int r1 = r11.qds
            byte[] r2 = org.brotli.dec.e.getData()
            int r4 = r11.qdr
            org.brotli.dec.k[] r8 = org.brotli.dec.k.qdF
            r5 = r8[r5]
            int r1 = org.brotli.dec.k.a(r0, r1, r2, r3, r4, r5)
            int r2 = r11.qds
            int r2 = r2 + r1
            r11.qds = r2
            int r2 = r11.pos
            int r2 = r2 + r1
            r11.pos = r2
            int r2 = r11.qcP
            int r1 = r2 - r1
            r11.qcP = r1
            int r1 = r11.qds
            int r2 = r11.qdv
            if (r1 < r2) goto L383
            r1 = 8
            r11.qcK = r1
            int r1 = r11.qdv
            r11.qdC = r1
            r1 = 0
            r11.pHt = r1
            r1 = 12
            r11.qcJ = r1
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
            r11.qcJ = r1
            goto L25
        L388:
            int r1 = r11.qdv
            r2 = 0
            int r3 = r11.qds
            int r4 = r11.qdv
            int r3 = r3 - r4
            java.lang.System.arraycopy(r0, r1, r0, r2, r3)
            r1 = 3
            r11.qcJ = r1
            goto L25
        L398:
            int r1 = r11.qcP
            if (r1 <= 0) goto L3ab
            org.brotli.dec.a.a(r7)
            r1 = 8
            org.brotli.dec.a.a(r7, r1)
            int r1 = r11.qcP
            int r1 = r1 + (-1)
            r11.qcP = r1
            goto L398
        L3ab:
            r1 = 1
            r11.qcJ = r1
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
            int r2 = r11.qdt
            if (r1 < r2) goto L3c6
            int r1 = r11.qdt
            r11.gPJ = r1
        L3c6:
            int r1 = r11.pos
            r1 = r1 & r6
            r11.pos = r1
            int r1 = r11.qcK
            r11.qcJ = r1
            goto L25
        L3d1:
            int r0 = r11.qcJ
            r1 = 10
            if (r0 != r1) goto L3bb
            int r0 = r11.qcP
            if (r0 >= 0) goto L3e4
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Invalid metablock length"
            r0.<init>(r1)
            throw r0
        L3e4:
            org.brotli.dec.a.f(r7)
            org.brotli.dec.a r0 = r11.qcL
            r1 = 1
            org.brotli.dec.a.a(r0, r1)
            goto L3bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }
}
