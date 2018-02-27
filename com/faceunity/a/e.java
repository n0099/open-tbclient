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
    private c hWN;
    private MediaCodec hWO;
    private int hWP;
    private boolean hWQ;
    private Surface hXu;
    private h hbC;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hXv = new Bundle();
    private long hXw = 0;
    private boolean hXq = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hWO = MediaCodec.createEncoderByType("video/avc");
        this.hWO.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hXu = this.hWO.createInputSurface();
        this.hWO.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hXv.putInt("request-sync", 0);
            this.hWO.setParameters(this.hXv);
        }
        this.hWP = -1;
        this.hWQ = false;
        this.hWN = cVar;
    }

    public synchronized void requestStop() {
        this.hXq = true;
    }

    public Surface getInputSurface() {
        return this.hXu;
    }

    public void release() {
        if (this.hWO != null) {
            this.hWO.stop();
            this.hWO.release();
            this.hWO = null;
        }
        if (this.hWN != null) {
            try {
                this.hWN.stop();
            } catch (IllegalStateException e) {
                if (this.hbC != null) {
                    this.hbC.U(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hWN = null;
        }
    }

    public void ol(boolean z) throws Exception {
        if (z) {
            this.hWO.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hWO.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hWO.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hWO.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hWQ) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hWO.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hWP = this.hWN.addTrack(outputFormat);
                if (!this.hWN.start()) {
                    synchronized (this.hWN) {
                        while (!this.hWN.isStarted() && !this.hXq) {
                            try {
                                this.hWN.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hXq) {
                    this.hWQ = true;
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
                    if (!this.hWQ) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hWN.writeSampleData(this.hWP, byteBuffer, this.mBufferInfo);
                }
                this.hWO.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hXw >= 500) {
                    this.hWO.setParameters(this.hXv);
                    this.hXw = System.currentTimeMillis();
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
