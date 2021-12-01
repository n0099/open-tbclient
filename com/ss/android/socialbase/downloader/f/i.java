package com.ss.android.socialbase.downloader.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile m a;

    /* renamed from: b  reason: collision with root package name */
    public int f61794b;

    /* renamed from: c  reason: collision with root package name */
    public final long f61795c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f61796d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f61797e;

    /* renamed from: f  reason: collision with root package name */
    public long f61798f;

    /* renamed from: g  reason: collision with root package name */
    public int f61799g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f61800h;

    public i(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AtomicLong atomicLong = new AtomicLong();
        this.f61796d = atomicLong;
        this.f61794b = 0;
        this.f61795c = j2;
        atomicLong.set(j2);
        this.f61797e = j2;
        if (j3 >= j2) {
            this.f61798f = j3;
        } else {
            this.f61798f = -1L;
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61796d.get() - this.f61795c : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.f61798f;
            if (j2 >= this.f61795c) {
                return (j2 - e()) + 1;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61795c : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j2 = this.f61796d.get();
            long j3 = this.f61798f;
            if (j3 > 0) {
                long j4 = j3 + 1;
                if (j2 > j4) {
                    return j4;
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m mVar = this.a;
            if (mVar != null) {
                long d2 = mVar.d();
                if (d2 > this.f61797e) {
                    return d2;
                }
            }
            return this.f61797e;
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f61798f : invokeV.longValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f61799g : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f61794b++;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f61794b--;
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f61794b : invokeV.intValue;
    }

    public JSONObject k() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = this.f61800h;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.f61800h = jSONObject;
            }
            jSONObject.put("st", c());
            jSONObject.put(com.baidu.fsg.base.statistics.k.f34310b, d());
            jSONObject.put(com.baidu.fsg.base.statistics.h.a, f());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Segment{startOffset=" + this.f61795c + ",\t currentOffset=" + this.f61796d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f61798f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long j3 = this.f61795c;
            if (j2 < j3) {
                j2 = j3;
            }
            long j4 = this.f61798f;
            if (j4 > 0) {
                long j5 = j4 + 1;
                if (j2 > j5) {
                    j2 = j5;
                }
            }
            this.f61796d.set(j2);
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            if (j2 >= this.f61795c) {
                this.f61798f = j2;
                return;
            }
            String str = "setEndOffset: endOffset = " + j2 + ", segment = " + this;
            if (j2 == -1) {
                this.f61798f = j2;
            }
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f61796d.addAndGet(j2);
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || j2 < this.f61796d.get()) {
            return;
        }
        this.f61797e = j2;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f61794b = i2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f61799g = i2;
        }
    }

    public static String a(List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            Collections.sort(list, new Comparator<i>() { // from class: com.ss.android.socialbase.downloader.f.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(i iVar, i iVar2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, iVar, iVar2)) == null) ? (int) (iVar.c() - iVar2.c()) : invokeLL.intValue;
                }
            });
            StringBuilder sb = new StringBuilder();
            for (i iVar : list) {
                sb.append(iVar);
                sb.append("\r\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        AtomicLong atomicLong = new AtomicLong();
        this.f61796d = atomicLong;
        this.f61794b = 0;
        this.f61795c = iVar.f61795c;
        this.f61798f = iVar.f61798f;
        atomicLong.set(iVar.f61796d.get());
        this.f61797e = this.f61796d.get();
        this.f61799g = iVar.f61799g;
    }

    public i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f61796d = new AtomicLong();
        this.f61794b = 0;
        this.f61795c = jSONObject.optLong("st");
        c(jSONObject.optLong(com.baidu.fsg.base.statistics.h.a));
        a(jSONObject.optLong(com.baidu.fsg.base.statistics.k.f34310b));
        d(d());
    }
}
