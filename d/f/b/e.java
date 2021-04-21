package d.f.b;

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
import d.b.j0.t1.g;
import d.b.j0.t1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f66968a;

    /* renamed from: b  reason: collision with root package name */
    public c f66969b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f66970c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f66971d;

    /* renamed from: e  reason: collision with root package name */
    public int f66972e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66973f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f66974g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f66975h = 0;
    public boolean i = false;
    public g j;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f66971d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f66970c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66968a = this.f66970c.createInputSurface();
        this.f66970c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f66974g.putInt("request-sync", 0);
            this.f66970c.setParameters(this.f66974g);
        }
        this.f66972e = -1;
        this.f66973f = false;
        this.f66969b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f66970c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f66970c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66970c.dequeueOutputBuffer(this.f66971d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66970c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66973f) {
                    MediaFormat outputFormat = this.f66970c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f66972e = this.f66969b.a(outputFormat);
                    if (!this.f66969b.c()) {
                        synchronized (this.f66969b) {
                            while (!this.f66969b.b() && !this.i) {
                                try {
                                    this.f66969b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.i) {
                        return;
                    }
                    this.f66973f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66971d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66971d;
                    if (bufferInfo2.size != 0) {
                        if (this.f66973f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66971d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66969b.e(this.f66972e, byteBuffer, this.f66971d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66970c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f66975h >= 500) {
                        this.f66970c.setParameters(this.f66974g);
                        this.f66975h = System.currentTimeMillis();
                    }
                    if ((this.f66971d.flags & 4) != 0) {
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
        return this.f66968a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f66970c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f66970c.release();
            this.f66970c = null;
        }
        c cVar = this.f66969b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.c(17, d.b.j0.t1.a.a(e2));
                }
            }
            this.f66969b = null;
        }
    }

    public synchronized void d() {
        this.i = true;
    }
}
