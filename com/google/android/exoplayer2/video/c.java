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
    private static final int[] mHZ = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lZK;
    private float mIA;
    private int mIB;
    private int mIC;
    private int mIE;
    private float mIF;
    b mIG;
    private long mIH;
    private int mII;
    private final d mIa;
    private final e.a mIb;
    private final long mIc;
    private final int mIe;
    private final boolean mIf;
    private final long[] mIg;
    private Format[] mIh;
    private a mIi;
    private boolean mIj;
    private Surface mIk;
    private int mIl;
    private boolean mIm;
    private boolean mIn;
    private long mIo;
    private long mIq;
    private int mIr;
    private int mIt;
    private int mIu;
    private int mIv;
    private float mIw;
    private int mIx;
    private int mIy;
    private int mIz;
    private boolean mbY;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mIc = j;
        this.mIe = i;
        this.context = context.getApplicationContext();
        this.mIa = new d(context);
        this.mIb = new e.a(handler, eVar);
        this.mIf = dAb();
        this.mIg = new long[10];
        this.mIH = -9223372036854775807L;
        this.mIo = -9223372036854775807L;
        this.mIx = -1;
        this.mIy = -1;
        this.mIA = -1.0f;
        this.mIw = -1.0f;
        this.mIl = 1;
        dzX();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        String str = format.sampleMimeType;
        if (i.OQ(str)) {
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
                boolean Ps = aL.Ps(format.codecs);
                if (Ps && format.width > 0 && format.height > 0) {
                    if (v.SDK_INT >= 21) {
                        Ps = aL.a(format.width, format.height, format.frameRate);
                    } else {
                        Ps = format.width * format.height <= MediaCodecUtil.dvX();
                        if (!Ps) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mHM + "]");
                        }
                    }
                }
                return (aL.mbY ? 32 : 0) | (aL.mpm ? 16 : 8) | (Ps ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vx(boolean z) throws ExoPlaybackException {
        super.vx(z);
        this.lZK = dsN().lZK;
        this.mbY = this.lZK != 0;
        this.mIb.e(this.mpX);
        this.mIa.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mIh = formatArr;
        if (this.mIH == -9223372036854775807L) {
            this.mIH = j;
        } else {
            if (this.mII == this.mIg.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mIg[this.mII - 1]);
            } else {
                this.mII++;
            }
            this.mIg[this.mII - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void l(long j, boolean z) throws ExoPlaybackException {
        super.l(j, z);
        dzU();
        this.mIt = 0;
        if (this.mII != 0) {
            this.mIH = this.mIg[this.mII - 1];
            this.mII = 0;
        }
        if (z) {
            dzT();
        } else {
            this.mIo = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mIm || ((this.mIk != null && this.surface == this.mIk) || dvN() == null || this.mbY))) {
            this.mIo = -9223372036854775807L;
            return true;
        } else if (this.mIo == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mIo) {
                this.mIo = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mIr = 0;
        this.mIq = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mIo = -9223372036854775807L;
        dAa();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dsM() {
        this.mIx = -1;
        this.mIy = -1;
        this.mIA = -1.0f;
        this.mIw = -1.0f;
        this.mIH = -9223372036854775807L;
        this.mII = 0;
        dzX();
        dzU();
        this.mIa.disable();
        this.mIG = null;
        this.mbY = false;
        try {
            super.dsM();
        } finally {
            this.mpX.duz();
            this.mIb.f(this.mpX);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mIl = ((Integer) obj).intValue();
            MediaCodec dvN = dvN();
            if (dvN != null) {
                a(dvN, this.mIl);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mIk != null) {
                surface = this.mIk;
            } else {
                com.google.android.exoplayer2.mediacodec.a dvO = dvO();
                if (dvO != null && vX(dvO.secure)) {
                    this.mIk = DummySurface.o(this.context, dvO.secure);
                    surface = this.mIk;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec dvN = dvN();
                if (v.SDK_INT >= 23 && dvN != null && surface != null && !this.mIj) {
                    a(dvN, surface);
                } else {
                    dvP();
                    dvM();
                }
            }
            if (surface != null && surface != this.mIk) {
                dzZ();
                dzU();
                if (state == 2) {
                    dzT();
                    return;
                }
                return;
            }
            dzX();
            dzU();
        } else if (surface != null && surface != this.mIk) {
            dzZ();
            dzW();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || vX(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mIi = a(aVar, format, this.mIh);
        MediaFormat a2 = a(format, this.mIi, this.mIf, this.lZK);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(vX(aVar.secure));
            if (this.mIk == null) {
                this.mIk = DummySurface.o(this.context, aVar.secure);
            }
            this.surface = this.mIk;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mbY) {
            this.mIG = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvP() {
        try {
            super.dvP();
        } finally {
            this.mIu = 0;
            this.mIn = false;
            if (this.mIk != null) {
                if (this.surface == this.mIk) {
                    this.surface = null;
                }
                this.mIk.release();
                this.mIk = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvQ() throws ExoPlaybackException {
        super.dvQ();
        this.mIu = 0;
        this.mIn = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mIb.f(str, j, j2);
        this.mIj = QH(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mIb.f(format);
        this.mIw = r(format);
        this.mIv = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mIu++;
        if (v.SDK_INT < 23 && this.mbY) {
            dzV();
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
        this.mIx = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mIy = integer2;
        this.mIA = this.mIw;
        if (v.SDK_INT >= 21) {
            if (this.mIv == 90 || this.mIv == 270) {
                int i = this.mIx;
                this.mIx = this.mIy;
                this.mIy = i;
                this.mIA = 1.0f / this.mIA;
            }
        } else {
            this.mIz = this.mIv;
        }
        a(mediaCodec, this.mIl);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mIi.width && format2.height <= this.mIi.height && q(format2) <= this.mIi.mIJ;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mII != 0 && j3 >= this.mIg[0]) {
            this.mIH = this.mIg[0];
            this.mII--;
            System.arraycopy(this.mIg, 1, this.mIg, 0, this.mII);
        }
        long j4 = j3 - this.mIH;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mIk) {
            if (gM(j5)) {
                this.mIn = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mIm || this.mIn) {
            this.mIn = false;
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
            long Z = this.mIa.Z(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (Z - nanoTime) / 1000;
            if (Y(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mIn = true;
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
        this.mIu--;
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
        this.mpX.mdw++;
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
        this.mpX.mdz++;
        Md(fm + this.mIu);
        dvQ();
        return true;
    }

    protected void Md(int i) {
        this.mpX.mdx += i;
        this.mIr += i;
        this.mIt += i;
        this.mpX.mdy = Math.max(this.mIt, this.mpX.mdy);
        if (this.mIr >= this.mIe) {
            dAa();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dzY();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mpX.mdv++;
        this.mIt = 0;
        dzV();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dzY();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mpX.mdv++;
        this.mIt = 0;
        dzV();
    }

    private boolean vX(boolean z) {
        return v.SDK_INT >= 23 && !this.mbY && (!z || DummySurface.gr(this.context));
    }

    private void dzT() {
        this.mIo = this.mIc > 0 ? SystemClock.elapsedRealtime() + this.mIc : -9223372036854775807L;
    }

    private void dzU() {
        MediaCodec dvN;
        this.mIm = false;
        if (v.SDK_INT >= 23 && this.mbY && (dvN = dvN()) != null) {
            this.mIG = new b(dvN);
        }
    }

    void dzV() {
        if (!this.mIm) {
            this.mIm = true;
            this.mIb.f(this.surface);
        }
    }

    private void dzW() {
        if (this.mIm) {
            this.mIb.f(this.surface);
        }
    }

    private void dzX() {
        this.mIB = -1;
        this.mIC = -1;
        this.mIF = -1.0f;
        this.mIE = -1;
    }

    private void dzY() {
        if (this.mIx == -1 && this.mIy == -1) {
            return;
        }
        if (this.mIB != this.mIx || this.mIC != this.mIy || this.mIE != this.mIz || this.mIF != this.mIA) {
            this.mIb.c(this.mIx, this.mIy, this.mIz, this.mIA);
            this.mIB = this.mIx;
            this.mIC = this.mIy;
            this.mIE = this.mIz;
            this.mIF = this.mIA;
        }
    }

    private void dzZ() {
        if (this.mIB != -1 || this.mIC != -1) {
            this.mIb.c(this.mIB, this.mIC, this.mIE, this.mIF);
        }
    }

    private void dAa() {
        if (this.mIr > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mIb.J(this.mIr, elapsedRealtime - this.mIq);
            this.mIr = 0;
            this.mIq = elapsedRealtime;
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
            if (a(aVar.mpm, format, format2)) {
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
        MediaFormat dtx = format.dtx();
        dtx.setInteger("max-width", aVar.width);
        dtx.setInteger("max-height", aVar.height);
        if (aVar.mIJ != -1) {
            dtx.setInteger("max-input-size", aVar.mIJ);
        }
        if (z) {
            dtx.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dtx, i);
        }
        return dtx;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mHZ) {
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
                if (dZ * dZ2 <= MediaCodecUtil.dvX()) {
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

    private static boolean dAb() {
        return v.SDK_INT <= 22 && "foster".equals(v.mHL) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean QH(String str) {
        return (("deb".equals(v.mHL) || "flo".equals(v.mHL)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mHL) || "SVP-DTV15".equals(v.mHL) || "BRAVIA_ATV2".equals(v.mHL)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
        public final int mIJ;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mIJ = i3;
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
            if (this == c.this.mIG) {
                c.this.dzV();
            }
        }
    }
}
