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
    private b mzA;
    private int mzB;
    private List<com.google.android.exoplayer2.text.b> mzg;
    private List<com.google.android.exoplayer2.text.b> mzh;
    private final int mzx;
    private final a[] mzy;
    private a mzz;
    private final l mzb = new l();
    private final k mzw = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dxT() throws SubtitleDecoderException {
        return super.duA();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dxU() throws SubtitleDecoderException {
        return super.duz();
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
        this.mzx = i == -1 ? 1 : i;
        this.mzy = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.mzy[i2] = new a();
        }
        this.mzz = this.mzy[0];
        dxS();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mzg = null;
        this.mzh = null;
        this.mzB = 0;
        this.mzz = this.mzy[this.mzB];
        dxS();
        this.mzA = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dxP() {
        return this.mzg != this.mzh;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dxQ() {
        this.mzh = this.mzg;
        return new f(this.mzg);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.mzb.I(hVar.data.array(), hVar.data.limit());
        while (this.mzb.dzt() >= 3) {
            int readUnsignedByte = this.mzb.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.mzb.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.mzb.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dxZ();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.mzA = new b(i2, i3);
                        byte[] bArr = this.mzA.mAa;
                        b bVar = this.mzA;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.mzA == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.mzA.mAa;
                            b bVar2 = this.mzA;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.mzA.mAa;
                            b bVar3 = this.mzA;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.mzA.currentIndex == (this.mzA.packetSize * 2) - 1) {
                        dxZ();
                    }
                }
            }
        }
    }

    private void dxZ() {
        if (this.mzA != null) {
            dya();
            this.mzA = null;
        }
    }

    private void dya() {
        if (this.mzA.currentIndex != (this.mzA.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.mzA.packetSize * 2) - 1) + ", but current index is " + this.mzA.currentIndex + " (sequence number " + this.mzA.mzZ + "); ignoring packet");
            return;
        }
        this.mzw.I(this.mzA.mAa, this.mzA.currentIndex);
        int readBits = this.mzw.readBits(3);
        int readBits2 = this.mzw.readBits(5);
        if (readBits == 7) {
            this.mzw.JU(2);
            readBits += this.mzw.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.mzx) {
            boolean z = false;
            while (this.mzw.dzp() > 0) {
                int readBits3 = this.mzw.readBits(8);
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
                    int readBits4 = this.mzw.readBits(8);
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
                this.mzg = dxR();
            }
        }
    }

    private void Lo(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.mzg = dxR();
                return;
            case 8:
                this.mzz.dxV();
                return;
            case 12:
                dxS();
                return;
            case 13:
                this.mzz.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.mzw.JU(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.mzw.JU(16);
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
                if (this.mzB != i3) {
                    this.mzB = i3;
                    this.mzz = this.mzy[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.mzw.dvn()) {
                        this.mzy[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.mzw.dvn()) {
                        this.mzy[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.mzw.dvn()) {
                        this.mzy[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.mzw.dvn()) {
                        a aVar = this.mzy[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.mzw.dvn()) {
                        this.mzy[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.mzw.JU(8);
                return;
            case 142:
                return;
            case 143:
                dxS();
                return;
            case 144:
                if (!this.mzz.dyf()) {
                    this.mzw.JU(16);
                    return;
                } else {
                    dyb();
                    return;
                }
            case 145:
                if (!this.mzz.dyf()) {
                    this.mzw.JU(24);
                    return;
                } else {
                    dyc();
                    return;
                }
            case 146:
                if (!this.mzz.dyf()) {
                    this.mzw.JU(16);
                    return;
                } else {
                    dyd();
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
                if (!this.mzz.dyf()) {
                    this.mzw.JU(32);
                    return;
                } else {
                    dye();
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
                if (this.mzB != i6) {
                    this.mzB = i6;
                    this.mzz = this.mzy[i6];
                    return;
                }
                return;
        }
    }

    private void Lq(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.mzw.JU(8);
            } else if (i <= 23) {
                this.mzw.JU(16);
            } else if (i <= 31) {
                this.mzw.JU(24);
            }
        }
    }

    private void Lr(int i) {
        if (i <= 135) {
            this.mzw.JU(32);
        } else if (i <= 143) {
            this.mzw.JU(40);
        } else if (i <= 159) {
            this.mzw.JU(2);
            this.mzw.JU(this.mzw.readBits(6) * 8);
        }
    }

    private void Ls(int i) {
        if (i == 127) {
            this.mzz.append((char) 9835);
        } else {
            this.mzz.append((char) (i & 255));
        }
    }

    private void Lt(int i) {
        this.mzz.append((char) (i & 255));
    }

    private void Lu(int i) {
        switch (i) {
            case 32:
                this.mzz.append(' ');
                return;
            case 33:
                this.mzz.append((char) 160);
                return;
            case 37:
                this.mzz.append((char) 8230);
                return;
            case 42:
                this.mzz.append((char) 352);
                return;
            case 44:
                this.mzz.append((char) 338);
                return;
            case 48:
                this.mzz.append((char) 9608);
                return;
            case 49:
                this.mzz.append((char) 8216);
                return;
            case 50:
                this.mzz.append((char) 8217);
                return;
            case 51:
                this.mzz.append((char) 8220);
                return;
            case 52:
                this.mzz.append((char) 8221);
                return;
            case 53:
                this.mzz.append((char) 8226);
                return;
            case 57:
                this.mzz.append((char) 8482);
                return;
            case 58:
                this.mzz.append((char) 353);
                return;
            case 60:
                this.mzz.append((char) 339);
                return;
            case 61:
                this.mzz.append((char) 8480);
                return;
            case 63:
                this.mzz.append((char) 376);
                return;
            case 118:
                this.mzz.append((char) 8539);
                return;
            case 119:
                this.mzz.append((char) 8540);
                return;
            case 120:
                this.mzz.append((char) 8541);
                return;
            case 121:
                this.mzz.append((char) 8542);
                return;
            case 122:
                this.mzz.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.mzz.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.mzz.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.mzz.append((char) 9472);
                return;
            case Opcodes.IAND /* 126 */:
                this.mzz.append((char) 9496);
                return;
            case 127:
                this.mzz.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lv(int i) {
        if (i == 160) {
            this.mzz.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.mzz.append('_');
    }

    private void dyb() {
        this.mzz.a(this.mzw.readBits(4), this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.dvn(), this.mzw.dvn(), this.mzw.readBits(3), this.mzw.readBits(3));
    }

    private void dyc() {
        int K = a.K(this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2));
        int K2 = a.K(this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2));
        this.mzw.JU(2);
        this.mzz.ag(K, K2, a.ah(this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2)));
    }

    private void dyd() {
        this.mzw.JU(4);
        int readBits = this.mzw.readBits(4);
        this.mzw.JU(2);
        this.mzz.dS(readBits, this.mzw.readBits(6));
    }

    private void dye() {
        int K = a.K(this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2));
        int readBits = this.mzw.readBits(2);
        int ah = a.ah(this.mzw.readBits(2), this.mzw.readBits(2), this.mzw.readBits(2));
        if (this.mzw.dvn()) {
            readBits |= 4;
        }
        boolean dvn = this.mzw.dvn();
        int readBits2 = this.mzw.readBits(2);
        int readBits3 = this.mzw.readBits(2);
        int readBits4 = this.mzw.readBits(2);
        this.mzw.JU(8);
        this.mzz.a(K, ah, dvn, readBits, readBits2, readBits3, readBits4);
    }

    private void Lw(int i) {
        a aVar = this.mzy[i];
        this.mzw.JU(2);
        boolean dvn = this.mzw.dvn();
        boolean dvn2 = this.mzw.dvn();
        boolean dvn3 = this.mzw.dvn();
        int readBits = this.mzw.readBits(3);
        boolean dvn4 = this.mzw.dvn();
        int readBits2 = this.mzw.readBits(7);
        int readBits3 = this.mzw.readBits(8);
        int readBits4 = this.mzw.readBits(4);
        int readBits5 = this.mzw.readBits(4);
        this.mzw.JU(2);
        int readBits6 = this.mzw.readBits(6);
        this.mzw.JU(2);
        aVar.a(dvn, dvn2, dvn3, readBits, dvn4, readBits2, readBits3, readBits5, readBits6, readBits4, this.mzw.readBits(3), this.mzw.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dxR() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.mzy[i].isEmpty() && this.mzy[i].isVisible()) {
                arrayList.add(this.mzy[i].dyg());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dxS() {
        for (int i = 0; i < 8; i++) {
            this.mzy[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        int currentIndex = 0;
        public final byte[] mAa;
        public final int mzZ;
        public final int packetSize;

        public b(int i, int i2) {
            this.mzZ = i;
            this.packetSize = i2;
            this.mAa = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public static final int mzC = K(2, 2, 2, 0);
        public static final int mzD = K(0, 0, 0, 0);
        public static final int mzE = K(0, 0, 0, 3);
        private static final int[] mzF = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] mzG = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] mzH = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mzI = {false, false, false, true, true, true, false};
        private static final int[] mzJ = {mzD, mzE, mzD, mzD, mzE, mzD, mzD};
        private static final int[] mzK = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mzL = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mzM = {mzD, mzD, mzD, mzD, mzD, mzE, mzE};
        private int backgroundColor;
        private int foregroundColor;
        private int ht;
        private boolean mzN;
        private boolean mzO;
        private int mzP;
        private int mzQ;
        private int mzR;
        private boolean mzS;
        private int mzT;
        private int mzU;
        private int mzV;
        private int mzW;
        private int mzX;
        private int mzY;
        private final List<SpannableString> mzp = new LinkedList();
        private final SpannableStringBuilder mzq = new SpannableStringBuilder();
        private int mzt;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dyf() || (this.mzp.isEmpty() && this.mzq.length() == 0);
        }

        public void reset() {
            clear();
            this.mzN = false;
            this.visible = false;
            this.priority = 4;
            this.mzO = false;
            this.mzP = 0;
            this.mzQ = 0;
            this.mzR = 0;
            this.rowCount = 15;
            this.mzS = true;
            this.ht = 0;
            this.mzT = 0;
            this.mzU = 0;
            this.mzV = mzD;
            this.foregroundColor = mzC;
            this.backgroundColor = mzD;
        }

        public void clear() {
            this.mzp.clear();
            this.mzq.clear();
            this.mzW = -1;
            this.mzt = -1;
            this.mzX = -1;
            this.mzY = -1;
            this.row = 0;
        }

        public boolean dyf() {
            return this.mzN;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mzN = true;
            this.visible = z;
            this.mzS = z2;
            this.priority = i;
            this.mzO = z4;
            this.mzP = i2;
            this.mzQ = i3;
            this.mzR = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.mzp.size() < this.rowCount) && this.mzp.size() < 15) {
                        break;
                    }
                    this.mzp.remove(0);
                }
            }
            if (i7 != 0 && this.mzT != i7) {
                this.mzT = i7;
                int i9 = i7 - 1;
                a(mzJ[i9], mzE, mzI[i9], 0, mzG[i9], mzH[i9], mzF[i9]);
            }
            if (i8 != 0 && this.mzU != i8) {
                this.mzU = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mzL[i10], mzK[i10]);
                ag(mzC, mzM[i10], mzD);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mzV = i;
            this.ht = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mzW != -1) {
                if (!z) {
                    this.mzq.setSpan(new StyleSpan(2), this.mzW, this.mzq.length(), 33);
                    this.mzW = -1;
                }
            } else if (z) {
                this.mzW = this.mzq.length();
            }
            if (this.mzt != -1) {
                if (!z2) {
                    this.mzq.setSpan(new UnderlineSpan(), this.mzt, this.mzq.length(), 33);
                    this.mzt = -1;
                }
            } else if (z2) {
                this.mzt = this.mzq.length();
            }
        }

        public void ag(int i, int i2, int i3) {
            if (this.mzX != -1 && this.foregroundColor != i) {
                this.mzq.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzX, this.mzq.length(), 33);
            }
            if (i != mzC) {
                this.mzX = this.mzq.length();
                this.foregroundColor = i;
            }
            if (this.mzY != -1 && this.backgroundColor != i2) {
                this.mzq.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzY, this.mzq.length(), 33);
            }
            if (i2 != mzD) {
                this.mzY = this.mzq.length();
                this.backgroundColor = i2;
            }
        }

        public void dS(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dxV() {
            int length = this.mzq.length();
            if (length > 0) {
                this.mzq.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.mzp.add(dxX());
                this.mzq.clear();
                if (this.mzW != -1) {
                    this.mzW = 0;
                }
                if (this.mzt != -1) {
                    this.mzt = 0;
                }
                if (this.mzX != -1) {
                    this.mzX = 0;
                }
                if (this.mzY != -1) {
                    this.mzY = 0;
                }
                while (true) {
                    if ((this.mzS && this.mzp.size() >= this.rowCount) || this.mzp.size() >= 15) {
                        this.mzp.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.mzq.append(c);
            }
        }

        public SpannableString dxX() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mzq);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mzW != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mzW, length, 33);
                }
                if (this.mzt != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.mzt, length, 33);
                }
                if (this.mzX != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzX, length, 33);
                }
                if (this.mzY != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzY, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dyg() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.mzp.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.mzp.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dxX());
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
            if (this.mzO) {
                f = this.mzQ / 99.0f;
                f2 = this.mzP / 99.0f;
            } else {
                f = this.mzQ / 209.0f;
                f2 = this.mzP / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mzR % 3 == 0) {
                i = 0;
            } else {
                i = this.mzR % 3 == 1 ? 1 : 2;
            }
            if (this.mzR / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mzR / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mzV != mzD, this.mzV, this.priority);
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
