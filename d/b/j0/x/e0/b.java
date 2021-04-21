package d.b.j0.x.e0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class b extends d.b.i0.r.q.a implements PreLoadImageProvider {
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
    public a2 f64193e;

    /* renamed from: f  reason: collision with root package name */
    public String f64194f;

    /* renamed from: g  reason: collision with root package name */
    public String f64195g;

    /* renamed from: h  reason: collision with root package name */
    public int f64196h;
    public String i;
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
        for (int i = 0; i < P.size(); i++) {
            for (int i2 = 0; i2 < Q.size(); i2++) {
                R[i][i2] = BdUniqueId.gen();
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
        return this.f64196h;
    }

    public String F() {
        return this.f64195g;
    }

    public StatisticItem G(String str) {
        return I(str, false);
    }

    public StatisticItem H(String str, int i) {
        a2 n = n();
        if (n == null) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(n.c0())).param("tid", String.valueOf(n.w1())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", O()).param("obj_source", F()).param("obj_locate", E()).param("obj_name", z()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.b.j0.x.m.e());
        if (i == 0) {
            param.param("obj_type", J());
        } else {
            param.param("obj_type", i);
        }
        param.param("obj_id", B());
        return param;
    }

    public StatisticItem I(String str, boolean z) {
        a2 n = n();
        if (n == null || str.length() == 0) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(n.c0())).param("tid", String.valueOf(n.w1())).param("nid", n.L0()).param("obj_id", B()).param("obj_param1", O()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", F()).param("obj_locate", E()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.b.j0.x.m.e()).param("ab_tag", z()).param(TiebaStatic.Params.IS_ZP, n.D2() ? 1 : 0);
        if (!z) {
            param.param("obj_type", J());
        } else {
            if (n.p1 > 0) {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            param.param(TiebaStatic.Params.IS_VERTICAL, D().intValue());
        }
        if (n.z1() != null && n.z1().K() != null && n.z1().K().u() != null && n.z1().K().u().size() > 0) {
            param.param(TiebaStatic.Params.OBJ_TO, n.z1().N ? 2 : 1);
        }
        return param;
    }

    public final int J() {
        a2 n = n();
        int i = 0;
        if (n == null) {
            return 0;
        }
        ArrayList<MediaData> K0 = n.K0();
        if (K0 != null) {
            Iterator<MediaData> it = K0.iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i++;
                }
            }
        }
        return i;
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
        return this.f64194f;
    }

    public boolean P() {
        return this.q == 1;
    }

    public boolean Q() {
        return false;
    }

    public void R(String str) {
        this.i = str;
    }

    public void S(String str) {
        this.m = str;
    }

    public void T(Integer num) {
        this.n = num;
    }

    public void U(int i) {
        this.f64196h = i;
    }

    public void V(String str) {
        this.f64195g = str;
    }

    public void W(int i) {
        this.q = i;
    }

    public void X(String str) {
        this.j = str;
    }

    public void Y(String str) {
        this.f64194f = str;
    }

    @Override // d.b.i0.r.q.a
    public v0 g() {
        SparseArray<String> sparseArray;
        if (n() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(n().w1());
        v0Var.k(n().c0());
        v0Var.m(n().L0());
        v0Var.j(this.feedBackReasonMap);
        v0Var.j = this.f64194f;
        v0Var.k = this.f64195g;
        v0Var.l = this.m;
        v0Var.m = n().Z;
        return v0Var;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        a2 n = n();
        if (n != null) {
            return n.getImages();
        }
        return null;
    }

    public boolean isValid() {
        return true;
    }

    @Override // d.b.i0.r.q.a
    public String j() {
        return this.f64195g + "#" + this.f64196h + "#" + this.i;
    }

    @Override // d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    public String z() {
        return this.i;
    }
}
