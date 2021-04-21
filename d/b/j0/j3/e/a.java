package d.b.j0.j3.e;

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
    public List<Object> f58111e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f58112f;

    /* renamed from: g  reason: collision with root package name */
    public d f58113g;

    /* renamed from: d.b.j0.j3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1394a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58114a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f58115b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f58116c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f58117d;

        /* renamed from: e  reason: collision with root package name */
        public View f58118e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f58112f = tbPageContext;
        this.f58113g = dVar;
    }

    public void a(List<Object> list) {
        this.f58111e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f58111e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f58111e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f58111e.size()) {
            return null;
        }
        return this.f58111e.get(i);
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
        C1394a c1394a;
        Object item = getItem(i);
        if (view != null) {
            c1394a = (C1394a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f58112f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1394a = new C1394a();
            c1394a.f58114a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1394a);
        } else {
            view = LayoutInflater.from(this.f58112f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1394a = new C1394a();
            c1394a.f58115b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1394a.f58116c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1394a.f58117d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1394a.f58118e = view.findViewById(R.id.divider_line);
            view.setTag(c1394a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1394a.f58114a.setText(item.toString());
            } else {
                List list = (List) item;
                c1394a.f58115b.e((DressItemData) list.get(0));
                c1394a.f58115b.setController(this.f58113g);
                if (list.size() > 2) {
                    c1394a.f58116c.e((DressItemData) list.get(1));
                    c1394a.f58117d.e((DressItemData) list.get(2));
                    c1394a.f58116c.setController(this.f58113g);
                    c1394a.f58117d.setController(this.f58113g);
                } else if (list.size() > 1) {
                    c1394a.f58116c.e((DressItemData) list.get(1));
                    c1394a.f58116c.setController(this.f58113g);
                    c1394a.f58117d.f();
                } else {
                    c1394a.f58116c.f();
                    c1394a.f58117d.f();
                }
                if (getItem(i + 1) instanceof List) {
                    c1394a.f58118e.setVisibility(8);
                } else {
                    c1394a.f58118e.setVisibility(0);
                }
            }
        }
        this.f58112f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
