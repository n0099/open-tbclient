package com.kwad.components.ad.fullscreen.b.kwai;

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
import com.kwad.sdk.utils.h;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    @NonNull
    public com.kwad.components.ad.reward.h.a c;
    public h.a d;
    public g e;

    public c() {
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
        this.d = new h.a(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a.b.post(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
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
                            this.a.a.c.a(false, false);
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
        this.e = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.c = ((com.kwad.components.ad.reward.presenter.a) this).a.j;
            boolean z = false;
            this.b.setVisibility(0);
            KsVideoPlayConfig ksVideoPlayConfig = ((com.kwad.components.ad.reward.presenter.a) this).a.d;
            if (!this.c.a() && com.kwad.components.core.l.b.a(u()).a()) {
                imageView = this.b;
            } else if (ksVideoPlayConfig != null) {
                this.b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.c.a(this.e);
                this.c.a(this.d);
            } else {
                imageView = this.b;
                z = true;
            }
            imageView.setSelected(z);
            this.c.a(this.e);
            this.c.a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a)) {
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
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.d);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 == (imageView = this.b)) {
            this.c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
