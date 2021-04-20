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
import d.b.i0.t1.g;
import d.b.i0.t1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f66821a;

    /* renamed from: b  reason: collision with root package name */
    public c f66822b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f66823c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f66824d;

    /* renamed from: e  reason: collision with root package name */
    public int f66825e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66826f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f66827g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f66828h = 0;
    public boolean i = false;
    public g j;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f66824d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f66823c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66821a = this.f66823c.createInputSurface();
        this.f66823c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f66827g.putInt("request-sync", 0);
            this.f66823c.setParameters(this.f66827g);
        }
        this.f66825e = -1;
        this.f66826f = false;
        this.f66822b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f66823c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f66823c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66823c.dequeueOutputBuffer(this.f66824d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66823c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66826f) {
                    MediaFormat outputFormat = this.f66823c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f66825e = this.f66822b.a(outputFormat);
                    if (!this.f66822b.c()) {
                        synchronized (this.f66822b) {
                            while (!this.f66822b.b() && !this.i) {
                                try {
                                    this.f66822b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.i) {
                        return;
                    }
                    this.f66826f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66824d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66824d;
                    if (bufferInfo2.size != 0) {
                        if (this.f66826f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66824d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66822b.e(this.f66825e, byteBuffer, this.f66824d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66823c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f66828h >= 500) {
                        this.f66823c.setParameters(this.f66827g);
                        this.f66828h = System.currentTimeMillis();
                    }
                    if ((this.f66824d.flags & 4) != 0) {
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
        return this.f66821a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f66823c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f66823c.release();
            this.f66823c = null;
        }
        c cVar = this.f66822b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.c(17, d.b.i0.t1.a.a(e2));
                }
            }
            this.f66822b = null;
        }
    }

    public synchronized void d() {
        this.i = true;
    }
}
