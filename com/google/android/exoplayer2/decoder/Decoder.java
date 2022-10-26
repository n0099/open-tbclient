package com.google.android.exoplayer2.decoder;
/* loaded from: classes7.dex */
public interface Decoder {
    Object dequeueInputBuffer() throws Exception;

    Object dequeueOutputBuffer() throws Exception;

    void flush();

    String getName();

    void queueInputBuffer(Object obj) throws Exception;

    void release();
}
