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
    public final MediaMuxer f66086a;

    /* renamed from: b  reason: collision with root package name */
    public int f66087b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f66088c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66089d = false;

    public c(String str) throws IOException {
        this.f66086a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f66089d) {
            addTrack = this.f66086a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f66087b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f66089d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i2 = this.f66088c + 1;
        this.f66088c = i2;
        if (this.f66087b > 0 && i2 == this.f66087b) {
            this.f66086a.start();
            this.f66089d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f66089d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f66088c);
        int i2 = this.f66088c + (-1);
        this.f66088c = i2;
        if (this.f66087b > 0 && i2 <= 0) {
            this.f66086a.stop();
            this.f66086a.release();
            this.f66089d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f66088c > 0) {
            this.f66086a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
