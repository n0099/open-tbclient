package d.a.k0.d1;

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
    public String f52573e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f52574f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f52575g;

    /* renamed from: d.a.k0.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1230b {

        /* renamed from: a  reason: collision with root package name */
        public int f52576a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52577b;

        /* renamed from: c  reason: collision with root package name */
        public View f52578c;

        /* renamed from: d  reason: collision with root package name */
        public View f52579d;

        public C1230b(b bVar) {
            this.f52576a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f52575g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1230b c1230b, View view, int i2) {
        if (c1230b == null || c1230b.f52576a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1230b.f52579d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1230b.f52578c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1230b.f52577b, R.color.CAM_X0105, 1);
        c1230b.f52576a = i2;
    }

    public void b() {
        this.f52574f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        return this.f52574f.get(i2);
    }

    public List<d> d() {
        return this.f52574f;
    }

    public void e(String str, List<d> list) {
        this.f52573e = str;
        this.f52574f.clear();
        if (list != null) {
            this.f52574f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52574f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1230b c1230b;
        d item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1230b)) {
            c1230b = (C1230b) view.getTag();
        } else {
            view = this.f52575g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1230b = new C1230b();
            c1230b.f52577b = (TextView) view.findViewById(R.id.name);
            c1230b.f52578c = view.findViewById(R.id.divider_line_top);
            c1230b.f52579d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1230b);
        }
        c1230b.f52578c.setVisibility(i2 == 0 ? 0 : 8);
        c1230b.f52577b.setText(StringHelper.highLightText(d.a.j0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f52573e, R.color.CAM_X0302));
        a(c1230b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
