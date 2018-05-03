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
    private h gxt;
    private Surface huP;
    private c hui;
    private MediaCodec huj;
    private int huk;
    private boolean hul;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle huQ = new Bundle();
    private long huR = 0;
    private boolean huL = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.huj = MediaCodec.createEncoderByType("video/avc");
        this.huj.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.huP = this.huj.createInputSurface();
        this.huj.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.huQ.putInt("request-sync", 0);
            this.huj.setParameters(this.huQ);
        }
        this.huk = -1;
        this.hul = false;
        this.hui = cVar;
    }

    public synchronized void requestStop() {
        this.huL = true;
    }

    public Surface getInputSurface() {
        return this.huP;
    }

    public void release() {
        if (this.huj != null) {
            this.huj.stop();
            this.huj.release();
            this.huj = null;
        }
        if (this.hui != null) {
            try {
                this.hui.stop();
            } catch (IllegalStateException e) {
                if (this.gxt != null) {
                    this.gxt.ac(17, com.baidu.tieba.j.a.g(e));
                }
            }
            this.hui = null;
        }
    }

    public void nS(boolean z) throws Exception {
        if (z) {
            this.huj.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.huj.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.huj.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.huj.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.hul) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.huj.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.huk = this.hui.addTrack(outputFormat);
                if (!this.hui.start()) {
                    synchronized (this.hui) {
                        while (!this.hui.isStarted() && !this.huL) {
                            try {
                                this.hui.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.huL) {
                    this.hul = true;
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
                    if (!this.hul) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hui.writeSampleData(this.huk, byteBuffer, this.mBufferInfo);
                }
                this.huj.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.huR >= 500) {
                    this.huj.setParameters(this.huQ);
                    this.huR = System.currentTimeMillis();
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
