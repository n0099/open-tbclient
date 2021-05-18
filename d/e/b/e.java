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
import d.a.k0.t1.g;
import d.a.k0.t1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f66065a;

    /* renamed from: b  reason: collision with root package name */
    public c f66066b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f66067c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f66068d;

    /* renamed from: e  reason: collision with root package name */
    public int f66069e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66070f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f66071g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f66072h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66073i = false;
    public g j;

    public e(int i2, int i3, int i4, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f66068d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f66067c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66065a = this.f66067c.createInputSurface();
        this.f66067c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f66071g.putInt("request-sync", 0);
            this.f66067c.setParameters(this.f66071g);
        }
        this.f66069e = -1;
        this.f66070f = false;
        this.f66066b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f66067c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f66067c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66067c.dequeueOutputBuffer(this.f66068d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66067c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66070f) {
                    MediaFormat outputFormat = this.f66067c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f66069e = this.f66066b.a(outputFormat);
                    if (!this.f66066b.c()) {
                        synchronized (this.f66066b) {
                            while (!this.f66066b.b() && !this.f66073i) {
                                try {
                                    this.f66066b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.f66073i) {
                        return;
                    }
                    this.f66070f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66068d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66068d;
                    if (bufferInfo2.size != 0) {
                        if (this.f66070f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66068d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66066b.e(this.f66069e, byteBuffer, this.f66068d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66067c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f66072h >= 500) {
                        this.f66067c.setParameters(this.f66071g);
                        this.f66072h = System.currentTimeMillis();
                    }
                    if ((this.f66068d.flags & 4) != 0) {
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
        return this.f66065a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f66067c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f66067c.release();
            this.f66067c = null;
        }
        c cVar = this.f66066b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.b(17, d.a.k0.t1.a.a(e2));
                }
            }
            this.f66066b = null;
        }
    }

    public synchronized void d() {
        this.f66073i = true;
    }
}
