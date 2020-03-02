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
/* loaded from: classes6.dex */
public class g extends MediaCodecRenderer implements com.google.android.exoplayer2.util.h {
    private int channelCount;
    private int encoderDelay;
    private int encoderPadding;
    private boolean mcA;
    private final d.a mcu;
    private final AudioSink mcv;
    private boolean mcw;
    private boolean mcx;
    private MediaFormat mcy;
    private long mcz;
    private int pcmEncoding;

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
    }

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        this.mcu = new d.a(handler, dVar);
        this.mcv = audioSink;
        audioSink.a(new a());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        boolean z2 = false;
        String str = format.sampleMimeType;
        if (com.google.android.exoplayer2.util.i.Qo(str)) {
            int i = v.SDK_INT >= 21 ? 32 : 0;
            boolean a2 = a(aVar, format.drmInitData);
            if (a2 && Po(str) && bVar.dvY() != null) {
                return i | 8 | 4;
            }
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
                    z |= drmInitData.Jr(i2).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a2) {
                if (v.SDK_INT < 21 || ((format.sampleRate == -1 || aL.Kb(format.sampleRate)) && (format.channelCount == -1 || aL.Kc(format.channelCount)))) {
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
        com.google.android.exoplayer2.mediacodec.a dvY;
        if (Po(format.sampleMimeType) && (dvY = bVar.dvY()) != null) {
            this.mcw = true;
            return dvY;
        }
        this.mcw = false;
        return super.a(bVar, format, z);
    }

    protected boolean Po(String str) {
        return this.mcv.Pm(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.mcx = Pp(aVar.name);
        if (this.mcw) {
            this.mcy = format.dtz();
            this.mcy.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.mcy, (Surface) null, mediaCrypto, 0);
            this.mcy.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.dtz(), (Surface) null, mediaCrypto, 0);
        this.mcy = null;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dsH() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mcu.f(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mcu.f(format);
        this.pcmEncoding = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay != -1 ? format.encoderDelay : 0;
        this.encoderPadding = format.encoderPadding != -1 ? format.encoderPadding : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = this.mcy != null;
        String string = z ? this.mcy.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.mcy;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.mcx && integer == 6 && this.channelCount < 6) {
            iArr = new int[this.channelCount];
            for (int i = 0; i < this.channelCount; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.mcv.a(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    protected void EU(int i) {
    }

    protected void dup() {
    }

    protected void j(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vx(boolean z) throws ExoPlaybackException {
        super.vx(z);
        this.mcu.e(this.mpZ);
        int i = dsP().lZM;
        if (i != 0) {
            this.mcv.Jf(i);
        } else {
            this.mcv.dtV();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void l(long j, boolean z) throws ExoPlaybackException {
        super.l(j, z);
        this.mcv.reset();
        this.mcz = j;
        this.mcA = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mcv.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mcv.pause();
        super.onStopped();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 367=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dsO() {
        try {
            this.mcv.release();
            try {
                super.dsO();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.dsO();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean avR() {
        return super.avR() && this.mcv.avR();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        return this.mcv.dtU() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dul() {
        long vF = this.mcv.vF(avR());
        if (vF != Long.MIN_VALUE) {
            if (!this.mcA) {
                vF = Math.max(this.mcz, vF);
            }
            this.mcz = vF;
            this.mcA = false;
        }
        return this.mcz;
    }

    @Override // com.google.android.exoplayer2.util.h
    public q d(q qVar) {
        return this.mcv.d(qVar);
    }

    @Override // com.google.android.exoplayer2.util.h
    public q dsV() {
        return this.mcv.dsV();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.mcw && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.mpZ.mdy++;
            this.mcv.dtS();
            return true;
        } else {
            try {
                if (this.mcv.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.mpZ.mdx++;
                    return true;
                }
                return false;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void duq() throws ExoPlaybackException {
        try {
            this.mcv.dtT();
        } catch (AudioSink.WriteException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.mcv.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.mcv.a((b) obj);
                return;
            default:
                super.k(i, obj);
                return;
        }
    }

    private static boolean Pp(String str) {
        return v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHN.startsWith("zeroflte") || v.mHN.startsWith("herolte") || v.mHN.startsWith("heroqlte"));
    }

    /* loaded from: classes6.dex */
    private final class a implements AudioSink.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void EU(int i) {
            g.this.mcu.Je(i);
            g.this.EU(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void dtW() {
            g.this.dup();
            g.this.mcA = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void i(int i, long j, long j2) {
            g.this.mcu.h(i, j, j2);
            g.this.j(i, j, j2);
        }
    }
}
