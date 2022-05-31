package com.repackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h94<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final hc4 g;
    public transient /* synthetic */ FieldHolder $fh;
    public g94 a;
    public T b;
    public File c;
    public AtomicBoolean d;
    public e94<T> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755693426, "Lcom/repackage/h94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755693426, "Lcom/repackage/h94;");
                return;
            }
        }
        g = hc4.e();
    }

    public h94(g94 g94Var, T t, e94<T> e94Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g94Var, t, e94Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new AtomicBoolean(false);
        this.a = g94Var;
        this.b = t;
        this.e = e94Var;
    }

    public final void a(int i, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, d84Var) == null) || d84Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", d84Var.toString());
            } catch (JSONException e) {
                g.g("PMSDownloadTask", "#addStatistic json put data出错", e);
            }
        }
        if (d84Var instanceof e84) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d84Var.g);
        }
        fc4.a(d84Var.h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            d84 d84Var = this.a.b;
            if (d84Var.e != i) {
                d84Var.e = i;
                if (i != 2 && i != 3 && i != 10) {
                    s(false);
                } else {
                    s(true);
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a.b.a)) {
                g.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c = lc4.c(this.e.d(this.b), this.a.b.l);
            this.c = c;
            if (c == null) {
                String absolutePath = x54.b().getAppContext().getCacheDir().getAbsolutePath();
                hc4 hc4Var = g;
                hc4Var.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.c = lc4.c(absolutePath, this.a.b.l);
            }
            File file = this.c;
            if (file == null) {
                g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.e.e(this.b, new z74(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.a.b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(h94<T> h94Var) {
        InterceptResult invokeL;
        g94 g94Var;
        d84 d84Var;
        g94 g94Var2;
        d84 d84Var2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, h94Var)) == null) ? (h94Var == null || (g94Var = h94Var.a) == null || (d84Var = g94Var.b) == null || (g94Var2 = this.a) == null || (d84Var2 = g94Var2.b) == null || !d84Var2.equals(d84Var)) ? false : true : invokeL.booleanValue;
    }

    public w64<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (w64) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof h94)) {
                return d((h94) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new t84().a(this.e.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e94<T> e94Var = this.e;
            if (e94Var != null) {
                return e94Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.a.b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.b.e : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            String d = this.e.d(this.b);
            if (d == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Throwable th) {
                g.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.a(this.b);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.e.e(this.b, this.a.a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.e.i(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.e.c(this.b);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.e.j(this.b);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.a.b.b = 0L;
            }
            b(0);
            s(false);
            this.f = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String d84Var = this.a.b.toString();
        g.i("PMSDownloadTask", "#run 开始下包 pkg=" + d84Var);
        l94 l94Var = new l94(this, h());
        while (true) {
            z74 z74Var = this.a.a;
            if (z74Var != null && z74Var.a == 2200) {
                return;
            }
            if (this.d.get()) {
                g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + d84Var);
                q();
                return;
            }
            l94Var.b();
            z74 z74Var2 = this.a.a;
            if (z74Var2 != null) {
                if (z74Var2.a != 2200) {
                    if (this.d.get()) {
                        g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + d84Var);
                        q();
                        return;
                    }
                    this.e.b++;
                    g.i("PMSDownloadTask", "#run 下载出错 pkg=" + d84Var + " retryCount=" + this.e.b);
                    if (this.e.b < 3) {
                        try {
                            if (!this.d.get()) {
                                Thread.sleep(this.e.b * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        g94 g94Var = this.a;
                        a(g94Var.a.a, g94Var.b);
                        return;
                    }
                } else {
                    g.i("PMSDownloadTask", "#run 下包成功 pkg=" + d84Var);
                    n();
                    return;
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.d.get() == z) {
            return;
        }
        this.d.set(z);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.a.b.n + ",versionName:" + this.a.b.j + ",versionCode:" + this.a.b.i + "md5:" + this.a.b.l + "bundleId:" + this.a.b.g;
        }
        return (String) invokeV.objValue;
    }
}
