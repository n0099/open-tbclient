package d.b.i0.d2.h;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public ForumData f53857a;

    /* renamed from: e  reason: collision with root package name */
    public int f53861e;

    /* renamed from: g  reason: collision with root package name */
    public int f53863g;
    public AntiData i;
    public a2 j;
    public boolean l;
    public Error m;

    /* renamed from: f  reason: collision with root package name */
    public int f53862f = 20;

    /* renamed from: h  reason: collision with root package name */
    public int f53864h = -1;
    public boolean k = false;

    /* renamed from: b  reason: collision with root package name */
    public PostData f53858b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f53859c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f53860d = 1;

    public static q w(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            q qVar = new q();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            qVar.x(antiData);
            a2 a2Var = new a2();
            a2Var.R2(dataRes.thread);
            qVar.E(a2Var);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            qVar.A(forumData);
            PostData postData = new PostData();
            postData.j0(forumData.isBrandForum);
            postData.b0(dataRes.post, context);
            qVar.C(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.j0(forumData.isBrandForum);
                postData2.c0(list.get(i), context);
                if (postData2.r() != null && postData2.r().baijiahaoData == null && a2Var.V() != null) {
                    postData2.r().baijiahaoData = a2Var.V();
                }
                arrayList.add(postData2);
            }
            qVar.D(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            qVar.x(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                qVar.z(intValue3);
                qVar.B(intValue2);
                qVar.F(intValue4);
                qVar.G(intValue);
            }
            qVar.y(dataRes.is_black_white.intValue() == 1);
            return qVar;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public void A(ForumData forumData) {
        this.f53857a = forumData;
    }

    public void B(int i) {
        if (i != 0) {
            this.f53862f = i;
        }
    }

    public void C(PostData postData) {
        this.f53858b = postData;
    }

    public void D(ArrayList<PostData> arrayList) {
        this.f53859c = arrayList;
    }

    public void E(a2 a2Var) {
        this.j = a2Var;
    }

    public void F(int i) {
        this.f53861e = i;
    }

    public void G(int i) {
        this.f53860d = i;
    }

    public void H() {
        int i = this.f53864h;
        if (i < 0) {
            this.f53864h = this.f53863g;
            return;
        }
        int i2 = this.f53863g;
        if (i > i2) {
            this.f53864h = i2;
        }
    }

    public AntiData a() {
        return this.i;
    }

    public int b() {
        return this.f53863g;
    }

    public Error c() {
        return this.m;
    }

    public ForumData d() {
        return this.f53857a;
    }

    public boolean e() {
        a2 a2Var = this.j;
        return (a2Var == null || this.f53858b == null || a2Var.T() == null || this.j.T().getUserId() == null || this.f53858b.t() == null || this.f53858b.t().getUserId() == null || !this.j.T().getUserId().equals(this.f53858b.t().getUserId())) ? false : true;
    }

    public boolean f() {
        return this.k;
    }

    public int g() {
        return this.f53862f;
    }

    public int h() {
        return this.f53864h;
    }

    public PostData i() {
        return this.f53858b;
    }

    public int j() {
        if (this.f53864h == -1) {
            this.f53864h = this.f53863g;
        }
        return this.f53864h;
    }

    public ArrayList<PostData> k() {
        return this.f53859c;
    }

    public a2 l() {
        return this.j;
    }

    public int m() {
        return this.f53861e;
    }

    public int n() {
        return this.f53860d;
    }

    public boolean o() {
        return this.f53863g < this.f53860d;
    }

    public boolean p() {
        a2 a2Var = this.j;
        return a2Var != null && a2Var.y2();
    }

    public boolean q() {
        return this.l;
    }

    public void r(q qVar, boolean z) {
        if (qVar == null) {
            return;
        }
        x(qVar.a());
        A(qVar.d());
        C(qVar.i());
        E(qVar.l());
        y(qVar.q());
        if (qVar.k() != null) {
            z(qVar.b());
            B(qVar.g());
            F(qVar.m());
            G(qVar.n());
        }
        int size = this.f53859c.size();
        if (z && size % this.f53862f != 0) {
            for (int i = 0; i < size % this.f53862f; i++) {
                ArrayList<PostData> arrayList = this.f53859c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f53859c.addAll(qVar.k());
    }

    public void s(q qVar) {
        if (qVar == null) {
            return;
        }
        x(qVar.a());
        A(qVar.d());
        C(qVar.i());
        E(qVar.l());
        y(qVar.q());
        if (qVar.k() != null && qVar.k().size() > 0) {
            z(qVar.b());
            B(qVar.g());
            F(qVar.m());
            G(qVar.n());
            int i = this.f53862f;
            int size = (this.f53863g - (((qVar.k().size() - 1) + i) / i)) + 1;
            this.f53864h = size;
            if (size < 0) {
                this.f53864h = 0;
            }
        }
        this.f53859c.addAll(qVar.k());
    }

    public void t(q qVar, boolean z) {
        if (qVar == null) {
            return;
        }
        x(qVar.a());
        A(qVar.d());
        C(qVar.i());
        E(qVar.l());
        y(qVar.q());
        if (qVar.k() != null && qVar.k().size() > 0) {
            z(qVar.b());
            B(qVar.g());
            F(qVar.m());
            G(qVar.n());
        }
        int size = this.f53859c.size();
        if (z && size % this.f53862f != 0) {
            for (int i = 0; i < size % this.f53862f; i++) {
                ArrayList<PostData> arrayList = this.f53859c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f53859c.addAll(qVar.k());
        H();
    }

    public void u(q qVar, boolean z) {
        v(qVar, z);
    }

    public void v(q qVar, boolean z) {
        if (qVar == null) {
            return;
        }
        x(qVar.a());
        this.f53864h = qVar.b();
        A(qVar.d());
        B(qVar.g());
        E(qVar.l());
        F(qVar.m());
        G(qVar.n());
        y(qVar.q());
        this.f53859c.addAll(0, qVar.k());
    }

    public void x(AntiData antiData) {
        this.i = antiData;
    }

    public void y(boolean z) {
        this.l = z;
    }

    public void z(int i) {
        this.f53863g = i;
    }
}
