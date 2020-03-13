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
/* loaded from: classes6.dex */
public class c extends MediaCodecRenderer {
    private static final int[] mIn = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lZX;
    private int mIA;
    private boolean mIB;
    private boolean mIC;
    private long mIE;
    private long mIF;
    private int mIG;
    private int mIH;
    private int mII;
    private int mIJ;
    private float mIK;
    private int mIL;
    private int mIM;
    private int mIN;
    private float mIO;
    private int mIP;
    private int mIQ;
    private int mIR;
    private float mIS;
    b mIT;
    private long mIU;
    private int mIV;
    private final d mIo;
    private final e.a mIq;
    private final long mIr;
    private final int mIt;
    private final boolean mIu;
    private final long[] mIv;
    private Format[] mIw;
    private a mIx;
    private boolean mIy;
    private Surface mIz;
    private boolean mcl;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mIr = j;
        this.mIt = i;
        this.context = context.getApplicationContext();
        this.mIo = new d(context);
        this.mIq = new e.a(handler, eVar);
        this.mIu = dAe();
        this.mIv = new long[10];
        this.mIU = -9223372036854775807L;
        this.mIE = -9223372036854775807L;
        this.mIL = -1;
        this.mIM = -1;
        this.mIO = -1.0f;
        this.mIK = -1.0f;
        this.mIA = 1;
        dAa();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        String str = format.sampleMimeType;
        if (i.OR(str)) {
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                    z |= drmInitData.Jr(i).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a(aVar, drmInitData)) {
                boolean Pt = aL.Pt(format.codecs);
                if (Pt && format.width > 0 && format.height > 0) {
                    if (v.SDK_INT >= 21) {
                        Pt = aL.a(format.width, format.height, format.frameRate);
                    } else {
                        Pt = format.width * format.height <= MediaCodecUtil.dwa();
                        if (!Pt) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mHZ + "]");
                        }
                    }
                }
                return (aL.mcl ? 32 : 0) | (aL.mpz ? 16 : 8) | (Pt ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vx(boolean z) throws ExoPlaybackException {
        super.vx(z);
        this.lZX = dsQ().lZX;
        this.mcl = this.lZX != 0;
        this.mIq.e(this.mqk);
        this.mIo.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mIw = formatArr;
        if (this.mIU == -9223372036854775807L) {
            this.mIU = j;
        } else {
            if (this.mIV == this.mIv.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mIv[this.mIV - 1]);
            } else {
                this.mIV++;
            }
            this.mIv[this.mIV - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void l(long j, boolean z) throws ExoPlaybackException {
        super.l(j, z);
        dzX();
        this.mIH = 0;
        if (this.mIV != 0) {
            this.mIU = this.mIv[this.mIV - 1];
            this.mIV = 0;
        }
        if (z) {
            dzW();
        } else {
            this.mIE = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mIB || ((this.mIz != null && this.surface == this.mIz) || dvQ() == null || this.mcl))) {
            this.mIE = -9223372036854775807L;
            return true;
        } else if (this.mIE == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mIE) {
                this.mIE = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mIG = 0;
        this.mIF = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mIE = -9223372036854775807L;
        dAd();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dsP() {
        this.mIL = -1;
        this.mIM = -1;
        this.mIO = -1.0f;
        this.mIK = -1.0f;
        this.mIU = -9223372036854775807L;
        this.mIV = 0;
        dAa();
        dzX();
        this.mIo.disable();
        this.mIT = null;
        this.mcl = false;
        try {
            super.dsP();
        } finally {
            this.mqk.duC();
            this.mIq.f(this.mqk);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mIA = ((Integer) obj).intValue();
            MediaCodec dvQ = dvQ();
            if (dvQ != null) {
                a(dvQ, this.mIA);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mIz != null) {
                surface = this.mIz;
            } else {
                com.google.android.exoplayer2.mediacodec.a dvR = dvR();
                if (dvR != null && vX(dvR.secure)) {
                    this.mIz = DummySurface.o(this.context, dvR.secure);
                    surface = this.mIz;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec dvQ = dvQ();
                if (v.SDK_INT >= 23 && dvQ != null && surface != null && !this.mIy) {
                    a(dvQ, surface);
                } else {
                    dvS();
                    dvP();
                }
            }
            if (surface != null && surface != this.mIz) {
                dAc();
                dzX();
                if (state == 2) {
                    dzW();
                    return;
                }
                return;
            }
            dAa();
            dzX();
        } else if (surface != null && surface != this.mIz) {
            dAc();
            dzZ();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || vX(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mIx = a(aVar, format, this.mIw);
        MediaFormat a2 = a(format, this.mIx, this.mIu, this.lZX);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(vX(aVar.secure));
            if (this.mIz == null) {
                this.mIz = DummySurface.o(this.context, aVar.secure);
            }
            this.surface = this.mIz;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mcl) {
            this.mIT = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvS() {
        try {
            super.dvS();
        } finally {
            this.mII = 0;
            this.mIC = false;
            if (this.mIz != null) {
                if (this.surface == this.mIz) {
                    this.surface = null;
                }
                this.mIz.release();
                this.mIz = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvT() throws ExoPlaybackException {
        super.dvT();
        this.mII = 0;
        this.mIC = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mIq.f(str, j, j2);
        this.mIy = QI(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mIq.f(format);
        this.mIK = r(format);
        this.mIJ = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mII++;
        if (v.SDK_INT < 23 && this.mcl) {
            dzY();
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
        this.mIL = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mIM = integer2;
        this.mIO = this.mIK;
        if (v.SDK_INT >= 21) {
            if (this.mIJ == 90 || this.mIJ == 270) {
                int i = this.mIL;
                this.mIL = this.mIM;
                this.mIM = i;
                this.mIO = 1.0f / this.mIO;
            }
        } else {
            this.mIN = this.mIJ;
        }
        a(mediaCodec, this.mIA);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mIx.width && format2.height <= this.mIx.height && q(format2) <= this.mIx.mIW;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mIV != 0 && j3 >= this.mIv[0]) {
            this.mIU = this.mIv[0];
            this.mIV--;
            System.arraycopy(this.mIv, 1, this.mIv, 0, this.mIV);
        }
        long j4 = j3 - this.mIU;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mIz) {
            if (gM(j5)) {
                this.mIC = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mIB || this.mIC) {
            this.mIC = false;
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
            long Z = this.mIo.Z(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (Z - nanoTime) / 1000;
            if (Y(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mIC = true;
                return false;
            } else if (X(j6, j2)) {
                b(mediaCodec, i, j4);
                return true;
            } else {
                if (v.SDK_INT >= 21) {
                    if (j6 < 50000) {
                        b(mediaCodec, i, j4, Z);
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
    protected void fX(long j) {
        this.mII--;
    }

    protected boolean X(long j, long j2) {
        return gM(j);
    }

    protected boolean Y(long j, long j2) {
        return gN(j);
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        this.mqk.mdJ++;
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        Md(1);
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int fm = fm(j2);
        if (fm == 0) {
            return false;
        }
        this.mqk.mdM++;
        Md(fm + this.mII);
        dvT();
        return true;
    }

    protected void Md(int i) {
        this.mqk.mdK += i;
        this.mIG += i;
        this.mIH += i;
        this.mqk.mdL = Math.max(this.mIH, this.mqk.mdL);
        if (this.mIG >= this.mIt) {
            dAd();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dAb();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mqk.mdI++;
        this.mIH = 0;
        dzY();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dAb();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mqk.mdI++;
        this.mIH = 0;
        dzY();
    }

    private boolean vX(boolean z) {
        return v.SDK_INT >= 23 && !this.mcl && (!z || DummySurface.gr(this.context));
    }

    private void dzW() {
        this.mIE = this.mIr > 0 ? SystemClock.elapsedRealtime() + this.mIr : -9223372036854775807L;
    }

    private void dzX() {
        MediaCodec dvQ;
        this.mIB = false;
        if (v.SDK_INT >= 23 && this.mcl && (dvQ = dvQ()) != null) {
            this.mIT = new b(dvQ);
        }
    }

    void dzY() {
        if (!this.mIB) {
            this.mIB = true;
            this.mIq.f(this.surface);
        }
    }

    private void dzZ() {
        if (this.mIB) {
            this.mIq.f(this.surface);
        }
    }

    private void dAa() {
        this.mIP = -1;
        this.mIQ = -1;
        this.mIS = -1.0f;
        this.mIR = -1;
    }

    private void dAb() {
        if (this.mIL == -1 && this.mIM == -1) {
            return;
        }
        if (this.mIP != this.mIL || this.mIQ != this.mIM || this.mIR != this.mIN || this.mIS != this.mIO) {
            this.mIq.c(this.mIL, this.mIM, this.mIN, this.mIO);
            this.mIP = this.mIL;
            this.mIQ = this.mIM;
            this.mIR = this.mIN;
            this.mIS = this.mIO;
        }
    }

    private void dAc() {
        if (this.mIP != -1 || this.mIQ != -1) {
            this.mIq.c(this.mIP, this.mIQ, this.mIR, this.mIS);
        }
    }

    private void dAd() {
        if (this.mIG > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mIq.J(this.mIG, elapsedRealtime - this.mIF);
            this.mIG = 0;
            this.mIF = elapsedRealtime;
        }
    }

    private static boolean gM(long j) {
        return j < -30000;
    }

    private static boolean gN(long j) {
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
            if (a(aVar.mpz, format, format2)) {
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
        MediaFormat dtA = format.dtA();
        dtA.setInteger("max-width", aVar.width);
        dtA.setInteger("max-height", aVar.height);
        if (aVar.mIW != -1) {
            dtA.setInteger("max-input-size", aVar.mIW);
        }
        if (z) {
            dtA.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dtA, i);
        }
        return dtA;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mIn) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (v.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point dN = aVar.dN(i5, i3);
                if (aVar.a(dN.x, dN.y, format.frameRate)) {
                    return dN;
                }
            } else {
                int dZ = v.dZ(i3, 16) * 16;
                int dZ2 = v.dZ(i4, 16) * 16;
                if (dZ * dZ2 <= MediaCodecUtil.dwa()) {
                    return new Point(z ? dZ2 : dZ, z ? dZ : dZ2);
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
                    i3 = v.dZ(i, 16) * v.dZ(i2, 16) * 16 * 16;
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

    private static boolean dAe() {
        return v.SDK_INT <= 22 && "foster".equals(v.mHY) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean QI(String str) {
        return (("deb".equals(v.mHY) || "flo".equals(v.mHY)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mHY) || "SVP-DTV15".equals(v.mHY) || "BRAVIA_ATV2".equals(v.mHY)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
    /* loaded from: classes6.dex */
    public static final class a {
        public final int height;
        public final int mIW;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mIW = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* loaded from: classes6.dex */
    public final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            if (this == c.this.mIT) {
                c.this.dzY();
            }
        }
    }
}
