package d.b.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64786d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f64787a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f64788b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f64789c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f64787a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f64786d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i, f fVar) {
        if (!d.b.u.c.h.a.a(str)) {
            d.b.u.c.h.a.b(str);
        }
        try {
            this.f64787a = new MediaMuxer(str, i);
            this.f64789c = fVar;
            this.f64788b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f64786d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f64788b;
    }

    public void d() {
        if (this.f64788b) {
            return;
        }
        this.f64787a.release();
        this.f64787a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f64787a.start();
            this.f64788b = true;
        } catch (Exception unused) {
            Log.e(f64786d, "startMuxer error!!!");
            z = false;
        }
        if (this.f64789c != null) {
            this.f64789c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f64787a.stop();
            this.f64788b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f64786d, "stopMuxer error!!!");
        }
        if (this.f64789c != null) {
            this.f64789c.b(z);
        }
    }

    public boolean g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.f64787a.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f64786d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
