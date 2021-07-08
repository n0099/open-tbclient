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
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f71865a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71866b;

    /* renamed from: c  reason: collision with root package name */
    public final String f71867c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f71868d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f71869e;

    /* renamed from: f  reason: collision with root package name */
    public int f71870f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71871g;

    /* renamed from: h  reason: collision with root package name */
    public int f71872h;

    /* renamed from: i  reason: collision with root package name */
    public String f71873i;
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
        this.f71869e = new ArrayList();
        this.j = new AtomicLong();
        this.f71865a = str;
        this.f71868d = z;
        this.f71866b = null;
        this.f71867c = null;
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f71869e.size();
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
                this.f71869e.add(lVar);
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f71870f++;
                this.f71871g = true;
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
                    this.f71869e.remove(lVar);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f71871g = false;
            }
        }
    }

    public synchronized boolean h() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = this.f71871g;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f71872h == 0) {
                this.f71872h = i().hashCode();
            }
            return this.f71872h;
        }
        return invokeV.intValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f71873i == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f71865a);
                sb.append("_");
                String str = this.f71866b;
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append("_");
                sb.append(this.f71868d);
                this.f71873i = sb.toString();
            }
            return this.f71873i;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "UrlRecord{url='" + this.f71865a + "', ip='" + this.f71866b + "', ipFamily='" + this.f71867c + "', isMainUrl=" + this.f71868d + ", failedTimes=" + this.f71870f + ", isCurrentFailed=" + this.f71871g + '}';
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
        this.f71869e = new ArrayList();
        this.j = new AtomicLong();
        this.f71865a = str;
        this.f71868d = false;
        this.f71866b = str2;
        this.f71867c = b(str2);
    }
}
