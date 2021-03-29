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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public LabelRecommendActivity f54932a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54933b;

    /* renamed from: c  reason: collision with root package name */
    public View f54934c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54935d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f54936e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54937f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f54938g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.g1.a.a f54939h;
    public d.b.i0.g1.d.a i;
    public View.OnClickListener j;
    public List<d.b.i0.g1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.b.i0.g1.b.a) {
                Integer valueOf = Integer.valueOf(((d.b.i0.g1.b.a) view.getTag()).f54922a);
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
        this.f54932a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f54933b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.i.b()));
        return arrayList;
    }

    public View e() {
        return this.f54935d;
    }

    public View f() {
        return this.f54937f;
    }

    public final void g() {
        this.f54932a.setContentView(R.layout.activity_label_recommend);
        this.f54933b = (ViewGroup) this.f54932a.findViewById(R.id.view_root);
        this.f54934c = this.f54932a.findViewById(R.id.statebar_view);
        this.f54935d = (TextView) this.f54932a.findViewById(R.id.skip);
        this.f54936e = (NoNetworkView) this.f54932a.findViewById(R.id.view_no_network);
        this.f54937f = (TextView) this.f54932a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f54934c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f54938g = (BdListView) this.f54932a.findViewById(R.id.listview);
        d.b.i0.g1.a.a aVar = new d.b.i0.g1.a.a(this.f54932a.getPageContext().getPageActivity());
        this.f54939h = aVar;
        aVar.b(this.m);
        d.b.i0.g1.d.a aVar2 = new d.b.i0.g1.d.a(this.f54932a.getPageContext().getPageActivity());
        this.i = aVar2;
        this.f54938g.addHeaderView(aVar2.a());
        this.f54938g.setAdapter((ListAdapter) this.f54939h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f54935d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54937f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f54937f, R.drawable.bule_bg_commen_label_button);
        this.f54936e.c(this.f54932a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.b.i0.g1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f54924c = this.l.contains(Integer.valueOf(aVar.f54922a));
            }
        }
        this.f54939h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.b.i0.g1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.b.i0.g1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f54924c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.i.d(bVar.c());
        this.f54939h.a(this.k);
        this.f54938g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f54935d.setOnClickListener(onClickListener);
    }

    public final void l(int i, int i2) {
        this.f54937f.setEnabled(i > 0);
        this.f54937f.setText(this.f54932a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.f54937f.setOnClickListener(i > 0 ? this.j : null);
    }
}
