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
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c extends d {
    private List<com.google.android.exoplayer2.text.b> mAY;
    private List<com.google.android.exoplayer2.text.b> mAZ;
    private final int mBq;
    private final a[] mBr;
    private a mBs;
    private b mBt;
    private int mBu;
    private final l mAT = new l();
    private final k mBp = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dyr() throws SubtitleDecoderException {
        return super.duY();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dys() throws SubtitleDecoderException {
        return super.duX();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gw(long j) {
        super.gw(j);
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        this.mBq = i == -1 ? 1 : i;
        this.mBr = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.mBr[i2] = new a();
        }
        this.mBs = this.mBr[0];
        dyq();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mAY = null;
        this.mAZ = null;
        this.mBu = 0;
        this.mBs = this.mBr[this.mBu];
        dyq();
        this.mBt = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dyn() {
        return this.mAY != this.mAZ;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dyo() {
        this.mAZ = this.mAY;
        return new f(this.mAY);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.mAT.I(hVar.data.array(), hVar.data.limit());
        while (this.mAT.dzR() >= 3) {
            int readUnsignedByte = this.mAT.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.mAT.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.mAT.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dyx();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.mBt = new b(i2, i3);
                        byte[] bArr = this.mBt.mBT;
                        b bVar = this.mBt;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.mBt == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.mBt.mBT;
                            b bVar2 = this.mBt;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.mBt.mBT;
                            b bVar3 = this.mBt;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.mBt.currentIndex == (this.mBt.packetSize * 2) - 1) {
                        dyx();
                    }
                }
            }
        }
    }

    private void dyx() {
        if (this.mBt != null) {
            dyy();
            this.mBt = null;
        }
    }

    private void dyy() {
        if (this.mBt.currentIndex != (this.mBt.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.mBt.packetSize * 2) - 1) + ", but current index is " + this.mBt.currentIndex + " (sequence number " + this.mBt.mBS + "); ignoring packet");
            return;
        }
        this.mBp.I(this.mBt.mBT, this.mBt.currentIndex);
        int readBits = this.mBp.readBits(3);
        int readBits2 = this.mBp.readBits(5);
        if (readBits == 7) {
            this.mBp.Ka(2);
            readBits += this.mBp.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.mBq) {
            boolean z = false;
            while (this.mBp.dzN() > 0) {
                int readBits3 = this.mBp.readBits(8);
                if (readBits3 != 16) {
                    if (readBits3 <= 31) {
                        Lu(readBits3);
                    } else if (readBits3 <= 127) {
                        Ly(readBits3);
                        z = true;
                    } else if (readBits3 <= 159) {
                        Lv(readBits3);
                        z = true;
                    } else if (readBits3 <= 255) {
                        Lz(readBits3);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid base command: " + readBits3);
                    }
                } else {
                    int readBits4 = this.mBp.readBits(8);
                    if (readBits4 <= 31) {
                        Lw(readBits4);
                    } else if (readBits4 <= 127) {
                        LA(readBits4);
                        z = true;
                    } else if (readBits4 <= 159) {
                        Lx(readBits4);
                    } else if (readBits4 <= 255) {
                        LB(readBits4);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid extended command: " + readBits4);
                    }
                }
            }
            if (z) {
                this.mAY = dyp();
            }
        }
    }

    private void Lu(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.mAY = dyp();
                return;
            case 8:
                this.mBs.dyt();
                return;
            case 12:
                dyq();
                return;
            case 13:
                this.mBs.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.mBp.Ka(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.mBp.Ka(16);
                    return;
                } else {
                    Log.w("Cea708Decoder", "Invalid C0 command: " + i);
                    return;
                }
        }
    }

    private void Lv(int i) {
        int i2 = 1;
        switch (i) {
            case 128:
            case 129:
            case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
            case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
            case IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER /* 132 */:
            case 133:
            case 134:
            case 135:
                int i3 = i - 128;
                if (this.mBu != i3) {
                    this.mBu = i3;
                    this.mBs = this.mBr[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.mBp.dvL()) {
                        this.mBr[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.mBp.dvL()) {
                        this.mBr[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.mBp.dvL()) {
                        this.mBr[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.mBp.dvL()) {
                        a aVar = this.mBr[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.mBp.dvL()) {
                        this.mBr[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.mBp.Ka(8);
                return;
            case 142:
                return;
            case 143:
                dyq();
                return;
            case 144:
                if (!this.mBs.dyD()) {
                    this.mBp.Ka(16);
                    return;
                } else {
                    dyz();
                    return;
                }
            case 145:
                if (!this.mBs.dyD()) {
                    this.mBp.Ka(24);
                    return;
                } else {
                    dyA();
                    return;
                }
            case 146:
                if (!this.mBs.dyD()) {
                    this.mBp.Ka(16);
                    return;
                } else {
                    dyB();
                    return;
                }
            case 147:
            case Opcodes.LCMP /* 148 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
            default:
                Log.w("Cea708Decoder", "Invalid C1 command: " + i);
                return;
            case Opcodes.DCMPL /* 151 */:
                if (!this.mBs.dyD()) {
                    this.mBp.Ka(32);
                    return;
                } else {
                    dyC();
                    return;
                }
            case 152:
            case Opcodes.IFEQ /* 153 */:
            case Opcodes.IFNE /* 154 */:
            case 155:
            case 156:
            case 157:
            case Opcodes.IFLE /* 158 */:
            case Opcodes.IF_ICMPEQ /* 159 */:
                int i6 = i - 152;
                LC(i6);
                if (this.mBu != i6) {
                    this.mBu = i6;
                    this.mBs = this.mBr[i6];
                    return;
                }
                return;
        }
    }

    private void Lw(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.mBp.Ka(8);
            } else if (i <= 23) {
                this.mBp.Ka(16);
            } else if (i <= 31) {
                this.mBp.Ka(24);
            }
        }
    }

    private void Lx(int i) {
        if (i <= 135) {
            this.mBp.Ka(32);
        } else if (i <= 143) {
            this.mBp.Ka(40);
        } else if (i <= 159) {
            this.mBp.Ka(2);
            this.mBp.Ka(this.mBp.readBits(6) * 8);
        }
    }

    private void Ly(int i) {
        if (i == 127) {
            this.mBs.append((char) 9835);
        } else {
            this.mBs.append((char) (i & 255));
        }
    }

    private void Lz(int i) {
        this.mBs.append((char) (i & 255));
    }

    private void LA(int i) {
        switch (i) {
            case 32:
                this.mBs.append(' ');
                return;
            case 33:
                this.mBs.append((char) 160);
                return;
            case 37:
                this.mBs.append((char) 8230);
                return;
            case 42:
                this.mBs.append((char) 352);
                return;
            case 44:
                this.mBs.append((char) 338);
                return;
            case 48:
                this.mBs.append((char) 9608);
                return;
            case 49:
                this.mBs.append((char) 8216);
                return;
            case 50:
                this.mBs.append((char) 8217);
                return;
            case 51:
                this.mBs.append((char) 8220);
                return;
            case 52:
                this.mBs.append((char) 8221);
                return;
            case 53:
                this.mBs.append((char) 8226);
                return;
            case 57:
                this.mBs.append((char) 8482);
                return;
            case 58:
                this.mBs.append((char) 353);
                return;
            case 60:
                this.mBs.append((char) 339);
                return;
            case 61:
                this.mBs.append((char) 8480);
                return;
            case 63:
                this.mBs.append((char) 376);
                return;
            case 118:
                this.mBs.append((char) 8539);
                return;
            case 119:
                this.mBs.append((char) 8540);
                return;
            case 120:
                this.mBs.append((char) 8541);
                return;
            case 121:
                this.mBs.append((char) 8542);
                return;
            case 122:
                this.mBs.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.mBs.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.mBs.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.mBs.append((char) 9472);
                return;
            case Opcodes.IAND /* 126 */:
                this.mBs.append((char) 9496);
                return;
            case 127:
                this.mBs.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void LB(int i) {
        if (i == 160) {
            this.mBs.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.mBs.append('_');
    }

    private void dyz() {
        this.mBs.a(this.mBp.readBits(4), this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.dvL(), this.mBp.dvL(), this.mBp.readBits(3), this.mBp.readBits(3));
    }

    private void dyA() {
        int K = a.K(this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2));
        int K2 = a.K(this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2));
        this.mBp.Ka(2);
        this.mBs.ag(K, K2, a.ah(this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2)));
    }

    private void dyB() {
        this.mBp.Ka(4);
        int readBits = this.mBp.readBits(4);
        this.mBp.Ka(2);
        this.mBs.dT(readBits, this.mBp.readBits(6));
    }

    private void dyC() {
        int K = a.K(this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2));
        int readBits = this.mBp.readBits(2);
        int ah = a.ah(this.mBp.readBits(2), this.mBp.readBits(2), this.mBp.readBits(2));
        if (this.mBp.dvL()) {
            readBits |= 4;
        }
        boolean dvL = this.mBp.dvL();
        int readBits2 = this.mBp.readBits(2);
        int readBits3 = this.mBp.readBits(2);
        int readBits4 = this.mBp.readBits(2);
        this.mBp.Ka(8);
        this.mBs.a(K, ah, dvL, readBits, readBits2, readBits3, readBits4);
    }

    private void LC(int i) {
        a aVar = this.mBr[i];
        this.mBp.Ka(2);
        boolean dvL = this.mBp.dvL();
        boolean dvL2 = this.mBp.dvL();
        boolean dvL3 = this.mBp.dvL();
        int readBits = this.mBp.readBits(3);
        boolean dvL4 = this.mBp.dvL();
        int readBits2 = this.mBp.readBits(7);
        int readBits3 = this.mBp.readBits(8);
        int readBits4 = this.mBp.readBits(4);
        int readBits5 = this.mBp.readBits(4);
        this.mBp.Ka(2);
        int readBits6 = this.mBp.readBits(6);
        this.mBp.Ka(2);
        aVar.a(dvL, dvL2, dvL3, readBits, dvL4, readBits2, readBits3, readBits5, readBits6, readBits4, this.mBp.readBits(3), this.mBp.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dyp() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.mBr[i].isEmpty() && this.mBr[i].isVisible()) {
                arrayList.add(this.mBr[i].dyE());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dyq() {
        for (int i = 0; i < 8; i++) {
            this.mBr[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        int currentIndex = 0;
        public final int mBS;
        public final byte[] mBT;
        public final int packetSize;

        public b(int i, int i2) {
            this.mBS = i;
            this.packetSize = i2;
            this.mBT = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private int backgroundColor;
        private int foregroundColor;
        private int hs;
        private boolean mBG;
        private boolean mBH;
        private int mBI;
        private int mBJ;
        private int mBK;
        private boolean mBL;
        private int mBM;
        private int mBN;
        private int mBO;
        private int mBP;
        private int mBQ;
        private int mBR;
        private final List<SpannableString> mBi = new LinkedList();
        private final SpannableStringBuilder mBj = new SpannableStringBuilder();
        private int mBm;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;
        public static final int mBv = K(2, 2, 2, 0);
        public static final int mBw = K(0, 0, 0, 0);
        public static final int mBx = K(0, 0, 0, 3);
        private static final int[] mBy = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] mBz = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] mBA = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mBB = {false, false, false, true, true, true, false};
        private static final int[] mBC = {mBw, mBx, mBw, mBw, mBx, mBw, mBw};
        private static final int[] mBD = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mBE = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mBF = {mBw, mBw, mBw, mBw, mBw, mBx, mBx};

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dyD() || (this.mBi.isEmpty() && this.mBj.length() == 0);
        }

        public void reset() {
            clear();
            this.mBG = false;
            this.visible = false;
            this.priority = 4;
            this.mBH = false;
            this.mBI = 0;
            this.mBJ = 0;
            this.mBK = 0;
            this.rowCount = 15;
            this.mBL = true;
            this.hs = 0;
            this.mBM = 0;
            this.mBN = 0;
            this.mBO = mBw;
            this.foregroundColor = mBv;
            this.backgroundColor = mBw;
        }

        public void clear() {
            this.mBi.clear();
            this.mBj.clear();
            this.mBP = -1;
            this.mBm = -1;
            this.mBQ = -1;
            this.mBR = -1;
            this.row = 0;
        }

        public boolean dyD() {
            return this.mBG;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mBG = true;
            this.visible = z;
            this.mBL = z2;
            this.priority = i;
            this.mBH = z4;
            this.mBI = i2;
            this.mBJ = i3;
            this.mBK = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.mBi.size() < this.rowCount) && this.mBi.size() < 15) {
                        break;
                    }
                    this.mBi.remove(0);
                }
            }
            if (i7 != 0 && this.mBM != i7) {
                this.mBM = i7;
                int i9 = i7 - 1;
                a(mBC[i9], mBx, mBB[i9], 0, mBz[i9], mBA[i9], mBy[i9]);
            }
            if (i8 != 0 && this.mBN != i8) {
                this.mBN = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mBE[i10], mBD[i10]);
                ag(mBv, mBF[i10], mBw);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mBO = i;
            this.hs = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mBP != -1) {
                if (!z) {
                    this.mBj.setSpan(new StyleSpan(2), this.mBP, this.mBj.length(), 33);
                    this.mBP = -1;
                }
            } else if (z) {
                this.mBP = this.mBj.length();
            }
            if (this.mBm != -1) {
                if (!z2) {
                    this.mBj.setSpan(new UnderlineSpan(), this.mBm, this.mBj.length(), 33);
                    this.mBm = -1;
                }
            } else if (z2) {
                this.mBm = this.mBj.length();
            }
        }

        public void ag(int i, int i2, int i3) {
            if (this.mBQ != -1 && this.foregroundColor != i) {
                this.mBj.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mBQ, this.mBj.length(), 33);
            }
            if (i != mBv) {
                this.mBQ = this.mBj.length();
                this.foregroundColor = i;
            }
            if (this.mBR != -1 && this.backgroundColor != i2) {
                this.mBj.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mBR, this.mBj.length(), 33);
            }
            if (i2 != mBw) {
                this.mBR = this.mBj.length();
                this.backgroundColor = i2;
            }
        }

        public void dT(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dyt() {
            int length = this.mBj.length();
            if (length > 0) {
                this.mBj.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.mBi.add(dyv());
                this.mBj.clear();
                if (this.mBP != -1) {
                    this.mBP = 0;
                }
                if (this.mBm != -1) {
                    this.mBm = 0;
                }
                if (this.mBQ != -1) {
                    this.mBQ = 0;
                }
                if (this.mBR != -1) {
                    this.mBR = 0;
                }
                while (true) {
                    if ((this.mBL && this.mBi.size() >= this.rowCount) || this.mBi.size() >= 15) {
                        this.mBi.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.mBj.append(c);
            }
        }

        public SpannableString dyv() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mBj);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mBP != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mBP, length, 33);
                }
                if (this.mBm != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.mBm, length, 33);
                }
                if (this.mBQ != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mBQ, length, 33);
                }
                if (this.mBR != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mBR, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dyE() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.mBi.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.mBi.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dyv());
            switch (this.hs) {
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
                    throw new IllegalArgumentException("Unexpected justification value: " + this.hs);
            }
            if (this.mBH) {
                f = this.mBJ / 99.0f;
                f2 = this.mBI / 99.0f;
            } else {
                f = this.mBJ / 209.0f;
                f2 = this.mBI / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mBK % 3 == 0) {
                i = 0;
            } else {
                i = this.mBK % 3 == 1 ? 1 : 2;
            }
            if (this.mBK / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mBK / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mBO != mBw, this.mBO, this.priority);
        }

        public static int ah(int i, int i2, int i3) {
            return K(i, i2, i3, 0);
        }

        public static int K(int i, int i2, int i3, int i4) {
            int i5;
            com.google.android.exoplayer2.util.a.aj(i, 0, 4);
            com.google.android.exoplayer2.util.a.aj(i2, 0, 4);
            com.google.android.exoplayer2.util.a.aj(i3, 0, 4);
            com.google.android.exoplayer2.util.a.aj(i4, 0, 4);
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
