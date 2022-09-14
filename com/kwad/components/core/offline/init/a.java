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
import com.kwad.components.core.k.e;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.w;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
/* loaded from: classes7.dex */
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
    public void a(Context context, ClassLoader classLoader) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, classLoader) == null) {
            try {
                z = b(context, classLoader);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
                z = false;
            }
            w.b(context, nk(), nl(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(Context context) {
        String tag;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            com.kwad.sdk.core.e.b.d(getTag(), "initReal");
            if (isEnabled()) {
                String tag2 = getTag();
                com.kwad.sdk.core.e.b.d(tag2, "initReal disableOfflineComponents: " + com.kwad.components.core.a.CL + " , isDevelopEnable: " + com.kwad.components.core.a.aw + " , DEBUG: false");
                if (com.kwad.components.core.a.CL.booleanValue()) {
                    a(context, getClass().getClassLoader());
                } else {
                    an(context);
                }
                tag = getTag();
                str = "initReal end";
            } else {
                tag = getTag();
                str = "initReal disable";
            }
            com.kwad.sdk.core.e.b.d(tag, str);
        }
    }

    private void an(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            com.kwai.sodler.lib.c.b nj = nj();
            String tag = getTag();
            com.kwad.sdk.core.e.b.d(tag, "loadComponents pluginInfo: " + nj);
            com.kwai.sodler.kwai.a.a(context, nj, new b.a(this, context) { // from class: com.kwad.components.core.offline.init.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a EK;
                public final /* synthetic */ Context gC;

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
                    this.EK = this;
                    this.gC = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwai.sodler.lib.ext.b.C0637b, com.kwai.sodler.lib.ext.b
                public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(65537, this, aVar, pluginError) == null) {
                        super.a((AnonymousClass2) aVar, pluginError);
                        String tag2 = this.EK.getTag();
                        com.kwad.sdk.core.e.b.d(tag2, "loadComponents failed error: " + pluginError);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwai.sodler.lib.ext.b.C0637b, com.kwai.sodler.lib.ext.b
                public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(65538, this, aVar, aVar2) == null) {
                        super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
                        String tag2 = this.EK.getTag();
                        if (aVar2 == null) {
                            com.kwad.sdk.core.e.b.d(tag2, "loadComponents failed plugin null");
                            return;
                        }
                        com.kwad.sdk.core.e.b.d(tag2, "loadComponents success");
                        this.EK.a(this.gC, aVar2.Ff());
                    }
                }
            });
        }
    }

    private com.kwai.sodler.lib.c.b nj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
            bVar.ayz = nk();
            bVar.Dv = true;
            bVar.ayD = false;
            bVar.ayA = com.kwad.sdk.core.network.idc.a.tH().bZ(nm());
            bVar.version = nl();
            bVar.ayC = nn();
            return bVar;
        }
        return (com.kwai.sodler.lib.c.b) invokeV.objValue;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, classLoader, str)) == null) {
            String tag = getTag();
            com.kwad.sdk.core.e.b.d(tag, "onOfflineComponentsLoaded classLoader:" + classLoader);
            try {
                t = (T) classLoader.loadClass(str).newInstance();
            } catch (Throwable th) {
                String tag2 = getTag();
                com.kwad.sdk.core.e.b.e(tag2, "loadClass or instance failed: " + str, th);
                t = null;
            }
            String tag3 = getTag();
            com.kwad.sdk.core.e.b.d(tag3, "onOfflineComponentsLoaded components: " + t);
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public abstract boolean b(Context context, ClassLoader classLoader);

    public abstract String getTag();

    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            boolean g = w.g(context, nk(), nl());
            String tag = getTag();
            com.kwad.sdk.core.e.b.d(tag, "init isSuccessLoaded: " + g);
            e.a(new e.a(this, g, context) { // from class: com.kwad.components.core.offline.init.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean EJ;
                public final /* synthetic */ a EK;
                public final /* synthetic */ Context gC;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(g), context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.EK = this;
                    this.EJ = g;
                    this.gC = context;
                }

                @Override // com.kwad.components.core.k.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, sdkConfigData) == null) || this.EJ) {
                        return;
                    }
                    com.kwad.sdk.core.e.b.d(this.EK.getTag(), "init onConfigRefresh");
                    this.EK.am(this.gC);
                }

                @Override // com.kwad.components.core.k.e.a
                public final void no() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.EJ) {
                        com.kwad.sdk.core.e.b.d(this.EK.getTag(), "init onCacheLoaded");
                        this.EK.am(this.gC);
                    }
                }
            });
        }
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract String nk();

    public abstract String nl();

    public abstract String nm();

    public abstract String nn();
}
