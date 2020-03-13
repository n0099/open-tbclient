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
    public static final com.google.android.exoplayer2.extractor.h meI = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long moU = com.google.android.exoplayer2.util.v.QF("AC-3");
    private static final long moV = com.google.android.exoplayer2.util.v.QF("EAC3");
    private static final long moW = com.google.android.exoplayer2.util.v.QF("HEVC");
    private com.google.android.exoplayer2.extractor.g mlA;
    private final List<com.google.android.exoplayer2.util.s> moX;
    private final com.google.android.exoplayer2.util.l moY;
    private final SparseIntArray moZ;
    private final int mode;
    private final w.c mpa;
    private final SparseArray<w> mpb;
    private final SparseBooleanArray mpc;
    private int mpd;
    private boolean mpe;
    private w mpf;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.mpd;
        vVar.mpd = i + 1;
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
        this.mpa = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.moX = Collections.singletonList(sVar);
        } else {
            this.moX = new ArrayList();
            this.moX.add(sVar);
        }
        this.moY = new com.google.android.exoplayer2.util.l(9400);
        this.mpc = new SparseBooleanArray();
        this.mpb = new SparseArray<>();
        this.moZ = new SparseIntArray();
        dvC();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.moY.data;
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
        this.mlA = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        int size = this.moX.size();
        for (int i = 0; i < size; i++) {
            this.moX.get(i).reset();
        }
        this.moY.reset();
        this.moZ.clear();
        dvC();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.moY.data;
        if (9400 - this.moY.getPosition() < 188) {
            int dzu = this.moY.dzu();
            if (dzu > 0) {
                System.arraycopy(bArr, this.moY.getPosition(), bArr, 0, dzu);
            }
            this.moY.I(bArr, dzu);
        }
        while (this.moY.dzu() < 188) {
            int dzv = this.moY.dzv();
            int read = fVar.read(bArr, dzv, 9400 - dzv);
            if (read == -1) {
                return -1;
            }
            this.moY.setLimit(dzv + read);
        }
        int dzv2 = this.moY.dzv();
        int position = this.moY.getPosition();
        while (position < dzv2 && bArr[position] != 71) {
            position++;
        }
        this.moY.setPosition(position);
        int i = position + Opcodes.NEWARRAY;
        if (i > dzv2) {
            return 0;
        }
        int readInt = this.moY.readInt();
        if ((8388608 & readInt) != 0) {
            this.moY.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.mpb.get(i2) : null;
        if (wVar == null) {
            this.moY.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.moZ.get(i2, i3 - 1);
            this.moZ.put(i2, i3);
            if (i4 == i3) {
                this.moY.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.cze();
            }
        }
        if (z2) {
            this.moY.skipBytes(this.moY.readUnsignedByte());
        }
        this.moY.setLimit(i);
        wVar.a(this.moY, z);
        this.moY.setLimit(dzv2);
        this.moY.setPosition(i);
        return 0;
    }

    private void dvC() {
        this.mpc.clear();
        this.mpb.clear();
        SparseArray<w> dvx = this.mpa.dvx();
        int size = dvx.size();
        for (int i = 0; i < size; i++) {
            this.mpb.put(dvx.keyAt(i), dvx.valueAt(i));
        }
        this.mpb.put(0, new s(new a()));
        this.mpf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k mpg = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dzu = lVar.dzu() / 4;
                for (int i = 0; i < dzu; i++) {
                    lVar.e(this.mpg, 4);
                    int readBits = this.mpg.readBits(16);
                    this.mpg.JU(3);
                    if (readBits == 0) {
                        this.mpg.JU(13);
                    } else {
                        int readBits2 = this.mpg.readBits(13);
                        v.this.mpb.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.mpb.remove(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k mpi = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> mpj = new SparseArray<>();
        private final SparseIntArray mpk = new SparseIntArray();
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
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.mpd == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.moX.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.moX.get(0)).dzQ());
                    v.this.moX.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.mpi, 2);
                this.mpi.JU(4);
                lVar.skipBytes(this.mpi.readBits(12));
                if (v.this.mode == 2 && v.this.mpf == null) {
                    v.this.mpf = v.this.mpa.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.mpf.a(sVar, v.this.mlA, new w.d(readUnsignedShort, 21, 8192));
                }
                this.mpj.clear();
                this.mpk.clear();
                int dzu = lVar.dzu();
                while (dzu > 0) {
                    lVar.e(this.mpi, 5);
                    int readBits = this.mpi.readBits(8);
                    this.mpi.JU(3);
                    int readBits2 = this.mpi.readBits(13);
                    this.mpi.JU(4);
                    int readBits3 = this.mpi.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dzu - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.mpc.get(i2)) {
                        dzu = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.mpf : v.this.mpa.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.mpk.get(i2, 8192)) {
                            this.mpk.put(i2, readBits2);
                            this.mpj.put(i2, a);
                        }
                        dzu = i;
                    }
                }
                int size = this.mpk.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mpk.keyAt(i3);
                    v.this.mpc.put(keyAt, true);
                    w valueAt = this.mpj.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.mpf) {
                            valueAt.a(sVar, v.this.mlA, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.mpb.put(this.mpk.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.mpe) {
                        v.this.mlA.duV();
                        v.this.mpd = 0;
                        v.this.mpe = true;
                        return;
                    }
                    return;
                }
                v.this.mpb.remove(this.pid);
                v.this.mpd = v.this.mode == 1 ? 0 : v.this.mpd - 1;
                if (v.this.mpd == 0) {
                    v.this.mlA.duV();
                    v.this.mpe = true;
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
                    if (readUnsignedInt != v.moU) {
                        if (readUnsignedInt != v.moV) {
                            if (readUnsignedInt == v.moW) {
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
