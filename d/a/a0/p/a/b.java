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
    public List<a.C0488a> f38490e;

    /* renamed from: f  reason: collision with root package name */
    public Context f38491f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f38492a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f38493b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f38494c;

        public a(View view) {
            this.f38492a = (TextView) view.findViewById(f.coupon_title);
            this.f38493b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f38494c = (ImageView) view.findViewById(f.select_icon);
        }
    }

    public b(Context context) {
        this.f38491f = context;
    }

    public void a(List<a.C0488a> list) {
        this.f38490e = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0488a getItem(int i2) {
        if (i2 < this.f38490e.size()) {
            return this.f38490e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0488a> list = this.f38490e;
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
        a.C0488a item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f38491f).inflate(g.coupon_list_item, (ViewGroup) null, false);
            view.setTag(new a(view));
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            aVar.f38492a.setText(item.f38484c);
            if (TextUtils.isEmpty(item.f38485d)) {
                aVar.f38493b.setVisibility(8);
            } else {
                aVar.f38493b.setVisibility(0);
                aVar.f38493b.setText(item.f38485d);
            }
            aVar.f38494c.setSelected(item.f38488g == 1);
        }
        return view;
    }
}
