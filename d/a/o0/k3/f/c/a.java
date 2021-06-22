package d.a.o0.k3.f.c;

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
    public List<List<DressItemData>> f60887e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60888f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.k3.f.a.a f60889g;

    /* renamed from: d.a.o0.k3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1485a {

        /* renamed from: a  reason: collision with root package name */
        public View f60890a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f60891b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f60892c;
    }

    public a(TbPageContext<?> tbPageContext, d.a.o0.k3.f.a.a aVar) {
        this.f60888f = tbPageContext;
        this.f60889g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f60887e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60887e.size()) {
            return null;
        }
        return this.f60887e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f60887e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f60887e;
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
        C1485a c1485a;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            c1485a = (C1485a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60888f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1485a = new C1485a();
            c1485a.f60890a = view.findViewById(R.id.top_white_line);
            c1485a.f60891b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1485a.f60892c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1485a);
        }
        if (item != null) {
            if (i2 == 0) {
                c1485a.f60890a.setVisibility(0);
            } else {
                c1485a.f60890a.setVisibility(8);
            }
            c1485a.f60891b.d(item.get(0));
            c1485a.f60891b.setController(this.f60889g);
            c1485a.f60891b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1485a.f60892c.d(item.get(1));
                c1485a.f60892c.setController(this.f60889g);
                c1485a.f60892c.setFromBubbleGroup(false);
            } else {
                c1485a.f60892c.e();
            }
        }
        this.f60888f.getLayoutMode().j(view);
        return view;
    }
}
