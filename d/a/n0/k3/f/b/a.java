package d.a.n0.k3.f.b;

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
    public List<Object> f57054e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57055f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k3.f.a.a f57056g;

    /* renamed from: d.a.n0.k3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1424a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57057a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f57058b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f57059c;

        /* renamed from: d  reason: collision with root package name */
        public View f57060d;
    }

    public a(TbPageContext<?> tbPageContext, d.a.n0.k3.f.a.a aVar) {
        this.f57055f = tbPageContext;
        this.f57056g = aVar;
    }

    public void a(List<Object> list) {
        this.f57054e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f57054e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f57054e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f57054e.size()) {
            return null;
        }
        return this.f57054e.get(i2);
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
        C1424a c1424a;
        Object item = getItem(i2);
        if (view != null) {
            c1424a = (C1424a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f57055f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1424a = new C1424a();
            c1424a.f57057a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1424a);
        } else {
            view = LayoutInflater.from(this.f57055f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1424a = new C1424a();
            c1424a.f57058b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1424a.f57059c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1424a.f57060d = view.findViewById(R.id.divider_line);
            view.setTag(c1424a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1424a.f57057a.setText(item.toString());
            } else {
                List list = (List) item;
                c1424a.f57058b.d((DressItemData) list.get(0));
                c1424a.f57058b.setController(this.f57056g);
                c1424a.f57058b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1424a.f57059c.d((DressItemData) list.get(1));
                    c1424a.f57059c.setController(this.f57056g);
                    c1424a.f57059c.setFromBubbleGroup(true);
                } else {
                    c1424a.f57059c.e();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1424a.f57060d.setVisibility(8);
                } else {
                    c1424a.f57060d.setVisibility(0);
                }
            }
        }
        this.f57055f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
