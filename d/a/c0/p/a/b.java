package d.a.c0.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import d.a.c0.f;
import d.a.c0.g;
import d.a.c0.p.a.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0573a> f43294e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43295f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f43296a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43297b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f43298c;

        public a(View view) {
            this.f43296a = (TextView) view.findViewById(f.coupon_title);
            this.f43297b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f43298c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f43295f = context;
    }

    public void a(List<a.C0573a> list) {
        this.f43294e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0573a getItem(int i2) {
        if (i2 < this.f43294e.size()) {
            return this.f43294e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0573a> list = this.f43294e;
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
        a.C0573a item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f43295f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f43296a.setText(item.f43288c);
            if (TextUtils.isEmpty(item.f43289d)) {
                aVar.f43297b.setVisibility(8);
            } else {
                aVar.f43297b.setVisibility(0);
                aVar.f43297b.setText(item.f43289d);
            }
            aVar.f43298c.setSelected(item.f43292g == 1);
        }
        return view;
    }
}
