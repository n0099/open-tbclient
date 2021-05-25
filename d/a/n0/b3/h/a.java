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
    public d f52130e;

    /* renamed from: f  reason: collision with root package name */
    public int f52131f = 0;

    /* renamed from: g  reason: collision with root package name */
    public C1222a f52132g;

    /* renamed from: h  reason: collision with root package name */
    public Context f52133h;

    /* renamed from: d.a.n0.b3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1222a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f52134a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52135b;

        public C1222a(a aVar) {
        }
    }

    public a(Context context) {
        this.f52133h = context;
    }

    public final View a() {
        View inflate = LayoutInflater.from(this.f52133h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        C1222a c1222a = new C1222a(this);
        this.f52132g = c1222a;
        c1222a.f52134a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f52132g.f52135b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f52132g);
        return inflate;
    }

    public final void b(C1222a c1222a, d dVar, View view, int i2) {
        if (c1222a == null || dVar == null) {
            return;
        }
        c1222a.f52135b.setText("");
        if (i2 == 0) {
            TextView textView = c1222a.f52135b;
            textView.setText(this.f52133h.getString(R.string.all) + dVar.f52185b);
        } else {
            c1222a.f52135b.setText(dVar.f52185b);
        }
        if (i2 != this.f52131f) {
            c1222a.f52134a.setVisibility(4);
            SkinManager.setViewTextColor(c1222a.f52135b, R.color.common_color_10200, 1);
            return;
        }
        c1222a.f52134a.setVisibility(0);
        SkinManager.setViewTextColor(c1222a.f52135b, R.color.common_color_10013, 1);
    }

    public d c() {
        return this.f52130e;
    }

    public void d(int i2) {
        this.f52131f = i2;
        notifyDataSetChanged();
    }

    public void e(d dVar) {
        this.f52130e = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList;
        d dVar = this.f52130e;
        if (dVar == null || (arrayList = dVar.f52188e) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<d> arrayList;
        d dVar = this.f52130e;
        if (dVar == null || (arrayList = dVar.f52188e) == null) {
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
        d dVar = this.f52130e;
        if (dVar == null) {
            return view;
        }
        d dVar2 = dVar.f52188e.get(i2);
        C1222a c1222a = (C1222a) view.getTag();
        this.f52132g = c1222a;
        if (dVar2 != null) {
            b(c1222a, dVar2, view, i2);
        }
        return view;
    }
}
