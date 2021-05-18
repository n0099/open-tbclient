package d.a.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64785d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f64786a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f64787b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f64788c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f64786a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f64785d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i2, f fVar) {
        if (!d.a.u.c.h.a.a(str)) {
            d.a.u.c.h.a.b(str);
        }
        try {
            this.f64786a = new MediaMuxer(str, i2);
            this.f64788c = fVar;
            this.f64787b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f64785d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f64787b;
    }

    public void d() {
        if (this.f64787b) {
            return;
        }
        this.f64786a.release();
        this.f64786a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f64786a.start();
            this.f64787b = true;
        } catch (Exception unused) {
            Log.e(f64785d, "startMuxer error!!!");
            z = false;
        }
        if (this.f64788c != null) {
            this.f64788c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f64786a.stop();
            this.f64787b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f64785d, "stopMuxer error!!!");
        }
        if (this.f64788c != null) {
            this.f64788c.b(z);
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i2 != -1) {
            try {
                this.f64786a.writeSampleData(i2, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f64785d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
