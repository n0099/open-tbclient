package d.b.j0.a1.k;

import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.i0.r.f0.f;
import d.b.i0.r.q.v0;
import d.b.j0.a1.k.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.a1.k.c.b f53409a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.a1.k.e.a f53410b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f53411c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f53412d = new C1186a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f53413e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f53414f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f53415g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f53416h = new e();
    public View.OnClickListener i = new f();

    /* renamed from: d.b.j0.a1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1186a extends CustomMessageListener {
        public C1186a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f53410b != null) {
                a.this.f53410b.E();
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
            for (int i = 0; i < size; i++) {
                sb.append(arrayList.get(i));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i2 = v0Var.m;
            if (i2 != 0 && i2 == 40) {
            }
            if (a.this.f53410b != null) {
                a.this.f53410b.G();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f53410b.L(false);
                a.this.f53409a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f53410b.X(null);
            a.this.f53411c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f53410b.Q();
            a.this.f53409a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.b.j0.a1.k.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1187a implements View.OnClickListener {
            public View$OnClickListenerC1187a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.b.j0.a1.k.c.b.f
        public void a(int i, boolean z, boolean z2) {
            a.this.f53410b.t();
            a.this.f53410b.u();
            if (z || z2) {
                a.this.f53410b.X(null);
            } else {
                a.this.f53410b.X(a.this.i(i));
            }
            if (i != 0) {
                a.this.f53410b.J(a.this.f53409a.h());
                a.this.f53410b.P(a.this.i);
            } else if (ListUtils.isEmpty(a.this.f53410b.q())) {
                a.this.f53410b.T();
            } else if (z) {
                a.this.f53410b.U();
            }
        }

        @Override // d.b.j0.a1.k.c.b.f
        public void b(int i, String str, boolean z) {
            a.this.f53410b.X(null);
            a.this.f53410b.t();
            a.this.f53410b.u();
            if (ListUtils.isEmpty(a.this.f53410b.q())) {
                a.this.f53410b.S(new View$OnClickListenerC1187a());
                return;
            }
            if (z) {
                a.this.f53410b.P(a.this.i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f53411c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f53411c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f53410b == null || a.this.f53409a == null) {
                return;
            }
            a.this.f53410b.Q();
            a.this.f53409a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f53411c = tbPageContext;
        this.f53410b = new d.b.j0.a1.k.e.a(tbPageContext, bdUniqueId, this.f53413e);
        this.f53409a = new d.b.j0.a1.k.c.b(this.f53411c, this.f53416h);
    }

    public void g() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.j0.a1.k.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f53409a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f53409a.r(optString);
        this.f53409a.q(optString);
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i) {
        String string;
        if (i <= 0) {
            string = this.f53411c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f53411c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f53409a.p();
        this.f53410b.v();
        this.f53410b.K(this.f53414f);
        this.f53410b.M(this.f53415g);
        MessageManager.getInstance().registerListener(this.f53412d);
    }

    public void l() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.n();
            this.f53410b.R();
        }
        d.b.j0.a1.k.c.b bVar = this.f53409a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.K(null);
            this.f53410b.M(null);
            this.f53410b.A();
        }
        d.b.j0.a1.k.c.b bVar = this.f53409a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f53412d);
    }

    public void n() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.B();
            this.f53410b.C();
            this.f53410b.O(true);
        }
    }

    public void o() {
        d.b.j0.a1.k.e.a aVar = this.f53410b;
        if (aVar != null) {
            aVar.L(false);
            this.f53410b.W();
            this.f53410b.y();
            this.f53410b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f53410b.D();
        } else {
            this.f53410b.C();
        }
    }
}
