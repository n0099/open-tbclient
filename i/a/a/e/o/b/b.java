package i.a.a.e.o.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.l.c;
import i.a.a.e.n.g;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f72180e;

    /* renamed from: f  reason: collision with root package name */
    public int f72181f;

    /* renamed from: g  reason: collision with root package name */
    public List<c> f72182g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f72183h;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f72184a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f72185b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f72186c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f72187d;

        public a(b bVar) {
        }
    }

    public b(Context context, PayUIKitConfig payUIKitConfig, List<c> list) {
        this.f72182g = new ArrayList();
        this.f72180e = context;
        this.f72182g = list;
        this.f72183h = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c getItem(int i2) {
        return this.f72182g.get(i2);
    }

    public int b() {
        return this.f72181f;
    }

    public void c(int i2) {
        this.f72181f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f72182g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f72180e).inflate(e.pay_ui_item_pay_way_choose, viewGroup, false);
            aVar = new a(this);
            aVar.f72184a = (TextView) view.findViewById(d.way_tv_title);
            aVar.f72186c = (ImageView) view.findViewById(d.img_select);
            aVar.f72185b = (ImageView) view.findViewById(d.recharge_way_bg);
            aVar.f72187d = (TextView) view.findViewById(d.tv_tips);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        c item = getItem(i2);
        aVar.f72184a.setText(item.a());
        PayType payType = item.f72159a;
        if (PayType.ALI_PAY.equals(payType)) {
            aVar.f72185b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_zhifubao);
        } else if (PayType.WECHAT_PAY.equals(payType)) {
            aVar.f72185b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_weixin);
        } else if (PayType.DXM_PAY.equals(payType)) {
            aVar.f72185b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_dxm);
        } else if (PayType.DXM_PAY_KJ.equals(payType)) {
            aVar.f72185b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_dxmkj);
        }
        aVar.f72184a.setTextColor(this.f72180e.getResources().getColor(i.a.a.e.a.pay_ui_font_color_6));
        if (this.f72181f == i2) {
            aVar.f72186c.setBackgroundResource(g.f72167a.b(this.f72183h) ? i.a.a.e.c.pay_ui_pay_way_item_select : i.a.a.e.c.pay_ui_pay_way_item_select_y);
        } else {
            aVar.f72186c.setBackgroundResource(i.a.a.e.c.pay_ui_pay_way_item_unselect);
        }
        if (TextUtils.isEmpty(item.f72161c)) {
            aVar.f72187d.setVisibility(8);
        } else {
            aVar.f72187d.setVisibility(0);
            aVar.f72187d.setText(item.f72161c);
        }
        return view;
    }
}
