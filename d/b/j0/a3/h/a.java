package d.b.j0.a3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.j0.a3.j.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f53531e;

    /* renamed from: f  reason: collision with root package name */
    public int f53532f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1194a f53533g;

    /* renamed from: h  reason: collision with root package name */
    public Context f53534h;

    /* renamed from: d.b.j0.a3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1194a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f53535a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53536b;

        public C1194a(a aVar) {
        }
    }

    public a(Context context) {
        this.f53534h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f53534h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1194a c1194a = new C1194a(this);
        this.f53533g = c1194a;
        c1194a.f53535a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f53533g.f53536b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f53533g);
        return inflate;
    }

    public final void b(C1194a c1194a, d dVar, View view, int i) {
        if (c1194a == null || dVar == null) {
            return;
        }
        c1194a.f53536b.setText("");
        if (i == 0) {
            TextView textView = c1194a.f53536b;
            textView.setText(this.f53534h.getString(R.string.all) + dVar.f53583b);
        } else {
            c1194a.f53536b.setText(dVar.f53583b);
        }
        if (i != this.f53532f) {
            c1194a.f53535a.setVisibility(4);
            SkinManager.setViewTextColor(c1194a.f53536b, R.color.common_color_10200, 1);
            return;
        }
        c1194a.f53535a.setVisibility(0);
        SkinManager.setViewTextColor(c1194a.f53536b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f53531e;
    }

    public void d(int i) {
        this.f53532f = i;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f53531e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f53531e;
        if (dVar == null || (arrayList = dVar.f53586e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d> arrayList;
        d dVar = this.f53531e;
        if (dVar == null || (arrayList = dVar.f53586e) == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
        }
        d dVar = this.f53531e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f53586e.get(i);
        C1194a c1194a = (C1194a) view.getTag();
        this.f53533g = c1194a;
        if (dVar2 != null) {
            b(c1194a, dVar2, view, i);
        }
        return view;
    }
}
