package d.a.n0.b1.e.b;

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
import d.a.n0.b1.e.b.a;
import d.a.n0.b1.e.b.b;
import d.a.n0.b1.e.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55161a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.e.f.b f55162b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.b1.e.d.b f55163c;

    /* renamed from: d  reason: collision with root package name */
    public int f55164d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.e.b.a f55165e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.e.b.b f55166f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f55167g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55168h = new a(2016488);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f55169i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1250c();
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
            if (c.this.f55162b != null) {
                c.this.f55162b.L();
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
            if (c.this.f55162b != null) {
                c.this.f55162b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f55164d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.n0.b1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1250c implements View.OnClickListener {
        public View$OnClickListenerC1250c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f55162b.E()) {
                return;
            }
            c.this.f55162b.Q(true);
            if (c.this.f55166f.i()) {
                c.this.f55166f.e();
                c.this.f55162b.c0();
                SkinManager.setBackgroundResource(c.this.f55162b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f55166f.n(c.this.f55162b.x());
            c.this.f55162b.d0();
            SkinManager.setBackgroundResource(c.this.f55162b.x(), R.color.CAM_X0201);
            if (c.this.f55163c == null || ListUtils.isEmpty(c.this.f55163c.m())) {
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
                c.this.f55163c.q(c.this.f55164d);
                c.this.u();
                c.this.f55162b.X(false);
                return;
            }
            c.this.f55162b.n0(null);
            c.this.f55161a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f55162b.f0();
            c.this.f55163c.r(c.this.f55164d);
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

        @Override // d.a.n0.b1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            c.this.f55162b.A();
            c.this.f55162b.B();
            if (z || z2) {
                c.this.f55162b.n0(null);
            } else {
                c.this.f55162b.n0(c.this.q(i2));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f55163c.m()) && !StringUtils.isNull(d.a.m0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f55162b.R(c.this.f55166f.i());
                c.this.f55162b.e0();
                c.this.f55166f.l(c.this.f55163c.m());
            }
            if (i2 != 0) {
                c.this.f55162b.S(c.this.f55163c.l());
                c.this.f55162b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f55162b.w())) {
                c.this.f55162b.i0();
            } else if (z) {
                c.this.f55162b.j0();
            }
        }

        @Override // d.a.n0.b1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            c.this.f55162b.n0(null);
            c.this.f55162b.A();
            c.this.f55162b.B();
            if (ListUtils.isEmpty(c.this.f55162b.w())) {
                c.this.f55162b.h0(new a());
                return;
            }
            if (z) {
                c.this.f55162b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f55161a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f55161a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f55162b == null || c.this.f55163c == null) {
                return;
            }
            c.this.f55162b.f0();
            c.this.f55163c.r(c.this.f55164d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.a.n0.b1.e.b.b.f
        public void a(d.a.n0.b1.e.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f55164d = aVar.f55180a;
            c.this.m(aVar.f55180a);
            if (c.this.f55162b != null) {
                c.this.f55162b.U(aVar.f55180a);
                c.this.f55162b.R(false);
                c.this.f55162b.T(aVar.f55181b);
            }
        }

        @Override // d.a.n0.b1.e.b.b.f
        public void b() {
            if (c.this.f55162b != null) {
                c.this.f55162b.R(false);
                c.this.f55162b.H(false);
            }
        }

        @Override // d.a.n0.b1.e.b.b.f
        public void c() {
            c.this.f55162b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.n0.b1.e.b.a.b
        public void a(d.a.n0.b1.e.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f55164d = aVar.f55180a;
            c.this.m(aVar.f55180a);
            if (c.this.f55162b != null) {
                c.this.f55162b.U(aVar.f55180a);
                c.this.f55162b.R(false);
                c.this.f55162b.T(aVar.f55181b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55161a = tbPageContext;
        this.f55167g = bdUniqueId;
        this.f55162b = new d.a.n0.b1.e.f.b(tbPageContext, bdUniqueId, this.f55169i);
        this.f55163c = new d.a.n0.b1.e.d.b(this.f55161a, this.m);
        d.a.n0.b1.e.b.b bVar = new d.a.n0.b1.e.b.b(tbPageContext, this.f55167g);
        this.f55166f = bVar;
        bVar.m(this.o);
        d.a.n0.b1.e.b.a aVar = new d.a.n0.b1.e.b.a(tbPageContext, this.f55167g);
        this.f55165e = aVar;
        aVar.i(this.p);
        this.f55162b.W(this.j);
        int k = d.a.m0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f55164d = k;
        this.f55162b.U(k);
    }

    public final void m(int i2) {
        d.a.n0.b1.e.b.b bVar = this.f55166f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.a.n0.b1.e.d.b bVar2 = this.f55163c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            bVar.r();
        }
        d.a.n0.b1.e.b.b bVar2 = this.f55166f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.a.n0.b1.e.b.a aVar = this.f55165e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f55166f.i()) {
            SkinManager.setBackgroundResource(this.f55162b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f55162b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.a.n0.b1.e.b.a aVar;
        d.a.n0.b1.e.d.b bVar = this.f55163c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f55163c.o() || this.f55164d == 0) && (aVar = this.f55165e) != null) {
            aVar.h(this.f55163c.m());
            this.f55165e.c((ViewGroup) this.f55162b.y());
            d.a.m0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.a.m0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.n0.b1.e.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f55163c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f55163c.w(optString);
        this.f55163c.v(optString);
        d.a.n0.b1.e.f.b bVar2 = this.f55162b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f55161a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f55161a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f55163c.u();
        this.f55162b.C();
        this.f55162b.V(this.k);
        this.f55162b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f55168h);
    }

    public void t() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            bVar.s();
            this.f55162b.g0();
        }
        d.a.n0.b1.e.d.b bVar2 = this.f55163c;
        if (bVar2 != null) {
            bVar2.q(this.f55164d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f55164d));
    }

    public void v() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            bVar.V(null);
            this.f55162b.Y(null);
            this.f55162b.I();
        }
        d.a.n0.b1.e.b.b bVar2 = this.f55166f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.a.n0.b1.e.b.a aVar = this.f55165e;
        if (aVar != null) {
            aVar.g();
        }
        d.a.n0.b1.e.d.b bVar3 = this.f55163c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f55168h);
    }

    public void w() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            bVar.J();
            this.f55162b.K();
            this.f55162b.Z(true);
        }
    }

    public void x() {
        d.a.n0.b1.e.f.b bVar = this.f55162b;
        if (bVar != null) {
            bVar.G();
            this.f55162b.l0();
            this.f55162b.X(false);
            this.f55162b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f55164d));
            if (this.f55166f.i()) {
                return;
            }
            this.f55162b.a0();
            return;
        }
        d.a.n0.b1.e.b.b bVar = this.f55166f;
        if (bVar != null) {
            bVar.f();
        }
        this.f55162b.K();
    }
}
