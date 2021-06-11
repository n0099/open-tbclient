package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f68556d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f68557a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68558b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f68559c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f68557a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f68556d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i2, f fVar) {
        if (!d.a.w.c.h.a.a(str)) {
            d.a.w.c.h.a.b(str);
        }
        try {
            this.f68557a = new MediaMuxer(str, i2);
            this.f68559c = fVar;
            this.f68558b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f68556d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f68558b;
    }

    public void d() {
        if (this.f68558b) {
            return;
        }
        this.f68557a.release();
        this.f68557a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f68557a.start();
            this.f68558b = true;
        } catch (Exception unused) {
            Log.e(f68556d, "startMuxer error!!!");
            z = false;
        }
        if (this.f68559c != null) {
            this.f68559c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f68557a.stop();
            this.f68558b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f68556d, "stopMuxer error!!!");
        }
        if (this.f68559c != null) {
            this.f68559c.b(z);
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i2 != -1) {
            try {
                this.f68557a.writeSampleData(i2, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f68556d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
