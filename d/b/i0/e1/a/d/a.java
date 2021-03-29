package d.b.i0.e1.a.d;

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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f54343e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f54344f;

    /* renamed from: g  reason: collision with root package name */
    public int f54345g = R.color.CAM_X0105;

    /* renamed from: h  reason: collision with root package name */
    public int f54346h = R.color.CAM_X0108;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f54347a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54348b;

        /* renamed from: c  reason: collision with root package name */
        public View f54349c;

        public b(a aVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54350a;

        /* renamed from: b  reason: collision with root package name */
        public View f54351b;

        public c(a aVar) {
        }
    }

    public a(Context context) {
        this.f54343e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.s.f.a getItem(int i) {
        List<d.b.h0.s.f.a> list = this.f54344f;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f54344f.get(i);
    }

    public void b(List<d.b.h0.s.f.a> list) {
        this.f54344f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.h0.s.f.a> list = this.f54344f;
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
                view = LayoutInflater.from(this.f54343e).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                cVar = new c();
                cVar.f54350a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                cVar.f54351b = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(cVar);
            }
            if (item.a() != null) {
                cVar.f54350a.setText(item.a());
            }
            SkinManager.setViewTextColor(cVar.f54350a, this.f54346h, 1);
            SkinManager.setBackgroundColor(cVar.f54351b, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                bVar = new b();
                view = LayoutInflater.from(this.f54343e).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                bVar.f54347a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                bVar.f54348b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                bVar.f54349c = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(bVar);
            }
            if (item.f() != null) {
                bVar.f54348b.setText(item.f());
                bVar.f54347a.W(item.h(), 12, false);
            }
            SkinManager.setViewTextColor(bVar.f54348b, this.f54345g, 1);
            SkinManager.setBackgroundResource(bVar.f54349c, R.color.CAM_X0204);
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
