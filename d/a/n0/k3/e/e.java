package d.a.n0.k3.e;

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
    public List<List<DressItemData>> f60696e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60697f;

    /* renamed from: g  reason: collision with root package name */
    public d f60698g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f60699a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f60700b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f60701c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f60702d;

        public a(e eVar) {
        }
    }

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.f60697f = tbPageContext;
        this.f60698g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f60696e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60696e.size()) {
            return null;
        }
        return this.f60696e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f60696e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f60696e;
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
        a aVar;
        List<DressItemData> item = getItem(i2);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60697f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a(this);
            aVar.f60699a = view.findViewById(R.id.top_white_line);
            aVar.f60700b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.f60701c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.f60702d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i2 == 0) {
                aVar.f60699a.setVisibility(0);
            } else {
                aVar.f60699a.setVisibility(8);
            }
            aVar.f60700b.e(item.get(0));
            aVar.f60700b.setController(this.f60698g);
            if (item.size() > 2) {
                aVar.f60701c.e(item.get(1));
                aVar.f60702d.e(item.get(2));
                aVar.f60701c.setController(this.f60698g);
                aVar.f60702d.setController(this.f60698g);
            } else if (item.size() > 1) {
                aVar.f60701c.e(item.get(1));
                aVar.f60701c.setController(this.f60698g);
                aVar.f60702d.f();
            } else {
                aVar.f60701c.f();
                aVar.f60702d.f();
            }
        }
        this.f60697f.getLayoutMode().j(view);
        return view;
    }
}
