package d.a.n0.b1.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.v0;
import d.a.n0.b1.d.b.a;
import d.a.n0.b1.d.b.b;
import d.a.n0.b1.d.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51478a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.d.f.b f51479b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.b1.d.d.b f51480c;

    /* renamed from: d  reason: collision with root package name */
    public int f51481d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.d.b.a f51482e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.d.b.b f51483f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f51484g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f51485h = new a(2016488);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f51486i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1194c();
    public f.g k = new d();
    public BdListView.p l = new e();
    public b.e m = new f();
    public View.OnClickListener n = new g();
    public b.f o = new h();
    public a.b p = new i();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.p(customResponsedMessage);
            if (c.this.f51479b != null) {
                c.this.f51479b.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b() {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            if (arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = v0Var.m;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49) {
                i2 = 3;
            }
            if (c.this.f51479b != null) {
                c.this.f51479b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f51481d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.n0.b1.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1194c implements View.OnClickListener {
        public View$OnClickListenerC1194c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51479b.E()) {
                return;
            }
            c.this.f51479b.Q(true);
            if (c.this.f51483f.i()) {
                c.this.f51483f.e();
                c.this.f51479b.c0();
                SkinManager.setBackgroundResource(c.this.f51479b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f51483f.n(c.this.f51479b.x());
            c.this.f51479b.d0();
            SkinManager.setBackgroundResource(c.this.f51479b.x(), R.color.CAM_X0201);
            if (c.this.f51480c == null || ListUtils.isEmpty(c.this.f51480c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f51480c.q(c.this.f51481d);
                c.this.u();
                c.this.f51479b.X(false);
                return;
            }
            c.this.f51479b.n0(null);
            c.this.f51478a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f51479b.f0();
            c.this.f51480c.r(c.this.f51481d);
            c.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b.e {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.t();
            }
        }

        public f() {
        }

        @Override // d.a.n0.b1.d.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            c.this.f51479b.A();
            c.this.f51479b.B();
            if (z || z2) {
                c.this.f51479b.n0(null);
            } else {
                c.this.f51479b.n0(c.this.q(i2));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f51480c.m()) && !StringUtils.isNull(d.a.m0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f51479b.R(c.this.f51483f.i());
                c.this.f51479b.e0();
                c.this.f51483f.l(c.this.f51480c.m());
            }
            if (i2 != 0) {
                c.this.f51479b.S(c.this.f51480c.l());
                c.this.f51479b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f51479b.w())) {
                c.this.f51479b.i0();
            } else if (z) {
                c.this.f51479b.j0();
            }
        }

        @Override // d.a.n0.b1.d.d.b.e
        public void b(int i2, String str, boolean z) {
            c.this.f51479b.n0(null);
            c.this.f51479b.A();
            c.this.f51479b.B();
            if (ListUtils.isEmpty(c.this.f51479b.w())) {
                c.this.f51479b.h0(new a());
                return;
            }
            if (z) {
                c.this.f51479b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f51478a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f51478a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51479b == null || c.this.f51480c == null) {
                return;
            }
            c.this.f51479b.f0();
            c.this.f51480c.r(c.this.f51481d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.a.n0.b1.d.b.b.f
        public void a(d.a.n0.b1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f51481d = aVar.f51497a;
            c.this.m(aVar.f51497a);
            if (c.this.f51479b != null) {
                c.this.f51479b.U(aVar.f51497a);
                c.this.f51479b.R(false);
                c.this.f51479b.T(aVar.f51498b);
            }
        }

        @Override // d.a.n0.b1.d.b.b.f
        public void b() {
            if (c.this.f51479b != null) {
                c.this.f51479b.R(false);
                c.this.f51479b.H(false);
            }
        }

        @Override // d.a.n0.b1.d.b.b.f
        public void c() {
            c.this.f51479b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.n0.b1.d.b.a.b
        public void a(d.a.n0.b1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f51481d = aVar.f51497a;
            c.this.m(aVar.f51497a);
            if (c.this.f51479b != null) {
                c.this.f51479b.U(aVar.f51497a);
                c.this.f51479b.R(false);
                c.this.f51479b.T(aVar.f51498b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51478a = tbPageContext;
        this.f51484g = bdUniqueId;
        this.f51479b = new d.a.n0.b1.d.f.b(tbPageContext, bdUniqueId, this.f51486i);
        this.f51480c = new d.a.n0.b1.d.d.b(this.f51478a, this.m);
        d.a.n0.b1.d.b.b bVar = new d.a.n0.b1.d.b.b(tbPageContext, this.f51484g);
        this.f51483f = bVar;
        bVar.m(this.o);
        d.a.n0.b1.d.b.a aVar = new d.a.n0.b1.d.b.a(tbPageContext, this.f51484g);
        this.f51482e = aVar;
        aVar.i(this.p);
        this.f51479b.W(this.j);
        int k = d.a.m0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f51481d = k;
        this.f51479b.U(k);
    }

    public final void m(int i2) {
        d.a.n0.b1.d.b.b bVar = this.f51483f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.a.n0.b1.d.d.b bVar2 = this.f51480c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            bVar.r();
        }
        d.a.n0.b1.d.b.b bVar2 = this.f51483f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.a.n0.b1.d.b.a aVar = this.f51482e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f51483f.i()) {
            SkinManager.setBackgroundResource(this.f51479b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f51479b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.a.n0.b1.d.b.a aVar;
        d.a.n0.b1.d.d.b bVar = this.f51480c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f51480c.o() || this.f51481d == 0) && (aVar = this.f51482e) != null) {
            aVar.h(this.f51480c.m());
            this.f51482e.c((ViewGroup) this.f51479b.y());
            d.a.m0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.a.m0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.n0.b1.d.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f51480c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f51480c.w(optString);
        this.f51480c.v(optString);
        d.a.n0.b1.d.f.b bVar2 = this.f51479b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f51478a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f51478a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f51480c.u();
        this.f51479b.C();
        this.f51479b.V(this.k);
        this.f51479b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f51485h);
    }

    public void t() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            bVar.s();
            this.f51479b.g0();
        }
        d.a.n0.b1.d.d.b bVar2 = this.f51480c;
        if (bVar2 != null) {
            bVar2.q(this.f51481d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f51481d));
    }

    public void v() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            bVar.V(null);
            this.f51479b.Y(null);
            this.f51479b.I();
        }
        d.a.n0.b1.d.b.b bVar2 = this.f51483f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.a.n0.b1.d.b.a aVar = this.f51482e;
        if (aVar != null) {
            aVar.g();
        }
        d.a.n0.b1.d.d.b bVar3 = this.f51480c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f51485h);
    }

    public void w() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            bVar.J();
            this.f51479b.K();
            this.f51479b.Z(true);
        }
    }

    public void x() {
        d.a.n0.b1.d.f.b bVar = this.f51479b;
        if (bVar != null) {
            bVar.G();
            this.f51479b.l0();
            this.f51479b.X(false);
            this.f51479b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f51481d));
            if (this.f51483f.i()) {
                return;
            }
            this.f51479b.a0();
            return;
        }
        d.a.n0.b1.d.b.b bVar = this.f51483f;
        if (bVar != null) {
            bVar.f();
        }
        this.f51479b.K();
    }
}
