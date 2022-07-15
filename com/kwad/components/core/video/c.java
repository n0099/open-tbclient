package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class c extends a implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public final bc j;
    public final AtomicBoolean k;
    public boolean l;
    public boolean m;
    public final KsAdVideoPlayConfig n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, cVar, ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdTemplate) objArr2[1], (com.kwad.sdk.core.video.videoview.c) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new bc(this);
        this.k = new AtomicBoolean(true);
        this.m = true;
        this.i = this;
        this.n = ksAdVideoPlayConfig;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.k.getAndSet(false)) {
            com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onViewAttached");
            this.j.sendEmptyMessage(1);
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.k.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onViewDetached");
        this.j.removeCallbacksAndMessages(null);
        if (this.m) {
            j();
        } else {
            this.h.c();
        }
    }

    private boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.n;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return ac.b(((a) this).a);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ac.c(((a) this).a);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? ac.b(((a) this).a) : ac.c(((a) this).a);
                }
            }
            if (com.kwad.sdk.core.response.a.a.az(this.c)) {
                return ac.b(((a) this).a);
            }
            if (com.kwad.sdk.core.response.a.a.aA(this.c)) {
                return ac.c(((a) this).a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.utils.bc.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && !this.e && message.what == 1) {
            if (!com.kwad.sdk.b.kwai.a.a(this.i, 30)) {
                i();
            } else if (!this.l) {
                g();
            }
            this.j.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.h.d()) {
                if (this.h.g() || this.h.e()) {
                    h();
                    this.h.b();
                }
            } else if (!ac.b(((a) this).a)) {
                c();
            } else {
                d();
                if (!this.e && !t() && !this.d) {
                    f();
                    return;
                }
                h();
                this.h.a();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h.c();
            this.l = true;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            this.l = false;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onAttachedToWindow");
            r();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onDetachedFromWindow");
            s();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onFinishTemporaryDetach");
            r();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.b.c("FeedVideoPlayerController", "onStartTemporaryDetach");
            s();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    public final void setAutoRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }
}
