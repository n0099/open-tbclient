package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.h;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public ImageView c;
    public AdTemplate d;
    @NonNull
    public com.kwad.components.ad.reward.h.a e;
    public h.a f;
    public g g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new h.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.b == null || com.kwad.components.ad.reward.kwai.b.e()) {
                    return;
                }
                this.a.b.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass1 a;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext2);
                            int i3 = newInitContext2.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext2.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.a.a.b.setSelected(false);
                            this.a.a.e.a(false, false);
                        }
                    }
                });
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.g = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.e();
                }
            }
        };
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            AdTemplate adTemplate = lVar.g;
            this.d = adTemplate;
            this.e = lVar.j;
            this.b.setVisibility(l.c(adTemplate) ? 8 : 0);
            this.c.setVisibility(l.c(this.d) ? 0 : 8);
            KsVideoPlayConfig ksVideoPlayConfig = ((com.kwad.components.ad.reward.presenter.a) this).a.d;
            if (!this.e.a() && com.kwad.components.core.l.b.a(u()).a()) {
                this.b.setSelected(false);
            } else if (ksVideoPlayConfig != null) {
                this.b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.c.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.e.a(this.g);
                this.e.a(this.f);
            } else {
                this.b.setSelected(true);
            }
            this.c.setSelected(true);
            this.e.a(this.g);
            this.e.a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            } else {
                d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (ImageView) b(R.id.obfuscated_res_0x7f0911dd);
            this.c = (ImageView) b(R.id.obfuscated_res_0x7f0910fd);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.g);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.f);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            ImageView imageView = this.b;
            if (view2 == imageView) {
                this.e.a(!imageView.isSelected(), true);
                ImageView imageView2 = this.b;
                imageView2.setSelected(!imageView2.isSelected());
                return;
            }
            ImageView imageView3 = this.c;
            if (view2 == imageView3) {
                this.e.a(!imageView3.isSelected(), true);
                ImageView imageView4 = this.c;
                imageView4.setSelected(!imageView4.isSelected());
            }
        }
    }
}
