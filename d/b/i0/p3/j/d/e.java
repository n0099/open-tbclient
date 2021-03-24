package d.b.i0.p3.j.d;

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
    public final MediaMuxer f58984a;

    /* renamed from: b  reason: collision with root package name */
    public int f58985b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58986c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f58987d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f58988e;

    public e(String str) throws IOException {
        this.f58984a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f58986c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f58984a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f58986c;
    }

    public void c() {
        this.f58988e = true;
    }

    public void d() {
        this.f58987d = true;
    }

    public synchronized boolean e() {
        if (this.f58988e && this.f58987d) {
            if (this.f58985b > 0 && this.f58988e && this.f58987d) {
                this.f58984a.start();
                this.f58986c = true;
                notifyAll();
            }
            return this.f58986c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f58985b > 0) {
            try {
                this.f58984a.stop();
                this.f58984a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f58986c = false;
        }
    }

    public synchronized void g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f58986c) {
            this.f58984a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
