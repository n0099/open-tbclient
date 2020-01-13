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
    private final int myK;
    private final a[] myL;
    private a myM;
    private b myN;
    private int myO;
    private List<com.google.android.exoplayer2.text.b> myt;
    private List<com.google.android.exoplayer2.text.b> myu;
    private final l myo = new l();
    private final k myJ = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bv(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dwF() throws SubtitleDecoderException {
        return super.dtl();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dwG() throws SubtitleDecoderException {
        return super.dtk();
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
        this.myK = i == -1 ? 1 : i;
        this.myL = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.myL[i2] = new a();
        }
        this.myM = this.myL[0];
        dwE();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.myt = null;
        this.myu = null;
        this.myO = 0;
        this.myM = this.myL[this.myO];
        dwE();
        this.myN = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dwB() {
        return this.myt != this.myu;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dwC() {
        this.myu = this.myt;
        return new f(this.myt);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.myo.G(hVar.data.array(), hVar.data.limit());
        while (this.myo.dyf() >= 3) {
            int readUnsignedByte = this.myo.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.myo.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.myo.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dwL();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.myN = new b(i2, i3);
                        byte[] bArr = this.myN.mzn;
                        b bVar = this.myN;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.myN == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.myN.mzn;
                            b bVar2 = this.myN;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.myN.mzn;
                            b bVar3 = this.myN;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.myN.currentIndex == (this.myN.packetSize * 2) - 1) {
                        dwL();
                    }
                }
            }
        }
    }

    private void dwL() {
        if (this.myN != null) {
            dwM();
            this.myN = null;
        }
    }

    private void dwM() {
        if (this.myN.currentIndex != (this.myN.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.myN.packetSize * 2) - 1) + ", but current index is " + this.myN.currentIndex + " (sequence number " + this.myN.mzm + "); ignoring packet");
            return;
        }
        this.myJ.G(this.myN.mzn, this.myN.currentIndex);
        int readBits = this.myJ.readBits(3);
        int readBits2 = this.myJ.readBits(5);
        if (readBits == 7) {
            this.myJ.JP(2);
            readBits += this.myJ.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.myK) {
            boolean z = false;
            while (this.myJ.dyb() > 0) {
                int readBits3 = this.myJ.readBits(8);
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
                    int readBits4 = this.myJ.readBits(8);
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
                this.myt = dwD();
            }
        }
    }

    private void Lj(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.myt = dwD();
                return;
            case 8:
                this.myM.dwH();
                return;
            case 12:
                dwE();
                return;
            case 13:
                this.myM.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.myJ.JP(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.myJ.JP(16);
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
                if (this.myO != i3) {
                    this.myO = i3;
                    this.myM = this.myL[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.myJ.dtY()) {
                        this.myL[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.myJ.dtY()) {
                        this.myL[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.myJ.dtY()) {
                        this.myL[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.myJ.dtY()) {
                        a aVar = this.myL[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.myJ.dtY()) {
                        this.myL[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.myJ.JP(8);
                return;
            case 142:
                return;
            case 143:
                dwE();
                return;
            case 144:
                if (!this.myM.dwR()) {
                    this.myJ.JP(16);
                    return;
                } else {
                    dwN();
                    return;
                }
            case 145:
                if (!this.myM.dwR()) {
                    this.myJ.JP(24);
                    return;
                } else {
                    dwO();
                    return;
                }
            case 146:
                if (!this.myM.dwR()) {
                    this.myJ.JP(16);
                    return;
                } else {
                    dwP();
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
                if (!this.myM.dwR()) {
                    this.myJ.JP(32);
                    return;
                } else {
                    dwQ();
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
                if (this.myO != i6) {
                    this.myO = i6;
                    this.myM = this.myL[i6];
                    return;
                }
                return;
        }
    }

    private void Ll(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.myJ.JP(8);
            } else if (i <= 23) {
                this.myJ.JP(16);
            } else if (i <= 31) {
                this.myJ.JP(24);
            }
        }
    }

    private void Lm(int i) {
        if (i <= 135) {
            this.myJ.JP(32);
        } else if (i <= 143) {
            this.myJ.JP(40);
        } else if (i <= 159) {
            this.myJ.JP(2);
            this.myJ.JP(this.myJ.readBits(6) * 8);
        }
    }

    private void Ln(int i) {
        if (i == 127) {
            this.myM.append((char) 9835);
        } else {
            this.myM.append((char) (i & 255));
        }
    }

    private void Lo(int i) {
        this.myM.append((char) (i & 255));
    }

    private void Lp(int i) {
        switch (i) {
            case 32:
                this.myM.append(' ');
                return;
            case 33:
                this.myM.append((char) 160);
                return;
            case 37:
                this.myM.append((char) 8230);
                return;
            case 42:
                this.myM.append((char) 352);
                return;
            case 44:
                this.myM.append((char) 338);
                return;
            case 48:
                this.myM.append((char) 9608);
                return;
            case 49:
                this.myM.append((char) 8216);
                return;
            case 50:
                this.myM.append((char) 8217);
                return;
            case 51:
                this.myM.append((char) 8220);
                return;
            case 52:
                this.myM.append((char) 8221);
                return;
            case 53:
                this.myM.append((char) 8226);
                return;
            case 57:
                this.myM.append((char) 8482);
                return;
            case 58:
                this.myM.append((char) 353);
                return;
            case 60:
                this.myM.append((char) 339);
                return;
            case 61:
                this.myM.append((char) 8480);
                return;
            case 63:
                this.myM.append((char) 376);
                return;
            case 118:
                this.myM.append((char) 8539);
                return;
            case 119:
                this.myM.append((char) 8540);
                return;
            case 120:
                this.myM.append((char) 8541);
                return;
            case 121:
                this.myM.append((char) 8542);
                return;
            case 122:
                this.myM.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.myM.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.myM.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.myM.append((char) 9472);
                return;
            case 126:
                this.myM.append((char) 9496);
                return;
            case 127:
                this.myM.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lq(int i) {
        if (i == 160) {
            this.myM.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.myM.append('_');
    }

    private void dwN() {
        this.myM.a(this.myJ.readBits(4), this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.dtY(), this.myJ.dtY(), this.myJ.readBits(3), this.myJ.readBits(3));
    }

    private void dwO() {
        int K = a.K(this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2));
        int K2 = a.K(this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2));
        this.myJ.JP(2);
        this.myM.af(K, K2, a.ag(this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2)));
    }

    private void dwP() {
        this.myJ.JP(4);
        int readBits = this.myJ.readBits(4);
        this.myJ.JP(2);
        this.myM.dP(readBits, this.myJ.readBits(6));
    }

    private void dwQ() {
        int K = a.K(this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2));
        int readBits = this.myJ.readBits(2);
        int ag = a.ag(this.myJ.readBits(2), this.myJ.readBits(2), this.myJ.readBits(2));
        if (this.myJ.dtY()) {
            readBits |= 4;
        }
        boolean dtY = this.myJ.dtY();
        int readBits2 = this.myJ.readBits(2);
        int readBits3 = this.myJ.readBits(2);
        int readBits4 = this.myJ.readBits(2);
        this.myJ.JP(8);
        this.myM.a(K, ag, dtY, readBits, readBits2, readBits3, readBits4);
    }

    private void Lr(int i) {
        a aVar = this.myL[i];
        this.myJ.JP(2);
        boolean dtY = this.myJ.dtY();
        boolean dtY2 = this.myJ.dtY();
        boolean dtY3 = this.myJ.dtY();
        int readBits = this.myJ.readBits(3);
        boolean dtY4 = this.myJ.dtY();
        int readBits2 = this.myJ.readBits(7);
        int readBits3 = this.myJ.readBits(8);
        int readBits4 = this.myJ.readBits(4);
        int readBits5 = this.myJ.readBits(4);
        this.myJ.JP(2);
        int readBits6 = this.myJ.readBits(6);
        this.myJ.JP(2);
        aVar.a(dtY, dtY2, dtY3, readBits, dtY4, readBits2, readBits3, readBits5, readBits6, readBits4, this.myJ.readBits(3), this.myJ.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dwD() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.myL[i].isEmpty() && this.myL[i].isVisible()) {
                arrayList.add(this.myL[i].dwS());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dwE() {
        for (int i = 0; i < 8; i++) {
            this.myL[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        int currentIndex = 0;
        public final int mzm;
        public final byte[] mzn;
        public final int packetSize;

        public b(int i, int i2) {
            this.mzm = i;
            this.packetSize = i2;
            this.mzn = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public static final int myP = K(2, 2, 2, 0);
        public static final int myQ = K(0, 0, 0, 0);
        public static final int myR = K(0, 0, 0, 3);
        private static final int[] myS = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] myT = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] myU = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] myV = {false, false, false, true, true, true, false};
        private static final int[] myW = {myQ, myR, myQ, myQ, myR, myQ, myQ};
        private static final int[] myX = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] myY = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] myZ = {myQ, myQ, myQ, myQ, myQ, myR, myR};
        private int backgroundColor;
        private int foregroundColor;
        private int hp;
        private final List<SpannableString> myC = new LinkedList();
        private final SpannableStringBuilder myD = new SpannableStringBuilder();
        private int myG;
        private boolean mza;
        private boolean mzb;
        private int mzc;
        private int mzd;
        private int mze;
        private boolean mzf;
        private int mzg;
        private int mzh;
        private int mzi;
        private int mzj;
        private int mzk;
        private int mzl;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dwR() || (this.myC.isEmpty() && this.myD.length() == 0);
        }

        public void reset() {
            clear();
            this.mza = false;
            this.visible = false;
            this.priority = 4;
            this.mzb = false;
            this.mzc = 0;
            this.mzd = 0;
            this.mze = 0;
            this.rowCount = 15;
            this.mzf = true;
            this.hp = 0;
            this.mzg = 0;
            this.mzh = 0;
            this.mzi = myQ;
            this.foregroundColor = myP;
            this.backgroundColor = myQ;
        }

        public void clear() {
            this.myC.clear();
            this.myD.clear();
            this.mzj = -1;
            this.myG = -1;
            this.mzk = -1;
            this.mzl = -1;
            this.row = 0;
        }

        public boolean dwR() {
            return this.mza;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mza = true;
            this.visible = z;
            this.mzf = z2;
            this.priority = i;
            this.mzb = z4;
            this.mzc = i2;
            this.mzd = i3;
            this.mze = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.myC.size() < this.rowCount) && this.myC.size() < 15) {
                        break;
                    }
                    this.myC.remove(0);
                }
            }
            if (i7 != 0 && this.mzg != i7) {
                this.mzg = i7;
                int i9 = i7 - 1;
                a(myW[i9], myR, myV[i9], 0, myT[i9], myU[i9], myS[i9]);
            }
            if (i8 != 0 && this.mzh != i8) {
                this.mzh = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, myY[i10], myX[i10]);
                af(myP, myZ[i10], myQ);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mzi = i;
            this.hp = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mzj != -1) {
                if (!z) {
                    this.myD.setSpan(new StyleSpan(2), this.mzj, this.myD.length(), 33);
                    this.mzj = -1;
                }
            } else if (z) {
                this.mzj = this.myD.length();
            }
            if (this.myG != -1) {
                if (!z2) {
                    this.myD.setSpan(new UnderlineSpan(), this.myG, this.myD.length(), 33);
                    this.myG = -1;
                }
            } else if (z2) {
                this.myG = this.myD.length();
            }
        }

        public void af(int i, int i2, int i3) {
            if (this.mzk != -1 && this.foregroundColor != i) {
                this.myD.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzk, this.myD.length(), 33);
            }
            if (i != myP) {
                this.mzk = this.myD.length();
                this.foregroundColor = i;
            }
            if (this.mzl != -1 && this.backgroundColor != i2) {
                this.myD.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzl, this.myD.length(), 33);
            }
            if (i2 != myQ) {
                this.mzl = this.myD.length();
                this.backgroundColor = i2;
            }
        }

        public void dP(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dwH() {
            int length = this.myD.length();
            if (length > 0) {
                this.myD.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.myC.add(dwJ());
                this.myD.clear();
                if (this.mzj != -1) {
                    this.mzj = 0;
                }
                if (this.myG != -1) {
                    this.myG = 0;
                }
                if (this.mzk != -1) {
                    this.mzk = 0;
                }
                if (this.mzl != -1) {
                    this.mzl = 0;
                }
                while (true) {
                    if ((this.mzf && this.myC.size() >= this.rowCount) || this.myC.size() >= 15) {
                        this.myC.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.myD.append(c);
            }
        }

        public SpannableString dwJ() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.myD);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mzj != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mzj, length, 33);
                }
                if (this.myG != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.myG, length, 33);
                }
                if (this.mzk != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzk, length, 33);
                }
                if (this.mzl != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzl, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dwS() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.myC.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.myC.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dwJ());
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
            if (this.mzb) {
                f = this.mzd / 99.0f;
                f2 = this.mzc / 99.0f;
            } else {
                f = this.mzd / 209.0f;
                f2 = this.mzc / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mze % 3 == 0) {
                i = 0;
            } else {
                i = this.mze % 3 == 1 ? 1 : 2;
            }
            if (this.mze / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mze / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mzi != myQ, this.mzi, this.priority);
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
