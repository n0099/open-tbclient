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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68163e;

    /* renamed from: f  reason: collision with root package name */
    public int f68164f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.j.b> f68165g;

    /* renamed from: h  reason: collision with root package name */
    public String f68166h = "Y币";

    /* renamed from: i.a.a.e.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1877a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f68167a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68168b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f68169c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68170d;

        public C1877a(a aVar) {
        }
    }

    public a(Context context, List<i.a.a.e.j.b> list) {
        this.f68163e = context;
        this.f68165g = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.j.b getItem(int i2) {
        List<i.a.a.e.j.b> list = this.f68165g;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f68165g.size()) {
            return null;
        }
        return this.f68165g.get(i2);
    }

    public void b(String str) {
        this.f68166h = str;
    }

    public void c(int i2) {
        this.f68164f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f68165g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1877a c1877a;
        if (view == null) {
            view = LayoutInflater.from(this.f68163e).inflate(d.yy_item_pay_amount_choose, (ViewGroup) null);
            c1877a = new C1877a(this);
            c1877a.f68167a = (TextView) view.findViewById(c.tv_dest_amount);
            c1877a.f68168b = (TextView) view.findViewById(c.tv_amount_unit);
            c1877a.f68169c = (LinearLayout) view.findViewById(c.amount_new_rl);
            c1877a.f68170d = (TextView) view.findViewById(c.amount_new);
            view.setTag(c1877a);
        } else {
            c1877a = (C1877a) view.getTag();
        }
        i.a.a.e.j.b item = getItem(i2);
        c1877a.f68167a.setText(String.valueOf(item.a()));
        c1877a.f68168b.setText(this.f68166h);
        c1877a.f68170d.setVisibility(0);
        Double b2 = item.b();
        if (b2 == null) {
            c1877a.f68170d.setText("");
        } else {
            c1877a.f68170d.setText(String.format("¥%s", i.a.a.e.l.d.a(b2.doubleValue())));
        }
        if (this.f68164f == i2) {
            c1877a.f68169c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_selected);
            c1877a.f68167a.setTextColor(-52395);
            c1877a.f68168b.setTextColor(-52395);
        } else {
            c1877a.f68169c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_normal);
            c1877a.f68167a.setTextColor(-16777216);
            c1877a.f68168b.setTextColor(-16777216);
        }
        return view;
    }
}
