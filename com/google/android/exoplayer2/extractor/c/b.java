package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import android.util.Pair;
import com.alibaba.fastjson.asm.Opcodes;
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
/* loaded from: classes6.dex */
public final class b {
    private static final int miM = v.QE("vide");
    private static final int miN = v.QE("soun");
    private static final int miO = v.QE("text");
    private static final int miP = v.QE("sbtl");
    private static final int miQ = v.QE("subt");
    private static final int miR = v.QE("clcp");
    private static final int miS = v.QE("cenc");
    private static final int miv = v.QE(MetaBox.TYPE);

    /* renamed from: com.google.android.exoplayer2.extractor.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private interface InterfaceC0675b {
        int dvc();

        boolean dvd();

        int getSampleCount();
    }

    public static j a(a.C0674a c0674a, a.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long i;
        a.C0674a JM = c0674a.JM(com.google.android.exoplayer2.extractor.c.a.mhw);
        int n = n(JM.JL(com.google.android.exoplayer2.extractor.c.a.mhK).miL);
        if (n == -1) {
            return null;
        }
        f m = m(c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhG).miL);
        long j2 = j == -9223372036854775807L ? m.duration : j;
        long l = l(bVar.miL);
        if (j2 == -9223372036854775807L) {
            i = -9223372036854775807L;
        } else {
            i = v.i(j2, TimeUtils.NANOS_PER_MS, l);
        }
        a.C0674a JM2 = JM.JM(com.google.android.exoplayer2.extractor.c.a.mhx).JM(com.google.android.exoplayer2.extractor.c.a.mhy);
        Pair<Long, String> o = o(JM.JL(com.google.android.exoplayer2.extractor.c.a.mhJ).miL);
        c a2 = a(JM2.JL(com.google.android.exoplayer2.extractor.c.a.mhL).miL, m.id, m.rotationDegrees, (String) o.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> b = b(c0674a.JM(com.google.android.exoplayer2.extractor.c.a.mhH));
            jArr2 = (long[]) b.second;
            jArr = (long[]) b.first;
        }
        if (a2.lZy == null) {
            return null;
        }
        return new j(m.id, n, ((Long) o.first).longValue(), l, i, a2.lZy, a2.mja, a2.miZ, a2.meO, jArr, jArr2);
    }

    public static m a(j jVar, a.C0674a c0674a, com.google.android.exoplayer2.extractor.i iVar) throws ParserException {
        InterfaceC0675b eVar;
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
        a.b JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mij);
        if (JL != null) {
            eVar = new d(JL);
        } else {
            a.b JL2 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mik);
            if (JL2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            eVar = new e(JL2);
        }
        int sampleCount = eVar.getSampleCount();
        if (sampleCount == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z2 = false;
        a.b JL3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mil);
        if (JL3 == null) {
            z2 = true;
            JL3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mim);
        }
        com.google.android.exoplayer2.util.l lVar2 = JL3.miL;
        com.google.android.exoplayer2.util.l lVar3 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mii).miL;
        com.google.android.exoplayer2.util.l lVar4 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mif).miL;
        a.b JL4 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mig);
        com.google.android.exoplayer2.util.l lVar5 = JL4 != null ? JL4.miL : null;
        a.b JL5 = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mih);
        com.google.android.exoplayer2.util.l lVar6 = JL5 != null ? JL5.miL : null;
        a aVar = new a(lVar3, lVar2, z2);
        lVar4.setPosition(12);
        int dzE = lVar4.dzE() - 1;
        int dzE2 = lVar4.dzE();
        int dzE3 = lVar4.dzE();
        int i9 = 0;
        if (lVar6 != null) {
            lVar6.setPosition(12);
            i9 = lVar6.dzE();
        }
        if (lVar5 == null) {
            i = -1;
            lVar = lVar5;
            i2 = 0;
        } else {
            lVar5.setPosition(12);
            int dzE4 = lVar5.dzE();
            if (dzE4 <= 0) {
                i = -1;
                lVar = null;
                i2 = dzE4;
            } else {
                i = lVar5.dzE() - 1;
                lVar = lVar5;
                i2 = dzE4;
            }
        }
        if (!(eVar.dvd() && "audio/raw".equals(jVar.lZy.sampleMimeType) && dzE == 0 && i9 == 0 && i2 == 0)) {
            long[] jArr3 = new long[sampleCount];
            int[] iArr3 = new int[sampleCount];
            long[] jArr4 = new long[sampleCount];
            int[] iArr4 = new int[sampleCount];
            long j2 = 0;
            int i10 = 0;
            int i11 = dzE2;
            int i12 = 0;
            int i13 = i2;
            int i14 = 0;
            int i15 = i;
            int i16 = i9;
            long j3 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = dzE3;
            int i20 = dzE;
            int i21 = i15;
            while (i10 < sampleCount) {
                long j4 = j2;
                int i22 = i18;
                while (i22 == 0) {
                    com.google.android.exoplayer2.util.a.checkState(aVar.moveNext());
                    j4 = aVar.offset;
                    i22 = aVar.miT;
                }
                if (lVar6 != null) {
                    while (i12 == 0 && i16 > 0) {
                        i12 = lVar6.dzE();
                        i14 = lVar6.readInt();
                        i16--;
                    }
                    i12--;
                }
                jArr3[i10] = j4;
                iArr3[i10] = eVar.dvc();
                if (iArr3[i10] > i17) {
                    i17 = iArr3[i10];
                }
                jArr4[i10] = i14 + j3;
                iArr4[i10] = lVar == null ? 1 : 0;
                if (i10 == i21) {
                    iArr4[i10] = 1;
                    int i23 = i13 - 1;
                    if (i23 > 0) {
                        i21 = lVar.dzE() - 1;
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
                    i7 = lVar4.dzE();
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
                com.google.android.exoplayer2.util.a.checkArgument(lVar6.dzE() == 0);
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
                iArr5[aVar.index] = aVar.miT;
            }
            d.a a2 = com.google.android.exoplayer2.extractor.c.d.a(eVar.dvc(), jArr5, iArr5, dzE3);
            jArr = a2.mdS;
            iArr = a2.mdR;
            i3 = a2.maximumSize;
            jArr2 = a2.mjg;
            iArr2 = a2.mjh;
            j = 0;
        }
        if (jVar.mkB == null || iVar.duV()) {
            v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        if (jVar.mkB.length == 1 && jVar.type == 1 && jArr2.length >= 2) {
            long j7 = jVar.mkC[0];
            long i27 = v.i(jVar.mkB[0], jVar.timescale, jVar.mkz) + j7;
            if (jArr2[0] <= j7 && j7 < jArr2[1] && jArr2[jArr2.length - 1] < i27 && i27 <= j) {
                long i28 = v.i(j7 - jArr2[0], jVar.lZy.sampleRate, jVar.timescale);
                long i29 = v.i(j - i27, jVar.lZy.sampleRate, jVar.timescale);
                if ((i28 != 0 || i29 != 0) && i28 <= 2147483647L && i29 <= 2147483647L) {
                    iVar.encoderDelay = (int) i28;
                    iVar.encoderPadding = (int) i29;
                    v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
                    return new m(jArr, iArr, i3, jArr2, iArr2);
                }
            }
        }
        if (jVar.mkB.length == 1 && jVar.mkB[0] == 0) {
            for (int i30 = 0; i30 < jArr2.length; i30++) {
                jArr2[i30] = v.i(jArr2[i30] - jVar.mkC[0], TimeUtils.NANOS_PER_MS, jVar.timescale);
            }
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        boolean z3 = jVar.type == 1;
        int i31 = 0;
        int i32 = 0;
        boolean z4 = false;
        int i33 = 0;
        while (true) {
            int i34 = i33;
            z = z4;
            int i35 = i32;
            i4 = i31;
            if (i34 >= jVar.mkB.length) {
                break;
            }
            long j8 = jVar.mkC[i34];
            if (j8 != -1) {
                long i36 = v.i(jVar.mkB[i34], jVar.timescale, jVar.mkz);
                int b = v.b(jArr2, j8, true, true);
                i32 = v.b(jArr2, i36 + j8, z3, false);
                i31 = i4 + (i32 - b);
                z4 = z | (i35 != b);
            } else {
                z4 = z;
                i32 = i35;
                i31 = i4;
            }
            i33 = i34 + 1;
        }
        boolean z5 = z | (i4 != sampleCount);
        long[] jArr6 = z5 ? new long[i4] : jArr;
        int[] iArr6 = z5 ? new int[i4] : iArr;
        int i37 = z5 ? 0 : i3;
        int[] iArr7 = z5 ? new int[i4] : iArr2;
        long[] jArr7 = new long[i4];
        int i38 = 0;
        int i39 = 0;
        long j9 = 0;
        int i40 = i37;
        while (i38 < jVar.mkB.length) {
            long j10 = jVar.mkC[i38];
            long j11 = jVar.mkB[i38];
            if (j10 != -1) {
                long i41 = j10 + v.i(j11, jVar.timescale, jVar.mkz);
                int b2 = v.b(jArr2, j10, true, true);
                int b3 = v.b(jArr2, i41, z3, false);
                if (z5) {
                    int i42 = b3 - b2;
                    System.arraycopy(jArr, b2, jArr6, i39, i42);
                    System.arraycopy(iArr, b2, iArr6, i39, i42);
                    System.arraycopy(iArr2, b2, iArr7, i39, i42);
                }
                int i43 = b2;
                int i44 = i39;
                int i45 = i40;
                while (i43 < b3) {
                    jArr7[i44] = v.i(jArr2[i43] - j10, TimeUtils.NANOS_PER_MS, jVar.timescale) + v.i(j9, TimeUtils.NANOS_PER_MS, jVar.mkz);
                    int i46 = (!z5 || iArr6[i44] <= i45) ? i45 : iArr[i43];
                    i44++;
                    i43++;
                    i45 = i46;
                }
                i5 = i44;
                i6 = i45;
            } else {
                i5 = i39;
                i6 = i40;
            }
            i38++;
            i39 = i5;
            j9 += j11;
            i40 = i6;
        }
        boolean z6 = false;
        for (int i47 = 0; i47 < iArr7.length && !z6; i47++) {
            z6 |= (iArr7[i47] & 1) != 0;
        }
        if (!z6) {
            Log.w("AtomParsers", "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
            v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        return new m(jArr6, iArr6, i40, jArr7, iArr7);
    }

    public static Metadata a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        com.google.android.exoplayer2.util.l lVar = bVar.miL;
        lVar.setPosition(8);
        while (lVar.dzt() >= 8) {
            int position = lVar.getPosition();
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.miv) {
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.miw) {
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
        lVar.skipBytes(com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt()) != 0 ? 16 : 8);
        return lVar.readUnsignedInt();
    }

    private static f m(com.google.android.exoplayer2.util.l lVar) {
        long readUnsignedInt;
        int i;
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        lVar.skipBytes(JI == 0 ? 8 : 16);
        int readInt = lVar.readInt();
        lVar.skipBytes(4);
        boolean z = true;
        int position = lVar.getPosition();
        int i2 = JI == 0 ? 4 : 8;
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
            readUnsignedInt = JI == 0 ? lVar.readUnsignedInt() : lVar.dzG();
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
        if (readInt == miN) {
            return 1;
        }
        if (readInt == miM) {
            return 2;
        }
        if (readInt == miO || readInt == miP || readInt == miQ || readInt == miR) {
            return 3;
        }
        if (readInt == miv) {
            return 4;
        }
        return -1;
    }

    private static Pair<Long, String> o(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        lVar.skipBytes(JI == 0 ? 8 : 16);
        long readUnsignedInt = lVar.readUnsignedInt();
        lVar.skipBytes(JI == 0 ? 4 : 8);
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
            if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mgT || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgU || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhR || readInt3 == com.google.android.exoplayer2.extractor.c.a.mie || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgV || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgW || readInt3 == com.google.android.exoplayer2.extractor.c.a.mgX || readInt3 == com.google.android.exoplayer2.extractor.c.a.miE || readInt3 == com.google.android.exoplayer2.extractor.c.a.miF) {
                a(lVar, readInt3, position, readInt2, i, i2, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mha || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhS || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhf || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhh || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhj || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhm || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhk || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhl || readInt3 == com.google.android.exoplayer2.extractor.c.a.mis || readInt3 == com.google.android.exoplayer2.extractor.c.a.mit || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhd || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhe || readInt3 == com.google.android.exoplayer2.extractor.c.a.mhb || readInt3 == com.google.android.exoplayer2.extractor.c.a.miI) {
                a(lVar, readInt3, position, readInt2, i, str, z, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mib || readInt3 == com.google.android.exoplayer2.extractor.c.a.mio || readInt3 == com.google.android.exoplayer2.extractor.c.a.mip || readInt3 == com.google.android.exoplayer2.extractor.c.a.miq || readInt3 == com.google.android.exoplayer2.extractor.c.a.mir) {
                a(lVar, readInt3, position, readInt2, i, str, cVar);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.miH) {
                cVar.lZy = Format.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
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
        if (i == com.google.android.exoplayer2.extractor.c.a.mib) {
            str2 = "application/ttml+xml";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mio) {
            str2 = "application/x-quicktime-tx3g";
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            lVar.G(bArr, 0, i5);
            list = Collections.singletonList(bArr);
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mip) {
            str2 = "application/x-mp4-vtt";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.miq) {
            str2 = "application/ttml+xml";
            j = 0;
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mir) {
            str2 = "application/x-mp4-cea-608";
            cVar.mja = 1;
        } else {
            throw new IllegalStateException();
        }
        cVar.lZy = Format.a(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
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
        if (i == com.google.android.exoplayer2.extractor.c.a.mhR) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.Pq(((k) b.second).schemeType);
                cVar.miZ[i6] = (k) b.second;
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
                if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhz) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/avc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar);
                    list = ag.initializationData;
                    cVar.meO = ag.meO;
                    if (!z2) {
                        f2 = ag.mHr;
                    }
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhA) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/hevc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(lVar);
                    list = ai.initializationData;
                    cVar.meO = ai.meO;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.miG) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = i == com.google.android.exoplayer2.extractor.c.a.miE ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mgY) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = MimeType.Video.GP3;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhB) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    Pair<String, byte[]> g = g(lVar, position2);
                    list = Collections.singletonList(g.second);
                    str = (String) g.first;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mia) {
                    f2 = f(lVar, position2);
                    z = true;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.miC) {
                    bArr = d(lVar, position2, readInt);
                    z = z2;
                } else {
                    if (readInt2 == com.google.android.exoplayer2.extractor.c.a.miB) {
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
                cVar.lZy = Format.a(Integer.toString(i4), str, (String) null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f2, bArr, i7, (ColorInfo) null, drmInitData2);
                return;
            } else {
                return;
            }
        }
        if (str == null) {
        }
    }

    private static Pair<long[], long[]> b(a.C0674a c0674a) {
        a.b JL;
        if (c0674a == null || (JL = c0674a.JL(com.google.android.exoplayer2.extractor.c.a.mhI)) == null) {
            return Pair.create(null, null);
        }
        com.google.android.exoplayer2.util.l lVar = JL.miL;
        lVar.setPosition(8);
        int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
        int dzE = lVar.dzE();
        long[] jArr = new long[dzE];
        long[] jArr2 = new long[dzE];
        for (int i = 0; i < dzE; i++) {
            jArr[i] = JI == 1 ? lVar.dzG() : lVar.readUnsignedInt();
            jArr2[i] = JI == 1 ? lVar.readLong() : lVar.readInt();
            if (lVar.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            lVar.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float f(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.setPosition(i + 8);
        return lVar.dzE() / lVar.dzE();
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
            int dzC = lVar.dzC();
            if (i6 == 1) {
                lVar.skipBytes(16);
                i7 = readUnsignedShort2;
                i8 = dzC;
            } else {
                i7 = readUnsignedShort2;
                i8 = dzC;
            }
        } else if (i6 == 2) {
            lVar.skipBytes(16);
            int dzE = lVar.dzE();
            lVar.skipBytes(20);
            i7 = dzE;
            i8 = (int) Math.round(lVar.readDouble());
        } else {
            return;
        }
        int position = lVar.getPosition();
        if (i == com.google.android.exoplayer2.extractor.c.a.mhS) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.Pq(((k) b.second).schemeType);
                cVar.miZ[i5] = (k) b.second;
            } else {
                drmInitData3 = drmInitData;
            }
            lVar.setPosition(position);
            drmInitData2 = drmInitData3;
        } else {
            drmInitData2 = drmInitData;
        }
        String str2 = null;
        if (i == com.google.android.exoplayer2.extractor.c.a.mhf) {
            str2 = "audio/ac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhh) {
            str2 = "audio/eac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhj) {
            str2 = "audio/vnd.dts";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhk || i == com.google.android.exoplayer2.extractor.c.a.mhl) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhm) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mis) {
            str2 = "audio/3gpp";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mit) {
            str2 = "audio/amr-wb";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhd || i == com.google.android.exoplayer2.extractor.c.a.mhe) {
            str2 = "audio/raw";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mhb) {
            str2 = "audio/mpeg";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.miI) {
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
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhB || (z && readInt2 == com.google.android.exoplayer2.extractor.c.a.mhc)) {
                int a2 = readInt2 == com.google.android.exoplayer2.extractor.c.a.mhB ? position : a(lVar, position, readInt);
                if (a2 != -1) {
                    Pair<String, byte[]> g = g(lVar, a2);
                    str3 = (String) g.first;
                    bArr = (byte[]) g.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(bArr);
                        i9 = ((Integer) az.first).intValue();
                        i10 = ((Integer) az.second).intValue();
                    }
                } else {
                    bArr = bArr2;
                }
                bArr2 = bArr;
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhg) {
                lVar.setPosition(position + 8);
                cVar.lZy = com.google.android.exoplayer2.audio.a.a(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhi) {
                lVar.setPosition(position + 8);
                cVar.lZy = com.google.android.exoplayer2.audio.a.b(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhn) {
                cVar.lZy = Format.a(Integer.toString(i4), str3, null, -1, -1, i10, i9, null, drmInitData2, 0, str);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.miI) {
                bArr2 = new byte[readInt];
                lVar.setPosition(position);
                lVar.G(bArr2, 0, readInt);
            }
            position += readInt;
        }
        if (cVar.lZy == null && str3 != null) {
            cVar.lZy = Format.a(Integer.toString(i4), str3, (String) null, -1, -1, i10, i9, "audio/raw".equals(str3) ? 2 : -1, bArr2 == null ? null : Collections.singletonList(bArr2), drmInitData2, 0, str);
        }
    }

    private static int a(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        int position = lVar.getPosition();
        while (position - i < i2) {
            lVar.setPosition(position);
            int readInt = lVar.readInt();
            com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhB) {
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
            case Opcodes.IF_ACMPEQ /* 165 */:
                str = "audio/ac3";
                break;
            case Opcodes.IF_ACMPNE /* 166 */:
                str = "audio/eac3";
                break;
            case Opcodes.RET /* 169 */:
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
        lVar.G(bArr, 0, p);
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
                if (lVar.readInt() != com.google.android.exoplayer2.extractor.c.a.mhN || (c2 = c(lVar, i3, readInt)) == null) {
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
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhT) {
                num = Integer.valueOf(lVar.readInt());
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhO) {
                lVar.skipBytes(4);
                str = lVar.LU(4);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mhP) {
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mhQ) {
                int JI = com.google.android.exoplayer2.extractor.c.a.JI(lVar.readInt());
                lVar.skipBytes(1);
                if (JI == 0) {
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
                lVar.G(bArr2, 0, bArr2.length);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = lVar.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    lVar.G(bArr, 0, readUnsignedByte3);
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.miD) {
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

    /* loaded from: classes6.dex */
    private static final class a {
        public int index;
        public final int length;
        public int miT;
        private final boolean miU;
        private final com.google.android.exoplayer2.util.l miV;
        private final com.google.android.exoplayer2.util.l miW;
        private int miX;
        private int miY;
        public long offset;

        public a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, boolean z) {
            this.miW = lVar;
            this.miV = lVar2;
            this.miU = z;
            lVar2.setPosition(12);
            this.length = lVar2.dzE();
            lVar.setPosition(12);
            this.miY = lVar.dzE();
            com.google.android.exoplayer2.util.a.d(lVar.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.miU ? this.miV.dzG() : this.miV.readUnsignedInt();
            if (this.index == this.miX) {
                this.miT = this.miW.dzE();
                this.miW.skipBytes(4);
                int i2 = this.miY - 1;
                this.miY = i2;
                this.miX = i2 > 0 ? this.miW.dzE() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static final class c {
        public Format lZy;
        public int meO;
        public final k[] miZ;
        public int mja = 0;

        public c(int i) {
            this.miZ = new k[i];
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements InterfaceC0675b {
        private final com.google.android.exoplayer2.util.l miL;
        private final int mjb;
        private final int sampleCount;

        public d(a.b bVar) {
            this.miL = bVar.miL;
            this.miL.setPosition(12);
            this.mjb = this.miL.dzE();
            this.sampleCount = this.miL.dzE();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public int dvc() {
            return this.mjb == 0 ? this.miL.dzE() : this.mjb;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public boolean dvd() {
            return this.mjb != 0;
        }
    }

    /* loaded from: classes6.dex */
    static final class e implements InterfaceC0675b {
        private final com.google.android.exoplayer2.util.l miL;
        private final int mjc;
        private int mjd;
        private int mje;
        private final int sampleCount;

        public e(a.b bVar) {
            this.miL = bVar.miL;
            this.miL.setPosition(12);
            this.mjc = this.miL.dzE() & 255;
            this.sampleCount = this.miL.dzE();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public int dvc() {
            if (this.mjc == 8) {
                return this.miL.readUnsignedByte();
            }
            if (this.mjc == 16) {
                return this.miL.readUnsignedShort();
            }
            int i = this.mjd;
            this.mjd = i + 1;
            if (i % 2 == 0) {
                this.mje = this.miL.readUnsignedByte();
                return (this.mje & 240) >> 4;
            }
            return this.mje & 15;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0675b
        public boolean dvd() {
            return false;
        }
    }
}
