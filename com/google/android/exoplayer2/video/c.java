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
    private static final int[] mJW = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, TbConfig.HEAD_IMG_SIZE, 854, 640, 540, 480};
    private final Context context;
    private final d mJX;
    private final e.a mJY;
    private final long mJZ;
    private long mKA;
    private int mKB;
    private final int mKa;
    private final boolean mKb;
    private final long[] mKc;
    private Format[] mKd;
    private a mKe;
    private boolean mKf;
    private Surface mKg;
    private int mKh;
    private boolean mKi;
    private boolean mKj;
    private long mKk;
    private long mKl;
    private int mKm;
    private int mKn;
    private int mKo;
    private int mKp;
    private float mKq;
    private int mKr;
    private int mKs;
    private int mKt;
    private float mKu;
    private int mKv;
    private int mKw;
    private int mKx;
    private float mKy;
    b mKz;
    private int mbG;
    private boolean mdR;
    private Surface surface;

    public c(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i) {
        super(2, bVar, aVar, z);
        this.mJZ = j;
        this.mKa = i;
        this.context = context.getApplicationContext();
        this.mJX = new d(context);
        this.mJY = new e.a(handler, eVar);
        this.mKb = dAB();
        this.mKc = new long[10];
        this.mKA = -9223372036854775807L;
        this.mKk = -9223372036854775807L;
        this.mKr = -1;
        this.mKs = -1;
        this.mKu = -1.0f;
        this.mKq = -1.0f;
        this.mKh = 1;
        dAx();
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
                    z |= drmInitData.Jx(i).requiresSecureDecryption;
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
                        Pt = format.width * format.height <= MediaCodecUtil.dwx();
                        if (!Pt) {
                            Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + Config.EVENT_HEAT_X + format.height + "] [" + v.mJJ + "]");
                        }
                    }
                }
                return (aL.mdR ? 32 : 0) | (aL.mrf ? 16 : 8) | (Pt ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vE(boolean z) throws ExoPlaybackException {
        super.vE(z);
        this.mbG = dtn().mbG;
        this.mdR = this.mbG != 0;
        this.mJY.e(this.mrQ);
        this.mJX.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a
    public void a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.mKd = formatArr;
        if (this.mKA == -9223372036854775807L) {
            this.mKA = j;
        } else {
            if (this.mKB == this.mKc.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.mKc[this.mKB - 1]);
            } else {
                this.mKB++;
            }
            this.mKc[this.mKB - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void m(long j, boolean z) throws ExoPlaybackException {
        super.m(j, z);
        dAu();
        this.mKn = 0;
        if (this.mKB != 0) {
            this.mKA = this.mKc[this.mKB - 1];
            this.mKB = 0;
        }
        if (z) {
            dAt();
        } else {
            this.mKk = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        if (super.isReady() && (this.mKi || ((this.mKg != null && this.surface == this.mKg) || dwn() == null || this.mdR))) {
            this.mKk = -9223372036854775807L;
            return true;
        } else if (this.mKk == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.mKk) {
                this.mKk = -9223372036854775807L;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mKm = 0;
        this.mKl = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mKk = -9223372036854775807L;
        dAA();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dtm() {
        this.mKr = -1;
        this.mKs = -1;
        this.mKu = -1.0f;
        this.mKq = -1.0f;
        this.mKA = -9223372036854775807L;
        this.mKB = 0;
        dAx();
        dAu();
        this.mJX.disable();
        this.mKz = null;
        this.mdR = false;
        try {
            super.dtm();
        } finally {
            this.mrQ.duZ();
            this.mJY.f(this.mrQ);
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.mKh = ((Integer) obj).intValue();
            MediaCodec dwn = dwn();
            if (dwn != null) {
                a(dwn, this.mKh);
            }
        } else {
            super.k(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.mKg != null) {
                surface = this.mKg;
            } else {
                com.google.android.exoplayer2.mediacodec.a dwo = dwo();
                if (dwo != null && we(dwo.secure)) {
                    this.mKg = DummySurface.o(this.context, dwo.secure);
                    surface = this.mKg;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec dwn = dwn();
                if (v.SDK_INT >= 23 && dwn != null && surface != null && !this.mKf) {
                    a(dwn, surface);
                } else {
                    dwp();
                    dwm();
                }
            }
            if (surface != null && surface != this.mKg) {
                dAz();
                dAu();
                if (state == 2) {
                    dAt();
                    return;
                }
                return;
            }
            dAx();
            dAu();
        } else if (surface != null && surface != this.mKg) {
            dAz();
            dAw();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.surface != null || we(aVar.secure);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.mKe = a(aVar, format, this.mKd);
        MediaFormat a2 = a(format, this.mKe, this.mKb, this.mbG);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.a.checkState(we(aVar.secure));
            if (this.mKg == null) {
                this.mKg = DummySurface.o(this.context, aVar.secure);
            }
            this.surface = this.mKg;
        }
        mediaCodec.configure(a2, this.surface, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.mdR) {
            this.mKz = new b(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dwp() {
        try {
            super.dwp();
        } finally {
            this.mKo = 0;
            this.mKj = false;
            if (this.mKg != null) {
                if (this.surface == this.mKg) {
                    this.surface = null;
                }
                this.mKg.release();
                this.mKg = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void dwq() throws ExoPlaybackException {
        super.dwq();
        this.mKo = 0;
        this.mKj = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mJY.f(str, j, j2);
        this.mKf = QI(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mJY.f(format);
        this.mKq = r(format);
        this.mKp = s(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void c(com.google.android.exoplayer2.a.e eVar) {
        this.mKo++;
        if (v.SDK_INT < 23 && this.mdR) {
            dAv();
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
        this.mKr = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.mKs = integer2;
        this.mKu = this.mKq;
        if (v.SDK_INT >= 21) {
            if (this.mKp == 90 || this.mKp == 270) {
                int i = this.mKr;
                this.mKr = this.mKs;
                this.mKs = i;
                this.mKu = 1.0f / this.mKu;
            }
        } else {
            this.mKt = this.mKp;
        }
        a(mediaCodec, this.mKh);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.width <= this.mKe.width && format2.height <= this.mKe.height && q(format2) <= this.mKe.mKC;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        while (this.mKB != 0 && j3 >= this.mKc[0]) {
            this.mKA = this.mKc[0];
            this.mKB--;
            System.arraycopy(this.mKc, 1, this.mKc, 0, this.mKB);
        }
        long j4 = j3 - this.mKA;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.mKg) {
            if (gN(j5)) {
                this.mKj = false;
                a(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.mKi || this.mKj) {
            this.mKj = false;
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
            long Z = this.mJX.Z(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (Z - nanoTime) / 1000;
            if (Y(j6, j2) && a(mediaCodec, i, j4, j)) {
                this.mKj = true;
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
    protected void fY(long j) {
        this.mKo--;
    }

    protected boolean X(long j, long j2) {
        return gN(j);
    }

    protected boolean Y(long j, long j2) {
        return gO(j);
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        this.mrQ.mfp++;
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        t.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        Mj(1);
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int fn = fn(j2);
        if (fn == 0) {
            return false;
        }
        this.mrQ.mfs++;
        Mj(fn + this.mKo);
        dwq();
        return true;
    }

    protected void Mj(int i) {
        this.mrQ.mfq += i;
        this.mKm += i;
        this.mKn += i;
        this.mrQ.mfr = Math.max(this.mKn, this.mrQ.mfr);
        if (this.mKm >= this.mKa) {
            dAA();
        }
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        dAy();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        this.mrQ.mfo++;
        this.mKn = 0;
        dAv();
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        dAy();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.endSection();
        this.mrQ.mfo++;
        this.mKn = 0;
        dAv();
    }

    private boolean we(boolean z) {
        return v.SDK_INT >= 23 && !this.mdR && (!z || DummySurface.gq(this.context));
    }

    private void dAt() {
        this.mKk = this.mJZ > 0 ? SystemClock.elapsedRealtime() + this.mJZ : -9223372036854775807L;
    }

    private void dAu() {
        MediaCodec dwn;
        this.mKi = false;
        if (v.SDK_INT >= 23 && this.mdR && (dwn = dwn()) != null) {
            this.mKz = new b(dwn);
        }
    }

    void dAv() {
        if (!this.mKi) {
            this.mKi = true;
            this.mJY.f(this.surface);
        }
    }

    private void dAw() {
        if (this.mKi) {
            this.mJY.f(this.surface);
        }
    }

    private void dAx() {
        this.mKv = -1;
        this.mKw = -1;
        this.mKy = -1.0f;
        this.mKx = -1;
    }

    private void dAy() {
        if (this.mKr == -1 && this.mKs == -1) {
            return;
        }
        if (this.mKv != this.mKr || this.mKw != this.mKs || this.mKx != this.mKt || this.mKy != this.mKu) {
            this.mJY.c(this.mKr, this.mKs, this.mKt, this.mKu);
            this.mKv = this.mKr;
            this.mKw = this.mKs;
            this.mKx = this.mKt;
            this.mKy = this.mKu;
        }
    }

    private void dAz() {
        if (this.mKv != -1 || this.mKw != -1) {
            this.mJY.c(this.mKv, this.mKw, this.mKx, this.mKy);
        }
    }

    private void dAA() {
        if (this.mKm > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mJY.J(this.mKm, elapsedRealtime - this.mKl);
            this.mKm = 0;
            this.mKl = elapsedRealtime;
        }
    }

    private static boolean gN(long j) {
        return j < -30000;
    }

    private static boolean gO(long j) {
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
            if (a(aVar.mrf, format, format2)) {
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
        MediaFormat dtX = format.dtX();
        dtX.setInteger("max-width", aVar.width);
        dtX.setInteger("max-height", aVar.height);
        if (aVar.mKC != -1) {
            dtX.setInteger("max-input-size", aVar.mKC);
        }
        if (z) {
            dtX.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            b(dtX, i);
        }
        return dtX;
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int[] iArr;
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : mJW) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (v.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point dO = aVar.dO(i5, i3);
                if (aVar.a(dO.x, dO.y, format.frameRate)) {
                    return dO;
                }
            } else {
                int ea = v.ea(i3, 16) * 16;
                int ea2 = v.ea(i4, 16) * 16;
                if (ea * ea2 <= MediaCodecUtil.dwx()) {
                    return new Point(z ? ea2 : ea, z ? ea : ea2);
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
                    i3 = v.ea(i, 16) * v.ea(i2, 16) * 16 * 16;
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

    private static boolean dAB() {
        return v.SDK_INT <= 22 && "foster".equals(v.mJI) && "NVIDIA".equals(v.MANUFACTURER);
    }

    private static boolean QI(String str) {
        return (("deb".equals(v.mJI) || "flo".equals(v.mJI)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.mJI) || "SVP-DTV15".equals(v.mJI) || "BRAVIA_ATV2".equals(v.mJI)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
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
        public final int mKC;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.mKC = i3;
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
            if (this == c.this.mKz) {
                c.this.dAv();
            }
        }
    }
}
