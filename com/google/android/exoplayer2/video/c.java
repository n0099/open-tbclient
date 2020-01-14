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
    private static final int[] mHu = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lZe;
    private final long[] mHA;
    private Format[] mHB;
    private a mHC;
    private boolean mHD;
    private Surface mHE;
    private int mHF;
    private boolean mHG;
    private boolean mHH;
    private long mHI;
    private long mHJ;
    private int mHK;
    private int mHL;
    private int mHM;
    private int mHN;
    private float mHO;
    private int mHP;
    private int mHQ;
    private int mHR;
    private float mHS;
    private int mHT;
    private int mHU;
    private int mHV;
    private float mHW;
    b mHX;
    private long mHY;
    private int mHZ;
    private final d mHv;
    private final e.a mHw;
    private final long mHx;
    private final int mHy;
    private final boolean mHz;
    private boolean mbs;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mHx = j;
        this.mHy = i;
        this.context = context.getApplicationContext();
        this.mHv = new d(context);
        this.mHw = new e.a(handler, eVar);
        this.mHz = dyR();
        this.mHA = new long[10];
        this.mHY = -9223372036854775807L;
        this.mHI = -9223372036854775807L;
        this.mHP = -1;
        this.mHQ = -1;
        this.mHS = -1.0f;
        this.mHO = -1.0f;
        this.mHF = 1;
        dyN();
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
                        Pf = format.width * format.height <= MediaCodecUtil.duN();
                        if (!Pf) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mHh + "]");
                        }
                    }
                }
                return (aL.mbs ? 32 : 0) | (aL.moG ? 16 : 8) | (Pf ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vt(boolean z) throws ExoPlaybackException {
        super.vt(z);
        this.lZe = drB().lZe;
        this.mbs = this.lZe != 0;
        this.mHw.e(this.mpr);
        this.mHv.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mHB = formatArr;
        if (this.mHY == -9223372036854775807L) {
            this.mHY = j;
        } else {
            if (this.mHZ == this.mHA.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mHA[this.mHZ - 1]);
            } else {
                this.mHZ++;
            }
            this.mHA[this.mHZ - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void j(long j, boolean z) throws ExoPlaybackException {
        super.j(j, z);
        dyK();
        this.mHL = 0;
        if (this.mHZ != 0) {
            this.mHY = this.mHA[this.mHZ - 1];
            this.mHZ = 0;
        }
        if (z) {
            dyJ();
        } else {
            this.mHI = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mHG || ((this.mHE != null && this.surface == this.mHE) || duD() == null || this.mbs))) {
            this.mHI = -9223372036854775807L;
            return true;
        } else if (this.mHI == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mHI) {
                this.mHI = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mHK = 0;
        this.mHJ = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mHI = -9223372036854775807L;
        dyQ();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void drA() {
        this.mHP = -1;
        this.mHQ = -1;
        this.mHS = -1.0f;
        this.mHO = -1.0f;
        this.mHY = -9223372036854775807L;
        this.mHZ = 0;
        dyN();
        dyK();
        this.mHv.disable();
        this.mHX = null;
        this.mbs = false;
        try {
            super.drA();
        } finally {
            this.mpr.dto();
            this.mHw.f(this.mpr);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mHF = ((Integer) obj).intValue();
            MediaCodec duD = duD();
            if (duD != null) {
                a(duD, this.mHF);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mHE != null) {
                surface = this.mHE;
            } else {
                com.google.android.exoplayer2.mediacodec.a duE = duE();
                if (duE != null && vT(duE.secure)) {
                    this.mHE = DummySurface.p(this.context, duE.secure);
                    surface = this.mHE;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec duD = duD();
                if (v.SDK_INT >= 23 && duD != null && surface != null && !this.mHD) {
                    a(duD, surface);
                } else {
                    duF();
                    duC();
                }
            }
            if (surface != null && surface != this.mHE) {
                dyP();
                dyK();
                if (state == 2) {
                    dyJ();
                    return;
                }
                return;
            }
            dyN();
            dyK();
        } else if (surface != null && surface != this.mHE) {
            dyP();
            dyM();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || vT(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mHC = a(aVar, format, this.mHB);
        MediaFormat a2 = a(format, this.mHC, this.mHz, this.lZe);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(vT(aVar.secure));
            if (this.mHE == null) {
                this.mHE = DummySurface.p(this.context, aVar.secure);
            }
            this.surface = this.mHE;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mbs) {
            this.mHX = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void duF() {
        try {
            super.duF();
        } finally {
            this.mHM = 0;
            this.mHH = false;
            if (this.mHE != null) {
                if (this.surface == this.mHE) {
                    this.surface = null;
                }
                this.mHE.release();
                this.mHE = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void duG() throws ExoPlaybackException {
        super.duG();
        this.mHM = 0;
        this.mHH = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mHw.f(str, j, j2);
        this.mHD = Qu(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mHw.f(format);
        this.mHO = r(format);
        this.mHN = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mHM++;
        if (v.SDK_INT < 23 && this.mbs) {
            dyL();
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
        this.mHP = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mHQ = integer2;
        this.mHS = this.mHO;
        if (v.SDK_INT >= 21) {
            if (this.mHN == 90 || this.mHN == 270) {
                int i = this.mHP;
                this.mHP = this.mHQ;
                this.mHQ = i;
                this.mHS = 1.0f / this.mHS;
            }
        } else {
            this.mHR = this.mHN;
        }
        a(mediaCodec, this.mHF);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mHC.width && format2.height <= this.mHC.height && q(format2) <= this.mHC.mIa;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mHZ != 0 && j3 >= this.mHA[0]) {
            this.mHY = this.mHA[0];
            this.mHZ--;
            System.arraycopy(this.mHA, 1, this.mHA, 0, this.mHZ);
        }
        long j4 = j3 - this.mHY;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mHE) {
            if (gO(j5)) {
                this.mHH = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mHG || this.mHH) {
            this.mHH = false;
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
            long aa = this.mHv.aa(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (aa - nanoTime) / 1000;
            if (Z(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mHH = true;
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
        this.mHM--;
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
        this.mpr.mcQ++;
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
        this.mpr.mcT++;
        LY(fo + this.mHM);
        duG();
        return true;
    }

    protected void LY(int i) {
        this.mpr.mcR += i;
        this.mHK += i;
        this.mHL += i;
        this.mpr.mcS = Math.max(this.mHL, this.mpr.mcS);
        if (this.mHK >= this.mHy) {
            dyQ();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dyO();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mpr.mcP++;
        this.mHL = 0;
        dyL();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dyO();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mpr.mcP++;
        this.mHL = 0;
        dyL();
    }

    private boolean vT(boolean z) {
        return v.SDK_INT >= 23 && !this.mbs && (!z || DummySurface.gs(this.context));
    }

    private void dyJ() {
        this.mHI = this.mHx > 0 ? SystemClock.elapsedRealtime() + this.mHx : -9223372036854775807L;
    }

    private void dyK() {
        MediaCodec duD;
        this.mHG = false;
        if (v.SDK_INT >= 23 && this.mbs && (duD = duD()) != null) {
            this.mHX = new b(duD);
        }
    }

    void dyL() {
        if (!this.mHG) {
            this.mHG = true;
            this.mHw.f(this.surface);
        }
    }

    private void dyM() {
        if (this.mHG) {
            this.mHw.f(this.surface);
        }
    }

    private void dyN() {
        this.mHT = -1;
        this.mHU = -1;
        this.mHW = -1.0f;
        this.mHV = -1;
    }

    private void dyO() {
        if (this.mHP == -1 && this.mHQ == -1) {
            return;
        }
        if (this.mHT != this.mHP || this.mHU != this.mHQ || this.mHV != this.mHR || this.mHW != this.mHS) {
            this.mHw.c(this.mHP, this.mHQ, this.mHR, this.mHS);
            this.mHT = this.mHP;
            this.mHU = this.mHQ;
            this.mHV = this.mHR;
            this.mHW = this.mHS;
        }
    }

    private void dyP() {
        if (this.mHT != -1 || this.mHU != -1) {
            this.mHw.c(this.mHT, this.mHU, this.mHV, this.mHW);
        }
    }

    private void dyQ() {
        if (this.mHK > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mHw.K(this.mHK, elapsedRealtime - this.mHJ);
            this.mHK = 0;
            this.mHJ = elapsedRealtime;
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
            if (a(aVar.moG, format, format2)) {
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
        MediaFormat dsl = format.dsl();
        dsl.setInteger("max-width", aVar.width);
        dsl.setInteger("max-height", aVar.height);
        if (aVar.mIa != -1) {
            dsl.setInteger("max-input-size", aVar.mIa);
        }
        if (z) {
            dsl.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dsl, i);
        }
        return dsl;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mHu) {
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
                if (dW * dW2 <= MediaCodecUtil.duN()) {
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

    private static boolean dyR() {
        return v.SDK_INT <= 22 && "foster".equals(v.mHg) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean Qu(String str) {
        return (("deb".equals(v.mHg) || "flo".equals(v.mHg)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mHg) || "SVP-DTV15".equals(v.mHg) || "BRAVIA_ATV2".equals(v.mHg)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
        public final int mIa;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mIa = i3;
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
            if (this == c.this.mHX) {
                c.this.dyL();
            }
        }
    }
}
