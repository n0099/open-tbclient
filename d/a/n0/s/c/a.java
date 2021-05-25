package d.a.n0.s.c;

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
    public Context f60323e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.m0.s.f.a> f60324f;

    /* renamed from: g  reason: collision with root package name */
    public int f60325g;

    /* renamed from: h  reason: collision with root package name */
    public int f60326h = R.color.CAM_X0105;

    /* renamed from: i  reason: collision with root package name */
    public int f60327i = R.color.CAM_X0108;
    public int j = R.color.CAM_X0109;
    public Drawable k;
    public Drawable l;
    public int m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f60328a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60329b;

        /* renamed from: c  reason: collision with root package name */
        public View f60330c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60331d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60332e;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60333a;

        /* renamed from: b  reason: collision with root package name */
        public View f60334b;

        public c(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f60335a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60336b;

        /* renamed from: c  reason: collision with root package name */
        public View f60337c;

        public d(a aVar) {
        }
    }

    public a(Context context, d.a.m0.r.c cVar) {
        this.n = true;
        this.f60323e = context;
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
    public d.a.m0.s.f.a getItem(int i2) {
        int i3 = this.n ? 3 : 2;
        if (i2 < i3 || i2 >= getCount()) {
            return null;
        }
        return this.f60324f.get(i2 - i3);
    }

    public void e(List<d.a.m0.s.f.a> list) {
        this.f60324f = list;
        notifyDataSetChanged();
    }

    public void f(int i2) {
        this.f60325g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i2 = this.n ? 3 : 2;
        List<d.a.m0.s.f.a> list = this.f60324f;
        return list == null ? i2 : list.size() + i2;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        d.a.m0.s.f.a item = getItem(i2);
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
                view = LayoutInflater.from(this.f60323e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar3 = new d();
                dVar3.f60335a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar3.f60336b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar3.f60337c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar3);
            }
            SkinManager.setImageResource(dVar3.f60335a, R.drawable.icon_new_friend);
            SkinManager.setViewTextColor(dVar3.f60336b, this.f60326h, 1);
            SkinManager.setBackgroundResource(dVar3.f60337c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            c((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.f60325g);
            return view;
        } else if (getItemViewType(i2) == 5) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar2 = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f60323e).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                dVar2 = new d();
                dVar2.f60335a = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                dVar2.f60336b = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                dVar2.f60337c = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(dVar2);
            }
            SkinManager.setImageResource(dVar2.f60335a, R.drawable.icon_add_friend);
            SkinManager.setViewTextColor(dVar2.f60336b, this.f60326h, 1);
            dVar2.f60336b.setText(this.f60323e.getResources().getString(R.string.find_new_friend));
            SkinManager.setBackgroundResource(dVar2.f60337c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i2) == 1) {
            if (view != 0 && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f60323e).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                dVar = new d();
                dVar.f60335a = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                dVar.f60336b = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(dVar);
            }
            SkinManager.setImageResource(dVar.f60335a, R.drawable.icon_me_group);
            SkinManager.setViewTextColor(dVar.f60336b, this.f60326h, 1);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            d.a.m0.s.f.a item = getItem(i2);
            if (getItemViewType(i2) == 2) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                    cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f60323e).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    cVar = new c();
                    cVar.f60333a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    cVar.f60334b = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(cVar);
                }
                if (item.a() != null) {
                    cVar.f60333a.setText(item.a());
                }
                SkinManager.setViewTextColor(cVar.f60333a, this.f60327i, 1);
                SkinManager.setBackgroundResource(cVar.f60334b, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i2) == 3) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    bVar = new b();
                    view = LayoutInflater.from(this.f60323e).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    bVar.f60328a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    bVar.f60329b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    bVar.f60331d = (TextView) view.findViewById(R.id.detail_info_distance);
                    bVar.f60332e = (TextView) view.findViewById(R.id.detail_info_time);
                    bVar.f60330c = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(bVar);
                }
                if (item.f() != null) {
                    bVar.f60329b.setText(item.f());
                    bVar.f60328a.V(item.h(), 12, false);
                }
                item.l(null);
                if (item.b() != null) {
                    if (item.b().b() == 1) {
                        bVar.f60331d.setVisibility(0);
                        SkinManager.setViewTextColor(bVar.f60331d, this.j, 1);
                        bVar.f60331d.setText(this.f60323e.getResources().getString(R.string.contact_yinshen));
                        bVar.f60331d.setCompoundDrawables(null, null, null, null);
                        bVar.f60332e.setVisibility(8);
                    } else if (item.b().b() == 0) {
                        if (a(item.b().a()) && b(item.b().c())) {
                            bVar.f60331d.setVisibility(0);
                            bVar.f60332e.setVisibility(0);
                            bVar.f60331d.setText(item.b().a());
                            bVar.f60332e.setText(StringHelper.getTimeInterval(item.b().c()));
                            SkinManager.setViewTextColor(bVar.f60331d, this.j, 1);
                            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                            this.k = drawable;
                            int i3 = this.m;
                            drawable.setBounds(0, 0, i3, i3);
                            bVar.f60331d.setCompoundDrawables(this.k, null, null, null);
                            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                            this.l = drawable2;
                            int i4 = this.m;
                            drawable2.setBounds(0, 0, i4, i4);
                            bVar.f60332e.setCompoundDrawables(this.l, null, null, null);
                            SkinManager.setViewTextColor(bVar.f60332e, this.j, 1);
                        } else {
                            bVar.f60331d.setVisibility(8);
                            bVar.f60332e.setVisibility(8);
                        }
                    } else {
                        bVar.f60331d.setVisibility(8);
                        bVar.f60332e.setVisibility(8);
                    }
                } else {
                    bVar.f60331d.setVisibility(8);
                    bVar.f60332e.setVisibility(8);
                }
                SkinManager.setViewTextColor(bVar.f60329b, this.f60326h, 1);
                String a2 = item.a();
                d.a.m0.s.f.a item2 = getItem(i2 + 1);
                if ((TextUtils.isEmpty(a2) || item2 == null || a2.equals(item2.a())) ? false : true) {
                    bVar.f60330c.setVisibility(4);
                } else {
                    bVar.f60330c.setVisibility(0);
                    SkinManager.setBackgroundResource(bVar.f60330c, R.color.CAM_X0204);
                }
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setViewTextColor(bVar.f60329b, this.f60326h, 1);
                SkinManager.setBackgroundResource(bVar.f60330c, R.color.CAM_X0204);
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
