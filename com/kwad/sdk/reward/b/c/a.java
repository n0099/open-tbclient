package com.kwad.sdk.reward.b.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d;
/* loaded from: classes10.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f73800b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f73801c;

    public a(Context context, AdTemplate adTemplate, boolean z, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, Boolean.valueOf(z), frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73801c = adTemplate;
        this.f73800b = c.i(adTemplate);
        if (z) {
            a(context, frameLayout);
        } else {
            b(context, frameLayout);
        }
    }

    private void a(Context context, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, frameLayout) == null) {
            boolean a2 = com.kwad.sdk.core.response.b.a.a(this.f73800b, context);
            boolean a3 = com.kwad.sdk.core.config.c.a(this.f73800b, context);
            if (a3) {
                a((Presenter) new com.kwad.sdk.reward.b.b());
            }
            if (a2) {
                return;
            }
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
            if (c.a(this.f73801c, context)) {
                a((Presenter) new com.kwad.sdk.reward.b.c.a.d());
            }
            if (c.r(this.f73801c)) {
                a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
            }
            if (!(!a3 && com.kwad.sdk.core.response.b.a.b(context, this.f73801c, this.f73800b)) || frameLayout == null) {
                return;
            }
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a(context, this.f73801c, frameLayout));
        }
    }

    private void b(Context context, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, frameLayout) == null) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
            if (com.kwad.sdk.core.response.b.b.j(this.f73801c)) {
                a((Presenter) new com.kwad.sdk.reward.b.c.a.d());
            }
            if (c.r(this.f73801c)) {
                a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
            }
            if (!com.kwad.sdk.core.response.b.a.b(context, this.f73801c, this.f73800b) || frameLayout == null) {
                return;
            }
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a(context, this.f73801c, frameLayout));
        }
    }
}
