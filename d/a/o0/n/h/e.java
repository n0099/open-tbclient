package d.a.o0.n.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes7.dex */
public class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f51140g;

    /* renamed from: h  reason: collision with root package name */
    public int f51141h;

    /* renamed from: i  reason: collision with root package name */
    public long f51142i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public e() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f51140g) || this.f51142i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof e)) {
                e eVar = (e) obj;
                return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f51140g.equals(eVar.f51140g) && this.f51142i == eVar.f51142i : TextUtils.equals(this.f51140g, eVar.f51140g) && this.f51142i == eVar.f51142i && TextUtils.equals(this.j, eVar.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.hash(this.f51140g, Integer.valueOf(this.f51141h), Long.valueOf(this.f51142i), this.j) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "bundleId=" + this.f51140g + ", category=" + this.f51141h + ", versionCode=" + this.f51142i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
        }
        return (String) invokeV.objValue;
    }
}
