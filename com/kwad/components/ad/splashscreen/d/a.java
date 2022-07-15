package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.core.download.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public AdInfo b;
    public Context c;

    public a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adTemplate;
        this.b = d.i(adTemplate);
        this.c = context;
    }

    private void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            a(com.kwad.sdk.core.response.a.b.i(this.b) ? e.a(this.a, this.b, i) : com.kwad.sdk.core.response.a.b.k(this.b) ? e.b(this.b, i) : e.a(this.b, i));
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            b(4);
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.a = adTemplate;
        }
    }

    public abstract void a(String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b(7);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b(8);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(0);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b(12);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            b(2);
        }
    }
}
