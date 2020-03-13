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
    private final int mzI;
    private final a[] mzJ;
    private a mzK;
    private b mzL;
    private int mzM;
    private List<com.google.android.exoplayer2.text.b> mzr;
    private List<com.google.android.exoplayer2.text.b> mzs;
    private final l mzm = new l();
    private final k mzH = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dxU() throws SubtitleDecoderException {
        return super.duB();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dxV() throws SubtitleDecoderException {
        return super.duA();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gv(long j) {
        super.gv(j);
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        this.mzI = i == -1 ? 1 : i;
        this.mzJ = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.mzJ[i2] = new a();
        }
        this.mzK = this.mzJ[0];
        dxT();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mzr = null;
        this.mzs = null;
        this.mzM = 0;
        this.mzK = this.mzJ[this.mzM];
        dxT();
        this.mzL = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dxQ() {
        return this.mzr != this.mzs;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dxR() {
        this.mzs = this.mzr;
        return new f(this.mzr);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.mzm.I(hVar.data.array(), hVar.data.limit());
        while (this.mzm.dzu() >= 3) {
            int readUnsignedByte = this.mzm.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.mzm.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.mzm.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dya();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.mzL = new b(i2, i3);
                        byte[] bArr = this.mzL.mAm;
                        b bVar = this.mzL;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.mzL == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.mzL.mAm;
                            b bVar2 = this.mzL;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.mzL.mAm;
                            b bVar3 = this.mzL;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.mzL.currentIndex == (this.mzL.packetSize * 2) - 1) {
                        dya();
                    }
                }
            }
        }
    }

    private void dya() {
        if (this.mzL != null) {
            dyb();
            this.mzL = null;
        }
    }

    private void dyb() {
        if (this.mzL.currentIndex != (this.mzL.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.mzL.packetSize * 2) - 1) + ", but current index is " + this.mzL.currentIndex + " (sequence number " + this.mzL.mAl + "); ignoring packet");
            return;
        }
        this.mzH.I(this.mzL.mAm, this.mzL.currentIndex);
        int readBits = this.mzH.readBits(3);
        int readBits2 = this.mzH.readBits(5);
        if (readBits == 7) {
            this.mzH.JU(2);
            readBits += this.mzH.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.mzI) {
            boolean z = false;
            while (this.mzH.dzq() > 0) {
                int readBits3 = this.mzH.readBits(8);
                if (readBits3 != 16) {
                    if (readBits3 <= 31) {
                        Lo(readBits3);
                    } else if (readBits3 <= 127) {
                        Ls(readBits3);
                        z = true;
                    } else if (readBits3 <= 159) {
                        Lp(readBits3);
                        z = true;
                    } else if (readBits3 <= 255) {
                        Lt(readBits3);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid base command: " + readBits3);
                    }
                } else {
                    int readBits4 = this.mzH.readBits(8);
                    if (readBits4 <= 31) {
                        Lq(readBits4);
                    } else if (readBits4 <= 127) {
                        Lu(readBits4);
                        z = true;
                    } else if (readBits4 <= 159) {
                        Lr(readBits4);
                    } else if (readBits4 <= 255) {
                        Lv(readBits4);
                        z = true;
                    } else {
                        Log.w("Cea708Decoder", "Invalid extended command: " + readBits4);
                    }
                }
            }
            if (z) {
                this.mzr = dxS();
            }
        }
    }

    private void Lo(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.mzr = dxS();
                return;
            case 8:
                this.mzK.dxW();
                return;
            case 12:
                dxT();
                return;
            case 13:
                this.mzK.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.mzH.JU(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.mzH.JU(16);
                    return;
                } else {
                    Log.w("Cea708Decoder", "Invalid C0 command: " + i);
                    return;
                }
        }
    }

    private void Lp(int i) {
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
                if (this.mzM != i3) {
                    this.mzM = i3;
                    this.mzK = this.mzJ[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.mzH.dvo()) {
                        this.mzJ[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.mzH.dvo()) {
                        this.mzJ[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.mzH.dvo()) {
                        this.mzJ[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.mzH.dvo()) {
                        a aVar = this.mzJ[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.mzH.dvo()) {
                        this.mzJ[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.mzH.JU(8);
                return;
            case 142:
                return;
            case 143:
                dxT();
                return;
            case 144:
                if (!this.mzK.dyg()) {
                    this.mzH.JU(16);
                    return;
                } else {
                    dyc();
                    return;
                }
            case 145:
                if (!this.mzK.dyg()) {
                    this.mzH.JU(24);
                    return;
                } else {
                    dyd();
                    return;
                }
            case 146:
                if (!this.mzK.dyg()) {
                    this.mzH.JU(16);
                    return;
                } else {
                    dye();
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
                if (!this.mzK.dyg()) {
                    this.mzH.JU(32);
                    return;
                } else {
                    dyf();
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
                Lw(i6);
                if (this.mzM != i6) {
                    this.mzM = i6;
                    this.mzK = this.mzJ[i6];
                    return;
                }
                return;
        }
    }

    private void Lq(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.mzH.JU(8);
            } else if (i <= 23) {
                this.mzH.JU(16);
            } else if (i <= 31) {
                this.mzH.JU(24);
            }
        }
    }

    private void Lr(int i) {
        if (i <= 135) {
            this.mzH.JU(32);
        } else if (i <= 143) {
            this.mzH.JU(40);
        } else if (i <= 159) {
            this.mzH.JU(2);
            this.mzH.JU(this.mzH.readBits(6) * 8);
        }
    }

    private void Ls(int i) {
        if (i == 127) {
            this.mzK.append((char) 9835);
        } else {
            this.mzK.append((char) (i & 255));
        }
    }

    private void Lt(int i) {
        this.mzK.append((char) (i & 255));
    }

    private void Lu(int i) {
        switch (i) {
            case 32:
                this.mzK.append(' ');
                return;
            case 33:
                this.mzK.append((char) 160);
                return;
            case 37:
                this.mzK.append((char) 8230);
                return;
            case 42:
                this.mzK.append((char) 352);
                return;
            case 44:
                this.mzK.append((char) 338);
                return;
            case 48:
                this.mzK.append((char) 9608);
                return;
            case 49:
                this.mzK.append((char) 8216);
                return;
            case 50:
                this.mzK.append((char) 8217);
                return;
            case 51:
                this.mzK.append((char) 8220);
                return;
            case 52:
                this.mzK.append((char) 8221);
                return;
            case 53:
                this.mzK.append((char) 8226);
                return;
            case 57:
                this.mzK.append((char) 8482);
                return;
            case 58:
                this.mzK.append((char) 353);
                return;
            case 60:
                this.mzK.append((char) 339);
                return;
            case 61:
                this.mzK.append((char) 8480);
                return;
            case 63:
                this.mzK.append((char) 376);
                return;
            case 118:
                this.mzK.append((char) 8539);
                return;
            case 119:
                this.mzK.append((char) 8540);
                return;
            case 120:
                this.mzK.append((char) 8541);
                return;
            case 121:
                this.mzK.append((char) 8542);
                return;
            case 122:
                this.mzK.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.mzK.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.mzK.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.mzK.append((char) 9472);
                return;
            case Opcodes.IAND /* 126 */:
                this.mzK.append((char) 9496);
                return;
            case 127:
                this.mzK.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lv(int i) {
        if (i == 160) {
            this.mzK.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.mzK.append('_');
    }

    private void dyc() {
        this.mzK.a(this.mzH.readBits(4), this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.dvo(), this.mzH.dvo(), this.mzH.readBits(3), this.mzH.readBits(3));
    }

    private void dyd() {
        int K = a.K(this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2));
        int K2 = a.K(this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2));
        this.mzH.JU(2);
        this.mzK.ag(K, K2, a.ah(this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2)));
    }

    private void dye() {
        this.mzH.JU(4);
        int readBits = this.mzH.readBits(4);
        this.mzH.JU(2);
        this.mzK.dS(readBits, this.mzH.readBits(6));
    }

    private void dyf() {
        int K = a.K(this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2));
        int readBits = this.mzH.readBits(2);
        int ah = a.ah(this.mzH.readBits(2), this.mzH.readBits(2), this.mzH.readBits(2));
        if (this.mzH.dvo()) {
            readBits |= 4;
        }
        boolean dvo = this.mzH.dvo();
        int readBits2 = this.mzH.readBits(2);
        int readBits3 = this.mzH.readBits(2);
        int readBits4 = this.mzH.readBits(2);
        this.mzH.JU(8);
        this.mzK.a(K, ah, dvo, readBits, readBits2, readBits3, readBits4);
    }

    private void Lw(int i) {
        a aVar = this.mzJ[i];
        this.mzH.JU(2);
        boolean dvo = this.mzH.dvo();
        boolean dvo2 = this.mzH.dvo();
        boolean dvo3 = this.mzH.dvo();
        int readBits = this.mzH.readBits(3);
        boolean dvo4 = this.mzH.dvo();
        int readBits2 = this.mzH.readBits(7);
        int readBits3 = this.mzH.readBits(8);
        int readBits4 = this.mzH.readBits(4);
        int readBits5 = this.mzH.readBits(4);
        this.mzH.JU(2);
        int readBits6 = this.mzH.readBits(6);
        this.mzH.JU(2);
        aVar.a(dvo, dvo2, dvo3, readBits, dvo4, readBits2, readBits3, readBits5, readBits6, readBits4, this.mzH.readBits(3), this.mzH.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dxS() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.mzJ[i].isEmpty() && this.mzJ[i].isVisible()) {
                arrayList.add(this.mzJ[i].dyh());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dxT() {
        for (int i = 0; i < 8; i++) {
            this.mzJ[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        int currentIndex = 0;
        public final int mAl;
        public final byte[] mAm;
        public final int packetSize;

        public b(int i, int i2) {
            this.mAl = i;
            this.packetSize = i2;
            this.mAm = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public static final int mzN = K(2, 2, 2, 0);
        public static final int mzO = K(0, 0, 0, 0);
        public static final int mzP = K(0, 0, 0, 3);
        private static final int[] mzQ = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] mzR = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] mzS = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mzT = {false, false, false, true, true, true, false};
        private static final int[] mzU = {mzO, mzP, mzO, mzO, mzP, mzO, mzO};
        private static final int[] mzV = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mzW = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mzX = {mzO, mzO, mzO, mzO, mzO, mzP, mzP};
        private int backgroundColor;
        private int foregroundColor;
        private int ht;
        private int mAa;
        private int mAb;
        private int mAc;
        private boolean mAd;
        private int mAe;
        private int mAf;
        private int mAg;
        private int mAh;
        private int mAi;
        private int mAj;
        private final List<SpannableString> mzA = new LinkedList();
        private final SpannableStringBuilder mzB = new SpannableStringBuilder();
        private int mzE;
        private boolean mzY;
        private boolean mzZ;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dyg() || (this.mzA.isEmpty() && this.mzB.length() == 0);
        }

        public void reset() {
            clear();
            this.mzY = false;
            this.visible = false;
            this.priority = 4;
            this.mzZ = false;
            this.mAa = 0;
            this.mAb = 0;
            this.mAc = 0;
            this.rowCount = 15;
            this.mAd = true;
            this.ht = 0;
            this.mAe = 0;
            this.mAf = 0;
            this.mAg = mzO;
            this.foregroundColor = mzN;
            this.backgroundColor = mzO;
        }

        public void clear() {
            this.mzA.clear();
            this.mzB.clear();
            this.mAh = -1;
            this.mzE = -1;
            this.mAi = -1;
            this.mAj = -1;
            this.row = 0;
        }

        public boolean dyg() {
            return this.mzY;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mzY = true;
            this.visible = z;
            this.mAd = z2;
            this.priority = i;
            this.mzZ = z4;
            this.mAa = i2;
            this.mAb = i3;
            this.mAc = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.mzA.size() < this.rowCount) && this.mzA.size() < 15) {
                        break;
                    }
                    this.mzA.remove(0);
                }
            }
            if (i7 != 0 && this.mAe != i7) {
                this.mAe = i7;
                int i9 = i7 - 1;
                a(mzU[i9], mzP, mzT[i9], 0, mzR[i9], mzS[i9], mzQ[i9]);
            }
            if (i8 != 0 && this.mAf != i8) {
                this.mAf = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mzW[i10], mzV[i10]);
                ag(mzN, mzX[i10], mzO);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mAg = i;
            this.ht = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mAh != -1) {
                if (!z) {
                    this.mzB.setSpan(new StyleSpan(2), this.mAh, this.mzB.length(), 33);
                    this.mAh = -1;
                }
            } else if (z) {
                this.mAh = this.mzB.length();
            }
            if (this.mzE != -1) {
                if (!z2) {
                    this.mzB.setSpan(new UnderlineSpan(), this.mzE, this.mzB.length(), 33);
                    this.mzE = -1;
                }
            } else if (z2) {
                this.mzE = this.mzB.length();
            }
        }

        public void ag(int i, int i2, int i3) {
            if (this.mAi != -1 && this.foregroundColor != i) {
                this.mzB.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mAi, this.mzB.length(), 33);
            }
            if (i != mzN) {
                this.mAi = this.mzB.length();
                this.foregroundColor = i;
            }
            if (this.mAj != -1 && this.backgroundColor != i2) {
                this.mzB.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mAj, this.mzB.length(), 33);
            }
            if (i2 != mzO) {
                this.mAj = this.mzB.length();
                this.backgroundColor = i2;
            }
        }

        public void dS(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dxW() {
            int length = this.mzB.length();
            if (length > 0) {
                this.mzB.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.mzA.add(dxY());
                this.mzB.clear();
                if (this.mAh != -1) {
                    this.mAh = 0;
                }
                if (this.mzE != -1) {
                    this.mzE = 0;
                }
                if (this.mAi != -1) {
                    this.mAi = 0;
                }
                if (this.mAj != -1) {
                    this.mAj = 0;
                }
                while (true) {
                    if ((this.mAd && this.mzA.size() >= this.rowCount) || this.mzA.size() >= 15) {
                        this.mzA.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.mzB.append(c);
            }
        }

        public SpannableString dxY() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mzB);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mAh != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mAh, length, 33);
                }
                if (this.mzE != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.mzE, length, 33);
                }
                if (this.mAi != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mAi, length, 33);
                }
                if (this.mAj != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mAj, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dyh() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.mzA.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.mzA.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dxY());
            switch (this.ht) {
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
                    throw new IllegalArgumentException("Unexpected justification value: " + this.ht);
            }
            if (this.mzZ) {
                f = this.mAb / 99.0f;
                f2 = this.mAa / 99.0f;
            } else {
                f = this.mAb / 209.0f;
                f2 = this.mAa / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mAc % 3 == 0) {
                i = 0;
            } else {
                i = this.mAc % 3 == 1 ? 1 : 2;
            }
            if (this.mAc / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mAc / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mAg != mzO, this.mAg, this.priority);
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
