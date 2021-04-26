package d.a.j0.h1.d;

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
    public LabelRecommendActivity f54800a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54801b;

    /* renamed from: c  reason: collision with root package name */
    public View f54802c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54803d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f54804e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54805f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f54806g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.h1.a.a f54807h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.h1.d.a f54808i;
    public View.OnClickListener j;
    public List<d.a.j0.h1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.j0.h1.b.a) {
                Integer valueOf = Integer.valueOf(((d.a.j0.h1.b.a) view.getTag()).f54789a);
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
        this.f54800a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f54801b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.f54808i.b()));
        return arrayList;
    }

    public View e() {
        return this.f54803d;
    }

    public View f() {
        return this.f54805f;
    }

    public final void g() {
        this.f54800a.setContentView(R.layout.activity_label_recommend);
        this.f54801b = (ViewGroup) this.f54800a.findViewById(R.id.view_root);
        this.f54802c = this.f54800a.findViewById(R.id.statebar_view);
        this.f54803d = (TextView) this.f54800a.findViewById(R.id.skip);
        this.f54804e = (NoNetworkView) this.f54800a.findViewById(R.id.view_no_network);
        this.f54805f = (TextView) this.f54800a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f54802c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f54806g = (BdListView) this.f54800a.findViewById(R.id.listview);
        d.a.j0.h1.a.a aVar = new d.a.j0.h1.a.a(this.f54800a.getPageContext().getPageActivity());
        this.f54807h = aVar;
        aVar.b(this.m);
        d.a.j0.h1.d.a aVar2 = new d.a.j0.h1.d.a(this.f54800a.getPageContext().getPageActivity());
        this.f54808i = aVar2;
        this.f54806g.addHeaderView(aVar2.a());
        this.f54806g.setAdapter((ListAdapter) this.f54807h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f54803d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54805f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f54805f, R.drawable.bule_bg_commen_label_button);
        this.f54804e.c(this.f54800a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.a.j0.h1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f54791c = this.l.contains(Integer.valueOf(aVar.f54789a));
            }
        }
        this.f54807h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.a.j0.h1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.a.j0.h1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f54791c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f54808i.d(bVar.c());
        this.f54807h.a(this.k);
        this.f54806g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f54803d.setOnClickListener(onClickListener);
    }

    public final void l(int i2, int i3) {
        this.f54805f.setEnabled(i2 > 0);
        this.f54805f.setText(this.f54800a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        this.f54805f.setOnClickListener(i2 > 0 ? this.j : null);
    }
}
