package d.b.j0.n1.e;

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
    public d.b.j0.n1.c.a f58915e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f58916f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58917g = false;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58918h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58919a;

        /* renamed from: b  reason: collision with root package name */
        public View f58920b;

        public b(a aVar) {
        }
    }

    public a(SearchLocationActivity searchLocationActivity) {
        this.f58916f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        NoDataView a2 = NoDataViewFactory.a(this.f58916f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
        this.f58918h = a2;
        a2.f(this.f58916f.getPageContext(), skinType);
        this.f58918h.setVisibility(0);
        return this.f58918h;
    }

    public b b(View view) {
        b bVar = new b();
        bVar.f58919a = (TextView) view.findViewById(R.id.location_search_address_name);
        bVar.f58920b = view.findViewById(R.id.location_search_line);
        return bVar;
    }

    public boolean c() {
        return this.f58917g;
    }

    public void d(d.b.j0.n1.c.a aVar) {
        this.f58915e = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        d.b.j0.n1.c.a aVar = this.f58915e;
        if (aVar != null && aVar.a() != null && !this.f58915e.a().isEmpty()) {
            this.f58917g = true;
            return this.f58915e.a().size();
        }
        this.f58917g = false;
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        d.b.j0.n1.c.a aVar = this.f58915e;
        if (aVar == null || aVar.a() == null || this.f58915e.a().isEmpty()) {
            return null;
        }
        return this.f58915e.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f58917g) {
            return a(viewGroup);
        }
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.f58916f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            bVar = b(view);
            view.setTag(bVar);
        }
        bVar.f58919a.setText(this.f58915e.a().get(i).a());
        SkinManager.setBackgroundColor(bVar.f58920b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f58919a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }
}
