package d.a.j0.a1.k;

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
import d.a.c.e.p.j;
import d.a.i0.r.f0.f;
import d.a.i0.r.q.v0;
import d.a.j0.a1.k.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.a1.k.c.b f51134a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.a1.k.e.a f51135b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f51136c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f51137d = new C1125a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f51138e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f51139f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f51140g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f51141h = new e();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f51142i = new f();

    /* renamed from: d.a.j0.a1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1125a extends CustomMessageListener {
        public C1125a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f51135b != null) {
                a.this.f51135b.E();
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
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = v0Var.m;
            if (i3 != 0 && i3 == 40) {
            }
            if (a.this.f51135b != null) {
                a.this.f51135b.G();
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

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f51135b.L(false);
                a.this.f51134a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f51135b.X(null);
            a.this.f51136c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f51135b.Q();
            a.this.f51134a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.a.j0.a1.k.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1126a implements View.OnClickListener {
            public View$OnClickListenerC1126a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.a.j0.a1.k.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            a.this.f51135b.t();
            a.this.f51135b.u();
            if (z || z2) {
                a.this.f51135b.X(null);
            } else {
                a.this.f51135b.X(a.this.i(i2));
            }
            if (i2 != 0) {
                a.this.f51135b.J(a.this.f51134a.h());
                a.this.f51135b.P(a.this.f51142i);
            } else if (ListUtils.isEmpty(a.this.f51135b.q())) {
                a.this.f51135b.T();
            } else if (z) {
                a.this.f51135b.U();
            }
        }

        @Override // d.a.j0.a1.k.c.b.f
        public void b(int i2, String str, boolean z) {
            a.this.f51135b.X(null);
            a.this.f51135b.t();
            a.this.f51135b.u();
            if (ListUtils.isEmpty(a.this.f51135b.q())) {
                a.this.f51135b.S(new View$OnClickListenerC1126a());
                return;
            }
            if (z) {
                a.this.f51135b.P(a.this.f51142i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f51136c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f51136c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51135b == null || a.this.f51134a == null) {
                return;
            }
            a.this.f51135b.Q();
            a.this.f51134a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51136c = tbPageContext;
        this.f51135b = new d.a.j0.a1.k.e.a(tbPageContext, bdUniqueId, this.f51138e);
        this.f51134a = new d.a.j0.a1.k.c.b(this.f51136c, this.f51141h);
    }

    public void g() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.j0.a1.k.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f51134a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f51134a.r(optString);
        this.f51134a.q(optString);
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f51136c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f51136c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f51134a.p();
        this.f51135b.v();
        this.f51135b.K(this.f51139f);
        this.f51135b.M(this.f51140g);
        MessageManager.getInstance().registerListener(this.f51137d);
    }

    public void l() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.n();
            this.f51135b.R();
        }
        d.a.j0.a1.k.c.b bVar = this.f51134a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.K(null);
            this.f51135b.M(null);
            this.f51135b.A();
        }
        d.a.j0.a1.k.c.b bVar = this.f51134a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f51137d);
    }

    public void n() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.B();
            this.f51135b.C();
            this.f51135b.O(true);
        }
    }

    public void o() {
        d.a.j0.a1.k.e.a aVar = this.f51135b;
        if (aVar != null) {
            aVar.L(false);
            this.f51135b.W();
            this.f51135b.y();
            this.f51135b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f51135b.D();
        } else {
            this.f51135b.C();
        }
    }
}
