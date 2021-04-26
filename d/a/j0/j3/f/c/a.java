package d.a.j0.j3.f.c;

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
    public List<List<DressItemData>> f56186e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56187f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.j3.f.a.a f56188g;

    /* renamed from: d.a.j0.j3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1335a {

        /* renamed from: a  reason: collision with root package name */
        public View f56189a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f56190b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f56191c;
    }

    public a(TbPageContext<?> tbPageContext, d.a.j0.j3.f.a.a aVar) {
        this.f56187f = tbPageContext;
        this.f56188g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f56186e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56186e.size()) {
            return null;
        }
        return this.f56186e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56186e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56186e;
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
        C1335a c1335a;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            c1335a = (C1335a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f56187f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c1335a = new C1335a();
            c1335a.f56189a = view.findViewById(R.id.top_white_line);
            c1335a.f56190b = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c1335a.f56191c = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c1335a);
        }
        if (item != null) {
            if (i2 == 0) {
                c1335a.f56189a.setVisibility(0);
            } else {
                c1335a.f56189a.setVisibility(8);
            }
            c1335a.f56190b.d(item.get(0));
            c1335a.f56190b.setController(this.f56188g);
            c1335a.f56190b.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c1335a.f56191c.d(item.get(1));
                c1335a.f56191c.setController(this.f56188g);
                c1335a.f56191c.setFromBubbleGroup(false);
            } else {
                c1335a.f56191c.e();
            }
        }
        this.f56187f.getLayoutMode().j(view);
        return view;
    }
}
