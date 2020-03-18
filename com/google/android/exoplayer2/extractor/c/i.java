package com.google.android.exoplayer2.extractor.c;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
final class i {
    private static final int[] mmp = {v.QE("isom"), v.QE("iso2"), v.QE("iso3"), v.QE("iso4"), v.QE("iso5"), v.QE("iso6"), v.QE(VisualSampleEntry.TYPE3), v.QE("hvc1"), v.QE("hev1"), v.QE("mp41"), v.QE("mp42"), v.QE("3g2a"), v.QE("3g2b"), v.QE("3gr6"), v.QE("3gs6"), v.QE("3ge6"), v.QE("3gg6"), v.QE("M4V "), v.QE("M4A "), v.QE("f4v "), v.QE("kddi"), v.QE("M4VP"), v.QE("qt  "), v.QE("MSNV")};

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
            fVar.s(lVar.data, 0, 8);
            long readUnsignedInt = lVar.readUnsignedInt();
            int readInt = lVar.readInt();
            if (readUnsignedInt == 1) {
                i3 = 16;
                fVar.s(lVar.data, 8, 8);
                lVar.setLimit(16);
                readUnsignedInt = lVar.dAe();
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
            if (readInt != a.mjm) {
                if (readInt == a.mjv || readInt == a.mjx) {
                    z3 = true;
                    break;
                } else if ((i2 + readUnsignedInt) - i3 >= i) {
                    break;
                } else {
                    int i4 = (int) (readUnsignedInt - i3);
                    int i5 = i2 + i4;
                    if (readInt == a.miL) {
                        if (i4 < 8) {
                            return false;
                        }
                        lVar.reset(i4);
                        fVar.s(lVar.data, 0, i4);
                        int i6 = i4 / 4;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i6) {
                                break;
                            }
                            if (i7 == 1) {
                                lVar.skipBytes(4);
                            } else if (JV(lVar.readInt())) {
                                z2 = true;
                                break;
                            }
                            i7++;
                        }
                        if (!z2) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        fVar.JC(i4);
                    }
                    i2 = i5;
                }
            }
        }
        return z2 && z == z3;
    }

    private static boolean JV(int i) {
        if ((i >>> 8) == v.QE("3gp")) {
            return true;
        }
        for (int i2 : mmp) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
