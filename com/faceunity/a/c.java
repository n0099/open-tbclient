package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class c {
    private final MediaMuxer iWR;
    private int iWS = 2;
    private int jMq = 0;
    private boolean mIsStarted = false;

    public c(String str) throws IOException {
        this.iWR = new MediaMuxer(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v("MediaMuxerWrapper", "start:");
        this.jMq++;
        if (this.iWS > 0 && this.jMq == this.iWS) {
            this.iWR.start();
            this.mIsStarted = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.mIsStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.jMq);
        this.jMq--;
        if (this.iWS > 0 && this.jMq <= 0) {
            this.iWR.stop();
            this.iWR.release();
            this.mIsStarted = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int addTrack(MediaFormat mediaFormat) {
        int addTrack;
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        addTrack = this.iWR.addTrack(mediaFormat);
        Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.iWS + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.jMq > 0) {
            this.iWR.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
