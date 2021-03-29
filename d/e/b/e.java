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
import d.b.i0.s1.g;
import d.b.i0.s1.k;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Surface f65976a;

    /* renamed from: b  reason: collision with root package name */
    public c f65977b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f65978c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f65979d;

    /* renamed from: e  reason: collision with root package name */
    public int f65980e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65981f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f65982g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public long f65983h = 0;
    public boolean i = false;
    public g j;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        this.f65979d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f65978c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f65976a = this.f65978c.createInputSurface();
        this.f65978c.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f65982g.putInt("request-sync", 0);
            this.f65978c.setParameters(this.f65982g);
        }
        this.f65980e = -1;
        this.f65981f = false;
        this.f65977b = cVar;
    }

    public void a(boolean z) throws Exception {
        if (z) {
            this.f65978c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f65978c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f65978c.dequeueOutputBuffer(this.f65979d, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f65978c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f65981f) {
                    MediaFormat outputFormat = this.f65978c.getOutputFormat();
                    Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                    this.f65980e = this.f65977b.a(outputFormat);
                    if (!this.f65977b.c()) {
                        synchronized (this.f65977b) {
                            while (!this.f65977b.b() && !this.i) {
                                try {
                                    this.f65977b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.i) {
                        return;
                    }
                    this.f65981f = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f65979d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f65979d;
                    if (bufferInfo2.size != 0) {
                        if (this.f65981f) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f65979d;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f65977b.e(this.f65980e, byteBuffer, this.f65979d);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f65978c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f65983h >= 500) {
                        this.f65978c.setParameters(this.f65982g);
                        this.f65983h = System.currentTimeMillis();
                    }
                    if ((this.f65979d.flags & 4) != 0) {
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
        return this.f65976a;
    }

    public void c() {
        MediaCodec mediaCodec = this.f65978c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f65978c.release();
            this.f65978c = null;
        }
        c cVar = this.f65977b;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e2) {
                g gVar = this.j;
                if (gVar != null) {
                    gVar.c(17, d.b.i0.s1.a.a(e2));
                }
            }
            this.f65977b = null;
        }
    }

    public synchronized void d() {
        this.i = true;
    }
}
