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
    public boolean f61793a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61794b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v.d.g.d.c f61795c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f61796d;

    /* renamed from: f  reason: collision with root package name */
    public String f61798f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61797e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f61799g = new C1656a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f61800h = new b();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f61801i = new c();
    public f j = new d();
    public f.g k = new e();

    /* renamed from: d.a.n0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1656a implements BdListView.p {
        public C1656a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f61796d != null ? a.this.f61796d.J() : false;
            if (a.this.f61795c != null) {
                if (!J) {
                    a.this.f61795c.v();
                    return;
                }
                a.this.f61796d.L();
                a.this.f61795c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            if (a.this.f61794b == null || a.this.f61795c == null) {
                return;
            }
            a.this.f61795c.d();
            a.this.f61795c.g();
            d.a.n0.v.d.g.d.c cVar = a.this.f61795c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f61794b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.f61801i, true);
            a.this.f61795c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f61794b == null || a.this.f61795c == null) {
                return;
            }
            a.this.f61795c.d();
            a.this.f61795c.g();
            a.this.f61795c.p(a.this.f61796d.F());
            a.this.f61795c.l(a.this.f61796d.G());
            a.this.f61795c.m(a.this.f61796d.I());
            if (a.this.f61796d != null && a.this.f61796d.getPn() == 0 && a.this.f61795c.e() != null) {
                a.this.f61795c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f61796d.F()) == 0) {
                a.this.f61795c.u(a.this.f61794b.getString(R.string.no_data_text), a.this.f61801i, true);
                a.this.f61795c.o(8);
                return;
            }
            a.this.f61795c.h();
            a.this.f61795c.o(0);
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
            aVar.g(aVar.f61794b, a2Var, str);
        }

        @Override // d.a.n0.v.d.g.d.f
        public void b(d.a.n0.v.d.g.b.c cVar) {
            if (a.this.f61796d == null || cVar == null || StringUtils.isNull(cVar.f61789a)) {
                return;
            }
            a.this.f61796d.setSortType(cVar.f61789a);
            a.this.f61796d.setLat(cVar.f61790b);
            a.this.f61796d.setLng(cVar.f61791c);
            a.this.f61796d.P(cVar.f61792d);
            a.this.f61796d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f61796d != null) {
                a.this.f61796d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f61794b = tbPageContext;
        this.f61793a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f61796d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f61800h);
        d.a.n0.v.d.g.d.c cVar = new d.a.n0.v.d.g.d.c(this.f61794b);
        this.f61795c = cVar;
        cVar.n(this.j);
        this.f61795c.q(this.k);
        this.f61795c.r(this.f61799g);
        this.f61795c.t();
    }

    public View f() {
        return this.f61795c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.r1().live_id);
        if (!StringUtils.isNull(this.f61798f)) {
            param.param("locate_type", this.f61798f);
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.f61796d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.n0.v.d.g.d.c cVar = this.f61795c;
        if (cVar != null) {
            cVar.j(tbPageContext, i2);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f61796d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f61796d = null;
        }
        d.a.n0.v.d.g.d.c cVar = this.f61795c;
        if (cVar != null) {
            cVar.k();
            this.f61795c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f61796d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f61797e = str.equals("16:9");
        }
        this.f61795c.s(this.f61793a, list, str2, str3, this.f61797e, false);
        this.f61796d.setEntryName(str2);
        this.f61796d.setLabelName(str3);
        this.f61796d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f61796d.O(this.f61797e);
        this.f61798f = str2;
    }
}
