package d.a.o0.v.d.g.c;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65633a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65634b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.v.d.g.d.c f65635c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f65636d;

    /* renamed from: f  reason: collision with root package name */
    public String f65638f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65637e = false;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f65639g = new C1717a();

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f65640h = new b();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65641i = new c();
    public f j = new d();
    public f.g k = new e();

    /* renamed from: d.a.o0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1717a implements BdListView.p {
        public C1717a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean N = a.this.f65636d != null ? a.this.f65636d.N() : false;
            if (a.this.f65635c != null) {
                if (!N) {
                    a.this.f65635c.v();
                    return;
                }
                a.this.f65636d.P();
                a.this.f65635c.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            if (a.this.f65634b == null || a.this.f65635c == null) {
                return;
            }
            a.this.f65635c.d();
            a.this.f65635c.g();
            d.a.o0.v.d.g.d.c cVar = a.this.f65635c;
            if (TextUtils.isEmpty(str)) {
                str = a.this.f65634b.getString(R.string.no_data_text);
            }
            cVar.u(str, a.this.f65641i, true);
            a.this.f65635c.o(8);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            if (a.this.f65634b == null || a.this.f65635c == null) {
                return;
            }
            a.this.f65635c.d();
            a.this.f65635c.g();
            a.this.f65635c.p(a.this.f65636d.J());
            a.this.f65635c.l(a.this.f65636d.K());
            a.this.f65635c.m(a.this.f65636d.M());
            if (a.this.f65636d != null && a.this.f65636d.getPn() == 0 && a.this.f65635c.e() != null) {
                a.this.f65635c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(a.this.f65636d.J()) == 0) {
                a.this.f65635c.u(a.this.f65634b.getString(R.string.no_data_text), a.this.f65641i, true);
                a.this.f65635c.o(8);
                return;
            }
            a.this.f65635c.h();
            a.this.f65635c.o(0);
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
    public class d implements d.a.o0.v.d.g.d.f {
        public d() {
        }

        @Override // d.a.o0.v.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            a aVar = a.this;
            aVar.g(aVar.f65634b, a2Var, str);
        }

        @Override // d.a.o0.v.d.g.d.f
        public void b(d.a.o0.v.d.g.b.c cVar) {
            if (a.this.f65636d == null || cVar == null || StringUtils.isNull(cVar.f65629a)) {
                return;
            }
            a.this.f65636d.setSortType(cVar.f65629a);
            a.this.f65636d.setLat(cVar.f65630b);
            a.this.f65636d.setLng(cVar.f65631c);
            a.this.f65636d.T(cVar.f65632d);
            a.this.f65636d.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.f65636d != null) {
                a.this.f65636d.Q();
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f65634b = tbPageContext;
        this.f65633a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f65636d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f65640h);
        d.a.o0.v.d.g.d.c cVar = new d.a.o0.v.d.g.d.c(this.f65634b);
        this.f65635c = cVar;
        cVar.n(this.j);
        this.f65635c.q(this.k);
        this.f65635c.r(this.f65639g);
        this.f65635c.t();
    }

    public View f() {
        return this.f65635c.f();
    }

    public final void g(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", a2Var.s1().live_id);
        if (!StringUtils.isNull(this.f65638f)) {
            param.param("locate_type", this.f65638f);
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
        for (a2 a2Var2 : this.f65636d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.o0.v.d.g.d.c cVar = this.f65635c;
        if (cVar != null) {
            cVar.j(tbPageContext, i2);
        }
    }

    public void i() {
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.f65636d;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
            this.f65636d = null;
        }
        d.a.o0.v.d.g.d.c cVar = this.f65635c;
        if (cVar != null) {
            cVar.k();
            this.f65635c = null;
        }
    }

    public final AlaLiveInfoCoreData j(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void k() {
        this.f65636d.Q();
    }

    public void l(String str, String str2, String str3, List<String> list) {
        if (StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f65637e = str.equals("16:9");
        }
        this.f65635c.s(this.f65633a, list, str2, str3, this.f65637e, false);
        this.f65636d.setEntryName(str2);
        this.f65636d.setLabelName(str3);
        this.f65636d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f65636d.S(this.f65637e);
        this.f65638f = str2;
    }
}
