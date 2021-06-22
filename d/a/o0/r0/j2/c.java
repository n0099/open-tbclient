package d.a.o0.r0.j2;

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
import d.a.n0.r.q.a2;
import d.a.o0.z.t;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static int f62597e;

    /* renamed from: f  reason: collision with root package name */
    public static c f62598f;

    /* renamed from: b  reason: collision with root package name */
    public C1561c f62600b;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f62602d;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f62599a = new a(2005016);

    /* renamed from: c  reason: collision with root package name */
    public Handler f62601c = new b(this, Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || c.this.f62602d == null) {
                return;
            }
            c.this.f62602d.clear();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1561c c1561c;
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1561c) || (c1561c = (C1561c) obj) == null) {
                return;
            }
            c1561c.f62607d = false;
            c1561c.f62604a = false;
            c1561c.f62605b = 0;
        }
    }

    public c() {
        f62597e = d.a.n0.r.d0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f62599a);
    }

    public static c j() {
        if (f62598f == null) {
            synchronized (t.class) {
                if (f62598f == null) {
                    f62598f = new c();
                }
            }
        }
        return f62598f;
    }

    public static void l(FrsViewData frsViewData, int i2, int i3, Context context) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i2).param("obj_type", i3);
        if (context != null) {
            d.a.n0.j0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(a2 a2Var) {
        if (a2Var != null && a2Var.a2()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("obj_source", a2Var.T0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.U0);
            statisticItem.param("obj_param1", a2Var.X0);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", a2Var.z1());
            t.b().a(statisticItem);
        }
    }

    public void c(d.a.o0.r0.j2.b bVar, a2 a2Var) {
        if (bVar == null || !bVar.f62590a || a2Var == null || a2Var.z1() == null) {
            return;
        }
        if (this.f62602d == null) {
            this.f62602d = new SparseArray<>();
        }
        if (this.f62602d.get(bVar.f62593d) == null) {
            this.f62602d.put(bVar.f62593d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f62602d.get(bVar.f62593d);
        String z1 = a2Var.z1();
        if (bVar.f62594e >= 0) {
            z1 = z1 + "_" + bVar.f62594e;
        }
        if (hashSet.contains(z1) || f()) {
            return;
        }
        hashSet.add(z1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f62592c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", a2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.U0);
        statisticItem.param("obj_param1", a2Var.V0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.X0);
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param("nid", a2Var.M0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f62593d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = a2Var.O1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (a2Var.C1() == null || (a2Var.C1().K() == null && a2Var.C1().V() == null)) ? 0 : 1;
        if (i4 != 0 && a2Var.C1().K() != null && a2Var.C1().K().y() != null && a2Var.C1().K().y().size() > 0) {
            statisticItem.param("obj_name", a2Var.C1().N ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = a2Var.getType() == a2.t3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && a2Var.T() != null && !StringUtils.isNull(a2Var.T().getName_show())) {
            statisticItem.param("obj_name", a2Var.T().getName_show());
        }
        if (!a2Var.U1() && !a2Var.T1()) {
            if (a2Var.R1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        t.b().a(statisticItem);
        if (a2Var.D2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f62592c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", a2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.U0);
            statisticItem2.param("obj_param1", a2Var.V0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.X0);
            statisticItem2.param("tid", a2Var.z1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f62593d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f62592c);
            statisticItem3.param("tid", a2Var.z1());
            t.b().a(statisticItem3);
        }
    }

    public void d(a2 a2Var, HashSet<String> hashSet) {
        if (a2Var == null || !a2Var.y2()) {
            return;
        }
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        if (a2Var.z1() == null || hashSet.contains(a2Var.z1())) {
            return;
        }
        hashSet.add(a2Var.z1());
        t.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", a2Var.z1()));
    }

    public void e(a2 a2Var, boolean z) {
        if (a2Var == null) {
            return;
        }
        t.b().a(new StatisticItem("c12125").param("tid", a2Var.o0()).param("obj_locate", z ? 2 : 1).param("obj_id", a2Var.s1() != null ? a2Var.s1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        if (this.f62600b == null) {
            this.f62600b = new C1561c(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1561c c1561c = this.f62600b;
        if (c1561c.f62607d) {
            return true;
        }
        if (c1561c.f62604a) {
            int i2 = c1561c.f62605b + 1;
            c1561c.f62605b = i2;
            if (currentTimeMillis - c1561c.f62606c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= f62597e) {
                    c1561c.f62607d = true;
                    h(c1561c);
                    return true;
                }
            } else {
                c1561c.f62604a = false;
                c1561c.f62605b = 0;
            }
        } else {
            c1561c.f62604a = true;
            c1561c.f62606c = currentTimeMillis;
        }
        return false;
    }

    public void g(d.a.o0.r0.j2.b bVar, a2 a2Var, int i2) {
        if (bVar == null || !bVar.f62590a || a2Var == null || a2Var.z1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f62592c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", a2Var.T0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.U0);
        statisticItem.param("obj_param1", a2Var.V0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.X0);
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param("nid", a2Var.M0());
        if (!a2Var.U1() && !a2Var.T1()) {
            if (a2Var.R1()) {
                statisticItem.param("obj_type", 13);
            } else {
                statisticItem.param("obj_type", i2);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_TO, i(a2Var));
        int i3 = bVar.f62593d;
        if (i3 >= 0) {
            statisticItem.param("tab_id", i3);
        }
        int i4 = a2Var.O1;
        if (i4 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
        }
        statisticItem.param("thread_type", a2Var.getType() == a2.t3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (a2Var.D2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f62592c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", a2Var.T0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, a2Var.U0);
            statisticItem2.param("obj_param1", a2Var.V0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, a2Var.X0);
            statisticItem2.param("tid", a2Var.z1());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(a2Var));
            TiebaStatic.log(statisticItem2);
        }
        if (bVar.f62593d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f62592c);
            statisticItem3.param("tid", a2Var.z1());
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

    public final void h(C1561c c1561c) {
        Message obtainMessage = this.f62601c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1561c;
        this.f62601c.removeMessages(5);
        this.f62601c.sendMessageDelayed(obtainMessage, 300000L);
    }

    public final String i(a2 a2Var) {
        if (a2Var.a1) {
            return String.valueOf(a2Var.q0());
        }
        return String.valueOf(4);
    }

    public int k(d.a.o0.r0.j2.b bVar) {
        if (bVar == null) {
            return 5;
        }
        int i2 = bVar.f62595f;
        if (i2 > 0) {
            if (bVar.f62593d == 1120) {
                return 15;
            }
            if (bVar.f62596g == 3) {
                return 13;
            }
            return i2;
        }
        int i3 = bVar.f62591b;
        if (i3 == 8) {
            i3 = 9;
        }
        if (bVar.f62593d == 504) {
            i3 = 11;
        }
        if (bVar.f62593d == 1120) {
            return 15;
        }
        return i3;
    }

    /* renamed from: d.a.o0.r0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1561c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f62604a;

        /* renamed from: b  reason: collision with root package name */
        public int f62605b;

        /* renamed from: c  reason: collision with root package name */
        public long f62606c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62607d;

        public C1561c(c cVar) {
            this.f62604a = false;
            this.f62605b = 0;
            this.f62607d = false;
        }

        public /* synthetic */ C1561c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
