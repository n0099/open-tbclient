package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.b.i;
import com.kwad.sdk.utils.am;
/* loaded from: classes10.dex */
public class a implements com.kwad.sdk.plugin.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            com.kwad.sdk.core.d.a.c("AdPluginImpl", "初次获取Gid: initGId");
            c.r.a.a.b.b().g(context, false, new c.r.a.a.d(this, context) { // from class: com.kwad.sdk.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f71314a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f71315b;

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
                    this.f71315b = this;
                    this.f71314a = context;
                }

                @Override // c.r.a.a.d
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.e("AdPluginImpl", "初次获取Gid: initGId onFailed errorCode:" + i2 + "errorMessage :" + str);
                    }
                }

                @Override // c.r.a.a.d
                public void a(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                        com.kwad.sdk.core.b.e.a(this.f71314a, str2);
                        this.f71315b.a(this.f71314a, str);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.plugin.d
    public Class a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.plugin.a.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.plugin.d
    public void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sdkConfig) == null) {
            try {
                a(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.e("AdPluginImpl", "AdPluginImpl initGId error : " + th);
            }
        }
    }

    @Override // com.kwad.sdk.plugin.a
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.equals(str, am.a(context))) {
            return;
        }
        am.d(context, str);
        try {
            c.r.a.a.b.b().l(context, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.e("AdPluginImpl", "AdPluginImpl KWEGIDDFP setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.a
    public i b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.kwad.sdk.core.b.a() : (i) invokeV.objValue;
    }
}
