package d.b.i0.f1.a.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f55784e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f55785f;

    /* renamed from: g  reason: collision with root package name */
    public int f55786g = R.color.CAM_X0105;

    /* renamed from: h  reason: collision with root package name */
    public int f55787h = R.color.CAM_X0108;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f55788a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55789b;

        /* renamed from: c  reason: collision with root package name */
        public View f55790c;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f55791a;

        /* renamed from: b  reason: collision with root package name */
        public View f55792b;

        public c(a aVar) {
        }
    }

    public a(Context context) {
        this.f55784e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.s.f.a getItem(int i) {
        List<d.b.h0.s.f.a> list = this.f55785f;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f55785f.get(i);
    }

    public void b(List<d.b.h0.s.f.a> list) {
        this.f55785f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.h0.s.f.a> list = this.f55785f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        d.b.h0.s.f.a item = getItem(i);
        if (item == null) {
            return 2;
        }
        return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        TbadkCoreApplication.getInst().getSkinType();
        d.b.h0.s.f.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f55784e).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                cVar = new c();
                cVar.f55791a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                cVar.f55792b = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(cVar);
            }
            if (item.a() != null) {
                cVar.f55791a.setText(item.a());
            }
            SkinManager.setViewTextColor(cVar.f55791a, this.f55787h, 1);
            SkinManager.setBackgroundColor(cVar.f55792b, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                bVar = new b();
                view = LayoutInflater.from(this.f55784e).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                bVar.f55788a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                bVar.f55789b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                bVar.f55790c = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(bVar);
            }
            if (item.f() != null) {
                bVar.f55789b.setText(item.f());
                bVar.f55788a.W(item.h(), 12, false);
            }
            SkinManager.setViewTextColor(bVar.f55789b, this.f55786g, 1);
            SkinManager.setBackgroundResource(bVar.f55790c, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
