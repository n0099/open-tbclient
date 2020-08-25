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
/* loaded from: classes17.dex */
public class e {
    private boolean bzP;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mEncoder;
    private Surface mInputSurface;
    private int mTrackIndex;
    private h mgf;
    private c nAj;
    private Bundle cID = new Bundle();
    private long nAM = 0;
    private boolean nAH = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
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
            this.cID.putInt("request-sync", 0);
            this.mEncoder.setParameters(this.cID);
        }
        this.mTrackIndex = -1;
        this.bzP = false;
        this.nAj = cVar;
    }

    public synchronized void requestStop() {
        this.nAH = true;
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
        if (this.nAj != null) {
            try {
                this.nAj.stop();
            } catch (IllegalStateException e) {
                if (this.mgf != null) {
                    this.mgf.bn(17, com.baidu.tieba.k.a.r(e));
                }
            }
            this.nAj = null;
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
                if (this.bzP) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.mTrackIndex = this.nAj.c(outputFormat);
                if (!this.nAj.start()) {
                    synchronized (this.nAj) {
                        while (!this.nAj.isStarted() && !this.nAH) {
                            try {
                                this.nAj.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.nAH) {
                    this.bzP = true;
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
                    if (!this.bzP) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.nAj.c(this.mTrackIndex, byteBuffer, this.mBufferInfo);
                }
                this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.nAM >= 500) {
                    this.mEncoder.setParameters(this.cID);
                    this.nAM = System.currentTimeMillis();
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
