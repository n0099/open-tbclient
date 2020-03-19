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
    private static final byte[] mrh = v.QG("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    @Nullable
    private final com.google.android.exoplayer2.drm.a<c> maj;
    private Format mbs;
    private ByteBuffer[] mdK;
    private boolean mrA;
    private boolean mrB;
    private ByteBuffer[] mrC;
    private long mrD;
    private int mrE;
    private int mrF;
    private boolean mrG;
    private boolean mrH;
    private int mrI;
    private int mrJ;
    private boolean mrK;
    private boolean mrL;
    private boolean mrM;
    private boolean mrN;
    private boolean mrO;
    private boolean mrP;
    protected d mrQ;
    private final b mri;
    private final boolean mrj;
    private final e mrk;
    private final e mrl;
    private final m mrm;
    private final List<Long> mrn;
    private final MediaCodec.BufferInfo mro;
    private DrmSession<c> mrp;
    private DrmSession<c> mrq;
    private MediaCodec mrr;
    private a mrs;
    private int mrt;
    private boolean mru;
    private boolean mrv;
    private boolean mrw;
    private boolean mrx;
    private boolean mry;
    private boolean mrz;

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
        this.mri = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        this.maj = aVar;
        this.mrj = z;
        this.mrk = new e(0);
        this.mrl = e.dva();
        this.mrm = new m();
        this.mrn = new ArrayList();
        this.mro = new MediaCodec.BufferInfo();
        this.mrI = 0;
        this.mrJ = 0;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.t
    public final int dtl() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.t
    public final int e(Format format) throws ExoPlaybackException {
        try {
            return a(this.mri, this.maj, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return bVar.aL(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dwm() throws ExoPlaybackException {
        boolean z;
        MediaCrypto mediaCrypto;
        if (this.mrr == null && this.mbs != null) {
            this.mrp = this.mrq;
            String str = this.mbs.sampleMimeType;
            if (this.mrp != null) {
                c dvm = this.mrp.dvm();
                if (dvm == null) {
                    DrmSession.DrmSessionException dvl = this.mrp.dvl();
                    if (dvl != null) {
                        throw ExoPlaybackException.createForRenderer(dvl, getIndex());
                    }
                    return;
                }
                MediaCrypto dvn = dvm.dvn();
                z = dvm.Ps(str);
                mediaCrypto = dvn;
            } else {
                z = false;
                mediaCrypto = null;
            }
            if (this.mrs == null) {
                try {
                    this.mrs = a(this.mri, this.mbs, z);
                    if (this.mrs == null && z) {
                        this.mrs = a(this.mri, this.mbs, false);
                        if (this.mrs != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.mrs.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    a(new DecoderInitializationException(this.mbs, e, z, -49998));
                }
                if (this.mrs == null) {
                    a(new DecoderInitializationException(this.mbs, (Throwable) null, z, -49999));
                }
            }
            if (a(this.mrs)) {
                String str2 = this.mrs.name;
                this.mrt = Pz(str2);
                this.mru = a(str2, this.mbs);
                this.mrv = Py(str2);
                this.mrw = PA(str2);
                this.mrx = PB(str2);
                this.mry = PC(str2);
                this.mrz = b(str2, this.mbs);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:" + str2);
                    this.mrr = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.mrs, this.mrr, this.mbs, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.mrr.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    g(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.mrC = this.mrr.getInputBuffers();
                    this.mdK = this.mrr.getOutputBuffers();
                } catch (Exception e2) {
                    a(new DecoderInitializationException(this.mbs, e2, z, str2));
                }
                this.mrD = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.mrE = -1;
                this.mrF = -1;
                this.mrP = true;
                this.mrQ.mfk++;
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
    public final MediaCodec dwn() {
        return this.mrr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a dwo() {
        return this.mrs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void vE(boolean z) throws ExoPlaybackException {
        this.mrQ = new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void m(long j, boolean z) throws ExoPlaybackException {
        this.mrM = false;
        this.mrN = false;
        if (this.mrr != null) {
            dwq();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=8, 459=4, 460=4, 463=8] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void dtm() {
        this.mbs = null;
        try {
            dwp();
            try {
                if (this.mrp != null) {
                    this.maj.a(this.mrp);
                }
                try {
                    if (this.mrq != null && this.mrq != this.mrp) {
                        this.maj.a(this.mrq);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mrq != null && this.mrq != this.mrp) {
                        this.maj.a(this.mrq);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.mrp != null) {
                    this.maj.a(this.mrp);
                }
                try {
                    if (this.mrq != null && this.mrq != this.mrp) {
                        this.maj.a(this.mrq);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mrq != null && this.mrq != this.mrp) {
                        this.maj.a(this.mrq);
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
    public void dwp() {
        this.mrD = -9223372036854775807L;
        this.mrE = -1;
        this.mrF = -1;
        this.mrO = false;
        this.mrG = false;
        this.mrn.clear();
        this.mrC = null;
        this.mdK = null;
        this.mrs = null;
        this.mrH = false;
        this.mrK = false;
        this.mru = false;
        this.mrv = false;
        this.mrt = 0;
        this.mrw = false;
        this.mrx = false;
        this.mrz = false;
        this.mrA = false;
        this.mrB = false;
        this.mrL = false;
        this.mrI = 0;
        this.mrJ = 0;
        this.mrk.data = null;
        if (this.mrr != null) {
            this.mrQ.mfl++;
            try {
                this.mrr.stop();
                try {
                    this.mrr.release();
                    this.mrr = null;
                    if (this.mrp == null || this.mrq == this.mrp) {
                        return;
                    }
                    try {
                        this.maj.a(this.mrp);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.mrr = null;
                    if (this.mrp != null && this.mrq != this.mrp) {
                        try {
                            this.maj.a(this.mrp);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.mrr.release();
                    this.mrr = null;
                    if (this.mrp != null && this.mrq != this.mrp) {
                        try {
                            this.maj.a(this.mrp);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.mrr = null;
                    if (this.mrp != null && this.mrq != this.mrp) {
                        try {
                            this.maj.a(this.mrp);
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
        if (this.mrN) {
            duO();
            return;
        }
        if (this.mbs == null) {
            this.mrl.clear();
            int a = a(this.mrm, this.mrl, true);
            if (a == -5) {
                g(this.mrm.mbs);
            } else if (a == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mrl.duS());
                this.mrM = true;
                dwv();
                return;
            } else {
                return;
            }
        }
        dwm();
        if (this.mrr != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (Q(j, j2));
            do {
            } while (dwr());
            t.endSection();
        } else {
            this.mrQ.mfn += fn(j);
            this.mrl.clear();
            int a2 = a(this.mrm, this.mrl, false);
            if (a2 == -5) {
                g(this.mrm.mbs);
            } else if (a2 == -4) {
                com.google.android.exoplayer2.util.a.checkState(this.mrl.duS());
                this.mrM = true;
                dwv();
            }
        }
        this.mrQ.duZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwq() throws ExoPlaybackException {
        this.mrD = -9223372036854775807L;
        this.mrE = -1;
        this.mrF = -1;
        this.mrP = true;
        this.mrO = false;
        this.mrG = false;
        this.mrn.clear();
        this.mrA = false;
        this.mrB = false;
        if (this.mrv || (this.mrx && this.mrL)) {
            dwp();
            dwm();
        } else if (this.mrJ != 0) {
            dwp();
            dwm();
        } else {
            this.mrr.flush();
            this.mrK = false;
        }
        if (this.mrH && this.mbs != null) {
            this.mrI = 1;
        }
    }

    private boolean dwr() throws ExoPlaybackException {
        int position;
        int a;
        if (this.mrr == null || this.mrJ == 2 || this.mrM) {
            return false;
        }
        if (this.mrE < 0) {
            this.mrE = this.mrr.dequeueInputBuffer(0L);
            if (this.mrE < 0) {
                return false;
            }
            this.mrk.data = this.mrC[this.mrE];
            this.mrk.clear();
        }
        if (this.mrJ == 1) {
            if (!this.mrw) {
                this.mrL = true;
                this.mrr.queueInputBuffer(this.mrE, 0, 0, 0L, 4);
                this.mrE = -1;
            }
            this.mrJ = 2;
            return false;
        } else if (this.mrA) {
            this.mrA = false;
            this.mrk.data.put(mrh);
            this.mrr.queueInputBuffer(this.mrE, 0, mrh.length, 0L, 0);
            this.mrE = -1;
            this.mrK = true;
            return true;
        } else {
            if (this.mrO) {
                a = -4;
                position = 0;
            } else {
                if (this.mrI == 1) {
                    for (int i = 0; i < this.mbs.initializationData.size(); i++) {
                        this.mrk.data.put(this.mbs.initializationData.get(i));
                    }
                    this.mrI = 2;
                }
                position = this.mrk.data.position();
                a = a(this.mrm, this.mrk, false);
            }
            if (a != -3) {
                if (a == -5) {
                    if (this.mrI == 2) {
                        this.mrk.clear();
                        this.mrI = 1;
                    }
                    g(this.mrm.mbs);
                    return true;
                } else if (this.mrk.duS()) {
                    if (this.mrI == 2) {
                        this.mrk.clear();
                        this.mrI = 1;
                    }
                    this.mrM = true;
                    if (!this.mrK) {
                        dwv();
                        return false;
                    }
                    try {
                        if (this.mrw) {
                            return false;
                        }
                        this.mrL = true;
                        this.mrr.queueInputBuffer(this.mrE, 0, 0, 0L, 4);
                        this.mrE = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.mrP && !this.mrk.duT()) {
                    this.mrk.clear();
                    if (this.mrI == 2) {
                        this.mrI = 1;
                    }
                    return true;
                } else {
                    this.mrP = false;
                    boolean dvc = this.mrk.dvc();
                    this.mrO = vN(dvc);
                    if (this.mrO) {
                        return false;
                    }
                    if (this.mru && !dvc) {
                        j.k(this.mrk.data);
                        if (this.mrk.data.position() == 0) {
                            return true;
                        }
                        this.mru = false;
                    }
                    try {
                        long j = this.mrk.mfu;
                        if (this.mrk.duR()) {
                            this.mrn.add(Long.valueOf(j));
                        }
                        this.mrk.dvd();
                        c(this.mrk);
                        if (dvc) {
                            this.mrr.queueSecureInputBuffer(this.mrE, 0, a(this.mrk, position), j, 0);
                        } else {
                            this.mrr.queueInputBuffer(this.mrE, 0, this.mrk.data.limit(), j, 0);
                        }
                        this.mrE = -1;
                        this.mrK = true;
                        this.mrI = 0;
                        this.mrQ.mfm++;
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
        MediaCodec.CryptoInfo duU = eVar.mft.duU();
        if (i != 0) {
            if (duU.numBytesOfClearData == null) {
                duU.numBytesOfClearData = new int[1];
            }
            int[] iArr = duU.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return duU;
    }

    private boolean vN(boolean z) throws ExoPlaybackException {
        if (this.mrp == null || (!z && this.mrj)) {
            return false;
        }
        int state = this.mrp.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.mrp.dvl(), getIndex());
        }
        return state != 4;
    }

    protected void g(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Format format) throws ExoPlaybackException {
        Format format2 = this.mbs;
        this.mbs = format;
        if (!v.h(this.mbs.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.mbs.drmInitData != null) {
                if (this.maj == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.mrq = this.maj.a(Looper.myLooper(), this.mbs.drmInitData);
                if (this.mrq == this.mrp) {
                    this.maj.a(this.mrq);
                }
            } else {
                this.mrq = null;
            }
        }
        if (this.mrq == this.mrp && this.mrr != null && a(this.mrr, this.mrs.mrf, format2, this.mbs)) {
            this.mrH = true;
            this.mrI = 1;
            this.mrA = this.mrt == 2 || (this.mrt == 1 && this.mbs.width == format2.width && this.mbs.height == format2.height);
        } else if (this.mrK) {
            this.mrJ = 1;
        } else {
            dwp();
            dwm();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    protected void c(e eVar) {
    }

    protected void fY(long j) {
    }

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean avU() {
        return this.mrN;
    }

    @Override // com.google.android.exoplayer2.s
    public boolean isReady() {
        return (this.mbs == null || this.mrO || (!cTK() && this.mrF < 0 && (this.mrD == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.mrD))) ? false : true;
    }

    protected long dws() {
        return 0L;
    }

    private boolean Q(long j, long j2) throws ExoPlaybackException {
        boolean a;
        if (this.mrF < 0) {
            if (this.mry && this.mrL) {
                try {
                    this.mrF = this.mrr.dequeueOutputBuffer(this.mro, dws());
                } catch (IllegalStateException e) {
                    dwv();
                    if (this.mrN) {
                        dwp();
                    }
                    return false;
                }
            } else {
                this.mrF = this.mrr.dequeueOutputBuffer(this.mro, dws());
            }
            if (this.mrF >= 0) {
                if (this.mrB) {
                    this.mrB = false;
                    this.mrr.releaseOutputBuffer(this.mrF, false);
                    this.mrF = -1;
                    return true;
                } else if ((this.mro.flags & 4) != 0) {
                    dwv();
                    this.mrF = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.mdK[this.mrF];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.mro.offset);
                        byteBuffer.limit(this.mro.offset + this.mro.size);
                    }
                    this.mrG = fZ(this.mro.presentationTimeUs);
                }
            } else if (this.mrF == -2) {
                dwt();
                return true;
            } else if (this.mrF == -3) {
                dwu();
                return true;
            } else {
                if (this.mrw && (this.mrM || this.mrJ == 2)) {
                    dwv();
                }
                return false;
            }
        }
        if (this.mry && this.mrL) {
            try {
                a = a(j, j2, this.mrr, this.mdK[this.mrF], this.mrF, this.mro.flags, this.mro.presentationTimeUs, this.mrG);
            } catch (IllegalStateException e2) {
                dwv();
                if (this.mrN) {
                    dwp();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.mrr, this.mdK[this.mrF], this.mrF, this.mro.flags, this.mro.presentationTimeUs, this.mrG);
        }
        if (a) {
            fY(this.mro.presentationTimeUs);
            this.mrF = -1;
            return true;
        }
        return false;
    }

    private void dwt() throws ExoPlaybackException {
        MediaFormat outputFormat = this.mrr.getOutputFormat();
        if (this.mrt != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.mrB = true;
            return;
        }
        if (this.mrz) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.mrr, outputFormat);
    }

    private void dwu() {
        this.mdK = this.mrr.getOutputBuffers();
    }

    protected void duO() throws ExoPlaybackException {
    }

    private void dwv() throws ExoPlaybackException {
        if (this.mrJ == 2) {
            dwp();
            dwm();
            return;
        }
        this.mrN = true;
        duO();
    }

    private boolean fZ(long j) {
        int size = this.mrn.size();
        for (int i = 0; i < size; i++) {
            if (this.mrn.get(i).longValue() == j) {
                this.mrn.remove(i);
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
        if (v.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(v.mJI) || "flounder_lte".equals(v.mJI) || "grouper".equals(v.mJI) || "tilapia".equals(v.mJI)))) {
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
        return (v.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.SDK_INT <= 19 && "hb2000".equals(v.mJI) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean PC(String str) {
        return v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, Format format) {
        return v.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
