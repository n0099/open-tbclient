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
    private static final int[] mIb = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private int lZM;
    private int mIA;
    private int mIB;
    private float mIC;
    private int mIE;
    private int mIF;
    private int mIG;
    private float mIH;
    b mII;
    private long mIJ;
    private int mIK;
    private final d mIc;
    private final e.a mIe;
    private final long mIf;
    private final int mIg;
    private final boolean mIh;
    private final long[] mIi;
    private Format[] mIj;
    private a mIk;
    private boolean mIl;
    private Surface mIm;
    private int mIn;
    private boolean mIo;
    private boolean mIq;
    private long mIr;
    private long mIt;
    private int mIu;
    private int mIv;
    private int mIw;
    private int mIx;
    private float mIy;
    private int mIz;
    private boolean mca;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mIf = j;
        this.mIg = i;
        this.context = context.getApplicationContext();
        this.mIc = new d(context);
        this.mIe = new e.a(handler, eVar);
        this.mIh = dAd();
        this.mIi = new long[10];
        this.mIJ = -9223372036854775807L;
        this.mIr = -9223372036854775807L;
        this.mIz = -1;
        this.mIA = -1;
        this.mIC = -1.0f;
        this.mIy = -1.0f;
        this.mIn = 1;
        dzZ();
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
                        Ps = format.width * format.height <= MediaCodecUtil.dvZ();
                        if (!Ps) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mHO + "]");
                        }
                    }
                }
                return (aL.mca ? 32 : 0) | (aL.mpo ? 16 : 8) | (Ps ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vx(boolean z) throws ExoPlaybackException {
        super.vx(z);
        this.lZM = dsP().lZM;
        this.mca = this.lZM != 0;
        this.mIe.e(this.mpZ);
        this.mIc.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mIj = formatArr;
        if (this.mIJ == -9223372036854775807L) {
            this.mIJ = j;
        } else {
            if (this.mIK == this.mIi.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mIi[this.mIK - 1]);
            } else {
                this.mIK++;
            }
            this.mIi[this.mIK - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void l(long j, boolean z) throws ExoPlaybackException {
        super.l(j, z);
        dzW();
        this.mIv = 0;
        if (this.mIK != 0) {
            this.mIJ = this.mIi[this.mIK - 1];
            this.mIK = 0;
        }
        if (z) {
            dzV();
        } else {
            this.mIr = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mIo || ((this.mIm != null && this.surface == this.mIm) || dvP() == null || this.mca))) {
            this.mIr = -9223372036854775807L;
            return true;
        } else if (this.mIr == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mIr) {
                this.mIr = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mIu = 0;
        this.mIt = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mIr = -9223372036854775807L;
        dAc();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dsO() {
        this.mIz = -1;
        this.mIA = -1;
        this.mIC = -1.0f;
        this.mIy = -1.0f;
        this.mIJ = -9223372036854775807L;
        this.mIK = 0;
        dzZ();
        dzW();
        this.mIc.disable();
        this.mII = null;
        this.mca = false;
        try {
            super.dsO();
        } finally {
            this.mpZ.duB();
            this.mIe.f(this.mpZ);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mIn = ((Integer) obj).intValue();
            MediaCodec dvP = dvP();
            if (dvP != null) {
                a(dvP, this.mIn);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mIm != null) {
                surface = this.mIm;
            } else {
                com.google.android.exoplayer2.mediacodec.a dvQ = dvQ();
                if (dvQ != null && vX(dvQ.secure)) {
                    this.mIm = DummySurface.o(this.context, dvQ.secure);
                    surface = this.mIm;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec dvP = dvP();
                if (v.SDK_INT >= 23 && dvP != null && surface != null && !this.mIl) {
                    a(dvP, surface);
                } else {
                    dvR();
                    dvO();
                }
            }
            if (surface != null && surface != this.mIm) {
                dAb();
                dzW();
                if (state == 2) {
                    dzV();
                    return;
                }
                return;
            }
            dzZ();
            dzW();
        } else if (surface != null && surface != this.mIm) {
            dAb();
            dzY();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || vX(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mIk = a(aVar, format, this.mIj);
        MediaFormat a2 = a(format, this.mIk, this.mIh, this.lZM);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(vX(aVar.secure));
            if (this.mIm == null) {
                this.mIm = DummySurface.o(this.context, aVar.secure);
            }
            this.surface = this.mIm;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mca) {
            this.mII = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvR() {
        try {
            super.dvR();
        } finally {
            this.mIw = 0;
            this.mIq = false;
            if (this.mIm != null) {
                if (this.surface == this.mIm) {
                    this.surface = null;
                }
                this.mIm.release();
                this.mIm = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dvS() throws ExoPlaybackException {
        super.dvS();
        this.mIw = 0;
        this.mIq = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mIe.f(str, j, j2);
        this.mIl = QH(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mIe.f(format);
        this.mIy = r(format);
        this.mIx = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mIw++;
        if (v.SDK_INT < 23 && this.mca) {
            dzX();
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
        this.mIz = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mIA = integer2;
        this.mIC = this.mIy;
        if (v.SDK_INT >= 21) {
            if (this.mIx == 90 || this.mIx == 270) {
                int i = this.mIz;
                this.mIz = this.mIA;
                this.mIA = i;
                this.mIC = 1.0f / this.mIC;
            }
        } else {
            this.mIB = this.mIx;
        }
        a(mediaCodec, this.mIn);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mIk.width && format2.height <= this.mIk.height && q(format2) <= this.mIk.mIL;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mIK != 0 && j3 >= this.mIi[0]) {
            this.mIJ = this.mIi[0];
            this.mIK--;
            System.arraycopy(this.mIi, 1, this.mIi, 0, this.mIK);
        }
        long j4 = j3 - this.mIJ;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mIm) {
            if (gM(j5)) {
                this.mIq = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mIo || this.mIq) {
            this.mIq = false;
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
            long Z = this.mIc.Z(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (Z - nanoTime) / 1000;
            if (Y(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mIq = true;
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
        this.mIw--;
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
        this.mpZ.mdy++;
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
        this.mpZ.mdB++;
        Md(fm + this.mIw);
        dvS();
        return true;
    }

    protected void Md(int i) {
        this.mpZ.mdz += i;
        this.mIu += i;
        this.mIv += i;
        this.mpZ.mdA = Math.max(this.mIv, this.mpZ.mdA);
        if (this.mIu >= this.mIg) {
            dAc();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dAa();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mpZ.mdx++;
        this.mIv = 0;
        dzX();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dAa();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mpZ.mdx++;
        this.mIv = 0;
        dzX();
    }

    private boolean vX(boolean z) {
        return v.SDK_INT >= 23 && !this.mca && (!z || DummySurface.gr(this.context));
    }

    private void dzV() {
        this.mIr = this.mIf > 0 ? SystemClock.elapsedRealtime() + this.mIf : -9223372036854775807L;
    }

    private void dzW() {
        MediaCodec dvP;
        this.mIo = false;
        if (v.SDK_INT >= 23 && this.mca && (dvP = dvP()) != null) {
            this.mII = new b(dvP);
        }
    }

    void dzX() {
        if (!this.mIo) {
            this.mIo = true;
            this.mIe.f(this.surface);
        }
    }

    private void dzY() {
        if (this.mIo) {
            this.mIe.f(this.surface);
        }
    }

    private void dzZ() {
        this.mIE = -1;
        this.mIF = -1;
        this.mIH = -1.0f;
        this.mIG = -1;
    }

    private void dAa() {
        if (this.mIz == -1 && this.mIA == -1) {
            return;
        }
        if (this.mIE != this.mIz || this.mIF != this.mIA || this.mIG != this.mIB || this.mIH != this.mIC) {
            this.mIe.c(this.mIz, this.mIA, this.mIB, this.mIC);
            this.mIE = this.mIz;
            this.mIF = this.mIA;
            this.mIG = this.mIB;
            this.mIH = this.mIC;
        }
    }

    private void dAb() {
        if (this.mIE != -1 || this.mIF != -1) {
            this.mIe.c(this.mIE, this.mIF, this.mIG, this.mIH);
        }
    }

    private void dAc() {
        if (this.mIu > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mIe.J(this.mIu, elapsedRealtime - this.mIt);
            this.mIu = 0;
            this.mIt = elapsedRealtime;
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
            if (a(aVar.mpo, format, format2)) {
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
        MediaFormat dtz = format.dtz();
        dtz.setInteger("max-width", aVar.width);
        dtz.setInteger("max-height", aVar.height);
        if (aVar.mIL != -1) {
            dtz.setInteger("max-input-size", aVar.mIL);
        }
        if (z) {
            dtz.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dtz, i);
        }
        return dtz;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mIb) {
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
                if (dZ * dZ2 <= MediaCodecUtil.dvZ()) {
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

    private static boolean dAd() {
        return v.SDK_INT <= 22 && "foster".equals(v.mHN) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean QH(String str) {
        return (("deb".equals(v.mHN) || "flo".equals(v.mHN)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mHN) || "SVP-DTV15".equals(v.mHN) || "BRAVIA_ATV2".equals(v.mHN)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
        public final int mIL;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mIL = i3;
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
            if (this == c.this.mII) {
                c.this.dzX();
            }
        }
    }
}
