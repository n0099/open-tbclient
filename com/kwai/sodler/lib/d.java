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
import com.kwad.sdk.utils.ac;
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
    public final Context a;
    public final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> b;

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
        this.b = new ConcurrentHashMap<>();
        this.a = context.getApplicationContext();
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                com.kwai.sodler.lib.kwai.kwai.a.a((BaseDexClassLoader) classLoader);
            }
        } catch (Exception e) {
            a.a("Sodler.loader", "DvaPathClassLoader.inject failed", e);
        }
    }

    private com.kwai.sodler.lib.a.a a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fVar, aVar)) == null) {
            String f = aVar.f();
            File file = new File(f);
            new StringBuilder("Loading plugin, path = ").append(f);
            com.kwai.sodler.lib.a.e b = fVar.b();
            if (file.exists()) {
                String i = fVar.i();
                String a = fVar.a();
                com.kwai.sodler.lib.a.a a2 = a(i);
                if (a2 != null) {
                    new StringBuilder("The current plugin has been loaded, id = ").append(a);
                    return a2;
                }
                aVar.b(i);
                aVar.a(a);
                if (b.f().c(i, a)) {
                    String b2 = b.f().b(i, a);
                    if (o.b(b2)) {
                        aVar.c(b2);
                        aVar.b(this.a, b2);
                        a(i, aVar);
                        return aVar;
                    }
                }
                String a3 = b.f().a(aVar);
                aVar.c(a3);
                new StringBuilder("installed .").append(a3);
                aVar.b(this.a, a3);
                a(i, aVar);
                if (f.endsWith(b.c().f())) {
                    o.d(f);
                }
                return aVar;
            }
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        return (com.kwai.sodler.lib.a.a) invokeLL.objValue;
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, fVar, pluginError) == null) {
            new StringBuilder("onError state = ").append(fVar.c());
            fVar.a(-5);
            fVar.a(pluginError);
            d(fVar);
        }
    }

    private synchronized void a(String str, com.kwai.sodler.lib.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (aVar.d()) {
                        this.b.put(str, aVar);
                    }
                }
            }
        }
    }

    public static void b(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) {
            new StringBuilder("onPreLoad state = ").append(fVar.c());
            fVar.b().h();
        }
    }

    public static void c(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fVar) == null) {
            new StringBuilder("onCanceled state = ").append(fVar.c());
            fVar.a(-7);
            fVar.b().h().a(fVar);
        }
    }

    public static void d(com.kwai.sodler.lib.a.f fVar) {
        PluginError loadError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, fVar) == null) {
            new StringBuilder("onPostLoad state = ").append(fVar.c());
            if (fVar.c() == 0) {
                com.kwai.sodler.lib.a.a m = fVar.m();
                if (m != null) {
                    fVar.b().h().a(fVar, m);
                    return;
                }
                fVar.a(-1);
            }
            if (fVar.g() != null) {
                loadError = fVar.g() instanceof PluginError ? (PluginError) fVar.g() : new PluginError.LoadError(fVar.g(), 4011);
            } else {
                loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.c(), 4011);
            }
            fVar.b().h().a(fVar, loadError);
        }
    }

    @Override // com.kwai.sodler.lib.a.d
    public final synchronized com.kwai.sodler.lib.a.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                com.kwai.sodler.lib.a.a aVar = this.b.get(str);
                if (aVar != null) {
                    if (!aVar.d()) {
                        return null;
                    }
                }
                return aVar;
            }
        }
        return (com.kwai.sodler.lib.a.a) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            new StringBuilder("Loading plugin, id = ").append(fVar.i());
            fVar.b("Load");
            b(fVar);
            if (fVar.f()) {
                c(fVar);
                return fVar;
            }
            fVar.s();
            com.kwai.sodler.lib.a.a aVar = this.b.get(fVar.i());
            if (aVar != null && aVar.d()) {
                fVar.a((com.kwai.sodler.lib.a.f) aVar);
                new StringBuilder("Load plugin success, path = ").append(aVar.f());
                fVar.a(0);
                d(fVar);
                return fVar;
            }
            List<com.kwai.sodler.lib.c.a> q = fVar.q();
            com.kwai.sodler.lib.c.b a = f.a(fVar);
            if (a == null) {
                fVar.a(-1);
                d(fVar);
                return fVar;
            }
            com.kwai.sodler.lib.c.a aVar2 = null;
            if (q != null && !q.isEmpty()) {
                for (com.kwai.sodler.lib.c.a aVar3 : q) {
                    if (a.b.equals(aVar3.b)) {
                        aVar2 = aVar3;
                    } else {
                        fVar.b().f().a(fVar.i(), aVar3.b);
                    }
                }
            }
            if (aVar2 != null) {
                String b = fVar.b().f().b(aVar2.a, aVar2.b);
                new StringBuilder("-------本地已存在--------").append(b);
                fVar.c(b);
                fVar.d(b);
                fVar.a(1);
                fVar.a(aVar2.b);
            } else if (!ac.c(this.a) && (a.g || (a.h && fVar.k() > 0))) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            } else {
                fVar.b().e().a(fVar);
            }
            if (fVar.c() != 1) {
                d(fVar);
                return fVar;
            }
            String l = fVar.l();
            new StringBuilder("-------更新成功或者获取到本地成功------------").append(l);
            if (TextUtils.isEmpty(l)) {
                fVar.a(-1);
                d(fVar);
                return fVar;
            }
            com.kwai.sodler.lib.a.a a2 = fVar.g(l).a(a);
            if (fVar.f()) {
                c(fVar);
                return fVar;
            }
            try {
                fVar.a((com.kwai.sodler.lib.a.f) a(fVar, a2));
                new StringBuilder("Load plugin success, path = ").append(l);
                fVar.a(0);
                d(fVar);
                return fVar;
            } catch (PluginError.InstallError e) {
                e = e;
                a(fVar, e);
                return fVar;
            } catch (PluginError.LoadError e2) {
                e = e2;
                a(fVar, e);
                return fVar;
            } catch (Throwable th) {
                a.a("Sodler.loader", "Load plugin failed, path = " + l, th);
                a(fVar, new PluginError.InstallError("Load or install plugin failed", 4004));
                return fVar;
            }
        }
        return (com.kwai.sodler.lib.a.f) invokeL.objValue;
    }
}
