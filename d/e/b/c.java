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
    public final MediaMuxer f65954a;

    /* renamed from: b  reason: collision with root package name */
    public int f65955b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f65956c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65957d = false;

    public c(String str) throws IOException {
        this.f65954a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f65957d) {
            addTrack = this.f65954a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f65955b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f65957d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i = this.f65956c + 1;
        this.f65956c = i;
        if (this.f65955b > 0 && i == this.f65955b) {
            this.f65954a.start();
            this.f65957d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f65957d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f65956c);
        int i = this.f65956c + (-1);
        this.f65956c = i;
        if (this.f65955b > 0 && i <= 0) {
            this.f65954a.stop();
            this.f65954a.release();
            this.f65957d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f65956c > 0) {
            this.f65954a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
