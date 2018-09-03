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
    private h gPa;
    private Surface hES;
    private c hEl;
    private MediaCodec hEm;
    private int hEn;
    private boolean hEo;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hET = new Bundle();
    private long hEU = 0;
    private boolean hEO = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hEm = MediaCodec.createEncoderByType("video/avc");
        this.hEm.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hES = this.hEm.createInputSurface();
        this.hEm.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hET.putInt("request-sync", 0);
            this.hEm.setParameters(this.hET);
        }
        this.hEn = -1;
        this.hEo = false;
        this.hEl = cVar;
    }

    public synchronized void requestStop() {
        this.hEO = true;
    }

    public Surface getInputSurface() {
        return this.hES;
    }

    public void release() {
        if (this.hEm != null) {
            this.hEm.stop();
            this.hEm.release();
            this.hEm = null;
        }
        if (this.hEl != null) {
            try {
                this.hEl.stop();
            } catch (IllegalStateException e) {
                if (this.gPa != null) {
                    this.gPa.ab(17, com.baidu.tieba.j.a.m(e));
                }
            }
            this.hEl = null;
        }
    }

    public void nI(boolean z) throws Exception {
        if (z) {
            this.hEm.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hEm.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hEm.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hEm.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hEo) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hEm.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hEn = this.hEl.addTrack(outputFormat);
                if (!this.hEl.start()) {
                    synchronized (this.hEl) {
                        while (!this.hEl.isStarted() && !this.hEO) {
                            try {
                                this.hEl.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hEO) {
                    this.hEo = true;
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
                    if (!this.hEo) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hEl.writeSampleData(this.hEn, byteBuffer, this.mBufferInfo);
                }
                this.hEm.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hEU >= 500) {
                    this.hEm.setParameters(this.hET);
                    this.hEU = System.currentTimeMillis();
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
