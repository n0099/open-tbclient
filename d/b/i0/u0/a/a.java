package d.b.i0.u0.a;

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
    public ArrayList<d.b.i0.u0.a.b> f52257e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f52258f;
    public int j;
    public int k;
    public int l;

    /* renamed from: g  reason: collision with root package name */
    public int f52259g = -1;
    public int m = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f52260h = SkinManager.getColor(R.color.common_color_10043);
    public int i = SkinManager.getColor(R.color.CAM_X0302);

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f52261a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f52262b;

        public b(a aVar) {
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f52257e = null;
        this.f52258f = null;
        this.l = 0;
        this.f52258f = tbPageContext;
        this.f52257e = new ArrayList<>();
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = l.g(this.f52258f.getPageActivity(), R.dimen.ds4);
        this.l = l.g(this.f52258f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i) {
        int i2 = i / 4;
        if (i2 == 0) {
            return 1;
        }
        return i2 == this.m - 1 ? 2 : 3;
    }

    public void b(int i) {
        this.f52259g = i;
    }

    public void c(ArrayList<d.b.i0.u0.a.b> arrayList) {
        this.f52257e = arrayList;
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
        ArrayList<d.b.i0.u0.a.b> arrayList = this.f52257e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d.b.i0.u0.a.b> arrayList = this.f52257e;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f52257e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.f52259g ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.f52258f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            bVar = new b();
            bVar.f52261a = (LinearLayout) view.findViewById(R.id.photo_container);
            bVar.f52262b = (TbImageView) view.findViewById(R.id.photo);
        } else {
            bVar = (b) view.getTag();
        }
        if (a(i) == 1) {
            bVar.f52261a.setPadding(0, this.l, 0, 0);
        } else if (a(i) == 2) {
            bVar.f52261a.setPadding(0, 0, 0, this.l);
        } else {
            bVar.f52261a.setPadding(0, 0, 0, 0);
        }
        bVar.f52262b.setDrawerType(0);
        bVar.f52262b.setBorderSurroundContent(true);
        bVar.f52262b.setDrawBorder(true);
        if (itemViewType == 0) {
            bVar.f52262b.setBorderColor(this.f52260h);
            bVar.f52262b.setBorderWidth(this.j);
        } else {
            bVar.f52262b.setBorderColor(this.i);
            bVar.f52262b.setBorderWidth(this.k);
        }
        bVar.f52262b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f52262b.W(this.f52257e.get(i).a(), 10, false);
        view.setTag(bVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
