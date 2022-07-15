package com.kwad.components.offline.obiwan;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.j.e;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.core.offline.init.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.offline.obiwan.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0529a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1557032993, "Lcom/kwad/components/offline/obiwan/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1557032993, "Lcom/kwad/components/offline/obiwan/a$a;");
                    return;
                }
            }
            a = new a((byte) 0);
        }
    }

    public a() {
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

    public /* synthetic */ a(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.init.b.class, methodId = "initOC")
    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            g().a(context);
        }
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0529a.a : (a) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ObiwanInitModule" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean a(Context context, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, classLoader)) == null) {
            IObiwanOfflineCompo iObiwanOfflineCompo = (IObiwanOfflineCompo) a(classLoader, IObiwanOfflineCompo.IMPL);
            if (iObiwanOfflineCompo == null) {
                return false;
            }
            ObiwanComponentsImpl obiwanComponentsImpl = new ObiwanComponentsImpl(iObiwanOfflineCompo);
            com.kwad.sdk.components.c.a(ObiwanComponents.class, obiwanComponentsImpl);
            iObiwanOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new c());
            com.kwad.sdk.core.d.b.a(new b(obiwanComponentsImpl.getLog()));
            e.a(new e.a(this, obiwanComponentsImpl) { // from class: com.kwad.components.offline.obiwan.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ObiwanComponentsImpl a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obiwanComponentsImpl};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = obiwanComponentsImpl;
                }

                private void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        com.kwad.sdk.core.d.b.a(d.ac() ? new b(this.a.getLog()) : null);
                        this.a.updateConfigs();
                    }
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b();
                    }
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) {
                        b();
                    }
                }
            });
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.ac() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? IObiwanOfflineCompo.PACKAGE_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "3.3.24.3" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.24.3.apk" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "ed7ce6364c3cbfa6c08587ab840e51a2" : (String) invokeV.objValue;
    }
}
