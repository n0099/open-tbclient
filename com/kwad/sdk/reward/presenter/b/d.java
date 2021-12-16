package com.kwad.sdk.reward.presenter.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.a f59682b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59683c;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
            super.a();
            if (this.f59683c) {
                this.f59682b.a(((g) this).a);
            }
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            float c2 = bb.c(q());
            aVar.a = (int) ((bb.b(q()) / c2) + 0.5f);
            aVar.f58575b = (int) ((bb.a(q()) / c2) + 0.5f);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            if (this.f59683c) {
                this.f59682b.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c_();
            com.kwad.sdk.reward.presenter.platdetail.a aVar = new com.kwad.sdk.reward.presenter.platdetail.a();
            this.f59682b = aVar;
            aVar.c(m());
            m().findViewById(i()).setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "ksad-video-bottom-card.js" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.id.ksad_js_slide_black : invokeV.intValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f59682b.a(((g) this).a);
            this.f59683c = true;
        }
    }
}
