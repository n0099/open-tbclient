package com.kwad.components.core.n.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ap;
/* loaded from: classes10.dex */
public final class b extends BaseKsMediaPlayerView {
    public DetailVideoView Nv;

    public b(Context context) {
        super(context);
    }

    public final b a(@NonNull DetailVideoView detailVideoView) {
        ap.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.Nv = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z) {
        this.Nv.fixWidth(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z) {
        this.Nv.setAd(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        DetailVideoView.a aVar;
        DetailVideoView detailVideoView = this.Nv;
        if (videoViewClickListener == null) {
            aVar = null;
        } else {
            aVar = new DetailVideoView.a() { // from class: com.kwad.components.core.n.b.c.b.1
                @Override // com.kwad.components.core.video.DetailVideoView.a
                public final void onClickRootView() {
                    videoViewClickListener.onClickRootView();
                }

                @Override // com.kwad.components.core.video.DetailVideoView.a
                public final void onClickVideoView() {
                    videoViewClickListener.onClickVideoView();
                }
            };
        }
        detailVideoView.setClickListener(aVar);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z) {
        this.Nv.setForce(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z) {
        this.Nv.setHorizontalVideo(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (iKsMediaPlayer instanceof a) {
            this.Nv.setMediaPlayer(((a) iKsMediaPlayer).oK());
            return;
        }
        throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f) {
        this.Nv.setRadius(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i) {
        this.Nv.updateTextureViewGravity(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i, int i2) {
        this.Nv.adaptVideoSize(i, i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.Nv.getTextureViewGravity();
    }

    public final DetailVideoView oM() {
        return this.Nv;
    }
}
