package d.b.i0.a1.d.b;

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
import d.b.c.e.p.j;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.v0;
import d.b.i0.a1.d.b.a;
import d.b.i0.a1.d.b.b;
import d.b.i0.a1.d.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52496a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.a1.d.f.b f52497b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.a1.d.d.b f52498c;

    /* renamed from: d  reason: collision with root package name */
    public int f52499d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.a1.d.b.a f52500e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.a1.d.b.b f52501f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f52502g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f52503h = new a(2016488);
    public NEGFeedBackView.b i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1143c();
    public f.g k = new d();
    public BdListView.p l = new e();
    public b.e m = new f();
    public View.OnClickListener n = new g();
    public b.f o = new h();
    public a.b p = new i();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.p(customResponsedMessage);
            if (c.this.f52497b != null) {
                c.this.f52497b.L();
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
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = v0Var.m;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49) {
                i = 3;
            }
            if (c.this.f52497b != null) {
                c.this.f52497b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f52499d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.b.i0.a1.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1143c implements View.OnClickListener {
        public View$OnClickListenerC1143c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f52497b.E()) {
                return;
            }
            c.this.f52497b.Q(true);
            if (c.this.f52501f.i()) {
                c.this.f52501f.e();
                c.this.f52497b.c0();
                SkinManager.setBackgroundResource(c.this.f52497b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f52501f.n(c.this.f52497b.x());
            c.this.f52497b.d0();
            SkinManager.setBackgroundResource(c.this.f52497b.x(), R.color.CAM_X0201);
            if (c.this.f52498c == null || ListUtils.isEmpty(c.this.f52498c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f52498c.q(c.this.f52499d);
                c.this.u();
                c.this.f52497b.X(false);
                return;
            }
            c.this.f52497b.n0(null);
            c.this.f52496a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f52497b.f0();
            c.this.f52498c.r(c.this.f52499d);
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

        @Override // d.b.i0.a1.d.d.b.e
        public void a(int i, boolean z, boolean z2) {
            c.this.f52497b.A();
            c.this.f52497b.B();
            if (z || z2) {
                c.this.f52497b.n0(null);
            } else {
                c.this.f52497b.n0(c.this.q(i));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f52498c.m()) && !StringUtils.isNull(d.b.h0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f52497b.R(c.this.f52501f.i());
                c.this.f52497b.e0();
                c.this.f52501f.l(c.this.f52498c.m());
            }
            if (i != 0) {
                c.this.f52497b.S(c.this.f52498c.l());
                c.this.f52497b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f52497b.w())) {
                c.this.f52497b.i0();
            } else if (z) {
                c.this.f52497b.j0();
            }
        }

        @Override // d.b.i0.a1.d.d.b.e
        public void b(int i, String str, boolean z) {
            c.this.f52497b.n0(null);
            c.this.f52497b.A();
            c.this.f52497b.B();
            if (ListUtils.isEmpty(c.this.f52497b.w())) {
                c.this.f52497b.h0(new a());
                return;
            }
            if (z) {
                c.this.f52497b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f52496a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f52496a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f52497b == null || c.this.f52498c == null) {
                return;
            }
            c.this.f52497b.f0();
            c.this.f52498c.r(c.this.f52499d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.b.i0.a1.d.b.b.f
        public void a(d.b.i0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f52499d = aVar.f52514a;
            c.this.m(aVar.f52514a);
            if (c.this.f52497b != null) {
                c.this.f52497b.U(aVar.f52514a);
                c.this.f52497b.R(false);
                c.this.f52497b.T(aVar.f52515b);
            }
        }

        @Override // d.b.i0.a1.d.b.b.f
        public void b() {
            if (c.this.f52497b != null) {
                c.this.f52497b.R(false);
                c.this.f52497b.H(false);
            }
        }

        @Override // d.b.i0.a1.d.b.b.f
        public void c() {
            c.this.f52497b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.b.i0.a1.d.b.a.b
        public void a(d.b.i0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f52499d = aVar.f52514a;
            c.this.m(aVar.f52514a);
            if (c.this.f52497b != null) {
                c.this.f52497b.U(aVar.f52514a);
                c.this.f52497b.R(false);
                c.this.f52497b.T(aVar.f52515b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52496a = tbPageContext;
        this.f52502g = bdUniqueId;
        this.f52497b = new d.b.i0.a1.d.f.b(tbPageContext, bdUniqueId, this.i);
        this.f52498c = new d.b.i0.a1.d.d.b(this.f52496a, this.m);
        d.b.i0.a1.d.b.b bVar = new d.b.i0.a1.d.b.b(tbPageContext, this.f52502g);
        this.f52501f = bVar;
        bVar.m(this.o);
        d.b.i0.a1.d.b.a aVar = new d.b.i0.a1.d.b.a(tbPageContext, this.f52502g);
        this.f52500e = aVar;
        aVar.i(this.p);
        this.f52497b.W(this.j);
        int k = d.b.h0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f52499d = k;
        this.f52497b.U(k);
    }

    public final void m(int i2) {
        d.b.i0.a1.d.b.b bVar = this.f52501f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.b.i0.a1.d.d.b bVar2 = this.f52498c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            bVar.r();
        }
        d.b.i0.a1.d.b.b bVar2 = this.f52501f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.b.i0.a1.d.b.a aVar = this.f52500e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f52501f.i()) {
            SkinManager.setBackgroundResource(this.f52497b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f52497b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.b.i0.a1.d.b.a aVar;
        d.b.i0.a1.d.d.b bVar = this.f52498c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f52498c.o() || this.f52499d == 0) && (aVar = this.f52500e) != null) {
            aVar.h(this.f52498c.m());
            this.f52500e.c((ViewGroup) this.f52497b.y());
            d.b.h0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.b.h0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.a1.d.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f52498c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f52498c.w(optString);
        this.f52498c.v(optString);
        d.b.i0.a1.d.f.b bVar2 = this.f52497b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f52496a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f52496a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f52498c.u();
        this.f52497b.C();
        this.f52497b.V(this.k);
        this.f52497b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f52503h);
    }

    public void t() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            bVar.s();
            this.f52497b.g0();
        }
        d.b.i0.a1.d.d.b bVar2 = this.f52498c;
        if (bVar2 != null) {
            bVar2.q(this.f52499d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f52499d));
    }

    public void v() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            bVar.V(null);
            this.f52497b.Y(null);
            this.f52497b.I();
        }
        d.b.i0.a1.d.b.b bVar2 = this.f52501f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.b.i0.a1.d.b.a aVar = this.f52500e;
        if (aVar != null) {
            aVar.g();
        }
        d.b.i0.a1.d.d.b bVar3 = this.f52498c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f52503h);
    }

    public void w() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            bVar.J();
            this.f52497b.K();
            this.f52497b.Z(true);
        }
    }

    public void x() {
        d.b.i0.a1.d.f.b bVar = this.f52497b;
        if (bVar != null) {
            bVar.G();
            this.f52497b.l0();
            this.f52497b.X(false);
            this.f52497b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f52499d));
            if (this.f52501f.i()) {
                return;
            }
            this.f52497b.a0();
            return;
        }
        d.b.i0.a1.d.b.b bVar = this.f52501f;
        if (bVar != null) {
            bVar.f();
        }
        this.f52497b.K();
    }
}
