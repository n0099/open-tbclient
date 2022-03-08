package com.kwad.sdk.core.imageloader.core.listener;

import android.widget.AbsListView;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
/* loaded from: classes7.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    public final AbsListView.OnScrollListener externalListener;
    public ImageLoader imageLoader;
    public final boolean pauseOnFling;
    public final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z, boolean z2) {
        this(imageLoader, z, z2, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z;
        this.pauseOnFling = z2;
        this.externalListener = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            this.imageLoader.resume();
        } else if (i2 == 1 ? this.pauseOnScroll : !(i2 != 2 || !this.pauseOnFling)) {
            this.imageLoader.pause();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }
}
