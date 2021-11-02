package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f69374a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69375b;

    /* renamed from: c  reason: collision with root package name */
    public final String f69376c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f69377d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f69378e;

    /* renamed from: f  reason: collision with root package name */
    public int f69379f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69380g;

    /* renamed from: h  reason: collision with root package name */
    public int f69381h;

    /* renamed from: i  reason: collision with root package name */
    public String f69382i;
    public final AtomicLong j;

    public q(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69378e = new ArrayList();
        this.j = new AtomicLong();
        this.f69374a = str;
        this.f69377d = z;
        this.f69375b = null;
        this.f69376c = null;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                int lastIndexOf = str.lastIndexOf(".");
                if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                    return null;
                }
                return str.substring(0, lastIndexOf);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f69382i == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f69374a);
                sb.append("_");
                String str = this.f69375b;
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append("_");
                sb.append(this.f69377d);
                this.f69382i = sb.toString();
            }
            return this.f69382i;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void b(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) {
            synchronized (this) {
                try {
                    this.f69378e.remove(mVar);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.f69380g = false;
            }
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                z = this.f69380g;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q) {
                return e().equals(((q) obj).e());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f69381h == 0) {
                this.f69381h = e().hashCode();
            }
            return this.f69381h;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "UrlRecord{url='" + this.f69374a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f69375b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f69376c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f69377d + ", failedTimes=" + this.f69379f + ", isCurrentFailed=" + this.f69380g + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f69379f++;
                this.f69380g = true;
            }
        }
    }

    public synchronized void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            synchronized (this) {
                this.f69378e.add(mVar);
            }
        }
    }

    public q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69378e = new ArrayList();
        this.j = new AtomicLong();
        this.f69374a = str;
        this.f69377d = false;
        this.f69375b = str2;
        this.f69376c = a(str2);
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f69378e.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.j.addAndGet(j);
        }
    }
}
