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
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class c implements com.kwai.sodler.lib.kwai.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final File f41803b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f41804c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f41805d;

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
        this.f41804c = applicationContext;
        this.f41805d = cVar;
        this.a = applicationContext.getDir(cVar.b(), 0);
        this.f41803b = this.f41804c.getCacheDir();
    }

    @Nullable
    public String a(com.kwai.sodler.lib.kwai.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? b(aVar.c(), aVar.a()) : (String) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            com.kwai.sodler.lib.b.b.a(b(str, str2));
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            a.b("Sodler.installer", "Check plugin's validation.");
            if (com.kwai.sodler.lib.b.b.b(str)) {
                a.a("Sodler.installer", "Check plugin's signatures success, path = " + str);
                return true;
            }
            a.e("Sodler.installer", "Plugin not found, path = " + str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) {
            if (a(b(str, str2))) {
                return true;
            }
            if (z) {
                a(str, str2);
                return false;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            if (a(str)) {
                return true;
            }
            if (z) {
                b(str);
                return false;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getAbsolutePath() : (String) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public String b(com.kwai.sodler.lib.kwai.a aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            String e2 = aVar.e();
            a.c("Sodler.installer", "Install plugin, path = " + e2);
            File file = new File(e2);
            if (!file.exists()) {
                a.e("Sodler.installer", "Plugin path not exist");
                throw new PluginError.InstallError("Plugin file not exist.", 3001);
            }
            a.a("Sodler.installer", "Check plugin's signatures.");
            if (!a(e2, true)) {
                a.e("Sodler.installer", "Check plugin's signatures fail.");
                throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
            }
            String a = a(aVar);
            if (TextUtils.isEmpty(a)) {
                throw new PluginError.InstallError("Can not get install path.", 3006);
            }
            a.a("Sodler.installer", "Install path = " + a);
            File file2 = new File(a);
            if (file2.exists()) {
                if (!this.f41805d.g() && a(file2.getAbsolutePath(), true)) {
                    str = "Plugin has been already installed.";
                    a.b("Sodler.installer", str);
                    return a;
                }
                a.b("Sodler.installer", "Ignore installed plugin.");
            }
            a.b("Sodler.installer", "Install plugin, from = " + e2 + ", to = " + a);
            if (!file.exists()) {
                a.e("Sodler.installer", "Plugin path not exist");
                throw new PluginError.InstallError("Plugin file not exist.", 3001);
            } else if (file.renameTo(file2)) {
                str = "Rename success.";
                a.b("Sodler.installer", str);
                return a;
            } else {
                try {
                    a();
                    try {
                        a.b("Sodler.installer", "Rename fail, try copy file.");
                        com.kwai.sodler.lib.b.b.a(file, file2);
                        return a;
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

    @Override // com.kwai.sodler.lib.kwai.c
    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            return b() + File.separator + str + File.separator + str2 + File.separator + this.f41805d.f();
        }
        return (String) invokeLL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            com.kwai.sodler.lib.b.b.a(str);
        }
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            File file = new File(e(str));
            if (file.exists()) {
                com.kwai.sodler.lib.b.b.a(file);
                return;
            }
            a.e("Sodler.installer", "Delete fail, dir not found, path = " + file.getAbsolutePath());
        }
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (this.f41805d.g()) {
                return false;
            }
            return a(str, str2, true);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return File.createTempFile(str + System.currentTimeMillis(), this.f41805d.e(), this.f41803b);
        }
        return (File) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.kwai.c
    public String e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return b() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }
}
