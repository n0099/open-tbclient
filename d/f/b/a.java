package d.f.b;

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
    public c f66935a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f66936b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f66937c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f66938d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66939e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        try {
            this.f66936b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f66936b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66936b.start();
        this.f66938d = -1;
        this.f66939e = false;
        this.f66935a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f66936b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66936b.dequeueOutputBuffer(this.f66937c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66936b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66939e) {
                    MediaFormat outputFormat = this.f66936b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f66938d = this.f66935a.a(outputFormat);
                    if (!this.f66935a.c()) {
                        synchronized (this.f66935a) {
                            while (!this.f66935a.b()) {
                                try {
                                    this.f66935a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f66939e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66937c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66937c;
                    if (bufferInfo2.size != 0) {
                        if (this.f66939e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66937c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66935a.e(this.f66938d, byteBuffer, this.f66937c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66936b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f66937c.flags & 4) != 0) {
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
        ByteBuffer[] inputBuffers = this.f66936b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f66936b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.f66936b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f66936b.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f66936b != null) {
                this.f66936b.stop();
                this.f66936b.release();
                this.f66936b = null;
            }
            if (this.f66935a != null) {
                this.f66935a.d();
                this.f66935a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
