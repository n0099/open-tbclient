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
    private c hHg;
    private MediaCodec hHh;
    private int hHi;
    private boolean hHj;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.hHh = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hHh.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hHh.start();
        this.hHi = -1;
        this.hHj = false;
        this.hHg = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.hHh.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.hHh.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.hHh.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.hHh.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.hHh.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void bNk() throws Exception {
        ByteBuffer[] outputBuffers = this.hHh.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hHh.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.hHh.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.hHj) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.hHh.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.hHi = this.hHg.addTrack(outputFormat);
                    if (!this.hHg.start()) {
                        synchronized (this.hHg) {
                            while (!this.hHg.isStarted()) {
                                try {
                                    this.hHg.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.hHj = true;
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
                        if (!this.hHj) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(this.mBufferInfo.offset);
                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                        this.hHg.writeSampleData(this.hHi, byteBuffer, this.mBufferInfo);
                    }
                    this.hHh.releaseOutputBuffer(dequeueOutputBuffer, false);
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
            if (this.hHh != null) {
                this.hHh.stop();
                this.hHh.release();
                this.hHh = null;
            }
            if (this.hHg != null) {
                this.hHg.stop();
                this.hHg = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
