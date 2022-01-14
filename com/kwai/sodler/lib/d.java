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
/* loaded from: classes3.dex */
public class d implements com.kwai.sodler.lib.kwai.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, com.kwai.sodler.lib.kwai.a> f58380b;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58380b = new ConcurrentHashMap<>();
        this.a = context.getApplicationContext();
    }

    private com.kwai.sodler.lib.kwai.a a(com.kwai.sodler.lib.kwai.f fVar, com.kwai.sodler.lib.kwai.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fVar, aVar)) == null) {
            String e2 = aVar.e();
            File file = new File(e2);
            a.b("Sodler.loader", "Loading plugin, path = " + e2);
            com.kwai.sodler.lib.kwai.e b2 = fVar.b();
            if (file.exists()) {
                String i2 = fVar.i();
                String a = fVar.a();
                aVar.b(i2);
                aVar.a(a);
                if (b2.e().c(i2, a)) {
                    String b3 = b2.e().b(i2, a);
                    if (com.kwai.sodler.lib.b.b.b(b3)) {
                        a.b("Sodler.loader", "The current version has been installed before.");
                        aVar.c(b3);
                        com.kwai.sodler.lib.kwai.a a2 = a(i2);
                        if (a2 == null) {
                            a.a("Sodler.loader", "Load plugin from installed path.");
                            aVar.a(this.a, b3);
                            a(i2, aVar);
                            return aVar;
                        }
                        a.b("Sodler.loader", "The current plugin has been loaded, id = " + a);
                        return a2;
                    }
                }
                com.kwai.sodler.lib.kwai.a a3 = a(i2);
                if (a3 != null) {
                    return a3;
                }
                a.b("Sodler.loader", "Load plugin from dest path.");
                String b4 = b2.e().b(aVar);
                aVar.c(b4);
                a.b("Sodler.loader", "installed ." + b4);
                aVar.a(this.a, b4);
                a(i2, aVar);
                if (e2.endsWith(b2.b().e())) {
                    com.kwai.sodler.lib.b.b.a(e2);
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
            } catch (Exception e2) {
                e2.printStackTrace();
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
                com.kwai.sodler.lib.kwai.a aVar = this.f58380b.get(str);
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
        com.kwai.sodler.lib.kwai.a aVar = this.f58380b.get(fVar.i());
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
            if (a.f58373g && !a(this.a)) {
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
                if (a.f58368b.equals(next.f58366b)) {
                    aVar2 = next;
                    break;
                }
            }
            if (aVar2 != null) {
                String b2 = fVar.b().e().b(aVar2.a, aVar2.f58366b);
                fVar.d(b2);
                fVar.e(b2);
                fVar.a(1);
                fVar.b(aVar2.f58366b);
                a.b("Sodler.loader", "-------本地找到--------" + b2);
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
                int i2 = 0;
                while (!fVar.f()) {
                    try {
                        fVar.a((com.kwai.sodler.lib.kwai.f) a(fVar, a2));
                        a.b("Sodler.loader", "Load plugin success, path = " + k);
                        fVar.a(0);
                        d(fVar);
                        return fVar;
                    } catch (PluginError.InstallError | PluginError.LoadError e2) {
                        a.a("Sodler.loader", e2);
                        try {
                            fVar.h();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Load fail, retry ");
                            int i3 = i2 + 1;
                            sb.append(i2);
                            a.b("Sodler.loader", sb.toString());
                            fVar.c("Retry load " + i3);
                            i2 = i3;
                        } catch (PluginError.RetryError unused) {
                            a.b("Sodler.loader", "Load plugin fail, error = " + e2.toString());
                            a(fVar, e2);
                            return fVar;
                        }
                    }
                }
                c(fVar);
                return fVar;
            }
            a.b("Sodler.loader", "-------本地需要升级--------");
            if (a.f58373g && !a(this.a)) {
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
                        this.f58380b.put(str, aVar);
                    }
                }
            }
        }
    }
}
