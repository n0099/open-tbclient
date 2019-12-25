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
/* loaded from: classes4.dex */
public final class v implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long mkh = com.google.android.exoplayer2.util.v.Qg("AC-3");
    private static final long mki = com.google.android.exoplayer2.util.v.Qg("EAC3");
    private static final long mkj = com.google.android.exoplayer2.util.v.Qg("HEVC");
    private com.google.android.exoplayer2.extractor.g mgL;
    private final List<com.google.android.exoplayer2.util.s> mkk;
    private final com.google.android.exoplayer2.util.l mkl;
    private final SparseIntArray mkm;
    private final w.c mkn;
    private final SparseArray<w> mko;
    private final SparseBooleanArray mkp;
    private int mkq;
    private boolean mkr;
    private w mks;
    private final int mode;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.mkq;
        vVar.mkq = i + 1;
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
        this.mkn = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.mkk = Collections.singletonList(sVar);
        } else {
            this.mkk = new ArrayList();
            this.mkk.add(sVar);
        }
        this.mkl = new com.google.android.exoplayer2.util.l(9400);
        this.mkp = new SparseBooleanArray();
        this.mko = new SparseArray<>();
        this.mkm = new SparseIntArray();
        dta();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.mkl.data;
        fVar.p(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            fVar.Jh(i);
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mgL = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.mkk.size();
        for (int i = 0; i < size; i++) {
            this.mkk.get(i).reset();
        }
        this.mkl.reset();
        this.mkm.clear();
        dta();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.mkl.data;
        if (9400 - this.mkl.getPosition() < 188) {
            int dwV = this.mkl.dwV();
            if (dwV > 0) {
                System.arraycopy(bArr, this.mkl.getPosition(), bArr, 0, dwV);
            }
            this.mkl.G(bArr, dwV);
        }
        while (this.mkl.dwV() < 188) {
            int dwW = this.mkl.dwW();
            int read = fVar.read(bArr, dwW, 9400 - dwW);
            if (read == -1) {
                return -1;
            }
            this.mkl.setLimit(dwW + read);
        }
        int dwW2 = this.mkl.dwW();
        int position = this.mkl.getPosition();
        while (position < dwW2 && bArr[position] != 71) {
            position++;
        }
        this.mkl.setPosition(position);
        int i = position + 188;
        if (i > dwW2) {
            return 0;
        }
        int readInt = this.mkl.readInt();
        if ((8388608 & readInt) != 0) {
            this.mkl.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.mko.get(i2) : null;
        if (wVar == null) {
            this.mkl.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.mkm.get(i2, i3 - 1);
            this.mkm.put(i2, i3);
            if (i4 == i3) {
                this.mkl.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.cwy();
            }
        }
        if (z2) {
            this.mkl.skipBytes(this.mkl.readUnsignedByte());
        }
        this.mkl.setLimit(i);
        wVar.a(this.mkl, z);
        this.mkl.setLimit(dwW2);
        this.mkl.setPosition(i);
        return 0;
    }

    private void dta() {
        this.mkp.clear();
        this.mko.clear();
        SparseArray<w> dsV = this.mkn.dsV();
        int size = dsV.size();
        for (int i = 0; i < size; i++) {
            this.mko.put(dsV.keyAt(i), dsV.valueAt(i));
        }
        this.mko.put(0, new s(new a()));
        this.mks = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k mkt = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dwV = lVar.dwV() / 4;
                for (int i = 0; i < dwV; i++) {
                    lVar.e(this.mkt, 4);
                    int readBits = this.mkt.readBits(16);
                    this.mkt.JG(3);
                    if (readBits == 0) {
                        this.mkt.JG(13);
                    } else {
                        int readBits2 = this.mkt.readBits(13);
                        v.this.mko.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.mko.remove(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k mkv = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> mkw = new SparseArray<>();
        private final SparseIntArray mkx = new SparseIntArray();
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
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.mkq == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.mkk.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.mkk.get(0)).dxr());
                    v.this.mkk.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.mkv, 2);
                this.mkv.JG(4);
                lVar.skipBytes(this.mkv.readBits(12));
                if (v.this.mode == 2 && v.this.mks == null) {
                    v.this.mks = v.this.mkn.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.mks.a(sVar, v.this.mgL, new w.d(readUnsignedShort, 21, 8192));
                }
                this.mkw.clear();
                this.mkx.clear();
                int dwV = lVar.dwV();
                while (dwV > 0) {
                    lVar.e(this.mkv, 5);
                    int readBits = this.mkv.readBits(8);
                    this.mkv.JG(3);
                    int readBits2 = this.mkv.readBits(13);
                    this.mkv.JG(4);
                    int readBits3 = this.mkv.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dwV - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.mkp.get(i2)) {
                        dwV = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.mks : v.this.mkn.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.mkx.get(i2, 8192)) {
                            this.mkx.put(i2, readBits2);
                            this.mkw.put(i2, a);
                        }
                        dwV = i;
                    }
                }
                int size = this.mkx.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mkx.keyAt(i3);
                    v.this.mkp.put(keyAt, true);
                    w valueAt = this.mkw.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.mks) {
                            valueAt.a(sVar, v.this.mgL, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.mko.put(this.mkx.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.mkr) {
                        v.this.mgL.dst();
                        v.this.mkq = 0;
                        v.this.mkr = true;
                        return;
                    }
                    return;
                }
                v.this.mko.remove(this.pid);
                v.this.mkq = v.this.mode == 1 ? 0 : v.this.mkq - 1;
                if (v.this.mkq == 0) {
                    v.this.mgL.dst();
                    v.this.mkr = true;
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
                    if (readUnsignedInt != v.mkh) {
                        if (readUnsignedInt != v.mki) {
                            if (readUnsignedInt == v.mkj) {
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
                    str = lVar.LG(3).trim();
                } else if (readUnsignedByte == 89) {
                    i3 = 89;
                    arrayList = new ArrayList();
                    while (lVar.getPosition() < readUnsignedByte2) {
                        String trim = lVar.LG(3).trim();
                        int readUnsignedByte3 = lVar.readUnsignedByte();
                        byte[] bArr = new byte[4];
                        lVar.D(bArr, 0, 4);
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
