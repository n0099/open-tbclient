package d.b.h0.u0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.h0.u0.a.b> f51921e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f51922f;
    public int j;
    public int k;
    public int l;

    /* renamed from: g  reason: collision with root package name */
    public int f51923g = -1;
    public int m = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f51924h = SkinManager.getColor(R.color.common_color_10043);
    public int i = SkinManager.getColor(R.color.CAM_X0302);

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f51925a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f51926b;

        public b(a aVar) {
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f51921e = null;
        this.f51922f = null;
        this.l = 0;
        this.f51922f = tbPageContext;
        this.f51921e = new ArrayList<>();
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = l.g(this.f51922f.getPageActivity(), R.dimen.ds4);
        this.l = l.g(this.f51922f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i) {
        int i2 = i / 4;
        if (i2 == 0) {
            return 1;
        }
        return i2 == this.m - 1 ? 2 : 3;
    }

    public void b(int i) {
        this.f51923g = i;
    }

    public void c(ArrayList<d.b.h0.u0.a.b> arrayList) {
        this.f51921e = arrayList;
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
        ArrayList<d.b.h0.u0.a.b> arrayList = this.f51921e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d.b.h0.u0.a.b> arrayList = this.f51921e;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f51921e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.f51923g ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.f51922f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            bVar = new b();
            bVar.f51925a = (LinearLayout) view.findViewById(R.id.photo_container);
            bVar.f51926b = (TbImageView) view.findViewById(R.id.photo);
        } else {
            bVar = (b) view.getTag();
        }
        if (a(i) == 1) {
            bVar.f51925a.setPadding(0, this.l, 0, 0);
        } else if (a(i) == 2) {
            bVar.f51925a.setPadding(0, 0, 0, this.l);
        } else {
            bVar.f51925a.setPadding(0, 0, 0, 0);
        }
        bVar.f51926b.setDrawerType(0);
        bVar.f51926b.setBorderSurroundContent(true);
        bVar.f51926b.setDrawBorder(true);
        if (itemViewType == 0) {
            bVar.f51926b.setBorderColor(this.f51924h);
            bVar.f51926b.setBorderWidth(this.j);
        } else {
            bVar.f51926b.setBorderColor(this.i);
            bVar.f51926b.setBorderWidth(this.k);
        }
        bVar.f51926b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f51926b.W(this.f51921e.get(i).a(), 10, false);
        view.setTag(bVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
