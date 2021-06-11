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
    public List<List<DressItemData>> f60762e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60763f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k3.f.a.a f60764g;

    /* renamed from: d.a.n0.k3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1481a {

        /* renamed from: a  reason: collision with root package name */
        public View f60765a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f60766b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f60767c;
    }

    public a(TbPageContext<?> tbPageContext, d.a.n0.k3.f.a.a aVar) {
        this.f60763f = tbPageContext;
        this.f60764g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f60762e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60762e.size()) {
            return null;
        }
        return this.f60762e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f60762e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f60762e;
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
        C1481a c1481a;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            c1481a = (C1481a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60763f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1481a = new C1481a();
            c1481a.f60765a = view.findViewById(R.id.top_white_line);
            c1481a.f60766b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1481a.f60767c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1481a);
        }
        if (item != null) {
            if (i2 == 0) {
                c1481a.f60765a.setVisibility(0);
            } else {
                c1481a.f60765a.setVisibility(8);
            }
            c1481a.f60766b.d(item.get(0));
            c1481a.f60766b.setController(this.f60764g);
            c1481a.f60766b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1481a.f60767c.d(item.get(1));
                c1481a.f60767c.setController(this.f60764g);
                c1481a.f60767c.setFromBubbleGroup(false);
            } else {
                c1481a.f60767c.e();
            }
        }
        this.f60763f.getLayoutMode().j(view);
        return view;
    }
}
