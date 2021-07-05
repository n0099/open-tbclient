package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.d.e;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class k extends a<e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f34820d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.d.e f34821e;

    public k() {
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

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            com.kwad.sdk.contentalliance.detail.photo.d.e eVar = this.f34821e;
            if (eVar != null) {
                eVar.dismiss();
            }
            SlidePlayViewPager slidePlayViewPager = this.f34820d;
            if (slidePlayViewPager != null) {
                slidePlayViewPager.a(true, 2);
            }
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            com.kwad.sdk.contentalliance.detail.photo.d.d dVar = new com.kwad.sdk.contentalliance.detail.photo.d.d(cVar.j, cVar.f34582i);
            com.kwad.sdk.contentalliance.detail.photo.d.e eVar = this.f34821e;
            if (eVar == null || !eVar.isShowing()) {
                com.kwad.sdk.contentalliance.detail.photo.d.e eVar2 = new com.kwad.sdk.contentalliance.detail.photo.d.e(o(), dVar);
                this.f34821e = eVar2;
                eVar2.a(new e.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.f.k.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f34822a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34822a = this;
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ((com.kwad.sdk.contentalliance.detail.b) this.f34822a).f34553a.n = true;
                            this.f34822a.f34820d.a(false, 3);
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            ((com.kwad.sdk.contentalliance.detail.b) this.f34822a).f34553a.n = false;
                            this.f34822a.f34820d.a(true, 3);
                        }
                    }
                });
                this.f34821e.show();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((e) ((a) this).f34792b).setOnClickListener(this);
            this.f34820d = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            h();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            h();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new e(o()) : (e) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
            } else {
                p();
            }
            com.kwad.sdk.core.report.e.c(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
        }
    }
}
