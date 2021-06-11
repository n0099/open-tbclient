package d.a.n0.b3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.b3.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f55819e;

    /* renamed from: f  reason: collision with root package name */
    public int f55820f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1278a f55821g;

    /* renamed from: h  reason: collision with root package name */
    public Context f55822h;

    /* renamed from: d.a.n0.b3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1278a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f55823a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55824b;

        public C1278a(a aVar) {
        }
    }

    public a(Context context) {
        this.f55822h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f55822h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1278a c1278a = new C1278a(this);
        this.f55821g = c1278a;
        c1278a.f55823a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f55821g.f55824b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f55821g);
        return inflate;
    }

    public final void b(C1278a c1278a, d dVar, View view, int i2) {
        if (c1278a == null || dVar == null) {
            return;
        }
        c1278a.f55824b.setText("");
        if (i2 == 0) {
            TextView textView = c1278a.f55824b;
            textView.setText(this.f55822h.getString(R.string.all) + dVar.f55874b);
        } else {
            c1278a.f55824b.setText(dVar.f55874b);
        }
        if (i2 != this.f55820f) {
            c1278a.f55823a.setVisibility(4);
            SkinManager.setViewTextColor(c1278a.f55824b, R.color.common_color_10200, 1);
            return;
        }
        c1278a.f55823a.setVisibility(0);
        SkinManager.setViewTextColor(c1278a.f55824b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f55819e;
    }

    public void d(int i2) {
        this.f55820f = i2;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f55819e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f55819e;
        if (dVar == null || (arrayList = dVar.f55877e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d> arrayList;
        d dVar = this.f55819e;
        if (dVar == null || (arrayList = dVar.f55877e) == null) {
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
        d dVar = this.f55819e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f55877e.get(i2);
        C1278a c1278a = (C1278a) view.getTag();
        this.f55821g = c1278a;
        if (dVar2 != null) {
            b(c1278a, dVar2, view, i2);
        }
        return view;
    }
}
