package d.a.q0.h0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f57264a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f57265b;

    /* renamed from: c  reason: collision with root package name */
    public float f57266c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57267d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57268e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57265b = new ArrayList();
        this.f57267d = false;
        this.f57268e = false;
    }

    public static final b c(DnsIpData dnsIpData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dnsIpData)) == null) {
            if (dnsIpData == null) {
                return null;
            }
            b bVar = new b();
            bVar.f57264a = dnsIpData.address;
            for (int i2 = 0; i2 < dnsIpData.data.size(); i2++) {
                bVar.f57265b.add(dnsIpData.data.get(i2));
            }
            bVar.b();
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static final DnsIpData d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            DnsIpData.Builder builder = new DnsIpData.Builder();
            builder.address = bVar.f57264a;
            builder.data = new ArrayList();
            for (Integer num : bVar.f57265b) {
                builder.data.add(Integer.valueOf(num.intValue()));
            }
            return builder.build(true);
        }
        return (DnsIpData) invokeL.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f57265b.add(0, Integer.valueOf(i2));
            while (this.f57265b.size() > 49) {
                List<Integer> list = this.f57265b;
                list.remove(list.size() - 1);
            }
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int size = this.f57265b.size();
            float f2 = 0.0f;
            if (size <= 0) {
                this.f57266c = 0.0f;
                return;
            }
            int i2 = 0;
            if (size == 1) {
                this.f57266c = this.f57265b.get(0).intValue();
                return;
            }
            float f3 = 1.0f;
            for (Integer num : this.f57265b) {
                int intValue = num.intValue();
                i2 += intValue;
                f3 *= 0.5f;
                f2 += intValue * f3;
            }
            float f4 = f2 + ((f3 * i2) / size);
            this.f57266c = f4;
            if (f4 < 0.05d) {
                if (this.f57267d) {
                    return;
                }
                d.a.q0.h0.d.c().b("ip_weight_lower", this.f57264a, String.valueOf(this.f57266c));
                this.f57267d = true;
            } else if (this.f57267d && f4 > 0.5d && !this.f57268e) {
                d.a.q0.h0.d.c().b("ip_weight_lower_recover", this.f57264a, String.valueOf(this.f57266c));
                this.f57268e = true;
            }
        }
    }
}
