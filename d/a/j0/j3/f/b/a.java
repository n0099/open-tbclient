package d.a.j0.j3.f.b;

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
    public List<Object> f56167e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56168f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.j3.f.a.a f56169g;

    /* renamed from: d.a.j0.j3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1334a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56170a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56171b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56172c;

        /* renamed from: d  reason: collision with root package name */
        public View f56173d;
    }

    public a(TbPageContext<?> tbPageContext, d.a.j0.j3.f.a.a aVar) {
        this.f56168f = tbPageContext;
        this.f56169g = aVar;
    }

    public void a(List<Object> list) {
        this.f56167e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56167e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56167e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56167e.size()) {
            return null;
        }
        return this.f56167e.get(i2);
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
        C1334a c1334a;
        Object item = getItem(i2);
        if (view != null) {
            c1334a = (C1334a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f56168f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1334a = new C1334a();
            c1334a.f56170a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1334a);
        } else {
            view = LayoutInflater.from(this.f56168f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1334a = new C1334a();
            c1334a.f56171b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1334a.f56172c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1334a.f56173d = view.findViewById(R.id.divider_line);
            view.setTag(c1334a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1334a.f56170a.setText(item.toString());
            } else {
                List list = (List) item;
                c1334a.f56171b.d((DressItemData) list.get(0));
                c1334a.f56171b.setController(this.f56169g);
                c1334a.f56171b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1334a.f56172c.d((DressItemData) list.get(1));
                    c1334a.f56172c.setController(this.f56169g);
                    c1334a.f56172c.setFromBubbleGroup(true);
                } else {
                    c1334a.f56172c.e();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1334a.f56173d.setVisibility(8);
                } else {
                    c1334a.f56173d.setVisibility(0);
                }
            }
        }
        this.f56168f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
