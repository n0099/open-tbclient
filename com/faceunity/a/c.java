package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class c {
    private int kvR = 2;
    private int lWR = 0;
    private boolean mIsStarted = false;
    private final MediaMuxer mMediaMuxer;

    public c(String str) throws IOException {
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v("MediaMuxerWrapper", "start:");
        this.lWR++;
        if (this.kvR > 0 && this.lWR == this.kvR) {
            this.mMediaMuxer.start();
            this.mIsStarted = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.mIsStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.lWR);
        this.lWR--;
        if (this.kvR > 0 && this.lWR <= 0) {
            this.mMediaMuxer.stop();
            this.mMediaMuxer.release();
            this.mIsStarted = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int i(MediaFormat mediaFormat) {
        int addTrack;
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        addTrack = this.mMediaMuxer.addTrack(mediaFormat);
        Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.kvR + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.lWR > 0) {
            this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
