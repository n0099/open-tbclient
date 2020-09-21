package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes22.dex */
public class c {
    private final MediaMuxer bDo;
    private int mFR = 2;
    private int nKD = 0;
    private boolean mIsStarted = false;

    public c(String str) throws IOException {
        this.bDo = new MediaMuxer(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v("MediaMuxerWrapper", "start:");
        this.nKD++;
        if (this.mFR > 0 && this.nKD == this.mFR) {
            this.bDo.start();
            this.mIsStarted = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.mIsStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.nKD);
        this.nKD--;
        if (this.mFR > 0 && this.nKD <= 0) {
            this.bDo.stop();
            this.bDo.release();
            this.mIsStarted = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int c(MediaFormat mediaFormat) {
        int addTrack;
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        addTrack = this.bDo.addTrack(mediaFormat);
        Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.mFR + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.nKD > 0) {
            this.bDo.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
