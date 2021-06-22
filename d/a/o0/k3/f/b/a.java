package d.a.o0.k3.f.b;

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
    public List<Object> f60868e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60869f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.k3.f.a.a f60870g;

    /* renamed from: d.a.o0.k3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1484a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60871a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f60872b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f60873c;

        /* renamed from: d  reason: collision with root package name */
        public View f60874d;
    }

    public a(TbPageContext<?> tbPageContext, d.a.o0.k3.f.a.a aVar) {
        this.f60869f = tbPageContext;
        this.f60870g = aVar;
    }

    public void a(List<Object> list) {
        this.f60868e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f60868e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f60868e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60868e.size()) {
            return null;
        }
        return this.f60868e.get(i2);
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
        C1484a c1484a;
        Object item = getItem(i2);
        if (view != null) {
            c1484a = (C1484a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f60869f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1484a = new C1484a();
            c1484a.f60871a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1484a);
        } else {
            view = LayoutInflater.from(this.f60869f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1484a = new C1484a();
            c1484a.f60872b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1484a.f60873c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1484a.f60874d = view.findViewById(R.id.divider_line);
            view.setTag(c1484a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1484a.f60871a.setText(item.toString());
            } else {
                List list = (List) item;
                c1484a.f60872b.d((DressItemData) list.get(0));
                c1484a.f60872b.setController(this.f60870g);
                c1484a.f60872b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1484a.f60873c.d((DressItemData) list.get(1));
                    c1484a.f60873c.setController(this.f60870g);
                    c1484a.f60873c.setFromBubbleGroup(true);
                } else {
                    c1484a.f60873c.e();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1484a.f60874d.setVisibility(8);
                } else {
                    c1484a.f60874d.setVisibility(0);
                }
            }
        }
        this.f60869f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
