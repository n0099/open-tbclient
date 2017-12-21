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
public class d {
    private h gCU;
    private b hwP;
    private MediaCodec hwQ;
    private int hwR;
    private boolean hwS;
    private Surface hxs;
    private Bundle hxt = new Bundle();
    private long hxu = 0;
    private MediaCodec.BufferInfo mBufferInfo;

    public d(int i, int i2, int i3, b bVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hwQ = MediaCodec.createEncoderByType("video/avc");
        this.hwQ.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hxs = this.hwQ.createInputSurface();
        this.hwQ.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hxt.putInt("request-sync", 0);
            this.hwQ.setParameters(this.hxt);
        }
        this.hwR = -1;
        this.hwS = false;
        this.hwP = bVar;
    }

    public Surface getInputSurface() {
        return this.hxs;
    }

    public void release() {
        if (this.hwQ != null) {
            this.hwQ.stop();
            this.hwQ.release();
            this.hwQ = null;
        }
        if (this.hwP != null) {
            try {
                this.hwP.stop();
            } catch (IllegalStateException e) {
                if (this.gCU != null) {
                    this.gCU.Q(17, com.baidu.tieba.i.a.g(e));
                }
            }
            this.hwP = null;
        }
    }

    public void oC(boolean z) throws Exception {
        if (z) {
            this.hwQ.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hwQ.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hwQ.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hwQ.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hwS) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hwQ.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hwR = this.hwP.d(outputFormat);
                if (!this.hwP.start()) {
                    synchronized (this.hwP) {
                        while (!this.hwP.isStarted()) {
                            try {
                                this.hwP.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.hwS = true;
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
                    if (!this.hwS) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hwP.a(this.hwR, byteBuffer, this.mBufferInfo);
                }
                this.hwQ.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hxu >= 500) {
                    this.hwQ.setParameters(this.hxt);
                    this.hxu = System.currentTimeMillis();
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
