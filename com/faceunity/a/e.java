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
    private h gWF;
    private c hMF;
    private MediaCodec hMG;
    private int hMH;
    private boolean hMI;
    private Surface hNm;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hNn = new Bundle();
    private long hNo = 0;
    private boolean hNi = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hMG = MediaCodec.createEncoderByType("video/avc");
        this.hMG.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hNm = this.hMG.createInputSurface();
        this.hMG.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hNn.putInt("request-sync", 0);
            this.hMG.setParameters(this.hNn);
        }
        this.hMH = -1;
        this.hMI = false;
        this.hMF = cVar;
    }

    public synchronized void requestStop() {
        this.hNi = true;
    }

    public Surface getInputSurface() {
        return this.hNm;
    }

    public void release() {
        if (this.hMG != null) {
            this.hMG.stop();
            this.hMG.release();
            this.hMG = null;
        }
        if (this.hMF != null) {
            try {
                this.hMF.stop();
            } catch (IllegalStateException e) {
                if (this.gWF != null) {
                    this.gWF.ab(17, com.baidu.tieba.j.a.m(e));
                }
            }
            this.hMF = null;
        }
    }

    public void of(boolean z) throws Exception {
        if (z) {
            this.hMG.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hMG.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hMG.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hMG.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hMI) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hMG.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hMH = this.hMF.addTrack(outputFormat);
                if (!this.hMF.start()) {
                    synchronized (this.hMF) {
                        while (!this.hMF.isStarted() && !this.hNi) {
                            try {
                                this.hMF.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hNi) {
                    this.hMI = true;
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
                    if (!this.hMI) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hMF.writeSampleData(this.hMH, byteBuffer, this.mBufferInfo);
                }
                this.hMG.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hNo >= 500) {
                    this.hMG.setParameters(this.hNn);
                    this.hNo = System.currentTimeMillis();
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
