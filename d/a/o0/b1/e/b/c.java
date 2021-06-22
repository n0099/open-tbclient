package d.a.o0.b1.e.b;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.q.v0;
import d.a.o0.b1.e.b.a;
import d.a.o0.b1.e.b.b;
import d.a.o0.b1.e.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55286a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.b1.e.f.b f55287b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.b1.e.d.b f55288c;

    /* renamed from: d  reason: collision with root package name */
    public int f55289d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.b1.e.b.a f55290e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.b1.e.b.b f55291f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f55292g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55293h = new a(2016488);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f55294i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1254c();
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
            if (c.this.f55287b != null) {
                c.this.f55287b.L();
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
            if (c.this.f55287b != null) {
                c.this.f55287b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f55289d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.o0.b1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1254c implements View.OnClickListener {
        public View$OnClickListenerC1254c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f55287b.E()) {
                return;
            }
            c.this.f55287b.Q(true);
            if (c.this.f55291f.i()) {
                c.this.f55291f.e();
                c.this.f55287b.c0();
                SkinManager.setBackgroundResource(c.this.f55287b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f55291f.n(c.this.f55287b.x());
            c.this.f55287b.d0();
            SkinManager.setBackgroundResource(c.this.f55287b.x(), R.color.CAM_X0201);
            if (c.this.f55288c == null || ListUtils.isEmpty(c.this.f55288c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f55288c.q(c.this.f55289d);
                c.this.u();
                c.this.f55287b.X(false);
                return;
            }
            c.this.f55287b.n0(null);
            c.this.f55286a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f55287b.f0();
            c.this.f55288c.r(c.this.f55289d);
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

        @Override // d.a.o0.b1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            c.this.f55287b.A();
            c.this.f55287b.B();
            if (z || z2) {
                c.this.f55287b.n0(null);
            } else {
                c.this.f55287b.n0(c.this.q(i2));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f55288c.m()) && !StringUtils.isNull(d.a.n0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f55287b.R(c.this.f55291f.i());
                c.this.f55287b.e0();
                c.this.f55291f.l(c.this.f55288c.m());
            }
            if (i2 != 0) {
                c.this.f55287b.S(c.this.f55288c.l());
                c.this.f55287b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f55287b.w())) {
                c.this.f55287b.i0();
            } else if (z) {
                c.this.f55287b.j0();
            }
        }

        @Override // d.a.o0.b1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            c.this.f55287b.n0(null);
            c.this.f55287b.A();
            c.this.f55287b.B();
            if (ListUtils.isEmpty(c.this.f55287b.w())) {
                c.this.f55287b.h0(new a());
                return;
            }
            if (z) {
                c.this.f55287b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f55286a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f55286a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f55287b == null || c.this.f55288c == null) {
                return;
            }
            c.this.f55287b.f0();
            c.this.f55288c.r(c.this.f55289d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.a.o0.b1.e.b.b.f
        public void a(d.a.o0.b1.e.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f55289d = aVar.f55305a;
            c.this.m(aVar.f55305a);
            if (c.this.f55287b != null) {
                c.this.f55287b.U(aVar.f55305a);
                c.this.f55287b.R(false);
                c.this.f55287b.T(aVar.f55306b);
            }
        }

        @Override // d.a.o0.b1.e.b.b.f
        public void b() {
            if (c.this.f55287b != null) {
                c.this.f55287b.R(false);
                c.this.f55287b.H(false);
            }
        }

        @Override // d.a.o0.b1.e.b.b.f
        public void c() {
            c.this.f55287b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.o0.b1.e.b.a.b
        public void a(d.a.o0.b1.e.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f55289d = aVar.f55305a;
            c.this.m(aVar.f55305a);
            if (c.this.f55287b != null) {
                c.this.f55287b.U(aVar.f55305a);
                c.this.f55287b.R(false);
                c.this.f55287b.T(aVar.f55306b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55286a = tbPageContext;
        this.f55292g = bdUniqueId;
        this.f55287b = new d.a.o0.b1.e.f.b(tbPageContext, bdUniqueId, this.f55294i);
        this.f55288c = new d.a.o0.b1.e.d.b(this.f55286a, this.m);
        d.a.o0.b1.e.b.b bVar = new d.a.o0.b1.e.b.b(tbPageContext, this.f55292g);
        this.f55291f = bVar;
        bVar.m(this.o);
        d.a.o0.b1.e.b.a aVar = new d.a.o0.b1.e.b.a(tbPageContext, this.f55292g);
        this.f55290e = aVar;
        aVar.i(this.p);
        this.f55287b.W(this.j);
        int k = d.a.n0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f55289d = k;
        this.f55287b.U(k);
    }

    public final void m(int i2) {
        d.a.o0.b1.e.b.b bVar = this.f55291f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.a.o0.b1.e.d.b bVar2 = this.f55288c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            bVar.r();
        }
        d.a.o0.b1.e.b.b bVar2 = this.f55291f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.a.o0.b1.e.b.a aVar = this.f55290e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f55291f.i()) {
            SkinManager.setBackgroundResource(this.f55287b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f55287b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.a.o0.b1.e.b.a aVar;
        d.a.o0.b1.e.d.b bVar = this.f55288c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f55288c.o() || this.f55289d == 0) && (aVar = this.f55290e) != null) {
            aVar.h(this.f55288c.m());
            this.f55290e.c((ViewGroup) this.f55287b.y());
            d.a.n0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.a.n0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.o0.b1.e.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f55288c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f55288c.w(optString);
        this.f55288c.v(optString);
        d.a.o0.b1.e.f.b bVar2 = this.f55287b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f55286a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f55286a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f55288c.u();
        this.f55287b.C();
        this.f55287b.V(this.k);
        this.f55287b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f55293h);
    }

    public void t() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            bVar.s();
            this.f55287b.g0();
        }
        d.a.o0.b1.e.d.b bVar2 = this.f55288c;
        if (bVar2 != null) {
            bVar2.q(this.f55289d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f55289d));
    }

    public void v() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            bVar.V(null);
            this.f55287b.Y(null);
            this.f55287b.I();
        }
        d.a.o0.b1.e.b.b bVar2 = this.f55291f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.a.o0.b1.e.b.a aVar = this.f55290e;
        if (aVar != null) {
            aVar.g();
        }
        d.a.o0.b1.e.d.b bVar3 = this.f55288c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f55293h);
    }

    public void w() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            bVar.J();
            this.f55287b.K();
            this.f55287b.Z(true);
        }
    }

    public void x() {
        d.a.o0.b1.e.f.b bVar = this.f55287b;
        if (bVar != null) {
            bVar.G();
            this.f55287b.l0();
            this.f55287b.X(false);
            this.f55287b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f55289d));
            if (this.f55291f.i()) {
                return;
            }
            this.f55287b.a0();
            return;
        }
        d.a.o0.b1.e.b.b bVar = this.f55291f;
        if (bVar != null) {
            bVar.f();
        }
        this.f55287b.K();
    }
}
