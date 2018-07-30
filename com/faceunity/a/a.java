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
    private c hEj;
    private MediaCodec hEk;
    private int hEl;
    private boolean hEm;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.hEk = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hEk.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hEk.start();
        this.hEl = -1;
        this.hEm = false;
        this.hEj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.hEk.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.hEk.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.hEk.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.hEk.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.hEk.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void bJF() throws Exception {
        ByteBuffer[] outputBuffers = this.hEk.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hEk.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.hEk.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.hEm) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.hEk.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.hEl = this.hEj.addTrack(outputFormat);
                    if (!this.hEj.start()) {
                        synchronized (this.hEj) {
                            while (!this.hEj.isStarted()) {
                                try {
                                    this.hEj.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.hEm = true;
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
                        if (!this.hEm) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(this.mBufferInfo.offset);
                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                        this.hEj.writeSampleData(this.hEl, byteBuffer, this.mBufferInfo);
                    }
                    this.hEk.releaseOutputBuffer(dequeueOutputBuffer, false);
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
            if (this.hEk != null) {
                this.hEk.stop();
                this.hEk.release();
                this.hEk = null;
            }
            if (this.hEj != null) {
                this.hEj.stop();
                this.hEj = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
