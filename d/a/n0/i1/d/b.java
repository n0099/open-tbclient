package d.a.n0.i1.d;

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
    public LabelRecommendActivity f55695a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55696b;

    /* renamed from: c  reason: collision with root package name */
    public View f55697c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55698d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f55699e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55700f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f55701g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.i1.a.a f55702h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.i1.d.a f55703i;
    public View.OnClickListener j;
    public List<d.a.n0.i1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.n0.i1.b.a) {
                Integer valueOf = Integer.valueOf(((d.a.n0.i1.b.a) view.getTag()).f55684a);
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
        this.f55695a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f55696b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.f55703i.b()));
        return arrayList;
    }

    public View e() {
        return this.f55698d;
    }

    public View f() {
        return this.f55700f;
    }

    public final void g() {
        this.f55695a.setContentView(R.layout.activity_label_recommend);
        this.f55696b = (ViewGroup) this.f55695a.findViewById(R.id.view_root);
        this.f55697c = this.f55695a.findViewById(R.id.statebar_view);
        this.f55698d = (TextView) this.f55695a.findViewById(R.id.skip);
        this.f55699e = (NoNetworkView) this.f55695a.findViewById(R.id.view_no_network);
        this.f55700f = (TextView) this.f55695a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f55697c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f55701g = (BdListView) this.f55695a.findViewById(R.id.listview);
        d.a.n0.i1.a.a aVar = new d.a.n0.i1.a.a(this.f55695a.getPageContext().getPageActivity());
        this.f55702h = aVar;
        aVar.b(this.m);
        d.a.n0.i1.d.a aVar2 = new d.a.n0.i1.d.a(this.f55695a.getPageContext().getPageActivity());
        this.f55703i = aVar2;
        this.f55701g.addHeaderView(aVar2.a());
        this.f55701g.setAdapter((ListAdapter) this.f55702h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f55698d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55700f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f55700f, R.drawable.bule_bg_commen_label_button);
        this.f55699e.c(this.f55695a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.a.n0.i1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f55686c = this.l.contains(Integer.valueOf(aVar.f55684a));
            }
        }
        this.f55702h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.a.n0.i1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.a.n0.i1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f55686c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f55703i.d(bVar.c());
        this.f55702h.a(this.k);
        this.f55701g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f55698d.setOnClickListener(onClickListener);
    }

    public final void l(int i2, int i3) {
        this.f55700f.setEnabled(i2 > 0);
        this.f55700f.setText(this.f55695a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        this.f55700f.setOnClickListener(i2 > 0 ? this.j : null);
    }
}
