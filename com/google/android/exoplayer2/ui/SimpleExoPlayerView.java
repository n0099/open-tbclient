package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
@TargetApi(16)
/* loaded from: classes9.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    public static final int SURFACE_TYPE_NONE = 0;
    public static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    public static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    public final ImageView artworkView;
    public final ComponentListener componentListener;
    public final AspectRatioFrameLayout contentFrame;
    public final PlaybackControlView controller;
    public boolean controllerAutoShow;
    public boolean controllerHideOnTouch;
    public int controllerShowTimeoutMs;
    public Bitmap defaultArtwork;
    public final FrameLayout overlayFrameLayout;
    public SimpleExoPlayer player;
    public final View shutterView;
    public final SubtitleView subtitleView;
    public final View surfaceView;
    public boolean useArtwork;
    public boolean useController;

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* loaded from: classes9.dex */
    public final class ComponentListener extends Player.DefaultEventListener implements TextOutput, SimpleExoPlayer.VideoListener {
        public ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            if (SimpleExoPlayerView.this.subtitleView != null) {
                SimpleExoPlayerView.this.subtitleView.onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            if (SimpleExoPlayerView.this.isPlayingAd()) {
                SimpleExoPlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            if (!SimpleExoPlayerView.this.isPlayingAd()) {
                SimpleExoPlayerView.this.maybeShowController(false);
            } else {
                SimpleExoPlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            SimpleExoPlayerView.this.updateForCurrentTrackSelections();
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            if (SimpleExoPlayerView.this.shutterView != null) {
                SimpleExoPlayerView.this.shutterView.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            float f2;
            if (SimpleExoPlayerView.this.contentFrame != null) {
                if (i2 == 0) {
                    f2 = 1.0f;
                } else {
                    f2 = (i * f) / i2;
                }
                SimpleExoPlayerView.this.contentFrame.setAspectRatio(f2);
            }
        }
    }

    public SimpleExoPlayerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShowController(boolean z) {
        boolean z2;
        if (!isPlayingAd() && this.useController) {
            if (this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean shouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z || z2 || shouldShowControllerIndefinitely) {
                showController(shouldShowControllerIndefinitely);
            }
        }
    }

    private boolean setArtworkFromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(width / height);
                }
                this.artworkView.setImageBitmap(bitmap);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entry).pictureData;
                return setArtworkFromBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private void showController(boolean z) {
        int i;
        if (!this.useController) {
            return;
        }
        PlaybackControlView playbackControlView = this.controller;
        if (z) {
            i = 0;
        } else {
            i = this.controllerShowTimeoutMs;
        }
        playbackControlView.setShowTimeoutMs(i);
        this.controller.show();
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        if (this.useController && this.controller.dispatchMediaKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.useController && this.player != null && motionEvent.getActionMasked() == 0) {
            if (!this.controller.isVisible()) {
                maybeShowController(true);
            } else if (this.controllerHideOnTouch) {
                this.controller.hide();
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.useController && this.player != null) {
            maybeShowController(true);
            return true;
        }
        return false;
    }

    public void setControlDispatcher(@Nullable ControlDispatcher controlDispatcher) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controller.setControlDispatcher(controlDispatcher);
    }

    public void setControllerAutoShow(boolean z) {
        this.controllerAutoShow = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        boolean z2;
        if (this.controller != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        this.controllerHideOnTouch = z;
    }

    public void setControllerShowTimeoutMs(int i) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controllerShowTimeoutMs = i;
    }

    public void setControllerVisibilityListener(PlaybackControlView.VisibilityListener visibilityListener) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controller.setVisibilityListener(visibilityListener);
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.defaultArtwork != bitmap) {
            this.defaultArtwork = bitmap;
            updateForCurrentTrackSelections();
        }
    }

    public void setFastForwardIncrementMs(int i) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controller.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controller.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        boolean z;
        if (this.contentFrame != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.contentFrame.setResizeMode(i);
    }

    public void setRewindIncrementMs(int i) {
        boolean z;
        if (this.controller != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.controller.setRewindIncrementMs(i);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        boolean z2;
        if (this.controller != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        this.controller.setShowMultiWindowTimeBar(z);
    }

    public void setShowShuffleButton(boolean z) {
        boolean z2;
        if (this.controller != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        this.controller.setShowShuffleButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view2 = this.shutterView;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        boolean z2;
        if (z && this.artworkView == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (this.useArtwork != z) {
            this.useArtwork = z;
            updateForCurrentTrackSelections();
        }
    }

    public void setUseController(boolean z) {
        boolean z2;
        if (z && this.controller == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (this.useController == z) {
            return;
        }
        this.useController = z;
        if (z) {
            this.controller.setPlayer(this.player);
            return;
        }
        PlaybackControlView playbackControlView = this.controller;
        if (playbackControlView != null) {
            playbackControlView.hide();
            this.controller.setPlayer(null);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view2 = this.surfaceView;
        if (view2 instanceof SurfaceView) {
            view2.setVisibility(i);
        }
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void configureEditModeLogo(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080632));
        imageView.setBackgroundColor(resources.getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06074b));
    }

    @TargetApi(23)
    public static void configureEditModeLogoV23(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080632, null));
        imageView.setBackgroundColor(resources.getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06074b, null));
    }

    public static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        boolean z7;
        View surfaceView;
        if (isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.surfaceView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.controller = null;
            this.componentListener = null;
            this.overlayFrameLayout = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                configureEditModeLogoV23(getResources(), imageView);
            } else {
                configureEditModeLogo(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i6 = com.baidu.tieba.R.layout.obfuscated_res_0x7f0d02c9;
        int i7 = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SimpleExoPlayerView, 0, 0);
            try {
                z3 = obtainStyledAttributes.hasValue(9);
                i3 = obtainStyledAttributes.getColor(9, 0);
                i6 = obtainStyledAttributes.getResourceId(5, com.baidu.tieba.R.layout.obfuscated_res_0x7f0d02c9);
                z4 = obtainStyledAttributes.getBoolean(11, true);
                i4 = obtainStyledAttributes.getResourceId(2, 0);
                z5 = obtainStyledAttributes.getBoolean(12, true);
                i5 = obtainStyledAttributes.getInt(10, 1);
                i2 = obtainStyledAttributes.getInt(6, 0);
                i7 = obtainStyledAttributes.getInt(8, 5000);
                z = obtainStyledAttributes.getBoolean(4, true);
                boolean z8 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                z2 = z8;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
            i2 = 0;
            z2 = true;
            i3 = 0;
            z3 = false;
            z4 = true;
            i4 = 0;
            z5 = true;
            i5 = 1;
        }
        LayoutInflater.from(context).inflate(i6, this);
        this.componentListener = new ComponentListener();
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a8a);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            setResizeModeRaw(aspectRatioFrameLayout, i2);
        }
        View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a99);
        this.shutterView = findViewById;
        if (findViewById != null && z3) {
            findViewById.setBackgroundColor(i3);
        }
        if (this.contentFrame != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                surfaceView = new TextureView(context);
            } else {
                surfaceView = new SurfaceView(context);
            }
            this.surfaceView = surfaceView;
            surfaceView.setLayoutParams(layoutParams);
            this.contentFrame.addView(this.surfaceView, 0);
        } else {
            this.surfaceView = null;
        }
        this.overlayFrameLayout = (FrameLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a90);
        ImageView imageView2 = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a89);
        this.artworkView = imageView2;
        if (z4 && imageView2 != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.useArtwork = z6;
        if (i4 != 0) {
            this.defaultArtwork = BitmapFactory.decodeResource(context.getResources(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a9a);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            this.subtitleView.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a8b);
        View findViewById2 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a8c);
        if (playbackControlView != null) {
            this.controller = playbackControlView;
        } else if (findViewById2 != null) {
            PlaybackControlView playbackControlView2 = new PlaybackControlView(context, null, 0, attributeSet);
            this.controller = playbackControlView2;
            playbackControlView2.setLayoutParams(findViewById2.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById2.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById2);
            viewGroup.removeView(findViewById2);
            viewGroup.addView(this.controller, indexOfChild);
        } else {
            this.controller = null;
        }
        this.controllerShowTimeoutMs = this.controller == null ? 0 : i7;
        this.controllerHideOnTouch = z;
        this.controllerAutoShow = z2;
        if (z5 && this.controller != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.useController = z7;
        hideController();
    }

    private void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.artworkView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayingAd() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null && simpleExoPlayer.isPlayingAd() && this.player.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    private boolean shouldShowControllerIndefinitely() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return true;
        }
        int playbackState = simpleExoPlayer.getPlaybackState();
        if (this.controllerAutoShow && (playbackState == 1 || playbackState == 4 || !this.player.getPlayWhenReady())) {
            return true;
        }
        return false;
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public Bitmap getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public SimpleExoPlayer getPlayer() {
        return this.player;
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public boolean getUseController() {
        return this.useController;
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public void hideController() {
        PlaybackControlView playbackControlView = this.controller;
        if (playbackControlView != null) {
            playbackControlView.hide();
        }
    }

    public void showController() {
        showController(shouldShowControllerIndefinitely());
    }

    public static void switchTargetView(@NonNull SimpleExoPlayer simpleExoPlayer, @Nullable SimpleExoPlayerView simpleExoPlayerView, @Nullable SimpleExoPlayerView simpleExoPlayerView2) {
        if (simpleExoPlayerView == simpleExoPlayerView2) {
            return;
        }
        if (simpleExoPlayerView2 != null) {
            simpleExoPlayerView2.setPlayer(simpleExoPlayer);
        }
        if (simpleExoPlayerView != null) {
            simpleExoPlayerView.setPlayer(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForCurrentTrackSelections() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        TrackSelectionArray currentTrackSelections = simpleExoPlayer.getCurrentTrackSelections();
        for (int i = 0; i < currentTrackSelections.length; i++) {
            if (this.player.getRendererType(i) == 2 && currentTrackSelections.get(i) != null) {
                hideArtwork();
                return;
            }
        }
        View view2 = this.shutterView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (this.useArtwork) {
            for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                TrackSelection trackSelection = currentTrackSelections.get(i2);
                if (trackSelection != null) {
                    for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                        Metadata metadata = trackSelection.getFormat(i3).metadata;
                        if (metadata != null && setArtworkFromMetadata(metadata)) {
                            return;
                        }
                    }
                    continue;
                }
            }
            if (setArtworkFromBitmap(this.defaultArtwork)) {
                return;
            }
        }
        hideArtwork();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null && simpleExoPlayer.isPlayingAd()) {
            this.overlayFrameLayout.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        if (isDpadKey(keyEvent.getKeyCode()) && this.useController && !this.controller.isVisible()) {
            z = true;
        } else {
            z = false;
        }
        maybeShowController(true);
        if (!z && !dispatchMediaKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == simpleExoPlayer) {
            return;
        }
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.removeListener(this.componentListener);
            this.player.removeTextOutput(this.componentListener);
            this.player.removeVideoListener(this.componentListener);
            View view2 = this.surfaceView;
            if (view2 instanceof TextureView) {
                this.player.clearVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                this.player.clearVideoSurfaceView((SurfaceView) view2);
            }
        }
        this.player = simpleExoPlayer;
        if (this.useController) {
            this.controller.setPlayer(simpleExoPlayer);
        }
        View view3 = this.shutterView;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        if (simpleExoPlayer != null) {
            View view4 = this.surfaceView;
            if (view4 instanceof TextureView) {
                simpleExoPlayer.setVideoTextureView((TextureView) view4);
            } else if (view4 instanceof SurfaceView) {
                simpleExoPlayer.setVideoSurfaceView((SurfaceView) view4);
            }
            simpleExoPlayer.addVideoListener(this.componentListener);
            simpleExoPlayer.addTextOutput(this.componentListener);
            simpleExoPlayer.addListener(this.componentListener);
            maybeShowController(false);
            updateForCurrentTrackSelections();
            return;
        }
        hideController();
        hideArtwork();
    }
}
