package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class e {
    private Surface hXH;
    private c hXa;
    private MediaCodec hXb;
    private int hXc;
    private boolean hXd;
    private h hbR;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hXI = new Bundle();
    private long hXJ = 0;
    private boolean hXD = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hXb = MediaCodec.createEncoderByType("video/avc");
        this.hXb.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hXH = this.hXb.createInputSurface();
        this.hXb.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hXI.putInt("request-sync", 0);
            this.hXb.setParameters(this.hXI);
        }
        this.hXc = -1;
        this.hXd = false;
        this.hXa = cVar;
    }

    public synchronized void requestStop() {
        this.hXD = true;
    }

    public Surface getInputSurface() {
        return this.hXH;
    }

    public void release() {
        if (this.hXb != null) {
            this.hXb.stop();
            this.hXb.release();
            this.hXb = null;
        }
        if (this.hXa != null) {
            try {
                this.hXa.stop();
            } catch (IllegalStateException e) {
                if (this.hbR != null) {
                    this.hbR.U(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hXa = null;
        }
    }

    public void ol(boolean z) throws Exception {
        if (z) {
            this.hXb.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hXb.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hXb.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hXb.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hXd) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hXb.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hXc = this.hXa.addTrack(outputFormat);
                if (!this.hXa.start()) {
                    synchronized (this.hXa) {
                        while (!this.hXa.isStarted() && !this.hXD) {
                            try {
                                this.hXa.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hXD) {
                    this.hXd = true;
                } else {
                    return;
                }
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
                    if (!this.hXd) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hXa.writeSampleData(this.hXc, byteBuffer, this.mBufferInfo);
                }
                this.hXb.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hXJ >= 500) {
                    this.hXb.setParameters(this.hXI);
                    this.hXJ = System.currentTimeMillis();
                }
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
