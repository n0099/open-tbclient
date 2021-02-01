package com.yy.mediaframework.encoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface HardEncodeListner {
    void onEncodedDataAvailable(ByteBuffer byteBuffer, int i, int i2, long j, long j2);

    void onEncodedDataAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat);

    void onEncodedHeaderAvailable(ByteBuffer byteBuffer, int i, int i2, String str);

    void onEncodedHeaderAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat);

    void onEncoderFomratChanged(MediaFormat mediaFormat);

    void onError(long j, String str, String str2);

    void onNoEncodedDataOut();

    void onPreviewTextureAvailable(SurfaceTexture surfaceTexture);
}
