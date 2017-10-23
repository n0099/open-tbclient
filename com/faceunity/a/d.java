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
    private Surface gXQ;
    private b gXl;
    private MediaCodec gXm;
    private int gXn;
    private boolean gXo;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public d(int i, int i2, int i3, b bVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.gXm = MediaCodec.createEncoderByType("video/avc");
        this.gXm.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.gXQ = this.gXm.createInputSurface();
        this.gXm.start();
        this.gXn = -1;
        this.gXo = false;
        this.gXl = bVar;
    }

    public Surface getInputSurface() {
        return this.gXQ;
    }

    public void release() {
        if (this.gXm != null) {
            this.gXm.stop();
            this.gXm.release();
            this.gXm = null;
        }
        if (this.gXl != null) {
            try {
                this.gXl.stop();
            } catch (IllegalStateException e) {
            }
            this.gXl = null;
        }
    }

    public void nN(boolean z) throws Exception {
        if (z) {
            this.gXm.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.gXm.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.gXm.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.gXm.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.gXo) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.gXm.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.gXn = this.gXl.a(outputFormat);
                if (!this.gXl.start()) {
                    synchronized (this.gXl) {
                        while (!this.gXl.isStarted()) {
                            try {
                                this.gXl.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.gXo = true;
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
                    if (!this.gXo) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.gXl.a(this.gXn, byteBuffer, this.mBufferInfo);
                }
                this.gXm.releaseOutputBuffer(dequeueOutputBuffer, false);
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
