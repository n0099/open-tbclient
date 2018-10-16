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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes5.dex */
public class e {
    private h hea;
    private c iiY;
    private MediaCodec iiZ;
    private Surface ijE;
    private int ija;
    private boolean ijb;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle ijF = new Bundle();
    private long ijG = 0;
    private boolean ijA = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.iiZ = MediaCodec.createEncoderByType("video/avc");
        this.iiZ.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.ijE = this.iiZ.createInputSurface();
        this.iiZ.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.ijF.putInt("request-sync", 0);
            this.iiZ.setParameters(this.ijF);
        }
        this.ija = -1;
        this.ijb = false;
        this.iiY = cVar;
    }

    public synchronized void requestStop() {
        this.ijA = true;
    }

    public Surface getInputSurface() {
        return this.ijE;
    }

    public void release() {
        if (this.iiZ != null) {
            this.iiZ.stop();
            this.iiZ.release();
            this.iiZ = null;
        }
        if (this.iiY != null) {
            try {
                this.iiY.stop();
            } catch (IllegalStateException e) {
                if (this.hea != null) {
                    this.hea.ab(17, com.baidu.tieba.j.a.o(e));
                }
            }
            this.iiY = null;
        }
    }

    public void oL(boolean z) throws Exception {
        if (z) {
            this.iiZ.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.iiZ.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.iiZ.dequeueOutputBuffer(this.mBufferInfo, ErrDef.Feature.WEIGHT);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.iiZ.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.ijb) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.iiZ.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.ija = this.iiY.addTrack(outputFormat);
                if (!this.iiY.start()) {
                    synchronized (this.iiY) {
                        while (!this.iiY.isStarted() && !this.ijA) {
                            try {
                                this.iiY.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.ijA) {
                    this.ijb = true;
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
                    if (!this.ijb) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.iiY.writeSampleData(this.ija, byteBuffer, this.mBufferInfo);
                }
                this.iiZ.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.ijG >= 500) {
                    this.iiZ.setParameters(this.ijF);
                    this.ijG = System.currentTimeMillis();
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
