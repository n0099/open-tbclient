package d.a.n0.k3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f60672e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60673f;

    /* renamed from: g  reason: collision with root package name */
    public d f60674g;

    /* renamed from: d.a.n0.k3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1479a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60675a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f60676b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f60677c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f60678d;

        /* renamed from: e  reason: collision with root package name */
        public View f60679e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f60673f = tbPageContext;
        this.f60674g = dVar;
    }

    public void a(List<Object> list) {
        this.f60672e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f60672e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f60672e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60672e.size()) {
            return null;
        }
        return this.f60672e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (getItem(i2) != null) {
            return i2;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return getItem(i2) instanceof List ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1479a c1479a;
        Object item = getItem(i2);
        if (view != null) {
            c1479a = (C1479a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f60673f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1479a = new C1479a();
            c1479a.f60675a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1479a);
        } else {
            view = LayoutInflater.from(this.f60673f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1479a = new C1479a();
            c1479a.f60676b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1479a.f60677c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1479a.f60678d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1479a.f60679e = view.findViewById(R.id.divider_line);
            view.setTag(c1479a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1479a.f60675a.setText(item.toString());
            } else {
                List list = (List) item;
                c1479a.f60676b.e((DressItemData) list.get(0));
                c1479a.f60676b.setController(this.f60674g);
                if (list.size() > 2) {
                    c1479a.f60677c.e((DressItemData) list.get(1));
                    c1479a.f60678d.e((DressItemData) list.get(2));
                    c1479a.f60677c.setController(this.f60674g);
                    c1479a.f60678d.setController(this.f60674g);
                } else if (list.size() > 1) {
                    c1479a.f60677c.e((DressItemData) list.get(1));
                    c1479a.f60677c.setController(this.f60674g);
                    c1479a.f60678d.f();
                } else {
                    c1479a.f60677c.f();
                    c1479a.f60678d.f();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1479a.f60679e.setVisibility(8);
                } else {
                    c1479a.f60679e.setVisibility(0);
                }
            }
        }
        this.f60673f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
