package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.o;
import com.kwai.sodler.lib.ext.PluginError;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class d implements com.kwai.sodler.lib.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> axj;
    public final Context mContext;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.axj = new ConcurrentHashMap<>();
        this.mContext = context.getApplicationContext();
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                com.kwai.sodler.lib.kwai.kwai.a.a((BaseDexClassLoader) classLoader);
            }
        } catch (Exception e) {
            a.e("Sodler.loader", "DvaPathClassLoader.inject failed", e);
        }
    }

    public static void a(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fVar) == null) {
            new StringBuilder("onCanceled state = ").append(fVar.getState());
            fVar.cG(-7);
            fVar.Fk().Fc().o(fVar);
        }
    }

    private com.kwai.sodler.lib.a.a b(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, fVar, aVar)) == null) {
            String Fh = aVar.Fh();
            File file = new File(Fh);
            new StringBuilder("Loading plugin, path = ").append(Fh);
            com.kwai.sodler.lib.a.e Fk = fVar.Fk();
            if (file.exists()) {
                String id = fVar.getId();
                String version = fVar.getVersion();
                com.kwai.sodler.lib.a.a eQ = eQ(id);
                if (eQ != null) {
                    new StringBuilder("The current plugin has been loaded, id = ").append(version);
                    return eQ;
                }
                aVar.eU(id);
                aVar.eT(version);
                if (Fk.Fa().aj(id, version)) {
                    String ai = Fk.Fa().ai(id, version);
                    if (o.dz(ai)) {
                        aVar.eV(ai);
                        aVar.af(this.mContext, ai);
                        b(id, aVar);
                        return aVar;
                    }
                }
                String b = Fk.Fa().b(aVar);
                aVar.eV(b);
                new StringBuilder("installed .").append(b);
                aVar.af(this.mContext, b);
                b(id, aVar);
                if (Fh.endsWith(Fk.EX().FC())) {
                    o.delete(Fh);
                }
                return aVar;
            }
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        return (com.kwai.sodler.lib.a.a) invokeLL.objValue;
    }

    private void b(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, fVar, pluginError) == null) {
            new StringBuilder("onError state = ").append(fVar.getState());
            fVar.cG(-5);
            fVar.q(pluginError);
            h(fVar);
        }
    }

    private synchronized void b(String str, com.kwai.sodler.lib.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (aVar.isLoaded()) {
                        this.axj.put(str, aVar);
                    }
                }
            }
        }
    }

    public static void g(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fVar) == null) {
            new StringBuilder("onPreLoad state = ").append(fVar.getState());
            fVar.Fk().Fc();
        }
    }

    public static void h(com.kwai.sodler.lib.a.f fVar) {
        PluginError loadError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, fVar) == null) {
            new StringBuilder("onPostLoad state = ").append(fVar.getState());
            if (fVar.getState() == 0) {
                com.kwai.sodler.lib.a.a Fr = fVar.Fr();
                if (Fr != null) {
                    fVar.Fk().Fc().c(fVar, Fr);
                    return;
                }
                fVar.cG(-1);
            }
            if (fVar.Fm() != null) {
                loadError = fVar.Fm() instanceof PluginError ? (PluginError) fVar.Fm() : new PluginError.LoadError(fVar.Fm(), 4011);
            } else {
                loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.getState(), 4011);
            }
            fVar.Fk().Fc().c(fVar, loadError);
        }
    }

    @Override // com.kwai.sodler.lib.a.d
    public final synchronized com.kwai.sodler.lib.a.a eQ(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                com.kwai.sodler.lib.a.a aVar = this.axj.get(str);
                if (aVar != null) {
                    if (!aVar.isLoaded()) {
                        return null;
                    }
                }
                return aVar;
            }
        }
        return (com.kwai.sodler.lib.a.a) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.f f(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            new StringBuilder("Loading plugin, id = ").append(fVar.getId());
            fVar.eW("Load");
            g(fVar);
            if (fVar.isCanceled()) {
                a(fVar);
                return fVar;
            }
            fVar.Fw();
            com.kwai.sodler.lib.a.a aVar = this.axj.get(fVar.getId());
            if (aVar != null && aVar.isLoaded()) {
                fVar.c(aVar);
                new StringBuilder("Load plugin success, path = ").append(aVar.Fh());
                fVar.cG(0);
                h(fVar);
                return fVar;
            }
            List<com.kwai.sodler.lib.c.a> Fu = fVar.Fu();
            com.kwai.sodler.lib.c.b k = f.k(fVar);
            if (k == null) {
                fVar.cG(-1);
                h(fVar);
                return fVar;
            }
            com.kwai.sodler.lib.c.a aVar2 = null;
            if (Fu != null && !Fu.isEmpty()) {
                for (com.kwai.sodler.lib.c.a aVar3 : Fu) {
                    if (k.version.equals(aVar3.version)) {
                        aVar2 = aVar3;
                    } else {
                        fVar.Fk().Fa().ag(fVar.getId(), aVar3.version);
                    }
                }
            }
            if (aVar2 != null) {
                String ai = fVar.Fk().Fa().ai(aVar2.ayz, aVar2.version);
                new StringBuilder("-------本地已存在--------").append(ai);
                fVar.eX(ai);
                fVar.eY(ai);
                fVar.cG(1);
                fVar.eT(aVar2.version);
            } else if (!ae.isWifiConnected(this.mContext) && (k.ayD || (k.ayE && fVar.Fp() > 0))) {
                b(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            } else {
                fVar.Fk().EZ().i(fVar);
            }
            if (fVar.getState() != 1) {
                h(fVar);
                return fVar;
            }
            String Fq = fVar.Fq();
            new StringBuilder("-------更新成功或者获取到本地成功------------").append(Fq);
            if (TextUtils.isEmpty(Fq)) {
                fVar.cG(-1);
                h(fVar);
                return fVar;
            }
            com.kwai.sodler.lib.a.a a = fVar.fb(Fq).a(k);
            if (fVar.isCanceled()) {
                a(fVar);
                return fVar;
            }
            try {
                fVar.c(b(fVar, a));
                new StringBuilder("Load plugin success, path = ").append(Fq);
                fVar.cG(0);
                h(fVar);
                return fVar;
            } catch (PluginError.InstallError e) {
                e = e;
                b(fVar, e);
                return fVar;
            } catch (PluginError.LoadError e2) {
                e = e2;
                b(fVar, e);
                return fVar;
            } catch (Throwable th) {
                a.e("Sodler.loader", "Load plugin failed, path = " + Fq, th);
                b(fVar, new PluginError.InstallError("Load or install plugin failed", 4004));
                return fVar;
            }
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }
}
