package d.b.j0.a1.d.b;

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
import d.b.i0.r.f0.f;
import d.b.i0.r.q.v0;
import d.b.j0.a1.d.b.a;
import d.b.j0.a1.d.b.b;
import d.b.j0.a1.d.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52917a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.a1.d.f.b f52918b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.a1.d.d.b f52919c;

    /* renamed from: d  reason: collision with root package name */
    public int f52920d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.a1.d.b.a f52921e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.a1.d.b.b f52922f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f52923g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f52924h = new a(2016488);
    public NEGFeedBackView.b i = new b();
    public final View.OnClickListener j = new View$OnClickListenerC1166c();
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
            if (c.this.f52918b != null) {
                c.this.f52918b.L();
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
            if (c.this.f52918b != null) {
                c.this.f52918b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.j).param("obj_source", v0Var.k).param("obj_id", v0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", v0Var.c()).param("tid", v0Var.e()).param("obj_type", c.this.f52920d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.b.j0.a1.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1166c implements View.OnClickListener {
        public View$OnClickListenerC1166c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f52918b.E()) {
                return;
            }
            c.this.f52918b.Q(true);
            if (c.this.f52922f.i()) {
                c.this.f52922f.e();
                c.this.f52918b.c0();
                SkinManager.setBackgroundResource(c.this.f52918b.x(), R.color.CAM_X0207);
                return;
            }
            c.this.f52922f.n(c.this.f52918b.x());
            c.this.f52918b.d0();
            SkinManager.setBackgroundResource(c.this.f52918b.x(), R.color.CAM_X0201);
            if (c.this.f52919c == null || ListUtils.isEmpty(c.this.f52919c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                c.this.f52919c.q(c.this.f52920d);
                c.this.u();
                c.this.f52918b.X(false);
                return;
            }
            c.this.f52918b.n0(null);
            c.this.f52917a.showToast(R.string.im_error_default);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f52918b.f0();
            c.this.f52919c.r(c.this.f52920d);
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

        @Override // d.b.j0.a1.d.d.b.e
        public void a(int i, boolean z, boolean z2) {
            c.this.f52918b.A();
            c.this.f52918b.B();
            if (z || z2) {
                c.this.f52918b.n0(null);
            } else {
                c.this.f52918b.n0(c.this.q(i));
            }
            if (c.this.o()) {
                return;
            }
            if (!ListUtils.isEmpty(c.this.f52919c.m()) && !StringUtils.isNull(d.b.i0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                c.this.f52918b.R(c.this.f52922f.i());
                c.this.f52918b.e0();
                c.this.f52922f.l(c.this.f52919c.m());
            }
            if (i != 0) {
                c.this.f52918b.S(c.this.f52919c.l());
                c.this.f52918b.b0(c.this.n);
            } else if (ListUtils.isEmpty(c.this.f52918b.w())) {
                c.this.f52918b.i0();
            } else if (z) {
                c.this.f52918b.j0();
            }
        }

        @Override // d.b.j0.a1.d.d.b.e
        public void b(int i, String str, boolean z) {
            c.this.f52918b.n0(null);
            c.this.f52918b.A();
            c.this.f52918b.B();
            if (ListUtils.isEmpty(c.this.f52918b.w())) {
                c.this.f52918b.h0(new a());
                return;
            }
            if (z) {
                c.this.f52918b.b0(c.this.n);
            }
            if (StringUtils.isNull(str)) {
                c.this.f52917a.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.f52917a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f52918b == null || c.this.f52919c == null) {
                return;
            }
            c.this.f52918b.f0();
            c.this.f52919c.r(c.this.f52920d);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.f {
        public h() {
        }

        @Override // d.b.j0.a1.d.b.b.f
        public void a(d.b.j0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f52920d = aVar.f52935a;
            c.this.m(aVar.f52935a);
            if (c.this.f52918b != null) {
                c.this.f52918b.U(aVar.f52935a);
                c.this.f52918b.R(false);
                c.this.f52918b.T(aVar.f52936b);
            }
        }

        @Override // d.b.j0.a1.d.b.b.f
        public void b() {
            if (c.this.f52918b != null) {
                c.this.f52918b.R(false);
                c.this.f52918b.H(false);
            }
        }

        @Override // d.b.j0.a1.d.b.b.f
        public void c() {
            c.this.f52918b.H(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.b.j0.a1.d.b.a.b
        public void a(d.b.j0.a1.d.c.a aVar) {
            if (aVar == null) {
                return;
            }
            c.this.f52920d = aVar.f52935a;
            c.this.m(aVar.f52935a);
            if (c.this.f52918b != null) {
                c.this.f52918b.U(aVar.f52935a);
                c.this.f52918b.R(false);
                c.this.f52918b.T(aVar.f52936b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52917a = tbPageContext;
        this.f52923g = bdUniqueId;
        this.f52918b = new d.b.j0.a1.d.f.b(tbPageContext, bdUniqueId, this.i);
        this.f52919c = new d.b.j0.a1.d.d.b(this.f52917a, this.m);
        d.b.j0.a1.d.b.b bVar = new d.b.j0.a1.d.b.b(tbPageContext, this.f52923g);
        this.f52922f = bVar;
        bVar.m(this.o);
        d.b.j0.a1.d.b.a aVar = new d.b.j0.a1.d.b.a(tbPageContext, this.f52923g);
        this.f52921e = aVar;
        aVar.i(this.p);
        this.f52918b.W(this.j);
        int k = d.b.i0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f52920d = k;
        this.f52918b.U(k);
    }

    public final void m(int i2) {
        d.b.j0.a1.d.b.b bVar = this.f52922f;
        if (bVar != null) {
            bVar.p(i2);
        }
        d.b.j0.a1.d.d.b bVar2 = this.f52919c;
        if (bVar2 != null) {
            bVar2.x();
        }
        t();
    }

    public void n() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            bVar.r();
        }
        d.b.j0.a1.d.b.b bVar2 = this.f52922f;
        if (bVar2 != null) {
            bVar2.j();
        }
        d.b.j0.a1.d.b.a aVar = this.f52921e;
        if (aVar != null) {
            aVar.f();
        }
        if (this.f52922f.i()) {
            SkinManager.setBackgroundResource(this.f52918b.x(), R.color.CAM_X0201);
        } else {
            SkinManager.setBackgroundResource(this.f52918b.x(), R.color.CAM_X0207);
        }
    }

    public final boolean o() {
        d.b.j0.a1.d.b.a aVar;
        d.b.j0.a1.d.d.b bVar = this.f52919c;
        if (bVar == null || ListUtils.isEmpty(bVar.m())) {
            return false;
        }
        if ((this.f52919c.o() || this.f52920d == 0) && (aVar = this.f52921e) != null) {
            aVar.h(this.f52919c.m());
            this.f52921e.c((ViewGroup) this.f52918b.y());
            d.b.i0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
            d.b.i0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
            return true;
        }
        return false;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.j0.a1.d.d.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f52919c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f52919c.w(optString);
        this.f52919c.v(optString);
        d.b.j0.a1.d.f.b bVar2 = this.f52918b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f52917a.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.f52917a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View r() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            return bVar.y();
        }
        return null;
    }

    public void s() {
        this.f52919c.u();
        this.f52918b.C();
        this.f52918b.V(this.k);
        this.f52918b.Y(this.l);
        MessageManager.getInstance().registerListener(this.f52924h);
    }

    public void t() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            bVar.s();
            this.f52918b.g0();
        }
        d.b.j0.a1.d.d.b bVar2 = this.f52919c;
        if (bVar2 != null) {
            bVar2.q(this.f52920d);
        }
    }

    public final void u() {
        TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f52920d));
    }

    public void v() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            bVar.V(null);
            this.f52918b.Y(null);
            this.f52918b.I();
        }
        d.b.j0.a1.d.b.b bVar2 = this.f52922f;
        if (bVar2 != null) {
            bVar2.k();
        }
        d.b.j0.a1.d.b.a aVar = this.f52921e;
        if (aVar != null) {
            aVar.g();
        }
        d.b.j0.a1.d.d.b bVar3 = this.f52919c;
        if (bVar3 != null) {
            bVar3.t();
        }
        MessageManager.getInstance().unRegisterListener(this.f52924h);
    }

    public void w() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            bVar.J();
            this.f52918b.K();
            this.f52918b.Z(true);
        }
    }

    public void x() {
        d.b.j0.a1.d.f.b bVar = this.f52918b;
        if (bVar != null) {
            bVar.G();
            this.f52918b.l0();
            this.f52918b.X(false);
            this.f52918b.m0();
        }
    }

    public void y(boolean z) {
        if (z) {
            TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f52920d));
            if (this.f52922f.i()) {
                return;
            }
            this.f52918b.a0();
            return;
        }
        d.b.j0.a1.d.b.b bVar = this.f52922f;
        if (bVar != null) {
            bVar.f();
        }
        this.f52918b.K();
    }
}
