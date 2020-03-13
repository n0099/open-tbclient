package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
/* loaded from: classes6.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.a {
    private static final byte[] mpB = v.QG("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lYC;
    private Format lZJ;
    private ByteBuffer[] mce;
    private final b mpC;
    private final boolean mpD;
    private final e mpE;
    private final e mpF;
    private final m mpG;
    private final List<Long> mpH;
    private final MediaCodec.BufferInfo mpI;
    private DrmSession<c> mpJ;
    private DrmSession<c> mpK;
    private MediaCodec mpL;
    private a mpM;
    private int mpN;
    private boolean mpO;
    private boolean mpP;
    private boolean mpQ;
    private boolean mpR;
    private boolean mpS;
    private boolean mpT;
    private boolean mpU;
    private boolean mpV;
    private ByteBuffer[] mpW;
    private long mpX;
    private int mpY;
    private int mpZ;
    private boolean mqa;
    private boolean mqb;
    private int mqc;
    private int mqd;
    private boolean mqe;
    private boolean mqf;
    private boolean mqg;
    private boolean mqh;
    private boolean mqi;
    private boolean mqj;
    protected d mqk;

    protected abstract int a(b bVar, com.google.android.exoplayer2.drm.a<c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    protected abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    /* loaded from: classes6.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = v.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null;
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, b bVar, @Nullable com.google.android.exoplayer2.drm.a<c> aVar, boolean z) {
        super(i);
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 16);
        this.mpC = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lYC = aVar;
        this.mpD = z;
        this.mpE = new e(0);
        this.mpF = e.duD();
        this.mpG = new m();
        this.mpH = new ArrayList();
        this.mpI = new MediaCodec.BufferInfo();
        this.mqc = 0;
        this.mqd = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int dsO() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.mpC, this.lYC, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dvP() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.mpL == null && this.lZJ != null) {
            this.mpJ = this.mpK;
            String str = this.lZJ.sampleMimeType;
            if (this.mpJ != null) {
                c duP = this.mpJ.duP();
                if (duP == null) {
                    DrmSession.DrmSessionException duO = this.mpJ.duO();
                    if (duO != null) {
                        throw ExoPlaybackException.createForRenderer(duO, getIndex());
                    }
                    return;
                }
                MediaCrypto duQ = duP.duQ();
                z = duP.Ps(str);
                mediaCrypto = duQ;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.mpM == null) {
                try {
                    this.mpM = a(this.mpC, this.lZJ, z);
                    if (this.mpM == null && z) {
                        this.mpM = a(this.mpC, this.lZJ, false);
                        if (this.mpM != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.mpM.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lZJ, e, z, -49998));
                }
                if (this.mpM == null) {
                    a(new DecoderInitializationException(this.lZJ, (Throwable) null, z, -49999));
                }
            }
            if (a(this.mpM)) {
                String str2 = this.mpM.name;
                this.mpN = Pz(str2);
                this.mpO = a(str2, this.lZJ);
                this.mpP = Py(str2);
                this.mpQ = PA(str2);
                this.mpR = PB(str2);
                this.mpS = PC(str2);
                this.mpT = b(str2, this.lZJ);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.mpL = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.mpM, this.mpL, this.lZJ, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.mpL.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mpW = this.mpL.getInputBuffers();
                    this.mce = this.mpL.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lZJ, e2, z, str2));
                }
                this.mpX = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mpY = -1;
                this.mpZ = -1;
                this.mqj = true;
                this.mqk.mdE++;
            }
        }
    }

    private void a(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
    }

    protected boolean a(a aVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec dvQ() {
        return this.mpL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a dvR() {
        return this.mpM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vx(boolean z) throws ExoPlaybackException {
        this.mqk = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void l(long j, boolean z) throws ExoPlaybackException {
        this.mqg = false;
        this.mqh = false;
        if (this.mpL != null) {
            dvT();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dsP() {
        this.lZJ = null;
        try {
            dvS();
            try {
                if (this.mpJ != null) {
                    this.lYC.a(this.mpJ);
                }
                try {
                    if (this.mpK != null && this.mpK != this.mpJ) {
                        this.lYC.a(this.mpK);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mpK != null && this.mpK != this.mpJ) {
                        this.lYC.a(this.mpK);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.mpJ != null) {
                    this.lYC.a(this.mpJ);
                }
                try {
                    if (this.mpK != null && this.mpK != this.mpJ) {
                        this.lYC.a(this.mpK);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mpK != null && this.mpK != this.mpJ) {
                        this.lYC.a(this.mpK);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [502=4, 503=4, 505=4, 507=5] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    public void dvS() {
        this.mpX = -9223372036854775807L;
        this.mpY = -1;
        this.mpZ = -1;
        this.mqi = false;
        this.mqa = false;
        this.mpH.clear();
        this.mpW = null;
        this.mce = null;
        this.mpM = null;
        this.mqb = false;
        this.mqe = false;
        this.mpO = false;
        this.mpP = false;
        this.mpN = 0;
        this.mpQ = false;
        this.mpR = false;
        this.mpT = false;
        this.mpU = false;
        this.mpV = false;
        this.mqf = false;
        this.mqc = 0;
        this.mqd = 0;
        this.mpE.data = null;
        if (this.mpL != null) {
            this.mqk.mdF++;
            try {
                this.mpL.stop();
                try {
                    this.mpL.release();
                    this.mpL = null;
                    if (this.mpJ == null || this.mpK == this.mpJ) {
                        return;
                    }
                    try {
                        this.lYC.a(this.mpJ);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.mpL = null;
                    if (this.mpJ != null && this.mpK != this.mpJ) {
                        try {
                            this.lYC.a(this.mpJ);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.mpL.release();
                    this.mpL = null;
                    if (this.mpJ != null && this.mpK != this.mpJ) {
                        try {
                            this.lYC.a(this.mpJ);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.mpL = null;
                    if (this.mpJ != null && this.mpK != this.mpJ) {
                        try {
                            this.lYC.a(this.mpJ);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.s
    public void M(long j, long j2) throws ExoPlaybackException {
        if (this.mqh) {
            dur();
            return;
        }
        if (this.lZJ == null) {
            this.mpF.clear();
            int a = a(this.mpG, this.mpF, true);
            if (a == -5) {
                g(this.mpG.lZJ);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mpF.duv());
                this.mqg = true;
                dvY();
                return;
            } else {
                return;
            }
        }
        dvP();
        if (this.mpL != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (Q(j, j2));
            do {
            } while (dvU());
            t.endSection();
        } else {
            this.mqk.mdH += fm(j);
            this.mpF.clear();
            int a2 = a(this.mpG, this.mpF, false);
            if (a2 == -5) {
                g(this.mpG.lZJ);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mpF.duv());
                this.mqg = true;
                dvY();
            }
        }
        this.mqk.duC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvT() throws ExoPlaybackException {
        this.mpX = -9223372036854775807L;
        this.mpY = -1;
        this.mpZ = -1;
        this.mqj = true;
        this.mqi = false;
        this.mqa = false;
        this.mpH.clear();
        this.mpU = false;
        this.mpV = false;
        if (this.mpP || (this.mpR && this.mqf)) {
            dvS();
            dvP();
        } else if (this.mqd != 0) {
            dvS();
            dvP();
        } else {
            this.mpL.flush();
            this.mqe = false;
        }
        if (this.mqb && this.lZJ != null) {
            this.mqc = 1;
        }
    }

    private boolean dvU() throws ExoPlaybackException {
        int position;
        int a;
        if (this.mpL == null || this.mqd == 2 || this.mqg) {
            return false;
        }
        if (this.mpY < 0) {
            this.mpY = this.mpL.dequeueInputBuffer(0L);
            if (this.mpY < 0) {
                return false;
            }
            this.mpE.data = this.mpW[this.mpY];
            this.mpE.clear();
        }
        if (this.mqd == 1) {
            if (!this.mpQ) {
                this.mqf = true;
                this.mpL.queueInputBuffer(this.mpY, 0, 0, 0L, 4);
                this.mpY = -1;
            }
            this.mqd = 2;
            return false;
        } else if (this.mpU) {
            this.mpU = false;
            this.mpE.data.put(mpB);
            this.mpL.queueInputBuffer(this.mpY, 0, mpB.length, 0L, 0);
            this.mpY = -1;
            this.mqe = true;
            return true;
        } else {
            if (this.mqi) {
                a = -4;
                position = 0;
            } else {
                if (this.mqc == 1) {
                    for (int i = 0; i < this.lZJ.initializationData.size(); i++) {
                        this.mpE.data.put(this.lZJ.initializationData.get(i));
                    }
                    this.mqc = 2;
                }
                position = this.mpE.data.position();
                a = a(this.mpG, this.mpE, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mqc == 2) {
                        this.mpE.clear();
                        this.mqc = 1;
                    }
                    g(this.mpG.lZJ);
                    return true;
                } else if (this.mpE.duv()) {
                    if (this.mqc == 2) {
                        this.mpE.clear();
                        this.mqc = 1;
                    }
                    this.mqg = true;
                    if (!this.mqe) {
                        dvY();
                        return false;
                    }
                    try {
                        if (this.mpQ) {
                            return false;
                        }
                        this.mqf = true;
                        this.mpL.queueInputBuffer(this.mpY, 0, 0, 0L, 4);
                        this.mpY = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mqj && !this.mpE.duw()) {
                    this.mpE.clear();
                    if (this.mqc == 2) {
                        this.mqc = 1;
                    }
                    return true;
                } else {
                    this.mqj = false;
                    boolean duF = this.mpE.duF();
                    this.mqi = vG(duF);
                    if (this.mqi) {
                        return false;
                    }
                    if (this.mpO && !duF) {
                        j.k(this.mpE.data);
                        if (this.mpE.data.position() == 0) {
                            return true;
                        }
                        this.mpO = false;
                    }
                    try {
                        long j = this.mpE.mdO;
                        if (this.mpE.duu()) {
                            this.mpH.add(Long.valueOf(j));
                        }
                        this.mpE.duG();
                        c(this.mpE);
                        if (duF) {
                            this.mpL.queueSecureInputBuffer(this.mpY, 0, a(this.mpE, position), j, 0);
                        } else {
                            this.mpL.queueInputBuffer(this.mpY, 0, this.mpE.data.limit(), j, 0);
                        }
                        this.mpY = -1;
                        this.mqe = true;
                        this.mqc = 0;
                        this.mqk.mdG++;
                        return true;
                    } catch (MediaCodec.CryptoException e2) {
                        throw ExoPlaybackException.createForRenderer(e2, getIndex());
                    }
                }
            }
            return false;
        }
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i) {
        MediaCodec.CryptoInfo dux = eVar.mdN.dux();
        if (i != 0) {
            if (dux.numBytesOfClearData == null) {
                dux.numBytesOfClearData = new int[1];
            }
            int[] iArr = dux.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return dux;
    }

    private boolean vG(boolean z) throws ExoPlaybackException {
        if (this.mpJ == null || (!z && this.mpD)) {
            return false;
        }
        int state = this.mpJ.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.mpJ.duO(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lZJ;
        this.lZJ = format;
        if (!v.h(this.lZJ.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lZJ.drmInitData != null) {
                if (this.lYC == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.mpK = this.lYC.a(Looper.myLooper(), this.lZJ.drmInitData);
                if (this.mpK == this.mpJ) {
                    this.lYC.a(this.mpK);
                }
            } else {
                this.mpK = null;
            }
        }
        if (this.mpK == this.mpJ && this.mpL != null && a(this.mpL, this.mpM.mpz, format2, this.lZJ)) {
            this.mqb = true;
            this.mqc = 1;
            this.mpU = this.mpN == 2 || (this.mpN == 1 && this.lZJ.width == format2.width && this.lZJ.height == format2.height);
        } else if (this.mqe) {
            this.mqd = 1;
        } else {
            dvS();
            dvP();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    protected void c(e eVar) {
    }

    protected void fX(long j) {
    }

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avR() {
        return this.mqh;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lZJ == null || this.mqi || (!cTq() && this.mpZ < 0 && (this.mpX == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mpX))) ? false : true;
    }

    protected long dvV() {
        return 0L;
    }

    private boolean Q(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mpZ < 0) {
            if (this.mpS && this.mqf) {
                try {
                    this.mpZ = this.mpL.dequeueOutputBuffer(this.mpI, dvV());
                } catch (IllegalStateException e) {
                    dvY();
                    if (this.mqh) {
                        dvS();
                    }
                    return false;
                }
            } else {
                this.mpZ = this.mpL.dequeueOutputBuffer(this.mpI, dvV());
            }
            if (this.mpZ >= 0) {
                if (this.mpV) {
                    this.mpV = false;
                    this.mpL.releaseOutputBuffer(this.mpZ, false);
                    this.mpZ = -1;
                    return true;
                } else if ((this.mpI.flags & 4) != 0) {
                    dvY();
                    this.mpZ = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mce[this.mpZ];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.mpI.offset);
                        byteBuffer.limit(this.mpI.offset + this.mpI.size);
                    }
                    this.mqa = fY(this.mpI.presentationTimeUs);
                }
            } else if (this.mpZ == -2) {
                dvW();
                return true;
            } else if (this.mpZ == -3) {
                dvX();
                return true;
            } else {
                if (this.mpQ && (this.mqg || this.mqd == 2)) {
                    dvY();
                }
                return false;
            }
        }
        if (this.mpS && this.mqf) {
            try {
                a = a(j, j2, this.mpL, this.mce[this.mpZ], this.mpZ, this.mpI.flags, this.mpI.presentationTimeUs, this.mqa);
            } catch (IllegalStateException e2) {
                dvY();
                if (this.mqh) {
                    dvS();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.mpL, this.mce[this.mpZ], this.mpZ, this.mpI.flags, this.mpI.presentationTimeUs, this.mqa);
        }
        if (a) {
            fX(this.mpI.presentationTimeUs);
            this.mpZ = -1;
            return true;
        }
        return false;
    }

    private void dvW() throws ExoPlaybackException {
        MediaFormat outputFormat = this.mpL.getOutputFormat();
        if (this.mpN != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mpV = true;
            return;
        }
        if (this.mpT) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.mpL, outputFormat);
    }

    private void dvX() {
        this.mce = this.mpL.getOutputBuffers();
    }

    protected void dur() throws ExoPlaybackException {
    }

    private void dvY() throws ExoPlaybackException {
        if (this.mqd == 2) {
            dvS();
            dvP();
            return;
        }
        this.mqh = true;
        dur();
    }

    private boolean fY(long j) {
        int size = this.mpH.size();
        for (int i = 0; i < size; i++) {
            if (this.mpH.get(i).longValue() == j) {
                this.mpH.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean Py(String str) {
        return v.SDK_INT < 18 || (v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.SDK_INT == 19 && v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int Pz(String str) {
        if (v.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (v.MODEL.startsWith("SM-T585") || v.MODEL.startsWith("SM-A510") || v.MODEL.startsWith("SM-A520") || v.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mHY) || "flounder_lte".equals(v.mHY) || "grouper".equals(v.mHY) || "tilapia".equals(v.mHY)))) {
            return 1;
        }
        return 0;
    }

    private static boolean a(String str, Format format) {
        return v.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean PA(String str) {
        return v.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean PB(String str) {
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mHY) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean PC(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
