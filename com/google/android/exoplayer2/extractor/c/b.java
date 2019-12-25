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
/* loaded from: classes4.dex */
public final class b {
    private static final int mei = v.Qg("vide");
    private static final int mej = v.Qg("soun");
    private static final int mek = v.Qg("text");
    private static final int mel = v.Qg("sbtl");
    private static final int mem = v.Qg("subt");
    private static final int men = v.Qg("clcp");
    private static final int meo = v.Qg("cenc");
    private static final int mdR = v.Qg(MetaBox.TYPE);

    /* renamed from: com.google.android.exoplayer2.extractor.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private interface InterfaceC0661b {
        int dsB();

        boolean dsC();

        int getSampleCount();
    }

    public static j a(a.C0660a c0660a, a.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long h;
        a.C0660a Jy = c0660a.Jy(com.google.android.exoplayer2.extractor.c.a.mcU);
        int n = n(Jy.Jx(com.google.android.exoplayer2.extractor.c.a.mdi).meh);
        if (n == -1) {
            return null;
        }
        f m = m(c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mde).meh);
        long j2 = j == -9223372036854775807L ? m.duration : j;
        long l = l(bVar.meh);
        if (j2 == -9223372036854775807L) {
            h = -9223372036854775807L;
        } else {
            h = v.h(j2, TimeUtils.NANOS_PER_MS, l);
        }
        a.C0660a Jy2 = Jy.Jy(com.google.android.exoplayer2.extractor.c.a.mcV).Jy(com.google.android.exoplayer2.extractor.c.a.mcW);
        Pair<Long, String> o = o(Jy.Jx(com.google.android.exoplayer2.extractor.c.a.mdh).meh);
        c a2 = a(Jy2.Jx(com.google.android.exoplayer2.extractor.c.a.mdj).meh, m.id, m.rotationDegrees, (String) o.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> b = b(c0660a.Jy(com.google.android.exoplayer2.extractor.c.a.mdf));
            jArr2 = (long[]) b.second;
            jArr = (long[]) b.first;
        }
        if (a2.lUU == null) {
            return null;
        }
        return new j(m.id, n, ((Long) o.first).longValue(), l, h, a2.lUU, a2.mew, a2.mev, a2.mak, jArr, jArr2);
    }

    public static m a(j jVar, a.C0660a c0660a, com.google.android.exoplayer2.extractor.i iVar) throws ParserException {
        InterfaceC0661b eVar;
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
        a.b Jx = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdG);
        if (Jx != null) {
            eVar = new d(Jx);
        } else {
            a.b Jx2 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdH);
            if (Jx2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            eVar = new e(Jx2);
        }
        int sampleCount = eVar.getSampleCount();
        if (sampleCount == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z2 = false;
        a.b Jx3 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdI);
        if (Jx3 == null) {
            z2 = true;
            Jx3 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdJ);
        }
        com.google.android.exoplayer2.util.l lVar2 = Jx3.meh;
        com.google.android.exoplayer2.util.l lVar3 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdF).meh;
        com.google.android.exoplayer2.util.l lVar4 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdC).meh;
        a.b Jx4 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdD);
        com.google.android.exoplayer2.util.l lVar5 = Jx4 != null ? Jx4.meh : null;
        a.b Jx5 = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdE);
        com.google.android.exoplayer2.util.l lVar6 = Jx5 != null ? Jx5.meh : null;
        a aVar = new a(lVar3, lVar2, z2);
        lVar4.setPosition(12);
        int dxg = lVar4.dxg() - 1;
        int dxg2 = lVar4.dxg();
        int dxg3 = lVar4.dxg();
        int i9 = 0;
        if (lVar6 != null) {
            lVar6.setPosition(12);
            i9 = lVar6.dxg();
        }
        if (lVar5 == null) {
            i = -1;
            lVar = lVar5;
            i2 = 0;
        } else {
            lVar5.setPosition(12);
            int dxg4 = lVar5.dxg();
            if (dxg4 <= 0) {
                i = -1;
                lVar = null;
                i2 = dxg4;
            } else {
                i = lVar5.dxg() - 1;
                lVar = lVar5;
                i2 = dxg4;
            }
        }
        if (!(eVar.dsC() && "audio/raw".equals(jVar.lUU.sampleMimeType) && dxg == 0 && i9 == 0 && i2 == 0)) {
            long[] jArr3 = new long[sampleCount];
            int[] iArr3 = new int[sampleCount];
            long[] jArr4 = new long[sampleCount];
            int[] iArr4 = new int[sampleCount];
            long j2 = 0;
            int i10 = 0;
            int i11 = dxg2;
            int i12 = 0;
            int i13 = i2;
            int i14 = 0;
            int i15 = i;
            int i16 = i9;
            long j3 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = dxg3;
            int i20 = dxg;
            int i21 = i15;
            while (i10 < sampleCount) {
                long j4 = j2;
                int i22 = i18;
                while (i22 == 0) {
                    com.google.android.exoplayer2.util.a.checkState(aVar.moveNext());
                    j4 = aVar.offset;
                    i22 = aVar.mep;
                }
                if (lVar6 != null) {
                    while (i12 == 0 && i16 > 0) {
                        i12 = lVar6.dxg();
                        i14 = lVar6.readInt();
                        i16--;
                    }
                    i12--;
                }
                jArr3[i10] = j4;
                iArr3[i10] = eVar.dsB();
                if (iArr3[i10] > i17) {
                    i17 = iArr3[i10];
                }
                jArr4[i10] = i14 + j3;
                iArr4[i10] = lVar == null ? 1 : 0;
                if (i10 == i21) {
                    iArr4[i10] = 1;
                    int i23 = i13 - 1;
                    if (i23 > 0) {
                        i21 = lVar.dxg() - 1;
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
                    i7 = lVar4.dxg();
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
                com.google.android.exoplayer2.util.a.checkArgument(lVar6.dxg() == 0);
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
                iArr5[aVar.index] = aVar.mep;
            }
            d.a a2 = com.google.android.exoplayer2.extractor.c.d.a(eVar.dsB(), jArr5, iArr5, dxg3);
            jArr = a2.lZn;
            iArr = a2.lZm;
            i3 = a2.maximumSize;
            jArr2 = a2.meC;
            iArr2 = a2.meD;
            j = 0;
        }
        if (jVar.mfX == null || iVar.dsu()) {
            v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
            return new m(jArr, iArr, i3, jArr2, iArr2);
        }
        if (jVar.mfX.length == 1 && jVar.type == 1 && jArr2.length >= 2) {
            long j7 = jVar.mfY[0];
            long h = v.h(jVar.mfX[0], jVar.timescale, jVar.mfV) + j7;
            if (jArr2[0] <= j7 && j7 < jArr2[1] && jArr2[jArr2.length - 1] < h && h <= j) {
                long h2 = v.h(j7 - jArr2[0], jVar.lUU.sampleRate, jVar.timescale);
                long h3 = v.h(j - h, jVar.lUU.sampleRate, jVar.timescale);
                if ((h2 != 0 || h3 != 0) && h2 <= 2147483647L && h3 <= 2147483647L) {
                    iVar.encoderDelay = (int) h2;
                    iVar.encoderPadding = (int) h3;
                    v.a(jArr2, (long) TimeUtils.NANOS_PER_MS, jVar.timescale);
                    return new m(jArr, iArr, i3, jArr2, iArr2);
                }
            }
        }
        if (jVar.mfX.length == 1 && jVar.mfX[0] == 0) {
            for (int i27 = 0; i27 < jArr2.length; i27++) {
                jArr2[i27] = v.h(jArr2[i27] - jVar.mfY[0], TimeUtils.NANOS_PER_MS, jVar.timescale);
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
            if (i31 >= jVar.mfX.length) {
                break;
            }
            long j8 = jVar.mfY[i31];
            if (j8 != -1) {
                long h4 = v.h(jVar.mfX[i31], jVar.timescale, jVar.mfV);
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
        while (i34 < jVar.mfX.length) {
            long j10 = jVar.mfY[i34];
            long j11 = jVar.mfX[i34];
            if (j10 != -1) {
                long h5 = j10 + v.h(j11, jVar.timescale, jVar.mfV);
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
                    jArr7[i39] = v.h(jArr2[i38] - j10, TimeUtils.NANOS_PER_MS, jVar.timescale) + v.h(j9, TimeUtils.NANOS_PER_MS, jVar.mfV);
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
        com.google.android.exoplayer2.util.l lVar = bVar.meh;
        lVar.setPosition(8);
        while (lVar.dwV() >= 8) {
            int position = lVar.getPosition();
            int readInt = lVar.readInt();
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mdR) {
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mdS) {
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
        lVar.skipBytes(com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt()) != 0 ? 16 : 8);
        return lVar.readUnsignedInt();
    }

    private static f m(com.google.android.exoplayer2.util.l lVar) {
        long readUnsignedInt;
        int i;
        lVar.setPosition(8);
        int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt());
        lVar.skipBytes(Ju == 0 ? 8 : 16);
        int readInt = lVar.readInt();
        lVar.skipBytes(4);
        boolean z = true;
        int position = lVar.getPosition();
        int i2 = Ju == 0 ? 4 : 8;
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
            readUnsignedInt = Ju == 0 ? lVar.readUnsignedInt() : lVar.dxi();
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
        if (readInt == mej) {
            return 1;
        }
        if (readInt == mei) {
            return 2;
        }
        if (readInt == mek || readInt == mel || readInt == mem || readInt == men) {
            return 3;
        }
        if (readInt == mdR) {
            return 4;
        }
        return -1;
    }

    private static Pair<Long, String> o(com.google.android.exoplayer2.util.l lVar) {
        lVar.setPosition(8);
        int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt());
        lVar.skipBytes(Ju == 0 ? 8 : 16);
        long readUnsignedInt = lVar.readUnsignedInt();
        lVar.skipBytes(Ju == 0 ? 4 : 8);
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
            if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mcr || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcs || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdp || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdB || readInt3 == com.google.android.exoplayer2.extractor.c.a.mct || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcu || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcv || readInt3 == com.google.android.exoplayer2.extractor.c.a.mea || readInt3 == com.google.android.exoplayer2.extractor.c.a.meb) {
                a(lVar, readInt3, position, readInt2, i, i2, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mcy || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdq || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcD || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcF || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcH || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcK || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcI || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcJ || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdO || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdP || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcB || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcC || readInt3 == com.google.android.exoplayer2.extractor.c.a.mcz || readInt3 == com.google.android.exoplayer2.extractor.c.a.mee) {
                a(lVar, readInt3, position, readInt2, i, str, z, drmInitData, cVar, i3);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.mdz || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdK || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdL || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdM || readInt3 == com.google.android.exoplayer2.extractor.c.a.mdN) {
                a(lVar, readInt3, position, readInt2, i, str, cVar);
            } else if (readInt3 == com.google.android.exoplayer2.extractor.c.a.med) {
                cVar.lUU = Format.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
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
        if (i == com.google.android.exoplayer2.extractor.c.a.mdz) {
            str2 = "application/ttml+xml";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdK) {
            str2 = "application/x-quicktime-tx3g";
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            lVar.D(bArr, 0, i5);
            list = Collections.singletonList(bArr);
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdL) {
            str2 = "application/x-mp4-vtt";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdM) {
            str2 = "application/ttml+xml";
            j = 0;
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdN) {
            str2 = "application/x-mp4-cea-608";
            cVar.mew = 1;
        } else {
            throw new IllegalStateException();
        }
        cVar.lUU = Format.a(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
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
        if (i == com.google.android.exoplayer2.extractor.c.a.mdp) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.OS(((k) b.second).schemeType);
                cVar.mev[i6] = (k) b.second;
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
                if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcX) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/avc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar);
                    list = ag.initializationData;
                    cVar.mak = ag.mak;
                    if (!z2) {
                        f2 = ag.mCO;
                    }
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcY) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = "video/hevc";
                    lVar.setPosition(position2 + 8);
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(lVar);
                    list = ai.initializationData;
                    cVar.mak = ai.mak;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mec) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = i == com.google.android.exoplayer2.extractor.c.a.mea ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcw) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    str = MimeType.Video.GP3;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcZ) {
                    com.google.android.exoplayer2.util.a.checkState(str == null);
                    Pair<String, byte[]> g = g(lVar, position2);
                    list = Collections.singletonList(g.second);
                    str = (String) g.first;
                    z = z2;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdy) {
                    f2 = f(lVar, position2);
                    z = true;
                } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdY) {
                    bArr = d(lVar, position2, readInt);
                    z = z2;
                } else {
                    if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdX) {
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
                cVar.lUU = Format.a(Integer.toString(i4), str, (String) null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f2, bArr, i7, (ColorInfo) null, drmInitData2);
                return;
            } else {
                return;
            }
        }
        if (str == null) {
        }
    }

    private static Pair<long[], long[]> b(a.C0660a c0660a) {
        a.b Jx;
        if (c0660a == null || (Jx = c0660a.Jx(com.google.android.exoplayer2.extractor.c.a.mdg)) == null) {
            return Pair.create(null, null);
        }
        com.google.android.exoplayer2.util.l lVar = Jx.meh;
        lVar.setPosition(8);
        int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt());
        int dxg = lVar.dxg();
        long[] jArr = new long[dxg];
        long[] jArr2 = new long[dxg];
        for (int i = 0; i < dxg; i++) {
            jArr[i] = Ju == 1 ? lVar.dxi() : lVar.readUnsignedInt();
            jArr2[i] = Ju == 1 ? lVar.readLong() : lVar.readInt();
            if (lVar.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            lVar.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float f(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.setPosition(i + 8);
        return lVar.dxg() / lVar.dxg();
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
            int dxe = lVar.dxe();
            if (i6 == 1) {
                lVar.skipBytes(16);
                i7 = readUnsignedShort2;
                i8 = dxe;
            } else {
                i7 = readUnsignedShort2;
                i8 = dxe;
            }
        } else if (i6 == 2) {
            lVar.skipBytes(16);
            int dxg = lVar.dxg();
            lVar.skipBytes(20);
            i7 = dxg;
            i8 = (int) Math.round(lVar.readDouble());
        } else {
            return;
        }
        int position = lVar.getPosition();
        if (i == com.google.android.exoplayer2.extractor.c.a.mdq) {
            Pair<Integer, k> b = b(lVar, i2, i3);
            if (b != null) {
                i = ((Integer) b.first).intValue();
                drmInitData3 = drmInitData == null ? null : drmInitData.OS(((k) b.second).schemeType);
                cVar.mev[i5] = (k) b.second;
            } else {
                drmInitData3 = drmInitData;
            }
            lVar.setPosition(position);
            drmInitData2 = drmInitData3;
        } else {
            drmInitData2 = drmInitData;
        }
        String str2 = null;
        if (i == com.google.android.exoplayer2.extractor.c.a.mcD) {
            str2 = "audio/ac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcF) {
            str2 = "audio/eac3";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcH) {
            str2 = "audio/vnd.dts";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcI || i == com.google.android.exoplayer2.extractor.c.a.mcJ) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcK) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdO) {
            str2 = "audio/3gpp";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mdP) {
            str2 = "audio/amr-wb";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcB || i == com.google.android.exoplayer2.extractor.c.a.mcC) {
            str2 = "audio/raw";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mcz) {
            str2 = "audio/mpeg";
        } else if (i == com.google.android.exoplayer2.extractor.c.a.mee) {
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
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcZ || (z && readInt2 == com.google.android.exoplayer2.extractor.c.a.mcA)) {
                int a2 = readInt2 == com.google.android.exoplayer2.extractor.c.a.mcZ ? position : a(lVar, position, readInt);
                if (a2 != -1) {
                    Pair<String, byte[]> g = g(lVar, a2);
                    str3 = (String) g.first;
                    bArr = (byte[]) g.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair<Integer, Integer> av = com.google.android.exoplayer2.util.c.av(bArr);
                        i9 = ((Integer) av.first).intValue();
                        i10 = ((Integer) av.second).intValue();
                    }
                } else {
                    bArr = bArr2;
                }
                bArr2 = bArr;
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcE) {
                lVar.setPosition(position + 8);
                cVar.lUU = com.google.android.exoplayer2.audio.a.a(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcG) {
                lVar.setPosition(position + 8);
                cVar.lUU = com.google.android.exoplayer2.audio.a.b(lVar, Integer.toString(i4), str, drmInitData2);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mcL) {
                cVar.lUU = Format.a(Integer.toString(i4), str3, null, -1, -1, i10, i9, null, drmInitData2, 0, str);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mee) {
                bArr2 = new byte[readInt];
                lVar.setPosition(position);
                lVar.D(bArr2, 0, readInt);
            }
            position += readInt;
        }
        if (cVar.lUU == null && str3 != null) {
            cVar.lUU = Format.a(Integer.toString(i4), str3, (String) null, -1, -1, i10, i9, "audio/raw".equals(str3) ? 2 : -1, bArr2 == null ? null : Collections.singletonList(bArr2), drmInitData2, 0, str);
        }
    }

    private static int a(com.google.android.exoplayer2.util.l lVar, int i, int i2) {
        int position = lVar.getPosition();
        while (position - i < i2) {
            lVar.setPosition(position);
            int readInt = lVar.readInt();
            com.google.android.exoplayer2.util.a.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mcZ) {
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
        lVar.D(bArr, 0, p);
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
                if (lVar.readInt() != com.google.android.exoplayer2.extractor.c.a.mdl || (c2 = c(lVar, i3, readInt)) == null) {
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
            if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdr) {
                num = Integer.valueOf(lVar.readInt());
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdm) {
                lVar.skipBytes(4);
                str = lVar.LG(4);
            } else if (readInt2 == com.google.android.exoplayer2.extractor.c.a.mdn) {
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mdo) {
                int Ju = com.google.android.exoplayer2.extractor.c.a.Ju(lVar.readInt());
                lVar.skipBytes(1);
                if (Ju == 0) {
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
                lVar.D(bArr2, 0, bArr2.length);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = lVar.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    lVar.D(bArr, 0, readUnsignedByte3);
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
            if (lVar.readInt() == com.google.android.exoplayer2.extractor.c.a.mdZ) {
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

    /* loaded from: classes4.dex */
    private static final class a {
        public int index;
        public final int length;
        public int mep;
        private final boolean meq;
        private final com.google.android.exoplayer2.util.l mer;
        private final com.google.android.exoplayer2.util.l mes;
        private int met;
        private int meu;
        public long offset;

