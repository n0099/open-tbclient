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
import com.baidu.tieba.j.l;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class e {
    private h gOY;
    private Surface hEQ;
    private c hEj;
    private MediaCodec hEk;
    private int hEl;
    private boolean hEm;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hER = new Bundle();
    private long hES = 0;
    private boolean hEM = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hEk = MediaCodec.createEncoderByType("video/avc");
        this.hEk.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hEQ = this.hEk.createInputSurface();
        this.hEk.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hER.putInt("request-sync", 0);
            this.hEk.setParameters(this.hER);
        }
        this.hEl = -1;
        this.hEm = false;
        this.hEj = cVar;
    }

    public synchronized void requestStop() {
        this.hEM = true;
    }

    public Surface getInputSurface() {
        return this.hEQ;
    }

    public void release() {
        if (this.hEk != null) {
            this.hEk.stop();
            this.hEk.release();
            this.hEk = null;
        }
        if (this.hEj != null) {
            try {
                this.hEj.stop();
            } catch (IllegalStateException e) {
                if (this.gOY != null) {
                    this.gOY.ab(17, com.baidu.tieba.j.a.m(e));
                }
            }
            this.hEj = null;
        }
    }

    public void nI(boolean z) throws Exception {
        if (z) {
            this.hEk.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hEk.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hEk.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hEk.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hEm) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hEk.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hEl = this.hEj.addTrack(outputFormat);
                if (!this.hEj.start()) {
                    synchronized (this.hEj) {
                        while (!this.hEj.isStarted() && !this.hEM) {
                            try {
                                this.hEj.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hEM) {
                    this.hEm = true;
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
                    if (!this.hEm) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hEj.writeSampleData(this.hEl, byteBuffer, this.mBufferInfo);
                }
                this.hEk.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hES >= 500) {
                    this.hEk.setParameters(this.hER);
                    this.hES = System.currentTimeMillis();
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
