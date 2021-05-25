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
    public d.a.n0.o1.c.a f57811e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f57812f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57813g = false;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f57814h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57815a;

        /* renamed from: b  reason: collision with root package name */
        public View f57816b;

        public b(a aVar) {
        }
    }

    public a(SearchLocationActivity searchLocationActivity) {
        this.f57812f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        NoDataView a2 = NoDataViewFactory.a(this.f57812f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
        this.f57814h = a2;
        a2.f(this.f57812f.getPageContext(), skinType);
        this.f57814h.setVisibility(0);
        return this.f57814h;
    }

    public b b(View view) {
        b bVar = new b();
        bVar.f57815a = (TextView) view.findViewById(R.id.location_search_address_name);
        bVar.f57816b = view.findViewById(R.id.location_search_line);
        return bVar;
    }

    public boolean c() {
        return this.f57813g;
    }

    public void d(d.a.n0.o1.c.a aVar) {
        this.f57811e = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        d.a.n0.o1.c.a aVar = this.f57811e;
        if (aVar != null && aVar.a() != null && !this.f57811e.a().isEmpty()) {
            this.f57813g = true;
            return this.f57811e.a().size();
        }
        this.f57813g = false;
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        d.a.n0.o1.c.a aVar = this.f57811e;
        if (aVar == null || aVar.a() == null || this.f57811e.a().isEmpty()) {
            return null;
        }
        return this.f57811e.a().get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f57813g) {
            return a(viewGroup);
        }
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.f57812f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            bVar = b(view);
            view.setTag(bVar);
        }
        bVar.f57815a.setText(this.f57811e.a().get(i2).a());
        SkinManager.setBackgroundColor(bVar.f57816b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f57815a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }
}
