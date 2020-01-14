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
/* loaded from: classes5.dex */
public final class c extends d {
    private final int myP;
    private final a[] myQ;
    private a myR;
    private b myS;
    private int myT;
    private List<com.google.android.exoplayer2.text.b> myy;
    private List<com.google.android.exoplayer2.text.b> myz;
    private final l myt = new l();
    private final k myO = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bv(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dwH() throws SubtitleDecoderException {
        return super.dtn();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dwI() throws SubtitleDecoderException {
        return super.dtm();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gx(long j) {
        super.gx(j);
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        this.myP = i == -1 ? 1 : i;
        this.myQ = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.myQ[i2] = new a();
        }
        this.myR = this.myQ[0];
        dwG();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.myy = null;
        this.myz = null;
        this.myT = 0;
        this.myR = this.myQ[this.myT];
        dwG();
        this.myS = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dwD() {
        return this.myy != this.myz;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dwE() {
        this.myz = this.myy;
        return new f(this.myy);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.myt.G(hVar.data.array(), hVar.data.limit());
        while (this.myt.dyh() >= 3) {
            int readUnsignedByte = this.myt.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.myt.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.myt.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dwN();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.myS = new b(i2, i3);
                        byte[] bArr = this.myS.mzs;
                        b bVar = this.myS;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.myS == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.myS.mzs;
                            b bVar2 = this.myS;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.myS.mzs;
                            b bVar3 = this.myS;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.myS.currentIndex == (this.myS.packetSize * 2) - 1) {
                        dwN();
                    }
                }
            }
        }
    }

    private void dwN() {
        if (this.myS != null) {
            dwO();
            this.myS = null;
        }
    }

    private void dwO() {
        if (this.myS.currentIndex != (this.myS.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.myS.packetSize * 2) - 1) + ", but current index is " + this.myS.currentIndex + " (sequence number " + this.myS.mzr + "); ignoring packet");
            return;
        }
        this.myO.G(this.myS.mzs, this.myS.currentIndex);
        int readBits = this.myO.readBits(3);
        int readBits2 = this.myO.readBits(5);
        if (readBits == 7) {
            this.myO.JP(2);
            readBits += this.myO.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.myP) {
            boolean z = false;
            while (this.myO.dyd() > 0) {
                int readBits3 = this.myO.readBits(8);
                if (readBits3 != 16) {
                    if (readBits3 <= 31) {
                        Lj(readBits3);
                    } else if (readBits3 <= 127) {
                        Ln(readBits3);
                        z = true;
                    } else if (readBits3 <= 159) {
                        Lk(readBits3);
                        z = true;
                    } else if (readBits3 <= 255) {
                        Lo(readBits3);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid base command: " + readBits3);
                    }
                } else {
                    int readBits4 = this.myO.readBits(8);
                    if (readBits4 <= 31) {
                        Ll(readBits4);
                    } else if (readBits4 <= 127) {
                        Lp(readBits4);
                        z = true;
                    } else if (readBits4 <= 159) {
                        Lm(readBits4);
                    } else if (readBits4 <= 255) {
                        Lq(readBits4);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid extended command: " + readBits4);
                    }
                }
            }
            if (z) {
                this.myy = dwF();
            }
        }
    }

    private void Lj(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.myy = dwF();
                return;
            case 8:
                this.myR.dwJ();
                return;
            case 12:
                dwG();
                return;
            case 13:
                this.myR.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.myO.JP(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.myO.JP(16);
                    return;
                } else {
                    Log.w("Cea708Decoder", "Invalid C0 command: " + i);
                    return;
                }
        }
    }

    private void Lk(int i) {
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
                if (this.myT != i3) {
                    this.myT = i3;
                    this.myR = this.myQ[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.myO.dua()) {
                        this.myQ[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.myO.dua()) {
                        this.myQ[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.myO.dua()) {
                        this.myQ[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.myO.dua()) {
                        a aVar = this.myQ[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.myO.dua()) {
                        this.myQ[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.myO.JP(8);
                return;
            case 142:
                return;
            case 143:
                dwG();
                return;
            case 144:
                if (!this.myR.dwT()) {
                    this.myO.JP(16);
                    return;
                } else {
                    dwP();
                    return;
                }
            case 145:
                if (!this.myR.dwT()) {
                    this.myO.JP(24);
                    return;
                } else {
                    dwQ();
                    return;
                }
            case 146:
                if (!this.myR.dwT()) {
                    this.myO.JP(16);
                    return;
                } else {
                    dwR();
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
                if (!this.myR.dwT()) {
                    this.myO.JP(32);
                    return;
                } else {
                    dwS();
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
                Lr(i6);
                if (this.myT != i6) {
                    this.myT = i6;
                    this.myR = this.myQ[i6];
                    return;
                }
                return;
        }
    }

    private void Ll(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.myO.JP(8);
            } else if (i <= 23) {
                this.myO.JP(16);
            } else if (i <= 31) {
                this.myO.JP(24);
            }
        }
    }

    private void Lm(int i) {
        if (i <= 135) {
            this.myO.JP(32);
        } else if (i <= 143) {
            this.myO.JP(40);
        } else if (i <= 159) {
            this.myO.JP(2);
            this.myO.JP(this.myO.readBits(6) * 8);
        }
    }

    private void Ln(int i) {
        if (i == 127) {
            this.myR.append((char) 9835);
        } else {
            this.myR.append((char) (i & 255));
        }
    }

    private void Lo(int i) {
        this.myR.append((char) (i & 255));
    }

    private void Lp(int i) {
        switch (i) {
            case 32:
                this.myR.append(' ');
                return;
            case 33:
                this.myR.append((char) 160);
                return;
            case 37:
                this.myR.append((char) 8230);
                return;
            case 42:
                this.myR.append((char) 352);
                return;
            case 44:
                this.myR.append((char) 338);
                return;
            case 48:
                this.myR.append((char) 9608);
                return;
            case 49:
                this.myR.append((char) 8216);
                return;
            case 50:
                this.myR.append((char) 8217);
                return;
            case 51:
                this.myR.append((char) 8220);
                return;
            case 52:
                this.myR.append((char) 8221);
                return;
            case 53:
                this.myR.append((char) 8226);
                return;
            case 57:
                this.myR.append((char) 8482);
                return;
            case 58:
                this.myR.append((char) 353);
                return;
            case 60:
                this.myR.append((char) 339);
                return;
            case 61:
                this.myR.append((char) 8480);
                return;
            case 63:
                this.myR.append((char) 376);
                return;
            case 118:
                this.myR.append((char) 8539);
                return;
            case 119:
                this.myR.append((char) 8540);
                return;
            case 120:
                this.myR.append((char) 8541);
                return;
            case 121:
                this.myR.append((char) 8542);
                return;
            case 122:
                this.myR.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.myR.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.myR.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.myR.append((char) 9472);
                return;
            case 126:
                this.myR.append((char) 9496);
                return;
            case 127:
                this.myR.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lq(int i) {
        if (i == 160) {
            this.myR.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.myR.append('_');
    }

    private void dwP() {
        this.myR.a(this.myO.readBits(4), this.myO.readBits(2), this.myO.readBits(2), this.myO.dua(), this.myO.dua(), this.myO.readBits(3), this.myO.readBits(3));
    }

    private void dwQ() {
        int K = a.K(this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2));
        int K2 = a.K(this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2));
        this.myO.JP(2);
        this.myR.af(K, K2, a.ag(this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2)));
    }

    private void dwR() {
        this.myO.JP(4);
        int readBits = this.myO.readBits(4);
        this.myO.JP(2);
        this.myR.dP(readBits, this.myO.readBits(6));
    }

    private void dwS() {
        int K = a.K(this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2));
        int readBits = this.myO.readBits(2);
        int ag = a.ag(this.myO.readBits(2), this.myO.readBits(2), this.myO.readBits(2));
        if (this.myO.dua()) {
            readBits |= 4;
        }
        boolean dua = this.myO.dua();
        int readBits2 = this.myO.readBits(2);
        int readBits3 = this.myO.readBits(2);
        int readBits4 = this.myO.readBits(2);
        this.myO.JP(8);
        this.myR.a(K, ag, dua, readBits, readBits2, readBits3, readBits4);
    }

    private void Lr(int i) {
        a aVar = this.myQ[i];
        this.myO.JP(2);
        boolean dua = this.myO.dua();
        boolean dua2 = this.myO.dua();
        boolean dua3 = this.myO.dua();
        int readBits = this.myO.readBits(3);
        boolean dua4 = this.myO.dua();
        int readBits2 = this.myO.readBits(7);
        int readBits3 = this.myO.readBits(8);
        int readBits4 = this.myO.readBits(4);
        int readBits5 = this.myO.readBits(4);
        this.myO.JP(2);
        int readBits6 = this.myO.readBits(6);
        this.myO.JP(2);
        aVar.a(dua, dua2, dua3, readBits, dua4, readBits2, readBits3, readBits5, readBits6, readBits4, this.myO.readBits(3), this.myO.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dwF() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.myQ[i].isEmpty() && this.myQ[i].isVisible()) {
                arrayList.add(this.myQ[i].dwU());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dwG() {
        for (int i = 0; i < 8; i++) {
            this.myQ[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        int currentIndex = 0;
        public final int mzr;
        public final byte[] mzs;
        public final int packetSize;

        public b(int i, int i2) {
            this.mzr = i;
            this.packetSize = i2;
            this.mzs = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public static final int myU = K(2, 2, 2, 0);
        public static final int myV = K(0, 0, 0, 0);
        public static final int myW = K(0, 0, 0, 3);
        private static final int[] myX = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] myY = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] myZ = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mza = {false, false, false, true, true, true, false};
        private static final int[] mzb = {myV, myW, myV, myV, myW, myV, myV};
        private static final int[] mzc = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mzd = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mze = {myV, myV, myV, myV, myV, myW, myW};
        private int backgroundColor;
        private int foregroundColor;
        private int hp;
        private final List<SpannableString> myH = new LinkedList();
        private final SpannableStringBuilder myI = new SpannableStringBuilder();
        private int myL;
        private boolean mzf;
        private boolean mzg;
        private int mzh;
        private int mzi;
        private int mzj;
        private boolean mzk;
        private int mzl;
        private int mzm;
        private int mzn;
        private int mzo;
        private int mzp;
        private int mzq;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dwT() || (this.myH.isEmpty() && this.myI.length() == 0);
        }

        public void reset() {
            clear();
            this.mzf = false;
            this.visible = false;
            this.priority = 4;
            this.mzg = false;
            this.mzh = 0;
            this.mzi = 0;
            this.mzj = 0;
            this.rowCount = 15;
            this.mzk = true;
            this.hp = 0;
            this.mzl = 0;
            this.mzm = 0;
            this.mzn = myV;
            this.foregroundColor = myU;
            this.backgroundColor = myV;
        }

        public void clear() {
            this.myH.clear();
            this.myI.clear();
            this.mzo = -1;
            this.myL = -1;
            this.mzp = -1;
            this.mzq = -1;
            this.row = 0;
        }

        public boolean dwT() {
            return this.mzf;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mzf = true;
            this.visible = z;
            this.mzk = z2;
            this.priority = i;
            this.mzg = z4;
            this.mzh = i2;
            this.mzi = i3;
            this.mzj = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.myH.size() < this.rowCount) && this.myH.size() < 15) {
                        break;
                    }
                    this.myH.remove(0);
                }
            }
            if (i7 != 0 && this.mzl != i7) {
                this.mzl = i7;
                int i9 = i7 - 1;
                a(mzb[i9], myW, mza[i9], 0, myY[i9], myZ[i9], myX[i9]);
            }
            if (i8 != 0 && this.mzm != i8) {
                this.mzm = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mzd[i10], mzc[i10]);
                af(myU, mze[i10], myV);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mzn = i;
            this.hp = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mzo != -1) {
                if (!z) {
                    this.myI.setSpan(new StyleSpan(2), this.mzo, this.myI.length(), 33);
                    this.mzo = -1;
                }
            } else if (z) {
                this.mzo = this.myI.length();
            }
            if (this.myL != -1) {
                if (!z2) {
                    this.myI.setSpan(new UnderlineSpan(), this.myL, this.myI.length(), 33);
                    this.myL = -1;
                }
            } else if (z2) {
                this.myL = this.myI.length();
            }
        }

        public void af(int i, int i2, int i3) {
            if (this.mzp != -1 && this.foregroundColor != i) {
                this.myI.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzp, this.myI.length(), 33);
            }
            if (i != myU) {
                this.mzp = this.myI.length();
                this.foregroundColor = i;
            }
            if (this.mzq != -1 && this.backgroundColor != i2) {
                this.myI.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzq, this.myI.length(), 33);
            }
            if (i2 != myV) {
                this.mzq = this.myI.length();
                this.backgroundColor = i2;
            }
        }

        public void dP(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dwJ() {
            int length = this.myI.length();
            if (length > 0) {
                this.myI.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.myH.add(dwL());
                this.myI.clear();
                if (this.mzo != -1) {
                    this.mzo = 0;
                }
                if (this.myL != -1) {
                    this.myL = 0;
                }
                if (this.mzp != -1) {
                    this.mzp = 0;
                }
                if (this.mzq != -1) {
                    this.mzq = 0;
                }
                while (true) {
                    if ((this.mzk && this.myH.size() >= this.rowCount) || this.myH.size() >= 15) {
                        this.myH.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.myI.append(c);
            }
        }

        public SpannableString dwL() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.myI);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mzo != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mzo, length, 33);
                }
                if (this.myL != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.myL, length, 33);
                }
                if (this.mzp != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzp, length, 33);
                }
                if (this.mzq != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzq, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dwU() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.myH.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.myH.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dwL());
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
            if (this.mzg) {
                f = this.mzi / 99.0f;
                f2 = this.mzh / 99.0f;
            } else {
                f = this.mzi / 209.0f;
                f2 = this.mzh / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mzj % 3 == 0) {
                i = 0;
            } else {
                i = this.mzj % 3 == 1 ? 1 : 2;
            }
            if (this.mzj / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mzj / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mzn != myV, this.mzn, this.priority);
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
