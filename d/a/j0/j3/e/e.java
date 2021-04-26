package d.a.j0.j3.e;

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
    public List<List<DressItemData>> f56120e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56121f;

    /* renamed from: g  reason: collision with root package name */
    public d f56122g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f56123a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56124b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56125c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56126d;

        public a(e eVar) {
        }
    }

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.f56121f = tbPageContext;
        this.f56122g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f56120e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f56120e.size()) {
            return null;
        }
        return this.f56120e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56120e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56120e;
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
            view = LayoutInflater.from(this.f56121f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a(this);
            aVar.f56123a = view.findViewById(R.id.top_white_line);
            aVar.f56124b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.f56125c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.f56126d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i2 == 0) {
                aVar.f56123a.setVisibility(0);
            } else {
                aVar.f56123a.setVisibility(8);
            }
            aVar.f56124b.e(item.get(0));
            aVar.f56124b.setController(this.f56122g);
            if (item.size() > 2) {
                aVar.f56125c.e(item.get(1));
                aVar.f56126d.e(item.get(2));
                aVar.f56125c.setController(this.f56122g);
                aVar.f56126d.setController(this.f56122g);
            } else if (item.size() > 1) {
                aVar.f56125c.e(item.get(1));
                aVar.f56125c.setController(this.f56122g);
                aVar.f56126d.f();
            } else {
                aVar.f56125c.f();
                aVar.f56126d.f();
            }
        }
        this.f56121f.getLayoutMode().j(view);
        return view;
    }
}
