package d.b.z.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.z.f;
import d.b.z.g;
import d.b.z.p.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<a.C1810a> f65762e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65763f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f65764a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65765b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f65766c;

        public a(View view) {
            this.f65764a = (TextView) view.findViewById(f.coupon_title);
            this.f65765b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f65766c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f65763f = context;
    }

    public void a(List<a.C1810a> list) {
        this.f65762e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C1810a getItem(int i) {
        if (i < this.f65762e.size()) {
            return this.f65762e.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C1810a> list = this.f65762e;
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
        a.C1810a item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f65763f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f65764a.setText(item.f65756c);
            if (TextUtils.isEmpty(item.f65757d)) {
                aVar.f65765b.setVisibility(8);
            } else {
                aVar.f65765b.setVisibility(0);
                aVar.f65765b.setText(item.f65757d);
            }
            aVar.f65766c.setSelected(item.f65760g == 1);
        }
        return view;
    }
}
