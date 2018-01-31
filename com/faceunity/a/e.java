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
    private h gZD;
    private c hVC;
    private MediaCodec hVD;
    private int hVE;
    private boolean hVF;
    private Surface hWj;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hWk = new Bundle();
    private long hWl = 0;
    private boolean hWf = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hVD = MediaCodec.createEncoderByType("video/avc");
        this.hVD.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hWj = this.hVD.createInputSurface();
        this.hVD.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hWk.putInt("request-sync", 0);
            this.hVD.setParameters(this.hWk);
        }
        this.hVE = -1;
        this.hVF = false;
        this.hVC = cVar;
    }

    public synchronized void requestStop() {
        this.hWf = true;
    }

    public Surface getInputSurface() {
        return this.hWj;
    }

    public void release() {
        if (this.hVD != null) {
            this.hVD.stop();
            this.hVD.release();
            this.hVD = null;
        }
        if (this.hVC != null) {
            try {
                this.hVC.stop();
            } catch (IllegalStateException e) {
                if (this.gZD != null) {
                    this.gZD.T(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hVC = null;
        }
    }

    public void oc(boolean z) throws Exception {
        if (z) {
            this.hVD.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hVD.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hVD.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hVD.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hVF) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hVD.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hVE = this.hVC.addTrack(outputFormat);
                if (!this.hVC.start()) {
                    synchronized (this.hVC) {
                        while (!this.hVC.isStarted() && !this.hWf) {
                            try {
                                this.hVC.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hWf) {
                    this.hVF = true;
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
                    if (!this.hVF) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hVC.writeSampleData(this.hVE, byteBuffer, this.mBufferInfo);
                }
                this.hVD.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hWl >= 500) {
                    this.hVD.setParameters(this.hWk);
                    this.hWl = System.currentTimeMillis();
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
