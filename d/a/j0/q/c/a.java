package d.a.j0.q.c;

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
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f57418e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.i0.s.f.a> f57419f;

    /* renamed from: g  reason: collision with root package name */
    public int f57420g;

    /* renamed from: h  reason: collision with root package name */
    public int f57421h = R.color.CAM_X0105;

    /* renamed from: i  reason: collision with root package name */
    public int f57422i = R.color.CAM_X0108;
    public int j = R.color.CAM_X0109;
    public Drawable k;
    public Drawable l;
    public int m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f57423a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57424b;

        /* renamed from: c  reason: collision with root package name */
        public View f57425c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57426d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57427e;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57428a;

        /* renamed from: b  reason: collision with root package name */
        public View f57429b;

        public c(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f57430a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57431b;

        /* renamed from: c  reason: collision with root package name */
        public View f57432c;

        public d(a aVar) {
        }
    }

    public a(Context context, d.a.i0.r.c cVar) {
        this.n = true;
        this.f57418e = context;
        this.m = l.g(context, R.dimen.ds24);
        this.n = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean b(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    public final void c(TextView textView, int i2) {
        int i3;
        if (i2 <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1);
        if (i2 < 10) {
            textView.setText(String.valueOf(i2));
            i3 = R.drawable.icon_news_head_prompt_one;
        } else if (i2 < 100) {
            textView.setText(String.valueOf(i2));
            i3 = R.drawable.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i3 = R.drawable.icon_news_head_prompt_two;
        }
        SkinManager.setBackgroundResource(textView, i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public d.a.i0.s.f.a getItem(int i2) {
        int i3 = this.n ? 3 : 2;
        if (i2 < i3 || i2 >= getCount()) {
            return null;
        }
        return this.f57419f.get(i2 - i3);
    }

    public void e(List<d.a.i0.s.f.a> list) {
        this.f57419f = list;
        notifyDataSetChanged();
    }

    public void f(int i2) {
        this.f57420g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i2 = this.n ? 3 : 2;
        List<d.a.i0.s.f.a> list = this.f57419f;
        return list == null ? i2 : list.size() + i2;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        d.a.i0.s.f.a item = getItem(i2);
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 5;
        }
        if (i2 == 2 && this.n) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        if (getItemViewType(i2) == 4) {
            return null;
        }
        if (getItemViewType(i2) == 0) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar3 = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f57418e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar3 = new d();
                dVar3.f57430a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar3.f57431b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar3.f57432c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar3);
            }
            SkinManager.setImageResource(dVar3.f57430a, R.drawable.icon_new_friend);
            SkinManager.setViewTextColor(dVar3.f57431b, this.f57421h, 1);
            SkinManager.setBackgroundResource(dVar3.f57432c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            c((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.f57420g);
            return view;
        } else if (getItemViewType(i2) == 5) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar2 = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f57418e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar2 = new d();
                dVar2.f57430a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar2.f57431b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar2.f57432c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar2);
            }
            SkinManager.setImageResource(dVar2.f57430a, R.drawable.icon_add_friend);
            SkinManager.setViewTextColor(dVar2.f57431b, this.f57421h, 1);
            dVar2.f57431b.setText(this.f57418e.getResources().getString(R.string.find_new_friend));
            SkinManager.setBackgroundResource(dVar2.f57432c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i2) == 1) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f57418e).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                dVar = new d();
                dVar.f57430a = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                dVar.f57431b = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(dVar);
            }
            SkinManager.setImageResource(dVar.f57430a, R.drawable.icon_me_group);
            SkinManager.setViewTextColor(dVar.f57431b, this.f57421h, 1);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            d.a.i0.s.f.a item = getItem(i2);
            if (getItemViewType(i2) == 2) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                    cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f57418e).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.f57428a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    cVar.f57429b = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(cVar);
                }
                if (item.a() != null) {
                    cVar.f57428a.setText(item.a());
                }
                SkinManager.setViewTextColor(cVar.f57428a, this.f57422i, 1);
                SkinManager.setBackgroundResource(cVar.f57429b, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i2) == 3) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    bVar = new b();
                    view = LayoutInflater.from(this.f57418e).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    bVar.f57423a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    bVar.f57424b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    bVar.f57426d = (TextView) view.findViewById(R.id.detail_info_distance);
                    bVar.f57427e = (TextView) view.findViewById(R.id.detail_info_time);
                    bVar.f57425c = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(bVar);
                }
                if (item.f() != null) {
                    bVar.f57424b.setText(item.f());
                    bVar.f57423a.V(item.h(), 12, false);
                }
                item.l(null);
                if (item.b() != null) {
                    if (item.b().b() == 1) {
                        bVar.f57426d.setVisibility(0);
                        SkinManager.setViewTextColor(bVar.f57426d, this.j, 1);
                        bVar.f57426d.setText(this.f57418e.getResources().getString(R.string.contact_yinshen));
                        bVar.f57426d.setCompoundDrawables(null, null, null, null);
                        bVar.f57427e.setVisibility(8);
                    } else if (item.b().b() == 0) {
                        if (a(item.b().a()) && b(item.b().c())) {
                            bVar.f57426d.setVisibility(0);
                            bVar.f57427e.setVisibility(0);
                            bVar.f57426d.setText(item.b().a());
                            bVar.f57427e.setText(StringHelper.getTimeInterval(item.b().c()));
                            SkinManager.setViewTextColor(bVar.f57426d, this.j, 1);
                            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                            this.k = drawable;
                            int i3 = this.m;
                            drawable.setBounds(0, 0, i3, i3);
                            bVar.f57426d.setCompoundDrawables(this.k, null, null, null);
                            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                            this.l = drawable2;
                            int i4 = this.m;
                            drawable2.setBounds(0, 0, i4, i4);
                            bVar.f57427e.setCompoundDrawables(this.l, null, null, null);
                            SkinManager.setViewTextColor(bVar.f57427e, this.j, 1);
                        } else {
                            bVar.f57426d.setVisibility(8);
                            bVar.f57427e.setVisibility(8);
                        }
                    } else {
                        bVar.f57426d.setVisibility(8);
                        bVar.f57427e.setVisibility(8);
                    }
                } else {
                    bVar.f57426d.setVisibility(8);
                    bVar.f57427e.setVisibility(8);
                }
                SkinManager.setViewTextColor(bVar.f57424b, this.f57421h, 1);
                String a2 = item.a();
                d.a.i0.s.f.a item2 = getItem(i2 + 1);
                if ((TextUtils.isEmpty(a2) || item2 == null || a2.equals(item2.a())) ? false : true) {
                    bVar.f57425c.setVisibility(4);
                } else {
                    bVar.f57425c.setVisibility(0);
                    SkinManager.setBackgroundResource(bVar.f57425c, R.color.CAM_X0204);
                }
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setViewTextColor(bVar.f57424b, this.f57421h, 1);
                SkinManager.setBackgroundResource(bVar.f57425c, R.color.CAM_X0204);
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
