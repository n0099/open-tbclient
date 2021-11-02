package com.tencent.open.log;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f70090a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f70091b;

    /* renamed from: c  reason: collision with root package name */
    public int f70092c;

    /* renamed from: d  reason: collision with root package name */
    public int f70093d;

    /* renamed from: e  reason: collision with root package name */
    public int f70094e;

    /* renamed from: f  reason: collision with root package name */
    public long f70095f;

    /* renamed from: g  reason: collision with root package name */
    public File f70096g;

    /* renamed from: h  reason: collision with root package name */
    public int f70097h;

    /* renamed from: i  reason: collision with root package name */
    public String f70098i;
    public long j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1617044229, "Lcom/tencent/open/log/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1617044229, "Lcom/tencent/open/log/b;");
                return;
            }
        }
        f70090a = d.C2027d.a("yy.MM.dd.HH");
    }

    public b(File file, int i2, int i3, int i4, String str, long j, int i5, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j), Integer.valueOf(i5), str2, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70091b = "Tracer.File";
        this.f70092c = Integer.MAX_VALUE;
        this.f70093d = Integer.MAX_VALUE;
        this.f70094e = 4096;
        this.f70095f = 10000L;
        this.f70097h = 10;
        this.f70098i = ".log";
        this.j = Long.MAX_VALUE;
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j);
        d(i5);
        b(str2);
        b(j2);
    }

    private File[] c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            File b2 = b();
            String c2 = c(d(j));
            try {
                b2 = new File(b2, c2);
            } catch (Throwable th) {
                SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
            }
            String b3 = l.b();
            File file = null;
            if (!TextUtils.isEmpty(b3) || b3 != null) {
                try {
                    File file2 = new File(b3, c.o);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(file2, c2);
                } catch (Exception e2) {
                    SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
                }
            }
            return new File[]{b2, file};
        }
        return (File[]) invokeJ.objValue;
    }

    private String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public File[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c(System.currentTimeMillis()) : (File[]) invokeV.objValue;
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            File e2 = e();
            if (e2 != null) {
                e2.mkdirs();
            }
            return e2;
        }
        return (File) invokeV.objValue;
    }

    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f70096g : (File) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f70097h : invokeV.intValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f70091b = str;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f70092c = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f70093d = i2;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f70095f = j;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f70098i = str;
        }
    }

    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
            this.f70096g = file;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.j = j;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f70094e : invokeV.intValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f70097h = i2;
        }
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            return "com.tencent.mobileqq_connectSdk." + str + ".log";
        }
        return (String) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70091b : (String) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f70094e = i2;
        }
    }
}
