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
    private List<com.google.android.exoplayer2.text.b> mze;
    private List<com.google.android.exoplayer2.text.b> mzf;
    private final int mzv;
    private final a[] mzw;
    private a mzx;
    private b mzy;
    private int mzz;
    private final l myZ = new l();
    private final k mzu = new k();

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dxR() throws SubtitleDecoderException {
        return super.duy();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dxS() throws SubtitleDecoderException {
        return super.dux();
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
        this.mzv = i == -1 ? 1 : i;
        this.mzw = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.mzw[i2] = new a();
        }
        this.mzx = this.mzw[0];
        dxQ();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mze = null;
        this.mzf = null;
        this.mzz = 0;
        this.mzx = this.mzw[this.mzz];
        dxQ();
        this.mzy = null;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dxN() {
        return this.mze != this.mzf;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dxO() {
        this.mzf = this.mze;
        return new f(this.mze);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.myZ.I(hVar.data.array(), hVar.data.limit());
        while (this.myZ.dzr() >= 3) {
            int readUnsignedByte = this.myZ.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.myZ.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.myZ.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        dxX();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = readUnsignedByte2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        this.mzy = new b(i2, i3);
                        byte[] bArr = this.mzy.mzY;
                        b bVar = this.mzy;
                        int i4 = bVar.currentIndex;
                        bVar.currentIndex = i4 + 1;
                        bArr[i4] = readUnsignedByte3;
                    } else {
                        com.google.android.exoplayer2.util.a.checkArgument(i == 2);
                        if (this.mzy == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = this.mzy.mzY;
                            b bVar2 = this.mzy;
                            int i5 = bVar2.currentIndex;
                            bVar2.currentIndex = i5 + 1;
                            bArr2[i5] = readUnsignedByte2;
                            byte[] bArr3 = this.mzy.mzY;
                            b bVar3 = this.mzy;
                            int i6 = bVar3.currentIndex;
                            bVar3.currentIndex = i6 + 1;
                            bArr3[i6] = readUnsignedByte3;
                        }
                    }
                    if (this.mzy.currentIndex == (this.mzy.packetSize * 2) - 1) {
                        dxX();
                    }
                }
            }
        }
    }

    private void dxX() {
        if (this.mzy != null) {
            dxY();
            this.mzy = null;
        }
    }

    private void dxY() {
        if (this.mzy.currentIndex != (this.mzy.packetSize * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.mzy.packetSize * 2) - 1) + ", but current index is " + this.mzy.currentIndex + " (sequence number " + this.mzy.mzX + "); ignoring packet");
            return;
        }
        this.mzu.I(this.mzy.mzY, this.mzy.currentIndex);
        int readBits = this.mzu.readBits(3);
        int readBits2 = this.mzu.readBits(5);
        if (readBits == 7) {
            this.mzu.JU(2);
            readBits += this.mzu.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.mzv) {
            boolean z = false;
            while (this.mzu.dzn() > 0) {
                int readBits3 = this.mzu.readBits(8);
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
                    int readBits4 = this.mzu.readBits(8);
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
                this.mze = dxP();
            }
        }
    }

    private void Lo(int i) {
        switch (i) {
            case 0:
            case 14:
                return;
            case 3:
                this.mze = dxP();
                return;
            case 8:
                this.mzx.dxT();
                return;
            case 12:
                dxQ();
                return;
            case 13:
                this.mzx.append('\n');
                return;
            default:
                if (i >= 17 && i <= 23) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                    this.mzu.JU(8);
                    return;
                } else if (i >= 24 && i <= 31) {
                    Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                    this.mzu.JU(16);
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
                if (this.mzz != i3) {
                    this.mzz = i3;
                    this.mzx = this.mzw[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.mzu.dvl()) {
                        this.mzw[8 - i2].clear();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.mzu.dvl()) {
                        this.mzw[8 - i4].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.mzu.dvl()) {
                        this.mzw[8 - i2].setVisibility(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.mzu.dvl()) {
                        a aVar = this.mzw[8 - i5];
                        aVar.setVisibility(!aVar.isVisible());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.mzu.dvl()) {
                        this.mzw[8 - i2].reset();
                    }
                    i2++;
                }
                return;
            case 141:
                this.mzu.JU(8);
                return;
            case 142:
                return;
            case 143:
                dxQ();
                return;
            case 144:
                if (!this.mzx.dyd()) {
                    this.mzu.JU(16);
                    return;
                } else {
                    dxZ();
                    return;
                }
            case 145:
                if (!this.mzx.dyd()) {
                    this.mzu.JU(24);
                    return;
                } else {
                    dya();
                    return;
                }
            case 146:
                if (!this.mzx.dyd()) {
                    this.mzu.JU(16);
                    return;
                } else {
                    dyb();
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
                if (!this.mzx.dyd()) {
                    this.mzu.JU(32);
                    return;
                } else {
                    dyc();
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
                if (this.mzz != i6) {
                    this.mzz = i6;
                    this.mzx = this.mzw[i6];
                    return;
                }
                return;
        }
    }

    private void Lq(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.mzu.JU(8);
            } else if (i <= 23) {
                this.mzu.JU(16);
            } else if (i <= 31) {
                this.mzu.JU(24);
            }
        }
    }

    private void Lr(int i) {
        if (i <= 135) {
            this.mzu.JU(32);
        } else if (i <= 143) {
            this.mzu.JU(40);
        } else if (i <= 159) {
            this.mzu.JU(2);
            this.mzu.JU(this.mzu.readBits(6) * 8);
        }
    }

    private void Ls(int i) {
        if (i == 127) {
            this.mzx.append((char) 9835);
        } else {
            this.mzx.append((char) (i & 255));
        }
    }

    private void Lt(int i) {
        this.mzx.append((char) (i & 255));
    }

    private void Lu(int i) {
        switch (i) {
            case 32:
                this.mzx.append(' ');
                return;
            case 33:
                this.mzx.append((char) 160);
                return;
            case 37:
                this.mzx.append((char) 8230);
                return;
            case 42:
                this.mzx.append((char) 352);
                return;
            case 44:
                this.mzx.append((char) 338);
                return;
            case 48:
                this.mzx.append((char) 9608);
                return;
            case 49:
                this.mzx.append((char) 8216);
                return;
            case 50:
                this.mzx.append((char) 8217);
                return;
            case 51:
                this.mzx.append((char) 8220);
                return;
            case 52:
                this.mzx.append((char) 8221);
                return;
            case 53:
                this.mzx.append((char) 8226);
                return;
            case 57:
                this.mzx.append((char) 8482);
                return;
            case 58:
                this.mzx.append((char) 353);
                return;
            case 60:
                this.mzx.append((char) 339);
                return;
            case 61:
                this.mzx.append((char) 8480);
                return;
            case 63:
                this.mzx.append((char) 376);
                return;
            case 118:
                this.mzx.append((char) 8539);
                return;
            case 119:
                this.mzx.append((char) 8540);
                return;
            case 120:
                this.mzx.append((char) 8541);
                return;
            case 121:
                this.mzx.append((char) 8542);
                return;
            case 122:
                this.mzx.append((char) 9474);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.mzx.append((char) 9488);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                this.mzx.append((char) 9492);
                return;
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                this.mzx.append((char) 9472);
                return;
            case Opcodes.IAND /* 126 */:
                this.mzx.append((char) 9496);
                return;
            case 127:
                this.mzx.append((char) 9484);
                return;
            default:
                Log.w("Cea708Decoder", "Invalid G2 character: " + i);
                return;
        }
    }

    private void Lv(int i) {
        if (i == 160) {
            this.mzx.append((char) 13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i);
        this.mzx.append('_');
    }

    private void dxZ() {
        this.mzx.a(this.mzu.readBits(4), this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.dvl(), this.mzu.dvl(), this.mzu.readBits(3), this.mzu.readBits(3));
    }

    private void dya() {
        int K = a.K(this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2));
        int K2 = a.K(this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2));
        this.mzu.JU(2);
        this.mzx.ag(K, K2, a.ah(this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2)));
    }

    private void dyb() {
        this.mzu.JU(4);
        int readBits = this.mzu.readBits(4);
        this.mzu.JU(2);
        this.mzx.dS(readBits, this.mzu.readBits(6));
    }

    private void dyc() {
        int K = a.K(this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2));
        int readBits = this.mzu.readBits(2);
        int ah = a.ah(this.mzu.readBits(2), this.mzu.readBits(2), this.mzu.readBits(2));
        if (this.mzu.dvl()) {
            readBits |= 4;
        }
        boolean dvl = this.mzu.dvl();
        int readBits2 = this.mzu.readBits(2);
        int readBits3 = this.mzu.readBits(2);
        int readBits4 = this.mzu.readBits(2);
        this.mzu.JU(8);
        this.mzx.a(K, ah, dvl, readBits, readBits2, readBits3, readBits4);
    }

    private void Lw(int i) {
        a aVar = this.mzw[i];
        this.mzu.JU(2);
        boolean dvl = this.mzu.dvl();
        boolean dvl2 = this.mzu.dvl();
        boolean dvl3 = this.mzu.dvl();
        int readBits = this.mzu.readBits(3);
        boolean dvl4 = this.mzu.dvl();
        int readBits2 = this.mzu.readBits(7);
        int readBits3 = this.mzu.readBits(8);
        int readBits4 = this.mzu.readBits(4);
        int readBits5 = this.mzu.readBits(4);
        this.mzu.JU(2);
        int readBits6 = this.mzu.readBits(6);
        this.mzu.JU(2);
        aVar.a(dvl, dvl2, dvl3, readBits, dvl4, readBits2, readBits3, readBits5, readBits6, readBits4, this.mzu.readBits(3), this.mzu.readBits(3));
    }

    private List<com.google.android.exoplayer2.text.b> dxP() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.mzw[i].isEmpty() && this.mzw[i].isVisible()) {
                arrayList.add(this.mzw[i].dye());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void dxQ() {
        for (int i = 0; i < 8; i++) {
            this.mzw[i].reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        int currentIndex = 0;
        public final int mzX;
        public final byte[] mzY;
        public final int packetSize;

        public b(int i, int i2) {
            this.mzX = i;
            this.packetSize = i2;
            this.mzY = new byte[(i2 * 2) - 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public static final int mzA = K(2, 2, 2, 0);
        public static final int mzB = K(0, 0, 0, 0);
        public static final int mzC = K(0, 0, 0, 3);
        private static final int[] mzD = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] mzE = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] mzF = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] mzG = {false, false, false, true, true, true, false};
        private static final int[] mzH = {mzB, mzC, mzB, mzB, mzC, mzB, mzB};
        private static final int[] mzI = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] mzJ = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] mzK = {mzB, mzB, mzB, mzB, mzB, mzC, mzC};
        private int backgroundColor;
        private int foregroundColor;
        private int ht;
        private boolean mzL;
        private boolean mzM;
        private int mzN;
        private int mzO;
        private int mzP;
        private boolean mzQ;
        private int mzR;
        private int mzS;
        private int mzT;
        private int mzU;
        private int mzV;
        private int mzW;
        private final List<SpannableString> mzn = new LinkedList();
        private final SpannableStringBuilder mzo = new SpannableStringBuilder();
        private int mzr;
        private int priority;
        private int row;
        private int rowCount;
        private boolean visible;

        public a() {
            reset();
        }

        public boolean isEmpty() {
            return !dyd() || (this.mzn.isEmpty() && this.mzo.length() == 0);
        }

        public void reset() {
            clear();
            this.mzL = false;
            this.visible = false;
            this.priority = 4;
            this.mzM = false;
            this.mzN = 0;
            this.mzO = 0;
            this.mzP = 0;
            this.rowCount = 15;
            this.mzQ = true;
            this.ht = 0;
            this.mzR = 0;
            this.mzS = 0;
            this.mzT = mzB;
            this.foregroundColor = mzA;
            this.backgroundColor = mzB;
        }

        public void clear() {
            this.mzn.clear();
            this.mzo.clear();
            this.mzU = -1;
            this.mzr = -1;
            this.mzV = -1;
            this.mzW = -1;
            this.row = 0;
        }

        public boolean dyd() {
            return this.mzL;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mzL = true;
            this.visible = z;
            this.mzQ = z2;
            this.priority = i;
            this.mzM = z4;
            this.mzN = i2;
            this.mzO = i3;
            this.mzP = i6;
            if (this.rowCount != i4 + 1) {
                this.rowCount = i4 + 1;
                while (true) {
                    if ((!z2 || this.mzn.size() < this.rowCount) && this.mzn.size() < 15) {
                        break;
                    }
                    this.mzn.remove(0);
                }
            }
            if (i7 != 0 && this.mzR != i7) {
                this.mzR = i7;
                int i9 = i7 - 1;
                a(mzH[i9], mzC, mzG[i9], 0, mzE[i9], mzF[i9], mzD[i9]);
            }
            if (i8 != 0 && this.mzS != i8) {
                this.mzS = i8;
                int i10 = i8 - 1;
                a(0, 1, 1, false, false, mzJ[i10], mzI[i10]);
                ag(mzA, mzK[i10], mzB);
            }
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.mzT = i;
            this.ht = i6;
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.mzU != -1) {
                if (!z) {
                    this.mzo.setSpan(new StyleSpan(2), this.mzU, this.mzo.length(), 33);
                    this.mzU = -1;
                }
            } else if (z) {
                this.mzU = this.mzo.length();
            }
            if (this.mzr != -1) {
                if (!z2) {
                    this.mzo.setSpan(new UnderlineSpan(), this.mzr, this.mzo.length(), 33);
                    this.mzr = -1;
                }
            } else if (z2) {
                this.mzr = this.mzo.length();
            }
        }

        public void ag(int i, int i2, int i3) {
            if (this.mzV != -1 && this.foregroundColor != i) {
                this.mzo.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzV, this.mzo.length(), 33);
            }
            if (i != mzA) {
                this.mzV = this.mzo.length();
                this.foregroundColor = i;
            }
            if (this.mzW != -1 && this.backgroundColor != i2) {
                this.mzo.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzW, this.mzo.length(), 33);
            }
            if (i2 != mzB) {
                this.mzW = this.mzo.length();
                this.backgroundColor = i2;
            }
        }

        public void dS(int i, int i2) {
            if (this.row != i) {
                append('\n');
            }
            this.row = i;
        }

        public void dxT() {
            int length = this.mzo.length();
            if (length > 0) {
                this.mzo.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == '\n') {
                this.mzn.add(dxV());
                this.mzo.clear();
                if (this.mzU != -1) {
                    this.mzU = 0;
                }
                if (this.mzr != -1) {
                    this.mzr = 0;
                }
                if (this.mzV != -1) {
                    this.mzV = 0;
                }
                if (this.mzW != -1) {
                    this.mzW = 0;
                }
                while (true) {
                    if ((this.mzQ && this.mzn.size() >= this.rowCount) || this.mzn.size() >= 15) {
                        this.mzn.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.mzo.append(c);
            }
        }

        public SpannableString dxV() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mzo);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.mzU != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.mzU, length, 33);
                }
                if (this.mzr != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.mzr, length, 33);
                }
                if (this.mzV != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.mzV, length, 33);
                }
                if (this.mzW != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.mzW, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public com.google.android.exoplayer2.text.a.b dye() {
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.mzn.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.mzn.get(i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dxV());
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
            if (this.mzM) {
                f = this.mzO / 99.0f;
                f2 = this.mzN / 99.0f;
            } else {
                f = this.mzO / 209.0f;
                f2 = this.mzN / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            if (this.mzP % 3 == 0) {
                i = 0;
            } else {
                i = this.mzP % 3 == 1 ? 1 : 2;
            }
            if (this.mzP / 3 == 0) {
                i2 = 0;
            } else {
                i2 = this.mzP / 3 == 1 ? 1 : 2;
            }
            return new com.google.android.exoplayer2.text.a.b(spannableStringBuilder, alignment, f4, 0, i, f3, i2, Float.MIN_VALUE, this.mzT != mzB, this.mzT, this.priority);
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
