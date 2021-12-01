package com.kwad.sdk.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.core.video.videoview.a implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f58241e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f58242f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f58243g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58244h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdTemplate) objArr2[1], (com.kwad.sdk.core.video.videoview.d) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58242f = new bc(this);
        this.f58243g = new AtomicBoolean(true);
        this.f58244h = false;
        this.f58241e = this;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f58244h = false;
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f58243g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewAttached");
            this.f58242f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ImageView imageView = ((com.kwad.sdk.core.video.videoview.a) this).f57866b;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
            }
            TextView textView = ((com.kwad.sdk.core.video.videoview.a) this).f57867c;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && !this.f58244h && message.what == 1) {
            if (bb.a(this.f58241e, 30)) {
                f();
            } else {
                g();
            }
            this.f58242f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.h();
            this.f58244h = true;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f58243g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewDetached");
        this.f58242f.removeCallbacksAndMessages(null);
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onAttachedToWindow");
            n();
            o();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onDetachedFromWindow");
            m();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
            o();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onStartTemporaryDetach");
            m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
        }
    }
}
