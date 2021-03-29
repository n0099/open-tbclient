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
    public e f64772c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f64773d;

    /* renamed from: f  reason: collision with root package name */
    public c f64775f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64776g;

    /* renamed from: a  reason: collision with root package name */
    public int f64770a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64771b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f64777h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f64774e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f64771b && this.f64770a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f64773d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f64773d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f64773d;
            MediaCodec.BufferInfo bufferInfo = this.f64774e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f64773d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f64773d.dequeueOutputBuffer(this.f64774e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f64773d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f64772c.c()) {
                        Log.e(i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f64773d.getOutputFormat();
                    String str = i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f64770a = this.f64772c.a(outputFormat);
                    this.f64771b = true;
                    c cVar = this.f64775f;
                    if (cVar != null) {
                        cVar.b(true);
                    }
                    if (this.f64776g) {
                        this.f64772c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f64774e.flags & 2) != 0) {
                            Log.d(i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f64774e.size = 0;
                        }
                        if (this.f64774e.size != 0) {
                            if (this.f64772c.c()) {
                                byteBuffer.position(this.f64774e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f64774e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f64772c.g(this.f64770a, byteBuffer, this.f64774e);
                            } else {
                                Log.d(i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f64773d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f64774e.flags & 4) != 0) {
                            if (z) {
                                if (this.f64776g) {
                                    this.f64772c.f();
                                }
                                c cVar2 = this.f64775f;
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
            e eVar = this.f64772c;
            if (eVar != null && eVar.c()) {
                this.f64773d.signalEndOfInputStream();
            } else {
                c cVar = this.f64775f;
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
        return this.f64777h * 1000;
    }

    public void e() {
        this.f64773d.release();
        this.f64773d = null;
        this.f64772c = null;
    }

    public void f(c cVar) {
        this.f64775f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f64773d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f64774e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f64773d.start();
        c cVar = this.f64775f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f64773d.stop();
        } catch (Exception unused) {
            Log.e(i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
