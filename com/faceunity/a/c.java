package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class c {
    private final MediaMuxer cil;
    private int nHr = 2;
    private int pGz = 0;
    private boolean mIsStarted = false;

    public c(String str) throws IOException {
        this.cil = new MediaMuxer(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v("MediaMuxerWrapper", "start:");
        this.pGz++;
        if (this.nHr > 0 && this.pGz == this.nHr) {
            this.cil.start();
            this.mIsStarted = true;
            notifyAll();
            Log.v("MediaMuxerWrapper", "MediaMuxer started:");
        }
        return this.mIsStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v("MediaMuxerWrapper", "stop:mStatredCount=" + this.pGz);
        this.pGz--;
        if (this.nHr > 0 && this.pGz <= 0) {
            this.cil.stop();
            this.cil.release();
            this.mIsStarted = false;
            Log.v("MediaMuxerWrapper", "MediaMuxer stopped:");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int f(MediaFormat mediaFormat) {
        int addTrack;
        if (this.mIsStarted) {
            throw new IllegalStateException("muxer already started");
        }
        addTrack = this.cil.addTrack(mediaFormat);
        Log.i("MediaMuxerWrapper", "addTrack:trackNum=" + this.nHr + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.pGz > 0) {
            this.cil.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isStarted() {
        return this.mIsStarted;
    }
}
