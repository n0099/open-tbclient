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
import d.a.j0.t1.g;
import d.a.j0.t1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f65379a;

    /* renamed from: b  reason: collision with root package name */
    public c f65380b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f65381c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f65382d;

    /* renamed from: e  reason: collision with root package name */
    public int f65383e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65384f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f65385g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f65386h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65387i = false;
    public g j;

    public e(int i2, int i3, int i4, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f65382d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f65381c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f65379a = this.f65381c.createInputSurface();
        this.f65381c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f65385g.putInt("request-sync", 0);
            this.f65381c.setParameters(this.f65385g);
        }
        this.f65383e = -1;
        this.f65384f = false;
        this.f65380b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f65381c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f65381c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f65381c.dequeueOutputBuffer(this.f65382d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f65381c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f65384f) {
                    MediaFormat outputFormat = this.f65381c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f65383e = this.f65380b.a(outputFormat);
                    if (!this.f65380b.c()) {
                        synchronized (this.f65380b) {
                            while (!this.f65380b.b() && !this.f65387i) {
                                try {
                                    this.f65380b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.f65387i) {
                        return;
                    }
                    this.f65384f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f65382d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f65382d;
                    if (bufferInfo2.size != 0) {
                        if (this.f65384f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f65382d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f65380b.e(this.f65383e, byteBuffer, this.f65382d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f65381c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f65386h >= 500) {
                        this.f65381c.setParameters(this.f65385g);
                        this.f65386h = System.currentTimeMillis();
                    }
                    if ((this.f65382d.flags & 4) != 0) {
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
        return this.f65379a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f65381c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f65381c.release();
            this.f65381c = null;
        }
        c cVar = this.f65380b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.b(17, d.a.j0.t1.a.a(e2));
                }
            }
            this.f65380b = null;
        }
    }

    public synchronized void d() {
        this.f65387i = true;
    }
}
