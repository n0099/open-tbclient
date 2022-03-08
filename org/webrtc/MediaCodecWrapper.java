package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public interface MediaCodecWrapper {
    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2);

    Surface createInputSurface();

    int dequeueInputBuffer(long j2);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2);

    void flush();

    void foundSei(ByteBuffer byteBuffer);

    ByteBuffer[] getInputBuffers();

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i2, int i3, int i4, long j2, int i5);

    void release();

    void releaseOutputBuffer(int i2, boolean z);

    void setParameters(Bundle bundle);

    void start();

    void stop();
}
