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
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62406b;

    /* renamed from: c  reason: collision with root package name */
    public final String f62407c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f62408d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f62409e;

    /* renamed from: f  reason: collision with root package name */
    public int f62410f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62411g;

    /* renamed from: h  reason: collision with root package name */
    public int f62412h;

    /* renamed from: i  reason: collision with root package name */
    public String f62413i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f62414j;

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
        this.f62409e = new ArrayList();
        this.f62414j = new AtomicLong();
        this.a = str;
        this.f62408d = z;
        this.f62406b = null;
        this.f62407c = null;
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
            if (this.f62413i == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append("_");
                String str = this.f62406b;
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append("_");
                sb.append(this.f62408d);
                this.f62413i = sb.toString();
            }
            return this.f62413i;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void b(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) {
            synchronized (this) {
                try {
                    this.f62409e.remove(mVar);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.f62411g = false;
            }
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                z = this.f62411g;
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
            if (this.f62412h == 0) {
                this.f62412h = e().hashCode();
            }
            return this.f62412h;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f62406b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f62407c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f62408d + ", failedTimes=" + this.f62410f + ", isCurrentFailed=" + this.f62411g + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f62410f++;
                this.f62411g = true;
            }
        }
    }

    public synchronized void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            synchronized (this) {
                this.f62409e.add(mVar);
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
        this.f62409e = new ArrayList();
        this.f62414j = new AtomicLong();
        this.a = str;
        this.f62408d = false;
        this.f62406b = str2;
        this.f62407c = a(str2);
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f62409e.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f62414j.addAndGet(j2);
        }
    }
}
