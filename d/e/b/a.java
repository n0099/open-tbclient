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
    public c f66788a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f66789b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f66790c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    public int f66791d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66792e;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 128000);
        try {
            this.f66789b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f66789b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f66789b.start();
        this.f66791d = -1;
        this.f66792e = false;
        this.f66788a = cVar;
    }

    public void a() throws Exception {
        ByteBuffer[] outputBuffers = this.f66789b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f66789b.dequeueOutputBuffer(this.f66790c, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f66789b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f66792e) {
                    MediaFormat outputFormat = this.f66789b.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.f66791d = this.f66788a.a(outputFormat);
                    if (!this.f66788a.c()) {
                        synchronized (this.f66788a) {
                            while (!this.f66788a.b()) {
                                try {
                                    this.f66788a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f66792e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f66790c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f66790c;
                    if (bufferInfo2.size != 0) {
                        if (this.f66792e) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.f66790c;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.f66788a.e(this.f66791d, byteBuffer, this.f66790c);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f66789b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f66790c.flags & 4) != 0) {
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
        ByteBuffer[] inputBuffers = this.f66789b.getInputBuffers();
        do {
            dequeueInputBuffer = this.f66789b.dequeueInputBuffer(10000L);
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.f66789b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.f66789b.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void c() {
        try {
            if (this.f66789b != null) {
                this.f66789b.stop();
                this.f66789b.release();
                this.f66789b = null;
            }
            if (this.f66788a != null) {
                this.f66788a.d();
                this.f66788a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
