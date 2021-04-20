package d.b.i0.j3.f.b;

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
    public List<Object> f57757e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57758f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.j3.f.a.a f57759g;

    /* renamed from: d.b.i0.j3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1372a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57760a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f57761b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f57762c;

        /* renamed from: d  reason: collision with root package name */
        public View f57763d;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.j3.f.a.a aVar) {
        this.f57758f = tbPageContext;
        this.f57759g = aVar;
    }

    public void a(List<Object> list) {
        this.f57757e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f57757e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f57757e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f57757e.size()) {
            return null;
        }
        return this.f57757e.get(i);
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
        C1372a c1372a;
        Object item = getItem(i);
        if (view != null) {
            c1372a = (C1372a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f57758f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1372a = new C1372a();
            c1372a.f57760a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1372a);
        } else {
            view = LayoutInflater.from(this.f57758f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1372a = new C1372a();
            c1372a.f57761b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1372a.f57762c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1372a.f57763d = view.findViewById(R.id.divider_line);
            view.setTag(c1372a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1372a.f57760a.setText(item.toString());
            } else {
                List list = (List) item;
                c1372a.f57761b.d((DressItemData) list.get(0));
                c1372a.f57761b.setController(this.f57759g);
                c1372a.f57761b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1372a.f57762c.d((DressItemData) list.get(1));
                    c1372a.f57762c.setController(this.f57759g);
                    c1372a.f57762c.setFromBubbleGroup(true);
                } else {
                    c1372a.f57762c.e();
                }
                if (getItem(i + 1) instanceof List) {
                    c1372a.f57763d.setVisibility(8);
                } else {
                    c1372a.f57763d.setVisibility(0);
                }
            }
        }
        this.f57758f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
