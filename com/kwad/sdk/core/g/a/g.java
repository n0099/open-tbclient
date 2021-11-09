package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes2.dex */
public class g extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64601a;

    /* renamed from: b  reason: collision with root package name */
    public String f64602b;

    public g() {
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

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            SdkConfigData.TemplateConfig a2 = com.kwad.sdk.core.config.c.a();
            if (a2 != null) {
                g gVar = new g();
                String str = a2.h5Url;
                if (str != null) {
                    gVar.f64602b = str;
                }
                String str2 = a2.h5Version;
                if (str2 != null) {
                    gVar.f64601a = str2;
                }
                if (gVar.f64602b == null && gVar.f64601a == null) {
                    return null;
                }
                return gVar;
            }
            return null;
        }
        return (g) invokeV.objValue;
    }
}
