package d.a.j0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a extends BaseCardInfo implements d.a.j0.b.f.k {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    public Map<BdUniqueId, d.a.j0.b.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    @Override // d.a.j0.b.f.k
    public void e(BdUniqueId bdUniqueId, d.a.j0.b.e eVar) {
        if (bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, eVar);
    }

    public abstract v0 h();

    public String l() {
        return null;
    }

    public abstract a2 m();

    public boolean p() {
        a2 m = m();
        if (m == null) {
            return false;
        }
        return m.p();
    }

    public boolean s() {
        return ThreadCardUtils.isSelf(m());
    }

    public boolean t() {
        a2 m = m();
        if (m == null) {
            return false;
        }
        return m.T1 || m.U1 || m.W1 || m.V1 || m.X1;
    }

    public boolean u() {
        a2 m = m();
        if (m == null) {
            return false;
        }
        return m.U1 || m.W1 || m.F2();
    }

    public boolean v() {
        a2 m = m();
        if (m == null) {
            return false;
        }
        return m.U1 || m.W1 || m.T1;
    }

    public boolean w() {
        a2 m = m();
        if (m == null || m.T() == null || ThreadCardUtils.isSelf(m)) {
            return false;
        }
        boolean z = m.U1() || m.P1() || m.S1();
        if ((!m.T1 || (!z && !m.F2())) && (!m.V1 || (!z && !m.F2()))) {
            if (!m.p()) {
                return false;
            }
            if (!z && !m.F2()) {
                return false;
            }
        }
        return true;
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        return false;
    }
}
