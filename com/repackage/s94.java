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
/* loaded from: classes7.dex */
public class s94<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final sc4 g;
    public transient /* synthetic */ FieldHolder $fh;
    public r94 a;
    public T b;
    public File c;
    public AtomicBoolean d;
    public p94<T> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755365725, "Lcom/repackage/s94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755365725, "Lcom/repackage/s94;");
                return;
            }
        }
        g = sc4.e();
    }

    public s94(r94 r94Var, T t, p94<T> p94Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r94Var, t, p94Var};
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
        this.a = r94Var;
        this.b = t;
        this.e = p94Var;
    }

    public final void a(int i, o84 o84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, o84Var) == null) || o84Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", o84Var.toString());
            } catch (JSONException e) {
                g.g("PMSDownloadTask", "#addStatistic json put data出错", e);
            }
        }
        if (o84Var instanceof p84) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, o84Var.g);
        }
        qc4.a(o84Var.h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            o84 o84Var = this.a.b;
            if (o84Var.e != i) {
                o84Var.e = i;
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
            File c = wc4.c(this.e.d(this.b), this.a.b.l);
            this.c = c;
            if (c == null) {
                String absolutePath = i64.b().getAppContext().getCacheDir().getAbsolutePath();
                sc4 sc4Var = g;
                sc4Var.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.c = wc4.c(absolutePath, this.a.b.l);
            }
            File file = this.c;
            if (file == null) {
                g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.e.e(this.b, new k84(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.a.b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(s94<T> s94Var) {
        InterceptResult invokeL;
        r94 r94Var;
        o84 o84Var;
        r94 r94Var2;
        o84 o84Var2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s94Var)) == null) ? (s94Var == null || (r94Var = s94Var.a) == null || (o84Var = r94Var.b) == null || (r94Var2 = this.a) == null || (o84Var2 = r94Var2.b) == null || !o84Var2.equals(o84Var)) ? false : true : invokeL.booleanValue;
    }

    public h74<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (h74) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof s94)) {
                return d((s94) obj);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new e94().a(this.e.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            p94<T> p94Var = this.e;
            if (p94Var != null) {
                return p94Var.g();
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
        String o84Var = this.a.b.toString();
        g.i("PMSDownloadTask", "#run 开始下包 pkg=" + o84Var);
        w94 w94Var = new w94(this, h());
        while (true) {
            k84 k84Var = this.a.a;
            if (k84Var != null && k84Var.a == 2200) {
                return;
            }
            if (this.d.get()) {
                g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + o84Var);
                q();
                return;
            }
            w94Var.b();
            k84 k84Var2 = this.a.a;
            if (k84Var2 != null) {
                if (k84Var2.a != 2200) {
                    if (this.d.get()) {
                        g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + o84Var);
                        q();
                        return;
                    }
                    this.e.b++;
                    g.i("PMSDownloadTask", "#run 下载出错 pkg=" + o84Var + " retryCount=" + this.e.b);
                    if (this.e.b < 3) {
                        try {
                            if (!this.d.get()) {
                                Thread.sleep(this.e.b * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        r94 r94Var = this.a;
                        a(r94Var.a.a, r94Var.b);
                        return;
                    }
                } else {
                    g.i("PMSDownloadTask", "#run 下包成功 pkg=" + o84Var);
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
