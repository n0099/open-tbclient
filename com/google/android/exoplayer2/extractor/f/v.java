package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class v implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mev = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long moH = com.google.android.exoplayer2.util.v.QE("AC-3");
    private static final long moI = com.google.android.exoplayer2.util.v.QE("EAC3");
    private static final long moJ = com.google.android.exoplayer2.util.v.QE("HEVC");
    private com.google.android.exoplayer2.extractor.g mln;
    private final List<com.google.android.exoplayer2.util.s> moK;
    private final com.google.android.exoplayer2.util.l moL;
    private final SparseIntArray moM;
    private final w.c moN;
    private final SparseArray<w> moO;
    private final SparseBooleanArray moP;
    private int moQ;
    private boolean moR;
    private w moS;
    private final int mode;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.moQ;
        vVar.moQ = i + 1;
        return i;
    }

    public v() {
        this(0);
    }

    public v(int i) {
        this(1, i);
    }

    public v(int i, int i2) {
        this(i, new com.google.android.exoplayer2.util.s(0L), new e(i2));
    }

    public v(int i, com.google.android.exoplayer2.util.s sVar, w.c cVar) {
        this.moN = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.moK = Collections.singletonList(sVar);
        } else {
            this.moK = new ArrayList();
            this.moK.add(sVar);
        }
        this.moL = new com.google.android.exoplayer2.util.l(9400);
        this.moP = new SparseBooleanArray();
        this.moO = new SparseArray<>();
        this.moM = new SparseIntArray();
        dvz();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.moL.data;
        fVar.s(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    break;
                }
            }
            fVar.Jv(i);
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mln = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.moK.size();
        for (int i = 0; i < size; i++) {
            this.moK.get(i).reset();
        }
        this.moL.reset();
        this.moM.clear();
        dvz();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.moL.data;
        if (9400 - this.moL.getPosition() < 188) {
            int dzr = this.moL.dzr();
            if (dzr > 0) {
                System.arraycopy(bArr, this.moL.getPosition(), bArr, 0, dzr);
            }
            this.moL.I(bArr, dzr);
        }
        while (this.moL.dzr() < 188) {
            int dzs = this.moL.dzs();
            int read = fVar.read(bArr, dzs, 9400 - dzs);
            if (read == -1) {
                return -1;
            }
            this.moL.setLimit(dzs + read);
        }
        int dzs2 = this.moL.dzs();
        int position = this.moL.getPosition();
        while (position < dzs2 && bArr[position] != 71) {
            position++;
        }
        this.moL.setPosition(position);
        int i = position + Opcodes.NEWARRAY;
        if (i > dzs2) {
            return 0;
        }
        int readInt = this.moL.readInt();
        if ((8388608 & readInt) != 0) {
            this.moL.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.moO.get(i2) : null;
        if (wVar == null) {
            this.moL.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.moM.get(i2, i3 - 1);
            this.moM.put(i2, i3);
            if (i4 == i3) {
                this.moL.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.czb();
            }
        }
        if (z2) {
            this.moL.skipBytes(this.moL.readUnsignedByte());
        }
        this.moL.setLimit(i);
        wVar.a(this.moL, z);
        this.moL.setLimit(dzs2);
        this.moL.setPosition(i);
        return 0;
    }

    private void dvz() {
        this.moP.clear();
        this.moO.clear();
        SparseArray<w> dvu = this.moN.dvu();
        int size = dvu.size();
        for (int i = 0; i < size; i++) {
            this.moO.put(dvu.keyAt(i), dvu.valueAt(i));
        }
        this.moO.put(0, new s(new a()));
        this.moS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k moT = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dzr = lVar.dzr() / 4;
                for (int i = 0; i < dzr; i++) {
                    lVar.e(this.moT, 4);
                    int readBits = this.moT.readBits(16);
                    this.moT.JU(3);
                    if (readBits == 0) {
                        this.moT.JU(13);
                    } else {
                        int readBits2 = this.moT.readBits(13);
                        v.this.moO.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.moO.remove(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k moV = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> moW = new SparseArray<>();
        private final SparseIntArray moX = new SparseIntArray();
        private final int pid;

        public b(int i) {
            this.pid = i;
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            com.google.android.exoplayer2.util.s sVar;
            if (lVar.readUnsignedByte() == 2) {
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.moQ == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.moK.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.moK.get(0)).dzN());
                    v.this.moK.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.moV, 2);
                this.moV.JU(4);
                lVar.skipBytes(this.moV.readBits(12));
                if (v.this.mode == 2 && v.this.moS == null) {
                    v.this.moS = v.this.moN.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.moS.a(sVar, v.this.mln, new w.d(readUnsignedShort, 21, 8192));
                }
                this.moW.clear();
                this.moX.clear();
                int dzr = lVar.dzr();
                while (dzr > 0) {
                    lVar.e(this.moV, 5);
                    int readBits = this.moV.readBits(8);
                    this.moV.JU(3);
                    int readBits2 = this.moV.readBits(13);
                    this.moV.JU(4);
                    int readBits3 = this.moV.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dzr - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.moP.get(i2)) {
                        dzr = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.moS : v.this.moN.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.moX.get(i2, 8192)) {
                            this.moX.put(i2, readBits2);
                            this.moW.put(i2, a);
                        }
                        dzr = i;
                    }
                }
                int size = this.moX.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.moX.keyAt(i3);
                    v.this.moP.put(keyAt, true);
                    w valueAt = this.moW.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.moS) {
                            valueAt.a(sVar, v.this.mln, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.moO.put(this.moX.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.moR) {
                        v.this.mln.duS();
                        v.this.moQ = 0;
                        v.this.moR = true;
                        return;
                    }
                    return;
                }
                v.this.moO.remove(this.pid);
                v.this.moQ = v.this.mode == 1 ? 0 : v.this.moQ - 1;
                if (v.this.moQ == 0) {
                    v.this.mln.duS();
                    v.this.moR = true;
                }
            }
        }

        private w.b k(com.google.android.exoplayer2.util.l lVar, int i) {
            int position = lVar.getPosition();
            int i2 = position + i;
            int i3 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (lVar.getPosition() < i2) {
                int readUnsignedByte = lVar.readUnsignedByte();
                int readUnsignedByte2 = lVar.readUnsignedByte() + lVar.getPosition();
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = lVar.readUnsignedInt();
                    if (readUnsignedInt != v.moH) {
                        if (readUnsignedInt != v.moI) {
                            if (readUnsignedInt == v.moJ) {
                                i3 = 36;
                            }
                        } else {
                            i3 = 135;
                        }
                    } else {
                        i3 = 129;
                    }
                } else if (readUnsignedByte == 106) {
                    i3 = 129;
                } else if (readUnsignedByte == 122) {
                    i3 = 135;
                } else if (readUnsignedByte == 123) {
                    i3 = 138;
                } else if (readUnsignedByte == 10) {
                    str = lVar.LU(3).trim();
                } else if (readUnsignedByte == 89) {
                    i3 = 89;
                    arrayList = new ArrayList();
                    while (lVar.getPosition() < readUnsignedByte2) {
                        String trim = lVar.LU(3).trim();
                        int readUnsignedByte3 = lVar.readUnsignedByte();
                        byte[] bArr = new byte[4];
                        lVar.G(bArr, 0, 4);
                        arrayList.add(new w.a(trim, readUnsignedByte3, bArr));
                    }
                }
                lVar.skipBytes(readUnsignedByte2 - lVar.getPosition());
            }
            lVar.setPosition(i2);
            return new w.b(i3, str, arrayList, Arrays.copyOfRange(lVar.data, position, i2));
        }
    }
}
