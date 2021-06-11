package d.a.m0.u0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.m0.u0.a.b> f54496e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f54497f;
    public int j;
    public int k;
    public int l;

    /* renamed from: g  reason: collision with root package name */
    public int f54498g = -1;
    public int m = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f54499h = SkinManager.getColor(R.color.common_color_10043);

    /* renamed from: i  reason: collision with root package name */
    public int f54500i = SkinManager.getColor(R.color.CAM_X0302);

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f54501a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f54502b;

        public b(a aVar) {
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f54496e = null;
        this.f54497f = null;
        this.l = 0;
        this.f54497f = tbPageContext;
        this.f54496e = new ArrayList<>();
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = l.g(this.f54497f.getPageActivity(), R.dimen.ds4);
        this.l = l.g(this.f54497f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i2) {
        int i3 = i2 / 4;
        if (i3 == 0) {
            return 1;
        }
        return i3 == this.m - 1 ? 2 : 3;
    }

    public void b(int i2) {
        this.f54498g = i2;
    }

    public void c(ArrayList<d.a.m0.u0.a.b> arrayList) {
        this.f54496e = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.m = arrayList.size() / 4;
            } else {
                this.m = (arrayList.size() / 4) + 1;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.a.m0.u0.a.b> arrayList = this.f54496e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d.a.m0.u0.a.b> arrayList = this.f54496e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f54496e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 == this.f54498g ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f54497f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            bVar = new b();
            bVar.f54501a = (LinearLayout) view.findViewById(R.id.photo_container);
            bVar.f54502b = (TbImageView) view.findViewById(R.id.photo);
        } else {
            bVar = (b) view.getTag();
        }
        if (a(i2) == 1) {
            bVar.f54501a.setPadding(0, this.l, 0, 0);
        } else if (a(i2) == 2) {
            bVar.f54501a.setPadding(0, 0, 0, this.l);
        } else {
            bVar.f54501a.setPadding(0, 0, 0, 0);
        }
        bVar.f54502b.setDrawerType(0);
        bVar.f54502b.setBorderSurroundContent(true);
        bVar.f54502b.setDrawBorder(true);
        if (itemViewType == 0) {
            bVar.f54502b.setBorderColor(this.f54499h);
            bVar.f54502b.setBorderWidth(this.j);
        } else {
            bVar.f54502b.setBorderColor(this.f54500i);
            bVar.f54502b.setBorderWidth(this.k);
        }
        bVar.f54502b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f54502b.U(this.f54496e.get(i2).a(), 10, false);
        view.setTag(bVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
