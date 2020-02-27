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
    private long lZB;
    private g meB;
    private final l meK;
    private final l meL;
    private final f meP;
    private final l mex;
    private int mfA;
    private long mfB;
    private long mfC;
    private int mfD;
    private int mfE;
    private int[] mfF;
    private int mfG;
    private int mfH;
    private int mfI;
    private int mfJ;
    private boolean mfK;
    private boolean mfL;
    private boolean mfM;
    private boolean mfN;
    private byte mfO;
    private int mfP;
    private int mfQ;
    private int mfR;
    private boolean mfS;
    private boolean mfT;
    private final com.google.android.exoplayer2.extractor.a.b mfb;
    private final SparseArray<b> mfc;
    private final boolean mfd;
    private final l mfe;
    private final l mff;
    private final l mfg;
    private final l mfh;
    private final l mfi;
    private final l mfj;
    private ByteBuffer mfk;
    private long mfl;
    private long mfm;
    private long mfn;
    private long mfo;
    private b mfp;
    private boolean mfq;
    private int mfr;
    private long mfs;
    private boolean mft;
    private long mfu;
    private long mfv;
    private long mfw;
    private com.google.android.exoplayer2.util.g mfx;
    private com.google.android.exoplayer2.util.g mfy;
    private boolean mfz;
    public static final h mev = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] meV = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] meW = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] meX = v.QA("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] meY = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] meZ = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID mfa = new UUID(72057594037932032L, -9223371306706625679L);

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.mfm = -1L;
        this.mfn = -9223372036854775807L;
        this.mfo = -9223372036854775807L;
        this.lZB = -9223372036854775807L;
        this.mfu = -1L;
        this.mfv = -1L;
        this.mfw = -9223372036854775807L;
        this.mfb = bVar;
        this.mfb.a(new a());
        this.mfd = (i & 1) == 0;
        this.meP = new f();
        this.mfc = new SparseArray<>();
        this.mex = new l(4);
        this.mfe = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.mff = new l(4);
        this.meK = new l(j.mGZ);
        this.meL = new l(4);
        this.mfg = new l();
        this.mfh = new l();
        this.mfi = new l(8);
        this.mfj = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meB = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mfw = -9223372036854775807L;
        this.mfA = 0;
        this.mfb.reset();
        this.meP.reset();
        duU();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mfS = false;
        boolean z = true;
        while (z && !this.mfS) {
            z = this.mfb.g(fVar);
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
                this.mfT = false;
                return;
            case 174:
                this.mfp = new b();
                return;
            case Opcodes.NEW /* 187 */:
                this.mfz = false;
                return;
            case 19899:
                this.mfr = -1;
                this.mfs = -1L;
                return;
            case 20533:
                this.mfp.mfX = true;
                return;
            case 21968:
                this.mfp.mge = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.mfm != -1 && this.mfm != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.mfm = j;
                this.mfl = j2;
                return;
            case 475249515:
                this.mfx = new com.google.android.exoplayer2.util.g();
                this.mfy = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.mfq) {
                    if (this.mfd && this.mfu != -1) {
                        this.mft = true;
                        return;
                    }
                    this.meB.a(new l.a(this.lZB));
                    this.mfq = true;
                    return;
                }
                return;
        }
    }

    void JF(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.mfA == 2) {
                    if (!this.mfT) {
                        this.mfI |= 1;
                    }
                    a(this.mfc.get(this.mfG), this.mfB);
                    this.mfA = 0;
                    return;
                }
                return;
            case 174:
                if (Ps(this.mfp.mfV)) {
                    this.mfp.a(this.meB, this.mfp.number);
                    this.mfc.put(this.mfp.number, this.mfp);
                }
                this.mfp = null;
                return;
            case 19899:
                if (this.mfr == -1 || this.mfs == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.mfr == 475249515) {
                    this.mfu = this.mfs;
                    return;
                }
                return;
            case 25152:
                if (this.mfp.mfX) {
                    if (this.mfp.mfZ == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.mfp.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lYd, "video/webm", this.mfp.mfZ.meq));
                    return;
                }
                return;
            case 28032:
                if (this.mfp.mfX && this.mfp.mfY != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.mfn == -9223372036854775807L) {
                    this.mfn = TimeUtils.NANOS_PER_MS;
                }
                if (this.mfo != -9223372036854775807L) {
                    this.lZB = fM(this.mfo);
                    return;
                }
                return;
            case 374648427:
                if (this.mfc.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.meB.duS();
                return;
            case 475249515:
                if (!this.mfq) {
                    this.meB.a(duV());
                    this.mfq = true;
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
                this.mfp.type = (int) j;
                return;
            case 136:
                this.mfp.mgu = j == 1;
                return;
            case 155:
                this.mfC = fM(j);
                return;
            case Opcodes.IF_ICMPEQ /* 159 */:
                this.mfp.channelCount = (int) j;
                return;
            case Opcodes.ARETURN /* 176 */:
                this.mfp.width = (int) j;
                return;
            case 179:
                this.mfx.gG(fM(j));
                return;
            case 186:
                this.mfp.height = (int) j;
                return;
            case 215:
                this.mfp.number = (int) j;
                return;
            case 231:
                this.mfw = fM(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.mfz) {
                    this.mfy.gG(j);
                    this.mfz = true;
                    return;
                }
                return;
            case 251:
                this.mfT = true;
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
                this.mfs = this.mfm + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.mfp.stereoMode = 0;
                        return;
                    case 1:
                        this.mfp.stereoMode = 2;
                        return;
                    case 3:
                        this.mfp.stereoMode = 1;
                        return;
                    case 15:
                        this.mfp.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.mfp.mgb = (int) j;
                return;
            case 21682:
                this.mfp.mgd = (int) j;
                return;
            case 21690:
                this.mfp.mgc = (int) j;
                return;
            case 21930:
                this.mfp.mgv = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.mfp.colorRange = 2;
                        return;
                    case 2:
                        this.mfp.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.mfp.colorTransfer = 3;
                        return;
                    case 16:
                        this.mfp.colorTransfer = 6;
                        return;
                    case 18:
                        this.mfp.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.mfp.mge = true;
                switch ((int) j) {
                    case 1:
                        this.mfp.colorSpace = 1;
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
                        this.mfp.colorSpace = 2;
                        return;
                    case 9:
                        this.mfp.colorSpace = 6;
                        return;
                }
            case 21948:
                this.mfp.mgf = (int) j;
                return;
            case 21949:
                this.mfp.mgg = (int) j;
                return;
            case 22186:
                this.mfp.mgs = j;
                return;
            case 22203:
                this.mfp.mgt = j;
                return;
            case 25188:
                this.mfp.mgr = (int) j;
                return;
            case 2352003:
                this.mfp.mfW = (int) j;
                return;
            case 2807729:
                this.mfn = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case Opcodes.PUTFIELD /* 181 */:
                this.mfp.sampleRate = (int) d;
                return;
            case 17545:
                this.mfo = (long) d;
                return;
            case 21969:
                this.mfp.mgh = (float) d;
                return;
            case 21970:
                this.mfp.mgi = (float) d;
                return;
            case 21971:
                this.mfp.mgj = (float) d;
                return;
            case 21972:
                this.mfp.mgk = (float) d;
                return;
            case 21973:
                this.mfp.mgl = (float) d;
                return;
            case 21974:
                this.mfp.mgm = (float) d;
                return;
            case 21975:
                this.mfp.mgn = (float) d;
                return;
            case 21976:
                this.mfp.mgo = (float) d;
                return;
            case 21977:
                this.mfp.mgp = (float) d;
                return;
            case 21978:
                this.mfp.mgq = (float) d;
                return;
            default:
                return;
        }
    }

    void bh(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.mfp.mfV = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.mfp.language = str;
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
                if (this.mfA == 0) {
                    this.mfG = (int) this.meP.a(fVar, false, true, 8);
                    this.mfH = this.meP.duZ();
                    this.mfC = -9223372036854775807L;
                    this.mfA = 1;
                    this.mex.reset();
                }
                b bVar = this.mfc.get(this.mfG);
                if (bVar == null) {
                    fVar.Jv(i2 - this.mfH);
                    this.mfA = 0;
                    return;
                }
                if (this.mfA == 1) {
                    d(fVar, 3);
                    int i4 = (this.mex.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.mfE = 1;
                        this.mfF = c(this.mfF, 1);
                        this.mfF[0] = (i2 - this.mfH) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.mfE = (this.mex.data[3] & 255) + 1;
                        this.mfF = c(this.mfF, this.mfE);
                        if (i4 == 2) {
                            Arrays.fill(this.mfF, 0, this.mfE, ((i2 - this.mfH) - 4) / this.mfE);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.mfE - 1; i7++) {
                                this.mfF[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.mex.data[i6 - 1] & 255;
                                    int[] iArr = this.mfF;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.mfF[i7];
                            }
                            this.mfF[this.mfE - 1] = ((i2 - this.mfH) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.mfE - 1; i10++) {
                                this.mfF[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.mex.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.mex.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.mex.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.mex.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.mfF;
                                if (i10 != 0) {
                                    i16 += this.mfF[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.mfF[i10];
                            }
                            this.mfF[this.mfE - 1] = ((i2 - this.mfH) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.mfB = this.mfw + fM((this.mex.data[0] << 8) | (this.mex.data[1] & 255));
                    this.mfI = ((this.mex.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.mex.data[2] & 128) == 128) ? 1 : 0);
                    this.mfA = 2;
                    this.mfD = 0;
                }
                if (i == 163) {
                    while (this.mfD < this.mfE) {
                        a(fVar, bVar, this.mfF[this.mfD]);
                        a(bVar, this.mfB + ((this.mfD * bVar.mfW) / 1000));
                        this.mfD++;
                    }
                    this.mfA = 0;
                    return;
                }
                a(fVar, bVar, this.mfF[0]);
                return;
            case 16981:
                this.mfp.mfY = new byte[i2];
                fVar.readFully(this.mfp.mfY, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.mfp.mfZ = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.mff.data, (byte) 0);
                fVar.readFully(this.mff.data, 4 - i2, i2);
                this.mff.setPosition(0);
                this.mfr = (int) this.mff.readUnsignedInt();
                return;
            case 25506:
                this.mfp.mga = new byte[i2];
                fVar.readFully(this.mfp.mga, 0, i2);
                return;
            case 30322:
                this.mfp.projectionData = new byte[i2];
                fVar.readFully(this.mfp.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mfV)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, meW);
        } else if ("S_TEXT/ASS".equals(bVar.mfV)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, meZ);
        }
        bVar.meJ.a(j, this.mfI, this.mfR, 0, bVar.mfZ);
        this.mfS = true;
        duU();
    }

    private void duU() {
        this.mfJ = 0;
        this.mfR = 0;
        this.mfQ = 0;
        this.mfK = false;
        this.mfL = false;
        this.mfN = false;
        this.mfP = 0;
        this.mfO = (byte) 0;
        this.mfM = false;
        this.mfg.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.mex.dzs() < i) {
            if (this.mex.capacity() < i) {
                this.mex.I(Arrays.copyOf(this.mex.data, Math.max(this.mex.data.length * 2, i)), this.mex.dzs());
            }
            fVar.readFully(this.mex.data, this.mex.dzs(), i - this.mex.dzs());
            this.mex.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mfV)) {
            a(fVar, meV, i);
        } else if ("S_TEXT/ASS".equals(bVar.mfV)) {
            a(fVar, meY, i);
        } else {
            m mVar = bVar.meJ;
            if (!this.mfK) {
                if (bVar.mfX) {
                    this.mfI &= -1073741825;
                    if (!this.mfL) {
                        fVar.readFully(this.mex.data, 0, 1);
                        this.mfJ++;
                        if ((this.mex.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mfO = this.mex.data[0];
                        this.mfL = true;
                    }
                    if ((this.mfO & 1) == 1) {
                        boolean z = (this.mfO & 2) == 2;
                        this.mfI |= 1073741824;
                        if (!this.mfM) {
                            fVar.readFully(this.mfi.data, 0, 8);
                            this.mfJ += 8;
                            this.mfM = true;
                            this.mex.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.mex.setPosition(0);
                            mVar.a(this.mex, 1);
                            this.mfR++;
                            this.mfi.setPosition(0);
                            mVar.a(this.mfi, 8);
                            this.mfR += 8;
                        }
                        if (z) {
                            if (!this.mfN) {
                                fVar.readFully(this.mex.data, 0, 1);
                                this.mfJ++;
                                this.mex.setPosition(0);
                                this.mfP = this.mex.readUnsignedByte();
                                this.mfN = true;
                            }
                            int i2 = this.mfP * 4;
                            this.mex.reset(i2);
                            fVar.readFully(this.mex.data, 0, i2);
                            this.mfJ = i2 + this.mfJ;
                            short s = (short) ((this.mfP / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.mfk == null || this.mfk.capacity() < i3) {
                                this.mfk = ByteBuffer.allocate(i3);
                            }
                            this.mfk.position(0);
                            this.mfk.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mfP) {
                                int dzC = this.mex.dzC();
                                if (i4 % 2 == 0) {
                                    this.mfk.putShort((short) (dzC - i5));
                                } else {
                                    this.mfk.putInt(dzC - i5);
                                }
                                i4++;
                                i5 = dzC;
                            }
                            int i6 = (i - this.mfJ) - i5;
                            if (this.mfP % 2 == 1) {
                                this.mfk.putInt(i6);
                            } else {
                                this.mfk.putShort((short) i6);
                                this.mfk.putInt(0);
                            }
                            this.mfj.I(this.mfk.array(), i3);
                            mVar.a(this.mfj, i3);
                            this.mfR += i3;
                        }
                    }
                } else if (bVar.mfY != null) {
                    this.mfg.I(bVar.mfY, bVar.mfY.length);
                }
                this.mfK = true;
            }
            int dzs = this.mfg.dzs() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mfV) || "V_MPEGH/ISO/HEVC".equals(bVar.mfV)) {
                byte[] bArr = this.meL.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.meM;
                int i8 = 4 - bVar.meM;
                while (this.mfJ < dzs) {
                    if (this.mfQ == 0) {
                        a(fVar, bArr, i8, i7);
                        this.meL.setPosition(0);
                        this.mfQ = this.meL.dzC();
                        this.meK.setPosition(0);
                        mVar.a(this.meK, 4);
                        this.mfR += 4;
                    } else {
                        this.mfQ -= a(fVar, mVar, this.mfQ);
                    }
                }
            } else {
                while (this.mfJ < dzs) {
                    a(fVar, mVar, dzs - this.mfJ);
                }
            }
            if ("A_VORBIS".equals(bVar.mfV)) {
                this.mfe.setPosition(0);
                mVar.a(this.mfe, 4);
                this.mfR += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.mfh.capacity() < length) {
            this.mfh.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.mfh.data, 0, bArr.length);
        }
        fVar.readFully(this.mfh.data, bArr.length, i);
        this.mfh.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.mfh.data, this.mfC, str, i, j, bArr);
        bVar.meJ.a(this.mfh, this.mfh.dzs());
        this.mfR += this.mfh.dzs();
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
        int min = Math.min(i2, this.mfg.dzr());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.mfg.G(bArr, i, min);
        }
        this.mfJ += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dzr = this.mfg.dzr();
        if (dzr > 0) {
            a2 = Math.min(i, dzr);
            mVar.a(this.mfg, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mfJ += a2;
        this.mfR += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l duV() {
        if (this.mfm == -1 || this.lZB == -9223372036854775807L || this.mfx == null || this.mfx.size() == 0 || this.mfy == null || this.mfy.size() != this.mfx.size()) {
            this.mfx = null;
            this.mfy = null;
            return new l.a(this.lZB);
        }
        int size = this.mfx.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.mfx.LT(i);
            jArr[i] = this.mfm + this.mfy.LT(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.mfm + this.mfl) - jArr[size - 1]);
        jArr2[size - 1] = this.lZB - jArr3[size - 1];
        this.mfx = null;
        this.mfy = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.mft) {
            this.mfv = j;
            kVar.fNZ = this.mfu;
            this.mft = false;
            return true;
        } else if (!this.mfq || this.mfv == -1) {
            return false;
        } else {
            kVar.fNZ = this.mfv;
            this.mfv = -1L;
            return true;
        }
    }

    private long fM(long j) throws ParserException {
        if (this.mfn == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.i(j, this.mfn, 1000L);
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
        public m meJ;
        public int meM;
        public String mfV;
        public int mfW;
        public boolean mfX;
        public byte[] mfY;
        public m.a mfZ;
        public byte[] mga;
        public int mgb;
        public int mgc;
        public int mgd;
        public boolean mge;
        public int mgf;
        public int mgg;
        public float mgh;
        public float mgi;
        public float mgj;
        public float mgk;
        public float mgl;
        public float mgm;
        public float mgn;
        public float mgo;
        public float mgp;
        public float mgq;
        public int mgr;
        public long mgs;
        public long mgt;
        public boolean mgu;
        public boolean mgv;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mgb = -1;
            this.mgc = -1;
            this.mgd = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mge = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mgf = 1000;
            this.mgg = 200;
            this.mgh = -1.0f;
            this.mgi = -1.0f;
            this.mgj = -1.0f;
            this.mgk = -1.0f;
            this.mgl = -1.0f;
            this.mgm = -1.0f;
            this.mgn = -1.0f;
            this.mgo = -1.0f;
            this.mgp = -1.0f;
            this.mgq = -1.0f;
            this.channelCount = 1;
            this.mgr = -1;
            this.sampleRate = 8000;
            this.mgs = 0L;
            this.mgt = 0L;
            this.mgv = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mfV;
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
                    list = this.mga == null ? null : Collections.singletonList(this.mga);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mga));
                    list = ag.initializationData;
                    this.meM = ag.meM;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mga));
                    list = ai.initializationData;
                    this.meM = ai.meM;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mga));
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
                    list = at(this.mga);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mga);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgs).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgt).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mga);
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
                    list = Collections.singletonList(this.mga);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mga))) {
                        i4 = v.LZ(this.mgr);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgr + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LZ(this.mgr);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgr + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mga);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mga[0], this.mga[1], this.mga[2], this.mga[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mgv ? 1 : 0) | (this.mgu ? 2 : 0);
            if (i.Qo(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OQ(str)) {
                if (this.mgd == 0) {
                    this.mgb = this.mgb == -1 ? this.width : this.mgb;
                    this.mgc = this.mgc == -1 ? this.height : this.mgc;
                }
                float f = -1.0f;
                if (this.mgb != -1 && this.mgc != -1) {
                    f = (this.height * this.mgb) / (this.width * this.mgc);
                }
                ColorInfo colorInfo = null;
                if (this.mge) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, duY());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.meX);
                arrayList.add(this.mga);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.meJ = gVar.dK(this.number, i2);
            this.meJ.h(a);
        }

        private byte[] duY() {
            if (this.mgh == -1.0f || this.mgi == -1.0f || this.mgj == -1.0f || this.mgk == -1.0f || this.mgl == -1.0f || this.mgm == -1.0f || this.mgn == -1.0f || this.mgo == -1.0f || this.mgp == -1.0f || this.mgq == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mgh * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgi * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgj * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgk * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgl * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgm * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgn * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgo * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mgp + 0.5f));
            wrap.putShort((short) (this.mgq + 0.5f));
            wrap.putShort((short) this.mgf);
            wrap.putShort((short) this.mgg);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dzx() != 826496599) {
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
                int dzu = lVar.dzu();
                if (dzu == 1) {
                    return true;
                }
                if (dzu == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.mfa.getMostSignificantBits()) {
                        if (lVar.readLong() == d.mfa.getLeastSignificantBits()) {
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
