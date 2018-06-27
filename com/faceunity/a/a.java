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
    private c hLm;
    private MediaCodec hLn;
    private int hLo;
    private boolean hLp;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.hLn = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hLn.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.hLn.start();
        this.hLo = -1;
        this.hLp = false;
        this.hLm = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.hLn.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.hLn.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.hLn.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.hLn.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.hLn.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void bNM() throws Exception {
        ByteBuffer[] outputBuffers = this.hLn.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.hLn.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.hLn.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.hLp) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.hLn.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.hLo = this.hLm.addTrack(outputFormat);
                    if (!this.hLm.start()) {
                        synchronized (this.hLm) {
                            while (!this.hLm.isStarted()) {
                                try {
                                    this.hLm.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.hLp = true;
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
                        if (!this.hLp) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(this.mBufferInfo.offset);
                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                        this.hLm.writeSampleData(this.hLo, byteBuffer, this.mBufferInfo);
                    }
                    this.hLn.releaseOutputBuffer(dequeueOutputBuffer, false);
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
            if (this.hLn != null) {
                this.hLn.stop();
                this.hLn.release();
                this.hLn = null;
            }
            if (this.hLm != null) {
                this.hLm.stop();
                this.hLm = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
