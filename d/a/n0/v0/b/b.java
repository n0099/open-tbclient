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
    public Context f65914e;

    /* renamed from: f  reason: collision with root package name */
    public List<i0> f65915f;

    /* renamed from: g  reason: collision with root package name */
    public int f65916g = -1;

    /* renamed from: d.a.n0.v0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1739b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65917a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65918b;

        /* renamed from: c  reason: collision with root package name */
        public View f65919c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65920d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65921e;

        public C1739b() {
        }
    }

    public b(Context context) {
        this.f65914e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i0 getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f65915f.get(i2);
    }

    public int b() {
        return this.f65916g;
    }

    public void c(List<i0> list) {
        this.f65915f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f65916g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i0> list = this.f65915f;
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
        C1739b c1739b;
        if (view != null && view.getTag() != null) {
            c1739b = (C1739b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f65914e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            c1739b = new C1739b();
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
            c1739b.f65917a = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
            c1739b.f65918b = tbImageView2;
            tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
            c1739b.f65918b.setDefaultResource(R.drawable.transparent_bg);
            c1739b.f65919c = view.findViewById(R.id.mask);
            c1739b.f65920d = (TextView) view.findViewById(R.id.name);
            c1739b.f65921e = (TextView) view.findViewById(R.id.price);
            view.setTag(c1739b);
        }
        SkinManager.setViewTextColor(c1739b.f65920d, R.color.CAM_X0105, 1);
        if (i2 == this.f65916g) {
            SkinManager.setBackgroundResource(c1739b.f65919c, R.drawable.chx_box_gift_s);
        } else {
            c1739b.f65919c.setBackgroundResource(R.color.common_color_10022);
        }
        i0 item = getItem(i2);
        if (item != null) {
            c1739b.f65920d.setText(item.f53720b);
            c1739b.f65917a.U(item.f53722d, 10, false);
            c1739b.f65918b.U(item.f53725g, 10, false);
            int i3 = item.f53724f;
            if (i3 == 5) {
                c1739b.f65921e.setVisibility(8);
            } else if (i3 == 3) {
                c1739b.f65921e.setVisibility(0);
                c1739b.f65921e.setText(g.b(item.a(), false, item.s));
            } else {
                c1739b.f65921e.setVisibility(0);
                c1739b.f65921e.setText(g.b(item.b(), false, item.s));
            }
        }
        return view;
    }
}
