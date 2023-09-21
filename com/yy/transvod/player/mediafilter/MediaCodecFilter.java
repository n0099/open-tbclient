package com.yy.transvod.player.mediafilter;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Message;
import android.view.Surface;
import com.baidu.tieba.h6c;
import com.baidu.tieba.i7c;
import com.baidu.tieba.j7c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.n7c;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
@TargetApi(16)
/* loaded from: classes10.dex */
public abstract class MediaCodecFilter extends n7c {
    public final String A = MediaCodecFilter.class.getSimpleName();
    public MediaCodec B = null;
    public MediaCodec.BufferInfo C = null;
    public ByteBuffer[] D = null;
    public ByteBuffer[] E = null;
    public Surface F = null;
    public WeakReference<SurfaceTexture> G = null;
    public WeakReference<m8c> H = new WeakReference<>(null);
    public c I = new c();
    public b J = null;
    public int K = 0;
    public int L = 0;
    public long M = 0;
    public boolean N = false;
    public boolean O = false;

    public abstract int N(long j);

    /* loaded from: classes10.dex */
    public class OverMaxInputTryCountException extends RuntimeException {
        public OverMaxInputTryCountException() {
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public ByteBuffer a;
        public ByteBuffer b;

        public b(MediaFormat mediaFormat) {
            this.a = null;
            this.b = null;
            if (mediaFormat == null) {
                return;
            }
            try {
                this.a = mediaFormat.getByteBuffer("csd-0");
                this.b = mediaFormat.getByteBuffer("csd-1");
            } catch (Exception e) {
                TLog.g(this, "CsdData exception: " + e.toString());
            }
        }

        public boolean a(b bVar) {
            if (bVar == null) {
                return false;
            }
            if (bVar == this || (this.a == bVar.a && this.b == bVar.b)) {
                return true;
            }
            ByteBuffer byteBuffer = this.a;
            ByteBuffer byteBuffer2 = bVar.a;
            if (byteBuffer != byteBuffer2 && (byteBuffer == null || byteBuffer2 == null || !Arrays.equals(byteBuffer.array(), bVar.a.array()))) {
                return false;
            }
            ByteBuffer byteBuffer3 = this.b;
            ByteBuffer byteBuffer4 = bVar.b;
            if (byteBuffer3 != byteBuffer4 && (byteBuffer3 == null || byteBuffer4 == null || !Arrays.equals(byteBuffer3.array(), bVar.b.array()))) {
                return false;
            }
            return true;
        }

        public boolean b() {
            if (this.a == null && this.b == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class c {
        public int a;
        public long b;

        public c() {
            this.a = 0;
            this.b = 0L;
        }

        public boolean a() {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            if (this.a > 90 && currentTimeMillis > 3000) {
                return true;
            }
            return false;
        }

        public void b() {
            this.a++;
            if (this.b == 0) {
                this.b = System.currentTimeMillis();
            }
        }

        public void c() {
            this.a = 0;
            this.b = 0L;
        }
    }

    @Override // com.baidu.tieba.n7c
    public void B() {
        if (this.B != null) {
            while (!this.r.b() && N(100000L) == 1) {
                try {
                    TLog.g(this, "handleEndOfStream");
                    Thread.sleep(20L);
                } catch (Exception e) {
                    TLog.c(this, "mediaCodec decode error::handleEndOfStream" + e.toString());
                }
            }
            this.N = true;
        }
    }

    @Override // com.baidu.tieba.n7c
    public void C() {
        MediaCodec mediaCodec = this.B;
        if (mediaCodec != null) {
            mediaCodec.flush();
            F();
        }
    }

    @Override // com.baidu.tieba.n7c
    public int D(MediaSample mediaSample) {
        MediaFormat mediaFormat;
        SurfaceTexture surfaceTexture;
        AVframe aVframe = mediaSample.g;
        int i = aVframe.e;
        int i2 = this.a;
        int i3 = 0;
        if (i > i2) {
            long j = this.v + 1;
            this.v = j;
            if (j < 2) {
                TLog.c(this, String.format("MediaCodec::sample.avFrame.playTaskID: %d > mPlayTaskID %d", Integer.valueOf(i), Integer.valueOf(this.a)));
            }
            return 0;
        } else if (i < i2) {
            long j2 = this.v + 1;
            this.v = j2;
            if (j2 < 2) {
                TLog.c(this, String.format("MediaCodec::sample.avFrame.playTaskID: %d < mPlayTaskID %d", Integer.valueOf(i), Integer.valueOf(this.a)));
            }
            return -1;
        } else {
            if (aVframe.a) {
                byte[] bArr = aVframe.q;
                if (bArr == null) {
                    TLog.c(this, "frame.spsPps null");
                    return -1;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (aVframe.f == 2000) {
                    mediaFormat = j7c.b((int) aVframe.j, (int) aVframe.k, wrap, false);
                } else {
                    mediaFormat = null;
                }
                if (aVframe.f == 2002) {
                    mediaFormat = j7c.c((int) aVframe.j, (int) aVframe.k, wrap, false);
                }
                b bVar = new b(mediaFormat);
                if (bVar.b()) {
                    return -1;
                }
                long currentTimeMillis = System.currentTimeMillis();
                b bVar2 = this.J;
                if ((bVar2 != null && !bVar2.b() && !this.J.a(bVar)) || this.N) {
                    TLog.g(this, "VideoHwDecodeFilter create again mForceRebuild :" + this.N);
                    if (this.B != null) {
                        O();
                    }
                    m8c m8cVar = this.H.get();
                    if (m8cVar != null && m8cVar.y() != null) {
                        if (m8cVar != null) {
                            surfaceTexture = m8cVar.y();
                        } else {
                            surfaceTexture = null;
                        }
                        WeakReference<SurfaceTexture> weakReference = new WeakReference<>(surfaceTexture);
                        this.G = weakReference;
                        if (this.O) {
                            this.B = J(null, mediaFormat);
                        } else if (weakReference.get() != null) {
                            Surface surface = this.F;
                            if (surface != null) {
                                surface.release();
                                this.F = null;
                            }
                            TLog.g(this, "mSurfaceTexture " + this.G.get());
                            Surface surface2 = new Surface(this.G.get());
                            this.F = surface2;
                            this.B = J(surface2, mediaFormat);
                        }
                        if (this.B == null) {
                            A();
                            return -1;
                        }
                        this.J = bVar;
                        this.N = false;
                    }
                    return -1;
                }
                b bVar3 = this.J;
                if (bVar3 == null || bVar3.b()) {
                    TLog.l(this, "VideoHwDecodeFilter pre create by no csd0.....");
                    MediaSample b2 = h6c.f().b(null, wrap);
                    int L = L(b2);
                    h6c.f().e(b2);
                    if (L == 1) {
                        this.J = bVar;
                        TLog.l(this, "VideoHwDecodeFilter pre create by no csd0, reconfig sucess, time cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    } else if (L == -1) {
                        return K(null);
                    } else {
                        return L;
                    }
                }
                E(mediaSample, System.currentTimeMillis() - currentTimeMillis);
            }
            try {
                i3 = M(mediaSample);
                N(0L);
                return i3;
            } catch (Exception e) {
                TLog.c(this, "internalProcessInput error: " + e.getMessage() + " retryCount " + this.K);
                if (i3 == 1) {
                    this.r.d(mediaSample);
                }
                return K(e);
            }
        }
    }

    public final int M(MediaSample mediaSample) {
        int i;
        long j;
        byte[] bArr;
        if (this.B == null) {
            return -3;
        }
        MediaInfo mediaInfo = mediaSample.i;
        if (mediaSample.d) {
            i = 1;
        } else {
            i = 0;
        }
        if (mediaSample.g.c) {
            i |= 4;
            this.l.f(2002);
        }
        int i2 = i;
        int remaining = mediaInfo.k.remaining();
        if ((i2 & 4) != 0) {
            j = 100000;
        } else {
            j = 10000;
        }
        try {
            int dequeueInputBuffer = this.B.dequeueInputBuffer(j);
            if (dequeueInputBuffer >= 0 && remaining > 0) {
                this.I.c();
                ByteBuffer byteBuffer = this.D[dequeueInputBuffer];
                byteBuffer.clear();
                if (mediaInfo.a == 10) {
                    try {
                        remaining = j7c.k(mediaInfo.k, byteBuffer, mediaSample.d);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        m(51);
                        return -1;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw e2;
                    }
                } else {
                    if (mediaSample.d && (bArr = mediaSample.g.q) != null) {
                        byteBuffer.put(bArr);
                        remaining += mediaSample.g.q.length;
                    }
                    mediaInfo.k.mark();
                    byteBuffer.put(mediaInfo.k);
                    mediaInfo.k.reset();
                }
                int i3 = remaining;
                if (byteBuffer.position() == i3) {
                    this.L++;
                    this.B.queueInputBuffer(dequeueInputBuffer, 0, i3, mediaSample.g.m * 1000, i2);
                    if (this.L == 1) {
                        TLog.l(this, "mediacodec dequeueInputBuffer first frame!!");
                        this.M = System.currentTimeMillis();
                    }
                    this.r.a(mediaSample);
                    return 1;
                }
                TLog.c(this, "buffer.position: " + byteBuffer.position() + "buffer.capacity: " + byteBuffer.capacity() + "info.data.remaining: " + mediaInfo.k.remaining() + "info.w: " + mediaInfo.b + "info.h: " + mediaInfo.c + "length: " + i3);
                StringBuilder sb = new StringBuilder();
                sb.append("sample.taskID: ");
                sb.append(mediaSample.g.e);
                sb.append("mTaskID: ");
                sb.append(this.a);
                TLog.c(this, sb.toString());
                throw new RuntimeException("unexpected buffer.");
            }
            TLog.c(this, "mCodec.dequeueInputBuffer() failed. type:" + i7c.a[this.q.a] + " result " + dequeueInputBuffer + " pts:" + mediaSample.l);
            this.I.b();
            if (!this.I.a()) {
                return 0;
            }
            TLog.c(this, "mCodec.dequeueInputBuffer() failed. checkError true");
            this.I.c();
            throw new OverMaxInputTryCountException();
        } catch (IllegalStateException e3) {
            TLog.d(this.A, "mCodec.dequeueInputBuffer exception: " + e3.getMessage());
            throw e3;
        }
    }

    public final MediaCodec J(Surface surface, MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            this.D = createDecoderByType.getInputBuffers();
            this.E = createDecoderByType.getOutputBuffers();
            this.C = new MediaCodec.BufferInfo();
            this.J = new b(mediaFormat);
            this.L = 0;
            String str = "y";
            if (Build.VERSION.SDK_INT >= 18) {
                Object[] objArr = new Object[3];
                objArr[0] = string;
                objArr[1] = createDecoderByType.getName();
                if (!this.J.b()) {
                    str = "n";
                }
                objArr[2] = str;
                TLog.l(this, String.format("createDecoderByType(%s) = %s, mcsd0=null? %s", objArr));
            } else {
                Object[] objArr2 = new Object[3];
                objArr2[0] = string;
                objArr2[1] = createDecoderByType.toString();
                if (!this.J.b()) {
                    str = "n";
                }
                objArr2[2] = str;
                TLog.l(this, String.format("createDecoderByType(%s) = %s, mcsd0=null? %s", objArr2));
            }
            return createDecoderByType;
        } catch (Exception e) {
            e.printStackTrace();
            m(50);
            TLog.g(this, "createDecoder failed mine " + string);
            return null;
        }
    }

    public final int K(Exception exc) {
        if (exc != null && (exc instanceof OverMaxInputTryCountException)) {
            TLog.c(this, "internalProcessInput error: OverMaxInputTryCountException");
            A();
            return -2;
        } else if (this.K < 3 && !this.N) {
            TLog.c(this, "internalProcessInput error: MediaConst.EXCEPTION");
            this.K++;
            this.N = true;
            return -1;
        } else if (this.K < 3) {
            return -1;
        } else {
            TLog.c(this, "internalProcessInput error: MediaConst.FATAL_ERROR");
            m(51);
            A();
            return -2;
        }
    }

    public final int L(MediaSample mediaSample) {
        if (this.B == null) {
            return -3;
        }
        int remaining = mediaSample.i.k.remaining();
        try {
            int dequeueInputBuffer = this.B.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0 && remaining > 0) {
                String str = this.A;
                TLog.h(str, "mediaCodecProcessConfig length:" + remaining + " buffer index:" + dequeueInputBuffer);
                ByteBuffer byteBuffer = this.D[dequeueInputBuffer];
                byteBuffer.clear();
                mediaSample.i.k.mark();
                byteBuffer.put(mediaSample.i.k);
                mediaSample.i.k.reset();
                try {
                    this.B.queueInputBuffer(dequeueInputBuffer, 0, remaining, 0L, 2);
                    return 1;
                } catch (Exception e) {
                    String str2 = this.A;
                    TLog.d(str2, "mediaCodecProcessConfig, mCodec.queueInputBuffer exception: " + e.toString());
                    return -1;
                }
            }
            return 0;
        } catch (Exception e2) {
            String str3 = this.A;
            TLog.d(str3, "mCodec.dequeueInputBuffer exception: " + e2.getMessage());
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r3.J = null;
        r3.C = null;
        r3.D = null;
        r3.E = null;
        r3.v = 0;
        G();
        com.yy.transvod.player.log.TLog.g(r3, "MediaCodecFilter.stopCodec leave.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void O() {
        TLog.l(this, "MediaCodecFilter.stopCodec enter.");
        try {
            try {
                if (this.B != null) {
                    this.B.stop();
                    this.B.release();
                    this.B = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                m(52);
                MediaCodec mediaCodec = this.B;
            }
        } finally {
            MediaCodec mediaCodec2 = this.B;
            if (mediaCodec2 != null) {
                mediaCodec2.release();
                this.B = null;
            }
        }
    }

    @Override // com.baidu.tieba.n7c, com.baidu.tieba.w7c, com.baidu.tieba.e6c.a
    public void handleMessage(Message message) {
        if (message.what != 1002) {
            super.handleMessage(message);
        } else {
            O();
        }
    }
}
