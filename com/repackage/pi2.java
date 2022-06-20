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
import com.repackage.oi2;
import com.repackage.qi2;
import com.repackage.ri2;
import com.repackage.yk2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class pi2 extends qi2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final o84 d;
    public final i74 e;
    public v93 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi2 a;

        public a(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755409032, "Lcom/repackage/pi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755409032, "Lcom/repackage/pi2;");
                return;
            }
        }
        g = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pi2(o84 o84Var, i74 i74Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o84Var, i74Var};
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
        this.d = o84Var;
        this.e = i74Var;
    }

    @Override // com.repackage.qi2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                sw1.k("SwanExtractor", "#onInstallFaild del: " + string);
                uf4.M(string);
            }
        }
    }

    @Override // com.repackage.qi2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        xk2 xk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                xk2Var = xk2.d(string);
                yk2.b e = xk2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                xk2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (xk2Var != null && g) {
                xk2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        o84 o84Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (o84Var = this.d) == null || o84Var.h != 0 || oi2.w()) {
            return;
        }
        oi2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            lb3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            sw1.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                xk2 d = xk2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || u93.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            v93 v93Var = new v93(str);
            this.f = v93Var;
            v93Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || u93.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        v93 v93Var = this.f;
        if (v93Var == null) {
            return;
        }
        v93Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        i74 i74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (i74Var = this.e) == null) {
            return;
        }
        i74Var.n(str, str2);
    }

    public final lb3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        ri2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            xk2 d = xk2.d(str);
            o84 o84Var = this.d;
            if (o84Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(2320L);
                lb3Var.f("pkg info is empty");
                pb3.a().f(lb3Var);
                return lb3Var;
            }
            int i2 = o84Var.h;
            boolean z = true;
            if (i2 == 1) {
                ah1 g2 = aj2.g();
                o84 o84Var2 = this.d;
                i = g2.a(o84Var2.g, String.valueOf(o84Var2.i));
            } else if (i2 == 0) {
                i = oi2.e.i(o84Var.g, String.valueOf(o84Var.i));
            } else {
                lb3 lb3Var2 = new lb3();
                lb3Var2.k(11L);
                lb3Var2.i(2320L);
                lb3Var2.f("pkh category illegal");
                pb3.a().f(lb3Var2);
                return lb3Var2;
            }
            if (i == null) {
                lb3 lb3Var3 = new lb3();
                lb3Var3.k(11L);
                lb3Var3.i(2320L);
                lb3Var3.f("获取解压目录失败");
                pb3.a().f(lb3Var3);
                return lb3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                lb3 lb3Var4 = new lb3();
                lb3Var4.k(11L);
                lb3Var4.i(2320L);
                lb3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                pb3.a().f(lb3Var4);
                return lb3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        mc3.k(new a(this), "doFallbackIfNeeded");
                        lb3 lb3Var5 = new lb3();
                        lb3Var5.k(11L);
                        lb3Var5.i(2320L);
                        lb3Var5.f("解压失败：解压文件夹创建失败");
                        pb3.a().f(lb3Var5);
                        return lb3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ri2.c i3 = ri2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = ri2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = xf4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        ri2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        m74.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    lb3 lb3Var6 = new lb3();
                    lb3Var6.k(11L);
                    if (z2) {
                        lb3Var6.i(2330L);
                        lb3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        lb3Var6.i(2320L);
                        lb3Var6.f("unzip failed");
                    }
                    pb3.a().f(lb3Var6);
                    return lb3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    lb3 lb3Var7 = new lb3();
                    lb3Var7.k(11L);
                    lb3Var7.i(2320L);
                    lb3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    pb3.a().f(lb3Var7);
                    return lb3Var7;
                }
            }
        }
        return (lb3) invokeLL.objValue;
    }
}
