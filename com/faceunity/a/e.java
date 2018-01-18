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
    private h gZj;
    private Surface hVP;
    private c hVi;
    private MediaCodec hVj;
    private int hVk;
    private boolean hVl;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hVQ = new Bundle();
    private long hVR = 0;
    private boolean hVL = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hVj = MediaCodec.createEncoderByType("video/avc");
        this.hVj.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hVP = this.hVj.createInputSurface();
        this.hVj.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hVQ.putInt("request-sync", 0);
            this.hVj.setParameters(this.hVQ);
        }
        this.hVk = -1;
        this.hVl = false;
        this.hVi = cVar;
    }

    public synchronized void requestStop() {
        this.hVL = true;
    }

    public Surface getInputSurface() {
        return this.hVP;
    }

    public void release() {
        if (this.hVj != null) {
            this.hVj.stop();
            this.hVj.release();
            this.hVj = null;
        }
        if (this.hVi != null) {
            try {
                this.hVi.stop();
            } catch (IllegalStateException e) {
                if (this.gZj != null) {
                    this.gZj.R(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hVi = null;
        }
    }

    public void oa(boolean z) throws Exception {
        if (z) {
            this.hVj.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hVj.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hVj.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hVj.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hVl) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hVj.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hVk = this.hVi.addTrack(outputFormat);
                if (!this.hVi.start()) {
                    synchronized (this.hVi) {
                        while (!this.hVi.isStarted() && !this.hVL) {
                            try {
                                this.hVi.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hVL) {
                    this.hVl = true;
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
                    if (!this.hVl) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hVi.writeSampleData(this.hVk, byteBuffer, this.mBufferInfo);
                }
                this.hVj.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hVR >= 500) {
                    this.hVj.setParameters(this.hVQ);
                    this.hVR = System.currentTimeMillis();
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
