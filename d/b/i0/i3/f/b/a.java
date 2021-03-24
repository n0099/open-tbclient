package d.b.i0.i3.f.b;

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
    public List<Object> f56309e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56310f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i3.f.a.a f56311g;

    /* renamed from: d.b.i0.i3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1315a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56312a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56313b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56314c;

        /* renamed from: d  reason: collision with root package name */
        public View f56315d;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.i3.f.a.a aVar) {
        this.f56310f = tbPageContext;
        this.f56311g = aVar;
    }

    public void a(List<Object> list) {
        this.f56309e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56309e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56309e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56309e.size()) {
            return null;
        }
        return this.f56309e.get(i);
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
        C1315a c1315a;
        Object item = getItem(i);
        if (view != null) {
            c1315a = (C1315a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f56310f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1315a = new C1315a();
            c1315a.f56312a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1315a);
        } else {
            view = LayoutInflater.from(this.f56310f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1315a = new C1315a();
            c1315a.f56313b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1315a.f56314c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1315a.f56315d = view.findViewById(R.id.divider_line);
            view.setTag(c1315a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1315a.f56312a.setText(item.toString());
            } else {
                List list = (List) item;
                c1315a.f56313b.d((DressItemData) list.get(0));
                c1315a.f56313b.setController(this.f56311g);
                c1315a.f56313b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1315a.f56314c.d((DressItemData) list.get(1));
                    c1315a.f56314c.setController(this.f56311g);
                    c1315a.f56314c.setFromBubbleGroup(true);
                } else {
                    c1315a.f56314c.e();
                }
                if (getItem(i + 1) instanceof List) {
                    c1315a.f56315d.setVisibility(8);
                } else {
                    c1315a.f56315d.setVisibility(0);
                }
            }
        }
        this.f56310f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
