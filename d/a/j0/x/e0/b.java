package d.a.j0.x.e0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class b extends d.a.i0.r.q.a implements PreLoadImageProvider {
    public static final BdUniqueId F = BdUniqueId.gen();
    public static final BdUniqueId G = BdUniqueId.gen();
    public static final BdUniqueId H = BdUniqueId.gen();
    public static final BdUniqueId I = BdUniqueId.gen();
    public static final BdUniqueId J = BdUniqueId.gen();
    public static final BdUniqueId K = BdUniqueId.gen();
    public static final BdUniqueId L = BdUniqueId.gen();
    public static final BdUniqueId M = BdUniqueId.gen();
    public static final BdUniqueId N = BdUniqueId.gen();
    public static final BdUniqueId O = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> P = new ArrayList<>();
    public static final ArrayList<BdUniqueId> Q = new ArrayList<>();
    public static BdUniqueId[][] R;

    /* renamed from: e  reason: collision with root package name */
    public a2 f62455e;

    /* renamed from: f  reason: collision with root package name */
    public String f62456f;

    /* renamed from: g  reason: collision with root package name */
    public String f62457g;

    /* renamed from: h  reason: collision with root package name */
    public int f62458h;

    /* renamed from: i  reason: collision with root package name */
    public String f62459i;
    public String j;
    public String l;
    public String m;
    public int q;
    public int k = 1;
    public Integer n = 0;
    public int o = 0;
    public int p = 0;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;

    static {
        P.add(F);
        P.add(G);
        Q.add(K);
        Q.add(H);
        Q.add(J);
        Q.add(I);
        R = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, P.size(), Q.size());
        for (int i2 = 0; i2 < P.size(); i2++) {
            for (int i3 = 0; i3 < Q.size(); i3++) {
                R[i2][i3] = BdUniqueId.gen();
            }
        }
    }

    public StatisticItem A(String str) {
        return null;
    }

    public String B() {
        return this.m;
    }

    public StatisticItem C() {
        return null;
    }

    public Integer D() {
        return this.n;
    }

    public int E() {
        return this.f62458h;
    }

    public String F() {
        return this.f62457g;
    }

    public StatisticItem G(String str) {
        return I(str, false);
    }

    public StatisticItem H(String str, int i2) {
        a2 m = m();
        if (m == null) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(m.c0())).param("tid", String.valueOf(m.w1())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", O()).param("obj_source", F()).param("obj_locate", E()).param("obj_name", z()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.j0.x.m.e());
        if (i2 == 0) {
            param.param("obj_type", J());
        } else {
            param.param("obj_type", i2);
        }
        param.param("obj_id", B());
        return param;
    }

    public StatisticItem I(String str, boolean z) {
        a2 m = m();
        if (m == null || str.length() == 0) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(m.c0())).param("tid", String.valueOf(m.w1())).param("nid", m.L0()).param("obj_id", B()).param("obj_param1", O()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", F()).param("obj_locate", E()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.j0.x.m.e()).param("ab_tag", z()).param(TiebaStatic.Params.IS_ZP, m.D2() ? 1 : 0);
        if (!z) {
            param.param("obj_type", J());
        } else {
            if (m.p1 > 0) {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            param.param(TiebaStatic.Params.IS_VERTICAL, D().intValue());
        }
        if (m.z1() != null && m.z1().K() != null && m.z1().K().u() != null && m.z1().K().u().size() > 0) {
            param.param(TiebaStatic.Params.OBJ_TO, m.z1().N ? 2 : 1);
        }
        return param;
    }

    public final int J() {
        a2 m = m();
        int i2 = 0;
        if (m == null) {
            return 0;
        }
        ArrayList<MediaData> K0 = m.K0();
        if (K0 != null) {
            Iterator<MediaData> it = K0.iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public StatisticItem K() {
        return null;
    }

    public StatisticItem L() {
        return null;
    }

    public String M() {
        return this.j;
    }

    public StatisticItem N() {
        return null;
    }

    public String O() {
        return this.f62456f;
    }

    public boolean P() {
        return this.q == 1;
    }

    public boolean Q() {
        return false;
    }

    public void R(String str) {
        this.f62459i = str;
    }

    public void S(String str) {
        this.m = str;
    }

    public void T(Integer num) {
        this.n = num;
    }

    public void U(int i2) {
        this.f62458h = i2;
    }

    public void V(String str) {
        this.f62457g = str;
    }

    public void W(int i2) {
        this.q = i2;
    }

    public void X(String str) {
        this.j = str;
    }

    public void Y(String str) {
        this.f62456f = str;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        a2 m = m();
        if (m != null) {
            return m.getImages();
        }
        return null;
    }

    @Override // d.a.i0.r.q.a
    public v0 h() {
        SparseArray<String> sparseArray;
        if (m() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(m().w1());
        v0Var.k(m().c0());
        v0Var.m(m().L0());
        v0Var.j(this.feedBackReasonMap);
        v0Var.j = this.f62456f;
        v0Var.k = this.f62457g;
        v0Var.l = this.m;
        v0Var.m = m().Z;
        return v0Var;
    }

    public boolean isValid() {
        return true;
    }

    @Override // d.a.i0.r.q.a
    public String l() {
        return this.f62457g + "#" + this.f62458h + "#" + this.f62459i;
    }

    @Override // d.a.i0.r.q.a
    public a2 m() {
        return null;
    }

    public String z() {
        return this.f62459i;
    }
}
