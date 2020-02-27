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
    private static final byte[] mpo = v.QF("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lYp;
    private Format lZw;
    private ByteBuffer[] mbR;
    private int mpA;
    private boolean mpB;
    private boolean mpC;
    private boolean mpD;
    private boolean mpE;
    private boolean mpF;
    private boolean mpG;
    private boolean mpH;
    private boolean mpI;
    private ByteBuffer[] mpJ;
    private long mpK;
    private int mpL;
    private int mpM;
    private boolean mpN;
    private boolean mpO;
    private int mpP;
    private int mpQ;
    private boolean mpR;
    private boolean mpS;
    private boolean mpT;
    private boolean mpU;
    private boolean mpV;
    private boolean mpW;
    protected d mpX;
    private final b mpp;
    private final boolean mpq;
    private final e mpr;
    private final e mps;
    private final m mpt;
    private final List<Long> mpu;
    private final MediaCodec.BufferInfo mpv;
    private DrmSession<c> mpw;
    private DrmSession<c> mpx;
    private MediaCodec mpy;
    private a mpz;

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
        this.mpp = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lYp = aVar;
        this.mpq = z;
        this.mpr = new e(0);
        this.mps = e.duA();
        this.mpt = new m();
        this.mpu = new ArrayList();
        this.mpv = new MediaCodec.BufferInfo();
        this.mpP = 0;
        this.mpQ = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int dsL() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.mpp, this.lYp, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dvM() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.mpy == null && this.lZw != null) {
            this.mpw = this.mpx;
            String str = this.lZw.sampleMimeType;
            if (this.mpw != null) {
                c duM = this.mpw.duM();
                if (duM == null) {
                    DrmSession.DrmSessionException duL = this.mpw.duL();
                    if (duL != null) {
                        throw ExoPlaybackException.createForRenderer(duL, getIndex());
                    }
                    return;
                }
                MediaCrypto duN = duM.duN();
                z = duM.Pr(str);
                mediaCrypto = duN;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.mpz == null) {
                try {
                    this.mpz = a(this.mpp, this.lZw, z);
                    if (this.mpz == null && z) {
                        this.mpz = a(this.mpp, this.lZw, false);
                        if (this.mpz != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.mpz.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lZw, e, z, -49998));
                }
                if (this.mpz == null) {
                    a(new DecoderInitializationException(this.lZw, (Throwable) null, z, -49999));
                }
            }
            if (a(this.mpz)) {
                String str2 = this.mpz.name;
                this.mpA = Py(str2);
                this.mpB = a(str2, this.lZw);
                this.mpC = Px(str2);
                this.mpD = Pz(str2);
                this.mpE = PA(str2);
                this.mpF = PB(str2);
                this.mpG = b(str2, this.lZw);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.mpy = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.mpz, this.mpy, this.lZw, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.mpy.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mpJ = this.mpy.getInputBuffers();
                    this.mbR = this.mpy.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lZw, e2, z, str2));
                }
                this.mpK = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mpL = -1;
                this.mpM = -1;
                this.mpW = true;
                this.mpX.mdr++;
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
    public final MediaCodec dvN() {
        return this.mpy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a dvO() {
        return this.mpz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vx(boolean z) throws ExoPlaybackException {
        this.mpX = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void l(long j, boolean z) throws ExoPlaybackException {
        this.mpT = false;
        this.mpU = false;
        if (this.mpy != null) {
            dvQ();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dsM() {
        this.lZw = null;
        try {
            dvP();
            try {
                if (this.mpw != null) {
                    this.lYp.a(this.mpw);
                }
                try {
                    if (this.mpx != null && this.mpx != this.mpw) {
                        this.lYp.a(this.mpx);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mpx != null && this.mpx != this.mpw) {
                        this.lYp.a(this.mpx);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.mpw != null) {
                    this.lYp.a(this.mpw);
                }
                try {
                    if (this.mpx != null && this.mpx != this.mpw) {
                        this.lYp.a(this.mpx);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mpx != null && this.mpx != this.mpw) {
                        this.lYp.a(this.mpx);
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
    public void dvP() {
        this.mpK = -9223372036854775807L;
        this.mpL = -1;
        this.mpM = -1;
        this.mpV = false;
        this.mpN = false;
        this.mpu.clear();
        this.mpJ = null;
        this.mbR = null;
        this.mpz = null;
        this.mpO = false;
        this.mpR = false;
        this.mpB = false;
        this.mpC = false;
        this.mpA = 0;
        this.mpD = false;
        this.mpE = false;
        this.mpG = false;
        this.mpH = false;
        this.mpI = false;
        this.mpS = false;
        this.mpP = 0;
        this.mpQ = 0;
        this.mpr.data = null;
        if (this.mpy != null) {
            this.mpX.mds++;
            try {
                this.mpy.stop();
                try {
                    this.mpy.release();
                    this.mpy = null;
                    if (this.mpw == null || this.mpx == this.mpw) {
                        return;
                    }
                    try {
                        this.lYp.a(this.mpw);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.mpy = null;
                    if (this.mpw != null && this.mpx != this.mpw) {
                        try {
                            this.lYp.a(this.mpw);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.mpy.release();
                    this.mpy = null;
                    if (this.mpw != null && this.mpx != this.mpw) {
                        try {
                            this.lYp.a(this.mpw);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.mpy = null;
                    if (this.mpw != null && this.mpx != this.mpw) {
                        try {
                            this.lYp.a(this.mpw);
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
        if (this.mpU) {
            duo();
            return;
        }
        if (this.lZw == null) {
            this.mps.clear();
            int a = a(this.mpt, this.mps, true);
            if (a == -5) {
                g(this.mpt.lZw);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mps.dus());
                this.mpT = true;
                dvV();
                return;
            } else {
                return;
            }
        }
        dvM();
        if (this.mpy != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (Q(j, j2));
            do {
            } while (dvR());
            t.endSection();
        } else {
            this.mpX.mdu += fm(j);
            this.mps.clear();
            int a2 = a(this.mpt, this.mps, false);
            if (a2 == -5) {
                g(this.mpt.lZw);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mps.dus());
                this.mpT = true;
                dvV();
            }
        }
        this.mpX.duz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvQ() throws ExoPlaybackException {
        this.mpK = -9223372036854775807L;
        this.mpL = -1;
        this.mpM = -1;
        this.mpW = true;
        this.mpV = false;
        this.mpN = false;
        this.mpu.clear();
        this.mpH = false;
        this.mpI = false;
        if (this.mpC || (this.mpE && this.mpS)) {
            dvP();
            dvM();
        } else if (this.mpQ != 0) {
            dvP();
            dvM();
        } else {
            this.mpy.flush();
            this.mpR = false;
        }
        if (this.mpO && this.lZw != null) {
            this.mpP = 1;
        }
    }

    private boolean dvR() throws ExoPlaybackException {
        int position;
        int a;
        if (this.mpy == null || this.mpQ == 2 || this.mpT) {
            return false;
        }
        if (this.mpL < 0) {
            this.mpL = this.mpy.dequeueInputBuffer(0L);
            if (this.mpL < 0) {
                return false;
            }
            this.mpr.data = this.mpJ[this.mpL];
            this.mpr.clear();
        }
        if (this.mpQ == 1) {
            if (!this.mpD) {
                this.mpS = true;
                this.mpy.queueInputBuffer(this.mpL, 0, 0, 0L, 4);
                this.mpL = -1;
            }
            this.mpQ = 2;
            return false;
        } else if (this.mpH) {
            this.mpH = false;
            this.mpr.data.put(mpo);
            this.mpy.queueInputBuffer(this.mpL, 0, mpo.length, 0L, 0);
            this.mpL = -1;
            this.mpR = true;
            return true;
        } else {
            if (this.mpV) {
                a = -4;
                position = 0;
            } else {
                if (this.mpP == 1) {
                    for (int i = 0; i < this.lZw.initializationData.size(); i++) {
                        this.mpr.data.put(this.lZw.initializationData.get(i));
                    }
                    this.mpP = 2;
                }
                position = this.mpr.data.position();
                a = a(this.mpt, this.mpr, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mpP == 2) {
                        this.mpr.clear();
                        this.mpP = 1;
                    }
                    g(this.mpt.lZw);
                    return true;
                } else if (this.mpr.dus()) {
                    if (this.mpP == 2) {
                        this.mpr.clear();
                        this.mpP = 1;
                    }
                    this.mpT = true;
                    if (!this.mpR) {
                        dvV();
                        return false;
                    }
                    try {
                        if (this.mpD) {
                            return false;
                        }
                        this.mpS = true;
                        this.mpy.queueInputBuffer(this.mpL, 0, 0, 0L, 4);
                        this.mpL = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mpW && !this.mpr.dut()) {
                    this.mpr.clear();
                    if (this.mpP == 2) {
                        this.mpP = 1;
                    }
                    return true;
                } else {
                    this.mpW = false;
                    boolean duC = this.mpr.duC();
                    this.mpV = vG(duC);
                    if (this.mpV) {
                        return false;
                    }
                    if (this.mpB && !duC) {
                        j.k(this.mpr.data);
                        if (this.mpr.data.position() == 0) {
                            return true;
                        }
                        this.mpB = false;
                    }
                    try {
                        long j = this.mpr.mdB;
                        if (this.mpr.dur()) {
                            this.mpu.add(Long.valueOf(j));
                        }
                        this.mpr.duD();
                        c(this.mpr);
                        if (duC) {
                            this.mpy.queueSecureInputBuffer(this.mpL, 0, a(this.mpr, position), j, 0);
                        } else {
                            this.mpy.queueInputBuffer(this.mpL, 0, this.mpr.data.limit(), j, 0);
                        }
                        this.mpL = -1;
                        this.mpR = true;
                        this.mpP = 0;
                        this.mpX.mdt++;
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
        MediaCodec.CryptoInfo duu = eVar.mdA.duu();
        if (i != 0) {
            if (duu.numBytesOfClearData == null) {
                duu.numBytesOfClearData = new int[1];
            }
            int[] iArr = duu.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return duu;
    }

    private boolean vG(boolean z) throws ExoPlaybackException {
        if (this.mpw == null || (!z && this.mpq)) {
            return false;
        }
        int state = this.mpw.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.mpw.duL(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lZw;
        this.lZw = format;
        if (!v.h(this.lZw.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lZw.drmInitData != null) {
                if (this.lYp == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.mpx = this.lYp.a(Looper.myLooper(), this.lZw.drmInitData);
                if (this.mpx == this.mpw) {
                    this.lYp.a(this.mpx);
                }
            } else {
                this.mpx = null;
            }
        }
        if (this.mpx == this.mpw && this.mpy != null && a(this.mpy, this.mpz.mpm, format2, this.lZw)) {
            this.mpO = true;
            this.mpP = 1;
            this.mpH = this.mpA == 2 || (this.mpA == 1 && this.lZw.width == format2.width && this.lZw.height == format2.height);
        } else if (this.mpR) {
            this.mpQ = 1;
        } else {
            dvP();
            dvM();
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
    public boolean avP() {
        return this.mpU;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lZw == null || this.mpV || (!cTn() && this.mpM < 0 && (this.mpK == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mpK))) ? false : true;
    }

    protected long dvS() {
        return 0L;
    }

    private boolean Q(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mpM < 0) {
            if (this.mpF && this.mpS) {
                try {
                    this.mpM = this.mpy.dequeueOutputBuffer(this.mpv, dvS());
                } catch (IllegalStateException e) {
                    dvV();
                    if (this.mpU) {
                        dvP();
                    }
                    return false;
                }
            } else {
                this.mpM = this.mpy.dequeueOutputBuffer(this.mpv, dvS());
            }
            if (this.mpM >= 0) {
                if (this.mpI) {
                    this.mpI = false;
                    this.mpy.releaseOutputBuffer(this.mpM, false);
                    this.mpM = -1;
                    return true;
                } else if ((this.mpv.flags & 4) != 0) {
                    dvV();
                    this.mpM = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mbR[this.mpM];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.mpv.offset);
                        byteBuffer.limit(this.mpv.offset + this.mpv.size);
                    }
                    this.mpN = fY(this.mpv.presentationTimeUs);
                }
            } else if (this.mpM == -2) {
                dvT();
                return true;
            } else if (this.mpM == -3) {
                dvU();
                return true;
            } else {
                if (this.mpD && (this.mpT || this.mpQ == 2)) {
                    dvV();
                }
                return false;
            }
        }
        if (this.mpF && this.mpS) {
            try {
                a = a(j, j2, this.mpy, this.mbR[this.mpM], this.mpM, this.mpv.flags, this.mpv.presentationTimeUs, this.mpN);
            } catch (IllegalStateException e2) {
                dvV();
                if (this.mpU) {
                    dvP();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.mpy, this.mbR[this.mpM], this.mpM, this.mpv.flags, this.mpv.presentationTimeUs, this.mpN);
        }
        if (a) {
            fX(this.mpv.presentationTimeUs);
            this.mpM = -1;
            return true;
        }
        return false;
    }

    private void dvT() throws ExoPlaybackException {
        MediaFormat outputFormat = this.mpy.getOutputFormat();
        if (this.mpA != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mpI = true;
            return;
        }
        if (this.mpG) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.mpy, outputFormat);
    }

    private void dvU() {
        this.mbR = this.mpy.getOutputBuffers();
    }

    protected void duo() throws ExoPlaybackException {
    }

    private void dvV() throws ExoPlaybackException {
        if (this.mpQ == 2) {
            dvP();
            dvM();
            return;
        }
        this.mpU = true;
        duo();
    }

    private boolean fY(long j) {
        int size = this.mpu.size();
        for (int i = 0; i < size; i++) {
            if (this.mpu.get(i).longValue() == j) {
                this.mpu.remove(i);
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
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mHL) || "flounder_lte".equals(v.mHL) || "grouper".equals(v.mHL) || "tilapia".equals(v.mHL)))) {
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
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mHL) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean PB(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
