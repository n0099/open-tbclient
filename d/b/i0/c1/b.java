package d.b.i0.c1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public String f52284e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f52285f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f52286g;

    /* renamed from: d.b.i0.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1139b {

        /* renamed from: a  reason: collision with root package name */
        public int f52287a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52288b;

        /* renamed from: c  reason: collision with root package name */
        public View f52289c;

        /* renamed from: d  reason: collision with root package name */
        public View f52290d;

        public C1139b(b bVar) {
            this.f52287a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f52286g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1139b c1139b, View view, int i) {
        if (c1139b == null || c1139b.f52287a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1139b.f52290d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1139b.f52289c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1139b.f52288b, R.color.CAM_X0105, 1);
        c1139b.f52287a = i;
    }

    public void b() {
        this.f52285f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        return this.f52285f.get(i);
    }

    public List<d> d() {
        return this.f52285f;
    }

    public void e(String str, List<d> list) {
        this.f52284e = str;
        this.f52285f.clear();
        if (list != null) {
            this.f52285f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52285f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1139b c1139b;
        d item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1139b)) {
            c1139b = (C1139b) view.getTag();
        } else {
            view = this.f52286g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1139b = new C1139b();
            c1139b.f52288b = (TextView) view.findViewById(R.id.name);
            c1139b.f52289c = view.findViewById(R.id.divider_line_top);
            c1139b.f52290d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1139b);
        }
        c1139b.f52289c.setVisibility(i == 0 ? 0 : 8);
        c1139b.f52288b.setText(StringHelper.highLightText(d.b.h0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f52284e, R.color.CAM_X0302));
        a(c1139b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
