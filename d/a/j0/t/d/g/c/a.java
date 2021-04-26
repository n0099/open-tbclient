package d.a.j0.t.d.g.c;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.q.a2;
import d.a.j0.t.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60781a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60782b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.t.d.g.d.c f60783c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f60784d;

    /* renamed from: f  reason: collision with root package name */
    public String f60786f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60785e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f60787g = new C1571a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f60788h = new b();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f60789i = new c();
    public f j = new d();
    public f.g k = new e();

    /* renamed from: d.a.j0.t.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1571a implements BdListView.p {
        public C1571a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean J = a.this.f60784d != null ? a.this.f60784d.J() : false;
            if (a.this.f60783c != null) {
                if (!J) {
                    a.this.f60783c.v();
                    return;
                }
                a.this.f60784d.L();
                a.this.f60783c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            if (a.this.f60782b == null || a.this.f60783c == null) {
                return;
            }
            a.this.f60783c.d();
            a.this.f60783c.g();
            d.a.j0.t.d.g.d.c cVar = a.this.f60783c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f60782b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.f60789i, true);
            a.this.f60783c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f60782b == null || a.this.f60783c == null) {
                return;
            }
            a.this.f60783c.d();
            a.this.f60783c.g();
            a.this.f60783c.p(a.this.f60784d.F());
            a.this.f60783c.l(a.this.f60784d.G());
            a.this.f60783c.m(a.this.f60784d.I());
            if (a.this.f60784d != null && a.this.f60784d.getPn() == 0 && a.this.f60783c.e() != null) {
                a.this.f60783c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f60784d.F()) == 0) {
                a.this.f60783c.u(a.this.f60782b.getString(R.string.no_data_text), a.this.f60789i, true);
                a.this.f60783c.o(8);
                return;
            }
            a.this.f60783c.h();
            a.this.f60783c.o(0);
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
    public class d implements d.a.j0.t.d.g.d.f {
        public d() {
        }

        @Override // d.a.j0.t.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f60782b, a2Var, str);
        }

        @Override // d.a.j0.t.d.g.d.f
        public void b(d.a.j0.t.d.g.b.c cVar) {
            if (a.this.f60784d == null || cVar == null || StringUtils.isNull(cVar.f60777a)) {
                return;
            }
            a.this.f60784d.setSortType(cVar.f60777a);
            a.this.f60784d.setLat(cVar.f60778b);
            a.this.f60784d.setLng(cVar.f60779c);
            a.this.f60784d.P(cVar.f60780d);
            a.this.f60784d.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f60784d != null) {
                a.this.f60784d.M();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f60782b = tbPageContext;
        this.f60781a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f60784d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.N(this.f60788h);
        d.a.j0.t.d.g.d.c cVar = new d.a.j0.t.d.g.d.c(this.f60782b);
        this.f60783c = cVar;
        cVar.n(this.j);
        this.f60783c.q(this.k);
        this.f60783c.r(this.f60787g);
        this.f60783c.t();
    }

    public View f() {
        return this.f60783c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.q1().live_id);
        if (!StringUtils.isNull(this.f60786f)) {
            param.param("locate_type", this.f60786f);
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
        for (a2 a2Var2 : this.f60784d.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.j0.t.d.g.d.c cVar = this.f60783c;
        if (cVar != null) {
            cVar.j(tbPageContext, i2);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f60784d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f60784d = null;
        }
        d.a.j0.t.d.g.d.c cVar = this.f60783c;
        if (cVar != null) {
            cVar.k();
            this.f60783c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f60784d.M();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f60785e = str.equals("16:9");
        }
        this.f60783c.s(this.f60781a, list, str2, str3, this.f60785e, false);
        this.f60784d.setEntryName(str2);
        this.f60784d.setLabelName(str3);
        this.f60784d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f60784d.O(this.f60785e);
        this.f60786f = str2;
    }
}
