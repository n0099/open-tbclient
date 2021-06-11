package i.a.a.e.o.b;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.n.f;
import i.a.a.e.n.g;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f72169e;

    /* renamed from: f  reason: collision with root package name */
    public int f72170f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.a> f72171g;

    /* renamed from: h  reason: collision with root package name */
    public String f72172h = "Y币";

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f72173i;

    /* renamed from: i.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1995a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f72174a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f72175b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f72176c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f72177d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f72178e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f72179f;

        public C1995a(a aVar) {
        }
    }

    public a(Context context, List<i.a.a.e.l.a> list, PayUIKitConfig payUIKitConfig) {
        this.f72169e = context;
        this.f72171g = list;
        this.f72173i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.a getItem(int i2) {
        List<i.a.a.e.l.a> list = this.f72171g;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f72171g.size()) {
            return null;
        }
        return this.f72171g.get(i2);
    }

    public i.a.a.e.l.a b() {
        int i2;
        if (this.f72170f >= getCount() || (i2 = this.f72170f) < 0) {
            return null;
        }
        return getItem(i2);
    }

    public void c(String str) {
        this.f72172h = str;
    }

    public void d(int i2) {
        this.f72170f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f72171g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1995a c1995a;
        if (view == null) {
            view = LayoutInflater.from(new ContextThemeWrapper(this.f72169e, g.f72167a.a(this.f72173i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
            c1995a = new C1995a(this);
            c1995a.f72174a = (TextView) view.findViewById(d.tv_dest_amount);
            c1995a.f72175b = (TextView) view.findViewById(d.tv_amount_unit);
            c1995a.f72176c = (LinearLayout) view.findViewById(d.amount_new_rl);
            c1995a.f72177d = (TextView) view.findViewById(d.amount_new);
            c1995a.f72178e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
            c1995a.f72179f = (TextView) view.findViewById(d.tv_other_amount);
            view.setTag(c1995a);
        } else {
            c1995a = (C1995a) view.getTag();
        }
        i.a.a.e.l.a item = getItem(i2);
        if (item.f72154c) {
            c1995a.f72179f.setVisibility(0);
            c1995a.f72178e.setVisibility(8);
            c1995a.f72177d.setVisibility(8);
        } else {
            c1995a.f72179f.setVisibility(8);
            c1995a.f72178e.setVisibility(0);
            c1995a.f72177d.setVisibility(0);
            c1995a.f72174a.setText(String.valueOf(item.a()));
            c1995a.f72175b.setText(this.f72172h);
            c1995a.f72177d.setVisibility(0);
            Double b2 = item.b();
            if (b2 == null) {
                c1995a.f72177d.setText("");
            } else {
                c1995a.f72177d.setText(String.format("¥%s", f.a(b2.doubleValue())));
            }
            if (this.f72170f == i2) {
                c1995a.f72176c.setSelected(true);
                c1995a.f72174a.setSelected(true);
                c1995a.f72175b.setSelected(true);
            } else {
                c1995a.f72176c.setSelected(false);
                c1995a.f72174a.setSelected(false);
                c1995a.f72175b.setSelected(false);
            }
        }
        return view;
    }
}
