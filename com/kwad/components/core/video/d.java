package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.core.video.a implements bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public boolean Kw;
    public boolean zA;

    /* loaded from: classes8.dex */
    public interface a extends a.b {
        void onVideoPlayError(int i, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, cVar};
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
        this.zA = false;
        this.Kw = false;
        this.Kr = this;
    }

    private void am() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onViewAttached");
            this.Ks.sendEmptyMessage(1);
        }
    }

    private void an() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onViewDetached");
        this.Ks.removeCallbacksAndMessages(null);
        release();
    }

    private void pf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.zA = false;
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && !this.zA && message.what == 1) {
            if (com.kwad.sdk.b.kwai.a.g(this.Kr, 70)) {
                oO();
            } else {
                oQ();
            }
            this.Ks.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void er() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.Kw) {
            super.er();
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void oI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.oI();
            ImageView imageView = this.jQ;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080c9d);
            }
            TextView textView = this.jR;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onAttachedToWindow");
            pf();
            am();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
            an();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
            am();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
            an();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            this.zA = true;
        }
    }
}
