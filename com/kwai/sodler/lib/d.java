package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.z;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d implements com.kwai.sodler.lib.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f67120a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> f67121b;

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
        this.f67121b = new ConcurrentHashMap<>();
        this.f67120a = context.getApplicationContext();
    }

    private com.kwai.sodler.lib.a.a a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fVar, aVar)) == null) {
            String e2 = aVar.e();
            File file = new File(e2);
            a.b("Sodler.loader", "Loading plugin, path = " + e2);
            com.kwai.sodler.lib.a.e b2 = fVar.b();
            if (file.exists()) {
                String i2 = fVar.i();
                String a2 = fVar.a();
                aVar.b(i2);
                aVar.a(a2);
                if (b2.e().c(i2, a2)) {
                    String b3 = b2.e().b(i2, a2);
                    if (com.kwai.sodler.lib.c.a.b(b3)) {
                        a.b("Sodler.loader", "The current version has been installed before.");
                        aVar.c(b3);
                        com.kwai.sodler.lib.a.a a3 = a(i2);
                        if (a3 == null) {
                            a.a("Sodler.loader", "Load plugin from installed path.");
                            aVar.a(this.f67120a, b3);
                            a(i2, aVar);
                            return aVar;
                        }
                        a.b("Sodler.loader", "The current plugin has been loaded, id = " + a2);
                        return a3;
                    }
                }
                com.kwai.sodler.lib.a.a a4 = a(i2);
                if (a4 != null) {
                    return a4;
                }
                a.b("Sodler.loader", "Load plugin from dest path.");
                String b4 = b2.e().b(aVar);
                aVar.c(b4);
                a.b("Sodler.loader", "installed ." + b4);
                aVar.a(this.f67120a, b4);
                a(i2, aVar);
                if (e2.endsWith(b2.b().e())) {
                    com.kwai.sodler.lib.c.a.a(e2);
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
            a.c("Sodler.loader", "onError state = " + fVar.c());
            fVar.a(-5);
            fVar.a(pluginError);
            d(fVar);
        }
    }

    private void b(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, fVar) == null) {
            a.c("Sodler.loader", "onPreLoad state = " + fVar.c());
            fVar.b().g().e(fVar);
        }
    }

    private void c(com.kwai.sodler.lib.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar) == null) {
            a.c("Sodler.loader", "onCanceled state = " + fVar.c());
            fVar.a(-7);
            fVar.b().g().b(fVar);
        }
    }

    private void d(com.kwai.sodler.lib.a.f fVar) {
        PluginError.LoadError loadError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, fVar) == null) {
            a.c("Sodler.loader", "onPostLoad state = " + fVar.c());
            if (fVar.c() == 0) {
                com.kwai.sodler.lib.a.a l = fVar.l();
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

    public synchronized com.kwai.sodler.lib.a.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                com.kwai.sodler.lib.a.a aVar = this.f67121b.get(str);
                if (aVar != null) {
                    if (!aVar.b()) {
                        return null;
                    }
                }
                return aVar;
            }
        }
        return (com.kwai.sodler.lib.a.a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f4  */
    @Override // com.kwai.sodler.lib.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return (com.kwai.sodler.lib.a.f) invokeL.objValue;
        }
        a.b("Sodler.loader", "Loading plugin, id = " + fVar.i());
        fVar.c("Load");
        b(fVar);
        if (fVar.f()) {
            c(fVar);
            return fVar;
        }
        fVar.t();
        com.kwai.sodler.lib.a.a aVar = this.f67121b.get(fVar.i());
        if (aVar != null && aVar.b()) {
            fVar.a((com.kwai.sodler.lib.a.f) aVar);
            a.b("Sodler.loader", "Load plugin success, path = " + aVar.e());
            fVar.a(0);
            d(fVar);
            return fVar;
        }
        a.b("Sodler.loader", "------choose best plugin------------");
        a.b("Sodler.loader", "-------远程存在------------");
        List<com.kwai.sodler.lib.b.a> r = fVar.r();
        com.kwai.sodler.lib.b.b a2 = f.a(this.f67120a, fVar);
        if (a2 == null) {
            fVar.a(-1);
            d(fVar);
            return fVar;
        }
        if (r == null || r.isEmpty()) {
            a.b("Sodler.loader", "-------本地不存在，触发更新------------");
            if (a2.f67113g && !z.b(KsAdSDKImpl.get().getContext())) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        } else {
            a.b("Sodler.loader", "-------本地存在------------");
            com.kwai.sodler.lib.b.a aVar2 = null;
            Iterator<com.kwai.sodler.lib.b.a> it = r.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwai.sodler.lib.b.a next = it.next();
                if (a2.f67108b.equals(next.f67105b)) {
                    aVar2 = next;
                    break;
                }
            }
            if (aVar2 != null) {
                String b2 = fVar.b().e().b(aVar2.f67104a, aVar2.f67105b);
                fVar.d(b2);
                fVar.e(b2);
                fVar.a(1);
                fVar.b(aVar2.f67105b);
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
                com.kwai.sodler.lib.a.a a3 = fVar.a(k).a(a2);
                fVar.b(fVar.b().b().a());
                int i2 = 0;
                while (!fVar.f()) {
                    try {
                        fVar.a((com.kwai.sodler.lib.a.f) a(fVar, a3));
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
            if (a2.f67113g && !z.b(KsAdSDKImpl.get().getContext())) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        }
        fVar.b().d().a(fVar);
        if (fVar.c() == 1) {
        }
    }

    public synchronized void a(String str, com.kwai.sodler.lib.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (aVar.b()) {
                        this.f67121b.put(str, aVar);
                    }
                }
            }
        }
    }
}
