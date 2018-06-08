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
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class e {
    private h gJZ;
    private Surface hHN;
    private c hHg;
    private MediaCodec hHh;
    private int hHi;
    private boolean hHj;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hHO = new Bundle();
    private long hHP = 0;
    private boolean hHJ = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hHh = MediaCodec.createEncoderByType("video/avc");
        this.hHh.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hHN = this.hHh.createInputSurface();
        this.hHh.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hHO.putInt("request-sync", 0);
            this.hHh.setParameters(this.hHO);
        }
        this.hHi = -1;
        this.hHj = false;
        this.hHg = cVar;
    }

    public synchronized void requestStop() {
        this.hHJ = true;
    }

    public Surface getInputSurface() {
        return this.hHN;
    }

    public void release() {
        if (this.hHh != null) {
            this.hHh.stop();
            this.hHh.release();
            this.hHh = null;
        }
        if (this.hHg != null) {
            try {
                this.hHg.stop();
            } catch (IllegalStateException e) {
                if (this.gJZ != null) {
                    this.gJZ.ac(17, com.baidu.tieba.j.a.m(e));
                }
            }
            this.hHg = null;
        }
    }

    public void ob(boolean z) throws Exception {
        if (z) {
            this.hHh.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hHh.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hHh.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hHh.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hHj) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hHh.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hHi = this.hHg.addTrack(outputFormat);
                if (!this.hHg.start()) {
                    synchronized (this.hHg) {
                        while (!this.hHg.isStarted() && !this.hHJ) {
                            try {
                                this.hHg.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hHJ) {
                    this.hHj = true;
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
                    if (!this.hHj) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hHg.writeSampleData(this.hHi, byteBuffer, this.mBufferInfo);
                }
                this.hHh.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hHP >= 500) {
                    this.hHh.setParameters(this.hHO);
                    this.hHP = System.currentTimeMillis();
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
