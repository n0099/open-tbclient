package d.l.a.e.b.i;

import android.util.Log;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f74783a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f74784b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f74785c;

    /* renamed from: d  reason: collision with root package name */
    public long f74786d;

    /* renamed from: e  reason: collision with root package name */
    public int f74787e;

    /* renamed from: f  reason: collision with root package name */
    public volatile l f74788f;

    /* renamed from: g  reason: collision with root package name */
    public int f74789g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f74790h;

    /* loaded from: classes10.dex */
    public static class a implements Comparator<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iVar, iVar2)) == null) ? (int) (iVar.h() - iVar2.h()) : invokeLL.intValue;
        }
    }

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
        this.f74784b = atomicLong;
        this.f74789g = 0;
        this.f74783a = j;
        atomicLong.set(j);
        this.f74785c = j;
        if (j2 >= j) {
            this.f74786d = j2;
        } else {
            this.f74786d = -1L;
        }
    }

    public static String b(List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            Collections.sort(list, new a());
            StringBuilder sb = new StringBuilder();
            for (i iVar : list) {
                sb.append(iVar);
                sb.append(Part.CRLF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74784b.get() - this.f74783a : invokeV.longValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f74787e = i2;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long j2 = this.f74783a;
            if (j < j2) {
                j = j2;
            }
            long j3 = this.f74786d;
            if (j3 > 0) {
                long j4 = j3 + 1;
                if (j > j4) {
                    j = j4;
                }
            }
            this.f74784b.set(j);
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.f74786d;
            if (j >= this.f74783a) {
                return (j - l()) + 1;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f74789g = i2;
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f74784b.addAndGet(j);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74783a : invokeV.longValue;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (j >= this.f74783a) {
                this.f74786d = j;
                return;
            }
            Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
            if (j == -1) {
                this.f74786d = j;
            }
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j = this.f74784b.get();
            long j2 = this.f74786d;
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

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || j < this.f74784b.get()) {
            return;
        }
        this.f74785c = j;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            l lVar = this.f74788f;
            if (lVar != null) {
                long r = lVar.r();
                if (r > this.f74785c) {
                    return r;
                }
            }
            return this.f74785c;
        }
        return invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f74786d : invokeV.longValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f74787e : invokeV.intValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f74789g++;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f74789g--;
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f74789g : invokeV.intValue;
    }

    public JSONObject r() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = this.f74790h;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.f74790h = jSONObject;
            }
            jSONObject.put("st", h());
            jSONObject.put("cu", j());
            jSONObject.put("en", m());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Segment{startOffset=" + this.f74783a + ",\t currentOffset=" + this.f74784b + ",\t currentOffsetRead=" + l() + ",\t endOffset=" + this.f74786d + '}';
        }
        return (String) invokeV.objValue;
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
        this.f74784b = atomicLong;
        this.f74789g = 0;
        this.f74783a = iVar.f74783a;
        this.f74786d = iVar.f74786d;
        atomicLong.set(iVar.f74784b.get());
        this.f74785c = this.f74784b.get();
        this.f74787e = iVar.f74787e;
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
        this.f74784b = new AtomicLong();
        this.f74789g = 0;
        this.f74783a = jSONObject.optLong("st");
        i(jSONObject.optLong("en"));
        d(jSONObject.optLong("cu"));
        k(j());
    }
}
