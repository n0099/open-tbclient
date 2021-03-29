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
        public View f57970a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57971b;

        /* renamed from: c  reason: collision with root package name */
        public View f57972c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57973d;

        /* renamed from: e  reason: collision with root package name */
        public View f57974e;

        /* renamed from: f  reason: collision with root package name */
        public View f57975f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57976g;

        /* renamed from: h  reason: collision with root package name */
        public View f57977h;
        public View i;
        public View j;
        public List<View> k;

        public a(View view) {
            super(view);
            this.k = new ArrayList();
            this.f57971b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f57970a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f57972c = view.findViewById(R.id.frs_my_service_item);
            this.f57973d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f57974e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f57975f = view.findViewById(R.id.frs_bawu_center);
            this.f57976g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f57977h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f57977h);
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
        return new a(LayoutInflater.from(this.f42358e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
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
                aVar.f57971b.setText(y4);
            } else {
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                    TextView textView = aVar.f57971b;
                    Context context = this.f42358e;
                    int i2 = R.string.get_fortune_hint_format;
                    Object[] objArr = new Object[1];
                    FrsViewData frsViewData2 = this.n;
                    objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                    textView.setText(context.getString(i2, objArr));
                }
            }
            aVar.f57970a.setTag(Integer.valueOf(i));
            aVar.f57970a.setOnClickListener(this);
            aVar.f57970a.setVisibility(0);
        } else {
            aVar.f57970a.setVisibility(8);
            aVar.f57977h.setVisibility(8);
        }
        d.b.i0.c3.r z4 = xVar.z4();
        if (z4 != null && z4.b() && !TextUtils.isEmpty(z4.a())) {
            aVar.f57973d.setText(z4.a());
            aVar.f57972c.setTag(Integer.valueOf(i));
            aVar.f57972c.setOnClickListener(this);
            aVar.f57972c.setVisibility(0);
        } else {
            aVar.f57972c.setVisibility(8);
            aVar.i.setVisibility(8);
        }
        if (this.x) {
            aVar.f57974e.setVisibility(0);
        } else {
            aVar.f57974e.setVisibility(8);
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        FrsViewData frsViewData3 = this.n;
        z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
        if (z) {
            aVar.f57975f.setVisibility(0);
            SkinManager.setBackgroundResource(aVar.f57975f, R.drawable.frs_top_item_bg);
            aVar.f57974e.setVisibility(0);
            aVar.f57975f.setOnClickListener(this);
            aVar.f57975f.setTag(Integer.valueOf(i));
        } else {
            aVar.f57975f.setVisibility(8);
            aVar.j.setVisibility(8);
        }
        if (this.w || xVar.A4()) {
            return view;
        }
        if (z) {
            aVar.f57970a.setVisibility(8);
            aVar.f57972c.setVisibility(8);
            t0(aVar);
            return view;
        }
        return new View(this.f42358e);
    }
}
