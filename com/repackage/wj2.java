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
import com.repackage.fm2;
import com.repackage.vj2;
import com.repackage.xj2;
import com.repackage.yj2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class wj2 extends xj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final v94 d;
    public final p84 e;
    public cb3 f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public a(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755199534, "Lcom/repackage/wj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755199534, "Lcom/repackage/wj2;");
                return;
            }
        }
        g = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wj2(v94 v94Var, p84 p84Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v94Var, p84Var};
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
        this.d = v94Var;
        this.e = p84Var;
    }

    @Override // com.repackage.xj2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                zx1.k("SwanExtractor", "#onInstallFaild del: " + string);
                bh4.M(string);
            }
        }
    }

    @Override // com.repackage.xj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        em2 em2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                em2Var = em2.d(string);
                fm2.b e = em2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                em2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (em2Var != null && g) {
                em2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        v94 v94Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (v94Var = this.d) == null || v94Var.h != 0 || vj2.w()) {
            return;
        }
        vj2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            sc3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            zx1.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                em2 d = em2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || bb3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            cb3 cb3Var = new cb3(str);
            this.f = cb3Var;
            cb3Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || bb3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        cb3 cb3Var = this.f;
        if (cb3Var == null) {
            return;
        }
        cb3Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        p84 p84Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (p84Var = this.e) == null) {
            return;
        }
        p84Var.n(str, str2);
    }

    public final sc3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        yj2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            em2 d = em2.d(str);
            v94 v94Var = this.d;
            if (v94Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(11L);
                sc3Var.i(2320L);
                sc3Var.f("pkg info is empty");
                wc3.a().f(sc3Var);
                return sc3Var;
            }
            int i2 = v94Var.h;
            boolean z = true;
            if (i2 == 1) {
                hi1 g2 = hk2.g();
                v94 v94Var2 = this.d;
                i = g2.a(v94Var2.g, String.valueOf(v94Var2.i));
            } else if (i2 == 0) {
                i = vj2.e.i(v94Var.g, String.valueOf(v94Var.i));
            } else {
                sc3 sc3Var2 = new sc3();
                sc3Var2.k(11L);
                sc3Var2.i(2320L);
                sc3Var2.f("pkh category illegal");
                wc3.a().f(sc3Var2);
                return sc3Var2;
            }
            if (i == null) {
                sc3 sc3Var3 = new sc3();
                sc3Var3.k(11L);
                sc3Var3.i(2320L);
                sc3Var3.f("获取解压目录失败");
                wc3.a().f(sc3Var3);
                return sc3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                sc3 sc3Var4 = new sc3();
                sc3Var4.k(11L);
                sc3Var4.i(2320L);
                sc3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                wc3.a().f(sc3Var4);
                return sc3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        td3.k(new a(this), "doFallbackIfNeeded");
                        sc3 sc3Var5 = new sc3();
                        sc3Var5.k(11L);
                        sc3Var5.i(2320L);
                        sc3Var5.f("解压失败：解压文件夹创建失败");
                        wc3.a().f(sc3Var5);
                        return sc3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    yj2.c i3 = yj2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = yj2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = eh4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        yj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        t84.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    sc3 sc3Var6 = new sc3();
                    sc3Var6.k(11L);
                    if (z2) {
                        sc3Var6.i(2330L);
                        sc3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        sc3Var6.i(2320L);
                        sc3Var6.f("unzip failed");
                    }
                    wc3.a().f(sc3Var6);
                    return sc3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    sc3 sc3Var7 = new sc3();
                    sc3Var7.k(11L);
                    sc3Var7.i(2320L);
                    sc3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    wc3.a().f(sc3Var7);
                    return sc3Var7;
                }
            }
        }
        return (sc3) invokeLL.objValue;
    }
}
