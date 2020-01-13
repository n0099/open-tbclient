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
/* loaded from: classes5.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.a {
    private static final byte[] moD = v.Qs("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lXE;
    private Format lYL;
    private ByteBuffer[] mbg;
    private final b moE;
    private final boolean moF;
    private final e moG;
    private final e moH;
    private final m moI;
    private final List<Long> moJ;
    private final MediaCodec.BufferInfo moK;
    private DrmSession<c> moL;
    private DrmSession<c> moM;
    private MediaCodec moN;
    private a moO;
    private int moP;
    private boolean moQ;
    private boolean moR;
    private boolean moS;
    private boolean moT;
    private boolean moU;
    private boolean moV;
    private boolean moW;
    private boolean moX;
    private ByteBuffer[] moY;
    private long moZ;
    private int mpa;
    private int mpb;
    private boolean mpc;
    private boolean mpd;
    private int mpe;
    private int mpf;
    private boolean mpg;
    private boolean mph;
    private boolean mpi;
    private boolean mpj;
    private boolean mpk;
    private boolean mpl;
    protected d mpm;

    protected abstract int a(b bVar, com.google.android.exoplayer2.drm.a<c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    protected abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    /* loaded from: classes5.dex */
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
        this.moE = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lXE = aVar;
        this.moF = z;
        this.moG = new e(0);
        this.moH = e.dtn();
        this.moI = new m();
        this.moJ = new ArrayList();
        this.moK = new MediaCodec.BufferInfo();
        this.mpe = 0;
        this.mpf = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int drx() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.moE, this.lXE, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void duA() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.moN == null && this.lYL != null) {
            this.moL = this.moM;
            String str = this.lYL.sampleMimeType;
            if (this.moL != null) {
                c dtz = this.moL.dtz();
                if (dtz == null) {
                    DrmSession.DrmSessionException dty = this.moL.dty();
                    if (dty != null) {
                        throw ExoPlaybackException.createForRenderer(dty, getIndex());
                    }
                    return;
                }
                MediaCrypto dtA = dtz.dtA();
                z = dtz.Pe(str);
                mediaCrypto = dtA;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.moO == null) {
                try {
                    this.moO = a(this.moE, this.lYL, z);
                    if (this.moO == null && z) {
                        this.moO = a(this.moE, this.lYL, false);
                        if (this.moO != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.moO.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lYL, e, z, -49998));
                }
                if (this.moO == null) {
                    a(new DecoderInitializationException(this.lYL, (Throwable) null, z, -49999));
                }
            }
            if (a(this.moO)) {
                String str2 = this.moO.name;
                this.moP = Pl(str2);
                this.moQ = a(str2, this.lYL);
                this.moR = Pk(str2);
                this.moS = Pm(str2);
                this.moT = Pn(str2);
                this.moU = Po(str2);
                this.moV = b(str2, this.lYL);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.moN = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.moO, this.moN, this.lYL, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.moN.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.moY = this.moN.getInputBuffers();
                    this.mbg = this.moN.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lYL, e2, z, str2));
                }
                this.moZ = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mpa = -1;
                this.mpb = -1;
                this.mpl = true;
                this.mpm.mcG++;
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
    public final MediaCodec duB() {
        return this.moN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a duC() {
        return this.moO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vt(boolean z) throws ExoPlaybackException {
        this.mpm = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void j(long j, boolean z) throws ExoPlaybackException {
        this.mpi = false;
        this.mpj = false;
        if (this.moN != null) {
            duE();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dry() {
        this.lYL = null;
        try {
            duD();
            try {
                if (this.moL != null) {
                    this.lXE.a(this.moL);
                }
                try {
                    if (this.moM != null && this.moM != this.moL) {
                        this.lXE.a(this.moM);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.moM != null && this.moM != this.moL) {
                        this.lXE.a(this.moM);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.moL != null) {
                    this.lXE.a(this.moL);
                }
                try {
                    if (this.moM != null && this.moM != this.moL) {
                        this.lXE.a(this.moM);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.moM != null && this.moM != this.moL) {
                        this.lXE.a(this.moM);
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
    public void duD() {
        this.moZ = -9223372036854775807L;
        this.mpa = -1;
        this.mpb = -1;
        this.mpk = false;
        this.mpc = false;
        this.moJ.clear();
        this.moY = null;
        this.mbg = null;
        this.moO = null;
        this.mpd = false;
        this.mpg = false;
        this.moQ = false;
        this.moR = false;
        this.moP = 0;
        this.moS = false;
        this.moT = false;
        this.moV = false;
        this.moW = false;
        this.moX = false;
        this.mph = false;
        this.mpe = 0;
        this.mpf = 0;
        this.moG.data = null;
        if (this.moN != null) {
            this.mpm.mcH++;
            try {
                this.moN.stop();
                try {
                    this.moN.release();
                    this.moN = null;
                    if (this.moL == null || this.moM == this.moL) {
                        return;
                    }
                    try {
                        this.lXE.a(this.moL);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.moN = null;
                    if (this.moL != null && this.moM != this.moL) {
                        try {
                            this.lXE.a(this.moL);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.moN.release();
                    this.moN = null;
                    if (this.moL != null && this.moM != this.moL) {
                        try {
                            this.lXE.a(this.moL);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.moN = null;
                    if (this.moL != null && this.moM != this.moL) {
                        try {
                            this.lXE.a(this.moL);
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
    public void N(long j, long j2) throws ExoPlaybackException {
        if (this.mpj) {
            dtb();
            return;
        }
        if (this.lYL == null) {
            this.moH.clear();
            int a = a(this.moI, this.moH, true);
            if (a == -5) {
                g(this.moI.lYL);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.moH.dtf());
                this.mpi = true;
                duJ();
                return;
            } else {
                return;
            }
        }
        duA();
        if (this.moN != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (R(j, j2));
            do {
            } while (duF());
            t.endSection();
        } else {
            this.mpm.mcJ += fo(j);
            this.moH.clear();
            int a2 = a(this.moI, this.moH, false);
            if (a2 == -5) {
                g(this.moI.lYL);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.moH.dtf());
                this.mpi = true;
                duJ();
            }
        }
        this.mpm.dtm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void duE() throws ExoPlaybackException {
        this.moZ = -9223372036854775807L;
        this.mpa = -1;
        this.mpb = -1;
        this.mpl = true;
        this.mpk = false;
        this.mpc = false;
        this.moJ.clear();
        this.moW = false;
        this.moX = false;
        if (this.moR || (this.moT && this.mph)) {
            duD();
            duA();
        } else if (this.mpf != 0) {
            duD();
            duA();
        } else {
            this.moN.flush();
            this.mpg = false;
        }
        if (this.mpd && this.lYL != null) {
            this.mpe = 1;
        }
    }

    private boolean duF() throws ExoPlaybackException {
        int position;
        int a;
        if (this.moN == null || this.mpf == 2 || this.mpi) {
            return false;
        }
        if (this.mpa < 0) {
            this.mpa = this.moN.dequeueInputBuffer(0L);
            if (this.mpa < 0) {
                return false;
            }
            this.moG.data = this.moY[this.mpa];
            this.moG.clear();
        }
        if (this.mpf == 1) {
            if (!this.moS) {
                this.mph = true;
                this.moN.queueInputBuffer(this.mpa, 0, 0, 0L, 4);
                this.mpa = -1;
            }
            this.mpf = 2;
            return false;
        } else if (this.moW) {
            this.moW = false;
            this.moG.data.put(moD);
            this.moN.queueInputBuffer(this.mpa, 0, moD.length, 0L, 0);
            this.mpa = -1;
            this.mpg = true;
            return true;
        } else {
            if (this.mpk) {
                a = -4;
                position = 0;
            } else {
                if (this.mpe == 1) {
                    for (int i = 0; i < this.lYL.initializationData.size(); i++) {
                        this.moG.data.put(this.lYL.initializationData.get(i));
                    }
                    this.mpe = 2;
                }
                position = this.moG.data.position();
                a = a(this.moI, this.moG, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mpe == 2) {
                        this.moG.clear();
                        this.mpe = 1;
                    }
                    g(this.moI.lYL);
                    return true;
                } else if (this.moG.dtf()) {
                    if (this.mpe == 2) {
                        this.moG.clear();
                        this.mpe = 1;
                    }
                    this.mpi = true;
                    if (!this.mpg) {
                        duJ();
                        return false;
                    }
                    try {
                        if (this.moS) {
                            return false;
                        }
                        this.mph = true;
                        this.moN.queueInputBuffer(this.mpa, 0, 0, 0L, 4);
                        this.mpa = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mpl && !this.moG.dtg()) {
                    this.moG.clear();
                    if (this.mpe == 2) {
                        this.mpe = 1;
                    }
                    return true;
                } else {
                    this.mpl = false;
                    boolean dtp = this.moG.dtp();
                    this.mpk = vC(dtp);
                    if (this.mpk) {
                        return false;
                    }
                    if (this.moQ && !dtp) {
                        j.k(this.moG.data);
                        if (this.moG.data.position() == 0) {
                            return true;
                        }
                        this.moQ = false;
                    }
                    try {
                        long j = this.moG.mcQ;
                        if (this.moG.dte()) {
                            this.moJ.add(Long.valueOf(j));
                        }
                        this.moG.dtq();
                        c(this.moG);
                        if (dtp) {
                            this.moN.queueSecureInputBuffer(this.mpa, 0, a(this.moG, position), j, 0);
                        } else {
                            this.moN.queueInputBuffer(this.mpa, 0, this.moG.data.limit(), j, 0);
                        }
                        this.mpa = -1;
                        this.mpg = true;
                        this.mpe = 0;
                        this.mpm.mcI++;
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
        MediaCodec.CryptoInfo dth = eVar.mcP.dth();
        if (i != 0) {
            if (dth.numBytesOfClearData == null) {
                dth.numBytesOfClearData = new int[1];
            }
            int[] iArr = dth.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return dth;
    }

    private boolean vC(boolean z) throws ExoPlaybackException {
        if (this.moL == null || (!z && this.moF)) {
            return false;
        }
        int state = this.moL.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.moL.dty(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lYL;
        this.lYL = format;
        if (!v.h(this.lYL.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lYL.drmInitData != null) {
                if (this.lXE == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.moM = this.lXE.a(Looper.myLooper(), this.lYL.drmInitData);
                if (this.moM == this.moL) {
                    this.lXE.a(this.moM);
                }
            } else {
                this.moM = null;
            }
        }
        if (this.moM == this.moL && this.moN != null && a(this.moN, this.moO.moB, format2, this.lYL)) {
            this.mpd = true;
            this.mpe = 1;
            this.moW = this.moP == 2 || (this.moP == 1 && this.lYL.width == format2.width && this.lYL.height == format2.height);
        } else if (this.mpg) {
            this.mpf = 1;
        } else {
            duD();
            duA();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    protected void c(e eVar) {
    }

    protected void fZ(long j) {
    }

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean atB() {
        return this.mpj;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lYL == null || this.mpk || (!cRQ() && this.mpb < 0 && (this.moZ == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.moZ))) ? false : true;
    }

    protected long duG() {
        return 0L;
    }

    private boolean R(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mpb < 0) {
            if (this.moU && this.mph) {
                try {
                    this.mpb = this.moN.dequeueOutputBuffer(this.moK, duG());
                } catch (IllegalStateException e) {
                    duJ();
                    if (this.mpj) {
                        duD();
                    }
                    return false;
                }
            } else {
                this.mpb = this.moN.dequeueOutputBuffer(this.moK, duG());
            }
            if (this.mpb >= 0) {
                if (this.moX) {
                    this.moX = false;
                    this.moN.releaseOutputBuffer(this.mpb, false);
                    this.mpb = -1;
                    return true;
                } else if ((this.moK.flags & 4) != 0) {
                    duJ();
                    this.mpb = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mbg[this.mpb];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.moK.offset);
                        byteBuffer.limit(this.moK.offset + this.moK.size);
                    }
                    this.mpc = ga(this.moK.presentationTimeUs);
                }
            } else if (this.mpb == -2) {
                duH();
                return true;
            } else if (this.mpb == -3) {
                duI();
                return true;
            } else {
                if (this.moS && (this.mpi || this.mpf == 2)) {
                    duJ();
                }
                return false;
            }
        }
        if (this.moU && this.mph) {
            try {
                a = a(j, j2, this.moN, this.mbg[this.mpb], this.mpb, this.moK.flags, this.moK.presentationTimeUs, this.mpc);
            } catch (IllegalStateException e2) {
                duJ();
                if (this.mpj) {
                    duD();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.moN, this.mbg[this.mpb], this.mpb, this.moK.flags, this.moK.presentationTimeUs, this.mpc);
        }
        if (a) {
            fZ(this.moK.presentationTimeUs);
            this.mpb = -1;
            return true;
        }
        return false;
    }

    private void duH() throws ExoPlaybackException {
        MediaFormat outputFormat = this.moN.getOutputFormat();
        if (this.moP != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.moX = true;
            return;
        }
        if (this.moV) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.moN, outputFormat);
    }

    private void duI() {
        this.mbg = this.moN.getOutputBuffers();
    }

    protected void dtb() throws ExoPlaybackException {
    }

    private void duJ() throws ExoPlaybackException {
        if (this.mpf == 2) {
            duD();
            duA();
            return;
        }
        this.mpj = true;
        dtb();
    }

    private boolean ga(long j) {
        int size = this.moJ.size();
        for (int i = 0; i < size; i++) {
            if (this.moJ.get(i).longValue() == j) {
                this.moJ.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean Pk(String str) {
        return v.SDK_INT < 18 || (v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.SDK_INT == 19 && v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int Pl(String str) {
        if (v.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (v.MODEL.startsWith("SM-T585") || v.MODEL.startsWith("SM-A510") || v.MODEL.startsWith("SM-A520") || v.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mHb) || "flounder_lte".equals(v.mHb) || "grouper".equals(v.mHb) || "tilapia".equals(v.mHb)))) {
            return 1;
        }
        return 0;
    }

    private static boolean a(String str, Format format) {
        return v.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean Pm(String str) {
        return v.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean Pn(String str) {
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mHb) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean Po(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
