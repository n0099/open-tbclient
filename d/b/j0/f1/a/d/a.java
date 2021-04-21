package d.b.j0.f1.a.d;

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
    public Context f56205e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.s.f.a> f56206f;

    /* renamed from: g  reason: collision with root package name */
    public int f56207g = R.color.CAM_X0105;

    /* renamed from: h  reason: collision with root package name */
    public int f56208h = R.color.CAM_X0108;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f56209a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56210b;

        /* renamed from: c  reason: collision with root package name */
        public View f56211c;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56212a;

        /* renamed from: b  reason: collision with root package name */
        public View f56213b;

        public c(a aVar) {
        }
    }

    public a(Context context) {
        this.f56205e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.s.f.a getItem(int i) {
        List<d.b.i0.s.f.a> list = this.f56206f;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f56206f.get(i);
    }

    public void b(List<d.b.i0.s.f.a> list) {
        this.f56206f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.s.f.a> list = this.f56206f;
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
        d.b.i0.s.f.a item = getItem(i);
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
        d.b.i0.s.f.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f56205e).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                cVar = new c();
                cVar.f56212a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                cVar.f56213b = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(cVar);
            }
            if (item.a() != null) {
                cVar.f56212a.setText(item.a());
            }
            SkinManager.setViewTextColor(cVar.f56212a, this.f56208h, 1);
            SkinManager.setBackgroundColor(cVar.f56213b, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                bVar = new b();
                view = LayoutInflater.from(this.f56205e).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                bVar.f56209a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                bVar.f56210b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                bVar.f56211c = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(bVar);
            }
            if (item.f() != null) {
                bVar.f56210b.setText(item.f());
                bVar.f56209a.W(item.h(), 12, false);
            }
            SkinManager.setViewTextColor(bVar.f56210b, this.f56207g, 1);
            SkinManager.setBackgroundResource(bVar.f56211c, R.color.CAM_X0204);
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
