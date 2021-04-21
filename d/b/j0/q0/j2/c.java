package d.b.j0.q0.j2;

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
import d.b.i0.r.q.a2;
import d.b.j0.x.t;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static int f59827e;

    /* renamed from: f  reason: collision with root package name */
    public static c f59828f;

    /* renamed from: b  reason: collision with root package name */
    public C1475c f59830b;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f59832d;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f59829a = new a(2005016);

    /* renamed from: c  reason: collision with root package name */
    public Handler f59831c = new b(this, Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || c.this.f59832d == null) {
                return;
            }
            c.this.f59832d.clear();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1475c c1475c;
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1475c) || (c1475c = (C1475c) obj) == null) {
                return;
            }
            c1475c.f59837d = false;
            c1475c.f59834a = false;
            c1475c.f59835b = 0;
        }
    }

    public c() {
        f59827e = d.b.i0.r.d0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f59829a);
    }

    public static c j() {
        if (f59828f == null) {
            synchronized (t.class) {
                if (f59828f == null) {
                    f59828f = new c();
                }
            }
        }
        return f59828f;
    }

    public static void l(FrsViewData frsViewData, int i, int i2, Context context) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i).param("obj_type", i2);
        if (context != null) {
            d.b.i0.j0.c.b(context, param);
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

    public void c(d.b.j0.q0.j2.b bVar, a2 a2Var) {
        if (bVar == null || !bVar.f59820a || a2Var == null || a2Var.w1() == null) {
            return;
        }
        if (this.f59832d == null) {
            this.f59832d = new SparseArray<>();
        }
        if (this.f59832d.get(bVar.f59823d) == null) {
            this.f59832d.put(bVar.f59823d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f59832d.get(bVar.f59823d);
        String w1 = a2Var.w1();
        if (bVar.f59824e >= 0) {
            w1 = w1 + "_" + bVar.f59824e;
        }
        if (hashSet.contains(w1) || f()) {
            return;
        }
        hashSet.add(w1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f59822c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", a2Var.R0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
        statisticItem.param("obj_param1", a2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param("nid", a2Var.L0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i = bVar.f59823d;
        if (i >= 0) {
            statisticItem.param("tab_id", i);
        }
        int i2 = a2Var.M1;
        if (i2 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
        }
        int i3 = (a2Var.z1() == null || (a2Var.z1().K() == null && a2Var.z1().V() == null)) ? 0 : 1;
        if (i3 != 0 && a2Var.z1().K() != null && a2Var.z1().K().u() != null && a2Var.z1().K().u().size() > 0) {
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
        if (a2Var.z2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f59822c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", a2Var.R0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.S0);
            statisticItem2.param("obj_param1", a2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.V0);
            statisticItem2.param("tid", a2Var.w1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f59823d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f59822c);
            statisticItem3.param("tid", a2Var.w1());
            t.b().a(statisticItem3);
        }
    }

    public void d(a2 a2Var, HashSet<String> hashSet) {
        if (a2Var == null || !a2Var.u2()) {
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
        if (this.f59830b == null) {
            this.f59830b = new C1475c(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1475c c1475c = this.f59830b;
        if (c1475c.f59837d) {
            return true;
        }
        if (c1475c.f59834a) {
            int i = c1475c.f59835b + 1;
            c1475c.f59835b = i;
            if (currentTimeMillis - c1475c.f59836c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= f59827e) {
                    c1475c.f59837d = true;
                    h(c1475c);
                    return true;
                }
            } else {
                c1475c.f59834a = false;
                c1475c.f59835b = 0;
            }
        } else {
            c1475c.f59834a = true;
            c1475c.f59836c = currentTimeMillis;
        }
        return false;
    }

    public void g(d.b.j0.q0.j2.b bVar, a2 a2Var, int i) {
        if (bVar == null || !bVar.f59820a || a2Var == null || a2Var.w1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f59822c);
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
        int i2 = bVar.f59823d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = a2Var.M1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        statisticItem.param("thread_type", a2Var.getType() == a2.o3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (a2Var.z2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f59822c);
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
        if (bVar.f59823d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f59822c);
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

    public final void h(C1475c c1475c) {
        Message obtainMessage = this.f59831c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1475c;
        this.f59831c.removeMessages(5);
        this.f59831c.sendMessageDelayed(obtainMessage, 300000L);
    }

    public final String i(a2 a2Var) {
        if (a2Var.Y0) {
            return String.valueOf(a2Var.q0());
        }
        return String.valueOf(4);
    }

    public int k(d.b.j0.q0.j2.b bVar) {
        if (bVar == null) {
            return 5;
        }
        int i = bVar.f59825f;
        if (i > 0) {
            int i2 = bVar.f59823d;
            if (i2 == 1120 || i2 == 1121) {
                return 15;
            }
            if (bVar.f59826g == 3) {
                return 13;
            }
            return i;
        }
        int i3 = bVar.f59821b;
        if (i3 == 8) {
            i3 = 9;
        }
        if (bVar.f59823d == 504) {
            i3 = 11;
        }
        int i4 = bVar.f59823d;
        if (i4 == 1120 || i4 == 1121) {
            return 15;
        }
        return i3;
    }

    /* renamed from: d.b.j0.q0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1475c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59834a;

        /* renamed from: b  reason: collision with root package name */
        public int f59835b;

        /* renamed from: c  reason: collision with root package name */
        public long f59836c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59837d;

        public C1475c(c cVar) {
            this.f59834a = false;
            this.f59835b = 0;
            this.f59837d = false;
        }

        public /* synthetic */ C1475c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
