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
/* loaded from: classes5.dex */
public class e {
    private boolean afr;
    private h jjR;
    private c kpe;
    private int kpf;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mEncoder;
    private Surface mInputSurface;
    private Bundle aHE = new Bundle();
    private long kpJ = 0;
    private boolean kpF = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.mEncoder = MediaCodec.createEncoderByType("video/avc");
        this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.aHE.putInt("request-sync", 0);
            this.mEncoder.setParameters(this.aHE);
        }
        this.kpf = -1;
        this.afr = false;
        this.kpe = cVar;
    }

    public synchronized void requestStop() {
        this.kpF = true;
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    public void release() {
        if (this.mEncoder != null) {
            this.mEncoder.stop();
            this.mEncoder.release();
            this.mEncoder = null;
        }
        if (this.kpe != null) {
            try {
                this.kpe.stop();
            } catch (IllegalStateException e) {
                if (this.jjR != null) {
                    this.jjR.av(17, com.baidu.tieba.j.a.p(e));
                }
            }
            this.kpe = null;
        }
    }

    public void drainEncoder(boolean z) throws Exception {
        if (z) {
            this.mEncoder.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.mEncoder.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.afr) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.kpf = this.kpe.f(outputFormat);
                if (!this.kpe.start()) {
                    synchronized (this.kpe) {
                        while (!this.kpe.isStarted() && !this.kpF) {
                            try {
                                this.kpe.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.kpF) {
                    this.afr = true;
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
                    if (!this.afr) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.kpe.c(this.kpf, byteBuffer, this.mBufferInfo);
                }
                this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.kpJ >= 500) {
                    this.mEncoder.setParameters(this.aHE);
                    this.kpJ = System.currentTimeMillis();
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
