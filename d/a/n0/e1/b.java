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
    public String f56467e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f56468f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f56469g;

    /* renamed from: d.a.n0.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1304b {

        /* renamed from: a  reason: collision with root package name */
        public int f56470a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56471b;

        /* renamed from: c  reason: collision with root package name */
        public View f56472c;

        /* renamed from: d  reason: collision with root package name */
        public View f56473d;

        public C1304b(b bVar) {
            this.f56470a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f56469g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1304b c1304b, View view, int i2) {
        if (c1304b == null || c1304b.f56470a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1304b.f56473d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1304b.f56472c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1304b.f56471b, R.color.CAM_X0105, 1);
        c1304b.f56470a = i2;
    }

    public void b() {
        this.f56468f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        return this.f56468f.get(i2);
    }

    public List<d> d() {
        return this.f56468f;
    }

    public void e(String str, List<d> list) {
        this.f56467e = str;
        this.f56468f.clear();
        if (list != null) {
            this.f56468f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56468f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1304b c1304b;
        d item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1304b)) {
            c1304b = (C1304b) view.getTag();
        } else {
            view = this.f56469g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1304b = new C1304b();
            c1304b.f56471b = (TextView) view.findViewById(R.id.name);
            c1304b.f56472c = view.findViewById(R.id.divider_line_top);
            c1304b.f56473d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1304b);
        }
        c1304b.f56472c.setVisibility(i2 == 0 ? 0 : 8);
        c1304b.f56471b.setText(StringHelper.highLightText(d.a.m0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f56467e, R.color.CAM_X0302));
        a(c1304b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
