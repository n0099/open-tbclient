package com.facebook.datasource;

import javax.annotation.Nonnull;
/* loaded from: classes7.dex */
public interface DataSubscriber {
    void onCancellation(@Nonnull DataSource dataSource);

    void onFailure(@Nonnull DataSource dataSource);

    void onNewResult(@Nonnull DataSource dataSource);

    void onProgressUpdate(@Nonnull DataSource dataSource);
}
