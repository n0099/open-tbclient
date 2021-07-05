package d.a.s0.u0.j2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.a0.t;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f66182e;

    /* renamed from: f  reason: collision with root package name */
    public static c f66183f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f66184a;

    /* renamed from: b  reason: collision with root package name */
    public C1721c f66185b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f66186c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f66187d;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f66188a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66188a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f66188a.f66187d == null) {
                return;
            }
            this.f66188a.f66187d.clear();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1721c c1721c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1721c) || (c1721c = (C1721c) obj) == null) {
                    return;
                }
                c1721c.f66192d = false;
                c1721c.f66189a = false;
                c1721c.f66190b = 0;
            }
        }
    }

    public c() {
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
        this.f66184a = new a(this, 2005016);
        this.f66186c = new b(this, Looper.getMainLooper());
        f66182e = d.a.r0.r.d0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f66184a);
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f66183f == null) {
                synchronized (t.class) {
                    if (f66183f == null) {
                        f66183f = new c();
                    }
                }
            }
            return f66183f;
        }
        return (c) invokeV.objValue;
    }

    public static void l(FrsViewData frsViewData, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i2).param("obj_type", i3);
        if (context != null) {
            d.a.r0.j0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) && b2Var != null && b2Var.N1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", b2Var.Q());
            statisticItem.param("obj_source", b2Var.T0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, b2Var.U0);
            statisticItem.param("obj_param1", b2Var.X0);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", b2Var.n1());
            t.b().a(statisticItem);
        }
    }

    public void c(d.a.s0.u0.j2.b bVar, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, b2Var) == null) || bVar == null || !bVar.f66175a || b2Var == null || b2Var.n1() == null) {
            return;
        }
        if (this.f66187d == null) {
            this.f66187d = new SparseArray<>();
        }
        if (this.f66187d.get(bVar.f66178d) == null) {
            this.f66187d.put(bVar.f66178d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f66187d.get(bVar.f66178d);
        String n1 = b2Var.n1();
        if (bVar.f66179e >= 0) {
            n1 = n1 + "_" + bVar.f66179e;
        }
        if (hashSet.contains(n1) || f()) {
            return;
        }
        hashSet.add(n1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f66177c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", b2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, b2Var.U0);
        statisticItem.param("obj_param1", b2Var.V0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, b2Var.X0);
        statisticItem.param("tid", b2Var.n1());
        statisticItem.param("nid", b2Var.A0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f66178d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = b2Var.P1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (b2Var.p1() == null || (b2Var.p1().K() == null && b2Var.p1().V() == null)) ? 0 : 1;
        if (i4 != 0 && b2Var.p1().K() != null && b2Var.p1().K().y() != null && b2Var.p1().K().y().size() > 0) {
            statisticItem.param("obj_name", b2Var.p1().N ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = b2Var.getType() == b2.v3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && b2Var.H() != null && !StringUtils.isNull(b2Var.H().getName_show())) {
            statisticItem.param("obj_name", b2Var.H().getName_show());
        }
        if (!b2Var.H1() && !b2Var.G1()) {
            if (b2Var.E1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        t.b().a(statisticItem);
        if (b2Var.q2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f66177c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", b2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, b2Var.U0);
            statisticItem2.param("obj_param1", b2Var.V0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, b2Var.X0);
            statisticItem2.param("tid", b2Var.n1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f66178d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f66177c);
            statisticItem3.param("tid", b2Var.n1());
            t.b().a(statisticItem3);
        }
    }

    public void d(b2 b2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, b2Var, hashSet) == null) && b2Var != null && b2Var.l2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (b2Var.n1() == null || hashSet.contains(b2Var.n1())) {
                return;
            }
            hashSet.add(b2Var.n1());
            t.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", b2Var.n1()));
        }
    }

    public void e(b2 b2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, b2Var, z) == null) || b2Var == null) {
            return;
        }
        t.b().a(new StatisticItem("c12125").param("tid", b2Var.c0()).param("obj_locate", z ? 2 : 1).param("obj_id", b2Var.g1() != null ? b2Var.g1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f66185b == null) {
                this.f66185b = new C1721c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1721c c1721c = this.f66185b;
            if (c1721c.f66192d) {
                return true;
            }
            if (c1721c.f66189a) {
                int i2 = c1721c.f66190b + 1;
                c1721c.f66190b = i2;
                if (currentTimeMillis - c1721c.f66191c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f66182e) {
                        c1721c.f66192d = true;
                        h(c1721c);
                        return true;
                    }
                } else {
                    c1721c.f66189a = false;
                    c1721c.f66190b = 0;
                }
            } else {
                c1721c.f66189a = true;
                c1721c.f66191c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(d.a.s0.u0.j2.b bVar, b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, bVar, b2Var, i2) == null) || bVar == null || !bVar.f66175a || b2Var == null || b2Var.n1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f66177c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", b2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, b2Var.U0);
        statisticItem.param("obj_param1", b2Var.V0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, b2Var.X0);
        statisticItem.param("tid", b2Var.n1());
        statisticItem.param("nid", b2Var.A0());
        if (!b2Var.H1() && !b2Var.G1()) {
            if (b2Var.E1()) {
                statisticItem.param("obj_type", 13);
            } else {
                statisticItem.param("obj_type", i2);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_TO, i(b2Var));
        int i3 = bVar.f66178d;
        if (i3 >= 0) {
            statisticItem.param("tab_id", i3);
        }
        int i4 = b2Var.P1;
        if (i4 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
        }
        statisticItem.param("thread_type", b2Var.getType() == b2.v3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (b2Var.q2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f66177c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", b2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, b2Var.U0);
            statisticItem2.param("obj_param1", b2Var.V0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, b2Var.X0);
            statisticItem2.param("tid", b2Var.n1());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(b2Var));
            TiebaStatic.log(statisticItem2);
        }
        if (bVar.f66178d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f66177c);
            statisticItem3.param("tid", b2Var.n1());
            t.b().a(statisticItem3);
        }
        if (b2Var.H() == null || b2Var.H().getAlaUserData() == null) {
            return;
        }
        AlaUserInfoData alaUserData = b2Var.H().getAlaUserData();
        if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
            return;
        }
        StatisticItem statisticItem4 = new StatisticItem("c11850");
        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem4);
    }

    public final void h(C1721c c1721c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1721c) == null) {
            Message obtainMessage = this.f66186c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1721c;
            this.f66186c.removeMessages(5);
            this.f66186c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String i(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b2Var)) == null) {
            if (b2Var.b1) {
                return String.valueOf(b2Var.e0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int k(d.a.s0.u0.j2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f66180f;
            if (i2 > 0) {
                if (bVar.f66178d == 1120) {
                    return 15;
                }
                if (bVar.f66181g == 3) {
                    return 13;
                }
                return i2;
            }
            int i3 = bVar.f66176b;
            if (i3 == 8) {
                i3 = 9;
            }
            if (bVar.f66178d == 504) {
                i3 = 11;
            }
            if (bVar.f66178d == 1120) {
                return 15;
            }
            return i3;
        }
        return invokeL.intValue;
    }

    /* renamed from: d.a.s0.u0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1721c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f66189a;

        /* renamed from: b  reason: collision with root package name */
        public int f66190b;

        /* renamed from: c  reason: collision with root package name */
        public long f66191c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66192d;

        public C1721c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66189a = false;
            this.f66190b = 0;
            this.f66192d = false;
        }

        public /* synthetic */ C1721c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
