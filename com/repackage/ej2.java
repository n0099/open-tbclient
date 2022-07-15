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
import com.repackage.dj2;
import com.repackage.fj2;
import com.repackage.gj2;
import com.repackage.nl2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class ej2 extends fj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final d94 d;
    public final x74 e;
    public ka3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public a(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755735772, "Lcom/repackage/ej2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755735772, "Lcom/repackage/ej2;");
                return;
            }
        }
        g = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej2(d94 d94Var, x74 x74Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d94Var, x74Var};
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
        this.d = d94Var;
        this.e = x74Var;
    }

    @Override // com.repackage.fj2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                hx1.k("SwanExtractor", "#onInstallFaild del: " + string);
                jg4.M(string);
            }
        }
    }

    @Override // com.repackage.fj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ml2 ml2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ml2Var = ml2.d(string);
                nl2.b e = ml2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ml2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ml2Var != null && g) {
                ml2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        d94 d94Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d94Var = this.d) == null || d94Var.h != 0 || dj2.w()) {
            return;
        }
        dj2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            ac3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            hx1.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ml2 d = ml2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                q("670", "package_end_decrypt");
                q("770", "na_package_end_decrypt");
                return;
            }
            q("670", "package_end_unzip");
            q("770", "na_package_end_unzip");
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                q("670", "package_start_decrypt");
                q("770", "na_package_start_decrypt");
                return;
            }
            q("670", "package_start_unzip");
            q("770", "na_package_start_unzip");
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || ja3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            ka3 ka3Var = new ka3(str);
            this.f = ka3Var;
            ka3Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ja3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        ka3 ka3Var = this.f;
        if (ka3Var == null) {
            return;
        }
        ka3Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        x74 x74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (x74Var = this.e) == null) {
            return;
        }
        x74Var.n(str, str2);
    }

    public final ac3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        gj2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ml2 d = ml2.d(str);
            d94 d94Var = this.d;
            if (d94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(2320L);
                ac3Var.f("pkg info is empty");
                ec3.a().f(ac3Var);
                return ac3Var;
            }
            int i2 = d94Var.h;
            boolean z = true;
            if (i2 == 1) {
                ph1 g2 = pj2.g();
                d94 d94Var2 = this.d;
                i = g2.a(d94Var2.g, String.valueOf(d94Var2.i));
            } else if (i2 == 0) {
                i = dj2.e.i(d94Var.g, String.valueOf(d94Var.i));
            } else {
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(11L);
                ac3Var2.i(2320L);
                ac3Var2.f("pkh category illegal");
                ec3.a().f(ac3Var2);
                return ac3Var2;
            }
            if (i == null) {
                ac3 ac3Var3 = new ac3();
                ac3Var3.k(11L);
                ac3Var3.i(2320L);
                ac3Var3.f("获取解压目录失败");
                ec3.a().f(ac3Var3);
                return ac3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ac3 ac3Var4 = new ac3();
                ac3Var4.k(11L);
                ac3Var4.i(2320L);
                ac3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                ec3.a().f(ac3Var4);
                return ac3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        bd3.k(new a(this), "doFallbackIfNeeded");
                        ac3 ac3Var5 = new ac3();
                        ac3Var5.k(11L);
                        ac3Var5.i(2320L);
                        ac3Var5.f("解压失败：解压文件夹创建失败");
                        ec3.a().f(ac3Var5);
                        return ac3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    gj2.c i3 = gj2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = gj2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = mg4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        gj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        b84.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    ac3 ac3Var6 = new ac3();
                    ac3Var6.k(11L);
                    if (z2) {
                        ac3Var6.i(2330L);
                        ac3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ac3Var6.i(2320L);
                        ac3Var6.f("unzip failed");
                    }
                    ec3.a().f(ac3Var6);
                    return ac3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ac3 ac3Var7 = new ac3();
                    ac3Var7.k(11L);
                    ac3Var7.i(2320L);
                    ac3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    ec3.a().f(ac3Var7);
                    return ac3Var7;
                }
            }
        }
        return (ac3) invokeLL.objValue;
    }
}
