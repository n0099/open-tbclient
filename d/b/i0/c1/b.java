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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public String f52283e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f52284f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f52285g;

    /* renamed from: d.b.i0.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1138b {

        /* renamed from: a  reason: collision with root package name */
        public int f52286a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52287b;

        /* renamed from: c  reason: collision with root package name */
        public View f52288c;

        /* renamed from: d  reason: collision with root package name */
        public View f52289d;

        public C1138b(b bVar) {
            this.f52286a = 3;
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f52285g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1138b c1138b, View view, int i) {
        if (c1138b == null || c1138b.f52286a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1138b.f52289d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1138b.f52288c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1138b.f52287b, R.color.CAM_X0105, 1);
        c1138b.f52286a = i;
    }

    public void b() {
        this.f52284f.clear();
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i) {
        return this.f52284f.get(i);
    }

    public List<d> d() {
        return this.f52284f;
    }

    public void e(String str, List<d> list) {
        this.f52283e = str;
        this.f52284f.clear();
        if (list != null) {
            this.f52284f.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52284f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1138b c1138b;
        d item = getItem(i);
        if (item == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof C1138b)) {
            c1138b = (C1138b) view.getTag();
        } else {
            view = this.f52285g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
            c1138b = new C1138b();
            c1138b.f52287b = (TextView) view.findViewById(R.id.name);
            c1138b.f52288c = view.findViewById(R.id.divider_line_top);
            c1138b.f52289d = view.findViewById(R.id.divider_line_bottom);
            view.setTag(c1138b);
        }
        c1138b.f52288c.setVisibility(i == 0 ? 0 : 8);
        c1138b.f52287b.setText(StringHelper.highLightText(d.b.h0.p0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f52283e, R.color.CAM_X0302));
        a(c1138b, view, TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
