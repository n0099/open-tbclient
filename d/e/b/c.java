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
    public final MediaMuxer f66800a;

    /* renamed from: b  reason: collision with root package name */
    public int f66801b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f66802c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66803d = false;

    public c(String str) throws IOException {
        this.f66800a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.f66803d) {
            addTrack = this.f66800a.addTrack(mediaFormat);
            Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.f66801b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    public synchronized boolean b() {
        return this.f66803d;
    }

    public synchronized boolean c() {
        Log.v("MediaMuxerWrapper", "start:");
        int i = this.f66802c + 1;
        this.f66802c = i;
        if (this.f66801b > 0 && i == this.f66801b) {
            this.f66800a.start();
            this.f66803d = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.f66803d;
    }

    public synchronized void d() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.f66802c);
        int i = this.f66802c + (-1);
        this.f66802c = i;
        if (this.f66801b > 0 && i <= 0) {
            this.f66800a.stop();
            this.f66800a.release();
            this.f66803d = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    public synchronized void e(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f66802c > 0) {
            this.f66800a.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
