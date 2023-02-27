package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
/* loaded from: classes7.dex */
public final class FileDataSourceFactory implements DataSource.Factory {
    public final TransferListener<? super FileDataSource> listener;

    public FileDataSourceFactory() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        return new FileDataSource(this.listener);
    }

    public FileDataSourceFactory(TransferListener<? super FileDataSource> transferListener) {
        this.listener = transferListener;
    }
}
