package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes4.dex */
public class AudioEncoder {
    private static final String TAG = "AudioEncoder";
    private long mCodecCtx;

    private native long nativeCreateAudioEncoder(int i);

    private native byte[] nativeEncode(long j, byte[] bArr);

    private native byte[] nativeEncodeLoss(long j);

    private native void nativeFlush(long j);

    private native long nativeGetEncoderBytes(long j);

    private native void nativeInit(long j);

    private native void nativeSetBitRate(long j, long j2);

    private native void nativeSetComplexity(long j, long j2);

    private native void nativeUninit(long j);

    public AudioEncoder(Constant.AudioCoderType audioCoderType) {
        this.mCodecCtx = nativeCreateAudioEncoder(audioCoderType.ordinal());
    }

    public void init() {
        nativeInit(this.mCodecCtx);
    }

    public void uninit() {
        nativeUninit(this.mCodecCtx);
    }

    public void flush() {
        nativeFlush(this.mCodecCtx);
    }

    public byte[] encode(byte[] bArr) {
        return nativeEncode(this.mCodecCtx, bArr);
    }

    public byte[] encodeLoss() {
        return nativeEncodeLoss(this.mCodecCtx);
    }

    public void setBitRate(long j) {
        nativeSetBitRate(this.mCodecCtx, j);
    }

    public long getEncoderBytes() {
        return nativeGetEncoderBytes(this.mCodecCtx);
    }

    public void setComplexity(long j) {
        nativeSetComplexity(this.mCodecCtx, j);
    }
}
