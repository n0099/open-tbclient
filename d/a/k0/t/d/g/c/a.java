package d.a.k0.t.d.g.c;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.q.a2;
import d.a.k0.t.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61505a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61506b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.t.d.g.d.c f61507c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f61508d;

    /* renamed from: f  reason: collision with root package name */
    public String f61510f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61509e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f61511g = new C1636a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f61512h = new b();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f61513i = new c();
    public f j = new d();
    public f.g k = new e();

    /* renamed from: d.a.k0.t.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1636a implements BdListView.p {
        public C1636a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f61508d != null ? a.this.f61508d.J() : false;
            if (a.this.f61507c != null) {
                if (!J) {
                    a.this.f61507c.v();
                    return;
                }
                a.this.f61508d.L();
                a.this.f61507c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            if (a.this.f61506b == null || a.this.f61507c == null) {
                return;
            }
            a.this.f61507c.d();
            a.this.f61507c.g();
            d.a.k0.t.d.g.d.c cVar = a.this.f61507c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f61506b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.f61513i, true);
            a.this.f61507c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f61506b == null || a.this.f61507c == null) {
                return;
            }
            a.this.f61507c.d();
            a.this.f61507c.g();
            a.this.f61507c.p(a.this.f61508d.F());
            a.this.f61507c.l(a.this.f61508d.G());
            a.this.f61507c.m(a.this.f61508d.I());
            if (a.this.f61508d != null && a.this.f61508d.getPn() == 0 && a.this.f61507c.e() != null) {
                a.this.f61507c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f61508d.F()) == 0) {
                a.this.f61507c.u(a.this.f61506b.getString(R.string.no_data_text), a.this.f61513i, true);
                a.this.f61507c.o(8);
                return;
            }
            a.this.f61507c.h();
            a.this.f61507c.o(0);
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
    public class d implements d.a.k0.t.d.g.d.f {
        public d() {
        }

        @Override // d.a.k0.t.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f61506b, a2Var, str);
        }

        @Override // d.a.k0.t.d.g.d.f
        public void b(d.a.k0.t.d.g.b.c cVar) {
            if (a.this.f61508d == null || cVar == null || StringUtils.isNull(cVar.f61501a)) {
                return;
            }
            a.this.f61508d.setSortType(cVar.f61501a);
            a.this.f61508d.setLat(cVar.f61502b);
            a.this.f61508d.setLng(cVar.f61503c);
            a.this.f61508d.P(cVar.f61504d);
            a.this.f61508d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f61508d != null) {
                a.this.f61508d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f61506b = tbPageContext;
        this.f61505a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f61508d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f61512h);
        d.a.k0.t.d.g.d.c cVar = new d.a.k0.t.d.g.d.c(this.f61506b);
        this.f61507c = cVar;
        cVar.n(this.j);
        this.f61507c.q(this.k);
        this.f61507c.r(this.f61511g);
        this.f61507c.t();
    }

    public View f() {
        return this.f61507c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.q1().live_id);
        if (!StringUtils.isNull(this.f61510f)) {
            param.param("locate_type", this.f61510f);
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
        for (a2 a2Var2 : this.f61508d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.k0.t.d.g.d.c cVar = this.f61507c;
        if (cVar != null) {
            cVar.j(tbPageContext, i2);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f61508d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f61508d = null;
        }
        d.a.k0.t.d.g.d.c cVar = this.f61507c;
        if (cVar != null) {
            cVar.k();
            this.f61507c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f61508d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f61509e = str.equals("16:9");
        }
        this.f61507c.s(this.f61505a, list, str2, str3, this.f61509e, false);
        this.f61508d.setEntryName(str2);
        this.f61508d.setLabelName(str3);
        this.f61508d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f61508d.O(this.f61509e);
        this.f61510f = str2;
    }
}
