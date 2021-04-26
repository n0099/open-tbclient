package d.a.j0.q0.n1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.j0.q0.k<d.a.j0.d3.x, a> implements View.OnClickListener {
    public boolean w;
    public boolean x;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f58133a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58134b;

        /* renamed from: c  reason: collision with root package name */
        public View f58135c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58136d;

        /* renamed from: e  reason: collision with root package name */
        public View f58137e;

        /* renamed from: f  reason: collision with root package name */
        public View f58138f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58139g;

        /* renamed from: h  reason: collision with root package name */
        public View f58140h;

        /* renamed from: i  reason: collision with root package name */
        public View f58141i;
        public View j;
        public List<View> k;

        public a(View view) {
            super(view);
            this.k = new ArrayList();
            this.f58134b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f58133a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f58135c = view.findViewById(R.id.frs_my_service_item);
            this.f58136d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f58137e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f58138f = view.findViewById(R.id.frs_bawu_center);
            this.f58139g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f58140h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f58141i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f58140h);
            this.k.add(this.f58141i);
            this.k.add(this.j);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.w = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.x = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.p != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (y(intValue) instanceof a2) {
                a2 a2Var = (a2) y(intValue);
                this.p.a(id, intValue, view, e0(this.q.getListView(), intValue), a2Var);
            }
        }
    }

    public final void t0(a aVar) {
        List<View> list = aVar.k;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public a P(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f40319e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.d3.x xVar, a aVar) {
        super.W(i2, view, viewGroup, xVar, aVar);
        boolean z = true;
        if (xVar.B4()) {
            String z4 = xVar.z4();
            if (z4 != null) {
                aVar.f58134b.setText(z4);
            } else {
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                    TextView textView = aVar.f58134b;
                    Context context = this.f40319e;
                    int i3 = R.string.get_fortune_hint_format;
                    Object[] objArr = new Object[1];
                    FrsViewData frsViewData2 = this.n;
                    objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                    textView.setText(context.getString(i3, objArr));
                }
            }
            aVar.f58133a.setTag(Integer.valueOf(i2));
            aVar.f58133a.setOnClickListener(this);
            aVar.f58133a.setVisibility(0);
        } else {
            aVar.f58133a.setVisibility(8);
            aVar.f58140h.setVisibility(8);
        }
        d.a.j0.d3.r A4 = xVar.A4();
        if (A4 != null && A4.b() && !TextUtils.isEmpty(A4.a())) {
            aVar.f58136d.setText(A4.a());
            aVar.f58135c.setTag(Integer.valueOf(i2));
            aVar.f58135c.setOnClickListener(this);
            aVar.f58135c.setVisibility(0);
        } else {
            aVar.f58135c.setVisibility(8);
            aVar.f58141i.setVisibility(8);
        }
        if (this.x) {
            aVar.f58137e.setVisibility(0);
        } else {
            aVar.f58137e.setVisibility(8);
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        FrsViewData frsViewData3 = this.n;
        z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
        if (z) {
            aVar.f58138f.setVisibility(0);
            SkinManager.setBackgroundResource(aVar.f58138f, R.drawable.frs_top_item_bg);
            aVar.f58137e.setVisibility(0);
            aVar.f58138f.setOnClickListener(this);
            aVar.f58138f.setTag(Integer.valueOf(i2));
        } else {
            aVar.f58138f.setVisibility(8);
            aVar.j.setVisibility(8);
        }
        if (this.w || xVar.B4()) {
            return view;
        }
        if (z) {
            aVar.f58133a.setVisibility(8);
            aVar.f58135c.setVisibility(8);
            t0(aVar);
            return view;
        }
        return new View(this.f40319e);
    }
}
