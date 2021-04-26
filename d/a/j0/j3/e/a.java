package d.a.j0.j3.e;

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
    public List<Object> f56096e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56097f;

    /* renamed from: g  reason: collision with root package name */
    public d f56098g;

    /* renamed from: d.a.j0.j3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1333a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56099a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56100b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56101c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56102d;

        /* renamed from: e  reason: collision with root package name */
        public View f56103e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f56097f = tbPageContext;
        this.f56098g = dVar;
    }

    public void a(List<Object> list) {
        this.f56096e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56096e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56096e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56096e.size()) {
            return null;
        }
        return this.f56096e.get(i2);
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
        C1333a c1333a;
        Object item = getItem(i2);
        if (view != null) {
            c1333a = (C1333a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f56097f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1333a = new C1333a();
            c1333a.f56099a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1333a);
        } else {
            view = LayoutInflater.from(this.f56097f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1333a = new C1333a();
            c1333a.f56100b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1333a.f56101c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1333a.f56102d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1333a.f56103e = view.findViewById(R.id.divider_line);
            view.setTag(c1333a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1333a.f56099a.setText(item.toString());
            } else {
                List list = (List) item;
                c1333a.f56100b.e((DressItemData) list.get(0));
                c1333a.f56100b.setController(this.f56098g);
                if (list.size() > 2) {
                    c1333a.f56101c.e((DressItemData) list.get(1));
                    c1333a.f56102d.e((DressItemData) list.get(2));
                    c1333a.f56101c.setController(this.f56098g);
                    c1333a.f56102d.setController(this.f56098g);
                } else if (list.size() > 1) {
                    c1333a.f56101c.e((DressItemData) list.get(1));
                    c1333a.f56101c.setController(this.f56098g);
                    c1333a.f56102d.f();
                } else {
                    c1333a.f56101c.f();
                    c1333a.f56102d.f();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1333a.f56103e.setVisibility(8);
                } else {
                    c1333a.f56103e.setVisibility(0);
                }
            }
        }
        this.f56097f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
