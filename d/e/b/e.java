package d.e.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.kwai.video.player.KsMediaMeta;
import d.a.o0.u1.g;
import d.a.o0.u1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f69943a;

    /* renamed from: b  reason: collision with root package name */
    public c f69944b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f69945c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f69946d;

    /* renamed from: e  reason: collision with root package name */
    public int f69947e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69948f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f69949g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f69950h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69951i = false;
    public g j;

    public e(int i2, int i3, int i4, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f69946d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i4);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f69945c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f69943a = this.f69945c.createInputSurface();
        this.f69945c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f69949g.putInt("request-sync", 0);
            this.f69945c.setParameters(this.f69949g);
        }
        this.f69947e = -1;
        this.f69948f = false;
        this.f69944b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f69945c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f69945c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f69945c.dequeueOutputBuffer(this.f69946d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f69945c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f69948f) {
                    MediaFormat outputFormat = this.f69945c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f69947e = this.f69944b.a(outputFormat);
                    if (!this.f69944b.c()) {
                        synchronized (this.f69944b) {
                            while (!this.f69944b.b() && !this.f69951i) {
                                try {
                                    this.f69944b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.f69951i) {
                        return;
                    }
                    this.f69948f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f69946d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f69946d;
                    if (bufferInfo2.size != 0) {
                        if (this.f69948f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f69946d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f69944b.e(this.f69947e, byteBuffer, this.f69946d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f69945c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f69950h >= 500) {
                        this.f69945c.setParameters(this.f69949g);
                        this.f69950h = System.currentTimeMillis();
                    }
                    if ((this.f69946d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        Log.w("VideoEncoder", "reached end of stream unexpectedly");
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    public Surface b() {
        return this.f69943a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f69945c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f69945c.release();
            this.f69945c = null;
        }
        c cVar = this.f69944b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.b(17, d.a.o0.u1.a.a(e2));
                }
            }
            this.f69944b = null;
        }
    }

    public synchronized void d() {
        this.f69951i = true;
    }
}
