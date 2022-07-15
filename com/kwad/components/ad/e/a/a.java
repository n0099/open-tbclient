package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ay;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup c;
    public ImageView d;
    public TextView e;
    public KsAdVideoPlayConfig f;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = ksAdVideoPlayConfig;
    }

    private boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, adInfo)) == null) {
            if (ac.b(u())) {
                KsAdVideoPlayConfig ksAdVideoPlayConfig = this.f;
                if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                        return true;
                    }
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                        return ac.c(u());
                    }
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                        return false;
                    }
                    if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                        return ac.c(u()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ac.d(u()));
                    }
                }
                if (com.kwad.sdk.core.response.a.a.az(adInfo)) {
                    return true;
                }
                return com.kwad.sdk.core.response.a.a.aA(adInfo) && ac.c(u());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        ViewGroup viewGroup;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.e.kwai.a) this).a.d);
            if (a(i2)) {
                viewGroup = this.c;
                i = 8;
            } else {
                this.e.setText(ay.a(com.kwad.sdk.core.response.a.a.c(i2) * 1000));
                this.d.setOnClickListener(this);
                ((com.kwad.components.ad.e.kwai.a) this).a.d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
                viewGroup = this.c;
                i = 0;
            }
            viewGroup.setVisibility(i);
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.b();
                        this.a.d();
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        super.c();
                        this.a.d();
                    }
                }
            };
            ((com.kwad.components.ad.e.kwai.a) this).b = hVar;
            ((com.kwad.components.ad.e.kwai.a) this).a.f.a(hVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.c = (ViewGroup) b(R.id.obfuscated_res_0x7f091023);
            this.d = (ImageView) b(R.id.obfuscated_res_0x7f091024);
            this.e = (TextView) b(R.id.obfuscated_res_0x7f091025);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && view2 == this.d) {
            ((com.kwad.components.ad.e.kwai.a) this).a.f.f();
        }
    }
}
