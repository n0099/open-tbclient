package d.b.i0.z2.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.z2.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f63490e;

    /* renamed from: f  reason: collision with root package name */
    public int f63491f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1718a f63492g;

    /* renamed from: h  reason: collision with root package name */
    public Context f63493h;

    /* renamed from: d.b.i0.z2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1718a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f63494a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63495b;

        public C1718a(a aVar) {
        }
    }

    public a(Context context) {
        this.f63493h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f63493h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1718a c1718a = new C1718a(this);
        this.f63492g = c1718a;
        c1718a.f63494a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f63492g.f63495b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f63492g);
        return inflate;
    }

    public final void b(C1718a c1718a, d dVar, View view, int i) {
        if (c1718a == null || dVar == null) {
            return;
        }
        c1718a.f63495b.setText("");
        if (i == 0) {
            TextView textView = c1718a.f63495b;
            textView.setText(this.f63493h.getString(R.string.all) + dVar.f63542b);
        } else {
            c1718a.f63495b.setText(dVar.f63542b);
        }
        if (i != this.f63491f) {
            c1718a.f63494a.setVisibility(4);
            SkinManager.setViewTextColor(c1718a.f63495b, R.color.common_color_10200, 1);
            return;
        }
        c1718a.f63494a.setVisibility(0);
        SkinManager.setViewTextColor(c1718a.f63495b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f63490e;
    }

    public void d(int i) {
        this.f63491f = i;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f63490e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f63490e;
        if (dVar == null || (arrayList = dVar.f63545e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d> arrayList;
        d dVar = this.f63490e;
        if (dVar == null || (arrayList = dVar.f63545e) == null) {
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
        d dVar = this.f63490e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f63545e.get(i);
        C1718a c1718a = (C1718a) view.getTag();
        this.f63492g = c1718a;
        if (dVar2 != null) {
            b(c1718a, dVar2, view, i);
        }
        return view;
    }
}
