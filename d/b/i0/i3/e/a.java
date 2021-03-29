package d.b.i0.i3.e;

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
    public List<Object> f56243e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56244f;

    /* renamed from: g  reason: collision with root package name */
    public d f56245g;

    /* renamed from: d.b.i0.i3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1315a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56246a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56247b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56248c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56249d;

        /* renamed from: e  reason: collision with root package name */
        public View f56250e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f56244f = tbPageContext;
        this.f56245g = dVar;
    }

    public void a(List<Object> list) {
        this.f56243e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56243e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56243e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56243e.size()) {
            return null;
        }
        return this.f56243e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof List ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1315a c1315a;
        Object item = getItem(i);
        if (view != null) {
            c1315a = (C1315a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f56244f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1315a = new C1315a();
            c1315a.f56246a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1315a);
        } else {
            view = LayoutInflater.from(this.f56244f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1315a = new C1315a();
            c1315a.f56247b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1315a.f56248c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1315a.f56249d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1315a.f56250e = view.findViewById(R.id.divider_line);
            view.setTag(c1315a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1315a.f56246a.setText(item.toString());
            } else {
                List list = (List) item;
                c1315a.f56247b.e((DressItemData) list.get(0));
                c1315a.f56247b.setController(this.f56245g);
                if (list.size() > 2) {
                    c1315a.f56248c.e((DressItemData) list.get(1));
                    c1315a.f56249d.e((DressItemData) list.get(2));
                    c1315a.f56248c.setController(this.f56245g);
                    c1315a.f56249d.setController(this.f56245g);
                } else if (list.size() > 1) {
                    c1315a.f56248c.e((DressItemData) list.get(1));
                    c1315a.f56248c.setController(this.f56245g);
                    c1315a.f56249d.f();
                } else {
                    c1315a.f56248c.f();
                    c1315a.f56249d.f();
                }
                if (getItem(i + 1) instanceof List) {
                    c1315a.f56250e.setVisibility(8);
                } else {
                    c1315a.f56250e.setVisibility(0);
                }
            }
        }
        this.f56244f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
