package d.a.o0.r3.i.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final MediaMuxer f63907a;

    /* renamed from: b  reason: collision with root package name */
    public int f63908b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63909c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f63910d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f63911e;

    public e(String str) throws IOException {
        this.f63907a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f63909c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f63907a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f63909c;
    }

    public void c() {
        this.f63911e = true;
    }

    public void d() {
        this.f63910d = true;
    }

    public synchronized boolean e() {
        if (this.f63911e && this.f63910d) {
            if (this.f63908b > 0 && this.f63911e && this.f63910d) {
                this.f63907a.start();
                this.f63909c = true;
                notifyAll();
            }
            return this.f63909c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f63908b > 0) {
            try {
                this.f63907a.stop();
                this.f63907a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f63909c = false;
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f63909c) {
            this.f63907a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
