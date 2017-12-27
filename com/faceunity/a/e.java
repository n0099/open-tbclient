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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class e {
    private Surface hXW;
    private c hXp;
    private MediaCodec hXq;
    private int hXr;
    private boolean hXs;
    private h hjJ;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hXX = new Bundle();
    private long hXY = 0;
    private boolean hXS = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hXq = MediaCodec.createEncoderByType("video/avc");
        this.hXq.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hXW = this.hXq.createInputSurface();
        this.hXq.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hXX.putInt("request-sync", 0);
            this.hXq.setParameters(this.hXX);
        }
        this.hXr = -1;
        this.hXs = false;
        this.hXp = cVar;
    }

    public synchronized void requestStop() {
        this.hXS = true;
    }

    public Surface getInputSurface() {
        return this.hXW;
    }

    public void release() {
        if (this.hXq != null) {
            this.hXq.stop();
            this.hXq.release();
            this.hXq = null;
        }
        if (this.hXp != null) {
            try {
                this.hXp.stop();
            } catch (IllegalStateException e) {
                if (this.hjJ != null) {
                    this.hjJ.P(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hXp = null;
        }
    }

    public void oJ(boolean z) throws Exception {
        if (z) {
            this.hXq.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hXq.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hXq.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hXq.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hXs) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hXq.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hXr = this.hXp.addTrack(outputFormat);
                if (!this.hXp.start()) {
                    synchronized (this.hXp) {
                        while (!this.hXp.isStarted() && !this.hXS) {
                            try {
                                this.hXp.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hXS) {
                    this.hXs = true;
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
                    if (!this.hXs) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hXp.writeSampleData(this.hXr, byteBuffer, this.mBufferInfo);
                }
                this.hXq.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hXY >= 500) {
                    this.hXq.setParameters(this.hXX);
                    this.hXY = System.currentTimeMillis();
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
