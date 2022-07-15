package com.kwad.components.core.offline.init;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.j.e;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.as;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        String a;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            com.kwad.sdk.core.d.b.a(a(), "initReal");
            if (b()) {
                String a2 = a();
                com.kwad.sdk.core.d.b.a(a2, "initReal disableOfflineComponents: " + com.kwad.components.core.a.b + " , isDevelopEnable: " + com.kwad.components.core.a.c + " , DEBUG: false");
                if (com.kwad.components.core.a.b.booleanValue()) {
                    b(context, getClass().getClassLoader());
                } else {
                    c(context);
                }
                a = a();
                str = "initReal end";
            } else {
                a = a();
                str = "initReal disable";
            }
            com.kwad.sdk.core.d.b.a(a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ClassLoader classLoader) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, classLoader) == null) {
            try {
                z = a(context, classLoader);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
                z = false;
            }
            as.a(context, c(), d(), z);
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            com.kwai.sodler.lib.c.b g = g();
            String a = a();
            com.kwad.sdk.core.d.b.a(a, "loadComponents pluginInfo: " + g);
            com.kwai.sodler.kwai.a.a(context, g, new b.a(this, context) { // from class: com.kwad.components.core.offline.init.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
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
                    this.a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
                public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(65537, this, aVar, pluginError) == null) {
                        super.a((AnonymousClass2) aVar, pluginError);
                        String a2 = this.b.a();
                        com.kwad.sdk.core.d.b.a(a2, "loadComponents failed error: " + pluginError);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
                public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(65538, this, aVar, aVar2) == null) {
                        super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
                        String a2 = this.b.a();
                        if (aVar2 == null) {
                            com.kwad.sdk.core.d.b.a(a2, "loadComponents failed plugin null");
                            return;
                        }
                        com.kwad.sdk.core.d.b.a(a2, "loadComponents success");
                        this.b.b(this.a, aVar2.a());
                    }
                }
            });
        }
    }

    private com.kwai.sodler.lib.c.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
            bVar.a = c();
            bVar.e = true;
            bVar.g = false;
            bVar.c = com.kwad.sdk.core.network.idc.a.a().a(e());
            bVar.b = d();
            bVar.f = f();
            return bVar;
        }
        return (com.kwai.sodler.lib.c.b) invokeV.objValue;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, classLoader, str)) == null) {
            String a = a();
            com.kwad.sdk.core.d.b.a(a, "onOfflineComponentsLoaded classLoader:" + classLoader);
            try {
                t = (T) classLoader.loadClass(str).newInstance();
            } catch (Throwable th) {
                String a2 = a();
                com.kwad.sdk.core.d.b.a(a2, "loadClass or instance failed: " + str, th);
                t = null;
            }
            String a3 = a();
            com.kwad.sdk.core.d.b.a(a3, "onOfflineComponentsLoaded components: " + t);
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public abstract String a();

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            boolean b = as.b(context, c(), d());
            String a = a();
            com.kwad.sdk.core.d.b.a(a, "init isSuccessLoaded: " + b);
            e.a(new e.a(this, b, context) { // from class: com.kwad.components.core.offline.init.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ Context b;
                public final /* synthetic */ a c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(b), context};
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
                    this.a = b;
                    this.b = context;
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a) {
                        com.kwad.sdk.core.d.b.a(this.c.a(), "init onCacheLoaded");
                        this.c.b(this.b);
                    }
                }

                @Override // com.kwad.components.core.j.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) || this.a) {
                        return;
                    }
                    com.kwad.sdk.core.d.b.a(this.c.a(), "init onConfigRefresh");
                    this.c.b(this.b);
                }
            });
        }
    }

    public abstract boolean a(Context context, ClassLoader classLoader);

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();
}
