package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64838d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f64839a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f64840b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f64841c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f64839a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f64838d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i2, f fVar) {
        if (!d.a.w.c.h.a.a(str)) {
            d.a.w.c.h.a.b(str);
        }
        try {
            this.f64839a = new MediaMuxer(str, i2);
            this.f64841c = fVar;
            this.f64840b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f64838d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f64840b;
    }

    public void d() {
        if (this.f64840b) {
            return;
        }
        this.f64839a.release();
        this.f64839a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f64839a.start();
            this.f64840b = true;
        } catch (Exception unused) {
            Log.e(f64838d, "startMuxer error!!!");
            z = false;
        }
        if (this.f64841c != null) {
            this.f64841c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f64839a.stop();
            this.f64840b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f64838d, "stopMuxer error!!!");
        }
        if (this.f64841c != null) {
            this.f64841c.b(z);
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i2 != -1) {
            try {
                this.f64839a.writeSampleData(i2, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f64838d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
