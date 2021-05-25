package d.e.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f66074a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f66075b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f66076c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f66077d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66078e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", 128000);
        try {
            this.f66075b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f66075b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66075b.start();
        this.f66077d = -1;
        this.f66078e = false;
        this.f66074a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f66075b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66075b.dequeueOutputBuffer(this.f66076c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66075b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66078e) {
                    MediaFormat outputFormat = this.f66075b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f66077d = this.f66074a.a(outputFormat);
                    if (!this.f66074a.c()) {
                        synchronized (this.f66074a) {
                            while (!this.f66074a.b()) {
                                try {
                                    this.f66074a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f66078e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66076c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66076c;
                    if (bufferInfo2.size != 0) {
                        if (this.f66078e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66076c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66074a.e(this.f66077d, byteBuffer, this.f66076c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66075b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f66076c.flags & 4) != 0) {
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    public void b(ByteBuffer byteBuffer, int i2, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.f66075b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f66075b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i2 <= 0) {
            this.f66075b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f66075b.queueInputBuffer(dequeueInputBuffer, 0, i2, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f66075b != null) {
                this.f66075b.stop();
                this.f66075b.release();
                this.f66075b = null;
            }
            if (this.f66074a != null) {
                this.f66074a.d();
                this.f66074a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
