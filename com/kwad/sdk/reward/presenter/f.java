package com.kwad.sdk.reward.presenter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.af;
/* loaded from: classes2.dex */
public class f extends com.kwad.sdk.reward.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59155b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59156c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59157d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59158e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f59159f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59160g;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59159f = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.presenter.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.e();
                }
            }
        };
        this.f59160g = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.presenter.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    ((com.kwad.sdk.reward.g) this.a).a.b();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!((com.kwad.sdk.reward.g) this).a.t) {
                this.f59155b.setVisibility(8);
                this.f59156c.setVisibility(0);
            }
            Context q = q();
            if (g() && af.e(q)) {
                this.f59158e.setVisibility(0);
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            int i2 = 0;
            if (((com.kwad.sdk.reward.g) this).a.t) {
                this.f59157d.setVisibility(0);
                viewGroup = this.f59155b;
                i2 = 8;
            } else {
                viewGroup = this.f59155b;
            }
            viewGroup.setVisibility(i2);
            ((com.kwad.sdk.reward.g) this).a.a(this.f59159f);
            ((com.kwad.sdk.reward.g) this).a.f58878k.a(this.f59160g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.g) this).a.b(this.f59159f);
            ((com.kwad.sdk.reward.g) this).a.f58878k.b(this.f59160g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59155b = (ViewGroup) a(R.id.ksad_play_detail_top_toolbar);
            this.f59156c = (ViewGroup) a(R.id.ksad_play_end_top_toolbar);
            this.f59157d = (ViewGroup) a(R.id.ksad_js_top);
            this.f59158e = (ImageView) a(R.id.ksad_blur_end_cover);
        }
    }
}
