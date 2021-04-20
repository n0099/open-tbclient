package d.b.i0.j3.e;

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
    public List<Object> f57690e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57691f;

    /* renamed from: g  reason: collision with root package name */
    public d f57692g;

    /* renamed from: d.b.i0.j3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1371a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57693a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f57694b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f57695c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f57696d;

        /* renamed from: e  reason: collision with root package name */
        public View f57697e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f57691f = tbPageContext;
        this.f57692g = dVar;
    }

    public void a(List<Object> list) {
        this.f57690e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f57690e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f57690e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f57690e.size()) {
            return null;
        }
        return this.f57690e.get(i);
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
        C1371a c1371a;
        Object item = getItem(i);
        if (view != null) {
            c1371a = (C1371a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f57691f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1371a = new C1371a();
            c1371a.f57693a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1371a);
        } else {
            view = LayoutInflater.from(this.f57691f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1371a = new C1371a();
            c1371a.f57694b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1371a.f57695c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1371a.f57696d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1371a.f57697e = view.findViewById(R.id.divider_line);
            view.setTag(c1371a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1371a.f57693a.setText(item.toString());
            } else {
                List list = (List) item;
                c1371a.f57694b.e((DressItemData) list.get(0));
                c1371a.f57694b.setController(this.f57692g);
                if (list.size() > 2) {
                    c1371a.f57695c.e((DressItemData) list.get(1));
                    c1371a.f57696d.e((DressItemData) list.get(2));
                    c1371a.f57695c.setController(this.f57692g);
                    c1371a.f57696d.setController(this.f57692g);
                } else if (list.size() > 1) {
                    c1371a.f57695c.e((DressItemData) list.get(1));
                    c1371a.f57695c.setController(this.f57692g);
                    c1371a.f57696d.f();
                } else {
                    c1371a.f57695c.f();
                    c1371a.f57696d.f();
                }
                if (getItem(i + 1) instanceof List) {
                    c1371a.f57697e.setVisibility(8);
                } else {
                    c1371a.f57697e.setVisibility(0);
                }
            }
        }
        this.f57691f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
