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
    public LabelRecommendActivity f59384a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59385b;

    /* renamed from: c  reason: collision with root package name */
    public View f59386c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59387d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59388e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59389f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f59390g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.i1.a.a f59391h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.i1.d.a f59392i;
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
                Integer valueOf = Integer.valueOf(((d.a.n0.i1.b.a) view.getTag()).f59373a);
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
        this.f59384a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f59385b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.f59392i.b()));
        return arrayList;
    }

    public View e() {
        return this.f59387d;
    }

    public View f() {
        return this.f59389f;
    }

    public final void g() {
        this.f59384a.setContentView(R.layout.activity_label_recommend);
        this.f59385b = (ViewGroup) this.f59384a.findViewById(R.id.view_root);
        this.f59386c = this.f59384a.findViewById(R.id.statebar_view);
        this.f59387d = (TextView) this.f59384a.findViewById(R.id.skip);
        this.f59388e = (NoNetworkView) this.f59384a.findViewById(R.id.view_no_network);
        this.f59389f = (TextView) this.f59384a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f59386c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f59390g = (BdListView) this.f59384a.findViewById(R.id.listview);
        d.a.n0.i1.a.a aVar = new d.a.n0.i1.a.a(this.f59384a.getPageContext().getPageActivity());
        this.f59391h = aVar;
        aVar.b(this.m);
        d.a.n0.i1.d.a aVar2 = new d.a.n0.i1.d.a(this.f59384a.getPageContext().getPageActivity());
        this.f59392i = aVar2;
        this.f59390g.addHeaderView(aVar2.a());
        this.f59390g.setAdapter((ListAdapter) this.f59391h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f59387d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f59389f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f59389f, R.drawable.bule_bg_commen_label_button);
        this.f59388e.c(this.f59384a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.a.n0.i1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f59375c = this.l.contains(Integer.valueOf(aVar.f59373a));
            }
        }
        this.f59391h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.a.n0.i1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.a.n0.i1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f59375c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f59392i.d(bVar.c());
        this.f59391h.a(this.k);
        this.f59390g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f59387d.setOnClickListener(onClickListener);
    }

    public final void l(int i2, int i3) {
        this.f59389f.setEnabled(i2 > 0);
        this.f59389f.setText(this.f59384a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        this.f59389f.setOnClickListener(i2 > 0 ? this.j : null);
    }
}
