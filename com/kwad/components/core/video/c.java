package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class c extends a implements bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public boolean Ku;
    public boolean Kv;
    public final KsAdVideoPlayConfig cN;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
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
        this.Ks = new bg(this);
        this.Kt = new AtomicBoolean(true);
        this.Kv = true;
        this.Kr = this;
        this.cN = ksAdVideoPlayConfig;
    }

    private void am() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onViewAttached");
            this.Ks.sendEmptyMessage(1);
        }
    }

    private void an() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onViewDetached");
        this.Ks.removeCallbacksAndMessages(null);
        if (this.Kv) {
            release();
        } else {
            this.aef.pause();
        }
    }

    private boolean pb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return ae.isNetworkConnected(this.mContext);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ae.isWifiConnected(this.mContext);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? ae.isNetworkConnected(this.mContext) : ae.isWifiConnected(this.mContext);
                }
            }
            if (com.kwad.sdk.core.response.a.a.bi(this.mAdInfo)) {
                return ae.isNetworkConnected(this.mContext);
            }
            if (com.kwad.sdk.core.response.a.a.bj(this.mAdInfo)) {
                return ae.isWifiConnected(this.mContext);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && !this.Jm && message.what == 1) {
            if (!com.kwad.sdk.b.kwai.a.g(this.Kr, 30)) {
                oQ();
            } else if (!this.Ku) {
                oO();
            }
            this.Ks.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void oO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.aef.isIdle()) {
                if (this.aef.isPaused() || this.aef.vE()) {
                    oP();
                    this.aef.restart();
                }
            } else if (!ae.isNetworkConnected(this.mContext)) {
                oK();
            } else {
                oL();
                if (!this.Jm && !pb() && !this.Jk) {
                    oM();
                    return;
                }
                oP();
                this.aef.start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onAttachedToWindow");
            am();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onDetachedFromWindow");
            an();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
            am();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onStartTemporaryDetach");
            an();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    public final void pc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.aef.pause();
            this.Ku = true;
        }
    }

    public final void pd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            oO();
            this.Ku = false;
        }
    }

    public final void pe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.Ku = false;
        }
    }

    public final void setAutoRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.Kv = z;
        }
    }
}
