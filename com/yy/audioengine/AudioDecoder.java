package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes4.dex */
public class AudioDecoder {
    private static final String TAG = "AudioDecoder";
    private long mCodecCtx;

    private native long nativeCreateAudioDecoder(int i);

    private native byte[] nativeDecode(long j, byte[] bArr);

    private native byte[] nativeDecodeLoss(long j);

    private native void nativeFlush(long j);

    private native void nativeInit(long j);

    private native void nativeUninit(long j);

    public AudioDecoder(Constant.AudioCoderType audioCoderType) {
        this.mCodecCtx = nativeCreateAudioDecoder(audioCoderType.ordinal());
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

    public byte[] decode(byte[] bArr) {
        return nativeDecode(this.mCodecCtx, bArr);
    }

    public byte[] decodeLoss() {
        return nativeDecodeLoss(this.mCodecCtx);
    }
}
