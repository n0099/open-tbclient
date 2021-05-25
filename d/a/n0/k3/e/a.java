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
    public List<Object> f56983e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56984f;

    /* renamed from: g  reason: collision with root package name */
    public d f56985g;

    /* renamed from: d.a.n0.k3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1423a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56986a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56987b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56988c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56989d;

        /* renamed from: e  reason: collision with root package name */
        public View f56990e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f56984f = tbPageContext;
        this.f56985g = dVar;
    }

    public void a(List<Object> list) {
        this.f56983e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56983e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56983e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56983e.size()) {
            return null;
        }
        return this.f56983e.get(i2);
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
        C1423a c1423a;
        Object item = getItem(i2);
        if (view != null) {
            c1423a = (C1423a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f56984f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1423a = new C1423a();
            c1423a.f56986a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1423a);
        } else {
            view = LayoutInflater.from(this.f56984f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1423a = new C1423a();
            c1423a.f56987b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1423a.f56988c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1423a.f56989d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1423a.f56990e = view.findViewById(R.id.divider_line);
            view.setTag(c1423a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1423a.f56986a.setText(item.toString());
            } else {
                List list = (List) item;
                c1423a.f56987b.e((DressItemData) list.get(0));
                c1423a.f56987b.setController(this.f56985g);
                if (list.size() > 2) {
                    c1423a.f56988c.e((DressItemData) list.get(1));
                    c1423a.f56989d.e((DressItemData) list.get(2));
                    c1423a.f56988c.setController(this.f56985g);
                    c1423a.f56989d.setController(this.f56985g);
                } else if (list.size() > 1) {
                    c1423a.f56988c.e((DressItemData) list.get(1));
                    c1423a.f56988c.setController(this.f56985g);
                    c1423a.f56989d.f();
                } else {
                    c1423a.f56988c.f();
                    c1423a.f56989d.f();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1423a.f56990e.setVisibility(8);
                } else {
                    c1423a.f56990e.setVisibility(0);
                }
            }
        }
        this.f56984f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
