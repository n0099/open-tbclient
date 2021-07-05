package d.a.t.d.d;

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
import d.a.t.d.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends d.a.t.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public d.a.t.d.a f70217g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70218h;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70218h = z;
    }

    @Override // d.a.t.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            this.f70217g.a(str, bundle, cVar);
        }
    }

    @Override // d.a.t.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f70217g.d(str) : invokeL.booleanValue;
    }

    @Override // d.a.t.d.a
    public void e(a.b bVar) {
        d.a.t.d.a bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (this.f70218h ? i() : h()) {
                bVar2 = new d.a.t.d.c.a();
            } else {
                bVar2 = new b(this.f70218h ? ".helios.ipc.default" : ".helios.ipc.isolate");
            }
            this.f70217g = bVar2;
            bVar2.b(this.f70179e);
            this.f70217g.c(bVar);
        }
    }

    @Override // d.a.t.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) ? this.f70217g.f(str, bundle) : (a.d) invokeLL.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File(ProcessUtils.CMD_LINE_NAME)));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        d.a.t.g.c.a.c.b(bufferedReader);
                        return readLine;
                    }
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    th = th2;
                    d.a.t.g.c.a.c.b(bufferedReader);
                    throw th;
                }
            } catch (IOException unused2) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
            d.a.t.g.c.a.c.b(bufferedReader);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f70179e.f70183c.getSystemService("activity")).getRunningAppProcesses();
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

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String g2 = g();
            return g2 != null && g2.contains(":helios");
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String g2 = g();
            if (g2 == null) {
                return true;
            }
            Context context = this.f70179e.f70183c;
            String str = context.getApplicationInfo().processName;
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            if (g2.startsWith(str)) {
                return g2.length() == str.length() || g2.charAt(str.length()) != ':';
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
