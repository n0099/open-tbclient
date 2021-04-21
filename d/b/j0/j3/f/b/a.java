package d.b.j0.j3.f.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f58178e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f58179f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.j3.f.a.a f58180g;

    /* renamed from: d.b.j0.j3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1395a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58181a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f58182b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f58183c;

        /* renamed from: d  reason: collision with root package name */
        public View f58184d;
    }

    public a(TbPageContext<?> tbPageContext, d.b.j0.j3.f.a.a aVar) {
        this.f58179f = tbPageContext;
        this.f58180g = aVar;
    }

    public void a(List<Object> list) {
        this.f58178e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f58178e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f58178e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f58178e.size()) {
            return null;
        }
        return this.f58178e.get(i);
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
        C1395a c1395a;
        Object item = getItem(i);
        if (view != null) {
            c1395a = (C1395a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f58179f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1395a = new C1395a();
            c1395a.f58181a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1395a);
        } else {
            view = LayoutInflater.from(this.f58179f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1395a = new C1395a();
            c1395a.f58182b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1395a.f58183c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1395a.f58184d = view.findViewById(R.id.divider_line);
            view.setTag(c1395a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1395a.f58181a.setText(item.toString());
            } else {
                List list = (List) item;
                c1395a.f58182b.d((DressItemData) list.get(0));
                c1395a.f58182b.setController(this.f58180g);
                c1395a.f58182b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1395a.f58183c.d((DressItemData) list.get(1));
                    c1395a.f58183c.setController(this.f58180g);
                    c1395a.f58183c.setFromBubbleGroup(true);
                } else {
                    c1395a.f58183c.e();
                }
                if (getItem(i + 1) instanceof List) {
                    c1395a.f58184d.setVisibility(8);
                } else {
                    c1395a.f58184d.setVisibility(0);
                }
            }
        }
        this.f58179f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
