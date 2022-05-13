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
import com.repackage.am2;
import com.repackage.qj2;
import com.repackage.sj2;
import com.repackage.tj2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class rj2 extends sj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final q94 d;
    public final k84 e;
    public xa3 f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj2 a;

        public a(rj2 rj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755348489, "Lcom/repackage/rj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755348489, "Lcom/repackage/rj2;");
                return;
            }
        }
        g = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rj2(q94 q94Var, k84 k84Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q94Var, k84Var};
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
        this.d = q94Var;
        this.e = k84Var;
    }

    @Override // com.repackage.sj2.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                ux1.k("SwanExtractor", "#onInstallFaild del: " + string);
                xg4.M(string);
            }
        }
    }

    @Override // com.repackage.sj2.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        zl2 zl2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                zl2Var = zl2.d(string);
                am2.b e = zl2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                zl2Var = null;
            }
            boolean k = k(Channels.newInputStream(sourceChannel), string);
            if (zl2Var != null && g) {
                zl2Var.g("SwanExtractor", "done: " + k);
            }
            return k;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        q94 q94Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (q94Var = this.d) == null || q94Var.h != 0 || qj2.w()) {
            return;
        }
        qj2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            nc3 q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            ux1.k("SwanExtractor", "#extract error=" + q);
            if (g) {
                zl2 d = zl2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || wa3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            xa3 xa3Var = new xa3(str);
            this.f = xa3Var;
            xa3Var.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || wa3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        xa3 xa3Var = this.f;
        if (xa3Var == null) {
            return;
        }
        xa3Var.stopWatching();
        this.f = null;
    }

    public final void p(String str, String str2) {
        k84 k84Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (k84Var = this.e) == null) {
            return;
        }
        k84Var.n(str, str2);
    }

    public final nc3 q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        tj2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            zl2 d = zl2.d(str);
            q94 q94Var = this.d;
            if (q94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(2320L);
                nc3Var.f("pkg info is empty");
                rc3.a().f(nc3Var);
                return nc3Var;
            }
            int i2 = q94Var.h;
            boolean z = true;
            if (i2 == 1) {
                ci1 g2 = ck2.g();
                q94 q94Var2 = this.d;
                i = g2.a(q94Var2.g, String.valueOf(q94Var2.i));
            } else if (i2 == 0) {
                i = qj2.e.i(q94Var.g, String.valueOf(q94Var.i));
            } else {
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(11L);
                nc3Var2.i(2320L);
                nc3Var2.f("pkh category illegal");
                rc3.a().f(nc3Var2);
                return nc3Var2;
            }
            if (i == null) {
                nc3 nc3Var3 = new nc3();
                nc3Var3.k(11L);
                nc3Var3.i(2320L);
                nc3Var3.f("获取解压目录失败");
                rc3.a().f(nc3Var3);
                return nc3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                nc3 nc3Var4 = new nc3();
                nc3Var4.k(11L);
                nc3Var4.i(2320L);
                nc3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                rc3.a().f(nc3Var4);
                return nc3Var4;
            } else {
                if (!i.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        od3.k(new a(this), "doFallbackIfNeeded");
                        nc3 nc3Var5 = new nc3();
                        nc3Var5.k(11L);
                        nc3Var5.i(2320L);
                        nc3Var5.f("解压失败：解压文件夹创建失败");
                        rc3.a().f(nc3Var5);
                        return nc3Var5;
                    }
                }
                n(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                b().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    tj2.c i3 = tj2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    m(z2);
                    if (z2) {
                        bVar = tj2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = ah4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        tj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        o84.a(this.e, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    nc3 nc3Var6 = new nc3();
                    nc3Var6.k(11L);
                    if (z2) {
                        nc3Var6.i(2330L);
                        nc3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        nc3Var6.i(2320L);
                        nc3Var6.f("unzip failed");
                    }
                    rc3.a().f(nc3Var6);
                    return nc3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    nc3 nc3Var7 = new nc3();
                    nc3Var7.k(11L);
                    nc3Var7.i(2320L);
                    nc3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    rc3.a().f(nc3Var7);
                    return nc3Var7;
                }
            }
        }
        return (nc3) invokeLL.objValue;
    }
}
