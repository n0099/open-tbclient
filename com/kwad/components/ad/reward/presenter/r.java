package com.kwad.components.ad.reward.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.y;
/* loaded from: classes5.dex */
public final class r extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailVideoView b;
    public ViewGroup c;
    public FrameLayout d;
    public ImageView e;
    public View f;
    public View g;
    public View h;
    public ViewGroup.LayoutParams i;

    public r() {
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
        this.i = null;
    }

    private void a(@LayoutRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.d.addView(LayoutInflater.from(u()).inflate(i, (ViewGroup) this.d, false), -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view2, z) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(((a) this).a.g).a(((a) this).a.k).a(2).a(((a) this).a.j.i()).a(true).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.presenter.r.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ r b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = z;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    AdTemplate adTemplate;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a) {
                            adTemplate = ((a) this.b).a.g;
                            i = 115;
                        } else {
                            adTemplate = ((a) this.b).a.g;
                            i = 117;
                        }
                        com.kwad.sdk.core.report.a.a(adTemplate, i, (y.a) null);
                    }
                }
            }));
        }
    }

    private void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(((a) this).a.g);
            boolean z = !ae.e(u());
            boolean ar = com.kwad.sdk.core.response.a.a.ar(i2);
            boolean z2 = com.kwad.components.ad.reward.l.a(((a) this).a.g) || com.kwad.components.ad.reward.l.b(((a) this).a.g) || ar;
            if (!z || !z2) {
                if (!z && com.kwad.sdk.core.response.a.a.bb(i2)) {
                    this.g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.reward.presenter.r.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ r a;

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

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.a.a(view2, false);
                            }
                        }
                    });
                    this.h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.reward.presenter.r.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ r a;

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

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.a.a(view2, true);
                            }
                        }
                    });
                    this.f.setVisibility(0);
                }
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            if (ar) {
                this.e.setVisibility(8);
                i = R.layout.obfuscated_res_0x7f0d0441;
            } else {
                i = R.layout.obfuscated_res_0x7f0d03fa;
            }
            a(i);
            if (!com.kwad.sdk.core.response.a.a.T(i2)) {
                this.b.a(17);
            } else {
                this.b.a(21);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.r.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ViewGroup.LayoutParams layoutParams = this.a.f.getLayoutParams();
                        layoutParams.height = (com.kwad.sdk.b.kwai.a.b(this.a.s()) * 550) / 1080;
                        this.a.f.setLayoutParams(layoutParams);
                        ViewGroup.LayoutParams layoutParams2 = this.a.g.getLayoutParams();
                        layoutParams2.width = ((com.kwad.sdk.b.kwai.a.b(this.a.s()) - com.kwad.sdk.b.kwai.a.a(this.a.u(), 24.0f)) * 550) / 684;
                        this.a.g.setLayoutParams(layoutParams2);
                        ViewGroup.LayoutParams layoutParams3 = this.a.h.getLayoutParams();
                        layoutParams3.width = ((com.kwad.sdk.b.kwai.a.b(this.a.s()) - com.kwad.sdk.b.kwai.a.a(this.a.u(), 24.0f)) * 550) / 324;
                        this.a.h.setLayoutParams(layoutParams3);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams != null) {
                this.i = new ViewGroup.LayoutParams(layoutParams);
            }
            e();
            d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (DetailVideoView) b(R.id.obfuscated_res_0x7f0911da);
            this.c = (ViewGroup) b(R.id.obfuscated_res_0x7f0910b1);
            this.e = (ImageView) b(R.id.obfuscated_res_0x7f0910b2);
            this.d = (FrameLayout) b(R.id.obfuscated_res_0x7f0910b3);
            this.f = b(R.id.obfuscated_res_0x7f091194);
            this.g = b(R.id.obfuscated_res_0x7f091195);
            this.h = b(R.id.obfuscated_res_0x7f091196);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            if (this.i == null || (detailVideoView = this.b) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = this.i;
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                this.b.setLayoutParams(layoutParams);
            }
            this.i = null;
        }
    }
}
