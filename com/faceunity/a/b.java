package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private final MediaMuxer gXp;
    private int gXq = 2;
    private int gXr = 0;
    private boolean mIsStarted = false;

    public b(String str) throws IOException {
        this.gXp = new MediaMuxer(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v("MediaMuxerWrapper", "start:");
        this.gXr++;
        if (this.gXq > 0 && this.gXr == this.gXq) {
            this.gXp.start();
            this.mIsStarted = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.mIsStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.gXr);
        this.gXr--;
        if (this.gXq > 0 && this.gXr <= 0) {
            this.gXp.stop();
            this.gXp.release();
            this.mIsStarted = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int a(MediaFormat mediaFormat) {
        int addTrack;
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        addTrack = this.gXp.addTrack(mediaFormat);
        Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.gXq + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.gXr > 0) {
            this.gXp.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
