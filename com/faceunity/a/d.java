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
    private h gCP;
    private b hwK;
    private MediaCodec hwL;
    private int hwM;
    private boolean hwN;
    private Surface hxn;
    private Bundle hxo = new Bundle();
    private long hxp = 0;
    private MediaCodec.BufferInfo mBufferInfo;

    public d(int i, int i2, int i3, b bVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOj();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hwL = MediaCodec.createEncoderByType("video/avc");
        this.hwL.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hxn = this.hwL.createInputSurface();
        this.hwL.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hxo.putInt("request-sync", 0);
            this.hwL.setParameters(this.hxo);
        }
        this.hwM = -1;
        this.hwN = false;
        this.hwK = bVar;
    }

    public Surface getInputSurface() {
        return this.hxn;
    }

    public void release() {
        if (this.hwL != null) {
            this.hwL.stop();
            this.hwL.release();
            this.hwL = null;
        }
        if (this.hwK != null) {
            try {
                this.hwK.stop();
            } catch (IllegalStateException e) {
                if (this.gCP != null) {
                    this.gCP.Q(17, com.baidu.tieba.i.a.g(e));
                }
            }
            this.hwK = null;
        }
    }

    public void oC(boolean z) throws Exception {
        if (z) {
            this.hwL.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hwL.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hwL.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hwL.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hwN) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hwL.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hwM = this.hwK.d(outputFormat);
                if (!this.hwK.start()) {
                    synchronized (this.hwK) {
                        while (!this.hwK.isStarted()) {
                            try {
                                this.hwK.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.hwN = true;
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
                    if (!this.hwN) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hwK.a(this.hwM, byteBuffer, this.mBufferInfo);
                }
                this.hwL.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hxp >= 500) {
                    this.hwL.setParameters(this.hxo);
                    this.hxp = System.currentTimeMillis();
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
