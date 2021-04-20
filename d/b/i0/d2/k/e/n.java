package d.b.i0.d2.k.e;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f54213c;

    /* renamed from: a  reason: collision with root package name */
    public long f54214a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54215b = false;

    /* loaded from: classes3.dex */
    public class a extends d.b.h0.k0.b {
        public a(n nVar) {
        }

        @Override // d.b.h0.k0.b
        public int getMaxCost() {
            return 3;
        }

        @Override // d.b.h0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    public static n a() {
        if (f54213c == null) {
            synchronized (n.class) {
                if (f54213c == null) {
                    f54213c = new n();
                }
            }
        }
        return f54213c;
    }

    public final boolean b(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int i2 = d.b.c.e.p.l.i(TbadkCoreApplication.getInst());
        int g2 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        if (view2.getVisibility() != 0) {
            return i > 0 && i < i2 - g2;
        }
        return true;
    }

    public void c() {
        f54213c = null;
        this.f54214a = 0L;
        this.f54215b = false;
    }

    public final void d(Context context, d.b.h0.k0.d dVar) {
        if (dVar == null || StringUtils.isNull(dVar.c()) || !new a(this).canStat(dVar)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14085");
        statisticItem.param("obj_source", d.b.h0.k0.c.a(dVar.h()));
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
        if (!d.b.c.e.p.k.isEmpty(dVar.j())) {
            statisticItem.param("task_id", String.valueOf(dVar.j()));
        }
        if (!d.b.c.e.p.k.isEmpty(dVar.a())) {
            statisticItem.param("ab_tag", dVar.a());
        }
        if (!StringUtils.isNull(dVar.f())) {
            statisticItem.param("obj_location", dVar.f());
        }
        d.b.h0.i0.e.b(context, statisticItem, dVar);
        TiebaStatic.log(statisticItem);
    }

    public void e() {
        g();
    }

    public void f(boolean z, View view, View view2, d.b.h0.k0.d dVar, boolean z2) {
        if (this.f54215b) {
            z = false;
        } else {
            this.f54215b = z;
        }
        if (b(view, view2) || (z && !z2)) {
            g();
        } else if (z2) {
            i(dVar);
        }
    }

    public final void g() {
        if (this.f54214a == 0) {
            this.f54214a = System.currentTimeMillis();
        }
    }

    public void h(PbActivity pbActivity) {
        if (pbActivity != null) {
            i(pbActivity.getPageStayDurationItem());
        }
    }

    public final void i(d.b.h0.k0.d dVar) {
        if (this.f54214a > 0) {
            this.f54214a = 0L;
            dVar.v(System.currentTimeMillis() - this.f54214a);
            d(TbadkCoreApplication.getInst(), dVar);
        }
    }
}
