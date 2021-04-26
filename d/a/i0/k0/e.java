package d.a.i0.k0;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f48573d;

    /* renamed from: b  reason: collision with root package name */
    public int f48575b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48574a = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48576c = false;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.k0.b {
        public a(e eVar) {
        }

        @Override // d.a.i0.k0.b
        public int getMaxCost() {
            return 6;
        }

        @Override // d.a.i0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.k0.b {
        public b() {
        }

        @Override // d.a.i0.k0.b
        public int getMaxCost() {
            return e.this.f48575b;
        }

        @Override // d.a.i0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    public static e b() {
        if (f48573d == null) {
            synchronized (e.class) {
                if (f48573d == null) {
                    f48573d = new e();
                }
            }
        }
        return f48573d;
    }

    public int c() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return d.a.i0.r.d0.b.j().k("page_stay_max_cost", 0);
        }
        return this.f48575b;
    }

    public boolean d() {
        return this.f48574a;
    }

    public boolean e() {
        return this.f48576c;
    }

    public void f(int i2) {
        this.f48575b = i2;
        d.a.i0.r.d0.b.j().v("page_stay_max_cost", this.f48575b);
    }

    public void g(boolean z) {
        this.f48574a = z;
    }

    public void h(boolean z) {
        this.f48576c = z;
    }

    public void i(Context context, d dVar, d.a.i0.k0.b bVar) {
        if (dVar == null || StringUtils.isNull(dVar.c())) {
            return;
        }
        if (dVar.f48564a) {
            if (bVar == null) {
                bVar = new a(this);
            }
            if (bVar.canStat(dVar)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", c.a(dVar.h()));
                statisticItem.param("obj_locate", dVar.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(dVar.f48572i)) {
                    statisticItem.param("obj_id", dVar.f48572i);
                }
                if (dVar.b() != 0) {
                    statisticItem.param("ad_source", dVar.b());
                }
                d.a.i0.i0.e.b(context, statisticItem, dVar);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (bVar == null) {
            bVar = new b();
        }
        if (bVar.isSwitchOpen() && bVar.canStat(dVar)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", c.a(dVar.h()));
            statisticItem2.param("obj_type", dVar.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(dVar.i()));
            if (dVar.d() > 0) {
                statisticItem2.param("fid", String.valueOf(dVar.d()));
            }
            if (dVar.l() > 0) {
                statisticItem2.param("tid", String.valueOf(dVar.l()));
            }
            if (!StringUtils.isNull(dVar.e())) {
                statisticItem2.param("nid", dVar.e());
            }
            if (dVar.g() > 0) {
                statisticItem2.param("pid", String.valueOf(dVar.g()));
            }
            if (!StringUtils.isNull(dVar.k)) {
                statisticItem2.param("obj_param1", dVar.k);
            }
            if (!StringUtils.isNull(dVar.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, dVar.l);
            }
            if (!StringUtils.isNull(dVar.p)) {
                statisticItem2.param("is_dynamic", dVar.p);
            }
            if (!StringUtils.isNull(dVar.q)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, dVar.q);
            }
            if (!k.isEmpty(dVar.j())) {
                statisticItem2.param("task_id", String.valueOf(dVar.j()));
            }
            if (!k.isEmpty(dVar.a())) {
                statisticItem2.param("ab_tag", dVar.a());
            }
            if (e()) {
                if (!StringUtils.isNull(dVar.f48572i)) {
                    statisticItem2.param("obj_id", dVar.f48572i);
                }
                if (!StringUtils.isNull(dVar.j)) {
                    statisticItem2.param("obj_name", dVar.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(dVar.f())) {
                statisticItem2.param("obj_location", dVar.f());
            }
            if (dVar.b() != 0) {
                statisticItem2.param("ad_source", dVar.b());
            }
            d.a.i0.i0.e.b(context, statisticItem2, dVar);
            TiebaStatic.log(statisticItem2);
        }
    }
}
