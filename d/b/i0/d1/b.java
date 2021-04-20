package d.b.i0.d1;

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
    public String f53679e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f53680f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f53681g;

    /* renamed from: d.b.i0.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1196b {

        /* renamed from: a  reason: collision with root package name */
        public int f53682a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53683b;

        /* renamed from: c  reason: collision with root package name */
        public View f53684c;

        /* renamed from: d  reason: collision with root package name */
        public View f53685d;

        public C1196b(b bVar) {
            this.f53682a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f53681g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1196b c1196b, View view, int i) {
        if (c1196b == null || c1196b.f53682a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1196b.f53685d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1196b.f53684c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1196b.f53683b, R.color.CAM_X0105, 1);
        c1196b.f53682a = i;
    }

    public void b() {
        this.f53680f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        return this.f53680f.get(i);
    }

    public List<d> d() {
        return this.f53680f;
    }

    public void e(String str, List<d> list) {
        this.f53679e = str;
        this.f53680f.clear();
        if (list != null) {
            this.f53680f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f53680f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1196b c1196b;
        d item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1196b)) {
            c1196b = (C1196b) view.getTag();
        } else {
            view = this.f53681g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1196b = new C1196b();
            c1196b.f53683b = (TextView) view.findViewById(R.id.name);
            c1196b.f53684c = view.findViewById(R.id.divider_line_top);
            c1196b.f53685d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1196b);
        }
        c1196b.f53684c.setVisibility(i == 0 ? 0 : 8);
        c1196b.f53683b.setText(StringHelper.highLightText(d.b.h0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f53679e, R.color.CAM_X0302));
        a(c1196b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
