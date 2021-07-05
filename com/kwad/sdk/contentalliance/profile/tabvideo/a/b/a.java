package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RadiusPvFrameLayout f35375b;

    /* renamed from: c  reason: collision with root package name */
    public RadiusPvFrameLayout.a f35376c;

    public a() {
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
        this.f35376c = new RadiusPvFrameLayout.a(this) { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35377a;

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
                this.f35377a = this;
            }

            @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35377a.f();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().a(((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38570f.g());
            ProfileVideoDetailParam profileVideoDetailParam = new ProfileVideoDetailParam();
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            profileVideoDetailParam.mEnterScene = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f35374a.mEntryScene;
            profileVideoDetailParam.mAuthorId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f35374a.mAuthorId;
            profileVideoDetailParam.mTabId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f35374a.mTabId;
            profileVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f38572h;
            com.kwad.sdk.contentalliance.profile.tabvideo.detail.b.a(o(), profileVideoDetailParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            e.a((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            e.b((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i, 1);
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35375b.setOnClickListener(this);
            this.f35375b.a(this.f35376c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35375b.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35375b = (RadiusPvFrameLayout) b(R.id.ksad_profile_item_root);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || ao.a()) {
            return;
        }
        e();
        g();
    }
}
