package d.a.n0.s1.f;

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
import d.a.n0.s1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f60519e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f60520f;

    /* renamed from: g  reason: collision with root package name */
    public int f60521g;

    /* renamed from: h  reason: collision with root package name */
    public int f60522h;

    /* renamed from: i  reason: collision with root package name */
    public int f60523i;
    public int j;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f60524a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f60525b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60526c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60527d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60528e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60529f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60530g;

        public a(c cVar, View view) {
            this.f60524a = (RelativeLayout) view.findViewById(R.id.root);
            this.f60525b = (LinearLayout) view.findViewById(R.id.container);
            this.f60526c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f60527d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f60528e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f60529f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f60530g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f60520f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f60521g = k;
        this.f60522h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f60523i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        return (f.d) ListUtils.getItem(this.f60519e, i2);
    }

    public f.d b() {
        for (int i2 = 0; i2 < this.f60519e.size(); i2++) {
            if (this.f60519e.get(i2).m) {
                return this.f60519e.get(i2);
            }
        }
        return null;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f60530g.setText(f(dVar.f60552b, 7));
        if (TextUtils.isEmpty(dVar.f60553c)) {
            aVar.f60529f.setVisibility(4);
        } else {
            aVar.f60529f.setVisibility(0);
            aVar.f60529f.setText(f(dVar.f60553c, 10));
        }
        TextView textView = aVar.f60528e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f60558h)) {
            aVar.f60527d.setVisibility(4);
        } else {
            aVar.f60527d.setVisibility(0);
            aVar.f60527d.setText(dVar.f60558h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f60524a.getLayoutParams();
            layoutParams.width = this.f60522h;
            layoutParams.height = this.f60523i;
            layoutParams.leftMargin = this.j;
            aVar.f60524a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f60524a.getLayoutParams();
            layoutParams2.width = this.f60522h;
            layoutParams2.height = this.f60523i;
            layoutParams2.leftMargin = 0;
            aVar.f60524a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f60526c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f60527d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f60527d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f60528e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f60529f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f60530g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f60519e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f60525b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f60525b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i2) {
        if (str.length() > i2) {
            return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f60519e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f60519e.size(); i2++) {
            this.f60519e.get(i2).m = false;
            if (this.f60519e.get(i2).f60551a.equals(dVar.f60551a)) {
                this.f60519e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f60519e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f60520f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i2, getItem(i2), (a) view.getTag());
        return view;
    }
}
