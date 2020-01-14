package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.coremedia.iso.boxes.MetaBox;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.c.a;
import com.google.android.exoplayer2.extractor.c.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b {
    private static final int mic = v.Qr("vide");
    private static final int mie = v.Qr("soun");
    private static final int mif = v.Qr("text");
    private static final int mig = v.Qr("sbtl");
    private static final int mih = v.Qr("subt");
    private static final int mii = v.Qr("clcp");
    private static final int mij = v.Qr("cenc");
    private static final int mhL = v.Qr(MetaBox.TYPE);

    /* renamed from: com.google.android.exoplayer2.extractor.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private interface InterfaceC0667b {
        int dtP();

        boolean dtQ();

        int getSampleCount();
    }

    public static j a(a.C0666a c0666a, a.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long h;
        a.C0666a JH = c0666a.JH(com.google.android.exoplayer2.extractor.c.a.mgO);
        int n = n(JH.JG(com.google.android.exoplayer2.extractor.c.a.mhc).mib);
        if (n == -1) {
            return null;
        }
        f m = m(c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mgY).mib);
        long j2 = j == -9223372036854775807L ? m.duration : j;
        long l = l(bVar.mib);
        if (j2 == -9223372036854775807L) {
            h = -9223372036854775807L;
        } else {
            h = v.h(j2, TimeUtils.NANOS_PER_MS, l);
        }
        a.C0666a JH2 = JH.JH(com.google.android.exoplayer2.extractor.c.a.mgP).JH(com.google.android.exoplayer2.extractor.c.a.mgQ);
        Pair<Long, String> o = o(JH.JG(com.google.android.exoplayer2.extractor.c.a.mhb).mib);
        c a2 = a(JH2.JG(com.google.android.exoplayer2.extractor.c.a.mhd).mib, m.id, m.rotationDegrees, (String) o.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> b = b(c0666a.JH(com.google.android.exoplayer2.extractor.c.a.mgZ));
            jArr2 = (long[]) b.second;
            jArr = (long[]) b.first;
        }
        if (a2.lYQ == null) {
            return null;
        }
        return new j(m.id, n, ((Long) o.first).longValue(), l, h, a2.lYQ, a2.mis, a2.mir, a2.meg, jArr, jArr2);
    }

    public static m a(j jVar, a.C0666a c0666a, com.google.android.exoplayer2.extractor.i iVar) throws ParserException {
        InterfaceC0667b eVar;
        int i;
        com.google.android.exoplayer2.util.l lVar;
        int i2;
        long[] jArr;
        int[] iArr;
        int i3;
        long[] jArr2;
        int[] iArr2;
        long j;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        a.b JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhA);
        if (JG != null) {
            eVar = new d(JG);
        } else {
            a.b JG2 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhB);
            if (JG2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            eVar = new e(JG2);
        }
        int sampleCount = eVar.getSampleCount();
        if (sampleCount == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z2 = false;
        a.b JG3 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhC);
        if (JG3 == null) {
            z2 = true;
            JG3 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhD);
        }
        com.google.android.exoplayer2.util.l lVar2 = JG3.mib;
        com.google.android.exoplayer2.util.l lVar3 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhz).mib;
        com.google.android.exoplayer2.util.l lVar4 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhw).mib;
        a.b JG4 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhx);
        com.google.android.exoplayer2.util.l lVar5 = JG4 != null ? JG4.mib : null;
        a.b JG5 = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mhy);
        com.google.android.exoplayer2.util.l lVar6 = JG5 != null ? JG5.mib : null;
        a aVar = new a(lVar3, lVar2, z2);
        lVar4.setPosition(12);
        int dys = lVar4.dys() - 1;
        int dys2 = lVar4.dys();
        int dys3 = lVar4.dys();
        int i9 = 0;
        if (lVar6 != null) {
            lVar6.setPosition(12);
            i9 = lVar6.dys();
        }
        if (lVar5 == null) {
            i = -1;
            lVar = lVar5;
            i2 = 0;
        } else {
            lVar5.setPosition(12);
            int dys4 = lVar5.dys();
            if (dys4 <= 0) {
                i = -1;
                lVar = null;
                i2 = dys4;
            } else {
                i = lVar5.dys() - 1;
                lVar = lVar5;
                i2 = dys4;
            }
        }
        if (!(eVar.dtQ() && "audio/raw".equals(jVar.lYQ.sampleMimeType) && dys == 0 && i9 == 0 && i2 == 0)) {
            long[] jArr3 = new long[sampleCount];
            int[] iArr3 = new int[sampleCount];
            long[] jArr4 = new long[sampleCount];
            int[] iArr4 = new int[sampleCount];
            long j2 = 0;
            int i10 = 0;
            int i11 = dys2;
            int i12 = 0;
            int i13 = i2;
            int i14 = 0;
            int i15 = i;
            int i16 = i9;
            long j3 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = dys3;
            int i20 = dys;
            int i21 = i15;
            while (i10 < sampleCount) {
                long j4 = j2;
                int i22 = i18;
                while (i22 == 0) {
                    com.google.android.exoplayer2.util.a.checkState(aVar.moveNext());
                    j4 = aVar.offset;
                    i22 = aVar.mik;
                }
                if (lVar6 != null) {
                    while (i12 == 0 && i16 > 0) {
                        i12 = lVar6.dys();
                        i14 = lVar6.readInt();
                        i16--;
                    }
                    i12--;
                }
                jArr3[i10] = j4;
                iArr3[i10] = eVar.dtP();
                if (iArr3[i10] > i17) {
                    i17 = iArr3[i10];
                }
                jArr4[i10] = i14 + j3;
                iArr4[i10] = lVar == null ? 1 : 0;
                if (i10 == i21) {
                    iArr4[i10] = 1;
                    int i23 = i13 - 1;
                    if (i23 > 0) {
                        i21 = lVar.dys() - 1;
                        i13 = i23;
                    } else {
                        i13 = i23;
                    }
                }
                long j5 = i19 + j3;
                int i24 = i11 - 1;
                if (i24 != 0 || i20 <= 0) {
                    int i25 = i19;
                    i7 = i24;
                    i8 = i25;
                } else {
                    i7 = lVar4.dys();
                    i8 = lVar4.readInt();
                    i20--;
                }
                long j6 = j4 + iArr3[i10];
                int i26 = i22 - 1;
                i10++;
                j2 = j6;
                i11 = i7;
                i19 = i8;
                i18 = i26;
                j3 = j5;
            }
            com.google.android.exoplayer2.util.a.checkArgument(i12 == 0);
            while (i16 > 0) {
                com.google.android.exoplayer2.util.a.checkArgument(lVar6.dys() == 0);
                lVar6.readInt();
                i16--;
            }
            if (i13 != 0 || i11 != 0 || i18 != 0 || i20 != 0) {
                Log.w("AtomParsers", "Inconsistent stbl box for track " + jVar.id + ": remainingSynchronizationSamples " + i13 + ", remainingSamplesAtTimestampDelta " + i11 + ", remainingSamplesInChunk " + i18 + ", remainingTimestampDeltaChanges " + i20);
            }
            iArr2 = iArr4;
            jArr2 = jArr4;
            i3 = i17;
            iArr = iArr3;
            jArr = jArr3;
            j = j3;
        } else {
            long[] jArr5 = new long[aVar.length];
            int[] iArr5 = new int[aVar.length];
            while (aVar.moveNext()) {
                jArr5[aVar.index] = aVar.offset;
                iArr5[aVar.index] = aVar.mik;
            }
            d.a a2 = com.google.android.exoplayer2.extractor.c.d.a(eVar.dtP(), jArr5, iArr5, dys3);
            jArr = a2.mdk;
            iArr = a2.mdj;
            i3 = a2.maximumSize;
            jArr2 = a2.miy;
            iArr2 = a2.miz;
            j = 0;
        }
        if (jVar.mjT == null || iVar.dtI()) {
            v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        if (jVar.mjT.length == 1 && jVar.type == 1 && jArr2.length >= 2) {
            long j7 = jVar.mjU[0];
            long h = v.h(jVar.mjT[0], jVar.timescale, jVar.mjR) + j7;
            if (jArr2[0] <= j7 && j7 < jArr2[1] && jArr2[jArr2.length - 1] < h && h <= j) {
                long h2 = v.h(j7 - jArr2[0], jVar.lYQ.sampleRate, jVar.timescale);
                long h3 = v.h(j - h, jVar.lYQ.sampleRate, jVar.timescale);
                if ((h2 != 0 || h3 != 0) && h2 <= 2147483647L && h3 <= 2147483647L) {
                    iVar.encoderDelay = (int) h2;
                    iVar.encoderPadding = (int) h3;
                    v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
                    return new m(jArr, iArr, i3, jArr2, iArr2);
                }
            }
        }
        if (jVar.mjT.length == 1 && jVar.mjT[0] == 0) {
            for (int i27 = 0; i27 < jArr2.length; i27++) {
                jArr2[i27] = v.h(jArr2[i27] - jVar.mjU[0], TimeUtils.NANOS_PER_MS, jVar.timescale);
            }
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        boolean z3 = jVar.type == 1;
        int i28 = 0;
        int i29 = 0;
        boolean z4 = false;
        int i30 = 0;
        while (true) {
            int i31 = i30;
            z = z4;
            int i32 = i29;
            i4 = i28;
            if (i31 >= jVar.mjT.length) {
                break;
            }
            long j8 = jVar.mjU[i31];
            if (j8 != -1) {
                long h4 = v.h(jVar.mjT[i31], jVar.timescale, jVar.mjR);
                int b = v.b(jArr2, j8, true, true);
                i29 = v.b(jArr2, h4 + j8, z3, false);
                i28 = i4 + (i29 - b);
                z4 = z | (i32 != b);
            } else {
                z4 = z;
                i29 = i32;
                i28 = i4;
            }
            i30 = i31 + 1;
        }
        boolean z5 = z | (i4 != sampleCount);
        long[] jArr6 = z5 ? new long[i4] : jArr;
        int[] iArr6 = z5 ? new int[i4] : iArr;
        int i33 = z5 ? 0 : i3;
        int[] iArr7 = z5 ? new int[i4] : iArr2;
        long[] jArr7 = new long[i4];
        int i34 = 0;
        int i35 = 0;
        long j9 = 0;
        int i36 = i33;
        while (i34 < jVar.mjT.length) {
            long j10 = jVar.mjU[i34];
            long j11 = jVar.mjT[i34];
            if (j10 != -1) {
                long h5 = j10 + v.h(j11, jVar.timescale, jVar.mjR);
                int b2 = v.b(jArr2, j10, true, true);
                int b3 = v.b(jArr2, h5, z3, false);
                if (z5) {
                    int i37 = b3 - b2;
                    System.arraycopy(jArr, b2, jArr6, i35, i37);
                    System.arraycopy(iArr, b2, iArr6, i35, i37);
                    System.arraycopy(iArr2, b2, iArr7, i35, i37);
                }
                int i38 = b2;
                int i39 = i35;
                int i40 = i36;
                while (i38 < b3) {
                    jArr7[i39] = v.h(jArr2[i38] - j10, TimeUtils.NANOS_PER_MS, jVar.timescale) + v.h(j9, TimeUtils.NANOS_PER_MS, jVar.mjR);
                    int i41 = (!z5 || iArr6[i39] <= i40) ? i40 : iArr[i38];
                    i39++;
                    i38++;
                    i40 = i41;
                }
                i5 = i39;
                i6 = i40;
            } else {
                i5 = i35;
                i6 = i36;
            }
            i34++;
            i35 = i5;
            j9 += j11;
            i36 = i6;
        }
        boolean z6 = false;
        for (int i42 = 0; i42 < iArr7.length && !z6; i42++) {
            z6 |= (iArr7[i42] & 1) != 0;
        }
        if (!z6) {
            Log.w("AtomParsers", "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
            v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        return new m(jArr6, iArr6, i36, jArr7, iArr7);
    }

    public static Metadata a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        com.google.android.exoplayer2.util.l lVar = bVar.mib;
        lVar.setPosition(8);
        while (lVar.dyh() >= 8) {
            int position = lVar.getPosition();
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhL) {
                lVar.setPosition(position);
                return d(lVar, position + readInt);
            }
            lVar.skipBytes(readInt - 8);
        }
        return null;
    }

    private static Metadata d(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.skipBytes(12);
        while (lVar.getPosition() < i) {
            int position = lVar.getPosition();
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhM) {
                lVar.setPosition(position);
                return e(lVar, position + readInt);
            }
            lVar.skipBytes(readInt - 8);
        }
        return null;
    }

    private static Metadata e(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (lVar.getPosition() < i) {
            Metadata.Entry u = com.google.android.exoplayer2.extractor.c.f.u(lVar);
            if (u != null) {
                arrayList.add(u);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static long l(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        lVar.skipBytes(com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt()) != 0 ? 16 : 8);
        return lVar.readUnsignedInt();
    }

    private static f m(com.google.android.exoplayer2.util.l lVar) {
        long readUnsignedInt;
        int i;
        lVar.setPosition(8);
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
        lVar.skipBytes(JD == 0 ? 8 : 16);
        int readInt = lVar.readInt();
        lVar.skipBytes(4);
        boolean z = true;
        int position = lVar.getPosition();
        int i2 = JD == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (lVar.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            lVar.skipBytes(i2);
            readUnsignedInt = -9223372036854775807L;
        } else {
            readUnsignedInt = JD == 0 ? lVar.readUnsignedInt() : lVar.dyu();
            if (readUnsignedInt == 0) {
                readUnsignedInt = -9223372036854775807L;
            }
        }
        lVar.skipBytes(16);
        int readInt2 = lVar.readInt();
        int readInt3 = lVar.readInt();
        lVar.skipBytes(4);
        int readInt4 = lVar.readInt();
        int readInt5 = lVar.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == (-65536) && readInt5 == 0) {
            i = 90;
        } else if (readInt2 == 0 && readInt3 == (-65536) && readInt4 == 65536 && readInt5 == 0) {
            i = 270;
        } else {
            i = (readInt2 == (-65536) && readInt3 == 0 && readInt4 == 0 && readInt5 == (-65536)) ? 180 : 0;
        }
        return new f(readInt, readUnsignedInt, i);
    }

    private static int n(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(16);
        int readInt = lVar.readInt();
        if (readInt == mie) {
            return 1;
        }
        if (readInt == mic) {
            return 2;
        }
        if (readInt == mif || readInt == mig || readInt == mih || readInt == mii) {
            return 3;
        }
        if (readInt == mhL) {
            return 4;
        }
        return -1;
    }

    private static Pair<Long, String> o(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
        lVar.skipBytes(JD == 0 ? 8 : 16);
        long readUnsignedInt = lVar.readUnsignedInt();
        lVar.skipBytes(JD == 0 ? 4 : 8);
        int readUnsignedShort = lVar.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static c a(com.google.android.exoplayer2.util.l lVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        lVar.setPosition(12);
        int readInt = lVar.readInt();
        c cVar = new c(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = lVar.getPosition();
            int readInt2 = lVar.readInt();
            com.google.android.exoplayer2.util.a.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = lVar.readInt();
            if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mgl || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgm || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhj || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhv || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgn || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgo || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgp || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhU || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhV) {
                a(lVar, readInt3, position, readInt2, i, i2, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mgs || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhk || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgx || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgz || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgB || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgE || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgC || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgD || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhI || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhJ || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgv || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgw || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgt || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhY) {
                a(lVar, readInt3, position, readInt2, i, str, z, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mht || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhE || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhF || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhG || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhH) {
                a(lVar, readInt3, position, readInt2, i, str, cVar);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mhX) {
                cVar.lYQ = Format.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            lVar.setPosition(position + readInt2);
        }
        return cVar;
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, int i2, int i3, int i4, String str, c cVar) throws ParserException {
        String str2;
        lVar.setPosition(i2 + 8 + 8);
        List list = null;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        if (i == com.google.android.exoplayer2.extractor.c.a.mht) {
            str2 = "application/ttml+xml";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhE) {
            str2 = "application/x-quicktime-tx3g";
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            lVar.C(bArr, 0, i5);
            list = Collections.singletonList(bArr);
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhF) {
            str2 = "application/x-mp4-vtt";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhG) {
            str2 = "application/ttml+xml";
            j = 0;
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhH) {
            str2 = "application/x-mp4-cea-608";
            cVar.mis = 1;
        } else {
            throw new IllegalStateException();
        }
        cVar.lYQ = Format.a(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(com.google.android.exoplayer2.util.l lVar, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, c cVar, int i6) throws ParserException {
        DrmInitData drmInitData2;
        boolean z;
        DrmInitData drmInitData3;
        lVar.setPosition(i2 + 8 + 8);
        lVar.skipBytes(16);
        int readUnsignedShort = lVar.readUnsignedShort();
        int readUnsignedShort2 = lVar.readUnsignedShort();
        float f2 = 1.0f;
        lVar.skipBytes(50);
        int position = lVar.getPosition();
        if (i == com.google.android.exoplayer2.extractor.c.a.mhj) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.Pd(((k) b.second).schemeType);
                cVar.mir[i6] = (k) b.second;
            } else {
                drmInitData3 = drmInitData;
            }
            lVar.setPosition(position);
            drmInitData2 = drmInitData3;
        } else {
            drmInitData2 = drmInitData;
        }
        List<byte[]> list = null;
        String str = null;
        byte[] bArr = null;
        int i7 = -1;
        boolean z2 = false;
        int i8 = position;
        while (i8 - i2 < i3) {
            lVar.setPosition(i8);
            int position2 = lVar.getPosition();
            int readInt = lVar.readInt();
            if (readInt != 0 || lVar.getPosition() - i2 != i3) {
                com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
                int readInt2 = lVar.readInt();
                if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgR) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/avc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar);
                    list = ag.initializationData;
                    cVar.meg = ag.meg;
                    if (!z2) {
                        f2 = ag.mGK;
                    }
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgS) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/hevc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(lVar);
                    list = ai.initializationData;
                    cVar.meg = ai.meg;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhW) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = i == com.google.android.exoplayer2.extractor.c.a.mhU ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgq) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = MimeType.Video.GP3;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgT) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    Pair<String, byte[]> g = g(lVar, position2);
                    list = Collections.singletonList(g.second);
                    str = (String) g.first;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhs) {
                    f2 = f(lVar, position2);
                    z = true;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhS) {
                    bArr = d(lVar, position2, readInt);
                    z = z2;
                } else {
                    if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhR) {
                        int readUnsignedByte = lVar.readUnsignedByte();
                        lVar.skipBytes(3);
                        if (readUnsignedByte == 0) {
                            switch (lVar.readUnsignedByte()) {
                                case 0:
                                    i7 = 0;
                                    z = z2;
                                    break;
                                case 1:
                                    i7 = 1;
                                    z = z2;
                                    break;
                                case 2:
                                    i7 = 2;
                                    z = z2;
                                    break;
                                case 3:
                                    i7 = 3;
                                    z = z2;
                                    break;
                            }
                        }
                    }
                    z = z2;
                }
                i8 += readInt;
                z2 = z;
            } else if (str == null) {
                cVar.lYQ = Format.a(Integer.toString(i4), str, (String) null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f2, bArr, i7, (ColorInfo) null, drmInitData2);
                return;
            } else {
                return;
            }
        }
        if (str == null) {
        }
    }

    private static Pair<long[], long[]> b(a.C0666a c0666a) {
        a.b JG;
        if (c0666a == null || (JG = c0666a.JG(com.google.android.exoplayer2.extractor.c.a.mha)) == null) {
            return Pair.create(null, null);
        }
        com.google.android.exoplayer2.util.l lVar = JG.mib;
        lVar.setPosition(8);
        int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
        int dys = lVar.dys();
        long[] jArr = new long[dys];
        long[] jArr2 = new long[dys];
        for (int i = 0; i < dys; i++) {
            jArr[i] = JD == 1 ? lVar.dyu() : lVar.readUnsignedInt();
            jArr2[i] = JD == 1 ? lVar.readLong() : lVar.readInt();
            if (lVar.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            lVar.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float f(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.setPosition(i + 8);
        return lVar.dys() / lVar.dys();
    }

    private static void a(com.google.android.exoplayer2.util.l lVar, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, c cVar, int i5) throws ParserException {
        int i6;
        int i7;
        int i8;
        DrmInitData drmInitData2;
        byte[] bArr;
        DrmInitData drmInitData3;
        lVar.setPosition(i2 + 8 + 8);
        if (z) {
            int readUnsignedShort = lVar.readUnsignedShort();
            lVar.skipBytes(6);
            i6 = readUnsignedShort;
        } else {
            lVar.skipBytes(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            int readUnsignedShort2 = lVar.readUnsignedShort();
            lVar.skipBytes(6);
            int dyq = lVar.dyq();
            if (i6 == 1) {
                lVar.skipBytes(16);
                i7 = readUnsignedShort2;
                i8 = dyq;
            } else {
                i7 = readUnsignedShort2;
                i8 = dyq;
            }
        } else if (i6 == 2) {
            lVar.skipBytes(16);
            int dys = lVar.dys();
            lVar.skipBytes(20);
            i7 = dys;
            i8 = (int) Math.round(lVar.readDouble());
        } else {
            return;
        }
        int position = lVar.getPosition();
        if (i == com.google.android.exoplayer2.extractor.c.a.mhk) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.Pd(((k) b.second).schemeType);
                cVar.mir[i5] = (k) b.second;
            } else {
                drmInitData3 = drmInitData;
            }
            lVar.setPosition(position);
            drmInitData2 = drmInitData3;
        } else {
            drmInitData2 = drmInitData;
        }
        String str2 = null;
        if (i == com.google.android.exoplayer2.extractor.c.a.mgx) {
            str2 = "audio/ac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgz) {
            str2 = "audio/eac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgB) {
            str2 = "audio/vnd.dts";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgC || i == com.google.android.exoplayer2.extractor.c.a.mgD) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgE) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhI) {
            str2 = "audio/3gpp";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhJ) {
            str2 = "audio/amr-wb";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgv || i == com.google.android.exoplayer2.extractor.c.a.mgw) {
            str2 = "audio/raw";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mgt) {
            str2 = "audio/mpeg";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhY) {
            str2 = "audio/alac";
        }
        byte[] bArr2 = null;
        int i9 = i8;
        int i10 = i7;
        String str3 = str2;
        while (position - i2 < i3) {
            lVar.setPosition(position);
            int readInt = lVar.readInt();
            com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = lVar.readInt();
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgT || (z && readInt2 == com.google.android.exoplayer2.extractor.c.a.mgu)) {
                int a2 = readInt2 == com.google.android.exoplayer2.extractor.c.a.mgT ? position : a(lVar, position, readInt);
                if (a2 != -1) {
                    Pair<String, byte[]> g = g(lVar, a2);
                    str3 = (String) g.first;
                    bArr = (byte[]) g.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair<Integer, Integer> au = com.google.android.exoplayer2.util.c.au(bArr);
                        i9 = ((Integer) au.first).intValue();
                        i10 = ((Integer) au.second).intValue();
                    }
                } else {
                    bArr = bArr2;
                }
                bArr2 = bArr;
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgy) {
                lVar.setPosition(position + 8);
                cVar.lYQ = com.google.android.exoplayer2.audio.a.a(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgA) {
                lVar.setPosition(position + 8);
                cVar.lYQ = com.google.android.exoplayer2.audio.a.b(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgF) {
                cVar.lYQ = Format.a(Integer.toString(i4), str3, null, -1, -1, i10, i9, null, drmInitData2, 0, str);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhY) {
                bArr2 = new byte[readInt];
                lVar.setPosition(position);
                lVar.C(bArr2, 0, readInt);
            }
            position += readInt;
        }
        if (cVar.lYQ == null && str3 != null) {
            cVar.lYQ = Format.a(Integer.toString(i4), str3, (String) null, -1, -1, i10, i9, "audio/raw".equals(str3) ? 2 : -1, bArr2 == null ? null : Collections.singletonList(bArr2), drmInitData2, 0, str);
        }
    }

    private static int a(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        int position = lVar.getPosition();
        while (position - i < i2) {
            lVar.setPosition(position);
            int readInt = lVar.readInt();
            com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mgT) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> g(com.google.android.exoplayer2.util.l lVar, int i) {
        String str = null;
        lVar.setPosition(i + 8 + 4);
        lVar.skipBytes(1);
        p(lVar);
        lVar.skipBytes(2);
        int readUnsignedByte = lVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            lVar.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            lVar.skipBytes(lVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            lVar.skipBytes(2);
        }
        lVar.skipBytes(1);
        p(lVar);
        switch (lVar.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 96:
            case 97:
                str = "video/mpeg2";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
            case Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID /* 171 */:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        lVar.skipBytes(12);
        lVar.skipBytes(1);
        int p = p(lVar);
        byte[] bArr = new byte[p];
        lVar.C(bArr, 0, p);
        return Pair.create(str, bArr);
    }

    private static Pair<Integer, k> b(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        Pair<Integer, k> c2;
        int position = lVar.getPosition();
        while (true) {
            int i3 = position;
            if (i3 - i < i2) {
                lVar.setPosition(i3);
                int readInt = lVar.readInt();
                com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
                if (lVar.readInt() != com.google.android.exoplayer2.extractor.c.a.mhf || (c2 = c(lVar, i3, readInt)) == null) {
                    position = i3 + readInt;
                } else {
                    return c2;
                }
            } else {
                return null;
            }
        }
    }

    static Pair<Integer, k> c(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        int i3 = i + 8;
        Integer num = null;
        String str = null;
        int i4 = 0;
        int i5 = -1;
        while (i3 - i < i2) {
            lVar.setPosition(i3);
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhl) {
                num = Integer.valueOf(lVar.readInt());
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhg) {
                lVar.skipBytes(4);
                str = lVar.LP(4);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhh) {
                i4 = readInt;
                i5 = i3;
            }
            i3 += readInt;
        }
        if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
            com.google.android.exoplayer2.util.a.checkArgument(num != null, "frma atom is mandatory");
            com.google.android.exoplayer2.util.a.checkArgument(i5 != -1, "schi atom is mandatory");
            k a2 = a(lVar, i5, i4, str);
            com.google.android.exoplayer2.util.a.checkArgument(a2 != null, "tenc atom is mandatory");
            return Pair.create(num, a2);
        }
        return null;
    }

    private static k a(com.google.android.exoplayer2.util.l lVar, int i, int i2, String str) {
        int i3;
        int i4;
        byte[] bArr = null;
        int i5 = i + 8;
        while (i5 - i < i2) {
            lVar.setPosition(i5);
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhi) {
                int JD = com.google.android.exoplayer2.extractor.c.a.JD(lVar.readInt());
                lVar.skipBytes(1);
                if (JD == 0) {
                    lVar.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = lVar.readUnsignedByte();
                    i3 = (readUnsignedByte & 240) >> 4;
                    i4 = readUnsignedByte & 15;
                }
                boolean z = lVar.readUnsignedByte() == 1;
                int readUnsignedByte2 = lVar.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                lVar.C(bArr2, 0, bArr2.length);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = lVar.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    lVar.C(bArr, 0, readUnsignedByte3);
                }
                return new k(z, str, readUnsignedByte2, bArr2, i3, i4, bArr);
            }
            i5 += readInt;
        }
        return null;
    }

    private static byte[] d(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            lVar.setPosition(i3);
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhT) {
                return Arrays.copyOfRange(lVar.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int p(com.google.android.exoplayer2.util.l lVar) {
        int readUnsignedByte = lVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = lVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    /* loaded from: classes5.dex */
    private static final class a {
        public int index;
        public final int length;
        public int mik;
        private final boolean mil;
        private final com.google.android.exoplayer2.util.l mim;
        private final com.google.android.exoplayer2.util.l mio;
        private int mip;
        private int miq;
        public long offset;

        public a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, boolean z) {
            this.mio = lVar;
            this.mim = lVar2;
            this.mil = z;
            lVar2.setPosition(12);
            this.length = lVar2.dys();
            lVar.setPosition(12);
            this.miq = lVar.dys();
            com.google.android.exoplayer2.util.a.d(lVar.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.mil ? this.mim.dyu() : this.mim.readUnsignedInt();
            if (this.index == this.mip) {
                this.mik = this.mio.dys();
                this.mio.skipBytes(4);
                int i2 = this.miq - 1;
                this.miq = i2;
                this.mip = i2 > 0 ? this.mio.dys() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class f {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public f(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        public Format lYQ;
        public int meg;
        public final k[] mir;
        public int mis = 0;

        public c(int i) {
            this.mir = new k[i];
        }
    }

    /* loaded from: classes5.dex */
    static final class d implements InterfaceC0667b {
        private final com.google.android.exoplayer2.util.l mib;
        private final int mit;
        private final int sampleCount;

        public d(a.b bVar) {
            this.mib = bVar.mib;
            this.mib.setPosition(12);
            this.mit = this.mib.dys();
            this.sampleCount = this.mib.dys();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public int dtP() {
            return this.mit == 0 ? this.mib.dys() : this.mit;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public boolean dtQ() {
            return this.mit != 0;
        }
    }

    /* loaded from: classes5.dex */
    static final class e implements InterfaceC0667b {
        private final com.google.android.exoplayer2.util.l mib;
        private final int miu;
        private int miv;
        private int miw;
        private final int sampleCount;

        public e(a.b bVar) {
            this.mib = bVar.mib;
            this.mib.setPosition(12);
            this.miu = this.mib.dys() & 255;
            this.sampleCount = this.mib.dys();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public int dtP() {
            if (this.miu == 8) {
                return this.mib.readUnsignedByte();
            }
            if (this.miu == 16) {
                return this.mib.readUnsignedShort();
            }
            int i = this.miv;
            this.miv = i + 1;
            if (i % 2 == 0) {
                this.miw = this.mib.readUnsignedByte();
                return (this.miw & 240) >> 4;
            }
            return this.miw & 15;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0667b
        public boolean dtQ() {
            return false;
        }
    }
}
