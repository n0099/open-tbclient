package d.b.u.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f65744d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f65745a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f65746b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f65747c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f65745a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f65744d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i, f fVar) {
        if (!d.b.u.c.h.a.a(str)) {
            d.b.u.c.h.a.b(str);
        }
        try {
            this.f65745a = new MediaMuxer(str, i);
            this.f65747c = fVar;
            this.f65746b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f65744d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f65746b;
    }

    public void d() {
        if (this.f65746b) {
            return;
        }
        this.f65745a.release();
        this.f65745a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f65745a.start();
            this.f65746b = true;
        } catch (Exception unused) {
            Log.e(f65744d, "startMuxer error!!!");
            z = false;
        }
        if (this.f65747c != null) {
            this.f65747c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f65745a.stop();
            this.f65746b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f65744d, "stopMuxer error!!!");
        }
        if (this.f65747c != null) {
            this.f65747c.b(z);
        }
    }

    public boolean g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.f65745a.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f65744d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