        public a(com.google.android.exoplayer2.util.l lVar, com.google.android.exoplayer2.util.l lVar2, boolean z) {
            this.mes = lVar;
            this.mer = lVar2;
            this.meq = z;
            lVar2.setPosition(12);
            this.length = lVar2.dxg();
            lVar.setPosition(12);
            this.meu = lVar.dxg();
            com.google.android.exoplayer2.util.a.d(lVar.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.meq ? this.mer.dxi() : this.mer.readUnsignedInt();
            if (this.index == this.met) {
                this.mep = this.mes.dxg();
                this.mes.skipBytes(4);
                int i2 = this.meu - 1;
                this.meu = i2;
                this.met = i2 > 0 ? this.mes.dxg() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static final class c {
        public Format lUU;
        public int mak;
        public final k[] mev;
        public int mew = 0;

        public c(int i) {
            this.mev = new k[i];
        }
    }

    /* loaded from: classes4.dex */
    static final class d implements InterfaceC0661b {
        private final com.google.android.exoplayer2.util.l meh;
        private final int mex;
        private final int sampleCount;

        public d(a.b bVar) {
            this.meh = bVar.meh;
            this.meh.setPosition(12);
            this.mex = this.meh.dxg();
            this.sampleCount = this.meh.dxg();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public int dsB() {
            return this.mex == 0 ? this.meh.dxg() : this.mex;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public boolean dsC() {
            return this.mex != 0;
        }
    }

    /* loaded from: classes4.dex */
    static final class e implements InterfaceC0661b {
        private int meA;
        private final com.google.android.exoplayer2.util.l meh;
        private final int mey;
        private int mez;
        private final int sampleCount;

        public e(a.b bVar) {
            this.meh = bVar.meh;
            this.meh.setPosition(12);
            this.mey = this.meh.dxg() & 255;
            this.sampleCount = this.meh.dxg();
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public int dsB() {
            if (this.mey == 8) {
                return this.meh.readUnsignedByte();
            }
            if (this.mey == 16) {
                return this.meh.readUnsignedShort();
            }
            int i = this.mez;
            this.mez = i + 1;
            if (i % 2 == 0) {
                this.meA = this.meh.readUnsignedByte();
                return (this.meA & 240) >> 4;
            }
            return this.meA & 15;
        }

        @Override // com.google.android.exoplayer2.extractor.c.b.InterfaceC0661b
        public boolean dsC() {
            return false;
        }
    }
}
