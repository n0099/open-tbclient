package d.a.q0.h3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterCallback;
import d.a.d.e.p.j;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.n.a f58627a;

    /* renamed from: b  reason: collision with root package name */
    public String f58628b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58629c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58628b = null;
        this.f58629c = false;
        e(str, false);
    }

    public void a() {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58627a == null || (c2 = c()) == null || c2.f58640f == null) {
            return;
        }
        long e2 = this.f58627a.e();
        if (e2 > 3000) {
            d dVar = c2.f58640f;
            dVar.f58631a += e2;
            dVar.f58632b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i2, String str, long j, long j2, long j3) {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f58627a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f58638d;
            if (dVar == null) {
                return;
            }
            dVar.f58632b++;
            if (z2) {
                dVar.f58631a += j2;
                dVar.f58634d += j;
            } else {
                dVar.f58633c++;
            }
        } else {
            d dVar2 = c2.f58639e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f58632b++;
            if (z2) {
                dVar2.f58631a += j3;
                dVar2.f58634d += j;
            } else {
                dVar2.f58633c++;
            }
            j2 = j3;
        }
        this.f58627a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f58628b == "frsStat") {
            if (!z2 || j2 > 3000) {
                d.a.d.e.n.a aVar = new d.a.d.e.n.a("dbg");
                aVar.b("act", "frs");
                aVar.b("result", z2 ? "0" : "1");
                aVar.b("isHttp", z ? "1" : "0");
                aVar.b("timeCost", String.valueOf(j2));
                aVar.b(RouterCallback.KEY_ERROR_CODE, String.valueOf(i2));
                aVar.b("errMsg", str);
                aVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", aVar);
            }
        }
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.e(this.f58628b, d(), this.f58629c) : (e) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = j.I();
            return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f4012b : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.f58628b = str;
            this.f58629c = z;
            this.f58627a = new d.a.d.e.n.a("dbg");
            c.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58627a.g();
        }
    }
}
