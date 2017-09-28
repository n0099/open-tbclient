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
    private b gXB;
    private MediaCodec gXC;
    private int gXD;
    private boolean gXE;
    private Surface gYg;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public d(int i, int i2, int i3, b bVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.gXC = MediaCodec.createEncoderByType("video/avc");
        this.gXC.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.gYg = this.gXC.createInputSurface();
        this.gXC.start();
        this.gXD = -1;
        this.gXE = false;
        this.gXB = bVar;
    }

    public Surface getInputSurface() {
        return this.gYg;
    }

    public void release() {
        if (this.gXC != null) {
            this.gXC.stop();
            this.gXC.release();
            this.gXC = null;
        }
        if (this.gXB != null) {
            try {
                this.gXB.stop();
            } catch (IllegalStateException e) {
            }
            this.gXB = null;
        }
    }

    public void nO(boolean z) throws Exception {
        if (z) {
            this.gXC.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.gXC.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.gXC.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.gXC.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.gXE) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.gXC.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.gXD = this.gXB.a(outputFormat);
                if (!this.gXB.start()) {
                    synchronized (this.gXB) {
                        while (!this.gXB.isStarted()) {
                            try {
                                this.gXB.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.gXE = true;
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
                    if (!this.gXE) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.gXB.a(this.gXD, byteBuffer, this.mBufferInfo);
                }
                this.gXC.releaseOutputBuffer(dequeueOutputBuffer, false);
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
