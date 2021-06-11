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
    public c f69805a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f69806b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f69807c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f69808d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69809e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        try {
            this.f69806b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f69806b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f69806b.start();
        this.f69808d = -1;
        this.f69809e = false;
        this.f69805a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f69806b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f69806b.dequeueOutputBuffer(this.f69807c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f69806b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f69809e) {
                    MediaFormat outputFormat = this.f69806b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f69808d = this.f69805a.a(outputFormat);
                    if (!this.f69805a.c()) {
                        synchronized (this.f69805a) {
                            while (!this.f69805a.b()) {
                                try {
                                    this.f69805a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f69809e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f69807c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f69807c;
                    if (bufferInfo2.size != 0) {
                        if (this.f69809e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f69807c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f69805a.e(this.f69808d, byteBuffer, this.f69807c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f69806b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f69807c.flags & 4) != 0) {
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
        ByteBuffer[] inputBuffers = this.f69806b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f69806b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i2 <= 0) {
            this.f69806b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f69806b.queueInputBuffer(dequeueInputBuffer, 0, i2, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f69806b != null) {
                this.f69806b.stop();
                this.f69806b.release();
                this.f69806b = null;
            }
            if (this.f69805a != null) {
                this.f69805a.d();
                this.f69805a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
