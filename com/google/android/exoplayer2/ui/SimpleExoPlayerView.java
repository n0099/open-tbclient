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
import b.i.b.a.c;
import b.i.b.a.d0.t;
import b.i.b.a.e0.j;
import b.i.b.a.f0.f;
import b.i.b.a.f0.g;
import b.i.b.a.g0.d;
import b.i.b.a.q;
import b.i.b.a.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import java.util.List;
@TargetApi(16)
/* loaded from: classes11.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final AspectRatioFrameLayout f63037e;

    /* renamed from: f  reason: collision with root package name */
    public final View f63038f;

    /* renamed from: g  reason: collision with root package name */
    public final View f63039g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f63040h;

    /* renamed from: i  reason: collision with root package name */
    public final SubtitleView f63041i;
    public final PlaybackControlView j;
    public final b k;
    public final FrameLayout l;
    public v m;
    public boolean n;
    public boolean o;
    public Bitmap p;
    public int q;
    public boolean r;
    public boolean s;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public final class b extends q.a implements j, v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SimpleExoPlayerView f63042e;

        public b(SimpleExoPlayerView simpleExoPlayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleExoPlayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63042e = simpleExoPlayerView;
        }

        @Override // b.i.b.a.v.c
        public void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63042e.f63038f == null) {
                return;
            }
            this.f63042e.f63038f.setVisibility(4);
        }

        @Override // b.i.b.a.q.a, b.i.b.a.q.b
        public void i(t tVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar, gVar) == null) {
                this.f63042e.r();
            }
        }

        @Override // b.i.b.a.q.a, b.i.b.a.q.b
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f63042e.k()) {
                this.f63042e.hideController();
            }
        }

        @Override // b.i.b.a.q.b
        public void l(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (!this.f63042e.k()) {
                    this.f63042e.l(false);
                } else {
                    this.f63042e.hideController();
                }
            }
        }

        @Override // b.i.b.a.e0.j
        public void onCues(List<b.i.b.a.e0.b> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || this.f63042e.f63041i == null) {
                return;
            }
            this.f63042e.f63041i.onCues(list);
        }

        @Override // b.i.b.a.v.c
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f63042e.f63037e == null) {
                return;
            }
            this.f63042e.f63037e.setAspectRatio(i3 == 0 ? 1.0f : (i2 * f2) / i3);
        }

        public /* synthetic */ b(SimpleExoPlayerView simpleExoPlayerView, a aVar) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void g(Resources resources, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, resources, imageView) == null) {
            imageView.setImageDrawable(resources.getDrawable(b.i.b.a.g0.b.exo_edit_mode_logo));
            imageView.setBackgroundColor(resources.getColor(b.i.b.a.g0.a.exo_edit_mode_background_color));
        }
    }

    @TargetApi(23)
    public static void h(Resources resources, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, resources, imageView) == null) {
            imageView.setImageDrawable(resources.getDrawable(b.i.b.a.g0.b.exo_edit_mode_logo, null));
            imageView.setBackgroundColor(resources.getColor(b.i.b.a.g0.a.exo_edit_mode_background_color, null));
        }
    }

    public static void o(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, aspectRatioFrameLayout, i2) == null) {
            aspectRatioFrameLayout.setResizeMode(i2);
        }
    }

    public static void switchTargetView(@NonNull v vVar, @Nullable SimpleExoPlayerView simpleExoPlayerView, @Nullable SimpleExoPlayerView simpleExoPlayerView2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, vVar, simpleExoPlayerView, simpleExoPlayerView2) == null) || simpleExoPlayerView == simpleExoPlayerView2) {
            return;
        }
        if (simpleExoPlayerView2 != null) {
            simpleExoPlayerView2.setPlayer(vVar);
        }
        if (simpleExoPlayerView != null) {
            simpleExoPlayerView.setPlayer(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            v vVar = this.m;
            if (vVar != null && vVar.e()) {
                this.l.requestFocus();
                return super.dispatchKeyEvent(keyEvent);
            }
            boolean z = j(keyEvent.getKeyCode()) && this.n && !this.j.isVisible();
            l(true);
            return z || dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) ? this.n && this.j.dispatchMediaKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean getControllerAutoShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean getControllerHideOnTouch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public int getControllerShowTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : invokeV.intValue;
    }

    public Bitmap getDefaultArtwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (Bitmap) invokeV.objValue;
    }

    public FrameLayout getOverlayFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (FrameLayout) invokeV.objValue;
    }

    public v getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (v) invokeV.objValue;
    }

    public SubtitleView getSubtitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63041i : (SubtitleView) invokeV.objValue;
    }

    public boolean getUseArtwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean getUseController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public View getVideoSurfaceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f63039g : (View) invokeV.objValue;
    }

    public void hideController() {
        PlaybackControlView playbackControlView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (playbackControlView = this.j) == null) {
            return;
        }
        playbackControlView.hide();
    }

    public final void i() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (imageView = this.f63040h) == null) {
            return;
        }
        imageView.setImageResource(17170445);
        this.f63040h.setVisibility(4);
    }

    @SuppressLint({"InlinedApi"})
    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23 : invokeI.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            v vVar = this.m;
            return vVar != null && vVar.e() && this.m.g();
        }
        return invokeV.booleanValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && !k() && this.n) {
            boolean z2 = this.j.isVisible() && this.j.getShowTimeoutMs() <= 0;
            boolean p = p();
            if (z || z2 || p) {
                q(p);
            }
        }
    }

    public final boolean m(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bitmap)) == null) {
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width > 0 && height > 0) {
                    AspectRatioFrameLayout aspectRatioFrameLayout = this.f63037e;
                    if (aspectRatioFrameLayout != null) {
                        aspectRatioFrameLayout.setAspectRatio(width / height);
                    }
                    this.f63040h.setImageBitmap(bitmap);
                    this.f63040h.setVisibility(0);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(Metadata metadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, metadata)) == null) {
            for (int i2 = 0; i2 < metadata.length(); i2++) {
                Metadata.Entry entry = metadata.get(i2);
                if (entry instanceof ApicFrame) {
                    byte[] bArr = ((ApicFrame) entry).pictureData;
                    return m(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            if (this.n && this.m != null && motionEvent.getActionMasked() == 0) {
                if (!this.j.isVisible()) {
                    l(true);
                } else if (this.s) {
                    this.j.hide();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            if (!this.n || this.m == null) {
                return false;
            }
            l(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            v vVar = this.m;
            if (vVar == null) {
                return true;
            }
            int playbackState = vVar.getPlaybackState();
            return this.r && (playbackState == 1 || playbackState == 4 || !this.m.g());
        }
        return invokeV.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && this.n) {
            this.j.setShowTimeoutMs(z ? 0 : this.q);
            this.j.show();
        }
    }

    public final void r() {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (vVar = this.m) == null) {
            return;
        }
        g n = vVar.n();
        for (int i2 = 0; i2 < n.f32499a; i2++) {
            if (this.m.o(i2) == 2 && n.a(i2) != null) {
                i();
                return;
            }
        }
        View view = this.f63038f;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.o) {
            for (int i3 = 0; i3 < n.f32499a; i3++) {
                f a2 = n.a(i3);
                if (a2 != null) {
                    for (int i4 = 0; i4 < a2.length(); i4++) {
                        Metadata metadata = a2.h(i4).metadata;
                        if (metadata != null && n(metadata)) {
                            return;
                        }
                    }
                    continue;
                }
            }
            if (m(this.p)) {
                return;
            }
        }
        i();
    }

    public void setControlDispatcher(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setControlDispatcher(cVar);
        }
    }

    public void setControllerAutoShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.r = z;
        }
    }

    public void setControllerHideOnTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.s = z;
        }
    }

    public void setControllerShowTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.q = i2;
        }
    }

    public void setControllerVisibilityListener(PlaybackControlView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setVisibilityListener(fVar);
        }
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bitmap) == null) || this.p == bitmap) {
            return;
        }
        this.p = bitmap;
        r();
    }

    public void setFastForwardIncrementMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setFastForwardIncrementMs(i2);
        }
    }

    public void setPlayer(v vVar) {
        v vVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, vVar) == null) || (vVar2 = this.m) == vVar) {
            return;
        }
        if (vVar2 != null) {
            vVar2.f(this.k);
            this.m.Q(this.k);
            this.m.R(this.k);
            View view = this.f63039g;
            if (view instanceof TextureView) {
                this.m.M((TextureView) view);
            } else if (view instanceof SurfaceView) {
                this.m.L((SurfaceView) view);
            }
        }
        this.m = vVar;
        if (this.n) {
            this.j.setPlayer(vVar);
        }
        View view2 = this.f63038f;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (vVar != null) {
            View view3 = this.f63039g;
            if (view3 instanceof TextureView) {
                vVar.W((TextureView) view3);
            } else if (view3 instanceof SurfaceView) {
                vVar.V((SurfaceView) view3);
            }
            vVar.J(this.k);
            vVar.I(this.k);
            vVar.i(this.k);
            l(false);
            r();
            return;
        }
        hideController();
        i();
    }

    public void setRepeatToggleModes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setRepeatToggleModes(i2);
        }
    }

    public void setResizeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            b.i.b.a.i0.a.f(this.f63037e != null);
            this.f63037e.setResizeMode(i2);
        }
    }

    public void setRewindIncrementMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setRewindIncrementMs(i2);
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setShowMultiWindowTimeBar(z);
        }
    }

    public void setShowShuffleButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            b.i.b.a.i0.a.f(this.j != null);
            this.j.setShowShuffleButton(z);
        }
    }

    public void setShutterBackgroundColor(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i2) == null) || (view = this.f63038f) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setUseArtwork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            b.i.b.a.i0.a.f((z && this.f63040h == null) ? false : true);
            if (this.o != z) {
                this.o = z;
                r();
            }
        }
    }

    public void setUseController(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            b.i.b.a.i0.a.f((z && this.j == null) ? false : true);
            if (this.n == z) {
                return;
            }
            this.n = z;
            if (z) {
                this.j.setPlayer(this.m);
                return;
            }
            PlaybackControlView playbackControlView = this.j;
            if (playbackControlView != null) {
                playbackControlView.hide();
                this.j.setPlayer(null);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            super.setVisibility(i2);
            View view = this.f63039g;
            if (view instanceof SurfaceView) {
                view.setVisibility(i2);
            }
        }
    }

    public void showController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            q(p());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (isInEditMode()) {
            this.f63037e = null;
            this.f63038f = null;
            this.f63039g = null;
            this.f63040h = null;
            this.f63041i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            ImageView imageView = new ImageView(context);
            if (b.i.b.a.i0.v.f32661a >= 23) {
                h(getResources(), imageView);
            } else {
                g(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i9 = d.exo_simple_player_view;
        int i10 = 5000;
        boolean z6 = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.i.b.a.g0.f.SimpleExoPlayerView, 0, 0);
            try {
                z3 = obtainStyledAttributes.hasValue(b.i.b.a.g0.f.SimpleExoPlayerView_shutter_background_color);
                i3 = obtainStyledAttributes.getColor(b.i.b.a.g0.f.SimpleExoPlayerView_shutter_background_color, 0);
                i9 = obtainStyledAttributes.getResourceId(b.i.b.a.g0.f.SimpleExoPlayerView_player_layout_id, i9);
                z4 = obtainStyledAttributes.getBoolean(b.i.b.a.g0.f.SimpleExoPlayerView_use_artwork, true);
                i4 = obtainStyledAttributes.getResourceId(b.i.b.a.g0.f.SimpleExoPlayerView_default_artwork, 0);
                z5 = obtainStyledAttributes.getBoolean(b.i.b.a.g0.f.SimpleExoPlayerView_use_controller, true);
                i5 = obtainStyledAttributes.getInt(b.i.b.a.g0.f.SimpleExoPlayerView_surface_type, 1);
                i6 = obtainStyledAttributes.getInt(b.i.b.a.g0.f.SimpleExoPlayerView_resize_mode, 0);
                i10 = obtainStyledAttributes.getInt(b.i.b.a.g0.f.SimpleExoPlayerView_show_timeout, 5000);
                z2 = obtainStyledAttributes.getBoolean(b.i.b.a.g0.f.SimpleExoPlayerView_hide_on_touch, true);
                z = obtainStyledAttributes.getBoolean(b.i.b.a.g0.f.SimpleExoPlayerView_auto_show, true);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            z = true;
            z2 = true;
            z3 = false;
            i3 = 0;
            z4 = true;
            i4 = 0;
            z5 = true;
            i5 = 1;
            i6 = 0;
        }
        LayoutInflater.from(context).inflate(i9, this);
        this.k = new b(this, null);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(b.i.b.a.g0.c.exo_content_frame);
        this.f63037e = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            o(aspectRatioFrameLayout, i6);
        }
        View findViewById = findViewById(b.i.b.a.g0.c.exo_shutter);
        this.f63038f = findViewById;
        if (findViewById != null && z3) {
            findViewById.setBackgroundColor(i3);
        }
        if (this.f63037e != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            View textureView = i5 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.f63039g = textureView;
            textureView.setLayoutParams(layoutParams);
            this.f63037e.addView(this.f63039g, 0);
        } else {
            this.f63039g = null;
        }
        this.l = (FrameLayout) findViewById(b.i.b.a.g0.c.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(b.i.b.a.g0.c.exo_artwork);
        this.f63040h = imageView2;
        this.o = z4 && imageView2 != null;
        if (i4 != 0) {
            this.p = BitmapFactory.decodeResource(context.getResources(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(b.i.b.a.g0.c.exo_subtitles);
        this.f63041i = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            this.f63041i.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(b.i.b.a.g0.c.exo_controller);
        View findViewById2 = findViewById(b.i.b.a.g0.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.j = playbackControlView;
        } else if (findViewById2 != null) {
            PlaybackControlView playbackControlView2 = new PlaybackControlView(context, null, 0, attributeSet);
            this.j = playbackControlView2;
            playbackControlView2.setLayoutParams(findViewById2.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById2.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById2);
            viewGroup.removeView(findViewById2);
            viewGroup.addView(this.j, indexOfChild);
        } else {
            this.j = null;
        }
        this.q = this.j == null ? 0 : i10;
        this.s = z2;
        this.r = z;
        this.n = (!z5 || this.j == null) ? false : false;
        hideController();
    }
}
