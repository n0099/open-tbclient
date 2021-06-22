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
    public c f69909a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f69910b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f69911c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f69912d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69913e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        try {
            this.f69910b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f69910b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f69910b.start();
        this.f69912d = -1;
        this.f69913e = false;
        this.f69909a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f69910b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f69910b.dequeueOutputBuffer(this.f69911c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f69910b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f69913e) {
                    MediaFormat outputFormat = this.f69910b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f69912d = this.f69909a.a(outputFormat);
                    if (!this.f69909a.c()) {
                        synchronized (this.f69909a) {
                            while (!this.f69909a.b()) {
                                try {
                                    this.f69909a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f69913e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f69911c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f69911c;
                    if (bufferInfo2.size != 0) {
                        if (this.f69913e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f69911c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f69909a.e(this.f69912d, byteBuffer, this.f69911c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f69910b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f69911c.flags & 4) != 0) {
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
        ByteBuffer[] inputBuffers = this.f69910b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f69910b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i2 <= 0) {
            this.f69910b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f69910b.queueInputBuffer(dequeueInputBuffer, 0, i2, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f69910b != null) {
                this.f69910b.stop();
                this.f69910b.release();
                this.f69910b = null;
            }
            if (this.f69909a != null) {
                this.f69909a.d();
                this.f69909a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
