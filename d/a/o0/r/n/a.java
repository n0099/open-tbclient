package d.a.o0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52517a;

    /* renamed from: b  reason: collision with root package name */
    public String f52518b;

    /* renamed from: c  reason: collision with root package name */
    public int f52519c;

    /* renamed from: d  reason: collision with root package name */
    public long f52520d;

    /* renamed from: e  reason: collision with root package name */
    public int f52521e;

    /* renamed from: f  reason: collision with root package name */
    public long f52522f;

    /* renamed from: g  reason: collision with root package name */
    public long f52523g;

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
            if (StringUtils.isNULL(this.f52517a) || this.f52520d <= 0) {
                return false;
            }
            int i2 = this.f52521e;
            if (i2 == 1 || i2 == 3) {
                long j = this.f52522f;
                if (j > 0) {
                    long j2 = this.f52523g;
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
            this.f52517a = bigdayInfo.img_url;
            this.f52518b = bigdayInfo.jump_url;
            this.f52519c = bigdayInfo.img_colour.intValue();
            this.f52520d = bigdayInfo.id.longValue();
            this.f52521e = bigdayInfo.position.intValue();
            this.f52522f = bigdayInfo.start_time.longValue();
            this.f52523g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f52520d == aVar.f52520d && StringHelper.equals(this.f52517a, aVar.f52517a) && ((this.f52518b == null && aVar.f52518b == null) || StringHelper.equals(this.f52518b, aVar.f52518b)) && this.f52519c == aVar.f52519c && this.f52521e == aVar.f52521e && this.f52522f == aVar.f52522f && this.f52523g == aVar.f52523g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
