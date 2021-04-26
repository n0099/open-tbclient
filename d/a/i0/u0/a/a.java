package d.a.i0.u0.a;

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
    public ArrayList<d.a.i0.u0.a.b> f49927e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f49928f;
    public int j;
    public int k;
    public int l;

    /* renamed from: g  reason: collision with root package name */
    public int f49929g = -1;
    public int m = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f49930h = SkinManager.getColor(R.color.common_color_10043);

    /* renamed from: i  reason: collision with root package name */
    public int f49931i = SkinManager.getColor(R.color.CAM_X0302);

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f49932a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f49933b;

        public b(a aVar) {
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f49927e = null;
        this.f49928f = null;
        this.l = 0;
        this.f49928f = tbPageContext;
        this.f49927e = new ArrayList<>();
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = l.g(this.f49928f.getPageActivity(), R.dimen.ds4);
        this.l = l.g(this.f49928f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i2) {
        int i3 = i2 / 4;
        if (i3 == 0) {
            return 1;
        }
        return i3 == this.m - 1 ? 2 : 3;
    }

    public void b(int i2) {
        this.f49929g = i2;
    }

    public void c(ArrayList<d.a.i0.u0.a.b> arrayList) {
        this.f49927e = arrayList;
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
        ArrayList<d.a.i0.u0.a.b> arrayList = this.f49927e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d.a.i0.u0.a.b> arrayList = this.f49927e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f49927e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 == this.f49929g ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i2);
        if (view == null) {
            view = LayoutInflater.from(this.f49928f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            bVar = new b();
            bVar.f49932a = (LinearLayout) view.findViewById(R.id.photo_container);
            bVar.f49933b = (TbImageView) view.findViewById(R.id.photo);
        } else {
            bVar = (b) view.getTag();
        }
        if (a(i2) == 1) {
            bVar.f49932a.setPadding(0, this.l, 0, 0);
        } else if (a(i2) == 2) {
            bVar.f49932a.setPadding(0, 0, 0, this.l);
        } else {
            bVar.f49932a.setPadding(0, 0, 0, 0);
        }
        bVar.f49933b.setDrawerType(0);
        bVar.f49933b.setBorderSurroundContent(true);
        bVar.f49933b.setDrawBorder(true);
        if (itemViewType == 0) {
            bVar.f49933b.setBorderColor(this.f49930h);
            bVar.f49933b.setBorderWidth(this.j);
        } else {
            bVar.f49933b.setBorderColor(this.f49931i);
            bVar.f49933b.setBorderWidth(this.k);
        }
        bVar.f49933b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f49933b.V(this.f49927e.get(i2).a(), 10, false);
        view.setTag(bVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
