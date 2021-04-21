package d.b.j0.r1.f;

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
import d.b.c.e.p.l;
import d.b.j0.r1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f61502e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f61503f;

    /* renamed from: g  reason: collision with root package name */
    public int f61504g;

    /* renamed from: h  reason: collision with root package name */
    public int f61505h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f61506a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f61507b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61508c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61509d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61510e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61511f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61512g;

        public a(c cVar, View view) {
            this.f61506a = (RelativeLayout) view.findViewById(R.id.root);
            this.f61507b = (LinearLayout) view.findViewById(R.id.container);
            this.f61508c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f61509d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f61510e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f61511f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f61512g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f61503f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f61504g = k;
        this.f61505h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i) {
        return (f.d) ListUtils.getItem(this.f61502e, i);
    }

    public f.d b() {
        for (int i = 0; i < this.f61502e.size(); i++) {
            if (this.f61502e.get(i).m) {
                return this.f61502e.get(i);
            }
        }
        return null;
    }

    public final void c(int i, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f61512g.setText(f(dVar.f61534b, 7));
        if (TextUtils.isEmpty(dVar.f61535c)) {
            aVar.f61511f.setVisibility(4);
        } else {
            aVar.f61511f.setVisibility(0);
            aVar.f61511f.setText(f(dVar.f61535c, 10));
        }
        TextView textView = aVar.f61510e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f61540h)) {
            aVar.f61509d.setVisibility(4);
        } else {
            aVar.f61509d.setVisibility(0);
            aVar.f61509d.setText(dVar.f61540h);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f61506a.getLayoutParams();
            layoutParams.width = this.f61505h;
            layoutParams.height = this.i;
            layoutParams.leftMargin = this.j;
            aVar.f61506a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f61506a.getLayoutParams();
            layoutParams2.width = this.f61505h;
            layoutParams2.height = this.i;
            layoutParams2.leftMargin = 0;
            aVar.f61506a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f61508c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f61509d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f61509d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f61510e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f61511f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f61512g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f61502e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f61507b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f61507b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f61502e == null) {
            return;
        }
        for (int i = 0; i < this.f61502e.size(); i++) {
            this.f61502e.get(i).m = false;
            if (this.f61502e.get(i).f61533a.equals(dVar.f61533a)) {
                this.f61502e.get(i).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f61502e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f61503f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i, getItem(i), (a) view.getTag());
        return view;
    }
}
