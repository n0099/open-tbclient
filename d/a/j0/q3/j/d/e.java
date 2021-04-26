package d.a.j0.q3.j.d;

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
    public final MediaMuxer f59207a;

    /* renamed from: b  reason: collision with root package name */
    public int f59208b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59209c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f59210d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f59211e;

    public e(String str) throws IOException {
        this.f59207a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        if (!this.f59209c) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f59207a.addTrack(mediaFormat);
    }

    public synchronized boolean b() {
        return this.f59209c;
    }

    public void c() {
        this.f59211e = true;
    }

    public void d() {
        this.f59210d = true;
    }

    public synchronized boolean e() {
        if (this.f59211e && this.f59210d) {
            if (this.f59208b > 0 && this.f59211e && this.f59210d) {
                this.f59207a.start();
                this.f59209c = true;
                notifyAll();
            }
            return this.f59209c;
        }
        return false;
    }

    public synchronized void f() {
        if (this.f59208b > 0) {
            try {
                this.f59207a.stop();
                this.f59207a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f59209c = false;
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f59209c) {
            this.f59207a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
