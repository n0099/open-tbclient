package d.a.r0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f55804a;

    /* renamed from: b  reason: collision with root package name */
    public String f55805b;

    /* renamed from: c  reason: collision with root package name */
    public int f55806c;

    /* renamed from: d  reason: collision with root package name */
    public long f55807d;

    /* renamed from: e  reason: collision with root package name */
    public int f55808e;

    /* renamed from: f  reason: collision with root package name */
    public long f55809f;

    /* renamed from: g  reason: collision with root package name */
    public long f55810g;

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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNULL(this.f55804a) || this.f55807d <= 0) {
                return false;
            }
            int i2 = this.f55808e;
            if (i2 == 1 || i2 == 3) {
                long j = this.f55809f;
                if (j > 0) {
                    long j2 = this.f55810g;
                    return j2 > 0 && j2 > j;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b(BigdayInfo bigdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigdayInfo) == null) || bigdayInfo == null || StringUtils.isNULL(bigdayInfo.img_url) || bigdayInfo.id.longValue() <= 0) {
            return;
        }
        if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
            this.f55804a = bigdayInfo.img_url;
            this.f55805b = bigdayInfo.jump_url;
            this.f55806c = bigdayInfo.img_colour.intValue();
            this.f55807d = bigdayInfo.id.longValue();
            this.f55808e = bigdayInfo.position.intValue();
            this.f55809f = bigdayInfo.start_time.longValue();
            this.f55810g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f55807d == aVar.f55807d && StringHelper.equals(this.f55804a, aVar.f55804a) && ((this.f55805b == null && aVar.f55805b == null) || StringHelper.equals(this.f55805b, aVar.f55805b)) && this.f55806c == aVar.f55806c && this.f55808e == aVar.f55808e && this.f55809f == aVar.f55809f && this.f55810g == aVar.f55810g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
