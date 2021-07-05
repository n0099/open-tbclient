package d.a.r0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class m extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    public void b(h hVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && k.d().g()) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "time");
            a2.b("ishttp", hVar.s ? "1" : "0");
            a2.b("issuccess", hVar.f55457b ? "1" : "0");
            a2.b("nettype", k.d().f());
            a2.b("wt", String.valueOf(hVar.p));
            a2.b("qt", String.valueOf(hVar.f55461f));
            a2.b("connt", String.valueOf(hVar.f55462g));
            a2.b("rwt", String.valueOf(hVar.f55463h));
            a2.b("fbt", String.valueOf(hVar.f55464i));
            a2.b("abt", String.valueOf(hVar.j));
            a2.b("dect", String.valueOf(hVar.k));
            a2.b("parset", String.valueOf(hVar.l));
            a2.b("tqt", String.valueOf(hVar.n));
            a2.b("rendert", String.valueOf(hVar.o));
            a2.b("ss", String.valueOf(hVar.q));
            a2.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i2 = hVar.t) != 0) {
                a2.b("salno", String.valueOf(i2));
                long j = hVar.u;
                if (j != 0) {
                    a2.b("scosttime", String.valueOf(j));
                }
            }
            if (hVar.s) {
                a2.b("hrtn", String.valueOf(hVar.w));
                a2.b("hrtt", String.valueOf(hVar.x));
            }
            int i3 = hVar.v;
            if (i3 != 0) {
                a2.c("errcode", Integer.valueOf(i3));
            }
            if (hVar.y) {
                a2.b(Config.PLATFORM_TYPE, "1");
            } else {
                a2.b("sysct", String.valueOf(hVar.f55458c));
                a2.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.f55460e));
                a2.b("lt", String.valueOf(hVar.f55459d));
                a2.b("df", String.valueOf(hVar.m));
            }
            if (hVar.s) {
                a2.b("c_logid", String.valueOf(hVar.A));
                long j2 = hVar.z;
                if (j2 != 0) {
                    a2.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a2.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            HashMap<String, String> hashMap = hVar.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.E.entrySet()) {
                    a2.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.f55477a, a2);
        }
    }

    public void c(h hVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i2) == null) && k.d().g() && hVar.D > 0) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "time");
            a2.b("pct", String.valueOf(hVar.D));
            if (i2 == 0) {
                a2.b("pct_type", String.valueOf(100));
            } else if (i2 != 40) {
                return;
            } else {
                a2.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.f55477a, a2);
        }
    }

    public void d(h hVar, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    d.a.c.e.n.a a2 = j.a();
                    a2.b("action", "time");
                    if (z) {
                        a2.b("put", String.valueOf(hVar.B));
                    } else {
                        a2.b("pdt", String.valueOf(hVar.C));
                    }
                    a2.b("ishttp", hVar.s ? "1" : "0");
                    a2.b("issuccess", hVar.f55457b ? "1" : "0");
                    a2.b("nettype", k.d().f());
                    a2.b("qt", String.valueOf(hVar.f55461f));
                    a2.b("connt", String.valueOf(hVar.f55462g));
                    a2.b("rwt", String.valueOf(hVar.f55463h));
                    a2.b("dect", String.valueOf(hVar.k));
                    a2.b("parset", String.valueOf(hVar.l));
                    a2.b("rendert", String.valueOf(hVar.o));
                    a2.b("ss", String.valueOf(hVar.q));
                    a2.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i2 = hVar.t) != 0) {
                        a2.b("salno", String.valueOf(i2));
                        long j = hVar.u;
                        if (j != 0) {
                            a2.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i3 = hVar.v;
                    if (i3 != 0) {
                        a2.c("errcode", Integer.valueOf(i3));
                    }
                    BdStatisticsManager.getInstance().performance(this.f55477a, a2);
                }
            }
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && bVar != null && k.d().g()) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "fluency");
            a2.b("fps", String.valueOf(bVar.b()));
            BdStatisticsManager.getInstance().performance(this.f55477a, a2);
            d.a.c.e.n.a a3 = j.a();
            a3.b("action", "mem");
            a3.b("memp", String.valueOf(k.d().c()));
            BdStatisticsManager.getInstance().performance(this.f55477a, a3);
        }
    }
}
