package d.a.n0.b1.l;

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
import d.a.m0.r.f0.f;
import d.a.m0.r.q.v0;
import d.a.n0.b1.l.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.b1.l.c.b f55689a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.l.e.a f55690b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55691c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f55692d = new C1270a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f55693e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f55694f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f55695g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f55696h = new e();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f55697i = new f();

    /* renamed from: d.a.n0.b1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1270a extends CustomMessageListener {
        public C1270a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f55690b != null) {
                a.this.f55690b.E();
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
            if (a.this.f55690b != null) {
                a.this.f55690b.G();
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

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f55690b.L(false);
                a.this.f55689a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f55690b.X(null);
            a.this.f55691c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f55690b.Q();
            a.this.f55689a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.a.n0.b1.l.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1271a implements View.OnClickListener {
            public View$OnClickListenerC1271a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.a.n0.b1.l.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            a.this.f55690b.t();
            a.this.f55690b.u();
            if (z || z2) {
                a.this.f55690b.X(null);
            } else {
                a.this.f55690b.X(a.this.i(i2));
            }
            if (i2 != 0) {
                a.this.f55690b.J(a.this.f55689a.h());
                a.this.f55690b.P(a.this.f55697i);
            } else if (ListUtils.isEmpty(a.this.f55690b.q())) {
                a.this.f55690b.T();
            } else if (z) {
                a.this.f55690b.U();
            }
        }

        @Override // d.a.n0.b1.l.c.b.f
        public void b(int i2, String str, boolean z) {
            a.this.f55690b.X(null);
            a.this.f55690b.t();
            a.this.f55690b.u();
            if (ListUtils.isEmpty(a.this.f55690b.q())) {
                a.this.f55690b.S(new View$OnClickListenerC1271a());
                return;
            }
            if (z) {
                a.this.f55690b.P(a.this.f55697i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f55691c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f55691c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55690b == null || a.this.f55689a == null) {
                return;
            }
            a.this.f55690b.Q();
            a.this.f55689a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55691c = tbPageContext;
        this.f55690b = new d.a.n0.b1.l.e.a(tbPageContext, bdUniqueId, this.f55693e);
        this.f55689a = new d.a.n0.b1.l.c.b(this.f55691c, this.f55696h);
    }

    public void g() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.n0.b1.l.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f55689a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f55689a.r(optString);
        this.f55689a.q(optString);
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f55691c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f55691c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f55689a.p();
        this.f55690b.v();
        this.f55690b.K(this.f55694f);
        this.f55690b.M(this.f55695g);
        MessageManager.getInstance().registerListener(this.f55692d);
    }

    public void l() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.n();
            this.f55690b.R();
        }
        d.a.n0.b1.l.c.b bVar = this.f55689a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.K(null);
            this.f55690b.M(null);
            this.f55690b.A();
        }
        d.a.n0.b1.l.c.b bVar = this.f55689a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f55692d);
    }

    public void n() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.B();
            this.f55690b.C();
            this.f55690b.O(true);
        }
    }

    public void o() {
        d.a.n0.b1.l.e.a aVar = this.f55690b;
        if (aVar != null) {
            aVar.L(false);
            this.f55690b.W();
            this.f55690b.y();
            this.f55690b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f55690b.D();
        } else {
            this.f55690b.C();
        }
    }
}
