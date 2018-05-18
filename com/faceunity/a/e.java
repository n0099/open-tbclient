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
    private h gyx;
    private Surface hvT;
    private c hvm;
    private MediaCodec hvn;
    private int hvo;
    private boolean hvp;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hvU = new Bundle();
    private long hvV = 0;
    private boolean hvP = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hvn = MediaCodec.createEncoderByType("video/avc");
        this.hvn.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hvT = this.hvn.createInputSurface();
        this.hvn.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hvU.putInt("request-sync", 0);
            this.hvn.setParameters(this.hvU);
        }
        this.hvo = -1;
        this.hvp = false;
        this.hvm = cVar;
    }

    public synchronized void requestStop() {
        this.hvP = true;
    }

    public Surface getInputSurface() {
        return this.hvT;
    }

    public void release() {
        if (this.hvn != null) {
            this.hvn.stop();
            this.hvn.release();
            this.hvn = null;
        }
        if (this.hvm != null) {
            try {
                this.hvm.stop();
            } catch (IllegalStateException e) {
                if (this.gyx != null) {
                    this.gyx.ac(17, com.baidu.tieba.j.a.g(e));
                }
            }
            this.hvm = null;
        }
    }

    public void nT(boolean z) throws Exception {
        if (z) {
            this.hvn.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hvn.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hvn.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hvn.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hvp) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hvn.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hvo = this.hvm.addTrack(outputFormat);
                if (!this.hvm.start()) {
                    synchronized (this.hvm) {
                        while (!this.hvm.isStarted() && !this.hvP) {
                            try {
                                this.hvm.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hvP) {
                    this.hvp = true;
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
                    if (!this.hvp) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hvm.writeSampleData(this.hvo, byteBuffer, this.mBufferInfo);
                }
                this.hvn.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hvV >= 500) {
                    this.hvn.setParameters(this.hvU);
                    this.hvV = System.currentTimeMillis();
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
