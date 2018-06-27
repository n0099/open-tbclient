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
    private h gOa;
    private Surface hLT;
    private c hLm;
    private MediaCodec hLn;
    private int hLo;
    private boolean hLp;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hLU = new Bundle();
    private long hLV = 0;
    private boolean hLP = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hLn = MediaCodec.createEncoderByType("video/avc");
        this.hLn.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hLT = this.hLn.createInputSurface();
        this.hLn.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hLU.putInt("request-sync", 0);
            this.hLn.setParameters(this.hLU);
        }
        this.hLo = -1;
        this.hLp = false;
        this.hLm = cVar;
    }

    public synchronized void requestStop() {
        this.hLP = true;
    }

    public Surface getInputSurface() {
        return this.hLT;
    }

    public void release() {
        if (this.hLn != null) {
            this.hLn.stop();
            this.hLn.release();
            this.hLn = null;
        }
        if (this.hLm != null) {
            try {
                this.hLm.stop();
            } catch (IllegalStateException e) {
                if (this.gOa != null) {
                    this.gOa.Z(17, com.baidu.tieba.j.a.m(e));
                }
            }
            this.hLm = null;
        }
    }

    public void oi(boolean z) throws Exception {
        if (z) {
            this.hLn.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hLn.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hLn.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hLn.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hLp) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hLn.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hLo = this.hLm.addTrack(outputFormat);
                if (!this.hLm.start()) {
                    synchronized (this.hLm) {
                        while (!this.hLm.isStarted() && !this.hLP) {
                            try {
                                this.hLm.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hLP) {
                    this.hLp = true;
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
                    if (!this.hLp) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hLm.writeSampleData(this.hLo, byteBuffer, this.mBufferInfo);
                }
                this.hLn.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hLV >= 500) {
                    this.hLn.setParameters(this.hLU);
                    this.hLV = System.currentTimeMillis();
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
