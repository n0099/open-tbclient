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
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements aw.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f65751b;

    /* renamed from: c  reason: collision with root package name */
    public final aw f65752c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f65753d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65754e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65755f;

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
        this.f65752c = new aw(this);
        this.f65753d = new AtomicBoolean(true);
        this.f65755f = true;
        this.f65751b = this;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f65753d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewAttached");
            this.f65752c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.aw.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
            if (!av.a(this.f65751b, 30)) {
                f();
            } else if (!this.f65754e) {
                e();
            }
            this.f65752c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f65753d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewDetached");
        this.f65752c.removeCallbacksAndMessages(null);
        if (this.f65755f) {
            g();
        } else {
            this.f65128a.c();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65128a.c();
            this.f65754e = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            this.f65754e = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f65754e = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onAttachedToWindow");
            p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onDetachedFromWindow");
            l();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onFinishTemporaryDetach");
            p();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onStartTemporaryDetach");
            l();
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

    public void setAutoRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f65755f = z;
        }
    }
}
