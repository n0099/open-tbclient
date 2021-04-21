package d.b.j0.d1;

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
    public String f54100e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f54101f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f54102g;

    /* renamed from: d.b.j0.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1219b {

        /* renamed from: a  reason: collision with root package name */
        public int f54103a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54104b;

        /* renamed from: c  reason: collision with root package name */
        public View f54105c;

        /* renamed from: d  reason: collision with root package name */
        public View f54106d;

        public C1219b(b bVar) {
            this.f54103a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f54102g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1219b c1219b, View view, int i) {
        if (c1219b == null || c1219b.f54103a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1219b.f54106d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1219b.f54105c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1219b.f54104b, R.color.CAM_X0105, 1);
        c1219b.f54103a = i;
    }

    public void b() {
        this.f54101f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        return this.f54101f.get(i);
    }

    public List<d> d() {
        return this.f54101f;
    }

    public void e(String str, List<d> list) {
        this.f54100e = str;
        this.f54101f.clear();
        if (list != null) {
            this.f54101f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f54101f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1219b c1219b;
        d item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1219b)) {
            c1219b = (C1219b) view.getTag();
        } else {
            view = this.f54102g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1219b = new C1219b();
            c1219b.f54104b = (TextView) view.findViewById(R.id.name);
            c1219b.f54105c = view.findViewById(R.id.divider_line_top);
            c1219b.f54106d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1219b);
        }
        c1219b.f54105c.setVisibility(i == 0 ? 0 : 8);
        c1219b.f54104b.setText(StringHelper.highLightText(d.b.i0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f54100e, R.color.CAM_X0302));
        a(c1219b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
