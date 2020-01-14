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
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.v.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new v()};
        }
    };
    private static final long moa = com.google.android.exoplayer2.util.v.Qr("AC-3");
    private static final long mob = com.google.android.exoplayer2.util.v.Qr("EAC3");
    private static final long moc = com.google.android.exoplayer2.util.v.Qr("HEVC");
    private com.google.android.exoplayer2.extractor.g mkH;
    private final List<com.google.android.exoplayer2.util.s> mod;
    private final int mode;
    private final com.google.android.exoplayer2.util.l moe;
    private final SparseIntArray mof;
    private final w.c mog;
    private final SparseArray<w> moh;
    private final SparseBooleanArray moi;
    private int moj;
    private boolean mok;
    private w mol;

    static /* synthetic */ int b(v vVar) {
        int i = vVar.moj;
        vVar.moj = i + 1;
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
        this.mog = (w.c) com.google.android.exoplayer2.util.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.mod = Collections.singletonList(sVar);
        } else {
            this.mod = new ArrayList();
            this.mod.add(sVar);
        }
        this.moe = new com.google.android.exoplayer2.util.l(9400);
        this.moi = new SparseBooleanArray();
        this.moh = new SparseArray<>();
        this.mof = new SparseIntArray();
        duo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.moe.data;
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
        this.mkH = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        int size = this.mod.size();
        for (int i = 0; i < size; i++) {
            this.mod.get(i).reset();
        }
        this.moe.reset();
        this.mof.clear();
        duo();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        byte[] bArr = this.moe.data;
        if (9400 - this.moe.getPosition() < 188) {
            int dyh = this.moe.dyh();
            if (dyh > 0) {
                System.arraycopy(bArr, this.moe.getPosition(), bArr, 0, dyh);
            }
            this.moe.G(bArr, dyh);
        }
        while (this.moe.dyh() < 188) {
            int dyi = this.moe.dyi();
            int read = fVar.read(bArr, dyi, 9400 - dyi);
            if (read == -1) {
                return -1;
            }
            this.moe.setLimit(dyi + read);
        }
        int dyi2 = this.moe.dyi();
        int position = this.moe.getPosition();
        while (position < dyi2 && bArr[position] != 71) {
            position++;
        }
        this.moe.setPosition(position);
        int i = position + 188;
        if (i > dyi2) {
            return 0;
        }
        int readInt = this.moe.readInt();
        if ((8388608 & readInt) != 0) {
            this.moe.setPosition(i);
            return 0;
        }
        boolean z = (4194304 & readInt) != 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z2 = (readInt & 32) != 0;
        w wVar = (readInt & 16) != 0 ? this.moh.get(i2) : null;
        if (wVar == null) {
            this.moe.setPosition(i);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.mof.get(i2, i3 - 1);
            this.mof.put(i2, i3);
            if (i4 == i3) {
                this.moe.setPosition(i);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                wVar.cxH();
            }
        }
        if (z2) {
            this.moe.skipBytes(this.moe.readUnsignedByte());
        }
        this.moe.setLimit(i);
        wVar.a(this.moe, z);
        this.moe.setLimit(dyi2);
        this.moe.setPosition(i);
        return 0;
    }

    private void duo() {
        this.moi.clear();
        this.moh.clear();
        SparseArray<w> duj = this.mog.duj();
        int size = duj.size();
        for (int i = 0; i < size; i++) {
            this.moh.put(duj.keyAt(i), duj.valueAt(i));
        }
        this.moh.put(0, new s(new a()));
        this.mol = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements r {
        private final com.google.android.exoplayer2.util.k mom = new com.google.android.exoplayer2.util.k(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.f.r
        public void I(com.google.android.exoplayer2.util.l lVar) {
            if (lVar.readUnsignedByte() == 0) {
                lVar.skipBytes(7);
                int dyh = lVar.dyh() / 4;
                for (int i = 0; i < dyh; i++) {
                    lVar.e(this.mom, 4);
                    int readBits = this.mom.readBits(16);
                    this.mom.JP(3);
                    if (readBits == 0) {
                        this.mom.JP(13);
                    } else {
                        int readBits2 = this.mom.readBits(13);
                        v.this.moh.put(readBits2, new s(new b(readBits2)));
                        v.b(v.this);
                    }
                }
                if (v.this.mode != 2) {
                    v.this.moh.remove(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b implements r {
        private final com.google.android.exoplayer2.util.k mop = new com.google.android.exoplayer2.util.k(new byte[5]);
        private final SparseArray<w> moq = new SparseArray<>();
        private final SparseIntArray mor = new SparseIntArray();
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
                if (v.this.mode == 1 || v.this.mode == 2 || v.this.moj == 1) {
                    sVar = (com.google.android.exoplayer2.util.s) v.this.mod.get(0);
                } else {
                    sVar = new com.google.android.exoplayer2.util.s(((com.google.android.exoplayer2.util.s) v.this.mod.get(0)).dyD());
                    v.this.mod.add(sVar);
                }
                lVar.skipBytes(2);
                int readUnsignedShort = lVar.readUnsignedShort();
                lVar.skipBytes(5);
                lVar.e(this.mop, 2);
                this.mop.JP(4);
                lVar.skipBytes(this.mop.readBits(12));
                if (v.this.mode == 2 && v.this.mol == null) {
                    v.this.mol = v.this.mog.a(21, new w.b(21, null, null, new byte[0]));
                    v.this.mol.a(sVar, v.this.mkH, new w.d(readUnsignedShort, 21, 8192));
                }
                this.moq.clear();
                this.mor.clear();
                int dyh = lVar.dyh();
                while (dyh > 0) {
                    lVar.e(this.mop, 5);
                    int readBits = this.mop.readBits(8);
                    this.mop.JP(3);
                    int readBits2 = this.mop.readBits(13);
                    this.mop.JP(4);
                    int readBits3 = this.mop.readBits(12);
                    w.b k = k(lVar, readBits3);
                    if (readBits == 6) {
                        readBits = k.streamType;
                    }
                    int i = dyh - (readBits3 + 5);
                    int i2 = v.this.mode == 2 ? readBits : readBits2;
                    if (v.this.moi.get(i2)) {
                        dyh = i;
                    } else {
                        w a = (v.this.mode == 2 && readBits == 21) ? v.this.mol : v.this.mog.a(readBits, k);
                        if (v.this.mode != 2 || readBits2 < this.mor.get(i2, 8192)) {
                            this.mor.put(i2, readBits2);
                            this.moq.put(i2, a);
                        }
                        dyh = i;
                    }
                }
                int size = this.mor.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = this.mor.keyAt(i3);
                    v.this.moi.put(keyAt, true);
                    w valueAt = this.moq.valueAt(i3);
                    if (valueAt != null) {
                        if (valueAt != v.this.mol) {
                            valueAt.a(sVar, v.this.mkH, new w.d(readUnsignedShort, keyAt, 8192));
                        }
                        v.this.moh.put(this.mor.valueAt(i3), valueAt);
                    }
                }
                if (v.this.mode == 2) {
                    if (!v.this.mok) {
                        v.this.mkH.dtH();
                        v.this.moj = 0;
                        v.this.mok = true;
                        return;
                    }
                    return;
                }
                v.this.moh.remove(this.pid);
                v.this.moj = v.this.mode == 1 ? 0 : v.this.moj - 1;
                if (v.this.moj == 0) {
                    v.this.mkH.dtH();
                    v.this.mok = true;
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
                    if (readUnsignedInt != v.moa) {
                        if (readUnsignedInt != v.mob) {
                            if (readUnsignedInt == v.moc) {
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
