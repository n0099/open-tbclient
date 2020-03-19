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
    private final d.a mel;
    private final AudioSink mem;
    private boolean men;
    private boolean meo;
    private MediaFormat mep;
    private long meq;
    private boolean mer;
    private int pcmEncoding;

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
    }

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        this.mel = new d.a(handler, dVar);
        this.mem = audioSink;
        audioSink.a(new a());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        boolean z2 = false;
        String str = format.sampleMimeType;
        if (com.google.android.exoplayer2.util.i.Qp(str)) {
            int i = v.SDK_INT >= 21 ? 32 : 0;
            boolean a2 = a(aVar, format.drmInitData);
            if (a2 && Pp(str) && bVar.dww() != null) {
                return i | 8 | 4;
            }
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
                    z |= drmInitData.Jx(i2).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.mediacodec.a aL = bVar.aL(str, z);
            if (aL == null) {
                return (!z || bVar.aL(str, false) == null) ? 1 : 2;
            } else if (a2) {
                if (v.SDK_INT < 21 || ((format.sampleRate == -1 || aL.Kh(format.sampleRate)) && (format.channelCount == -1 || aL.Ki(format.channelCount)))) {
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
        com.google.android.exoplayer2.mediacodec.a dww;
        if (Pp(format.sampleMimeType) && (dww = bVar.dww()) != null) {
            this.men = true;
            return dww;
        }
        this.men = false;
        return super.a(bVar, format, z);
    }

    protected boolean Pp(String str) {
        return this.mem.Pn(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.meo = Pq(aVar.name);
        if (this.men) {
            this.mep = format.dtX();
            this.mep.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.mep, (Surface) null, mediaCrypto, 0);
            this.mep.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.dtX(), (Surface) null, mediaCrypto, 0);
        this.mep = null;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h dtf() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mel.f(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mel.f(format);
        this.pcmEncoding = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay != -1 ? format.encoderDelay : 0;
        this.encoderPadding = format.encoderPadding != -1 ? format.encoderPadding : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = this.mep != null;
        String string = z ? this.mep.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.mep;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.meo && integer == 6 && this.channelCount < 6) {
            iArr = new int[this.channelCount];
            for (int i = 0; i < this.channelCount; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.mem.a(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    protected void Fb(int i) {
    }

    protected void duN() {
    }

    protected void j(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vE(boolean z) throws ExoPlaybackException {
        super.vE(z);
        this.mel.e(this.mrQ);
        int i = dtn().mbG;
        if (i != 0) {
            this.mem.Jl(i);
        } else {
            this.mem.dut();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void m(long j, boolean z) throws ExoPlaybackException {
        super.m(j, z);
        this.mem.reset();
        this.meq = j;
        this.mer = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mem.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mem.pause();
        super.onStopped();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 367=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dtm() {
        try {
            this.mem.release();
            try {
                super.dtm();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.dtm();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean avU() {
        return super.avU() && this.mem.avU();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        return this.mem.dus() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.h
    public long duJ() {
        long vM = this.mem.vM(avU());
        if (vM != Long.MIN_VALUE) {
            if (!this.mer) {
                vM = Math.max(this.meq, vM);
            }
            this.meq = vM;
            this.mer = false;
        }
        return this.meq;
    }

    @Override // com.google.android.exoplayer2.util.h
    public q d(q qVar) {
        return this.mem.d(qVar);
    }

    @Override // com.google.android.exoplayer2.util.h
    public q dtt() {
        return this.mem.dtt();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.men && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.mrQ.mfp++;
            this.mem.duq();
            return true;
        } else {
            try {
                if (this.mem.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.mrQ.mfo++;
                    return true;
                }
                return false;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void duO() throws ExoPlaybackException {
        try {
            this.mem.dur();
        } catch (AudioSink.WriteException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.mem.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.mem.a((b) obj);
                return;
            default:
                super.k(i, obj);
                return;
        }
    }

    private static boolean Pq(String str) {
        return v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mJI.startsWith("zeroflte") || v.mJI.startsWith("herolte") || v.mJI.startsWith("heroqlte"));
    }

    /* loaded from: classes6.dex */
    private final class a implements AudioSink.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void Fb(int i) {
            g.this.mel.Jk(i);
            g.this.Fb(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void duu() {
            g.this.duN();
            g.this.mer = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void i(int i, long j, long j2) {
            g.this.mel.h(i, j, j2);
            g.this.j(i, j, j2);
        }
    }
}
