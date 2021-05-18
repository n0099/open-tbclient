package d.a.k0.z2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public int A;
    public int G;
    public BlockPopInfoData J;

    /* renamed from: a  reason: collision with root package name */
    public int f63699a;

    /* renamed from: c  reason: collision with root package name */
    public String f63701c;

    /* renamed from: d  reason: collision with root package name */
    public String f63702d;

    /* renamed from: e  reason: collision with root package name */
    public String f63703e;

    /* renamed from: f  reason: collision with root package name */
    public String f63704f;

    /* renamed from: g  reason: collision with root package name */
    public String f63705g;

    /* renamed from: h  reason: collision with root package name */
    public String f63706h;

    /* renamed from: i  reason: collision with root package name */
    public int f63707i;
    public String j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public String v;
    public String w;
    public int x;
    public boolean y;
    public int z;

    /* renamed from: b  reason: collision with root package name */
    public String f63700b = "0";
    public ArrayList<d> B = new ArrayList<>();
    public ArrayList<d> C = new ArrayList<>();
    public ArrayList<d> D = new ArrayList<>();
    public HashMap<String, d> E = new HashMap<>();
    public d.a.k0.z2.a F = new d.a.k0.z2.a();
    public f H = new f();
    public k I = new k();

    /* loaded from: classes5.dex */
    public class a implements Comparator<d> {
        public a(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar2.i() - dVar.i();
        }
    }

    public boolean A() {
        return this.y;
    }

    public boolean B() {
        return this.l;
    }

    public boolean C() {
        f fVar = this.H;
        if (fVar == null) {
            return false;
        }
        return !StringUtils.isNull(fVar.f63716a);
    }

    public void D(h hVar) {
        this.z = 0;
        this.A = 0;
        ArrayList<i> d2 = hVar.d();
        int size = d2.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = d2.get(i2);
            d dVar = this.E.get(iVar.c() + "");
            if (dVar != null) {
                if (iVar.e() != 0) {
                    this.z++;
                    dVar.r(1);
                    dVar.o(iVar.d());
                    dVar.q(iVar.a());
                    dVar.u(true);
                    dVar.s(false);
                    dVar.t(false);
                    c(dVar);
                } else {
                    this.A++;
                    dVar.u(false);
                    dVar.s(true);
                    dVar.t(false);
                    dVar.p(iVar.b().b());
                }
            }
        }
        b();
        a(true);
    }

    public void E(SignData signData) {
        d dVar;
        if (signData == null || (dVar = this.E.get(signData.forumId)) == null) {
            return;
        }
        dVar.r(1);
        dVar.o(signData.count_sign_num);
        dVar.q(signData.sign_bonus_point);
        dVar.u(true);
        dVar.s(false);
        dVar.t(false);
        c(dVar);
        b();
        a(true);
    }

    public void F(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.F.c(jSONObject.optJSONObject("error"));
        this.f63699a = jSONObject.optInt("level", 7);
        this.f63700b = jSONObject.optString("sign_new");
        this.f63701c = jSONObject.optString("title");
        this.f63702d = jSONObject.optString("text_pre");
        this.f63703e = jSONObject.optString("text_color");
        this.f63704f = jSONObject.optString("text_mid");
        this.f63705g = jSONObject.optString("text_suf");
        this.f63706h = jSONObject.optString("num_notice");
        this.f63707i = jSONObject.optInt("show_dialog");
        this.j = jSONObject.optString("sign_notice");
        this.k = jSONObject.optInt("valid", 0);
        this.G = jSONObject.optInt("sign_max_num", 50);
        this.u = jSONObject.optInt("can_use", 0);
        this.w = jSONObject.optString("content");
        this.v = jSONObject.optString("button_content");
        JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
        if (optJSONObject != null) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.J = blockPopInfoData;
            blockPopInfoData.block_info = optJSONObject.optString("block_content");
            this.J.ahead_info = optJSONObject.optString("block_confirm");
            this.J.ahead_url = optJSONObject.optString("block_dealurl");
            this.J.ok_info = optJSONObject.optString("block_cancel");
            this.J.appeal_status = optJSONObject.optInt("appeal_status");
            this.J.appeal_msg = optJSONObject.optString("appeal_msg");
        }
        if (this.u == 1) {
            this.l = true;
        } else {
            this.l = false;
        }
        this.r = this.f63699a + this.f63701c;
        this.q = "1-" + (this.f63699a - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
        j.o = this.G;
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
        if (optJSONArray != null) {
            int min = Math.min(optJSONArray.length(), j.o);
            for (int i2 = 0; i2 < min; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.n(jSONObject2);
                    if (dVar.f() == 0) {
                        if (this.k == 0) {
                            if (this.l) {
                                dVar.s(true);
                            } else if (dVar.i() > this.f63699a) {
                                dVar.s(true);
                            }
                        }
                        if (dVar.i() >= this.f63699a) {
                            this.p++;
                        } else {
                            this.n++;
                        }
                        this.D.add(dVar);
                        this.E.put(dVar.c() + "", dVar);
                    } else {
                        if (dVar.i() >= this.f63699a) {
                            this.o++;
                        } else {
                            this.m++;
                        }
                        this.C.add(dVar);
                        TbadkApplication.getInst().addSignedForum(dVar.d(), dVar.e(), -1);
                    }
                    this.B.add(dVar);
                    Collections.sort(this.B, new a(this));
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
        if (this.H == null) {
            this.H = new f();
        }
        this.H.a(optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
        if (this.I == null) {
            this.I = new k();
        }
        this.I.a(optJSONObject3);
        a(false);
    }

    public final void a(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.B.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.B.removeAll(arrayList);
        }
        int i2 = this.p;
        int i3 = this.o;
        if (i2 + i3 > 0) {
            if (i3 > 0) {
                this.t = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.o), Integer.valueOf(this.p));
            } else {
                this.t = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.p + this.o));
            }
            if (this.B.size() > 0) {
                this.B.add(0, new b(this.r, this.t));
            }
        }
        int i4 = this.n;
        int i5 = this.m;
        if (i4 + i5 > 0) {
            if (i5 > 0) {
                this.s = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.m), Integer.valueOf(this.n));
            } else {
                this.s = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.n + this.m));
            }
            if (this.p + this.o > 0) {
                if (this.B.size() > this.p + this.o + 1) {
                    this.B.add(this.p + this.o + 1, new b(this.q, this.s));
                }
            } else if (this.B.size() > 0) {
                this.B.add(0, new b(this.q, this.s));
            }
        }
        if (this.B.size() <= 0) {
            this.x = 3;
        } else if (this.l) {
            if (this.k == 1 && this.D.size() > 0) {
                this.x = 0;
            } else {
                this.x = 2;
            }
        } else if (this.k == 1 && this.p > 0) {
            this.x = 0;
        } else {
            int i6 = this.p;
            int i7 = this.o;
            if (i6 + i7 > 0) {
                this.x = 2;
            } else if (i6 + i7 <= 0) {
                this.x = 3;
            }
        }
    }

    public final void b() {
        if (this.l) {
            if (this.p + this.n <= 0) {
                this.y = true;
            } else {
                this.y = false;
            }
        } else if (this.p <= 0) {
            this.y = true;
        } else {
            this.y = false;
        }
    }

    public final void c(d dVar) {
        if (dVar.i() >= this.f63699a) {
            this.o++;
            this.p--;
        } else {
            this.m++;
            this.n--;
        }
        this.E.remove(String.valueOf(dVar.c()));
        this.D.remove(dVar);
        if (dVar.h() + dVar.e() >= dVar.g()) {
            dVar.w(dVar.i() + 1);
            dVar.v(true);
            if (dVar.i() == this.f63699a) {
                this.o++;
                this.m--;
            }
        }
        this.C.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.d(), dVar.e(), -1);
    }

    public String d() {
        return this.H.f63716a;
    }

    public String e() {
        return this.H.f63717b;
    }

    public BlockPopInfoData f() {
        return this.J;
    }

    public String g() {
        return this.v;
    }

    public String h() {
        return this.w;
    }

    public d.a.k0.z2.a i() {
        return this.F;
    }

    public int j() {
        return this.A;
    }

    public ArrayList<d> k() {
        return this.B;
    }

    public int l() {
        return this.f63699a;
    }

    public String m() {
        return this.f63706h;
    }

    public boolean n() {
        return !StringUtils.isNull(this.f63700b) && this.f63700b.equals("1");
    }

    public int o() {
        return this.f63707i;
    }

    public String p() {
        return this.j;
    }

    public int q() {
        return this.x;
    }

    public ArrayList<d> r() {
        return this.C;
    }

    public int s() {
        return this.z;
    }

    public String t() {
        return this.f63703e;
    }

    public String u() {
        return this.f63704f;
    }

    public String v() {
        return this.f63702d;
    }

    public String w() {
        return this.f63705g;
    }

    public ArrayList<d> x() {
        return this.D;
    }

    public String y() {
        return this.I.f63760a;
    }

    public String z() {
        return this.I.f63761b;
    }
}
