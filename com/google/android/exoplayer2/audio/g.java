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
    private final d.a mcs;
    private final AudioSink mct;
    private boolean mcu;
    private boolean mcv;
    private MediaFormat mcw;
    private long mcx;
    private boolean mcy;
    private int pcmEncoding;

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
    }

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        this.mcs = new d.a(handler, dVar);
        this.mct = audioSink;
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
            if (a2 && Po(str) && bVar.dvW() != null) {
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
        com.google.android.exoplayer2.mediacodec.a dvW;
        if (Po(format.sampleMimeType) && (dvW = bVar.dvW()) != null) {
            this.mcu = true;
            return dvW;
        }
        this.mcu = false;
        return super.a(bVar, format, z);
    }

    protected boolean Po(String str) {
        return this.mct.Pm(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.mcv = Pp(aVar.name);
        if (this.mcu) {
            this.mcw = format.dtx();
            this.mcw.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.mcw, (Surface) null, mediaCrypto, 0);
            this.mcw.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.dtx(), (Surface) null, mediaCrypto, 0);
        this.mcw = null;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dsF() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mcs.f(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mcs.f(format);
        this.pcmEncoding = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay != -1 ? format.encoderDelay : 0;
        this.encoderPadding = format.encoderPadding != -1 ? format.encoderPadding : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = this.mcw != null;
        String string = z ? this.mcw.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.mcw;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.mcv && integer == 6 && this.channelCount < 6) {
            iArr = new int[this.channelCount];
            for (int i = 0; i < this.channelCount; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.mct.a(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    protected void EU(int i) {
    }

    protected void dun() {
    }

    protected void j(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vx(boolean z) throws ExoPlaybackException {
        super.vx(z);
        this.mcs.e(this.mpX);
        int i = dsN().lZK;
        if (i != 0) {
            this.mct.Jf(i);
        } else {
            this.mct.dtT();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void l(long j, boolean z) throws ExoPlaybackException {
        super.l(j, z);
        this.mct.reset();
        this.mcx = j;
        this.mcy = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mct.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mct.pause();
        super.onStopped();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 367=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dsM() {
        try {
            this.mct.release();
            try {
                super.dsM();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.dsM();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean avP() {
        return super.avP() && this.mct.avP();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        return this.mct.dtS() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.h
    public long duj() {
        long vF = this.mct.vF(avP());
        if (vF != Long.MIN_VALUE) {
            if (!this.mcy) {
                vF = Math.max(this.mcx, vF);
            }
            this.mcx = vF;
            this.mcy = false;
        }
        return this.mcx;
    }

    @Override // com.google.android.exoplayer2.util.h
    public q d(q qVar) {
        return this.mct.d(qVar);
    }

    @Override // com.google.android.exoplayer2.util.h
    public q dsT() {
        return this.mct.dsT();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.mcu && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.mpX.mdw++;
            this.mct.dtQ();
            return true;
        } else {
            try {
                if (this.mct.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.mpX.mdv++;
                    return true;
                }
                return false;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void duo() throws ExoPlaybackException {
        try {
            this.mct.dtR();
        } catch (AudioSink.WriteException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.mct.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.mct.a((b) obj);
                return;
            default:
                super.k(i, obj);
                return;
        }
    }

    private static boolean Pp(String str) {
        return v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHL.startsWith("zeroflte") || v.mHL.startsWith("herolte") || v.mHL.startsWith("heroqlte"));
    }

    /* loaded from: classes6.dex */
    private final class a implements AudioSink.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void EU(int i) {
            g.this.mcs.Je(i);
            g.this.EU(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void dtU() {
            g.this.dun();
            g.this.mcy = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void i(int i, long j, long j2) {
            g.this.mcs.h(i, j, j2);
            g.this.j(i, j, j2);
        }
    }
}
