package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class v implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long mnV = com.google.android.exoplayer2.util.v.Qr("AC-3");
    private static final long mnW = com.google.android.exoplayer2.util.v.Qr("EAC3");
    private static final long mnX = com.google.android.exoplayer2.util.v.Qr("HEVC");
    private com.google.android.exoplayer2.extractor.g mkC;
    private final List<com.google.android.exoplayer2.util.s> mnY;
    private final com.google.android.exoplayer2.util.l mnZ;
    private final SparseIntArray moa;
    private final w.c mob;
    private final SparseArray<w> moc;
    private final SparseBooleanArray mod;
    private final int mode;
    private int moe;
    private boolean mof;
    private w mog;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.moe;
        vVar.moe = i + 1;
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
        this.mob = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.mnY = Collections.singletonList(sVar);
        } else {
            this.mnY = new ArrayList();
            this.mnY.add(sVar);
        }
        this.mnZ = new com.google.android.exoplayer2.util.l(9400);
        this.mod = new SparseBooleanArray();
        this.moc = new SparseArray<>();
        this.moa = new SparseIntArray();
        dum();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.mnZ.data;
        fVar.o(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            fVar.Jq(i);
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mkC = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.mnY.size();
        for (int i = 0; i < size; i++) {
            this.mnY.get(i).reset();
        }
        this.mnZ.reset();
        this.moa.clear();
        dum();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.mnZ.data;
        if (9400 - this.mnZ.getPosition() < 188) {
            int dyf = this.mnZ.dyf();
            if (dyf > 0) {
                System.arraycopy(bArr, this.mnZ.getPosition(), bArr, 0, dyf);
            }
            this.mnZ.G(bArr, dyf);
        }
        while (this.mnZ.dyf() < 188) {
            int dyg = this.mnZ.dyg();
            int read = fVar.read(bArr, dyg, 9400 - dyg);
            if (read == -1) {
                return -1;
            }
            this.mnZ.setLimit(dyg + read);
        }
        int dyg2 = this.mnZ.dyg();
        int position = this.mnZ.getPosition();
        while (position < dyg2 && bArr[position] != 71) {
            position++;
        }
        this.mnZ.setPosition(position);
        int i = position + 188;
        if (i > dyg2) {
            return 0;
        }
        int readInt = this.mnZ.readInt();
        if ((8388608 & readInt) != 0) {
            this.mnZ.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.moc.get(i2) : null;
        if (wVar == null) {
            this.mnZ.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.moa.get(i2, i3 - 1);
            this.moa.put(i2, i3);
            if (i4 == i3) {
                this.mnZ.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.cxF();
            }
        }
        if (z2) {
            this.mnZ.skipBytes(this.mnZ.readUnsignedByte());
        }
        this.mnZ.setLimit(i);
        wVar.a(this.mnZ, z);
        this.mnZ.setLimit(dyg2);
        this.mnZ.setPosition(i);
        return 0;
    }

    private void dum() {
        this.mod.clear();
        this.moc.clear();
        SparseArray<w> duh = this.mob.duh();
        int size = duh.size();
        for (int i = 0; i < size; i++) {
            this.moc.put(duh.keyAt(i), duh.valueAt(i));
        }
        this.moc.put(0, new s(new a()));
        this.mog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k moh = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dyf = lVar.dyf() / 4;
                for (int i = 0; i < dyf; i++) {
                    lVar.e(this.moh, 4);
                    int readBits = this.moh.readBits(16);
                    this.moh.JP(3);
                    if (readBits == 0) {
                        this.moh.JP(13);
                    } else {
                        int readBits2 = this.moh.readBits(13);
                        v.this.moc.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.moc.remove(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k moj = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> mok = new SparseArray<>();
        private final SparseIntArray mol = new SparseIntArray();
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
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.moe == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.mnY.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.mnY.get(0)).dyB());
                    v.this.mnY.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.moj, 2);
                this.moj.JP(4);
                lVar.skipBytes(this.moj.readBits(12));
                if (v.this.mode == 2 && v.this.mog == null) {
                    v.this.mog = v.this.mob.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.mog.a(sVar, v.this.mkC, new w.d(readUnsignedShort, 21, 8192));
                }
                this.mok.clear();
                this.mol.clear();
                int dyf = lVar.dyf();
                while (dyf > 0) {
                    lVar.e(this.moj, 5);
                    int readBits = this.moj.readBits(8);
                    this.moj.JP(3);
                    int readBits2 = this.moj.readBits(13);
                    this.moj.JP(4);
                    int readBits3 = this.moj.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dyf - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.mod.get(i2)) {
                        dyf = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.mog : v.this.mob.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.mol.get(i2, 8192)) {
                            this.mol.put(i2, readBits2);
                            this.mok.put(i2, a);
                        }
                        dyf = i;
                    }
                }
                int size = this.mol.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mol.keyAt(i3);
                    v.this.mod.put(keyAt, true);
                    w valueAt = this.mok.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.mog) {
                            valueAt.a(sVar, v.this.mkC, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.moc.put(this.mol.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.mof) {
                        v.this.mkC.dtF();
                        v.this.moe = 0;
                        v.this.mof = true;
                        return;
                    }
                    return;
                }
                v.this.moc.remove(this.pid);
                v.this.moe = v.this.mode == 1 ? 0 : v.this.moe - 1;
                if (v.this.moe == 0) {
                    v.this.mkC.dtF();
                    v.this.mof = true;
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
                    if (readUnsignedInt != v.mnV) {
                        if (readUnsignedInt != v.mnW) {
                            if (readUnsignedInt == v.mnX) {
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
                    str = lVar.LP(3).trim();
                } else if (readUnsignedByte == 89) {
                    i3 = 89;
                    arrayList = new ArrayList();
                    while (lVar.getPosition() < readUnsignedByte2) {
                        String trim = lVar.LP(3).trim();
                        int readUnsignedByte3 = lVar.readUnsignedByte();
                        byte[] bArr = new byte[4];
                        lVar.C(bArr, 0, 4);
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
