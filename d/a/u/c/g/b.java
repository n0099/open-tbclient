package d.a.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: i  reason: collision with root package name */
    public static final String f64767i = "b";
    public static long j = 0;
    public static int k = 10000;

    /* renamed from: c  reason: collision with root package name */
    public e f64770c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f64771d;

    /* renamed from: f  reason: collision with root package name */
    public c f64773f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64774g;

    /* renamed from: a  reason: collision with root package name */
    public int f64768a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64769b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f64775h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f64772e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f64769b && this.f64768a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f64771d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(f64767i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(f64767i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f64771d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f64771d;
            MediaCodec.BufferInfo bufferInfo = this.f64772e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f64771d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f64771d.dequeueOutputBuffer(this.f64772e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(f64767i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f64771d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f64770c.c()) {
                        Log.e(f64767i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f64771d.getOutputFormat();
                    String str = f64767i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f64768a = this.f64770c.a(outputFormat);
                    this.f64769b = true;
                    c cVar = this.f64773f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f64774g) {
                        this.f64770c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = f64767i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f64772e.flags & 2) != 0) {
                            Log.d(f64767i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f64772e.size = 0;
                        }
                        if (this.f64772e.size != 0) {
                            if (this.f64770c.c()) {
                                byteBuffer.position(this.f64772e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f64772e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f64770c.g(this.f64768a, byteBuffer, this.f64772e);
                            } else {
                                Log.d(f64767i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f64771d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f64772e.flags & 4) != 0) {
                            if (z) {
                                if (this.f64774g) {
                                    this.f64770c.f();
                                }
                                c cVar2 = this.f64773f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(f64767i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = f64767i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        if (z) {
            e eVar = this.f64770c;
            if (eVar != null && eVar.c()) {
                this.f64771d.signalEndOfInputStream();
            } else {
                c cVar = this.f64773f;
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
        return this.f64775h * 1000;
    }

    public void e() {
        this.f64771d.release();
        this.f64771d = null;
        this.f64770c = null;
    }

    public void f(c cVar) {
        this.f64773f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f64771d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f64772e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f64771d.start();
        c cVar = this.f64773f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f64771d.stop();
        } catch (Exception unused) {
            Log.e(f64767i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
