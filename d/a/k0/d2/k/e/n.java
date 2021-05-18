package d.a.k0.d2.k.e;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f53142c;

    /* renamed from: a  reason: collision with root package name */
    public long f53143a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53144b = false;

    /* loaded from: classes5.dex */
    public class a extends d.a.j0.k0.b {
        public a(n nVar) {
        }

        @Override // d.a.j0.k0.b
        public int getMaxCost() {
            return 3;
        }

        @Override // d.a.j0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    public static n a() {
        if (f53142c == null) {
            synchronized (n.class) {
                if (f53142c == null) {
                    f53142c = new n();
                }
            }
        }
        return f53142c;
    }

    public final boolean b(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int i3 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        if (view2.getVisibility() != 0) {
            return i2 > 0 && i2 < i3 - g2;
        }
        return true;
    }

    public void c() {
        f53142c = null;
        this.f53143a = 0L;
        this.f53144b = false;
    }

    public final void d(Context context, d.a.j0.k0.d dVar) {
        if (dVar == null || StringUtils.isNull(dVar.c()) || !new a(this).canStat(dVar)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14085");
        statisticItem.param("obj_source", d.a.j0.k0.c.a(dVar.h()));
        statisticItem.param("obj_type", dVar.c());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(dVar.i()));
        if (dVar.d() > 0) {
            statisticItem.param("fid", String.valueOf(dVar.d()));
        }
        if (dVar.l() > 0) {
            statisticItem.param("tid", String.valueOf(dVar.l()));
        }
        if (!StringUtils.isNull(dVar.e())) {
            statisticItem.param("nid", dVar.e());
        }
        if (dVar.g() > 0) {
            statisticItem.param("pid", String.valueOf(dVar.g()));
        }
        if (!StringUtils.isNull(dVar.k)) {
            statisticItem.param("obj_param1", dVar.k);
        }
        if (!StringUtils.isNull(dVar.l)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, dVar.l);
        }
        if (!StringUtils.isNull(dVar.p)) {
            statisticItem.param("is_dynamic", dVar.p);
        }
        if (!StringUtils.isNull(dVar.q)) {
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, dVar.q);
        }
        if (!d.a.c.e.p.k.isEmpty(dVar.j())) {
            statisticItem.param("task_id", String.valueOf(dVar.j()));
        }
        if (!d.a.c.e.p.k.isEmpty(dVar.a())) {
            statisticItem.param("ab_tag", dVar.a());
        }
        if (!StringUtils.isNull(dVar.f())) {
            statisticItem.param("obj_location", dVar.f());
        }
        d.a.j0.i0.e.b(context, statisticItem, dVar);
        TiebaStatic.log(statisticItem);
    }

    public void e() {
        g();
    }

    public void f(boolean z, View view, View view2, d.a.j0.k0.d dVar, boolean z2) {
        if (this.f53144b) {
            z = false;
        } else {
            this.f53144b = z;
        }
        if (b(view, view2) || (z && !z2)) {
            g();
        } else if (z2) {
            i(dVar);
        }
    }

    public final void g() {
        if (this.f53143a == 0) {
            this.f53143a = System.currentTimeMillis();
        }
    }

    public void h(PbActivity pbActivity) {
        if (pbActivity != null) {
            i(pbActivity.getPageStayDurationItem());
        }
    }

    public final void i(d.a.j0.k0.d dVar) {
        if (this.f53143a > 0) {
            this.f53143a = 0L;
            dVar.v(System.currentTimeMillis() - this.f53143a);
            d(TbadkCoreApplication.getInst(), dVar);
        }
    }
}
