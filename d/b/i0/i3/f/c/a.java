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
    public List<List<DressItemData>> f56327e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56328f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i3.f.a.a f56329g;

    /* renamed from: d.b.i0.i3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1316a {

        /* renamed from: a  reason: collision with root package name */
        public View f56330a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56331b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56332c;
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.i3.f.a.a aVar) {
        this.f56328f = tbPageContext;
        this.f56329g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f56327e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56327e.size()) {
            return null;
        }
        return this.f56327e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56327e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56327e;
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
        C1316a c1316a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c1316a = (C1316a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56328f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1316a = new C1316a();
            c1316a.f56330a = view.findViewById(R.id.top_white_line);
            c1316a.f56331b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1316a.f56332c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1316a);
        }
        if (item != null) {
            if (i == 0) {
                c1316a.f56330a.setVisibility(0);
            } else {
                c1316a.f56330a.setVisibility(8);
            }
            c1316a.f56331b.d(item.get(0));
            c1316a.f56331b.setController(this.f56329g);
            c1316a.f56331b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1316a.f56332c.d(item.get(1));
                c1316a.f56332c.setController(this.f56329g);
                c1316a.f56332c.setFromBubbleGroup(false);
            } else {
                c1316a.f56332c.e();
            }
        }
        this.f56328f.getLayoutMode().j(view);
        return view;
    }
}
