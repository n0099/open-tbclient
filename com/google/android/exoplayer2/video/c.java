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
/* loaded from: classes4.dex */
public class c extends MediaCodecRenderer {
    private static final int[] mDB = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lVi;
    private Surface lVr;
    private boolean lXv;
    private final d mDC;
    private final e.a mDD;
    private final long mDE;
    private final int mDF;
    private final boolean mDG;
    private final long[] mDH;
    private Format[] mDI;
    private a mDJ;
    private boolean mDK;
    private Surface mDL;
    private int mDM;
    private boolean mDN;
    private boolean mDO;
    private long mDP;
    private long mDQ;
    private int mDR;
    private int mDS;
    private int mDT;
    private int mDU;
    private float mDV;
    private int mDW;
    private int mDX;
    private int mDY;
    private float mDZ;
    private int mEa;
    private int mEb;
    private int mEc;
    private float mEd;
    b mEe;
    private long mEf;
    private int mEg;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mDE = j;
        this.mDF = i;
        this.context = context.getApplicationContext();
        this.mDC = new d(context);
        this.mDD = new e.a(handler, eVar);
        this.mDG = dxF();
        this.mDH = new long[10];
        this.mEf = -9223372036854775807L;
        this.mDP = -9223372036854775807L;
        this.mDW = -1;
        this.mDX = -1;
        this.mDZ = -1.0f;
        this.mDV = -1.0f;
        this.mDM = 1;
        dxB();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        String str = format.sampleMimeType;
        if (i.Ot(str)) {
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                    z |= drmInitData.Jd(i).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a(aVar, drmInitData)) {
                boolean OU = aL.OU(format.codecs);
                if (OU && format.width > 0 && format.height > 0) {
                    if (v.SDK_INT >= 21) {
                        OU = aL.a(format.width, format.height, format.frameRate);
                    } else {
                        OU = format.width * format.height <= MediaCodecUtil.dtA();
                        if (!OU) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mDm + "]");
                        }
                    }
                }
                return (aL.lXv ? 32 : 0) | (aL.mkM ? 16 : 8) | (OU ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vh(boolean z) throws ExoPlaybackException {
        super.vh(z);
        this.lVi = dqn().lVi;
        this.lXv = this.lVi != 0;
        this.mDD.e(this.mlx);
        this.mDC.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mDI = formatArr;
        if (this.mEf == -9223372036854775807L) {
            this.mEf = j;
        } else {
            if (this.mEg == this.mDH.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mDH[this.mEg - 1]);
            } else {
                this.mEg++;
            }
            this.mDH[this.mEg - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void j(long j, boolean z) throws ExoPlaybackException {
        super.j(j, z);
        dxy();
        this.mDS = 0;
        if (this.mEg != 0) {
            this.mEf = this.mDH[this.mEg - 1];
            this.mEg = 0;
        }
        if (z) {
            dxx();
        } else {
            this.mDP = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mDN || ((this.mDL != null && this.lVr == this.mDL) || dtq() == null || this.lXv))) {
            this.mDP = -9223372036854775807L;
            return true;
        } else if (this.mDP == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mDP) {
                this.mDP = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mDR = 0;
        this.mDQ = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mDP = -9223372036854775807L;
        dxE();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dqm() {
        this.mDW = -1;
        this.mDX = -1;
        this.mDZ = -1.0f;
        this.mDV = -1.0f;
        this.mEf = -9223372036854775807L;
        this.mEg = 0;
        dxB();
        dxy();
        this.mDC.disable();
        this.mEe = null;
        this.lXv = false;
        try {
            super.dqm();
        } finally {
            this.mlx.dsa();
            this.mDD.f(this.mlx);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mDM = ((Integer) obj).intValue();
            MediaCodec dtq = dtq();
            if (dtq != null) {
                a(dtq, this.mDM);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mDL != null) {
                surface = this.mDL;
            } else {
                com.google.android.exoplayer2.mediacodec.a dtr = dtr();
                if (dtr != null && vH(dtr.secure)) {
                    this.mDL = DummySurface.p(this.context, dtr.secure);
                    surface = this.mDL;
                }
            }
        }
        if (this.lVr != surface) {
            this.lVr = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec dtq = dtq();
                if (v.SDK_INT >= 23 && dtq != null && surface != null && !this.mDK) {
                    a(dtq, surface);
                } else {
                    dts();
                    dtp();
                }
            }
            if (surface != null && surface != this.mDL) {
                dxD();
                dxy();
                if (state == 2) {
                    dxx();
                    return;
                }
                return;
            }
            dxB();
            dxy();
        } else if (surface != null && surface != this.mDL) {
            dxD();
            dxA();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.lVr != null || vH(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mDJ = a(aVar, format, this.mDI);
        MediaFormat a2 = a(format, this.mDJ, this.mDG, this.lVi);
        if (this.lVr == null) {
            com.google.android.exoplayer2.util.a.checkState(vH(aVar.secure));
            if (this.mDL == null) {
                this.mDL = DummySurface.p(this.context, aVar.secure);
            }
            this.lVr = this.mDL;
        }
        mediaCodec.configure(a2, this.lVr, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.lXv) {
            this.mEe = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dts() {
        try {
            super.dts();
        } finally {
            this.mDT = 0;
            this.mDO = false;
            if (this.mDL != null) {
                if (this.lVr == this.mDL) {
                    this.lVr = null;
                }
                this.mDL.release();
                this.mDL = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dtt() throws ExoPlaybackException {
        super.dtt();
        this.mDT = 0;
        this.mDO = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mDD.f(str, j, j2);
        this.mDK = Qj(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mDD.f(format);
        this.mDV = r(format);
        this.mDU = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mDT++;
        if (v.SDK_INT < 23 && this.lXv) {
            dxz();
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
        this.mDW = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mDX = integer2;
        this.mDZ = this.mDV;
        if (v.SDK_INT >= 21) {
            if (this.mDU == 90 || this.mDU == 270) {
                int i = this.mDW;
                this.mDW = this.mDX;
                this.mDX = i;
                this.mDZ = 1.0f / this.mDZ;
            }
        } else {
            this.mDY = this.mDU;
        }
        a(mediaCodec, this.mDM);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mDJ.width && format2.height <= this.mDJ.height && q(format2) <= this.mDJ.mEh;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mEg != 0 && j3 >= this.mDH[0]) {
            this.mEf = this.mDH[0];
            this.mEg--;
            System.arraycopy(this.mDH, 1, this.mDH, 0, this.mEg);
        }
        long j4 = j3 - this.mEf;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.lVr == this.mDL) {
            if (gJ(j5)) {
                this.mDO = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mDN || this.mDO) {
            this.mDO = false;
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
            long aa = this.mDC.aa(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (aa - nanoTime) / 1000;
            if (Z(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mDO = true;
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
    protected void fU(long j) {
        this.mDT--;
    }

    protected boolean Y(long j, long j2) {
        return gJ(j);
    }

    protected boolean Z(long j, long j2) {
        return gK(j);
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        this.mlx.lYT++;
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        LP(1);
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int fj = fj(j2);
        if (fj == 0) {
            return false;
        }
        this.mlx.lYW++;
        LP(fj + this.mDT);
        dtt();
        return true;
    }

    protected void LP(int i) {
        this.mlx.lYU += i;
        this.mDR += i;
        this.mDS += i;
        this.mlx.lYV = Math.max(this.mDS, this.mlx.lYV);
        if (this.mDR >= this.mDF) {
            dxE();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dxC();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mlx.lYS++;
        this.mDS = 0;
        dxz();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dxC();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mlx.lYS++;
        this.mDS = 0;
        dxz();
    }

    private boolean vH(boolean z) {
        return v.SDK_INT >= 23 && !this.lXv && (!z || DummySurface.gr(this.context));
    }

    private void dxx() {
        this.mDP = this.mDE > 0 ? SystemClock.elapsedRealtime() + this.mDE : -9223372036854775807L;
    }

    private void dxy() {
        MediaCodec dtq;
        this.mDN = false;
        if (v.SDK_INT >= 23 && this.lXv && (dtq = dtq()) != null) {
            this.mEe = new b(dtq);
        }
    }

    void dxz() {
        if (!this.mDN) {
            this.mDN = true;
            this.mDD.f(this.lVr);
        }
    }

    private void dxA() {
        if (this.mDN) {
            this.mDD.f(this.lVr);
        }
    }

    private void dxB() {
        this.mEa = -1;
        this.mEb = -1;
        this.mEd = -1.0f;
        this.mEc = -1;
    }

    private void dxC() {
        if (this.mDW == -1 && this.mDX == -1) {
            return;
        }
        if (this.mEa != this.mDW || this.mEb != this.mDX || this.mEc != this.mDY || this.mEd != this.mDZ) {
            this.mDD.c(this.mDW, this.mDX, this.mDY, this.mDZ);
            this.mEa = this.mDW;
            this.mEb = this.mDX;
            this.mEc = this.mDY;
            this.mEd = this.mDZ;
        }
    }

    private void dxD() {
        if (this.mEa != -1 || this.mEb != -1) {
            this.mDD.c(this.mEa, this.mEb, this.mEc, this.mEd);
        }
    }

    private void dxE() {
        if (this.mDR > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mDD.K(this.mDR, elapsedRealtime - this.mDQ);
            this.mDR = 0;
            this.mDQ = elapsedRealtime;
        }
    }

    private static boolean gJ(long j) {
        return j < -30000;
    }

    private static boolean gK(long j) {
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
            if (a(aVar.mkM, format, format2)) {
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
        MediaFormat dqX = format.dqX();
        dqX.setInteger("max-width", aVar.width);
        dqX.setInteger("max-height", aVar.height);
        if (aVar.mEh != -1) {
            dqX.setInteger("max-input-size", aVar.mEh);
        }
        if (z) {
            dqX.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dqX, i);
        }
        return dqX;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mDB) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (v.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point dM = aVar.dM(i5, i3);
                if (aVar.a(dM.x, dM.y, format.frameRate)) {
                    return dM;
                }
            } else {
                int dY = v.dY(i3, 16) * 16;
                int dY2 = v.dY(i4, 16) * 16;
                if (dY * dY2 <= MediaCodecUtil.dtA()) {
                    return new Point(z ? dY2 : dY, z ? dY : dY2);
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
                    i3 = v.dY(i, 16) * v.dY(i2, 16) * 16 * 16;
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

    private static boolean dxF() {
        return v.SDK_INT <= 22 && "foster".equals(v.mDl) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean Qj(String str) {
        return (("deb".equals(v.mDl) || "flo".equals(v.mDl)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mDl) || "SVP-DTV15".equals(v.mDl) || "BRAVIA_ATV2".equals(v.mDl)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
    /* loaded from: classes4.dex */
    public static final class a {
        public final int height;
        public final int mEh;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mEh = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* loaded from: classes4.dex */
    public final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            if (this == c.this.mEe) {
                c.this.dxz();
            }
        }
    }
}
