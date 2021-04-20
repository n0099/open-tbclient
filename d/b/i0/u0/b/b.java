package d.b.i0.u0.b;

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
    public Context f62687e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f62688f;

    /* renamed from: g  reason: collision with root package name */
    public int f62689g = -1;

    /* renamed from: d.b.i0.u0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1641b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62690a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62691b;

        /* renamed from: c  reason: collision with root package name */
        public View f62692c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62693d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62694e;

        public C1641b() {
        }
    }

    public b(Context context) {
        this.f62687e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f62688f.get(i);
    }

    public int b() {
        return this.f62689g;
    }

    public void c(List<i0> list) {
        this.f62688f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f62689g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f62688f;
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
        C1641b c1641b;
        if (view != null && view.getTag() != null) {
            c1641b = (C1641b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62687e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1641b = new C1641b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1641b.f62690a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1641b.f62691b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1641b.f62691b.setDefaultResource(R.drawable.transparent_bg);
            c1641b.f62692c = view.findViewById(R.id.mask);
            c1641b.f62693d = (TextView) view.findViewById(R.id.name);
            c1641b.f62694e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1641b);
        }
        SkinManager.setViewTextColor(c1641b.f62693d, R.color.CAM_X0105, 1);
        if (i == this.f62689g) {
            SkinManager.setBackgroundResource(c1641b.f62692c, R.drawable.chx_box_gift_s);
        } else {
            c1641b.f62692c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i);
        if (item != null) {
            c1641b.f62693d.setText(item.f51217b);
            c1641b.f62690a.W(item.f51219d, 10, false);
            c1641b.f62691b.W(item.f51222g, 10, false);
            int i2 = item.f51221f;
            if (i2 == 5) {
                c1641b.f62694e.setVisibility(8);
            } else if (i2 == 3) {
                c1641b.f62694e.setVisibility(0);
                c1641b.f62694e.setText(g.b(item.j, false));
            } else {
                c1641b.f62694e.setVisibility(0);
                c1641b.f62694e.setText(g.b(item.f51218c, false));
            }
        }
        return view;
    }
}
