package d.a.n0.v0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.m0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f62199e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f62200f;

    /* renamed from: g  reason: collision with root package name */
    public int f62201g = -1;

    /* renamed from: d.a.n0.v0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1682b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62202a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62203b;

        /* renamed from: c  reason: collision with root package name */
        public View f62204c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62205d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62206e;

        public C1682b() {
        }
    }

    public b(Context context) {
        this.f62199e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f62200f.get(i2);
    }

    public int b() {
        return this.f62201g;
    }

    public void c(List<i0> list) {
        this.f62200f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f62201g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f62200f;
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
        C1682b c1682b;
        if (view != null && view.getTag() != null) {
            c1682b = (C1682b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62199e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1682b = new C1682b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1682b.f62202a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1682b.f62203b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1682b.f62203b.setDefaultResource(R.drawable.transparent_bg);
            c1682b.f62204c = view.findViewById(R.id.mask);
            c1682b.f62205d = (TextView) view.findViewById(R.id.name);
            c1682b.f62206e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1682b);
        }
        SkinManager.setViewTextColor(c1682b.f62205d, R.color.CAM_X0105, 1);
        if (i2 == this.f62201g) {
            SkinManager.setBackgroundResource(c1682b.f62204c, R.drawable.chx_box_gift_s);
        } else {
            c1682b.f62204c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i2);
        if (item != null) {
            c1682b.f62205d.setText(item.f50044b);
            c1682b.f62202a.V(item.f50046d, 10, false);
            c1682b.f62203b.V(item.f50049g, 10, false);
            int i3 = item.f50048f;
            if (i3 == 5) {
                c1682b.f62206e.setVisibility(8);
            } else if (i3 == 3) {
                c1682b.f62206e.setVisibility(0);
                c1682b.f62206e.setText(g.b(item.a(), false, item.s));
            } else {
                c1682b.f62206e.setVisibility(0);
                c1682b.f62206e.setText(g.b(item.b(), false, item.s));
            }
        }
        return view;
    }
}
