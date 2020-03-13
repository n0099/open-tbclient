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
    public static final h meI = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] mfi = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] mfj = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] mfk = v.QB("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] mfl = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] mfm = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID mfn = new UUID(72057594037932032L, -9223371306706625679L);
    private long lZO;
    private final l meK;
    private g meO;
    private final l meX;
    private final l meY;
    private long mfA;
    private long mfB;
    private b mfC;
    private boolean mfD;
    private int mfE;
    private long mfF;
    private boolean mfG;
    private long mfH;
    private long mfI;
    private long mfJ;
    private com.google.android.exoplayer2.util.g mfK;
    private com.google.android.exoplayer2.util.g mfL;
    private boolean mfM;
    private int mfN;
    private long mfO;
    private long mfP;
    private int mfQ;
    private int mfR;
    private int[] mfS;
    private int mfT;
    private int mfU;
    private int mfV;
    private int mfW;
    private boolean mfX;
    private boolean mfY;
    private boolean mfZ;
    private final f mfc;
    private final com.google.android.exoplayer2.extractor.a.b mfo;
    private final SparseArray<b> mfp;
    private final boolean mfq;
    private final l mfr;
    private final l mfs;
    private final l mft;
    private final l mfu;
    private final l mfv;
    private final l mfw;
    private ByteBuffer mfx;
    private long mfy;
    private long mfz;
    private boolean mga;
    private byte mgb;
    private int mgc;
    private int mgd;
    private int mge;
    private boolean mgf;
    private boolean mgg;

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.mfz = -1L;
        this.mfA = -9223372036854775807L;
        this.mfB = -9223372036854775807L;
        this.lZO = -9223372036854775807L;
        this.mfH = -1L;
        this.mfI = -1L;
        this.mfJ = -9223372036854775807L;
        this.mfo = bVar;
        this.mfo.a(new a());
        this.mfq = (i & 1) == 0;
        this.mfc = new f();
        this.mfp = new SparseArray<>();
        this.meK = new l(4);
        this.mfr = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.mfs = new l(4);
        this.meX = new l(j.mHm);
        this.meY = new l(4);
        this.mft = new l();
        this.mfu = new l();
        this.mfv = new l(8);
        this.mfw = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meO = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mfJ = -9223372036854775807L;
        this.mfN = 0;
        this.mfo.reset();
        this.mfc.reset();
        duX();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mgf = false;
        boolean z = true;
        while (z && !this.mgf) {
            z = this.mfo.g(fVar);
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
                this.mgg = false;
                return;
            case 174:
                this.mfC = new b();
                return;
            case Opcodes.NEW /* 187 */:
                this.mfM = false;
                return;
            case 19899:
                this.mfE = -1;
                this.mfF = -1L;
                return;
            case 20533:
                this.mfC.mgk = true;
                return;
            case 21968:
                this.mfC.mgr = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.mfz != -1 && this.mfz != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.mfz = j;
                this.mfy = j2;
                return;
            case 475249515:
                this.mfK = new com.google.android.exoplayer2.util.g();
                this.mfL = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.mfD) {
                    if (this.mfq && this.mfH != -1) {
                        this.mfG = true;
                        return;
                    }
                    this.meO.a(new l.a(this.lZO));
                    this.mfD = true;
                    return;
                }
                return;
        }
    }

    void JF(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.mfN == 2) {
                    if (!this.mgg) {
                        this.mfV |= 1;
                    }
                    a(this.mfp.get(this.mfT), this.mfO);
                    this.mfN = 0;
                    return;
                }
                return;
            case 174:
                if (Pt(this.mfC.mgi)) {
                    this.mfC.a(this.meO, this.mfC.number);
                    this.mfp.put(this.mfC.number, this.mfC);
                }
                this.mfC = null;
                return;
            case 19899:
                if (this.mfE == -1 || this.mfF == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.mfE == 475249515) {
                    this.mfH = this.mfF;
                    return;
                }
                return;
            case 25152:
                if (this.mfC.mgk) {
                    if (this.mfC.mgm == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.mfC.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lYq, "video/webm", this.mfC.mgm.meD));
                    return;
                }
                return;
            case 28032:
                if (this.mfC.mgk && this.mfC.mgl != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.mfA == -9223372036854775807L) {
                    this.mfA = TimeUtils.NANOS_PER_MS;
                }
                if (this.mfB != -9223372036854775807L) {
                    this.lZO = fM(this.mfB);
                    return;
                }
                return;
            case 374648427:
                if (this.mfp.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.meO.duV();
                return;
            case 475249515:
                if (!this.mfD) {
                    this.meO.a(duY());
                    this.mfD = true;
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
                this.mfC.type = (int) j;
                return;
            case 136:
                this.mfC.mgH = j == 1;
                return;
            case 155:
                this.mfP = fM(j);
                return;
            case Opcodes.IF_ICMPEQ /* 159 */:
                this.mfC.channelCount = (int) j;
                return;
            case Opcodes.ARETURN /* 176 */:
                this.mfC.width = (int) j;
                return;
            case 179:
                this.mfK.gG(fM(j));
                return;
            case 186:
                this.mfC.height = (int) j;
                return;
            case 215:
                this.mfC.number = (int) j;
                return;
            case 231:
                this.mfJ = fM(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.mfM) {
                    this.mfL.gG(j);
                    this.mfM = true;
                    return;
                }
                return;
            case 251:
                this.mgg = true;
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
                this.mfF = this.mfz + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.mfC.stereoMode = 0;
                        return;
                    case 1:
                        this.mfC.stereoMode = 2;
                        return;
                    case 3:
                        this.mfC.stereoMode = 1;
                        return;
                    case 15:
                        this.mfC.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.mfC.mgo = (int) j;
                return;
            case 21682:
                this.mfC.mgq = (int) j;
                return;
            case 21690:
                this.mfC.mgp = (int) j;
                return;
            case 21930:
                this.mfC.mgI = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.mfC.colorRange = 2;
                        return;
                    case 2:
                        this.mfC.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.mfC.colorTransfer = 3;
                        return;
                    case 16:
                        this.mfC.colorTransfer = 6;
                        return;
                    case 18:
                        this.mfC.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.mfC.mgr = true;
                switch ((int) j) {
                    case 1:
                        this.mfC.colorSpace = 1;
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
                        this.mfC.colorSpace = 2;
                        return;
                    case 9:
                        this.mfC.colorSpace = 6;
                        return;
                }
            case 21948:
                this.mfC.mgs = (int) j;
                return;
            case 21949:
                this.mfC.mgt = (int) j;
                return;
            case 22186:
                this.mfC.mgF = j;
                return;
            case 22203:
                this.mfC.mgG = j;
                return;
            case 25188:
                this.mfC.mgE = (int) j;
                return;
            case 2352003:
                this.mfC.mgj = (int) j;
                return;
            case 2807729:
                this.mfA = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case Opcodes.PUTFIELD /* 181 */:
                this.mfC.sampleRate = (int) d;
                return;
            case 17545:
                this.mfB = (long) d;
                return;
            case 21969:
                this.mfC.mgu = (float) d;
                return;
            case 21970:
                this.mfC.mgv = (float) d;
                return;
            case 21971:
                this.mfC.mgw = (float) d;
                return;
            case 21972:
                this.mfC.mgx = (float) d;
                return;
            case 21973:
                this.mfC.mgy = (float) d;
                return;
            case 21974:
                this.mfC.mgz = (float) d;
                return;
            case 21975:
                this.mfC.mgA = (float) d;
                return;
            case 21976:
                this.mfC.mgB = (float) d;
                return;
            case 21977:
                this.mfC.mgC = (float) d;
                return;
            case 21978:
                this.mfC.mgD = (float) d;
                return;
            default:
                return;
        }
    }

    void bh(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.mfC.mgi = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.mfC.language = str;
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
                if (this.mfN == 0) {
                    this.mfT = (int) this.mfc.a(fVar, false, true, 8);
                    this.mfU = this.mfc.dvc();
                    this.mfP = -9223372036854775807L;
                    this.mfN = 1;
                    this.meK.reset();
                }
                b bVar = this.mfp.get(this.mfT);
                if (bVar == null) {
                    fVar.Jv(i2 - this.mfU);
                    this.mfN = 0;
                    return;
                }
                if (this.mfN == 1) {
                    d(fVar, 3);
                    int i4 = (this.meK.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.mfR = 1;
                        this.mfS = c(this.mfS, 1);
                        this.mfS[0] = (i2 - this.mfU) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.mfR = (this.meK.data[3] & 255) + 1;
                        this.mfS = c(this.mfS, this.mfR);
                        if (i4 == 2) {
                            Arrays.fill(this.mfS, 0, this.mfR, ((i2 - this.mfU) - 4) / this.mfR);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.mfR - 1; i7++) {
                                this.mfS[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.meK.data[i6 - 1] & 255;
                                    int[] iArr = this.mfS;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.mfS[i7];
                            }
                            this.mfS[this.mfR - 1] = ((i2 - this.mfU) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.mfR - 1; i10++) {
                                this.mfS[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.meK.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.meK.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.meK.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.meK.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.mfS;
                                if (i10 != 0) {
                                    i16 += this.mfS[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.mfS[i10];
                            }
                            this.mfS[this.mfR - 1] = ((i2 - this.mfU) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.mfO = this.mfJ + fM((this.meK.data[0] << 8) | (this.meK.data[1] & 255));
                    this.mfV = ((this.meK.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.meK.data[2] & 128) == 128) ? 1 : 0);
                    this.mfN = 2;
                    this.mfQ = 0;
                }
                if (i == 163) {
                    while (this.mfQ < this.mfR) {
                        a(fVar, bVar, this.mfS[this.mfQ]);
                        a(bVar, this.mfO + ((this.mfQ * bVar.mgj) / 1000));
                        this.mfQ++;
                    }
                    this.mfN = 0;
                    return;
                }
                a(fVar, bVar, this.mfS[0]);
                return;
            case 16981:
                this.mfC.mgl = new byte[i2];
                fVar.readFully(this.mfC.mgl, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.mfC.mgm = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.mfs.data, (byte) 0);
                fVar.readFully(this.mfs.data, 4 - i2, i2);
                this.mfs.setPosition(0);
                this.mfE = (int) this.mfs.readUnsignedInt();
                return;
            case 25506:
                this.mfC.mgn = new byte[i2];
                fVar.readFully(this.mfC.mgn, 0, i2);
                return;
            case 30322:
                this.mfC.projectionData = new byte[i2];
                fVar.readFully(this.mfC.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mgi)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, mfj);
        } else if ("S_TEXT/ASS".equals(bVar.mgi)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, mfm);
        }
        bVar.meW.a(j, this.mfV, this.mge, 0, bVar.mgm);
        this.mgf = true;
        duX();
    }

    private void duX() {
        this.mfW = 0;
        this.mge = 0;
        this.mgd = 0;
        this.mfX = false;
        this.mfY = false;
        this.mga = false;
        this.mgc = 0;
        this.mgb = (byte) 0;
        this.mfZ = false;
        this.mft.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.meK.dzv() < i) {
            if (this.meK.capacity() < i) {
                this.meK.I(Arrays.copyOf(this.meK.data, Math.max(this.meK.data.length * 2, i)), this.meK.dzv());
            }
            fVar.readFully(this.meK.data, this.meK.dzv(), i - this.meK.dzv());
            this.meK.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mgi)) {
            a(fVar, mfi, i);
        } else if ("S_TEXT/ASS".equals(bVar.mgi)) {
            a(fVar, mfl, i);
        } else {
            m mVar = bVar.meW;
            if (!this.mfX) {
                if (bVar.mgk) {
                    this.mfV &= -1073741825;
                    if (!this.mfY) {
                        fVar.readFully(this.meK.data, 0, 1);
                        this.mfW++;
                        if ((this.meK.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mgb = this.meK.data[0];
                        this.mfY = true;
                    }
                    if ((this.mgb & 1) == 1) {
                        boolean z = (this.mgb & 2) == 2;
                        this.mfV |= 1073741824;
                        if (!this.mfZ) {
                            fVar.readFully(this.mfv.data, 0, 8);
                            this.mfW += 8;
                            this.mfZ = true;
                            this.meK.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.meK.setPosition(0);
                            mVar.a(this.meK, 1);
                            this.mge++;
                            this.mfv.setPosition(0);
                            mVar.a(this.mfv, 8);
                            this.mge += 8;
                        }
                        if (z) {
                            if (!this.mga) {
                                fVar.readFully(this.meK.data, 0, 1);
                                this.mfW++;
                                this.meK.setPosition(0);
                                this.mgc = this.meK.readUnsignedByte();
                                this.mga = true;
                            }
                            int i2 = this.mgc * 4;
                            this.meK.reset(i2);
                            fVar.readFully(this.meK.data, 0, i2);
                            this.mfW = i2 + this.mfW;
                            short s = (short) ((this.mgc / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.mfx == null || this.mfx.capacity() < i3) {
                                this.mfx = ByteBuffer.allocate(i3);
                            }
                            this.mfx.position(0);
                            this.mfx.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mgc) {
                                int dzF = this.meK.dzF();
                                if (i4 % 2 == 0) {
                                    this.mfx.putShort((short) (dzF - i5));
                                } else {
                                    this.mfx.putInt(dzF - i5);
                                }
                                i4++;
                                i5 = dzF;
                            }
                            int i6 = (i - this.mfW) - i5;
                            if (this.mgc % 2 == 1) {
                                this.mfx.putInt(i6);
                            } else {
                                this.mfx.putShort((short) i6);
                                this.mfx.putInt(0);
                            }
                            this.mfw.I(this.mfx.array(), i3);
                            mVar.a(this.mfw, i3);
                            this.mge += i3;
                        }
                    }
                } else if (bVar.mgl != null) {
                    this.mft.I(bVar.mgl, bVar.mgl.length);
                }
                this.mfX = true;
            }
            int dzv = this.mft.dzv() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mgi) || "V_MPEGH/ISO/HEVC".equals(bVar.mgi)) {
                byte[] bArr = this.meY.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.meZ;
                int i8 = 4 - bVar.meZ;
                while (this.mfW < dzv) {
                    if (this.mgd == 0) {
                        a(fVar, bArr, i8, i7);
                        this.meY.setPosition(0);
                        this.mgd = this.meY.dzF();
                        this.meX.setPosition(0);
                        mVar.a(this.meX, 4);
                        this.mge += 4;
                    } else {
                        this.mgd -= a(fVar, mVar, this.mgd);
                    }
                }
            } else {
                while (this.mfW < dzv) {
                    a(fVar, mVar, dzv - this.mfW);
                }
            }
            if ("A_VORBIS".equals(bVar.mgi)) {
                this.mfr.setPosition(0);
                mVar.a(this.mfr, 4);
                this.mge += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.mfu.capacity() < length) {
            this.mfu.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.mfu.data, 0, bArr.length);
        }
        fVar.readFully(this.mfu.data, bArr.length, i);
        this.mfu.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.mfu.data, this.mfP, str, i, j, bArr);
        bVar.meW.a(this.mfu, this.mfu.dzv());
        this.mge += this.mfu.dzv();
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
        int min = Math.min(i2, this.mft.dzu());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.mft.G(bArr, i, min);
        }
        this.mfW += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dzu = this.mft.dzu();
        if (dzu > 0) {
            a2 = Math.min(i, dzu);
            mVar.a(this.mft, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mfW += a2;
        this.mge += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l duY() {
        if (this.mfz == -1 || this.lZO == -9223372036854775807L || this.mfK == null || this.mfK.size() == 0 || this.mfL == null || this.mfL.size() != this.mfK.size()) {
            this.mfK = null;
            this.mfL = null;
            return new l.a(this.lZO);
        }
        int size = this.mfK.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.mfK.LT(i);
            jArr[i] = this.mfz + this.mfL.LT(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.mfz + this.mfy) - jArr[size - 1]);
        jArr2[size - 1] = this.lZO - jArr3[size - 1];
        this.mfK = null;
        this.mfL = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.mfG) {
            this.mfI = j;
            kVar.fOo = this.mfH;
            this.mfG = false;
            return true;
        } else if (!this.mfD || this.mfI == -1) {
            return false;
        } else {
            kVar.fOo = this.mfI;
            this.mfI = -1L;
            return true;
        }
    }

    private long fM(long j) throws ParserException {
        if (this.mfA == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.i(j, this.mfA, 1000L);
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
        public m meW;
        public int meZ;
        public float mgA;
        public float mgB;
        public float mgC;
        public float mgD;
        public int mgE;
        public long mgF;
        public long mgG;
        public boolean mgH;
        public boolean mgI;
        public String mgi;
        public int mgj;
        public boolean mgk;
        public byte[] mgl;
        public m.a mgm;
        public byte[] mgn;
        public int mgo;
        public int mgp;
        public int mgq;
        public boolean mgr;
        public int mgs;
        public int mgt;
        public float mgu;
        public float mgv;
        public float mgw;
        public float mgx;
        public float mgy;
        public float mgz;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mgo = -1;
            this.mgp = -1;
            this.mgq = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mgr = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mgs = 1000;
            this.mgt = 200;
            this.mgu = -1.0f;
            this.mgv = -1.0f;
            this.mgw = -1.0f;
            this.mgx = -1.0f;
            this.mgy = -1.0f;
            this.mgz = -1.0f;
            this.mgA = -1.0f;
            this.mgB = -1.0f;
            this.mgC = -1.0f;
            this.mgD = -1.0f;
            this.channelCount = 1;
            this.mgE = -1;
            this.sampleRate = 8000;
            this.mgF = 0L;
            this.mgG = 0L;
            this.mgI = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mgi;
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
                    list = this.mgn == null ? null : Collections.singletonList(this.mgn);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mgn));
                    list = ag.initializationData;
                    this.meZ = ag.meZ;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mgn));
                    list = ai.initializationData;
                    this.meZ = ai.meZ;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mgn));
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
                    list = at(this.mgn);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mgn);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgF).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mgG).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mgn);
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
                    list = Collections.singletonList(this.mgn);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mgn))) {
                        i4 = v.LZ(this.mgE);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgE + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LZ(this.mgE);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mgE + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mgn);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mgn[0], this.mgn[1], this.mgn[2], this.mgn[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mgI ? 1 : 0) | (this.mgH ? 2 : 0);
            if (i.Qp(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OR(str)) {
                if (this.mgq == 0) {
                    this.mgo = this.mgo == -1 ? this.width : this.mgo;
                    this.mgp = this.mgp == -1 ? this.height : this.mgp;
                }
                float f = -1.0f;
                if (this.mgo != -1 && this.mgp != -1) {
                    f = (this.height * this.mgo) / (this.width * this.mgp);
                }
                ColorInfo colorInfo = null;
                if (this.mgr) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dvb());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.mfk);
                arrayList.add(this.mgn);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.meW = gVar.dK(this.number, i2);
            this.meW.h(a);
        }

        private byte[] dvb() {
            if (this.mgu == -1.0f || this.mgv == -1.0f || this.mgw == -1.0f || this.mgx == -1.0f || this.mgy == -1.0f || this.mgz == -1.0f || this.mgA == -1.0f || this.mgB == -1.0f || this.mgC == -1.0f || this.mgD == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mgu * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgv * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgw * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgx * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgy * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgz * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgA * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mgB * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mgC + 0.5f));
            wrap.putShort((short) (this.mgD + 0.5f));
            wrap.putShort((short) this.mgs);
            wrap.putShort((short) this.mgt);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dzA() != 826496599) {
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
                int dzx = lVar.dzx();
                if (dzx == 1) {
                    return true;
                }
                if (dzx == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.mfn.getMostSignificantBits()) {
                        if (lVar.readLong() == d.mfn.getLeastSignificantBits()) {
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
