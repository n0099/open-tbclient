package i.a.a.e.m.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import i.a.a.e.c;
import i.a.a.e.j.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f68851e;

    /* renamed from: f  reason: collision with root package name */
    public int f68852f;

    /* renamed from: g  reason: collision with root package name */
    public List<d> f68853g;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f68854a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f68855b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f68856c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68857d;

        public a(b bVar) {
        }
    }

    public b(Context context, List<d> list) {
        this.f68853g = new ArrayList();
        this.f68851e = context;
        this.f68853g = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        return this.f68853g.get(i2);
    }

    public int b() {
        return this.f68852f;
    }

    public void c(int i2) {
        this.f68852f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f68853g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f68851e).inflate(i.a.a.e.d.yy_item_pay_way_choose, (ViewGroup) null);
            aVar = new a(this);
            aVar.f68854a = (TextView) view.findViewById(c.way_tv_title);
            aVar.f68856c = (ImageView) view.findViewById(c.img_select);
            aVar.f68855b = (ImageView) view.findViewById(c.recharge_way_bg);
            aVar.f68857d = (TextView) view.findViewById(c.tv_tips);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        d item = getItem(i2);
        aVar.f68854a.setText(item.a());
        PayType payType = item.f68834a;
        if (payType.equals(PayType.ALI_PAY)) {
            aVar.f68855b.setBackgroundResource(i.a.a.e.b.yy_recharge_zhifubao);
        } else if (payType.equals(PayType.WECHAT_PAY)) {
            aVar.f68855b.setBackgroundResource(i.a.a.e.b.yy_recharge_weixin);
        } else if (payType.equals(PayType.DXM_PAY)) {
            aVar.f68855b.setBackgroundResource(i.a.a.e.b.yy_recharge_dxm);
        }
        aVar.f68854a.setTextColor(this.f68851e.getResources().getColor(i.a.a.e.a.font_color_6));
        if (this.f68852f == i2) {
            aVar.f68856c.setBackgroundResource(i.a.a.e.b.yy_pay_way_item_select);
        } else {
            aVar.f68856c.setBackgroundResource(i.a.a.e.b.yy_pay_way_item_unselect);
        }
        if (TextUtils.isEmpty(item.f68836c)) {
            aVar.f68857d.setVisibility(8);
        } else {
            aVar.f68857d.setVisibility(0);
            aVar.f68857d.setText(item.f68836c);
        }
        return view;
    }
}
