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
import com.kwad.components.core.k.e;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.core.offline.init.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.offline.tk.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0596a {
        public static /* synthetic */ Interceptable $ic;
        public static final a Ql;
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
            Ql = new a((byte) 0);
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
            qy().init(context);
        }
    }

    public static a qy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0596a.Ql : (a) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, classLoader)) == null) {
            ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
            if (iTkOfflineCompo == null) {
                com.kwad.sdk.core.e.b.d("TkInitModule", "onPluginLoaded components is null");
                return false;
            }
            String tag = getTag();
            com.kwad.sdk.core.e.b.d(tag, "onOfflineComponentsLoaded components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
            TkCompoImpl tkCompoImpl = new TkCompoImpl(iTkOfflineCompo);
            c.a(com.kwad.components.core.offline.api.kwai.a.class, tkCompoImpl);
            iTkOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new b());
            SdkConfigData rZ = d.rZ();
            if (rZ != null) {
                tkCompoImpl.onConfigRefresh(context, rZ.toJson());
            }
            e.a(new e.a(this, tkCompoImpl, context) { // from class: com.kwad.components.offline.tk.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TkCompoImpl Qj;
                public final /* synthetic */ a Qk;
                public final /* synthetic */ Context gC;

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
                    this.Qk = this;
                    this.Qj = tkCompoImpl;
                    this.gC = context;
                }

                @Override // com.kwad.components.core.k.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, sdkConfigData) == null) {
                        this.Qj.onConfigRefresh(this.gC, sdkConfigData.toJson());
                    }
                }

                @Override // com.kwad.components.core.k.e.a
                public final void no() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "TkInitModule" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.isCanUseTk() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ITkOfflineCompo.PACKAGE_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "3.3.26.1" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.26.1.apk" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "daf5b23731d40988bcb92485d3adf70a" : (String) invokeV.objValue;
    }
}
