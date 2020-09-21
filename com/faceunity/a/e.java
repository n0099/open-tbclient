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
import com.baidu.fsg.face.liveness.video.f;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes22.dex */
public class e {
    private boolean bDp;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mEncoder;
    private Surface mInputSurface;
    private int mTrackIndex;
    private h mpU;
    private c nKy;
    private Bundle cKH = new Bundle();
    private long nLb = 0;
    private boolean nKW = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(f.b, i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.mEncoder = MediaCodec.createEncoderByType(f.b);
        this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.cKH.putInt("request-sync", 0);
            this.mEncoder.setParameters(this.cKH);
        }
        this.mTrackIndex = -1;
        this.bDp = false;
        this.nKy = cVar;
    }

    public synchronized void requestStop() {
        this.nKW = true;
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
        if (this.nKy != null) {
            try {
                this.nKy.stop();
            } catch (IllegalStateException e) {
                if (this.mpU != null) {
                    this.mpU.bq(17, com.baidu.tieba.k.a.r(e));
                }
            }
            this.nKy = null;
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
                if (this.bDp) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.mTrackIndex = this.nKy.c(outputFormat);
                if (!this.nKy.start()) {
                    synchronized (this.nKy) {
                        while (!this.nKy.isStarted() && !this.nKW) {
                            try {
                                this.nKy.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.nKW) {
                    this.bDp = true;
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
                    if (!this.bDp) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.nKy.c(this.mTrackIndex, byteBuffer, this.mBufferInfo);
                }
                this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.nLb >= 500) {
                    this.mEncoder.setParameters(this.cKH);
                    this.nLb = System.currentTimeMillis();
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
