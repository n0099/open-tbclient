package d.b.i0.p0.j2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.i0.x.t;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static int f57706e;

    /* renamed from: f  reason: collision with root package name */
    public static c f57707f;

    /* renamed from: b  reason: collision with root package name */
    public C1389c f57709b;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f57711d;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f57708a = new a(2005016);

    /* renamed from: c  reason: collision with root package name */
    public Handler f57710c = new b(this, Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || c.this.f57711d == null) {
                return;
            }
            c.this.f57711d.clear();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1389c c1389c;
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1389c) || (c1389c = (C1389c) obj) == null) {
                return;
            }
            c1389c.f57716d = false;
            c1389c.f57713a = false;
            c1389c.f57714b = 0;
        }
    }

    public c() {
        f57706e = d.b.h0.r.d0.b.i().j("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f57708a);
    }

    public static c j() {
        if (f57707f == null) {
            synchronized (t.class) {
                if (f57707f == null) {
                    f57707f = new c();
                }
            }
        }
        return f57707f;
    }

    public static void l(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i).param("obj_type", i2);
        if (context != null) {
            d.b.h0.j0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(a2 a2Var) {
        if (a2Var != null && a2Var.X1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("obj_source", a2Var.R0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
            statisticItem.param("obj_param1", a2Var.V0);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", a2Var.w1());
            t.b().a(statisticItem);
        }
    }

    public void c(d.b.i0.p0.j2.b bVar, a2 a2Var) {
        if (bVar == null || !bVar.f57699a || a2Var == null || a2Var.w1() == null) {
            return;
        }
        if (this.f57711d == null) {
            this.f57711d = new SparseArray<>();
        }
        if (this.f57711d.get(bVar.f57702d) == null) {
            this.f57711d.put(bVar.f57702d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f57711d.get(bVar.f57702d);
        String w1 = a2Var.w1();
        if (bVar.f57703e >= 0) {
            w1 = w1 + "_" + bVar.f57703e;
        }
        if (hashSet.contains(w1) || f()) {
            return;
        }
        hashSet.add(w1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f57701c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", a2Var.R0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
        statisticItem.param("obj_param1", a2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param("nid", a2Var.L0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i = bVar.f57702d;
        if (i >= 0) {
            statisticItem.param("tab_id", i);
        }
        int i2 = a2Var.M1;
        if (i2 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
        }
        int i3 = (a2Var.z1() == null || (a2Var.z1().J() == null && a2Var.z1().U() == null)) ? 0 : 1;
        if (i3 != 0 && a2Var.z1().J() != null && a2Var.z1().J().u() != null && a2Var.z1().J().u().size() > 0) {
            statisticItem.param("obj_name", a2Var.z1().N ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i3);
        }
        boolean z = a2Var.getType() == a2.o3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && a2Var.T() != null && !StringUtils.isNull(a2Var.T().getName_show())) {
            statisticItem.param("obj_name", a2Var.T().getName_show());
        }
        if (!a2Var.R1() && !a2Var.Q1()) {
            if (a2Var.O1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        t.b().a(statisticItem);
        if (a2Var.y2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f57701c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", a2Var.R0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
            statisticItem2.param("obj_param1", a2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
            statisticItem2.param("tid", a2Var.w1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f57702d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f57701c);
            statisticItem3.param("tid", a2Var.w1());
            t.b().a(statisticItem3);
        }
    }

    public void d(a2 a2Var, HashSet<String> hashSet) {
        if (a2Var == null || !a2Var.t2()) {
            return;
        }
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        if (a2Var.w1() == null || hashSet.contains(a2Var.w1())) {
            return;
        }
        hashSet.add(a2Var.w1());
        t.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", a2Var.w1()));
    }

    public void e(a2 a2Var, boolean z) {
        if (a2Var == null) {
            return;
        }
        t.b().a(new StatisticItem("c12125").param("tid", a2Var.o0()).param("obj_locate", z ? 2 : 1).param("obj_id", a2Var.q1() != null ? a2Var.q1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        if (this.f57709b == null) {
            this.f57709b = new C1389c(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1389c c1389c = this.f57709b;
        if (c1389c.f57716d) {
            return true;
        }
        if (c1389c.f57713a) {
            int i = c1389c.f57714b + 1;
            c1389c.f57714b = i;
            if (currentTimeMillis - c1389c.f57715c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= f57706e) {
                    c1389c.f57716d = true;
                    h(c1389c);
                    return true;
                }
            } else {
                c1389c.f57713a = false;
                c1389c.f57714b = 0;
            }
        } else {
            c1389c.f57713a = true;
            c1389c.f57715c = currentTimeMillis;
        }
        return false;
    }

    public void g(d.b.i0.p0.j2.b bVar, a2 a2Var, int i) {
        if (bVar == null || !bVar.f57699a || a2Var == null || a2Var.w1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f57701c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", a2Var.R0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
        statisticItem.param("obj_param1", a2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param("nid", a2Var.L0());
        if (!a2Var.R1() && !a2Var.Q1()) {
            if (a2Var.O1()) {
                statisticItem.param("obj_type", 13);
            } else {
                statisticItem.param("obj_type", i);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_TO, i(a2Var));
        int i2 = bVar.f57702d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = a2Var.M1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        statisticItem.param("thread_type", a2Var.getType() == a2.o3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (a2Var.y2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f57701c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", a2Var.R0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
            statisticItem2.param("obj_param1", a2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
            statisticItem2.param("tid", a2Var.w1());
            statisticItem2.param("obj_type", i);
            statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(a2Var));
            TiebaStatic.log(statisticItem2);
        }
        if (bVar.f57702d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f57701c);
            statisticItem3.param("tid", a2Var.w1());
            t.b().a(statisticItem3);
        }
        if (a2Var.T() == null || a2Var.T().getAlaUserData() == null) {
            return;
        }
        AlaUserInfoData alaUserData = a2Var.T().getAlaUserData();
        if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
            return;
        }
        StatisticItem statisticItem4 = new StatisticItem("c11850");
        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem4);
    }

    public final void h(C1389c c1389c) {
        Message obtainMessage = this.f57710c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1389c;
        this.f57710c.removeMessages(5);
        this.f57710c.sendMessageDelayed(obtainMessage, 300000L);
    }

    public final String i(a2 a2Var) {
        if (a2Var.Y0) {
            return String.valueOf(a2Var.q0());
        }
        return String.valueOf(4);
    }

    public int k(d.b.i0.p0.j2.b bVar) {
        if (bVar == null) {
            return 5;
        }
        int i = bVar.f57704f;
        if (i > 0) {
            int i2 = bVar.f57702d;
            if (i2 == 1120 || i2 == 1121) {
                return 15;
            }
            if (bVar.f57705g == 3) {
                return 13;
            }
            return i;
        }
        int i3 = bVar.f57700b;
        if (i3 == 8) {
            i3 = 9;
        }
        if (bVar.f57702d == 504) {
            i3 = 11;
        }
        int i4 = bVar.f57702d;
        if (i4 == 1120 || i4 == 1121) {
            return 15;
        }
        return i3;
    }

    /* renamed from: d.b.i0.p0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1389c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57713a;

        /* renamed from: b  reason: collision with root package name */
        public int f57714b;

        /* renamed from: c  reason: collision with root package name */
        public long f57715c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57716d;

        public C1389c(c cVar) {
            this.f57713a = false;
            this.f57714b = 0;
            this.f57716d = false;
        }

        public /* synthetic */ C1389c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
