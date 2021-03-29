package d.b.i0.i3.e;

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
    public List<List<DressItemData>> f56266e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56267f;

    /* renamed from: g  reason: collision with root package name */
    public d f56268g;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f56269a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f56270b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f56271c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f56272d;

        public a(e eVar) {
        }
    }

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.f56267f = tbPageContext;
        this.f56268g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        List<List<DressItemData>> list = this.f56266e;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.f56266e.size()) {
            return null;
        }
        return this.f56266e.get(i);
    }

    public void b(List<List<DressItemData>> list) {
        this.f56266e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<DressItemData>> list = this.f56266e;
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
            view = LayoutInflater.from(this.f56267f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a(this);
            aVar.f56269a = view.findViewById(R.id.top_white_line);
            aVar.f56270b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.f56271c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.f56272d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.f56269a.setVisibility(0);
            } else {
                aVar.f56269a.setVisibility(8);
            }
            aVar.f56270b.e(item.get(0));
            aVar.f56270b.setController(this.f56268g);
            if (item.size() > 2) {
                aVar.f56271c.e(item.get(1));
                aVar.f56272d.e(item.get(2));
                aVar.f56271c.setController(this.f56268g);
                aVar.f56272d.setController(this.f56268g);
            } else if (item.size() > 1) {
                aVar.f56271c.e(item.get(1));
                aVar.f56271c.setController(this.f56268g);
                aVar.f56272d.f();
            } else {
                aVar.f56271c.f();
                aVar.f56272d.f();
            }
        }
        this.f56267f.getLayoutMode().j(view);
        return view;
    }
}
