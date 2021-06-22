package d.a.o0.z.e0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class b extends d.a.n0.r.q.a implements PreLoadImageProvider {
    public static final BdUniqueId G = BdUniqueId.gen();
    public static final BdUniqueId H = BdUniqueId.gen();
    public static final BdUniqueId I = BdUniqueId.gen();
    public static final BdUniqueId J = BdUniqueId.gen();
    public static final BdUniqueId K = BdUniqueId.gen();
    public static final BdUniqueId L = BdUniqueId.gen();
    public static final BdUniqueId M = BdUniqueId.gen();
    public static final BdUniqueId N = BdUniqueId.gen();
    public static final BdUniqueId O = BdUniqueId.gen();
    public static final BdUniqueId P = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> Q = new ArrayList<>();
    public static final ArrayList<BdUniqueId> R = new ArrayList<>();
    public static BdUniqueId[][] S;

    /* renamed from: e  reason: collision with root package name */
    public a2 f67302e;

    /* renamed from: f  reason: collision with root package name */
    public String f67303f;

    /* renamed from: g  reason: collision with root package name */
    public String f67304g;

    /* renamed from: h  reason: collision with root package name */
    public int f67305h;

    /* renamed from: i  reason: collision with root package name */
    public String f67306i;
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
    public boolean F = false;

    static {
        Q.add(G);
        Q.add(H);
        R.add(L);
        R.add(I);
        R.add(K);
        R.add(J);
        S = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, Q.size(), R.size());
        for (int i2 = 0; i2 < Q.size(); i2++) {
            for (int i3 = 0; i3 < R.size(); i3++) {
                S[i2][i3] = BdUniqueId.gen();
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
        return this.f67305h;
    }

    public String F() {
        return this.f67304g;
    }

    public StatisticItem G(String str) {
        return I(str, false);
    }

    public StatisticItem H(String str, int i2) {
        a2 i3 = i();
        if (i3 == null) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(i3.c0())).param("tid", String.valueOf(i3.z1())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", O()).param("obj_source", F()).param("obj_locate", E()).param("obj_name", z()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.o0.z.m.e());
        if (i2 == 0) {
            param.param("obj_type", J());
        } else {
            param.param("obj_type", i2);
        }
        param.param("obj_id", B());
        return param;
    }

    public StatisticItem I(String str, boolean z) {
        a2 i2 = i();
        if (i2 == null || str.length() == 0) {
            return null;
        }
        StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(i2.c0())).param("tid", String.valueOf(i2.z1())).param("nid", i2.M0()).param("obj_id", B()).param("obj_param1", O()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", F()).param("obj_locate", E()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.o0.z.m.e()).param("ab_tag", z()).param(TiebaStatic.Params.IS_ZP, i2.H2() ? 1 : 0);
        if (!z) {
            param.param("obj_type", J());
        } else {
            if (i2.r1 > 0) {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            param.param(TiebaStatic.Params.IS_VERTICAL, D().intValue());
        }
        if (i2.C1() != null && i2.C1().K() != null && i2.C1().K().y() != null && i2.C1().K().y().size() > 0) {
            param.param(TiebaStatic.Params.OBJ_TO, i2.C1().N ? 2 : 1);
        }
        return param;
    }

    public final int J() {
        a2 i2 = i();
        int i3 = 0;
        if (i2 == null) {
            return 0;
        }
        ArrayList<MediaData> L0 = i2.L0();
        if (L0 != null) {
            Iterator<MediaData> it = L0.iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i3++;
                }
            }
        }
        return i3;
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
        return this.f67303f;
    }

    public boolean P() {
        return this.q == 1;
    }

    public boolean Q() {
        return false;
    }

    public void R(String str) {
        this.f67306i = str;
    }

    public void S(String str) {
        this.m = str;
    }

    public void T(Integer num) {
        this.n = num;
    }

    public void U(int i2) {
        this.f67305h = i2;
    }

    public void V(String str) {
        this.f67304g = str;
    }

    public void W(int i2) {
        this.q = i2;
    }

    public void X(String str) {
        this.j = str;
    }

    public void Y(String str) {
        this.f67303f = str;
    }

    @Override // d.a.n0.r.q.a
    public v0 c() {
        SparseArray<String> sparseArray;
        if (i() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(i().z1());
        v0Var.k(i().c0());
        v0Var.m(i().M0());
        v0Var.j(this.feedBackReasonMap);
        v0Var.j = this.f67303f;
        v0Var.k = this.f67304g;
        v0Var.l = this.m;
        v0Var.m = i().Z;
        return v0Var;
    }

    @Override // d.a.n0.r.q.a
    public String g() {
        return this.f67304g + "#" + this.f67305h + "#" + this.f67306i;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        a2 i2 = i();
        if (i2 != null) {
            return i2.getImages();
        }
        return null;
    }

    @Override // d.a.n0.r.q.a
    public a2 i() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public String z() {
        return this.f67306i;
    }
}
