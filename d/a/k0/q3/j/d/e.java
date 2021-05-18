package d.a.k0.q3.j.d;

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
    public final MediaMuxer f59952a;

    /* renamed from: b  reason: collision with root package name */
    public int f59953b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59954c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f59955d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f59956e;

    public e(String str) throws IOException {
        this.f59952a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f59954c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f59952a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f59954c;
    }

    public void c() {
        this.f59956e = true;
    }

    public void d() {
        this.f59955d = true;
    }

    public synchronized boolean e() {
        if (this.f59956e && this.f59955d) {
            if (this.f59953b > 0 && this.f59956e && this.f59955d) {
                this.f59952a.start();
                this.f59954c = true;
                notifyAll();
            }
            return this.f59954c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f59953b > 0) {
            try {
                this.f59952a.stop();
                this.f59952a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f59954c = false;
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f59954c) {
            this.f59952a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
