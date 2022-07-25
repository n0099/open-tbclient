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
import com.repackage.ej2;
import com.repackage.gj2;
import com.repackage.hj2;
import com.repackage.ol2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class fj2 extends gj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final e94 d;
    public final y74 e;
    public la3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj2 a;

        public a(fj2 fj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755705981, "Lcom/repackage/fj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755705981, "Lcom/repackage/fj2;");
                return;
            }
        }
        g = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj2(e94 e94Var, y74 y74Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e94Var, y74Var};
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
        this.d = e94Var;
        this.e = y74Var;
    }

    @Override // com.repackage.gj2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                ix1.k("SwanExtractor", "#onInstallFaild del: " + string);
                kg4.M(string);
            }
        }
    }

    @Override // com.repackage.gj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        nl2 nl2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                nl2Var = nl2.d(string);
                ol2.b e = nl2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                nl2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (nl2Var != null && g) {
                nl2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        e94 e94Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (e94Var = this.d) == null || e94Var.h != 0 || ej2.w()) {
            return;
        }
        ej2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            bc3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            ix1.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                nl2 d = nl2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || ka3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            la3 la3Var = new la3(str);
            this.f = la3Var;
            la3Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ka3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        la3 la3Var = this.f;
        if (la3Var == null) {
            return;
        }
        la3Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        y74 y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (y74Var = this.e) == null) {
            return;
        }
        y74Var.n(str, str2);
    }

    public final bc3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        hj2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            nl2 d = nl2.d(str);
            e94 e94Var = this.d;
            if (e94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(11L);
                bc3Var.i(2320L);
                bc3Var.f("pkg info is empty");
                fc3.a().f(bc3Var);
                return bc3Var;
            }
            int i2 = e94Var.h;
            boolean z = true;
            if (i2 == 1) {
                qh1 g2 = qj2.g();
                e94 e94Var2 = this.d;
                i = g2.a(e94Var2.g, String.valueOf(e94Var2.i));
            } else if (i2 == 0) {
                i = ej2.e.i(e94Var.g, String.valueOf(e94Var.i));
            } else {
                bc3 bc3Var2 = new bc3();
                bc3Var2.k(11L);
                bc3Var2.i(2320L);
                bc3Var2.f("pkh category illegal");
                fc3.a().f(bc3Var2);
                return bc3Var2;
            }
            if (i == null) {
                bc3 bc3Var3 = new bc3();
                bc3Var3.k(11L);
                bc3Var3.i(2320L);
                bc3Var3.f("获取解压目录失败");
                fc3.a().f(bc3Var3);
                return bc3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                bc3 bc3Var4 = new bc3();
                bc3Var4.k(11L);
                bc3Var4.i(2320L);
                bc3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                fc3.a().f(bc3Var4);
                return bc3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        cd3.k(new a(this), "doFallbackIfNeeded");
                        bc3 bc3Var5 = new bc3();
                        bc3Var5.k(11L);
                        bc3Var5.i(2320L);
                        bc3Var5.f("解压失败：解压文件夹创建失败");
                        fc3.a().f(bc3Var5);
                        return bc3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    hj2.c i3 = hj2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = hj2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = ng4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        hj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        c84.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    bc3 bc3Var6 = new bc3();
                    bc3Var6.k(11L);
                    if (z2) {
                        bc3Var6.i(2330L);
                        bc3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        bc3Var6.i(2320L);
                        bc3Var6.f("unzip failed");
                    }
                    fc3.a().f(bc3Var6);
                    return bc3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    bc3 bc3Var7 = new bc3();
                    bc3Var7.k(11L);
                    bc3Var7.i(2320L);
                    bc3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    fc3.a().f(bc3Var7);
                    return bc3Var7;
                }
            }
        }
        return (bc3) invokeLL.objValue;
    }
}
