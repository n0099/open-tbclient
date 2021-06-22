package d.a.o0.e1;

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
    public String f56592e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f56593f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f56594g;

    /* renamed from: d.a.o0.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1308b {

        /* renamed from: a  reason: collision with root package name */
        public int f56595a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56596b;

        /* renamed from: c  reason: collision with root package name */
        public View f56597c;

        /* renamed from: d  reason: collision with root package name */
        public View f56598d;

        public C1308b(b bVar) {
            this.f56595a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f56594g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1308b c1308b, View view, int i2) {
        if (c1308b == null || c1308b.f56595a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1308b.f56598d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1308b.f56597c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1308b.f56596b, R.color.CAM_X0105, 1);
        c1308b.f56595a = i2;
    }

    public void b() {
        this.f56593f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        return this.f56593f.get(i2);
    }

    public List<d> d() {
        return this.f56593f;
    }

    public void e(String str, List<d> list) {
        this.f56592e = str;
        this.f56593f.clear();
        if (list != null) {
            this.f56593f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56593f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1308b c1308b;
        d item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1308b)) {
            c1308b = (C1308b) view.getTag();
        } else {
            view = this.f56594g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1308b = new C1308b();
            c1308b.f56596b = (TextView) view.findViewById(R.id.name);
            c1308b.f56597c = view.findViewById(R.id.divider_line_top);
            c1308b.f56598d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1308b);
        }
        c1308b.f56597c.setVisibility(i2 == 0 ? 0 : 8);
        c1308b.f56596b.setText(StringHelper.highLightText(d.a.n0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f56592e, R.color.CAM_X0302));
        a(c1308b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
