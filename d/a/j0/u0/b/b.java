package d.a.j0.u0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.i0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f61318e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f61319f;

    /* renamed from: g  reason: collision with root package name */
    public int f61320g = -1;

    /* renamed from: d.a.j0.u0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1604b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61321a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61322b;

        /* renamed from: c  reason: collision with root package name */
        public View f61323c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61324d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61325e;

        public C1604b() {
        }
    }

    public b(Context context) {
        this.f61318e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f61319f.get(i2);
    }

    public int b() {
        return this.f61320g;
    }

    public void c(List<i0> list) {
        this.f61319f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f61320g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f61319f;
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
        C1604b c1604b;
        if (view != null && view.getTag() != null) {
            c1604b = (C1604b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61318e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1604b = new C1604b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1604b.f61321a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1604b.f61322b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1604b.f61322b.setDefaultResource(R.drawable.transparent_bg);
            c1604b.f61323c = view.findViewById(R.id.mask);
            c1604b.f61324d = (TextView) view.findViewById(R.id.name);
            c1604b.f61325e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1604b);
        }
        SkinManager.setViewTextColor(c1604b.f61324d, R.color.CAM_X0105, 1);
        if (i2 == this.f61320g) {
            SkinManager.setBackgroundResource(c1604b.f61323c, R.drawable.chx_box_gift_s);
        } else {
            c1604b.f61323c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i2);
        if (item != null) {
            c1604b.f61324d.setText(item.f49181b);
            c1604b.f61321a.V(item.f49183d, 10, false);
            c1604b.f61322b.V(item.f49186g, 10, false);
            int i3 = item.f49185f;
            if (i3 == 5) {
                c1604b.f61325e.setVisibility(8);
            } else if (i3 == 3) {
                c1604b.f61325e.setVisibility(0);
                c1604b.f61325e.setText(g.b(item.a(), false, item.s));
            } else {
                c1604b.f61325e.setVisibility(0);
                c1604b.f61325e.setText(g.b(item.b(), false, item.s));
            }
        }
        return view;
    }
}
