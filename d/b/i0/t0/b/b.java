package d.b.i0.t0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.h0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f60998e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f60999f;

    /* renamed from: g  reason: collision with root package name */
    public int f61000g = -1;

    /* renamed from: d.b.i0.t0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1581b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61001a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61002b;

        /* renamed from: c  reason: collision with root package name */
        public View f61003c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61004d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61005e;

        public C1581b() {
        }
    }

    public b(Context context) {
        this.f60998e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f60999f.get(i);
    }

    public int b() {
        return this.f61000g;
    }

    public void c(List<i0> list) {
        this.f60999f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f61000g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f60999f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1581b c1581b;
        if (view != null && view.getTag() != null) {
            c1581b = (C1581b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60998e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1581b = new C1581b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1581b.f61001a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1581b.f61002b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1581b.f61002b.setDefaultResource(R.drawable.transparent_bg);
            c1581b.f61003c = view.findViewById(R.id.mask);
            c1581b.f61004d = (TextView) view.findViewById(R.id.name);
            c1581b.f61005e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1581b);
        }
        SkinManager.setViewTextColor(c1581b.f61004d, R.color.CAM_X0105, 1);
        if (i == this.f61000g) {
            SkinManager.setBackgroundResource(c1581b.f61003c, R.drawable.chx_box_gift_s);
        } else {
            c1581b.f61003c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i);
        if (item != null) {
            c1581b.f61004d.setText(item.f50810b);
            c1581b.f61001a.W(item.f50812d, 10, false);
            c1581b.f61002b.W(item.f50815g, 10, false);
            int i2 = item.f50814f;
            if (i2 == 5) {
                c1581b.f61005e.setVisibility(8);
            } else if (i2 == 3) {
                c1581b.f61005e.setVisibility(0);
                c1581b.f61005e.setText(g.b(item.j, false));
            } else {
                c1581b.f61005e.setVisibility(0);
                c1581b.f61005e.setText(g.b(item.f50811c, false));
            }
        }
        return view;
    }
}
