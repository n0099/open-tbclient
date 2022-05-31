package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
import com.repackage.fi2;
import com.repackage.gi2;
import com.repackage.nk2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class ei2 extends fi2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final d84 d;
    public final x64 e;
    public k93 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei2 a;

        public a(ei2 ei2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ei2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755736733, "Lcom/repackage/ei2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755736733, "Lcom/repackage/ei2;");
                return;
            }
        }
        g = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei2(d84 d84Var, x64 x64Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d84Var, x64Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = d84Var;
        this.e = x64Var;
    }

    @Override // com.repackage.fi2.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                hw1.k("SwanExtractor", "#onInstallFaild del: " + string);
                kf4.M(string);
            }
        }
    }

    @Override // com.repackage.fi2.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        mk2 mk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                mk2Var = mk2.d(string);
                nk2.b e = mk2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                mk2Var = null;
            }
            boolean k = k(Channels.newInputStream(sourceChannel), string);
            if (mk2Var != null && g) {
                mk2Var.g("SwanExtractor", "done: " + k);
            }
            return k;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        d84 d84Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d84Var = this.d) == null || d84Var.h != 0 || di2.w()) {
            return;
        }
        di2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            ab3 q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            hw1.k("SwanExtractor", "#extract error=" + q);
            if (g) {
                mk2 d = mk2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + q);
            }
            b().putLong("result_error_code", q.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                p("670", "package_end_decrypt");
                p("770", "na_package_end_decrypt");
                return;
            }
            p("670", "package_end_unzip");
            p("770", "na_package_end_unzip");
        }
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                p("670", "package_start_decrypt");
                p("770", "na_package_start_decrypt");
                return;
            }
            p("670", "package_start_unzip");
            p("770", "na_package_start_unzip");
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || j93.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            k93 k93Var = new k93(str);
            this.f = k93Var;
            k93Var.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || j93.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        k93 k93Var = this.f;
        if (k93Var == null) {
            return;
        }
        k93Var.stopWatching();
        this.f = null;
    }

    public final void p(String str, String str2) {
        x64 x64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (x64Var = this.e) == null) {
            return;
        }
        x64Var.n(str, str2);
    }

    public final ab3 q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        gi2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            mk2 d = mk2.d(str);
            d84 d84Var = this.d;
            if (d84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(2320L);
                ab3Var.f("pkg info is empty");
                eb3.a().f(ab3Var);
                return ab3Var;
            }
            int i2 = d84Var.h;
            boolean z = true;
            if (i2 == 1) {
                pg1 g2 = pi2.g();
                d84 d84Var2 = this.d;
                i = g2.a(d84Var2.g, String.valueOf(d84Var2.i));
            } else if (i2 == 0) {
                i = di2.e.i(d84Var.g, String.valueOf(d84Var.i));
            } else {
                ab3 ab3Var2 = new ab3();
                ab3Var2.k(11L);
                ab3Var2.i(2320L);
                ab3Var2.f("pkh category illegal");
                eb3.a().f(ab3Var2);
                return ab3Var2;
            }
            if (i == null) {
                ab3 ab3Var3 = new ab3();
                ab3Var3.k(11L);
                ab3Var3.i(2320L);
                ab3Var3.f("获取解压目录失败");
                eb3.a().f(ab3Var3);
                return ab3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ab3 ab3Var4 = new ab3();
                ab3Var4.k(11L);
                ab3Var4.i(2320L);
                ab3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                eb3.a().f(ab3Var4);
                return ab3Var4;
            } else {
                if (!i.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        bc3.k(new a(this), "doFallbackIfNeeded");
                        ab3 ab3Var5 = new ab3();
                        ab3Var5.k(11L);
                        ab3Var5.i(2320L);
                        ab3Var5.f("解压失败：解压文件夹创建失败");
                        eb3.a().f(ab3Var5);
                        return ab3Var5;
                    }
                }
                n(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                b().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    gi2.c i3 = gi2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    m(z2);
                    if (z2) {
                        bVar = gi2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = nf4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        gi2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        b74.a(this.e, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    ab3 ab3Var6 = new ab3();
                    ab3Var6.k(11L);
                    if (z2) {
                        ab3Var6.i(2330L);
                        ab3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ab3Var6.i(2320L);
                        ab3Var6.f("unzip failed");
                    }
                    eb3.a().f(ab3Var6);
                    return ab3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ab3 ab3Var7 = new ab3();
                    ab3Var7.k(11L);
                    ab3Var7.i(2320L);
                    ab3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    eb3.a().f(ab3Var7);
                    return ab3Var7;
                }
            }
        }
        return (ab3) invokeLL.objValue;
    }
}
