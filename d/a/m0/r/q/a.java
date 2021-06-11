package d.a.m0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a extends BaseCardInfo implements d.a.m0.b.f.l {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    public Map<BdUniqueId, d.a.m0.b.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    @Override // d.a.m0.b.f.l
    public void b(BdUniqueId bdUniqueId, d.a.m0.b.e eVar) {
        if (bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, eVar);
    }

    public abstract v0 c();

    public String g() {
        return null;
    }

    public abstract a2 i();

    public boolean k() {
        a2 i2 = i();
        if (i2 == null) {
            return false;
        }
        return i2.k();
    }

    public boolean o() {
        return ThreadCardUtils.isSelf(i());
    }

    public boolean p() {
        a2 i2 = i();
        if (i2 == null) {
            return false;
        }
        return i2.V1 || i2.W1 || i2.Z1 || i2.X1 || i2.a2 || i2.Y1;
    }

    public boolean q() {
        a2 i2 = i();
        if (i2 == null) {
            return false;
        }
        return i2.W1 || i2.Z1 || i2.H2();
    }

    public boolean t() {
        a2 i2 = i();
        if (i2 == null) {
            return false;
        }
        return i2.W1 || i2.Z1 || i2.V1;
    }

    public boolean w() {
        a2 i2 = i();
        if (i2 == null || i2.T() == null || ThreadCardUtils.isSelf(i2)) {
            return false;
        }
        boolean z = i2.W1() || i2.R1() || i2.U1();
        if ((!i2.V1 || (!z && !i2.H2())) && ((!i2.X1 || (!z && !i2.H2())) && (!i2.k() || (!z && !i2.H2())))) {
            if (!i2.Y1) {
                return false;
            }
            if (!z && !i2.H2()) {
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
