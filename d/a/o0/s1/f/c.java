package d.a.o0.s1.f;

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
import d.a.o0.s1.f.f;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f64335e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f64336f;

    /* renamed from: g  reason: collision with root package name */
    public int f64337g;

    /* renamed from: h  reason: collision with root package name */
    public int f64338h;

    /* renamed from: i  reason: collision with root package name */
    public int f64339i;
    public int j;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f64340a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f64341b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64342c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64343d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f64344e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f64345f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64346g;

        public a(c cVar, View view) {
            this.f64340a = (RelativeLayout) view.findViewById(R.id.root);
            this.f64341b = (LinearLayout) view.findViewById(R.id.container);
            this.f64342c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f64343d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f64344e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f64345f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f64346g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f64336f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f64337g = k;
        this.f64338h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f64339i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        return (f.d) ListUtils.getItem(this.f64335e, i2);
    }

    public f.d b() {
        for (int i2 = 0; i2 < this.f64335e.size(); i2++) {
            if (this.f64335e.get(i2).m) {
                return this.f64335e.get(i2);
            }
        }
        return null;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f64346g.setText(f(dVar.f64368b, 7));
        if (TextUtils.isEmpty(dVar.f64369c)) {
            aVar.f64345f.setVisibility(4);
        } else {
            aVar.f64345f.setVisibility(0);
            aVar.f64345f.setText(f(dVar.f64369c, 10));
        }
        TextView textView = aVar.f64344e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f64374h)) {
            aVar.f64343d.setVisibility(4);
        } else {
            aVar.f64343d.setVisibility(0);
            aVar.f64343d.setText(dVar.f64374h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f64340a.getLayoutParams();
            layoutParams.width = this.f64338h;
            layoutParams.height = this.f64339i;
            layoutParams.leftMargin = this.j;
            aVar.f64340a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f64340a.getLayoutParams();
            layoutParams2.width = this.f64338h;
            layoutParams2.height = this.f64339i;
            layoutParams2.leftMargin = 0;
            aVar.f64340a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f64342c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f64343d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f64343d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f64344e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f64345f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f64346g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f64335e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f64341b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f64341b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i2) {
        if (str.length() > i2) {
            return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f64335e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f64335e.size(); i2++) {
            this.f64335e.get(i2).m = false;
            if (this.f64335e.get(i2).f64367a.equals(dVar.f64367a)) {
                this.f64335e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f64335e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f64336f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i2, getItem(i2), (a) view.getTag());
        return view;
    }
}
