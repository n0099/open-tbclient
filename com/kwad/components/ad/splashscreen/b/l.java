package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.t;
/* loaded from: classes5.dex */
public final class l extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.download.kwai.a b;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo == null) {
                    return null;
                }
                return context.getResources().getString(packageInfo.applicationInfo.labelRes);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.download.kwai.a aVar = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.splashscreen.b.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadStarted() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        super.onDownloadStarted();
                        Context u = this.a.u();
                        if (u != null) {
                            String b = l.b(u);
                            if (b != null) {
                                str = b + ":已开始下载";
                            } else {
                                str = "已开始下载";
                            }
                            t.a(u, str);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    }
                }
            };
            this.b = aVar;
            ((e) this).a.f.a(aVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        com.kwad.sdk.core.download.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.b) == null) {
            return;
        }
        ((e) this).a.f.b(aVar);
    }
}
