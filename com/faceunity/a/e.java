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
    private h gxw;
    private Surface huS;
    private c hul;
    private MediaCodec hum;
    private int hun;
    private boolean huo;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle huT = new Bundle();
    private long huU = 0;
    private boolean huO = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.hum = MediaCodec.createEncoderByType("video/avc");
        this.hum.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.huS = this.hum.createInputSurface();
        this.hum.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.huT.putInt("request-sync", 0);
            this.hum.setParameters(this.huT);
        }
        this.hun = -1;
        this.huo = false;
        this.hul = cVar;
    }

    public synchronized void requestStop() {
        this.huO = true;
    }

    public Surface getInputSurface() {
        return this.huS;
    }

    public void release() {
        if (this.hum != null) {
            this.hum.stop();
            this.hum.release();
            this.hum = null;
        }
        if (this.hul != null) {
            try {
                this.hul.stop();
            } catch (IllegalStateException e) {
                if (this.gxw != null) {
                    this.gxw.ac(17, com.baidu.tieba.j.a.g(e));
                }
            }
            this.hul = null;
        }
    }

    public void nS(boolean z) throws Exception {
        if (z) {
            this.hum.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.hum.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hum.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.hum.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.huo) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.hum.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.hun = this.hul.addTrack(outputFormat);
                if (!this.hul.start()) {
                    synchronized (this.hul) {
                        while (!this.hul.isStarted() && !this.huO) {
                            try {
                                this.hul.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.huO) {
                    this.huo = true;
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
                    if (!this.huo) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.hul.writeSampleData(this.hun, byteBuffer, this.mBufferInfo);
                }
                this.hum.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.huU >= 500) {
                    this.hum.setParameters(this.huT);
                    this.huU = System.currentTimeMillis();
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
