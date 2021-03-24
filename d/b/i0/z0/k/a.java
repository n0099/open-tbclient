package d.b.i0.z0.k;

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
import d.b.b.e.p.j;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.v0;
import d.b.i0.z0.k.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.z0.k.c.b f63368a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.z0.k.e.a f63369b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f63370c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f63371d = new C1710a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f63372e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f63373f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f63374g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f63375h = new e();
    public View.OnClickListener i = new f();

    /* renamed from: d.b.i0.z0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1710a extends CustomMessageListener {
        public C1710a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f63369b != null) {
                a.this.f63369b.E();
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
            if (a.this.f63369b != null) {
                a.this.f63369b.G();
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

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f63369b.L(false);
                a.this.f63368a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f63369b.X(null);
            a.this.f63370c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f63369b.Q();
            a.this.f63368a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.f {

        /* renamed from: d.b.i0.z0.k.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1711a implements View.OnClickListener {
            public View$OnClickListenerC1711a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.l();
            }
        }

        public e() {
        }

        @Override // d.b.i0.z0.k.c.b.f
        public void a(int i, boolean z, boolean z2) {
            a.this.f63369b.t();
            a.this.f63369b.u();
            if (z || z2) {
                a.this.f63369b.X(null);
            } else {
                a.this.f63369b.X(a.this.i(i));
            }
            if (i != 0) {
                a.this.f63369b.J(a.this.f63368a.h());
                a.this.f63369b.P(a.this.i);
            } else if (ListUtils.isEmpty(a.this.f63369b.q())) {
                a.this.f63369b.T();
            } else if (z) {
                a.this.f63369b.U();
            }
        }

        @Override // d.b.i0.z0.k.c.b.f
        public void b(int i, String str, boolean z) {
            a.this.f63369b.X(null);
            a.this.f63369b.t();
            a.this.f63369b.u();
            if (ListUtils.isEmpty(a.this.f63369b.q())) {
                a.this.f63369b.S(new View$OnClickListenerC1711a());
                return;
            }
            if (z) {
                a.this.f63369b.P(a.this.i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f63370c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f63370c.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63369b == null || a.this.f63368a == null) {
                return;
            }
            a.this.f63369b.Q();
            a.this.f63368a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f63370c = tbPageContext;
        this.f63369b = new d.b.i0.z0.k.e.a(tbPageContext, bdUniqueId, this.f63372e);
        this.f63368a = new d.b.i0.z0.k.c.b(this.f63370c, this.f63375h);
    }

    public void g() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.z0.k.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f63368a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f63368a.r(optString);
        this.f63368a.q(optString);
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i) {
        String string;
        if (i <= 0) {
            string = this.f63370c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f63370c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f63368a.p();
        this.f63369b.v();
        this.f63369b.K(this.f63373f);
        this.f63369b.M(this.f63374g);
        MessageManager.getInstance().registerListener(this.f63371d);
    }

    public void l() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.n();
            this.f63369b.R();
        }
        d.b.i0.z0.k.c.b bVar = this.f63368a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.K(null);
            this.f63369b.M(null);
            this.f63369b.A();
        }
        d.b.i0.z0.k.c.b bVar = this.f63368a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f63371d);
    }

    public void n() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.B();
            this.f63369b.C();
            this.f63369b.O(true);
        }
    }

    public void o() {
        d.b.i0.z0.k.e.a aVar = this.f63369b;
        if (aVar != null) {
            aVar.L(false);
            this.f63369b.W();
            this.f63369b.y();
            this.f63369b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f63369b.D();
        } else {
            this.f63369b.C();
        }
    }
}
