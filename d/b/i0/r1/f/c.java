package d.b.i0.r1.f;

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
import d.b.i0.r1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f61081e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f61082f;

    /* renamed from: g  reason: collision with root package name */
    public int f61083g;

    /* renamed from: h  reason: collision with root package name */
    public int f61084h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f61085a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f61086b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61087c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61088d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61089e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61090f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61091g;

        public a(c cVar, View view) {
            this.f61085a = (RelativeLayout) view.findViewById(R.id.root);
            this.f61086b = (LinearLayout) view.findViewById(R.id.container);
            this.f61087c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f61088d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f61089e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f61090f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f61091g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f61082f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f61083g = k;
        this.f61084h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i) {
        return (f.d) ListUtils.getItem(this.f61081e, i);
    }

    public f.d b() {
        for (int i = 0; i < this.f61081e.size(); i++) {
            if (this.f61081e.get(i).m) {
                return this.f61081e.get(i);
            }
        }
        return null;
    }

    public final void c(int i, f.d dVar, a aVar) {
        if (dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f61091g.setText(f(dVar.f61113b, 7));
        if (TextUtils.isEmpty(dVar.f61114c)) {
            aVar.f61090f.setVisibility(4);
        } else {
            aVar.f61090f.setVisibility(0);
            aVar.f61090f.setText(f(dVar.f61114c, 10));
        }
        TextView textView = aVar.f61089e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f61119h)) {
            aVar.f61088d.setVisibility(4);
        } else {
            aVar.f61088d.setVisibility(0);
            aVar.f61088d.setText(dVar.f61119h);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f61085a.getLayoutParams();
            layoutParams.width = this.f61084h;
            layoutParams.height = this.i;
            layoutParams.leftMargin = this.j;
            aVar.f61085a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f61085a.getLayoutParams();
            layoutParams2.width = this.f61084h;
            layoutParams2.height = this.i;
            layoutParams2.leftMargin = 0;
            aVar.f61085a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f61087c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f61088d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f61088d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f61089e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f61090f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f61091g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        this.f61081e = list;
    }

    public final void e(f.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f61086b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f61086b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void g(f.d dVar) {
        if (dVar == null || this.f61081e == null) {
            return;
        }
        for (int i = 0; i < this.f61081e.size(); i++) {
            this.f61081e.get(i).m = false;
            if (this.f61081e.get(i).f61112a.equals(dVar.f61112a)) {
                this.f61081e.get(i).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f61081e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f61082f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        c(i, getItem(i), (a) view.getTag());
        return view;
    }
}
