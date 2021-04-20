package d.b.i0.h1.d;

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
    public LabelRecommendActivity f56468a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56469b;

    /* renamed from: c  reason: collision with root package name */
    public View f56470c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56471d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56472e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56473f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f56474g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.h1.a.a f56475h;
    public d.b.i0.h1.d.a i;
    public View.OnClickListener j;
    public List<d.b.i0.h1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.b.i0.h1.b.a) {
                Integer valueOf = Integer.valueOf(((d.b.i0.h1.b.a) view.getTag()).f56458a);
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
        this.f56468a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f56469b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.i.b()));
        return arrayList;
    }

    public View e() {
        return this.f56471d;
    }

    public View f() {
        return this.f56473f;
    }

    public final void g() {
        this.f56468a.setContentView(R.layout.activity_label_recommend);
        this.f56469b = (ViewGroup) this.f56468a.findViewById(R.id.view_root);
        this.f56470c = this.f56468a.findViewById(R.id.statebar_view);
        this.f56471d = (TextView) this.f56468a.findViewById(R.id.skip);
        this.f56472e = (NoNetworkView) this.f56468a.findViewById(R.id.view_no_network);
        this.f56473f = (TextView) this.f56468a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f56470c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f56474g = (BdListView) this.f56468a.findViewById(R.id.listview);
        d.b.i0.h1.a.a aVar = new d.b.i0.h1.a.a(this.f56468a.getPageContext().getPageActivity());
        this.f56475h = aVar;
        aVar.b(this.m);
        d.b.i0.h1.d.a aVar2 = new d.b.i0.h1.d.a(this.f56468a.getPageContext().getPageActivity());
        this.i = aVar2;
        this.f56474g.addHeaderView(aVar2.a());
        this.f56474g.setAdapter((ListAdapter) this.f56475h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f56471d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f56473f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f56473f, R.drawable.bule_bg_commen_label_button);
        this.f56472e.c(this.f56468a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.b.i0.h1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f56460c = this.l.contains(Integer.valueOf(aVar.f56458a));
            }
        }
        this.f56475h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.b.i0.h1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.b.i0.h1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f56460c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.i.d(bVar.c());
        this.f56475h.a(this.k);
        this.f56474g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f56471d.setOnClickListener(onClickListener);
    }

    public final void l(int i, int i2) {
        this.f56473f.setEnabled(i > 0);
        this.f56473f.setText(this.f56468a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.f56473f.setOnClickListener(i > 0 ? this.j : null);
    }
}
