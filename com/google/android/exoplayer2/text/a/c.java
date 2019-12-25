package com.google.android.exoplayer2.text.a;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public final class c extends d {
    private List<com.google.android.exoplayer2.text.b> muG;
    private List<com.google.android.exoplayer2.text.b> muH;
    private final int muX;
    private final a[] muY;
    private a muZ;
    private b mva;
    private int mvb;
    private final l muB = new l();
    private final k muW = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bu(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dvu() throws SubtitleDecoderException {
        return super.drZ();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dvv() throws SubtitleDecoderException {
        return super.drY();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gs(long j) {
        super.gs(j);
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        this.muX = i == -1 ? 1 : i;
        this.muY = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.muY[i2] = new a();
        }
        this.muZ = this.muY[0];
        dvt();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.muG = null;
        this.muH = null;
        this.mvb = 0;
        this.muZ = this.muY[this.mvb];
        dvt();
        this.mva = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dvq() {
        return this.muG != this.muH;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dvr() {
        this.muH = this.muG;
        return new f(this.muG);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.muB.G(hVar.data.array(), hVar.data.limit());
        while (this.muB.dwV() >= 3) {
            int readUnsignedByte = this.muB.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.muB.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.muB.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dvA();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.mva = new b(i2, i3);
                        byte[] bArr = this.mva.mvA;
                        b bVar = this.mva;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.mva == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.mva.mvA;
                            b bVar2 = this.mva;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.mva.mvA;
                            b bVar3 = this.mva;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.mva.currentIndex == (this.mva.packetSize * 2) - 1) {
                        dvA();
                    }
                }
            }
        }
    }

    private void dvA() {
        if (this.mva != null) {
            dvB();
            this.mva = null;
        }
    }

    private void dvB() {
        if (this.mva.currentIndex != (this.mva.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.mva.packetSize * 2) - 1) + ", but current index is " + this.mva.currentIndex + " (sequence number " + this.mva.mvz + "); ignoring packet");
            return;
        }
        this.muW.G(this.mva.mvA, this.mva.currentIndex);
        int readBits = this.muW.readBits(3);
        int readBits2 = this.muW.readBits(5);
        if (readBits == 7) {
            this.muW.JG(2);
            readBits += this.muW.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.muX) {
            boolean z = false;
            while (this.muW.dwR() > 0) {
                int readBits3 = this.muW.readBits(8);
                if (readBits3 != 16) {
                    if (readBits3 <= 31) {
                        La(readBits3);
                    } else if (readBits3 <= 127) {
                        Le(readBits3);
                        z = true;
                    } else if (readBits3 <= 159) {
                        Lb(readBits3);
                        z = true;
                    } else if (readBits3 <= 255) {
                        Lf(readBits3);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid base command: " + readBits3);
                    }
                } else {
                    int readBits4 = this.muW.readBits(8);
                    if (readBits4 <= 31) {
                        Lc(readBits4);
                    } else if (readBits4 <= 127) {
                        Lg(readBits4);
                        z = true;
                    } else if (readBits4 <= 159) {
                        Ld(readBits4);
                    } else if (readBits4 <= 255) {
                        Lh(readBits4);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid extended command: " + readBits4);
                    }
                }
            }
            if (z) {
                this.muG = dvs();
            }
        }
    }

    private void La(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.muG = dvs();
                return;
            case 8:
                this.muZ.dvw();
                return;
            case 12:
                dvt();
                return;
            case 13:
                this.muZ.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.muW.JG(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.muW.JG(16);
                    return;
                } else {
                    Log.w("Cea708Decoder", "Invalid C0 command: " + i);
                    return;
                }
        }
    }

    private void Lb(int i) {
        int i2 = 1;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i3 = i - 128;
                if (this.mvb != i3) {
                    this.mvb = i3;
                    this.muZ = this.muY[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.muW.dsM()) {
                        this.muY[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.muW.dsM()) {
                        this.muY[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.muW.dsM()) {
                        this.muY[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.muW.dsM()) {
                        a aVar = this.muY[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.muW.dsM()) {
                        this.muY[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.muW.JG(8);
                return;
            case 142:
                return;
            case 143:
                dvt();
                return;
            case 144:
                if (!this.muZ.dvG()) {
                    this.muW.JG(16);
                    return;
                } else {
                    dvC();
                    return;
                }
            case 145:
                if (!this.muZ.dvG()) {
                    this.muW.JG(24);
                    return;
                } else {
                    dvD();
                    return;
                }
            case 146:
                if (!this.muZ.dvG()) {
                    this.muW.JG(16);
                    return;
                } else {
                    dvE();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                Log.w("Cea708Decoder", "Invalid C1 command: " + i);
                return;
            case 151:
                if (!this.muZ.dvG()) {
                    this.muW.JG(32);
                    return;
                } else {
                    dvF();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i6 = i - 152;
                Li(i6);
                if (this.mvb != i6) {
                    this.mvb = i6;
                    this.muZ = this.muY[i6];
                    return;
                }
                return;
        }
    }

    private void Lc(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.muW.JG(8);
            } else if (i <= 23) {
                this.muW.JG(16);
            } else if (i <= 31) {
                this.muW.JG(24);
            }
        }
    }

    private void Ld(int i) {
        if (i <= 135) {
            this.muW.JG(32);
        } else if (i <= 143) {
            this.muW.JG(40);
        } else if (i <= 159) {
            this.muW.JG(2);
            this.muW.JG(this.muW.readBits(6) * 8);
        }
    }

    private void Le(int i) {
        if (i == 127) {
            this.muZ.append((char) 9835);
        } else {
            this.muZ.append((char) (i & 255));
        }
    }

    private void Lf(int i) {
        this.muZ.append((char) (i & 255));
    }

    private void Lg(int i) {
        switch (i) {
            case 32:
                this.muZ.append(' ');
                return;
            case 33:
                this.muZ.append((char) 160);
                return;
            case 37:
                this.muZ.append((char) 8230);
                return;
            case 42:
                this.muZ.append((char) 352);
                return;
            case 44:
                this.muZ.append((char) 338);
                return;
            case 48:
                this.muZ.append((char) 9608);
                return;
            case 49:
                this.muZ.append((char) 8216);
                return;
            case 50:
                this.muZ.append((char) 8217);
                return;
            case 51:
                this.muZ.append((char) 8220);
                return;
            case 52:
                this.muZ.append((char) 8221);
                return;
            case 53:
                this.muZ.append((char) 8226);
                return;
            case 57:
                this.muZ.append((char) 8482);
                return;
            case 58:
                this.muZ.append((char) 353);
                return;
            case 60:
                this.muZ.append((char) 339);
                return;
            case 61:
                this.muZ.append((char) 8480);
                return;
            case 63:
                this.muZ.append((char) 376);
                return;
            case 118:
                this.muZ.append((char) 8539);
                return;
            case 119:
                this.muZ.append((char) 8540);
                return;
            case 120:
                this.muZ.append((char) 8541);
                return;
            case 121:
                this.muZ.append((char) 8542);
                return;
            case 122:
                this.muZ.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.muZ.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.muZ.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.muZ.append((char) 9472);
                return;
            case 126:
                this.muZ.append((char) 9496);
                return;
            case 127:
                this.muZ.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lh(int i) {
        if (i == 160) {
            this.muZ.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.muZ.append('_');
    }

    private void dvC() {
        this.muZ.a(this.muW.readBits(4), this.muW.readBits(2), this.muW.readBits(2), this.muW.dsM(), this.muW.dsM(), this.muW.readBits(3), this.muW.readBits(3));
    }

    private void dvD() {
        int K = a.K(this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2));
        int K2 = a.K(this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2));
        this.muW.JG(2);
        this.muZ.af(K, K2, a.ag(this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2)));
    }

    private void dvE() {
        this.muW.JG(4);
        int readBits = this.muW.readBits(4);
        this.muW.JG(2);
        this.muZ.dR(readBits, this.muW.readBits(6));
    }

    private void dvF() {
        int K = a.K(this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2));
        int readBits = this.muW.readBits(2);
        int ag = a.ag(this.muW.readBits(2), this.muW.readBits(2), this.muW.readBits(2));
        if (this.muW.dsM()) {
            readBits |= 4;
        }
        boolean dsM = this.muW.dsM();
        int readBits2 = this.muW.readBits(2);
        int readBits3 = this.muW.readBits(2);
        int readBits4 = this.muW.readBits(2);
        this.muW.JG(8);
        this.muZ.a(K, ag, dsM, readBits, readBits2, readBits3, readBits4);
    }

    private void Li(int i) {
        a aVar = this.muY[i];
        this.muW.JG(2);
        boolean dsM = this.muW.dsM();
        boolean dsM2 = this.muW.dsM();
        boolean dsM3 = this.muW.dsM();
        int readBits = this.muW.readBits(3);
        boolean dsM4 = this.muW.dsM();
        int readBits2 = this.muW.readBits(7);
        int readBits3 = this.muW.readBits(8);
        int readBits4 = this.muW.readBits(4);
        int readBits5 = this.muW.readBits(4);
        this.muW.JG(2);
        int readBits6 = this.muW.readBits(6);
        this.muW.JG(2);
        aVar.a(dsM, dsM2, dsM3, readBits, dsM4, readBits2, readBits3, readBits5, readBits6, readBits4, this.muW.readBits(3), this.muW.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dvs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.muY[i].isEmpty() && this.muY[i].isVisible()) {
                arrayList.add(this.muY[i].dvH());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dvt() {
        for (int i = 0; i < 8; i++) {
            this.muY[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {
        int currentIndex = 0;
        public final byte[] mvA;
        public final int mvz;
        public final int packetSize;

        public b(int i, int i2) {
            this.mvz = i;
            this.packetSize = i2;
            this.mvA = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public static final int mvc = K(2, 2, 2, 0);
        public static final int mvd = K(0, 0, 0, 0);
        public static final int mve = K(0, 0, 0, 3);
        private static final int[] mvf = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] mvg = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] mvh = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mvi = {false, false, false, true, true, true, false};
        private static final int[] mvj = {mvd, mve, mvd, mvd, mve, mvd, mvd};
        private static final int[] mvk = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mvl = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mvm = {mvd, mvd, mvd, mvd, mvd, mve, mve};
        private int backgroundColor;
        private int foregroundColor;
        private int hp;
        private final List<SpannableString> muP = new LinkedList();
        private final SpannableStringBuilder muQ = new SpannableStringBuilder();
        private int muT;
        private boolean mvn;
        private boolean mvo;
        private int mvp;
        private int mvq;
        private int mvr;
        private boolean mvs;
        private int mvt;
        private int mvu;
        private int mvv;
        private int mvw;
        private int mvx;
        private int mvy;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dvG() || (this.muP.isEmpty() && this.muQ.length() == 0);
        }

        public void reset() {
            clear();
            this.mvn = false;
            this.visible = false;
            this.priority = 4;
            this.mvo = false;
            this.mvp = 0;
            this.mvq = 0;
            this.mvr = 0;
            this.rowCount = 15;
            this.mvs = true;
            this.hp = 0;
            this.mvt = 0;
            this.mvu = 0;
            this.mvv = mvd;
            this.foregroundColor = mvc;
            this.backgroundColor = mvd;
        }

        public void clear() {
            this.muP.clear();
            this.muQ.clear();
            this.mvw = -1;
            this.muT = -1;
            this.mvx = -1;
            this.mvy = -1;
            this.row = 0;
        }

        public boolean dvG() {
            return this.mvn;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mvn = true;
            this.visible = z;
            this.mvs = z2;
            this.priority = i;
            this.mvo = z4;
            this.mvp = i2;
            this.mvq = i3;
            this.mvr = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.muP.size() < this.rowCount) && this.muP.size() < 15) {
                        break;
                    }
                    this.muP.remove(0);
                }
            }
            if (i7 != 0 && this.mvt != i7) {
                this.mvt = i7;
                int i9 = i7 - 1;
                a(mvj[i9], mve, mvi[i9], 0, mvg[i9], mvh[i9], mvf[i9]);
            }
            if (i8 != 0 && this.mvu != i8) {
                this.mvu = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mvl[i10], mvk[i10]);
                af(mvc, mvm[i10], mvd);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mvv = i;
            this.hp = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mvw != -1) {
                if (!z) {
                    this.muQ.setSpan(new StyleSpan(2), this.mvw, this.muQ.length(), 33);
                    this.mvw = -1;
                }
            } else if (z) {
                this.mvw = this.muQ.length();
            }
            if (this.muT != -1) {
                if (!z2) {
                    this.muQ.setSpan(new UnderlineSpan(), this.muT, this.muQ.length(), 33);
                    this.muT = -1;
                }
            } else if (z2) {
                this.muT = this.muQ.length();
            }
        }

        public void af(int i, int i2, int i3) {
            if (this.mvx != -1 && this.foregroundColor != i) {
                this.muQ.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mvx, this.muQ.length(), 33);
            }
            if (i != mvc) {
                this.mvx = this.muQ.length();
                this.foregroundColor = i;
            }
            if (this.mvy != -1 && this.backgroundColor != i2) {
                this.muQ.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mvy, this.muQ.length(), 33);
            }
            if (i2 != mvd) {
                this.mvy = this.muQ.length();
                this.backgroundColor = i2;
            }
        }

        public void dR(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dvw() {
            int length = this.muQ.length();
            if (length > 0) {
                this.muQ.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.muP.add(dvy());
                this.muQ.clear();
                if (this.mvw != -1) {
                    this.mvw = 0;
                }
                if (this.muT != -1) {
                    this.muT = 0;
                }
                if (this.mvx != -1) {
                    this.mvx = 0;
                }
                if (this.mvy != -1) {
                    this.mvy = 0;
                }
                while (true) {
                    if ((this.mvs && this.muP.size() >= this.rowCount) || this.muP.size() >= 15) {
                        this.muP.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.muQ.append(c);
            }
        }

        public SpannableString dvy() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.muQ);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mvw != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mvw, length, 33);
                }
                if (this.muT != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.muT, length, 33);
                }
                if (this.mvx != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mvx, length, 33);
                }
                if (this.mvy != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mvy, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dvH() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.muP.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.muP.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dvy());
            switch (this.hp) {
                case 0:
                case 3:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected justification value: " + this.hp);
            }
            if (this.mvo) {
                f = this.mvq / 99.0f;
                f2 = this.mvp / 99.0f;
            } else {
                f = this.mvq / 209.0f;
                f2 = this.mvp / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mvr % 3 == 0) {
                i = 0;
            } else {
                i = this.mvr % 3 == 1 ? 1 : 2;
            }
            if (this.mvr / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mvr / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mvv != mvd, this.mvv, this.priority);
        }

        public static int ag(int i, int i2, int i3) {
            return K(i, i2, i3, 0);
        }

        public static int K(int i, int i2, int i3, int i4) {
            int i5;
            com.google.android.exoplayer2.util.a.ai(i, 0, 4);
            com.google.android.exoplayer2.util.a.ai(i2, 0, 4);
            com.google.android.exoplayer2.util.a.ai(i3, 0, 4);
            com.google.android.exoplayer2.util.a.ai(i4, 0, 4);
            switch (i4) {
                case 0:
                case 1:
                    i5 = 255;
                    break;
                case 2:
                    i5 = 127;
                    break;
                case 3:
                    i5 = 0;
                    break;
                default:
                    i5 = 255;
                    break;
            }
            return Color.argb(i5, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, i3 <= 1 ? 0 : 255);
        }
    }
}
