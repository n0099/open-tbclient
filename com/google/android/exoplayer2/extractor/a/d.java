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
/* loaded from: classes4.dex */
public final class d implements com.google.android.exoplayer2.extractor.e {
    private long lUZ;
    private final l lZU;
    private g lZY;
    private final com.google.android.exoplayer2.extractor.a.b maB;
    private final SparseArray<b> maC;
    private final boolean maD;
    private final l maE;
    private final l maF;
    private final l maG;
    private final l maH;
    private final l maI;
    private final l maJ;
    private ByteBuffer maK;
    private long maL;
    private long maM;
    private long maN;
    private long maO;
    private b maP;
    private boolean maQ;
    private int maR;
    private long maS;
    private boolean maT;
    private long maU;
    private long maV;
    private long maW;
    private com.google.android.exoplayer2.util.g maX;
    private com.google.android.exoplayer2.util.g maY;
    private boolean maZ;
    private final l mai;
    private final l maj;
    private final f man;
    private int mba;
    private long mbb;
    private long mbc;
    private int mbd;
    private int mbe;
    private int[] mbf;
    private int mbg;
    private int mbh;
    private int mbi;
    private int mbj;
    private boolean mbk;
    private boolean mbl;
    private boolean mbm;
    private boolean mbn;
    private byte mbo;
    private int mbp;
    private int mbq;
    private int mbr;
    private boolean mbs;
    private boolean mbt;
    public static final h lZS = new h() { // from class: com.google.android.exoplayer2.extractor.a.d.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new d()};
        }
    };
    private static final byte[] mau = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] mav = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] maw = v.Qc("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] may = {68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] maz = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID maA = new UUID(72057594037932032L, -9223371306706625679L);

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.google.android.exoplayer2.extractor.a.a(), i);
    }

    d(com.google.android.exoplayer2.extractor.a.b bVar, int i) {
        this.maM = -1L;
        this.maN = -9223372036854775807L;
        this.maO = -9223372036854775807L;
        this.lUZ = -9223372036854775807L;
        this.maU = -1L;
        this.maV = -1L;
        this.maW = -9223372036854775807L;
        this.maB = bVar;
        this.maB.a(new a());
        this.maD = (i & 1) == 0;
        this.man = new f();
        this.maC = new SparseArray<>();
        this.lZU = new l(4);
        this.maE = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.maF = new l(4);
        this.mai = new l(j.mCx);
        this.maj = new l(4);
        this.maG = new l();
        this.maH = new l();
        this.maI = new l(8);
        this.maJ = new l();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.lZY = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.maW = -9223372036854775807L;
        this.mba = 0;
        this.maB.reset();
        this.man.reset();
        dsv();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, k kVar) throws IOException, InterruptedException {
        this.mbs = false;
        boolean z = true;
        while (z && !this.mbs) {
            z = this.maB.g(fVar);
            if (z && a(kVar, fVar.getPosition())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    int Jp(int i) {
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

    boolean Jq(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void k(int i, long j, long j2) throws ParserException {
        switch (i) {
            case 160:
                this.mbt = false;
                return;
            case 174:
                this.maP = new b();
                return;
            case 187:
                this.maZ = false;
                return;
            case 19899:
                this.maR = -1;
                this.maS = -1L;
                return;
            case 20533:
                this.maP.mbx = true;
                return;
            case 21968:
                this.maP.mbE = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.maM != -1 && this.maM != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.maM = j;
                this.maL = j2;
                return;
            case 475249515:
                this.maX = new com.google.android.exoplayer2.util.g();
                this.maY = new com.google.android.exoplayer2.util.g();
                return;
            case 524531317:
                if (!this.maQ) {
                    if (this.maD && this.maU != -1) {
                        this.maT = true;
                        return;
                    }
                    this.lZY.a(new l.a(this.lUZ));
                    this.maQ = true;
                    return;
                }
                return;
        }
    }

    void Jr(int i) throws ParserException {
        switch (i) {
            case 160:
                if (this.mba == 2) {
                    if (!this.mbt) {
                        this.mbi |= 1;
                    }
                    a(this.maC.get(this.mbg), this.mbb);
                    this.mba = 0;
                    return;
                }
                return;
            case 174:
                if (OU(this.maP.mbv)) {
                    this.maP.a(this.lZY, this.maP.number);
                    this.maC.put(this.maP.number, this.maP);
                }
                this.maP = null;
                return;
            case 19899:
                if (this.maR == -1 || this.maS == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if (this.maR == 475249515) {
                    this.maU = this.maS;
                    return;
                }
                return;
            case 25152:
                if (this.maP.mbx) {
                    if (this.maP.mbz == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    this.maP.drmInitData = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lTB, "video/webm", this.maP.mbz.lZN));
                    return;
                }
                return;
            case 28032:
                if (this.maP.mbx && this.maP.mby != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.maN == -9223372036854775807L) {
                    this.maN = TimeUtils.NANOS_PER_MS;
                }
                if (this.maO != -9223372036854775807L) {
                    this.lUZ = fJ(this.maO);
                    return;
                }
                return;
            case 374648427:
                if (this.maC.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.lZY.dst();
                return;
            case 475249515:
                if (!this.maQ) {
                    this.lZY.a(dsw());
                    this.maQ = true;
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
                this.maP.type = (int) j;
                return;
            case 136:
                this.maP.mbU = j == 1;
                return;
            case 155:
                this.mbc = fJ(j);
                return;
            case 159:
                this.maP.channelCount = (int) j;
                return;
            case 176:
                this.maP.width = (int) j;
                return;
            case 179:
                this.maX.gD(fJ(j));
                return;
            case 186:
                this.maP.height = (int) j;
                return;
            case 215:
                this.maP.number = (int) j;
                return;
            case 231:
                this.maW = fJ(j);
                return;
            case BaseActivity.DIALOG_PROMPT /* 241 */:
                if (!this.maZ) {
                    this.maY.gD(j);
                    this.maZ = true;
                    return;
                }
                return;
            case 251:
                this.mbt = true;
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
                this.maS = this.maM + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.maP.stereoMode = 0;
                        return;
                    case 1:
                        this.maP.stereoMode = 2;
                        return;
                    case 3:
                        this.maP.stereoMode = 1;
                        return;
                    case 15:
                        this.maP.stereoMode = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.maP.mbB = (int) j;
                return;
            case 21682:
                this.maP.mbD = (int) j;
                return;
            case 21690:
                this.maP.mbC = (int) j;
                return;
            case 21930:
                this.maP.mbV = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.maP.colorRange = 2;
                        return;
                    case 2:
                        this.maP.colorRange = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j) {
                    case 1:
                    case 6:
                    case 7:
                        this.maP.colorTransfer = 3;
                        return;
                    case 16:
                        this.maP.colorTransfer = 6;
                        return;
                    case 18:
                        this.maP.colorTransfer = 7;
                        return;
                    default:
                        return;
                }
            case 21947:
                this.maP.mbE = true;
                switch ((int) j) {
                    case 1:
                        this.maP.colorSpace = 1;
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
                        this.maP.colorSpace = 2;
                        return;
                    case 9:
                        this.maP.colorSpace = 6;
                        return;
                }
            case 21948:
                this.maP.mbF = (int) j;
                return;
            case 21949:
                this.maP.mbG = (int) j;
                return;
            case 22186:
                this.maP.mbS = j;
                return;
            case 22203:
                this.maP.mbT = j;
                return;
            case 25188:
                this.maP.mbR = (int) j;
                return;
            case 2352003:
                this.maP.mbw = (int) j;
                return;
            case 2807729:
                this.maN = j;
                return;
            default:
                return;
        }
    }

    void d(int i, double d) {
        switch (i) {
            case 181:
                this.maP.sampleRate = (int) d;
                return;
            case 17545:
                this.maO = (long) d;
                return;
            case 21969:
                this.maP.mbH = (float) d;
                return;
            case 21970:
                this.maP.mbI = (float) d;
                return;
            case 21971:
                this.maP.mbJ = (float) d;
                return;
            case 21972:
                this.maP.mbK = (float) d;
                return;
            case 21973:
                this.maP.mbL = (float) d;
                return;
            case 21974:
                this.maP.mbM = (float) d;
                return;
            case 21975:
                this.maP.mbN = (float) d;
                return;
            case 21976:
                this.maP.mbO = (float) d;
                return;
            case 21977:
                this.maP.mbP = (float) d;
                return;
            case 21978:
                this.maP.mbQ = (float) d;
                return;
            default:
                return;
        }
    }

    void bc(int i, String str) throws ParserException {
        switch (i) {
            case 134:
                this.maP.mbv = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.maP.language = str;
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
                if (this.mba == 0) {
                    this.mbg = (int) this.man.a(fVar, false, true, 8);
                    this.mbh = this.man.dsA();
                    this.mbc = -9223372036854775807L;
                    this.mba = 1;
                    this.lZU.reset();
                }
                b bVar = this.maC.get(this.mbg);
                if (bVar == null) {
                    fVar.Jh(i2 - this.mbh);
                    this.mba = 0;
                    return;
                }
                if (this.mba == 1) {
                    d(fVar, 3);
                    int i4 = (this.lZU.data[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.mbe = 1;
                        this.mbf = c(this.mbf, 1);
                        this.mbf[0] = (i2 - this.mbh) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        d(fVar, 4);
                        this.mbe = (this.lZU.data[3] & 255) + 1;
                        this.mbf = c(this.mbf, this.mbe);
                        if (i4 == 2) {
                            Arrays.fill(this.mbf, 0, this.mbe, ((i2 - this.mbh) - 4) / this.mbe);
                        } else if (i4 == 1) {
                            int i5 = 0;
                            int i6 = 4;
                            for (int i7 = 0; i7 < this.mbe - 1; i7++) {
                                this.mbf[i7] = 0;
                                do {
                                    i6++;
                                    d(fVar, i6);
                                    i3 = this.lZU.data[i6 - 1] & 255;
                                    int[] iArr = this.mbf;
                                    iArr[i7] = iArr[i7] + i3;
                                } while (i3 == 255);
                                i5 += this.mbf[i7];
                            }
                            this.mbf[this.mbe - 1] = ((i2 - this.mbh) - i6) - i5;
                        } else if (i4 == 3) {
                            int i8 = 0;
                            int i9 = 4;
                            for (int i10 = 0; i10 < this.mbe - 1; i10++) {
                                this.mbf[i10] = 0;
                                i9++;
                                d(fVar, i9);
                                if (this.lZU.data[i9 - 1] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 < 8) {
                                        int i13 = 1 << (7 - i12);
                                        if ((this.lZU.data[i9 - 1] & i13) == 0) {
                                            i11 = i12 + 1;
                                        } else {
                                            int i14 = i9 - 1;
                                            i9 += i12;
                                            d(fVar, i9);
                                            j = this.lZU.data[i14] & 255 & (i13 ^ (-1));
                                            for (int i15 = i14 + 1; i15 < i9; i15++) {
                                                j = (this.lZU.data[i15] & 255) | (j << 8);
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
                                int[] iArr2 = this.mbf;
                                if (i10 != 0) {
                                    i16 += this.mbf[i10 - 1];
                                }
                                iArr2[i10] = i16;
                                i8 += this.mbf[i10];
                            }
                            this.mbf[this.mbe - 1] = ((i2 - this.mbh) - i9) - i8;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.mbb = this.maW + fJ((this.lZU.data[0] << 8) | (this.lZU.data[1] & 255));
                    this.mbi = ((this.lZU.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | (bVar.type == 2 || (i == 163 && (this.lZU.data[2] & 128) == 128) ? 1 : 0);
                    this.mba = 2;
                    this.mbd = 0;
                }
                if (i == 163) {
                    while (this.mbd < this.mbe) {
                        a(fVar, bVar, this.mbf[this.mbd]);
                        a(bVar, this.mbb + ((this.mbd * bVar.mbw) / 1000));
                        this.mbd++;
                    }
                    this.mba = 0;
                    return;
                }
                a(fVar, bVar, this.mbf[0]);
                return;
            case 16981:
                this.maP.mby = new byte[i2];
                fVar.readFully(this.maP.mby, 0, i2);
                return;
            case 18402:
                byte[] bArr = new byte[i2];
                fVar.readFully(bArr, 0, i2);
                this.maP.mbz = new m.a(1, bArr, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.maF.data, (byte) 0);
                fVar.readFully(this.maF.data, 4 - i2, i2);
                this.maF.setPosition(0);
                this.maR = (int) this.maF.readUnsignedInt();
                return;
            case 25506:
                this.maP.mbA = new byte[i2];
                fVar.readFully(this.maP.mbA, 0, i2);
                return;
            case 30322:
                this.maP.projectionData = new byte[i2];
                fVar.readFully(this.maP.projectionData, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void a(b bVar, long j) {
        if ("S_TEXT/UTF8".equals(bVar.mbv)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, mav);
        } else if ("S_TEXT/ASS".equals(bVar.mbv)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, maz);
        }
        bVar.mah.a(j, this.mbi, this.mbr, 0, bVar.mbz);
        this.mbs = true;
        dsv();
    }

    private void dsv() {
        this.mbj = 0;
        this.mbr = 0;
        this.mbq = 0;
        this.mbk = false;
        this.mbl = false;
        this.mbn = false;
        this.mbp = 0;
        this.mbo = (byte) 0;
        this.mbm = false;
        this.maG.reset();
    }

    private void d(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (this.lZU.dwW() < i) {
            if (this.lZU.capacity() < i) {
                this.lZU.G(Arrays.copyOf(this.lZU.data, Math.max(this.lZU.data.length * 2, i)), this.lZU.dwW());
            }
            fVar.readFully(this.lZU.data, this.lZU.dwW(), i - this.lZU.dwW());
            this.lZU.setLimit(i);
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, b bVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(bVar.mbv)) {
            a(fVar, mau, i);
        } else if ("S_TEXT/ASS".equals(bVar.mbv)) {
            a(fVar, may, i);
        } else {
            m mVar = bVar.mah;
            if (!this.mbk) {
                if (bVar.mbx) {
                    this.mbi &= -1073741825;
                    if (!this.mbl) {
                        fVar.readFully(this.lZU.data, 0, 1);
                        this.mbj++;
                        if ((this.lZU.data[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.mbo = this.lZU.data[0];
                        this.mbl = true;
                    }
                    if ((this.mbo & 1) == 1) {
                        boolean z = (this.mbo & 2) == 2;
                        this.mbi |= 1073741824;
                        if (!this.mbm) {
                            fVar.readFully(this.maI.data, 0, 8);
                            this.mbj += 8;
                            this.mbm = true;
                            this.lZU.data[0] = (byte) ((z ? 128 : 0) | 8);
                            this.lZU.setPosition(0);
                            mVar.a(this.lZU, 1);
                            this.mbr++;
                            this.maI.setPosition(0);
                            mVar.a(this.maI, 8);
                            this.mbr += 8;
                        }
                        if (z) {
                            if (!this.mbn) {
                                fVar.readFully(this.lZU.data, 0, 1);
                                this.mbj++;
                                this.lZU.setPosition(0);
                                this.mbp = this.lZU.readUnsignedByte();
                                this.mbn = true;
                            }
                            int i2 = this.mbp * 4;
                            this.lZU.reset(i2);
                            fVar.readFully(this.lZU.data, 0, i2);
                            this.mbj = i2 + this.mbj;
                            short s = (short) ((this.mbp / 2) + 1);
                            int i3 = (s * 6) + 2;
                            if (this.maK == null || this.maK.capacity() < i3) {
                                this.maK = ByteBuffer.allocate(i3);
                            }
                            this.maK.position(0);
                            this.maK.putShort(s);
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < this.mbp) {
                                int dxg = this.lZU.dxg();
                                if (i4 % 2 == 0) {
                                    this.maK.putShort((short) (dxg - i5));
                                } else {
                                    this.maK.putInt(dxg - i5);
                                }
                                i4++;
                                i5 = dxg;
                            }
                            int i6 = (i - this.mbj) - i5;
                            if (this.mbp % 2 == 1) {
                                this.maK.putInt(i6);
                            } else {
                                this.maK.putShort((short) i6);
                                this.maK.putInt(0);
                            }
                            this.maJ.G(this.maK.array(), i3);
                            mVar.a(this.maJ, i3);
                            this.mbr += i3;
                        }
                    }
                } else if (bVar.mby != null) {
                    this.maG.G(bVar.mby, bVar.mby.length);
                }
                this.mbk = true;
            }
            int dwW = this.maG.dwW() + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.mbv) || "V_MPEGH/ISO/HEVC".equals(bVar.mbv)) {
                byte[] bArr = this.maj.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i7 = bVar.mak;
                int i8 = 4 - bVar.mak;
                while (this.mbj < dwW) {
                    if (this.mbq == 0) {
                        a(fVar, bArr, i8, i7);
                        this.maj.setPosition(0);
                        this.mbq = this.maj.dxg();
                        this.mai.setPosition(0);
                        mVar.a(this.mai, 4);
                        this.mbr += 4;
                    } else {
                        this.mbq -= a(fVar, mVar, this.mbq);
                    }
                }
            } else {
                while (this.mbj < dwW) {
                    a(fVar, mVar, dwW - this.mbj);
                }
            }
            if ("A_VORBIS".equals(bVar.mbv)) {
                this.maE.setPosition(0);
                mVar.a(this.maE, 4);
                this.mbr += 4;
            }
        }
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.maH.capacity() < length) {
            this.maH.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.maH.data, 0, bArr.length);
        }
        fVar.readFully(this.maH.data, bArr.length, i);
        this.maH.reset(length);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.maH.data, this.mbc, str, i, j, bArr);
        bVar.mah.a(this.maH, this.maH.dwW());
        this.mbr += this.maH.dwW();
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] Qc;
        if (j == -9223372036854775807L) {
            Qc = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - ((i2 * 3600) * TimeUtils.NANOS_PER_MS);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * TimeUtils.NANOS_PER_MS);
            int i4 = (int) (j4 / TimeUtils.NANOS_PER_MS);
            Qc = v.Qc(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * TimeUtils.NANOS_PER_MS)) / j2))));
        }
        System.arraycopy(Qc, 0, bArr, i, bArr2.length);
    }

    private void a(com.google.android.exoplayer2.extractor.f fVar, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int min = Math.min(i2, this.maG.dwV());
        fVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.maG.D(bArr, i, min);
        }
        this.mbj += i2;
    }

    private int a(com.google.android.exoplayer2.extractor.f fVar, m mVar, int i) throws IOException, InterruptedException {
        int a2;
        int dwV = this.maG.dwV();
        if (dwV > 0) {
            a2 = Math.min(i, dwV);
            mVar.a(this.maG, a2);
        } else {
            a2 = mVar.a(fVar, i, false);
        }
        this.mbj += a2;
        this.mbr += a2;
        return a2;
    }

    private com.google.android.exoplayer2.extractor.l dsw() {
        if (this.maM == -1 || this.lUZ == -9223372036854775807L || this.maX == null || this.maX.size() == 0 || this.maY == null || this.maY.size() != this.maX.size()) {
            this.maX = null;
            this.maY = null;
            return new l.a(this.lUZ);
        }
        int size = this.maX.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        for (int i = 0; i < size; i++) {
            jArr3[i] = this.maX.LF(i);
            jArr[i] = this.maM + this.maY.LF(i);
        }
        for (int i2 = 0; i2 < size - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            jArr2[i2] = jArr3[i2 + 1] - jArr3[i2];
        }
        iArr[size - 1] = (int) ((this.maM + this.maL) - jArr[size - 1]);
        jArr2[size - 1] = this.lUZ - jArr3[size - 1];
        this.maX = null;
        this.maY = null;
        return new com.google.android.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(k kVar, long j) {
        if (this.maT) {
            this.maV = j;
            kVar.fIt = this.maU;
            this.maT = false;
            return true;
        } else if (!this.maQ || this.maV == -1) {
            return false;
        } else {
            kVar.fIt = this.maV;
            this.maV = -1L;
            return true;
        }
    }

    private long fJ(long j) throws ParserException {
        if (this.maN == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return v.h(j, this.maN, 1000L);
    }

    private static boolean OU(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] c(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }

    /* loaded from: classes4.dex */
    private final class a implements c {
        private a() {
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public int Jp(int i) {
            return d.this.Jp(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public boolean Jq(int i) {
            return d.this.Jq(i);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void k(int i, long j, long j2) throws ParserException {
            d.this.k(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void Jr(int i) throws ParserException {
            d.this.Jr(i);
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
        public void bc(int i, String str) throws ParserException {
            d.this.bc(i, str);
        }

        @Override // com.google.android.exoplayer2.extractor.a.c
        public void a(int i, int i2, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            d.this.a(i, i2, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {
        public int channelCount;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public DrmInitData drmInitData;
        public int height;
        private String language;
        public m mah;
        public int mak;
        public byte[] mbA;
        public int mbB;
        public int mbC;
        public int mbD;
        public boolean mbE;
        public int mbF;
        public int mbG;
        public float mbH;
        public float mbI;
        public float mbJ;
        public float mbK;
        public float mbL;
        public float mbM;
        public float mbN;
        public float mbO;
        public float mbP;
        public float mbQ;
        public int mbR;
        public long mbS;
        public long mbT;
        public boolean mbU;
        public boolean mbV;
        public String mbv;
        public int mbw;
        public boolean mbx;
        public byte[] mby;
        public m.a mbz;
        public int number;
        public byte[] projectionData;
        public int sampleRate;
        public int stereoMode;
        public int type;
        public int width;

        private b() {
            this.width = -1;
            this.height = -1;
            this.mbB = -1;
            this.mbC = -1;
            this.mbD = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.mbE = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.mbF = 1000;
            this.mbG = 200;
            this.mbH = -1.0f;
            this.mbI = -1.0f;
            this.mbJ = -1.0f;
            this.mbK = -1.0f;
            this.mbL = -1.0f;
            this.mbM = -1.0f;
            this.mbN = -1.0f;
            this.mbO = -1.0f;
            this.mbP = -1.0f;
            this.mbQ = -1.0f;
            this.channelCount = 1;
            this.mbR = -1;
            this.sampleRate = 8000;
            this.mbS = 0L;
            this.mbT = 0L;
            this.mbV = true;
            this.language = "eng";
        }

        public void a(g gVar, int i) throws ParserException {
            String str;
            Format a;
            int i2;
            int i3 = -1;
            int i4 = -1;
            List list = null;
            String str2 = this.mbv;
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
                    list = this.mbA == null ? null : Collections.singletonList(this.mbA);
                    break;
                case 6:
                    str = "video/avc";
                    com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(new com.google.android.exoplayer2.util.l(this.mbA));
                    list = ag.initializationData;
                    this.mak = ag.mak;
                    break;
                case 7:
                    str = "video/hevc";
                    com.google.android.exoplayer2.video.b ai = com.google.android.exoplayer2.video.b.ai(new com.google.android.exoplayer2.util.l(this.mbA));
                    list = ai.initializationData;
                    this.mak = ai.mak;
                    break;
                case '\b':
                    list = j(new com.google.android.exoplayer2.util.l(this.mbA));
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
                    list = ap(this.mbA);
                    break;
                case 11:
                    str = "audio/opus";
                    i3 = 5760;
                    list = new ArrayList(3);
                    list.add(this.mbA);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mbS).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.mbT).array());
                    break;
                case '\f':
                    str = "audio/mp4a-latm";
                    list = Collections.singletonList(this.mbA);
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
                    list = Collections.singletonList(this.mbA);
                    break;
                case 22:
                    str = "audio/raw";
                    if (k(new com.google.android.exoplayer2.util.l(this.mbA))) {
                        i4 = v.LL(this.mbR);
                        if (i4 == 0) {
                            i4 = -1;
                            str = "audio/x-unknown";
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mbR + ". Setting mimeType to audio/x-unknown");
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
                    i4 = v.LL(this.mbR);
                    if (i4 == 0) {
                        i4 = -1;
                        str = "audio/x-unknown";
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.mbR + ". Setting mimeType to audio/x-unknown");
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
                    list = Collections.singletonList(this.mbA);
                    break;
                case 27:
                    str = "application/pgs";
                    break;
                case 28:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(new byte[]{this.mbA[0], this.mbA[1], this.mbA[2], this.mbA[3]});
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            int i5 = 0 | (this.mbV ? 1 : 0) | (this.mbU ? 2 : 0);
            if (i.PQ(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.channelCount, this.sampleRate, i4, list, this.drmInitData, i5, this.language);
                i2 = 1;
            } else if (i.Ot(str)) {
                if (this.mbD == 0) {
                    this.mbB = this.mbB == -1 ? this.width : this.mbB;
                    this.mbC = this.mbC == -1 ? this.height : this.mbC;
                }
                float f = -1.0f;
                if (this.mbB != -1 && this.mbC != -1) {
                    f = (this.height * this.mbB) / (this.width * this.mbC);
                }
                ColorInfo colorInfo = null;
                if (this.mbE) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, dsz());
                }
                a = Format.a(Integer.toString(i), str, (String) null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                i2 = 2;
            } else if ("application/x-subrip".equals(str)) {
                a = Format.a(Integer.toString(i), str, i5, this.language, this.drmInitData);
                i2 = 3;
            } else if ("text/x-ssa".equals(str)) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(d.maw);
                arrayList.add(this.mbA);
                a = Format.a(Integer.toString(i), str, (String) null, -1, i5, this.language, -1, this.drmInitData, (long) Format.OFFSET_SAMPLE_RELATIVE, arrayList);
                i2 = 3;
            } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                a = Format.a(Integer.toString(i), str, (String) null, -1, list, this.language, this.drmInitData);
                i2 = 3;
            } else {
                throw new ParserException("Unexpected MIME type.");
            }
            this.mah = gVar.dJ(this.number, i2);
            this.mah.h(a);
        }

        private byte[] dsz() {
            if (this.mbH == -1.0f || this.mbI == -1.0f || this.mbJ == -1.0f || this.mbK == -1.0f || this.mbL == -1.0f || this.mbM == -1.0f || this.mbN == -1.0f || this.mbO == -1.0f || this.mbP == -1.0f || this.mbQ == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.mbH * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbI * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbJ * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbK * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbL * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbM * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbN * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.mbO * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.mbP + 0.5f));
            wrap.putShort((short) (this.mbQ + 0.5f));
            wrap.putShort((short) this.mbF);
            wrap.putShort((short) this.mbG);
            return bArr;
        }

        private static List<byte[]> j(com.google.android.exoplayer2.util.l lVar) throws ParserException {
            try {
                lVar.skipBytes(16);
                if (lVar.dxb() != 826496599) {
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

        private static List<byte[]> ap(byte[] bArr) throws ParserException {
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
                int dwY = lVar.dwY();
                if (dwY == 1) {
                    return true;
                }
                if (dwY == 65534) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.maA.getMostSignificantBits()) {
                        if (lVar.readLong() == d.maA.getLeastSignificantBits()) {
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
