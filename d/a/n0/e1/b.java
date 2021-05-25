package d.a.n0.e1;

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
    public String f52778e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f52779f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f52780g;

    /* renamed from: d.a.n0.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1248b {

        /* renamed from: a  reason: collision with root package name */
        public int f52781a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52782b;

        /* renamed from: c  reason: collision with root package name */
        public View f52783c;

        /* renamed from: d  reason: collision with root package name */
        public View f52784d;

        public C1248b(b bVar) {
            this.f52781a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f52780g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1248b c1248b, View view, int i2) {
        if (c1248b == null || c1248b.f52781a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1248b.f52784d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1248b.f52783c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1248b.f52782b, R.color.CAM_X0105, 1);
        c1248b.f52781a = i2;
    }

    public void b() {
        this.f52779f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        return this.f52779f.get(i2);
    }

    public List<d> d() {
        return this.f52779f;
    }

    public void e(String str, List<d> list) {
        this.f52778e = str;
        this.f52779f.clear();
        if (list != null) {
            this.f52779f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52779f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1248b c1248b;
        d item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1248b)) {
            c1248b = (C1248b) view.getTag();
        } else {
            view = this.f52780g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1248b = new C1248b();
            c1248b.f52782b = (TextView) view.findViewById(R.id.name);
            c1248b.f52783c = view.findViewById(R.id.divider_line_top);
            c1248b.f52784d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1248b);
        }
        c1248b.f52783c.setVisibility(i2 == 0 ? 0 : 8);
        c1248b.f52782b.setText(StringHelper.highLightText(d.a.m0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f52778e, R.color.CAM_X0302));
        a(c1248b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
