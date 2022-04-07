package com.kwai.sodler.kwai;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.j;
import com.kwai.sodler.lib.kwai.f;
import com.kwai.sodler.lib.kwai.g;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108959625, "Lcom/kwai/sodler/kwai/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108959625, "Lcom/kwai/sodler/kwai/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (a) {
                    return;
                }
                j.a().a(context, new c.a().a("sodler").a(3).a(false).a());
                j.a().d().a(new g.a() { // from class: com.kwai.sodler.kwai.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    @Override // com.kwai.sodler.lib.kwai.g.a
                    public void a(@NonNull f fVar, File file) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, fVar, file) == null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.d("Sodler.helper", "==============start download:" + fVar);
                            g.a i = j.a().i();
                            if (i == null) {
                                return;
                            }
                            i.a(fVar, file);
                            try {
                                if (!TextUtils.isEmpty(fVar.p()) && !TextUtils.equals(com.kwai.sodler.lib.b.b.f(file), fVar.p())) {
                                    throw new PluginError.UpdateError("file md5 not equal", -4);
                                }
                                a.a((InputStream) null);
                                a.a((OutputStream) null);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                j.a h = j.a().h();
                                if (h != null) {
                                    h.a("sodler_download", String.valueOf(currentTimeMillis2));
                                }
                            } catch (Throwable th) {
                                try {
                                    throw new PluginError.UpdateError(th.getMessage(), -4);
                                } catch (Throwable th2) {
                                    a.a((InputStream) null);
                                    a.a((OutputStream) null);
                                    throw th2;
                                }
                            }
                        }
                    }
                });
                a = true;
            }
        }
    }

    public static void a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            j.a().a(aVar);
        }
    }

    public static void a(String str, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, bVar, bVar2) == null) {
            h hVar = new h(bVar, str);
            hVar.a(bVar2);
            j.a().a(hVar, 16);
        }
    }
}
