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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class d extends a implements bc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public final bc j;
    public final AtomicBoolean k;
    public boolean l;
    public boolean m;

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
        this.j = new bc(this);
        this.k = new AtomicBoolean(true);
        this.l = false;
        this.m = false;
        this.i = this;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.l = false;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.k.getAndSet(false)) {
            com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onViewAttached");
            this.j.sendEmptyMessage(1);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.k.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onViewDetached");
        this.j.removeCallbacksAndMessages(null);
        j();
    }

    @Override // com.kwad.components.core.video.a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080bee);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && !this.l && message.what == 1) {
            if (com.kwad.sdk.b.kwai.a.a(this.i, 70)) {
                g();
            } else {
                i();
            }
            this.j.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.m) {
            super.b();
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.j();
            this.l = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onAttachedToWindow");
            m();
            n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onDetachedFromWindow");
            o();
        }
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
            n();
        }
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.b.c("InterstitialVideoPlayerController", "onStartTemporaryDetach");
            o();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }
}
