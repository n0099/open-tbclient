package d.a.k0.a1.d.b;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.q.v0;
import d.a.k0.a1.d.b.a;
import d.a.k0.a1.d.b.b;
import d.a.k0.a1.d.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51313a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.a1.d.f.b f51314b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.a1.d.d.b f51315c;

    /* renamed from: d  reason: collision with root package name */
    public int f51316d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.d.b.a f51317e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.a1.d.b.b f51318f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f51319g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f51320h = new a(2016488);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f51321i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1177c();
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
            if (c.this.f51314b != null) {
                c.this.f51314b.L();
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
            if (c.this.f51314b != null) {
                c.this.f51314b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f51316d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.k0.a1.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1177c implements View.OnClickListener {
        public View$OnClickListenerC1177c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51314b.E()) {
                return;
            }
            c.this.f51314b.Q(true);
            if (c.this.f51318f.i()) {
                c.this.f51318f.e();
                c.this.f51314b.c0();
                SkinManager.setBackgroundResource(c.this.f51314b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f51318f.n(c.this.f51314b.x());
            c.this.f51314b.d0();
            SkinManager.setBackgroundResource(c.this.f51314b.x(), R.color.CAM_X0201);
            if (c.this.f51315c == null || ListUtils.isEmpty(c.this.f51315c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f51315c.q(c.this.f51316d);
                c.this.u();
                c.this.f51314b.X(false);
                return;
            }
            c.this.f51314b.n0(null);
            c.this.f51313a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f51314b.f0();
            c.this.f51315c.r(c.this.f51316d);
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

        @Override // d.a.k0.a1.d.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            c.this.f51314b.A();
            c.this.f51314b.B();
            if (z || z2) {
                c.this.f51314b.n0(null);
            } else {
                c.this.f51314b.n0(c.this.q(i2));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f51315c.m()) && !StringUtils.isNull(d.a.j0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f51314b.R(c.this.f51318f.i());
                c.this.f51314b.e0();
                c.this.f51318f.l(c.this.f51315c.m());
            }
            if (i2 != 0) {
                c.this.f51314b.S(c.this.f51315c.l());
                c.this.f51314b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f51314b.w())) {
                c.this.f51314b.i0();
            } else if (z) {
                c.this.f51314b.j0();
            }
        }

        @Override // d.a.k0.a1.d.d.b.e
        public void b(int i2, String str, boolean z) {
            c.this.f51314b.n0(null);
            c.this.f51314b.A();
            c.this.f51314b.B();
            if (ListUtils.isEmpty(c.this.f51314b.w())) {
                c.this.f51314b.h0(new a());
                return;
            }
            if (z) {
                c.this.f51314b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f51313a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f51313a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51314b == null || c.this.f51315c == null) {
                return;
            }
            c.this.f51314b.f0();
            c.this.f51315c.r(c.this.f51316d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.a.k0.a1.d.b.b.f
        public void a(d.a.k0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f51316d = aVar.f51332a;
            c.this.m(aVar.f51332a);
            if (c.this.f51314b != null) {
                c.this.f51314b.U(aVar.f51332a);
                c.this.f51314b.R(false);
                c.this.f51314b.T(aVar.f51333b);
            }
        }

        @Override // d.a.k0.a1.d.b.b.f
        public void b() {
            if (c.this.f51314b != null) {
                c.this.f51314b.R(false);
                c.this.f51314b.H(false);
            }
        }

        @Override // d.a.k0.a1.d.b.b.f
        public void c() {
            c.this.f51314b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.k0.a1.d.b.a.b
        public void a(d.a.k0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f51316d = aVar.f51332a;
            c.this.m(aVar.f51332a);
            if (c.this.f51314b != null) {
                c.this.f51314b.U(aVar.f51332a);
                c.this.f51314b.R(false);
                c.this.f51314b.T(aVar.f51333b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51313a = tbPageContext;
        this.f51319g = bdUniqueId;
        this.f51314b = new d.a.k0.a1.d.f.b(tbPageContext, bdUniqueId, this.f51321i);
        this.f51315c = new d.a.k0.a1.d.d.b(this.f51313a, this.m);
        d.a.k0.a1.d.b.b bVar = new d.a.k0.a1.d.b.b(tbPageContext, this.f51319g);
        this.f51318f = bVar;
        bVar.m(this.o);
        d.a.k0.a1.d.b.a aVar = new d.a.k0.a1.d.b.a(tbPageContext, this.f51319g);
        this.f51317e = aVar;
        aVar.i(this.p);
        this.f51314b.W(this.j);
        int k = d.a.j0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f51316d = k;
        this.f51314b.U(k);
    }

    public final void m(int i2) {
        d.a.k0.a1.d.b.b bVar = this.f51318f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.a.k0.a1.d.d.b bVar2 = this.f51315c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            bVar.r();
        }
        d.a.k0.a1.d.b.b bVar2 = this.f51318f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.a.k0.a1.d.b.a aVar = this.f51317e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f51318f.i()) {
            SkinManager.setBackgroundResource(this.f51314b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f51314b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.a.k0.a1.d.b.a aVar;
        d.a.k0.a1.d.d.b bVar = this.f51315c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f51315c.o() || this.f51316d == 0) && (aVar = this.f51317e) != null) {
            aVar.h(this.f51315c.m());
            this.f51317e.c((ViewGroup) this.f51314b.y());
            d.a.j0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.a.j0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.k0.a1.d.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f51315c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f51315c.w(optString);
        this.f51315c.v(optString);
        d.a.k0.a1.d.f.b bVar2 = this.f51314b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f51313a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f51313a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f51315c.u();
        this.f51314b.C();
        this.f51314b.V(this.k);
        this.f51314b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f51320h);
    }

    public void t() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            bVar.s();
            this.f51314b.g0();
        }
        d.a.k0.a1.d.d.b bVar2 = this.f51315c;
        if (bVar2 != null) {
            bVar2.q(this.f51316d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f51316d));
    }

    public void v() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            bVar.V(null);
            this.f51314b.Y(null);
            this.f51314b.I();
        }
        d.a.k0.a1.d.b.b bVar2 = this.f51318f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.a.k0.a1.d.b.a aVar = this.f51317e;
        if (aVar != null) {
            aVar.g();
        }
        d.a.k0.a1.d.d.b bVar3 = this.f51315c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f51320h);
    }

    public void w() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            bVar.J();
            this.f51314b.K();
            this.f51314b.Z(true);
        }
    }

    public void x() {
        d.a.k0.a1.d.f.b bVar = this.f51314b;
        if (bVar != null) {
            bVar.G();
            this.f51314b.l0();
            this.f51314b.X(false);
            this.f51314b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f51316d));
            if (this.f51318f.i()) {
                return;
            }
            this.f51314b.a0();
            return;
        }
        d.a.k0.a1.d.b.b bVar = this.f51318f;
        if (bVar != null) {
            bVar.f();
        }
        this.f51314b.K();
    }
}
