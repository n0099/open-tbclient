package com.google.android.exoplayer2.upstream;
/* loaded from: classes7.dex */
public interface TransferListener {
    void onBytesTransferred(Object obj, int i);

    void onTransferEnd(Object obj);

    void onTransferStart(Object obj, DataSpec dataSpec);
}
