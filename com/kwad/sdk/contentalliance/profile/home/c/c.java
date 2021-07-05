package com.kwad.sdk.contentalliance.profile.home.c;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.lib.desigin.CustomReboundBehavior;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.profile.home.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KSAppBarLayout f35348b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f35349c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f35350d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f35351e;

    public c() {
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
        this.f35350d = new com.kwad.sdk.contentalliance.profile.home.a.a(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35352a;

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
                this.f35352a = this;
            }

            @Override // com.kwad.sdk.contentalliance.profile.home.a.a
            public void a(@NonNull UserProfile userProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, userProfile) == null) {
                    this.f35352a.f35348b.post(this.f35352a.f35351e);
                }
            }
        };
        this.f35351e = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35353a;

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
                this.f35353a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) this.f35353a.f35348b.getLayoutParams()).getBehavior();
                    if (behavior instanceof CustomReboundBehavior) {
                        ((CustomReboundBehavior) behavior).setScrollableSize((this.f35353a.f35348b.getHeight() + this.f35353a.f35349c.getHeight()) - ((ViewGroup) this.f35353a.f35348b.getParent()).getHeight());
                    }
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a;
            this.f35349c = bVar.f35329c;
            bVar.f35332f.add(this.f35350d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35348b.removeCallbacks(this.f35351e);
            ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f35326a.f35332f.remove(this.f35350d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35348b = (KSAppBarLayout) b(R.id.ksad_profile_appbar);
        }
    }
}
