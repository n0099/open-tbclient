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
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long mqA = com.google.android.exoplayer2.util.v.QF("AC-3");
    private static final long mqB = com.google.android.exoplayer2.util.v.QF("EAC3");
    private static final long mqC = com.google.android.exoplayer2.util.v.QF("HEVC");
    private com.google.android.exoplayer2.extractor.g mng;
    private final int mode;
    private final List<com.google.android.exoplayer2.util.s> mqD;
    private final com.google.android.exoplayer2.util.l mqE;
    private final SparseIntArray mqF;
    private final w.c mqG;
    private final SparseArray<w> mqH;
    private final SparseBooleanArray mqI;
    private int mqJ;
    private boolean mqK;
    private w mqL;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.mqJ;
        vVar.mqJ = i + 1;
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
        this.mqG = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.mqD = Collections.singletonList(sVar);
        } else {
            this.mqD = new ArrayList();
            this.mqD.add(sVar);
        }
        this.mqE = new com.google.android.exoplayer2.util.l(9400);
        this.mqI = new SparseBooleanArray();
        this.mqH = new SparseArray<>();
        this.mqF = new SparseIntArray();
        dvZ();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.mqE.data;
        fVar.s(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    break;
                }
            }
            fVar.JB(i);
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mng = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.mqD.size();
        for (int i = 0; i < size; i++) {
            this.mqD.get(i).reset();
        }
        this.mqE.reset();
        this.mqF.clear();
        dvZ();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.mqE.data;
        if (9400 - this.mqE.getPosition() < 188) {
            int dzR = this.mqE.dzR();
            if (dzR > 0) {
                System.arraycopy(bArr, this.mqE.getPosition(), bArr, 0, dzR);
            }
            this.mqE.I(bArr, dzR);
        }
        while (this.mqE.dzR() < 188) {
            int dzS = this.mqE.dzS();
            int read = fVar.read(bArr, dzS, 9400 - dzS);
            if (read == -1) {
                return -1;
            }
            this.mqE.setLimit(dzS + read);
        }
        int dzS2 = this.mqE.dzS();
        int position = this.mqE.getPosition();
        while (position < dzS2 && bArr[position] != 71) {
            position++;
        }
        this.mqE.setPosition(position);
        int i = position + Opcodes.NEWARRAY;
        if (i > dzS2) {
            return 0;
        }
        int readInt = this.mqE.readInt();
        if ((8388608 & readInt) != 0) {
            this.mqE.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.mqH.get(i2) : null;
        if (wVar == null) {
            this.mqE.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.mqF.get(i2, i3 - 1);
            this.mqF.put(i2, i3);
            if (i4 == i3) {
                this.mqE.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.czx();
            }
        }
        if (z2) {
            this.mqE.skipBytes(this.mqE.readUnsignedByte());
        }
        this.mqE.setLimit(i);
        wVar.a(this.mqE, z);
        this.mqE.setLimit(dzS2);
        this.mqE.setPosition(i);
        return 0;
    }

    private void dvZ() {
        this.mqI.clear();
        this.mqH.clear();
        SparseArray<w> dvU = this.mqG.dvU();
        int size = dvU.size();
        for (int i = 0; i < size; i++) {
            this.mqH.put(dvU.keyAt(i), dvU.valueAt(i));
        }
        this.mqH.put(0, new s(new a()));
        this.mqL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k mqM = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dzR = lVar.dzR() / 4;
                for (int i = 0; i < dzR; i++) {
                    lVar.e(this.mqM, 4);
                    int readBits = this.mqM.readBits(16);
                    this.mqM.Ka(3);
                    if (readBits == 0) {
                        this.mqM.Ka(13);
                    } else {
                        int readBits2 = this.mqM.readBits(13);
                        v.this.mqH.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.mqH.remove(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k mqO = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> mqP = new SparseArray<>();
        private final SparseIntArray mqQ = new SparseIntArray();
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
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.mqJ == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.mqD.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.mqD.get(0)).dAn());
                    v.this.mqD.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.mqO, 2);
                this.mqO.Ka(4);
                lVar.skipBytes(this.mqO.readBits(12));
                if (v.this.mode == 2 && v.this.mqL == null) {
                    v.this.mqL = v.this.mqG.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.mqL.a(sVar, v.this.mng, new w.d(readUnsignedShort, 21, 8192));
                }
                this.mqP.clear();
                this.mqQ.clear();
                int dzR = lVar.dzR();
                while (dzR > 0) {
                    lVar.e(this.mqO, 5);
                    int readBits = this.mqO.readBits(8);
                    this.mqO.Ka(3);
                    int readBits2 = this.mqO.readBits(13);
                    this.mqO.Ka(4);
                    int readBits3 = this.mqO.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dzR - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.mqI.get(i2)) {
                        dzR = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.mqL : v.this.mqG.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.mqQ.get(i2, 8192)) {
                            this.mqQ.put(i2, readBits2);
                            this.mqP.put(i2, a);
                        }
                        dzR = i;
                    }
                }
                int size = this.mqQ.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mqQ.keyAt(i3);
                    v.this.mqI.put(keyAt, true);
                    w valueAt = this.mqP.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.mqL) {
                            valueAt.a(sVar, v.this.mng, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.mqH.put(this.mqQ.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.mqK) {
                        v.this.mng.dvs();
                        v.this.mqJ = 0;
                        v.this.mqK = true;
                        return;
                    }
                    return;
                }
                v.this.mqH.remove(this.pid);
                v.this.mqJ = v.this.mode == 1 ? 0 : v.this.mqJ - 1;
                if (v.this.mqJ == 0) {
                    v.this.mng.dvs();
                    v.this.mqK = true;
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
                    if (readUnsignedInt != v.mqA) {
                        if (readUnsignedInt != v.mqB) {
                            if (readUnsignedInt == v.mqC) {
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
                    str = lVar.Ma(3).trim();
                } else if (readUnsignedByte == 89) {
                    i3 = 89;
                    arrayList = new ArrayList();
                    while (lVar.getPosition() < readUnsignedByte2) {
                        String trim = lVar.Ma(3).trim();
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
