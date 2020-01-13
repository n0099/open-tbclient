package com.google.android.exoplayer2.extractor.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.IDevices;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.location.BDLocation;
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
/* loaded from: classes5.dex */
public final class d implements com.google.android.exoplayer2.extractor.e {
    public static final h mdK = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] mek = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] mel = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] mem = v.Qn("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] men = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] meo = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID mep = new UUID(72057594037932032L, -9223371306706625679L);
    private long lYQ;
    private final l mdM;
    private g mdQ;
    private final l mdZ;
    private long meA;
    private long meB;
    private long meC;
    private long meD;
    private b meE;
    private boolean meF;
    private int meG;
    private long meH;
    private boolean meI;
    private long meJ;
    private long meK;
    private long meL;
    private com.google.android.exoplayer2.util.g meM;
    private com.google.android.exoplayer2.util.g meN;
    private boolean meO;
    private int meP;
    private long meQ;
    private long meR;
    private int meS;
    private int meT;
    private int[] meU;
    private int meV;
    private int meW;
    private int meX;
    private int meY;
    private boolean meZ;
    private final l mea;
    private final f mee;
    private final com.google.android.exoplayer2.extractor.a.b meq;
    private final SparseArray<b> mer;
    private final boolean mes;
    private final l met;
    private final l meu;
    private final l mev;
    private final l mew;
    private final l mex;
    private final l mey;
    private ByteBuffer mez;
    private boolean mfa;
    private boolean mfb;
    private boolean mfc;
    private byte mfd;
    private int mfe;
    private int mff;
    private int mfg;
    private boolean mfh;
    private boolean mfi;

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.meB = -1L;
        this.meC = -9223372036854775807L;
        this.meD = -9223372036854775807L;
        this.lYQ = -9223372036854775807L;
        this.meJ = -1L;
        this.meK = -1L;
        this.meL = -9223372036854775807L;
        this.meq = bVar;
        this.meq.a(new a());
        this.mes = (i & 1) == 0;
        this.mee = new f();
        this.mer = new SparseArray<>();
        this.mdM = new l(4);
        this.met = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.meu = new l(4);
        this.mdZ = new l(j.mGo);
        this.mea = new l(4);
        this.mev = new l();
        this.mew = new l();
        this.mex = new l(8);
        this.mey = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdQ = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.meL = -9223372036854775807L;
        this.meP = 0;
        this.meq.reset();
        this.mee.reset();
        dtH();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mfh = false;
        boolean z = true;
        while (z && !this.mfh) {
            z = this.meq.g(fVar);
            if (z && a(kVar, fVar.getPosition())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    int Jy(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
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
            case IDevices.EM_AARCH64 /* 183 */:
            case 187:
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
            case BDLocation.TypeNetWorkLocation /* 161 */:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
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

    boolean Jz(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void k(int i, long j, long j2) throws ParserException {
        switch (i) {
            case 160:
                this.mfi = false;
                return;
            case 174:
                this.meE = new b();
                return;
            case 187:
                this.meO = false;
                return;
            case 19899:
                this.meG = -1;
                this.meH = -1L;
                return;
            case 20533:
                this.meE.mfm = true;
                return;
            case 21968:
                this.meE.mft = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.meB != -1 && this.meB != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.meB = j;
                this.meA = j2;
                return;
            case 475249515:
                this.meM = new com.google.android.exoplayer2.util.g();
                this.meN = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.meF) {
                    if (this.mes && this.meJ != -1) {
                        this.meI = true;
                        return;
                    }
                    this.mdQ.a(new l.a(this.lYQ));
                    this.meF = true;
                    return;
                }
                return;
        }
    }

    void JA(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.meP == 2) {
                    if (!this.mfi) {
                        this.meX |= 1;
                    }
                    a(this.mer.get(this.meV), this.meQ);
                    this.meP = 0;
                    return;
                }
                return;
            case 174:
                if (Pf(this.meE.mfk)) {
                    this.meE.a(this.mdQ, this.meE.number);
                    this.mer.put(this.meE.number, this.meE);
                }
                this.meE = null;
                return;
            case 19899:
                if (this.meG == -1 || this.meH == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.meG == 475249515) {
                    this.meJ = this.meH;
                    return;
                }
                return;
            case 25152:
                if (this.meE.mfm) {
                    if (this.meE.mfo == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.meE.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lXs, "video/webm", this.meE.mfo.mdF));
                    return;
                }
                return;
            case 28032:
                if (this.meE.mfm && this.meE.mfn != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.meC == -9223372036854775807L) {
                    this.meC = TimeUtils.NANOS_PER_MS;
                }
                if (this.meD != -9223372036854775807L) {
                    this.lYQ = fO(this.meD);
                    return;
                }
                return;
            case 374648427:
                if (this.mer.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.mdQ.dtF();
                return;
            case 475249515:
                if (!this.meF) {
                    this.mdQ.a(dtI());
                    this.meF = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    void D(int i, long j) throws ParserException {
        switch (i) {
            case 131:
                this.meE.type = (int) j;
                return;
            case 136:
                this.meE.mfJ = j == 1;
                return;
            case 155:
                this.meR = fO(j);
                return;
            case 159:
                this.meE.channelCount = (int) j;
                return;
            case 176:
                this.meE.width = (int) j;
                return;
            case 179:
                this.meM.gI(fO(j));
                return;
            case 186:
                this.meE.height = (int) j;
                return;
            case 215:
                this.meE.number = (int) j;
                return;
            case 231:
                this.meL = fO(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.meO) {
                    this.meN.gI(j);
                    this.meO = true;
                    return;
                }
                return;
            case 251:
                this.mfi = true;
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
                this.meH = this.meB + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.meE.stereoMode = 0;
                        return;
                    case 1:
                        this.meE.stereoMode = 2;
                        return;
                    case 3:
                        this.meE.stereoMode = 1;
                        return;
                    case 15:
                        this.meE.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.meE.mfq = (int) j;
                return;
            case 21682:
                this.meE.mfs = (int) j;
                return;
            case 21690:
                this.meE.mfr = (int) j;
                return;
            case 21930:
                this.meE.mfK = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.meE.colorRange = 2;
                        return;
                    case 2:
                        this.meE.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.meE.colorTransfer = 3;
                        return;
                    case 16:
                        this.meE.colorTransfer = 6;
                        return;
                    case 18:
                        this.meE.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.meE.mft = true;
                switch ((int) j) {
                    case 1:
                        this.meE.colorSpace = 1;
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
                        this.meE.colorSpace = 2;
                        return;
                    case 9:
                        this.meE.colorSpace = 6;
                        return;
                }
            case 21948:
                this.meE.mfu = (int) j;
                return;
            case 21949:
                this.meE.mfv = (int) j;
                return;
            case 22186:
                this.meE.mfH = j;
                return;
            case 22203:
                this.meE.mfI = j;
                return;
            case 25188:
                this.meE.mfG = (int) j;
                return;
            case 2352003:
                this.meE.mfl = (int) j;
                return;
            case 2807729:
                this.meC = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case 181:
                this.meE.sampleRate = (int) d;
                return;
            case 17545:
                this.meD = (long) d;
                return;
            case 21969:
                this.meE.mfw = (float) d;
                return;
            case 21970:
                this.meE.mfx = (float) d;
                return;
            case 21971:
                this.meE.mfy = (float) d;
                return;
            case 21972:
                this.meE.mfz = (float) d;
                return;
            case 21973:
                this.meE.mfA = (float) d;
                return;
            case 21974:
                this.meE.mfB = (float) d;
                return;
            case 21975:
                this.meE.mfC = (float) d;
                return;
            case 21976:
                this.meE.mfD = (float) d;
                return;
            case 21977:
                this.meE.mfE = (float) d;
                return;
            case 21978:
                this.meE.mfF = (float) d;
                return;
            default:
                return;
        }
    }

    void bi(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.meE.mfk = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.meE.language = str;
                return;
            default:
                return;
        }
    }

    void a(int i, int i2, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i3;
        switch (i) {
            case BDLocation.TypeNetWorkLocation /* 161 */:
            case 163:
                if (this.meP == 0) {
                    this.meV = (int) this.mee.a(fVar, false, true, 8);
                    this.meW = this.mee.dtM();
                    this.meR = -9223372036854775807L;
                    this.meP = 1;
                    this.mdM.reset();
                }
                b bVar = this.mer.get(this.meV);
                if (bVar == null) {
                    fVar.Jq(i2 - this.meW);
                    this.meP = 0;
                    return;
                }
                if (this.meP == 1) {
                    d(fVar, 3);
                    int i4 = (this.mdM.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.meT = 1;
                        this.meU = c(this.meU, 1);
                        this.meU[0] = (i2 - this.meW) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.meT = (this.mdM.data[3] & 255) + 1;
                        this.meU = c(this.meU, this.meT);
                        if (i4 == 2) {
                            Arrays.fill(this.meU, 0, this.meT, ((i2 - this.meW) - 4) / this.meT);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.meT - 1; i7++) {
                                this.meU[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.mdM.data[i6 - 1] & 255;
                                    int[] iArr = this.meU;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.meU[i7];
                            }
                            this.meU[this.meT - 1] = ((i2 - this.meW) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.meT - 1; i10++) {
                                this.meU[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.mdM.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.mdM.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.mdM.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.mdM.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.meU;
                                if (i10 != 0) {
                                    i16 += this.meU[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.meU[i10];
                            }
                            this.meU[this.meT - 1] = ((i2 - this.meW) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.meQ = this.meL + fO((this.mdM.data[0] << 8) | (this.mdM.data[1] & 255));
                    this.meX = ((this.mdM.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.mdM.data[2] & 128) == 128) ? 1 : 0);
                    this.meP = 2;
                    this.meS = 0;
                }
                if (i == 163) {
                    while (this.meS < this.meT) {
                        a(fVar, bVar, this.meU[this.meS]);
                        a(bVar, this.meQ + ((this.meS * bVar.mfl) / 1000));
                        this.meS++;
                    }
                    this.meP = 0;
                    return;
                }
                a(fVar, bVar, this.meU[0]);
                return;
            case 16981:
                this.meE.mfn = new byte[i2];
                fVar.readFully(this.meE.mfn, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.meE.mfo = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.meu.data, (byte) 0);
                fVar.readFully(this.meu.data, 4 - i2, i2);
                this.meu.setPosition(0);
                this.meG = (int) this.meu.readUnsignedInt();
                return;
            case 25506:
                this.meE.mfp = new byte[i2];
                fVar.readFully(this.meE.mfp, 0, i2);
                return;
            case 30322:
                this.meE.projectionData = new byte[i2];
                fVar.readFully(this.meE.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mfk)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, mel);
        } else if ("S_TEXT/ASS".equals(bVar.mfk)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, meo);
        }
        bVar.mdY.a(j, this.meX, this.mfg, 0, bVar.mfo);
        this.mfh = true;
        dtH();
    }

    private void dtH() {
        this.meY = 0;
        this.mfg = 0;
        this.mff = 0;
        this.meZ = false;
        this.mfa = false;
        this.mfc = false;
        this.mfe = 0;
        this.mfd = (byte) 0;
        this.mfb = false;
        this.mev.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.mdM.dyg() < i) {
            if (this.mdM.capacity() < i) {
                this.mdM.G(Arrays.copyOf(this.mdM.data, Math.max(this.mdM.data.length * 2, i)), this.mdM.dyg());
            }
            fVar.readFully(this.mdM.data, this.mdM.dyg(), i - this.mdM.dyg());
            this.mdM.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mfk)) {
            a(fVar, mek, i);
        } else if ("S_TEXT/ASS".equals(bVar.mfk)) {
            a(fVar, men, i);
        } else {
            m mVar = bVar.mdY;
            if (!this.meZ) {
                if (bVar.mfm) {
                    this.meX &= -1073741825;
                    if (!this.mfa) {
                        fVar.readFully(this.mdM.data, 0, 1);
                        this.meY++;
                        if ((this.mdM.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mfd = this.mdM.data[0];
                        this.mfa = true;
                    }
                    if ((this.mfd & 1) == 1) {
                        boolean z = (this.mfd & 2) == 2;
                        this.meX |= 1073741824;
                        if (!this.mfb) {
                            fVar.readFully(this.mex.data, 0, 8);
                            this.meY += 8;
                            this.mfb = true;
                            this.mdM.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.mdM.setPosition(0);
                            mVar.a(this.mdM, 1);
                            this.mfg++;
                            this.mex.setPosition(0);
                            mVar.a(this.mex, 8);
                            this.mfg += 8;
                        }
                        if (z) {
                            if (!this.mfc) {
                                fVar.readFully(this.mdM.data, 0, 1);
                                this.meY++;
                                this.mdM.setPosition(0);
                                this.mfe = this.mdM.readUnsignedByte();
                                this.mfc = true;
                            }
                            int i2 = this.mfe * 4;
                            this.mdM.reset(i2);
                            fVar.readFully(this.mdM.data, 0, i2);
                            this.meY = i2 + this.meY;
                            short s = (short) ((this.mfe / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.mez == null || this.mez.capacity() < i3) {
                                this.mez = ByteBuffer.allocate(i3);
                            }
                            this.mez.position(0);
                            this.mez.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mfe) {
                                int dyq = this.mdM.dyq();
                                if (i4 % 2 == 0) {
                                    this.mez.putShort((short) (dyq - i5));
                                } else {
                                    this.mez.putInt(dyq - i5);
                                }
                                i4++;
                                i5 = dyq;
                            }
                            int i6 = (i - this.meY) - i5;
                            if (this.mfe % 2 == 1) {
                                this.mez.putInt(i6);
                            } else {
                                this.mez.putShort((short) i6);
                                this.mez.putInt(0);
                            }
                            this.mey.G(this.mez.array(), i3);
                            mVar.a(this.mey, i3);
                            this.mfg += i3;
                        }
                    }
                } else if (bVar.mfn != null) {
                    this.mev.G(bVar.mfn, bVar.mfn.length);
                }
                this.meZ = true;
            }
            int dyg = this.mev.dyg() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mfk) || "V_MPEGH/ISO/HEVC".equals(bVar.mfk)) {
                byte[] bArr = this.mea.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.meb;
                int i8 = 4 - bVar.meb;
                while (this.meY < dyg) {
                    if (this.mff == 0) {
                        a(fVar, bArr, i8, i7);
                        this.mea.setPosition(0);
                        this.mff = this.mea.dyq();
                        this.mdZ.setPosition(0);
                        mVar.a(this.mdZ, 4);
                        this.mfg += 4;
                    } else {
                        this.mff -= a(fVar, mVar, this.mff);
                    }
                }
            } else {
                while (this.meY < dyg) {
                    a(fVar, mVar, dyg - this.meY);
                }
            }
            if ("A_VORBIS".equals(bVar.mfk)) {
                this.met.setPosition(0);
                mVar.a(this.met, 4);
                this.mfg += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.mew.capacity() < length) {
            this.mew.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.mew.data, 0, bArr.length);
        }
        fVar.readFully(this.mew.data, bArr.length, i);
        this.mew.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.mew.data, this.meR, str, i, j, bArr);
        bVar.mdY.a(this.mew, this.mew.dyg());
        this.mfg += this.mew.dyg();
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] Qn;
        if (j == -9223372036854775807L) {
            Qn = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - ((i2 * 3600) * TimeUtils.NANOS_PER_MS);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * TimeUtils.NANOS_PER_MS);
            int i4 = (int) (j4 / TimeUtils.NANOS_PER_MS);
            Qn = v.Qn(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * TimeUtils.NANOS_PER_MS)) / j2))));
        }
        System.arraycopy(Qn, 0, bArr, i, bArr2.length);
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int min = Math.min(i2, this.mev.dyf());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.mev.C(bArr, i, min);
        }
        this.meY += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dyf = this.mev.dyf();
        if (dyf > 0) {
            a2 = Math.min(i, dyf);
            mVar.a(this.mev, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.meY += a2;
        this.mfg += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l dtI() {
        if (this.meB == -1 || this.lYQ == -9223372036854775807L || this.meM == null || this.meM.size() == 0 || this.meN == null || this.meN.size() != this.meM.size()) {
            this.meM = null;
            this.meN = null;
            return new l.a(this.lYQ);
        }
        int size = this.meM.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.meM.LO(i);
            jArr[i] = this.meB + this.meN.LO(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.meB + this.meA) - jArr[size - 1]);
        jArr2[size - 1] = this.lYQ - jArr3[size - 1];
        this.meM = null;
        this.meN = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.meI) {
            this.meK = j;
            kVar.fLD = this.meJ;
            this.meI = false;
            return true;
        } else if (!this.meF || this.meK == -1) {
            return false;
        } else {
            kVar.fLD = this.meK;
            this.meK = -1L;
            return true;
        }
    }

    private long fO(long j) throws ParserException {
        if (this.meC == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.h(j, this.meC, 1000L);
    }

    private static boolean Pf(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] c(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }

    /* loaded from: classes5.dex */
    private final class a implements c {
        private a() {
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public int Jy(int i) {
            return d.this.Jy(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public boolean Jz(int i) {
            return d.this.Jz(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void k(int i, long j, long j2) throws ParserException {
            d.this.k(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void JA(int i) throws ParserException {
            d.this.JA(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void D(int i, long j) throws ParserException {
            d.this.D(i, j);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void d(int i, double d) throws ParserException {
            d.this.d(i, d);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void bi(int i, String str) throws ParserException {
            d.this.bi(i, str);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void a(int i, int i2, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            d.this.a(i, i2, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        public int channelCount;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public DrmInitData drmInitData;
        public int height;
        private String language;
        public m mdY;
        public int meb;
        public float mfA;
        public float mfB;
        public float mfC;
        public float mfD;
        public float mfE;
        public float mfF;
        public int mfG;
        public long mfH;
        public long mfI;
        public boolean mfJ;
        public boolean mfK;
        public String mfk;
        public int mfl;
        public boolean mfm;
        public byte[] mfn;
        public m.a mfo;
        public byte[] mfp;
        public int mfq;
        public int mfr;
        public int mfs;
        public boolean mft;
        public int mfu;
        public int mfv;
        public float mfw;
        public float mfx;
        public float mfy;
        public float mfz;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mfq = -1;
            this.mfr = -1;
            this.mfs = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mft = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mfu = 1000;
            this.mfv = 200;
            this.mfw = -1.0f;
            this.mfx = -1.0f;
            this.mfy = -1.0f;
            this.mfz = -1.0f;
            this.mfA = -1.0f;
            this.mfB = -1.0f;
            this.mfC = -1.0f;
            this.mfD = -1.0f;
            this.mfE = -1.0f;
            this.mfF = -1.0f;
            this.channelCount = 1;
            this.mfG = -1;
            this.sampleRate = 8000;
            this.mfH = 0L;
            this.mfI = 0L;
            this.mfK = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mfk;
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
                        c = 26;
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
                    list = this.mfp == null ? null : Collections.singletonList(this.mfp);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mfp));
                    list = ag.initializationData;
                    this.meb = ag.meb;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mfp));
                    list = ai.initializationData;
                    this.meb = ai.meb;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mfp));
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
                    list = ao(this.mfp);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mfp);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mfH).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mfI).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mfp);
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
                    list = Collections.singletonList(this.mfp);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mfp))) {
                        i4 = v.LU(this.mfG);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mfG + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LU(this.mfG);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mfG + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mfp);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mfp[0], this.mfp[1], this.mfp[2], this.mfp[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mfK ? 1 : 0) | (this.mfJ ? 2 : 0);
            if (i.Qb(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OD(str)) {
                if (this.mfs == 0) {
                    this.mfq = this.mfq == -1 ? this.width : this.mfq;
                    this.mfr = this.mfr == -1 ? this.height : this.mfr;
                }
                float f = -1.0f;
                if (this.mfq != -1 && this.mfr != -1) {
                    f = (this.height * this.mfq) / (this.width * this.mfr);
                }
                ColorInfo colorInfo = null;
                if (this.mft) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dtL());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.mem);
                arrayList.add(this.mfp);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.mdY = gVar.dH(this.number, i2);
            this.mdY.h(a);
        }

        private byte[] dtL() {
            if (this.mfw == -1.0f || this.mfx == -1.0f || this.mfy == -1.0f || this.mfz == -1.0f || this.mfA == -1.0f || this.mfB == -1.0f || this.mfC == -1.0f || this.mfD == -1.0f || this.mfE == -1.0f || this.mfF == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mfw * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfx * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfy * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfz * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfA * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfB * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfC * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfD * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mfE + 0.5f));
            wrap.putShort((short) (this.mfF + 0.5f));
            wrap.putShort((short) this.mfu);
            wrap.putShort((short) this.mfv);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dyl() != 826496599) {
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

        private static List<byte[]> ao(byte[] bArr) throws ParserException {
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
                int dyi = lVar.dyi();
                if (dyi == 1) {
                    return true;
                }
                if (dyi == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.mep.getMostSignificantBits()) {
                        if (lVar.readLong() == d.mep.getLeastSignificantBits()) {
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
