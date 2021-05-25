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
import d.a.n0.u1.g;
import d.a.n0.u1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f66108a;

    /* renamed from: b  reason: collision with root package name */
    public c f66109b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f66110c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f66111d;

    /* renamed from: e  reason: collision with root package name */
    public int f66112e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66113f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f66114g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f66115h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66116i = false;
    public g j;

    public e(int i2, int i3, int i4, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f66111d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i4);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f66110c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66108a = this.f66110c.createInputSurface();
        this.f66110c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f66114g.putInt("request-sync", 0);
            this.f66110c.setParameters(this.f66114g);
        }
        this.f66112e = -1;
        this.f66113f = false;
        this.f66109b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f66110c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f66110c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66110c.dequeueOutputBuffer(this.f66111d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66110c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66113f) {
                    MediaFormat outputFormat = this.f66110c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f66112e = this.f66109b.a(outputFormat);
                    if (!this.f66109b.c()) {
                        synchronized (this.f66109b) {
                            while (!this.f66109b.b() && !this.f66116i) {
                                try {
                                    this.f66109b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.f66116i) {
                        return;
                    }
                    this.f66113f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66111d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66111d;
                    if (bufferInfo2.size != 0) {
                        if (this.f66113f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66111d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66109b.e(this.f66112e, byteBuffer, this.f66111d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66110c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f66115h >= 500) {
                        this.f66110c.setParameters(this.f66114g);
                        this.f66115h = System.currentTimeMillis();
                    }
                    if ((this.f66111d.flags & 4) != 0) {
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
        return this.f66108a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f66110c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f66110c.release();
            this.f66110c = null;
        }
        c cVar = this.f66109b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.b(17, d.a.n0.u1.a.a(e2));
                }
            }
            this.f66109b = null;
        }
    }

    public synchronized void d() {
        this.f66116i = true;
    }
}
