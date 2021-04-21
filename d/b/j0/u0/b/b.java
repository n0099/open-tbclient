package d.b.j0.u0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f63108e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f63109f;

    /* renamed from: g  reason: collision with root package name */
    public int f63110g = -1;

    /* renamed from: d.b.j0.u0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1664b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63111a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63112b;

        /* renamed from: c  reason: collision with root package name */
        public View f63113c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63114d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63115e;

        public C1664b() {
        }
    }

    public b(Context context) {
        this.f63108e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f63109f.get(i);
    }

    public int b() {
        return this.f63110g;
    }

    public void c(List<i0> list) {
        this.f63109f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f63110g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f63109f;
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
        C1664b c1664b;
        if (view != null && view.getTag() != null) {
            c1664b = (C1664b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f63108e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1664b = new C1664b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1664b.f63111a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1664b.f63112b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1664b.f63112b.setDefaultResource(R.drawable.transparent_bg);
            c1664b.f63113c = view.findViewById(R.id.mask);
            c1664b.f63114d = (TextView) view.findViewById(R.id.name);
            c1664b.f63115e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1664b);
        }
        SkinManager.setViewTextColor(c1664b.f63114d, R.color.CAM_X0105, 1);
        if (i == this.f63110g) {
            SkinManager.setBackgroundResource(c1664b.f63113c, R.drawable.chx_box_gift_s);
        } else {
            c1664b.f63113c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i);
        if (item != null) {
            c1664b.f63114d.setText(item.f51553b);
            c1664b.f63111a.W(item.f51555d, 10, false);
            c1664b.f63112b.W(item.f51558g, 10, false);
            int i2 = item.f51557f;
            if (i2 == 5) {
                c1664b.f63115e.setVisibility(8);
            } else if (i2 == 3) {
                c1664b.f63115e.setVisibility(0);
                c1664b.f63115e.setText(g.b(item.j, false));
            } else {
                c1664b.f63115e.setVisibility(0);
                c1664b.f63115e.setText(g.b(item.f51554c, false));
            }
        }
        return view;
    }
}
