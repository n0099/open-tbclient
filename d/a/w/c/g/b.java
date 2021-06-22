package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: i  reason: collision with root package name */
    public static final String f68642i = "b";
    public static long j = 0;
    public static int k = 10000;

    /* renamed from: c  reason: collision with root package name */
    public e f68645c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f68646d;

    /* renamed from: f  reason: collision with root package name */
    public c f68648f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68649g;

    /* renamed from: a  reason: collision with root package name */
    public int f68643a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68644b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f68650h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f68647e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f68644b && this.f68643a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f68646d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(f68642i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(f68642i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f68646d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f68646d;
            MediaCodec.BufferInfo bufferInfo = this.f68647e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f68646d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f68646d.dequeueOutputBuffer(this.f68647e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(f68642i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f68646d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f68645c.c()) {
                        Log.e(f68642i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f68646d.getOutputFormat();
                    String str = f68642i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f68643a = this.f68645c.a(outputFormat);
                    this.f68644b = true;
                    c cVar = this.f68648f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f68649g) {
                        this.f68645c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = f68642i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f68647e.flags & 2) != 0) {
                            Log.d(f68642i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f68647e.size = 0;
                        }
                        if (this.f68647e.size != 0) {
                            if (this.f68645c.c()) {
                                byteBuffer.position(this.f68647e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f68647e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f68645c.g(this.f68643a, byteBuffer, this.f68647e);
                            } else {
                                Log.d(f68642i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f68646d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f68647e.flags & 4) != 0) {
                            if (z) {
                                if (this.f68649g) {
                                    this.f68645c.f();
                                }
                                c cVar2 = this.f68648f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(f68642i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = f68642i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        if (z) {
            e eVar = this.f68645c;
            if (eVar != null && eVar.c()) {
                this.f68646d.signalEndOfInputStream();
            } else {
                c cVar = this.f68648f;
                if (cVar != null) {
                    cVar.a(true);
                    return;
                }
                return;
            }
        }
        b(z, 10000);
    }

    public long d() {
        return this.f68650h * 1000;
    }

    public void e() {
        this.f68646d.release();
        this.f68646d = null;
        this.f68645c = null;
    }

    public void f(c cVar) {
        this.f68648f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f68646d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f68647e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f68646d.start();
        c cVar = this.f68648f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f68646d.stop();
        } catch (Exception unused) {
            Log.e(f68642i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
