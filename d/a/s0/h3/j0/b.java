package d.a.s0.h3.j0;

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
import d.a.c.e.p.j;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.n.a f61296a;

    /* renamed from: b  reason: collision with root package name */
    public String f61297b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61298c;

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
        this.f61297b = null;
        this.f61298c = false;
        e(str, false);
    }

    public void a() {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61296a == null || (c2 = c()) == null || c2.f61309f == null) {
            return;
        }
        long e2 = this.f61296a.e();
        if (e2 > 3000) {
            d dVar = c2.f61309f;
            dVar.f61300a += e2;
            dVar.f61301b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i2, String str, long j, long j2, long j3) {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f61296a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f61307d;
            if (dVar == null) {
                return;
            }
            dVar.f61301b++;
            if (z2) {
                dVar.f61300a += j2;
                dVar.f61303d += j;
            } else {
                dVar.f61302c++;
            }
        } else {
            d dVar2 = c2.f61308e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f61301b++;
            if (z2) {
                dVar2.f61300a += j3;
                dVar2.f61303d += j;
            } else {
                dVar2.f61302c++;
            }
            j2 = j3;
        }
        this.f61296a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f61297b == "frsStat") {
            if (!z2 || j2 > 3000) {
                d.a.c.e.n.a aVar = new d.a.c.e.n.a("dbg");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.e(this.f61297b, d(), this.f61298c) : (e) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = j.I();
            return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3983b : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.f61297b = str;
            this.f61298c = z;
            this.f61296a = new d.a.c.e.n.a("dbg");
            c.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f61296a.g();
        }
    }
}
