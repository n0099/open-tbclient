package d.b.i0.g1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public LabelRecommendActivity f54931a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54932b;

    /* renamed from: c  reason: collision with root package name */
    public View f54933c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54934d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f54935e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54936f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f54937g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.g1.a.a f54938h;
    public d.b.i0.g1.d.a i;
    public View.OnClickListener j;
    public List<d.b.i0.g1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.b.i0.g1.b.a) {
                Integer valueOf = Integer.valueOf(((d.b.i0.g1.b.a) view.getTag()).f54921a);
                if (b.this.l.contains(valueOf)) {
                    b.this.l.remove(valueOf);
                } else {
                    b.this.l.add(valueOf);
                }
                b.this.i();
            }
        }
    }

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity == null) {
            return;
        }
        this.f54931a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f54932b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.i.b()));
        return arrayList;
    }

    public View e() {
        return this.f54934d;
    }

    public View f() {
        return this.f54936f;
    }

    public final void g() {
        this.f54931a.setContentView(R.layout.activity_label_recommend);
        this.f54932b = (ViewGroup) this.f54931a.findViewById(R.id.view_root);
        this.f54933c = this.f54931a.findViewById(R.id.statebar_view);
        this.f54934d = (TextView) this.f54931a.findViewById(R.id.skip);
        this.f54935e = (NoNetworkView) this.f54931a.findViewById(R.id.view_no_network);
        this.f54936f = (TextView) this.f54931a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f54933c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f54937g = (BdListView) this.f54931a.findViewById(R.id.listview);
        d.b.i0.g1.a.a aVar = new d.b.i0.g1.a.a(this.f54931a.getPageContext().getPageActivity());
        this.f54938h = aVar;
        aVar.b(this.m);
        d.b.i0.g1.d.a aVar2 = new d.b.i0.g1.d.a(this.f54931a.getPageContext().getPageActivity());
        this.i = aVar2;
        this.f54937g.addHeaderView(aVar2.a());
        this.f54937g.setAdapter((ListAdapter) this.f54938h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f54934d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54936f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f54936f, R.drawable.bule_bg_commen_label_button);
        this.f54935e.c(this.f54931a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.b.i0.g1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f54923c = this.l.contains(Integer.valueOf(aVar.f54921a));
            }
        }
        this.f54938h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.b.i0.g1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.b.i0.g1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f54923c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.i.d(bVar.c());
        this.f54938h.a(this.k);
        this.f54937g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f54934d.setOnClickListener(onClickListener);
    }

    public final void l(int i, int i2) {
        this.f54936f.setEnabled(i > 0);
        this.f54936f.setText(this.f54931a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.f54936f.setOnClickListener(i > 0 ? this.j : null);
    }
}
