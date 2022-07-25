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
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.o;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements com.kwai.sodler.lib.a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File axg;
    public final File axh;
    public final com.kwai.sodler.lib.ext.c axi;
    public final Context mContext;

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
        this.mContext = applicationContext;
        this.axi = cVar;
        this.axg = applicationContext.getDir(cVar.Fy(), 0);
        this.axh = this.mContext.getCacheDir();
    }

    private String ET() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.axg.getAbsolutePath() : (String) invokeV.objValue;
    }

    @Nullable
    private String a(com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? ai(aVar.getId(), aVar.getVersion()) : (String) invokeL.objValue;
    }

    public static boolean a(String str, com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, aVar)) == null) {
            if (!o.dA(str)) {
                a.w("Sodler.installer", "Plugin not found, path = " + str);
                return false;
            } else if (aVar == null || TextUtils.isEmpty(aVar.Fi()) || TextUtils.equals(ab.Y(new File(str)), aVar.Fi())) {
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
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar, z)) == null) {
            if (a(str, aVar)) {
                return true;
            }
            delete(str);
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    private void af(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) {
            o.delete(ai(str, str2));
        }
    }

    private String ah(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            return ET() + File.separator + str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            o.delete(str);
        }
    }

    private boolean m(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, this, str, str2, z)) == null) {
            if (a(ai(str, str2), null)) {
                return true;
            }
            af(str, str2);
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void ES() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.axg.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void ag(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            File file = new File(ah(str, str2));
            if (file.exists()) {
                o.O(file);
            }
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String ai(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return ET() + File.separator + str + File.separator + str2 + File.separator + this.axi.FD();
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final boolean aj(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (this.axi.FE()) {
                return false;
            }
            return m(str, str2, true);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String b(com.kwai.sodler.lib.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            String a = a(aVar);
            if (TextUtils.isEmpty(a)) {
                throw new PluginError.InstallError("Can not get install path.", 3006);
            }
            new StringBuilder("Install path = ").append(a);
            File file = new File(a);
            if (file.exists() && !this.axi.FE() && a(file.getAbsolutePath(), aVar, true)) {
                return a;
            }
            String Fh = aVar.Fh();
            new StringBuilder("Install plugin, path = ").append(Fh);
            File file2 = new File(Fh);
            if (!file2.exists()) {
                a.w("Sodler.installer", "Plugin path not exist");
                throw new PluginError.InstallError("Plugin file not exist.", 3001);
            } else if (!a(Fh, aVar, true)) {
                a.w("Sodler.installer", "Check plugin's signatures fail.");
                throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
            } else {
                StringBuilder sb = new StringBuilder("Install plugin, from = ");
                sb.append(Fh);
                sb.append(", to = ");
                sb.append(a);
                if (file2.renameTo(file)) {
                    return a;
                }
                try {
                    ES();
                    try {
                        o.d(file2, file);
                        o.O(file2);
                        return a;
                    } catch (Throwable th) {
                        a.e("Sodler.installer", th);
                        throw new PluginError.InstallError(th, 3004);
                    }
                } catch (Throwable th2) {
                    a.e("Sodler.installer", th2);
                    throw new PluginError.InstallError(th2, 3005);
                }
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final File e(String str, boolean z) {
        InterceptResult invokeLZ;
        String fg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            if (str == null || (fg = com.kwai.sodler.lib.d.b.fg(str)) == null) {
                return null;
            }
            if (!z) {
                return File.createTempFile(fg + System.currentTimeMillis(), this.axi.FC(), this.axh);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(fg);
            if (this.axi.FC() != null) {
                sb.append(this.axi.FC());
            }
            File file = new File(this.axh, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return (File) invokeLZ.objValue;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void eO(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            File file = new File(eP(str));
            if (file.exists()) {
                o.O(file);
            }
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String eP(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return ET() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }
}
