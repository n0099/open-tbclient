package d.a.j0.d1;

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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public String f51874e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f51875f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f51876g;

    /* renamed from: d.a.j0.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1158b {

        /* renamed from: a  reason: collision with root package name */
        public int f51877a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51878b;

        /* renamed from: c  reason: collision with root package name */
        public View f51879c;

        /* renamed from: d  reason: collision with root package name */
        public View f51880d;

        public C1158b(b bVar) {
            this.f51877a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f51876g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1158b c1158b, View view, int i2) {
        if (c1158b == null || c1158b.f51877a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1158b.f51880d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1158b.f51879c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1158b.f51878b, R.color.CAM_X0105, 1);
        c1158b.f51877a = i2;
    }

    public void b() {
        this.f51875f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        return this.f51875f.get(i2);
    }

    public List<d> d() {
        return this.f51875f;
    }

    public void e(String str, List<d> list) {
        this.f51874e = str;
        this.f51875f.clear();
        if (list != null) {
            this.f51875f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f51875f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1158b c1158b;
        d item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1158b)) {
            c1158b = (C1158b) view.getTag();
        } else {
            view = this.f51876g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1158b = new C1158b();
            c1158b.f51878b = (TextView) view.findViewById(R.id.name);
            c1158b.f51879c = view.findViewById(R.id.divider_line_top);
            c1158b.f51880d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1158b);
        }
        c1158b.f51879c.setVisibility(i2 == 0 ? 0 : 8);
        c1158b.f51878b.setText(StringHelper.highLightText(d.a.i0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f51874e, R.color.CAM_X0302));
        a(c1158b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
