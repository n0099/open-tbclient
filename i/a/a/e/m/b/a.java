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
    public final Context f68886e;

    /* renamed from: f  reason: collision with root package name */
    public int f68887f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.j.b> f68888g;

    /* renamed from: h  reason: collision with root package name */
    public String f68889h = "Y币";

    /* renamed from: i.a.a.e.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1944a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f68890a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68891b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f68892c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68893d;

        public C1944a(a aVar) {
        }
    }

    public a(Context context, List<i.a.a.e.j.b> list) {
        this.f68886e = context;
        this.f68888g = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.j.b getItem(int i2) {
        List<i.a.a.e.j.b> list = this.f68888g;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f68888g.size()) {
            return null;
        }
        return this.f68888g.get(i2);
    }

    public void b(String str) {
        this.f68889h = str;
    }

    public void c(int i2) {
        this.f68887f = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f68888g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1944a c1944a;
        if (view == null) {
            view = LayoutInflater.from(this.f68886e).inflate(d.yy_item_pay_amount_choose, (ViewGroup) null);
            c1944a = new C1944a(this);
            c1944a.f68890a = (TextView) view.findViewById(c.tv_dest_amount);
            c1944a.f68891b = (TextView) view.findViewById(c.tv_amount_unit);
            c1944a.f68892c = (LinearLayout) view.findViewById(c.amount_new_rl);
            c1944a.f68893d = (TextView) view.findViewById(c.amount_new);
            view.setTag(c1944a);
        } else {
            c1944a = (C1944a) view.getTag();
        }
        i.a.a.e.j.b item = getItem(i2);
        c1944a.f68890a.setText(String.valueOf(item.a()));
        c1944a.f68891b.setText(this.f68889h);
        c1944a.f68893d.setVisibility(0);
        Double b2 = item.b();
        if (b2 == null) {
            c1944a.f68893d.setText("");
        } else {
            c1944a.f68893d.setText(String.format("¥%s", i.a.a.e.l.d.a(b2.doubleValue())));
        }
        if (this.f68887f == i2) {
            c1944a.f68892c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_selected);
            c1944a.f68890a.setTextColor(-52395);
            c1944a.f68891b.setTextColor(-52395);
        } else {
            c1944a.f68892c.setBackgroundResource(i.a.a.e.b.yy_bg_recharge_normal);
            c1944a.f68890a.setTextColor(-16777216);
            c1944a.f68891b.setTextColor(-16777216);
        }
        return view;
    }
}
