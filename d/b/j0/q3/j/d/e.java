package d.b.j0.q3.j.d;

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
    public final MediaMuxer f61074a;

    /* renamed from: b  reason: collision with root package name */
    public int f61075b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61076c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f61077d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f61078e;

    public e(String str) throws IOException {
        this.f61074a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f61076c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f61074a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f61076c;
    }

    public void c() {
        this.f61078e = true;
    }

    public void d() {
        this.f61077d = true;
    }

    public synchronized boolean e() {
        if (this.f61078e && this.f61077d) {
            if (this.f61075b > 0 && this.f61078e && this.f61077d) {
                this.f61074a.start();
                this.f61076c = true;
                notifyAll();
            }
            return this.f61076c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f61075b > 0) {
            try {
                this.f61074a.stop();
                this.f61074a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f61076c = false;
        }
    }

    public synchronized void g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f61076c) {
            this.f61074a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
