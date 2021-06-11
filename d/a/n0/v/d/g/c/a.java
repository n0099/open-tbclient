package d.a.n0.v.d.g.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65508a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65509b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.g.d.c f65510c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f65511d;

    /* renamed from: f  reason: collision with root package name */
    public String f65513f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65512e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f65514g = new C1713a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f65515h = new b();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65516i = new c();
    public f j = new d();
    public f.g k = new e();

    /* renamed from: d.a.n0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1713a implements BdListView.p {
        public C1713a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean N = a.this.f65511d != null ? a.this.f65511d.N() : false;
            if (a.this.f65510c != null) {
                if (!N) {
                    a.this.f65510c.v();
                    return;
                }
                a.this.f65511d.P();
                a.this.f65510c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            if (a.this.f65509b == null || a.this.f65510c == null) {
                return;
            }
            a.this.f65510c.d();
            a.this.f65510c.g();
            d.a.n0.v.d.g.d.c cVar = a.this.f65510c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f65509b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.f65516i, true);
            a.this.f65510c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f65509b == null || a.this.f65510c == null) {
                return;
            }
            a.this.f65510c.d();
            a.this.f65510c.g();
            a.this.f65510c.p(a.this.f65511d.J());
            a.this.f65510c.l(a.this.f65511d.K());
            a.this.f65510c.m(a.this.f65511d.M());
            if (a.this.f65511d != null && a.this.f65511d.getPn() == 0 && a.this.f65510c.e() != null) {
                a.this.f65510c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f65511d.J()) == 0) {
                a.this.f65510c.u(a.this.f65509b.getString(R.string.no_data_text), a.this.f65516i, true);
                a.this.f65510c.o(8);
                return;
            }
            a.this.f65510c.h();
            a.this.f65510c.o(0);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.v.d.g.d.f {
        public d() {
        }

        @Override // d.a.n0.v.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f65509b, a2Var, str);
        }

        @Override // d.a.n0.v.d.g.d.f
        public void b(d.a.n0.v.d.g.b.c cVar) {
            if (a.this.f65511d == null || cVar == null || StringUtils.isNull(cVar.f65504a)) {
                return;
            }
            a.this.f65511d.setSortType(cVar.f65504a);
            a.this.f65511d.setLat(cVar.f65505b);
            a.this.f65511d.setLng(cVar.f65506c);
            a.this.f65511d.T(cVar.f65507d);
            a.this.f65511d.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f65511d != null) {
                a.this.f65511d.Q();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f65509b = tbPageContext;
        this.f65508a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f65511d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f65515h);
        d.a.n0.v.d.g.d.c cVar = new d.a.n0.v.d.g.d.c(this.f65509b);
        this.f65510c = cVar;
        cVar.n(this.j);
        this.f65510c.q(this.k);
        this.f65510c.r(this.f65514g);
        this.f65510c.t();
    }

    public View f() {
        return this.f65510c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.s1().live_id);
        if (!StringUtils.isNull(this.f65513f)) {
            param.param("locate_type", this.f65513f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.f65511d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.n0.v.d.g.d.c cVar = this.f65510c;
        if (cVar != null) {
            cVar.j(tbPageContext, i2);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f65511d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f65511d = null;
        }
        d.a.n0.v.d.g.d.c cVar = this.f65510c;
        if (cVar != null) {
            cVar.k();
            this.f65510c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f65511d.Q();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f65512e = str.equals("16:9");
        }
        this.f65510c.s(this.f65508a, list, str2, str3, this.f65512e, false);
        this.f65511d.setEntryName(str2);
        this.f65511d.setLabelName(str3);
        this.f65511d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f65511d.S(this.f65512e);
        this.f65513f = str2;
    }
}
