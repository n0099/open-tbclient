package d.e.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final MediaMuxer f69817a;

    /* renamed from: b  reason: collision with root package name */
    public int f69818b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f69819c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69820d = false;

    public c(String str) throws IOException {
        this.f69817a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f69820d) {
            addTrack = this.f69817a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f69818b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f69820d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i2 = this.f69819c + 1;
        this.f69819c = i2;
        if (this.f69818b > 0 && i2 == this.f69818b) {
            this.f69817a.start();
            this.f69820d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f69820d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f69819c);
        int i2 = this.f69819c + (-1);
        this.f69819c = i2;
        if (this.f69818b > 0 && i2 <= 0) {
            this.f69817a.stop();
            this.f69817a.release();
            this.f69820d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f69819c > 0) {
            this.f69817a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
