package d.a.n0.o1.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.location.selectpoi.SearchLocationActivity;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.o1.c.a f61500e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f61501f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61502g = false;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f61503h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61504a;

        /* renamed from: b  reason: collision with root package name */
        public View f61505b;

        public b(a aVar) {
        }
    }

    public a(SearchLocationActivity searchLocationActivity) {
        this.f61501f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        NoDataView a2 = NoDataViewFactory.a(this.f61501f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
        this.f61503h = a2;
        a2.f(this.f61501f.getPageContext(), skinType);
        this.f61503h.setVisibility(0);
        return this.f61503h;
    }

    public b b(View view) {
        b bVar = new b();
        bVar.f61504a = (TextView) view.findViewById(R.id.location_search_address_name);
        bVar.f61505b = view.findViewById(R.id.location_search_line);
        return bVar;
    }

    public boolean c() {
        return this.f61502g;
    }

    public void d(d.a.n0.o1.c.a aVar) {
        this.f61500e = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        d.a.n0.o1.c.a aVar = this.f61500e;
        if (aVar != null && aVar.a() != null && !this.f61500e.a().isEmpty()) {
            this.f61502g = true;
            return this.f61500e.a().size();
        }
        this.f61502g = false;
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        d.a.n0.o1.c.a aVar = this.f61500e;
        if (aVar == null || aVar.a() == null || this.f61500e.a().isEmpty()) {
            return null;
        }
        return this.f61500e.a().get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f61502g) {
            return a(viewGroup);
        }
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.f61501f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            bVar = b(view);
            view.setTag(bVar);
        }
        bVar.f61504a.setText(this.f61500e.a().get(i2).a());
        SkinManager.setBackgroundColor(bVar.f61505b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f61504a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }
}
