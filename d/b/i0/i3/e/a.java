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
    public List<Object> f56242e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56243f;

    /* renamed from: g  reason: collision with root package name */
    public d f56244g;

    /* renamed from: d.b.i0.i3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1314a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56245a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56246b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56247c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56248d;

        /* renamed from: e  reason: collision with root package name */
        public View f56249e;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.f56243f = tbPageContext;
        this.f56244g = dVar;
    }

    public void a(List<Object> list) {
        this.f56242e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56242e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56242e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56242e.size()) {
            return null;
        }
        return this.f56242e.get(i);
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
        C1314a c1314a;
        Object item = getItem(i);
        if (view != null) {
            c1314a = (C1314a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f56243f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1314a = new C1314a();
            c1314a.f56245a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1314a);
        } else {
            view = LayoutInflater.from(this.f56243f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c1314a = new C1314a();
            c1314a.f56246b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c1314a.f56247c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c1314a.f56248d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c1314a.f56249e = view.findViewById(R.id.divider_line);
            view.setTag(c1314a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1314a.f56245a.setText(item.toString());
            } else {
                List list = (List) item;
                c1314a.f56246b.e((DressItemData) list.get(0));
                c1314a.f56246b.setController(this.f56244g);
                if (list.size() > 2) {
                    c1314a.f56247c.e((DressItemData) list.get(1));
                    c1314a.f56248d.e((DressItemData) list.get(2));
                    c1314a.f56247c.setController(this.f56244g);
                    c1314a.f56248d.setController(this.f56244g);
                } else if (list.size() > 1) {
                    c1314a.f56247c.e((DressItemData) list.get(1));
                    c1314a.f56247c.setController(this.f56244g);
                    c1314a.f56248d.f();
                } else {
                    c1314a.f56247c.f();
                    c1314a.f56248d.f();
                }
                if (getItem(i + 1) instanceof List) {
                    c1314a.f56249e.setVisibility(8);
                } else {
                    c1314a.f56249e.setVisibility(0);
                }
            }
        }
        this.f56243f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
