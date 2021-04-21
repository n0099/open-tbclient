package d.b.j0.t.d.g.c;

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
import d.b.i0.r.f0.f;
import d.b.i0.r.q.a2;
import d.b.j0.t.d.g.d.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62599a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62600b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.t.d.g.d.c f62601c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f62602d;

    /* renamed from: f  reason: collision with root package name */
    public String f62604f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62603e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f62605g = new C1631a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f62606h = new b();
    public View.OnClickListener i = new c();
    public g j = new d();
    public f.g k = new e();

    /* renamed from: d.b.j0.t.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1631a implements BdListView.p {
        public C1631a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f62602d != null ? a.this.f62602d.J() : false;
            if (a.this.f62601c != null) {
                if (!J) {
                    a.this.f62601c.v();
                    return;
                }
                a.this.f62602d.L();
                a.this.f62601c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i, String str) {
            if (a.this.f62600b == null || a.this.f62601c == null) {
                return;
            }
            a.this.f62601c.d();
            a.this.f62601c.g();
            d.b.j0.t.d.g.d.c cVar = a.this.f62601c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f62600b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.i, true);
            a.this.f62601c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f62600b == null || a.this.f62601c == null) {
                return;
            }
            a.this.f62601c.d();
            a.this.f62601c.g();
            a.this.f62601c.p(a.this.f62602d.F());
            a.this.f62601c.l(a.this.f62602d.G());
            a.this.f62601c.m(a.this.f62602d.I());
            if (a.this.f62602d != null && a.this.f62602d.getPn() == 0 && a.this.f62601c.e() != null) {
                a.this.f62601c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f62602d.F()) == 0) {
                a.this.f62601c.u(a.this.f62600b.getString(R.string.no_data_text), a.this.i, true);
                a.this.f62601c.o(8);
                return;
            }
            a.this.f62601c.h();
            a.this.f62601c.o(0);
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

        @Override // d.b.j0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f62600b, a2Var, str);
        }

        @Override // d.b.j0.t.d.g.d.g
        public void b(d.b.j0.t.d.g.b.c cVar) {
            if (a.this.f62602d == null || cVar == null || StringUtils.isNull(cVar.f62595a)) {
                return;
            }
            a.this.f62602d.setSortType(cVar.f62595a);
            a.this.f62602d.setLat(cVar.f62596b);
            a.this.f62602d.setLng(cVar.f62597c);
            a.this.f62602d.P(cVar.f62598d);
            a.this.f62602d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f62602d != null) {
                a.this.f62602d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f62600b = tbPageContext;
        this.f62599a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f62602d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f62606h);
        d.b.j0.t.d.g.d.c cVar = new d.b.j0.t.d.g.d.c(this.f62600b);
        this.f62601c = cVar;
        cVar.n(this.j);
        this.f62601c.q(this.k);
        this.f62601c.r(this.f62605g);
        this.f62601c.t();
    }

    public View f() {
        return this.f62601c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.q1().live_id);
        if (!StringUtils.isNull(this.f62604f)) {
            param.param("locate_type", this.f62604f);
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
        for (a2 a2Var2 : this.f62602d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i) {
        d.b.j0.t.d.g.d.c cVar = this.f62601c;
        if (cVar != null) {
            cVar.j(tbPageContext, i);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f62602d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f62602d = null;
        }
        d.b.j0.t.d.g.d.c cVar = this.f62601c;
        if (cVar != null) {
            cVar.k();
            this.f62601c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f62602d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f62603e = str.equals("16:9");
        }
        this.f62601c.s(this.f62599a, list, str2, str3, this.f62603e, false);
        this.f62602d.setEntryName(str2);
        this.f62602d.setLabelName(str3);
        this.f62602d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f62602d.O(this.f62603e);
        this.f62604f = str2;
    }
}
