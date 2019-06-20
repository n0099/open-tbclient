package com.faceunity.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes5.dex */
public class a {
    private boolean aeU;
    private c keu;
    private int kev;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec mEncoder;

    public a(c cVar) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        try {
            this.mEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mEncoder.start();
        this.kev = -1;
        this.aeU = false;
        this.keu = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0011 A[EDGE_INSN: B:15:0x0011->B:5:0x0011 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = this.mEncoder.getInputBuffers();
        while (true) {
            dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                break;
            }
            if (dequeueInputBuffer == -1) {
            }
            dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
            }
        }
        ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
        byteBuffer2.clear();
        if (byteBuffer != null) {
            byteBuffer2.put(byteBuffer);
        }
        if (i <= 0) {
            this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
        } else {
            this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        }
    }

    public void cID() throws Exception {
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.aeU) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d("AudioEncoder", "encoder output format changed: " + outputFormat);
                    this.kev = this.keu.addTrack(outputFormat);
                    if (!this.keu.start()) {
                        synchronized (this.keu) {
                            while (!this.keu.isStarted()) {
                                try {
                                    this.keu.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.aeU = true;
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
                        if (!this.aeU) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(this.mBufferInfo.offset);
                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                        this.keu.writeSampleData(this.kev, byteBuffer, this.mBufferInfo);
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
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
            if (this.mEncoder != null) {
                this.mEncoder.stop();
                this.mEncoder.release();
                this.mEncoder = null;
            }
            if (this.keu != null) {
                this.keu.stop();
                this.keu = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
