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
    private final d.a mbH;
    private final AudioSink mbI;
    private boolean mbJ;
    private boolean mbK;
    private MediaFormat mbL;
    private long mbM;
    private boolean mbN;
    private int pcmEncoding;

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
    }

    public g(com.google.android.exoplayer2.mediacodec.b bVar, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        this.mbH = new d.a(handler, dVar);
        this.mbI = audioSink;
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
            if (a2 && Pb(str) && bVar.duK() != null) {
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
        com.google.android.exoplayer2.mediacodec.a duK;
        if (Pb(format.sampleMimeType) && (duK = bVar.duK()) != null) {
            this.mbJ = true;
            return duK;
        }
        this.mbJ = false;
        return super.a(bVar, format, z);
    }

    protected boolean Pb(String str) {
        return this.mbI.OZ(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.mbK = Pc(aVar.name);
        if (this.mbJ) {
            this.mbL = format.dsj();
            this.mbL.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.mbL, (Surface) null, mediaCrypto, 0);
            this.mbL.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.dsj(), (Surface) null, mediaCrypto, 0);
        this.mbL = null;
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.s
    public com.google.android.exoplayer2.util.h drr() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(String str, long j, long j2) {
        this.mbH.f(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g(Format format) throws ExoPlaybackException {
        super.g(format);
        this.mbH.f(format);
        this.pcmEncoding = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay != -1 ? format.encoderDelay : 0;
        this.encoderPadding = format.encoderPadding != -1 ? format.encoderPadding : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = this.mbL != null;
        String string = z ? this.mbL.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.mbL;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.mbK && integer == 6 && this.channelCount < 6) {
            iArr = new int[this.channelCount];
            for (int i = 0; i < this.channelCount; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.mbI.a(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    protected void EP(int i) {
    }

    protected void dta() {
    }

    protected void j(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void vt(boolean z) throws ExoPlaybackException {
        super.vt(z);
        this.mbH.e(this.mpm);
        int i = drz().lYZ;
        if (i != 0) {
            this.mbI.Ja(i);
        } else {
            this.mbI.dsG();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void j(long j, boolean z) throws ExoPlaybackException {
        super.j(j, z);
        this.mbI.reset();
        this.mbM = j;
        this.mbN = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStarted() {
        super.onStarted();
        this.mbI.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void onStopped() {
        this.mbI.pause();
        super.onStopped();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 367=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    protected void dry() {
        try {
            this.mbI.release();
            try {
                super.dry();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.dry();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean atB() {
        return super.atB() && this.mbI.atB();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.s
    public boolean isReady() {
        return this.mbI.dsF() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dsW() {
        long vB = this.mbI.vB(atB());
        if (vB != Long.MIN_VALUE) {
            if (!this.mbN) {
                vB = Math.max(this.mbM, vB);
            }
            this.mbM = vB;
            this.mbN = false;
        }
        return this.mbM;
    }

    @Override // com.google.android.exoplayer2.util.h
    public q d(q qVar) {
        return this.mbI.d(qVar);
    }

    @Override // com.google.android.exoplayer2.util.h
    public q drF() {
        return this.mbI.drF();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.mbJ && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.mpm.mcL++;
            this.mbI.dsD();
            return true;
        } else {
            try {
                if (this.mbI.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.mpm.mcK++;
                    return true;
                }
                return false;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void dtb() throws ExoPlaybackException {
        try {
            this.mbI.dsE();
        } catch (AudioSink.WriteException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.g.a
    public void k(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.mbI.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.mbI.a((b) obj);
                return;
            default:
                super.k(i, obj);
                return;
        }
    }

    private static boolean Pc(String str) {
        return v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHb.startsWith("zeroflte") || v.mHb.startsWith("herolte") || v.mHb.startsWith("heroqlte"));
    }

    /* loaded from: classes5.dex */
    private final class a implements AudioSink.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void EP(int i) {
            g.this.mbH.IZ(i);
            g.this.EP(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void dsH() {
            g.this.dta();
            g.this.mbN = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void i(int i, long j, long j2) {
            g.this.mbH.h(i, j, j2);
            g.this.j(i, j, j2);
        }
    }
}
