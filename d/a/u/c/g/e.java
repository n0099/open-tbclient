package d.a.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64098d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f64099a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f64100b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f64101c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f64099a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f64098d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i2, f fVar) {
        if (!d.a.u.c.h.a.a(str)) {
            d.a.u.c.h.a.b(str);
        }
        try {
            this.f64099a = new MediaMuxer(str, i2);
            this.f64101c = fVar;
            this.f64100b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f64098d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f64100b;
    }

    public void d() {
        if (this.f64100b) {
            return;
        }
        this.f64099a.release();
        this.f64099a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f64099a.start();
            this.f64100b = true;
        } catch (Exception unused) {
            Log.e(f64098d, "startMuxer error!!!");
            z = false;
        }
        if (this.f64101c != null) {
            this.f64101c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f64099a.stop();
            this.f64100b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f64098d, "stopMuxer error!!!");
        }
        if (this.f64101c != null) {
            this.f64101c.b(z);
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i2 != -1) {
            try {
                this.f64099a.writeSampleData(i2, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f64098d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
