package d.a.o0.v0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.n0.r.q.i0;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f66039e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f66040f;

    /* renamed from: g  reason: collision with root package name */
    public int f66041g = -1;

    /* renamed from: d.a.o0.v0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1743b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66042a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f66043b;

        /* renamed from: c  reason: collision with root package name */
        public View f66044c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66045d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66046e;

        public C1743b() {
        }
    }

    public b(Context context) {
        this.f66039e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f66040f.get(i2);
    }

    public int b() {
        return this.f66041g;
    }

    public void c(List<i0> list) {
        this.f66040f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f66041g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f66040f;
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
        C1743b c1743b;
        if (view != null && view.getTag() != null) {
            c1743b = (C1743b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f66039e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1743b = new C1743b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1743b.f66042a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1743b.f66043b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1743b.f66043b.setDefaultResource(R.drawable.transparent_bg);
            c1743b.f66044c = view.findViewById(R.id.mask);
            c1743b.f66045d = (TextView) view.findViewById(R.id.name);
            c1743b.f66046e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1743b);
        }
        SkinManager.setViewTextColor(c1743b.f66045d, R.color.CAM_X0105, 1);
        if (i2 == this.f66041g) {
            SkinManager.setBackgroundResource(c1743b.f66044c, R.drawable.chx_box_gift_s);
        } else {
            c1743b.f66044c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i2);
        if (item != null) {
            c1743b.f66045d.setText(item.f53827b);
            c1743b.f66042a.U(item.f53829d, 10, false);
            c1743b.f66043b.U(item.f53832g, 10, false);
            int i3 = item.f53831f;
            if (i3 == 5) {
                c1743b.f66046e.setVisibility(8);
            } else if (i3 == 3) {
                c1743b.f66046e.setVisibility(0);
                c1743b.f66046e.setText(g.b(item.a(), false, item.s));
            } else {
                c1743b.f66046e.setVisibility(0);
                c1743b.f66046e.setText(g.b(item.b(), false, item.s));
            }
        }
        return view;
    }
}
