package d.a.n0.r3.i.d;

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
    public final MediaMuxer f63782a;

    /* renamed from: b  reason: collision with root package name */
    public int f63783b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63784c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f63785d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f63786e;

    public e(String str) throws IOException {
        this.f63782a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f63784c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f63782a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f63784c;
    }

    public void c() {
        this.f63786e = true;
    }

    public void d() {
        this.f63785d = true;
    }

    public synchronized boolean e() {
        if (this.f63786e && this.f63785d) {
            if (this.f63783b > 0 && this.f63786e && this.f63785d) {
                this.f63782a.start();
                this.f63784c = true;
                notifyAll();
            }
            return this.f63784c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f63783b > 0) {
            try {
                this.f63782a.stop();
                this.f63782a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f63784c = false;
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f63784c) {
            this.f63782a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
