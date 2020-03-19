package com.google.android.exoplayer2.extractor.a;

import android.util.Log;
import android.util.SparseArray;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class d implements com.google.android.exoplayer2.extractor.e {
    private long mbx;
    private final l mgD;
    private final l mgE;
    private final f mgI;
    private final com.google.android.exoplayer2.extractor.a.b mgU;
    private final SparseArray<b> mgV;
    private final boolean mgW;
    private final l mgX;
    private final l mgY;
    private final l mgZ;
    private final l mgq;
    private g mgu;
    private int mhA;
    private int mhB;
    private int mhC;
    private boolean mhD;
    private boolean mhE;
    private boolean mhF;
    private boolean mhG;
    private byte mhH;
    private int mhI;
    private int mhJ;
    private int mhK;
    private boolean mhL;
    private boolean mhM;
    private final l mha;
    private final l mhb;
    private final l mhc;
    private ByteBuffer mhd;
    private long mhe;
    private long mhf;
    private long mhg;
    private long mhh;
    private b mhi;
    private boolean mhj;
    private int mhk;
    private long mhl;
    private boolean mhm;
    private long mhn;
    private long mho;
    private long mhp;
    private com.google.android.exoplayer2.util.g mhq;
    private com.google.android.exoplayer2.util.g mhr;
    private boolean mhs;
    private int mht;
    private long mhu;
    private long mhv;
    private int mhw;
    private int mhx;
    private int[] mhy;
    private int mhz;
    public static final h mgo = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] mgO = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] mgP = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] mgQ = v.QB("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] mgR = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] mgS = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID mgT = new UUID(72057594037932032L, -9223371306706625679L);

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.mhf = -1L;
        this.mhg = -9223372036854775807L;
        this.mhh = -9223372036854775807L;
        this.mbx = -9223372036854775807L;
        this.mhn = -1L;
        this.mho = -1L;
        this.mhp = -9223372036854775807L;
        this.mgU = bVar;
        this.mgU.a(new a());
        this.mgW = (i & 1) == 0;
        this.mgI = new f();
        this.mgV = new SparseArray<>();
        this.mgq = new l(4);
        this.mgX = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.mgY = new l(4);
        this.mgD = new l(j.mIW);
        this.mgE = new l(4);
        this.mgZ = new l();
        this.mha = new l();
        this.mhb = new l(8);
        this.mhc = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mgu = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mhp = -9223372036854775807L;
        this.mht = 0;
        this.mgU.reset();
        this.mgI.reset();
        dvu();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mhL = false;
        boolean z = true;
        while (z && !this.mhL) {
            z = this.mgU.g(fVar);
            if (z && a(kVar, fVar.getPosition())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    int JJ(int i) {
        switch (i) {
            case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
            case 136:
            case 155:
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.ARETURN /* 176 */:
            case 179:
            case 186:
            case 215:
            case 231:
            case BaseActivity.DIALOG_PROMPT /* 241 */:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case Opcodes.NEW /* 187 */:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case Opcodes.IF_ICMPGT /* 163 */:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case Opcodes.PUTFIELD /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    boolean JK(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void k(int i, long j, long j2) throws ParserException {
        switch (i) {
            case 160:
                this.mhM = false;
                return;
            case 174:
                this.mhi = new b();
                return;
            case Opcodes.NEW /* 187 */:
                this.mhs = false;
                return;
            case 19899:
                this.mhk = -1;
                this.mhl = -1L;
                return;
            case 20533:
                this.mhi.mhQ = true;
                return;
            case 21968:
                this.mhi.mhX = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.mhf != -1 && this.mhf != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.mhf = j;
                this.mhe = j2;
                return;
            case 475249515:
                this.mhq = new com.google.android.exoplayer2.util.g();
                this.mhr = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.mhj) {
                    if (this.mgW && this.mhn != -1) {
                        this.mhm = true;
                        return;
                    }
                    this.mgu.a(new l.a(this.mbx));
                    this.mhj = true;
                    return;
                }
                return;
        }
    }

    void JL(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.mht == 2) {
                    if (!this.mhM) {
                        this.mhB |= 1;
                    }
                    a(this.mgV.get(this.mhz), this.mhu);
                    this.mht = 0;
                    return;
                }
                return;
            case 174:
                if (Pt(this.mhi.mhO)) {
                    this.mhi.a(this.mgu, this.mhi.number);
                    this.mgV.put(this.mhi.number, this.mhi);
                }
                this.mhi = null;
                return;
            case 19899:
                if (this.mhk == -1 || this.mhl == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.mhk == 475249515) {
                    this.mhn = this.mhl;
                    return;
                }
                return;
            case 25152:
                if (this.mhi.mhQ) {
                    if (this.mhi.mhS == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.mhi.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lZW, "video/webm", this.mhi.mhS.mgj));
                    return;
                }
                return;
            case 28032:
                if (this.mhi.mhQ && this.mhi.mhR != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.mhg == -9223372036854775807L) {
                    this.mhg = TimeUtils.NANOS_PER_MS;
                }
                if (this.mhh != -9223372036854775807L) {
                    this.mbx = fN(this.mhh);
                    return;
                }
                return;
            case 374648427:
                if (this.mgV.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.mgu.dvs();
                return;
            case 475249515:
                if (!this.mhj) {
                    this.mgu.a(dvv());
                    this.mhj = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    void C(int i, long j) throws ParserException {
        switch (i) {
            case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                this.mhi.type = (int) j;
                return;
            case 136:
                this.mhi.mip = j == 1;
                return;
            case 155:
                this.mhv = fN(j);
                return;
            case Opcodes.IF_ICMPEQ /* 159 */:
                this.mhi.channelCount = (int) j;
                return;
            case Opcodes.ARETURN /* 176 */:
                this.mhi.width = (int) j;
                return;
            case 179:
                this.mhq.gH(fN(j));
                return;
            case 186:
                this.mhi.height = (int) j;
                return;
            case 215:
                this.mhi.number = (int) j;
                return;
            case 231:
                this.mhp = fN(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.mhs) {
                    this.mhr.gH(j);
                    this.mhs = true;
                    return;
                }
                return;
            case 251:
                this.mhM = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new ParserException("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new ParserException("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new ParserException("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 20529:
                if (j != 0) {
                    throw new ParserException("ContentEncodingOrder " + j + " not supported");
                }
                return;
            case 20530:
                if (j != 1) {
                    throw new ParserException("ContentEncodingScope " + j + " not supported");
                }
                return;
            case 21420:
                this.mhl = this.mhf + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.mhi.stereoMode = 0;
                        return;
                    case 1:
                        this.mhi.stereoMode = 2;
                        return;
                    case 3:
                        this.mhi.stereoMode = 1;
                        return;
                    case 15:
                        this.mhi.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.mhi.mhU = (int) j;
                return;
            case 21682:
                this.mhi.mhW = (int) j;
                return;
            case 21690:
                this.mhi.mhV = (int) j;
                return;
            case 21930:
                this.mhi.miq = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.mhi.colorRange = 2;
                        return;
                    case 2:
                        this.mhi.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.mhi.colorTransfer = 3;
                        return;
                    case 16:
                        this.mhi.colorTransfer = 6;
                        return;
                    case 18:
                        this.mhi.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.mhi.mhX = true;
                switch ((int) j) {
                    case 1:
                        this.mhi.colorSpace = 1;
                        return;
                    case 2:
                    case 3:
                    case 8:
                    default:
                        return;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.mhi.colorSpace = 2;
                        return;
                    case 9:
                        this.mhi.colorSpace = 6;
                        return;
                }
            case 21948:
                this.mhi.mhY = (int) j;
                return;
            case 21949:
                this.mhi.mhZ = (int) j;
                return;
            case 22186:
                this.mhi.mim = j;
                return;
            case 22203:
                this.mhi.mio = j;
                return;
            case 25188:
                this.mhi.mil = (int) j;
                return;
            case 2352003:
                this.mhi.mhP = (int) j;
                return;
            case 2807729:
                this.mhg = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case Opcodes.PUTFIELD /* 181 */:
                this.mhi.sampleRate = (int) d;
                return;
            case 17545:
                this.mhh = (long) d;
                return;
            case 21969:
                this.mhi.mia = (float) d;
                return;
            case 21970:
                this.mhi.mib = (float) d;
                return;
            case 21971:
                this.mhi.mic = (float) d;
                return;
            case 21972:
                this.mhi.mie = (float) d;
                return;
            case 21973:
                this.mhi.mif = (float) d;
                return;
            case 21974:
                this.mhi.mig = (float) d;
                return;
            case 21975:
                this.mhi.mih = (float) d;
                return;
            case 21976:
                this.mhi.mii = (float) d;
                return;
            case 21977:
                this.mhi.mij = (float) d;
                return;
            case 21978:
                this.mhi.mik = (float) d;
                return;
            default:
                return;
        }
    }

    void bh(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.mhi.mhO = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.mhi.language = str;
                return;
            default:
                return;
        }
    }

    void a(int i, int i2, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i3;
        switch (i) {
            case 161:
            case Opcodes.IF_ICMPGT /* 163 */:
                if (this.mht == 0) {
                    this.mhz = (int) this.mgI.a(fVar, false, true, 8);
                    this.mhA = this.mgI.dvz();
                    this.mhv = -9223372036854775807L;
                    this.mht = 1;
                    this.mgq.reset();
                }
                b bVar = this.mgV.get(this.mhz);
                if (bVar == null) {
                    fVar.JB(i2 - this.mhA);
                    this.mht = 0;
                    return;
                }
                if (this.mht == 1) {
                    d(fVar, 3);
                    int i4 = (this.mgq.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.mhx = 1;
                        this.mhy = c(this.mhy, 1);
                        this.mhy[0] = (i2 - this.mhA) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.mhx = (this.mgq.data[3] & 255) + 1;
                        this.mhy = c(this.mhy, this.mhx);
                        if (i4 == 2) {
                            Arrays.fill(this.mhy, 0, this.mhx, ((i2 - this.mhA) - 4) / this.mhx);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.mhx - 1; i7++) {
                                this.mhy[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.mgq.data[i6 - 1] & 255;
                                    int[] iArr = this.mhy;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.mhy[i7];
                            }
                            this.mhy[this.mhx - 1] = ((i2 - this.mhA) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.mhx - 1; i10++) {
                                this.mhy[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.mgq.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.mgq.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.mgq.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.mgq.data[i15] & 255) | (j << 8);
                                            }
                                            if (i10 > 0) {
                                                j -= (1 << ((i12 * 7) + 6)) - 1;
                                            }
                                        }
                                    }
                                }
                                if (j < -2147483648L || j > 2147483647L) {
                                    throw new ParserException("EBML lacing sample size out of range.");
                                }
                                int i16 = (int) j;
                                int[] iArr2 = this.mhy;
                                if (i10 != 0) {
                                    i16 += this.mhy[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.mhy[i10];
                            }
                            this.mhy[this.mhx - 1] = ((i2 - this.mhA) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.mhu = this.mhp + fN((this.mgq.data[0] << 8) | (this.mgq.data[1] & 255));
                    this.mhB = ((this.mgq.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.mgq.data[2] & 128) == 128) ? 1 : 0);
                    this.mht = 2;
                    this.mhw = 0;
                }
                if (i == 163) {
                    while (this.mhw < this.mhx) {
                        a(fVar, bVar, this.mhy[this.mhw]);
                        a(bVar, this.mhu + ((this.mhw * bVar.mhP) / 1000));
                        this.mhw++;
                    }
                    this.mht = 0;
                    return;
                }
                a(fVar, bVar, this.mhy[0]);
                return;
            case 16981:
                this.mhi.mhR = new byte[i2];
                fVar.readFully(this.mhi.mhR, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.mhi.mhS = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.mgY.data, (byte) 0);
                fVar.readFully(this.mgY.data, 4 - i2, i2);
                this.mgY.setPosition(0);
                this.mhk = (int) this.mgY.readUnsignedInt();
                return;
            case 25506:
                this.mhi.mhT = new byte[i2];
                fVar.readFully(this.mhi.mhT, 0, i2);
                return;
            case 30322:
                this.mhi.projectionData = new byte[i2];
                fVar.readFully(this.mhi.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mhO)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, mgP);
        } else if ("S_TEXT/ASS".equals(bVar.mhO)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, mgS);
        }
        bVar.mgC.a(j, this.mhB, this.mhK, 0, bVar.mhS);
        this.mhL = true;
        dvu();
    }

    private void dvu() {
        this.mhC = 0;
        this.mhK = 0;
        this.mhJ = 0;
        this.mhD = false;
        this.mhE = false;
        this.mhG = false;
        this.mhI = 0;
        this.mhH = (byte) 0;
        this.mhF = false;
        this.mgZ.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.mgq.dzS() < i) {
            if (this.mgq.capacity() < i) {
                this.mgq.I(Arrays.copyOf(this.mgq.data, Math.max(this.mgq.data.length * 2, i)), this.mgq.dzS());
            }
            fVar.readFully(this.mgq.data, this.mgq.dzS(), i - this.mgq.dzS());
            this.mgq.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mhO)) {
            a(fVar, mgO, i);
        } else if ("S_TEXT/ASS".equals(bVar.mhO)) {
            a(fVar, mgR, i);
        } else {
            m mVar = bVar.mgC;
            if (!this.mhD) {
                if (bVar.mhQ) {
                    this.mhB &= -1073741825;
                    if (!this.mhE) {
                        fVar.readFully(this.mgq.data, 0, 1);
                        this.mhC++;
                        if ((this.mgq.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mhH = this.mgq.data[0];
                        this.mhE = true;
                    }
                    if ((this.mhH & 1) == 1) {
                        boolean z = (this.mhH & 2) == 2;
                        this.mhB |= 1073741824;
                        if (!this.mhF) {
                            fVar.readFully(this.mhb.data, 0, 8);
                            this.mhC += 8;
                            this.mhF = true;
                            this.mgq.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.mgq.setPosition(0);
                            mVar.a(this.mgq, 1);
                            this.mhK++;
                            this.mhb.setPosition(0);
                            mVar.a(this.mhb, 8);
                            this.mhK += 8;
                        }
                        if (z) {
                            if (!this.mhG) {
                                fVar.readFully(this.mgq.data, 0, 1);
                                this.mhC++;
                                this.mgq.setPosition(0);
                                this.mhI = this.mgq.readUnsignedByte();
                                this.mhG = true;
                            }
                            int i2 = this.mhI * 4;
                            this.mgq.reset(i2);
                            fVar.readFully(this.mgq.data, 0, i2);
                            this.mhC = i2 + this.mhC;
                            short s = (short) ((this.mhI / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.mhd == null || this.mhd.capacity() < i3) {
                                this.mhd = ByteBuffer.allocate(i3);
                            }
                            this.mhd.position(0);
                            this.mhd.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mhI) {
                                int dAc = this.mgq.dAc();
                                if (i4 % 2 == 0) {
                                    this.mhd.putShort((short) (dAc - i5));
                                } else {
                                    this.mhd.putInt(dAc - i5);
                                }
                                i4++;
                                i5 = dAc;
                            }
                            int i6 = (i - this.mhC) - i5;
                            if (this.mhI % 2 == 1) {
                                this.mhd.putInt(i6);
                            } else {
                                this.mhd.putShort((short) i6);
                                this.mhd.putInt(0);
                            }
                            this.mhc.I(this.mhd.array(), i3);
                            mVar.a(this.mhc, i3);
                            this.mhK += i3;
                        }
                    }
                } else if (bVar.mhR != null) {
                    this.mgZ.I(bVar.mhR, bVar.mhR.length);
                }
                this.mhD = true;
            }
            int dzS = this.mgZ.dzS() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mhO) || "V_MPEGH/ISO/HEVC".equals(bVar.mhO)) {
                byte[] bArr = this.mgE.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.mgF;
                int i8 = 4 - bVar.mgF;
                while (this.mhC < dzS) {
                    if (this.mhJ == 0) {
                        a(fVar, bArr, i8, i7);
                        this.mgE.setPosition(0);
                        this.mhJ = this.mgE.dAc();
                        this.mgD.setPosition(0);
                        mVar.a(this.mgD, 4);
                        this.mhK += 4;
                    } else {
                        this.mhJ -= a(fVar, mVar, this.mhJ);
                    }
                }
            } else {
                while (this.mhC < dzS) {
                    a(fVar, mVar, dzS - this.mhC);
                }
            }
            if ("A_VORBIS".equals(bVar.mhO)) {
                this.mgX.setPosition(0);
                mVar.a(this.mgX, 4);
                this.mhK += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.mha.capacity() < length) {
            this.mha.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.mha.data, 0, bArr.length);
        }
        fVar.readFully(this.mha.data, bArr.length, i);
        this.mha.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.mha.data, this.mhv, str, i, j, bArr);
        bVar.mgC.a(this.mha, this.mha.dzS());
        this.mhK += this.mha.dzS();
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] QB;
        if (j == -9223372036854775807L) {
            QB = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - ((i2 * 3600) * TimeUtils.NANOS_PER_MS);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * TimeUtils.NANOS_PER_MS);
            int i4 = (int) (j4 / TimeUtils.NANOS_PER_MS);
            QB = v.QB(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * TimeUtils.NANOS_PER_MS)) / j2))));
        }
        System.arraycopy(QB, 0, bArr, i, bArr2.length);
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int min = Math.min(i2, this.mgZ.dzR());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.mgZ.G(bArr, i, min);
        }
        this.mhC += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dzR = this.mgZ.dzR();
        if (dzR > 0) {
            a2 = Math.min(i, dzR);
            mVar.a(this.mgZ, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mhC += a2;
        this.mhK += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l dvv() {
        if (this.mhf == -1 || this.mbx == -9223372036854775807L || this.mhq == null || this.mhq.size() == 0 || this.mhr == null || this.mhr.size() != this.mhq.size()) {
            this.mhq = null;
            this.mhr = null;
            return new l.a(this.mbx);
        }
        int size = this.mhq.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.mhq.LZ(i);
            jArr[i] = this.mhf + this.mhr.LZ(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.mhf + this.mhe) - jArr[size - 1]);
        jArr2[size - 1] = this.mbx - jArr3[size - 1];
        this.mhq = null;
        this.mhr = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.mhm) {
            this.mho = j;
            kVar.fOW = this.mhn;
            this.mhm = false;
            return true;
        } else if (!this.mhj || this.mho == -1) {
            return false;
        } else {
            kVar.fOW = this.mho;
            this.mho = -1L;
            return true;
        }
    }

    private long fN(long j) throws ParserException {
        if (this.mhg == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.i(j, this.mhg, 1000L);
    }

    private static boolean Pt(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] c(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }

    /* loaded from: classes6.dex */
    private final class a implements c {
        private a() {
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public int JJ(int i) {
            return d.this.JJ(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public boolean JK(int i) {
            return d.this.JK(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void k(int i, long j, long j2) throws ParserException {
            d.this.k(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void JL(int i) throws ParserException {
            d.this.JL(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void C(int i, long j) throws ParserException {
            d.this.C(i, j);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void d(int i, double d) throws ParserException {
            d.this.d(i, d);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void bh(int i, String str) throws ParserException {
            d.this.bh(i, str);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void a(int i, int i2, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            d.this.a(i, i2, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        public int channelCount;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public DrmInitData drmInitData;
        public int height;
        private String language;
        public m mgC;
        public int mgF;
        public String mhO;
        public int mhP;
        public boolean mhQ;
        public byte[] mhR;
        public m.a mhS;
        public byte[] mhT;
        public int mhU;
        public int mhV;
        public int mhW;
        public boolean mhX;
        public int mhY;
        public int mhZ;
        public float mia;
        public float mib;
        public float mic;
        public float mie;
        public float mif;
        public float mig;
        public float mih;
        public float mii;
        public float mij;
        public float mik;
        public int mil;
        public long mim;
        public long mio;
        public boolean mip;
        public boolean miq;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mhU = -1;
            this.mhV = -1;
            this.mhW = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mhX = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mhY = 1000;
            this.mhZ = 200;
            this.mia = -1.0f;
            this.mib = -1.0f;
            this.mic = -1.0f;
            this.mie = -1.0f;
            this.mif = -1.0f;
            this.mig = -1.0f;
            this.mih = -1.0f;
            this.mii = -1.0f;
            this.mij = -1.0f;
            this.mik = -1.0f;
            this.channelCount = 1;
            this.mil = -1;
            this.sampleRate = 8000;
            this.mim = 0L;
            this.mio = 0L;
            this.miq = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mhO;
            char c = 65535;
            switch (str2.hashCode()) {
                case -2095576542:
                    if (str2.equals("V_MPEG4/ISO/AP")) {
                        c = 5;
                        break;
                    }
                    break;
                case -2095575984:
                    if (str2.equals("V_MPEG4/ISO/SP")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str2.equals("A_MS/ACM")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str2.equals("A_TRUEHD")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str2.equals("A_VORBIS")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1482641358:
                    if (str2.equals("A_MPEG/L2")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1482641357:
                    if (str2.equals("A_MPEG/L3")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str2.equals("V_MS/VFW/FOURCC")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -933872740:
                    if (str2.equals("S_DVBSUB")) {
                        c = 28;
                        break;
                    }
                    break;
                case -538363189:
                    if (str2.equals("V_MPEG4/ISO/ASP")) {
                        c = 4;
                        break;
                    }
                    break;
                case -538363109:
                    if (str2.equals("V_MPEG4/ISO/AVC")) {
                        c = 6;
                        break;
                    }
                    break;
                case -425012669:
                    if (str2.equals("S_VOBSUB")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -356037306:
                    if (str2.equals("A_DTS/LOSSLESS")) {
                        c = 20;
                        break;
                    }
                    break;
                case 62923557:
                    if (str2.equals("A_AAC")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 62923603:
                    if (str2.equals("A_AC3")) {
                        c = 15;
                        break;
                    }
                    break;
                case 62927045:
                    if (str2.equals("A_DTS")) {
                        c = 18;
                        break;
                    }
                    break;
                case 82338133:
                    if (str2.equals("V_VP8")) {
                        c = 0;
                        break;
                    }
                    break;
                case 82338134:
                    if (str2.equals("V_VP9")) {
                        c = 1;
                        break;
                    }
                    break;
                case 99146302:
                    if (str2.equals("S_HDMV/PGS")) {
                        c = 27;
                        break;
                    }
                    break;
                case 444813526:
                    if (str2.equals("V_THEORA")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 542569478:
                    if (str2.equals("A_DTS/EXPRESS")) {
                        c = 19;
                        break;
                    }
                    break;
                case 725957860:
                    if (str2.equals("A_PCM/INT/LIT")) {
                        c = 23;
                        break;
                    }
                    break;
                case 738597099:
                    if (str2.equals("S_TEXT/ASS")) {
                        c = 25;
                        break;
                    }
                    break;
                case 855502857:
                    if (str2.equals("V_MPEGH/ISO/HEVC")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str2.equals("S_TEXT/UTF8")) {
                        c = 24;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str2.equals("V_MPEG2")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str2.equals("A_EAC3")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str2.equals("A_FLAC")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str2.equals("A_OPUS")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = "video/x-vnd.on2.vp8";
                    break;
                case 1:
                    str = "video/x-vnd.on2.vp9";
                    break;
                case 2:
                    str = "video/mpeg2";
                    break;
                case 3:
                case 4:
                case 5:
                    str = "video/mp4v-es";
                    list = this.mhT == null ? null : Collections.singletonList(this.mhT);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mhT));
                    list = ag.initializationData;
                    this.mgF = ag.mgF;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mhT));
                    list = ai.initializationData;
                    this.mgF = ai.mgF;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mhT));
                    if (list != null) {
                        str = "video/wvc1";
                        break;
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                        str = "video/x-unknown";
                        break;
                    }
                case '\t':
                    str = "video/x-unknown";
                    break;
                case '\n':
                    str = "audio/vorbis";
                    i3 = 8192;
                    list = at(this.mhT);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mhT);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mim).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mio).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mhT);
                    break;
                case '\r':
                    str = "audio/mpeg-L2";
                    i3 = 4096;
                    break;
                case 14:
                    str = "audio/mpeg";
                    i3 = 4096;
                    break;
                case 15:
                    str = "audio/ac3";
                    break;
                case 16:
                    str = "audio/eac3";
                    break;
                case 17:
                    str = "audio/true-hd";
                    break;
                case 18:
                case 19:
                    str = "audio/vnd.dts";
                    break;
                case 20:
                    str = "audio/vnd.dts.hd";
                    break;
                case 21:
                    str = "audio/flac";
                    list = Collections.singletonList(this.mhT);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mhT))) {
                        i4 = v.Mf(this.mil);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mil + ". Setting mimeType to audio/x-unknown");
                            break;
                        }
                    } else {
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                        break;
                    }
                    break;
                case 23:
                    str = "audio/raw";
                    i4 = v.Mf(this.mil);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mil + ". Setting mimeType to audio/x-unknown");
                        break;
                    }
                    break;
                case 24:
                    str = "application/x-subrip";
                    break;
                case 25:
                    str = "text/x-ssa";
                    break;
                case 26:
                    str = "application/vobsub";
                    list = Collections.singletonList(this.mhT);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mhT[0], this.mhT[1], this.mhT[2], this.mhT[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.miq ? 1 : 0) | (this.mip ? 2 : 0);
            if (i.Qp(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OR(str)) {
                if (this.mhW == 0) {
                    this.mhU = this.mhU == -1 ? this.width : this.mhU;
                    this.mhV = this.mhV == -1 ? this.height : this.mhV;
                }
                float f = -1.0f;
                if (this.mhU != -1 && this.mhV != -1) {
                    f = (this.height * this.mhU) / (this.width * this.mhV);
                }
                ColorInfo colorInfo = null;
                if (this.mhX) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dvy());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.mgQ);
                arrayList.add(this.mhT);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.mgC = gVar.dL(this.number, i2);
            this.mgC.h(a);
        }

        private byte[] dvy() {
            if (this.mia == -1.0f || this.mib == -1.0f || this.mic == -1.0f || this.mie == -1.0f || this.mif == -1.0f || this.mig == -1.0f || this.mih == -1.0f || this.mii == -1.0f || this.mij == -1.0f || this.mik == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mia * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mib * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mic * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mie * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mif * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mig * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mih * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mii * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mij + 0.5f));
            wrap.putShort((short) (this.mik + 0.5f));
            wrap.putShort((short) this.mhY);
            wrap.putShort((short) this.mhZ);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dzX() != 826496599) {
                    return null;
                }
                byte[] bArr = lVar.data;
                for (int position = lVar.getPosition() + 20; position < bArr.length - 4; position++) {
                    if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                    }
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> at(byte[] bArr) throws ParserException {
            int i = 0;
            try {
                if (bArr[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i2 = 0;
                int i3 = 1;
                while (bArr[i3] == -1) {
                    i3++;
                    i2 += 255;
                }
                int i4 = i3 + 1;
                int i5 = i2 + bArr[i3];
                while (bArr[i4] == -1) {
                    i += 255;
                    i4++;
                }
                int i6 = i4 + 1;
                int i7 = i + bArr[i4];
                if (bArr[i6] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, i6, bArr2, 0, i5);
                int i8 = i5 + i6;
                if (bArr[i8] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i9 = i7 + i8;
                if (bArr[i9] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i9];
                System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean k(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                int dzU = lVar.dzU();
                if (dzU == 1) {
                    return true;
                }
                if (dzU == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.mgT.getMostSignificantBits()) {
                        if (lVar.readLong() == d.mgT.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }
}
