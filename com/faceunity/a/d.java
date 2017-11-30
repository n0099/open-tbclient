package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class d {
    private h gAg;
    private b htT;
    private MediaCodec htU;
    private int htV;
    private boolean htW;
    private Surface huw;
    private MediaCodec.BufferInfo mBufferInfo;

    public d(int i, int i2, int i3, b bVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.htU = MediaCodec.createEncoderByType("video/avc");
        this.htU.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.huw = this.htU.createInputSurface();
        this.htU.start();
        this.htV = -1;
        this.htW = false;
        this.htT = bVar;
    }

    public Surface getInputSurface() {
        return this.huw;
    }

    public void release() {
        if (this.htU != null) {
            this.htU.stop();
            this.htU.release();
            this.htU = null;
        }
        if (this.htT != null) {
            try {
                this.htT.stop();
            } catch (IllegalStateException e) {
                if (this.gAg != null) {
                    this.gAg.Q(17, com.baidu.tieba.i.a.g(e));
                }
            }
            this.htT = null;
        }
    }

    public void oB(boolean z) throws Exception {
        if (z) {
            this.htU.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.htU.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.htU.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.htU.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.htW) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.htU.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.htV = this.htT.d(outputFormat);
                if (!this.htT.start()) {
                    synchronized (this.htT) {
                        while (!this.htT.isStarted()) {
                            try {
                                this.htT.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                this.htW = true;
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
                    if (!this.htW) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.htT.a(this.htV, byteBuffer, this.mBufferInfo);
                }
                this.htU.releaseOutputBuffer(dequeueOutputBuffer, false);
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
