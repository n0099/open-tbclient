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
    public boolean f60613a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60614b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.d.g.d.c f60615c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f60616d;

    /* renamed from: f  reason: collision with root package name */
    public String f60618f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60617e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f60619g = new C1554a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f60620h = new b();
    public View.OnClickListener i = new c();
    public g j = new d();
    public f.g k = new e();

    /* renamed from: d.b.i0.t.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1554a implements BdListView.p {
        public C1554a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f60616d != null ? a.this.f60616d.J() : false;
            if (a.this.f60615c != null) {
                if (!J) {
                    a.this.f60615c.v();
                    return;
                }
                a.this.f60616d.L();
                a.this.f60615c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i, String str) {
            if (a.this.f60614b == null || a.this.f60615c == null) {
                return;
            }
            a.this.f60615c.d();
            a.this.f60615c.g();
            d.b.i0.t.d.g.d.c cVar = a.this.f60615c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f60614b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.i, true);
            a.this.f60615c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f60614b == null || a.this.f60615c == null) {
                return;
            }
            a.this.f60615c.d();
            a.this.f60615c.g();
            a.this.f60615c.p(a.this.f60616d.F());
            a.this.f60615c.l(a.this.f60616d.G());
            a.this.f60615c.m(a.this.f60616d.I());
            if (a.this.f60616d != null && a.this.f60616d.getPn() == 0 && a.this.f60615c.e() != null) {
                a.this.f60615c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f60616d.F()) == 0) {
                a.this.f60615c.u(a.this.f60614b.getString(R.string.no_data_text), a.this.i, true);
                a.this.f60615c.o(8);
                return;
            }
            a.this.f60615c.h();
            a.this.f60615c.o(0);
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
            aVar.g(aVar.f60614b, a2Var, str);
        }

        @Override // d.b.i0.t.d.g.d.g
        public void b(d.b.i0.t.d.g.b.c cVar) {
            if (a.this.f60616d == null || cVar == null || StringUtils.isNull(cVar.f60609a)) {
                return;
            }
            a.this.f60616d.setSortType(cVar.f60609a);
            a.this.f60616d.setLat(cVar.f60610b);
            a.this.f60616d.setLng(cVar.f60611c);
            a.this.f60616d.P(cVar.f60612d);
            a.this.f60616d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f60616d != null) {
                a.this.f60616d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f60614b = tbPageContext;
        this.f60613a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f60616d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f60620h);
        d.b.i0.t.d.g.d.c cVar = new d.b.i0.t.d.g.d.c(this.f60614b);
        this.f60615c = cVar;
        cVar.n(this.j);
        this.f60615c.q(this.k);
        this.f60615c.r(this.f60619g);
        this.f60615c.t();
    }

    public View f() {
        return this.f60615c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.q1().live_id);
        if (!StringUtils.isNull(this.f60618f)) {
            param.param("locate_type", this.f60618f);
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
        for (a2 a2Var2 : this.f60616d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i) {
        d.b.i0.t.d.g.d.c cVar = this.f60615c;
        if (cVar != null) {
            cVar.j(tbPageContext, i);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f60616d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f60616d = null;
        }
        d.b.i0.t.d.g.d.c cVar = this.f60615c;
        if (cVar != null) {
            cVar.k();
            this.f60615c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f60616d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f60617e = str.equals("16:9");
        }
        this.f60615c.s(this.f60613a, list, str2, str3, this.f60617e, false);
        this.f60616d.setEntryName(str2);
        this.f60616d.setLabelName(str3);
        this.f60616d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f60616d.O(this.f60617e);
        this.f60618f = str2;
    }
}
