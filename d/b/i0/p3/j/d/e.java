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
    public final MediaMuxer f58985a;

    /* renamed from: b  reason: collision with root package name */
    public int f58986b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58987c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f58988d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f58989e;

    public e(String str) throws IOException {
        this.f58985a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f58987c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f58985a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f58987c;
    }

    public void c() {
        this.f58989e = true;
    }

    public void d() {
        this.f58988d = true;
    }

    public synchronized boolean e() {
        if (this.f58989e && this.f58988d) {
            if (this.f58986b > 0 && this.f58989e && this.f58988d) {
                this.f58985a.start();
                this.f58987c = true;
                notifyAll();
            }
            return this.f58987c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f58986b > 0) {
            try {
                this.f58985a.stop();
                this.f58985a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f58987c = false;
        }
    }

    public synchronized void g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f58987c) {
            this.f58985a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
