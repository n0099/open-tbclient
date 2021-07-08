package com.facebook.datasource;
/* loaded from: classes5.dex */
public interface DataSubscriber<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
