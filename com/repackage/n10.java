package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public class n10 extends k10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k10 c;
    public boolean d;

    public n10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = z;
    }

    @Override // com.repackage.k10
    public void a(String str, Bundle bundle, k10.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            this.c.a(str, bundle, cVar);
        }
    }

    @Override // com.repackage.k10
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.d();
        }
    }

    @Override // com.repackage.k10
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.c.e(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.k10
    public void f(k10.b bVar) {
        k10 o10Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.d ? i() : j()) {
                o10Var = new m10();
            } else {
                o10Var = new o10(this.d ? ".helios.ipc.default" : ".helios.ipc.isolate");
            }
            this.c = o10Var;
            o10Var.b(this.a);
            this.c.c(bVar);
        }
    }

    @Override // com.repackage.k10
    public k10.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) ? this.c.g(str, bundle) : (k10.d) invokeLL.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(new File(ProcessUtils.CMD_LINE_NAME)));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        s30.b(bufferedReader);
                        return readLine;
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    s30.b(bufferedReader2);
                    throw th;
                }
            } catch (IOException unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
            s30.b(bufferedReader);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.a.c.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String h = h();
            if (h == null) {
                return true;
            }
            Context context = this.a.c;
            String str = context.getApplicationInfo().processName;
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            if (h.startsWith(str)) {
                return h.length() == str.length() || h.charAt(str.length()) != ':';
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String h = h();
            return h != null && h.contains(":helios");
        }
        return invokeV.booleanValue;
    }
}
