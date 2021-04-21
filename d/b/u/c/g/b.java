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
    public e f65730c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f65731d;

    /* renamed from: f  reason: collision with root package name */
    public c f65733f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65734g;

    /* renamed from: a  reason: collision with root package name */
    public int f65728a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65729b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f65735h = 0;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f65732e = new MediaCodec.BufferInfo();

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f65729b && this.f65728a == -1) {
            return;
        }
        int dequeueInputBuffer = this.f65731d.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(i, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(i, "drainBuffer sending EOS to drainBufferEncoder");
            this.f65731d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
            return;
        } else {
            MediaCodec mediaCodec = this.f65731d;
            MediaCodec.BufferInfo bufferInfo = this.f65732e;
            mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
        }
        b(z, k);
    }

    public final void b(boolean z, int i2) {
        ByteBuffer[] outputBuffers = this.f65731d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f65731d.dequeueOutputBuffer(this.f65732e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f65731d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f65730c.c()) {
                        Log.e(i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f65731d.getOutputFormat();
                    String str = i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f65728a = this.f65730c.a(outputFormat);
                    this.f65729b = true;
                    c cVar = this.f65733f;
                    if (cVar != null) {
                        cVar.b(true);
                    }
                    if (this.f65734g) {
                        this.f65730c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f65732e.flags & 2) != 0) {
                            Log.d(i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f65732e.size = 0;
                        }
                        if (this.f65732e.size != 0) {
                            if (this.f65730c.c()) {
                                byteBuffer.position(this.f65732e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f65732e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f65730c.g(this.f65728a, byteBuffer, this.f65732e);
                            } else {
                                Log.d(i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f65731d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f65732e.flags & 4) != 0) {
                            if (z) {
                                if (this.f65734g) {
                                    this.f65730c.f();
                                }
                                c cVar2 = this.f65733f;
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
            e eVar = this.f65730c;
            if (eVar != null && eVar.c()) {
                this.f65731d.signalEndOfInputStream();
            } else {
                c cVar = this.f65733f;
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
        return this.f65735h * 1000;
    }

    public void e() {
        this.f65731d.release();
        this.f65731d = null;
        this.f65730c = null;
    }

    public void f(c cVar) {
        this.f65733f = cVar;
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        ByteBuffer byteBuffer2 = this.f65731d.getInputBuffers()[i2];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.f65732e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return false;
    }

    public void h() {
        this.f65731d.start();
        c cVar = this.f65733f;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public void i() {
        try {
            this.f65731d.stop();
        } catch (Exception unused) {
            Log.e(i, "MediaCodec IllegalStateException Exception ");
        }
    }

    public abstract void j();
}
