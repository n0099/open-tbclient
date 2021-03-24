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
    public Context f60997e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f60998f;

    /* renamed from: g  reason: collision with root package name */
    public int f60999g = -1;

    /* renamed from: d.b.i0.t0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1580b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61000a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61001b;

        /* renamed from: c  reason: collision with root package name */
        public View f61002c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61003d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61004e;

        public C1580b() {
        }
    }

    public b(Context context) {
        this.f60997e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f60998f.get(i);
    }

    public int b() {
        return this.f60999g;
    }

    public void c(List<i0> list) {
        this.f60998f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f60999g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f60998f;
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
        C1580b c1580b;
        if (view != null && view.getTag() != null) {
            c1580b = (C1580b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60997e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1580b = new C1580b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1580b.f61000a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1580b.f61001b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1580b.f61001b.setDefaultResource(R.drawable.transparent_bg);
            c1580b.f61002c = view.findViewById(R.id.mask);
            c1580b.f61003d = (TextView) view.findViewById(R.id.name);
            c1580b.f61004e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1580b);
        }
        SkinManager.setViewTextColor(c1580b.f61003d, R.color.CAM_X0105, 1);
        if (i == this.f60999g) {
            SkinManager.setBackgroundResource(c1580b.f61002c, R.drawable.chx_box_gift_s);
        } else {
            c1580b.f61002c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i);
        if (item != null) {
            c1580b.f61003d.setText(item.f50809b);
            c1580b.f61000a.W(item.f50811d, 10, false);
            c1580b.f61001b.W(item.f50814g, 10, false);
            int i2 = item.f50813f;
            if (i2 == 5) {
                c1580b.f61004e.setVisibility(8);
            } else if (i2 == 3) {
                c1580b.f61004e.setVisibility(0);
                c1580b.f61004e.setText(g.b(item.j, false));
            } else {
                c1580b.f61004e.setVisibility(0);
                c1580b.f61004e.setText(g.b(item.f50810c, false));
            }
        }
        return view;
    }
}
