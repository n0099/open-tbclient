package i.a.a.e.m.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import i.a.a.e.c;
import i.a.a.e.d;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68843e;

    /* renamed from: f  reason: collision with root package name */
    public int f68844f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.j.b> f68845g;

    /* renamed from: h  reason: collision with root package name */
    public String f68846h = "Y币";

    /* renamed from: i.a.a.e.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1940a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f68847a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68848b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f68849c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68850d;

        public C1940a(a aVar) {
        }
    }

    public a(Context context, List<i.a.a.e.j.b> list) {
        this.f68843e = context;
        this.f68845g = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.j.b getItem(int i2) {
        List<i.a.a.e.j.b> list = this.f68845g;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f68845g.size()) {
            return null;
        }
        return this.f68845g.get(i2);
    }

    public void b(String str) {
        this.f68846h = str;
    }

    public void c(int i2) {
        this.f68844f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f68845g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1940a c1940a;
        if (view == null) {
            view = LayoutInflater.from(this.f68843e).inflate(d.yy_item_pay_amount_choose, (ViewGroup) null);
            c1940a = new C1940a(this);
            c1940a.f68847a = (TextView) view.findViewById(c.tv_dest_amount);
            c1940a.f68848b = (TextView) view.findViewById(c.tv_amount_unit);
            c1940a.f68849c = (LinearLayout) view.findViewById(c.amount_new_rl);
            c1940a.f68850d = (TextView) view.findViewById(c.amount_new);
            view.setTag(c1940a);
        } else {
            c1940a = (C1940a) view.getTag();
        }
        i.a.a.e.j.b item = getItem(i2);
        c1940a.f68847a.setText(String.valueOf(item.a()));
        c1940a.f68848b.setText(this.f68846h);
        c1940a.f68850d.setVisibility(0);
        Double b2 = item.b();
        if (b2 == null) {
            c1940a.f68850d.setText("");
        } else {
            c1940a.f68850d.setText(String.format("¥%s", i.a.a.e.l.d.a(b2.doubleValue())));
        }
        if (this.f68844f == i2) {
            c1940a.f68849c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_selected);
            c1940a.f68847a.setTextColor(-52395);
            c1940a.f68848b.setTextColor(-52395);
        } else {
            c1940a.f68849c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_normal);
            c1940a.f68847a.setTextColor(-16777216);
            c1940a.f68848b.setTextColor(-16777216);
        }
        return view;
    }
}
