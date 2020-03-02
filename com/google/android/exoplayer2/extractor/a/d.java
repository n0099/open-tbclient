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
    private long lZD;
    private g meD;
    private final l meM;
    private final l meN;
    private final f meR;
    private final l mez;
    private com.google.android.exoplayer2.util.g mfA;
    private boolean mfB;
    private int mfC;
    private long mfD;
    private long mfE;
    private int mfF;
    private int mfG;
    private int[] mfH;
    private int mfI;
    private int mfJ;
    private int mfK;
    private int mfL;
    private boolean mfM;
    private boolean mfN;
    private boolean mfO;
    private boolean mfP;
    private byte mfQ;
    private int mfR;
    private int mfS;
    private int mfT;
    private boolean mfU;
    private boolean mfV;
    private final com.google.android.exoplayer2.extractor.a.b mfd;
    private final SparseArray<b> mfe;
    private final boolean mff;
    private final l mfg;
    private final l mfh;
    private final l mfi;
    private final l mfj;
    private final l mfk;
    private final l mfl;
    private ByteBuffer mfm;
    private long mfn;
    private long mfo;
    private long mfp;
    private long mfq;
    private b mfr;
    private boolean mfs;
    private int mft;
    private long mfu;
    private boolean mfv;
    private long mfw;
    private long mfx;
    private long mfy;
    private com.google.android.exoplayer2.util.g mfz;
    public static final h mex = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duT() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] meX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] meY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] meZ = v.QA("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] mfa = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] mfb = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID mfc = new UUID(72057594037932032L, -9223371306706625679L);

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.mfo = -1L;
        this.mfp = -9223372036854775807L;
        this.mfq = -9223372036854775807L;
        this.lZD = -9223372036854775807L;
        this.mfw = -1L;
        this.mfx = -1L;
        this.mfy = -9223372036854775807L;
        this.mfd = bVar;
        this.mfd.a(new a());
        this.mff = (i & 1) == 0;
        this.meR = new f();
        this.mfe = new SparseArray<>();
        this.mez = new l(4);
        this.mfg = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.mfh = new l(4);
        this.meM = new l(j.mHb);
        this.meN = new l(4);
        this.mfi = new l();
        this.mfj = new l();
        this.mfk = new l(8);
        this.mfl = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meD = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mfy = -9223372036854775807L;
        this.mfC = 0;
        this.mfd.reset();
        this.meR.reset();
        duW();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mfU = false;
        boolean z = true;
        while (z && !this.mfU) {
            z = this.mfd.g(fVar);
            if (z && a(kVar, fVar.getPosition())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    int JD(int i) {
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

    boolean JE(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void k(int i, long j, long j2) throws ParserException {
        switch (i) {
            case 160:
                this.mfV = false;
                return;
            case 174:
                this.mfr = new b();
                return;
            case Opcodes.NEW /* 187 */:
                this.mfB = false;
                return;
            case 19899:
                this.mft = -1;
                this.mfu = -1L;
                return;
            case 20533:
                this.mfr.mfZ = true;
                return;
            case 21968:
                this.mfr.mgg = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.mfo != -1 && this.mfo != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.mfo = j;
                this.mfn = j2;
                return;
            case 475249515:
                this.mfz = new com.google.android.exoplayer2.util.g();
                this.mfA = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.mfs) {
                    if (this.mff && this.mfw != -1) {
                        this.mfv = true;
                        return;
                    }
                    this.meD.a(new l.a(this.lZD));
                    this.mfs = true;
                    return;
                }
                return;
        }
    }

    void JF(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.mfC == 2) {
                    if (!this.mfV) {
                        this.mfK |= 1;
                    }
                    a(this.mfe.get(this.mfI), this.mfD);
                    this.mfC = 0;
                    return;
                }
                return;
            case 174:
                if (Ps(this.mfr.mfX)) {
                    this.mfr.a(this.meD, this.mfr.number);
                    this.mfe.put(this.mfr.number, this.mfr);
                }
                this.mfr = null;
                return;
            case 19899:
                if (this.mft == -1 || this.mfu == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.mft == 475249515) {
                    this.mfw = this.mfu;
                    return;
                }
                return;
            case 25152:
                if (this.mfr.mfZ) {
                    if (this.mfr.mgb == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.mfr.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lYf, "video/webm", this.mfr.mgb.mes));
                    return;
                }
                return;
            case 28032:
                if (this.mfr.mfZ && this.mfr.mga != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.mfp == -9223372036854775807L) {
                    this.mfp = TimeUtils.NANOS_PER_MS;
                }
                if (this.mfq != -9223372036854775807L) {
                    this.lZD = fM(this.mfq);
                    return;
                }
                return;
            case 374648427:
                if (this.mfe.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.meD.duU();
                return;
            case 475249515:
                if (!this.mfs) {
                    this.meD.a(duX());
                    this.mfs = true;
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
                this.mfr.type = (int) j;
                return;
            case 136:
                this.mfr.mgw = j == 1;
                return;
            case 155:
                this.mfE = fM(j);
                return;
            case Opcodes.IF_ICMPEQ /* 159 */:
                this.mfr.channelCount = (int) j;
                return;
            case Opcodes.ARETURN /* 176 */:
                this.mfr.width = (int) j;
                return;
            case 179:
                this.mfz.gG(fM(j));
                return;
            case 186:
                this.mfr.height = (int) j;
                return;
            case 215:
                this.mfr.number = (int) j;
                return;
            case 231:
                this.mfy = fM(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.mfB) {
                    this.mfA.gG(j);
                    this.mfB = true;
                    return;
                }
                return;
            case 251:
                this.mfV = true;
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
                this.mfu = this.mfo + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.mfr.stereoMode = 0;
                        return;
                    case 1:
                        this.mfr.stereoMode = 2;
                        return;
                    case 3:
                        this.mfr.stereoMode = 1;
                        return;
                    case 15:
                        this.mfr.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.mfr.mgd = (int) j;
                return;
            case 21682:
                this.mfr.mgf = (int) j;
                return;
            case 21690:
                this.mfr.mge = (int) j;
                return;
            case 21930:
                this.mfr.mgx = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.mfr.colorRange = 2;
                        return;
                    case 2:
                        this.mfr.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.mfr.colorTransfer = 3;
                        return;
                    case 16:
                        this.mfr.colorTransfer = 6;
                        return;
                    case 18:
                        this.mfr.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.mfr.mgg = true;
                switch ((int) j) {
                    case 1:
                        this.mfr.colorSpace = 1;
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
                        this.mfr.colorSpace = 2;
                        return;
                    case 9:
                        this.mfr.colorSpace = 6;
                        return;
                }
            case 21948:
                this.mfr.mgh = (int) j;
                return;
            case 21949:
                this.mfr.mgi = (int) j;
                return;
            case 22186:
                this.mfr.mgu = j;
                return;
            case 22203:
                this.mfr.mgv = j;
                return;
            case 25188:
                this.mfr.mgt = (int) j;
                return;
            case 2352003:
                this.mfr.mfY = (int) j;
                return;
            case 2807729:
                this.mfp = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case Opcodes.PUTFIELD /* 181 */:
                this.mfr.sampleRate = (int) d;
                return;
            case 17545:
                this.mfq = (long) d;
                return;
            case 21969:
                this.mfr.mgj = (float) d;
                return;
            case 21970:
                this.mfr.mgk = (float) d;
                return;
            case 21971:
                this.mfr.mgl = (float) d;
                return;
            case 21972:
                this.mfr.mgm = (float) d;
                return;
            case 21973:
                this.mfr.mgn = (float) d;
                return;
            case 21974:
                this.mfr.mgo = (float) d;
                return;
            case 21975:
                this.mfr.mgp = (float) d;
                return;
            case 21976:
                this.mfr.mgq = (float) d;
                return;
            case 21977:
                this.mfr.mgr = (float) d;
                return;
            case 21978:
                this.mfr.mgs = (float) d;
                return;
            default:
                return;
        }
    }

    void bh(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.mfr.mfX = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.mfr.language = str;
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
                if (this.mfC == 0) {
                    this.mfI = (int) this.meR.a(fVar, false, true, 8);
                    this.mfJ = this.meR.dvb();
                    this.mfE = -9223372036854775807L;
                    this.mfC = 1;
                    this.mez.reset();
                }
                b bVar = this.mfe.get(this.mfI);
                if (bVar == null) {
                    fVar.Jv(i2 - this.mfJ);
                    this.mfC = 0;
                    return;
                }
                if (this.mfC == 1) {
                    d(fVar, 3);
                    int i4 = (this.mez.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.mfG = 1;
                        this.mfH = c(this.mfH, 1);
                        this.mfH[0] = (i2 - this.mfJ) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.mfG = (this.mez.data[3] & 255) + 1;
                        this.mfH = c(this.mfH, this.mfG);
                        if (i4 == 2) {
                            Arrays.fill(this.mfH, 0, this.mfG, ((i2 - this.mfJ) - 4) / this.mfG);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.mfG - 1; i7++) {
                                this.mfH[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.mez.data[i6 - 1] & 255;
                                    int[] iArr = this.mfH;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.mfH[i7];
                            }
                            this.mfH[this.mfG - 1] = ((i2 - this.mfJ) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.mfG - 1; i10++) {
                                this.mfH[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.mez.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.mez.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.mez.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.mez.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.mfH;
                                if (i10 != 0) {
                                    i16 += this.mfH[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.mfH[i10];
                            }
                            this.mfH[this.mfG - 1] = ((i2 - this.mfJ) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.mfD = this.mfy + fM((this.mez.data[0] << 8) | (this.mez.data[1] & 255));
                    this.mfK = ((this.mez.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.mez.data[2] & 128) == 128) ? 1 : 0);
                    this.mfC = 2;
                    this.mfF = 0;
                }
                if (i == 163) {
                    while (this.mfF < this.mfG) {
                        a(fVar, bVar, this.mfH[this.mfF]);
                        a(bVar, this.mfD + ((this.mfF * bVar.mfY) / 1000));
                        this.mfF++;
                    }
                    this.mfC = 0;
                    return;
                }
                a(fVar, bVar, this.mfH[0]);
                return;
            case 16981:
                this.mfr.mga = new byte[i2];
                fVar.readFully(this.mfr.mga, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.mfr.mgb = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.mfh.data, (byte) 0);
                fVar.readFully(this.mfh.data, 4 - i2, i2);
                this.mfh.setPosition(0);
                this.mft = (int) this.mfh.readUnsignedInt();
                return;
            case 25506:
                this.mfr.mgc = new byte[i2];
                fVar.readFully(this.mfr.mgc, 0, i2);
                return;
            case 30322:
                this.mfr.projectionData = new byte[i2];
                fVar.readFully(this.mfr.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mfX)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, meY);
        } else if ("S_TEXT/ASS".equals(bVar.mfX)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, mfb);
        }
        bVar.meL.a(j, this.mfK, this.mfT, 0, bVar.mgb);
        this.mfU = true;
        duW();
    }

    private void duW() {
        this.mfL = 0;
        this.mfT = 0;
        this.mfS = 0;
        this.mfM = false;
        this.mfN = false;
        this.mfP = false;
        this.mfR = 0;
        this.mfQ = (byte) 0;
        this.mfO = false;
        this.mfi.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.mez.dzu() < i) {
            if (this.mez.capacity() < i) {
                this.mez.I(Arrays.copyOf(this.mez.data, Math.max(this.mez.data.length * 2, i)), this.mez.dzu());
            }
            fVar.readFully(this.mez.data, this.mez.dzu(), i - this.mez.dzu());
            this.mez.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mfX)) {
            a(fVar, meX, i);
        } else if ("S_TEXT/ASS".equals(bVar.mfX)) {
            a(fVar, mfa, i);
        } else {
            m mVar = bVar.meL;
            if (!this.mfM) {
                if (bVar.mfZ) {
                    this.mfK &= -1073741825;
                    if (!this.mfN) {
                        fVar.readFully(this.mez.data, 0, 1);
                        this.mfL++;
                        if ((this.mez.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mfQ = this.mez.data[0];
                        this.mfN = true;
                    }
                    if ((this.mfQ & 1) == 1) {
                        boolean z = (this.mfQ & 2) == 2;
                        this.mfK |= 1073741824;
                        if (!this.mfO) {
                            fVar.readFully(this.mfk.data, 0, 8);
                            this.mfL += 8;
                            this.mfO = true;
                            this.mez.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.mez.setPosition(0);
                            mVar.a(this.mez, 1);
                            this.mfT++;
                            this.mfk.setPosition(0);
                            mVar.a(this.mfk, 8);
                            this.mfT += 8;
                        }
                        if (z) {
                            if (!this.mfP) {
                                fVar.readFully(this.mez.data, 0, 1);
                                this.mfL++;
                                this.mez.setPosition(0);
                                this.mfR = this.mez.readUnsignedByte();
                                this.mfP = true;
                            }
                            int i2 = this.mfR * 4;
                            this.mez.reset(i2);
                            fVar.readFully(this.mez.data, 0, i2);
                            this.mfL = i2 + this.mfL;
                            short s = (short) ((this.mfR / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.mfm == null || this.mfm.capacity() < i3) {
                                this.mfm = ByteBuffer.allocate(i3);
                            }
                            this.mfm.position(0);
                            this.mfm.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mfR) {
                                int dzE = this.mez.dzE();
                                if (i4 % 2 == 0) {
                                    this.mfm.putShort((short) (dzE - i5));
                                } else {
                                    this.mfm.putInt(dzE - i5);
                                }
                                i4++;
                                i5 = dzE;
                            }
                            int i6 = (i - this.mfL) - i5;
                            if (this.mfR % 2 == 1) {
                                this.mfm.putInt(i6);
                            } else {
                                this.mfm.putShort((short) i6);
                                this.mfm.putInt(0);
                            }
                            this.mfl.I(this.mfm.array(), i3);
                            mVar.a(this.mfl, i3);
                            this.mfT += i3;
                        }
                    }
                } else if (bVar.mga != null) {
                    this.mfi.I(bVar.mga, bVar.mga.length);
                }
                this.mfM = true;
            }
            int dzu = this.mfi.dzu() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mfX) || "V_MPEGH/ISO/HEVC".equals(bVar.mfX)) {
                byte[] bArr = this.meN.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.meO;
                int i8 = 4 - bVar.meO;
                while (this.mfL < dzu) {
                    if (this.mfS == 0) {
                        a(fVar, bArr, i8, i7);
                        this.meN.setPosition(0);
                        this.mfS = this.meN.dzE();
                        this.meM.setPosition(0);
                        mVar.a(this.meM, 4);
                        this.mfT += 4;
                    } else {
                        this.mfS -= a(fVar, mVar, this.mfS);
                    }
                }
            } else {
                while (this.mfL < dzu) {
                    a(fVar, mVar, dzu - this.mfL);
                }
            }
            if ("A_VORBIS".equals(bVar.mfX)) {
                this.mfg.setPosition(0);
                mVar.a(this.mfg, 4);
                this.mfT += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.mfj.capacity() < length) {
            this.mfj.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.mfj.data, 0, bArr.length);
        }
        fVar.readFully(this.mfj.data, bArr.length, i);
        this.mfj.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.mfj.data, this.mfE, str, i, j, bArr);
        bVar.meL.a(this.mfj, this.mfj.dzu());
        this.mfT += this.mfj.dzu();
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] QA;
        if (j == -9223372036854775807L) {
            QA = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - ((i2 * 3600) * TimeUtils.NANOS_PER_MS);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * TimeUtils.NANOS_PER_MS);
            int i4 = (int) (j4 / TimeUtils.NANOS_PER_MS);
            QA = v.QA(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * TimeUtils.NANOS_PER_MS)) / j2))));
        }
        System.arraycopy(QA, 0, bArr, i, bArr2.length);
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int min = Math.min(i2, this.mfi.dzt());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.mfi.G(bArr, i, min);
        }
        this.mfL += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dzt = this.mfi.dzt();
        if (dzt > 0) {
            a2 = Math.min(i, dzt);
            mVar.a(this.mfi, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mfL += a2;
        this.mfT += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l duX() {
        if (this.mfo == -1 || this.lZD == -9223372036854775807L || this.mfz == null || this.mfz.size() == 0 || this.mfA == null || this.mfA.size() != this.mfz.size()) {
            this.mfz = null;
            this.mfA = null;
            return new l.a(this.lZD);
        }
        int size = this.mfz.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.mfz.LT(i);
            jArr[i] = this.mfo + this.mfA.LT(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.mfo + this.mfn) - jArr[size - 1]);
        jArr2[size - 1] = this.lZD - jArr3[size - 1];
        this.mfz = null;
        this.mfA = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.mfv) {
            this.mfx = j;
            kVar.fOb = this.mfw;
            this.mfv = false;
            return true;
        } else if (!this.mfs || this.mfx == -1) {
            return false;
        } else {
            kVar.fOb = this.mfx;
            this.mfx = -1L;
            return true;
        }
    }

    private long fM(long j) throws ParserException {
        if (this.mfp == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.i(j, this.mfp, 1000L);
    }

    private static boolean Ps(String str) {
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
        public int JD(int i) {
            return d.this.JD(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public boolean JE(int i) {
            return d.this.JE(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void k(int i, long j, long j2) throws ParserException {
            d.this.k(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void JF(int i) throws ParserException {
            d.this.JF(i);
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
        public m meL;
        public int meO;
        public String mfX;
        public int mfY;
        public boolean mfZ;
        public byte[] mga;
        public m.a mgb;
        public byte[] mgc;
        public int mgd;
        public int mge;
        public int mgf;
        public boolean mgg;
        public int mgh;
        public int mgi;
        public float mgj;
        public float mgk;
        public float mgl;
        public float mgm;
        public float mgn;
        public float mgo;
        public float mgp;
        public float mgq;
        public float mgr;
        public float mgs;
        public int mgt;
        public long mgu;
        public long mgv;
        public boolean mgw;
        public boolean mgx;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mgd = -1;
            this.mge = -1;
            this.mgf = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mgg = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mgh = 1000;
            this.mgi = 200;
            this.mgj = -1.0f;
            this.mgk = -1.0f;
            this.mgl = -1.0f;
            this.mgm = -1.0f;
            this.mgn = -1.0f;
            this.mgo = -1.0f;
            this.mgp = -1.0f;
            this.mgq = -1.0f;
            this.mgr = -1.0f;
            this.mgs = -1.0f;
            this.channelCount = 1;
            this.mgt = -1;
            this.sampleRate = 8000;
            this.mgu = 0L;
            this.mgv = 0L;
            this.mgx = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mfX;
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
                    list = this.mgc == null ? null : Collections.singletonList(this.mgc);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mgc));
                    list = ag.initializationData;
                    this.meO = ag.meO;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mgc));
                    list = ai.initializationData;
                    this.meO = ai.meO;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mgc));
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
                    list = at(this.mgc);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mgc);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgu).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgv).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mgc);
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
                    list = Collections.singletonList(this.mgc);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mgc))) {
                        i4 = v.LZ(this.mgt);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgt + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LZ(this.mgt);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgt + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mgc);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mgc[0], this.mgc[1], this.mgc[2], this.mgc[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mgx ? 1 : 0) | (this.mgw ? 2 : 0);
            if (i.Qo(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OQ(str)) {
                if (this.mgf == 0) {
                    this.mgd = this.mgd == -1 ? this.width : this.mgd;
                    this.mge = this.mge == -1 ? this.height : this.mge;
                }
                float f = -1.0f;
                if (this.mgd != -1 && this.mge != -1) {
                    f = (this.height * this.mgd) / (this.width * this.mge);
                }
                ColorInfo colorInfo = null;
                if (this.mgg) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dva());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.meZ);
                arrayList.add(this.mgc);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.meL = gVar.dK(this.number, i2);
            this.meL.h(a);
        }

        private byte[] dva() {
            if (this.mgj == -1.0f || this.mgk == -1.0f || this.mgl == -1.0f || this.mgm == -1.0f || this.mgn == -1.0f || this.mgo == -1.0f || this.mgp == -1.0f || this.mgq == -1.0f || this.mgr == -1.0f || this.mgs == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mgj * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgk * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgl * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgm * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgn * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgo * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgp * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgq * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mgr + 0.5f));
            wrap.putShort((short) (this.mgs + 0.5f));
            wrap.putShort((short) this.mgh);
            wrap.putShort((short) this.mgi);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dzz() != 826496599) {
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
                int dzw = lVar.dzw();
                if (dzw == 1) {
                    return true;
                }
                if (dzw == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.mfc.getMostSignificantBits()) {
                        if (lVar.readLong() == d.mfc.getLeastSignificantBits()) {
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
