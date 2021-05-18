package d.a.k0.j3.f.b;

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
    public List<Object> f56874e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56875f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.j3.f.a.a f56876g;

    /* renamed from: d.a.k0.j3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1406a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56877a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56878b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56879c;

        /* renamed from: d  reason: collision with root package name */
        public View f56880d;
    }

    public a(TbPageContext<?> tbPageContext, d.a.k0.j3.f.a.a aVar) {
        this.f56875f = tbPageContext;
        this.f56876g = aVar;
    }

    public void a(List<Object> list) {
        this.f56874e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Object> list = this.f56874e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<Object> list = this.f56874e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56874e.size()) {
            return null;
        }
        return this.f56874e.get(i2);
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
        C1406a c1406a;
        Object item = getItem(i2);
        if (view != null) {
            c1406a = (C1406a) view.getTag();
        } else if (getItemViewType(i2) == 0) {
            view = LayoutInflater.from(this.f56875f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c1406a = new C1406a();
            c1406a.f56877a = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c1406a);
        } else {
            view = LayoutInflater.from(this.f56875f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1406a = new C1406a();
            c1406a.f56878b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1406a.f56879c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c1406a.f56880d = view.findViewById(R.id.divider_line);
            view.setTag(c1406a);
        }
        if (item != null) {
            if (getItemViewType(i2) == 0) {
                c1406a.f56877a.setText(item.toString());
            } else {
                List list = (List) item;
                c1406a.f56878b.d((DressItemData) list.get(0));
                c1406a.f56878b.setController(this.f56876g);
                c1406a.f56878b.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c1406a.f56879c.d((DressItemData) list.get(1));
                    c1406a.f56879c.setController(this.f56876g);
                    c1406a.f56879c.setFromBubbleGroup(true);
                } else {
                    c1406a.f56879c.e();
                }
                if (getItem(i2 + 1) instanceof List) {
                    c1406a.f56880d.setVisibility(8);
                } else {
                    c1406a.f56880d.setVisibility(0);
                }
            }
        }
        this.f56875f.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
