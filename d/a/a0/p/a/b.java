package d.a.a0.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import d.a.a0.f;
import d.a.a0.g;
import d.a.a0.p.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0501a> f39245e;

    /* renamed from: f  reason: collision with root package name */
    public Context f39246f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f39247a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f39248b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f39249c;

        public a(View view) {
            this.f39247a = (TextView) view.findViewById(f.coupon_title);
            this.f39248b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f39249c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f39246f = context;
    }

    public void a(List<a.C0501a> list) {
        this.f39245e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0501a getItem(int i2) {
        if (i2 < this.f39245e.size()) {
            return this.f39245e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0501a> list = this.f39245e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a.C0501a item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f39246f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f39247a.setText(item.f39239c);
            if (TextUtils.isEmpty(item.f39240d)) {
                aVar.f39248b.setVisibility(8);
            } else {
                aVar.f39248b.setVisibility(0);
                aVar.f39248b.setText(item.f39240d);
            }
            aVar.f39249c.setSelected(item.f39243g == 1);
        }
        return view;
    }
}
