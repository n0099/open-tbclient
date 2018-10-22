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
    private h heb;
    private c iiZ;
    private Surface ijF;
    private MediaCodec ija;
    private int ijb;
    private boolean ijc;
    private MediaCodec.BufferInfo mBufferInfo;
    private Bundle ijG = new Bundle();
    private long ijH = 0;
    private boolean ijB = false;

    public e(int i, int i2, int i3, c cVar) throws IOException {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        this.ija = MediaCodec.createEncoderByType("video/avc");
        this.ija.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.ijF = this.ija.createInputSurface();
        this.ija.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.ijG.putInt("request-sync", 0);
            this.ija.setParameters(this.ijG);
        }
        this.ijb = -1;
        this.ijc = false;
        this.iiZ = cVar;
    }

    public synchronized void requestStop() {
        this.ijB = true;
    }

    public Surface getInputSurface() {
        return this.ijF;
    }

    public void release() {
        if (this.ija != null) {
            this.ija.stop();
            this.ija.release();
            this.ija = null;
        }
        if (this.iiZ != null) {
            try {
                this.iiZ.stop();
            } catch (IllegalStateException e) {
                if (this.heb != null) {
                    this.heb.ab(17, com.baidu.tieba.j.a.o(e));
                }
            }
            this.iiZ = null;
        }
    }

    public void oL(boolean z) throws Exception {
        if (z) {
            this.ija.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.ija.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.ija.dequeueOutputBuffer(this.mBufferInfo, ErrDef.Feature.WEIGHT);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.ija.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.ijc) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.ija.getOutputFormat();
                Log.d("VideoEncoder", "encoder output format changed: " + outputFormat);
                this.ijb = this.iiZ.addTrack(outputFormat);
                if (!this.iiZ.start()) {
                    synchronized (this.iiZ) {
                        while (!this.iiZ.isStarted() && !this.ijB) {
                            try {
                                this.iiZ.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!this.ijB) {
                    this.ijc = true;
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
                    if (!this.ijc) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    this.iiZ.writeSampleData(this.ijb, byteBuffer, this.mBufferInfo);
                }
                this.ija.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.ijH >= 500) {
                    this.ija.setParameters(this.ijG);
                    this.ijH = System.currentTimeMillis();
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
