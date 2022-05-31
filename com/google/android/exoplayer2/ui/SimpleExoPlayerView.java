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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SURFACE_TYPE_NONE = 0;
    public static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    public static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* renamed from: com.google.android.exoplayer2.ui.SimpleExoPlayerView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class ComponentListener extends Player.DefaultEventListener implements TextOutput, SimpleExoPlayer.VideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleExoPlayerView this$0;

        public ComponentListener(SimpleExoPlayerView simpleExoPlayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleExoPlayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = simpleExoPlayerView;
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || this.this$0.subtitleView == null) {
                return;
            }
            this.this$0.subtitleView.onCues(list);
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (!this.this$0.isPlayingAd()) {
                    this.this$0.maybeShowController(false);
                } else {
                    this.this$0.hideController();
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.this$0.isPlayingAd()) {
                this.this$0.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.this$0.shutterView == null) {
                return;
            }
            this.this$0.shutterView.setVisibility(4);
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, trackGroupArray, trackSelectionArray) == null) {
                this.this$0.updateForCurrentTrackSelections();
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)}) == null) || this.this$0.contentFrame == null) {
                return;
            }
            this.this$0.contentFrame.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
        }

        public /* synthetic */ ComponentListener(SimpleExoPlayerView simpleExoPlayerView, AnonymousClass1 anonymousClass1) {
            this(simpleExoPlayerView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleExoPlayerView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void configureEditModeLogo(Resources resources, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, resources, imageView) == null) {
            imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804df));
            imageView.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060716));
        }
    }

    @TargetApi(23)
    public static void configureEditModeLogoV23(Resources resources, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, resources, imageView) == null) {
            imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804df, null));
            imageView.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060716, null));
        }
    }

    private void hideArtwork() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (imageView = this.artworkView) == null) {
            return;
        }
        imageView.setImageResource(17170445);
        this.artworkView.setVisibility(4);
    }

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) ? i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23 : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayingAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            return simpleExoPlayer != null && simpleExoPlayer.isPlayingAd() && this.player.getPlayWhenReady();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShowController(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, this, z) == null) && !isPlayingAd() && this.useController) {
            boolean z2 = this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0;
            boolean shouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z || z2 || shouldShowControllerIndefinitely) {
                showController(shouldShowControllerIndefinitely);
            }
        }
    }

    private boolean setArtworkFromBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, bitmap)) == null) {
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
        return invokeL.booleanValue;
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, metadata)) == null) {
            for (int i = 0; i < metadata.length(); i++) {
                Metadata.Entry entry = metadata.get(i);
                if (entry instanceof ApicFrame) {
                    byte[] bArr = ((ApicFrame) entry).pictureData;
                    return setArtworkFromBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, aspectRatioFrameLayout, i) == null) {
            aspectRatioFrameLayout.setResizeMode(i);
        }
    }

    private boolean shouldShowControllerIndefinitely() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer == null) {
                return true;
            }
            int playbackState = simpleExoPlayer.getPlaybackState();
            return this.controllerAutoShow && (playbackState == 1 || playbackState == 4 || !this.player.getPlayWhenReady());
        }
        return invokeV.booleanValue;
    }

    public static void switchTargetView(@NonNull SimpleExoPlayer simpleExoPlayer, @Nullable SimpleExoPlayerView simpleExoPlayerView, @Nullable SimpleExoPlayerView simpleExoPlayerView2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65556, null, simpleExoPlayer, simpleExoPlayerView, simpleExoPlayerView2) == null) || simpleExoPlayerView == simpleExoPlayerView2) {
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
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (simpleExoPlayer = this.player) == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null && simpleExoPlayer.isPlayingAd()) {
                this.overlayFrameLayout.requestFocus();
                return super.dispatchKeyEvent(keyEvent);
            }
            boolean z = isDpadKey(keyEvent.getKeyCode()) && this.useController && !this.controller.isVisible();
            maybeShowController(true);
            return z || dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) ? this.useController && this.controller.dispatchMediaKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean getControllerAutoShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.controllerAutoShow : invokeV.booleanValue;
    }

    public boolean getControllerHideOnTouch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.controllerHideOnTouch : invokeV.booleanValue;
    }

    public int getControllerShowTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.controllerShowTimeoutMs : invokeV.intValue;
    }

    public Bitmap getDefaultArtwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.defaultArtwork : (Bitmap) invokeV.objValue;
    }

    public FrameLayout getOverlayFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.overlayFrameLayout : (FrameLayout) invokeV.objValue;
    }

    public SimpleExoPlayer getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.player : (SimpleExoPlayer) invokeV.objValue;
    }

    public SubtitleView getSubtitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.subtitleView : (SubtitleView) invokeV.objValue;
    }

    public boolean getUseArtwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.useArtwork : invokeV.booleanValue;
    }

    public boolean getUseController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.useController : invokeV.booleanValue;
    }

    public View getVideoSurfaceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.surfaceView : (View) invokeV.objValue;
    }

    public void hideController() {
        PlaybackControlView playbackControlView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (playbackControlView = this.controller) == null) {
            return;
        }
        playbackControlView.hide();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (!this.useController || this.player == null) {
                return false;
            }
            maybeShowController(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setControlDispatcher(@Nullable ControlDispatcher controlDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, controlDispatcher) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setControlDispatcher(controlDispatcher);
        }
    }

    public void setControllerAutoShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.controllerAutoShow = z;
        }
    }

    public void setControllerHideOnTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            Assertions.checkState(this.controller != null);
            this.controllerHideOnTouch = z;
        }
    }

    public void setControllerShowTimeoutMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            Assertions.checkState(this.controller != null);
            this.controllerShowTimeoutMs = i;
        }
    }

    public void setControllerVisibilityListener(PlaybackControlView.VisibilityListener visibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, visibilityListener) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setVisibilityListener(visibilityListener);
        }
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bitmap) == null) || this.defaultArtwork == bitmap) {
            return;
        }
        this.defaultArtwork = bitmap;
        updateForCurrentTrackSelections();
    }

    public void setFastForwardIncrementMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setFastForwardIncrementMs(i);
        }
    }

    public void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        SimpleExoPlayer simpleExoPlayer2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, simpleExoPlayer) == null) || (simpleExoPlayer2 = this.player) == simpleExoPlayer) {
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

    public void setRepeatToggleModes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setRepeatToggleModes(i);
        }
    }

    public void setResizeMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            Assertions.checkState(this.contentFrame != null);
            this.contentFrame.setResizeMode(i);
        }
    }

    public void setRewindIncrementMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setRewindIncrementMs(i);
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setShowMultiWindowTimeBar(z);
        }
    }

    public void setShowShuffleButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            Assertions.checkState(this.controller != null);
            this.controller.setShowShuffleButton(z);
        }
    }

    public void setShutterBackgroundColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || (view2 = this.shutterView) == null) {
            return;
        }
        view2.setBackgroundColor(i);
    }

    public void setUseArtwork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            Assertions.checkState((z && this.artworkView == null) ? false : true);
            if (this.useArtwork != z) {
                this.useArtwork = z;
                updateForCurrentTrackSelections();
            }
        }
    }

    public void setUseController(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            Assertions.checkState((z && this.controller == null) ? false : true);
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
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            super.setVisibility(i);
            View view2 = this.surfaceView;
            if (view2 instanceof SurfaceView) {
                view2.setVisibility(i);
            }
        }
    }

    public void showController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            showController(shouldShowControllerIndefinitely());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void showController(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65555, this, z) == null) && this.useController) {
            this.controller.setShowTimeoutMs(z ? 0 : this.controllerShowTimeoutMs);
            this.controller.show();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        int i8 = R.layout.obfuscated_res_0x7f0d0278;
        int i9 = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400a5, R.attr.obfuscated_res_0x7f04018a, R.attr.obfuscated_res_0x7f0401e8, R.attr.obfuscated_res_0x7f04028a, R.attr.obfuscated_res_0x7f0402cb, R.attr.obfuscated_res_0x7f0404dd, R.attr.obfuscated_res_0x7f04053a, R.attr.obfuscated_res_0x7f04053d, R.attr.obfuscated_res_0x7f04059e, R.attr.obfuscated_res_0x7f0405a1, R.attr.obfuscated_res_0x7f0405e2, R.attr.obfuscated_res_0x7f0406b8, R.attr.obfuscated_res_0x7f0406b9}, 0, 0);
            try {
                z3 = obtainStyledAttributes.hasValue(9);
                i3 = obtainStyledAttributes.getColor(9, 0);
                i8 = obtainStyledAttributes.getResourceId(5, R.layout.obfuscated_res_0x7f0d0278);
                z4 = obtainStyledAttributes.getBoolean(11, true);
                i4 = obtainStyledAttributes.getResourceId(2, 0);
                z5 = obtainStyledAttributes.getBoolean(12, true);
                i5 = obtainStyledAttributes.getInt(10, 1);
                i2 = obtainStyledAttributes.getInt(6, 0);
                i9 = obtainStyledAttributes.getInt(8, 5000);
                z = obtainStyledAttributes.getBoolean(4, true);
                boolean z6 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                z2 = z6;
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
        LayoutInflater.from(context).inflate(i8, this);
        this.componentListener = new ComponentListener(this, null);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f090903);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            setResizeModeRaw(aspectRatioFrameLayout, i2);
        }
        View findViewById = findViewById(R.id.obfuscated_res_0x7f090912);
        this.shutterView = findViewById;
        if (findViewById != null && z3) {
            findViewById.setBackgroundColor(i3);
        }
        if (this.contentFrame != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            View textureView = i5 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.surfaceView = textureView;
            textureView.setLayoutParams(layoutParams);
            this.contentFrame.addView(this.surfaceView, 0);
        } else {
            this.surfaceView = null;
        }
        this.overlayFrameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090909);
        ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f090902);
        this.artworkView = imageView2;
        this.useArtwork = z4 && imageView2 != null;
        if (i4 != 0) {
            this.defaultArtwork = BitmapFactory.decodeResource(context.getResources(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.obfuscated_res_0x7f090913);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            this.subtitleView.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(R.id.obfuscated_res_0x7f090904);
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090905);
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
        this.controllerShowTimeoutMs = this.controller == null ? 0 : i9;
        this.controllerHideOnTouch = z;
        this.controllerAutoShow = z2;
        this.useController = z5 && this.controller != null;
        hideController();
    }
}
