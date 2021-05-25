package d.a.n0.e2.h;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public ForumData f52966a;

    /* renamed from: e  reason: collision with root package name */
    public int f52970e;

    /* renamed from: g  reason: collision with root package name */
    public int f52972g;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f52974i;
    public a2 j;
    public boolean l;
    public Error m;

    /* renamed from: f  reason: collision with root package name */
    public int f52971f = 20;

    /* renamed from: h  reason: collision with root package name */
    public int f52973h = -1;
    public boolean k = false;

    /* renamed from: b  reason: collision with root package name */
    public PostData f52967b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f52968c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f52969d = 1;

    public static r w(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            r rVar = new r();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            rVar.x(antiData);
            a2 a2Var = new a2();
            a2Var.U2(dataRes.thread);
            rVar.E(a2Var);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            rVar.A(forumData);
            PostData postData = new PostData();
            postData.j0(forumData.isBrandForum);
            postData.b0(dataRes.post, context);
            rVar.C(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                PostData postData2 = new PostData();
                postData2.j0(forumData.isBrandForum);
                postData2.c0(list.get(i2), context);
                if (postData2.r() != null && postData2.r().baijiahaoData == null && a2Var.V() != null) {
                    postData2.r().baijiahaoData = a2Var.V();
                }
                arrayList.add(postData2);
            }
            rVar.D(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            rVar.x(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                rVar.z(intValue3);
                rVar.B(intValue2);
                rVar.F(intValue4);
                rVar.G(intValue);
            }
            rVar.y(dataRes.is_black_white.intValue() == 1);
            return rVar;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public void A(ForumData forumData) {
        this.f52966a = forumData;
    }

    public void B(int i2) {
        if (i2 != 0) {
            this.f52971f = i2;
        }
    }

    public void C(PostData postData) {
        this.f52967b = postData;
    }

    public void D(ArrayList<PostData> arrayList) {
        this.f52968c = arrayList;
    }

    public void E(a2 a2Var) {
        this.j = a2Var;
    }

    public void F(int i2) {
        this.f52970e = i2;
    }

    public void G(int i2) {
        this.f52969d = i2;
    }

    public void H() {
        int i2 = this.f52973h;
        if (i2 < 0) {
            this.f52973h = this.f52972g;
            return;
        }
        int i3 = this.f52972g;
        if (i2 > i3) {
            this.f52973h = i3;
        }
    }

    public AntiData a() {
        return this.f52974i;
    }

    public int b() {
        return this.f52972g;
    }

    public Error c() {
        return this.m;
    }

    public ForumData d() {
        return this.f52966a;
    }

    public boolean e() {
        a2 a2Var = this.j;
        return (a2Var == null || this.f52967b == null || a2Var.T() == null || this.j.T().getUserId() == null || this.f52967b.t() == null || this.f52967b.t().getUserId() == null || !this.j.T().getUserId().equals(this.f52967b.t().getUserId())) ? false : true;
    }

    public boolean f() {
        return this.k;
    }

    public int g() {
        return this.f52971f;
    }

    public int h() {
        return this.f52973h;
    }

    public PostData i() {
        return this.f52967b;
    }

    public int j() {
        if (this.f52973h == -1) {
            this.f52973h = this.f52972g;
        }
        return this.f52973h;
    }

    public ArrayList<PostData> k() {
        return this.f52968c;
    }

    public a2 l() {
        return this.j;
    }

    public int m() {
        return this.f52970e;
    }

    public int n() {
        return this.f52969d;
    }

    public boolean o() {
        return this.f52972g < this.f52969d;
    }

    public boolean p() {
        a2 a2Var = this.j;
        return a2Var != null && a2Var.B2();
    }

    public boolean q() {
        return this.l;
    }

    public void r(r rVar, boolean z) {
        if (rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f52968c.size();
        if (z && size % this.f52971f != 0) {
            for (int i2 = 0; i2 < size % this.f52971f; i2++) {
                ArrayList<PostData> arrayList = this.f52968c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f52968c.addAll(rVar.k());
    }

    public void s(r rVar) {
        if (rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
            int i2 = this.f52971f;
            int size = (this.f52972g - (((rVar.k().size() - 1) + i2) / i2)) + 1;
            this.f52973h = size;
            if (size < 0) {
                this.f52973h = 0;
            }
        }
        this.f52968c.addAll(rVar.k());
    }

    public void t(r rVar, boolean z) {
        if (rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f52968c.size();
        if (z && size % this.f52971f != 0) {
            for (int i2 = 0; i2 < size % this.f52971f; i2++) {
                ArrayList<PostData> arrayList = this.f52968c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f52968c.addAll(rVar.k());
        H();
    }

    public void u(r rVar, boolean z) {
        v(rVar, z);
    }

    public void v(r rVar, boolean z) {
        if (rVar == null) {
            return;
        }
        x(rVar.a());
        this.f52973h = rVar.b();
        A(rVar.d());
        B(rVar.g());
        E(rVar.l());
        F(rVar.m());
        G(rVar.n());
        y(rVar.q());
        this.f52968c.addAll(0, rVar.k());
    }

    public void x(AntiData antiData) {
        this.f52974i = antiData;
    }

    public void y(boolean z) {
        this.l = z;
    }

    public void z(int i2) {
        this.f52972g = i2;
    }
}
