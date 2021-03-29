package d.b.i0.t.d.g.c;

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
import d.b.h0.r.f0.f;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.g.d.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60614a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60615b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.g.d.c f60616c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f60617d;

    /* renamed from: f  reason: collision with root package name */
    public String f60619f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60618e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f60620g = new C1555a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f60621h = new b();
    public View.OnClickListener i = new c();
    public g j = new d();
    public f.g k = new e();

    /* renamed from: d.b.i0.t.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1555a implements BdListView.p {
        public C1555a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f60617d != null ? a.this.f60617d.J() : false;
            if (a.this.f60616c != null) {
                if (!J) {
                    a.this.f60616c.v();
                    return;
                }
                a.this.f60617d.L();
                a.this.f60616c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i, String str) {
            if (a.this.f60615b == null || a.this.f60616c == null) {
                return;
            }
            a.this.f60616c.d();
            a.this.f60616c.g();
            d.b.i0.t.d.g.d.c cVar = a.this.f60616c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f60615b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.i, true);
            a.this.f60616c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f60615b == null || a.this.f60616c == null) {
                return;
            }
            a.this.f60616c.d();
            a.this.f60616c.g();
            a.this.f60616c.p(a.this.f60617d.F());
            a.this.f60616c.l(a.this.f60617d.G());
            a.this.f60616c.m(a.this.f60617d.I());
            if (a.this.f60617d != null && a.this.f60617d.getPn() == 0 && a.this.f60616c.e() != null) {
                a.this.f60616c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f60617d.F()) == 0) {
                a.this.f60616c.u(a.this.f60615b.getString(R.string.no_data_text), a.this.i, true);
                a.this.f60616c.o(8);
                return;
            }
            a.this.f60616c.h();
            a.this.f60616c.o(0);
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
    public class d implements g {
        public d() {
        }

        @Override // d.b.i0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f60615b, a2Var, str);
        }

        @Override // d.b.i0.t.d.g.d.g
        public void b(d.b.i0.t.d.g.b.c cVar) {
            if (a.this.f60617d == null || cVar == null || StringUtils.isNull(cVar.f60610a)) {
                return;
            }
            a.this.f60617d.setSortType(cVar.f60610a);
            a.this.f60617d.setLat(cVar.f60611b);
            a.this.f60617d.setLng(cVar.f60612c);
            a.this.f60617d.P(cVar.f60613d);
            a.this.f60617d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f60617d != null) {
                a.this.f60617d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f60615b = tbPageContext;
        this.f60614a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f60617d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f60621h);
        d.b.i0.t.d.g.d.c cVar = new d.b.i0.t.d.g.d.c(this.f60615b);
        this.f60616c = cVar;
        cVar.n(this.j);
        this.f60616c.q(this.k);
        this.f60616c.r(this.f60620g);
        this.f60616c.t();
    }

    public View f() {
        return this.f60616c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.q1().live_id);
        if (!StringUtils.isNull(this.f60619f)) {
            param.param("locate_type", this.f60619f);
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.f60617d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i) {
        d.b.i0.t.d.g.d.c cVar = this.f60616c;
        if (cVar != null) {
            cVar.j(tbPageContext, i);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f60617d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f60617d = null;
        }
        d.b.i0.t.d.g.d.c cVar = this.f60616c;
        if (cVar != null) {
            cVar.k();
            this.f60616c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f60617d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f60618e = str.equals("16:9");
        }
        this.f60616c.s(this.f60614a, list, str2, str3, this.f60618e, false);
        this.f60617d.setEntryName(str2);
        this.f60617d.setLabelName(str3);
        this.f60617d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f60617d.O(this.f60618e);
        this.f60619f = str2;
    }
}
