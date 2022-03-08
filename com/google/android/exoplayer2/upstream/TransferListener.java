package com.google.android.exoplayer2.upstream;
/* loaded from: classes7.dex */
public interface TransferListener<S> {
    void onBytesTransferred(S s, int i2);

    void onTransferEnd(S s);

    void onTransferStart(S s, DataSpec dataSpec);
}
