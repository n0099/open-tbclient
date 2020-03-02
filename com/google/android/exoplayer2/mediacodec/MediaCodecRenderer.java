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
    private static final byte[] mpq = v.QF("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lYr;
    private Format lZy;
    private ByteBuffer[] mbT;
    private MediaCodec mpA;
    private a mpB;
    private int mpC;
    private boolean mpD;
    private boolean mpE;
    private boolean mpF;
    private boolean mpG;
    private boolean mpH;
    private boolean mpI;
    private boolean mpJ;
    private boolean mpK;
    private ByteBuffer[] mpL;
    private long mpM;
    private int mpN;
    private int mpO;
    private boolean mpP;
    private boolean mpQ;
    private int mpR;
    private int mpS;
    private boolean mpT;
    private boolean mpU;
    private boolean mpV;
    private boolean mpW;
    private boolean mpX;
    private boolean mpY;
    protected d mpZ;
    private final b mpr;
    private final boolean mps;
    private final e mpt;
    private final e mpu;
    private final m mpv;
    private final List<Long> mpw;
    private final MediaCodec.BufferInfo mpx;
    private DrmSession<c> mpy;
    private DrmSession<c> mpz;

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
        this.mpr = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lYr = aVar;
        this.mps = z;
        this.mpt = new e(0);
        this.mpu = e.duC();
        this.mpv = new m();
        this.mpw = new ArrayList();
        this.mpx = new MediaCodec.BufferInfo();
        this.mpR = 0;
        this.mpS = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int dsN() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.mpr, this.lYr, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dvO() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.mpA == null && this.lZy != null) {
            this.mpy = this.mpz;
            String str = this.lZy.sampleMimeType;
            if (this.mpy != null) {
                c duO = this.mpy.duO();
                if (duO == null) {
                    DrmSession.DrmSessionException duN = this.mpy.duN();
                    if (duN != null) {
                        throw ExoPlaybackException.createForRenderer(duN, getIndex());
                    }
                    return;
                }
                MediaCrypto duP = duO.duP();
                z = duO.Pr(str);
                mediaCrypto = duP;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.mpB == null) {
                try {
                    this.mpB = a(this.mpr, this.lZy, z);
                    if (this.mpB == null && z) {
                        this.mpB = a(this.mpr, this.lZy, false);
                        if (this.mpB != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.mpB.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lZy, e, z, -49998));
                }
                if (this.mpB == null) {
                    a(new DecoderInitializationException(this.lZy, (Throwable) null, z, -49999));
                }
            }
            if (a(this.mpB)) {
                String str2 = this.mpB.name;
                this.mpC = Py(str2);
                this.mpD = a(str2, this.lZy);
                this.mpE = Px(str2);
                this.mpF = Pz(str2);
                this.mpG = PA(str2);
                this.mpH = PB(str2);
                this.mpI = b(str2, this.lZy);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.mpA = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.mpB, this.mpA, this.lZy, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.mpA.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mpL = this.mpA.getInputBuffers();
                    this.mbT = this.mpA.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lZy, e2, z, str2));
                }
                this.mpM = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mpN = -1;
                this.mpO = -1;
                this.mpY = true;
                this.mpZ.mdt++;
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
    public final MediaCodec dvP() {
        return this.mpA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a dvQ() {
        return this.mpB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vx(boolean z) throws ExoPlaybackException {
        this.mpZ = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void l(long j, boolean z) throws ExoPlaybackException {
        this.mpV = false;
        this.mpW = false;
        if (this.mpA != null) {
            dvS();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dsO() {
        this.lZy = null;
        try {
            dvR();
            try {
                if (this.mpy != null) {
                    this.lYr.a(this.mpy);
                }
                try {
                    if (this.mpz != null && this.mpz != this.mpy) {
                        this.lYr.a(this.mpz);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mpz != null && this.mpz != this.mpy) {
                        this.lYr.a(this.mpz);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.mpy != null) {
                    this.lYr.a(this.mpy);
                }
                try {
                    if (this.mpz != null && this.mpz != this.mpy) {
                        this.lYr.a(this.mpz);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mpz != null && this.mpz != this.mpy) {
                        this.lYr.a(this.mpz);
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
    public void dvR() {
        this.mpM = -9223372036854775807L;
        this.mpN = -1;
        this.mpO = -1;
        this.mpX = false;
        this.mpP = false;
        this.mpw.clear();
        this.mpL = null;
        this.mbT = null;
        this.mpB = null;
        this.mpQ = false;
        this.mpT = false;
        this.mpD = false;
        this.mpE = false;
        this.mpC = 0;
        this.mpF = false;
        this.mpG = false;
        this.mpI = false;
        this.mpJ = false;
        this.mpK = false;
        this.mpU = false;
        this.mpR = 0;
        this.mpS = 0;
        this.mpt.data = null;
        if (this.mpA != null) {
            this.mpZ.mdu++;
            try {
                this.mpA.stop();
                try {
                    this.mpA.release();
                    this.mpA = null;
                    if (this.mpy == null || this.mpz == this.mpy) {
                        return;
                    }
                    try {
                        this.lYr.a(this.mpy);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.mpA = null;
                    if (this.mpy != null && this.mpz != this.mpy) {
                        try {
                            this.lYr.a(this.mpy);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.mpA.release();
                    this.mpA = null;
                    if (this.mpy != null && this.mpz != this.mpy) {
                        try {
                            this.lYr.a(this.mpy);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.mpA = null;
                    if (this.mpy != null && this.mpz != this.mpy) {
                        try {
                            this.lYr.a(this.mpy);
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
        if (this.mpW) {
            duq();
            return;
        }
        if (this.lZy == null) {
            this.mpu.clear();
            int a = a(this.mpv, this.mpu, true);
            if (a == -5) {
                g(this.mpv.lZy);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mpu.duu());
                this.mpV = true;
                dvX();
                return;
            } else {
                return;
            }
        }
        dvO();
        if (this.mpA != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (Q(j, j2));
            do {
            } while (dvT());
            t.endSection();
        } else {
            this.mpZ.mdw += fm(j);
            this.mpu.clear();
            int a2 = a(this.mpv, this.mpu, false);
            if (a2 == -5) {
                g(this.mpv.lZy);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mpu.duu());
                this.mpV = true;
                dvX();
            }
        }
        this.mpZ.duB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvS() throws ExoPlaybackException {
        this.mpM = -9223372036854775807L;
        this.mpN = -1;
        this.mpO = -1;
        this.mpY = true;
        this.mpX = false;
        this.mpP = false;
        this.mpw.clear();
        this.mpJ = false;
        this.mpK = false;
        if (this.mpE || (this.mpG && this.mpU)) {
            dvR();
            dvO();
        } else if (this.mpS != 0) {
            dvR();
            dvO();
        } else {
            this.mpA.flush();
            this.mpT = false;
        }
        if (this.mpQ && this.lZy != null) {
            this.mpR = 1;
        }
    }

    private boolean dvT() throws ExoPlaybackException {
        int position;
        int a;
        if (this.mpA == null || this.mpS == 2 || this.mpV) {
            return false;
        }
        if (this.mpN < 0) {
            this.mpN = this.mpA.dequeueInputBuffer(0L);
            if (this.mpN < 0) {
                return false;
            }
            this.mpt.data = this.mpL[this.mpN];
            this.mpt.clear();
        }
        if (this.mpS == 1) {
            if (!this.mpF) {
                this.mpU = true;
                this.mpA.queueInputBuffer(this.mpN, 0, 0, 0L, 4);
                this.mpN = -1;
            }
            this.mpS = 2;
            return false;
        } else if (this.mpJ) {
            this.mpJ = false;
            this.mpt.data.put(mpq);
            this.mpA.queueInputBuffer(this.mpN, 0, mpq.length, 0L, 0);
            this.mpN = -1;
            this.mpT = true;
            return true;
        } else {
            if (this.mpX) {
                a = -4;
                position = 0;
            } else {
                if (this.mpR == 1) {
                    for (int i = 0; i < this.lZy.initializationData.size(); i++) {
                        this.mpt.data.put(this.lZy.initializationData.get(i));
                    }
                    this.mpR = 2;
                }
                position = this.mpt.data.position();
                a = a(this.mpv, this.mpt, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mpR == 2) {
                        this.mpt.clear();
                        this.mpR = 1;
                    }
                    g(this.mpv.lZy);
                    return true;
                } else if (this.mpt.duu()) {
                    if (this.mpR == 2) {
                        this.mpt.clear();
                        this.mpR = 1;
                    }
                    this.mpV = true;
                    if (!this.mpT) {
                        dvX();
                        return false;
                    }
                    try {
                        if (this.mpF) {
                            return false;
                        }
                        this.mpU = true;
                        this.mpA.queueInputBuffer(this.mpN, 0, 0, 0L, 4);
                        this.mpN = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mpY && !this.mpt.duv()) {
                    this.mpt.clear();
                    if (this.mpR == 2) {
                        this.mpR = 1;
                    }
                    return true;
                } else {
                    this.mpY = false;
                    boolean duE = this.mpt.duE();
                    this.mpX = vG(duE);
                    if (this.mpX) {
                        return false;
                    }
                    if (this.mpD && !duE) {
                        j.k(this.mpt.data);
                        if (this.mpt.data.position() == 0) {
                            return true;
                        }
                        this.mpD = false;
                    }
                    try {
                        long j = this.mpt.mdD;
                        if (this.mpt.dut()) {
                            this.mpw.add(Long.valueOf(j));
                        }
                        this.mpt.duF();
                        c(this.mpt);
                        if (duE) {
                            this.mpA.queueSecureInputBuffer(this.mpN, 0, a(this.mpt, position), j, 0);
                        } else {
                            this.mpA.queueInputBuffer(this.mpN, 0, this.mpt.data.limit(), j, 0);
                        }
                        this.mpN = -1;
                        this.mpT = true;
                        this.mpR = 0;
                        this.mpZ.mdv++;
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
        MediaCodec.CryptoInfo duw = eVar.mdC.duw();
        if (i != 0) {
            if (duw.numBytesOfClearData == null) {
                duw.numBytesOfClearData = new int[1];
            }
            int[] iArr = duw.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return duw;
    }

    private boolean vG(boolean z) throws ExoPlaybackException {
        if (this.mpy == null || (!z && this.mps)) {
            return false;
        }
        int state = this.mpy.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.mpy.duN(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lZy;
        this.lZy = format;
        if (!v.h(this.lZy.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lZy.drmInitData != null) {
                if (this.lYr == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.mpz = this.lYr.a(Looper.myLooper(), this.lZy.drmInitData);
                if (this.mpz == this.mpy) {
                    this.lYr.a(this.mpz);
                }
            } else {
                this.mpz = null;
            }
        }
        if (this.mpz == this.mpy && this.mpA != null && a(this.mpA, this.mpB.mpo, format2, this.lZy)) {
            this.mpQ = true;
            this.mpR = 1;
            this.mpJ = this.mpC == 2 || (this.mpC == 1 && this.lZy.width == format2.width && this.lZy.height == format2.height);
        } else if (this.mpT) {
            this.mpS = 1;
        } else {
            dvR();
            dvO();
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
        return this.mpW;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lZy == null || this.mpX || (!cTp() && this.mpO < 0 && (this.mpM == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mpM))) ? false : true;
    }

    protected long dvU() {
        return 0L;
    }

    private boolean Q(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mpO < 0) {
            if (this.mpH && this.mpU) {
                try {
                    this.mpO = this.mpA.dequeueOutputBuffer(this.mpx, dvU());
                } catch (IllegalStateException e) {
                    dvX();
                    if (this.mpW) {
                        dvR();
                    }
                    return false;
                }
            } else {
                this.mpO = this.mpA.dequeueOutputBuffer(this.mpx, dvU());
            }
            if (this.mpO >= 0) {
                if (this.mpK) {
                    this.mpK = false;
                    this.mpA.releaseOutputBuffer(this.mpO, false);
                    this.mpO = -1;
                    return true;
                } else if ((this.mpx.flags & 4) != 0) {
                    dvX();
                    this.mpO = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mbT[this.mpO];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.mpx.offset);
                        byteBuffer.limit(this.mpx.offset + this.mpx.size);
                    }
                    this.mpP = fY(this.mpx.presentationTimeUs);
                }
            } else if (this.mpO == -2) {
                dvV();
                return true;
            } else if (this.mpO == -3) {
                dvW();
                return true;
            } else {
                if (this.mpF && (this.mpV || this.mpS == 2)) {
                    dvX();
                }
                return false;
            }
        }
        if (this.mpH && this.mpU) {
            try {
                a = a(j, j2, this.mpA, this.mbT[this.mpO], this.mpO, this.mpx.flags, this.mpx.presentationTimeUs, this.mpP);
            } catch (IllegalStateException e2) {
                dvX();
                if (this.mpW) {
                    dvR();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.mpA, this.mbT[this.mpO], this.mpO, this.mpx.flags, this.mpx.presentationTimeUs, this.mpP);
        }
        if (a) {
            fX(this.mpx.presentationTimeUs);
            this.mpO = -1;
            return true;
        }
        return false;
    }

    private void dvV() throws ExoPlaybackException {
        MediaFormat outputFormat = this.mpA.getOutputFormat();
        if (this.mpC != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mpK = true;
            return;
        }
        if (this.mpI) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.mpA, outputFormat);
    }

    private void dvW() {
        this.mbT = this.mpA.getOutputBuffers();
    }

    protected void duq() throws ExoPlaybackException {
    }

    private void dvX() throws ExoPlaybackException {
        if (this.mpS == 2) {
            dvR();
            dvO();
            return;
        }
        this.mpW = true;
        duq();
    }

    private boolean fY(long j) {
        int size = this.mpw.size();
        for (int i = 0; i < size; i++) {
            if (this.mpw.get(i).longValue() == j) {
                this.mpw.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean Px(String str) {
        return v.SDK_INT < 18 || (v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.SDK_INT == 19 && v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int Py(String str) {
        if (v.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (v.MODEL.startsWith("SM-T585") || v.MODEL.startsWith("SM-A510") || v.MODEL.startsWith("SM-A520") || v.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mHN) || "flounder_lte".equals(v.mHN) || "grouper".equals(v.mHN) || "tilapia".equals(v.mHN)))) {
            return 1;
        }
        return 0;
    }

    private static boolean a(String str, Format format) {
        return v.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean Pz(String str) {
        return v.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean PA(String str) {
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mHN) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean PB(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
