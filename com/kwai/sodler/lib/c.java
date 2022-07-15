package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.z;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements com.kwai.sodler.lib.a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;
    public final File b;
    public final Context c;
    public final com.kwai.sodler.lib.ext.c d;

    public c(Context context, com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        this.d = cVar;
        this.a = applicationContext.getDir(cVar.b(), 0);
        this.b = this.c.getCacheDir();
    }

    public static boolean a(String str, com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, aVar)) == null) {
            if (!o.c(str)) {
                a.b("Sodler.installer", "Plugin not found, path = " + str);
                return false;
            } else if (aVar == null || TextUtils.isEmpty(aVar.g()) || TextUtils.equals(z.a(new File(str)), aVar.g())) {
                new StringBuilder("Check plugin's signatures success, path = ").append(str);
                return true;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(String str, com.kwai.sodler.lib.a.a aVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, this, str, aVar, z)) == null) {
            if (a(str, aVar)) {
                return true;
            }
            c(str);
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    private boolean a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, this, str, str2, z)) == null) {
            if (a(b(str, str2), (com.kwai.sodler.lib.a.a) null)) {
                return true;
            }
            d(str, str2);
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.a.getAbsolutePath() : (String) invokeV.objValue;
    }

    @Nullable
    private String b(com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aVar)) == null) ? b(aVar.e(), aVar.c()) : (String) invokeL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            o.d(str);
        }
    }

    private void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            o.d(b(str, str2));
        }
    }

    private String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
            return b() + File.separator + str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final File a(String str, boolean z) {
        InterceptResult invokeLZ;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (str == null || (a = com.kwai.sodler.lib.d.b.a(str)) == null) {
                return null;
            }
            if (!z) {
                return File.createTempFile(a + System.currentTimeMillis(), this.d.f(), this.b);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            if (this.d.f() != null) {
                sb.append(this.d.f());
            }
            File file = new File(this.b, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return (File) invokeLZ.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String a(com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            String b = b(aVar);
            if (TextUtils.isEmpty(b)) {
                throw new PluginError.InstallError("Can not get install path.", 3006);
            }
            new StringBuilder("Install path = ").append(b);
            File file = new File(b);
            if (file.exists() && !this.d.h() && a(file.getAbsolutePath(), aVar, true)) {
                return b;
            }
            String f = aVar.f();
            new StringBuilder("Install plugin, path = ").append(f);
            File file2 = new File(f);
            if (!file2.exists()) {
                a.b("Sodler.installer", "Plugin path not exist");
                throw new PluginError.InstallError("Plugin file not exist.", 3001);
            } else if (!a(f, aVar, true)) {
                a.b("Sodler.installer", "Check plugin's signatures fail.");
                throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
            } else {
                StringBuilder sb = new StringBuilder("Install plugin, from = ");
                sb.append(f);
                sb.append(", to = ");
                sb.append(b);
                if (file2.renameTo(file)) {
                    return b;
                }
                try {
                    a();
                    try {
                        o.a(file2, file);
                        o.d(file2);
                        return b;
                    } catch (Throwable th) {
                        a.a("Sodler.installer", th);
                        throw new PluginError.InstallError(th, 3004);
                    }
                } catch (Throwable th2) {
                    a.a("Sodler.installer", th2);
                    throw new PluginError.InstallError(th2, 3005);
                }
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            File file = new File(b(str));
            if (file.exists()) {
                o.d(file);
            }
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            File file = new File(e(str, str2));
            if (file.exists()) {
                o.d(file);
            }
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return b() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            return b() + File.separator + str + File.separator + str2 + File.separator + this.d.g();
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (this.d.h()) {
                return false;
            }
            return a(str, str2, true);
        }
        return invokeLL.booleanValue;
    }
}
