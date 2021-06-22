package d.a.o0.b1.l;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.q.v0;
import d.a.o0.b1.l.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.b1.l.c.b f55814a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.b1.l.e.a f55815b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55816c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f55817d = new C1274a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f55818e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f55819f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f55820g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f55821h = new e();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f55822i = new f();

    /* renamed from: d.a.o0.b1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1274a extends CustomMessageListener {
        public C1274a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f55815b != null) {
                a.this.f55815b.E();
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
            if (a.this.f55815b != null) {
                a.this.f55815b.G();
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

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f55815b.L(false);
                a.this.f55814a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f55815b.X(null);
            a.this.f55816c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f55815b.Q();
            a.this.f55814a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.a.o0.b1.l.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1275a implements View.OnClickListener {
            public View$OnClickListenerC1275a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.a.o0.b1.l.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            a.this.f55815b.t();
            a.this.f55815b.u();
            if (z || z2) {
                a.this.f55815b.X(null);
            } else {
                a.this.f55815b.X(a.this.i(i2));
            }
            if (i2 != 0) {
                a.this.f55815b.J(a.this.f55814a.h());
                a.this.f55815b.P(a.this.f55822i);
            } else if (ListUtils.isEmpty(a.this.f55815b.q())) {
                a.this.f55815b.T();
            } else if (z) {
                a.this.f55815b.U();
            }
        }

        @Override // d.a.o0.b1.l.c.b.f
        public void b(int i2, String str, boolean z) {
            a.this.f55815b.X(null);
            a.this.f55815b.t();
            a.this.f55815b.u();
            if (ListUtils.isEmpty(a.this.f55815b.q())) {
                a.this.f55815b.S(new View$OnClickListenerC1275a());
                return;
            }
            if (z) {
                a.this.f55815b.P(a.this.f55822i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f55816c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f55816c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55815b == null || a.this.f55814a == null) {
                return;
            }
            a.this.f55815b.Q();
            a.this.f55814a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55816c = tbPageContext;
        this.f55815b = new d.a.o0.b1.l.e.a(tbPageContext, bdUniqueId, this.f55818e);
        this.f55814a = new d.a.o0.b1.l.c.b(this.f55816c, this.f55821h);
    }

    public void g() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.o0.b1.l.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f55814a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f55814a.r(optString);
        this.f55814a.q(optString);
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        String string;
        if (i2 <= 0) {
            string = this.f55816c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f55816c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f55814a.p();
        this.f55815b.v();
        this.f55815b.K(this.f55819f);
        this.f55815b.M(this.f55820g);
        MessageManager.getInstance().registerListener(this.f55817d);
    }

    public void l() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.n();
            this.f55815b.R();
        }
        d.a.o0.b1.l.c.b bVar = this.f55814a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.K(null);
            this.f55815b.M(null);
            this.f55815b.A();
        }
        d.a.o0.b1.l.c.b bVar = this.f55814a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f55817d);
    }

    public void n() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.B();
            this.f55815b.C();
            this.f55815b.O(true);
        }
    }

    public void o() {
        d.a.o0.b1.l.e.a aVar = this.f55815b;
        if (aVar != null) {
            aVar.L(false);
            this.f55815b.W();
            this.f55815b.y();
            this.f55815b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f55815b.D();
        } else {
            this.f55815b.C();
        }
    }
}
