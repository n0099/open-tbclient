package com.ss.android.socialbase.downloader.f;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
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

    /* renamed from: a  reason: collision with root package name */
    public volatile m f70258a;

    /* renamed from: b  reason: collision with root package name */
    public int f70259b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70260c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f70261d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f70262e;

    /* renamed from: f  reason: collision with root package name */
    public long f70263f;

    /* renamed from: g  reason: collision with root package name */
    public int f70264g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f70265h;

    public i(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
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
        this.f70261d = atomicLong;
        this.f70259b = 0;
        this.f70260c = j;
        atomicLong.set(j);
        this.f70262e = j;
        if (j2 >= j) {
            this.f70263f = j2;
        } else {
            this.f70263f = -1L;
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70261d.get() - this.f70260c : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.f70263f;
            if (j >= this.f70260c) {
                return (j - e()) + 1;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70260c : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j = this.f70261d.get();
            long j2 = this.f70263f;
            if (j2 > 0) {
                long j3 = j2 + 1;
                if (j > j3) {
                    return j3;
                }
            }
            return j;
        }
        return invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m mVar = this.f70258a;
            if (mVar != null) {
                long d2 = mVar.d();
                if (d2 > this.f70262e) {
                    return d2;
                }
            }
            return this.f70262e;
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f70263f : invokeV.longValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f70264g : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f70259b++;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f70259b--;
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f70259b : invokeV.intValue;
    }

    public JSONObject k() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = this.f70265h;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.f70265h = jSONObject;
            }
            jSONObject.put("st", c());
            jSONObject.put(com.baidu.fsg.base.statistics.k.f38352b, d());
            jSONObject.put(com.baidu.fsg.base.statistics.h.f38333a, f());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Segment{startOffset=" + this.f70260c + ",\t currentOffset=" + this.f70261d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f70263f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long j2 = this.f70260c;
            if (j < j2) {
                j = j2;
            }
            long j3 = this.f70263f;
            if (j3 > 0) {
                long j4 = j3 + 1;
                if (j > j4) {
                    j = j4;
                }
            }
            this.f70261d.set(j);
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (j >= this.f70260c) {
                this.f70263f = j;
                return;
            }
            String str = "setEndOffset: endOffset = " + j + ", segment = " + this;
            if (j == -1) {
                this.f70263f = j;
            }
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f70261d.addAndGet(j);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || j < this.f70261d.get()) {
            return;
        }
        this.f70262e = j;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f70259b = i2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f70264g = i2;
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
                sb.append(Part.CRLF);
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
        this.f70261d = atomicLong;
        this.f70259b = 0;
        this.f70260c = iVar.f70260c;
        this.f70263f = iVar.f70263f;
        atomicLong.set(iVar.f70261d.get());
        this.f70262e = this.f70261d.get();
        this.f70264g = iVar.f70264g;
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
        this.f70261d = new AtomicLong();
        this.f70259b = 0;
        this.f70260c = jSONObject.optLong("st");
        c(jSONObject.optLong(com.baidu.fsg.base.statistics.h.f38333a));
        a(jSONObject.optLong(com.baidu.fsg.base.statistics.k.f38352b));
        d(d());
    }
}
