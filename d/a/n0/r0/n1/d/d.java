package d.a.n0.r0.n1.d;

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
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.n0.r0.k<d.a.n0.e3.x, a> implements View.OnClickListener {
    public boolean w;
    public boolean x;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f62707a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62708b;

        /* renamed from: c  reason: collision with root package name */
        public View f62709c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62710d;

        /* renamed from: e  reason: collision with root package name */
        public View f62711e;

        /* renamed from: f  reason: collision with root package name */
        public View f62712f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62713g;

        /* renamed from: h  reason: collision with root package name */
        public View f62714h;

        /* renamed from: i  reason: collision with root package name */
        public View f62715i;
        public View j;
        public List<View> k;

        public a(View view) {
            super(view);
            this.k = new ArrayList();
            this.f62708b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f62707a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f62709c = view.findViewById(R.id.frs_my_service_item);
            this.f62710d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f62711e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f62712f = view.findViewById(R.id.frs_bawu_center);
            this.f62713g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f62714h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f62715i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f62714h);
            this.k.add(this.f62715i);
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
            if (z(intValue) instanceof a2) {
                a2 a2Var = (a2) z(intValue);
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
    @Override // d.a.c.k.e.a
    /* renamed from: t0 */
    public a Q(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f42909e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: v0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.e3.x xVar, a aVar) {
        super.X(i2, view, viewGroup, xVar, aVar);
        boolean z = true;
        if (xVar.F4()) {
            String D4 = xVar.D4();
            if (D4 != null) {
                aVar.f62708b.setText(D4);
            } else {
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                    TextView textView = aVar.f62708b;
                    Context context = this.f42909e;
                    int i3 = R.string.get_fortune_hint_format;
                    Object[] objArr = new Object[1];
                    FrsViewData frsViewData2 = this.n;
                    objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                    textView.setText(context.getString(i3, objArr));
                }
            }
            aVar.f62707a.setTag(Integer.valueOf(i2));
            aVar.f62707a.setOnClickListener(this);
            aVar.f62707a.setVisibility(0);
        } else {
            aVar.f62707a.setVisibility(8);
            aVar.f62714h.setVisibility(8);
        }
        d.a.n0.e3.r E4 = xVar.E4();
        if (E4 != null && E4.b() && !TextUtils.isEmpty(E4.a())) {
            aVar.f62710d.setText(E4.a());
            aVar.f62709c.setTag(Integer.valueOf(i2));
            aVar.f62709c.setOnClickListener(this);
            aVar.f62709c.setVisibility(0);
        } else {
            aVar.f62709c.setVisibility(8);
            aVar.f62715i.setVisibility(8);
        }
        if (this.x) {
            aVar.f62711e.setVisibility(0);
        } else {
            aVar.f62711e.setVisibility(8);
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        FrsViewData frsViewData3 = this.n;
        z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
        if (z) {
            aVar.f62712f.setVisibility(0);
            SkinManager.setBackgroundResource(aVar.f62712f, R.drawable.frs_top_item_bg);
            aVar.f62711e.setVisibility(0);
            aVar.f62712f.setOnClickListener(this);
            aVar.f62712f.setTag(Integer.valueOf(i2));
        } else {
            aVar.f62712f.setVisibility(8);
            aVar.j.setVisibility(8);
        }
        if (this.w || xVar.F4()) {
            return view;
        }
        if (z) {
            aVar.f62707a.setVisibility(8);
            aVar.f62709c.setVisibility(8);
            s0(aVar);
            return view;
        }
        return new View(this.f42909e);
    }
}
