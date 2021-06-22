package d.a.o0.i1.d;

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
    public LabelRecommendActivity f59509a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59510b;

    /* renamed from: c  reason: collision with root package name */
    public View f59511c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59512d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59513e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59514f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f59515g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.i1.a.a f59516h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.i1.d.a f59517i;
    public View.OnClickListener j;
    public List<d.a.o0.i1.b.a> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.o0.i1.b.a) {
                Integer valueOf = Integer.valueOf(((d.a.o0.i1.b.a) view.getTag()).f59498a);
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
        this.f59509a = labelRecommendActivity;
        g();
    }

    public View c() {
        return this.f59510b;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.add(0, Integer.valueOf(this.f59517i.b()));
        return arrayList;
    }

    public View e() {
        return this.f59512d;
    }

    public View f() {
        return this.f59514f;
    }

    public final void g() {
        this.f59509a.setContentView(R.layout.activity_label_recommend);
        this.f59510b = (ViewGroup) this.f59509a.findViewById(R.id.view_root);
        this.f59511c = this.f59509a.findViewById(R.id.statebar_view);
        this.f59512d = (TextView) this.f59509a.findViewById(R.id.skip);
        this.f59513e = (NoNetworkView) this.f59509a.findViewById(R.id.view_no_network);
        this.f59514f = (TextView) this.f59509a.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f59511c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        l(0, 0);
        this.f59515g = (BdListView) this.f59509a.findViewById(R.id.listview);
        d.a.o0.i1.a.a aVar = new d.a.o0.i1.a.a(this.f59509a.getPageContext().getPageActivity());
        this.f59516h = aVar;
        aVar.b(this.m);
        d.a.o0.i1.d.a aVar2 = new d.a.o0.i1.d.a(this.f59509a.getPageContext().getPageActivity());
        this.f59517i = aVar2;
        this.f59515g.addHeaderView(aVar2.a());
        this.f59515g.setAdapter((ListAdapter) this.f59516h);
        h();
    }

    public final void h() {
        SkinManager.setViewTextColor(this.f59512d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f59514f, R.drawable.color_sub_lable_selector);
        SkinManager.setBackgroundResource(this.f59514f, R.drawable.bule_bg_commen_label_button);
        this.f59513e.c(this.f59509a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void i() {
        for (d.a.o0.i1.b.a aVar : this.k) {
            if (aVar != null) {
                aVar.f59500c = this.l.contains(Integer.valueOf(aVar.f59498a));
            }
        }
        this.f59516h.a(this.k);
        l(this.l.size(), this.k.size());
    }

    public void j(d.a.o0.i1.b.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.a.o0.i1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f59500c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f59517i.d(bVar.c());
        this.f59516h.a(this.k);
        this.f59515g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.f59512d.setOnClickListener(onClickListener);
    }

    public final void l(int i2, int i3) {
        this.f59514f.setEnabled(i2 > 0);
        this.f59514f.setText(this.f59509a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        this.f59514f.setOnClickListener(i2 > 0 ? this.j : null);
    }
}
