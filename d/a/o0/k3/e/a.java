package d.a.o0.k3.e;

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
    public List<Object> f60797e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60798f;

    /* renamed from: g  reason: collision with root package name */
    public d f60799g;

    /* renamed from: d.a.o0.k3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1483a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60800a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f60801b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f60802c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f60803d;

        /* renamed from: e  reason: collision with root package name */
        public View f60804e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f60798f = tbPageContext;
        this.f60799g = dVar;
    }

    public void a(List<Object> list) {
        this.f60797e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f60797e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f60797e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60797e.size()) {
            return null;
        }
        return this.f60797e.get(i2);
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
        C1483a c1483a;
        Object item = getItem(i2);
        if (view != null) {
            c1483a = (C1483a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f60798f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1483a = new C1483a();
            c1483a.f60800a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1483a);
        } else {
            view = LayoutInflater.from(this.f60798f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1483a = new C1483a();
            c1483a.f60801b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1483a.f60802c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1483a.f60803d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1483a.f60804e = view.findViewById(R.id.divider_line);
            view.setTag(c1483a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1483a.f60800a.setText(item.toString());
            } else {
                List list = (List) item;
                c1483a.f60801b.e((DressItemData) list.get(0));
                c1483a.f60801b.setController(this.f60799g);
                if (list.size() > 2) {
                    c1483a.f60802c.e((DressItemData) list.get(1));
                    c1483a.f60803d.e((DressItemData) list.get(2));
                    c1483a.f60802c.setController(this.f60799g);
                    c1483a.f60803d.setController(this.f60799g);
                } else if (list.size() > 1) {
                    c1483a.f60802c.e((DressItemData) list.get(1));
                    c1483a.f60802c.setController(this.f60799g);
                    c1483a.f60803d.f();
                } else {
                    c1483a.f60802c.f();
                    c1483a.f60803d.f();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1483a.f60804e.setVisibility(8);
                } else {
                    c1483a.f60804e.setVisibility(0);
                }
            }
        }
        this.f60798f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
