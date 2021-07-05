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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f37478b;

    /* renamed from: c  reason: collision with root package name */
    public final ap f37479c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f37480d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37481e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37482f;

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
        this.f37479c = new ap(this);
        this.f37480d = new AtomicBoolean(true);
        this.f37482f = true;
        this.f37478b = this;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.f37480d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewAttached");
            this.f37479c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
            if (!ao.a(this.f37478b, 30)) {
                e();
            } else if (!this.f37481e) {
                d();
            }
            this.f37479c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37480d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewDetached");
        this.f37479c.removeCallbacksAndMessages(null);
        if (this.f37482f) {
            f();
        } else {
            this.f36652a.c();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36652a.c();
            this.f37481e = true;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d();
            this.f37481e = false;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37481e = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onAttachedToWindow");
            n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onDetachedFromWindow");
            j();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onFinishTemporaryDetach");
            n();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onStartTemporaryDetach");
            j();
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
            this.f37482f = z;
        }
    }
}
