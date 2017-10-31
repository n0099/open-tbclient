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
    private Surface hhZ;
    private b hht;
    private MediaCodec hhu;
    private int hhv;
    private boolean hhw;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public d(int i, int i2, int i3, b bVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hhu = MediaCodec.createEncoderByType("video/avc");
        this.hhu.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hhZ = this.hhu.createInputSurface();
        this.hhu.start();
        this.hhv = -1;
        this.hhw = false;
        this.hht = bVar;
    }

    public Surface getInputSurface() {
        return this.hhZ;
    }

    public void release() {
        if (this.hhu != null) {
            this.hhu.stop();
            this.hhu.release();
            this.hhu = null;
        }
        if (this.hht != null) {
            try {
                this.hht.stop();
            } catch (IllegalStateException e) {
            }
            this.hht = null;
        }
    }

    public void nP(boolean z) throws Exception {
        if (z) {
            this.hhu.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hhu.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hhu.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hhu.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hhw) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hhu.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hhv = this.hht.a(outputFormat);
                if (!this.hht.start()) {
                    synchronized (this.hht) {
                        while (!this.hht.isStarted()) {
                            try {
                                this.hht.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.hhw = true;
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
                    if (!this.hhw) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hht.a(this.hhv, byteBuffer, this.mBufferInfo);
                }
                this.hhu.releaseOutputBuffer(dequeueOutputBuffer, false);
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
