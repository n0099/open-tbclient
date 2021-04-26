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
    public c f65345a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f65346b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f65347c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f65348d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65349e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", 128000);
        try {
            this.f65346b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f65346b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f65346b.start();
        this.f65348d = -1;
        this.f65349e = false;
        this.f65345a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f65346b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f65346b.dequeueOutputBuffer(this.f65347c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f65346b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f65349e) {
                    MediaFormat outputFormat = this.f65346b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f65348d = this.f65345a.a(outputFormat);
                    if (!this.f65345a.c()) {
                        synchronized (this.f65345a) {
                            while (!this.f65345a.b()) {
                                try {
                                    this.f65345a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f65349e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f65347c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f65347c;
                    if (bufferInfo2.size != 0) {
                        if (this.f65349e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f65347c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f65345a.e(this.f65348d, byteBuffer, this.f65347c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f65346b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f65347c.flags & 4) != 0) {
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
        ByteBuffer[] inputBuffers = this.f65346b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f65346b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i2 <= 0) {
            this.f65346b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f65346b.queueInputBuffer(dequeueInputBuffer, 0, i2, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f65346b != null) {
                this.f65346b.stop();
                this.f65346b.release();
                this.f65346b = null;
            }
            if (this.f65345a != null) {
                this.f65345a.d();
                this.f65345a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
