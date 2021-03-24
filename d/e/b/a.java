package d.e.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f65942a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f65943b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f65944c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f65945d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65946e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        try {
            this.f65943b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f65943b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f65943b.start();
        this.f65945d = -1;
        this.f65946e = false;
        this.f65942a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f65943b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f65943b.dequeueOutputBuffer(this.f65944c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f65943b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f65946e) {
                    MediaFormat outputFormat = this.f65943b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f65945d = this.f65942a.a(outputFormat);
                    if (!this.f65942a.c()) {
                        synchronized (this.f65942a) {
                            while (!this.f65942a.b()) {
                                try {
                                    this.f65942a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f65946e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f65944c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f65944c;
                    if (bufferInfo2.size != 0) {
                        if (this.f65946e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f65944c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f65942a.e(this.f65945d, byteBuffer, this.f65944c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f65943b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f65944c.flags & 4) != 0) {
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    public void b(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.f65943b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f65943b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.f65943b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f65943b.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f65943b != null) {
                this.f65943b.stop();
                this.f65943b.release();
                this.f65943b = null;
            }
            if (this.f65942a != null) {
                this.f65942a.d();
                this.f65942a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
