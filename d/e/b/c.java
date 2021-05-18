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
    public final MediaMuxer f66043a;

    /* renamed from: b  reason: collision with root package name */
    public int f66044b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f66045c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66046d = false;

    public c(String str) throws IOException {
        this.f66043a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f66046d) {
            addTrack = this.f66043a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f66044b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f66046d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i2 = this.f66045c + 1;
        this.f66045c = i2;
        if (this.f66044b > 0 && i2 == this.f66044b) {
            this.f66043a.start();
            this.f66046d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f66046d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f66045c);
        int i2 = this.f66045c + (-1);
        this.f66045c = i2;
        if (this.f66044b > 0 && i2 <= 0) {
            this.f66043a.stop();
            this.f66043a.release();
            this.f66046d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f66045c > 0) {
            this.f66043a.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
