package d.b.i0.q1.f;

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
import d.b.b.e.p.l;
import d.b.i0.q1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f59387e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f59388f;

    /* renamed from: g  reason: collision with root package name */
    public int f59389g;

    /* renamed from: h  reason: collision with root package name */
    public int f59390h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f59391a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f59392b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59393c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59394d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59395e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59396f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59397g;

        public a(c cVar, View view) {
            this.f59391a = (RelativeLayout) view.findViewById(R.id.root);
            this.f59392b = (LinearLayout) view.findViewById(R.id.container);
            this.f59393c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f59394d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f59395e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f59396f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f59397g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f59388f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f59389g = k;
        this.f59390h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i) {
        return (f.d) ListUtils.getItem(this.f59387e, i);
    }

    public f.d b() {
        for (int i = 0; i < this.f59387e.size(); i++) {
            if (this.f59387e.get(i).m) {
                return this.f59387e.get(i);
            }
        }
        return null;
    }

    public final void c(int i, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f59397g.setText(f(dVar.f59419b, 7));
        if (TextUtils.isEmpty(dVar.f59420c)) {
            aVar.f59396f.setVisibility(4);
        } else {
            aVar.f59396f.setVisibility(0);
            aVar.f59396f.setText(f(dVar.f59420c, 10));
        }
        TextView textView = aVar.f59395e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f59425h)) {
            aVar.f59394d.setVisibility(4);
        } else {
            aVar.f59394d.setVisibility(0);
            aVar.f59394d.setText(dVar.f59425h);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f59391a.getLayoutParams();
            layoutParams.width = this.f59390h;
            layoutParams.height = this.i;
            layoutParams.leftMargin = this.j;
            aVar.f59391a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f59391a.getLayoutParams();
            layoutParams2.width = this.f59390h;
            layoutParams2.height = this.i;
            layoutParams2.leftMargin = 0;
            aVar.f59391a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f59393c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f59394d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f59394d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f59395e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f59396f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f59397g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f59387e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f59392b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f59392b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f59387e == null) {
            return;
        }
        for (int i = 0; i < this.f59387e.size(); i++) {
            this.f59387e.get(i).m = false;
            if (this.f59387e.get(i).f59418a.equals(dVar.f59418a)) {
                this.f59387e.get(i).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f59387e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f59388f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i, getItem(i), (a) view.getTag());
        return view;
    }
}
