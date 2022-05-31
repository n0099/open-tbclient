package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vd0;
import java.io.File;
import java.util.Objects;
/* loaded from: classes7.dex */
public class rd0 extends td0 {
    public static /* synthetic */ Interceptable $ic;
    public static rd0 g;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public File d;
    public Context e;
    public Boolean f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd0 a;

        public a(rd0 rd0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rd0 rd0Var = this.a;
                rd0Var.p(rd0Var.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755354317, "Lcom/repackage/rd0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755354317, "Lcom/repackage/rd0;");
        }
    }

    public rd0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "arsource";
    }

    public static synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (rd0.class) {
                if (g == null) {
                    g = new rd0();
                }
            }
        }
    }

    public static final rd0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (g == null) {
                h();
            }
            return g;
        }
        return (rd0) invokeV.objValue;
    }

    @Override // com.repackage.td0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final boolean i(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, file)) == null) {
            if (file.isDirectory()) {
                ud0.b(file);
            } else {
                ud0.d(file);
            }
            File file2 = new File(file + ".loading");
            boolean a2 = new sd0(context).a(str, file2);
            if (n()) {
                q(a2 + " assetsToSD " + file2.getAbsolutePath());
            }
            if (a2) {
                a2 = file2.renameTo(file);
            }
            if (n()) {
                q(a2 + " renameTo " + file);
            }
            if (!a2) {
                q("del temp ...");
                ud0.b(file2);
                if (file.exists()) {
                    q("del " + file);
                    ud0.b(file);
                }
            }
            return a2;
        }
        return invokeLLL.booleanValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d == null && vc0.g() != null && !TextUtils.isEmpty(wc0.a())) {
                this.d = new File(wc0.a());
            }
            return this.d;
        }
        return (File) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public void m(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, file) == null) {
            this.e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.c = (String) Objects.requireNonNull(str);
            this.d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("init " + str + " to " + file.getAbsolutePath());
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? vc0.m() : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Boolean bool = this.f;
            if (bool != null) {
                return bool.booleanValue();
            }
            String j = j();
            File l = l();
            boolean z = false;
            if (n()) {
                q(String.format("from %s to %s ", j, l));
            }
            String str = null;
            String h = (l != null && l.exists() && l.isDirectory()) ? ud0.h(new File(l, "version")) : null;
            if (!TextUtils.isEmpty(h)) {
                Context context = this.e;
                str = ud0.g(context, j + "/version");
            }
            if (n()) {
                q("assets=" + str + ", sdcard=" + h);
            }
            z = (TextUtils.isEmpty(h) || !TextUtils.equals(h, str)) ? true : true;
            this.f = Boolean.valueOf(!z);
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            if (!o() ? i(context, j(), l()) : true) {
                this.f = null;
                d(2);
            }
            if (n()) {
                q("arVersion=" + vc0.h() + ", arVersionName=" + vc0.i());
            }
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Log.d("DuAr_AssetsLoader", str);
        }
    }

    @SuppressLint({"NewApi"})
    public void r(Context context, String str, File file, vd0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, file, aVar) == null) {
            this.e = ((Context) Objects.requireNonNull(context)).getApplicationContext();
            this.c = (String) Objects.requireNonNull(str);
            this.d = (File) Objects.requireNonNull(file);
            if (n()) {
                q("start " + str + " to " + file.getAbsolutePath());
            }
            super.e(aVar);
        }
    }
}
