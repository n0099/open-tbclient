package d.b.i0.p0.n1.d;

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
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends d.b.i0.p0.k<d.b.i0.c3.x, a> implements View.OnClickListener {
    public boolean w;
    public boolean x;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f57969a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57970b;

        /* renamed from: c  reason: collision with root package name */
        public View f57971c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57972d;

        /* renamed from: e  reason: collision with root package name */
        public View f57973e;

        /* renamed from: f  reason: collision with root package name */
        public View f57974f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57975g;

        /* renamed from: h  reason: collision with root package name */
        public View f57976h;
        public View i;
        public View j;
        public List<View> k;

        public a(View view) {
            super(view);
            this.k = new ArrayList();
            this.f57970b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f57969a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f57971c = view.findViewById(R.id.frs_my_service_item);
            this.f57972d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f57973e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f57974f = view.findViewById(R.id.frs_bawu_center);
            this.f57975g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f57976h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f57976h);
            this.k.add(this.i);
            this.k.add(this.j);
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
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
                this.p.a(id, intValue, view, h0(this.q.getListView(), intValue), a2Var);
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
    @Override // d.b.b.j.e.a
    /* renamed from: u0 */
    public a R(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f42357e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: v0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.c3.x xVar, a aVar) {
        super.X(i, view, viewGroup, xVar, aVar);
        boolean z = true;
        if (xVar.A4()) {
            String y4 = xVar.y4();
            if (y4 != null) {
                aVar.f57970b.setText(y4);
            } else {
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                    TextView textView = aVar.f57970b;
                    Context context = this.f42357e;
                    int i2 = R.string.get_fortune_hint_format;
                    Object[] objArr = new Object[1];
                    FrsViewData frsViewData2 = this.n;
                    objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                    textView.setText(context.getString(i2, objArr));
                }
            }
            aVar.f57969a.setTag(Integer.valueOf(i));
            aVar.f57969a.setOnClickListener(this);
            aVar.f57969a.setVisibility(0);
        } else {
            aVar.f57969a.setVisibility(8);
            aVar.f57976h.setVisibility(8);
        }
        d.b.i0.c3.r z4 = xVar.z4();
        if (z4 != null && z4.b() && !TextUtils.isEmpty(z4.a())) {
            aVar.f57972d.setText(z4.a());
            aVar.f57971c.setTag(Integer.valueOf(i));
            aVar.f57971c.setOnClickListener(this);
            aVar.f57971c.setVisibility(0);
        } else {
            aVar.f57971c.setVisibility(8);
            aVar.i.setVisibility(8);
        }
        if (this.x) {
            aVar.f57973e.setVisibility(0);
        } else {
            aVar.f57973e.setVisibility(8);
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        FrsViewData frsViewData3 = this.n;
        z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
        if (z) {
            aVar.f57974f.setVisibility(0);
            SkinManager.setBackgroundResource(aVar.f57974f, R.drawable.frs_top_item_bg);
            aVar.f57973e.setVisibility(0);
            aVar.f57974f.setOnClickListener(this);
            aVar.f57974f.setTag(Integer.valueOf(i));
        } else {
            aVar.f57974f.setVisibility(8);
            aVar.j.setVisibility(8);
        }
        if (this.w || xVar.A4()) {
            return view;
        }
        if (z) {
            aVar.f57969a.setVisibility(8);
            aVar.f57971c.setVisibility(8);
            t0(aVar);
            return view;
        }
        return new View(this.f42357e);
    }
}
