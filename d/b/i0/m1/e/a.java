package d.b.i0.m1.e;

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
    public d.b.i0.m1.c.a f56856e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f56857f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56858g = false;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f56859h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56860a;

        /* renamed from: b  reason: collision with root package name */
        public View f56861b;

        public b(a aVar) {
        }
    }

    public a(SearchLocationActivity searchLocationActivity) {
        this.f56857f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        NoDataView a2 = NoDataViewFactory.a(this.f56857f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
        this.f56859h = a2;
        a2.f(this.f56857f.getPageContext(), skinType);
        this.f56859h.setVisibility(0);
        return this.f56859h;
    }

    public b b(View view) {
        b bVar = new b();
        bVar.f56860a = (TextView) view.findViewById(R.id.location_search_address_name);
        bVar.f56861b = view.findViewById(R.id.location_search_line);
        return bVar;
    }

    public boolean c() {
        return this.f56858g;
    }

    public void d(d.b.i0.m1.c.a aVar) {
        this.f56856e = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        d.b.i0.m1.c.a aVar = this.f56856e;
        if (aVar != null && aVar.a() != null && !this.f56856e.a().isEmpty()) {
            this.f56858g = true;
            return this.f56856e.a().size();
        }
        this.f56858g = false;
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        d.b.i0.m1.c.a aVar = this.f56856e;
        if (aVar == null || aVar.a() == null || this.f56856e.a().isEmpty()) {
            return null;
        }
        return this.f56856e.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f56858g) {
            return a(viewGroup);
        }
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.f56857f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            bVar = b(view);
            view.setTag(bVar);
        }
        bVar.f56860a.setText(this.f56856e.a().get(i).a());
        SkinManager.setBackgroundColor(bVar.f56861b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bVar.f56860a, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }
}
