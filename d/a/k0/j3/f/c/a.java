package d.a.k0.j3.f.c;

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
    public List<List<DressItemData>> f56893e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56894f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.j3.f.a.a f56895g;

    /* renamed from: d.a.k0.j3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1407a {

        /* renamed from: a  reason: collision with root package name */
        public View f56896a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56897b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56898c;
    }

    public a(TbPageContext<?> tbPageContext, d.a.k0.j3.f.a.a aVar) {
        this.f56894f = tbPageContext;
        this.f56895g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f56893e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56893e.size()) {
            return null;
        }
        return this.f56893e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56893e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56893e;
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
        C1407a c1407a;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            c1407a = (C1407a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56894f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1407a = new C1407a();
            c1407a.f56896a = view.findViewById(R.id.top_white_line);
            c1407a.f56897b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1407a.f56898c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1407a);
        }
        if (item != null) {
            if (i2 == 0) {
                c1407a.f56896a.setVisibility(0);
            } else {
                c1407a.f56896a.setVisibility(8);
            }
            c1407a.f56897b.d(item.get(0));
            c1407a.f56897b.setController(this.f56895g);
            c1407a.f56897b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1407a.f56898c.d(item.get(1));
                c1407a.f56898c.setController(this.f56895g);
                c1407a.f56898c.setFromBubbleGroup(false);
            } else {
                c1407a.f56898c.e();
            }
        }
        this.f56894f.getLayoutMode().j(view);
        return view;
    }
}
