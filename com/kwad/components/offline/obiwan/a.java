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
import com.kwad.components.core.k.e;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.core.offline.init.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.offline.obiwan.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0619a {
        public static /* synthetic */ Interceptable $ic;
        public static final a Qh;
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
            Qh = new a((byte) 0);
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
    public static void aC(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            qw().init(context);
        }
    }

    public static a qw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0619a.Qh : (a) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, classLoader)) == null) {
            IObiwanOfflineCompo iObiwanOfflineCompo = (IObiwanOfflineCompo) a(classLoader, IObiwanOfflineCompo.IMPL);
            if (iObiwanOfflineCompo == null) {
                return false;
            }
            ObiwanComponentsImpl obiwanComponentsImpl = new ObiwanComponentsImpl(iObiwanOfflineCompo);
            com.kwad.sdk.components.c.a(ObiwanComponents.class, obiwanComponentsImpl);
            iObiwanOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new c());
            com.kwad.sdk.core.e.b.a(new b(obiwanComponentsImpl.getLog()));
            e.a(new e.a(this, obiwanComponentsImpl) { // from class: com.kwad.components.offline.obiwan.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ObiwanComponentsImpl Qf;
                public final /* synthetic */ a Qg;

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
                    this.Qg = this;
                    this.Qf = obiwanComponentsImpl;
                }

                private void updateConfigs() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        com.kwad.sdk.core.e.b.a(d.isLogObiwanEnableNow() ? new b(this.Qf.getLog()) : null);
                        this.Qf.updateConfigs();
                    }
                }

                @Override // com.kwad.components.core.k.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, sdkConfigData) == null) {
                        updateConfigs();
                    }
                }

                @Override // com.kwad.components.core.k.e.a
                public final void no() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        updateConfigs();
                    }
                }
            });
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ObiwanInitModule" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.isLogObiwanEnableNow() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? IObiwanOfflineCompo.PACKAGE_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "3.3.24.3" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.24.3.apk" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "ed7ce6364c3cbfa6c08587ab840e51a2" : (String) invokeV.objValue;
    }
}
