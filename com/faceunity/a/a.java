package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    private c hXl;
    private MediaCodec hXm;
    private int hXn;
    private boolean hXo;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.hXm = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hXm.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hXm.start();
        this.hXn = -1;
        this.hXo = false;
        this.hXl = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.hXm.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.hXm.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.hXm.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.hXm.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.hXm.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void bMK() throws Exception {
        ByteBuffer[] outputBuffers = this.hXm.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hXm.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.hXm.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.hXo) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.hXm.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.hXn = this.hXl.addTrack(outputFormat);
                    if (!this.hXl.start()) {
                        synchronized (this.hXl) {
                            while (!this.hXl.isStarted()) {
                                try {
                                    this.hXl.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.hXo = true;
                } else if (dequeueOutputBuffer < 0) {
                    Log.w("AudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
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
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public void release() {
        try {
            if (this.hXm != null) {
                this.hXm.stop();
                this.hXm.release();
                this.hXm = null;
            }
            if (this.hXl != null) {
                this.hXl.stop();
                this.hXl = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
