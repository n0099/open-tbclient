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
    public final Context f72273e;

    /* renamed from: f  reason: collision with root package name */
    public int f72274f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.a> f72275g;

    /* renamed from: h  reason: collision with root package name */
    public String f72276h = "Y币";

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f72277i;

    /* renamed from: i.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1998a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f72278a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f72279b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f72280c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f72281d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f72282e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f72283f;

        public C1998a(a aVar) {
        }
    }

    public a(Context context, List<i.a.a.e.l.a> list, PayUIKitConfig payUIKitConfig) {
        this.f72273e = context;
        this.f72275g = list;
        this.f72277i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.a getItem(int i2) {
        List<i.a.a.e.l.a> list = this.f72275g;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f72275g.size()) {
            return null;
        }
        return this.f72275g.get(i2);
    }

    public i.a.a.e.l.a b() {
        int i2;
        if (this.f72274f >= getCount() || (i2 = this.f72274f) < 0) {
            return null;
        }
        return getItem(i2);
    }

    public void c(String str) {
        this.f72276h = str;
    }

    public void d(int i2) {
        this.f72274f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f72275g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1998a c1998a;
        if (view == null) {
            view = LayoutInflater.from(new ContextThemeWrapper(this.f72273e, g.f72271a.a(this.f72277i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
            c1998a = new C1998a(this);
            c1998a.f72278a = (TextView) view.findViewById(d.tv_dest_amount);
            c1998a.f72279b = (TextView) view.findViewById(d.tv_amount_unit);
            c1998a.f72280c = (LinearLayout) view.findViewById(d.amount_new_rl);
            c1998a.f72281d = (TextView) view.findViewById(d.amount_new);
            c1998a.f72282e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
            c1998a.f72283f = (TextView) view.findViewById(d.tv_other_amount);
            view.setTag(c1998a);
        } else {
            c1998a = (C1998a) view.getTag();
        }
        i.a.a.e.l.a item = getItem(i2);
        if (item.f72258c) {
            c1998a.f72283f.setVisibility(0);
            c1998a.f72282e.setVisibility(8);
            c1998a.f72281d.setVisibility(8);
        } else {
            c1998a.f72283f.setVisibility(8);
            c1998a.f72282e.setVisibility(0);
            c1998a.f72281d.setVisibility(0);
            c1998a.f72278a.setText(String.valueOf(item.a()));
            c1998a.f72279b.setText(this.f72276h);
            c1998a.f72281d.setVisibility(0);
            Double b2 = item.b();
            if (b2 == null) {
                c1998a.f72281d.setText("");
            } else {
                c1998a.f72281d.setText(String.format("¥%s", f.a(b2.doubleValue())));
            }
            if (this.f72274f == i2) {
                c1998a.f72280c.setSelected(true);
                c1998a.f72278a.setSelected(true);
                c1998a.f72279b.setSelected(true);
            } else {
                c1998a.f72280c.setSelected(false);
                c1998a.f72278a.setSelected(false);
                c1998a.f72279b.setSelected(false);
            }
        }
        return view;
    }
}
