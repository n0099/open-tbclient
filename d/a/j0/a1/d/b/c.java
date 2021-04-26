package d.a.j0.a1.d.b;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.q.v0;
import d.a.j0.a1.d.b.a;
import d.a.j0.a1.d.b.b;
import d.a.j0.a1.d.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50616a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.a1.d.f.b f50617b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.a1.d.d.b f50618c;

    /* renamed from: d  reason: collision with root package name */
    public int f50619d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a1.d.b.a f50620e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.a1.d.b.b f50621f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f50622g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f50623h = new a(2016488);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f50624i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1105c();
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
            if (c.this.f50617b != null) {
                c.this.f50617b.L();
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
            if (c.this.f50617b != null) {
                c.this.f50617b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f50619d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.j0.a1.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1105c implements View.OnClickListener {
        public View$OnClickListenerC1105c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f50617b.E()) {
                return;
            }
            c.this.f50617b.Q(true);
            if (c.this.f50621f.i()) {
                c.this.f50621f.e();
                c.this.f50617b.c0();
                SkinManager.setBackgroundResource(c.this.f50617b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f50621f.n(c.this.f50617b.x());
            c.this.f50617b.d0();
            SkinManager.setBackgroundResource(c.this.f50617b.x(), R.color.CAM_X0201);
            if (c.this.f50618c == null || ListUtils.isEmpty(c.this.f50618c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f50618c.q(c.this.f50619d);
                c.this.u();
                c.this.f50617b.X(false);
                return;
            }
            c.this.f50617b.n0(null);
            c.this.f50616a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f50617b.f0();
            c.this.f50618c.r(c.this.f50619d);
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

        @Override // d.a.j0.a1.d.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            c.this.f50617b.A();
            c.this.f50617b.B();
            if (z || z2) {
                c.this.f50617b.n0(null);
            } else {
                c.this.f50617b.n0(c.this.q(i2));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f50618c.m()) && !StringUtils.isNull(d.a.i0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f50617b.R(c.this.f50621f.i());
                c.this.f50617b.e0();
                c.this.f50621f.l(c.this.f50618c.m());
            }
            if (i2 != 0) {
                c.this.f50617b.S(c.this.f50618c.l());
                c.this.f50617b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f50617b.w())) {
                c.this.f50617b.i0();
            } else if (z) {
                c.this.f50617b.j0();
            }
        }

        @Override // d.a.j0.a1.d.d.b.e
        public void b(int i2, String str, boolean z) {
            c.this.f50617b.n0(null);
            c.this.f50617b.A();
            c.this.f50617b.B();
            if (ListUtils.isEmpty(c.this.f50617b.w())) {
                c.this.f50617b.h0(new a());
                return;
            }
            if (z) {
                c.this.f50617b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f50616a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f50616a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f50617b == null || c.this.f50618c == null) {
                return;
            }
            c.this.f50617b.f0();
            c.this.f50618c.r(c.this.f50619d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.a.j0.a1.d.b.b.f
        public void a(d.a.j0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f50619d = aVar.f50635a;
            c.this.m(aVar.f50635a);
            if (c.this.f50617b != null) {
                c.this.f50617b.U(aVar.f50635a);
                c.this.f50617b.R(false);
                c.this.f50617b.T(aVar.f50636b);
            }
        }

        @Override // d.a.j0.a1.d.b.b.f
        public void b() {
            if (c.this.f50617b != null) {
                c.this.f50617b.R(false);
                c.this.f50617b.H(false);
            }
        }

        @Override // d.a.j0.a1.d.b.b.f
        public void c() {
            c.this.f50617b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.j0.a1.d.b.a.b
        public void a(d.a.j0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f50619d = aVar.f50635a;
            c.this.m(aVar.f50635a);
            if (c.this.f50617b != null) {
                c.this.f50617b.U(aVar.f50635a);
                c.this.f50617b.R(false);
                c.this.f50617b.T(aVar.f50636b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f50616a = tbPageContext;
        this.f50622g = bdUniqueId;
        this.f50617b = new d.a.j0.a1.d.f.b(tbPageContext, bdUniqueId, this.f50624i);
        this.f50618c = new d.a.j0.a1.d.d.b(this.f50616a, this.m);
        d.a.j0.a1.d.b.b bVar = new d.a.j0.a1.d.b.b(tbPageContext, this.f50622g);
        this.f50621f = bVar;
        bVar.m(this.o);
        d.a.j0.a1.d.b.a aVar = new d.a.j0.a1.d.b.a(tbPageContext, this.f50622g);
        this.f50620e = aVar;
        aVar.i(this.p);
        this.f50617b.W(this.j);
        int k = d.a.i0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f50619d = k;
        this.f50617b.U(k);
    }

    public final void m(int i2) {
        d.a.j0.a1.d.b.b bVar = this.f50621f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.a.j0.a1.d.d.b bVar2 = this.f50618c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            bVar.r();
        }
        d.a.j0.a1.d.b.b bVar2 = this.f50621f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.a.j0.a1.d.b.a aVar = this.f50620e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f50621f.i()) {
            SkinManager.setBackgroundResource(this.f50617b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f50617b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.a.j0.a1.d.b.a aVar;
        d.a.j0.a1.d.d.b bVar = this.f50618c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f50618c.o() || this.f50619d == 0) && (aVar = this.f50620e) != null) {
            aVar.h(this.f50618c.m());
            this.f50620e.c((ViewGroup) this.f50617b.y());
            d.a.i0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.a.i0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.j0.a1.d.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f50618c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f50618c.w(optString);
        this.f50618c.v(optString);
        d.a.j0.a1.d.f.b bVar2 = this.f50617b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f50616a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f50616a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f50618c.u();
        this.f50617b.C();
        this.f50617b.V(this.k);
        this.f50617b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f50623h);
    }

    public void t() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            bVar.s();
            this.f50617b.g0();
        }
        d.a.j0.a1.d.d.b bVar2 = this.f50618c;
        if (bVar2 != null) {
            bVar2.q(this.f50619d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f50619d));
    }

    public void v() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            bVar.V(null);
            this.f50617b.Y(null);
            this.f50617b.I();
        }
        d.a.j0.a1.d.b.b bVar2 = this.f50621f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.a.j0.a1.d.b.a aVar = this.f50620e;
        if (aVar != null) {
            aVar.g();
        }
        d.a.j0.a1.d.d.b bVar3 = this.f50618c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f50623h);
    }

    public void w() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            bVar.J();
            this.f50617b.K();
            this.f50617b.Z(true);
        }
    }

    public void x() {
        d.a.j0.a1.d.f.b bVar = this.f50617b;
        if (bVar != null) {
            bVar.G();
            this.f50617b.l0();
            this.f50617b.X(false);
            this.f50617b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f50619d));
            if (this.f50621f.i()) {
                return;
            }
            this.f50617b.a0();
            return;
        }
        d.a.j0.a1.d.b.b bVar = this.f50621f;
        if (bVar != null) {
            bVar.f();
        }
        this.f50617b.K();
    }
}
