package d.a.k0.j3.e;

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
    public List<Object> f56803e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56804f;

    /* renamed from: g  reason: collision with root package name */
    public d f56805g;

    /* renamed from: d.a.k0.j3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1405a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56806a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56807b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56808c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56809d;

        /* renamed from: e  reason: collision with root package name */
        public View f56810e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f56804f = tbPageContext;
        this.f56805g = dVar;
    }

    public void a(List<Object> list) {
        this.f56803e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56803e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56803e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56803e.size()) {
            return null;
        }
        return this.f56803e.get(i2);
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
        C1405a c1405a;
        Object item = getItem(i2);
        if (view != null) {
            c1405a = (C1405a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f56804f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1405a = new C1405a();
            c1405a.f56806a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1405a);
        } else {
            view = LayoutInflater.from(this.f56804f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1405a = new C1405a();
            c1405a.f56807b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1405a.f56808c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1405a.f56809d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1405a.f56810e = view.findViewById(R.id.divider_line);
            view.setTag(c1405a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1405a.f56806a.setText(item.toString());
            } else {
                List list = (List) item;
                c1405a.f56807b.e((DressItemData) list.get(0));
                c1405a.f56807b.setController(this.f56805g);
                if (list.size() > 2) {
                    c1405a.f56808c.e((DressItemData) list.get(1));
                    c1405a.f56809d.e((DressItemData) list.get(2));
                    c1405a.f56808c.setController(this.f56805g);
                    c1405a.f56809d.setController(this.f56805g);
                } else if (list.size() > 1) {
                    c1405a.f56808c.e((DressItemData) list.get(1));
                    c1405a.f56808c.setController(this.f56805g);
                    c1405a.f56809d.f();
                } else {
                    c1405a.f56808c.f();
                    c1405a.f56809d.f();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1405a.f56810e.setVisibility(8);
                } else {
                    c1405a.f56810e.setVisibility(0);
                }
            }
        }
        this.f56804f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
