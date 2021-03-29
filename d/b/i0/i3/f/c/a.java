package d.b.i0.i3.f.c;

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
    public List<List<DressItemData>> f56328e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56329f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i3.f.a.a f56330g;

    /* renamed from: d.b.i0.i3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1317a {

        /* renamed from: a  reason: collision with root package name */
        public View f56331a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56332b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56333c;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.i3.f.a.a aVar) {
        this.f56329f = tbPageContext;
        this.f56330g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f56328e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56328e.size()) {
            return null;
        }
        return this.f56328e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56328e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56328e;
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
        C1317a c1317a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c1317a = (C1317a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56329f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1317a = new C1317a();
            c1317a.f56331a = view.findViewById(R.id.top_white_line);
            c1317a.f56332b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1317a.f56333c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1317a);
        }
        if (item != null) {
            if (i == 0) {
                c1317a.f56331a.setVisibility(0);
            } else {
                c1317a.f56331a.setVisibility(8);
            }
            c1317a.f56332b.d(item.get(0));
            c1317a.f56332b.setController(this.f56330g);
            c1317a.f56332b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1317a.f56333c.d(item.get(1));
                c1317a.f56333c.setController(this.f56330g);
                c1317a.f56333c.setFromBubbleGroup(false);
            } else {
                c1317a.f56333c.e();
            }
        }
        this.f56329f.getLayoutMode().j(view);
        return view;
    }
}
