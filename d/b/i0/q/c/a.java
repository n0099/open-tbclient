package d.b.i0.q.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f58960e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f58961f;

    /* renamed from: g  reason: collision with root package name */
    public int f58962g;

    /* renamed from: h  reason: collision with root package name */
    public int f58963h = R.color.CAM_X0105;
    public int i = R.color.CAM_X0108;
    public int j = R.color.CAM_X0109;
    public Drawable k;
    public Drawable l;
    public int m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58964a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58965b;

        /* renamed from: c  reason: collision with root package name */
        public View f58966c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58967d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58968e;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58969a;

        /* renamed from: b  reason: collision with root package name */
        public View f58970b;

        public c(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f58971a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58972b;

        /* renamed from: c  reason: collision with root package name */
        public View f58973c;

        public d(a aVar) {
        }
    }

    public a(Context context, d.b.h0.r.c cVar) {
        this.n = true;
        this.f58960e = context;
        this.m = l.g(context, R.dimen.ds24);
        this.n = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean b(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    public final void c(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = R.drawable.icon_news_head_prompt_two;
        }
        SkinManager.setBackgroundResource(textView, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public d.b.h0.s.f.a getItem(int i) {
        int i2 = this.n ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.f58961f.get(i - i2);
    }

    public void e(List<d.b.h0.s.f.a> list) {
        this.f58961f = list;
        notifyDataSetChanged();
    }

    public void f(int i) {
        this.f58962g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.n ? 3 : 2;
        List<d.b.h0.s.f.a> list = this.f58961f;
        return list == null ? i : list.size() + i;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        d.b.h0.s.f.a item = getItem(i);
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 5;
        }
        if (i == 2 && this.n) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar3 = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f58960e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar3 = new d();
                dVar3.f58971a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar3.f58972b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar3.f58973c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar3);
            }
            SkinManager.setImageResource(dVar3.f58971a, R.drawable.icon_new_friend);
            SkinManager.setViewTextColor(dVar3.f58972b, this.f58963h, 1);
            SkinManager.setBackgroundResource(dVar3.f58973c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            c((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.f58962g);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar2 = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f58960e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar2 = new d();
                dVar2.f58971a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar2.f58972b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar2.f58973c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar2);
            }
            SkinManager.setImageResource(dVar2.f58971a, R.drawable.icon_add_friend);
            SkinManager.setViewTextColor(dVar2.f58972b, this.f58963h, 1);
            dVar2.f58972b.setText(this.f58960e.getResources().getString(R.string.find_new_friend));
            SkinManager.setBackgroundResource(dVar2.f58973c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f58960e).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                dVar = new d();
                dVar.f58971a = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                dVar.f58972b = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(dVar);
            }
            SkinManager.setImageResource(dVar.f58971a, R.drawable.icon_me_group);
            SkinManager.setViewTextColor(dVar.f58972b, this.f58963h, 1);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            d.b.h0.s.f.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                    cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f58960e).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.f58969a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    cVar.f58970b = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(cVar);
                }
                if (item.a() != null) {
                    cVar.f58969a.setText(item.a());
                }
                SkinManager.setViewTextColor(cVar.f58969a, this.i, 1);
                SkinManager.setBackgroundResource(cVar.f58970b, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    bVar = new b();
                    view = LayoutInflater.from(this.f58960e).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    bVar.f58964a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    bVar.f58965b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    bVar.f58967d = (TextView) view.findViewById(R.id.detail_info_distance);
                    bVar.f58968e = (TextView) view.findViewById(R.id.detail_info_time);
                    bVar.f58966c = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(bVar);
                }
                if (item.f() != null) {
                    bVar.f58965b.setText(item.f());
                    bVar.f58964a.W(item.h(), 12, false);
                }
                item.l(null);
                if (item.b() != null) {
                    if (item.b().b() == 1) {
                        bVar.f58967d.setVisibility(0);
                        SkinManager.setViewTextColor(bVar.f58967d, this.j, 1);
                        bVar.f58967d.setText(this.f58960e.getResources().getString(R.string.contact_yinshen));
                        bVar.f58967d.setCompoundDrawables(null, null, null, null);
                        bVar.f58968e.setVisibility(8);
                    } else if (item.b().b() == 0) {
                        if (a(item.b().a()) && b(item.b().c())) {
                            bVar.f58967d.setVisibility(0);
                            bVar.f58968e.setVisibility(0);
                            bVar.f58967d.setText(item.b().a());
                            bVar.f58968e.setText(StringHelper.getTimeInterval(item.b().c()));
                            SkinManager.setViewTextColor(bVar.f58967d, this.j, 1);
                            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                            this.k = drawable;
                            int i2 = this.m;
                            drawable.setBounds(0, 0, i2, i2);
                            bVar.f58967d.setCompoundDrawables(this.k, null, null, null);
                            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                            this.l = drawable2;
                            int i3 = this.m;
                            drawable2.setBounds(0, 0, i3, i3);
                            bVar.f58968e.setCompoundDrawables(this.l, null, null, null);
                            SkinManager.setViewTextColor(bVar.f58968e, this.j, 1);
                        } else {
                            bVar.f58967d.setVisibility(8);
                            bVar.f58968e.setVisibility(8);
                        }
                    } else {
                        bVar.f58967d.setVisibility(8);
                        bVar.f58968e.setVisibility(8);
                    }
                } else {
                    bVar.f58967d.setVisibility(8);
                    bVar.f58968e.setVisibility(8);
                }
                SkinManager.setViewTextColor(bVar.f58965b, this.f58963h, 1);
                String a2 = item.a();
                d.b.h0.s.f.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(a2) || item2 == null || a2.equals(item2.a())) ? false : true) {
                    bVar.f58966c.setVisibility(4);
                } else {
                    bVar.f58966c.setVisibility(0);
                    SkinManager.setBackgroundResource(bVar.f58966c, R.color.CAM_X0204);
                }
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setViewTextColor(bVar.f58965b, this.f58963h, 1);
                SkinManager.setBackgroundResource(bVar.f58966c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }
}
