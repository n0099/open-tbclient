package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.b.i;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.plugin.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    private void a(@NonNull List<com.kwad.sdk.core.response.model.b> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, list) == null) && com.kwad.sdk.core.config.c.m()) {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.core.response.model.b bVar : list) {
                if (bVar != null && bVar.f36573c) {
                    arrayList.add(new KsScene.Builder(bVar.f36571a).build());
                }
            }
            com.kwad.sdk.contentalliance.home.b.a(arrayList);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            com.kwad.sdk.core.d.a.b("ContentPluginImpl", "初次获取Gid: initGId");
            d.n.a.a.b.c().g(context, true, new d.n.a.a.d(this, context) { // from class: com.kwad.sdk.contentalliance.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f34329a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f34330b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34330b = this;
                    this.f34329a = context;
                }

                @Override // d.n.a.a.d
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.d("ContentPluginImpl", "初次获取Gid: initGId onFailed errorCode:" + i2 + "errorMessage :" + str);
                    }
                }

                @Override // d.n.a.a.d
                public void a(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                        com.kwad.sdk.core.b.e.a(this.f34329a, str2);
                        this.f34330b.a(this.f34329a, str);
                    }
                }
            });
        }
    }

    private void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null || ah.m(context).endsWith(":filedownloader")) {
            return;
        }
        com.kwad.sdk.emotion.a.d.a().a(com.kwad.sdk.emotion.model.a.a().a(ad.a(KsAdSDKImpl.get().getContext())).a(), new com.kwad.sdk.emotion.model.b(this) { // from class: com.kwad.sdk.contentalliance.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34331a;

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
                this.f34331a = this;
            }
        });
    }

    @Override // com.kwad.sdk.plugin.b
    public i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new com.kwad.sdk.core.b.a() : (i) invokeV.objValue;
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().a(context);
        }
    }

    @Override // com.kwad.sdk.plugin.e
    public void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sdkConfig) == null) {
            try {
                b(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.d("ContentPluginImpl", "ContentPluginImpl initGId error : " + th);
            }
        }
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.equals(str, ae.e(context))) {
            return;
        }
        ae.d(context, str);
        try {
            d.n.a.a.b.c().k(context, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.d("ContentPluginImpl", "ContentPluginImpl KWEGIDDFP setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(@NonNull SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sdkConfigData) == null) {
            List<com.kwad.sdk.core.response.model.b> b2 = c.a.aa.b();
            if (b2 != null) {
                a(b2);
            }
            if (com.kwad.sdk.core.config.c.L()) {
                c();
            }
        }
    }

    @Override // com.kwad.sdk.plugin.e
    public Class b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.plugin.b.class : (Class) invokeV.objValue;
    }
}
