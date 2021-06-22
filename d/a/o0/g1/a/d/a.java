package d.a.o0.g1.a.d;

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
    public Context f58793e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.s.f.a> f58794f;

    /* renamed from: g  reason: collision with root package name */
    public int f58795g = R.color.CAM_X0105;

    /* renamed from: h  reason: collision with root package name */
    public int f58796h = R.color.CAM_X0108;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f58797a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58798b;

        /* renamed from: c  reason: collision with root package name */
        public View f58799c;

        public b(a aVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58800a;

        /* renamed from: b  reason: collision with root package name */
        public View f58801b;

        public c(a aVar) {
        }
    }

    public a(Context context) {
        this.f58793e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.n0.s.f.a getItem(int i2) {
        List<d.a.n0.s.f.a> list = this.f58794f;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f58794f.get(i2);
    }

    public void b(List<d.a.n0.s.f.a> list) {
        this.f58794f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.s.f.a> list = this.f58794f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        d.a.n0.s.f.a item = getItem(i2);
        if (item == null) {
            return 2;
        }
        return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i2) == 2) {
            return null;
        }
        TbadkCoreApplication.getInst().getSkinType();
        d.a.n0.s.f.a item = getItem(i2);
        if (getItemViewType(i2) == 0) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f58793e).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                cVar = new c();
                cVar.f58800a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                cVar.f58801b = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(cVar);
            }
            if (item.a() != null) {
                cVar.f58800a.setText(item.a());
            }
            SkinManager.setViewTextColor(cVar.f58800a, this.f58796h, 1);
            SkinManager.setBackgroundColor(cVar.f58801b, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i2) == 1) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                bVar = new b();
                view = LayoutInflater.from(this.f58793e).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                bVar.f58797a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                bVar.f58798b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                bVar.f58799c = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(bVar);
            }
            if (item.f() != null) {
                bVar.f58798b.setText(item.f());
                bVar.f58797a.U(item.h(), 12, false);
            }
            SkinManager.setViewTextColor(bVar.f58798b, this.f58795g, 1);
            SkinManager.setBackgroundResource(bVar.f58799c, R.color.CAM_X0204);
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
