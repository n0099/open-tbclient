package d.b.t.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f65480d = "e";

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f65481a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f65482b = false;

    /* renamed from: c  reason: collision with root package name */
    public f f65483c;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.f65481a.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e(f65480d, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean b(String str, int i, f fVar) {
        if (!d.b.t.c.h.a.a(str)) {
            d.b.t.c.h.a.b(str);
        }
        try {
            this.f65481a = new MediaMuxer(str, i);
            this.f65483c = fVar;
            this.f65482b = false;
            return true;
        } catch (Exception e2) {
            Log.e(f65480d, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean c() {
        return this.f65482b;
    }

    public void d() {
        if (this.f65482b) {
            return;
        }
        this.f65481a.release();
        this.f65481a = null;
    }

    public synchronized void e() {
        boolean z = true;
        try {
            this.f65481a.start();
            this.f65482b = true;
        } catch (Exception unused) {
            Log.e(f65480d, "startMuxer error!!!");
            z = false;
        }
        if (this.f65483c != null) {
            this.f65483c.a(z);
        }
    }

    public synchronized void f() {
        boolean z = false;
        try {
            this.f65481a.stop();
            this.f65482b = false;
            z = true;
        } catch (Exception unused) {
            Log.e(f65480d, "stopMuxer error!!!");
        }
        if (this.f65483c != null) {
            this.f65483c.b(z);
        }
    }

    public boolean g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.f65481a.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                Log.e(f65480d, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }
}
