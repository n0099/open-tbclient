package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class d {
    private b hiE;
    private MediaCodec hiF;
    private int hiG;
    private boolean hiH;
    private Surface hjk;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public d(int i, int i2, int i3, b bVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hiF = MediaCodec.createEncoderByType("video/avc");
        this.hiF.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hjk = this.hiF.createInputSurface();
        this.hiF.start();
        this.hiG = -1;
        this.hiH = false;
        this.hiE = bVar;
    }

    public Surface getInputSurface() {
        return this.hjk;
    }

    public void release() {
        if (this.hiF != null) {
            this.hiF.stop();
            this.hiF.release();
            this.hiF = null;
        }
        if (this.hiE != null) {
            try {
                this.hiE.stop();
            } catch (IllegalStateException e) {
            }
            this.hiE = null;
        }
    }

    public void nX(boolean z) throws Exception {
        if (z) {
            this.hiF.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hiF.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hiF.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hiF.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hiH) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hiF.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hiG = this.hiE.a(outputFormat);
                if (!this.hiE.start()) {
                    synchronized (this.hiE) {
                        while (!this.hiE.isStarted()) {
                            try {
                                this.hiE.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.hiH = true;
            } else if (dequeueOutputBuffer < 0) {
                Log.w("VideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if ((this.mBufferInfo.flags & 2) != 0) {
                    this.mBufferInfo.size = 0;
                }
                if (this.mBufferInfo.size != 0) {
                    if (!this.hiH) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hiE.a(this.hiG, byteBuffer, this.mBufferInfo);
                }
                this.hiF.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.mBufferInfo.flags & 4) != 0) {
                    if (!z) {
                        Log.w("VideoEncoder", "reached end of stream unexpectedly");
                        return;
                    }
                    return;
                }
            }
        }
    }
}
