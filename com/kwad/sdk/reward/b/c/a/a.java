package com.kwad.sdk.reward.b.c.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.page.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f36074b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.b f36075c;

    /* renamed from: d  reason: collision with root package name */
    public f f36076d;

    public a(Context context, AdTemplate adTemplate, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36076d = new f(this) { // from class: com.kwad.sdk.reward.b.c.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f36077a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36077a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.sdk.reward.d) this.f36077a).f36214a.u || this.f36077a.f36074b == null || this.f36077a.f36075c == null || !this.f36077a.f36075c.b()) {
                    return;
                }
                this.f36077a.f36074b.setVisibility(0);
                this.f36077a.f36075c.d();
            }
        };
        this.f36074b = frameLayout;
        com.kwad.sdk.core.page.b bVar = new com.kwad.sdk.core.page.b(context, adTemplate, 4);
        this.f36075c = bVar;
        bVar.a(this);
        this.f36075c.a(new b.c().a(false).a());
        frameLayout.addView(this.f36075c.a());
    }

    private void e() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f36214a.f35889g) == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.d) this).f36214a.a(this.f36076d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f36214a.b(this.f36076d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.sdk.core.page.b bVar = this.f36075c;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // com.kwad.sdk.core.page.b.a
    public void onBackBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            ((com.kwad.sdk.reward.d) this).f36214a.f35884b.e();
            ((com.kwad.sdk.reward.d) this).f36214a.f35884b.a(false);
            e();
        }
    }

    @Override // com.kwad.sdk.core.page.b.a
    public void onCloseBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }
}
