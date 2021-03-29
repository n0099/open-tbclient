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
    public List<Object> f56310e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56311f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i3.f.a.a f56312g;

    /* renamed from: d.b.i0.i3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1316a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56313a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56314b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56315c;

        /* renamed from: d  reason: collision with root package name */
        public View f56316d;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.i3.f.a.a aVar) {
        this.f56311f = tbPageContext;
        this.f56312g = aVar;
    }

    public void a(List<Object> list) {
        this.f56310e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56310e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<Object> list = this.f56310e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56310e.size()) {
            return null;
        }
        return this.f56310e.get(i);
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
        C1316a c1316a;
        Object item = getItem(i);
        if (view != null) {
            c1316a = (C1316a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.f56311f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1316a = new C1316a();
            c1316a.f56313a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1316a);
        } else {
            view = LayoutInflater.from(this.f56311f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1316a = new C1316a();
            c1316a.f56314b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1316a.f56315c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1316a.f56316d = view.findViewById(R.id.divider_line);
            view.setTag(c1316a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c1316a.f56313a.setText(item.toString());
            } else {
                List list = (List) item;
                c1316a.f56314b.d((DressItemData) list.get(0));
                c1316a.f56314b.setController(this.f56312g);
                c1316a.f56314b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1316a.f56315c.d((DressItemData) list.get(1));
                    c1316a.f56315c.setController(this.f56312g);
                    c1316a.f56315c.setFromBubbleGroup(true);
                } else {
                    c1316a.f56315c.e();
                }
                if (getItem(i + 1) instanceof List) {
                    c1316a.f56316d.setVisibility(8);
                } else {
                    c1316a.f56316d.setVisibility(0);
                }
            }
        }
        this.f56311f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
