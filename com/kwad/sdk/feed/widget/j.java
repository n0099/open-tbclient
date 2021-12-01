package com.kwad.sdk.feed.widget;

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
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f58555e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f58556f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f58557g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58558h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58559i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
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
        this.f58556f = new bc(this);
        this.f58557g = new AtomicBoolean(true);
        this.f58559i = true;
        this.f58555e = this;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f58557g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewAttached");
            this.f58556f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && !this.a && message.what == 1) {
            if (!bb.a(this.f58555e, 30)) {
                g();
            } else if (!this.f58558h) {
                f();
            }
            this.f58556f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58557g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewDetached");
        this.f58556f.removeCallbacksAndMessages(null);
        if (this.f58559i) {
            h();
        } else {
            this.f57888d.c();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57888d.c();
            this.f58558h = true;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
            this.f58558h = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onAttachedToWindow");
            q();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onDetachedFromWindow");
            m();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onFinishTemporaryDetach");
            q();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onStartTemporaryDetach");
            m();
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f58558h = false;
        }
    }

    public void setAutoRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f58559i = z;
        }
    }
}
