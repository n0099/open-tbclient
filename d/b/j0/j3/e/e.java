package d.b.j0.j3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f58134e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f58135f;

    /* renamed from: g  reason: collision with root package name */
    public d f58136g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f58137a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f58138b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f58139c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f58140d;

        public a(e eVar) {
        }
    }

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.f58135f = tbPageContext;
        this.f58136g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f58134e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f58134e.size()) {
            return null;
        }
        return this.f58134e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f58134e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f58134e;
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
        a aVar;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58135f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a(this);
            aVar.f58137a = view.findViewById(R.id.top_white_line);
            aVar.f58138b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.f58139c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.f58140d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.f58137a.setVisibility(0);
            } else {
                aVar.f58137a.setVisibility(8);
            }
            aVar.f58138b.e(item.get(0));
            aVar.f58138b.setController(this.f58136g);
            if (item.size() > 2) {
                aVar.f58139c.e(item.get(1));
                aVar.f58140d.e(item.get(2));
                aVar.f58139c.setController(this.f58136g);
                aVar.f58140d.setController(this.f58136g);
            } else if (item.size() > 1) {
                aVar.f58139c.e(item.get(1));
                aVar.f58139c.setController(this.f58136g);
                aVar.f58140d.f();
            } else {
                aVar.f58139c.f();
                aVar.f58140d.f();
            }
        }
        this.f58135f.getLayoutMode().j(view);
        return view;
    }
}
