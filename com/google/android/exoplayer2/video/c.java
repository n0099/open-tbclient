package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.util.media.MimeType;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.e;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes5.dex */
public class c extends MediaCodecRenderer {
    private static final int[] mHp = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lYZ;
    private int mHA;
    private boolean mHB;
    private boolean mHC;
    private long mHD;
    private long mHE;
    private int mHF;
    private int mHG;
    private int mHH;
    private int mHI;
    private float mHJ;
    private int mHK;
    private int mHL;
    private int mHM;
    private float mHN;
    private int mHO;
    private int mHP;
    private int mHQ;
    private float mHR;
    b mHS;
    private long mHT;
    private int mHU;
    private final d mHq;
    private final e.a mHr;
    private final long mHs;
    private final int mHt;
    private final boolean mHu;
    private final long[] mHv;
    private Format[] mHw;
    private a mHx;
    private boolean mHy;
    private Surface mHz;
    private boolean mbn;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mHs = j;
        this.mHt = i;
        this.context = context.getApplicationContext();
        this.mHq = new d(context);
        this.mHr = new e.a(handler, eVar);
        this.mHu = dyP();
        this.mHv = new long[10];
        this.mHT = -9223372036854775807L;
        this.mHD = -9223372036854775807L;
        this.mHK = -1;
        this.mHL = -1;
        this.mHN = -1.0f;
        this.mHJ = -1.0f;
        this.mHA = 1;
        dyL();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        String str = format.sampleMimeType;
        if (i.OD(str)) {
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                    z |= drmInitData.Jm(i).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a(aVar, drmInitData)) {
                boolean Pf = aL.Pf(format.codecs);
                if (Pf && format.width > 0 && format.height > 0) {
                    if (v.SDK_INT >= 21) {
                        Pf = aL.a(format.width, format.height, format.frameRate);
                    } else {
                        Pf = format.width * format.height <= MediaCodecUtil.duL();
                        if (!Pf) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mHc + "]");
                        }
                    }
                }
                return (aL.mbn ? 32 : 0) | (aL.moB ? 16 : 8) | (Pf ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vt(boolean z) throws ExoPlaybackException {
        super.vt(z);
        this.lYZ = drz().lYZ;
        this.mbn = this.lYZ != 0;
        this.mHr.e(this.mpm);
        this.mHq.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mHw = formatArr;
        if (this.mHT == -9223372036854775807L) {
            this.mHT = j;
        } else {
            if (this.mHU == this.mHv.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mHv[this.mHU - 1]);
            } else {
                this.mHU++;
            }
            this.mHv[this.mHU - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void j(long j, boolean z) throws ExoPlaybackException {
        super.j(j, z);
        dyI();
        this.mHG = 0;
        if (this.mHU != 0) {
            this.mHT = this.mHv[this.mHU - 1];
            this.mHU = 0;
        }
        if (z) {
            dyH();
        } else {
            this.mHD = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mHB || ((this.mHz != null && this.surface == this.mHz) || duB() == null || this.mbn))) {
            this.mHD = -9223372036854775807L;
            return true;
        } else if (this.mHD == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mHD) {
                this.mHD = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mHF = 0;
        this.mHE = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mHD = -9223372036854775807L;
        dyO();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dry() {
        this.mHK = -1;
        this.mHL = -1;
        this.mHN = -1.0f;
        this.mHJ = -1.0f;
        this.mHT = -9223372036854775807L;
        this.mHU = 0;
        dyL();
        dyI();
        this.mHq.disable();
        this.mHS = null;
        this.mbn = false;
        try {
            super.dry();
        } finally {
            this.mpm.dtm();
            this.mHr.f(this.mpm);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mHA = ((Integer) obj).intValue();
            MediaCodec duB = duB();
            if (duB != null) {
                a(duB, this.mHA);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mHz != null) {
                surface = this.mHz;
            } else {
                com.google.android.exoplayer2.mediacodec.a duC = duC();
                if (duC != null && vT(duC.secure)) {
                    this.mHz = DummySurface.p(this.context, duC.secure);
                    surface = this.mHz;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec duB = duB();
                if (v.SDK_INT >= 23 && duB != null && surface != null && !this.mHy) {
                    a(duB, surface);
                } else {
                    duD();
                    duA();
                }
            }
            if (surface != null && surface != this.mHz) {
                dyN();
                dyI();
                if (state == 2) {
                    dyH();
                    return;
                }
                return;
            }
            dyL();
            dyI();
        } else if (surface != null && surface != this.mHz) {
            dyN();
            dyK();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || vT(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mHx = a(aVar, format, this.mHw);
        MediaFormat a2 = a(format, this.mHx, this.mHu, this.lYZ);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(vT(aVar.secure));
            if (this.mHz == null) {
                this.mHz = DummySurface.p(this.context, aVar.secure);
            }
            this.surface = this.mHz;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mbn) {
            this.mHS = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void duD() {
        try {
            super.duD();
        } finally {
            this.mHH = 0;
            this.mHC = false;
            if (this.mHz != null) {
                if (this.surface == this.mHz) {
                    this.surface = null;
                }
                this.mHz.release();
                this.mHz = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void duE() throws ExoPlaybackException {
        super.duE();
        this.mHH = 0;
        this.mHC = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mHr.f(str, j, j2);
        this.mHy = Qu(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mHr.f(format);
        this.mHJ = r(format);
        this.mHI = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mHH++;
        if (v.SDK_INT < 23 && this.mbn) {
            dyJ();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.mHK = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mHL = integer2;
        this.mHN = this.mHJ;
        if (v.SDK_INT >= 21) {
            if (this.mHI == 90 || this.mHI == 270) {
                int i = this.mHK;
                this.mHK = this.mHL;
                this.mHL = i;
                this.mHN = 1.0f / this.mHN;
            }
        } else {
            this.mHM = this.mHI;
        }
        a(mediaCodec, this.mHA);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mHx.width && format2.height <= this.mHx.height && q(format2) <= this.mHx.mHV;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mHU != 0 && j3 >= this.mHv[0]) {
            this.mHT = this.mHv[0];
            this.mHU--;
            System.arraycopy(this.mHv, 1, this.mHv, 0, this.mHU);
        }
        long j4 = j3 - this.mHT;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mHz) {
            if (gO(j5)) {
                this.mHC = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mHB || this.mHC) {
            this.mHC = false;
            if (v.SDK_INT >= 21) {
                b(mediaCodec, i, j4, System.nanoTime());
            } else {
                c(mediaCodec, i, j4);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long aa = this.mHq.aa(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (aa - nanoTime) / 1000;
            if (Z(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mHC = true;
                return false;
            } else if (Y(j6, j2)) {
                b(mediaCodec, i, j4);
                return true;
            } else {
                if (v.SDK_INT >= 21) {
                    if (j6 < 50000) {
                        b(mediaCodec, i, j4, aa);
                        return true;
                    }
                } else if (j6 < 30000) {
                    if (j6 > 11000) {
                        try {
                            Thread.sleep((j6 - 10000) / 1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    c(mediaCodec, i, j4);
                    return true;
                }
                return false;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void fZ(long j) {
        this.mHH--;
    }

    protected boolean Y(long j, long j2) {
        return gO(j);
    }

    protected boolean Z(long j, long j2) {
        return gP(j);
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        this.mpm.mcL++;
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        LY(1);
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int fo = fo(j2);
        if (fo == 0) {
            return false;
        }
        this.mpm.mcO++;
        LY(fo + this.mHH);
        duE();
        return true;
    }

    protected void LY(int i) {
        this.mpm.mcM += i;
        this.mHF += i;
        this.mHG += i;
        this.mpm.mcN = Math.max(this.mHG, this.mpm.mcN);
        if (this.mHF >= this.mHt) {
            dyO();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dyM();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mpm.mcK++;
        this.mHG = 0;
        dyJ();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dyM();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mpm.mcK++;
        this.mHG = 0;
        dyJ();
    }

    private boolean vT(boolean z) {
        return v.SDK_INT >= 23 && !this.mbn && (!z || DummySurface.gs(this.context));
    }

    private void dyH() {
        this.mHD = this.mHs > 0 ? SystemClock.elapsedRealtime() + this.mHs : -9223372036854775807L;
    }

    private void dyI() {
        MediaCodec duB;
        this.mHB = false;
        if (v.SDK_INT >= 23 && this.mbn && (duB = duB()) != null) {
            this.mHS = new b(duB);
        }
    }

    void dyJ() {
        if (!this.mHB) {
            this.mHB = true;
            this.mHr.f(this.surface);
        }
    }

    private void dyK() {
        if (this.mHB) {
            this.mHr.f(this.surface);
        }
    }

    private void dyL() {
        this.mHO = -1;
        this.mHP = -1;
        this.mHR = -1.0f;
        this.mHQ = -1;
    }

    private void dyM() {
        if (this.mHK == -1 && this.mHL == -1) {
            return;
        }
        if (this.mHO != this.mHK || this.mHP != this.mHL || this.mHQ != this.mHM || this.mHR != this.mHN) {
            this.mHr.c(this.mHK, this.mHL, this.mHM, this.mHN);
            this.mHO = this.mHK;
            this.mHP = this.mHL;
            this.mHQ = this.mHM;
            this.mHR = this.mHN;
        }
    }

    private void dyN() {
        if (this.mHO != -1 || this.mHP != -1) {
            this.mHr.c(this.mHO, this.mHP, this.mHQ, this.mHR);
        }
    }

    private void dyO() {
        if (this.mHF > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mHr.K(this.mHF, elapsedRealtime - this.mHE);
            this.mHF = 0;
            this.mHE = elapsedRealtime;
        }
    }

    private static boolean gO(long j) {
        return j < -30000;
    }

    private static boolean gP(long j) {
        return j < -500000;
    }

    @TargetApi(23)
    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void b(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    protected a a(com.google.android.exoplayer2.mediacodec.a aVar, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i;
        int i2 = format.width;
        int i3 = format.height;
        int q = q(format);
        if (formatArr.length == 1) {
            return new a(i2, i3, q);
        }
        int length = formatArr.length;
        int i4 = 0;
        boolean z2 = false;
        while (i4 < length) {
            Format format2 = formatArr[i4];
            if (a(aVar.moB, format, format2)) {
                z = (format2.width == -1 || format2.height == -1) | z2;
                i2 = Math.max(i2, format2.width);
                i3 = Math.max(i3, format2.height);
                i = Math.max(q, q(format2));
            } else {
                z = z2;
                i = q;
            }
            i4++;
            i2 = i2;
            i3 = i3;
            q = i;
            z2 = z;
        }
        if (z2) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + Config.EVENT_HEAT_X + i3);
            Point a2 = a(aVar, format);
            if (a2 != null) {
                i2 = Math.max(i2, a2.x);
                i3 = Math.max(i3, a2.y);
                q = Math.max(q, E(format.sampleMimeType, i2, i3));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + Config.EVENT_HEAT_X + i3);
            }
        }
        return new a(i2, i3, q);
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat a(Format format, a aVar, boolean z, int i) {
        MediaFormat dsj = format.dsj();
        dsj.setInteger("max-width", aVar.width);
        dsj.setInteger("max-height", aVar.height);
        if (aVar.mHV != -1) {
            dsj.setInteger("max-input-size", aVar.mHV);
        }
        if (z) {
            dsj.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dsj, i);
        }
        return dsj;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mHp) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (v.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point dK = aVar.dK(i5, i3);
                if (aVar.a(dK.x, dK.y, format.frameRate)) {
                    return dK;
                }
            } else {
                int dW = v.dW(i3, 16) * 16;
                int dW2 = v.dW(i4, 16) * 16;
                if (dW * dW2 <= MediaCodecUtil.duL()) {
                    return new Point(z ? dW2 : dW, z ? dW : dW2);
                }
            }
        }
        return null;
    }

    private static int q(Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.initializationData.get(i2).length;
            }
            return format.maxInputSize + i;
        }
        return E(format.sampleMimeType, format.width, format.height);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int E(String str, int i, int i2) {
        char c;
        int i3;
        int i4 = 2;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeType.Video.GP3)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                i3 = i * i2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(v.MODEL)) {
                    i3 = v.dW(i, 16) * v.dW(i2, 16) * 16 * 16;
                    break;
                } else {
                    return -1;
                }
            case 3:
                i3 = i * i2;
                break;
            case 4:
            case 5:
                i3 = i * i2;
                i4 = 4;
                break;
            default:
                return -1;
        }
        return (i3 * 3) / (i4 * 2);
    }

    private static void a(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    private static boolean dyP() {
        return v.SDK_INT <= 22 && "foster".equals(v.mHb) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean Qu(String str) {
        return (("deb".equals(v.mHb) || "flo".equals(v.mHb)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mHb) || "SVP-DTV15".equals(v.mHb) || "BRAVIA_ATV2".equals(v.mHb)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
    }

    private static boolean a(boolean z, Format format, Format format2) {
        return format.sampleMimeType.equals(format2.sampleMimeType) && s(format) == s(format2) && (z || (format.width == format2.width && format.height == format2.height));
    }

    private static float r(Format format) {
        if (format.pixelWidthHeightRatio == -1.0f) {
            return 1.0f;
        }
        return format.pixelWidthHeightRatio;
    }

    private static int s(Format format) {
        if (format.rotationDegrees == -1) {
            return 0;
        }
        return format.rotationDegrees;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static final class a {
        public final int height;
        public final int mHV;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mHV = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* loaded from: classes5.dex */
    public final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            if (this == c.this.mHS) {
                c.this.dyJ();
            }
        }
    }
}
