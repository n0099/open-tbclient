package d.b.j0.j3.f.c;

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
    public List<List<DressItemData>> f58196e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f58197f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.j3.f.a.a f58198g;

    /* renamed from: d.b.j0.j3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1396a {

        /* renamed from: a  reason: collision with root package name */
        public View f58199a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f58200b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f58201c;
    }

    public a(TbPageContext<?> tbPageContext, d.b.j0.j3.f.a.a aVar) {
        this.f58197f = tbPageContext;
        this.f58198g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f58196e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f58196e.size()) {
            return null;
        }
        return this.f58196e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f58196e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f58196e;
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
        C1396a c1396a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c1396a = (C1396a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58197f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1396a = new C1396a();
            c1396a.f58199a = view.findViewById(R.id.top_white_line);
            c1396a.f58200b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1396a.f58201c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1396a);
        }
        if (item != null) {
            if (i == 0) {
                c1396a.f58199a.setVisibility(0);
            } else {
                c1396a.f58199a.setVisibility(8);
            }
            c1396a.f58200b.d(item.get(0));
            c1396a.f58200b.setController(this.f58198g);
            c1396a.f58200b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1396a.f58201c.d(item.get(1));
                c1396a.f58201c.setController(this.f58198g);
                c1396a.f58201c.setFromBubbleGroup(false);
            } else {
                c1396a.f58201c.e();
            }
        }
        this.f58197f.getLayoutMode().j(view);
        return view;
    }
}
