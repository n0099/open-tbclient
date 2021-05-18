package d.a.k0.a3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.k0.a3.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f51963e;

    /* renamed from: f  reason: collision with root package name */
    public int f51964f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1205a f51965g;

    /* renamed from: h  reason: collision with root package name */
    public Context f51966h;

    /* renamed from: d.a.k0.a3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1205a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f51967a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51968b;

        public C1205a(a aVar) {
        }
    }

    public a(Context context) {
        this.f51966h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f51966h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1205a c1205a = new C1205a(this);
        this.f51965g = c1205a;
        c1205a.f51967a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f51965g.f51968b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f51965g);
        return inflate;
    }

    public final void b(C1205a c1205a, d dVar, View view, int i2) {
        if (c1205a == null || dVar == null) {
            return;
        }
        c1205a.f51968b.setText("");
        if (i2 == 0) {
            TextView textView = c1205a.f51968b;
            textView.setText(this.f51966h.getString(R.string.all) + dVar.f52018b);
        } else {
            c1205a.f51968b.setText(dVar.f52018b);
        }
        if (i2 != this.f51964f) {
            c1205a.f51967a.setVisibility(4);
            SkinManager.setViewTextColor(c1205a.f51968b, R.color.common_color_10200, 1);
            return;
        }
        c1205a.f51967a.setVisibility(0);
        SkinManager.setViewTextColor(c1205a.f51968b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f51963e;
    }

    public void d(int i2) {
        this.f51964f = i2;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f51963e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f51963e;
        if (dVar == null || (arrayList = dVar.f52021e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d> arrayList;
        d dVar = this.f51963e;
        if (dVar == null || (arrayList = dVar.f52021e) == null) {
            return null;
        }
        return arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
        }
        d dVar = this.f51963e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f52021e.get(i2);
        C1205a c1205a = (C1205a) view.getTag();
        this.f51965g = c1205a;
        if (dVar2 != null) {
            b(c1205a, dVar2, view, i2);
        }
        return view;
    }
}
