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
    public List<List<DressItemData>> f57007e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f57008f;

    /* renamed from: g  reason: collision with root package name */
    public d f57009g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f57010a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f57011b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f57012c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f57013d;

        public a(e eVar) {
        }
    }

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.f57008f = tbPageContext;
        this.f57009g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        List<List<DressItemData>> list = this.f57007e;
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f57007e.size()) {
            return null;
        }
        return this.f57007e.get(i2);
    }

    public void b(List<List<DressItemData>> list) {
        this.f57007e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f57007e;
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
            view = LayoutInflater.from(this.f57008f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a(this);
            aVar.f57010a = view.findViewById(R.id.top_white_line);
            aVar.f57011b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.f57012c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.f57013d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i2 == 0) {
                aVar.f57010a.setVisibility(0);
            } else {
                aVar.f57010a.setVisibility(8);
            }
            aVar.f57011b.e(item.get(0));
            aVar.f57011b.setController(this.f57009g);
            if (item.size() > 2) {
                aVar.f57012c.e(item.get(1));
                aVar.f57013d.e(item.get(2));
                aVar.f57012c.setController(this.f57009g);
                aVar.f57013d.setController(this.f57009g);
            } else if (item.size() > 1) {
                aVar.f57012c.e(item.get(1));
                aVar.f57012c.setController(this.f57009g);
                aVar.f57013d.f();
            } else {
                aVar.f57012c.f();
                aVar.f57013d.f();
            }
        }
        this.f57008f.getLayoutMode().j(view);
        return view;
    }
}
