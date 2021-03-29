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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.z0.k.c.b f63369a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.z0.k.e.a f63370b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f63371c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f63372d = new C1711a(2016488);

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f63373e = new b();

    /* renamed from: f  reason: collision with root package name */
    public f.g f63374f = new c();

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f63375g = new d();

    /* renamed from: h  reason: collision with root package name */
    public b.f f63376h = new e();
    public View.OnClickListener i = new f();

    /* renamed from: d.b.i0.z0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1711a extends CustomMessageListener {
        public C1711a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.f63370b != null) {
                a.this.f63370b.E();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (a.this.f63370b != null) {
                a.this.f63370b.G();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                a.this.f63370b.L(false);
                a.this.f63369a.j();
                TiebaStatic.log(new StatisticItem("c13582"));
                return;
            }
            a.this.f63370b.X(null);
            a.this.f63371c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            a.this.f63370b.Q();
            a.this.f63369a.l();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.f {

        /* renamed from: d.b.i0.z0.k.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1712a implements View.OnClickListener {
            public View$OnClickListenerC1712a() {
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
            a.this.f63370b.t();
            a.this.f63370b.u();
            if (z || z2) {
                a.this.f63370b.X(null);
            } else {
                a.this.f63370b.X(a.this.i(i));
            }
            if (i != 0) {
                a.this.f63370b.J(a.this.f63369a.h());
                a.this.f63370b.P(a.this.i);
            } else if (ListUtils.isEmpty(a.this.f63370b.q())) {
                a.this.f63370b.T();
            } else if (z) {
                a.this.f63370b.U();
            }
        }

        @Override // d.b.i0.z0.k.c.b.f
        public void b(int i, String str, boolean z) {
            a.this.f63370b.X(null);
            a.this.f63370b.t();
            a.this.f63370b.u();
            if (ListUtils.isEmpty(a.this.f63370b.q())) {
                a.this.f63370b.S(new View$OnClickListenerC1712a());
                return;
            }
            if (z) {
                a.this.f63370b.P(a.this.i);
            }
            if (StringUtils.isNull(str)) {
                a.this.f63371c.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.f63371c.showToast(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63370b == null || a.this.f63369a == null) {
                return;
            }
            a.this.f63370b.Q();
            a.this.f63369a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f63371c = tbPageContext;
        this.f63370b = new d.b.i0.z0.k.e.a(tbPageContext, bdUniqueId, this.f63373e);
        this.f63369a = new d.b.i0.z0.k.c.b(this.f63371c, this.f63376h);
    }

    public void g() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.z0.k.c.b bVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f63369a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f63369a.r(optString);
        this.f63369a.q(optString);
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i) {
        String string;
        if (i <= 0) {
            string = this.f63371c.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.f63371c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.i(string, 1000);
    }

    public View j() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public void k() {
        this.f63369a.p();
        this.f63370b.v();
        this.f63370b.K(this.f63374f);
        this.f63370b.M(this.f63375g);
        MessageManager.getInstance().registerListener(this.f63372d);
    }

    public void l() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.n();
            this.f63370b.R();
        }
        d.b.i0.z0.k.c.b bVar = this.f63369a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void m() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.K(null);
            this.f63370b.M(null);
            this.f63370b.A();
        }
        d.b.i0.z0.k.c.b bVar = this.f63369a;
        if (bVar != null) {
            bVar.o();
        }
        MessageManager.getInstance().unRegisterListener(this.f63372d);
    }

    public void n() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.B();
            this.f63370b.C();
            this.f63370b.O(true);
        }
    }

    public void o() {
        d.b.i0.z0.k.e.a aVar = this.f63370b;
        if (aVar != null) {
            aVar.L(false);
            this.f63370b.W();
            this.f63370b.y();
            this.f63370b.V();
        }
    }

    public void p(boolean z) {
        if (z) {
            this.f63370b.D();
        } else {
            this.f63370b.C();
        }
    }
}
