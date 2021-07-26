package d.a.p0.s.n;

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
    public String f53181a;

    /* renamed from: b  reason: collision with root package name */
    public String f53182b;

    /* renamed from: c  reason: collision with root package name */
    public int f53183c;

    /* renamed from: d  reason: collision with root package name */
    public long f53184d;

    /* renamed from: e  reason: collision with root package name */
    public int f53185e;

    /* renamed from: f  reason: collision with root package name */
    public long f53186f;

    /* renamed from: g  reason: collision with root package name */
    public long f53187g;

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
            if (StringUtils.isNULL(this.f53181a) || this.f53184d <= 0) {
                return false;
            }
            int i2 = this.f53185e;
            if (i2 == 1 || i2 == 3) {
                long j = this.f53186f;
                if (j > 0) {
                    long j2 = this.f53187g;
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
            this.f53181a = bigdayInfo.img_url;
            this.f53182b = bigdayInfo.jump_url;
            this.f53183c = bigdayInfo.img_colour.intValue();
            this.f53184d = bigdayInfo.id.longValue();
            this.f53185e = bigdayInfo.position.intValue();
            this.f53186f = bigdayInfo.start_time.longValue();
            this.f53187g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.a() && a() && this.f53184d == aVar.f53184d && StringHelper.equals(this.f53181a, aVar.f53181a) && ((this.f53182b == null && aVar.f53182b == null) || StringHelper.equals(this.f53182b, aVar.f53182b)) && this.f53183c == aVar.f53183c && this.f53185e == aVar.f53185e && this.f53186f == aVar.f53186f && this.f53187g == aVar.f53187g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
