package com.facebook.datasource;
/* loaded from: classes2.dex */
public interface d<T> {
    void onCancellation(b<T> bVar);

    void onFailure(b<T> bVar);

    void onNewResult(b<T> bVar);

    void onProgressUpdate(b<T> bVar);
}
