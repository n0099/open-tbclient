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
    private b gXl;
    private MediaCodec gXm;
    private int gXn;
    private boolean gXo;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public a(b bVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.gXm = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gXm.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.gXm.start();
        this.gXn = -1;
        this.gXo = false;
        this.gXl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.gXm.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.gXm.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.gXm.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.gXm.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.gXm.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void bFb() throws Exception {
        ByteBuffer[] outputBuffers = this.gXm.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.gXm.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.gXm.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.gXo) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.gXm.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.gXn = this.gXl.a(outputFormat);
                    if (!this.gXl.start()) {
                        synchronized (this.gXl) {
                            while (!this.gXl.isStarted()) {
                                try {
                                    this.gXl.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.gXo = true;
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
                        if (!this.gXo) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(this.mBufferInfo.offset);
                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                        this.gXl.a(this.gXn, byteBuffer, this.mBufferInfo);
                    }
                    this.gXm.releaseOutputBuffer(dequeueOutputBuffer, false);
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
            if (this.gXm != null) {
                this.gXm.stop();
                this.gXm.release();
                this.gXm = null;
            }
            if (this.gXl != null) {
                this.gXl.stop();
                this.gXl = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
