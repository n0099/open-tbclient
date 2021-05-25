package d.a.n0.b1.k;

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
import d.a.n0.b1.k.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.b1.k.c.b f52000a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.k.e.a f52001b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f52002c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f52003d = new C1214a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f52004e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f52005f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f52006g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f52007h = new e();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f52008i = new f();

    /* renamed from: d.a.n0.b1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1214a extends CustomMessageListener {
        public C1214a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f52001b != null) {
                a.this.f52001b.E();
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
            if (a.this.f52001b != null) {
                a.this.f52001b.G();
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
                a.this.f52001b.L(false);
                a.this.f52000a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f52001b.X(null);
            a.this.f52002c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f52001b.Q();
            a.this.f52000a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.a.n0.b1.k.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1215a implements View.OnClickListener {
            public View$OnClickListenerC1215a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.a.n0.b1.k.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            a.this.f52001b.t();
            a.this.f52001b.u();
            if (z || z2) {
                a.this.f52001b.X(null);
            } else {
                a.this.f52001b.X(a.this.i(i2));
            }
            if (i2 != 0) {
                a.this.f52001b.J(a.this.f52000a.h());
                a.this.f52001b.P(a.this.f52008i);
            } else if (ListUtils.isEmpty(a.this.f52001b.q())) {
                a.this.f52001b.T();
            } else if (z) {
                a.this.f52001b.U();
            }
        }

        @Override // d.a.n0.b1.k.c.b.f
        public void b(int i2, String str, boolean z) {
            a.this.f52001b.X(null);
            a.this.f52001b.t();
            a.this.f52001b.u();
            if (ListUtils.isEmpty(a.this.f52001b.q())) {
                a.this.f52001b.S(new View$OnClickListenerC1215a());
                return;
            }
            if (z) {
                a.this.f52001b.P(a.this.f52008i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f52002c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f52002c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52001b == null || a.this.f52000a == null) {
                return;
            }
            a.this.f52001b.Q();
            a.this.f52000a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52002c = tbPageContext;
        this.f52001b = new d.a.n0.b1.k.e.a(tbPageContext, bdUniqueId, this.f52004e);
        this.f52000a = new d.a.n0.b1.k.c.b(this.f52002c, this.f52007h);
    }

    public void g() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.n0.b1.k.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f52000a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f52000a.r(optString);
        this.f52000a.q(optString);
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f52002c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f52002c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f52000a.p();
        this.f52001b.v();
        this.f52001b.K(this.f52005f);
        this.f52001b.M(this.f52006g);
        MessageManager.getInstance().registerListener(this.f52003d);
    }

    public void l() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.n();
            this.f52001b.R();
        }
        d.a.n0.b1.k.c.b bVar = this.f52000a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.K(null);
            this.f52001b.M(null);
            this.f52001b.A();
        }
        d.a.n0.b1.k.c.b bVar = this.f52000a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f52003d);
    }

    public void n() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.B();
            this.f52001b.C();
            this.f52001b.O(true);
        }
    }

    public void o() {
        d.a.n0.b1.k.e.a aVar = this.f52001b;
        if (aVar != null) {
            aVar.L(false);
            this.f52001b.W();
            this.f52001b.y();
            this.f52001b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f52001b.D();
        } else {
            this.f52001b.C();
        }
    }
}
