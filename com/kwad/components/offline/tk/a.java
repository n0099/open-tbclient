package com.kwad.components.offline.tk;

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
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.core.offline.init.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.offline.tk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0530a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(902308278, "Lcom/kwad/components/offline/tk/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(902308278, "Lcom/kwad/components/offline/tk/a$a;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0530a.a : (a) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TkInitModule" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean a(Context context, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, classLoader)) == null) {
            ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
            if (iTkOfflineCompo == null) {
                com.kwad.sdk.core.d.b.a("TkInitModule", "onPluginLoaded components is null");
                return false;
            }
            String a = a();
            com.kwad.sdk.core.d.b.a(a, "onOfflineComponentsLoaded components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
            TkCompoImpl tkCompoImpl = new TkCompoImpl(iTkOfflineCompo);
            c.a(com.kwad.components.core.offline.api.kwai.a.class, tkCompoImpl);
            iTkOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new b());
            SdkConfigData G = d.G();
            if (G != null) {
                tkCompoImpl.onConfigRefresh(context, G.toJson());
            }
            e.a(new e.a(this, tkCompoImpl, context) { // from class: com.kwad.components.offline.tk.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TkCompoImpl a;
                public final /* synthetic */ Context b;
                public final /* synthetic */ a c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tkCompoImpl, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = tkCompoImpl;
                    this.b = context;
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) {
                        this.a.onConfigRefresh(this.b, sdkConfigData.toJson());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.C() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ITkOfflineCompo.PACKAGE_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "3.3.24.7" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.24.7-11ed97fe.apk" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "32b0020142ec0faf9dae126d121d723e" : (String) invokeV.objValue;
    }
}
