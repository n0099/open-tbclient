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
    public final MediaMuxer f65955a;

    /* renamed from: b  reason: collision with root package name */
    public int f65956b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f65957c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65958d = false;

    public c(String str) throws IOException {
        this.f65955a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f65958d) {
            addTrack = this.f65955a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f65956b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f65958d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i = this.f65957c + 1;
        this.f65957c = i;
        if (this.f65956b > 0 && i == this.f65956b) {
            this.f65955a.start();
            this.f65958d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f65958d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f65957c);
        int i = this.f65957c + (-1);
        this.f65957c = i;
        if (this.f65956b > 0 && i <= 0) {
            this.f65955a.stop();
            this.f65955a.release();
            this.f65958d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f65957c > 0) {
            this.f65955a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
