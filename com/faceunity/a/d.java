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
    private b gXA;
    private MediaCodec gXB;
    private int gXC;
    private boolean gXD;
    private Surface gYf;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public d(int i, int i2, int i3, b bVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.gXB = MediaCodec.createEncoderByType("video/avc");
        this.gXB.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.gYf = this.gXB.createInputSurface();
        this.gXB.start();
        this.gXC = -1;
        this.gXD = false;
        this.gXA = bVar;
    }

    public Surface getInputSurface() {
        return this.gYf;
    }

    public void release() {
        if (this.gXB != null) {
            this.gXB.stop();
            this.gXB.release();
            this.gXB = null;
        }
        if (this.gXA != null) {
            try {
                this.gXA.stop();
            } catch (IllegalStateException e) {
            }
            this.gXA = null;
        }
    }

    public void nO(boolean z) throws Exception {
        if (z) {
            this.gXB.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.gXB.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.gXB.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.gXB.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.gXD) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.gXB.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.gXC = this.gXA.a(outputFormat);
                if (!this.gXA.start()) {
                    synchronized (this.gXA) {
                        while (!this.gXA.isStarted()) {
                            try {
                                this.gXA.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.gXD = true;
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
                    if (!this.gXD) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.gXA.a(this.gXC, byteBuffer, this.mBufferInfo);
                }
                this.gXB.releaseOutputBuffer(dequeueOutputBuffer, false);
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
