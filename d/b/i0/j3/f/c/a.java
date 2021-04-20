package d.b.i0.j3.f.c;

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
    public List<List<DressItemData>> f57775e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57776f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.j3.f.a.a f57777g;

    /* renamed from: d.b.i0.j3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1373a {

        /* renamed from: a  reason: collision with root package name */
        public View f57778a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f57779b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f57780c;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.j3.f.a.a aVar) {
        this.f57776f = tbPageContext;
        this.f57777g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f57775e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f57775e.size()) {
            return null;
        }
        return this.f57775e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f57775e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f57775e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1373a c1373a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c1373a = (C1373a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f57776f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1373a = new C1373a();
            c1373a.f57778a = view.findViewById(R.id.top_white_line);
            c1373a.f57779b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1373a.f57780c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1373a);
        }
        if (item != null) {
            if (i == 0) {
                c1373a.f57778a.setVisibility(0);
            } else {
                c1373a.f57778a.setVisibility(8);
            }
            c1373a.f57779b.d(item.get(0));
            c1373a.f57779b.setController(this.f57777g);
            c1373a.f57779b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1373a.f57780c.d(item.get(1));
                c1373a.f57780c.setController(this.f57777g);
                c1373a.f57780c.setFromBubbleGroup(false);
            } else {
                c1373a.f57780c.e();
            }
        }
        this.f57776f.getLayoutMode().j(view);
        return view;
    }
}
