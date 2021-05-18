package d.a.k0.u0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.j0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f62042e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f62043f;

    /* renamed from: g  reason: collision with root package name */
    public int f62044g = -1;

    /* renamed from: d.a.k0.u0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1669b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62045a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62046b;

        /* renamed from: c  reason: collision with root package name */
        public View f62047c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62048d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62049e;

        public C1669b() {
        }
    }

    public b(Context context) {
        this.f62042e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f62043f.get(i2);
    }

    public int b() {
        return this.f62044g;
    }

    public void c(List<i0> list) {
        this.f62043f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f62044g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f62043f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1669b c1669b;
        if (view != null && view.getTag() != null) {
            c1669b = (C1669b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62042e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1669b = new C1669b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1669b.f62045a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1669b.f62046b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1669b.f62046b.setDefaultResource(R.drawable.transparent_bg);
            c1669b.f62047c = view.findViewById(R.id.mask);
            c1669b.f62048d = (TextView) view.findViewById(R.id.name);
            c1669b.f62049e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1669b);
        }
        SkinManager.setViewTextColor(c1669b.f62048d, R.color.CAM_X0105, 1);
        if (i2 == this.f62044g) {
            SkinManager.setBackgroundResource(c1669b.f62047c, R.drawable.chx_box_gift_s);
        } else {
            c1669b.f62047c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i2);
        if (item != null) {
            c1669b.f62048d.setText(item.f50000b);
            c1669b.f62045a.V(item.f50002d, 10, false);
            c1669b.f62046b.V(item.f50005g, 10, false);
            int i3 = item.f50004f;
            if (i3 == 5) {
                c1669b.f62049e.setVisibility(8);
            } else if (i3 == 3) {
                c1669b.f62049e.setVisibility(0);
                c1669b.f62049e.setText(g.b(item.a(), false, item.s));
            } else {
                c1669b.f62049e.setVisibility(0);
                c1669b.f62049e.setText(g.b(item.b(), false, item.s));
            }
        }
        return view;
    }
}
