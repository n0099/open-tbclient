package d.a.i0.k0;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public abstract class b {
    public static final int FIX_MAX_COST = 5;
    public boolean isSwitchOpen = d.a.i0.r.d0.b.j().g("page_stay_duration_switch", false);

    private void updataSwitchStaus(boolean z) {
        if (this.isSwitchOpen != z) {
            d.a.i0.r.d0.b.j().t("page_stay_duration_switch", true);
            this.isSwitchOpen = z;
        }
    }

    public boolean canStat(d dVar) {
        if (dVar == null || dVar.m()) {
            return false;
        }
        if (dVar.f48564a) {
            dVar.u(c.b(dVar.h(), 6));
        } else {
            int c2 = getMaxCost() > e.b().c() ? e.b().c() : getMaxCost();
            if (c2 > 5) {
                c2 = 5;
            }
            dVar.u(c.b(dVar.h(), c2));
        }
        return true;
    }

    public abstract int getMaxCost();

    public abstract boolean isCurrentPageCanBeAddToSourceTrace();

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.isSwitchOpen;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            updataSwitchStaus(false);
            return false;
        } else if (!e.b().d()) {
            updataSwitchStaus(false);
            return false;
        } else {
            updataSwitchStaus(true);
            return true;
        }
    }
}
