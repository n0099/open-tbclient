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
import com.repackage.fj2;
import com.repackage.hj2;
import com.repackage.ij2;
import com.repackage.pl2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class gj2 extends hj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final g94 d;
    public final a84 e;
    public ma3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj2 a;

        public a(gj2 gj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gj2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755676190, "Lcom/repackage/gj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755676190, "Lcom/repackage/gj2;");
                return;
            }
        }
        g = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj2(g94 g94Var, a84 a84Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g94Var, a84Var};
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
        this.d = g94Var;
        this.e = a84Var;
    }

    @Override // com.repackage.hj2.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                jx1.k("SwanExtractor", "#onInstallFaild del: " + string);
                ng4.M(string);
            }
        }
    }

    @Override // com.repackage.hj2.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ol2 ol2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ol2Var = ol2.d(string);
                pl2.b e = ol2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ol2Var = null;
            }
            boolean k = k(Channels.newInputStream(sourceChannel), string);
            if (ol2Var != null && g) {
                ol2Var.g("SwanExtractor", "done: " + k);
            }
            return k;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        g94 g94Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (g94Var = this.d) == null || g94Var.h != 0 || fj2.w()) {
            return;
        }
        fj2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            cc3 q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            jx1.k("SwanExtractor", "#extract error=" + q);
            if (g) {
                ol2 d = ol2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || la3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            ma3 ma3Var = new ma3(str);
            this.f = ma3Var;
            ma3Var.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || la3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        ma3 ma3Var = this.f;
        if (ma3Var == null) {
            return;
        }
        ma3Var.stopWatching();
        this.f = null;
    }

    public final void p(String str, String str2) {
        a84 a84Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (a84Var = this.e) == null) {
            return;
        }
        a84Var.n(str, str2);
    }

    public final cc3 q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        ij2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ol2 d = ol2.d(str);
            g94 g94Var = this.d;
            if (g94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(11L);
                cc3Var.i(2320L);
                cc3Var.f("pkg info is empty");
                gc3.a().f(cc3Var);
                return cc3Var;
            }
            int i2 = g94Var.h;
            boolean z = true;
            if (i2 == 1) {
                rh1 g2 = rj2.g();
                g94 g94Var2 = this.d;
                i = g2.a(g94Var2.g, String.valueOf(g94Var2.i));
            } else if (i2 == 0) {
                i = fj2.e.i(g94Var.g, String.valueOf(g94Var.i));
            } else {
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(11L);
                cc3Var2.i(2320L);
                cc3Var2.f("pkh category illegal");
                gc3.a().f(cc3Var2);
                return cc3Var2;
            }
            if (i == null) {
                cc3 cc3Var3 = new cc3();
                cc3Var3.k(11L);
                cc3Var3.i(2320L);
                cc3Var3.f("获取解压目录失败");
                gc3.a().f(cc3Var3);
                return cc3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                cc3 cc3Var4 = new cc3();
                cc3Var4.k(11L);
                cc3Var4.i(2320L);
                cc3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                gc3.a().f(cc3Var4);
                return cc3Var4;
            } else {
                if (!i.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        dd3.k(new a(this), "doFallbackIfNeeded");
                        cc3 cc3Var5 = new cc3();
                        cc3Var5.k(11L);
                        cc3Var5.i(2320L);
                        cc3Var5.f("解压失败：解压文件夹创建失败");
                        gc3.a().f(cc3Var5);
                        return cc3Var5;
                    }
                }
                n(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                b().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ij2.c i3 = ij2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    m(z2);
                    if (z2) {
                        bVar = ij2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = qg4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        ij2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        e84.a(this.e, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    cc3 cc3Var6 = new cc3();
                    cc3Var6.k(11L);
                    if (z2) {
                        cc3Var6.i(2330L);
                        cc3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        cc3Var6.i(2320L);
                        cc3Var6.f("unzip failed");
                    }
                    gc3.a().f(cc3Var6);
                    return cc3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    cc3 cc3Var7 = new cc3();
                    cc3Var7.k(11L);
                    cc3Var7.i(2320L);
                    cc3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    gc3.a().f(cc3Var7);
                    return cc3Var7;
                }
            }
        }
        return (cc3) invokeLL.objValue;
    }
}
