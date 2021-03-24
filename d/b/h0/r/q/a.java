package d.b.h0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a extends BaseCardInfo implements d.b.h0.b.f.k {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    public Map<BdUniqueId, d.b.h0.b.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    @Override // d.b.h0.b.f.k
    public void f(BdUniqueId bdUniqueId, d.b.h0.b.e eVar) {
        if (bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, eVar);
    }

    public abstract v0 g();

    public String j() {
        return null;
    }

    public abstract a2 n();

    public boolean o() {
        a2 n = n();
        if (n == null) {
            return false;
        }
        return n.o();
    }

    public boolean s() {
        return ThreadCardUtils.isSelf(n());
    }

    public boolean t() {
        a2 n = n();
        if (n == null) {
            return false;
        }
        return n.T1 || n.U1 || n.W1 || n.V1 || n.X1;
    }

    public boolean u() {
        a2 n = n();
        if (n == null) {
            return false;
        }
        return n.U1 || n.W1 || n.C2();
    }

    public boolean v() {
        a2 n = n();
        if (n == null) {
            return false;
        }
        return n.U1 || n.W1 || n.T1;
    }

    public boolean w() {
        a2 n = n();
        if (n == null || n.T() == null || ThreadCardUtils.isSelf(n)) {
            return false;
        }
        boolean z = n.T1() || n.O1() || n.R1();
        if (!n.T1 || (!z && !n.C2())) {
            if (!n.V1) {
                return false;
            }
            if (!z && !n.C2()) {
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
