package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
@TargetApi(16)
/* loaded from: classes5.dex */
public class g extends MediaCodecRenderer implements com.google.android.exoplayer2.util.h {
    private int channelCount;
    private int encoderDelay;
    private int encoderPadding;
    private final d.a mbM;
    private final AudioSink mbN;
    private boolean mbO;
    private boolean mbP;
    private MediaFormat mbQ;
    private long mbR;
    private boolean mbS;
    private int pcmEncoding;

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
    }

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        this.mbM = new d.a(handler, dVar);
        this.mbN = audioSink;
        audioSink.a(new a());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        boolean z2 = false;
        String str = format.sampleMimeType;
        if (com.google.android.exoplayer2.util.i.Qb(str)) {
            int i = v.SDK_INT >= 21 ? 32 : 0;
            boolean a2 = a(aVar, format.drmInitData);
            if (a2 && Pb(str) && bVar.duM() != null) {
                return i | 8 | 4;
            }
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
                    z |= drmInitData.Jm(i2).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a2) {
                if (v.SDK_INT < 21 || ((format.sampleRate == -1 || aL.JW(format.sampleRate)) && (format.channelCount == -1 || aL.JX(format.channelCount)))) {
                    z2 = true;
                }
                return (z2 ? 4 : 3) | i | 8;
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected com.google.android.exoplayer2.mediacodec.a a(com.google.android.exoplayer2.mediacodec.b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.a duM;
        if (Pb(format.sampleMimeType) && (duM = bVar.duM()) != null) {
            this.mbO = true;
            return duM;
        }
        this.mbO = false;
        return super.a(bVar, format, z);
    }

    protected boolean Pb(String str) {
        return this.mbN.OZ(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.mbP = Pc(aVar.name);
        if (this.mbO) {
            this.mbQ = format.dsl();
            this.mbQ.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.mbQ, (Surface) null, mediaCrypto, 0);
            this.mbQ.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.dsl(), (Surface) null, mediaCrypto, 0);
        this.mbQ = null;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h drt() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mbM.f(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mbM.f(format);
        this.pcmEncoding = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay != -1 ? format.encoderDelay : 0;
        this.encoderPadding = format.encoderPadding != -1 ? format.encoderPadding : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = this.mbQ != null;
        String string = z ? this.mbQ.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.mbQ;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.mbP && integer == 6 && this.channelCount < 6) {
            iArr = new int[this.channelCount];
            for (int i = 0; i < this.channelCount; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.mbN.a(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    protected void EP(int i) {
    }

    protected void dtc() {
    }

    protected void j(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vt(boolean z) throws ExoPlaybackException {
        super.vt(z);
        this.mbM.e(this.mpr);
        int i = drB().lZe;
        if (i != 0) {
            this.mbN.Ja(i);
        } else {
            this.mbN.dsI();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void j(long j, boolean z) throws ExoPlaybackException {
        super.j(j, z);
        this.mbN.reset();
        this.mbR = j;
        this.mbS = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mbN.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mbN.pause();
        super.onStopped();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 367=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void drA() {
        try {
            this.mbN.release();
            try {
                super.drA();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.drA();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean atB() {
        return super.atB() && this.mbN.atB();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        return this.mbN.dsH() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dsY() {
        long vB = this.mbN.vB(atB());
        if (vB != Long.MIN_VALUE) {
            if (!this.mbS) {
                vB = Math.max(this.mbR, vB);
            }
            this.mbR = vB;
            this.mbS = false;
        }
        return this.mbR;
    }

    @Override // com.google.android.exoplayer2.util.h
    public q d(q qVar) {
        return this.mbN.d(qVar);
    }

    @Override // com.google.android.exoplayer2.util.h
    public q drH() {
        return this.mbN.drH();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.mbO && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.mpr.mcQ++;
            this.mbN.dsF();
            return true;
        } else {
            try {
                if (this.mbN.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.mpr.mcP++;
                    return true;
                }
                return false;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void dtd() throws ExoPlaybackException {
        try {
            this.mbN.dsG();
        } catch (AudioSink.WriteException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.mbN.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.mbN.a((b) obj);
                return;
            default:
                super.k(i, obj);
                return;
        }
    }

    private static boolean Pc(String str) {
        return v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHg.startsWith("zeroflte") || v.mHg.startsWith("herolte") || v.mHg.startsWith("heroqlte"));
    }

    /* loaded from: classes5.dex */
    private final class a implements AudioSink.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void EP(int i) {
            g.this.mbM.IZ(i);
            g.this.EP(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void dsJ() {
            g.this.dtc();
            g.this.mbS = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void i(int i, long j, long j2) {
            g.this.mbM.h(i, j, j2);
            g.this.j(i, j, j2);
        }
    }
}
