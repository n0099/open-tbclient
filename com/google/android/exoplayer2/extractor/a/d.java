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
    public static final h mdP = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] mep = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] meq = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] mer = v.Qn("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] mes = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] met = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID meu = new UUID(72057594037932032L, -9223371306706625679L);
    private long lYV;
    private final l mdR;
    private g mdV;
    private final l meA;
    private final l meB;
    private final l meC;
    private final l meD;
    private ByteBuffer meE;
    private long meF;
    private long meG;
    private long meH;
    private long meI;
    private b meJ;
    private boolean meK;
    private int meL;
    private long meM;
    private boolean meN;
    private long meO;
    private long meP;
    private long meQ;
    private com.google.android.exoplayer2.util.g meR;
    private com.google.android.exoplayer2.util.g meS;
    private boolean meT;
    private int meU;
    private long meV;
    private long meW;
    private int meX;
    private int meY;
    private int[] meZ;
    private final l mee;
    private final l mef;
    private final f mej;
    private final com.google.android.exoplayer2.extractor.a.b mev;
    private final SparseArray<b> mew;
    private final boolean mex;
    private final l mey;
    private final l mez;
    private int mfa;
    private int mfb;
    private int mfc;
    private int mfd;
    private boolean mfe;
    private boolean mff;
    private boolean mfg;
    private boolean mfh;
    private byte mfi;
    private int mfj;
    private int mfk;
    private int mfl;
    private boolean mfm;
    private boolean mfn;

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.meG = -1L;
        this.meH = -9223372036854775807L;
        this.meI = -9223372036854775807L;
        this.lYV = -9223372036854775807L;
        this.meO = -1L;
        this.meP = -1L;
        this.meQ = -9223372036854775807L;
        this.mev = bVar;
        this.mev.a(new a());
        this.mex = (i & 1) == 0;
        this.mej = new f();
        this.mew = new SparseArray<>();
        this.mdR = new l(4);
        this.mey = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.mez = new l(4);
        this.mee = new l(j.mGt);
        this.mef = new l(4);
        this.meA = new l();
        this.meB = new l();
        this.meC = new l(8);
        this.meD = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdV = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.meQ = -9223372036854775807L;
        this.meU = 0;
        this.mev.reset();
        this.mej.reset();
        dtJ();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mfm = false;
        boolean z = true;
        while (z && !this.mfm) {
            z = this.mev.g(fVar);
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
                this.mfn = false;
                return;
            case 174:
                this.meJ = new b();
                return;
            case 187:
                this.meT = false;
                return;
            case 19899:
                this.meL = -1;
                this.meM = -1L;
                return;
            case 20533:
                this.meJ.mfr = true;
                return;
            case 21968:
                this.meJ.mfy = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.meG != -1 && this.meG != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.meG = j;
                this.meF = j2;
                return;
            case 475249515:
                this.meR = new com.google.android.exoplayer2.util.g();
                this.meS = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.meK) {
                    if (this.mex && this.meO != -1) {
                        this.meN = true;
                        return;
                    }
                    this.mdV.a(new l.a(this.lYV));
                    this.meK = true;
                    return;
                }
                return;
        }
    }

    void JA(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.meU == 2) {
                    if (!this.mfn) {
                        this.mfc |= 1;
                    }
                    a(this.mew.get(this.mfa), this.meV);
                    this.meU = 0;
                    return;
                }
                return;
            case 174:
                if (Pf(this.meJ.mfp)) {
                    this.meJ.a(this.mdV, this.meJ.number);
                    this.mew.put(this.meJ.number, this.meJ);
                }
                this.meJ = null;
                return;
            case 19899:
                if (this.meL == -1 || this.meM == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.meL == 475249515) {
                    this.meO = this.meM;
                    return;
                }
                return;
            case 25152:
                if (this.meJ.mfr) {
                    if (this.meJ.mft == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.meJ.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lXx, "video/webm", this.meJ.mft.mdK));
                    return;
                }
                return;
            case 28032:
                if (this.meJ.mfr && this.meJ.mfs != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.meH == -9223372036854775807L) {
                    this.meH = TimeUtils.NANOS_PER_MS;
                }
                if (this.meI != -9223372036854775807L) {
                    this.lYV = fO(this.meI);
                    return;
                }
                return;
            case 374648427:
                if (this.mew.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.mdV.dtH();
                return;
            case 475249515:
                if (!this.meK) {
                    this.mdV.a(dtK());
                    this.meK = true;
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
                this.meJ.type = (int) j;
                return;
            case 136:
                this.meJ.mfO = j == 1;
                return;
            case 155:
                this.meW = fO(j);
                return;
            case 159:
                this.meJ.channelCount = (int) j;
                return;
            case 176:
                this.meJ.width = (int) j;
                return;
            case 179:
                this.meR.gI(fO(j));
                return;
            case 186:
                this.meJ.height = (int) j;
                return;
            case 215:
                this.meJ.number = (int) j;
                return;
            case 231:
                this.meQ = fO(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.meT) {
                    this.meS.gI(j);
                    this.meT = true;
                    return;
                }
                return;
            case 251:
                this.mfn = true;
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
                this.meM = this.meG + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.meJ.stereoMode = 0;
                        return;
                    case 1:
                        this.meJ.stereoMode = 2;
                        return;
                    case 3:
                        this.meJ.stereoMode = 1;
                        return;
                    case 15:
                        this.meJ.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.meJ.mfv = (int) j;
                return;
            case 21682:
                this.meJ.mfx = (int) j;
                return;
            case 21690:
                this.meJ.mfw = (int) j;
                return;
            case 21930:
                this.meJ.mfP = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.meJ.colorRange = 2;
                        return;
                    case 2:
                        this.meJ.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.meJ.colorTransfer = 3;
                        return;
                    case 16:
                        this.meJ.colorTransfer = 6;
                        return;
                    case 18:
                        this.meJ.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.meJ.mfy = true;
                switch ((int) j) {
                    case 1:
                        this.meJ.colorSpace = 1;
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
                        this.meJ.colorSpace = 2;
                        return;
                    case 9:
                        this.meJ.colorSpace = 6;
                        return;
                }
            case 21948:
                this.meJ.mfz = (int) j;
                return;
            case 21949:
                this.meJ.mfA = (int) j;
                return;
            case 22186:
                this.meJ.mfM = j;
                return;
            case 22203:
                this.meJ.mfN = j;
                return;
            case 25188:
                this.meJ.mfL = (int) j;
                return;
            case 2352003:
                this.meJ.mfq = (int) j;
                return;
            case 2807729:
                this.meH = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case 181:
                this.meJ.sampleRate = (int) d;
                return;
            case 17545:
                this.meI = (long) d;
                return;
            case 21969:
                this.meJ.mfB = (float) d;
                return;
            case 21970:
                this.meJ.mfC = (float) d;
                return;
            case 21971:
                this.meJ.mfD = (float) d;
                return;
            case 21972:
                this.meJ.mfE = (float) d;
                return;
            case 21973:
                this.meJ.mfF = (float) d;
                return;
            case 21974:
                this.meJ.mfG = (float) d;
                return;
            case 21975:
                this.meJ.mfH = (float) d;
                return;
            case 21976:
                this.meJ.mfI = (float) d;
                return;
            case 21977:
                this.meJ.mfJ = (float) d;
                return;
            case 21978:
                this.meJ.mfK = (float) d;
                return;
            default:
                return;
        }
    }

    void bi(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.meJ.mfp = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.meJ.language = str;
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
                if (this.meU == 0) {
                    this.mfa = (int) this.mej.a(fVar, false, true, 8);
                    this.mfb = this.mej.dtO();
                    this.meW = -9223372036854775807L;
                    this.meU = 1;
                    this.mdR.reset();
                }
                b bVar = this.mew.get(this.mfa);
                if (bVar == null) {
                    fVar.Jq(i2 - this.mfb);
                    this.meU = 0;
                    return;
                }
                if (this.meU == 1) {
                    d(fVar, 3);
                    int i4 = (this.mdR.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.meY = 1;
                        this.meZ = c(this.meZ, 1);
                        this.meZ[0] = (i2 - this.mfb) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.meY = (this.mdR.data[3] & 255) + 1;
                        this.meZ = c(this.meZ, this.meY);
                        if (i4 == 2) {
                            Arrays.fill(this.meZ, 0, this.meY, ((i2 - this.mfb) - 4) / this.meY);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.meY - 1; i7++) {
                                this.meZ[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.mdR.data[i6 - 1] & 255;
                                    int[] iArr = this.meZ;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.meZ[i7];
                            }
                            this.meZ[this.meY - 1] = ((i2 - this.mfb) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.meY - 1; i10++) {
                                this.meZ[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.mdR.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.mdR.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.mdR.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.mdR.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.meZ;
                                if (i10 != 0) {
                                    i16 += this.meZ[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.meZ[i10];
                            }
                            this.meZ[this.meY - 1] = ((i2 - this.mfb) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.meV = this.meQ + fO((this.mdR.data[0] << 8) | (this.mdR.data[1] & 255));
                    this.mfc = ((this.mdR.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.mdR.data[2] & 128) == 128) ? 1 : 0);
                    this.meU = 2;
                    this.meX = 0;
                }
                if (i == 163) {
                    while (this.meX < this.meY) {
                        a(fVar, bVar, this.meZ[this.meX]);
                        a(bVar, this.meV + ((this.meX * bVar.mfq) / 1000));
                        this.meX++;
                    }
                    this.meU = 0;
                    return;
                }
                a(fVar, bVar, this.meZ[0]);
                return;
            case 16981:
                this.meJ.mfs = new byte[i2];
                fVar.readFully(this.meJ.mfs, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.meJ.mft = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.mez.data, (byte) 0);
                fVar.readFully(this.mez.data, 4 - i2, i2);
                this.mez.setPosition(0);
                this.meL = (int) this.mez.readUnsignedInt();
                return;
            case 25506:
                this.meJ.mfu = new byte[i2];
                fVar.readFully(this.meJ.mfu, 0, i2);
                return;
            case 30322:
                this.meJ.projectionData = new byte[i2];
                fVar.readFully(this.meJ.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mfp)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, meq);
        } else if ("S_TEXT/ASS".equals(bVar.mfp)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, met);
        }
        bVar.med.a(j, this.mfc, this.mfl, 0, bVar.mft);
        this.mfm = true;
        dtJ();
    }

    private void dtJ() {
        this.mfd = 0;
        this.mfl = 0;
        this.mfk = 0;
        this.mfe = false;
        this.mff = false;
        this.mfh = false;
        this.mfj = 0;
        this.mfi = (byte) 0;
        this.mfg = false;
        this.meA.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.mdR.dyi() < i) {
            if (this.mdR.capacity() < i) {
                this.mdR.G(Arrays.copyOf(this.mdR.data, Math.max(this.mdR.data.length * 2, i)), this.mdR.dyi());
            }
            fVar.readFully(this.mdR.data, this.mdR.dyi(), i - this.mdR.dyi());
            this.mdR.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mfp)) {
            a(fVar, mep, i);
        } else if ("S_TEXT/ASS".equals(bVar.mfp)) {
            a(fVar, mes, i);
        } else {
            m mVar = bVar.med;
            if (!this.mfe) {
                if (bVar.mfr) {
                    this.mfc &= -1073741825;
                    if (!this.mff) {
                        fVar.readFully(this.mdR.data, 0, 1);
                        this.mfd++;
                        if ((this.mdR.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mfi = this.mdR.data[0];
                        this.mff = true;
                    }
                    if ((this.mfi & 1) == 1) {
                        boolean z = (this.mfi & 2) == 2;
                        this.mfc |= 1073741824;
                        if (!this.mfg) {
                            fVar.readFully(this.meC.data, 0, 8);
                            this.mfd += 8;
                            this.mfg = true;
                            this.mdR.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.mdR.setPosition(0);
                            mVar.a(this.mdR, 1);
                            this.mfl++;
                            this.meC.setPosition(0);
                            mVar.a(this.meC, 8);
                            this.mfl += 8;
                        }
                        if (z) {
                            if (!this.mfh) {
                                fVar.readFully(this.mdR.data, 0, 1);
                                this.mfd++;
                                this.mdR.setPosition(0);
                                this.mfj = this.mdR.readUnsignedByte();
                                this.mfh = true;
                            }
                            int i2 = this.mfj * 4;
                            this.mdR.reset(i2);
                            fVar.readFully(this.mdR.data, 0, i2);
                            this.mfd = i2 + this.mfd;
                            short s = (short) ((this.mfj / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.meE == null || this.meE.capacity() < i3) {
                                this.meE = ByteBuffer.allocate(i3);
                            }
                            this.meE.position(0);
                            this.meE.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mfj) {
                                int dys = this.mdR.dys();
                                if (i4 % 2 == 0) {
                                    this.meE.putShort((short) (dys - i5));
                                } else {
                                    this.meE.putInt(dys - i5);
                                }
                                i4++;
                                i5 = dys;
                            }
                            int i6 = (i - this.mfd) - i5;
                            if (this.mfj % 2 == 1) {
                                this.meE.putInt(i6);
                            } else {
                                this.meE.putShort((short) i6);
                                this.meE.putInt(0);
                            }
                            this.meD.G(this.meE.array(), i3);
                            mVar.a(this.meD, i3);
                            this.mfl += i3;
                        }
                    }
                } else if (bVar.mfs != null) {
                    this.meA.G(bVar.mfs, bVar.mfs.length);
                }
                this.mfe = true;
            }
            int dyi = this.meA.dyi() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mfp) || "V_MPEGH/ISO/HEVC".equals(bVar.mfp)) {
                byte[] bArr = this.mef.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.meg;
                int i8 = 4 - bVar.meg;
                while (this.mfd < dyi) {
                    if (this.mfk == 0) {
                        a(fVar, bArr, i8, i7);
                        this.mef.setPosition(0);
                        this.mfk = this.mef.dys();
                        this.mee.setPosition(0);
                        mVar.a(this.mee, 4);
                        this.mfl += 4;
                    } else {
                        this.mfk -= a(fVar, mVar, this.mfk);
                    }
                }
            } else {
                while (this.mfd < dyi) {
                    a(fVar, mVar, dyi - this.mfd);
                }
            }
            if ("A_VORBIS".equals(bVar.mfp)) {
                this.mey.setPosition(0);
                mVar.a(this.mey, 4);
                this.mfl += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.meB.capacity() < length) {
            this.meB.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.meB.data, 0, bArr.length);
        }
        fVar.readFully(this.meB.data, bArr.length, i);
        this.meB.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.meB.data, this.meW, str, i, j, bArr);
        bVar.med.a(this.meB, this.meB.dyi());
        this.mfl += this.meB.dyi();
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
        int min = Math.min(i2, this.meA.dyh());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.meA.C(bArr, i, min);
        }
        this.mfd += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dyh = this.meA.dyh();
        if (dyh > 0) {
            a2 = Math.min(i, dyh);
            mVar.a(this.meA, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mfd += a2;
        this.mfl += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l dtK() {
        if (this.meG == -1 || this.lYV == -9223372036854775807L || this.meR == null || this.meR.size() == 0 || this.meS == null || this.meS.size() != this.meR.size()) {
            this.meR = null;
            this.meS = null;
            return new l.a(this.lYV);
        }
        int size = this.meR.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.meR.LO(i);
            jArr[i] = this.meG + this.meS.LO(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.meG + this.meF) - jArr[size - 1]);
        jArr2[size - 1] = this.lYV - jArr3[size - 1];
        this.meR = null;
        this.meS = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.meN) {
            this.meP = j;
            kVar.fLD = this.meO;
            this.meN = false;
            return true;
        } else if (!this.meK || this.meP == -1) {
            return false;
        } else {
            kVar.fLD = this.meP;
            this.meP = -1L;
            return true;
        }
    }

    private long fO(long j) throws ParserException {
        if (this.meH == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.h(j, this.meH, 1000L);
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
        public m med;
        public int meg;
        public int mfA;
        public float mfB;
        public float mfC;
        public float mfD;
        public float mfE;
        public float mfF;
        public float mfG;
        public float mfH;
        public float mfI;
        public float mfJ;
        public float mfK;
        public int mfL;
        public long mfM;
        public long mfN;
        public boolean mfO;
        public boolean mfP;
        public String mfp;
        public int mfq;
        public boolean mfr;
        public byte[] mfs;
        public m.a mft;
        public byte[] mfu;
        public int mfv;
        public int mfw;
        public int mfx;
        public boolean mfy;
        public int mfz;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mfv = -1;
            this.mfw = -1;
            this.mfx = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mfy = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mfz = 1000;
            this.mfA = 200;
            this.mfB = -1.0f;
            this.mfC = -1.0f;
            this.mfD = -1.0f;
            this.mfE = -1.0f;
            this.mfF = -1.0f;
            this.mfG = -1.0f;
            this.mfH = -1.0f;
            this.mfI = -1.0f;
            this.mfJ = -1.0f;
            this.mfK = -1.0f;
            this.channelCount = 1;
            this.mfL = -1;
            this.sampleRate = 8000;
            this.mfM = 0L;
            this.mfN = 0L;
            this.mfP = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mfp;
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
                    list = this.mfu == null ? null : Collections.singletonList(this.mfu);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mfu));
                    list = ag.initializationData;
                    this.meg = ag.meg;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mfu));
                    list = ai.initializationData;
                    this.meg = ai.meg;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mfu));
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
                    list = ao(this.mfu);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mfu);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mfM).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mfN).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mfu);
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
                    list = Collections.singletonList(this.mfu);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mfu))) {
                        i4 = v.LU(this.mfL);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mfL + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LU(this.mfL);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mfL + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mfu);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mfu[0], this.mfu[1], this.mfu[2], this.mfu[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mfP ? 1 : 0) | (this.mfO ? 2 : 0);
            if (i.Qb(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.OD(str)) {
                if (this.mfx == 0) {
                    this.mfv = this.mfv == -1 ? this.width : this.mfv;
                    this.mfw = this.mfw == -1 ? this.height : this.mfw;
                }
                float f = -1.0f;
                if (this.mfv != -1 && this.mfw != -1) {
                    f = (this.height * this.mfv) / (this.width * this.mfw);
                }
                ColorInfo colorInfo = null;
                if (this.mfy) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dtN());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.mer);
                arrayList.add(this.mfu);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.med = gVar.dH(this.number, i2);
            this.med.h(a);
        }

        private byte[] dtN() {
            if (this.mfB == -1.0f || this.mfC == -1.0f || this.mfD == -1.0f || this.mfE == -1.0f || this.mfF == -1.0f || this.mfG == -1.0f || this.mfH == -1.0f || this.mfI == -1.0f || this.mfJ == -1.0f || this.mfK == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mfB * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfC * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfD * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfE * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfF * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfG * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfH * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mfI * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mfJ + 0.5f));
            wrap.putShort((short) (this.mfK + 0.5f));
            wrap.putShort((short) this.mfz);
            wrap.putShort((short) this.mfA);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dyn() != 826496599) {
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
                int dyk = lVar.dyk();
                if (dyk == 1) {
                    return true;
                }
                if (dyk == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.meu.getMostSignificantBits()) {
                        if (lVar.readLong() == d.meu.getLeastSignificantBits()) {
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
