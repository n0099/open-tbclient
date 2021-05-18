package d.a.k0.q0.n1.d;

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
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.k0.q0.k<d.a.k0.d3.x, a> implements View.OnClickListener {
    public boolean w;
    public boolean x;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f58875a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58876b;

        /* renamed from: c  reason: collision with root package name */
        public View f58877c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58878d;

        /* renamed from: e  reason: collision with root package name */
        public View f58879e;

        /* renamed from: f  reason: collision with root package name */
        public View f58880f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58881g;

        /* renamed from: h  reason: collision with root package name */
        public View f58882h;

        /* renamed from: i  reason: collision with root package name */
        public View f58883i;
        public View j;
        public List<View> k;

        public a(View view) {
            super(view);
            this.k = new ArrayList();
            this.f58876b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f58875a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f58877c = view.findViewById(R.id.frs_my_service_item);
            this.f58878d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f58879e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f58880f = view.findViewById(R.id.frs_bawu_center);
            this.f58881g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f58882h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f58883i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f58882h);
            this.k.add(this.f58883i);
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

    public final void s0(a aVar) {
        List<View> list = aVar.k;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public a P(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f39564e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.d3.x xVar, a aVar) {
        super.W(i2, view, viewGroup, xVar, aVar);
        boolean z = true;
        if (xVar.D4()) {
            String B4 = xVar.B4();
            if (B4 != null) {
                aVar.f58876b.setText(B4);
            } else {
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                    TextView textView = aVar.f58876b;
                    Context context = this.f39564e;
                    int i3 = R.string.get_fortune_hint_format;
                    Object[] objArr = new Object[1];
                    FrsViewData frsViewData2 = this.n;
                    objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                    textView.setText(context.getString(i3, objArr));
                }
            }
            aVar.f58875a.setTag(Integer.valueOf(i2));
            aVar.f58875a.setOnClickListener(this);
            aVar.f58875a.setVisibility(0);
        } else {
            aVar.f58875a.setVisibility(8);
            aVar.f58882h.setVisibility(8);
        }
        d.a.k0.d3.r C4 = xVar.C4();
        if (C4 != null && C4.b() && !TextUtils.isEmpty(C4.a())) {
            aVar.f58878d.setText(C4.a());
            aVar.f58877c.setTag(Integer.valueOf(i2));
            aVar.f58877c.setOnClickListener(this);
            aVar.f58877c.setVisibility(0);
        } else {
            aVar.f58877c.setVisibility(8);
            aVar.f58883i.setVisibility(8);
        }
        if (this.x) {
            aVar.f58879e.setVisibility(0);
        } else {
            aVar.f58879e.setVisibility(8);
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        FrsViewData frsViewData3 = this.n;
        z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
        if (z) {
            aVar.f58880f.setVisibility(0);
            SkinManager.setBackgroundResource(aVar.f58880f, R.drawable.frs_top_item_bg);
            aVar.f58879e.setVisibility(0);
            aVar.f58880f.setOnClickListener(this);
            aVar.f58880f.setTag(Integer.valueOf(i2));
        } else {
            aVar.f58880f.setVisibility(8);
            aVar.j.setVisibility(8);
        }
        if (this.w || xVar.D4()) {
            return view;
        }
        if (z) {
            aVar.f58875a.setVisibility(8);
            aVar.f58877c.setVisibility(8);
            s0(aVar);
            return view;
        }
        return new View(this.f39564e);
    }
}
