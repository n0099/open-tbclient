package d.a.n0.r3.j.d;

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
    public final MediaMuxer f60093a;

    /* renamed from: b  reason: collision with root package name */
    public int f60094b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60095c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f60096d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f60097e;

    public e(String str) throws IOException {
        this.f60093a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f60095c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f60093a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f60095c;
    }

    public void c() {
        this.f60097e = true;
    }

    public void d() {
        this.f60096d = true;
    }

    public synchronized boolean e() {
        if (this.f60097e && this.f60096d) {
            if (this.f60094b > 0 && this.f60097e && this.f60096d) {
                this.f60093a.start();
                this.f60095c = true;
                notifyAll();
            }
            return this.f60095c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f60094b > 0) {
            try {
                this.f60093a.stop();
                this.f60093a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f60095c = false;
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f60095c) {
            this.f60093a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
