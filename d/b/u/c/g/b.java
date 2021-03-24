package d.b.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public abstract class b {
    public static final String i = "b";
    public static long j = 0;
    public static int k = 10000;

    /* renamed from: c  reason: collision with root package name */
    public e f64771c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f64772d;

    /* renamed from: f  reason: collision with root package name */
    public c f64774f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64775g;

    /* renamed from: a  reason: collision with root package name */
    public int f64769a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64770b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f64776h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f64773e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f64770b && this.f64769a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f64772d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f64772d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f64772d;
            MediaCodec.BufferInfo bufferInfo = this.f64773e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f64772d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f64772d.dequeueOutputBuffer(this.f64773e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f64772d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f64771c.c()) {
                        Log.e(i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f64772d.getOutputFormat();
                    String str = i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f64769a = this.f64771c.a(outputFormat);
                    this.f64770b = true;
                    c cVar = this.f64774f;
                    if (cVar != null) {
                        cVar.b(true);
                    }
                    if (this.f64775g) {
                        this.f64771c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f64773e.flags & 2) != 0) {
                            Log.d(i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f64773e.size = 0;
                        }
                        if (this.f64773e.size != 0) {
                            if (this.f64771c.c()) {
                                byteBuffer.position(this.f64773e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f64773e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f64771c.g(this.f64769a, byteBuffer, this.f64773e);
                            } else {
                                Log.d(i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f64772d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f64773e.flags & 4) != 0) {
                            if (z) {
                                if (this.f64775g) {
                                    this.f64771c.f();
                                }
                                c cVar2 = this.f64774f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        if (z) {
            e eVar = this.f64771c;
            if (eVar != null && eVar.c()) {
                this.f64772d.signalEndOfInputStream();
            } else {
                c cVar = this.f64774f;
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
        return this.f64776h * 1000;
    }

    public void e() {
        this.f64772d.release();
        this.f64772d = null;
        this.f64771c = null;
    }

    public void f(c cVar) {
        this.f64774f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f64772d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f64773e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f64772d.start();
        c cVar = this.f64774f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f64772d.stop();
        } catch (Exception unused) {
            Log.e(i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
