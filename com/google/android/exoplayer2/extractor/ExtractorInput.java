package com.google.android.exoplayer2.extractor;

import java.io.IOException;
/* loaded from: classes7.dex */
public interface ExtractorInput {
    void advancePeekPosition(int i2) throws IOException, InterruptedException;

    boolean advancePeekPosition(int i2, boolean z) throws IOException, InterruptedException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    boolean peekFully(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException;

    int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    boolean readFully(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j2, E e2) throws Throwable;

    int skip(int i2) throws IOException, InterruptedException;

    void skipFully(int i2) throws IOException, InterruptedException;

    boolean skipFully(int i2, boolean z) throws IOException, InterruptedException;
}
