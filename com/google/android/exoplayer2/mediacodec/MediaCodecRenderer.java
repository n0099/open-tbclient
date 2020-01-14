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
    private static final byte[] moI = v.Qs("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lXJ;
    private Format lYQ;
    private ByteBuffer[] mbl;
    private final b moJ;
    private final boolean moK;
    private final e moL;
    private final e moM;
    private final m moN;
    private final List<Long> moO;
    private final MediaCodec.BufferInfo moP;
    private DrmSession<c> moQ;
    private DrmSession<c> moR;
    private MediaCodec moS;
    private a moT;
    private int moU;
    private boolean moV;
    private boolean moW;
    private boolean moX;
    private boolean moY;
    private boolean moZ;
    private boolean mpa;
    private boolean mpb;
    private boolean mpc;
    private ByteBuffer[] mpd;
    private long mpe;
    private int mpf;
    private int mpg;
    private boolean mph;
    private boolean mpi;
    private int mpj;
    private int mpk;
    private boolean mpl;
    private boolean mpm;
    private boolean mpn;
    private boolean mpo;
    private boolean mpp;
    private boolean mpq;
    protected d mpr;

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
        this.moJ = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lXJ = aVar;
        this.moK = z;
        this.moL = new e(0);
        this.moM = e.dtp();
        this.moN = new m();
        this.moO = new ArrayList();
        this.moP = new MediaCodec.BufferInfo();
        this.mpj = 0;
        this.mpk = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int drz() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.moJ, this.lXJ, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void duC() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.moS == null && this.lYQ != null) {
            this.moQ = this.moR;
            String str = this.lYQ.sampleMimeType;
            if (this.moQ != null) {
                c dtB = this.moQ.dtB();
                if (dtB == null) {
                    DrmSession.DrmSessionException dtA = this.moQ.dtA();
                    if (dtA != null) {
                        throw ExoPlaybackException.createForRenderer(dtA, getIndex());
                    }
                    return;
                }
                MediaCrypto dtC = dtB.dtC();
                z = dtB.Pe(str);
                mediaCrypto = dtC;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.moT == null) {
                try {
                    this.moT = a(this.moJ, this.lYQ, z);
                    if (this.moT == null && z) {
                        this.moT = a(this.moJ, this.lYQ, false);
                        if (this.moT != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.moT.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lYQ, e, z, -49998));
                }
                if (this.moT == null) {
                    a(new DecoderInitializationException(this.lYQ, (Throwable) null, z, -49999));
                }
            }
            if (a(this.moT)) {
                String str2 = this.moT.name;
                this.moU = Pl(str2);
                this.moV = a(str2, this.lYQ);
                this.moW = Pk(str2);
                this.moX = Pm(str2);
                this.moY = Pn(str2);
                this.moZ = Po(str2);
                this.mpa = b(str2, this.lYQ);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.moS = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.moT, this.moS, this.lYQ, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.moS.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mpd = this.moS.getInputBuffers();
                    this.mbl = this.moS.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lYQ, e2, z, str2));
                }
                this.mpe = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mpf = -1;
                this.mpg = -1;
                this.mpq = true;
                this.mpr.mcL++;
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
    public final MediaCodec duD() {
        return this.moS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a duE() {
        return this.moT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vt(boolean z) throws ExoPlaybackException {
        this.mpr = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void j(long j, boolean z) throws ExoPlaybackException {
        this.mpn = false;
        this.mpo = false;
        if (this.moS != null) {
            duG();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void drA() {
        this.lYQ = null;
        try {
            duF();
            try {
                if (this.moQ != null) {
                    this.lXJ.a(this.moQ);
                }
                try {
                    if (this.moR != null && this.moR != this.moQ) {
                        this.lXJ.a(this.moR);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.moR != null && this.moR != this.moQ) {
                        this.lXJ.a(this.moR);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.moQ != null) {
                    this.lXJ.a(this.moQ);
                }
                try {
                    if (this.moR != null && this.moR != this.moQ) {
                        this.lXJ.a(this.moR);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.moR != null && this.moR != this.moQ) {
                        this.lXJ.a(this.moR);
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
    public void duF() {
        this.mpe = -9223372036854775807L;
        this.mpf = -1;
        this.mpg = -1;
        this.mpp = false;
        this.mph = false;
        this.moO.clear();
        this.mpd = null;
        this.mbl = null;
        this.moT = null;
        this.mpi = false;
        this.mpl = false;
        this.moV = false;
        this.moW = false;
        this.moU = 0;
        this.moX = false;
        this.moY = false;
        this.mpa = false;
        this.mpb = false;
        this.mpc = false;
        this.mpm = false;
        this.mpj = 0;
        this.mpk = 0;
        this.moL.data = null;
        if (this.moS != null) {
            this.mpr.mcM++;
            try {
                this.moS.stop();
                try {
                    this.moS.release();
                    this.moS = null;
                    if (this.moQ == null || this.moR == this.moQ) {
                        return;
                    }
                    try {
                        this.lXJ.a(this.moQ);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.moS = null;
                    if (this.moQ != null && this.moR != this.moQ) {
                        try {
                            this.lXJ.a(this.moQ);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.moS.release();
                    this.moS = null;
                    if (this.moQ != null && this.moR != this.moQ) {
                        try {
                            this.lXJ.a(this.moQ);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.moS = null;
                    if (this.moQ != null && this.moR != this.moQ) {
                        try {
                            this.lXJ.a(this.moQ);
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
        if (this.mpo) {
            dtd();
            return;
        }
        if (this.lYQ == null) {
            this.moM.clear();
            int a = a(this.moN, this.moM, true);
            if (a == -5) {
                g(this.moN.lYQ);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.moM.dth());
                this.mpn = true;
                duL();
                return;
            } else {
                return;
            }
        }
        duC();
        if (this.moS != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (R(j, j2));
            do {
            } while (duH());
            t.endSection();
        } else {
            this.mpr.mcO += fo(j);
            this.moM.clear();
            int a2 = a(this.moN, this.moM, false);
            if (a2 == -5) {
                g(this.moN.lYQ);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.moM.dth());
                this.mpn = true;
                duL();
            }
        }
        this.mpr.dto();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void duG() throws ExoPlaybackException {
        this.mpe = -9223372036854775807L;
        this.mpf = -1;
        this.mpg = -1;
        this.mpq = true;
        this.mpp = false;
        this.mph = false;
        this.moO.clear();
        this.mpb = false;
        this.mpc = false;
        if (this.moW || (this.moY && this.mpm)) {
            duF();
            duC();
        } else if (this.mpk != 0) {
            duF();
            duC();
        } else {
            this.moS.flush();
            this.mpl = false;
        }
        if (this.mpi && this.lYQ != null) {
            this.mpj = 1;
        }
    }

    private boolean duH() throws ExoPlaybackException {
        int position;
        int a;
        if (this.moS == null || this.mpk == 2 || this.mpn) {
            return false;
        }
        if (this.mpf < 0) {
            this.mpf = this.moS.dequeueInputBuffer(0L);
            if (this.mpf < 0) {
                return false;
            }
            this.moL.data = this.mpd[this.mpf];
            this.moL.clear();
        }
        if (this.mpk == 1) {
            if (!this.moX) {
                this.mpm = true;
                this.moS.queueInputBuffer(this.mpf, 0, 0, 0L, 4);
                this.mpf = -1;
            }
            this.mpk = 2;
            return false;
        } else if (this.mpb) {
            this.mpb = false;
            this.moL.data.put(moI);
            this.moS.queueInputBuffer(this.mpf, 0, moI.length, 0L, 0);
            this.mpf = -1;
            this.mpl = true;
            return true;
        } else {
            if (this.mpp) {
                a = -4;
                position = 0;
            } else {
                if (this.mpj == 1) {
                    for (int i = 0; i < this.lYQ.initializationData.size(); i++) {
                        this.moL.data.put(this.lYQ.initializationData.get(i));
                    }
                    this.mpj = 2;
                }
                position = this.moL.data.position();
                a = a(this.moN, this.moL, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mpj == 2) {
                        this.moL.clear();
                        this.mpj = 1;
                    }
                    g(this.moN.lYQ);
                    return true;
                } else if (this.moL.dth()) {
                    if (this.mpj == 2) {
                        this.moL.clear();
                        this.mpj = 1;
                    }
                    this.mpn = true;
                    if (!this.mpl) {
                        duL();
                        return false;
                    }
                    try {
                        if (this.moX) {
                            return false;
                        }
                        this.mpm = true;
                        this.moS.queueInputBuffer(this.mpf, 0, 0, 0L, 4);
                        this.mpf = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mpq && !this.moL.dti()) {
                    this.moL.clear();
                    if (this.mpj == 2) {
                        this.mpj = 1;
                    }
                    return true;
                } else {
                    this.mpq = false;
                    boolean dtr = this.moL.dtr();
                    this.mpp = vC(dtr);
                    if (this.mpp) {
                        return false;
                    }
                    if (this.moV && !dtr) {
                        j.k(this.moL.data);
                        if (this.moL.data.position() == 0) {
                            return true;
                        }
                        this.moV = false;
                    }
                    try {
                        long j = this.moL.mcV;
                        if (this.moL.dtg()) {
                            this.moO.add(Long.valueOf(j));
                        }
                        this.moL.dts();
                        c(this.moL);
                        if (dtr) {
                            this.moS.queueSecureInputBuffer(this.mpf, 0, a(this.moL, position), j, 0);
                        } else {
                            this.moS.queueInputBuffer(this.mpf, 0, this.moL.data.limit(), j, 0);
                        }
                        this.mpf = -1;
                        this.mpl = true;
                        this.mpj = 0;
                        this.mpr.mcN++;
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
        MediaCodec.CryptoInfo dtj = eVar.mcU.dtj();
        if (i != 0) {
            if (dtj.numBytesOfClearData == null) {
                dtj.numBytesOfClearData = new int[1];
            }
            int[] iArr = dtj.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return dtj;
    }

    private boolean vC(boolean z) throws ExoPlaybackException {
        if (this.moQ == null || (!z && this.moK)) {
            return false;
        }
        int state = this.moQ.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.moQ.dtA(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lYQ;
        this.lYQ = format;
        if (!v.h(this.lYQ.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lYQ.drmInitData != null) {
                if (this.lXJ == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.moR = this.lXJ.a(Looper.myLooper(), this.lYQ.drmInitData);
                if (this.moR == this.moQ) {
                    this.lXJ.a(this.moR);
                }
            } else {
                this.moR = null;
            }
        }
        if (this.moR == this.moQ && this.moS != null && a(this.moS, this.moT.moG, format2, this.lYQ)) {
            this.mpi = true;
            this.mpj = 1;
            this.mpb = this.moU == 2 || (this.moU == 1 && this.lYQ.width == format2.width && this.lYQ.height == format2.height);
        } else if (this.mpl) {
            this.mpk = 1;
        } else {
            duF();
            duC();
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
        return this.mpo;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lYQ == null || this.mpp || (!cRS() && this.mpg < 0 && (this.mpe == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mpe))) ? false : true;
    }

    protected long duI() {
        return 0L;
    }

    private boolean R(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mpg < 0) {
            if (this.moZ && this.mpm) {
                try {
                    this.mpg = this.moS.dequeueOutputBuffer(this.moP, duI());
                } catch (IllegalStateException e) {
                    duL();
                    if (this.mpo) {
                        duF();
                    }
                    return false;
                }
            } else {
                this.mpg = this.moS.dequeueOutputBuffer(this.moP, duI());
            }
            if (this.mpg >= 0) {
                if (this.mpc) {
                    this.mpc = false;
                    this.moS.releaseOutputBuffer(this.mpg, false);
                    this.mpg = -1;
                    return true;
                } else if ((this.moP.flags & 4) != 0) {
                    duL();
                    this.mpg = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mbl[this.mpg];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.moP.offset);
                        byteBuffer.limit(this.moP.offset + this.moP.size);
                    }
                    this.mph = ga(this.moP.presentationTimeUs);
                }
            } else if (this.mpg == -2) {
                duJ();
                return true;
            } else if (this.mpg == -3) {
                duK();
                return true;
            } else {
                if (this.moX && (this.mpn || this.mpk == 2)) {
                    duL();
                }
                return false;
            }
        }
        if (this.moZ && this.mpm) {
            try {
                a = a(j, j2, this.moS, this.mbl[this.mpg], this.mpg, this.moP.flags, this.moP.presentationTimeUs, this.mph);
            } catch (IllegalStateException e2) {
                duL();
                if (this.mpo) {
                    duF();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.moS, this.mbl[this.mpg], this.mpg, this.moP.flags, this.moP.presentationTimeUs, this.mph);
        }
        if (a) {
            fZ(this.moP.presentationTimeUs);
            this.mpg = -1;
            return true;
        }
        return false;
    }

    private void duJ() throws ExoPlaybackException {
        MediaFormat outputFormat = this.moS.getOutputFormat();
        if (this.moU != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mpc = true;
            return;
        }
        if (this.mpa) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.moS, outputFormat);
    }

    private void duK() {
        this.mbl = this.moS.getOutputBuffers();
    }

    protected void dtd() throws ExoPlaybackException {
    }

    private void duL() throws ExoPlaybackException {
        if (this.mpk == 2) {
            duF();
            duC();
            return;
        }
        this.mpo = true;
        dtd();
    }

    private boolean ga(long j) {
        int size = this.moO.size();
        for (int i = 0; i < size; i++) {
            if (this.moO.get(i).longValue() == j) {
                this.moO.remove(i);
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
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mHg) || "flounder_lte".equals(v.mHg) || "grouper".equals(v.mHg) || "tilapia".equals(v.mHg)))) {
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
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mHg) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean Po(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
