package d.a.j0.r1.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f59651e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f59652f;

    /* renamed from: g  reason: collision with root package name */
    public int f59653g;

    /* renamed from: h  reason: collision with root package name */
    public int f59654h;

    /* renamed from: i  reason: collision with root package name */
    public int f59655i;
    public int j;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f59656a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f59657b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59658c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59659d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59660e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59661f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59662g;

        public a(c cVar, View view) {
            this.f59656a = (RelativeLayout) view.findViewById(R.id.root);
            this.f59657b = (LinearLayout) view.findViewById(R.id.container);
            this.f59658c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f59659d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f59660e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f59661f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f59662g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f59652f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f59653g = k;
        this.f59654h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f59655i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        return (f.d) ListUtils.getItem(this.f59651e, i2);
    }

    public f.d b() {
        for (int i2 = 0; i2 < this.f59651e.size(); i2++) {
            if (this.f59651e.get(i2).m) {
                return this.f59651e.get(i2);
            }
        }
        return null;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f59662g.setText(f(dVar.f59684b, 7));
        if (TextUtils.isEmpty(dVar.f59685c)) {
            aVar.f59661f.setVisibility(4);
        } else {
            aVar.f59661f.setVisibility(0);
            aVar.f59661f.setText(f(dVar.f59685c, 10));
        }
        TextView textView = aVar.f59660e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f59690h)) {
            aVar.f59659d.setVisibility(4);
        } else {
            aVar.f59659d.setVisibility(0);
            aVar.f59659d.setText(dVar.f59690h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f59656a.getLayoutParams();
            layoutParams.width = this.f59654h;
            layoutParams.height = this.f59655i;
            layoutParams.leftMargin = this.j;
            aVar.f59656a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f59656a.getLayoutParams();
            layoutParams2.width = this.f59654h;
            layoutParams2.height = this.f59655i;
            layoutParams2.leftMargin = 0;
            aVar.f59656a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f59658c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f59659d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f59659d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f59660e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f59661f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f59662g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f59651e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f59657b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f59657b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i2) {
        if (str.length() > i2) {
            return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f59651e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f59651e.size(); i2++) {
            this.f59651e.get(i2).m = false;
            if (this.f59651e.get(i2).f59683a.equals(dVar.f59683a)) {
                this.f59651e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f59651e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f59652f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i2, getItem(i2), (a) view.getTag());
        return view;
    }
}
