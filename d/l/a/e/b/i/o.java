package d.l.a.e.b.i;

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
/* loaded from: classes10.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f74813a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74814b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74815c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f74816d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f74817e;

    /* renamed from: f  reason: collision with root package name */
    public int f74818f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74819g;

    /* renamed from: h  reason: collision with root package name */
    public int f74820h;

    /* renamed from: i  reason: collision with root package name */
    public String f74821i;
    public final AtomicLong j;

    public o(String str, boolean z) {
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
        this.f74817e = new ArrayList();
        this.j = new AtomicLong();
        this.f74813a = str;
        this.f74816d = z;
        this.f74814b = null;
        this.f74815c = null;
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f74817e.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.j.addAndGet(j);
        }
    }

    public synchronized void d(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            synchronized (this) {
                this.f74817e.add(lVar);
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f74818f++;
                this.f74819g = true;
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o) {
                return i().equals(((o) obj).i());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized void f(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            synchronized (this) {
                try {
                    this.f74817e.remove(lVar);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f74819g = false;
            }
        }
    }

    public synchronized boolean h() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = this.f74819g;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f74820h == 0) {
                this.f74820h = i().hashCode();
            }
            return this.f74820h;
        }
        return invokeV.intValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f74821i == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f74813a);
                sb.append("_");
                String str = this.f74814b;
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append("_");
                sb.append(this.f74816d);
                this.f74821i = sb.toString();
            }
            return this.f74821i;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "UrlRecord{url='" + this.f74813a + "', ip='" + this.f74814b + "', ipFamily='" + this.f74815c + "', isMainUrl=" + this.f74816d + ", failedTimes=" + this.f74818f + ", isCurrentFailed=" + this.f74819g + '}';
        }
        return (String) invokeV.objValue;
    }

    public o(String str, String str2) {
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
        this.f74817e = new ArrayList();
        this.j = new AtomicLong();
        this.f74813a = str;
        this.f74816d = false;
        this.f74814b = str2;
        this.f74815c = b(str2);
    }
}
