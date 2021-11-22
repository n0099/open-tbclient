package com.kwad.sdk.collector.model.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.kwad.sdk.collector.model.b<b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f65109a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f65110b;

    /* renamed from: c  reason: collision with root package name */
    public String f65111c;

    /* renamed from: d  reason: collision with root package name */
    public String f65112d;

    /* renamed from: e  reason: collision with root package name */
    public long f65113e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-34423350, "Lcom/kwad/sdk/collector/model/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-34423350, "Lcom/kwad/sdk/collector/model/a/b;");
                return;
            }
        }
        f65109a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    }

    public b(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65110b = -1L;
        this.f65110b = j;
        this.f65111c = str;
        this.f65112d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return 1;
            }
            int i2 = ((this.f65113e - com.kwad.sdk.collector.model.c.c(bVar)) > 0L ? 1 : ((this.f65113e - com.kwad.sdk.collector.model.c.c(bVar)) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 > 0 ? 1 : -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this.f65110b, this.f65111c, this.f65112d);
            com.kwad.sdk.collector.model.c.a(bVar, this.f65113e);
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? f65109a.format(new Date(j)) : (String) invokeJ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65111c : (String) invokeV.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f65110b = j;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65112d : (String) invokeV.objValue;
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f65113e = j;
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f65113e : invokeV.longValue;
    }

    @Override // com.kwad.sdk.collector.model.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            long j = this.f65110b;
            if (j != bVar.f65110b) {
                return false;
            }
            if (j == 0) {
                j = 1;
            }
            if (this.f65113e / j == bVar.f65113e / j && aa.a(this.f65111c, bVar.f65111c)) {
                return aa.a(this.f65112d, bVar.f65112d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long j = this.f65110b;
            if (j == 0) {
                j = 1;
            }
            long j2 = this.f65110b / j;
            String str = this.f65111c;
            int hashCode = (str != null ? str.hashCode() : 1) * 31;
            String str2 = this.f65112d;
            return ((hashCode + (str2 != null ? str2.hashCode() : 1)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "name", this.f65111c);
            q.a(jSONObject, "packageName", this.f65112d);
            q.a(jSONObject, "lastRunningTime", this.f65113e);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "AppRunningInfo{packageName='" + com.kwad.sdk.collector.model.c.b(this) + ExtendedMessageFormat.QUOTE + ", lastRunningTime=" + a(com.kwad.sdk.collector.model.c.c(this)) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
