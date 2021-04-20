package d.b.i0.q3.j.d;

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
    public final MediaMuxer f60653a;

    /* renamed from: b  reason: collision with root package name */
    public int f60654b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60655c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f60656d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f60657e;

    public e(String str) throws IOException {
        this.f60653a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f60655c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f60653a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f60655c;
    }

    public void c() {
        this.f60657e = true;
    }

    public void d() {
        this.f60656d = true;
    }

    public synchronized boolean e() {
        if (this.f60657e && this.f60656d) {
            if (this.f60654b > 0 && this.f60657e && this.f60656d) {
                this.f60653a.start();
                this.f60655c = true;
                notifyAll();
            }
            return this.f60655c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f60654b > 0) {
            try {
                this.f60653a.stop();
                this.f60653a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f60655c = false;
        }
    }

    public synchronized void g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f60655c) {
            this.f60653a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
