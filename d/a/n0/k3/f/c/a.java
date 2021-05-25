package d.a.n0.k3.f.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f57073e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57074f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k3.f.a.a f57075g;

    /* renamed from: d.a.n0.k3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1425a {

        /* renamed from: a  reason: collision with root package name */
        public View f57076a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f57077b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f57078c;
    }

    public a(TbPageContext<?> tbPageContext, d.a.n0.k3.f.a.a aVar) {
        this.f57074f = tbPageContext;
        this.f57075g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f57073e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f57073e.size()) {
            return null;
        }
        return this.f57073e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f57073e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f57073e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1425a c1425a;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            c1425a = (C1425a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f57074f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1425a = new C1425a();
            c1425a.f57076a = view.findViewById(R.id.top_white_line);
            c1425a.f57077b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1425a.f57078c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1425a);
        }
        if (item != null) {
            if (i2 == 0) {
                c1425a.f57076a.setVisibility(0);
            } else {
                c1425a.f57076a.setVisibility(8);
            }
            c1425a.f57077b.d(item.get(0));
            c1425a.f57077b.setController(this.f57075g);
            c1425a.f57077b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1425a.f57078c.d(item.get(1));
                c1425a.f57078c.setController(this.f57075g);
                c1425a.f57078c.setFromBubbleGroup(false);
            } else {
                c1425a.f57078c.e();
            }
        }
        this.f57074f.getLayoutMode().j(view);
        return view;
    }
}
