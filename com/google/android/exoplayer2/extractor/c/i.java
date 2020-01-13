package com.google.android.exoplayer2.extractor.c;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
final class i {
    private static final int[] mjL = {v.Qr("isom"), v.Qr("iso2"), v.Qr("iso3"), v.Qr("iso4"), v.Qr("iso5"), v.Qr("iso6"), v.Qr(VisualSampleEntry.TYPE3), v.Qr("hvc1"), v.Qr("hev1"), v.Qr("mp41"), v.Qr("mp42"), v.Qr("3g2a"), v.Qr("3g2b"), v.Qr("3gr6"), v.Qr("3gs6"), v.Qr("3ge6"), v.Qr("3gg6"), v.Qr("M4V "), v.Qr("M4A "), v.Qr("f4v "), v.Qr("kddi"), v.Qr("M4VP"), v.Qr("qt  "), v.Qr("MSNV")};

    public static boolean r(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return b(fVar, true);
    }

    public static boolean s(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return b(fVar, false);
    }

    private static boolean b(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        long length = fVar.getLength();
        int i = (int) ((length == -1 || length > 4096) ? 4096L : 4096L);
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(64);
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            lVar.reset(8);
            fVar.o(lVar.data, 0, 8);
            long readUnsignedInt = lVar.readUnsignedInt();
            int readInt = lVar.readInt();
            if (readUnsignedInt == 1) {
                i3 = 16;
                fVar.o(lVar.data, 8, 8);
                lVar.setLimit(16);
                readUnsignedInt = lVar.dys();
            } else if (readUnsignedInt == 0) {
                long length2 = fVar.getLength();
                if (length2 != -1) {
                    readUnsignedInt = (length2 - fVar.getPosition()) + 8;
                }
            }
            if (readUnsignedInt < i3) {
                return false;
            }
            i2 += i3;
            if (readInt != a.mgG) {
                if (readInt == a.mgP || readInt == a.mgR) {
                    z3 = true;
                    break;
                } else if ((i2 + readUnsignedInt) - i3 >= i) {
                    break;
                } else {
                    int i4 = (int) (readUnsignedInt - i3);
                    int i5 = i2 + i4;
                    if (readInt == a.mgf) {
                        if (i4 < 8) {
                            return false;
                        }
                        lVar.reset(i4);
                        fVar.o(lVar.data, 0, i4);
                        int i6 = i4 / 4;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i6) {
                                break;
                            }
                            if (i7 == 1) {
                                lVar.skipBytes(4);
                            } else if (JK(lVar.readInt())) {
                                z2 = true;
                                break;
                            }
                            i7++;
                        }
                        if (!z2) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        fVar.Jr(i4);
                    }
                    i2 = i5;
                }
            }
        }
        return z2 && z == z3;
    }

    private static boolean JK(int i) {
        if ((i >>> 8) == v.Qr("3gp")) {
            return true;
        }
        for (int i2 : mjL) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
