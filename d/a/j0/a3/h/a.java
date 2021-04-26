package d.a.j0.a3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.a3.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public d f51264e;

    /* renamed from: f  reason: collision with root package name */
    public int f51265f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1133a f51266g;

    /* renamed from: h  reason: collision with root package name */
    public Context f51267h;

    /* renamed from: d.a.j0.a3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1133a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f51268a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51269b;

        public C1133a(a aVar) {
        }
    }

    public a(Context context) {
        this.f51267h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f51267h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1133a c1133a = new C1133a(this);
        this.f51266g = c1133a;
        c1133a.f51268a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f51266g.f51269b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f51266g);
        return inflate;
    }

    public final void b(C1133a c1133a, d dVar, View view, int i2) {
        if (c1133a == null || dVar == null) {
            return;
        }
        c1133a.f51269b.setText("");
        if (i2 == 0) {
            TextView textView = c1133a.f51269b;
            textView.setText(this.f51267h.getString(R.string.all) + dVar.f51319b);
        } else {
            c1133a.f51269b.setText(dVar.f51319b);
        }
        if (i2 != this.f51265f) {
            c1133a.f51268a.setVisibility(4);
            SkinManager.setViewTextColor(c1133a.f51269b, R.color.common_color_10200, 1);
            return;
        }
        c1133a.f51268a.setVisibility(0);
        SkinManager.setViewTextColor(c1133a.f51269b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f51264e;
    }

    public void d(int i2) {
        this.f51265f = i2;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f51264e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f51264e;
        if (dVar == null || (arrayList = dVar.f51322e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d> arrayList;
        d dVar = this.f51264e;
        if (dVar == null || (arrayList = dVar.f51322e) == null) {
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
        d dVar = this.f51264e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f51322e.get(i2);
        C1133a c1133a = (C1133a) view.getTag();
        this.f51266g = c1133a;
        if (dVar2 != null) {
            b(c1133a, dVar2, view, i2);
        }
        return view;
    }
}
