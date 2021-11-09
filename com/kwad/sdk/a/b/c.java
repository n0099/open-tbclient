package com.kwad.sdk.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.d;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.core.video.videoview.a implements aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f63889b;

    /* renamed from: c  reason: collision with root package name */
    public final aw f63890c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f63891d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63892e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AdTemplate adTemplate, @NonNull d dVar) {
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
                super((Context) objArr2[0], (AdTemplate) objArr2[1], (d) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63890c = new aw(this);
        this.f63891d = new AtomicBoolean(true);
        this.f63892e = false;
        this.f63889b = this;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f63891d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewAttached");
            this.f63890c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && !this.f63892e && message.what == 1) {
            if (av.a(this.f63889b, 30)) {
                e();
            } else {
                f();
            }
            this.f63890c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f63892e = true;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f63891d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewDetached");
        this.f63890c.removeCallbacksAndMessages(null);
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onAttachedToWindow");
            m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onDetachedFromWindow");
            l();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
            m();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onStartTemporaryDetach");
            l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
        }
    }
}
