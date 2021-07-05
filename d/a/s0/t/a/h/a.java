package d.a.s0.t.a.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.h0.b.g.g;
import d.a.s0.t.a.c;
import d.a.s0.t.a.d;
import d.a.s0.t.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static a f65490e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65491a;

    /* renamed from: b  reason: collision with root package name */
    public String f65492b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65493c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f65494d;

    /* renamed from: d.a.s0.t.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1679a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC1679a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.v0.a.h().j();
            }
        }
    }

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
                return;
            }
        }
        this.f65494d = new ArrayList<>();
        this.f65491a = d.a.r0.r.d0.b.j().k("splash_ad_strategy_key", 0);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f65490e == null) {
                f65490e = new a();
            }
            return f65490e;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<b> it = this.f65494d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f65494d.clear();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65491a : invokeV.intValue;
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                e eVar = new e();
                d.a.s0.t.a.b bVar = new d.a.s0.t.a.b();
                d dVar = new d();
                c cVar = new c();
                this.f65494d.clear();
                this.f65494d.add(eVar);
                if (g.a()) {
                    this.f65494d.add(bVar);
                }
                if (this.f65491a == 101) {
                    this.f65494d.add(cVar);
                    this.f65494d.add(dVar);
                } else if (this.f65491a == 102) {
                    this.f65494d.add(dVar);
                    this.f65494d.add(cVar);
                } else {
                    if (this.f65491a != 103 && this.f65491a != 104) {
                        if (this.f65491a == 105) {
                            this.f65494d.add(cVar);
                        } else if (this.f65491a == 106) {
                            BdLog.d("splash nothing to add: " + this.f65491a);
                        } else {
                            this.f65494d.add(dVar);
                        }
                    }
                    String p = d.a.r0.r.d0.b.j().p("splash_ad_last_show_key", "");
                    this.f65492b = p;
                    if (k.isEmpty(p)) {
                        if (this.f65491a == 103) {
                            this.f65494d.add(cVar);
                            this.f65494d.add(dVar);
                        } else {
                            this.f65494d.add(dVar);
                            this.f65494d.add(cVar);
                        }
                    } else if (StringHelper.equals(this.f65492b, cVar.c())) {
                        this.f65494d.add(dVar);
                        this.f65494d.add(cVar);
                    } else {
                        this.f65494d.add(cVar);
                        this.f65494d.add(dVar);
                    }
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().isNeedBearAd(this.f65491a) : invokeV.booleanValue;
    }

    public synchronized void f(d.a.r0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (this) {
                this.f65493c = false;
                d();
                Iterator<b> it = this.f65494d.iterator();
                while (it.hasNext()) {
                    it.next().b(dVar);
                }
            }
        }
    }

    public void g(d.a.r0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            h(aVar, true);
        }
    }

    public synchronized void h(d.a.r0.k.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) {
            synchronized (this) {
                if (this.f65493c) {
                    return;
                }
                Iterator<b> it = this.f65494d.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        if (next.a() == AdLoadState.SUCCEED) {
                            this.f65493c = true;
                            next.show();
                            d.a.r0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.c()) ? "bes" : next.c());
                            i(next.c());
                            return;
                        } else if (next.a() != AdLoadState.FAILED && z) {
                            return;
                        }
                    }
                }
                if (!z) {
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 0).param("obj_type", "a064").param("obj_locate", 4).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
                }
                if (aVar != null) {
                    aVar.a("");
                }
            }
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.f65492b = str;
        d.a.r0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            int d2 = d.a.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
            c.i(d.a.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
            if ((d2 == 103 || d2 == 104) && d2 != this.f65491a) {
                this.f65492b = "";
                d.a.r0.r.d0.b.j().C("splash_ad_last_show_key");
            }
            d.a.r0.r.d0.b.j().v("splash_ad_strategy_key", d2);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
                if (l.C()) {
                    d.a.s0.v0.a.h().j();
                } else {
                    d.a.c.e.m.e.a().post(new RunnableC1679a(this));
                }
            }
            this.f65491a = d2;
        }
    }
}
