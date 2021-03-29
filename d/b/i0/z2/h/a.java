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
    public d f63491e;

    /* renamed from: f  reason: collision with root package name */
    public int f63492f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1719a f63493g;

    /* renamed from: h  reason: collision with root package name */
    public Context f63494h;

    /* renamed from: d.b.i0.z2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1719a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f63495a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63496b;

        public C1719a(a aVar) {
        }
    }

    public a(Context context) {
        this.f63494h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f63494h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1719a c1719a = new C1719a(this);
        this.f63493g = c1719a;
        c1719a.f63495a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f63493g.f63496b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f63493g);
        return inflate;
    }

    public final void b(C1719a c1719a, d dVar, View view, int i) {
        if (c1719a == null || dVar == null) {
            return;
        }
        c1719a.f63496b.setText("");
        if (i == 0) {
            TextView textView = c1719a.f63496b;
            textView.setText(this.f63494h.getString(R.string.all) + dVar.f63543b);
        } else {
            c1719a.f63496b.setText(dVar.f63543b);
        }
        if (i != this.f63492f) {
            c1719a.f63495a.setVisibility(4);
            SkinManager.setViewTextColor(c1719a.f63496b, R.color.common_color_10200, 1);
            return;
        }
        c1719a.f63495a.setVisibility(0);
        SkinManager.setViewTextColor(c1719a.f63496b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f63491e;
    }

    public void d(int i) {
        this.f63492f = i;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f63491e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f63491e;
        if (dVar == null || (arrayList = dVar.f63546e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<d> arrayList;
        d dVar = this.f63491e;
        if (dVar == null || (arrayList = dVar.f63546e) == null) {
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
        d dVar = this.f63491e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f63546e.get(i);
        C1719a c1719a = (C1719a) view.getTag();
        this.f63493g = c1719a;
        if (dVar2 != null) {
            b(c1719a, dVar2, view, i);
        }
        return view;
    }
}
