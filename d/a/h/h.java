package d.a.h;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f45545a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f45546b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45547c;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f45548a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f45549b;

        /* renamed from: c  reason: collision with root package name */
        public long f45550c;

        /* renamed from: d  reason: collision with root package name */
        public long f45551d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f45550c = j;
            }
        }

        public void b(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.f45548a = arrayList;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? i() + this.f45550c < System.currentTimeMillis() / 1000 : invokeV.booleanValue;
        }

        public ArrayList<String> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45548a : (ArrayList) invokeV.objValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.f45551d = j;
            }
        }

        public void f(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
                this.f45549b = arrayList;
            }
        }

        public ArrayList<String> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45549b : (ArrayList) invokeV.objValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45550c : invokeV.longValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f45551d : invokeV.longValue;
        }
    }

    public h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45547c = false;
        this.f45546b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
        this.f45545a = str;
        this.f45547c = z;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            a aVar = this.f45546b.get(str);
            if (aVar != null && aVar.c() && this.f45547c) {
                this.f45546b.remove(str);
                k.a("Remove expired entry from %s cache while reading, host(%s)", this.f45545a, str);
                return null;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f45546b.evictAll();
            k.a("Clear %s cache", this.f45545a);
        }
    }

    public void c(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            ArrayList<String> d2 = aVar.d();
            ArrayList<String> g2 = aVar.g();
            if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
                return;
            }
            this.f45546b.put(str, aVar);
            Object[] objArr = new Object[5];
            objArr[0] = this.f45545a;
            objArr[1] = str;
            objArr[2] = d2 != null ? d2.toString() : null;
            objArr[3] = g2 != null ? g2.toString() : null;
            objArr[4] = Long.valueOf(aVar.h());
            k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f45547c = z;
        }
    }

    public ArrayList<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : this.f45546b.snapshot().keySet()) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void f(String str) {
        a a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (a2 = a(str)) != null && a2.c()) {
            this.f45546b.remove(str);
            k.a("Remove expired entry from %s cache, host(%s)", this.f45545a, str);
        }
    }
}
