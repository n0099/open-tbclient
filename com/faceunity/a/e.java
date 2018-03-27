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
    private Surface hXS;
    private c hXl;
    private MediaCodec hXm;
    private int hXn;
    private boolean hXo;
    private h hca;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle hXT = new Bundle();
    private long hXU = 0;
    private boolean hXO = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hXm = MediaCodec.createEncoderByType("video/avc");
        this.hXm.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hXS = this.hXm.createInputSurface();
        this.hXm.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.hXT.putInt("request-sync", 0);
            this.hXm.setParameters(this.hXT);
        }
        this.hXn = -1;
        this.hXo = false;
        this.hXl = cVar;
    }

    public synchronized void requestStop() {
        this.hXO = true;
    }

    public Surface getInputSurface() {
        return this.hXS;
    }

    public void release() {
        if (this.hXm != null) {
            this.hXm.stop();
            this.hXm.release();
            this.hXm = null;
        }
        if (this.hXl != null) {
            try {
                this.hXl.stop();
            } catch (IllegalStateException e) {
                if (this.hca != null) {
                    this.hca.U(17, com.baidu.tieba.i.a.i(e));
                }
            }
            this.hXl = null;
        }
    }

    public void oq(boolean z) throws Exception {
        if (z) {
            this.hXm.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hXm.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hXm.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hXm.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hXo) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hXm.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hXn = this.hXl.addTrack(outputFormat);
                if (!this.hXl.start()) {
                    synchronized (this.hXl) {
                        while (!this.hXl.isStarted() && !this.hXO) {
                            try {
                                this.hXl.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.hXO) {
                    this.hXo = true;
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
                    if (!this.hXo) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hXl.writeSampleData(this.hXn, byteBuffer, this.mBufferInfo);
                }
                this.hXm.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.hXU >= 500) {
                    this.hXm.setParameters(this.hXT);
                    this.hXU = System.currentTimeMillis();
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
