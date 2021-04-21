package d.b.a0.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.a0.f;
import d.b.a0.g;
import d.b.a0.p.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0562a> f42064e;

    /* renamed from: f  reason: collision with root package name */
    public Context f42065f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f42066a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f42067b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f42068c;

        public a(View view) {
            this.f42066a = (TextView) view.findViewById(f.coupon_title);
            this.f42067b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f42068c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f42065f = context;
    }

    public void a(List<a.C0562a> list) {
        this.f42064e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0562a getItem(int i) {
        if (i < this.f42064e.size()) {
            return this.f42064e.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0562a> list = this.f42064e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a.C0562a item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f42065f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f42066a.setText(item.f42058c);
            if (TextUtils.isEmpty(item.f42059d)) {
                aVar.f42067b.setVisibility(8);
            } else {
                aVar.f42067b.setVisibility(0);
                aVar.f42067b.setText(item.f42059d);
            }
            aVar.f42068c.setSelected(item.f42062g == 1);
        }
        return view;
    }
}
