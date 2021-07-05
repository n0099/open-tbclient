package com.kwad.sdk.contentalliance.profile.home.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.b;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSProfilePageLoadingView;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.profile.home.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f35334b;

    /* renamed from: c  reason: collision with root package name */
    public KSProfilePageLoadingView f35335c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.b f35336d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f35337e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView.a f35338f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f35339g;

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
        this.f35338f = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35340a;

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
                this.f35340a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35340a.f35336d == null) {
                    return;
                }
                this.f35340a.f35336d.a();
            }
        };
        this.f35339g = new b.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35341a;

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
                this.f35341a = this;
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.b.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35341a.f35335c.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.b.a
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str) == null) {
                    this.f35341a.f35335c.a();
                    if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        this.f35341a.f35335c.c();
                    } else {
                        this.f35341a.f35335c.d();
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.b.a
            public void a(UserProfile userProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, userProfile) == null) {
                    this.f35341a.f35335c.a();
                    this.f35341a.f35334b.setVisibility(0);
                    for (com.kwad.sdk.contentalliance.profile.home.a.a aVar : this.f35341a.f35337e) {
                        aVar.a(userProfile);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.b.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f35336d.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a;
            this.f35337e = bVar.f35332f;
            ProfileHomeParam profileHomeParam = bVar.f35330d;
            SceneImpl sceneImpl = bVar.f35328b;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
            fVar.f36139b = sceneImpl.getPageScene();
            this.f35336d = new com.kwad.sdk.contentalliance.profile.home.b(fVar, profileHomeParam.mAuthorId, this.f35339g);
            e();
            this.f35335c.setRetryClickListener(this.f35338f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35336d.b();
            this.f35335c.setRetryClickListener(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35334b = b(R.id.ksad_profile_view_pager);
            this.f35335c = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        }
    }
}
