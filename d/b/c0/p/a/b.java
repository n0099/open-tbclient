package d.b.c0.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.c0.f;
import d.b.c0.g;
import d.b.c0.p.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0573a> f42694e;

    /* renamed from: f  reason: collision with root package name */
    public Context f42695f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f42696a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f42697b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f42698c;

        public a(View view) {
            this.f42696a = (TextView) view.findViewById(f.coupon_title);
            this.f42697b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f42698c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f42695f = context;
    }

    public void a(List<a.C0573a> list) {
        this.f42694e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0573a getItem(int i) {
        if (i < this.f42694e.size()) {
            return this.f42694e.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0573a> list = this.f42694e;
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
        a.C0573a item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f42695f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f42696a.setText(item.f42688c);
            if (TextUtils.isEmpty(item.f42689d)) {
                aVar.f42697b.setVisibility(8);
            } else {
                aVar.f42697b.setVisibility(0);
                aVar.f42697b.setText(item.f42689d);
            }
            aVar.f42698c.setSelected(item.f42692g == 1);
        }
        return view;
    }
}
