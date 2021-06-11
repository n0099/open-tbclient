package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: i  reason: collision with root package name */
    public static final String f68538i = "b";
    public static long j = 0;
    public static int k = 10000;

    /* renamed from: c  reason: collision with root package name */
    public e f68541c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f68542d;

    /* renamed from: f  reason: collision with root package name */
    public c f68544f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68545g;

    /* renamed from: a  reason: collision with root package name */
    public int f68539a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68540b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f68546h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f68543e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f68540b && this.f68539a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f68542d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(f68538i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(f68538i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f68542d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f68542d;
            MediaCodec.BufferInfo bufferInfo = this.f68543e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f68542d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f68542d.dequeueOutputBuffer(this.f68543e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(f68538i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f68542d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f68541c.c()) {
                        Log.e(f68538i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f68542d.getOutputFormat();
                    String str = f68538i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f68539a = this.f68541c.a(outputFormat);
                    this.f68540b = true;
                    c cVar = this.f68544f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f68545g) {
                        this.f68541c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = f68538i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f68543e.flags & 2) != 0) {
                            Log.d(f68538i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f68543e.size = 0;
                        }
                        if (this.f68543e.size != 0) {
                            if (this.f68541c.c()) {
                                byteBuffer.position(this.f68543e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f68543e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f68541c.g(this.f68539a, byteBuffer, this.f68543e);
                            } else {
                                Log.d(f68538i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f68542d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f68543e.flags & 4) != 0) {
                            if (z) {
                                if (this.f68545g) {
                                    this.f68541c.f();
                                }
                                c cVar2 = this.f68544f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(f68538i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = f68538i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        if (z) {
            e eVar = this.f68541c;
            if (eVar != null && eVar.c()) {
                this.f68542d.signalEndOfInputStream();
            } else {
                c cVar = this.f68544f;
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
        return this.f68546h * 1000;
    }

    public void e() {
        this.f68542d.release();
        this.f68542d = null;
        this.f68541c = null;
    }

    public void f(c cVar) {
        this.f68544f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f68542d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f68543e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f68542d.start();
        c cVar = this.f68544f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f68542d.stop();
        } catch (Exception unused) {
            Log.e(f68538i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
