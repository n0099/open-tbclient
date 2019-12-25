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
/* loaded from: classes4.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.a {
    private static final byte[] mkO = v.Qh("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> lTN;
    private Format lUU;
    private ByteBuffer[] lXo;
    private final b mkP;
    private final boolean mkQ;
    private final e mkR;
    private final e mkS;
    private final m mkT;
    private final List<Long> mkU;
    private final MediaCodec.BufferInfo mkV;
    private DrmSession<c> mkW;
    private DrmSession<c> mkX;
    private MediaCodec mkY;
    private a mkZ;
    private int mla;
    private boolean mlb;
    private boolean mlc;
    private boolean mld;
    private boolean mle;
    private boolean mlf;
    private boolean mlg;
    private boolean mlh;
    private boolean mli;
    private ByteBuffer[] mlj;
    private long mlk;
    private int mll;
    private int mlm;
    private boolean mln;
    private boolean mlo;
    private int mlp;
    private int mlq;
    private boolean mlr;
    private boolean mls;
    private boolean mlt;
    private boolean mlu;
    private boolean mlv;
    private boolean mlw;
    protected d mlx;

    protected abstract int a(b bVar, com.google.android.exoplayer2.drm.a<c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    protected abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    /* loaded from: classes4.dex */
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
        this.mkP = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.lTN = aVar;
        this.mkQ = z;
        this.mkR = new e(0);
        this.mkS = e.dsb();
        this.mkT = new m();
        this.mkU = new ArrayList();
        this.mkV = new MediaCodec.BufferInfo();
        this.mlp = 0;
        this.mlq = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int dql() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.mkP, this.lTN, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dtp() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.mkY == null && this.lUU != null) {
            this.mkW = this.mkX;
            String str = this.lUU.sampleMimeType;
            if (this.mkW != null) {
                c dsn = this.mkW.dsn();
                if (dsn == null) {
                    DrmSession.DrmSessionException dsm = this.mkW.dsm();
                    if (dsm != null) {
                        throw ExoPlaybackException.createForRenderer(dsm, getIndex());
                    }
                    return;
                }
                MediaCrypto dso = dsn.dso();
                z = dsn.OT(str);
                mediaCrypto = dso;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.mkZ == null) {
                try {
                    this.mkZ = a(this.mkP, this.lUU, z);
                    if (this.mkZ == null && z) {
                        this.mkZ = a(this.mkP, this.lUU, false);
                        if (this.mkZ != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.mkZ.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.lUU, e, z, -49998));
                }
                if (this.mkZ == null) {
                    a(new DecoderInitializationException(this.lUU, (Throwable) null, z, -49999));
                }
            }
            if (a(this.mkZ)) {
                String str2 = this.mkZ.name;
                this.mla = Pa(str2);
                this.mlb = a(str2, this.lUU);
                this.mlc = OZ(str2);
                this.mld = Pb(str2);
                this.mle = Pc(str2);
                this.mlf = Pd(str2);
                this.mlg = b(str2, this.lUU);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.mkY = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.mkZ, this.mkY, this.lUU, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.mkY.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mlj = this.mkY.getInputBuffers();
                    this.lXo = this.mkY.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.lUU, e2, z, str2));
                }
                this.mlk = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mll = -1;
                this.mlm = -1;
                this.mlw = true;
                this.mlx.lYO++;
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
    public final MediaCodec dtq() {
        return this.mkY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a dtr() {
        return this.mkZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vh(boolean z) throws ExoPlaybackException {
        this.mlx = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void j(long j, boolean z) throws ExoPlaybackException {
        this.mlt = false;
        this.mlu = false;
        if (this.mkY != null) {
            dtt();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dqm() {
        this.lUU = null;
        try {
            dts();
            try {
                if (this.mkW != null) {
                    this.lTN.a(this.mkW);
                }
                try {
                    if (this.mkX != null && this.mkX != this.mkW) {
                        this.lTN.a(this.mkX);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mkX != null && this.mkX != this.mkW) {
                        this.lTN.a(this.mkX);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.mkW != null) {
                    this.lTN.a(this.mkW);
                }
                try {
                    if (this.mkX != null && this.mkX != this.mkW) {
                        this.lTN.a(this.mkX);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mkX != null && this.mkX != this.mkW) {
                        this.lTN.a(this.mkX);
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
    public void dts() {
        this.mlk = -9223372036854775807L;
        this.mll = -1;
        this.mlm = -1;
        this.mlv = false;
        this.mln = false;
        this.mkU.clear();
        this.mlj = null;
        this.lXo = null;
        this.mkZ = null;
        this.mlo = false;
        this.mlr = false;
        this.mlb = false;
        this.mlc = false;
        this.mla = 0;
        this.mld = false;
        this.mle = false;
        this.mlg = false;
        this.mlh = false;
        this.mli = false;
        this.mls = false;
        this.mlp = 0;
        this.mlq = 0;
        this.mkR.data = null;
        if (this.mkY != null) {
            this.mlx.lYP++;
            try {
                this.mkY.stop();
                try {
                    this.mkY.release();
                    this.mkY = null;
                    if (this.mkW == null || this.mkX == this.mkW) {
                        return;
                    }
                    try {
                        this.lTN.a(this.mkW);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.mkY = null;
                    if (this.mkW != null && this.mkX != this.mkW) {
                        try {
                            this.lTN.a(this.mkW);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.mkY.release();
                    this.mkY = null;
                    if (this.mkW != null && this.mkX != this.mkW) {
                        try {
                            this.lTN.a(this.mkW);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.mkY = null;
                    if (this.mkW != null && this.mkX != this.mkW) {
                        try {
                            this.lTN.a(this.mkW);
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
        if (this.mlu) {
            drP();
            return;
        }
        if (this.lUU == null) {
            this.mkS.clear();
            int a = a(this.mkT, this.mkS, true);
            if (a == -5) {
                g(this.mkT.lUU);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mkS.drT());
                this.mlt = true;
                dty();
                return;
            } else {
                return;
            }
        }
        dtp();
        if (this.mkY != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (R(j, j2));
            do {
            } while (dtu());
            t.endSection();
        } else {
            this.mlx.lYR += fj(j);
            this.mkS.clear();
            int a2 = a(this.mkT, this.mkS, false);
            if (a2 == -5) {
                g(this.mkT.lUU);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mkS.drT());
                this.mlt = true;
                dty();
            }
        }
        this.mlx.dsa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dtt() throws ExoPlaybackException {
        this.mlk = -9223372036854775807L;
        this.mll = -1;
        this.mlm = -1;
        this.mlw = true;
        this.mlv = false;
        this.mln = false;
        this.mkU.clear();
        this.mlh = false;
        this.mli = false;
        if (this.mlc || (this.mle && this.mls)) {
            dts();
            dtp();
        } else if (this.mlq != 0) {
            dts();
            dtp();
        } else {
            this.mkY.flush();
            this.mlr = false;
        }
        if (this.mlo && this.lUU != null) {
            this.mlp = 1;
        }
    }

    private boolean dtu() throws ExoPlaybackException {
        int position;
        int a;
        if (this.mkY == null || this.mlq == 2 || this.mlt) {
            return false;
        }
        if (this.mll < 0) {
            this.mll = this.mkY.dequeueInputBuffer(0L);
            if (this.mll < 0) {
                return false;
            }
            this.mkR.data = this.mlj[this.mll];
            this.mkR.clear();
        }
        if (this.mlq == 1) {
            if (!this.mld) {
                this.mls = true;
                this.mkY.queueInputBuffer(this.mll, 0, 0, 0L, 4);
                this.mll = -1;
            }
            this.mlq = 2;
            return false;
        } else if (this.mlh) {
            this.mlh = false;
            this.mkR.data.put(mkO);
            this.mkY.queueInputBuffer(this.mll, 0, mkO.length, 0L, 0);
            this.mll = -1;
            this.mlr = true;
            return true;
        } else {
            if (this.mlv) {
                a = -4;
                position = 0;
            } else {
                if (this.mlp == 1) {
                    for (int i = 0; i < this.lUU.initializationData.size(); i++) {
                        this.mkR.data.put(this.lUU.initializationData.get(i));
                    }
                    this.mlp = 2;
                }
                position = this.mkR.data.position();
                a = a(this.mkT, this.mkR, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mlp == 2) {
                        this.mkR.clear();
                        this.mlp = 1;
                    }
                    g(this.mkT.lUU);
                    return true;
                } else if (this.mkR.drT()) {
                    if (this.mlp == 2) {
                        this.mkR.clear();
                        this.mlp = 1;
                    }
                    this.mlt = true;
                    if (!this.mlr) {
                        dty();
                        return false;
                    }
                    try {
                        if (this.mld) {
                            return false;
                        }
                        this.mls = true;
                        this.mkY.queueInputBuffer(this.mll, 0, 0, 0L, 4);
                        this.mll = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mlw && !this.mkR.drU()) {
                    this.mkR.clear();
                    if (this.mlp == 2) {
                        this.mlp = 1;
                    }
                    return true;
                } else {
                    this.mlw = false;
                    boolean dsd = this.mkR.dsd();
                    this.mlv = vq(dsd);
                    if (this.mlv) {
                        return false;
                    }
                    if (this.mlb && !dsd) {
                        j.k(this.mkR.data);
                        if (this.mkR.data.position() == 0) {
                            return true;
                        }
                        this.mlb = false;
                    }
                    try {
                        long j = this.mkR.lYY;
                        if (this.mkR.drS()) {
                            this.mkU.add(Long.valueOf(j));
                        }
                        this.mkR.dse();
                        c(this.mkR);
                        if (dsd) {
                            this.mkY.queueSecureInputBuffer(this.mll, 0, a(this.mkR, position), j, 0);
                        } else {
                            this.mkY.queueInputBuffer(this.mll, 0, this.mkR.data.limit(), j, 0);
                        }
                        this.mll = -1;
                        this.mlr = true;
                        this.mlp = 0;
                        this.mlx.lYQ++;
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
        MediaCodec.CryptoInfo drV = eVar.lYX.drV();
        if (i != 0) {
            if (drV.numBytesOfClearData == null) {
                drV.numBytesOfClearData = new int[1];
            }
            int[] iArr = drV.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return drV;
    }

    private boolean vq(boolean z) throws ExoPlaybackException {
        if (this.mkW == null || (!z && this.mkQ)) {
            return false;
        }
        int state = this.mkW.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.mkW.dsm(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.lUU;
        this.lUU = format;
        if (!v.h(this.lUU.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.lUU.drmInitData != null) {
                if (this.lTN == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.mkX = this.lTN.a(Looper.myLooper(), this.lUU.drmInitData);
                if (this.mkX == this.mkW) {
                    this.lTN.a(this.mkX);
                }
            } else {
                this.mkX = null;
            }
        }
        if (this.mkX == this.mkW && this.mkY != null && a(this.mkY, this.mkZ.mkM, format2, this.lUU)) {
            this.mlo = true;
            this.mlp = 1;
            this.mlh = this.mla == 2 || (this.mla == 1 && this.lUU.width == format2.width && this.lUU.height == format2.height);
        } else if (this.mlr) {
            this.mlq = 1;
        } else {
            dts();
            dtp();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    protected void c(e eVar) {
    }

    protected void fU(long j) {
    }

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean ati() {
        return this.mlu;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.lUU == null || this.mlv || (!cQN() && this.mlm < 0 && (this.mlk == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mlk))) ? false : true;
    }

    protected long dtv() {
        return 0L;
    }

    private boolean R(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mlm < 0) {
            if (this.mlf && this.mls) {
                try {
                    this.mlm = this.mkY.dequeueOutputBuffer(this.mkV, dtv());
                } catch (IllegalStateException e) {
                    dty();
                    if (this.mlu) {
                        dts();
                    }
                    return false;
                }
            } else {
                this.mlm = this.mkY.dequeueOutputBuffer(this.mkV, dtv());
            }
            if (this.mlm >= 0) {
                if (this.mli) {
                    this.mli = false;
                    this.mkY.releaseOutputBuffer(this.mlm, false);
                    this.mlm = -1;
                    return true;
                } else if ((this.mkV.flags & 4) != 0) {
                    dty();
                    this.mlm = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.lXo[this.mlm];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.mkV.offset);
                        byteBuffer.limit(this.mkV.offset + this.mkV.size);
                    }
                    this.mln = fV(this.mkV.presentationTimeUs);
                }
            } else if (this.mlm == -2) {
                dtw();
                return true;
            } else if (this.mlm == -3) {
                dtx();
                return true;
            } else {
                if (this.mld && (this.mlt || this.mlq == 2)) {
                    dty();
                }
                return false;
            }
        }
        if (this.mlf && this.mls) {
            try {
                a = a(j, j2, this.mkY, this.lXo[this.mlm], this.mlm, this.mkV.flags, this.mkV.presentationTimeUs, this.mln);
            } catch (IllegalStateException e2) {
                dty();
                if (this.mlu) {
                    dts();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.mkY, this.lXo[this.mlm], this.mlm, this.mkV.flags, this.mkV.presentationTimeUs, this.mln);
        }
        if (a) {
            fU(this.mkV.presentationTimeUs);
            this.mlm = -1;
            return true;
        }
        return false;
    }

    private void dtw() throws ExoPlaybackException {
        MediaFormat outputFormat = this.mkY.getOutputFormat();
        if (this.mla != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mli = true;
            return;
        }
        if (this.mlg) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.mkY, outputFormat);
    }

    private void dtx() {
        this.lXo = this.mkY.getOutputBuffers();
    }

    protected void drP() throws ExoPlaybackException {
    }

    private void dty() throws ExoPlaybackException {
        if (this.mlq == 2) {
            dts();
            dtp();
            return;
        }
        this.mlu = true;
        drP();
    }

    private boolean fV(long j) {
        int size = this.mkU.size();
        for (int i = 0; i < size; i++) {
            if (this.mkU.get(i).longValue() == j) {
                this.mkU.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean OZ(String str) {
        return v.SDK_INT < 18 || (v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.SDK_INT == 19 && v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int Pa(String str) {
        if (v.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (v.MODEL.startsWith("SM-T585") || v.MODEL.startsWith("SM-A510") || v.MODEL.startsWith("SM-A520") || v.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mDl) || "flounder_lte".equals(v.mDl) || "grouper".equals(v.mDl) || "tilapia".equals(v.mDl)))) {
            return 1;
        }
        return 0;
    }

    private static boolean a(String str, Format format) {
        return v.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean Pb(String str) {
        return v.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean Pc(String str) {
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mDl) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean Pd(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
