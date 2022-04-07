package com.kwai.sodler.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class d implements com.kwai.sodler.lib.kwai.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final ConcurrentHashMap<String, com.kwai.sodler.lib.kwai.a> b;

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
    }

    private com.kwai.sodler.lib.kwai.a a(com.kwai.sodler.lib.kwai.f fVar, com.kwai.sodler.lib.kwai.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fVar, aVar)) == null) {
            String e = aVar.e();
            File file = new File(e);
            a.b("Sodler.loader", "Loading plugin, path = " + e);
            com.kwai.sodler.lib.kwai.e b = fVar.b();
            if (file.exists()) {
                String i = fVar.i();
                String a = fVar.a();
                aVar.b(i);
                aVar.a(a);
                if (b.e().c(i, a)) {
                    String b2 = b.e().b(i, a);
                    if (com.kwai.sodler.lib.b.b.b(b2)) {
                        a.b("Sodler.loader", "The current version has been installed before.");
                        aVar.c(b2);
                        com.kwai.sodler.lib.kwai.a a2 = a(i);
                        if (a2 == null) {
                            a.a("Sodler.loader", "Load plugin from installed path.");
                            aVar.a(this.a, b2);
                            a(i, aVar);
                            return aVar;
                        }
                        a.b("Sodler.loader", "The current plugin has been loaded, id = " + a);
                        return a2;
                    }
                }
                com.kwai.sodler.lib.kwai.a a3 = a(i);
                if (a3 != null) {
                    return a3;
                }
                a.b("Sodler.loader", "Load plugin from dest path.");
                String b3 = b.e().b(aVar);
                aVar.c(b3);
                a.b("Sodler.loader", "installed ." + b3);
                aVar.a(this.a, b3);
                a(i, aVar);
                if (e.endsWith(b.b().e())) {
                    com.kwai.sodler.lib.b.b.a(e);
                }
                return aVar;
            }
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        return (com.kwai.sodler.lib.kwai.a) invokeLL.objValue;
    }

    private void a(com.kwai.sodler.lib.kwai.f fVar, PluginError pluginError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, fVar, pluginError) == null) {
            a.c("Sodler.loader", "onError state = " + fVar.c());
            fVar.a(-5);
            fVar.a(pluginError);
            d(fVar);
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    return 1 == activeNetworkInfo.getType();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(com.kwai.sodler.lib.kwai.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar) == null) {
            a.c("Sodler.loader", "onPreLoad state = " + fVar.c());
            fVar.b().g().e(fVar);
        }
    }

    private void c(com.kwai.sodler.lib.kwai.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, fVar) == null) {
            a.c("Sodler.loader", "onCanceled state = " + fVar.c());
            fVar.a(-7);
            fVar.b().g().b(fVar);
        }
    }

    private void d(com.kwai.sodler.lib.kwai.f fVar) {
        PluginError.LoadError loadError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fVar) == null) {
            a.c("Sodler.loader", "onPostLoad state = " + fVar.c());
            if (fVar.c() == 0) {
                com.kwai.sodler.lib.kwai.a l = fVar.l();
                if (l != null) {
                    fVar.b().g().a(fVar, l);
                    return;
                }
                fVar.a(-1);
            }
            if (fVar.g() != null) {
                loadError = new PluginError.LoadError(fVar.g(), 4011);
            } else {
                loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.c(), 4011);
            }
            fVar.b().g().a(fVar, loadError);
        }
    }

    public synchronized com.kwai.sodler.lib.kwai.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                com.kwai.sodler.lib.kwai.a aVar = this.b.get(str);
                if (aVar != null) {
                    if (!aVar.b()) {
                        return null;
                    }
                }
                return aVar;
            }
        }
        return (com.kwai.sodler.lib.kwai.a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e8  */
    @Override // com.kwai.sodler.lib.kwai.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.sodler.lib.kwai.f a(@NonNull com.kwai.sodler.lib.kwai.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return (com.kwai.sodler.lib.kwai.f) invokeL.objValue;
        }
        a.b("Sodler.loader", "Loading plugin, id = " + fVar.i());
        fVar.c("Load");
        b(fVar);
        if (fVar.f()) {
            c(fVar);
            return fVar;
        }
        fVar.t();
        com.kwai.sodler.lib.kwai.a aVar = this.b.get(fVar.i());
        if (aVar != null && aVar.b()) {
            fVar.a((com.kwai.sodler.lib.kwai.f) aVar);
            a.b("Sodler.loader", "Load plugin success, path = " + aVar.e());
            fVar.a(0);
            d(fVar);
            return fVar;
        }
        a.b("Sodler.loader", "------choose best plugin------------");
        a.b("Sodler.loader", "-------远程存在------------");
        List<com.kwai.sodler.lib.a.a> r = fVar.r();
        com.kwai.sodler.lib.a.b a = f.a(this.a, fVar);
        if (a == null) {
            fVar.a(-1);
            d(fVar);
            return fVar;
        }
        if (r == null || r.isEmpty()) {
            a.b("Sodler.loader", "-------本地不存在，触发更新------------");
            if (a.g && !a(this.a)) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        } else {
            a.b("Sodler.loader", "-------本地存在------------");
            com.kwai.sodler.lib.a.a aVar2 = null;
            Iterator<com.kwai.sodler.lib.a.a> it = r.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwai.sodler.lib.a.a next = it.next();
                if (a.b.equals(next.b)) {
                    aVar2 = next;
                    break;
                }
            }
            if (aVar2 != null) {
                String b = fVar.b().e().b(aVar2.a, aVar2.b);
                fVar.d(b);
                fVar.e(b);
                fVar.a(1);
                fVar.b(aVar2.b);
                a.b("Sodler.loader", "-------本地找到--------" + b);
                if (fVar.c() == 1) {
                    d(fVar);
                    return fVar;
                }
                String k = fVar.k();
                a.b("Sodler.loader", "-------更新成功或者获取到本地成功------------" + k);
                if (TextUtils.isEmpty(k)) {
                    fVar.a(-1);
                    d(fVar);
                    return fVar;
                }
                com.kwai.sodler.lib.kwai.a a2 = fVar.a(k).a(a);
                fVar.b(fVar.b().b().a());
                int i = 0;
                while (!fVar.f()) {
                    try {
                        fVar.a((com.kwai.sodler.lib.kwai.f) a(fVar, a2));
                        a.b("Sodler.loader", "Load plugin success, path = " + k);
                        fVar.a(0);
                        d(fVar);
                        return fVar;
                    } catch (PluginError.InstallError | PluginError.LoadError e) {
                        a.a("Sodler.loader", e);
                        try {
                            fVar.h();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Load fail, retry ");
                            int i2 = i + 1;
                            sb.append(i);
                            a.b("Sodler.loader", sb.toString());
                            fVar.c("Retry load " + i2);
                            i = i2;
                        } catch (PluginError.RetryError unused) {
                            a.b("Sodler.loader", "Load plugin fail, error = " + e.toString());
                            a(fVar, e);
                            return fVar;
                        }
                    }
                }
                c(fVar);
                return fVar;
            }
            a.b("Sodler.loader", "-------本地需要升级--------");
            if (a.g && !a(this.a)) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        }
        fVar.b().d().a(fVar);
        if (fVar.c() == 1) {
        }
    }

    public synchronized void a(String str, com.kwai.sodler.lib.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (aVar.b()) {
                        this.b.put(str, aVar);
                    }
                }
            }
        }
    }
}
